package com.google.common.io;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class ByteStreams {

    /* renamed from: a  reason: collision with root package name */
    private static final int f22764a = 8192;

    /* renamed from: b  reason: collision with root package name */
    private static final int f22765b = 524288;

    /* renamed from: c  reason: collision with root package name */
    private static final int f22766c = 2147483639;

    /* renamed from: d  reason: collision with root package name */
    private static final int f22767d = 20;

    /* renamed from: e  reason: collision with root package name */
    private static final OutputStream f22768e = new OutputStream() {
        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }

        public void write(int i2) {
        }

        public void write(byte[] bArr) {
            Preconditions.E(bArr);
        }

        public void write(byte[] bArr, int i2, int i3) {
            Preconditions.E(bArr);
            Preconditions.f0(i2, i3 + i2, bArr.length);
        }
    };

    private static class ByteArrayDataInputStream implements ByteArrayDataInput {
        final DataInput s;

        ByteArrayDataInputStream(ByteArrayInputStream byteArrayInputStream) {
            this.s = new DataInputStream(byteArrayInputStream);
        }

        public boolean readBoolean() {
            try {
                return this.s.readBoolean();
            } catch (IOException e2) {
                throw new IllegalStateException(e2);
            }
        }

        public byte readByte() {
            try {
                return this.s.readByte();
            } catch (EOFException e2) {
                throw new IllegalStateException(e2);
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        }

        public char readChar() {
            try {
                return this.s.readChar();
            } catch (IOException e2) {
                throw new IllegalStateException(e2);
            }
        }

        public double readDouble() {
            try {
                return this.s.readDouble();
            } catch (IOException e2) {
                throw new IllegalStateException(e2);
            }
        }

        public float readFloat() {
            try {
                return this.s.readFloat();
            } catch (IOException e2) {
                throw new IllegalStateException(e2);
            }
        }

        public void readFully(byte[] bArr) {
            try {
                this.s.readFully(bArr);
            } catch (IOException e2) {
                throw new IllegalStateException(e2);
            }
        }

        public int readInt() {
            try {
                return this.s.readInt();
            } catch (IOException e2) {
                throw new IllegalStateException(e2);
            }
        }

        @CheckForNull
        public String readLine() {
            try {
                return this.s.readLine();
            } catch (IOException e2) {
                throw new IllegalStateException(e2);
            }
        }

        public long readLong() {
            try {
                return this.s.readLong();
            } catch (IOException e2) {
                throw new IllegalStateException(e2);
            }
        }

        public short readShort() {
            try {
                return this.s.readShort();
            } catch (IOException e2) {
                throw new IllegalStateException(e2);
            }
        }

        public String readUTF() {
            try {
                return this.s.readUTF();
            } catch (IOException e2) {
                throw new IllegalStateException(e2);
            }
        }

        public int readUnsignedByte() {
            try {
                return this.s.readUnsignedByte();
            } catch (IOException e2) {
                throw new IllegalStateException(e2);
            }
        }

        public int readUnsignedShort() {
            try {
                return this.s.readUnsignedShort();
            } catch (IOException e2) {
                throw new IllegalStateException(e2);
            }
        }

        public int skipBytes(int i2) {
            try {
                return this.s.skipBytes(i2);
            } catch (IOException e2) {
                throw new IllegalStateException(e2);
            }
        }

        public void readFully(byte[] bArr, int i2, int i3) {
            try {
                this.s.readFully(bArr, i2, i3);
            } catch (IOException e2) {
                throw new IllegalStateException(e2);
            }
        }
    }

    private static class ByteArrayDataOutputStream implements ByteArrayDataOutput {
        final ByteArrayOutputStream X;
        final DataOutput s;

        ByteArrayDataOutputStream(ByteArrayOutputStream byteArrayOutputStream) {
            this.X = byteArrayOutputStream;
            this.s = new DataOutputStream(byteArrayOutputStream);
        }

        public byte[] t() {
            return this.X.toByteArray();
        }

        public void write(int i2) {
            try {
                this.s.write(i2);
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }

        public void writeBoolean(boolean z) {
            try {
                this.s.writeBoolean(z);
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }

        public void writeByte(int i2) {
            try {
                this.s.writeByte(i2);
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }

        public void writeBytes(String str) {
            try {
                this.s.writeBytes(str);
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }

        public void writeChar(int i2) {
            try {
                this.s.writeChar(i2);
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }

        public void writeChars(String str) {
            try {
                this.s.writeChars(str);
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }

        public void writeDouble(double d2) {
            try {
                this.s.writeDouble(d2);
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }

        public void writeFloat(float f2) {
            try {
                this.s.writeFloat(f2);
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }

        public void writeInt(int i2) {
            try {
                this.s.writeInt(i2);
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }

        public void writeLong(long j2) {
            try {
                this.s.writeLong(j2);
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }

        public void writeShort(int i2) {
            try {
                this.s.writeShort(i2);
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }

        public void writeUTF(String str) {
            try {
                this.s.writeUTF(str);
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }

        public void write(byte[] bArr) {
            try {
                this.s.write(bArr);
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }

        public void write(byte[] bArr, int i2, int i3) {
            try {
                this.s.write(bArr, i2, i3);
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    private static final class LimitedInputStream extends FilterInputStream {
        private long X = -1;
        private long s;

        LimitedInputStream(InputStream inputStream, long j2) {
            super(inputStream);
            Preconditions.E(inputStream);
            Preconditions.e(j2 >= 0, "limit must be non-negative");
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

    @CanIgnoreReturnValue
    public static long b(InputStream inputStream, OutputStream outputStream) throws IOException {
        Preconditions.E(inputStream);
        Preconditions.E(outputStream);
        byte[] d2 = d();
        long j2 = 0;
        while (true) {
            int read = inputStream.read(d2);
            if (read == -1) {
                return j2;
            }
            outputStream.write(d2, 0, read);
            j2 += (long) read;
        }
    }

    @CanIgnoreReturnValue
    public static long c(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel) throws IOException {
        Preconditions.E(readableByteChannel);
        Preconditions.E(writableByteChannel);
        long j2 = 0;
        if (readableByteChannel instanceof FileChannel) {
            FileChannel fileChannel = (FileChannel) readableByteChannel;
            long position = fileChannel.position();
            long j3 = position;
            while (true) {
                long transferTo = fileChannel.transferTo(j3, PlaybackStateCompat.y3, writableByteChannel);
                j3 += transferTo;
                fileChannel.position(j3);
                if (transferTo <= 0 && j3 >= fileChannel.size()) {
                    return j3 - position;
                }
            }
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(d());
            while (readableByteChannel.read(wrap) != -1) {
                Java8Compatibility.b(wrap);
                while (wrap.hasRemaining()) {
                    j2 += (long) writableByteChannel.write(wrap);
                }
                Java8Compatibility.a(wrap);
            }
            return j2;
        }
    }

    static byte[] d() {
        return new byte[8192];
    }

    @CanIgnoreReturnValue
    public static long e(InputStream inputStream) throws IOException {
        byte[] d2 = d();
        long j2 = 0;
        while (true) {
            long read = (long) inputStream.read(d2);
            if (read == -1) {
                return j2;
            }
            j2 += read;
        }
    }

    public static InputStream f(InputStream inputStream, long j2) {
        return new LimitedInputStream(inputStream, j2);
    }

    public static ByteArrayDataInput g(ByteArrayInputStream byteArrayInputStream) {
        return new ByteArrayDataInputStream((ByteArrayInputStream) Preconditions.E(byteArrayInputStream));
    }

    public static ByteArrayDataInput h(byte[] bArr) {
        return g(new ByteArrayInputStream(bArr));
    }

    public static ByteArrayDataInput i(byte[] bArr, int i2) {
        Preconditions.d0(i2, bArr.length);
        return g(new ByteArrayInputStream(bArr, i2, bArr.length - i2));
    }

    public static ByteArrayDataOutput j() {
        return l(new ByteArrayOutputStream());
    }

    public static ByteArrayDataOutput k(int i2) {
        if (i2 >= 0) {
            return l(new ByteArrayOutputStream(i2));
        }
        throw new IllegalArgumentException(String.format("Invalid size: %s", new Object[]{Integer.valueOf(i2)}));
    }

    public static ByteArrayDataOutput l(ByteArrayOutputStream byteArrayOutputStream) {
        return new ByteArrayDataOutputStream((ByteArrayOutputStream) Preconditions.E(byteArrayOutputStream));
    }

    public static OutputStream m() {
        return f22768e;
    }

    @CanIgnoreReturnValue
    public static int n(InputStream inputStream, byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        Preconditions.E(inputStream);
        Preconditions.E(bArr);
        if (i3 >= 0) {
            Preconditions.f0(i2, i2 + i3, bArr.length);
            while (i4 < i3) {
                int read = inputStream.read(bArr, i2 + i4, i3 - i4);
                if (read == -1) {
                    break;
                }
                i4 += read;
            }
            return i4;
        }
        throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", new Object[]{Integer.valueOf(i3)}));
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public static <T> T o(InputStream inputStream, ByteProcessor<T> byteProcessor) throws IOException {
        int read;
        Preconditions.E(inputStream);
        Preconditions.E(byteProcessor);
        byte[] d2 = d();
        do {
            read = inputStream.read(d2);
            if (read == -1 || !byteProcessor.b(d2, 0, read)) {
            }
            read = inputStream.read(d2);
            break;
        } while (!byteProcessor.b(d2, 0, read));
        return byteProcessor.a();
    }

    public static void p(InputStream inputStream, byte[] bArr) throws IOException {
        q(inputStream, bArr, 0, bArr.length);
    }

    public static void q(InputStream inputStream, byte[] bArr, int i2, int i3) throws IOException {
        int n2 = n(inputStream, bArr, i2, i3);
        if (n2 != i3) {
            throw new EOFException("reached end of stream after reading " + n2 + " bytes; " + i3 + " bytes expected");
        }
    }

    public static void r(InputStream inputStream, long j2) throws IOException {
        long t = t(inputStream, j2);
        if (t < j2) {
            throw new EOFException("reached end of stream after skipping " + t + " bytes; " + j2 + " bytes expected");
        }
    }

    private static long s(InputStream inputStream, long j2) throws IOException {
        int available = inputStream.available();
        if (available == 0) {
            return 0;
        }
        return inputStream.skip(Math.min((long) available, j2));
    }

    static long t(InputStream inputStream, long j2) throws IOException {
        byte[] bArr = null;
        long j3 = 0;
        while (j3 < j2) {
            long j4 = j2 - j3;
            long s = s(inputStream, j4);
            if (s == 0) {
                int min = (int) Math.min(j4, PlaybackStateCompat.s3);
                if (bArr == null) {
                    bArr = new byte[min];
                }
                s = (long) inputStream.read(bArr, 0, min);
                if (s == -1) {
                    break;
                }
            }
            j3 += s;
        }
        return j3;
    }

    public static byte[] u(InputStream inputStream) throws IOException {
        Preconditions.E(inputStream);
        return w(inputStream, new ArrayDeque(20), 0);
    }

    static byte[] v(InputStream inputStream, long j2) throws IOException {
        Preconditions.p(j2 >= 0, "expectedSize (%s) must be non-negative", j2);
        if (j2 <= 2147483639) {
            int i2 = (int) j2;
            byte[] bArr = new byte[i2];
            int i3 = i2;
            while (i3 > 0) {
                int i4 = i2 - i3;
                int read = inputStream.read(bArr, i4, i3);
                if (read == -1) {
                    return Arrays.copyOf(bArr, i4);
                }
                i3 -= read;
            }
            int read2 = inputStream.read();
            if (read2 == -1) {
                return bArr;
            }
            ArrayDeque arrayDeque = new ArrayDeque(22);
            arrayDeque.add(bArr);
            arrayDeque.add(new byte[]{(byte) read2});
            return w(inputStream, arrayDeque, i2 + 1);
        }
        throw new OutOfMemoryError(j2 + " bytes is too large to fit in a byte array");
    }

    private static byte[] w(InputStream inputStream, Queue<byte[]> queue, int i2) throws IOException {
        int min = Math.min(8192, Math.max(128, Integer.highestOneBit(i2) * 2));
        while (i2 < f22766c) {
            int min2 = Math.min(min, f22766c - i2);
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
            min = IntMath.u(min, min < 4096 ? 4 : 2);
        }
        if (inputStream.read() == -1) {
            return a(queue, f22766c);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }
}
