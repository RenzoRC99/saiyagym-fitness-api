package Shared.Domain;

public abstract class BooleanValueObject {

    private final boolean bool;

    public BooleanValueObject(boolean bool) {

        //TO DO verify if boll is null or other validation
        this.bool = bool;
    }

    public boolean value() {
        return this.bool;
    }
}
