package User.System.system.services.interfaces;

import User.System.system.models.User;
import org.springframework.stereotype.Service;

public interface UserService {

    void registerUser(User user);
}
