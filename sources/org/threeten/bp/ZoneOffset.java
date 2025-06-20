package org.threeten.bp;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.zone.ZoneRules;

public final class ZoneOffset extends ZoneId implements TemporalAccessor, TemporalAdjuster, Comparable<ZoneOffset>, Serializable {
    public static final TemporalQuery<ZoneOffset> Y2 = new TemporalQuery<ZoneOffset>() {
        /* renamed from: b */
        public ZoneOffset a(TemporalAccessor temporalAccessor) {
            return ZoneOffset.E(temporalAccessor);
        }
    };
    private static final ConcurrentMap<Integer, ZoneOffset> Z2 = new ConcurrentHashMap(16, 0.75f, 4);
    private static final ConcurrentMap<String, ZoneOffset> a3 = new ConcurrentHashMap(16, 0.75f, 4);
    private static final int b3 = 3600;
    private static final int c3 = 60;
    private static final int d3 = 60;
    private static final int e3 = 64800;
    private static final long f3 = 2357656521762053153L;
    public static final ZoneOffset g3 = L(0);
    public static final ZoneOffset h3 = L(-64800);
    public static final ZoneOffset i3 = L(e3);
    private final transient String X2;
    private final int Z;

    private ZoneOffset(int i2) {
        this.Z = i2;
        this.X2 = C(i2);
    }

    private static String C(int i2) {
        if (i2 == 0) {
            return "Z";
        }
        int abs = Math.abs(i2);
        StringBuilder sb = new StringBuilder();
        int i4 = abs / b3;
        int i5 = (abs / 60) % 60;
        sb.append(i2 < 0 ? "-" : "+");
        sb.append(i4 < 10 ? "0" : "");
        sb.append(i4);
        String str = ":";
        sb.append(i5 < 10 ? ":0" : str);
        sb.append(i5);
        int i6 = abs % 60;
        if (i6 != 0) {
            if (i6 < 10) {
                str = ":0";
            }
            sb.append(str);
            sb.append(i6);
        }
        return sb.toString();
    }

