package User.System.system.models;

import User.System.system.annotations.Password;
import User.System.system.constants.TextConstants;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity(name = "user")
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "user_username_unique",
                        columnNames = "username"
                )
        }
)
public class User {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "user_id",
            nullable = false
    )
    private long id;


    @Column(
            name = "username",
            nullable = false
    )
    @Size(min = 4, max = 30, message = TextConstants.USERNAME_INCORRECT_LENGTH)
    private String username;

    @Column(nullable = false)
    @Password(
            minLength = 6,
            maxLength = 50,
            containsDigit = true,
            containsLowerCase = true,
            containsUpperCase = true,
            containsSpecialSymbol = true)
    private String password;

    private String email;

    @Lob
    @Size(max = 1024 * 1024)
    private byte[] profilePicture;
}
