package ru.itgirl.libraryproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itgirl.libraryproject.dto.UserDto;
import ru.itgirl.libraryproject.model.User;
import ru.itgirl.libraryproject.repository.UserRepository;

import java.util.Set;

@Service
@RequiredArgsConstructor

public class UserServiceIml implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto getByUserName(String username) {
        User user = (User) userRepository.findByUsername(username).orElseThrow();
        UserDto userDto = convertEntityToDto(user);
        return userDto;    }

    @Override
    public UserDto getByEmail(String email) {
        return null;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        return null;
    }

    @Override
    public Set<UserDto> getAllusers() {
        return null;
    }

    private UserDto convertEntityToDto(User user) {
        return UserDto.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    private User convertDtoToEntyte(UserDto userDto) {
        return User.builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail()).build();
    }
}
