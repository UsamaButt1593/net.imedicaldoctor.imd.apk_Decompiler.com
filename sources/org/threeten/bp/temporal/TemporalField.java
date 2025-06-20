package org.threeten.bp.temporal;

import java.util.Locale;
import java.util.Map;
import org.threeten.bp.format.ResolverStyle;

public interface TemporalField {
    boolean a();

    boolean b();

    boolean c(TemporalAccessor temporalAccessor);

    <R extends Temporal> R e(R r, long j2);

    ValueRange f(TemporalAccessor temporalAccessor);

    TemporalUnit g();

    ValueRange h();

    TemporalUnit i();

    long j(TemporalAccessor temporalAccessor);

    String k(Locale locale);

    TemporalAccessor l(Map<TemporalField, Long> map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle);
}
