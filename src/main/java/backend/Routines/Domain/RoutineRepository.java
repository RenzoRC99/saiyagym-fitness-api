package backend.Routines.Domain;

import java.util.Optional;
import java.util.UUID;

public interface RoutineRepository {
    void save(Routine routine);

    Optional<Routine> find(UUID id);
}
