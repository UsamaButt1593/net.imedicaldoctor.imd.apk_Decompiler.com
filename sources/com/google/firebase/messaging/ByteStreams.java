package com.google.firebase.messaging;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

final class ByteStreams {

    /* renamed from: a  reason: collision with root package name */
    private static final int f24655a = 8192;

    /* renamed from: b  reason: collision with root package name */
    private static final int f24656b = 2147483639;

    /* renamed from: c  reason: collision with root package name */
    private static final int f24657c = 20;

    private static final class LimitedInputStream extends FilterInputStream {
        private long X = -1;
        private long s;

        LimitedInputStream(InputStream inputStream, long j2) {
            super(inputStream);
            this.s = j2;
        }

        public int available() throws IOException {
            return (int) Math.min((long) this.in.available(), this.s);
        }

        public synchronized void mark(int i2) {
            this.in.mark(i2);
            this.X = this.s;
        }

        public int read() throws IOException {
            if (this.s == 0) {
                return -1;
            }
            int read = this.in.read();
            if (read != -1) {
                this.s--;
            }
            return read;
        }

        public synchronized void reset() throws IOException {
            if (!this.in.markSupported()) {
                throw new IOException("Mark not supported");
            } else if (this.X != -1) {
                this.in.reset();
                this.s = this.X;
            } else {
                throw new IOException("Mark not set");
            }
        }

        public long skip(long j2) throws IOException {
            long skip = this.in.skip(Math.min(j2, this.s));
            this.s -= skip;
            return skip;
        }

        public int read(byte[] bArr, int i2, int i3) throws IOException {
            long j2 = this.s;
            if (j2 == 0) {
                return -1;
            }
            int read = this.in.read(bArr, i2, (int) Math.min((long) i3, j2));
            if (read != -1) {
                this.s -= (long) read;
            }
            return read;
        }
    }

    private ByteStreams() {
    }

    private static byte[] a(Queue<byte[]> queue, int i2) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] remove = queue.remove();
        if (remove.length == i2) {
            return remove;
        }
        int length = i2 - remove.length;
        byte[] copyOf = Arrays.copyOf(remove, i2);
        while (length > 0) {
            byte[] remove2 = queue.remove();
            int min = Math.min(length, remove2.length);
            System.arraycopy(remove2, 0, copyOf, i2 - length, min);
            length -= min;
        }
        return copyOf;
    }

    static byte[] b() {
        return new byte[8192];
    }

    public static InputStream c(InputStream inputStream, long j2) {
        return new LimitedInputStream(inputStream, j2);
    }

    private static int d(long j2) {
        if (j2 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j2 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j2;
    }

    public static byte[] e(InputStream inputStream) throws IOException {
        return f(inputStream, new ArrayDeque(20), 0);
    }

    private static byte[] f(InputStream inputStream, Queue<byte[]> queue, int i2) throws IOException {
        int min = Math.min(8192, Math.max(128, Integer.highestOneBit(i2) * 2));
        while (i2 < f24656b) {
            int min2 = Math.min(min, f24656b - i2);
            byte[] bArr = new byte[min2];
            queue.add(bArr);
            int i3 = 0;
            while (i3 < min2) {
                int read = inputStream.read(bArr, i3, min2 - i3);
                if (read == -1) {
                    return a(queue, i2);
                }
                i3 += read;
                i2 += read;
            }
            min = d(((long) min) * ((long) (min < 4096 ? 4 : 2)));
        }
        if (inputStream.read() == -1) {
            return a(queue, f24656b);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }
}
