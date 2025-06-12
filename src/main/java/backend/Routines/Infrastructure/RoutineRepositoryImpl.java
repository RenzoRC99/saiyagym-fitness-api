package backend.Routines.Infrastructure;

import backend.Routines.Domain.Routine;
import backend.Routines.Domain.RoutineRepository;
import backend.Routines.Infrastructure.Entity.RoutineEntity;
import backend.Routines.Infrastructure.Mapper.RoutineEntityMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public class RoutineRepositoryImpl implements RoutineRepository {

    private final RoutineEntityMapper mapper;
    @PersistenceContext
    private EntityManager entityManager;

    public RoutineRepositoryImpl(RoutineEntityMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void save(Routine routine) {
        RoutineEntity entity = mapper.toEntity(routine);
        entityManager.merge(entity);
    }

    @Override
    public Optional<Routine> find(UUID id) {
        RoutineEntity entity = entityManager.find(RoutineEntity.class, id);
        return Optional.ofNullable(entity)
                .map(mapper::toDomain);
    }
}
