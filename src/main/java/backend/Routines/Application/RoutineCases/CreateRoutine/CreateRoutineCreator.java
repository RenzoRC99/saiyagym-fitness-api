package backend.Routines.Application.RoutineCases.CreateRoutine;

import backend.Routines.Application.RoutineCases.RoutineUseCase;
import backend.Routines.Domain.Routine;
import backend.Routines.Domain.RoutineRepository;
import backend.Users.Application.UserCases.FindUser.UserFinder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public final class CreateRoutineCreator extends RoutineUseCase {
    private final UserFinder userFinder;

    public CreateRoutineCreator(RoutineRepository routineRepository, UserFinder userFinder) {
        super(routineRepository);
        this.userFinder = userFinder;
    }

    public void invoke(
            String userId,
            String name,
            boolean status,
            String description
    ) {
        var user = userFinder.invoke(UUID.fromString(userId));

        if (user.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        var routine = Routine.create(
                null,
                user.get(),
                name,
                status,
                description
        );
        routineRepository.save(routine);
    }
}
