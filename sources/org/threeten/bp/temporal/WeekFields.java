package org.threeten.bp.temporal;

import com.dd.plist.ASCIIPropertyListParser;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Year;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;

public final class WeekFields implements Serializable {
    private static final ConcurrentMap<String, WeekFields> a3 = new ConcurrentHashMap(4, 0.75f, 2);
    public static final WeekFields b3 = new WeekFields(DayOfWeek.MONDAY, 4);
    public static final WeekFields c3 = f(DayOfWeek.SUNDAY, 1);
    private static final long d3 = -1177360819670808121L;
    private final int X;
    private final transient TemporalField X2 = ComputedDayOfField.v(this);
    private final transient TemporalField Y = ComputedDayOfField.r(this);
    /* access modifiers changed from: private */
    public final transient TemporalField Y2 = ComputedDayOfField.u(this);
    private final transient TemporalField Z = ComputedDayOfField.t(this);
    private final transient TemporalField Z2 = ComputedDayOfField.s(this);
    private final DayOfWeek s;

    static class ComputedDayOfField implements TemporalField {
        private static final ValueRange Y2 = ValueRange.k(1, 7);
        private static final ValueRange Z2 = ValueRange.m(0, 1, 4, 6);
        private static final ValueRange a3 = ValueRange.m(0, 1, 52, 54);
        private static final ValueRange b3 = ValueRange.l(1, 52, 53);
        private static final ValueRange c3 = ChronoField.YEAR.h();
        private final WeekFields X;
        private final ValueRange X2;
        private final TemporalUnit Y;
        private final TemporalUnit Z;
        private final String s;

        private ComputedDayOfField(String str, WeekFields weekFields, TemporalUnit temporalUnit, TemporalUnit temporalUnit2, ValueRange valueRange) {
            this.s = str;
            this.X = weekFields;
            this.Y = temporalUnit;
            this.Z = temporalUnit2;
            this.X2 = valueRange;
        }

        private int d(int i2, int i3) {
            return ((i2 + 7) + (i3 - 1)) / 7;
        }

        private int m(TemporalAccessor temporalAccessor, int i2) {
            return Jdk8Methods.f(temporalAccessor.b(ChronoField.DAY_OF_WEEK) - i2, 7) + 1;
        }

        private int n(TemporalAccessor temporalAccessor) {
            int f2 = Jdk8Methods.f(temporalAccessor.b(ChronoField.DAY_OF_WEEK) - this.X.c().getValue(), 7) + 1;
            int b2 = temporalAccessor.b(ChronoField.YEAR);
            long q = q(temporalAccessor, f2);
            if (q == 0) {
                return b2 - 1;
            }
            if (q < 53) {
                return b2;
            }
            return q >= ((long) d(x(temporalAccessor.b(ChronoField.DAY_OF_YEAR), f2), (Year.F((long) b2) ? 366 : 365) + this.X.d())) ? b2 + 1 : b2;
        }

        private int o(TemporalAccessor temporalAccessor) {
            int f2 = Jdk8Methods.f(temporalAccessor.b(ChronoField.DAY_OF_WEEK) - this.X.c().getValue(), 7) + 1;
            long q = q(temporalAccessor, f2);
            if (q == 0) {
                return ((int) q(Chronology.q(temporalAccessor).e(temporalAccessor).o(1, ChronoUnit.WEEKS), f2)) + 1;
            }
            if (q >= 53) {
                int d2 = d(x(temporalAccessor.b(ChronoField.DAY_OF_YEAR), f2), (Year.F((long) temporalAccessor.b(ChronoField.YEAR)) ? 366 : 365) + this.X.d());
                if (q >= ((long) d2)) {
                    return (int) (q - ((long) (d2 - 1)));
                }
            }
            return (int) q;
        }

        private long p(TemporalAccessor temporalAccessor, int i2) {
            int b2 = temporalAccessor.b(ChronoField.DAY_OF_MONTH);
            return (long) d(x(b2, i2), b2);
        }

        private long q(TemporalAccessor temporalAccessor, int i2) {
            int b2 = temporalAccessor.b(ChronoField.DAY_OF_YEAR);
            return (long) d(x(b2, i2), b2);
        }

        static ComputedDayOfField r(WeekFields weekFields) {
            return new ComputedDayOfField("DayOfWeek", weekFields, ChronoUnit.DAYS, ChronoUnit.WEEKS, Y2);
        }

        static ComputedDayOfField s(WeekFields weekFields) {
            return new ComputedDayOfField("WeekBasedYear", weekFields, IsoFields.f31856e, ChronoUnit.FOREVER, c3);
        }

