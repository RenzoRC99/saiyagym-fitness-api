package backend.Users.Application.UserCases.CreateUser;

import org.springframework.stereotype.Service;

@Service
public final class CreateUserCommandHandler {

    private final CreateUserCreator creator;

    public CreateUserCommandHandler(CreateUserCreator creator) {
        this.creator = creator;
    }

    public void invoke(CreateUserCommand command) {
        creator.invoke(
                command.id(),
                command.name(),
                command.email(),
                command.phone(),
                command.address()
        );
    }
}
