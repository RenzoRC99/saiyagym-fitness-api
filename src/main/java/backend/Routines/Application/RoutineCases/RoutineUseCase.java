package backend.Routines.Application.RoutineCases;

import backend.Routines.Domain.RoutineRepository;

public abstract class RoutineUseCase {
    protected RoutineRepository routineRepository;

    public RoutineUseCase(RoutineRepository routineRepository) {
        this.routineRepository = routineRepository;
    }
}
