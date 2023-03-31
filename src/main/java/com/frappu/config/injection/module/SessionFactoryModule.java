package com.frappu.config.injection.module;

import com.frappu.util.Configuration;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import jakarta.persistence.Entity;
import lombok.extern.slf4j.Slf4j;
import org.h2.server.web.WebServer;
import org.h2.tools.Server;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.reflections.Reflections;

import java.sql.SQLException;

@Slf4j
public class SessionFactoryModule extends AbstractModule {

    @Provides
    @Singleton
    @Inject
    public SessionFactory providesSessionFactory(Configuration configuration) throws SQLException {
        var server = new Server(new WebServer(), "-tcp", "-tcpPort", "8082");
        server.start();
        log.info(server.getStatus());

        var standardServerRegistry = new StandardServiceRegistryBuilder()
                .applySetting("hibernate.connection.url", configuration.getString("database.url"))
                .applySetting("hibernate.connection.username", "sa")
                .applySetting("hibernate.connection.password", "")
                .applySetting("hibernate.dialect", "org.hibernate.dialect.H2Dialect")
                .applySetting("hibernate.show_sql", "true")
                .applySetting("hibernate.format_sql", "true")
                .applySetting("hibernate.current_session_context_class", "thread")
                .applySetting("hibernate.hbm2ddl.auto", "create-drop")
                .build();

        var metadataSources = new MetadataSources(standardServerRegistry);

        var reflections = new Reflections("model");
        reflections.getTypesAnnotatedWith(Entity.class)
                .forEach(metadataSources::addAnnotatedClass);

        var metadata = metadataSources.buildMetadata();

        return metadata.buildSessionFactory();
    }

}
