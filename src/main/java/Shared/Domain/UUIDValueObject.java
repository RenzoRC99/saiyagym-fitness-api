package Shared.Domain;

import java.util.UUID;

public abstract class UUIDValueObject {

    private final UUID uuid;

    public UUIDValueObject(UUID uuid) {
        if (uuid == null) {
            throw new IllegalArgumentException("UUID no puede ser null");
        }
        this.uuid = uuid;
    }

    public static UUID fromStringOrGenerate(String value) {
        return (value == null || value.isEmpty())
                ? UUID.randomUUID()
                : UUID.fromString(value);
    }

    public UUID value() {
        return this.uuid;
    }
}
