package backend.Users.Application;

import backend.Users.Domain.User;

public record UserResponse(
        String id,
        String name,
        String email,
        String phone,
        String address,
        String createdAt
) {
    public static UserResponse fromDomain(User user) {
        return new UserResponse(
                user.id().value().toString(),
                user.name().value(),
                user.email().value(),
                user.phone().value(),
                user.address().value(),
                user.createdAt().valueString()
        );
    }
}
