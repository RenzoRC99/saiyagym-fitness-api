package backend.shared.Domain;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public abstract class DateTimeValueObject {
    private final Instant date;

    public DateTimeValueObject(Instant date) {
        this.date = date;
    }

    public Instant value() {
        return this.date;
    }

    public String valueString() {
        // Formatear como ISO_ZONED_DATE_TIME con zona UTC para mantener formato legible
        return DateTimeFormatter.ISO_ZONED_DATE_TIME.withZone(ZoneOffset.UTC).format(this.date);
    }

    public String withFormat(String pattern) {
        return DateTimeFormatter.ofPattern(pattern)
                .withZone(ZoneOffset.UTC)
                .format(this.date);
    }

    @Override
    public String toString() {
        return valueString();
    }
}
