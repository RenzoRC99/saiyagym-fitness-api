package backend.Users.Infrastructure;

import backend.Users.Domain.User;
import backend.Users.Domain.UserRepository;
import backend.Users.Infrastructure.Entity.UserEntity;
import backend.Users.Infrastructure.Mapper.UserMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    private final UserMapper mapper;
    @PersistenceContext
    private EntityManager entityManager;

    public UserRepositoryImpl(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void save(User user) {
        UserEntity entity = mapper.toEntity(user);
        entityManager.merge(entity); // merge: crea o actualiza según corresponda
    }

    @Override
    public Optional<User> find(UUID id) {
        UserEntity entity = entityManager.find(UserEntity.class, id);
        return Optional.ofNullable(entity)
                .map(mapper::toDomain);
    }
}
