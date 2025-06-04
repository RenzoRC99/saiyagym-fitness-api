package backend.Users.Domain.ValueObjects;

import backend.shared.Domain.DateTimeValueObject;

import java.time.Instant;
import java.time.format.DateTimeParseException;

public final class UserCreatedAt extends DateTimeValueObject {
    public UserCreatedAt(String dateString) {
        super(parse(dateString));
    }

    public UserCreatedAt(Instant date) {
        super(date);
    }

    private static Instant parse(String dateString) {
        try {
            return Instant.parse(dateString); // espera formato ISO, ej: "2024-06-03T12:00:00Z"
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid createdAt value: " + dateString, e);
        }
    }
}
