package com.bumptech.glide.util;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ContentLengthInputStream extends FilterInputStream {
    private static final String Y = "ContentLengthStream";
    private static final int Z = -1;
    private int X;
    private final long s;

    private ContentLengthInputStream(@NonNull InputStream inputStream, long j2) {
        super(inputStream);
        this.s = j2;
    }

    private int b(int i2) throws IOException {
        if (i2 >= 0) {
            this.X += i2;
        } else if (this.s - ((long) this.X) > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.s + ", but read: " + this.X);
        }
        return i2;
    }

    @NonNull
    public static InputStream c(@NonNull InputStream inputStream, long j2) {
        return new ContentLengthInputStream(inputStream, j2);
    }

    @NonNull
    public static InputStream d(@NonNull InputStream inputStream, @Nullable String str) {
        return c(inputStream, (long) e(str));
    }

    private static int e(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e2) {
                if (Log.isLoggable(Y, 3)) {
                    Log.d(Y, "failed to parse content length header: " + str, e2);
                }
            }
        }
        return -1;
    }

    public synchronized int available() throws IOException {
        return (int) Math.max(this.s - ((long) this.X), (long) this.in.available());
    }

    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        b(read >= 0 ? 1 : -1);
        return read;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public synchronized int read(byte[] bArr, int i2, int i3) throws IOException {
        return b(super.read(bArr, i2, i3));
    }
}
