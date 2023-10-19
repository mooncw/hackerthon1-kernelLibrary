package kernel.hackerthon.library.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", columnDefinition = "varchar", length = 255)
    private String username;

    @Column(name = "email", columnDefinition = "varchar", length = 255)
    private String email;

    @Column(name = "password", columnDefinition = "varchar", length = 255)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Rental> rentals = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Book> books = new ArrayList<>();

    @Builder
    public User(Long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}

