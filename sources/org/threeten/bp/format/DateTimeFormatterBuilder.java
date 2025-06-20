package org.threeten.bp.format;

import androidx.media3.extractor.AacUtil;
import com.airbnb.lottie.utils.Utils;
import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.text.pdf.Barcode128;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import org.apache.commons.lang3.ClassUtils;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.format.SimpleDateTimeTextProvider;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.IsoFields;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.WeekFields;
import org.threeten.bp.zone.ZoneRulesProvider;

public final class DateTimeFormatterBuilder {

    /* renamed from: h  reason: collision with root package name */
    private static final TemporalQuery<ZoneId> f31812h = new TemporalQuery<ZoneId>() {
        /* renamed from: b */
        public ZoneId a(TemporalAccessor temporalAccessor) {
            ZoneId zoneId = (ZoneId) temporalAccessor.i(TemporalQueries.g());
            if (zoneId == null || (zoneId instanceof ZoneOffset)) {
                return null;
            }
            return zoneId;
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private static final Map<Character, TemporalField> f31813i;

    /* renamed from: j  reason: collision with root package name */
    static final Comparator<String> f31814j = new Comparator<String>() {
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.length() == str2.length() ? str.compareTo(str2) : str.length() - str2.length();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private DateTimeFormatterBuilder f31815a;

    /* renamed from: b  reason: collision with root package name */
    private final DateTimeFormatterBuilder f31816b;

    /* renamed from: c  reason: collision with root package name */
    private final List<DateTimePrinterParser> f31817c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f31818d;

    /* renamed from: e  reason: collision with root package name */
    private int f31819e;

    /* renamed from: f  reason: collision with root package name */
    private char f31820f;

    /* renamed from: g  reason: collision with root package name */
    private int f31821g;

    /* renamed from: org.threeten.bp.format.DateTimeFormatterBuilder$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31824a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                org.threeten.bp.format.SignStyle[] r0 = org.threeten.bp.format.SignStyle.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31824a = r0
                org.threeten.bp.format.SignStyle r1 = org.threeten.bp.format.SignStyle.EXCEEDS_PAD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31824a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.threeten.bp.format.SignStyle r1 = org.threeten.bp.format.SignStyle.ALWAYS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31824a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.threeten.bp.format.SignStyle r1 = org.threeten.bp.format.SignStyle.NORMAL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f31824a     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.threeten.bp.format.SignStyle r1 = org.threeten.bp.format.SignStyle.NOT_NEGATIVE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.format.DateTimeFormatterBuilder.AnonymousClass4.<clinit>():void");
        }
    }

    static final class CharLiteralPrinterParser implements DateTimePrinterParser {
        private final char s;

        CharLiteralPrinterParser(char c2) {
            this.s = c2;
        }

        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i2) {
            if (i2 == charSequence.length()) {
                return ~i2;
            }
            return !dateTimeParseContext.c(this.s, charSequence.charAt(i2)) ? ~i2 : i2 + 1;
        }

        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            sb.append(this.s);
            return true;
        }

        public String toString() {
            if (this.s == '\'') {
                return "''";
            }
            return "'" + this.s + "'";
        }
    }

    static final class ChronoPrinterParser implements DateTimePrinterParser {
        private final TextStyle s;

        ChronoPrinterParser(TextStyle textStyle) {
            this.s = textStyle;
        }

        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i2) {
            if (i2 < 0 || i2 > charSequence.length()) {
                throw new IndexOutOfBoundsException();
            }
            Chronology chronology = null;
            int i3 = -1;
            for (Chronology next : Chronology.r()) {
                String v = next.v();
                int length = v.length();
                if (length > i3 && dateTimeParseContext.v(charSequence, i2, v, 0, length)) {
                    chronology = next;
                    i3 = length;
                }
            }
            if (chronology == null) {
                return ~i2;
            }
            dateTimeParseContext.q(chronology);
            return i2 + i3;
        }

        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Chronology chronology = (Chronology) dateTimePrintContext.g(TemporalQueries.a());
            if (chronology == null) {
                return false;
            }
            if (this.s != null) {
                try {
                    sb.append(ResourceBundle.getBundle("org.threeten.bp.format.ChronologyText", dateTimePrintContext.c(), DateTimeFormatterBuilder.class.getClassLoader()).getString(chronology.v()));
                    return true;
                } catch (MissingResourceException unused) {
                }
            }
            sb.append(chronology.v());
            return true;
        }
    }

    static final class CompositePrinterParser implements DateTimePrinterParser {
        private final boolean X;
        private final DateTimePrinterParser[] s;

        CompositePrinterParser(List<DateTimePrinterParser> list, boolean z) {
            this((DateTimePrinterParser[]) list.toArray(new DateTimePrinterParser[list.size()]), z);
        }

        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i2) {
            if (this.X) {
                dateTimeParseContext.u();
                int i3 = i2;
                for (DateTimePrinterParser a2 : this.s) {
                    i3 = a2.a(dateTimeParseContext, charSequence, i3);
                    if (i3 < 0) {
                        dateTimeParseContext.g(false);
                        return i2;
                    }
                }
                dateTimeParseContext.g(true);
                return i3;
            }
            for (DateTimePrinterParser a3 : this.s) {
                i2 = a3.a(dateTimeParseContext, charSequence, i2);
                if (i2 < 0) {
                    break;
                }
            }
            return i2;
        }

        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            int length = sb.length();
            if (this.X) {
                dateTimePrintContext.j();
            }
            try {
                for (DateTimePrinterParser b2 : this.s) {
                    if (!b2.b(dateTimePrintContext, sb)) {
                        sb.setLength(length);
                        return true;
                    }
                }
                if (this.X) {
                    dateTimePrintContext.b();
                }
                return true;
            } finally {
                if (this.X) {
                    dateTimePrintContext.b();
                }
            }
        }

        public CompositePrinterParser c(boolean z) {
            return z == this.X ? this : new CompositePrinterParser(this.s, z);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.s != null) {
                sb.append(this.X ? "[" : "(");
                for (DateTimePrinterParser append : this.s) {
                    sb.append(append);
                }
                sb.append(this.X ? "]" : ")");
            }
            return sb.toString();
        }

        CompositePrinterParser(DateTimePrinterParser[] dateTimePrinterParserArr, boolean z) {
            this.s = dateTimePrinterParserArr;
            this.X = z;
        }
    }

    interface DateTimePrinterParser {
        int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i2);

        boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb);
    }

    static class DefaultingParser implements DateTimePrinterParser {
        private final long X;
        private final TemporalField s;

        DefaultingParser(TemporalField temporalField, long j2) {
            this.s = temporalField;
            this.X = j2;
        }

        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i2) {
            if (dateTimeParseContext.j(this.s) == null) {
                dateTimeParseContext.r(this.s, this.X, i2, i2);
            }
            return i2;
        }

        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            return true;
        }
    }

    static final class FractionPrinterParser implements DateTimePrinterParser {
        private final int X;
        private final int Y;
        private final boolean Z;
        private final TemporalField s;

        FractionPrinterParser(TemporalField temporalField, int i2, int i3, boolean z) {
            Jdk8Methods.j(temporalField, "field");
            if (!temporalField.h().g()) {
                throw new IllegalArgumentException("Field must have a fixed set of values: " + temporalField);
            } else if (i2 < 0 || i2 > 9) {
                throw new IllegalArgumentException("Minimum width must be from 0 to 9 inclusive but was " + i2);
            } else if (i3 < 1 || i3 > 9) {
                throw new IllegalArgumentException("Maximum width must be from 1 to 9 inclusive but was " + i3);
            } else if (i3 >= i2) {
                this.s = temporalField;
                this.X = i2;
                this.Y = i3;
                this.Z = z;
            } else {
                throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + i3 + " < " + i2);
            }
        }

        private long c(BigDecimal bigDecimal) {
            ValueRange h2 = this.s.h();
            BigDecimal valueOf = BigDecimal.valueOf(h2.e());
            return bigDecimal.multiply(BigDecimal.valueOf(h2.d()).subtract(valueOf).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(valueOf).longValueExact();
        }

        private BigDecimal d(long j2) {
            ValueRange h2 = this.s.h();
            h2.b(j2, this.s);
            BigDecimal valueOf = BigDecimal.valueOf(h2.e());
            BigDecimal divide = BigDecimal.valueOf(j2).subtract(valueOf).divide(BigDecimal.valueOf(h2.d()).subtract(valueOf).add(BigDecimal.ONE), 9, RoundingMode.FLOOR);
            BigDecimal bigDecimal = BigDecimal.ZERO;
            return divide.compareTo(bigDecimal) == 0 ? bigDecimal : a.a(divide);
        }

        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i2) {
            int i3 = 0;
            int i4 = dateTimeParseContext.m() ? this.X : 0;
            int i5 = dateTimeParseContext.m() ? this.Y : 9;
            int length = charSequence.length();
            if (i2 == length) {
                return i4 > 0 ? ~i2 : i2;
            }
            if (this.Z) {
                if (charSequence.charAt(i2) != dateTimeParseContext.k().e()) {
                    return i4 > 0 ? ~i2 : i2;
                }
                i2++;
            }
            int i6 = i2;
            int i7 = i4 + i6;
            if (i7 > length) {
                return ~i6;
            }
            int min = Math.min(i5 + i6, length);
            int i8 = i6;
            while (true) {
                if (i8 >= min) {
                    break;
                }
                int i9 = i8 + 1;
                int b2 = dateTimeParseContext.k().b(charSequence.charAt(i8));
                if (b2 >= 0) {
                    i3 = (i3 * 10) + b2;
                    i8 = i9;
                } else if (i9 < i7) {
                    return ~i6;
                }
            }
            return dateTimeParseContext.r(this.s, c(new BigDecimal(i3).movePointLeft(i8 - i6)), i6, i8);
        }

        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long f2 = dateTimePrintContext.f(this.s);
            if (f2 == null) {
                return false;
            }
            DecimalStyle d2 = dateTimePrintContext.d();
            BigDecimal d3 = d(f2.longValue());
            if (d3.scale() != 0) {
                String a2 = d2.a(d3.setScale(Math.min(Math.max(d3.scale(), this.X), this.Y), RoundingMode.FLOOR).toPlainString().substring(2));
                if (this.Z) {
                    sb.append(d2.e());
                }
                sb.append(a2);
                return true;
            } else if (this.X <= 0) {
                return true;
            } else {
                if (this.Z) {
                    sb.append(d2.e());
                }
                for (int i2 = 0; i2 < this.X; i2++) {
                    sb.append(d2.h());
                }
                return true;
            }
        }

        public String toString() {
            String str = this.Z ? ",DecimalPoint" : "";
            return "Fraction(" + this.s + "," + this.X + "," + this.Y + str + ")";
        }
    }

    static final class InstantPrinterParser implements DateTimePrinterParser {
        private static final long X = 315569520000L;
        private static final long Y = 62167219200L;
        private final int s;

        InstantPrinterParser(int i2) {
            this.s = i2;
        }

        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i2) {
            int i3;
            int i4;
            int i5 = i2;
            DateTimeParseContext e2 = dateTimeParseContext.e();
            int i6 = this.s;
            int i7 = 0;
            int i8 = i6 < 0 ? 0 : i6;
            if (i6 < 0) {
                i6 = 9;
            }
            DateTimeFormatterBuilder h2 = new DateTimeFormatterBuilder().a(DateTimeFormatter.f31798h).h(ASCIIPropertyListParser.C);
            ChronoField chronoField = ChronoField.HOUR_OF_DAY;
            DateTimeFormatterBuilder h3 = h2.u(chronoField, 2).h(ASCIIPropertyListParser.A);
            ChronoField chronoField2 = ChronoField.MINUTE_OF_HOUR;
            DateTimeFormatterBuilder h4 = h3.u(chronoField2, 2).h(ASCIIPropertyListParser.A);
            ChronoField chronoField3 = ChronoField.SECOND_OF_MINUTE;
            DateTimeFormatterBuilder u = h4.u(chronoField3, 2);
            ChronoField chronoField4 = ChronoField.NANO_OF_SECOND;
            int a2 = u.d(chronoField4, i8, i6, true).h(ASCIIPropertyListParser.D).P().C(false).a(e2, charSequence, i5);
            if (a2 < 0) {
                return a2;
            }
            long longValue = e2.j(ChronoField.YEAR).longValue();
            int intValue = e2.j(ChronoField.MONTH_OF_YEAR).intValue();
            int intValue2 = e2.j(ChronoField.DAY_OF_MONTH).intValue();
            int intValue3 = e2.j(chronoField).intValue();
            int intValue4 = e2.j(chronoField2).intValue();
            Long j2 = e2.j(chronoField3);
            Long j3 = e2.j(chronoField4);
            int intValue5 = j2 != null ? j2.intValue() : 0;
            int intValue6 = j3 != null ? j3.intValue() : 0;
            int i9 = ((int) longValue) % 10000;
            if (intValue3 == 24 && intValue4 == 0 && intValue5 == 0 && intValue6 == 0) {
                i3 = intValue5;
                i7 = 1;
                i4 = 0;
            } else if (intValue3 == 23 && intValue4 == 59 && intValue5 == 60) {
                dateTimeParseContext.s();
                i4 = intValue3;
                i3 = 59;
            } else {
                i4 = intValue3;
                i3 = intValue5;
            }
            try {
                DateTimeParseContext dateTimeParseContext2 = dateTimeParseContext;
                int i10 = i2;
                return dateTimeParseContext2.r(chronoField4, (long) intValue6, i10, dateTimeParseContext2.r(ChronoField.INSTANT_SECONDS, Jdk8Methods.o(longValue / 10000, X) + LocalDateTime.i2(i9, intValue, intValue2, i4, intValue4, i3, 0).E2((long) i7).L(ZoneOffset.g3), i10, a2));
            } catch (RuntimeException unused) {
                return ~i5;
            }
        }

        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            int i2;
            StringBuilder sb2 = sb;
            Long f2 = dateTimePrintContext.f(ChronoField.INSTANT_SECONDS);
            Long l2 = 0L;
            TemporalAccessor e2 = dateTimePrintContext.e();
            ChronoField chronoField = ChronoField.NANO_OF_SECOND;
            if (e2.m(chronoField)) {
                l2 = Long.valueOf(dateTimePrintContext.e().p(chronoField));
            }
            int i3 = 0;
            if (f2 == null) {
                return false;
            }
            long longValue = f2.longValue();
            int m2 = chronoField.m(l2.longValue());
            if (longValue >= -62167219200L) {
                long j2 = longValue - 253402300800L;
                long e3 = Jdk8Methods.e(j2, X) + 1;
                LocalDateTime q2 = LocalDateTime.q2(Jdk8Methods.h(j2, X) - Y, 0, ZoneOffset.g3);
                if (e3 > 0) {
                    sb2.append('+');
                    sb2.append(e3);
                }
                sb2.append(q2);
                if (q2.S1() == 0) {
                    sb2.append(":00");
                }
            } else {
                long j3 = longValue + Y;
                long j4 = j3 / X;
                long j5 = j3 % X;
                LocalDateTime q22 = LocalDateTime.q2(j5 - Y, 0, ZoneOffset.g3);
                int length = sb.length();
                sb2.append(q22);
                if (q22.S1() == 0) {
                    sb2.append(":00");
                }
                if (j4 < 0) {
                    if (q22.M0() == -10000) {
                        sb2.replace(length, length + 2, Long.toString(j4 - 1));
                    } else {
                        if (j5 != 0) {
                            length++;
                            j4 = Math.abs(j4);
                        }
                        sb2.insert(length, j4);
                    }
                }
            }
            int i4 = this.s;
            if (i4 == -2) {
                if (m2 != 0) {
                    sb2.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                    int i5 = 1000000;
                    if (m2 % 1000000 == 0) {
                        i2 = (m2 / 1000000) + 1000;
                    } else {
                        if (m2 % 1000 == 0) {
                            m2 /= 1000;
                        } else {
                            i5 = Utils.f17347a;
                        }
                        i2 = m2 + i5;
                    }
                    sb2.append(Integer.toString(i2).substring(1));
                }
            } else if (i4 > 0 || (i4 == -1 && m2 > 0)) {
                sb2.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                int i6 = 100000000;
                while (true) {
                    int i7 = this.s;
                    if ((i7 != -1 || m2 <= 0) && i3 >= i7) {
                        break;
                    }
                    int i8 = m2 / i6;
                    sb2.append((char) (i8 + 48));
                    m2 -= i8 * i6;
                    i6 /= 10;
                    i3++;
                }
            }
            sb2.append(ASCIIPropertyListParser.D);
            return true;
        }

        public String toString() {
            return "Instant()";
        }
    }

    static final class LocalizedOffsetPrinterParser implements DateTimePrinterParser {
        private final TextStyle s;

        public LocalizedOffsetPrinterParser(TextStyle textStyle) {
            this.s = textStyle;
        }

        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i2) {
            char charAt;
            CharSequence charSequence2 = charSequence;
            int i3 = i2;
            if (!dateTimeParseContext.v(charSequence, i2, "GMT", 0, 3)) {
                return ~i3;
            }
            int i4 = i3 + 3;
            if (this.s == TextStyle.FULL) {
                return new OffsetIdPrinterParser("", "+HH:MM:ss").a(dateTimeParseContext, charSequence2, i4);
            }
            DateTimeParseContext dateTimeParseContext2 = dateTimeParseContext;
            int length = charSequence.length();
            if (i4 == length) {
                return dateTimeParseContext.r(ChronoField.OFFSET_SECONDS, 0, i4, i4);
            }
            char charAt2 = charSequence2.charAt(i4);
            if (charAt2 != '+' && charAt2 != '-') {
                return dateTimeParseContext.r(ChronoField.OFFSET_SECONDS, 0, i4, i4);
            }
            int i5 = charAt2 == '-' ? -1 : 1;
            if (i4 == length) {
                return ~i4;
            }
            int i6 = i3 + 4;
            char charAt3 = charSequence2.charAt(i6);
            if (charAt3 < '0' || charAt3 > '9') {
                return ~i6;
            }
            int i7 = i3 + 5;
            int i8 = charAt3 - '0';
            if (i7 != length && (charAt = charSequence2.charAt(i7)) >= '0' && charAt <= '9') {
                i8 = (i8 * 10) + (charAt - '0');
                if (i8 > 23) {
                    return ~i7;
                }
                i7 = i3 + 6;
            }
            int i9 = i7;
            if (i9 == length || charSequence2.charAt(i9) != ':') {
                return dateTimeParseContext.r(ChronoField.OFFSET_SECONDS, (long) (i5 * 3600 * i8), i9, i9);
            }
            int i10 = i9 + 1;
            int i11 = length - 2;
            if (i10 > i11) {
                return ~i10;
            }
            char charAt4 = charSequence2.charAt(i10);
            if (charAt4 < '0' || charAt4 > '9') {
                return ~i10;
            }
            int i12 = i9 + 2;
            int i13 = charAt4 - '0';
            char charAt5 = charSequence2.charAt(i12);
            if (charAt5 < '0' || charAt5 > '9') {
                return ~i12;
            }
            int i14 = i9 + 3;
            int i15 = (i13 * 10) + (charAt5 - '0');
            if (i15 > 59) {
                return ~i14;
            }
            if (i14 == length || charSequence2.charAt(i14) != ':') {
                return dateTimeParseContext.r(ChronoField.OFFSET_SECONDS, (long) (i5 * ((i8 * 3600) + (i15 * 60))), i14, i14);
            }
            int i16 = i9 + 4;
            if (i16 > i11) {
                return ~i16;
            }
            char charAt6 = charSequence2.charAt(i16);
            if (charAt6 < '0' || charAt6 > '9') {
                return ~i16;
            }
            int i17 = i9 + 5;
            int i18 = charAt6 - '0';
            char charAt7 = charSequence2.charAt(i17);
            if (charAt7 < '0' || charAt7 > '9') {
                return ~i17;
            }
            int i19 = i9 + 6;
            int i20 = (i18 * 10) + (charAt7 - '0');
            if (i20 > 59) {
                return ~i19;
            }
            return dateTimeParseContext.r(ChronoField.OFFSET_SECONDS, (long) (i5 * ((i8 * 3600) + (i15 * 60) + i20)), i19, i19);
        }

        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long f2 = dateTimePrintContext.f(ChronoField.OFFSET_SECONDS);
            if (f2 == null) {
                return false;
            }
            sb.append("GMT");
            if (this.s == TextStyle.FULL) {
                return new OffsetIdPrinterParser("", "+HH:MM:ss").b(dateTimePrintContext, sb);
            }
            int r = Jdk8Methods.r(f2.longValue());
            if (r == 0) {
                return true;
            }
            int abs = Math.abs((r / 3600) % 100);
            int abs2 = Math.abs((r / 60) % 60);
            int abs3 = Math.abs(r % 60);
            sb.append(r < 0 ? "-" : "+");
            sb.append(abs);
            if (abs2 <= 0 && abs3 <= 0) {
                return true;
            }
            sb.append(":");
            sb.append((char) ((abs2 / 10) + 48));
            sb.append((char) ((abs2 % 10) + 48));
            if (abs3 <= 0) {
                return true;
            }
            sb.append(":");
            sb.append((char) ((abs3 / 10) + 48));
            sb.append((char) ((abs3 % 10) + 48));
            return true;
        }
    }

    static final class LocalizedPrinterParser implements DateTimePrinterParser {
        private final FormatStyle X;
        private final FormatStyle s;

        LocalizedPrinterParser(FormatStyle formatStyle, FormatStyle formatStyle2) {
            this.s = formatStyle;
            this.X = formatStyle2;
        }

        private DateTimeFormatter c(Locale locale, Chronology chronology) {
            return DateTimeFormatStyleProvider.c().b(this.s, this.X, chronology, locale);
        }

        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i2) {
            return c(dateTimeParseContext.i(), dateTimeParseContext.h()).C(false).a(dateTimeParseContext, charSequence, i2);
        }

        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            return c(dateTimePrintContext.c(), Chronology.q(dateTimePrintContext.e())).C(false).b(dateTimePrintContext, sb);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Localized(");
            Object obj = this.s;
            Object obj2 = "";
            if (obj == null) {
                obj = obj2;
            }
            sb.append(obj);
            sb.append(",");
            Object obj3 = this.X;
            if (obj3 != null) {
                obj2 = obj3;
            }
            sb.append(obj2);
            sb.append(")");
            return sb.toString();
        }
    }

    static class NumberPrinterParser implements DateTimePrinterParser {
        static final int[] Y2 = {0, 10, 100, 1000, 10000, AacUtil.f12876f, 1000000, 10000000, 100000000, Utils.f17347a};
        final int X;
        final int X2;
        final int Y;
        final SignStyle Z;
        final TemporalField s;

        NumberPrinterParser(TemporalField temporalField, int i2, int i3, SignStyle signStyle) {
            this.s = temporalField;
            this.X = i2;
            this.Y = i3;
            this.Z = signStyle;
            this.X2 = 0;
        }

        /* JADX WARNING: Removed duplicated region for block: B:105:0x015f  */
        /* JADX WARNING: Removed duplicated region for block: B:110:0x017d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int a(org.threeten.bp.format.DateTimeParseContext r20, java.lang.CharSequence r21, int r22) {
            /*
                r19 = this;
                r6 = r19
                r0 = r22
                int r1 = r21.length()
                if (r0 != r1) goto L_0x000c
                int r0 = ~r0
                return r0
            L_0x000c:
                char r2 = r21.charAt(r22)
                org.threeten.bp.format.DecimalStyle r3 = r20.k()
                char r3 = r3.g()
                r4 = 0
                r5 = 1
                if (r2 != r3) goto L_0x0039
                org.threeten.bp.format.SignStyle r2 = r6.Z
                boolean r3 = r20.m()
                int r7 = r6.X
                int r8 = r6.Y
                if (r7 != r8) goto L_0x002a
                r7 = 1
                goto L_0x002b
            L_0x002a:
                r7 = 0
            L_0x002b:
                boolean r2 = r2.a(r5, r3, r7)
                if (r2 != 0) goto L_0x0033
                int r0 = ~r0
                return r0
            L_0x0033:
                int r0 = r0 + 1
                r7 = r0
                r0 = 0
                r2 = 1
                goto L_0x0071
            L_0x0039:
                org.threeten.bp.format.DecimalStyle r3 = r20.k()
                char r3 = r3.f()
                if (r2 != r3) goto L_0x0060
                org.threeten.bp.format.SignStyle r2 = r6.Z
                boolean r3 = r20.m()
                int r7 = r6.X
                int r8 = r6.Y
                if (r7 != r8) goto L_0x0051
                r7 = 1
                goto L_0x0052
            L_0x0051:
                r7 = 0
            L_0x0052:
                boolean r2 = r2.a(r4, r3, r7)
                if (r2 != 0) goto L_0x005a
                int r0 = ~r0
                return r0
            L_0x005a:
                int r0 = r0 + 1
                r7 = r0
                r0 = 1
            L_0x005e:
                r2 = 0
                goto L_0x0071
            L_0x0060:
                org.threeten.bp.format.SignStyle r2 = r6.Z
                org.threeten.bp.format.SignStyle r3 = org.threeten.bp.format.SignStyle.ALWAYS
                if (r2 != r3) goto L_0x006e
                boolean r2 = r20.m()
                if (r2 == 0) goto L_0x006e
                int r0 = ~r0
                return r0
            L_0x006e:
                r7 = r0
                r0 = 0
                goto L_0x005e
            L_0x0071:
                boolean r3 = r20.m()
                if (r3 != 0) goto L_0x0080
                boolean r3 = r19.d(r20)
                if (r3 == 0) goto L_0x007e
                goto L_0x0080
            L_0x007e:
                r3 = 1
                goto L_0x0082
            L_0x0080:
                int r3 = r6.X
            L_0x0082:
                int r8 = r7 + r3
                if (r8 <= r1) goto L_0x0088
                int r0 = ~r7
                return r0
            L_0x0088:
                boolean r9 = r20.m()
                if (r9 != 0) goto L_0x0098
                boolean r9 = r19.d(r20)
                if (r9 == 0) goto L_0x0095
                goto L_0x0098
            L_0x0095:
                r9 = 9
                goto L_0x009a
            L_0x0098:
                int r9 = r6.Y
            L_0x009a:
                int r10 = r6.X2
                int r10 = java.lang.Math.max(r10, r4)
                int r9 = r9 + r10
            L_0x00a1:
                r10 = 2
                r13 = 0
                if (r4 >= r10) goto L_0x010f
                int r9 = r9 + r7
                int r9 = java.lang.Math.min(r9, r1)
                r10 = r7
                r14 = 0
            L_0x00ad:
                if (r10 >= r9) goto L_0x00f8
                int r16 = r10 + 1
                r11 = r21
                char r12 = r11.charAt(r10)
                org.threeten.bp.format.DecimalStyle r5 = r20.k()
                int r5 = r5.b(r12)
                if (r5 >= 0) goto L_0x00c8
                if (r10 >= r8) goto L_0x00c5
                int r0 = ~r7
                return r0
            L_0x00c5:
                r22 = r8
                goto L_0x00fb
            L_0x00c8:
                int r10 = r16 - r7
                r12 = 18
                if (r10 <= r12) goto L_0x00e8
                if (r13 != 0) goto L_0x00d4
                java.math.BigInteger r13 = java.math.BigInteger.valueOf(r14)
            L_0x00d4:
                java.math.BigInteger r10 = java.math.BigInteger.TEN
                java.math.BigInteger r10 = r13.multiply(r10)
                long r12 = (long) r5
                java.math.BigInteger r5 = java.math.BigInteger.valueOf(r12)
                java.math.BigInteger r5 = r10.add(r5)
                r13 = r5
                r22 = r8
                r12 = r9
                goto L_0x00f1
            L_0x00e8:
                r17 = 10
                long r14 = r14 * r17
                r22 = r8
                r12 = r9
                long r8 = (long) r5
                long r14 = r14 + r8
            L_0x00f1:
                r8 = r22
                r9 = r12
                r10 = r16
                r5 = 1
                goto L_0x00ad
            L_0x00f8:
                r11 = r21
                goto L_0x00c5
            L_0x00fb:
                int r5 = r6.X2
                if (r5 <= 0) goto L_0x010d
                if (r4 != 0) goto L_0x010d
                int r10 = r10 - r7
                int r10 = r10 - r5
                int r9 = java.lang.Math.max(r3, r10)
                int r4 = r4 + 1
                r8 = r22
                r5 = 1
                goto L_0x00a1
            L_0x010d:
                r5 = r10
                goto L_0x0112
            L_0x010f:
                r5 = r7
                r14 = 0
            L_0x0112:
                if (r0 == 0) goto L_0x0141
                if (r13 == 0) goto L_0x012e
                java.math.BigInteger r0 = java.math.BigInteger.ZERO
                boolean r0 = r13.equals(r0)
                if (r0 == 0) goto L_0x0128
                boolean r0 = r20.m()
                if (r0 == 0) goto L_0x0128
                r0 = 1
                int r7 = r7 - r0
                int r0 = ~r7
                return r0
            L_0x0128:
                java.math.BigInteger r13 = r13.negate()
            L_0x012c:
                r2 = r14
                goto L_0x015d
            L_0x012e:
                r0 = 1
                r1 = 0
                int r3 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
                if (r3 != 0) goto L_0x013e
                boolean r1 = r20.m()
                if (r1 == 0) goto L_0x013e
                int r7 = r7 - r0
                int r0 = ~r7
                return r0
            L_0x013e:
                long r0 = -r14
                r2 = r0
                goto L_0x015d
            L_0x0141:
                org.threeten.bp.format.SignStyle r0 = r6.Z
                org.threeten.bp.format.SignStyle r1 = org.threeten.bp.format.SignStyle.EXCEEDS_PAD
                if (r0 != r1) goto L_0x012c
                boolean r0 = r20.m()
                if (r0 == 0) goto L_0x012c
                int r0 = r5 - r7
                int r1 = r6.X
                if (r2 == 0) goto L_0x0159
                if (r0 > r1) goto L_0x012c
                r0 = 1
                int r7 = r7 - r0
                int r0 = ~r7
                return r0
            L_0x0159:
                if (r0 <= r1) goto L_0x012c
                int r0 = ~r7
                return r0
            L_0x015d:
                if (r13 == 0) goto L_0x017d
                int r0 = r13.bitLength()
                r1 = 63
                if (r0 <= r1) goto L_0x016f
                java.math.BigInteger r0 = java.math.BigInteger.TEN
                java.math.BigInteger r13 = r13.divide(r0)
                int r5 = r5 + -1
            L_0x016f:
                long r2 = r13.longValue()
                r0 = r19
                r1 = r20
                r4 = r7
                int r0 = r0.e(r1, r2, r4, r5)
                return r0
            L_0x017d:
                r0 = r19
                r1 = r20
                r4 = r7
                int r0 = r0.e(r1, r2, r4, r5)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser.a(org.threeten.bp.format.DateTimeParseContext, java.lang.CharSequence, int):int");
        }

        /* JADX WARNING: Removed duplicated region for block: B:32:0x00a3 A[LOOP:0: B:30:0x009a->B:32:0x00a3, LOOP_END] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean b(org.threeten.bp.format.DateTimePrintContext r12, java.lang.StringBuilder r13) {
            /*
                r11 = this;
                org.threeten.bp.temporal.TemporalField r0 = r11.s
                java.lang.Long r0 = r12.f(r0)
                r1 = 0
                if (r0 != 0) goto L_0x000a
                return r1
            L_0x000a:
                long r2 = r0.longValue()
                long r2 = r11.c(r12, r2)
                org.threeten.bp.format.DecimalStyle r12 = r12.d()
                r4 = -9223372036854775808
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 != 0) goto L_0x001f
                java.lang.String r0 = "9223372036854775808"
                goto L_0x0027
            L_0x001f:
                long r4 = java.lang.Math.abs(r2)
                java.lang.String r0 = java.lang.Long.toString(r4)
            L_0x0027:
                int r4 = r0.length()
                int r5 = r11.Y
                java.lang.String r6 = " cannot be printed as the value "
                java.lang.String r7 = "Field "
                if (r4 > r5) goto L_0x00b1
                java.lang.String r0 = r12.a(r0)
                r4 = 0
                r8 = 2
                r9 = 1
                int r10 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                int[] r4 = org.threeten.bp.format.DateTimeFormatterBuilder.AnonymousClass4.f31824a
                org.threeten.bp.format.SignStyle r5 = r11.Z
                int r5 = r5.ordinal()
                if (r10 < 0) goto L_0x0066
                r4 = r4[r5]
                if (r4 == r9) goto L_0x0056
                if (r4 == r8) goto L_0x004e
                goto L_0x009a
            L_0x004e:
                char r2 = r12.g()
            L_0x0052:
                r13.append(r2)
                goto L_0x009a
            L_0x0056:
                int r4 = r11.X
                r5 = 19
                if (r4 >= r5) goto L_0x009a
                int[] r5 = Y2
                r4 = r5[r4]
                long r4 = (long) r4
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 < 0) goto L_0x009a
                goto L_0x004e
            L_0x0066:
                r4 = r4[r5]
                if (r4 == r9) goto L_0x0095
                if (r4 == r8) goto L_0x0095
                r5 = 3
                if (r4 == r5) goto L_0x0095
                r5 = 4
                if (r4 == r5) goto L_0x0073
                goto L_0x009a
            L_0x0073:
                org.threeten.bp.DateTimeException r12 = new org.threeten.bp.DateTimeException
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>()
                r13.append(r7)
                org.threeten.bp.temporal.TemporalField r0 = r11.s
                r13.append(r0)
                r13.append(r6)
                r13.append(r2)
                java.lang.String r0 = " cannot be negative according to the SignStyle"
                r13.append(r0)
                java.lang.String r13 = r13.toString()
                r12.<init>(r13)
                throw r12
            L_0x0095:
                char r2 = r12.f()
                goto L_0x0052
            L_0x009a:
                int r2 = r11.X
                int r3 = r0.length()
                int r2 = r2 - r3
                if (r1 >= r2) goto L_0x00ad
                char r2 = r12.h()
                r13.append(r2)
                int r1 = r1 + 1
                goto L_0x009a
            L_0x00ad:
                r13.append(r0)
                return r9
            L_0x00b1:
                org.threeten.bp.DateTimeException r12 = new org.threeten.bp.DateTimeException
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>()
                r13.append(r7)
                org.threeten.bp.temporal.TemporalField r0 = r11.s
                r13.append(r0)
                r13.append(r6)
                r13.append(r2)
                java.lang.String r0 = " exceeds the maximum print width of "
                r13.append(r0)
                int r0 = r11.Y
                r13.append(r0)
                java.lang.String r13 = r13.toString()
                r12.<init>(r13)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser.b(org.threeten.bp.format.DateTimePrintContext, java.lang.StringBuilder):boolean");
        }

        /* access modifiers changed from: package-private */
        public long c(DateTimePrintContext dateTimePrintContext, long j2) {
            return j2;
        }

        /* access modifiers changed from: package-private */
        public boolean d(DateTimeParseContext dateTimeParseContext) {
            int i2 = this.X2;
            return i2 == -1 || (i2 > 0 && this.X == this.Y && this.Z == SignStyle.NOT_NEGATIVE);
        }

        /* access modifiers changed from: package-private */
        public int e(DateTimeParseContext dateTimeParseContext, long j2, int i2, int i3) {
            return dateTimeParseContext.r(this.s, j2, i2, i3);
        }

        /* access modifiers changed from: package-private */
        public NumberPrinterParser f() {
            return this.X2 == -1 ? this : new NumberPrinterParser(this.s, this.X, this.Y, this.Z, -1);
        }

        /* access modifiers changed from: package-private */
        public NumberPrinterParser g(int i2) {
            return new NumberPrinterParser(this.s, this.X, this.Y, this.Z, this.X2 + i2);
        }

        public String toString() {
            StringBuilder sb;
            Object obj;
            int i2 = this.X;
            if (i2 == 1 && this.Y == 19 && this.Z == SignStyle.NORMAL) {
                sb = new StringBuilder();
                sb.append("Value(");
                obj = this.s;
            } else if (i2 == this.Y && this.Z == SignStyle.NOT_NEGATIVE) {
                sb = new StringBuilder();
                sb.append("Value(");
                sb.append(this.s);
                sb.append(",");
                sb.append(this.X);
                sb.append(")");
                return sb.toString();
            } else {
                sb = new StringBuilder();
                sb.append("Value(");
                sb.append(this.s);
                sb.append(",");
                sb.append(this.X);
                sb.append(",");
                sb.append(this.Y);
                sb.append(",");
                obj = this.Z;
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }

        private NumberPrinterParser(TemporalField temporalField, int i2, int i3, SignStyle signStyle, int i4) {
            this.s = temporalField;
            this.X = i2;
            this.Y = i3;
            this.Z = signStyle;
            this.X2 = i4;
        }
    }

    static final class OffsetIdPrinterParser implements DateTimePrinterParser {
        static final String[] Y = {"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS"};
        static final OffsetIdPrinterParser Z = new OffsetIdPrinterParser("Z", "+HH:MM:ss");
        private final int X;
        private final String s;

        OffsetIdPrinterParser(String str, String str2) {
            Jdk8Methods.j(str, "noOffsetText");
            Jdk8Methods.j(str2, "pattern");
            this.s = str;
            this.X = c(str2);
        }

        private int c(String str) {
            int i2 = 0;
            while (true) {
                String[] strArr = Y;
                if (i2 >= strArr.length) {
                    throw new IllegalArgumentException("Invalid zone offset pattern: " + str);
                } else if (strArr[i2].equals(str)) {
                    return i2;
                } else {
                    i2++;
                }
            }
        }

        private boolean d(int[] iArr, int i2, CharSequence charSequence, boolean z) {
            int i3;
            int i4 = this.X;
            if ((i4 + 3) / 2 < i2) {
                return false;
            }
            int i5 = iArr[0];
            if (i4 % 2 == 0 && i2 > 1) {
                int i6 = i5 + 1;
                if (i6 > charSequence.length() || charSequence.charAt(i5) != ':') {
                    return z;
                }
                i5 = i6;
            }
            if (i5 + 2 > charSequence.length()) {
                return z;
            }
            int i7 = i5 + 1;
            char charAt = charSequence.charAt(i5);
            int i8 = i5 + 2;
            char charAt2 = charSequence.charAt(i7);
            if (charAt < '0' || charAt > '9' || charAt2 < '0' || charAt2 > '9' || (i3 = ((charAt - '0') * 10) + (charAt2 - '0')) < 0 || i3 > 59) {
                return z;
            }
            iArr[i2] = i3;
            iArr[0] = i8;
            return false;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0034, code lost:
            if (r16.v(r17, r18, r0.s, 0, r9) != false) goto L_0x0036;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int a(org.threeten.bp.format.DateTimeParseContext r16, java.lang.CharSequence r17, int r18) {
            /*
                r15 = this;
                r0 = r15
                r7 = r17
                r8 = r18
                int r1 = r17.length()
                java.lang.String r2 = r0.s
                int r9 = r2.length()
                if (r9 != 0) goto L_0x0022
                if (r8 != r1) goto L_0x0041
                org.threeten.bp.temporal.ChronoField r2 = org.threeten.bp.temporal.ChronoField.OFFSET_SECONDS
                r3 = 0
                r1 = r16
                r5 = r18
                r6 = r18
            L_0x001d:
                int r1 = r1.r(r2, r3, r5, r6)
                return r1
            L_0x0022:
                if (r8 != r1) goto L_0x0026
                int r1 = ~r8
                return r1
            L_0x0026:
                java.lang.String r4 = r0.s
                r5 = 0
                r1 = r16
                r2 = r17
                r3 = r18
                r6 = r9
                boolean r1 = r1.v(r2, r3, r4, r5, r6)
                if (r1 == 0) goto L_0x0041
            L_0x0036:
                org.threeten.bp.temporal.ChronoField r2 = org.threeten.bp.temporal.ChronoField.OFFSET_SECONDS
                r3 = 0
                int r6 = r8 + r9
                r1 = r16
                r5 = r18
                goto L_0x001d
            L_0x0041:
                char r1 = r17.charAt(r18)
                r2 = 43
                r3 = 45
                if (r1 == r2) goto L_0x004d
                if (r1 != r3) goto L_0x0098
            L_0x004d:
                r2 = 1
                if (r1 != r3) goto L_0x0052
                r1 = -1
                goto L_0x0053
            L_0x0052:
                r1 = 1
            L_0x0053:
                r3 = 4
                int[] r3 = new int[r3]
                int r4 = r8 + 1
                r5 = 0
                r3[r5] = r4
                boolean r4 = r15.d(r3, r2, r7, r2)
                if (r4 != 0) goto L_0x0098
                int r4 = r0.X
                r6 = 3
                if (r4 < r6) goto L_0x0068
                r4 = 1
                goto L_0x0069
            L_0x0068:
                r4 = 0
            L_0x0069:
                r10 = 2
                boolean r4 = r15.d(r3, r10, r7, r4)
                if (r4 != 0) goto L_0x0098
                boolean r4 = r15.d(r3, r6, r7, r5)
                if (r4 == 0) goto L_0x0077
                goto L_0x0098
            L_0x0077:
                long r11 = (long) r1
                r1 = r3[r2]
                long r1 = (long) r1
                r13 = 3600(0xe10, double:1.7786E-320)
                long r1 = r1 * r13
                r4 = r3[r10]
                long r9 = (long) r4
                r13 = 60
                long r9 = r9 * r13
                long r1 = r1 + r9
                r4 = r3[r6]
                long r6 = (long) r4
                long r1 = r1 + r6
                long r6 = r11 * r1
                org.threeten.bp.temporal.ChronoField r2 = org.threeten.bp.temporal.ChronoField.OFFSET_SECONDS
                r9 = r3[r5]
                r1 = r16
                r3 = r6
                r5 = r18
                r6 = r9
                goto L_0x001d
            L_0x0098:
                if (r9 != 0) goto L_0x009b
                goto L_0x0036
            L_0x009b:
                int r1 = ~r8
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.format.DateTimeFormatterBuilder.OffsetIdPrinterParser.a(org.threeten.bp.format.DateTimeParseContext, java.lang.CharSequence, int):int");
        }

        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long f2 = dateTimePrintContext.f(ChronoField.OFFSET_SECONDS);
            if (f2 == null) {
                return false;
            }
            int r = Jdk8Methods.r(f2.longValue());
            if (r != 0) {
                int abs = Math.abs((r / 3600) % 100);
                int abs2 = Math.abs((r / 60) % 60);
                int abs3 = Math.abs(r % 60);
                int length = sb.length();
                sb.append(r < 0 ? "-" : "+");
                sb.append((char) ((abs / 10) + 48));
                sb.append((char) ((abs % 10) + 48));
                int i2 = this.X;
                if (i2 >= 3 || (i2 >= 1 && abs2 > 0)) {
                    String str = "";
                    sb.append(i2 % 2 == 0 ? ":" : str);
                    sb.append((char) ((abs2 / 10) + 48));
                    sb.append((char) ((abs2 % 10) + 48));
                    abs += abs2;
                    int i3 = this.X;
                    if (i3 >= 7 || (i3 >= 5 && abs3 > 0)) {
                        if (i3 % 2 == 0) {
                            str = ":";
                        }
                        sb.append(str);
                        sb.append((char) ((abs3 / 10) + 48));
                        sb.append((char) ((abs3 % 10) + 48));
                        abs += abs3;
                    }
                }
                if (abs == 0) {
                    sb.setLength(length);
                }
                return true;
            }
            sb.append(this.s);
            return true;
        }

        public String toString() {
            String replace = this.s.replace("'", "''");
            return "Offset(" + Y[this.X] + ",'" + replace + "')";
        }
    }

    static final class PadPrinterParserDecorator implements DateTimePrinterParser {
        private final int X;
        private final char Y;
        private final DateTimePrinterParser s;

        PadPrinterParserDecorator(DateTimePrinterParser dateTimePrinterParser, int i2, char c2) {
            this.s = dateTimePrinterParser;
            this.X = i2;
            this.Y = c2;
        }

        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i2) {
            boolean m2 = dateTimeParseContext.m();
            boolean l2 = dateTimeParseContext.l();
            if (i2 > charSequence.length()) {
                throw new IndexOutOfBoundsException();
            } else if (i2 == charSequence.length()) {
                return ~i2;
            } else {
                int i3 = this.X + i2;
                if (i3 > charSequence.length()) {
                    if (m2) {
                        return ~i2;
                    }
                    i3 = charSequence.length();
                }
                int i4 = i2;
                while (i4 < i3) {
                    char charAt = charSequence.charAt(i4);
                    char c2 = this.Y;
                    if (!l2) {
                        if (!dateTimeParseContext.c(charAt, c2)) {
                            break;
                        }
                    } else if (charAt != c2) {
                        break;
                    }
                    i4++;
                }
                int a2 = this.s.a(dateTimeParseContext, charSequence.subSequence(0, i3), i4);
                return (a2 == i3 || !m2) ? a2 : ~(i2 + i4);
            }
        }

        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            int length = sb.length();
            if (!this.s.b(dateTimePrintContext, sb)) {
                return false;
            }
            int length2 = sb.length() - length;
            if (length2 <= this.X) {
                for (int i2 = 0; i2 < this.X - length2; i2++) {
                    sb.insert(length, this.Y);
                }
                return true;
            }
            throw new DateTimeException("Cannot print as output of " + length2 + " characters exceeds pad width of " + this.X);
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("Pad(");
            sb.append(this.s);
            sb.append(",");
            sb.append(this.X);
            if (this.Y == ' ') {
                str = ")";
            } else {
                str = ",'" + this.Y + "')";
            }
            sb.append(str);
            return sb.toString();
        }
    }

    static final class ReducedPrinterParser extends NumberPrinterParser {
        static final LocalDate b3 = LocalDate.r2(2000, 1, 1);
        private final int Z2;
        private final ChronoLocalDate a3;

        ReducedPrinterParser(TemporalField temporalField, int i2, int i3, int i4, ChronoLocalDate chronoLocalDate) {
            super(temporalField, i2, i3, SignStyle.NOT_NEGATIVE);
            if (i2 < 1 || i2 > 10) {
                throw new IllegalArgumentException("The width must be from 1 to 10 inclusive but was " + i2);
            } else if (i3 < 1 || i3 > 10) {
                throw new IllegalArgumentException("The maxWidth must be from 1 to 10 inclusive but was " + i3);
            } else if (i3 >= i2) {
                if (chronoLocalDate == null) {
                    long j2 = (long) i4;
                    if (!temporalField.h().j(j2)) {
                        throw new IllegalArgumentException("The base value must be within the range of the field");
                    } else if (j2 + ((long) NumberPrinterParser.Y2[i2]) > 2147483647L) {
                        throw new DateTimeException("Unable to add printer-parser as the range exceeds the capacity of an int");
                    }
                }
                this.Z2 = i4;
                this.a3 = chronoLocalDate;
            } else {
                throw new IllegalArgumentException("The maxWidth must be greater than the width");
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x002d, code lost:
            if (r7 < ((long) (r2 + r6))) goto L_0x002f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long c(org.threeten.bp.format.DateTimePrintContext r6, long r7) {
            /*
                r5 = this;
                long r0 = java.lang.Math.abs(r7)
                int r2 = r5.Z2
                org.threeten.bp.chrono.ChronoLocalDate r3 = r5.a3
                if (r3 == 0) goto L_0x001e
                org.threeten.bp.temporal.TemporalAccessor r6 = r6.e()
                org.threeten.bp.chrono.Chronology r6 = org.threeten.bp.chrono.Chronology.q(r6)
                org.threeten.bp.chrono.ChronoLocalDate r2 = r5.a3
                org.threeten.bp.chrono.ChronoLocalDate r6 = r6.e(r2)
                org.threeten.bp.temporal.TemporalField r2 = r5.s
                int r2 = r6.b(r2)
            L_0x001e:
                long r3 = (long) r2
                int r6 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
                if (r6 < 0) goto L_0x0032
                int[] r6 = org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser.Y2
                int r3 = r5.X
                r6 = r6[r3]
                int r2 = r2 + r6
                long r2 = (long) r2
                int r4 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
                if (r4 >= 0) goto L_0x0032
            L_0x002f:
                long r6 = (long) r6
                long r0 = r0 % r6
                return r0
            L_0x0032:
                int[] r6 = org.threeten.bp.format.DateTimeFormatterBuilder.NumberPrinterParser.Y2
                int r7 = r5.Y
                r6 = r6[r7]
                goto L_0x002f
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.format.DateTimeFormatterBuilder.ReducedPrinterParser.c(org.threeten.bp.format.DateTimePrintContext, long):long");
        }

        /* access modifiers changed from: package-private */
        public boolean d(DateTimeParseContext dateTimeParseContext) {
            if (!dateTimeParseContext.m()) {
                return false;
            }
            return super.d(dateTimeParseContext);
        }

        /* access modifiers changed from: package-private */
        public int e(DateTimeParseContext dateTimeParseContext, long j2, int i2, int i3) {
            int i4 = this.Z2;
            if (this.a3 != null) {
                i4 = dateTimeParseContext.h().e(this.a3).b(this.s);
                dateTimeParseContext.b(this, j2, i2, i3);
            }
            int i5 = i3 - i2;
            int i6 = this.X;
            if (i5 == i6 && j2 >= 0) {
                long j3 = (long) NumberPrinterParser.Y2[i6];
                long j4 = (long) i4;
                long j5 = j4 - (j4 % j3);
                j2 = i4 > 0 ? j5 + j2 : j5 - j2;
                if (j2 < j4) {
                    j2 += j3;
                }
            }
            return dateTimeParseContext.r(this.s, j2, i2, i3);
        }

        /* access modifiers changed from: package-private */
        public NumberPrinterParser f() {
            return this.X2 == -1 ? this : new ReducedPrinterParser(this.s, this.X, this.Y, this.Z2, this.a3, -1);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public ReducedPrinterParser g(int i2) {
            return new ReducedPrinterParser(this.s, this.X, this.Y, this.Z2, this.a3, this.X2 + i2);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ReducedValue(");
            sb.append(this.s);
            sb.append(",");
            sb.append(this.X);
            sb.append(",");
            sb.append(this.Y);
            sb.append(",");
            Object obj = this.a3;
            if (obj == null) {
                obj = Integer.valueOf(this.Z2);
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }

        private ReducedPrinterParser(TemporalField temporalField, int i2, int i3, int i4, ChronoLocalDate chronoLocalDate, int i5) {
            super(temporalField, i2, i3, SignStyle.NOT_NEGATIVE, i5);
            this.Z2 = i4;
            this.a3 = chronoLocalDate;
        }
    }

    enum SettingsParser implements DateTimePrinterParser {
        SENSITIVE,
        INSENSITIVE,
        STRICT,
        LENIENT;

        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i2) {
            int ordinal = ordinal();
            if (ordinal == 0) {
                dateTimeParseContext.n(true);
            } else if (ordinal == 1) {
                dateTimeParseContext.n(false);
            } else if (ordinal == 2) {
                dateTimeParseContext.t(true);
            } else if (ordinal == 3) {
                dateTimeParseContext.t(false);
            }
            return i2;
        }

        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            return true;
        }

        public String toString() {
            int ordinal = ordinal();
            if (ordinal == 0) {
                return "ParseCaseSensitive(true)";
            }
            if (ordinal == 1) {
                return "ParseCaseSensitive(false)";
            }
            if (ordinal == 2) {
                return "ParseStrict(true)";
            }
            if (ordinal == 3) {
                return "ParseStrict(false)";
            }
            throw new IllegalStateException("Unreachable");
        }
    }

    static final class StringLiteralPrinterParser implements DateTimePrinterParser {
        private final String s;

        StringLiteralPrinterParser(String str) {
            this.s = str;
        }

        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i2) {
            if (i2 > charSequence.length() || i2 < 0) {
                throw new IndexOutOfBoundsException();
            }
            String str = this.s;
            return !dateTimeParseContext.v(charSequence, i2, str, 0, str.length()) ? ~i2 : i2 + this.s.length();
        }

        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            sb.append(this.s);
            return true;
        }

        public String toString() {
            String replace = this.s.replace("'", "''");
            return "'" + replace + "'";
        }
    }

    static final class TextPrinterParser implements DateTimePrinterParser {
        private final TextStyle X;
        private final DateTimeTextProvider Y;
        private volatile NumberPrinterParser Z;
        private final TemporalField s;

        TextPrinterParser(TemporalField temporalField, TextStyle textStyle, DateTimeTextProvider dateTimeTextProvider) {
            this.s = temporalField;
            this.X = textStyle;
            this.Y = dateTimeTextProvider;
        }

        private NumberPrinterParser c() {
            if (this.Z == null) {
                this.Z = new NumberPrinterParser(this.s, 1, 19, SignStyle.NORMAL);
            }
            return this.Z;
        }

        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i2) {
            int length = charSequence.length();
            if (i2 < 0 || i2 > length) {
                throw new IndexOutOfBoundsException();
            }
            Iterator<Map.Entry<String, Long>> d2 = this.Y.d(this.s, dateTimeParseContext.m() ? this.X : null, dateTimeParseContext.i());
            if (d2 != null) {
                while (d2.hasNext()) {
                    Map.Entry next = d2.next();
                    String str = (String) next.getKey();
                    if (dateTimeParseContext.v(str, 0, charSequence, i2, str.length())) {
                        return dateTimeParseContext.r(this.s, ((Long) next.getValue()).longValue(), i2, i2 + str.length());
                    }
                }
                if (dateTimeParseContext.m()) {
                    return ~i2;
                }
            }
            return c().a(dateTimeParseContext, charSequence, i2);
        }

        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            Long f2 = dateTimePrintContext.f(this.s);
            if (f2 == null) {
                return false;
            }
            String c2 = this.Y.c(this.s, f2.longValue(), this.X, dateTimePrintContext.c());
            if (c2 == null) {
                return c().b(dateTimePrintContext, sb);
            }
            sb.append(c2);
            return true;
        }

        public String toString() {
            StringBuilder sb;
            Object obj;
            if (this.X == TextStyle.FULL) {
                sb = new StringBuilder();
                sb.append("Text(");
                obj = this.s;
            } else {
                sb = new StringBuilder();
                sb.append("Text(");
                sb.append(this.s);
                sb.append(",");
                obj = this.X;
            }
            sb.append(obj);
            sb.append(")");
            return sb.toString();
        }
    }

    static final class WeekFieldsPrinterParser implements DateTimePrinterParser {
        private final int X;
        private final char s;

        public WeekFieldsPrinterParser(char c2, int i2) {
            this.s = c2;
            this.X = i2;
        }

        private DateTimePrinterParser c(WeekFields weekFields) {
            char c2 = this.s;
            if (c2 == 'W') {
                return new NumberPrinterParser(weekFields.i(), 1, 2, SignStyle.NOT_NEGATIVE);
            }
            if (c2 != 'Y') {
                if (c2 == 'c') {
                    return new NumberPrinterParser(weekFields.b(), this.X, 2, SignStyle.NOT_NEGATIVE);
                }
                if (c2 == 'e') {
                    return new NumberPrinterParser(weekFields.b(), this.X, 2, SignStyle.NOT_NEGATIVE);
                }
                if (c2 != 'w') {
                    return null;
                }
                return new NumberPrinterParser(weekFields.j(), this.X, 2, SignStyle.NOT_NEGATIVE);
            } else if (this.X == 2) {
                return new ReducedPrinterParser(weekFields.h(), 2, 2, 0, ReducedPrinterParser.b3);
            } else {
                TemporalField h2 = weekFields.h();
                int i2 = this.X;
                return new NumberPrinterParser(h2, i2, 19, i2 < 4 ? SignStyle.NORMAL : SignStyle.EXCEEDS_PAD, -1);
            }
        }

        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i2) {
            return c(WeekFields.e(dateTimeParseContext.i())).a(dateTimeParseContext, charSequence, i2);
        }

        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            return c(WeekFields.e(dateTimePrintContext.c())).b(dateTimePrintContext, sb);
        }

        public String toString() {
            String str;
            String str2;
            StringBuilder sb = new StringBuilder(30);
            sb.append("Localized(");
            char c2 = this.s;
            if (c2 == 'Y') {
                int i2 = this.X;
                if (i2 == 1) {
                    str2 = "WeekBasedYear";
                } else if (i2 == 2) {
                    str2 = "ReducedValue(WeekBasedYear,2,2,2000-01-01)";
                } else {
                    sb.append("WeekBasedYear,");
                    sb.append(this.X);
                    sb.append(",");
                    sb.append(19);
                    sb.append(",");
                    sb.append(this.X < 4 ? SignStyle.NORMAL : SignStyle.EXCEEDS_PAD);
                }
                sb.append(str2);
            } else {
                if (c2 == 'c' || c2 == 'e') {
                    str = "DayOfWeek";
                } else if (c2 == 'w') {
                    str = "WeekOfWeekBasedYear";
                } else {
                    if (c2 == 'W') {
                        str = "WeekOfMonth";
                    }
                    sb.append(",");
                    sb.append(this.X);
                }
                sb.append(str);
                sb.append(",");
                sb.append(this.X);
            }
            sb.append(")");
            return sb.toString();
        }
    }

