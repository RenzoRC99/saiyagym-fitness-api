package backend.Routines.Infrastructure.Mapper;

import backend.Routines.Domain.Routine;
import backend.Routines.Infrastructure.Entity.RoutineEntity;
import backend.Users.Infrastructure.Mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
final class RoutineMapperImpl implements RoutineEntityMapper {

    private final UserMapper userMapper;

    public RoutineMapperImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Routine toDomain(RoutineEntity entity) {
        var user = userMapper.toDomain(entity.getUser());

        return Routine.create(
                entity.getId().toString(),
                user,
                entity.getName(),
                entity.isStatus(),
                entity.getDescription()
        );
    }

    @Override
    public RoutineEntity toEntity(Routine domain) {
        RoutineEntity entity = new RoutineEntity();

        entity.setId(domain.id().value());
        entity.setName(domain.name().value());
        entity.setStatus(domain.status().value());
        entity.setDescription(domain.description().value());
        entity.setCreatedAt(domain.createdAt().value());
        entity.setUser(userMapper.toEntity(domain.user()));

        return entity;
    }
}
