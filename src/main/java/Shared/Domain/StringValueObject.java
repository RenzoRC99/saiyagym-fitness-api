package Shared.Domain;

public abstract class StringValueObject {

    private final String value;

    public StringValueObject(String stringValue) {
        this.value = stringValue;
    }

    public String value() {
        return this.value;
    }
}
