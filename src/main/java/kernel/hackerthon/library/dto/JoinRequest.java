package kernel.hackerthon.library.dto;

import kernel.hackerthon.library.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JoinRequest {
    private String username;
    private String password;
    private String email;

    public User toEntity() {
        return User.builder()
                .username(username).password(password).email(email)
                .build();
    }
}