    static final class ZoneIdPrinterParser implements DateTimePrinterParser {
        private static volatile Map.Entry<Integer, SubstringTree> Y;
        private final String X;
        private final TemporalQuery<ZoneId> s;

        private static final class SubstringTree {

            /* renamed from: a  reason: collision with root package name */
            final int f31825a;

            /* renamed from: b  reason: collision with root package name */
            private final Map<CharSequence, SubstringTree> f31826b;

            /* renamed from: c  reason: collision with root package name */
            private final Map<String, SubstringTree> f31827c;

            private SubstringTree(int i2) {
                this.f31826b = new HashMap();
                this.f31827c = new HashMap();
                this.f31825a = i2;
            }

            /* access modifiers changed from: private */
            public void c(String str) {
                int length = str.length();
                int i2 = this.f31825a;
                if (length == i2) {
                    this.f31826b.put(str, (Object) null);
                    this.f31827c.put(str.toLowerCase(Locale.ENGLISH), (Object) null);
                } else if (length > i2) {
                    String substring = str.substring(0, i2);
                    SubstringTree substringTree = this.f31826b.get(substring);
                    if (substringTree == null) {
                        substringTree = new SubstringTree(length);
                        this.f31826b.put(substring, substringTree);
                        this.f31827c.put(substring.toLowerCase(Locale.ENGLISH), substringTree);
                    }
                    substringTree.c(str);
                }
            }

