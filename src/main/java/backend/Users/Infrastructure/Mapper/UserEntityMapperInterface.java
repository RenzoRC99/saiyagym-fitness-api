package backend.Users.Infrastructure.Mapper;

import backend.Users.Domain.User;
import backend.Users.Infrastructure.Entity.UserEntity;

public interface UserEntityMapperInterface {
    User toDomain(UserEntity entity);
    UserEntity toEntity(User domain);
}
