package okhttp3;

import com.dd.plist.ASCIIPropertyListParser;
import com.google.common.net.HttpHeaders;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;

public final class Cookie {

    /* renamed from: j  reason: collision with root package name */
    private static final Pattern f30825j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k  reason: collision with root package name */
    private static final Pattern f30826k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: l  reason: collision with root package name */
    private static final Pattern f30827l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: m  reason: collision with root package name */
    private static final Pattern f30828m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a  reason: collision with root package name */
    private final String f30829a;

    /* renamed from: b  reason: collision with root package name */
    private final String f30830b;

    /* renamed from: c  reason: collision with root package name */
    private final long f30831c;

    /* renamed from: d  reason: collision with root package name */
    private final String f30832d;

    /* renamed from: e  reason: collision with root package name */
    private final String f30833e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f30834f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f30835g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f30836h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f30837i;

    public static final class Builder {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        String f30838a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        String f30839b;

        /* renamed from: c  reason: collision with root package name */
        long f30840c = HttpDate.f31073a;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        String f30841d;

        /* renamed from: e  reason: collision with root package name */
        String f30842e = "/";

        /* renamed from: f  reason: collision with root package name */
        boolean f30843f;

        /* renamed from: g  reason: collision with root package name */
        boolean f30844g;

        /* renamed from: h  reason: collision with root package name */
        boolean f30845h;

        /* renamed from: i  reason: collision with root package name */
        boolean f30846i;

        private Builder c(String str, boolean z) {
            if (str != null) {
                String d2 = Util.d(str);
                if (d2 != null) {
                    this.f30841d = d2;
                    this.f30846i = z;
                    return this;
                }
                throw new IllegalArgumentException("unexpected domain: " + str);
            }
            throw new NullPointerException("domain == null");
        }

        public Cookie a() {
            return new Cookie(this);
        }

        public Builder b(String str) {
            return c(str, false);
        }

        public Builder d(long j2) {
            if (j2 <= 0) {
                j2 = Long.MIN_VALUE;
            }
            if (j2 > HttpDate.f31073a) {
                j2 = 253402300799999L;
            }
            this.f30840c = j2;
            this.f30845h = true;
            return this;
        }

        public Builder e(String str) {
            return c(str, true);
        }

        public Builder f() {
            this.f30844g = true;
            return this;
        }

        public Builder g(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str.trim().equals(str)) {
                this.f30838a = str;
                return this;
            } else {
                throw new IllegalArgumentException("name is not trimmed");
            }
        }

        public Builder h(String str) {
            if (str.startsWith("/")) {
                this.f30842e = str;
                return this;
            }
            throw new IllegalArgumentException("path must start with '/'");
        }

        public Builder i() {
            this.f30843f = true;
            return this;
        }