            /* access modifiers changed from: private */
            public SubstringTree d(CharSequence charSequence, boolean z) {
                Map map;
                if (z) {
                    map = this.f31826b;
                } else {
                    map = this.f31827c;
                    charSequence = charSequence.toString().toLowerCase(Locale.ENGLISH);
                }
                return (SubstringTree) map.get(charSequence);
            }
        }

        ZoneIdPrinterParser(TemporalQuery<ZoneId> temporalQuery, String str) {
            this.s = temporalQuery;
            this.X = str;
        }

        private ZoneId c(Set<String> set, String str, boolean z) {
            if (str == null) {
                return null;
            }
            if (!z) {
                for (String next : set) {
                    if (next.equalsIgnoreCase(str)) {
                        return ZoneId.w(next);
                    }
                }
                return null;
            } else if (set.contains(str)) {
                return ZoneId.w(str);
            } else {
                return null;
            }
        }

        private int d(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i2, int i3) {
            int a2;
            String upperCase = charSequence.subSequence(i2, i3).toString().toUpperCase();
            DateTimeParseContext e2 = dateTimeParseContext.e();
            if ((i3 >= charSequence.length() || !dateTimeParseContext.c(charSequence.charAt(i3), ASCIIPropertyListParser.D)) && (a2 = OffsetIdPrinterParser.Z.a(e2, charSequence, i3)) >= 0) {
                dateTimeParseContext.p(ZoneId.y(upperCase, ZoneOffset.L((int) e2.j(ChronoField.OFFSET_SECONDS).longValue())));
                return a2;
            }
            dateTimeParseContext.p(ZoneId.y(upperCase, ZoneOffset.g3));
            return i3;
        }

