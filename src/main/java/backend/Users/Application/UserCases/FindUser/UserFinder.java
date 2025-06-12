package backend.Users.Application.UserCases.FindUser;

import backend.Users.Application.UserCases.UserUseCase;
import backend.Users.Domain.User;
import backend.Users.Domain.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public final class UserFinder extends UserUseCase {

    public UserFinder(UserRepository userRepository) {
        super(userRepository);
    }

    public Optional<User> invoke(UUID id) {
        return userRepository.find(id);
    }
}
