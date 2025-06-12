package backend.Routines.Application.RoutineCases.FindRoutine;

import backend.Routines.Application.RoutineResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public final class FindRoutineQueryHandler {
    private final RoutineFinder routineFinder;

    public FindRoutineQueryHandler(RoutineFinder routineFinder) {
        this.routineFinder = routineFinder;
    }

    public Optional<RoutineResponse> invoke(FindRoutineQuery query) {
        return routineFinder.invoke(query.id())
                .map(RoutineResponse::fromDomain);
    }
}
