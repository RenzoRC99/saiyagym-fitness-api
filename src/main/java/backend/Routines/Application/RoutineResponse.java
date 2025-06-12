package backend.Routines.Application;

import backend.Routines.Domain.Routine;

import java.util.HashMap;
import java.util.Map;

public record RoutineResponse(
        String id,
        String userId,
        String name,
        boolean status,
        String description,
        String createdAt
) {
    public static RoutineResponse fromDomain(Routine routine) {
        return new RoutineResponse(
                routine.id().value().toString(),
                routine.user().id().value().toString(),
                routine.name().value(),
                routine.status().value(),
                routine.description().value(),
                routine.createdAt().valueString()
        );
    }

    public Map<String, Object> values() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("userId", userId);
        map.put("name", name);
        map.put("status", status);
        map.put("description", description);
        map.put("createdAt", createdAt);
        return map;
    }
}
