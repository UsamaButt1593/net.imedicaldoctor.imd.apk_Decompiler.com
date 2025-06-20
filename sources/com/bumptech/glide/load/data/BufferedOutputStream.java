package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.OutputStream;

public final class BufferedOutputStream extends OutputStream {
    private byte[] X;
    private ArrayPool Y;
    private int Z;
    @NonNull
    private final OutputStream s;

    public BufferedOutputStream(@NonNull OutputStream outputStream, @NonNull ArrayPool arrayPool) {
        this(outputStream, arrayPool, 65536);
    }

    private void a() {
        byte[] bArr = this.X;
        if (bArr != null) {
            this.Y.put(bArr);
            this.X = null;
        }
    }

    private void b() throws IOException {
        int i2 = this.Z;
        if (i2 > 0) {
            this.s.write(this.X, 0, i2);
            this.Z = 0;
        }
    }

    private void c() throws IOException {
        if (this.Z == this.X.length) {
            b();
        }
    }

    /* JADX INFO: finally extract failed */
    public void close() throws IOException {
        try {
            flush();
            this.s.close();
            a();
        } catch (Throwable th) {
            this.s.close();
            throw th;
        }
    }

    public void flush() throws IOException {
        b();
        this.s.flush();
    }

    public void write(int i2) throws IOException {
        byte[] bArr = this.X;
        int i3 = this.Z;
        this.Z = i3 + 1;
        bArr[i3] = (byte) i2;
        c();
    }

    @VisibleForTesting
    BufferedOutputStream(@NonNull OutputStream outputStream, ArrayPool arrayPool, int i2) {
        this.s = outputStream;
        this.Y = arrayPool;
        this.X = (byte[]) arrayPool.f(i2, byte[].class);
    }

    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(@NonNull byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        do {
            int i5 = i3 - i4;
            int i6 = i2 + i4;
            int i7 = this.Z;
            if (i7 != 0 || i5 < this.X.length) {
                int min = Math.min(i5, this.X.length - i7);
                System.arraycopy(bArr, i6, this.X, this.Z, min);
                this.Z += min;
                i4 += min;
                c();
            } else {
                this.s.write(bArr, i6, i5);
                return;
            }
        } while (i4 < i3);
    }
}
