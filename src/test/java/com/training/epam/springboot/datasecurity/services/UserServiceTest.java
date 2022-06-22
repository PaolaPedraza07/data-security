package com.training.epam.springboot.datasecurity.services;

import com.training.epam.springboot.datasecurity.models.UserApp;
import com.training.epam.springboot.datasecurity.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks
    UserService userService;
    @Mock
    UserRepository userRepository;

    @Test
    public void createUserSuccessfullyTest(){
        UserApp usuario = new UserApp();
        usuario.setNombre("Pao");

        Mockito.when(
                userRepository.save(Mockito.any(UserApp.class))
        ).thenReturn(usuario);

        UserApp userResponse = userService.createUser(usuario);
        Assertions.assertTrue(userResponse.getNombre().equals(usuario.getNombre()));
    }
    @Test
    public void createUserFailTest(){
        UserApp usuario = new UserApp();
        usuario.setNombre("Pao");

        Mockito.when(
                userRepository.save(usuario)
        ).thenReturn(null);

        UserApp userResponse = userService.createUser(usuario);
        Assertions.assertNull(userResponse);
    }
    @Test
    public void readUserByIdSuccessfullyTest(){
        Long userID = 10L;

        UserApp usuario = new UserApp();
        usuario.setNombre("Pao");
        Optional<UserApp> usuarioOptional = Optional.of(usuario);

        Mockito.when(
                userRepository.findById(userID)
        ).thenReturn(usuarioOptional);

        UserApp response = userService.readUserById(userID);
        Assertions.assertNotNull(response);
        Assertions.assertTrue(response.getNombre().equals(usuario.getNombre()));
    }
    @Test
    public void readUserByIdFailTest(){
        Long userID = 10L;

        Mockito.when(
                userRepository.findById(userID)
        ).thenReturn(Optional.empty());

        UserApp response = userService.readUserById(userID);
        Assertions.assertNull(response);
    }
}
