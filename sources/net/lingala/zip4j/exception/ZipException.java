package net.lingala.zip4j.exception;

import java.io.IOException;

public class ZipException extends IOException {
    private static final long X = 1;
    private Type s;

    public enum Type {
        WRONG_PASSWORD,
        TASK_CANCELLED_EXCEPTION,
        CHECKSUM_MISMATCH,
        UNKNOWN_COMPRESSION_METHOD,
        FILE_NOT_FOUND,
        UNSUPPORTED_ENCRYPTION,
        UNKNOWN
    }

    public ZipException(Exception exc) {
        super(exc);
        this.s = Type.UNKNOWN;
    }

    public Type a() {
        return this.s;
    }

    public ZipException(String str) {
        super(str);
        this.s = Type.UNKNOWN;
    }

    public ZipException(String str, Exception exc) {
        super(str, exc);
        this.s = Type.UNKNOWN;
    }

    public ZipException(String str, Throwable th, Type type) {
        super(str, th);
        Type type2 = Type.UNKNOWN;
        this.s = type;
    }

    public ZipException(String str, Type type) {
        super(str);
        Type type2 = Type.UNKNOWN;
        this.s = type;
    }
}
