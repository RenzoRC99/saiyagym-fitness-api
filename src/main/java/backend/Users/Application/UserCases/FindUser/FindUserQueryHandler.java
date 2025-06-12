package backend.Users.Application.UserCases.FindUser;

import backend.Users.Application.UserResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public final class FindUserQueryHandler {

    private final UserFinder userFinder;

    public FindUserQueryHandler(UserFinder userFinder) {
        this.userFinder = userFinder;
    }

    public Optional<UserResponse> invoke(FindUserQuery query) {
        return userFinder.invoke(query.id())
                .map(UserResponse::fromDomain);
    }
}
