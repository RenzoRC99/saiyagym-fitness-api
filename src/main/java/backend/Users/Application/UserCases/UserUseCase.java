package backend.Users.Application.UserCases;

import backend.Users.Domain.UserRepository;

public abstract class UserUseCase {

    protected UserRepository userRepository;

    public UserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
