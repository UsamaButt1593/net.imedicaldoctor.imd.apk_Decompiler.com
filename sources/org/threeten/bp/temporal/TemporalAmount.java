package org.threeten.bp.temporal;

import java.util.List;

public interface TemporalAmount {
    Temporal a(Temporal temporal);

    Temporal b(Temporal temporal);

    List<TemporalUnit> c();

    long e(TemporalUnit temporalUnit);
}