        private static SubstringTree e(Set<String> set) {
            ArrayList<String> arrayList = new ArrayList<>(set);
            Collections.sort(arrayList, DateTimeFormatterBuilder.f31814j);
            SubstringTree substringTree = new SubstringTree(((String) arrayList.get(0)).length());
            for (String b2 : arrayList) {
                substringTree.c(b2);
            }
            return substringTree;
        }

        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i2) {
            int i3;
            int length = charSequence.length();
            if (i2 > length) {
                throw new IndexOutOfBoundsException();
            } else if (i2 == length) {
                return ~i2;
            } else {
                char charAt = charSequence.charAt(i2);
                if (charAt == '+' || charAt == '-') {
                    DateTimeParseContext e2 = dateTimeParseContext.e();
                    int a2 = OffsetIdPrinterParser.Z.a(e2, charSequence, i2);
                    if (a2 < 0) {
                        return a2;
                    }
                    dateTimeParseContext.p(ZoneOffset.L((int) e2.j(ChronoField.OFFSET_SECONDS).longValue()));
                    return a2;
                }
                int i4 = i2 + 2;
                if (length >= i4) {
                    char charAt2 = charSequence.charAt(i2 + 1);
                    if (dateTimeParseContext.c(charAt, 'U') && dateTimeParseContext.c(charAt2, ASCIIPropertyListParser.C)) {
                        int i5 = i2 + 3;
                        return (length < i5 || !dateTimeParseContext.c(charSequence.charAt(i4), 'C')) ? d(dateTimeParseContext, charSequence, i2, i4) : d(dateTimeParseContext, charSequence, i2, i5);
                    } else if (dateTimeParseContext.c(charAt, 'G') && length >= (i3 = i2 + 3) && dateTimeParseContext.c(charAt2, 'M') && dateTimeParseContext.c(charSequence.charAt(i4), ASCIIPropertyListParser.C)) {
                        return d(dateTimeParseContext, charSequence, i2, i3);
                    }
                }
                Set<String> a3 = ZoneRulesProvider.a();
                int size = a3.size();
                Map.Entry<Integer, SubstringTree> entry = Y;
                if (entry == null || entry.getKey().intValue() != size) {
                    synchronized (this) {
                        try {
                            entry = Y;
                            if (entry != null) {
                                if (entry.getKey().intValue() != size) {
                                }
                            }
                            entry = new AbstractMap.SimpleImmutableEntry<>(Integer.valueOf(size), e(a3));
                            Y = entry;
                        } catch (Throwable th) {
                            while (true) {
                                throw th;
                            }
                        }
                    }
                }
                SubstringTree value = entry.getValue();
                String str = null;
                String str2 = null;
                while (value != null) {
                    int i6 = value.f31825a + i2;
                    if (i6 > length) {
                        break;
                    }
                    String charSequence2 = charSequence.subSequence(i2, i6).toString();
                    value = value.d(charSequence2, dateTimeParseContext.l());
                    String str3 = charSequence2;
                    str2 = str;
                    str = str3;
                }
                ZoneId c2 = c(a3, str, dateTimeParseContext.l());
                if (c2 == null) {
                    c2 = c(a3, str2, dateTimeParseContext.l());
                    if (c2 != null) {
                        str = str2;
                    } else if (!dateTimeParseContext.c(charAt, ASCIIPropertyListParser.D)) {
                        return ~i2;
                    } else {
                        dateTimeParseContext.p(ZoneOffset.g3);
                        return i2 + 1;
                    }
                }
                dateTimeParseContext.p(c2);
                return i2 + str.length();
            }
        }

        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            ZoneId zoneId = (ZoneId) dateTimePrintContext.g(this.s);
            if (zoneId == null) {
                return false;
            }
            sb.append(zoneId.s());
            return true;
        }

        public String toString() {
            return this.X;
        }
    }

    static final class ZoneTextPrinterParser implements DateTimePrinterParser {
        private static final Comparator<String> X = new Comparator<String>() {
            /* renamed from: a */
            public int compare(String str, String str2) {
                int length = str2.length() - str.length();
                return length == 0 ? str.compareTo(str2) : length;
            }
        };
        private final TextStyle s;

        ZoneTextPrinterParser(TextStyle textStyle) {
            this.s = (TextStyle) Jdk8Methods.j(textStyle, "textStyle");
        }

        public int a(DateTimeParseContext dateTimeParseContext, CharSequence charSequence, int i2) {
            TreeMap treeMap = new TreeMap(X);
            for (String next : ZoneId.k()) {
                treeMap.put(next, next);
                TimeZone timeZone = TimeZone.getTimeZone(next);
                int i3 = this.s.a() == TextStyle.FULL ? 1 : 0;
                String displayName = timeZone.getDisplayName(false, i3, dateTimeParseContext.i());
                if (next.startsWith("Etc/") || (!displayName.startsWith("GMT+") && !displayName.startsWith("GMT+"))) {
                    treeMap.put(displayName, next);
                }
                String displayName2 = timeZone.getDisplayName(true, i3, dateTimeParseContext.i());
                if (next.startsWith("Etc/") || (!displayName2.startsWith("GMT+") && !displayName2.startsWith("GMT+"))) {
                    treeMap.put(displayName2, next);
                }
            }
            for (Map.Entry entry : treeMap.entrySet()) {
                String str = (String) entry.getKey();
                if (dateTimeParseContext.v(charSequence, i2, str, 0, str.length())) {
                    dateTimeParseContext.p(ZoneId.w((String) entry.getValue()));
                    return i2 + str.length();
                }
            }
            return ~i2;
        }

        public boolean b(DateTimePrintContext dateTimePrintContext, StringBuilder sb) {
            boolean z;
            String displayName;
            ZoneId zoneId = (ZoneId) dateTimePrintContext.g(TemporalQueries.g());
            int i2 = 0;
            if (zoneId == null) {
                return false;
            }
            if (zoneId.v() instanceof ZoneOffset) {
                displayName = zoneId.s();
            } else {
                TemporalAccessor e2 = dateTimePrintContext.e();
                ChronoField chronoField = ChronoField.INSTANT_SECONDS;
                if (e2.m(chronoField)) {
                    z = zoneId.u().i(Instant.h0(e2.p(chronoField)));
                } else {
                    z = false;
                }
                TimeZone timeZone = TimeZone.getTimeZone(zoneId.s());
                if (this.s.a() == TextStyle.FULL) {
                    i2 = 1;
                }
                displayName = timeZone.getDisplayName(z, i2, dateTimePrintContext.c());
            }
            sb.append(displayName);
            return true;
        }

        public String toString() {
            return "ZoneText(" + this.s + ")";
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f31813i = hashMap;
        hashMap.put('G', ChronoField.ERA);
        hashMap.put('y', ChronoField.YEAR_OF_ERA);
        hashMap.put('u', ChronoField.YEAR);
        TemporalField temporalField = IsoFields.f31853b;
        hashMap.put('Q', temporalField);
        hashMap.put('q', temporalField);
        ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
        hashMap.put('M', chronoField);
        hashMap.put('L', chronoField);
        hashMap.put(Character.valueOf(ASCIIPropertyListParser.t), ChronoField.DAY_OF_YEAR);
        hashMap.put(Character.valueOf(Barcode128.G), ChronoField.DAY_OF_MONTH);
        hashMap.put('F', ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        ChronoField chronoField2 = ChronoField.DAY_OF_WEEK;
        hashMap.put('E', chronoField2);
        hashMap.put(Character.valueOf(Barcode128.F), chronoField2);
        hashMap.put(Character.valueOf(Barcode128.H), chronoField2);
        hashMap.put('a', ChronoField.AMPM_OF_DAY);
        hashMap.put('H', ChronoField.HOUR_OF_DAY);
        hashMap.put('k', ChronoField.CLOCK_HOUR_OF_DAY);
        hashMap.put('K', ChronoField.HOUR_OF_AMPM);
        hashMap.put(Character.valueOf(Barcode128.K), ChronoField.CLOCK_HOUR_OF_AMPM);
        hashMap.put('m', ChronoField.MINUTE_OF_HOUR);
        hashMap.put('s', ChronoField.SECOND_OF_MINUTE);
        ChronoField chronoField3 = ChronoField.NANO_OF_SECOND;
        hashMap.put('S', chronoField3);
        hashMap.put('A', ChronoField.MILLI_OF_DAY);
        hashMap.put('n', chronoField3);
        hashMap.put(Character.valueOf(ASCIIPropertyListParser.w), ChronoField.NANO_OF_DAY);
    }

    public DateTimeFormatterBuilder() {
        this.f31815a = this;
        this.f31817c = new ArrayList();
        this.f31821g = -1;
        this.f31816b = null;
        this.f31818d = false;
    }

    public static String D(FormatStyle formatStyle, FormatStyle formatStyle2, Chronology chronology, Locale locale) {
        DateFormat dateFormat;
        Jdk8Methods.j(locale, "locale");
        Jdk8Methods.j(chronology, "chrono");
        if (formatStyle == null && formatStyle2 == null) {
            throw new IllegalArgumentException("Either dateStyle or timeStyle must be non-null");
        }
        if (formatStyle != null) {
            int ordinal = formatStyle.ordinal();
            dateFormat = formatStyle2 != null ? DateFormat.getDateTimeInstance(ordinal, formatStyle2.ordinal(), locale) : DateFormat.getDateInstance(ordinal, locale);
        } else {
            dateFormat = DateFormat.getTimeInstance(formatStyle2.ordinal(), locale);
        }
        if (dateFormat instanceof SimpleDateFormat) {
            return ((SimpleDateFormat) dateFormat).toPattern();
        }
        throw new IllegalArgumentException("Unable to determine pattern");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0038, code lost:
        if (r9 == 1) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0077, code lost:
        g(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void L(char r8, int r9, org.threeten.bp.temporal.TemporalField r10) {
        /*
            r7 = this;
            r0 = 81
            r1 = 5
            r2 = 3
            r3 = 4
            java.lang.String r4 = "Too many pattern letters: "
            r5 = 1
            r6 = 2
            if (r8 == r0) goto L_0x0193
            r0 = 83
            if (r8 == r0) goto L_0x018c
            r0 = 97
            if (r8 == r0) goto L_0x0173
            r0 = 104(0x68, float:1.46E-43)
            if (r8 == r0) goto L_0x0156
            r0 = 107(0x6b, float:1.5E-43)
            if (r8 == r0) goto L_0x0156
            r0 = 109(0x6d, float:1.53E-43)
            if (r8 == r0) goto L_0x0156
            r0 = 113(0x71, float:1.58E-43)
            if (r8 == r0) goto L_0x0131
            r0 = 115(0x73, float:1.61E-43)
            if (r8 == r0) goto L_0x0156
            r0 = 117(0x75, float:1.64E-43)
            if (r8 == r0) goto L_0x011a
            r0 = 121(0x79, float:1.7E-43)
            if (r8 == r0) goto L_0x011a
            switch(r8) {
                case 68: goto L_0x00fd;
                case 69: goto L_0x00dc;
                case 70: goto L_0x00c3;
                case 71: goto L_0x00dc;
                case 72: goto L_0x0156;
                default: goto L_0x0032;
            }
        L_0x0032:
            switch(r8) {
                case 75: goto L_0x0156;
                case 76: goto L_0x0131;
                case 77: goto L_0x0193;
                default: goto L_0x0035;
            }
        L_0x0035:
            switch(r8) {
                case 99: goto L_0x007c;
                case 100: goto L_0x0156;
                case 101: goto L_0x0044;
                default: goto L_0x0038;
            }
        L_0x0038:
            if (r9 != r5) goto L_0x003f
        L_0x003a:
            r7.t(r10)
            goto L_0x01b4
        L_0x003f:
            r7.u(r10, r9)
            goto L_0x01b4
        L_0x0044:
            if (r9 == r5) goto L_0x0070
            if (r9 == r6) goto L_0x0070
            if (r9 == r2) goto L_0x006d
            if (r9 == r3) goto L_0x006a
            if (r9 != r1) goto L_0x0055
        L_0x004e:
            org.threeten.bp.format.TextStyle r8 = org.threeten.bp.format.TextStyle.NARROW
        L_0x0050:
            r7.r(r10, r8)
            goto L_0x01b4
        L_0x0055:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r4)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.<init>(r8)
            throw r9
        L_0x006a:
            org.threeten.bp.format.TextStyle r8 = org.threeten.bp.format.TextStyle.FULL
            goto L_0x0050
        L_0x006d:
            org.threeten.bp.format.TextStyle r8 = org.threeten.bp.format.TextStyle.SHORT
            goto L_0x0050
        L_0x0070:
            org.threeten.bp.format.DateTimeFormatterBuilder$WeekFieldsPrinterParser r8 = new org.threeten.bp.format.DateTimeFormatterBuilder$WeekFieldsPrinterParser
            r10 = 101(0x65, float:1.42E-43)
            r8.<init>(r10, r9)
        L_0x0077:
            r7.g(r8)
            goto L_0x01b4
        L_0x007c:
            if (r9 == r5) goto L_0x00bb
            if (r9 == r6) goto L_0x00a4
            if (r9 == r2) goto L_0x00a1
            if (r9 == r3) goto L_0x009e
            if (r9 != r1) goto L_0x0089
        L_0x0086:
            org.threeten.bp.format.TextStyle r8 = org.threeten.bp.format.TextStyle.NARROW_STANDALONE
            goto L_0x0050
        L_0x0089:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r4)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.<init>(r8)
            throw r9
        L_0x009e:
            org.threeten.bp.format.TextStyle r8 = org.threeten.bp.format.TextStyle.FULL_STANDALONE
            goto L_0x0050
        L_0x00a1:
            org.threeten.bp.format.TextStyle r8 = org.threeten.bp.format.TextStyle.SHORT_STANDALONE
            goto L_0x0050
        L_0x00a4:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "Invalid number of pattern letters: "
            r10.append(r0)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.<init>(r8)
            throw r9
        L_0x00bb:
            org.threeten.bp.format.DateTimeFormatterBuilder$WeekFieldsPrinterParser r8 = new org.threeten.bp.format.DateTimeFormatterBuilder$WeekFieldsPrinterParser
            r10 = 99
            r8.<init>(r10, r9)
            goto L_0x0077
        L_0x00c3:
            if (r9 != r5) goto L_0x00c7
            goto L_0x003a
        L_0x00c7:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r4)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.<init>(r8)
            throw r9
        L_0x00dc:
            if (r9 == r5) goto L_0x006d
            if (r9 == r6) goto L_0x006d
            if (r9 == r2) goto L_0x006d
            if (r9 == r3) goto L_0x006a
            if (r9 != r1) goto L_0x00e8
            goto L_0x004e
        L_0x00e8:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r4)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.<init>(r8)
            throw r9
        L_0x00fd:
            if (r9 != r5) goto L_0x0101
            goto L_0x003a
        L_0x0101:
            if (r9 > r2) goto L_0x0105
            goto L_0x003f
        L_0x0105:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r4)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.<init>(r8)
            throw r9
        L_0x011a:
            if (r9 != r6) goto L_0x0123
            org.threeten.bp.LocalDate r8 = org.threeten.bp.format.DateTimeFormatterBuilder.ReducedPrinterParser.b3
            r7.x(r10, r6, r6, r8)
            goto L_0x01b4
        L_0x0123:
            r8 = 19
            if (r9 >= r3) goto L_0x012e
            org.threeten.bp.format.SignStyle r0 = org.threeten.bp.format.SignStyle.NORMAL
        L_0x0129:
            r7.v(r10, r9, r8, r0)
            goto L_0x01b4
        L_0x012e:
            org.threeten.bp.format.SignStyle r0 = org.threeten.bp.format.SignStyle.EXCEEDS_PAD
            goto L_0x0129
        L_0x0131:
            if (r9 == r5) goto L_0x003a
            if (r9 == r6) goto L_0x0152
            if (r9 == r2) goto L_0x00a1
            if (r9 == r3) goto L_0x009e
            if (r9 != r1) goto L_0x013d
            goto L_0x0086
        L_0x013d:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r4)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.<init>(r8)
            throw r9
        L_0x0152:
            r7.u(r10, r6)
            goto L_0x01b4
        L_0x0156:
            if (r9 != r5) goto L_0x015a
            goto L_0x003a
        L_0x015a:
            if (r9 != r6) goto L_0x015e
            goto L_0x003f
        L_0x015e:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r4)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.<init>(r8)
            throw r9
        L_0x0173:
            if (r9 != r5) goto L_0x0177
            goto L_0x006d
        L_0x0177:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r4)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.<init>(r8)
            throw r9
        L_0x018c:
            org.threeten.bp.temporal.ChronoField r8 = org.threeten.bp.temporal.ChronoField.NANO_OF_SECOND
            r10 = 0
            r7.d(r8, r9, r9, r10)
            goto L_0x01b4
        L_0x0193:
            if (r9 == r5) goto L_0x003a
            if (r9 == r6) goto L_0x0152
            if (r9 == r2) goto L_0x006d
            if (r9 == r3) goto L_0x006a
            if (r9 != r1) goto L_0x019f
            goto L_0x004e
        L_0x019f:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r4)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.<init>(r8)
            throw r9
        L_0x01b4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.format.DateTimeFormatterBuilder.L(char, int, org.threeten.bp.temporal.TemporalField):void");
    }

    private void N(String str) {
        WeekFieldsPrinterParser weekFieldsPrinterParser;
        String str2;
        String str3;
        TextStyle textStyle;
        int i2;
        int i3 = 0;
        while (i3 < str.length()) {
            char charAt = str.charAt(i3);
            if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
                int i4 = i3 + 1;
                while (i4 < str.length() && str.charAt(i4) == charAt) {
                    i4++;
                }
                int i5 = i4 - i3;
                if (charAt == 'p') {
                    if (i4 >= str.length() || (((charAt = str.charAt(i4)) < 'A' || charAt > 'Z') && (charAt < 'a' || charAt > 'z'))) {
                        i2 = i5;
                        i5 = 0;
                    } else {
                        int i6 = i4 + 1;
                        while (i6 < str.length() && str.charAt(i6) == charAt) {
                            i6++;
                        }
                        i2 = i6 - i4;
                        i4 = i6;
                    }
                    if (i5 != 0) {
                        G(i5);
                        i5 = i2;
                    } else {
                        throw new IllegalArgumentException("Pad letter 'p' must be followed by valid pad pattern: " + str);
                    }
                }
                TemporalField temporalField = f31813i.get(Character.valueOf(charAt));
                if (temporalField != null) {
                    L(charAt, i5, temporalField);
                } else if (charAt == 'z') {
                    if (i5 <= 4) {
                        B(i5 == 4 ? TextStyle.FULL : TextStyle.SHORT);
                    } else {
                        throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                    }
                } else if (charAt != 'V') {
                    String str4 = "+0000";
                    if (charAt == 'Z') {
                        if (i5 < 4) {
                            str2 = "+HHMM";
                        } else {
                            if (i5 != 4) {
                                if (i5 == 5) {
                                    str3 = "+HH:MM:ss";
                                    l(str3, "Z");
                                } else {
                                    throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                                }
                            }
                            textStyle = TextStyle.FULL;
                            k(textStyle);
                        }
                    } else if (charAt == 'O') {
                        if (i5 == 1) {
                            textStyle = TextStyle.SHORT;
                            k(textStyle);
                        } else {
                            if (i5 != 4) {
                                throw new IllegalArgumentException("Pattern letter count must be 1 or 4: " + charAt);
                            }
                            textStyle = TextStyle.FULL;
                            k(textStyle);
                        }
                    } else if (charAt == 'X') {
                        if (i5 <= 5) {
                            str3 = OffsetIdPrinterParser.Y[i5 + (i5 == 1 ? 0 : 1)];
                            l(str3, "Z");
                        } else {
                            throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                        }
                    } else if (charAt != 'x') {
                        if (charAt == 'W') {
                            if (i5 <= 1) {
                                weekFieldsPrinterParser = new WeekFieldsPrinterParser('W', i5);
                            } else {
                                throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                            }
                        } else if (charAt == 'w') {
                            if (i5 <= 2) {
                                weekFieldsPrinterParser = new WeekFieldsPrinterParser('w', i5);
                            } else {
                                throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                            }
                        } else if (charAt == 'Y') {
                            weekFieldsPrinterParser = new WeekFieldsPrinterParser(ASCIIPropertyListParser.v, i5);
                        } else {
                            throw new IllegalArgumentException("Unknown pattern letter: " + charAt);
                        }
                        g(weekFieldsPrinterParser);
                    } else if (i5 <= 5) {
                        if (i5 == 1) {
                            str4 = "+00";
                        } else if (i5 % 2 != 0) {
                            str4 = "+00:00";
                        }
                        str2 = OffsetIdPrinterParser.Y[i5 + (i5 == 1 ? 0 : 1)];
                    } else {
                        throw new IllegalArgumentException("Too many pattern letters: " + charAt);
                    }
                    l(str2, str4);
                } else if (i5 == 2) {
                    y();
                } else {
                    throw new IllegalArgumentException("Pattern letter count must be 2: " + charAt);
                }
                i3 = i4 - 1;
            } else if (charAt == '\'') {
                int i7 = i3 + 1;
                int i8 = i7;
                while (i8 < str.length()) {
                    if (str.charAt(i8) == '\'') {
                        int i9 = i8 + 1;
                        if (i9 >= str.length() || str.charAt(i9) != '\'') {
                            break;
                        }
                        i8 = i9;
                    }
                    i8++;
                }
                if (i8 < str.length()) {
                    String substring = str.substring(i7, i8);
                    if (substring.length() == 0) {
                        h('\'');
                    } else {
                        i(substring.replace("''", "'"));
                    }
                    i3 = i8;
                } else {
                    throw new IllegalArgumentException("Pattern ends with an incomplete string literal: " + str);
                }
            } else if (charAt == '[') {
                F();
            } else if (charAt == ']') {
                if (this.f31815a.f31816b != null) {
                    E();
                } else {
                    throw new IllegalArgumentException("Pattern invalid as it contains ] without previous [");
                }
            } else if (charAt == '{' || charAt == '}' || charAt == '#') {
                throw new IllegalArgumentException("Pattern includes reserved character: '" + charAt + "'");
            } else {
                h(charAt);
            }
            i3++;
        }
    }

    private int g(DateTimePrinterParser dateTimePrinterParser) {
        Jdk8Methods.j(dateTimePrinterParser, "pp");
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.f31815a;
        int i2 = dateTimeFormatterBuilder.f31819e;
        if (i2 > 0) {
            if (dateTimePrinterParser != null) {
                dateTimePrinterParser = new PadPrinterParserDecorator(dateTimePrinterParser, i2, dateTimeFormatterBuilder.f31820f);
            }
            DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.f31815a;
            dateTimeFormatterBuilder2.f31819e = 0;
            dateTimeFormatterBuilder2.f31820f = 0;
        }
        this.f31815a.f31817c.add(dateTimePrinterParser);
        DateTimeFormatterBuilder dateTimeFormatterBuilder3 = this.f31815a;
        dateTimeFormatterBuilder3.f31821g = -1;
        return dateTimeFormatterBuilder3.f31817c.size() - 1;
    }

    private DateTimeFormatterBuilder s(NumberPrinterParser numberPrinterParser) {
        NumberPrinterParser numberPrinterParser2;
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.f31815a;
        int i2 = dateTimeFormatterBuilder.f31821g;
        if (i2 < 0 || !(dateTimeFormatterBuilder.f31817c.get(i2) instanceof NumberPrinterParser)) {
            this.f31815a.f31821g = g(numberPrinterParser);
        } else {
            DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.f31815a;
            int i3 = dateTimeFormatterBuilder2.f31821g;
            NumberPrinterParser numberPrinterParser3 = (NumberPrinterParser) dateTimeFormatterBuilder2.f31817c.get(i3);
            int i4 = numberPrinterParser.X;
            int i5 = numberPrinterParser.Y;
            if (i4 == i5 && numberPrinterParser.Z == SignStyle.NOT_NEGATIVE) {
                numberPrinterParser2 = numberPrinterParser3.g(i5);
                g(numberPrinterParser.f());
                this.f31815a.f31821g = i3;
            } else {
                numberPrinterParser2 = numberPrinterParser3.f();
                this.f31815a.f31821g = g(numberPrinterParser);
            }
            this.f31815a.f31817c.set(i3, numberPrinterParser2);
        }
        return this;
    }

    public DateTimeFormatterBuilder A() {
        g(new ZoneIdPrinterParser(f31812h, "ZoneRegionId()"));
        return this;
    }

    public DateTimeFormatterBuilder B(TextStyle textStyle) {
        g(new ZoneTextPrinterParser(textStyle));
        return this;
    }

    public DateTimeFormatterBuilder C(TextStyle textStyle, Set<ZoneId> set) {
        Jdk8Methods.j(set, "preferredZones");
        g(new ZoneTextPrinterParser(textStyle));
        return this;
    }

    public DateTimeFormatterBuilder E() {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.f31815a;
        if (dateTimeFormatterBuilder.f31816b != null) {
            if (dateTimeFormatterBuilder.f31817c.size() > 0) {
                DateTimeFormatterBuilder dateTimeFormatterBuilder2 = this.f31815a;
                CompositePrinterParser compositePrinterParser = new CompositePrinterParser(dateTimeFormatterBuilder2.f31817c, dateTimeFormatterBuilder2.f31818d);
                this.f31815a = this.f31815a.f31816b;
                g(compositePrinterParser);
            } else {
                this.f31815a = this.f31815a.f31816b;
            }
            return this;
        }
        throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
    }

    public DateTimeFormatterBuilder F() {
        DateTimeFormatterBuilder dateTimeFormatterBuilder = this.f31815a;
        dateTimeFormatterBuilder.f31821g = -1;
        this.f31815a = new DateTimeFormatterBuilder(dateTimeFormatterBuilder, true);
        return this;
    }

    public DateTimeFormatterBuilder G(int i2) {
        return H(i2, ' ');
    }

    public DateTimeFormatterBuilder H(int i2, char c2) {
        if (i2 >= 1) {
            DateTimeFormatterBuilder dateTimeFormatterBuilder = this.f31815a;
            dateTimeFormatterBuilder.f31819e = i2;
            dateTimeFormatterBuilder.f31820f = c2;
            dateTimeFormatterBuilder.f31821g = -1;
            return this;
        }
        throw new IllegalArgumentException("The pad width must be at least one but was " + i2);
    }

    public DateTimeFormatterBuilder I() {
        g(SettingsParser.INSENSITIVE);
        return this;
    }

    public DateTimeFormatterBuilder J() {
        g(SettingsParser.SENSITIVE);
        return this;
    }

    public DateTimeFormatterBuilder K(TemporalField temporalField, long j2) {
        Jdk8Methods.j(temporalField, "field");
        g(new DefaultingParser(temporalField, j2));
        return this;
    }

    public DateTimeFormatterBuilder M() {
        g(SettingsParser.LENIENT);
        return this;
    }

    public DateTimeFormatterBuilder O() {
        g(SettingsParser.STRICT);
        return this;
    }

    public DateTimeFormatter P() {
        return Q(Locale.getDefault());
    }

    public DateTimeFormatter Q(Locale locale) {
        Jdk8Methods.j(locale, "locale");
        while (this.f31815a.f31816b != null) {
            E();
        }
        return new DateTimeFormatter(new CompositePrinterParser(this.f31817c, false), locale, DecimalStyle.f31841e, ResolverStyle.SMART, (Set<TemporalField>) null, (Chronology) null, (ZoneId) null);
    }

    /* access modifiers changed from: package-private */
    public DateTimeFormatter R(ResolverStyle resolverStyle) {
        return P().I(resolverStyle);
    }

    public DateTimeFormatterBuilder a(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.j(dateTimeFormatter, "formatter");
        g(dateTimeFormatter.C(false));
        return this;
    }

    public DateTimeFormatterBuilder b() {
        g(new ChronoPrinterParser((TextStyle) null));
        return this;
    }

    public DateTimeFormatterBuilder c(TextStyle textStyle) {
        Jdk8Methods.j(textStyle, "textStyle");
        g(new ChronoPrinterParser(textStyle));
        return this;
    }

    public DateTimeFormatterBuilder d(TemporalField temporalField, int i2, int i3, boolean z) {
        g(new FractionPrinterParser(temporalField, i2, i3, z));
        return this;
    }

    public DateTimeFormatterBuilder e() {
        g(new InstantPrinterParser(-2));
        return this;
    }

    public DateTimeFormatterBuilder f(int i2) {
        if (i2 < -1 || i2 > 9) {
            throw new IllegalArgumentException("Invalid fractional digits: " + i2);
        }
        g(new InstantPrinterParser(i2));
        return this;
    }

    public DateTimeFormatterBuilder h(char c2) {
        g(new CharLiteralPrinterParser(c2));
        return this;
    }

    public DateTimeFormatterBuilder i(String str) {
        Jdk8Methods.j(str, "literal");
        if (str.length() > 0) {
            g(str.length() == 1 ? new CharLiteralPrinterParser(str.charAt(0)) : new StringLiteralPrinterParser(str));
        }
        return this;
    }

    public DateTimeFormatterBuilder j(FormatStyle formatStyle, FormatStyle formatStyle2) {
        if (formatStyle == null && formatStyle2 == null) {
            throw new IllegalArgumentException("Either the date or time style must be non-null");
        }
        g(new LocalizedPrinterParser(formatStyle, formatStyle2));
        return this;
    }

    public DateTimeFormatterBuilder k(TextStyle textStyle) {
        Jdk8Methods.j(textStyle, "style");
        if (textStyle == TextStyle.FULL || textStyle == TextStyle.SHORT) {
            g(new LocalizedOffsetPrinterParser(textStyle));
            return this;
        }
        throw new IllegalArgumentException("Style must be either full or short");
    }

    public DateTimeFormatterBuilder l(String str, String str2) {
        g(new OffsetIdPrinterParser(str2, str));
        return this;
    }

    public DateTimeFormatterBuilder m() {
        g(OffsetIdPrinterParser.Z);
        return this;
    }

    public DateTimeFormatterBuilder n(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.j(dateTimeFormatter, "formatter");
        g(dateTimeFormatter.C(true));
        return this;
    }

    public DateTimeFormatterBuilder o(String str) {
        Jdk8Methods.j(str, "pattern");
        N(str);
        return this;
    }

    public DateTimeFormatterBuilder p(TemporalField temporalField) {
        return r(temporalField, TextStyle.FULL);
    }

    public DateTimeFormatterBuilder q(TemporalField temporalField, Map<Long, String> map) {
        Jdk8Methods.j(temporalField, "field");
        Jdk8Methods.j(map, "textLookup");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        TextStyle textStyle = TextStyle.FULL;
        final SimpleDateTimeTextProvider.LocaleStore localeStore = new SimpleDateTimeTextProvider.LocaleStore(Collections.singletonMap(textStyle, linkedHashMap));
        g(new TextPrinterParser(temporalField, textStyle, new DateTimeTextProvider() {
            public String c(TemporalField temporalField, long j2, TextStyle textStyle, Locale locale) {
                return localeStore.a(j2, textStyle);
            }

            public Iterator<Map.Entry<String, Long>> d(TemporalField temporalField, TextStyle textStyle, Locale locale) {
                return localeStore.b(textStyle);
            }
        }));
        return this;
    }

    public DateTimeFormatterBuilder r(TemporalField temporalField, TextStyle textStyle) {
        Jdk8Methods.j(temporalField, "field");
        Jdk8Methods.j(textStyle, "textStyle");
        g(new TextPrinterParser(temporalField, textStyle, DateTimeTextProvider.b()));
        return this;
    }

    public DateTimeFormatterBuilder t(TemporalField temporalField) {
        Jdk8Methods.j(temporalField, "field");
        s(new NumberPrinterParser(temporalField, 1, 19, SignStyle.NORMAL));
        return this;
    }

    public DateTimeFormatterBuilder u(TemporalField temporalField, int i2) {
        Jdk8Methods.j(temporalField, "field");
        if (i2 < 1 || i2 > 19) {
            throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + i2);
        }
        s(new NumberPrinterParser(temporalField, i2, i2, SignStyle.NOT_NEGATIVE));
        return this;
    }

    public DateTimeFormatterBuilder v(TemporalField temporalField, int i2, int i3, SignStyle signStyle) {
        if (i2 == i3 && signStyle == SignStyle.NOT_NEGATIVE) {
            return u(temporalField, i3);
        }
        Jdk8Methods.j(temporalField, "field");
        Jdk8Methods.j(signStyle, "signStyle");
        if (i2 < 1 || i2 > 19) {
            throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + i2);
        } else if (i3 < 1 || i3 > 19) {
            throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + i3);
        } else if (i3 >= i2) {
            s(new NumberPrinterParser(temporalField, i2, i3, signStyle));
            return this;
        } else {
            throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + i3 + " < " + i2);
        }
    }

    public DateTimeFormatterBuilder w(TemporalField temporalField, int i2, int i3, int i4) {
        Jdk8Methods.j(temporalField, "field");
        s(new ReducedPrinterParser(temporalField, i2, i3, i4, (ChronoLocalDate) null));
        return this;
    }

    public DateTimeFormatterBuilder x(TemporalField temporalField, int i2, int i3, ChronoLocalDate chronoLocalDate) {
        Jdk8Methods.j(temporalField, "field");
        Jdk8Methods.j(chronoLocalDate, "baseDate");
        s(new ReducedPrinterParser(temporalField, i2, i3, 0, chronoLocalDate));
        return this;
    }

    public DateTimeFormatterBuilder y() {
        g(new ZoneIdPrinterParser(TemporalQueries.g(), "ZoneId()"));
        return this;
    }

    public DateTimeFormatterBuilder z() {
        g(new ZoneIdPrinterParser(TemporalQueries.f(), "ZoneOrOffsetId()"));
        return this;
    }

    private DateTimeFormatterBuilder(DateTimeFormatterBuilder dateTimeFormatterBuilder, boolean z) {
        this.f31815a = this;
        this.f31817c = new ArrayList();
        this.f31821g = -1;
        this.f31816b = dateTimeFormatterBuilder;
        this.f31818d = z;
    }
}
