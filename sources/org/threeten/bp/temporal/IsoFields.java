package org.threeten.bp.temporal;

import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.util.Locale;
import java.util.Map;
import net.imedicaldoctor.imd.BuildConfig;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;

public final class IsoFields {

    /* renamed from: a  reason: collision with root package name */
    public static final TemporalField f31852a = Field.DAY_OF_QUARTER;

    /* renamed from: b  reason: collision with root package name */
    public static final TemporalField f31853b = Field.QUARTER_OF_YEAR;

    /* renamed from: c  reason: collision with root package name */
    public static final TemporalField f31854c = Field.WEEK_OF_WEEK_BASED_YEAR;

    /* renamed from: d  reason: collision with root package name */
    public static final TemporalField f31855d = Field.WEEK_BASED_YEAR;

    /* renamed from: e  reason: collision with root package name */
    public static final TemporalUnit f31856e = Unit.WEEK_BASED_YEARS;

    /* renamed from: f  reason: collision with root package name */
    public static final TemporalUnit f31857f = Unit.QUARTER_YEARS;

    /* renamed from: org.threeten.bp.temporal.IsoFields$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31858a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.threeten.bp.temporal.IsoFields$Unit[] r0 = org.threeten.bp.temporal.IsoFields.Unit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31858a = r0
                org.threeten.bp.temporal.IsoFields$Unit r1 = org.threeten.bp.temporal.IsoFields.Unit.WEEK_BASED_YEARS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31858a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.temporal.IsoFields$Unit r1 = org.threeten.bp.temporal.IsoFields.Unit.QUARTER_YEARS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.temporal.IsoFields.AnonymousClass1.<clinit>():void");
        }
    }

    private enum Field implements TemporalField {
        DAY_OF_QUARTER {
            public boolean c(TemporalAccessor temporalAccessor) {
                return temporalAccessor.m(ChronoField.DAY_OF_YEAR) && temporalAccessor.m(ChronoField.MONTH_OF_YEAR) && temporalAccessor.m(ChronoField.YEAR) && Field.x(temporalAccessor);
            }

            public <R extends Temporal> R e(R r, long j2) {
                long j3 = j(r);
                h().b(j2, this);
                ChronoField chronoField = ChronoField.DAY_OF_YEAR;
                return r.a(chronoField, r.p(chronoField) + (j2 - j3));
            }

            public ValueRange f(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.m(this)) {
                    long p = temporalAccessor.p(Field.QUARTER_OF_YEAR);
                    if (p == 1) {
                        return IsoChronology.X2.x(temporalAccessor.p(ChronoField.YEAR)) ? ValueRange.k(1, 91) : ValueRange.k(1, 90);
                    } else if (p == 2) {
                        return ValueRange.k(1, 91);
                    } else {
                        return (p == 3 || p == 4) ? ValueRange.k(1, 92) : h();
                    }
                } else {
                    throw new UnsupportedTemporalTypeException("Unsupported field: DayOfQuarter");
                }
            }

            public TemporalUnit g() {
                return ChronoUnit.DAYS;
            }

            public ValueRange h() {
                return ValueRange.l(1, 90, 92);
            }

            public TemporalUnit i() {
                return IsoFields.f31857f;
            }

            public long j(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.m(this)) {
                    return (long) (temporalAccessor.b(ChronoField.DAY_OF_YEAR) - Field.X2[((temporalAccessor.b(ChronoField.MONTH_OF_YEAR) - 1) / 3) + (IsoChronology.X2.x(temporalAccessor.p(ChronoField.YEAR)) ? 4 : 0)]);
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: DayOfQuarter");
            }

            public TemporalAccessor l(Map<TemporalField, Long> map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
                LocalDate localDate;
                ValueRange h2;
                ChronoField chronoField = ChronoField.YEAR;
                Long l2 = map.get(chronoField);
                Field field = Field.QUARTER_OF_YEAR;
                Long l3 = map.get(field);
                if (l2 == null || l3 == null) {
                    return null;
                }
                int m2 = chronoField.m(l2.longValue());
                long longValue = map.get(Field.DAY_OF_QUARTER).longValue();
                if (resolverStyle == ResolverStyle.LENIENT) {
                    localDate = LocalDate.r2(m2, 1, 1).L2(Jdk8Methods.n(Jdk8Methods.q(l3.longValue(), 1), 3)).J2(Jdk8Methods.q(longValue, 1));
                } else {
                    int a2 = field.h().a(l3.longValue(), field);
                    if (resolverStyle == ResolverStyle.STRICT) {
                        int i2 = 91;
                        if (a2 == 1) {
                            if (!IsoChronology.X2.x((long) m2)) {
                                i2 = 90;
                            }
                        } else if (a2 != 2) {
                            i2 = 92;
                        }
                        h2 = ValueRange.k(1, (long) i2);
                    } else {
                        h2 = h();
                    }
                    h2.b(longValue, this);
                    localDate = LocalDate.r2(m2, ((a2 - 1) * 3) + 1, 1).J2(longValue - 1);
                }
                map.remove(this);
                map.remove(chronoField);
                map.remove(field);
                return localDate;
            }

            public String toString() {
                return "DayOfQuarter";
            }
        },
        QUARTER_OF_YEAR {
            public boolean c(TemporalAccessor temporalAccessor) {
                return temporalAccessor.m(ChronoField.MONTH_OF_YEAR) && Field.x(temporalAccessor);
            }

            public <R extends Temporal> R e(R r, long j2) {
                long j3 = j(r);
                h().b(j2, this);
                ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
                return r.a(chronoField, r.p(chronoField) + ((j2 - j3) * 3));
            }

            public ValueRange f(TemporalAccessor temporalAccessor) {
                return h();
            }

            public TemporalUnit g() {
                return IsoFields.f31857f;
            }

            public ValueRange h() {
                return ValueRange.k(1, 4);
            }

            public TemporalUnit i() {
                return ChronoUnit.YEARS;
            }

            public long j(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.m(this)) {
                    return (temporalAccessor.p(ChronoField.MONTH_OF_YEAR) + 2) / 3;
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: QuarterOfYear");
            }

            public String toString() {
                return "QuarterOfYear";
            }
        },
        WEEK_OF_WEEK_BASED_YEAR {
            public boolean c(TemporalAccessor temporalAccessor) {
                return temporalAccessor.m(ChronoField.EPOCH_DAY) && Field.x(temporalAccessor);
            }

            public <R extends Temporal> R e(R r, long j2) {
                h().b(j2, this);
                return r.q(Jdk8Methods.q(j2, j(r)), ChronoUnit.WEEKS);
            }

            public ValueRange f(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.m(this)) {
                    return Field.w(LocalDate.c1(temporalAccessor));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekOfWeekBasedYear");
            }

            public TemporalUnit g() {
                return ChronoUnit.WEEKS;
            }

            public ValueRange h() {
                return ValueRange.l(1, 52, 53);
            }

            public TemporalUnit i() {
                return IsoFields.f31856e;
            }

            public long j(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.m(this)) {
                    return (long) Field.s(LocalDate.c1(temporalAccessor));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekOfWeekBasedYear");
            }

            public String k(Locale locale) {
                Jdk8Methods.j(locale, "locale");
                return "Week";
            }

            public TemporalAccessor l(Map<TemporalField, Long> map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
                Field field;
                LocalDate localDate;
                long j2;
                Map<TemporalField, Long> map2 = map;
                ResolverStyle resolverStyle2 = resolverStyle;
                Field field2 = Field.WEEK_BASED_YEAR;
                Long l2 = map2.get(field2);
                ChronoField chronoField = ChronoField.DAY_OF_WEEK;
                Long l3 = map2.get(chronoField);
                if (l2 == null || l3 == null) {
                    return null;
                }
                int a2 = field2.h().a(l2.longValue(), field2);
                long longValue = map2.get(Field.WEEK_OF_WEEK_BASED_YEAR).longValue();
                if (resolverStyle2 == ResolverStyle.LENIENT) {
                    long longValue2 = l3.longValue();
                    if (longValue2 > 7) {
                        long j3 = longValue2 - 1;
                        j2 = j3 / 7;
                        longValue2 = (j3 % 7) + 1;
                    } else if (longValue2 < 1) {
                        j2 = (longValue2 / 7) - 1;
                        longValue2 = (longValue2 % 7) + 7;
                    } else {
                        j2 = 0;
                    }
                    field = field2;
                    localDate = LocalDate.r2(a2, 1, 4).M2(longValue - 1).M2(j2).q0(chronoField, longValue2);
                } else {
                    field = field2;
                    int m2 = chronoField.m(l3.longValue());
                    (resolverStyle2 == ResolverStyle.STRICT ? Field.w(LocalDate.r2(a2, 1, 4)) : h()).b(longValue, this);
                    localDate = LocalDate.r2(a2, 1, 4).M2(longValue - 1).q0(chronoField, (long) m2);
                }
                map2.remove(this);
                map2.remove(field);
                map2.remove(chronoField);
                return localDate;
            }

            public String toString() {
                return "WeekOfWeekBasedYear";
            }
        },
        WEEK_BASED_YEAR {
            public boolean c(TemporalAccessor temporalAccessor) {
                return temporalAccessor.m(ChronoField.EPOCH_DAY) && Field.x(temporalAccessor);
            }

            public <R extends Temporal> R e(R r, long j2) {
                if (c(r)) {
                    int a2 = h().a(j2, Field.WEEK_BASED_YEAR);
                    LocalDate c1 = LocalDate.c1(r);
                    ChronoField chronoField = ChronoField.DAY_OF_WEEK;
                    int b2 = c1.b(chronoField);
                    int p = Field.s(c1);
                    if (p == 53 && Field.v(a2) == 52) {
                        p = 52;
                    }
                    LocalDate r2 = LocalDate.r2(a2, 1, 4);
                    return r.l(r2.J2((long) ((b2 - r2.b(chronoField)) + ((p - 1) * 7))));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
            }

            public ValueRange f(TemporalAccessor temporalAccessor) {
                return ChronoField.YEAR.h();
            }

            public TemporalUnit g() {
                return IsoFields.f31856e;
            }

            public ValueRange h() {
                return ChronoField.YEAR.h();
            }

            public TemporalUnit i() {
                return ChronoUnit.FOREVER;
            }

            public long j(TemporalAccessor temporalAccessor) {
                if (temporalAccessor.m(this)) {
                    return (long) Field.u(LocalDate.c1(temporalAccessor));
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: WeekBasedYear");
            }

            public String toString() {
                return "WeekBasedYear";
            }
        };
        
        /* access modifiers changed from: private */
        public static final int[] X2 = null;

