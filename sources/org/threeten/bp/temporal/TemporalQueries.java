package org.threeten.bp.temporal;

import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.Chronology;

public final class TemporalQueries {

    /* renamed from: a  reason: collision with root package name */
    static final TemporalQuery<ZoneId> f31862a = new TemporalQuery<ZoneId>() {
        /* renamed from: b */
        public ZoneId a(TemporalAccessor temporalAccessor) {
            return (ZoneId) temporalAccessor.i(this);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    static final TemporalQuery<Chronology> f31863b = new TemporalQuery<Chronology>() {
        /* renamed from: b */
        public Chronology a(TemporalAccessor temporalAccessor) {
            return (Chronology) temporalAccessor.i(this);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    static final TemporalQuery<TemporalUnit> f31864c = new TemporalQuery<TemporalUnit>() {
        /* renamed from: b */
        public TemporalUnit a(TemporalAccessor temporalAccessor) {
            return (TemporalUnit) temporalAccessor.i(this);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    static final TemporalQuery<ZoneId> f31865d = new TemporalQuery<ZoneId>() {
        /* renamed from: b */
        public ZoneId a(TemporalAccessor temporalAccessor) {
            ZoneId zoneId = (ZoneId) temporalAccessor.i(TemporalQueries.f31862a);
            return zoneId != null ? zoneId : (ZoneId) temporalAccessor.i(TemporalQueries.f31866e);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    static final TemporalQuery<ZoneOffset> f31866e = new TemporalQuery<ZoneOffset>() {
        /* renamed from: b */
        public ZoneOffset a(TemporalAccessor temporalAccessor) {
            ChronoField chronoField = ChronoField.OFFSET_SECONDS;
            if (temporalAccessor.m(chronoField)) {
                return ZoneOffset.L(temporalAccessor.b(chronoField));
            }
            return null;
        }
    };

    /* renamed from: f  reason: collision with root package name */
    static final TemporalQuery<LocalDate> f31867f = new TemporalQuery<LocalDate>() {
        /* renamed from: b */
        public LocalDate a(TemporalAccessor temporalAccessor) {
            ChronoField chronoField = ChronoField.EPOCH_DAY;
            if (temporalAccessor.m(chronoField)) {
                return LocalDate.w2(temporalAccessor.p(chronoField));
            }
            return null;
        }
    };

    /* renamed from: g  reason: collision with root package name */
    static final TemporalQuery<LocalTime> f31868g = new TemporalQuery<LocalTime>() {
        /* renamed from: b */
        public LocalTime a(TemporalAccessor temporalAccessor) {
            ChronoField chronoField = ChronoField.NANO_OF_DAY;
            if (temporalAccessor.m(chronoField)) {
                return LocalTime.v0(temporalAccessor.p(chronoField));
            }
            return null;
        }
    };

    private TemporalQueries() {
    }

    public static final TemporalQuery<Chronology> a() {
        return f31863b;
    }

    public static final TemporalQuery<LocalDate> b() {
        return f31867f;
    }

    public static final TemporalQuery<LocalTime> c() {
        return f31868g;
    }

    public static final TemporalQuery<ZoneOffset> d() {
        return f31866e;
    }

    public static final TemporalQuery<TemporalUnit> e() {
        return f31864c;
    }

    public static final TemporalQuery<ZoneId> f() {
        return f31865d;
    }

    public static final TemporalQuery<ZoneId> g() {
        return f31862a;
    }
}
