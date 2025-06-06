package backend.Routines.Domain.ValueObjects;

import backend.shared.Domain.DateTimeValueObject;

import java.time.Instant;

public final class RoutineCreatedAt extends DateTimeValueObject {
    public RoutineCreatedAt(Instant date) {
        super(date);
    }
}
