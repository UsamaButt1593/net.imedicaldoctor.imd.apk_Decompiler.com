package org.threeten.bp.chrono;

import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import com.itextpdf.tool.xml.html.HTML;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.ValueRange;

final class ChronoLocalDateTimeImpl<D extends ChronoLocalDate> extends ChronoLocalDateTime<D> implements Temporal, TemporalAdjuster, Serializable {
    private static final int X2 = 24;
    private static final int Y2 = 60;
    private static final long Z = 4556003607393004514L;
    private static final int Z2 = 1440;
    private static final int a3 = 60;
    private static final int b3 = 3600;
    private static final int c3 = 86400;
    private static final long d3 = 86400000;
    private static final long e3 = 86400000000L;
    private static final long f3 = 1000000000;
    private static final long g3 = 60000000000L;
    private static final long h3 = 3600000000000L;
    private static final long i3 = 86400000000000L;
    private final D X;
    private final LocalTime Y;

    /* renamed from: org.threeten.bp.chrono.ChronoLocalDateTimeImpl$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31788a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.threeten.bp.temporal.ChronoUnit[] r0 = org.threeten.bp.temporal.ChronoUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31788a = r0
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.NANOS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31788a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.MICROS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31788a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.MILLIS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f31788a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.SECONDS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f31788a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.MINUTES     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f31788a     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.HOURS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f31788a     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.HALF_DAYS     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.ChronoLocalDateTimeImpl.AnonymousClass1.<clinit>():void");
        }
    }

    private ChronoLocalDateTimeImpl(D d2, LocalTime localTime) {
        Jdk8Methods.j(d2, DublinCoreProperties.f27398d);
        Jdk8Methods.j(localTime, HTML.Tag.P0);
        this.X = d2;
        this.Y = localTime;
    }

    private ChronoLocalDateTimeImpl<D> C0(long j2) {
        return K0(this.X, 0, j2, 0, 0);
    }

    private ChronoLocalDateTimeImpl<D> D0(long j2) {
        return K0(this.X, 0, 0, 0, j2);
    }

    private ChronoLocalDateTimeImpl<D> K0(D d2, long j2, long j3, long j4, long j5) {
        LocalTime v0;
        D d4 = d2;
        if ((j2 | j3 | j4 | j5) == 0) {
            v0 = this.Y;
        } else {
            long j6 = (j5 / i3) + (j4 / 86400) + (j3 / 1440) + (j2 / 24);
            long j7 = (j5 % i3) + ((j4 % 86400) * 1000000000) + ((j3 % 1440) * g3) + ((j2 % 24) * h3);
            long j1 = this.Y.j1();
            long j8 = j7 + j1;
            long e2 = j6 + Jdk8Methods.e(j8, i3);
            long h2 = Jdk8Methods.h(j8, i3);
            v0 = h2 == j1 ? this.Y : LocalTime.v0(h2);
            d4 = d4.q(e2, ChronoUnit.DAYS);
        }
        return R0(d4, v0);
    }

    static ChronoLocalDateTime<?> L0(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        return ((ChronoLocalDate) objectInput.readObject()).s((LocalTime) objectInput.readObject());
    }

    private ChronoLocalDateTimeImpl<D> R0(Temporal temporal, LocalTime localTime) {
        D d2 = this.X;
        return (d2 == temporal && this.Y == localTime) ? this : new ChronoLocalDateTimeImpl<>(d2.x().l(temporal), localTime);
    }

    private Object c1() {
        return new Ser((byte) 12, this);
    }

    static <R extends ChronoLocalDate> ChronoLocalDateTimeImpl<R> k0(R r, LocalTime localTime) {
        return new ChronoLocalDateTimeImpl<>(r, localTime);
    }

    private ChronoLocalDateTimeImpl<D> r0(long j2) {
        return R0(this.X.q(j2, ChronoUnit.DAYS), this.Y);
    }

    private ChronoLocalDateTimeImpl<D> v0(long j2) {
        return K0(this.X, j2, 0, 0, 0);
    }

    /* access modifiers changed from: package-private */
    public ChronoLocalDateTimeImpl<D> G0(long j2) {
        return K0(this.X, 0, 0, j2, 0);
    }

    public D S() {
        return this.X;
    }

