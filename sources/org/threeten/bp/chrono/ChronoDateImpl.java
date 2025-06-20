package org.threeten.bp.chrono;

import java.io.Serializable;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalUnit;

abstract class ChronoDateImpl<D extends ChronoLocalDate> extends ChronoLocalDate implements Temporal, TemporalAdjuster, Serializable {
    private static final long X = 6282433883239719096L;

    /* renamed from: org.threeten.bp.chrono.ChronoDateImpl$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31787a;

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
                f31787a = r0
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.DAYS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31787a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.WEEKS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31787a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.MONTHS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f31787a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.YEARS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f31787a     // Catch:{ NoSuchFieldError -> 0x003e }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.DECADES     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f31787a     // Catch:{ NoSuchFieldError -> 0x0049 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.CENTURIES     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f31787a     // Catch:{ NoSuchFieldError -> 0x0054 }
                org.threeten.bp.temporal.ChronoUnit r1 = org.threeten.bp.temporal.ChronoUnit.MILLENNIA     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.ChronoDateImpl.AnonymousClass1.<clinit>():void");
        }
    }

    ChronoDateImpl() {
    }

    /* access modifiers changed from: package-private */
    public ChronoDateImpl<D> C0(long j2) {
        return j2 == Long.MIN_VALUE ? R0(Long.MAX_VALUE).R0(1) : R0(-j2);
    }

    /* access modifiers changed from: package-private */
    public ChronoDateImpl<D> D0(long j2) {
        return j2 == Long.MIN_VALUE ? S0(Long.MAX_VALUE).S0(1) : S0(-j2);
    }

    /* renamed from: G0 */
    public ChronoDateImpl<D> q(long j2, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (ChronoDateImpl) x().l(temporalUnit.g(this, j2));
        }
        switch (AnonymousClass1.f31787a[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return K0(j2);
            case 2:
                return K0(Jdk8Methods.n(j2, 7));
            case 3:
                return L0(j2);
            case 4:
                return S0(j2);
            case 5:
                return S0(Jdk8Methods.n(j2, 10));
            case 6:
                return S0(Jdk8Methods.n(j2, 100));
            case 7:
                return S0(Jdk8Methods.n(j2, 1000));
            default:
                throw new DateTimeException(temporalUnit + " not valid for chronology " + x().v());
        }
    }

    /* access modifiers changed from: package-private */
    public abstract ChronoDateImpl<D> K0(long j2);

    /* access modifiers changed from: package-private */
    public abstract ChronoDateImpl<D> L0(long j2);

    /* access modifiers changed from: package-private */
    public ChronoDateImpl<D> R0(long j2) {
        return K0(Jdk8Methods.n(j2, 7));
    }

    /* access modifiers changed from: package-private */
    public abstract ChronoDateImpl<D> S0(long j2);

    public ChronoPeriod h0(ChronoLocalDate chronoLocalDate) {
        throw new UnsupportedOperationException("Not supported in ThreeTen backport");
    }

    public long r(Temporal temporal, TemporalUnit temporalUnit) {
        ChronoLocalDate e2 = x().e(temporal);
        return temporalUnit instanceof ChronoUnit ? LocalDate.c1(this).r(e2, temporalUnit) : temporalUnit.e(this, e2);
    }

    /* access modifiers changed from: package-private */
    public ChronoDateImpl<D> r0(long j2) {
        return j2 == Long.MIN_VALUE ? K0(Long.MAX_VALUE).K0(1) : K0(-j2);
    }

    public ChronoLocalDateTime<?> s(LocalTime localTime) {
        return ChronoLocalDateTimeImpl.k0(this, localTime);
    }

    /* access modifiers changed from: package-private */
    public ChronoDateImpl<D> v0(long j2) {
        return j2 == Long.MIN_VALUE ? L0(Long.MAX_VALUE).L0(1) : L0(-j2);
    }
}
