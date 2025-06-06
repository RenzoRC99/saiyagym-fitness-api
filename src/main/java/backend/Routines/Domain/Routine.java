package backend.Routines.Domain;

import backend.Routines.Domain.ValueObjects.RoutineCreatedAt;
import backend.Routines.Domain.ValueObjects.RoutineDescription;
import backend.Routines.Domain.ValueObjects.RoutineName;
import backend.Routines.Domain.ValueObjects.RoutineStatus;
import backend.Users.Domain.User;
import backend.shared.Domain.Ids.RoutineId;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public record Routine(
        RoutineId id,
        User user,
        RoutineName name,
        RoutineStatus status,
        RoutineDescription description,
        RoutineCreatedAt createdAt
) {
    public static Routine create(
            String id,
            User user,
            String name,
            boolean status,
            String description
    ){
        return new Routine(
                new RoutineId(id == null ?UUID.randomUUID():UUID.fromString(id)),
                user,
                new RoutineName(name),
                new RoutineStatus(status),
                new RoutineDescription(description),
                new RoutineCreatedAt(Instant.now())
        );
    }

    public Map<String, Object> values() {
        Map<String, Object> values = new HashMap<>();
        values.put("id", id.value());
        values.put("user_id", user.id().value());
        values.put("name", name.value());
        values.put("status", status.value());
        values.put("description", description.value());
        values.put("created_at", createdAt.valueString());

        return values;
    }
}
