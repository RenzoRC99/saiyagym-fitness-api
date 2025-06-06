package backend.Routines.Infrastructure.Mapper;

import backend.Routines.Domain.Routine;
import backend.Routines.Infrastructure.Entity.RoutineEntity;

public interface RoutineEntityMapper {
    Routine toDomain(RoutineEntity entity);
    RoutineEntity toEntity(Routine domain);
}
