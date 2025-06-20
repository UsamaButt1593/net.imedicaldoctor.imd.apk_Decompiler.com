package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public class ExceptionCatchingInputStream extends InputStream {
    private static final Queue<ExceptionCatchingInputStream> Y = Util.f(0);
    private IOException X;
    private InputStream s;

    ExceptionCatchingInputStream() {
    }

    static void b() {
        while (true) {
            Queue<ExceptionCatchingInputStream> queue = Y;
            if (!queue.isEmpty()) {
                queue.remove();
            } else {
                return;
            }
        }
    }

    @NonNull
    public static ExceptionCatchingInputStream d(@NonNull InputStream inputStream) {
        ExceptionCatchingInputStream poll;
        Queue<ExceptionCatchingInputStream> queue = Y;
        synchronized (queue) {
            poll = queue.poll();
        }
        if (poll == null) {
            poll = new ExceptionCatchingInputStream();
        }
        poll.e(inputStream);
        return poll;
    }

    public void a() {
        this.X = null;
        this.s = null;
        Queue<ExceptionCatchingInputStream> queue = Y;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    public int available() throws IOException {
        return this.s.available();
    }

    @Nullable
    public IOException c() {
        return this.X;
    }

    public void close() throws IOException {
        this.s.close();
    }

    /* access modifiers changed from: package-private */
    public void e(@NonNull InputStream inputStream) {
        this.s = inputStream;
    }

    public void mark(int i2) {
        this.s.mark(i2);
    }

    public boolean markSupported() {
        return this.s.markSupported();
    }

    public int read() {
        try {
            return this.s.read();
        } catch (IOException e2) {
            this.X = e2;
            return -1;
        }
    }

    public synchronized void reset() throws IOException {
        this.s.reset();
    }

    public long skip(long j2) {
        try {
            return this.s.skip(j2);
        } catch (IOException e2) {
            this.X = e2;
            return 0;
        }
    }

    public int read(byte[] bArr) {
        try {
            return this.s.read(bArr);
        } catch (IOException e2) {
            this.X = e2;
            return -1;
        }
    }

    public int read(byte[] bArr, int i2, int i3) {
        try {
            return this.s.read(bArr, i2, i3);
        } catch (IOException e2) {
            this.X = e2;
            return -1;
        }
    }
}
