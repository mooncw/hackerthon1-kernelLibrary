package kernel.hackerthon.library.domain;
import jakarta.persistence.*;
import lombok.*;


@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String userName;
    private String email;
    private String password;
    // business log//

    @Builder
    public User(String userName,String email,String password){
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}

