package org.threeten.bp.format;

import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.ValueRange;

final class DateTimePrintContext {

    /* renamed from: a  reason: collision with root package name */
    private TemporalAccessor f31835a;

    /* renamed from: b  reason: collision with root package name */
    private Locale f31836b;

    /* renamed from: c  reason: collision with root package name */
    private DecimalStyle f31837c;

    /* renamed from: d  reason: collision with root package name */
    private int f31838d;

    DateTimePrintContext(TemporalAccessor temporalAccessor, Locale locale, DecimalStyle decimalStyle) {
        this.f31835a = temporalAccessor;
        this.f31836b = locale;
        this.f31837c = decimalStyle;
    }

    private static TemporalAccessor a(final TemporalAccessor temporalAccessor, DateTimeFormatter dateTimeFormatter) {
        Chronology f2 = dateTimeFormatter.f();
        ZoneId k2 = dateTimeFormatter.k();
        if (f2 == null && k2 == null) {
            return temporalAccessor;
        }
        Chronology chronology = (Chronology) temporalAccessor.i(TemporalQueries.a());
        final ZoneId zoneId = (ZoneId) temporalAccessor.i(TemporalQueries.g());
        final ChronoLocalDate chronoLocalDate = null;
        if (Jdk8Methods.c(chronology, f2)) {
            f2 = null;
        }
        if (Jdk8Methods.c(zoneId, k2)) {
            k2 = null;
        }
        if (f2 == null && k2 == null) {
            return temporalAccessor;
        }
        final Chronology chronology2 = f2 != null ? f2 : chronology;
        if (k2 != null) {
            zoneId = k2;
        }
        if (k2 != null) {
            if (temporalAccessor.m(ChronoField.INSTANT_SECONDS)) {
                if (chronology2 == null) {
                    chronology2 = IsoChronology.X2;
                }
                return chronology2.O(Instant.x(temporalAccessor), k2);
            }
            ZoneId v = k2.v();
            ZoneOffset zoneOffset = (ZoneOffset) temporalAccessor.i(TemporalQueries.d());
            if ((v instanceof ZoneOffset) && zoneOffset != null && !v.equals(zoneOffset)) {
                throw new DateTimeException("Invalid override zone for temporal: " + k2 + StringUtils.SPACE + temporalAccessor);
            }
        }
        if (f2 != null) {
            if (temporalAccessor.m(ChronoField.EPOCH_DAY)) {
                chronoLocalDate = chronology2.e(temporalAccessor);
            } else if (!(f2 == IsoChronology.X2 && chronology == null)) {
                ChronoField[] values = ChronoField.values();
                int length = values.length;
                int i2 = 0;
                while (i2 < length) {
                    ChronoField chronoField = values[i2];
                    if (!chronoField.a() || !temporalAccessor.m(chronoField)) {
                        i2++;
                    } else {
                        throw new DateTimeException("Invalid override chronology for temporal: " + f2 + StringUtils.SPACE + temporalAccessor);
                    }
                }
            }
        }
        return new DefaultInterfaceTemporalAccessor() {
            public ValueRange f(TemporalField temporalField) {
                return (ChronoLocalDate.this == null || !temporalField.a()) ? temporalAccessor.f(temporalField) : ChronoLocalDate.this.f(temporalField);
            }

            public <R> R i(TemporalQuery<R> temporalQuery) {
                if (temporalQuery == TemporalQueries.a()) {
                    return chronology2;
                }
                if (temporalQuery == TemporalQueries.g()) {
                    return zoneId;
                }
                return temporalQuery == TemporalQueries.e() ? temporalAccessor.i(temporalQuery) : temporalQuery.a(this);
            }

            public boolean m(TemporalField temporalField) {
                return (ChronoLocalDate.this == null || !temporalField.a()) ? temporalAccessor.m(temporalField) : ChronoLocalDate.this.m(temporalField);
            }

            public long p(TemporalField temporalField) {
                return ((ChronoLocalDate.this == null || !temporalField.a()) ? temporalAccessor : ChronoLocalDate.this).p(temporalField);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f31838d--;
    }

    /* access modifiers changed from: package-private */
    public Locale c() {
        return this.f31836b;
    }

    /* access modifiers changed from: package-private */
    public DecimalStyle d() {
        return this.f31837c;
    }

    /* access modifiers changed from: package-private */
    public TemporalAccessor e() {
        return this.f31835a;
    }

    /* access modifiers changed from: package-private */
    public Long f(TemporalField temporalField) {
        try {
            return Long.valueOf(this.f31835a.p(temporalField));
        } catch (DateTimeException e2) {
            if (this.f31838d > 0) {
                return null;
            }
            throw e2;
        }
    }

    /* access modifiers changed from: package-private */
    public <R> R g(TemporalQuery<R> temporalQuery) {
        R i2 = this.f31835a.i(temporalQuery);
        if (i2 != null || this.f31838d != 0) {
            return i2;
        }
        throw new DateTimeException("Unable to extract value: " + this.f31835a.getClass());
    }

    /* access modifiers changed from: package-private */
    public void h(TemporalAccessor temporalAccessor) {
        Jdk8Methods.j(temporalAccessor, "temporal");
        this.f31835a = temporalAccessor;
    }

    /* access modifiers changed from: package-private */
    public void i(Locale locale) {
        Jdk8Methods.j(locale, "locale");
        this.f31836b = locale;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        this.f31838d++;
    }

    public String toString() {
        return this.f31835a.toString();
    }

    DateTimePrintContext(TemporalAccessor temporalAccessor, DateTimeFormatter dateTimeFormatter) {
        this.f31835a = a(temporalAccessor, dateTimeFormatter);
        this.f31836b = dateTimeFormatter.h();
        this.f31837c = dateTimeFormatter.g();
    }
}
