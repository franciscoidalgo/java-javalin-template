package com.frappu;

import com.frappu.config.ExceptionHandler;
import com.frappu.config.ScopesEnum;
import com.frappu.config.injection.module.ConfigurationModule;
import com.frappu.config.injection.module.JsonMapperModule;
import com.frappu.config.injection.module.RepositoryModule;
import com.frappu.config.injection.module.SessionFactoryModule;
import com.frappu.controller.PingController;
import com.frappu.controller.UserController;
import com.frappu.exception.ApiException;
import com.frappu.util.ScopeUtils;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.javalin.Javalin;
import io.javalin.json.JsonMapper;
import lombok.extern.slf4j.Slf4j;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;

@Slf4j
public class WebServer {

    private final Injector injector = Guice.createInjector(
            new ConfigurationModule(),
            new JsonMapperModule(),
            new RepositoryModule(),
            new SessionFactoryModule()
    );

    private final Javalin app = Javalin.create(config ->
            config.jsonMapper(injector.getInstance(JsonMapper.class))
    );

    private final ScopesEnum scope = ScopeUtils.getScope();

    public void start() {
        log.info(String.format("Scope set to %s", scope));
        configureRoutes();
        configureExceptions();
        app.start(8080);
    }

    private void configureRoutes() {
        var pingController = injector.getInstance(PingController.class);
        var userController = injector.getInstance(UserController.class);

        app.routes(() -> {
            path("/ping", () -> {
                get(pingController::ping);
            });

            path("/api", () -> {
                path("/users", () -> {
                    get("/{user_id}", userController::getUser);
                    post(userController::createUser);
                });
            });
        });
    }

    private void configureExceptions() {
        ExceptionHandler exceptionHandler = new ExceptionHandler();
        app.exception(ApiException.class, exceptionHandler::handleApiException);
    }
}
