package ru.itgirl.libraryproject.repository;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.itgirl.libraryproject.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Id> {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}