    /* renamed from: S0 */
    public ChronoLocalDateTimeImpl<D> l(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof ChronoLocalDate) {
            return R0((ChronoLocalDate) temporalAdjuster, this.Y);
        }
        if (temporalAdjuster instanceof LocalTime) {
            return R0(this.X, (LocalTime) temporalAdjuster);
        }
        return temporalAdjuster instanceof ChronoLocalDateTimeImpl ? this.X.x().m((ChronoLocalDateTimeImpl) temporalAdjuster) : this.X.x().m((ChronoLocalDateTimeImpl) temporalAdjuster.e(this));
    }

    public LocalTime U() {
        return this.Y;
    }

    /* renamed from: Y0 */
    public ChronoLocalDateTimeImpl<D> h0(TemporalField temporalField, long j2) {
        if (temporalField instanceof ChronoField) {
            return temporalField.b() ? R0(this.X, this.Y.a(temporalField, j2)) : R0(this.X.a(temporalField, j2), this.Y);
        }
        return this.X.x().m(temporalField.e(this, j2));
    }

    public int b(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField.b() ? this.Y.b(temporalField) : this.X.b(temporalField);
        }
        return f(temporalField).a(p(temporalField), temporalField);
    }

    public ValueRange f(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField.b() ? this.Y.f(temporalField) : this.X.f(temporalField);
        }
        return temporalField.f(this);
    }

    public boolean m(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField.a() || temporalField.b() : temporalField != null && temporalField.c(this);
    }

    public boolean n(TemporalUnit temporalUnit) {
        return temporalUnit instanceof ChronoUnit ? temporalUnit.a() || temporalUnit.b() : temporalUnit != null && temporalUnit.f(this);
    }

    public long p(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField.b() ? this.Y.p(temporalField) : this.X.p(temporalField);
        }
        return temporalField.j(this);
    }

    /* renamed from: q0 */
    public ChronoLocalDateTimeImpl<D> q(long j2, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return this.X.x().m(temporalUnit.g(this, j2));
        }
        switch (AnonymousClass1.f31788a[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return D0(j2);
            case 2:
                return r0(j2 / e3).D0((j2 % e3) * 1000);
            case 3:
                return r0(j2 / 86400000).D0((j2 % 86400000) * 1000000);
            case 4:
                return G0(j2);
            case 5:
                return C0(j2);
            case 6:
                return v0(j2);
            case 7:
                return r0(j2 / 256).v0((j2 % 256) * 12);
            default:
                return R0(this.X.q(j2, temporalUnit), this.Y);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0045, code lost:
        r2 = org.threeten.bp.jdk8.Jdk8Methods.o(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0033, code lost:
        r2 = org.threeten.bp.jdk8.Jdk8Methods.n(r2, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long r(org.threeten.bp.temporal.Temporal r7, org.threeten.bp.temporal.TemporalUnit r8) {
        /*
            r6 = this;
            org.threeten.bp.chrono.ChronoLocalDate r0 = r6.S()
            org.threeten.bp.chrono.Chronology r0 = r0.x()
            org.threeten.bp.chrono.ChronoLocalDateTime r7 = r0.y(r7)
            boolean r0 = r8 instanceof org.threeten.bp.temporal.ChronoUnit
            if (r0 == 0) goto L_0x0084
            r0 = r8
            org.threeten.bp.temporal.ChronoUnit r0 = (org.threeten.bp.temporal.ChronoUnit) r0
            boolean r1 = r0.b()
            if (r1 == 0) goto L_0x0065
            org.threeten.bp.temporal.ChronoField r1 = org.threeten.bp.temporal.ChronoField.EPOCH_DAY
            long r2 = r7.p(r1)
            D r4 = r6.X
            long r4 = r4.p(r1)
            long r2 = r2 - r4
            int[] r1 = org.threeten.bp.chrono.ChronoLocalDateTimeImpl.AnonymousClass1.f31788a
            int r0 = r0.ordinal()
            r0 = r1[r0]
            switch(r0) {
                case 1: goto L_0x0050;
                case 2: goto L_0x004a;
                case 3: goto L_0x0042;
                case 4: goto L_0x003e;
                case 5: goto L_0x003b;
                case 6: goto L_0x0038;
                case 7: goto L_0x0032;
                default: goto L_0x0031;
            }
        L_0x0031:
            goto L_0x0056
        L_0x0032:
            r0 = 2
        L_0x0033:
            long r2 = org.threeten.bp.jdk8.Jdk8Methods.n(r2, r0)
            goto L_0x0056
        L_0x0038:
            r0 = 24
            goto L_0x0033
        L_0x003b:
            r0 = 1440(0x5a0, float:2.018E-42)
            goto L_0x0033
        L_0x003e:
            r0 = 86400(0x15180, float:1.21072E-40)
            goto L_0x0033
        L_0x0042:
            r0 = 86400000(0x5265c00, double:4.2687272E-316)
        L_0x0045:
            long r2 = org.threeten.bp.jdk8.Jdk8Methods.o(r2, r0)
            goto L_0x0056
        L_0x004a:
            r0 = 86400000000(0x141dd76000, double:4.26872718007E-313)
            goto L_0x0045
        L_0x0050:
            r0 = 86400000000000(0x4e94914f0000, double:4.26872718006837E-310)
            goto L_0x0045
        L_0x0056:
            org.threeten.bp.LocalTime r0 = r6.Y
            org.threeten.bp.LocalTime r7 = r7.U()
            long r7 = r0.r(r7, r8)
            long r7 = org.threeten.bp.jdk8.Jdk8Methods.l(r2, r7)
            return r7
        L_0x0065:
            org.threeten.bp.chrono.ChronoLocalDate r0 = r7.S()
            org.threeten.bp.LocalTime r7 = r7.U()
            org.threeten.bp.LocalTime r1 = r6.Y
            boolean r7 = r7.E(r1)
            if (r7 == 0) goto L_0x007d
            r1 = 1
            org.threeten.bp.temporal.ChronoUnit r7 = org.threeten.bp.temporal.ChronoUnit.DAYS
            org.threeten.bp.chrono.ChronoLocalDate r0 = r0.o(r1, r7)
        L_0x007d:
            D r7 = r6.X
            long r7 = r7.r(r0, r8)
            return r7
        L_0x0084:
            long r7 = r8.e(r6, r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.ChronoLocalDateTimeImpl.r(org.threeten.bp.temporal.Temporal, org.threeten.bp.temporal.TemporalUnit):long");
    }

    public ChronoZonedDateTime<D> s(ZoneId zoneId) {
        return ChronoZonedDateTimeImpl.K0(this, zoneId, (ZoneOffset) null);
    }

    /* access modifiers changed from: package-private */
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(this.X);
        objectOutput.writeObject(this.Y);
    }
}
