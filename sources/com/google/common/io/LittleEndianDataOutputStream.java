package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
public final class LittleEndianDataOutputStream extends FilterOutputStream implements DataOutput {
    public LittleEndianDataOutputStream(OutputStream outputStream) {
        super(new DataOutputStream((OutputStream) Preconditions.E(outputStream)));
    }

    public void close() throws IOException {
        this.out.close();
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        this.out.write(bArr, i2, i3);
    }

    public void writeBoolean(boolean z) throws IOException {
        ((DataOutputStream) this.out).writeBoolean(z);
    }

    public void writeByte(int i2) throws IOException {
        ((DataOutputStream) this.out).writeByte(i2);
    }

    @Deprecated
    public void writeBytes(String str) throws IOException {
        ((DataOutputStream) this.out).writeBytes(str);
    }

    public void writeChar(int i2) throws IOException {
        writeShort(i2);
    }

    public void writeChars(String str) throws IOException {
        for (int i2 = 0; i2 < str.length(); i2++) {
            writeChar(str.charAt(i2));
        }
    }

    public void writeDouble(double d2) throws IOException {
        writeLong(Double.doubleToLongBits(d2));
    }

    public void writeFloat(float f2) throws IOException {
        writeInt(Float.floatToIntBits(f2));
    }

    public void writeInt(int i2) throws IOException {
        this.out.write(i2 & 255);
        this.out.write((i2 >> 8) & 255);
        this.out.write((i2 >> 16) & 255);
        this.out.write((i2 >> 24) & 255);
    }

    public void writeLong(long j2) throws IOException {
        byte[] D = Longs.D(Long.reverseBytes(j2));
        write(D, 0, D.length);
    }

    public void writeShort(int i2) throws IOException {
        this.out.write(i2 & 255);
        this.out.write((i2 >> 8) & 255);
    }

    public void writeUTF(String str) throws IOException {
        ((DataOutputStream) this.out).writeUTF(str);
    }
}
