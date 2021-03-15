package User.System.system.runner;

import User.System.system.models.User;
import User.System.system.services.interfaces.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class Runner {

    @Bean
    CommandLineRunner commandLineRunner(UserService userService) {
        return args -> {
            User dimitar = new User(
                    "dimitar",
                    "dimitar1234",
                    "dimitar.i.ivanov@abv.bg",
                    new byte[]{1, 2, 3, 4},
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    22,
                    false
            );

            userService.registerUser(dimitar);
        };
    }
}
