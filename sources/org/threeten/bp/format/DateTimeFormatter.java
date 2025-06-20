package org.threeten.bp.format;

import com.dd.plist.ASCIIPropertyListParser;
import com.google.android.gms.actions.SearchIntents;
import com.itextpdf.tool.xml.css.CSS;
import java.io.IOException;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.DateTimeParseContext;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.IsoFields;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQuery;

public final class DateTimeFormatter {

    /* renamed from: h  reason: collision with root package name */
    public static final DateTimeFormatter f31798h;

    /* renamed from: i  reason: collision with root package name */
    public static final DateTimeFormatter f31799i;

    /* renamed from: j  reason: collision with root package name */
    public static final DateTimeFormatter f31800j;

    /* renamed from: k  reason: collision with root package name */
    public static final DateTimeFormatter f31801k;

    /* renamed from: l  reason: collision with root package name */
    public static final DateTimeFormatter f31802l;

    /* renamed from: m  reason: collision with root package name */
    public static final DateTimeFormatter f31803m;

    /* renamed from: n  reason: collision with root package name */
    public static final DateTimeFormatter f31804n;
    public static final DateTimeFormatter o;
    public static final DateTimeFormatter p;
    public static final DateTimeFormatter q;
    public static final DateTimeFormatter r;
    public static final DateTimeFormatter s;
    public static final DateTimeFormatter t;
    public static final DateTimeFormatter u;
    public static final DateTimeFormatter v;
    private static final TemporalQuery<Period> w = new TemporalQuery<Period>() {
        /* renamed from: b */
        public Period a(TemporalAccessor temporalAccessor) {
            return temporalAccessor instanceof DateTimeBuilder ? ((DateTimeBuilder) temporalAccessor).Z2 : Period.Z;
        }
    };
    private static final TemporalQuery<Boolean> x = new TemporalQuery<Boolean>() {
        /* renamed from: b */
        public Boolean a(TemporalAccessor temporalAccessor) {
            return temporalAccessor instanceof DateTimeBuilder ? Boolean.valueOf(((DateTimeBuilder) temporalAccessor).Y2) : Boolean.FALSE;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final DateTimeFormatterBuilder.CompositePrinterParser f31805a;

    /* renamed from: b  reason: collision with root package name */
    private final Locale f31806b;

    /* renamed from: c  reason: collision with root package name */
    private final DecimalStyle f31807c;

    /* renamed from: d  reason: collision with root package name */
    private final ResolverStyle f31808d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<TemporalField> f31809e;

    /* renamed from: f  reason: collision with root package name */
    private final Chronology f31810f;

    /* renamed from: g  reason: collision with root package name */
    private final ZoneId f31811g;

    static class ClassicFormat extends Format {
        private final TemporalQuery<?> X;
        private final DateTimeFormatter s;

        public ClassicFormat(DateTimeFormatter dateTimeFormatter, TemporalQuery<?> temporalQuery) {
            this.s = dateTimeFormatter;
            this.X = temporalQuery;
        }

        public StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition) {
            Jdk8Methods.j(obj, "obj");
            Jdk8Methods.j(stringBuffer, "toAppendTo");
            Jdk8Methods.j(fieldPosition, "pos");
            if (obj instanceof TemporalAccessor) {
                fieldPosition.setBeginIndex(0);
                fieldPosition.setEndIndex(0);
                try {
                    this.s.e((TemporalAccessor) obj, stringBuffer);
                    return stringBuffer;
                } catch (RuntimeException e2) {
                    throw new IllegalArgumentException(e2.getMessage(), e2);
                }
            } else {
                throw new IllegalArgumentException("Format target must implement TemporalAccessor");
            }
        }

        public Object parseObject(String str) throws ParseException {
            Jdk8Methods.j(str, "text");
            try {
                TemporalQuery<?> temporalQuery = this.X;
                return temporalQuery == null ? this.s.v(str, (ParsePosition) null).L(this.s.j(), this.s.i()) : this.s.r(str, temporalQuery);
            } catch (DateTimeParseException e2) {
                throw new ParseException(e2.getMessage(), e2.a());
            } catch (RuntimeException e3) {
                throw ((ParseException) new ParseException(e3.getMessage(), 0).initCause(e3));
            }
        }

        public Object parseObject(String str, ParsePosition parsePosition) {
            Jdk8Methods.j(str, "text");
            try {
                DateTimeParseContext.Parsed b2 = this.s.x(str, parsePosition);
                if (b2 == null) {
                    if (parsePosition.getErrorIndex() < 0) {
                        parsePosition.setErrorIndex(0);
                    }
                    return null;
                }
                try {
                    DateTimeBuilder L = b2.u().L(this.s.j(), this.s.i());
                    TemporalQuery<?> temporalQuery = this.X;
                    return temporalQuery == null ? L : L.w(temporalQuery);
                } catch (RuntimeException unused) {
                    parsePosition.setErrorIndex(0);
                    return null;
                }
            } catch (IndexOutOfBoundsException unused2) {
                if (parsePosition.getErrorIndex() < 0) {
                    parsePosition.setErrorIndex(0);
                }
                return null;
            }
        }
    }

    static {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder();
        ChronoField chronoField = ChronoField.YEAR;
        SignStyle signStyle = SignStyle.EXCEEDS_PAD;
        DateTimeFormatterBuilder h2 = dateTimeFormatterBuilder.v(chronoField, 4, 10, signStyle).h('-');
        ChronoField chronoField2 = ChronoField.MONTH_OF_YEAR;
        DateTimeFormatterBuilder h3 = h2.u(chronoField2, 2).h('-');
        ChronoField chronoField3 = ChronoField.DAY_OF_MONTH;
        DateTimeFormatterBuilder u2 = h3.u(chronoField3, 2);
        ResolverStyle resolverStyle = ResolverStyle.STRICT;
        DateTimeFormatter R = u2.R(resolverStyle);
        IsoChronology isoChronology = IsoChronology.X2;
        DateTimeFormatter D = R.D(isoChronology);
        f31798h = D;
        f31799i = new DateTimeFormatterBuilder().I().a(D).m().R(resolverStyle).D(isoChronology);
        f31800j = new DateTimeFormatterBuilder().I().a(D).F().m().R(resolverStyle).D(isoChronology);
        DateTimeFormatterBuilder dateTimeFormatterBuilder2 = new DateTimeFormatterBuilder();
        ChronoField chronoField4 = ChronoField.HOUR_OF_DAY;
        DateTimeFormatterBuilder h4 = dateTimeFormatterBuilder2.u(chronoField4, 2).h(ASCIIPropertyListParser.A);
        ChronoField chronoField5 = ChronoField.MINUTE_OF_HOUR;
        DateTimeFormatterBuilder h5 = h4.u(chronoField5, 2).F().h(ASCIIPropertyListParser.A);
        ChronoField chronoField6 = ChronoField.SECOND_OF_MINUTE;
        DateTimeFormatter R2 = h5.u(chronoField6, 2).F().d(ChronoField.NANO_OF_SECOND, 0, 9, true).R(resolverStyle);
        f31801k = R2;
        f31802l = new DateTimeFormatterBuilder().I().a(R2).m().R(resolverStyle);
        f31803m = new DateTimeFormatterBuilder().I().a(R2).F().m().R(resolverStyle);
        DateTimeFormatter D2 = new DateTimeFormatterBuilder().I().a(D).h(ASCIIPropertyListParser.C).a(R2).R(resolverStyle).D(isoChronology);
        f31804n = D2;
        DateTimeFormatter D3 = new DateTimeFormatterBuilder().I().a(D2).m().R(resolverStyle).D(isoChronology);
        o = D3;
        p = new DateTimeFormatterBuilder().a(D3).F().h('[').J().A().h(']').R(resolverStyle).D(isoChronology);
        q = new DateTimeFormatterBuilder().a(D2).F().m().F().h('[').J().A().h(']').R(resolverStyle).D(isoChronology);
        r = new DateTimeFormatterBuilder().I().v(chronoField, 4, 10, signStyle).h('-').u(ChronoField.DAY_OF_YEAR, 3).F().m().R(resolverStyle).D(isoChronology);
        DateTimeFormatterBuilder h6 = new DateTimeFormatterBuilder().I().v(IsoFields.f31855d, 4, 10, signStyle).i("-W").u(IsoFields.f31854c, 2).h('-');
        ChronoField chronoField7 = ChronoField.DAY_OF_WEEK;
        s = h6.u(chronoField7, 1).F().m().R(resolverStyle).D(isoChronology);
        t = new DateTimeFormatterBuilder().I().e().R(resolverStyle);
        u = new DateTimeFormatterBuilder().I().u(chronoField, 4).u(chronoField2, 2).u(chronoField3, 2).F().l("+HHMMss", "Z").R(resolverStyle).D(isoChronology);
        HashMap hashMap = new HashMap();
        hashMap.put(1L, "Mon");
        hashMap.put(2L, "Tue");
        hashMap.put(3L, "Wed");
        hashMap.put(4L, "Thu");
        hashMap.put(5L, "Fri");
        hashMap.put(6L, "Sat");
        IsoChronology isoChronology2 = isoChronology;
        hashMap.put(7L, "Sun");
        HashMap hashMap2 = new HashMap();
        hashMap2.put(1L, "Jan");
        hashMap2.put(2L, "Feb");
        hashMap2.put(3L, "Mar");
        hashMap2.put(4L, "Apr");
        hashMap2.put(5L, "May");
        hashMap2.put(6L, "Jun");
        hashMap2.put(7L, "Jul");
        hashMap2.put(8L, "Aug");
        hashMap2.put(9L, "Sep");
        hashMap2.put(10L, "Oct");
        hashMap2.put(11L, "Nov");
        hashMap2.put(12L, "Dec");
        v = new DateTimeFormatterBuilder().I().M().F().q(chronoField7, hashMap).i(", ").E().v(chronoField3, 1, 2, SignStyle.NOT_NEGATIVE).h(' ').q(chronoField2, hashMap2).h(' ').u(chronoField, 4).h(' ').u(chronoField4, 2).h(ASCIIPropertyListParser.A).u(chronoField5, 2).F().h(ASCIIPropertyListParser.A).u(chronoField6, 2).E().h(' ').l("+HHMM", "GMT").R(ResolverStyle.SMART).D(isoChronology2);
    }

    DateTimeFormatter(DateTimeFormatterBuilder.CompositePrinterParser compositePrinterParser, Locale locale, DecimalStyle decimalStyle, ResolverStyle resolverStyle, Set<TemporalField> set, Chronology chronology, ZoneId zoneId) {
        this.f31805a = (DateTimeFormatterBuilder.CompositePrinterParser) Jdk8Methods.j(compositePrinterParser, "printerParser");
        this.f31806b = (Locale) Jdk8Methods.j(locale, "locale");
        this.f31807c = (DecimalStyle) Jdk8Methods.j(decimalStyle, "decimalStyle");
        this.f31808d = (ResolverStyle) Jdk8Methods.j(resolverStyle, "resolverStyle");
        this.f31809e = set;
        this.f31810f = chronology;
        this.f31811g = zoneId;
    }

    private DateTimeParseException c(CharSequence charSequence, RuntimeException runtimeException) {
        String str;
        if (charSequence.length() > 64) {
            str = charSequence.subSequence(0, 64).toString() + "...";
        } else {
            str = charSequence.toString();
        }
        return new DateTimeParseException("Text '" + str + "' could not be parsed: " + runtimeException.getMessage(), charSequence, 0, runtimeException);
    }

    public static DateTimeFormatter l(FormatStyle formatStyle) {
        Jdk8Methods.j(formatStyle, "dateStyle");
        return new DateTimeFormatterBuilder().j(formatStyle, (FormatStyle) null).P().D(IsoChronology.X2);
    }

    public static DateTimeFormatter m(FormatStyle formatStyle) {
        Jdk8Methods.j(formatStyle, "dateTimeStyle");
        return new DateTimeFormatterBuilder().j(formatStyle, formatStyle).P().D(IsoChronology.X2);
    }

    public static DateTimeFormatter n(FormatStyle formatStyle, FormatStyle formatStyle2) {
        Jdk8Methods.j(formatStyle, "dateStyle");
        Jdk8Methods.j(formatStyle2, "timeStyle");
        return new DateTimeFormatterBuilder().j(formatStyle, formatStyle2).P().D(IsoChronology.X2);
    }

    public static DateTimeFormatter o(FormatStyle formatStyle) {
        Jdk8Methods.j(formatStyle, "timeStyle");
        return new DateTimeFormatterBuilder().j((FormatStyle) null, formatStyle).P().D(IsoChronology.X2);
    }

    public static DateTimeFormatter p(String str) {
        return new DateTimeFormatterBuilder().o(str).P();
    }

    public static DateTimeFormatter q(String str, Locale locale) {
        return new DateTimeFormatterBuilder().o(str).Q(locale);
    }

    /* access modifiers changed from: private */
    public DateTimeBuilder v(CharSequence charSequence, ParsePosition parsePosition) {
        String str;
        ParsePosition parsePosition2 = parsePosition != null ? parsePosition : new ParsePosition(0);
        DateTimeParseContext.Parsed x2 = x(charSequence, parsePosition2);
        if (x2 != null && parsePosition2.getErrorIndex() < 0 && (parsePosition != null || parsePosition2.getIndex() >= charSequence.length())) {
            return x2.u();
        }
        if (charSequence.length() > 64) {
            str = charSequence.subSequence(0, 64).toString() + "...";
        } else {
            str = charSequence.toString();
        }
        if (parsePosition2.getErrorIndex() >= 0) {
            throw new DateTimeParseException("Text '" + str + "' could not be parsed at index " + parsePosition2.getErrorIndex(), charSequence, parsePosition2.getErrorIndex());
        }
        throw new DateTimeParseException("Text '" + str + "' could not be parsed, unparsed text found at index " + parsePosition2.getIndex(), charSequence, parsePosition2.getIndex());
    }

    /* access modifiers changed from: private */
    public DateTimeParseContext.Parsed x(CharSequence charSequence, ParsePosition parsePosition) {
        Jdk8Methods.j(charSequence, "text");
        Jdk8Methods.j(parsePosition, CSS.Property.m0);
        DateTimeParseContext dateTimeParseContext = new DateTimeParseContext(this);
        int a2 = this.f31805a.a(dateTimeParseContext, charSequence, parsePosition.getIndex());
        if (a2 < 0) {
            parsePosition.setErrorIndex(~a2);
            return null;
        }
        parsePosition.setIndex(a2);
        return dateTimeParseContext.w();
    }

    public static final TemporalQuery<Period> y() {
        return w;
    }

    public static final TemporalQuery<Boolean> z() {
        return x;
    }

    public Format A() {
        return new ClassicFormat(this, (TemporalQuery<?>) null);
    }

    public Format B(TemporalQuery<?> temporalQuery) {
        Jdk8Methods.j(temporalQuery, SearchIntents.f19720b);
        return new ClassicFormat(this, temporalQuery);
    }

    /* access modifiers changed from: package-private */
    public DateTimeFormatterBuilder.CompositePrinterParser C(boolean z) {
        return this.f31805a.c(z);
    }

    public DateTimeFormatter D(Chronology chronology) {
        if (Jdk8Methods.c(this.f31810f, chronology)) {
            return this;
        }
        return new DateTimeFormatter(this.f31805a, this.f31806b, this.f31807c, this.f31808d, this.f31809e, chronology, this.f31811g);
    }

    public DateTimeFormatter E(DecimalStyle decimalStyle) {
        if (this.f31807c.equals(decimalStyle)) {
            return this;
        }
        return new DateTimeFormatter(this.f31805a, this.f31806b, decimalStyle, this.f31808d, this.f31809e, this.f31810f, this.f31811g);
    }

    public DateTimeFormatter F(Locale locale) {
        if (this.f31806b.equals(locale)) {
            return this;
        }
        return new DateTimeFormatter(this.f31805a, locale, this.f31807c, this.f31808d, this.f31809e, this.f31810f, this.f31811g);
    }

    public DateTimeFormatter G(Set<TemporalField> set) {
        if (set == null) {
            return new DateTimeFormatter(this.f31805a, this.f31806b, this.f31807c, this.f31808d, (Set<TemporalField>) null, this.f31810f, this.f31811g);
        }
        if (Jdk8Methods.c(this.f31809e, set)) {
            return this;
        }
        return new DateTimeFormatter(this.f31805a, this.f31806b, this.f31807c, this.f31808d, Collections.unmodifiableSet(new HashSet(set)), this.f31810f, this.f31811g);
    }

    public DateTimeFormatter H(TemporalField... temporalFieldArr) {
        if (temporalFieldArr == null) {
            return new DateTimeFormatter(this.f31805a, this.f31806b, this.f31807c, this.f31808d, (Set<TemporalField>) null, this.f31810f, this.f31811g);
        }
        HashSet hashSet = new HashSet(Arrays.asList(temporalFieldArr));
        if (Jdk8Methods.c(this.f31809e, hashSet)) {
            return this;
        }
        return new DateTimeFormatter(this.f31805a, this.f31806b, this.f31807c, this.f31808d, Collections.unmodifiableSet(hashSet), this.f31810f, this.f31811g);
    }

    public DateTimeFormatter I(ResolverStyle resolverStyle) {
        Jdk8Methods.j(resolverStyle, "resolverStyle");
        if (Jdk8Methods.c(this.f31808d, resolverStyle)) {
            return this;
        }
        return new DateTimeFormatter(this.f31805a, this.f31806b, this.f31807c, resolverStyle, this.f31809e, this.f31810f, this.f31811g);
    }

    public DateTimeFormatter J(ZoneId zoneId) {
        return Jdk8Methods.c(this.f31811g, zoneId) ? this : new DateTimeFormatter(this.f31805a, this.f31806b, this.f31807c, this.f31808d, this.f31809e, this.f31810f, zoneId);
    }

    public String d(TemporalAccessor temporalAccessor) {
        StringBuilder sb = new StringBuilder(32);
        e(temporalAccessor, sb);
        return sb.toString();
    }

    public void e(TemporalAccessor temporalAccessor, Appendable appendable) {
        Jdk8Methods.j(temporalAccessor, "temporal");
        Jdk8Methods.j(appendable, "appendable");
        try {
            DateTimePrintContext dateTimePrintContext = new DateTimePrintContext(temporalAccessor, this);
            if (appendable instanceof StringBuilder) {
                this.f31805a.b(dateTimePrintContext, (StringBuilder) appendable);
                return;
            }
            StringBuilder sb = new StringBuilder(32);
            this.f31805a.b(dateTimePrintContext, sb);
            appendable.append(sb);
        } catch (IOException e2) {
            throw new DateTimeException(e2.getMessage(), e2);
        }
    }

    public Chronology f() {
        return this.f31810f;
    }

    public DecimalStyle g() {
        return this.f31807c;
    }

    public Locale h() {
        return this.f31806b;
    }

    public Set<TemporalField> i() {
        return this.f31809e;
    }

    public ResolverStyle j() {
        return this.f31808d;
    }

    public ZoneId k() {
        return this.f31811g;
    }

    public <T> T r(CharSequence charSequence, TemporalQuery<T> temporalQuery) {
        Jdk8Methods.j(charSequence, "text");
        Jdk8Methods.j(temporalQuery, "type");
        try {
            return v(charSequence, (ParsePosition) null).L(this.f31808d, this.f31809e).w(temporalQuery);
        } catch (DateTimeParseException e2) {
            throw e2;
        } catch (RuntimeException e3) {
            throw c(charSequence, e3);
        }
    }

    public TemporalAccessor s(CharSequence charSequence) {
        Jdk8Methods.j(charSequence, "text");
        try {
            return v(charSequence, (ParsePosition) null).L(this.f31808d, this.f31809e);
        } catch (DateTimeParseException e2) {
            throw e2;
        } catch (RuntimeException e3) {
            throw c(charSequence, e3);
        }
    }

    public TemporalAccessor t(CharSequence charSequence, ParsePosition parsePosition) {
        Jdk8Methods.j(charSequence, "text");
        Jdk8Methods.j(parsePosition, CSS.Property.m0);
        try {
            return v(charSequence, parsePosition).L(this.f31808d, this.f31809e);
        } catch (DateTimeParseException e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e3) {
            throw e3;
        } catch (RuntimeException e4) {
            throw c(charSequence, e4);
        }
    }

    public String toString() {
        String compositePrinterParser = this.f31805a.toString();
        return compositePrinterParser.startsWith("[") ? compositePrinterParser : compositePrinterParser.substring(1, compositePrinterParser.length() - 1);
    }

    public TemporalAccessor u(CharSequence charSequence, TemporalQuery<?>... temporalQueryArr) {
        Jdk8Methods.j(charSequence, "text");
        Jdk8Methods.j(temporalQueryArr, "types");
        if (temporalQueryArr.length >= 2) {
            try {
                DateTimeBuilder L = v(charSequence, (ParsePosition) null).L(this.f31808d, this.f31809e);
                int i2 = 0;
                while (i2 < temporalQueryArr.length) {
                    try {
                        return (TemporalAccessor) L.w(temporalQueryArr[i2]);
                    } catch (RuntimeException unused) {
                        i2++;
                    }
                }
                throw new DateTimeException("Unable to convert parsed text to any specified type: " + Arrays.toString(temporalQueryArr));
            } catch (DateTimeParseException e2) {
                throw e2;
            } catch (RuntimeException e3) {
                throw c(charSequence, e3);
            }
        } else {
            throw new IllegalArgumentException("At least two types must be specified");
        }
    }

    public TemporalAccessor w(CharSequence charSequence, ParsePosition parsePosition) {
        return x(charSequence, parsePosition);
    }
}