        static ComputedDayOfField t(WeekFields weekFields) {
            return new ComputedDayOfField("WeekOfMonth", weekFields, ChronoUnit.WEEKS, ChronoUnit.MONTHS, Z2);
        }

        static ComputedDayOfField u(WeekFields weekFields) {
            return new ComputedDayOfField("WeekOfWeekBasedYear", weekFields, ChronoUnit.WEEKS, IsoFields.f31856e, b3);
        }

        static ComputedDayOfField v(WeekFields weekFields) {
            return new ComputedDayOfField("WeekOfYear", weekFields, ChronoUnit.WEEKS, ChronoUnit.YEARS, a3);
        }

        private ValueRange w(TemporalAccessor temporalAccessor) {
            int f2 = Jdk8Methods.f(temporalAccessor.b(ChronoField.DAY_OF_WEEK) - this.X.c().getValue(), 7) + 1;
            long q = q(temporalAccessor, f2);
            if (q == 0) {
                return w(Chronology.q(temporalAccessor).e(temporalAccessor).o(2, ChronoUnit.WEEKS));
            }
            int d2 = d(x(temporalAccessor.b(ChronoField.DAY_OF_YEAR), f2), (Year.F((long) temporalAccessor.b(ChronoField.YEAR)) ? 366 : 365) + this.X.d());
            return q >= ((long) d2) ? w(Chronology.q(temporalAccessor).e(temporalAccessor).q(2, ChronoUnit.WEEKS)) : ValueRange.k(1, (long) (d2 - 1));
        }

        private int x(int i2, int i3) {
            int f2 = Jdk8Methods.f(i2 - i3, 7);
            return f2 + 1 > this.X.d() ? 7 - f2 : -f2;
        }

        public boolean a() {
            return true;
        }

        public boolean b() {
            return false;
        }

        public boolean c(TemporalAccessor temporalAccessor) {
            ChronoField chronoField;
            if (!temporalAccessor.m(ChronoField.DAY_OF_WEEK)) {
                return false;
            }
            TemporalUnit temporalUnit = this.Z;
            if (temporalUnit == ChronoUnit.WEEKS) {
                return true;
            }
            if (temporalUnit == ChronoUnit.MONTHS) {
                chronoField = ChronoField.DAY_OF_MONTH;
            } else if (temporalUnit == ChronoUnit.YEARS) {
                chronoField = ChronoField.DAY_OF_YEAR;
            } else if (temporalUnit != IsoFields.f31856e && temporalUnit != ChronoUnit.FOREVER) {
                return false;
            } else {
                chronoField = ChronoField.EPOCH_DAY;
            }
            return temporalAccessor.m(chronoField);
        }

        public <R extends Temporal> R e(R r, long j2) {
            long j3;
            int a2 = this.X2.a(j2, this);
            int b2 = r.b(this);
            if (a2 == b2) {
                return r;
            }
            if (this.Z != ChronoUnit.FOREVER) {
                return r.q((long) (a2 - b2), this.Y);
            }
            int b4 = r.b(this.X.Y2);
            ChronoUnit chronoUnit = ChronoUnit.WEEKS;
            R q = r.q((long) (((double) (j2 - ((long) b2))) * 52.1775d), chronoUnit);
            if (q.b(this) > a2) {
                j3 = (long) q.b(this.X.Y2);
            } else {
                if (q.b(this) < a2) {
                    q = q.q(2, chronoUnit);
                }
                q = q.q((long) (b4 - q.b(this.X.Y2)), chronoUnit);
                if (q.b(this) <= a2) {
                    return q;
                }
                j3 = 1;
            }
            return q.o(j3, chronoUnit);
        }

        public ValueRange f(TemporalAccessor temporalAccessor) {
            ChronoField chronoField;
            TemporalUnit temporalUnit = this.Z;
            if (temporalUnit == ChronoUnit.WEEKS) {
                return this.X2;
            }
            if (temporalUnit == ChronoUnit.MONTHS) {
                chronoField = ChronoField.DAY_OF_MONTH;
            } else if (temporalUnit == ChronoUnit.YEARS) {
                chronoField = ChronoField.DAY_OF_YEAR;
            } else if (temporalUnit == IsoFields.f31856e) {
                return w(temporalAccessor);
            } else {
                if (temporalUnit == ChronoUnit.FOREVER) {
                    return temporalAccessor.f(ChronoField.YEAR);
                }
                throw new IllegalStateException("unreachable");
            }
            int value = this.X.c().getValue();
            int x = x(temporalAccessor.b(chronoField), Jdk8Methods.f(temporalAccessor.b(ChronoField.DAY_OF_WEEK) - value, 7) + 1);
            ValueRange f2 = temporalAccessor.f(chronoField);
            return ValueRange.k((long) d(x, (int) f2.e()), (long) d(x, (int) f2.d()));
        }

