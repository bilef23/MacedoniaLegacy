package mk.finki.ukim.diansproject.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String username;
    private String password;
    private String email;
    @Enumerated
    private Role role;

    public User( String name, String username, String password, String email, Role role) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role=role;
    }

    public User() {
    }
}
