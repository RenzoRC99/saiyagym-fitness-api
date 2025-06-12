package backend.Users.Application.UserCases.CreateUser;

public record CreateUserCommand(
        String id,
        String name,
        String email,
        String phone,
        String address
) {
}