        public TemporalUnit g() {
            return this.Y;
        }

        public ValueRange h() {
            return this.X2;
        }

        public TemporalUnit i() {
            return this.Z;
        }

        public long j(TemporalAccessor temporalAccessor) {
            int n2;
            ChronoField chronoField;
            int f2 = Jdk8Methods.f(temporalAccessor.b(ChronoField.DAY_OF_WEEK) - this.X.c().getValue(), 7) + 1;
            TemporalUnit temporalUnit = this.Z;
            if (temporalUnit == ChronoUnit.WEEKS) {
                return (long) f2;
            }
            if (temporalUnit == ChronoUnit.MONTHS) {
                chronoField = ChronoField.DAY_OF_MONTH;
            } else if (temporalUnit == ChronoUnit.YEARS) {
                chronoField = ChronoField.DAY_OF_YEAR;
            } else {
                if (temporalUnit == IsoFields.f31856e) {
                    n2 = o(temporalAccessor);
                } else if (temporalUnit == ChronoUnit.FOREVER) {
                    n2 = n(temporalAccessor);
                } else {
                    throw new IllegalStateException("unreachable");
                }
                return (long) n2;
            }
            int b2 = temporalAccessor.b(chronoField);
            n2 = d(x(b2, f2), b2);
            return (long) n2;
        }

        public String k(Locale locale) {
            Jdk8Methods.j(locale, "locale");
            return this.Z == ChronoUnit.YEARS ? "Week" : toString();
        }

        public TemporalAccessor l(Map<TemporalField, Long> map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
            long j2;
            int m2;
            long a2;
            ChronoLocalDate Q;
            long j3;
            ChronoLocalDate chronoLocalDate;
            ChronoLocalDate b2;
            long a4;
            Map<TemporalField, Long> map2 = map;
            ResolverStyle resolverStyle2 = resolverStyle;
            int value = this.X.c().getValue();
            if (this.Z == ChronoUnit.WEEKS) {
                map2.put(ChronoField.DAY_OF_WEEK, Long.valueOf((long) (Jdk8Methods.f((value - 1) + (this.X2.a(map2.remove(this).longValue(), this) - 1), 7) + 1)));
                return null;
            }
            ChronoField chronoField = ChronoField.DAY_OF_WEEK;
            if (!map2.containsKey(chronoField)) {
                return null;
            }
            if (this.Z != ChronoUnit.FOREVER) {
                ChronoField chronoField2 = ChronoField.YEAR;
                if (!map2.containsKey(chronoField2)) {
                    return null;
                }
                int f2 = Jdk8Methods.f(chronoField.m(map2.get(chronoField).longValue()) - value, 7) + 1;
                int m3 = chronoField2.m(map2.get(chronoField2).longValue());
                Chronology q = Chronology.q(temporalAccessor);
                TemporalUnit temporalUnit = this.Z;
                ChronoUnit chronoUnit = ChronoUnit.MONTHS;
                if (temporalUnit == chronoUnit) {
                    ChronoField chronoField3 = ChronoField.MONTH_OF_YEAR;
                    if (!map2.containsKey(chronoField3)) {
                        return null;
                    }
                    long longValue = map2.remove(this).longValue();
                    if (resolverStyle2 == ResolverStyle.LENIENT) {
                        chronoLocalDate = q.b(m3, 1, 1).q(map2.get(chronoField3).longValue() - 1, chronoUnit);
                        int m4 = m(chronoLocalDate, value);
                        j3 = ((longValue - p(chronoLocalDate, m4)) * 7) + ((long) (f2 - m4));
                    } else {
                        chronoLocalDate = q.b(m3, chronoField3.m(map2.get(chronoField3).longValue()), 8);
                        int m5 = m(chronoLocalDate, value);
                        j3 = ((long) (f2 - m5)) + ((((long) this.X2.a(longValue, this)) - p(chronoLocalDate, m5)) * 7);
                    }
                    Q = chronoLocalDate.q(j3, ChronoUnit.DAYS);
                    if (resolverStyle2 != ResolverStyle.STRICT || Q.p(chronoField3) == map2.get(chronoField3).longValue()) {
                        map2.remove(this);
                        map2.remove(chronoField2);
                        map2.remove(chronoField3);
                    } else {
                        throw new DateTimeException("Strict mode rejected date parsed to a different month");
                    }
                } else if (temporalUnit == ChronoUnit.YEARS) {
                    long longValue2 = map2.remove(this).longValue();
                    ChronoLocalDate b4 = q.b(m3, 1, 1);
                    if (resolverStyle2 == ResolverStyle.LENIENT) {
                        m2 = m(b4, value);
                        a2 = longValue2 - q(b4, m2);
                        j2 = 7;
                    } else {
                        j2 = 7;
                        m2 = m(b4, value);
                        a2 = ((long) this.X2.a(longValue2, this)) - q(b4, m2);
                    }
                    Q = b4.q((a2 * j2) + ((long) (f2 - m2)), ChronoUnit.DAYS);
                    if (resolverStyle2 != ResolverStyle.STRICT || Q.p(chronoField2) == map2.get(chronoField2).longValue()) {
                        map2.remove(this);
                        map2.remove(chronoField2);
                    } else {
                        throw new DateTimeException("Strict mode rejected date parsed to a different year");
                    }
                } else {
                    throw new IllegalStateException("unreachable");
                }
            } else if (!map2.containsKey(this.X.Y2)) {
                return null;
            } else {
                Chronology q2 = Chronology.q(temporalAccessor);
                int f3 = Jdk8Methods.f(chronoField.m(map2.get(chronoField).longValue()) - value, 7) + 1;
                int a5 = h().a(map2.get(this).longValue(), this);
                if (resolverStyle2 == ResolverStyle.LENIENT) {
                    b2 = q2.b(a5, 1, this.X.d());
                    a4 = map2.get(this.X.Y2).longValue();
                } else {
                    b2 = q2.b(a5, 1, this.X.d());
                    a4 = (long) this.X.Y2.h().a(map2.get(this.X.Y2).longValue(), this.X.Y2);
                }
                int m6 = m(b2, value);
                Q = b2.q(((a4 - q(b2, m6)) * 7) + ((long) (f3 - m6)), ChronoUnit.DAYS);
                if (resolverStyle2 != ResolverStyle.STRICT || Q.p(this) == map2.get(this).longValue()) {
                    map2.remove(this);
                    map2.remove(this.X.Y2);
                } else {
                    throw new DateTimeException("Strict mode rejected date parsed to a different year");
                }
            }
            map2.remove(chronoField);
            return Q;
        }