        static {
            X2 = new int[]{0, 90, 181, TIFFConstants.h0, 0, 91, 182, TIFFConstants.i0};
        }

        /* access modifiers changed from: private */
        public static int s(LocalDate localDate) {
            int ordinal = localDate.j1().ordinal();
            int k1 = localDate.k1() - 1;
            int i2 = (3 - ordinal) + k1;
            int i3 = i2 - ((i2 / 7) * 7);
            int i4 = i3 - 3;
            if (i4 < -3) {
                i4 = i3 + 4;
            }
            if (k1 < i4) {
                return (int) w(localDate.X2(BuildConfig.f29478d).j2(1)).d();
            }
            int i5 = ((k1 - i4) / 7) + 1;
            if (i5 != 53 || i4 == -3 || (i4 == -2 && localDate.E())) {
                return i5;
            }
            return 1;
        }

        /* access modifiers changed from: private */
        public static int u(LocalDate localDate) {
            int M0 = localDate.M0();
            int k1 = localDate.k1();
            if (k1 <= 3) {
                return k1 - localDate.j1().ordinal() < -2 ? M0 - 1 : M0;
            }
            if (k1 < 363) {
                return M0;
            }
            return ((k1 - 363) - (localDate.E() ? 1 : 0)) - localDate.j1().ordinal() >= 0 ? M0 + 1 : M0;
        }

