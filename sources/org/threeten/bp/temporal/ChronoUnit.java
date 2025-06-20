package org.threeten.bp.temporal;

import org.threeten.bp.Duration;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.ChronoLocalDateTime;
import org.threeten.bp.chrono.ChronoZonedDateTime;

public enum ChronoUnit implements TemporalUnit {
    NANOS("Nanos", Duration.J(1)),
    MICROS("Micros", Duration.J(1000)),
    MILLIS("Millis", Duration.J(1000000)),
    SECONDS("Seconds", Duration.K(1)),
    MINUTES("Minutes", Duration.K(60)),
    HOURS("Hours", Duration.K(3600)),
    HALF_DAYS("HalfDays", Duration.K(43200)),
    DAYS("Days", Duration.K(86400)),
    WEEKS("Weeks", Duration.K(604800)),
    MONTHS("Months", Duration.K(2629746)),
    YEARS("Years", Duration.K(31556952)),
    DECADES("Decades", Duration.K(315569520)),
    CENTURIES("Centuries", Duration.K(3155695200L)),
    MILLENNIA("Millennia", Duration.K(31556952000L)),
    ERAS("Eras", Duration.K(31556952000000000L)),
    FOREVER("Forever", Duration.L(Long.MAX_VALUE, 999999999));
    
    private final Duration X;
    private final String s;

    private ChronoUnit(String str, Duration duration) {
        this.s = str;
        this.X = duration;
    }

    public Duration Q() {
        return this.X;
    }

    public boolean a() {
        return compareTo(DAYS) >= 0 && this != FOREVER;
    }

    public boolean b() {
        return compareTo(DAYS) < 0;
    }

    public boolean c() {
        return a() || this == FOREVER;
    }

    public long e(Temporal temporal, Temporal temporal2) {
        return temporal.r(temporal2, this);
    }

    public boolean f(Temporal temporal) {
        if (this == FOREVER) {
            return false;
        }
        if (temporal instanceof ChronoLocalDate) {
            return a();
        }
        if ((temporal instanceof ChronoLocalDateTime) || (temporal instanceof ChronoZonedDateTime)) {
            return true;
        }
        try {
            temporal.q(1, this);
            return true;
        } catch (RuntimeException unused) {
            try {
                temporal.q(-1, this);
                return true;
            } catch (RuntimeException unused2) {
                return false;
            }
        }
    }

    public <R extends Temporal> R g(R r, long j2) {
        return r.q(j2, this);
    }

    public String toString() {
        return this.s;
    }
}
