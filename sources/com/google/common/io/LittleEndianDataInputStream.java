package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
public final class LittleEndianDataInputStream extends FilterInputStream implements DataInput {
    public LittleEndianDataInputStream(InputStream inputStream) {
        super((InputStream) Preconditions.E(inputStream));
    }

    private byte b() throws IOException, EOFException {
        int read = this.in.read();
        if (-1 != read) {
            return (byte) read;
        }
        throw new EOFException();
    }

    @CanIgnoreReturnValue
    public boolean readBoolean() throws IOException {
        return readUnsignedByte() != 0;
    }

    @CanIgnoreReturnValue
    public byte readByte() throws IOException {
        return (byte) readUnsignedByte();
    }

    @CanIgnoreReturnValue
    public char readChar() throws IOException {
        return (char) readUnsignedShort();
    }

    @CanIgnoreReturnValue
    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    @CanIgnoreReturnValue
    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    public void readFully(byte[] bArr) throws IOException {
        ByteStreams.p(this, bArr);
    }

    @CanIgnoreReturnValue
    public int readInt() throws IOException {
        byte b2 = b();
        byte b3 = b();
        return Ints.k(b(), b(), b3, b2);
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    public String readLine() {
        throw new UnsupportedOperationException("readLine is not supported");
    }

    @CanIgnoreReturnValue
    public long readLong() throws IOException {
        byte b2 = b();
        byte b3 = b();
        byte b4 = b();
        byte b5 = b();
        byte b6 = b();
        byte b7 = b();
        return Longs.k(b(), b(), b7, b6, b5, b4, b3, b2);
    }

    @CanIgnoreReturnValue
    public short readShort() throws IOException {
        return (short) readUnsignedShort();
    }

    @CanIgnoreReturnValue
    public String readUTF() throws IOException {
        return new DataInputStream(this.in).readUTF();
    }

    @CanIgnoreReturnValue
    public int readUnsignedByte() throws IOException {
        int read = this.in.read();
        if (read >= 0) {
            return read;
        }
        throw new EOFException();
    }

    @CanIgnoreReturnValue
    public int readUnsignedShort() throws IOException {
        return Ints.k((byte) 0, (byte) 0, b(), b());
    }

    public int skipBytes(int i2) throws IOException {
        return (int) this.in.skip((long) i2);
    }

    public void readFully(byte[] bArr, int i2, int i3) throws IOException {
        ByteStreams.q(this, bArr, i2, i3);
    }
}
