package org.threeten.bp.temporal;

import org.threeten.bp.DayOfWeek;
import org.threeten.bp.jdk8.Jdk8Methods;

public final class TemporalAdjusters {

    private static final class DayOfWeekInMonth implements TemporalAdjuster {
        private final int X;
        private final int s;

        private DayOfWeekInMonth(int i2, DayOfWeek dayOfWeek) {
            this.s = i2;
            this.X = dayOfWeek.getValue();
        }

        public Temporal e(Temporal temporal) {
            Temporal a2;
            long j2;
            if (this.s >= 0) {
                a2 = temporal.a(ChronoField.DAY_OF_MONTH, 1);
                j2 = ((long) (((this.X - a2.b(ChronoField.DAY_OF_WEEK)) + 7) % 7)) + ((((long) this.s) - 1) * 7);
            } else {
                ChronoField chronoField = ChronoField.DAY_OF_MONTH;
                a2 = temporal.a(chronoField, temporal.f(chronoField).d());
                int b2 = this.X - a2.b(ChronoField.DAY_OF_WEEK);
                if (b2 == 0) {
                    b2 = 0;
                } else if (b2 > 0) {
                    b2 -= 7;
                }
                j2 = ((long) b2) - ((((long) (-this.s)) - 1) * 7);
            }
            return a2.q((long) ((int) j2), ChronoUnit.DAYS);
        }
    }

    private static class Impl implements TemporalAdjuster {
        /* access modifiers changed from: private */
        public static final Impl X = new Impl(0);
        /* access modifiers changed from: private */
        public static final Impl X2 = new Impl(3);
        /* access modifiers changed from: private */
        public static final Impl Y = new Impl(1);
        /* access modifiers changed from: private */
        public static final Impl Y2 = new Impl(4);
        /* access modifiers changed from: private */
        public static final Impl Z = new Impl(2);
        /* access modifiers changed from: private */
        public static final Impl Z2 = new Impl(5);
        private final int s;

        private Impl(int i2) {
            this.s = i2;
        }

        public Temporal e(Temporal temporal) {
            int i2 = this.s;
            if (i2 == 0) {
                return temporal.a(ChronoField.DAY_OF_MONTH, 1);
            }
            if (i2 == 1) {
                ChronoField chronoField = ChronoField.DAY_OF_MONTH;
                return temporal.a(chronoField, temporal.f(chronoField).d());
            } else if (i2 == 2) {
                return temporal.a(ChronoField.DAY_OF_MONTH, 1).q(1, ChronoUnit.MONTHS);
            } else {
                if (i2 == 3) {
                    return temporal.a(ChronoField.DAY_OF_YEAR, 1);
                }
                if (i2 == 4) {
                    ChronoField chronoField2 = ChronoField.DAY_OF_YEAR;
                    return temporal.a(chronoField2, temporal.f(chronoField2).d());
                } else if (i2 == 5) {
                    return temporal.a(ChronoField.DAY_OF_YEAR, 1).q(1, ChronoUnit.YEARS);
                } else {
                    throw new IllegalStateException("Unreachable");
                }
            }
        }
    }

    private static final class RelativeDayOfWeek implements TemporalAdjuster {
        private final int X;
        private final int s;

        private RelativeDayOfWeek(int i2, DayOfWeek dayOfWeek) {
            Jdk8Methods.j(dayOfWeek, "dayOfWeek");
            this.s = i2;
            this.X = dayOfWeek.getValue();
        }

        public Temporal e(Temporal temporal) {
            int b2 = temporal.b(ChronoField.DAY_OF_WEEK);
            int i2 = this.s;
            if (i2 < 2 && b2 == this.X) {
                return temporal;
            }
            if ((i2 & 1) == 0) {
                int i3 = b2 - this.X;
                return temporal.q((long) (i3 >= 0 ? 7 - i3 : -i3), ChronoUnit.DAYS);
            }
            int i4 = this.X - b2;
            return temporal.o((long) (i4 >= 0 ? 7 - i4 : -i4), ChronoUnit.DAYS);
        }
    }

    private TemporalAdjusters() {
    }

    public static TemporalAdjuster a(int i2, DayOfWeek dayOfWeek) {
        Jdk8Methods.j(dayOfWeek, "dayOfWeek");
        return new DayOfWeekInMonth(i2, dayOfWeek);
    }

    public static TemporalAdjuster b() {
        return Impl.X;
    }

    public static TemporalAdjuster c() {
        return Impl.Z;
    }

    public static TemporalAdjuster d() {
        return Impl.Z2;
    }

    public static TemporalAdjuster e() {
        return Impl.X2;
    }

    public static TemporalAdjuster f(DayOfWeek dayOfWeek) {
        Jdk8Methods.j(dayOfWeek, "dayOfWeek");
        return new DayOfWeekInMonth(1, dayOfWeek);
    }

    public static TemporalAdjuster g() {
        return Impl.Y;
    }

    public static TemporalAdjuster h() {
        return Impl.Y2;
    }

    public static TemporalAdjuster i(DayOfWeek dayOfWeek) {
        Jdk8Methods.j(dayOfWeek, "dayOfWeek");
        return new DayOfWeekInMonth(-1, dayOfWeek);
    }

    public static TemporalAdjuster j(DayOfWeek dayOfWeek) {
        return new RelativeDayOfWeek(2, dayOfWeek);
    }

    public static TemporalAdjuster k(DayOfWeek dayOfWeek) {
        return new RelativeDayOfWeek(0, dayOfWeek);
    }

    public static TemporalAdjuster l(DayOfWeek dayOfWeek) {
        return new RelativeDayOfWeek(3, dayOfWeek);
    }

    public static TemporalAdjuster m(DayOfWeek dayOfWeek) {
        return new RelativeDayOfWeek(1, dayOfWeek);
    }
}
