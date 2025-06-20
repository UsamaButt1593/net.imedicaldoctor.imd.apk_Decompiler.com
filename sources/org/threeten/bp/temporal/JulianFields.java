package org.threeten.bp.temporal;

import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;

public final class JulianFields {

    /* renamed from: a  reason: collision with root package name */
    public static final TemporalField f31859a = Field.JULIAN_DAY;

    /* renamed from: b  reason: collision with root package name */
    public static final TemporalField f31860b = Field.MODIFIED_JULIAN_DAY;

    /* renamed from: c  reason: collision with root package name */
    public static final TemporalField f31861c = Field.RATA_DIE;

    private enum Field implements TemporalField {
        JULIAN_DAY("JulianDay", r4, r5, 2440588),
        MODIFIED_JULIAN_DAY("ModifiedJulianDay", r4, r5, 40587),
        RATA_DIE("RataDie", r4, r5, 719163);
        
        private final TemporalUnit X;
        private final long X2;
        private final TemporalUnit Y;
        private final ValueRange Z;
        private final String s;

        private Field(String str, TemporalUnit temporalUnit, TemporalUnit temporalUnit2, long j2) {
            this.s = str;
            this.X = temporalUnit;
            this.Y = temporalUnit2;
            this.Z = ValueRange.k(-365243219162L + j2, 365241780471L + j2);
            this.X2 = j2;
        }

        public boolean a() {
            return true;
        }

        public boolean b() {
            return false;
        }

        public boolean c(TemporalAccessor temporalAccessor) {
            return temporalAccessor.m(ChronoField.EPOCH_DAY);
        }

        public <R extends Temporal> R e(R r, long j2) {
            if (h().j(j2)) {
                return r.a(ChronoField.EPOCH_DAY, Jdk8Methods.q(j2, this.X2));
            }
            throw new DateTimeException("Invalid value: " + this.s + StringUtils.SPACE + j2);
        }

        public ValueRange f(TemporalAccessor temporalAccessor) {
            if (c(temporalAccessor)) {
                return h();
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + this);
        }

        public TemporalUnit g() {
            return this.X;
        }

        public ValueRange h() {
            return this.Z;
        }

        public TemporalUnit i() {
            return this.Y;
        }

        public long j(TemporalAccessor temporalAccessor) {
            return temporalAccessor.p(ChronoField.EPOCH_DAY) + this.X2;
        }

        public String k(Locale locale) {
            Jdk8Methods.j(locale, "locale");
            return toString();
        }

        public TemporalAccessor l(Map<TemporalField, Long> map, TemporalAccessor temporalAccessor, ResolverStyle resolverStyle) {
            return Chronology.q(temporalAccessor).f(Jdk8Methods.q(map.remove(this).longValue(), this.X2));
        }

        public String toString() {
            return this.s;
        }
    }
}
