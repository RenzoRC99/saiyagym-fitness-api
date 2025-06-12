package backend.Routines.Application.RoutineCases.CreateRoutine;

public record CreateRoutineCommand(
        String id,
        String userId,
        String name,
        boolean status,
        String description
) {
}
