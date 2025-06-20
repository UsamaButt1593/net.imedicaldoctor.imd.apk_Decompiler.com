package org.threeten.bp.temporal;

public interface Temporal extends TemporalAccessor {
    Temporal a(TemporalField temporalField, long j2);

    Temporal g(TemporalAmount temporalAmount);

    Temporal h(TemporalAmount temporalAmount);

    Temporal l(TemporalAdjuster temporalAdjuster);

    boolean n(TemporalUnit temporalUnit);

    Temporal o(long j2, TemporalUnit temporalUnit);

    Temporal q(long j2, TemporalUnit temporalUnit);

    long r(Temporal temporal, TemporalUnit temporalUnit);
}
