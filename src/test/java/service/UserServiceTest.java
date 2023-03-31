package service;

import com.frappu.dto.UserDto;
import com.frappu.model.User;
import com.frappu.repository.UserRepository;
import com.frappu.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import test.util.MockedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


class UserServiceTest extends MockedTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    private final Long DEFAULT_USER_ID = 1L;

    @Test
    void getUserById_whenUserExistsForGivenId_returnUser() {
        Mockito.when(userRepository.findById(DEFAULT_USER_ID)).thenReturn(defaultUser());

        UserDto result = userService.getUserById(DEFAULT_USER_ID);

        assertEquals(DEFAULT_USER_ID, result.getId());
        Mockito.verify(userRepository).findById(DEFAULT_USER_ID);
    }

    private User defaultUser() {
        return User.builder()
                .id(DEFAULT_USER_ID)
                .build();
    }

}
