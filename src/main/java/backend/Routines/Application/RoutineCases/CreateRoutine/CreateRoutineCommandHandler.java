package backend.Routines.Application.RoutineCases.CreateRoutine;

import org.springframework.stereotype.Component;

@Component
public final class CreateRoutineCommandHandler {
    private final CreateRoutineCreator creator;

    public CreateRoutineCommandHandler(CreateRoutineCreator createRoutineCreator) {
        this.creator = createRoutineCreator;
    }

    public void invoke(CreateRoutineCommand command) {
        creator.invoke(
                command.userId(),
                command.name(),
                command.status(),
                command.description()
        );
    }
}
