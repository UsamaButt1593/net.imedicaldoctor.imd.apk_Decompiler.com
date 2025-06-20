package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.io.DataOutput;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
public interface ByteArrayDataOutput extends DataOutput {
    byte[] t();

    void write(int i2);

    void write(byte[] bArr);

    void write(byte[] bArr, int i2, int i3);

    void writeBoolean(boolean z);

    void writeByte(int i2);

    @Deprecated
    void writeBytes(String str);

    void writeChar(int i2);

    void writeChars(String str);

    void writeDouble(double d2);

    void writeFloat(float f2);

    void writeInt(int i2);

    void writeLong(long j2);

    void writeShort(int i2);

    void writeUTF(String str);
}
