package backend.Routines.Infrastructure.Mapper;

import backend.Routines.Domain.Routine;
import backend.Routines.Infrastructure.Entity.RoutineEntity;
import backend.Users.Infrastructure.Mapper.UserMapper;

final class RoutineMapperImpl implements RoutineEntityMapper{

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
        return null;
    }
}
