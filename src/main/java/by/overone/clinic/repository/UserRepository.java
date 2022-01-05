package by.overone.clinic.repository;

import by.overone.clinic.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> getAllUsers();

    Optional<User> getUserById(long id);

    Optional<User> getUserByLogin(String login);

    Optional<User> getUserByEmail(String email);
}
