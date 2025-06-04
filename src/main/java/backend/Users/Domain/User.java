package backend.Users.Domain;

import backend.shared.Domain.Ids.UserId;
import backend.Users.Domain.ValueObjects.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
            String address,
            String createdAt
    ) {
        if (createdAt == null || createdAt.isEmpty()) {
            createdAt = Instant.now().toString();
        }

        return new User(
                new UserId(UUID.fromString(id)),
                new UserName(name),
                new UserEmail(email),
                new UserPhone(phone),
                new UserAddress(address),
                new UserCreatedAt(createdAt)
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
