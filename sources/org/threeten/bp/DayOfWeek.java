package org.threeten.bp;

import java.util.Locale;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public enum DayOfWeek implements TemporalAccessor, TemporalAdjuster {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
    
    public static final TemporalQuery<DayOfWeek> a3 = null;
    private static final DayOfWeek[] b3 = null;

    static {
        a3 = new TemporalQuery<DayOfWeek>() {
            /* renamed from: b */
            public DayOfWeek a(TemporalAccessor temporalAccessor) {
                return DayOfWeek.j(temporalAccessor);
            }
        };
        b3 = values();
    }

    public static DayOfWeek j(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof DayOfWeek) {
            return (DayOfWeek) temporalAccessor;
        }
        try {
            return s(temporalAccessor.b(ChronoField.DAY_OF_WEEK));
        } catch (DateTimeException e2) {
            throw new DateTimeException("Unable to obtain DayOfWeek from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName(), e2);
        }
    }

    public static DayOfWeek s(int i2) {
        if (i2 >= 1 && i2 <= 7) {
            return b3[i2 - 1];
        }
        throw new DateTimeException("Invalid value for DayOfWeek: " + i2);
    }

    public int b(TemporalField temporalField) {
        return temporalField == ChronoField.DAY_OF_WEEK ? getValue() : f(temporalField).a(p(temporalField), temporalField);
    }

    public String c(TextStyle textStyle, Locale locale) {
        return new DateTimeFormatterBuilder().r(ChronoField.DAY_OF_WEEK, textStyle).Q(locale).d(this);
    }

    public Temporal e(Temporal temporal) {
        return temporal.a(ChronoField.DAY_OF_WEEK, (long) getValue());
    }

    public ValueRange f(TemporalField temporalField) {
        if (temporalField == ChronoField.DAY_OF_WEEK) {
            return temporalField.h();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.f(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public int getValue() {
        return ordinal() + 1;
    }

    public <R> R i(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.e()) {
            return ChronoUnit.DAYS;
        }
        if (temporalQuery == TemporalQueries.b() || temporalQuery == TemporalQueries.c() || temporalQuery == TemporalQueries.a() || temporalQuery == TemporalQueries.f() || temporalQuery == TemporalQueries.g() || temporalQuery == TemporalQueries.d()) {
            return null;
        }
        return temporalQuery.a(this);
    }

    public DayOfWeek k(long j2) {
        return u(-(j2 % 7));
    }

    public boolean m(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.DAY_OF_WEEK : temporalField != null && temporalField.c(this);
    }

    public long p(TemporalField temporalField) {
        if (temporalField == ChronoField.DAY_OF_WEEK) {
            return (long) getValue();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.j(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public DayOfWeek u(long j2) {
        return b3[(ordinal() + (((int) (j2 % 7)) + 7)) % 7];
    }
}
