package org.threeten.bp;

import com.airbnb.lottie.utils.Utils;
import com.itextpdf.text.DocWriter;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.apache.commons.lang3.ClassUtils;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public final class LocalTime extends DefaultInterfaceTemporalAccessor implements Temporal, TemporalAdjuster, Comparable<LocalTime>, Serializable {
    public static final LocalTime X2;
    public static final LocalTime Y2 = new LocalTime(23, 59, 59, Year.Y);
    public static final LocalTime Z2;
    public static final LocalTime a3;
    public static final TemporalQuery<LocalTime> b3 = new TemporalQuery<LocalTime>() {
        /* renamed from: b */
        public LocalTime a(TemporalAccessor temporalAccessor) {
            return LocalTime.y(temporalAccessor);
        }
    };
    private static final LocalTime[] c3 = new LocalTime[24];
    static final int d3 = 24;
    static final int e3 = 60;
    static final int f3 = 1440;
    static final int g3 = 60;
    static final int h3 = 3600;
    static final int i3 = 86400;
    static final long j3 = 86400000;
    static final long k3 = 86400000000L;
    static final long l3 = 1000000000;
    static final long m3 = 60000000000L;
    static final long n3 = 3600000000000L;
    static final long o3 = 86400000000000L;
    private static final long p3 = 6414437269572265201L;
    private final byte X;
    private final byte Y;
    private final int Z;
    private final byte s;

    /* renamed from: org.threeten.bp.LocalTime$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31776a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f31777b;

        /* JADX WARNING: Can't wrap try/catch for region: R(46:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|(2:25|26)|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|(3:57|58|60)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(50:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|(2:25|26)|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Can't wrap try/catch for region: R(52:0|1|2|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|25|26|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Can't wrap try/catch for region: R(53:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|60) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0065 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x006f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0079 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x0083 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x008d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0097 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00a1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00ad */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00b9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00c5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00d1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00dd */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00e9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00f5 */
        static {
            /*
                org.threeten.bp.temporal.ChronoUnit[] r0 = org.threeten.bp.temporal.ChronoUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31777b = r0
                r1 = 1
                org.threeten.bp.temporal.ChronoUnit r2 = org.threeten.bp.temporal.ChronoUnit.NANOS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f31777b     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoUnit r3 = org.threeten.bp.temporal.ChronoUnit.MICROS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f31777b     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoUnit r4 = org.threeten.bp.temporal.ChronoUnit.MILLIS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f31777b     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoUnit r5 = org.threeten.bp.temporal.ChronoUnit.SECONDS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f31777b     // Catch:{ NoSuchFieldError -> 0x003e }
                org.threeten.bp.temporal.ChronoUnit r6 = org.threeten.bp.temporal.ChronoUnit.MINUTES     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = f31777b     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.threeten.bp.temporal.ChronoUnit r7 = org.threeten.bp.temporal.ChronoUnit.HOURS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                r6 = 7
                int[] r7 = f31777b     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.threeten.bp.temporal.ChronoUnit r8 = org.threeten.bp.temporal.ChronoUnit.HALF_DAYS     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r7[r8] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                org.threeten.bp.temporal.ChronoField[] r7 = org.threeten.bp.temporal.ChronoField.values()
                int r7 = r7.length
                int[] r7 = new int[r7]
                f31776a = r7
                org.threeten.bp.temporal.ChronoField r8 = org.threeten.bp.temporal.ChronoField.NANO_OF_SECOND     // Catch:{ NoSuchFieldError -> 0x0065 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0065 }
                r7[r8] = r1     // Catch:{ NoSuchFieldError -> 0x0065 }
            L_0x0065:
                int[] r1 = f31776a     // Catch:{ NoSuchFieldError -> 0x006f }
                org.threeten.bp.temporal.ChronoField r7 = org.threeten.bp.temporal.ChronoField.NANO_OF_DAY     // Catch:{ NoSuchFieldError -> 0x006f }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x006f }
                r1[r7] = r0     // Catch:{ NoSuchFieldError -> 0x006f }
            L_0x006f:
                int[] r0 = f31776a     // Catch:{ NoSuchFieldError -> 0x0079 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MICRO_OF_SECOND     // Catch:{ NoSuchFieldError -> 0x0079 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0079 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0079 }
            L_0x0079:
                int[] r0 = f31776a     // Catch:{ NoSuchFieldError -> 0x0083 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MICRO_OF_DAY     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                int[] r0 = f31776a     // Catch:{ NoSuchFieldError -> 0x008d }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MILLI_OF_SECOND     // Catch:{ NoSuchFieldError -> 0x008d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008d }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x008d }
            L_0x008d:
                int[] r0 = f31776a     // Catch:{ NoSuchFieldError -> 0x0097 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MILLI_OF_DAY     // Catch:{ NoSuchFieldError -> 0x0097 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0097 }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x0097 }
            L_0x0097:
                int[] r0 = f31776a     // Catch:{ NoSuchFieldError -> 0x00a1 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.SECOND_OF_MINUTE     // Catch:{ NoSuchFieldError -> 0x00a1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a1 }
                r0[r1] = r6     // Catch:{ NoSuchFieldError -> 0x00a1 }
            L_0x00a1:
                int[] r0 = f31776a     // Catch:{ NoSuchFieldError -> 0x00ad }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.SECOND_OF_DAY     // Catch:{ NoSuchFieldError -> 0x00ad }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ad }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00ad }
            L_0x00ad:
                int[] r0 = f31776a     // Catch:{ NoSuchFieldError -> 0x00b9 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MINUTE_OF_HOUR     // Catch:{ NoSuchFieldError -> 0x00b9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b9 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b9 }
            L_0x00b9:
                int[] r0 = f31776a     // Catch:{ NoSuchFieldError -> 0x00c5 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.MINUTE_OF_DAY     // Catch:{ NoSuchFieldError -> 0x00c5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c5 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c5 }
            L_0x00c5:
                int[] r0 = f31776a     // Catch:{ NoSuchFieldError -> 0x00d1 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.HOUR_OF_AMPM     // Catch:{ NoSuchFieldError -> 0x00d1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d1 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d1 }
            L_0x00d1:
                int[] r0 = f31776a     // Catch:{ NoSuchFieldError -> 0x00dd }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.CLOCK_HOUR_OF_AMPM     // Catch:{ NoSuchFieldError -> 0x00dd }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00dd }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00dd }
            L_0x00dd:
                int[] r0 = f31776a     // Catch:{ NoSuchFieldError -> 0x00e9 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.HOUR_OF_DAY     // Catch:{ NoSuchFieldError -> 0x00e9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e9 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e9 }
            L_0x00e9:
                int[] r0 = f31776a     // Catch:{ NoSuchFieldError -> 0x00f5 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.CLOCK_HOUR_OF_DAY     // Catch:{ NoSuchFieldError -> 0x00f5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f5 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f5 }
            L_0x00f5:
                int[] r0 = f31776a     // Catch:{ NoSuchFieldError -> 0x0101 }
                org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.AMPM_OF_DAY     // Catch:{ NoSuchFieldError -> 0x0101 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0101 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0101 }
            L_0x0101:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.LocalTime.AnonymousClass2.<clinit>():void");
        }
    }

    static {
        int i2 = 0;
        while (true) {
            LocalTime[] localTimeArr = c3;
            if (i2 < localTimeArr.length) {
                localTimeArr[i2] = new LocalTime(i2, 0, 0, 0);
                i2++;
            } else {
                LocalTime localTime = localTimeArr[0];
                Z2 = localTime;
                a3 = localTimeArr[12];
                X2 = localTime;
                return;
            }
        }
    }

    private LocalTime(int i2, int i4, int i5, int i6) {
        this.s = (byte) i2;
        this.X = (byte) i4;
        this.Y = (byte) i5;
        this.Z = i6;
    }

    public static LocalTime C0(long j2) {
        ChronoField.SECOND_OF_DAY.n(j2);
        int i2 = (int) (j2 / 3600);
        long j4 = j2 - ((long) (i2 * h3));
        int i4 = (int) (j4 / 60);
        return w(i2, i4, (int) (j4 - ((long) (i4 * 60))), 0);
    }

    static LocalTime D0(long j2, int i2) {
        ChronoField.SECOND_OF_DAY.n(j2);
        ChronoField.NANO_OF_SECOND.n((long) i2);
        int i4 = (int) (j2 / 3600);
        long j4 = j2 - ((long) (i4 * h3));
        int i5 = (int) (j4 / 60);
        return w(i4, i5, (int) (j4 - ((long) (i5 * 60))), i2);
    }

    public static LocalTime G0(CharSequence charSequence) {
        return K0(charSequence, DateTimeFormatter.f31801k);
    }

    public static LocalTime K0(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.j(dateTimeFormatter, "formatter");
        return (LocalTime) dateTimeFormatter.r(charSequence, b3);
    }

    public static LocalTime U() {
        return c0(Clock.g());
    }

    public static LocalTime c0(Clock clock) {
        Jdk8Methods.j(clock, "clock");
        Instant c2 = clock.c();
        long y = ((c2.y() % 86400) + ((long) clock.b().u().b(c2).F())) % 86400;
        if (y < 0) {
            y += 86400;
        }
        return D0(y, c2.z());
    }

    static LocalTime e1(DataInput dataInput) throws IOException {
        byte b2;
        int i2;
        int readByte = dataInput.readByte();
        byte b4 = 0;
        if (readByte < 0) {
            readByte = ~readByte;
            b2 = 0;
        } else {
            byte readByte2 = dataInput.readByte();
            if (readByte2 < 0) {
                int i4 = ~readByte2;
                i2 = 0;
                b4 = i4;
                b2 = 0;
            } else {
                byte readByte3 = dataInput.readByte();
                if (readByte3 < 0) {
                    b2 = ~readByte3;
                    b4 = readByte2;
                } else {
                    int readInt = dataInput.readInt();
                    b2 = readByte3;
                    byte b5 = readByte2;
                    i2 = readInt;
                    b4 = b5;
                }
            }
            return r0(readByte, b4, b2, i2);
        }
        i2 = 0;
        return r0(readByte, b4, b2, i2);
    }

    public static LocalTime h0(ZoneId zoneId) {
        return c0(Clock.f(zoneId));
    }

    private Object h1() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object j2() {
        return new Ser((byte) 5, this);
    }

    public static LocalTime k0(int i2, int i4) {
        ChronoField.HOUR_OF_DAY.n((long) i2);
        if (i4 == 0) {
            return c3[i2];
        }
        ChronoField.MINUTE_OF_HOUR.n((long) i4);
        return new LocalTime(i2, i4, 0, 0);
    }

    public static LocalTime q0(int i2, int i4, int i5) {
        ChronoField.HOUR_OF_DAY.n((long) i2);
        if ((i4 | i5) == 0) {
            return c3[i2];
        }
        ChronoField.MINUTE_OF_HOUR.n((long) i4);
        ChronoField.SECOND_OF_MINUTE.n((long) i5);
        return new LocalTime(i2, i4, i5, 0);
    }

    public static LocalTime r0(int i2, int i4, int i5, int i6) {
        ChronoField.HOUR_OF_DAY.n((long) i2);
        ChronoField.MINUTE_OF_HOUR.n((long) i4);
        ChronoField.SECOND_OF_MINUTE.n((long) i5);
        ChronoField.NANO_OF_SECOND.n((long) i6);
        return w(i2, i4, i5, i6);
    }

    public static LocalTime v0(long j2) {
        ChronoField.NANO_OF_DAY.n(j2);
        int i2 = (int) (j2 / n3);
        long j4 = j2 - (((long) i2) * n3);
        int i4 = (int) (j4 / m3);
        long j5 = j4 - (((long) i4) * m3);
        int i5 = (int) (j5 / 1000000000);
        return w(i2, i4, i5, (int) (j5 - (((long) i5) * 1000000000)));
    }

    private static LocalTime w(int i2, int i4, int i5, int i6) {
        return ((i4 | i5) | i6) == 0 ? c3[i2] : new LocalTime(i2, i4, i5, i6);
    }

    public static LocalTime y(TemporalAccessor temporalAccessor) {
        LocalTime localTime = (LocalTime) temporalAccessor.i(TemporalQueries.c());
        if (localTime != null) {
            return localTime;
        }
        throw new DateTimeException("Unable to obtain LocalTime from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
    }

    private int z(TemporalField temporalField) {
        switch (AnonymousClass2.f31776a[((ChronoField) temporalField).ordinal()]) {
            case 1:
                return this.Z;
            case 2:
                throw new DateTimeException("Field too large for an int: " + temporalField);
            case 3:
                return this.Z / 1000;
            case 4:
                throw new DateTimeException("Field too large for an int: " + temporalField);
            case 5:
                return this.Z / 1000000;
            case 6:
                return (int) (j1() / 1000000);
            case 7:
                return this.Y;
            case 8:
                return k1();
            case 9:
                return this.X;
            case 10:
                return (this.s * DocWriter.b3) + this.X;
            case 11:
                return this.s % 12;
            case 12:
                int i2 = this.s % 12;
                if (i2 % 12 == 0) {
                    return 12;
                }
                return i2;
            case 13:
                return this.s;
            case 14:
                byte b2 = this.s;
                if (b2 == 0) {
                    return 24;
                }
                return b2;
            case 15:
                return this.s / 12;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    public int A() {
        return this.Z;
    }

    public int A1() {
        return this.s;
    }

    public boolean D(LocalTime localTime) {
        return compareTo(localTime) > 0;
    }

    /* renamed from: D1 */
    public LocalTime a(TemporalField temporalField, long j2) {
        if (!(temporalField instanceof ChronoField)) {
            return (LocalTime) temporalField.e(this, j2);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.n(j2);
        switch (AnonymousClass2.f31776a[chronoField.ordinal()]) {
            case 1:
                return e2((int) j2);
            case 2:
                return v0(j2);
            case 3:
                return e2(((int) j2) * 1000);
            case 4:
                return v0(j2 * 1000);
            case 5:
                return e2(((int) j2) * 1000000);
            case 6:
                return v0(j2 * 1000000);
            case 7:
                return f2((int) j2);
            case 8:
                return d1(j2 - ((long) k1()));
            case 9:
                return T1((int) j2);
            case 10:
                return Y0(j2 - ((long) ((this.s * DocWriter.b3) + this.X)));
            case 11:
                return S0(j2 - ((long) (this.s % 12)));
            case 12:
                if (j2 == 12) {
                    j2 = 0;
                }
                return S0(j2 - ((long) (this.s % 12)));
            case 13:
                return F1((int) j2);
            case 14:
                if (j2 == 24) {
                    j2 = 0;
                }
                return F1((int) j2);
            case 15:
                return S0((j2 - ((long) (this.s / 12))) * 12);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }
    }

    public boolean E(LocalTime localTime) {
        return compareTo(localTime) < 0;
    }

    /* renamed from: F */
    public LocalTime o(long j2, TemporalUnit temporalUnit) {
        return j2 == Long.MIN_VALUE ? q(Long.MAX_VALUE, temporalUnit).q(1, temporalUnit) : q(-j2, temporalUnit);
    }

    public LocalTime F1(int i2) {
        if (this.s == i2) {
            return this;
        }
        ChronoField.HOUR_OF_DAY.n((long) i2);
        return w(i2, this.X, this.Y, this.Z);
    }

    /* renamed from: J */
    public LocalTime g(TemporalAmount temporalAmount) {
        return (LocalTime) temporalAmount.a(this);
    }

    public LocalTime K(long j2) {
        return S0(-(j2 % 24));
    }

    public LocalTime L(long j2) {
        return Y0(-(j2 % 1440));
    }

    /* renamed from: L0 */
    public LocalTime q(long j2, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (LocalTime) temporalUnit.g(this, j2);
        }
        switch (AnonymousClass2.f31777b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return c1(j2);
            case 2:
                return c1((j2 % k3) * 1000);
            case 3:
                return c1((j2 % 86400000) * 1000000);
            case 4:
                return d1(j2);
            case 5:
                return Y0(j2);
            case 6:
                return S0(j2);
            case 7:
                return S0((j2 % 2) * 12);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
    }

    public LocalTime Q(long j2) {
        return c1(-(j2 % o3));
    }

    /* renamed from: R0 */
    public LocalTime h(TemporalAmount temporalAmount) {
        return (LocalTime) temporalAmount.b(this);
    }

    public LocalTime S(long j2) {
        return d1(-(j2 % 86400));
    }

    public LocalTime S0(long j2) {
        return j2 == 0 ? this : w(((((int) (j2 % 24)) + this.s) + 24) % 24, this.X, this.Y, this.Z);
    }

    public int S1() {
        return this.Y;
    }

    public LocalTime T1(int i2) {
        if (this.X == i2) {
            return this;
        }
        ChronoField.MINUTE_OF_HOUR.n((long) i2);
        return w(this.s, i2, this.Y, this.Z);
    }

    public LocalTime Y0(long j2) {
        if (j2 == 0) {
            return this;
        }
        int i2 = (this.s * DocWriter.b3) + this.X;
        int i4 = ((((int) (j2 % 1440)) + i2) + f3) % f3;
        return i2 == i4 ? this : w(i4 / 60, i4 % 60, this.Y, this.Z);
    }

    public int b(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? z(temporalField) : super.b(temporalField);
    }

    public LocalTime c1(long j2) {
        if (j2 == 0) {
            return this;
        }
        long j1 = j1();
        long j4 = (((j2 % o3) + j1) + o3) % o3;
        return j1 == j4 ? this : w((int) (j4 / n3), (int) ((j4 / m3) % 60), (int) ((j4 / 1000000000) % 60), (int) (j4 % 1000000000));
    }

    public LocalTime d1(long j2) {
        if (j2 == 0) {
            return this;
        }
        int i2 = (this.s * 3600) + (this.X * DocWriter.b3) + this.Y;
        int i4 = ((((int) (j2 % 86400)) + i2) + i3) % i3;
        return i2 == i4 ? this : w(i4 / h3, (i4 / 60) % 60, i4 % 60, this.Z);
    }

    public Temporal e(Temporal temporal) {
        return temporal.a(ChronoField.NANO_OF_DAY, j1());
    }

    public LocalTime e2(int i2) {
        if (this.Z == i2) {
            return this;
        }
        ChronoField.NANO_OF_SECOND.n((long) i2);
        return w(this.s, this.X, this.Y, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalTime)) {
            return false;
        }
        LocalTime localTime = (LocalTime) obj;
        return this.s == localTime.s && this.X == localTime.X && this.Y == localTime.Y && this.Z == localTime.Z;
    }

    public ValueRange f(TemporalField temporalField) {
        return super.f(temporalField);
    }

    public LocalTime f2(int i2) {
        if (this.Y == i2) {
            return this;
        }
        ChronoField.SECOND_OF_MINUTE.n((long) i2);
        return w(this.s, this.X, i2, this.Z);
    }

    public int hashCode() {
        long j1 = j1();
        return (int) (j1 ^ (j1 >>> 32));
    }

    public <R> R i(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.e()) {
            return ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries.c()) {
            return this;
        }
        if (temporalQuery == TemporalQueries.a() || temporalQuery == TemporalQueries.g() || temporalQuery == TemporalQueries.f() || temporalQuery == TemporalQueries.d() || temporalQuery == TemporalQueries.b()) {
            return null;
        }
        return temporalQuery.a(this);
    }

    /* access modifiers changed from: package-private */
    public void i2(DataOutput dataOutput) throws IOException {
        byte b2;
        if (this.Z == 0) {
            if (this.Y != 0) {
                dataOutput.writeByte(this.s);
                dataOutput.writeByte(this.X);
                b2 = this.Y;
            } else if (this.X == 0) {
                b2 = this.s;
            } else {
                dataOutput.writeByte(this.s);
                b2 = this.X;
            }
            dataOutput.writeByte(~b2);
            return;
        }
        dataOutput.writeByte(this.s);
        dataOutput.writeByte(this.X);
        dataOutput.writeByte(this.Y);
        dataOutput.writeInt(this.Z);
    }

    public long j1() {
        return (((long) this.s) * n3) + (((long) this.X) * m3) + (((long) this.Y) * 1000000000) + ((long) this.Z);
    }

    public int k1() {
        return (this.s * 3600) + (this.X * DocWriter.b3) + this.Y;
    }

    public LocalTime l1(TemporalUnit temporalUnit) {
        if (temporalUnit == ChronoUnit.NANOS) {
            return this;
        }
        Duration Q = temporalUnit.Q();
        if (Q.o() <= 86400) {
            long m0 = Q.m0();
            if (o3 % m0 == 0) {
                return v0((j1() / m0) * m0);
            }
            throw new DateTimeException("Unit must divide into a standard day without remainder");
        }
        throw new DateTimeException("Unit is too large to be used for truncation");
    }

    public boolean m(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField.b();
        }
        return temporalField != null && temporalField.c(this);
    }

    public boolean n(TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            return temporalUnit.b();
        }
        return temporalUnit != null && temporalUnit.f(this);
    }

    public long p(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.j(this);
        }
        if (temporalField == ChronoField.NANO_OF_DAY) {
            return j1();
        }
        return temporalField == ChronoField.MICRO_OF_DAY ? j1() / 1000 : (long) z(temporalField);
    }

    public long r(Temporal temporal, TemporalUnit temporalUnit) {
        long j2;
        LocalTime y = y(temporal);
        if (!(temporalUnit instanceof ChronoUnit)) {
            return temporalUnit.e(this, y);
        }
        long j1 = y.j1() - j1();
        switch (AnonymousClass2.f31777b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return j1;
            case 2:
                j2 = 1000;
                break;
            case 3:
                j2 = 1000000;
                break;
            case 4:
                j2 = 1000000000;
                break;
            case 5:
                j2 = m3;
                break;
            case 6:
                j2 = n3;
                break;
            case 7:
                j2 = 43200000000000L;
                break;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + temporalUnit);
        }
        return j1 / j2;
    }

    public LocalDateTime s(LocalDate localDate) {
        return LocalDateTime.p2(localDate, this);
    }

    public String toString() {
        int i2;
        StringBuilder sb = new StringBuilder(18);
        byte b2 = this.s;
        byte b4 = this.X;
        byte b5 = this.Y;
        int i4 = this.Z;
        sb.append(b2 < 10 ? "0" : "");
        sb.append(b2);
        String str = ":";
        sb.append(b4 < 10 ? ":0" : str);
        sb.append(b4);
        if (b5 > 0 || i4 > 0) {
            if (b5 < 10) {
                str = ":0";
            }
            sb.append(str);
            sb.append(b5);
            if (i4 > 0) {
                sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                int i5 = 1000000;
                if (i4 % 1000000 == 0) {
                    i2 = (i4 / 1000000) + 1000;
                } else {
                    if (i4 % 1000 == 0) {
                        i4 /= 1000;
                    } else {
                        i5 = Utils.f17347a;
                    }
                    i2 = i4 + i5;
                }
                sb.append(Integer.toString(i2).substring(1));
            }
        }
        return sb.toString();
    }

    public OffsetTime u(ZoneOffset zoneOffset) {
        return OffsetTime.k0(this, zoneOffset);
    }

    /* renamed from: v */
    public int compareTo(LocalTime localTime) {
        int a2 = Jdk8Methods.a(this.s, localTime.s);
        if (a2 != 0) {
            return a2;
        }
        int a4 = Jdk8Methods.a(this.X, localTime.X);
        if (a4 != 0) {
            return a4;
        }
        int a5 = Jdk8Methods.a(this.Y, localTime.Y);
        return a5 == 0 ? Jdk8Methods.a(this.Z, localTime.Z) : a5;
    }

    /* renamed from: w1 */
    public LocalTime l(TemporalAdjuster temporalAdjuster) {
        return temporalAdjuster instanceof LocalTime ? (LocalTime) temporalAdjuster : (LocalTime) temporalAdjuster.e(this);
    }

    public String x(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.j(dateTimeFormatter, "formatter");
        return dateTimeFormatter.d(this);
    }

    public int y0() {
        return this.X;
    }
}
