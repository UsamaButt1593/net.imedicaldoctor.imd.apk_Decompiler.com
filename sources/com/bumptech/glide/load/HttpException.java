package com.bumptech.glide.load;

import androidx.annotation.Nullable;
import java.io.IOException;

public final class HttpException extends IOException {
    private static final long X = 1;
    public static final int Y = -1;
    private final int s;

    public HttpException(int i2) {
        this("Http request failed with status code: " + i2, i2);
    }

    public int a() {
        return this.s;
    }

    public HttpException(String str) {
        this(str, -1);
    }

    public HttpException(String str, int i2) {
        this(str, i2, (Throwable) null);
    }

    public HttpException(String str, int i2, @Nullable Throwable th) {
        super(str, th);
        this.s = i2;
    }
}
