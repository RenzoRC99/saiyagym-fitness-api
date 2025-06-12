package backend.Routines.Domain.ValueObjects;

import Shared.Domain.DateTimeValueObject;

import java.time.Instant;

public final class RoutineCreatedAt extends DateTimeValueObject {
    public RoutineCreatedAt(Instant date) {
        super(date);
    }
}
