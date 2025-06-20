package org.threeten.bp;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

final class Ser implements Externalizable {
    static final byte X2 = 2;
    private static final long Y = -7683839454370182990L;
    static final byte Y2 = 3;
    static final byte Z = 1;
    static final byte Z2 = 4;
    static final byte a3 = 5;
    static final byte b3 = 6;
    static final byte c3 = 7;
    static final byte d3 = 8;
    static final byte e3 = 64;
    static final byte f3 = 66;
    static final byte g3 = 67;
    static final byte h3 = 68;
    static final byte i3 = 69;
    private Object X;
    private byte s;

    public Ser() {
    }

    static Object a(DataInput dataInput) throws IOException {
        return b(dataInput.readByte(), dataInput);
    }

    private static Object b(byte b2, DataInput dataInput) throws IOException {
        if (b2 == 64) {
            return MonthDay.c0(dataInput);
        }
        switch (b2) {
            case 1:
                return Duration.d0(dataInput);
            case 2:
                return Instant.L0(dataInput);
            case 3:
                return LocalDate.P2(dataInput);
            case 4:
                return LocalDateTime.S2(dataInput);
            case 5:
                return LocalTime.e1(dataInput);
            case 6:
                return ZonedDateTime.U2(dataInput);
            case 7:
                return ZoneRegion.E(dataInput);
            case 8:
                return ZoneOffset.O(dataInput);
            default:
                switch (b2) {
                    case 66:
                        return OffsetTime.S0(dataInput);
                    case 67:
                        return Year.G0(dataInput);
                    case 68:
                        return YearMonth.S0(dataInput);
                    case 69:
                        return OffsetDateTime.i2(dataInput);
                    default:
                        throw new StreamCorruptedException("Unknown serialized type");
                }
        }
    }

    private Object c() {
        return this.X;
    }

    static void d(byte b2, Object obj, DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(b2);
        if (b2 != 64) {
            switch (b2) {
                case 1:
                    ((Duration) obj).v0(dataOutput);
                    return;
                case 2:
                    ((Instant) obj).h1(dataOutput);
                    return;
                case 3:
                    ((LocalDate) obj).a3(dataOutput);
                    return;
                case 4:
                    ((LocalDateTime) obj).h3(dataOutput);
                    return;
                case 5:
                    ((LocalTime) obj).i2(dataOutput);
                    return;
                case 6:
                    ((ZonedDateTime) obj).s3(dataOutput);
                    return;
                case 7:
                    ((ZoneRegion) obj).H(dataOutput);
                    return;
                case 8:
                    ((ZoneOffset) obj).S(dataOutput);
                    return;
                default:
                    switch (b2) {
                        case 66:
                            ((OffsetTime) obj).f2(dataOutput);
                            return;
                        case 67:
                            ((Year) obj).S0(dataOutput);
                            return;
                        case 68:
                            ((YearMonth) obj).k1(dataOutput);
                            return;
                        case 69:
                            ((OffsetDateTime) obj).W2(dataOutput);
                            return;
                        default:
                            throw new InvalidClassException("Unknown serialized type");
                    }
            }
        } else {
            ((MonthDay) obj).v0(dataOutput);
        }
    }

    public void readExternal(ObjectInput objectInput) throws IOException {
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
