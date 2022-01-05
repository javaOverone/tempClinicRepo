package by.overone.clinic.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private long user_id;
    private String login;
    private String password;
    private String email;

    public User(String login, String password, String email){
        this.login=login;
        this.password=password;
        this.email=email;
    }
}