        public String toString() {
            return this.s + "[" + this.X.toString() + "]";
        }
    }

    private WeekFields(DayOfWeek dayOfWeek, int i2) {
        Jdk8Methods.j(dayOfWeek, "firstDayOfWeek");
        if (i2 < 1 || i2 > 7) {
            throw new IllegalArgumentException("Minimal number of days is invalid");
        }
        this.s = dayOfWeek;
        this.X = i2;
    }

    public static WeekFields e(Locale locale) {
        Jdk8Methods.j(locale, "locale");
        GregorianCalendar gregorianCalendar = new GregorianCalendar(new Locale(locale.getLanguage(), locale.getCountry()));
        return f(DayOfWeek.SUNDAY.u((long) (gregorianCalendar.getFirstDayOfWeek() - 1)), gregorianCalendar.getMinimalDaysInFirstWeek());
    }

    public static WeekFields f(DayOfWeek dayOfWeek, int i2) {
        String str = dayOfWeek.toString() + i2;
        ConcurrentMap<String, WeekFields> concurrentMap = a3;
        WeekFields weekFields = concurrentMap.get(str);
        if (weekFields != null) {
            return weekFields;
        }
        concurrentMap.putIfAbsent(str, new WeekFields(dayOfWeek, i2));
        return concurrentMap.get(str);
    }

    private Object g() throws InvalidObjectException {
        try {
            return f(this.s, this.X);
        } catch (IllegalArgumentException e2) {
            throw new InvalidObjectException("Invalid WeekFields" + e2.getMessage());
        }
    }

    public TemporalField b() {
        return this.Y;
    }

    public DayOfWeek c() {
        return this.s;
    }

    public int d() {
        return this.X;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WeekFields) && hashCode() == obj.hashCode();
    }

    public TemporalField h() {
        return this.Z2;
    }

    public int hashCode() {
        return (this.s.ordinal() * 7) + this.X;
    }

    public TemporalField i() {
        return this.Z;
    }

    public TemporalField j() {
        return this.Y2;
    }

    public TemporalField k() {
        return this.X2;
    }

    public String toString() {
        return "WeekFields[" + this.s + ASCIIPropertyListParser.f18651i + this.X + ']';
    }
}
