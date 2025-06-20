package org.threeten.bp.jdk8;

import java.util.Locale;
import org.threeten.bp.chrono.Era;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

public abstract class DefaultInterfaceEra extends DefaultInterfaceTemporalAccessor implements Era {
    public int b(TemporalField temporalField) {
        return temporalField == ChronoField.ERA ? getValue() : f(temporalField).a(p(temporalField), temporalField);
    }

    public String c(TextStyle textStyle, Locale locale) {
        return new DateTimeFormatterBuilder().r(ChronoField.ERA, textStyle).Q(locale).d(this);
    }

    public Temporal e(Temporal temporal) {
        return temporal.a(ChronoField.ERA, (long) getValue());
    }

    public <R> R i(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.e()) {
            return ChronoUnit.ERAS;
        }
        if (temporalQuery == TemporalQueries.a() || temporalQuery == TemporalQueries.f() || temporalQuery == TemporalQueries.g() || temporalQuery == TemporalQueries.d() || temporalQuery == TemporalQueries.b() || temporalQuery == TemporalQueries.c()) {
            return null;
        }
        return temporalQuery.a(this);
    }

    public boolean m(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.ERA : temporalField != null && temporalField.c(this);
    }

    public long p(TemporalField temporalField) {
        if (temporalField == ChronoField.ERA) {
            return (long) getValue();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.j(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }
}
