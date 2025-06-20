package org.threeten.bp.format;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

final class DateTimeParseContext {

    /* renamed from: a  reason: collision with root package name */
    private Locale f31828a;

    /* renamed from: b  reason: collision with root package name */
    private DecimalStyle f31829b;

    /* renamed from: c  reason: collision with root package name */
    private Chronology f31830c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ZoneId f31831d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f31832e = true;

    /* renamed from: f  reason: collision with root package name */
    private boolean f31833f = true;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayList<Parsed> f31834g;

    final class Parsed extends DefaultInterfaceTemporalAccessor {
        ZoneId X;
        Period X2;
        final Map<TemporalField, Long> Y;
        List<Object[]> Y2;
        boolean Z;
        Chronology s;

        private Parsed() {
            this.s = null;
            this.X = null;
            this.Y = new HashMap();
            this.X2 = Period.Z;
        }

        public int b(TemporalField temporalField) {
            if (this.Y.containsKey(temporalField)) {
                return Jdk8Methods.r(this.Y.get(temporalField).longValue());
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }

        public <R> R i(TemporalQuery<R> temporalQuery) {
            if (temporalQuery == TemporalQueries.a()) {
                return this.s;
            }
            return (temporalQuery == TemporalQueries.g() || temporalQuery == TemporalQueries.f()) ? this.X : super.i(temporalQuery);
        }

        public boolean m(TemporalField temporalField) {
            return this.Y.containsKey(temporalField);
        }

        public long p(TemporalField temporalField) {
            if (this.Y.containsKey(temporalField)) {
                return this.Y.get(temporalField).longValue();
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
        }

        /* access modifiers changed from: protected */
        public Parsed s() {
            Parsed parsed = new Parsed();
            parsed.s = this.s;
            parsed.X = this.X;
            parsed.Y.putAll(this.Y);
            parsed.Z = this.Z;
            return parsed;
        }

        public String toString() {
            return this.Y.toString() + "," + this.s + "," + this.X;
        }

        /* access modifiers changed from: package-private */
        public DateTimeBuilder u() {
            DateTimeBuilder dateTimeBuilder = new DateTimeBuilder();
            dateTimeBuilder.s.putAll(this.Y);
            dateTimeBuilder.X = DateTimeParseContext.this.h();
            ZoneId zoneId = this.X;
            if (zoneId == null) {
                zoneId = DateTimeParseContext.this.f31831d;
            }
            dateTimeBuilder.Y = zoneId;
            dateTimeBuilder.Y2 = this.Z;
            dateTimeBuilder.Z2 = this.X2;
            return dateTimeBuilder;
        }
    }

    DateTimeParseContext(Locale locale, DecimalStyle decimalStyle, Chronology chronology) {
        ArrayList<Parsed> arrayList = new ArrayList<>();
        this.f31834g = arrayList;
        this.f31828a = locale;
        this.f31829b = decimalStyle;
        this.f31830c = chronology;
        this.f31831d = null;
        arrayList.add(new Parsed());
    }

    static boolean d(char c2, char c3) {
        return c2 == c3 || Character.toUpperCase(c2) == Character.toUpperCase(c3) || Character.toLowerCase(c2) == Character.toLowerCase(c3);
    }

    private Parsed f() {
        ArrayList<Parsed> arrayList = this.f31834g;
        return arrayList.get(arrayList.size() - 1);
    }

    /* access modifiers changed from: package-private */
    public void b(DateTimeFormatterBuilder.ReducedPrinterParser reducedPrinterParser, long j2, int i2, int i3) {
        Parsed f2 = f();
        if (f2.Y2 == null) {
            f2.Y2 = new ArrayList(2);
        }
        f2.Y2.add(new Object[]{reducedPrinterParser, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    /* access modifiers changed from: package-private */
    public boolean c(char c2, char c3) {
        if (l()) {
            return c2 == c3;
        }
        return d(c2, c3);
    }

    /* access modifiers changed from: package-private */
    public DateTimeParseContext e() {
        return new DateTimeParseContext(this);
    }

    /* access modifiers changed from: package-private */
    public void g(boolean z) {
        ArrayList<Parsed> arrayList;
        int size;
        if (z) {
            arrayList = this.f31834g;
            size = arrayList.size() - 2;
        } else {
            arrayList = this.f31834g;
            size = arrayList.size() - 1;
        }
        arrayList.remove(size);
    }

    /* access modifiers changed from: package-private */
    public Chronology h() {
        Chronology chronology = f().s;
        if (chronology != null) {
            return chronology;
        }
        Chronology chronology2 = this.f31830c;
        return chronology2 == null ? IsoChronology.X2 : chronology2;
    }

    /* access modifiers changed from: package-private */
    public Locale i() {
        return this.f31828a;
    }

    /* access modifiers changed from: package-private */
    public Long j(TemporalField temporalField) {
        return f().Y.get(temporalField);
    }

    /* access modifiers changed from: package-private */
    public DecimalStyle k() {
        return this.f31829b;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return this.f31832e;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return this.f31833f;
    }

    /* access modifiers changed from: package-private */
    public void n(boolean z) {
        this.f31832e = z;
    }

    /* access modifiers changed from: package-private */
    public void o(Locale locale) {
        Jdk8Methods.j(locale, "locale");
        this.f31828a = locale;
    }

    /* access modifiers changed from: package-private */
    public void p(ZoneId zoneId) {
        Jdk8Methods.j(zoneId, "zone");
        f().X = zoneId;
    }

    /* access modifiers changed from: package-private */
    public void q(Chronology chronology) {
        Jdk8Methods.j(chronology, "chrono");
        Parsed f2 = f();
        f2.s = chronology;
        if (f2.Y2 != null) {
            ArrayList<Object[]> arrayList = new ArrayList<>(f2.Y2);
            f2.Y2.clear();
            for (Object[] objArr : arrayList) {
                ((DateTimeFormatterBuilder.ReducedPrinterParser) objArr[0]).e(this, ((Long) objArr[1]).longValue(), ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int r(TemporalField temporalField, long j2, int i2, int i3) {
        Jdk8Methods.j(temporalField, "field");
        Long put = f().Y.put(temporalField, Long.valueOf(j2));
        return (put == null || put.longValue() == j2) ? i3 : ~i2;
    }

    /* access modifiers changed from: package-private */
    public void s() {
        f().Z = true;
    }

    /* access modifiers changed from: package-private */
    public void t(boolean z) {
        this.f31833f = z;
    }

    public String toString() {
        return f().toString();
    }

    /* access modifiers changed from: package-private */
    public void u() {
        this.f31834g.add(f().s());
    }

    /* access modifiers changed from: package-private */
    public boolean v(CharSequence charSequence, int i2, CharSequence charSequence2, int i3, int i4) {
        if (i2 + i4 > charSequence.length() || i3 + i4 > charSequence2.length()) {
            return false;
        }
        if (l()) {
            for (int i5 = 0; i5 < i4; i5++) {
                if (charSequence.charAt(i2 + i5) != charSequence2.charAt(i3 + i5)) {
                    return false;
                }
            }
            return true;
        }
        for (int i6 = 0; i6 < i4; i6++) {
            char charAt = charSequence.charAt(i2 + i6);
            char charAt2 = charSequence2.charAt(i3 + i6);
            if (charAt != charAt2 && Character.toUpperCase(charAt) != Character.toUpperCase(charAt2) && Character.toLowerCase(charAt) != Character.toLowerCase(charAt2)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public Parsed w() {
        return f();
    }

    DateTimeParseContext(DateTimeFormatter dateTimeFormatter) {
        ArrayList<Parsed> arrayList = new ArrayList<>();
        this.f31834g = arrayList;
        this.f31828a = dateTimeFormatter.h();
        this.f31829b = dateTimeFormatter.g();
        this.f31830c = dateTimeFormatter.f();
        this.f31831d = dateTimeFormatter.k();
        arrayList.add(new Parsed());
    }

    DateTimeParseContext(DateTimeParseContext dateTimeParseContext) {
        ArrayList<Parsed> arrayList = new ArrayList<>();
        this.f31834g = arrayList;
        this.f31828a = dateTimeParseContext.f31828a;
        this.f31829b = dateTimeParseContext.f31829b;
        this.f31830c = dateTimeParseContext.f31830c;
        this.f31831d = dateTimeParseContext.f31831d;
        this.f31832e = dateTimeParseContext.f31832e;
        this.f31833f = dateTimeParseContext.f31833f;
        arrayList.add(new Parsed());
    }
}
