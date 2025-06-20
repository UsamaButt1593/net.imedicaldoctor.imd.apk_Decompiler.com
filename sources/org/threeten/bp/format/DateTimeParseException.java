package org.threeten.bp.format;

import org.threeten.bp.DateTimeException;

public class DateTimeParseException extends DateTimeException {
    private static final long Z = 4304633501674722597L;
    private final String X;
    private final int Y;

    public DateTimeParseException(String str, CharSequence charSequence, int i2) {
        super(str);
        this.X = charSequence.toString();
        this.Y = i2;
    }

    public int a() {
        return this.Y;
    }

    public String b() {
        return this.X;
    }

    public DateTimeParseException(String str, CharSequence charSequence, int i2, Throwable th) {
        super(str, th);
        this.X = charSequence.toString();
        this.Y = i2;
    }
}
