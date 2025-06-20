package org.threeten.bp.jdk8;

import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalUnit;

public abstract class DefaultInterfaceTemporal extends DefaultInterfaceTemporalAccessor implements Temporal {
    public Temporal g(TemporalAmount temporalAmount) {
        return temporalAmount.a(this);
    }

    public Temporal h(TemporalAmount temporalAmount) {
        return temporalAmount.b(this);
    }

    public Temporal l(TemporalAdjuster temporalAdjuster) {
        return temporalAdjuster.e(this);
    }

    public Temporal o(long j2, TemporalUnit temporalUnit) {
        return j2 == Long.MIN_VALUE ? q(Long.MAX_VALUE, temporalUnit).q(1, temporalUnit) : q(-j2, temporalUnit);
    }
}
