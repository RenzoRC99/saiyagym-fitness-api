package backend.shared.Domain;

public abstract class BooleanValueObject {

    private boolean bool= false;

    public BooleanValueObject(boolean bool) {

        //TO DO verify if boll is null or other validation
        this.bool = bool;
    }

    public boolean value() {
        return this.bool;
    }
}
