package org.threeten.bp;

public class DateTimeException extends RuntimeException {
    private static final long s = -1632418723876261839L;

    public DateTimeException(String str) {
        super(str);
    }

    public DateTimeException(String str, Throwable th) {
        super(str, th);
    }
}
