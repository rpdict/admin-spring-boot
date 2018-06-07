package sys.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@ToString(exclude = "password")
@Entity // This tells Hibernate to make a table out of this class
@NoArgsConstructor
public class User implements Serializable {

    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    private @Id @GeneratedValue Long id;

    private String name;

    private String email;

    private String remember_token;

    private Date created_at;

    private Date updated_at;

    private String password;

    private String[] roles;

    private void setPasswordEncoder(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    public User(String name, String password, String... roles) {
        this.name = name;
        this.setPasswordEncoder(password);
        this.roles = roles;
    }
}