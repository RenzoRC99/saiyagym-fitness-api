package backend.Users.Domain;

import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository {
    void save(User user);
    Optional<User> find(UUID id);
}
