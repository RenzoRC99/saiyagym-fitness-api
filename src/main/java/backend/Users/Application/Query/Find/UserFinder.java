package backend.Users.Application.Query.Find;

import backend.Users.Domain.User;
import backend.Users.Domain.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class UserFinder {

    private final UserRepository userRepository;

    public UserFinder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> invoke(UUID id) {
        return userRepository.find(id);
    }
}
