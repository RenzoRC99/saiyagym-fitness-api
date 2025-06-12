package backend.Users.Interface.Controllers;

import backend.Users.Application.UserCases.CreateUser.CreateUserCommand;
import backend.Users.Application.UserCases.CreateUser.CreateUserCommandHandler;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@Validated
public class UserCreatePostController {
    private final CreateUserCommandHandler handler;

    public UserCreatePostController(
            CreateUserCommandHandler handler
    ) {
        this.handler = handler;
    }

    @PostMapping()
    public ResponseEntity<?> create(@Valid @RequestBody CreateUserRequest request) {
        CreateUserCommand command = new CreateUserCommand(
                null,
                request.getName(),
                request.getEmail(),
                request.getPhone(),
                request.getAddress()
        );

        handler.invoke(command);
        return ResponseEntity.ok().build();
    }
}
