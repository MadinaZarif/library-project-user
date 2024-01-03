package ru.itgirl.libraryproject.service;

import ru.itgirl.libraryproject.dto.UserDto;
import ru.itgirl.libraryproject.model.User;

import java.util.Set;

public interface UserService {

    UserDto getByUserName(String username);

    UserDto getByEmail(String email);
    UserDto createUser(UserDto userDto);

    Set<UserDto> getAllusers();

}
