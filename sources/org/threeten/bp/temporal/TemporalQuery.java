package org.threeten.bp.temporal;

public interface TemporalQuery<R> {
    R a(TemporalAccessor temporalAccessor);
}
