package by.overone.clinic.service;

import by.overone.clinic.dto.UserData;

import java.util.List;

public interface UserService {

    List<UserData> getAllUsers();

    UserData getUserById(long id);

    UserData getUserByLogin(String login);

    UserData getUserByEmail(String email);
}
