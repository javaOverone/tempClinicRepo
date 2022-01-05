package by.overone.clinic.repository;

import by.overone.clinic.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository{

    private static final String GET_ALL_USERS_QUERY = "SELECT * FRO users;";
    private static final String GET_USER_BY_ID_QUERY = "SELECT * FROM users WHERE user_id=?;";
    private static final String GET_USER_BY_LOGIN_QUERY = "SELECT * FROM users WHERE login=?;";
    private static final String GET_USER_BY_EMAIL_QUERY = "SELECT * FROM users WHERE email=?;";
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.query(GET_ALL_USERS_QUERY, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public Optional<User> getUserById(long id) {
        return jdbcTemplate.query(GET_USER_BY_ID_QUERY, new Object[]{id}, new BeanPropertyRowMapper<>(User.class))
                .stream()
                .findAny();
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        return jdbcTemplate.query(GET_USER_BY_LOGIN_QUERY, new Object[]{login}, new BeanPropertyRowMapper<>(User.class))
                .stream()
                .findAny();
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return jdbcTemplate.query(GET_USER_BY_EMAIL_QUERY, new Object[]{email}, new BeanPropertyRowMapper<>(User.class))
                .stream()
                .findAny();
    }
}
