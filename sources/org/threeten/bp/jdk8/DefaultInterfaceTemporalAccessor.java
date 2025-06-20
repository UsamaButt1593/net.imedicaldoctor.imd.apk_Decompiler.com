package org.threeten.bp.jdk8;

import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public abstract class DefaultInterfaceTemporalAccessor implements TemporalAccessor {
    public int b(TemporalField temporalField) {
        return f(temporalField).a(p(temporalField), temporalField);
    }

    public ValueRange f(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.f(this);
        }
        if (m(temporalField)) {
            return temporalField.h();
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public <R> R i(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.g() || temporalQuery == TemporalQueries.a() || temporalQuery == TemporalQueries.e()) {
            return null;
        }
        return temporalQuery.a(this);
    }
}
