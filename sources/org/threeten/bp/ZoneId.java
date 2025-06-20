package org.threeten.bp;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.net.HttpHeaders;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.zone.ZoneRules;
import org.threeten.bp.zone.ZoneRulesException;
import org.threeten.bp.zone.ZoneRulesProvider;

public abstract class ZoneId implements Serializable {
    public static final Map<String, String> X;
    private static final long Y = 8352817235686L;
    public static final TemporalQuery<ZoneId> s = new TemporalQuery<ZoneId>() {
        /* renamed from: b */
        public ZoneId a(TemporalAccessor temporalAccessor) {
            return ZoneId.j(temporalAccessor);
        }
    };

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("ACT", "Australia/Darwin");
        hashMap.put("AET", "Australia/Sydney");
        hashMap.put("AGT", "America/Argentina/Buenos_Aires");
        hashMap.put("ART", "Africa/Cairo");
        hashMap.put("AST", "America/Anchorage");
        hashMap.put("BET", "America/Sao_Paulo");
        hashMap.put("BST", "Asia/Dhaka");
        hashMap.put("CAT", "Africa/Harare");
        hashMap.put("CNT", "America/St_Johns");
        hashMap.put("CST", "America/Chicago");
        hashMap.put("CTT", "Asia/Shanghai");
        hashMap.put("EAT", "Africa/Addis_Ababa");
        hashMap.put(HttpHeaders.r1, "Europe/Paris");
        hashMap.put("IET", "America/Indiana/Indianapolis");
        hashMap.put("IST", "Asia/Kolkata");
        hashMap.put("JST", "Asia/Tokyo");
        hashMap.put("MIT", "Pacific/Apia");
        hashMap.put("NET", "Asia/Yerevan");
        hashMap.put("NST", "Pacific/Auckland");
        hashMap.put("PLT", "Asia/Karachi");
        hashMap.put("PNT", "America/Phoenix");
        hashMap.put("PRT", "America/Puerto_Rico");
        hashMap.put("PST", "America/Los_Angeles");
        hashMap.put("SST", "Pacific/Guadalcanal");
        hashMap.put("VST", "Asia/Ho_Chi_Minh");
        hashMap.put("EST", "-05:00");
        hashMap.put("MST", "-07:00");
        hashMap.put("HST", "-10:00");
        X = Collections.unmodifiableMap(hashMap);
    }

    ZoneId() {
        if (getClass() != ZoneOffset.class && getClass() != ZoneRegion.class) {
            throw new AssertionError("Invalid subclass");
        }
    }

    public static ZoneId j(TemporalAccessor temporalAccessor) {
        ZoneId zoneId = (ZoneId) temporalAccessor.i(TemporalQueries.f());
        if (zoneId != null) {
            return zoneId;
        }
        throw new DateTimeException("Unable to obtain ZoneId from TemporalAccessor: " + temporalAccessor + ", type " + temporalAccessor.getClass().getName());
    }

    public static Set<String> k() {
        return new HashSet(ZoneRulesProvider.a());
    }

    public static ZoneId w(String str) {
        Jdk8Methods.j(str, "zoneId");
        if (str.equals("Z")) {
            return ZoneOffset.g3;
        }
        if (str.length() == 1) {
            throw new DateTimeException("Invalid zone: " + str);
        } else if (str.startsWith("+") || str.startsWith("-")) {
            return ZoneOffset.H(str);
        } else {
            if (str.equals("UTC") || str.equals("GMT") || str.equals("UT")) {
                return new ZoneRegion(str, ZoneOffset.g3.u());
            }
            if (str.startsWith("UTC+") || str.startsWith("GMT+") || str.startsWith("UTC-") || str.startsWith("GMT-")) {
                ZoneOffset H = ZoneOffset.H(str.substring(3));
                if (H.F() == 0) {
                    return new ZoneRegion(str.substring(0, 3), H.u());
                }
                return new ZoneRegion(str.substring(0, 3) + H.s(), H.u());
            } else if (!str.startsWith("UT+") && !str.startsWith("UT-")) {
                return ZoneRegion.C(str, true);
            } else {
                ZoneOffset H2 = ZoneOffset.H(str.substring(2));
                if (H2.F() == 0) {
                    return new ZoneRegion("UT", H2.u());
                }
                return new ZoneRegion("UT" + H2.s(), H2.u());
            }
        }
    }

    public static ZoneId x(String str, Map<String, String> map) {
        Jdk8Methods.j(str, "zoneId");
        Jdk8Methods.j(map, "aliasMap");
        String str2 = map.get(str);
        if (str2 != null) {
            str = str2;
        }
        return w(str);
    }

    public static ZoneId y(String str, ZoneOffset zoneOffset) {
        Jdk8Methods.j(str, "prefix");
        Jdk8Methods.j(zoneOffset, TypedValues.CycleType.R);
        if (str.length() == 0) {
            return zoneOffset;
        }
        if (!str.equals("GMT") && !str.equals("UTC") && !str.equals("UT")) {
            throw new IllegalArgumentException("Invalid prefix, must be GMT, UTC or UT: " + str);
        } else if (zoneOffset.F() == 0) {
            return new ZoneRegion(str, zoneOffset.u());
        } else {
            return new ZoneRegion(str + zoneOffset.s(), zoneOffset.u());
        }
    }

    public static ZoneId z() {
        return x(TimeZone.getDefault().getID(), X);
    }

    /* access modifiers changed from: package-private */
    public abstract void A(DataOutput dataOutput) throws IOException;

    public String c(TextStyle textStyle, Locale locale) {
        return new DateTimeFormatterBuilder().B(textStyle).Q(locale).d(new DefaultInterfaceTemporalAccessor() {
            public <R> R i(TemporalQuery<R> temporalQuery) {
                return temporalQuery == TemporalQueries.g() ? ZoneId.this : super.i(temporalQuery);
            }

            public boolean m(TemporalField temporalField) {
                return false;
            }

            public long p(TemporalField temporalField) {
                throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
            }
        });
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZoneId) {
            return s().equals(((ZoneId) obj).s());
        }
        return false;
    }

    public int hashCode() {
        return s().hashCode();
    }

    public abstract String s();

    public String toString() {
        return s();
    }

    public abstract ZoneRules u();

    public ZoneId v() {
        try {
            ZoneRules u = u();
            if (u.j()) {
                return u.b(Instant.Y);
            }
        } catch (ZoneRulesException unused) {
        }
        return this;
    }
}
