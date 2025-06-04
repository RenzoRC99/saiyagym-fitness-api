package backend.Users.Interface;

import backend.Users.Application.Query.Find.FindUserQuery;
import backend.Users.Application.Query.Find.FindUserQueryHandler;
import backend.Users.Application.Query.Find.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class FindUserController {

    private final FindUserQueryHandler handler;

    public FindUserController(FindUserQueryHandler handler) {
        this.handler = handler;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable String id) {
        var query = new FindUserQuery(UUID.fromString(id));
        return handler.invoke(query)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");
    }

}
