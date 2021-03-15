package User.System.system.runner;

import User.System.system.models.Country;
import User.System.system.models.Town;
import User.System.system.models.User;
import User.System.system.services.interfaces.CountryService;
import User.System.system.services.interfaces.TownService;
import User.System.system.services.interfaces.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.time.LocalDateTime;

@Configuration
public class Runner {

    @Bean
    CommandLineRunner commandLineRunner(UserService userService, TownService townService, CountryService countryService) {
        return args -> {
            User dimitar = new User(
                    "d1mn",
                    "Dimitar$1234",
                    "dimitar.i.ivanov@abv.bg",
                    new byte[]{1, 2, 3, 4},
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    22,
                    false,
                    "Dimitar",
                    "Ivanov"
            );

            Country bulgaria = new Country("Bulgaria");

            Town haskovo = new Town(
                    "Haskovo",
                    bulgaria
            );

            Town sofia = new Town(
                    "Sofia",
                    bulgaria
            );

            dimitar.setBornTown(haskovo);
            dimitar.setLivingTown(sofia);

            countryService.registerCountry(bulgaria);
            townService.registerTowns(List.of(haskovo, sofia));
            userService.registerUser(dimitar);
        };
    }
}
