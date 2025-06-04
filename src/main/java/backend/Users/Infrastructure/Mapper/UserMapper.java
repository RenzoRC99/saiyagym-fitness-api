package backend.Users.Infrastructure.Mapper;

import backend.Users.Domain.User;
import backend.Users.Infrastructure.Entity.UserEntity;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public final class UserMapper implements UserEntityMapperInterface{

    @Override
    public User toDomain(UserEntity entity) {
        return User.create(
                entity.getId().toString(),
                entity.getName(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getAddress(),
                entity.getCreatedAt().toString()
        );
    }

    @Override
    public UserEntity toEntity(User domain) {
        UserEntity entity = new UserEntity();

        entity.setId(domain.id().value());
        entity.setName(domain.name().value());
        entity.setEmail(domain.email().value());
        entity.setPhone(domain.phone().value());
        entity.setAddress(domain.address().value());
        entity.setCreatedAt(Instant.parse(domain.createdAt().valueString()));

        return entity;
    }
}
