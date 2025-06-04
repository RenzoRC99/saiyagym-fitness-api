package backend.Users.Domain.ValueObjects;

import backend.shared.Domain.StringValueObject;

public final class UserEmail extends StringValueObject {
    public UserEmail(String stringValue) {
        super(stringValue);
    }
}
