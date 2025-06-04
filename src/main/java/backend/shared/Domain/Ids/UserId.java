package backend.shared.Domain.Ids;

import backend.shared.Domain.UUIDValueObject;

import java.util.UUID;

public final class UserId extends UUIDValueObject {

    public UserId(UUID uuid) {
        super(uuid);
    }

}
