package org.threeten.bp.temporal;

public interface TemporalAccessor {
    int b(TemporalField temporalField);

    ValueRange f(TemporalField temporalField);

    <R> R i(TemporalQuery<R> temporalQuery);

    boolean m(TemporalField temporalField);

    long p(TemporalField temporalField);
}
