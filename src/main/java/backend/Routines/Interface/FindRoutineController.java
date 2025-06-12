package backend.Routines.Interface;

import backend.Routines.Application.RoutineCases.FindRoutine.FindRoutineQuery;
import backend.Routines.Application.RoutineCases.FindRoutine.FindRoutineQueryHandler;
import backend.Routines.Application.RoutineResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/routines")
public class FindRoutineController {
    private final FindRoutineQueryHandler handler;

    public FindRoutineController(FindRoutineQueryHandler handler) {
        this.handler = handler;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoutineResponse> findById(@PathVariable String id) {
        var query = new FindRoutineQuery(UUID.fromString(id));
        return handler.invoke(query)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
