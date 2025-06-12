package backend.Routines.Interface.Controllers;

import backend.Routines.Application.RoutineCases.CreateRoutine.CreateRoutineCommand;
import backend.Routines.Application.RoutineCases.CreateRoutine.CreateRoutineCommandHandler;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/routines")
@Validated
public class RoutineCreatePostController {
    private final CreateRoutineCommandHandler handler;

    public RoutineCreatePostController(CreateRoutineCommandHandler createRoutineCommandHandler) {
        this.handler = createRoutineCommandHandler;
    }

    @PostMapping()
    public ResponseEntity<?> create(@Valid @RequestBody CreateRoutineRequest request) {
        CreateRoutineCommand command = new CreateRoutineCommand(
                null,
                request.getUserId(),
                request.getName(),
                request.isStatus(),
                request.getDescription()
        );

        handler.invoke(command);
        return ResponseEntity.ok().build();
    }
}