        /* access modifiers changed from: private */
        public static int v(int i2) {
            LocalDate r2 = LocalDate.r2(i2, 1, 1);
            if (r2.j1() != DayOfWeek.THURSDAY) {
                return (r2.j1() != DayOfWeek.WEDNESDAY || !r2.E()) ? 52 : 53;
            }
            return 53;
        }

        /* access modifiers changed from: private */
        public static ValueRange w(LocalDate localDate) {
            return ValueRange.k(1, (long) v(u(localDate)));
        }

        /* access modifiers changed from: private */
        public static boolean x(TemporalAccessor temporalAccessor) {
            return Chronology.q(temporalAccessor).equals(IsoChronology.X2);
        }

        public boolean a() {
            return true;
        }

        public boolean b() {
            return false;
        }

        public String k(Locale locale) {
            Jdk8Methods.j(locale, "locale");
            return toString();
        }

        public TemporalAccessor l(Map<TemporalField, Long> map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
            return null;
        }
    }

    private enum Unit implements TemporalUnit {
        WEEK_BASED_YEARS("WeekBasedYears", Duration.K(31556952)),
        QUARTER_YEARS("QuarterYears", Duration.K(7889238));
        
        private final Duration X;
        private final String s;

        private Unit(String str, Duration duration) {
            this.s = str;
            this.X = duration;
        }

        public Duration Q() {
            return this.X;
        }

        public boolean a() {
            return true;
        }

        public boolean b() {
            return false;
        }

        public boolean c() {
            return true;
        }

        public long e(Temporal temporal, Temporal temporal2) {
            int i2 = AnonymousClass1.f31858a[ordinal()];
            if (i2 == 1) {
                TemporalField temporalField = IsoFields.f31855d;
                return Jdk8Methods.q(temporal2.p(temporalField), temporal.p(temporalField));
            } else if (i2 == 2) {
                return temporal.r(temporal2, ChronoUnit.MONTHS) / 3;
            } else {
                throw new IllegalStateException("Unreachable");
            }
        }

        public boolean f(Temporal temporal) {
            return temporal.m(ChronoField.EPOCH_DAY);
        }

        public <R extends Temporal> R g(R r, long j2) {
            int i2 = AnonymousClass1.f31858a[ordinal()];
            if (i2 == 1) {
                TemporalField temporalField = IsoFields.f31855d;
                return r.a(temporalField, Jdk8Methods.l((long) r.b(temporalField), j2));
            } else if (i2 == 2) {
                return r.q(j2 / 256, ChronoUnit.YEARS).q((j2 % 256) * 3, ChronoUnit.MONTHS);
            } else {
                throw new IllegalStateException("Unreachable");
            }
        }

        public String toString() {
            return this.s;
        }
    }

    private IsoFields() {
        throw new AssertionError("Not instantiable");
    }
}