    public static ZoneOffset E(TemporalAccessor temporalAccessor) {
        ZoneOffset zoneOffset = (ZoneOffset) temporalAccessor.i(TemporalQueries.d());
        if (zoneOffset != null) {
            return zoneOffset;
        }
        throw new DateTimeException("Unable to obtain ZoneOffset from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.threeten.bp.ZoneOffset H(java.lang.String r7) {
        /*
            java.lang.String r0 = "offsetId"
            org.threeten.bp.jdk8.Jdk8Methods.j(r7, r0)
            java.util.concurrent.ConcurrentMap<java.lang.String, org.threeten.bp.ZoneOffset> r0 = a3
            java.lang.Object r0 = r0.get(r7)
            org.threeten.bp.ZoneOffset r0 = (org.threeten.bp.ZoneOffset) r0
            if (r0 == 0) goto L_0x0010
            return r0
        L_0x0010:
            int r0 = r7.length()
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L_0x006e
            r1 = 3
            if (r0 == r1) goto L_0x008a
            r4 = 5
            if (r0 == r4) goto L_0x0065
            r5 = 6
            r6 = 4
            if (r0 == r5) goto L_0x005b
            r5 = 7
            if (r0 == r5) goto L_0x004e
            r1 = 9
            if (r0 != r1) goto L_0x0037
            int r0 = N(r7, r2, r3)
            int r1 = N(r7, r6, r2)
            int r2 = N(r7, r5, r2)
            goto L_0x0090
        L_0x0037:
            org.threeten.bp.DateTimeException r0 = new org.threeten.bp.DateTimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid ID for ZoneOffset, invalid format: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L_0x004e:
            int r0 = N(r7, r2, r3)
            int r1 = N(r7, r1, r3)
            int r2 = N(r7, r4, r3)
            goto L_0x0090
        L_0x005b:
            int r0 = N(r7, r2, r3)
            int r1 = N(r7, r6, r2)
        L_0x0063:
            r2 = 0
            goto L_0x0090
        L_0x0065:
            int r0 = N(r7, r2, r3)
            int r1 = N(r7, r1, r3)
            goto L_0x0063
        L_0x006e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            char r1 = r7.charAt(r3)
            r0.append(r1)
            java.lang.String r1 = "0"
            r0.append(r1)
            char r7 = r7.charAt(r2)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
        L_0x008a:
            int r0 = N(r7, r2, r3)
            r1 = 0
            goto L_0x0063
        L_0x0090:
            char r3 = r7.charAt(r3)
            r4 = 43
            r5 = 45
            if (r3 == r4) goto L_0x00b4
            if (r3 != r5) goto L_0x009d
            goto L_0x00b4
        L_0x009d:
            org.threeten.bp.DateTimeException r0 = new org.threeten.bp.DateTimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid ID for ZoneOffset, plus/minus not found when expected: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L_0x00b4:
            if (r3 != r5) goto L_0x00be
            int r7 = -r0
            int r0 = -r1
            int r1 = -r2
            org.threeten.bp.ZoneOffset r7 = K(r7, r0, r1)
            return r7
        L_0x00be:
            org.threeten.bp.ZoneOffset r7 = K(r0, r1, r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.ZoneOffset.H(java.lang.String):org.threeten.bp.ZoneOffset");
    }

    public static ZoneOffset I(int i2) {
        return K(i2, 0, 0);
    }

    public static ZoneOffset J(int i2, int i4) {
        return K(i2, i4, 0);
    }

    public static ZoneOffset K(int i2, int i4, int i5) {
        R(i2, i4, i5);
        return L(Q(i2, i4, i5));
    }

    public static ZoneOffset L(int i2) {
        if (Math.abs(i2) > e3) {
            throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
        } else if (i2 % TypedValues.Custom.f3957j != 0) {
            return new ZoneOffset(i2);
        } else {
            Integer valueOf = Integer.valueOf(i2);
            ConcurrentMap<Integer, ZoneOffset> concurrentMap = Z2;
            ZoneOffset zoneOffset = concurrentMap.get(valueOf);
            if (zoneOffset != null) {
                return zoneOffset;
            }
            concurrentMap.putIfAbsent(valueOf, new ZoneOffset(i2));
            ZoneOffset zoneOffset2 = concurrentMap.get(valueOf);
            a3.putIfAbsent(zoneOffset2.s(), zoneOffset2);
            return zoneOffset2;
        }
    }

    private static int N(CharSequence charSequence, int i2, boolean z) {
        if (!z || charSequence.charAt(i2 - 1) == ':') {
            char charAt = charSequence.charAt(i2);
            char charAt2 = charSequence.charAt(i2 + 1);
            if (charAt >= '0' && charAt <= '9' && charAt2 >= '0' && charAt2 <= '9') {
                return ((charAt - '0') * 10) + (charAt2 - '0');
            }
            throw new DateTimeException("Invalid ID for ZoneOffset, non numeric characters found: " + charSequence);
        }
        throw new DateTimeException("Invalid ID for ZoneOffset, colon not found when expected: " + charSequence);
    }

    static ZoneOffset O(DataInput dataInput) throws IOException {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? L(dataInput.readInt()) : L(readByte * 900);
    }

    private Object P() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private static int Q(int i2, int i4, int i5) {
        return (i2 * b3) + (i4 * 60) + i5;
    }

    private static void R(int i2, int i4, int i5) {
        if (i2 < -18 || i2 > 18) {
            throw new DateTimeException("Zone offset hours not in valid range: value " + i2 + " is not in the range -18 to 18");
        }
        if (i2 > 0) {
            if (i4 < 0 || i5 < 0) {
                throw new DateTimeException("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i2 < 0) {
            if (i4 > 0 || i5 > 0) {
                throw new DateTimeException("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i4 > 0 && i5 < 0) || (i4 < 0 && i5 > 0)) {
            throw new DateTimeException("Zone offset minutes and seconds must have the same sign");
        }
        if (Math.abs(i4) > 59) {
            throw new DateTimeException("Zone offset minutes not in valid range: abs(value) " + Math.abs(i4) + " is not in the range 0 to 59");
        } else if (Math.abs(i5) > 59) {
            throw new DateTimeException("Zone offset seconds not in valid range: abs(value) " + Math.abs(i5) + " is not in the range 0 to 59");
        } else if (Math.abs(i2) != 18) {
        } else {
            if (Math.abs(i4) > 0 || Math.abs(i5) > 0) {
                throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
            }
        }
    }

    private Object T() {
        return new Ser((byte) 8, this);
    }

    /* access modifiers changed from: package-private */
    public void A(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(8);
        S(dataOutput);
    }

    /* renamed from: D */
    public int compareTo(ZoneOffset zoneOffset) {
        return zoneOffset.Z - this.Z;
    }

    public int F() {
        return this.Z;
    }

    /* access modifiers changed from: package-private */
    public void S(DataOutput dataOutput) throws IOException {
        int i2 = this.Z;
        int i4 = i2 % TypedValues.Custom.f3957j == 0 ? i2 / TypedValues.Custom.f3957j : WorkQueueKt.f29430c;
        dataOutput.writeByte(i4);
        if (i4 == 127) {
            dataOutput.writeInt(i2);
        }
    }

    public int b(TemporalField temporalField) {
        if (temporalField == ChronoField.OFFSET_SECONDS) {
            return this.Z;
        }
        if (!(temporalField instanceof ChronoField)) {
            return f(temporalField).a(p(temporalField), temporalField);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public Temporal e(Temporal temporal) {
        return temporal.a(ChronoField.OFFSET_SECONDS, (long) this.Z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ZoneOffset) && this.Z == ((ZoneOffset) obj).Z;
    }

    public ValueRange f(TemporalField temporalField) {
        if (temporalField == ChronoField.OFFSET_SECONDS) {
            return temporalField.h();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.f(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public int hashCode() {
        return this.Z;
    }

    public <R> R i(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.d() || temporalQuery == TemporalQueries.f()) {
            return this;
        }
        if (temporalQuery == TemporalQueries.b() || temporalQuery == TemporalQueries.c() || temporalQuery == TemporalQueries.e() || temporalQuery == TemporalQueries.a() || temporalQuery == TemporalQueries.g()) {
            return null;
        }
        return temporalQuery.a(this);
    }

    public boolean m(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.OFFSET_SECONDS : temporalField != null && temporalField.c(this);
    }

    public long p(TemporalField temporalField) {
        if (temporalField == ChronoField.OFFSET_SECONDS) {
            return (long) this.Z;
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.j(this);
        }
        throw new DateTimeException("Unsupported field: " + temporalField);
    }

    public String s() {
        return this.X2;
    }

    public String toString() {
        return this.X2;
    }

    public ZoneRules u() {
        return ZoneRules.m(this);
    }
}
