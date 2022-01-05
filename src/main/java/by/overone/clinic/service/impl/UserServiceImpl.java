package by.overone.clinic.service.impl;

import by.overone.clinic.dto.UserData;
import by.overone.clinic.exception.EntityNotFoundException;
import by.overone.clinic.exception.ExceptionCode;
import by.overone.clinic.model.User;
import by.overone.clinic.repository.UserRepository;
import by.overone.clinic.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<UserData> getAllUsers() {
        List<User> users = userRepository.getAllUsers();
        return users.stream().map(u -> modelMapper.map(u, UserData.class)).collect(Collectors.toList());
    }

    @Override
    public UserData getUserById(long id) {
        log.info("Get user by id " +id+ " service method started");
        User user = userRepository.getUserById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionCode.NOT_EXISTING_USER.getErrorCode()));

        return modelMapper.map(user, UserData.class);
    }

    @Override
    public UserData getUserByLogin(String login) {
        return null;
    }

    @Override
    public UserData getUserByEmail(String email) {
        return null;
    }
}
