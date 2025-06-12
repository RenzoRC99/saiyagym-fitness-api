package backend.Users.Domain;

import Shared.Domain.Ids.UserId;
import backend.Users.Domain.ValueObjects.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public record User(
        UserId id,
        UserName name,
        UserEmail email,
        UserPhone phone,
        UserAddress address,
        UserCreatedAt createdAt
) {

    public static User create(
            String id,
            String name,
            String email,
            String phone,
            String address
    ) {
        return new User(
                new UserId(UserId.fromStringOrGenerate(id)),
                new UserName(name),
                new UserEmail(email),
                new UserPhone(phone),
                new UserAddress(address),
                new UserCreatedAt(Instant.now().toString())
        );
    }

    public Map<String, Object> values() {
        Map<String, Object> values = new HashMap<>();
        values.put("id", id.value());
        values.put("name", name.value());
        values.put("email", email.value());
        values.put("phone", phone.value());
        values.put("address", address.value());
        values.put("created_at", createdAt.valueString());
        return values;
    }
}
