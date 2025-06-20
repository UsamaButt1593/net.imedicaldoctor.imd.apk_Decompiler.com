package org.threeten.bp.temporal;

import androidx.media3.common.C;
import java.util.Locale;
import java.util.Map;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;

public enum ChronoField implements TemporalField {
    NANO_OF_SECOND("NanoOfSecond", r4, r9, ValueRange.k(0, 999999999)),
    NANO_OF_DAY("NanoOfDay", r4, r15, ValueRange.k(0, 86399999999999L)),
    MICRO_OF_SECOND("MicroOfSecond", r4, r9, ValueRange.k(0, 999999)),
    MICRO_OF_DAY("MicroOfDay", r4, r15, ValueRange.k(0, 86399999999L)),
    MILLI_OF_SECOND("MilliOfSecond", r4, r9, ValueRange.k(0, 999)),
    MILLI_OF_DAY("MilliOfDay", r4, r15, ValueRange.k(0, 86399999)),
    SECOND_OF_MINUTE("SecondOfMinute", r4, r20, ValueRange.k(0, 59)),
    SECOND_OF_DAY("SecondOfDay", r4, r15, ValueRange.k(0, 86399)),
    MINUTE_OF_HOUR("MinuteOfHour", r4, r24, ValueRange.k(0, 59)),
    MINUTE_OF_DAY("MinuteOfDay", r4, r15, ValueRange.k(0, 1439)),
    HOUR_OF_AMPM("HourOfAmPm", r24, r20, ValueRange.k(0, 11)),
    CLOCK_HOUR_OF_AMPM("ClockHourOfAmPm", r4, r20, ValueRange.k(1, 12)),
    HOUR_OF_DAY("HourOfDay", r4, r15, ValueRange.k(0, 23)),
    CLOCK_HOUR_OF_DAY("ClockHourOfDay", r4, r15, ValueRange.k(1, 24)),
    AMPM_OF_DAY("AmPmOfDay", r20, r15, ValueRange.k(0, 1)),
    DAY_OF_WEEK("DayOfWeek", r4, r30, ValueRange.k(1, 7)),
    ALIGNED_DAY_OF_WEEK_IN_MONTH("AlignedDayOfWeekInMonth", r4, r5, ValueRange.k(1, 7)),
    ALIGNED_DAY_OF_WEEK_IN_YEAR("AlignedDayOfWeekInYear", r4, r5, ValueRange.k(1, 7)),
    DAY_OF_MONTH("DayOfMonth", r15, r34, ValueRange.l(1, 28, 31)),
    DAY_OF_YEAR("DayOfYear", r4, r36, ValueRange.l(1, 365, 366)),
    EPOCH_DAY("EpochDay", r4, r38, ValueRange.k(-365243219162L, 365241780471L)),
    ALIGNED_WEEK_OF_MONTH("AlignedWeekOfMonth", r4, r34, ValueRange.l(1, 4, 5)),
    ALIGNED_WEEK_OF_YEAR("AlignedWeekOfYear", r4, r5, ValueRange.k(1, 53)),
    MONTH_OF_YEAR("MonthOfYear", r4, r5, ValueRange.k(1, 12)),
    PROLEPTIC_MONTH("ProlepticMonth", r4, r38, ValueRange.k(-11999999988L, 11999999999L)),
    YEAR_OF_ERA("YearOfEra", r4, r5, ValueRange.l(1, 999999999, C.f9093k)),
    YEAR("Year", r4, r5, ValueRange.k(-999999999, 999999999)),
    ERA("Era", ChronoUnit.ERAS, r5, ValueRange.k(0, 1)),
    INSTANT_SECONDS("InstantSeconds", r4, r5, ValueRange.k(Long.MIN_VALUE, Long.MAX_VALUE)),
    OFFSET_SECONDS("OffsetSeconds", r4, r5, ValueRange.k(-64800, 64800));
    
    private final TemporalUnit X;
    private final TemporalUnit Y;
    private final ValueRange Z;
    private final String s;

    private ChronoField(String str, TemporalUnit temporalUnit, TemporalUnit temporalUnit2, ValueRange valueRange) {
        this.s = str;
        this.X = temporalUnit;
        this.Y = temporalUnit2;
        this.Z = valueRange;
    }

    public boolean a() {
        return ordinal() >= DAY_OF_WEEK.ordinal() && ordinal() <= ERA.ordinal();
    }

    public boolean b() {
        return ordinal() < DAY_OF_WEEK.ordinal();
    }

    public boolean c(TemporalAccessor temporalAccessor) {
        return temporalAccessor.m(this);
    }

    public <R extends Temporal> R e(R r, long j2) {
        return r.a(this, j2);
    }

    public ValueRange f(TemporalAccessor temporalAccessor) {
        return temporalAccessor.f(this);
    }

    public TemporalUnit g() {
        return this.X;
    }

    public ValueRange h() {
        return this.Z;
    }

    public TemporalUnit i() {
        return this.Y;
    }

    public long j(TemporalAccessor temporalAccessor) {
        return temporalAccessor.p(this);
    }

    public String k(Locale locale) {
        Jdk8Methods.j(locale, "locale");
        return toString();
    }

    public TemporalAccessor l(Map<TemporalField, Long> map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
        return null;
    }

    public int m(long j2) {
        return h().a(j2, this);
    }

    public long n(long j2) {
        return h().b(j2, this);
    }

    public String toString() {
        return this.s;
    }
}