        public Builder j(String str) {
            if (str == null) {
                throw new NullPointerException("value == null");
            } else if (str.trim().equals(str)) {
                this.f30839b = str;
                return this;
            } else {
                throw new IllegalArgumentException("value is not trimmed");
            }
        }
    }

    private Cookie(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f30829a = str;
        this.f30830b = str2;
        this.f30831c = j2;
        this.f30832d = str3;
        this.f30833e = str4;
        this.f30834f = z;
        this.f30835g = z2;
        this.f30837i = z3;
        this.f30836h = z4;
    }

    private static int a(String str, int i2, int i3, boolean z) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (((charAt < ' ' && charAt != 9) || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    private static boolean c(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !Util.K(str);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0110  */
    @javax.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static okhttp3.Cookie i(long r23, okhttp3.HttpUrl r25, java.lang.String r26) {
        /*
            r0 = r26
            int r1 = r26.length()
            r2 = 0
            r3 = 59
            int r4 = okhttp3.internal.Util.o(r0, r2, r1, r3)
            r5 = 61
            int r6 = okhttp3.internal.Util.o(r0, r2, r4, r5)
            r7 = 0
            if (r6 != r4) goto L_0x0017
            return r7
        L_0x0017:
            java.lang.String r9 = okhttp3.internal.Util.J(r0, r2, r6)
            boolean r8 = r9.isEmpty()
            if (r8 != 0) goto L_0x0028
            int r8 = okhttp3.internal.Util.y(r9)
            r10 = -1
            if (r8 == r10) goto L_0x002b
        L_0x0028:
            r0 = r7
            goto L_0x0135
        L_0x002b:
            r8 = 1
            int r6 = r6 + r8
            java.lang.String r6 = okhttp3.internal.Util.J(r0, r6, r4)
            int r11 = okhttp3.internal.Util.y(r6)
            if (r11 == r10) goto L_0x0038
            return r7
        L_0x0038:
            int r4 = r4 + r8
            r10 = -1
            r12 = 253402300799999(0xe677d21fdbff, double:1.251973714024093E-309)
            r8 = r7
            r14 = r8
            r19 = r10
            r21 = r12
            r15 = 0
            r16 = 0
            r17 = 1
            r18 = 0
        L_0x004d:
            if (r4 >= r1) goto L_0x00bb
            int r7 = okhttp3.internal.Util.o(r0, r4, r1, r3)
            int r3 = okhttp3.internal.Util.o(r0, r4, r7, r5)
            java.lang.String r4 = okhttp3.internal.Util.J(r0, r4, r3)
            if (r3 >= r7) goto L_0x0064
            int r3 = r3 + 1
            java.lang.String r3 = okhttp3.internal.Util.J(r0, r3, r7)
            goto L_0x0066
        L_0x0064:
            java.lang.String r3 = ""
        L_0x0066:
            java.lang.String r5 = "expires"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0079
            int r4 = r3.length()     // Catch:{ IllegalArgumentException -> 0x00b3 }
            long r21 = m(r3, r2, r4)     // Catch:{ IllegalArgumentException -> 0x00b3 }
        L_0x0076:
            r18 = 1
            goto L_0x00b3
        L_0x0079:
            java.lang.String r5 = "max-age"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0086
            long r19 = n(r3)     // Catch:{  }
            goto L_0x0076
        L_0x0086:
            java.lang.String r5 = "domain"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0095
            java.lang.String r14 = l(r3)     // Catch:{ IllegalArgumentException -> 0x00b3 }
            r17 = 0
            goto L_0x00b3
        L_0x0095:
            java.lang.String r5 = "path"
            boolean r5 = r4.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x009f
            r8 = r3
            goto L_0x00b3
        L_0x009f:
            java.lang.String r3 = "secure"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x00a9
            r15 = 1
            goto L_0x00b3
        L_0x00a9:
            java.lang.String r3 = "httponly"
            boolean r3 = r4.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x00b3
            r16 = 1
        L_0x00b3:
            int r4 = r7 + 1
            r3 = 59
            r5 = 61
            r7 = 0
            goto L_0x004d
        L_0x00bb:
            r0 = -9223372036854775808
            int r3 = (r19 > r0 ? 1 : (r19 == r0 ? 0 : -1))
            if (r3 != 0) goto L_0x00c3
        L_0x00c1:
            r11 = r0
            goto L_0x00e8
        L_0x00c3:
            int r0 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
            if (r0 == 0) goto L_0x00e6
            r0 = 9223372036854775(0x20c49ba5e353f7, double:4.663754807431093E-308)
            int r3 = (r19 > r0 ? 1 : (r19 == r0 ? 0 : -1))
            if (r3 > 0) goto L_0x00d5
            r0 = 1000(0x3e8, double:4.94E-321)
            long r19 = r19 * r0
            goto L_0x00da
        L_0x00d5:
            r19 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x00da:
            long r0 = r23 + r19
            int r3 = (r0 > r23 ? 1 : (r0 == r23 ? 0 : -1))
            if (r3 < 0) goto L_0x00e4
            int r3 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r3 <= 0) goto L_0x00c1
        L_0x00e4:
            r11 = r12
            goto L_0x00e8
        L_0x00e6:
            r11 = r21
        L_0x00e8:
            java.lang.String r0 = r25.p()
            if (r14 != 0) goto L_0x00f1
            r13 = r0
            r1 = 0
            goto L_0x00fb
        L_0x00f1:
            boolean r1 = c(r0, r14)
            if (r1 != 0) goto L_0x00f9
            r1 = 0
            return r1
        L_0x00f9:
            r1 = 0
            r13 = r14
        L_0x00fb:
            int r0 = r0.length()
            int r3 = r13.length()
            if (r0 == r3) goto L_0x0110
            okhttp3.internal.publicsuffix.PublicSuffixDatabase r0 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.c()
            java.lang.String r0 = r0.d(r13)
            if (r0 != 0) goto L_0x0110
            return r1
        L_0x0110:
            java.lang.String r0 = "/"
            if (r8 == 0) goto L_0x011d
            boolean r1 = r8.startsWith(r0)
            if (r1 != 0) goto L_0x011b
            goto L_0x011d
        L_0x011b:
            r14 = r8
            goto L_0x012e
        L_0x011d:
            java.lang.String r1 = r25.h()
            r3 = 47
            int r3 = r1.lastIndexOf(r3)
            if (r3 == 0) goto L_0x012d
            java.lang.String r0 = r1.substring(r2, r3)
        L_0x012d:
            r14 = r0
        L_0x012e:
            okhttp3.Cookie r0 = new okhttp3.Cookie
            r8 = r0
            r10 = r6
            r8.<init>(r9, r10, r11, r13, r14, r15, r16, r17, r18)
        L_0x0135:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cookie.i(long, okhttp3.HttpUrl, java.lang.String):okhttp3.Cookie");
    }

    @Nullable
    public static Cookie j(HttpUrl httpUrl, String str) {
        return i(System.currentTimeMillis(), httpUrl, str);
    }

    public static List<Cookie> k(HttpUrl httpUrl, Headers headers) {
        List<String> o = headers.o(HttpHeaders.F0);
        int size = o.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            Cookie j2 = j(httpUrl, o.get(i2));
            if (j2 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(j2);
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    private static String l(String str) {
        if (!str.endsWith(".")) {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            String d2 = Util.d(str);
            if (d2 != null) {
                return d2;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    private static long m(String str, int i2, int i3) {
        int a2 = a(str, i2, i3, false);
        Matcher matcher = f30828m.matcher(str);
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        while (a2 < i3) {
            int a3 = a(str, a2 + 1, i3, true);
            matcher.region(a2, a3);
            if (i5 == -1 && matcher.usePattern(f30828m).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
                i8 = Integer.parseInt(matcher.group(2));
                i9 = Integer.parseInt(matcher.group(3));
            } else if (i6 != -1 || !matcher.usePattern(f30827l).matches()) {
                if (i7 == -1) {
                    Pattern pattern = f30826k;
                    if (matcher.usePattern(pattern).matches()) {
                        i7 = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                    }
                }
                if (i4 == -1 && matcher.usePattern(f30825j).matches()) {
                    i4 = Integer.parseInt(matcher.group(1));
                }
            } else {
                i6 = Integer.parseInt(matcher.group(1));
            }
            a2 = a(str, a3 + 1, i3, false);
        }
        if (i4 >= 70 && i4 <= 99) {
            i4 += 1900;
        }
        if (i4 >= 0 && i4 <= 69) {
            i4 += 2000;
        }
        if (i4 < 1601) {
            throw new IllegalArgumentException();
        } else if (i7 == -1) {
            throw new IllegalArgumentException();
        } else if (i6 < 1 || i6 > 31) {
            throw new IllegalArgumentException();
        } else if (i5 < 0 || i5 > 23) {
            throw new IllegalArgumentException();
        } else if (i8 < 0 || i8 > 59) {
            throw new IllegalArgumentException();
        } else if (i9 < 0 || i9 > 59) {
            throw new IllegalArgumentException();
        } else {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.p);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i4);
            gregorianCalendar.set(2, i7 - 1);
            gregorianCalendar.set(5, i6);
            gregorianCalendar.set(11, i5);
            gregorianCalendar.set(12, i8);
            gregorianCalendar.set(13, i9);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
    }

    private static long n(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e2) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e2;
        }
    }

    private static boolean p(HttpUrl httpUrl, String str) {
        String h2 = httpUrl.h();
        if (h2.equals(str)) {
            return true;
        }
        if (h2.startsWith(str)) {
            return str.endsWith("/") || h2.charAt(str.length()) == '/';
        }
        return false;
    }

    public String b() {
        return this.f30832d;
    }

    public long d() {
        return this.f30831c;
    }

    public boolean e() {
        return this.f30837i;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        return cookie.f30829a.equals(this.f30829a) && cookie.f30830b.equals(this.f30830b) && cookie.f30832d.equals(this.f30832d) && cookie.f30833e.equals(this.f30833e) && cookie.f30831c == this.f30831c && cookie.f30834f == this.f30834f && cookie.f30835g == this.f30835g && cookie.f30836h == this.f30836h && cookie.f30837i == this.f30837i;
    }

    public boolean f() {
        return this.f30835g;
    }

    public boolean g(HttpUrl httpUrl) {
        if ((this.f30837i ? httpUrl.p().equals(this.f30832d) : c(httpUrl.p(), this.f30832d)) && p(httpUrl, this.f30833e)) {
            return !this.f30834f || httpUrl.q();
        }
        return false;
    }

    public String h() {
        return this.f30829a;
    }

    public int hashCode() {
        long j2 = this.f30831c;
        return ((((((((((((((((MetaDo.w + this.f30829a.hashCode()) * 31) + this.f30830b.hashCode()) * 31) + this.f30832d.hashCode()) * 31) + this.f30833e.hashCode()) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (this.f30834f ^ true ? 1 : 0)) * 31) + (this.f30835g ^ true ? 1 : 0)) * 31) + (this.f30836h ^ true ? 1 : 0)) * 31) + (this.f30837i ^ true ? 1 : 0);
    }

    public String o() {
        return this.f30833e;
    }

    public boolean q() {
        return this.f30836h;
    }

    public boolean r() {
        return this.f30834f;
    }

    /* access modifiers changed from: package-private */
    public String s(boolean z) {
        String a2;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f30829a);
        sb.append(ASCIIPropertyListParser.f18654l);
        sb.append(this.f30830b);
        if (this.f30836h) {
            if (this.f30831c == Long.MIN_VALUE) {
                a2 = "; max-age=0";
            } else {
                sb.append("; expires=");
                a2 = HttpDate.a(new Date(this.f30831c));
            }
            sb.append(a2);
        }
        if (!this.f30837i) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.f30832d);
        }
        sb.append("; path=");
        sb.append(this.f30833e);
        if (this.f30834f) {
            sb.append("; secure");
        }
        if (this.f30835g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public String t() {
        return this.f30830b;
    }

    public String toString() {
        return s(false);
    }

    Cookie(Builder builder) {
        String str = builder.f30838a;
        if (str != null) {
            String str2 = builder.f30839b;
            if (str2 != null) {
                String str3 = builder.f30841d;
                if (str3 != null) {
                    this.f30829a = str;
                    this.f30830b = str2;
                    this.f30831c = builder.f30840c;
                    this.f30832d = str3;
                    this.f30833e = builder.f30842e;
                    this.f30834f = builder.f30843f;
                    this.f30835g = builder.f30844g;
                    this.f30836h = builder.f30845h;
                    this.f30837i = builder.f30846i;
                    return;
                }
                throw new NullPointerException("builder.domain == null");
            }
            throw new NullPointerException("builder.value == null");
        }
        throw new NullPointerException("builder.name == null");
    }
}
