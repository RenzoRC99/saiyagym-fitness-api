package backend.Routines.Application.RoutineCases.FindRoutine;

import backend.Routines.Application.RoutineCases.RoutineUseCase;
import backend.Routines.Domain.Routine;
import backend.Routines.Domain.RoutineRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class RoutineFinder extends RoutineUseCase {

    public RoutineFinder(RoutineRepository routineRepository) {
        super(routineRepository);
    }

    public Optional<Routine> invoke(UUID id) {
        return routineRepository.find(id);
    }
}
