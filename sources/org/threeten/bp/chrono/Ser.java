package org.threeten.bp.chrono;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

final class Ser implements Externalizable {
    static final byte X2 = 2;
    private static final long Y = 7857518227608961174L;
    static final byte Y2 = 3;
    static final byte Z = 1;
    static final byte Z2 = 4;
    static final byte a3 = 5;
    static final byte b3 = 6;
    static final byte c3 = 7;
    static final byte d3 = 8;
    static final byte e3 = 11;
    static final byte f3 = 12;
    static final byte g3 = 13;
    private Object X;
    private byte s;

    public Ser() {
    }

    static Object a(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        return b(objectInput.readByte(), objectInput);
    }

    private static Object b(byte b2, ObjectInput objectInput) throws IOException, ClassNotFoundException {
        switch (b2) {
            case 1:
                return JapaneseDate.p2(objectInput);
            case 2:
                return JapaneseEra.x(objectInput);
            case 3:
                return HijrahDate.c3(objectInput);
            case 4:
                return HijrahEra.s(objectInput);
            case 5:
                return MinguoDate.m2(objectInput);
            case 6:
                return MinguoEra.k(objectInput);
            case 7:
                return ThaiBuddhistDate.m2(objectInput);
            case 8:
                return ThaiBuddhistEra.k(objectInput);
            case 11:
                return Chronology.F(objectInput);
            case 12:
                return ChronoLocalDateTimeImpl.L0(objectInput);
            case 13:
                return ChronoZonedDateTimeImpl.R0(objectInput);
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    private Object c() {
        return this.X;
    }

    private static void d(byte b2, Object obj, ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(b2);
        switch (b2) {
            case 1:
                ((JapaneseDate) obj).E2(objectOutput);
                return;
            case 2:
                ((JapaneseEra) obj).F(objectOutput);
                return;
            case 3:
                ((HijrahDate) obj).h3(objectOutput);
                return;
            case 4:
                ((HijrahEra) obj).u(objectOutput);
                return;
            case 5:
                ((MinguoDate) obj).r2(objectOutput);
                return;
            case 6:
                ((MinguoEra) obj).s(objectOutput);
                return;
            case 7:
                ((ThaiBuddhistDate) obj).r2(objectOutput);
                return;
            case 8:
                ((ThaiBuddhistEra) obj).s(objectOutput);
                return;
            case 11:
                ((Chronology) obj).L(objectOutput);
                return;
            case 12:
                ((ChronoLocalDateTimeImpl) obj).writeExternal(objectOutput);
                return;
            case 13:
                ((ChronoZonedDateTimeImpl) obj).writeExternal(objectOutput);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        byte readByte = objectInput.readByte();
        this.s = readByte;
        this.X = b(readByte, objectInput);
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        d(this.s, this.X, objectOutput);
    }

    Ser(byte b2, Object obj) {
        this.s = b2;
        this.X = obj;
    }
}
