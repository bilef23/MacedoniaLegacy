package mk.finki.ukim.diansproject.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Data
@Entity
@Table(name="users")
public class User implements UserDetails {

    private String name;
    @Id
    private String username;
    private String password;
    private String email;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    private boolean isAccountNonExpired = true;
    private boolean isAccountNonLocked = true;
    private boolean isCredentialsNonExpired =  true;
    private boolean isEnabled = true;


    public User( String name, String username, String password, String email, Role role) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role=role;
    }

    public User() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(role);
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
