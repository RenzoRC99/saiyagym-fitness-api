package backend.Users.Application.UserCases.CreateUser;

import backend.Users.Application.UserCases.UserUseCase;
import backend.Users.Domain.User;
import backend.Users.Domain.UserRepository;
import org.springframework.stereotype.Component;

@Component
public final class CreateUserCreator extends UserUseCase {

    public CreateUserCreator(UserRepository userRepository) {
        super(userRepository);
    }

    public void invoke(
            String id,
            String name,
            String email,
            String phone,
            String address
    ) {
        //TODO crear el criteria para hacer las consultas
        //TODO antes de que hagas el create debes invocar al create criteria para validar los campos unicos
        var user = User.create(
                id,
                name,
                email,
                phone,
                address
        );

        userRepository.save(user);
    }
}
