package org.threeten.bp.zone;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import org.threeten.bp.ZoneOffset;

final class Ser implements Externalizable {
    static final byte X2 = 2;
    private static final long Y = -8885321777449118786L;
    static final byte Y2 = 3;
    static final byte Z = 1;
    private Object X;
    private byte s;

    public Ser() {
    }

    static Object a(DataInput dataInput) throws IOException, ClassNotFoundException {
        return c(dataInput.readByte(), dataInput);
    }

    static long b(DataInput dataInput) throws IOException {
        byte readByte = dataInput.readByte() & 255;
        if (readByte == 255) {
            return dataInput.readLong();
        }
        return (((long) (((readByte << 16) + ((dataInput.readByte() & 255) << 8)) + (dataInput.readByte() & 255))) * 900) - 4575744000L;
    }

    private static Object c(byte b2, DataInput dataInput) throws IOException, ClassNotFoundException {
        if (b2 == 1) {
            return StandardZoneRules.t(dataInput);
        }
        if (b2 == 2) {
            return ZoneOffsetTransition.o(dataInput);
        }
        if (b2 == 3) {
            return ZoneOffsetTransitionRule.l(dataInput);
        }
        throw new StreamCorruptedException("Unknown serialized type");
    }

    static ZoneOffset d(DataInput dataInput) throws IOException {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? ZoneOffset.L(dataInput.readInt()) : ZoneOffset.L(readByte * 900);
    }

    private Object e() {
        return this.X;
    }

    static void f(Object obj, DataOutput dataOutput) throws IOException {
        h((byte) 1, obj, dataOutput);
    }

    static void g(long j2, DataOutput dataOutput) throws IOException {
        if (j2 < -4575744000L || j2 >= 10413792000L || j2 % 900 != 0) {
            dataOutput.writeByte(255);
            dataOutput.writeLong(j2);
            return;
        }
        int i2 = (int) ((j2 + 4575744000L) / 900);
        dataOutput.writeByte((i2 >>> 16) & 255);
        dataOutput.writeByte((i2 >>> 8) & 255);
        dataOutput.writeByte(i2 & 255);
    }

    private static void h(byte b2, Object obj, DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(b2);
        if (b2 == 1) {
            ((StandardZoneRules) obj).u(dataOutput);
        } else if (b2 == 2) {
            ((ZoneOffsetTransition) obj).q(dataOutput);
        } else if (b2 == 3) {
            ((ZoneOffsetTransitionRule) obj).m(dataOutput);
        } else {
            throw new InvalidClassException("Unknown serialized type");
        }
    }

    static void i(ZoneOffset zoneOffset, DataOutput dataOutput) throws IOException {
        int F = zoneOffset.F();
        int i2 = F % TypedValues.Custom.f3957j == 0 ? F / TypedValues.Custom.f3957j : WorkQueueKt.f29430c;
        dataOutput.writeByte(i2);
        if (i2 == 127) {
            dataOutput.writeInt(F);
        }
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        byte readByte = objectInput.readByte();
        this.s = readByte;
        this.X = c(readByte, objectInput);
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        h(this.s, this.X, objectOutput);
    }

    Ser(byte b2, Object obj) {
        this.s = b2;
        this.X = obj;
    }
}
