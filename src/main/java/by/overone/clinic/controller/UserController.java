package by.overone.clinic.controller;

import by.overone.clinic.dto.UserData;
import by.overone.clinic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;


    @GetMapping
    public List<UserData> getAllUsers() {

        return userService.getAllUsers();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/{id}")
    public UserData getUserById(@PathVariable long id) {

        return userService.getUserById(id);
    }
}
