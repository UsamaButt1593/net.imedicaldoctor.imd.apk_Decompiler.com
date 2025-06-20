package okhttp3;

import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.text.pdf.PdfWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import kotlin.text.Typography;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.Buffer;

public final class HttpUrl {

    /* renamed from: j  reason: collision with root package name */
    private static final char[] f30871j = {'0', '1', PdfWriter.p4, PdfWriter.q4, PdfWriter.r4, PdfWriter.s4, PdfWriter.t4, PdfWriter.u4, '8', '9', 'A', ASCIIPropertyListParser.u, 'C', ASCIIPropertyListParser.t, 'E', 'F'};

    /* renamed from: k  reason: collision with root package name */
    static final String f30872k = " \"':;<=>@[]^`{}|/\\?#";

    /* renamed from: l  reason: collision with root package name */
    static final String f30873l = " \"':;<=>@[]^`{}|/\\?#";

    /* renamed from: m  reason: collision with root package name */
    static final String f30874m = " \"<>^`{}|/\\?#";

    /* renamed from: n  reason: collision with root package name */
    static final String f30875n = "[]";
    static final String o = " \"'<>#";
    static final String p = " \"'<>#&=";
    static final String q = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    static final String r = "\\^`{|}";
    static final String s = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    static final String t = "";
    static final String u = " \"#<>\\^`{|}";

    /* renamed from: a  reason: collision with root package name */
    final String f30876a;

    /* renamed from: b  reason: collision with root package name */
    private final String f30877b;

    /* renamed from: c  reason: collision with root package name */
    private final String f30878c;

    /* renamed from: d  reason: collision with root package name */
    final String f30879d;

    /* renamed from: e  reason: collision with root package name */
    final int f30880e;

    /* renamed from: f  reason: collision with root package name */
    private final List<String> f30881f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final List<String> f30882g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final String f30883h;

    /* renamed from: i  reason: collision with root package name */
    private final String f30884i;

    public static final class Builder {

        /* renamed from: i  reason: collision with root package name */
        static final String f30885i = "Invalid URL host";
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        String f30886a;

        /* renamed from: b  reason: collision with root package name */
        String f30887b = "";

        /* renamed from: c  reason: collision with root package name */
        String f30888c = "";
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        String f30889d;

        /* renamed from: e  reason: collision with root package name */
        int f30890e = -1;

        /* renamed from: f  reason: collision with root package name */
        final List<String> f30891f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        List<String> f30892g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        String f30893h;

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.f30891f = arrayList;
            arrayList.add("");
        }

        private void C(String str) {
            for (int size = this.f30892g.size() - 2; size >= 0; size -= 2) {
                if (str.equals(this.f30892g.get(size))) {
                    this.f30892g.remove(size + 1);
                    this.f30892g.remove(size);
                    if (this.f30892g.isEmpty()) {
                        this.f30892g = null;
                        return;
                    }
                }
            }
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0044 A[SYNTHETIC] */
        private void G(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L_0x0003
                return
            L_0x0003:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L_0x001e
                r1 = 92
                if (r0 != r1) goto L_0x0013
                goto L_0x001e
            L_0x0013:
                java.util.List<java.lang.String> r0 = r10.f30891f
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L_0x0029
            L_0x001e:
                java.util.List<java.lang.String> r0 = r10.f30891f
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f30891f
                r0.add(r2)
                goto L_0x0041
            L_0x0029:
                r6 = r12
                if (r6 >= r13) goto L_0x0044
                java.lang.String r12 = "/\\"
                int r12 = okhttp3.internal.Util.p(r11, r6, r13, r12)
                if (r12 >= r13) goto L_0x0036
                r0 = 1
                goto L_0x0037
            L_0x0036:
                r0 = 0
            L_0x0037:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.z(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L_0x0029
            L_0x0041:
                int r12 = r12 + 1
                goto L_0x0029
            L_0x0044:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.G(java.lang.String, int, int):void");
        }

        private static int I(String str, int i2, int i3) {
            if (i3 - i2 < 2) {
                return -1;
            }
            char charAt = str.charAt(i2);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i2++;
                    if (i2 >= i3) {
                        break;
                    }
                    char charAt2 = str.charAt(i2);
                    if ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && !((charAt2 >= '0' && charAt2 <= '9') || charAt2 == '+' || charAt2 == '-' || charAt2 == '.'))) {
                        if (charAt2 == ':') {
                            return i2;
                        }
                    }
                }
            }
            return -1;
        }

        private static int N(String str, int i2, int i3) {
            int i4 = 0;
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i4++;
                i2++;
            }
            return i4;
        }

        private Builder f(String str, boolean z) {
            int i2 = 0;
            do {
                int p = Util.p(str, i2, str.length(), "/\\");
                z(str, i2, p, p < str.length(), z);
                i2 = p + 1;
            } while (i2 <= str.length());
            return this;
        }

        private static String i(String str, int i2, int i3) {
            return Util.d(HttpUrl.z(str, i2, i3, false));
        }

        private boolean r(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean s(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private static int u(String str, int i2, int i3) {
            try {
                int parseInt = Integer.parseInt(HttpUrl.a(str, i2, i3, "", false, false, false, true, (Charset) null));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }

        private void w() {
            List<String> list = this.f30891f;
            if (!list.remove(list.size() - 1).isEmpty() || this.f30891f.isEmpty()) {
                this.f30891f.add("");
                return;
            }
            List<String> list2 = this.f30891f;
            list2.set(list2.size() - 1, "");
        }

        private static int y(String str, int i2, int i3) {
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt == ':') {
                    return i2;
                }
                if (charAt == '[') {
                    do {
                        i2++;
                        if (i2 >= i3) {
                            break;
                        }
                    } while (str.charAt(i2) == ']');
                }
                i2++;
            }
            return i3;
        }

        private void z(String str, int i2, int i3, boolean z, boolean z2) {
            String a2 = HttpUrl.a(str, i2, i3, HttpUrl.f30874m, z2, false, false, true, (Charset) null);
            if (!r(a2)) {
                if (s(a2)) {
                    w();
                    return;
                }
                List<String> list = this.f30891f;
                if (list.get(list.size() - 1).isEmpty()) {
                    List<String> list2 = this.f30891f;
                    list2.set(list2.size() - 1, a2);
                } else {
                    this.f30891f.add(a2);
                }
                if (z) {
                    this.f30891f.add("");
                }
            }
        }

        public Builder A(@Nullable String str) {
            this.f30892g = str != null ? HttpUrl.M(HttpUrl.b(str, HttpUrl.o, false, false, true, true)) : null;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder B() {
            int size = this.f30891f.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f30891f.set(i2, HttpUrl.b(this.f30891f.get(i2), "[]", true, true, false, true));
            }
            List<String> list = this.f30892g;
            if (list != null) {
                int size2 = list.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    String str = this.f30892g.get(i3);
                    if (str != null) {
                        this.f30892g.set(i3, HttpUrl.b(str, HttpUrl.r, true, true, true, true));
                    }
                }
            }
            String str2 = this.f30893h;
            if (str2 != null) {
                this.f30893h = HttpUrl.b(str2, HttpUrl.u, true, true, false, false);
            }
            return this;
        }

        public Builder D(String str) {
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            } else if (this.f30892g == null) {
                return this;
            } else {
                C(HttpUrl.b(str, HttpUrl.p, true, false, true, true));
                return this;
            }
        }

        public Builder E(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (this.f30892g == null) {
                return this;
            } else {
                C(HttpUrl.b(str, HttpUrl.q, false, false, true, true));
                return this;
            }
        }

        public Builder F(int i2) {
            this.f30891f.remove(i2);
            if (this.f30891f.isEmpty()) {
                this.f30891f.add("");
            }
            return this;
        }

        public Builder H(String str) {
            if (str != null) {
                String str2 = "http";
                if (!str.equalsIgnoreCase(str2)) {
                    str2 = "https";
                    if (!str.equalsIgnoreCase(str2)) {
                        throw new IllegalArgumentException("unexpected scheme: " + str);
                    }
                }
                this.f30886a = str2;
                return this;
            }
            throw new NullPointerException("scheme == null");
        }

        public Builder J(int i2, String str) {
            if (str != null) {
                String a2 = HttpUrl.a(str, 0, str.length(), HttpUrl.f30874m, true, false, false, true, (Charset) null);
                this.f30891f.set(i2, a2);
                if (!r(a2) && !s(a2)) {
                    return this;
                }
                throw new IllegalArgumentException("unexpected path segment: " + str);
            }
            throw new NullPointerException("encodedPathSegment == null");
        }

        public Builder K(String str, @Nullable String str2) {
            D(str);
            c(str, str2);
            return this;
        }

        public Builder L(int i2, String str) {
            if (str != null) {
                String a2 = HttpUrl.a(str, 0, str.length(), HttpUrl.f30874m, false, false, false, true, (Charset) null);
                if (r(a2) || s(a2)) {
                    throw new IllegalArgumentException("unexpected path segment: " + str);
                }
                this.f30891f.set(i2, a2);
                return this;
            }
            throw new NullPointerException("pathSegment == null");
        }

        public Builder M(String str, @Nullable String str2) {
            E(str);
            g(str, str2);
            return this;
        }

        public Builder O(String str) {
            if (str != null) {
                this.f30887b = HttpUrl.b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("username == null");
        }

        public Builder a(String str) {
            if (str != null) {
                z(str, 0, str.length(), false, true);
                return this;
            }
            throw new NullPointerException("encodedPathSegment == null");
        }

        public Builder b(String str) {
            if (str != null) {
                return f(str, true);
            }
            throw new NullPointerException("encodedPathSegments == null");
        }

        public Builder c(String str, @Nullable String str2) {
            if (str != null) {
                if (this.f30892g == null) {
                    this.f30892g = new ArrayList();
                }
                this.f30892g.add(HttpUrl.b(str, HttpUrl.p, true, false, true, true));
                this.f30892g.add(str2 != null ? HttpUrl.b(str2, HttpUrl.p, true, false, true, true) : null);
                return this;
            }
            throw new NullPointerException("encodedName == null");
        }

        public Builder d(String str) {
            if (str != null) {
                z(str, 0, str.length(), false, false);
                return this;
            }
            throw new NullPointerException("pathSegment == null");
        }

        public Builder e(String str) {
            if (str != null) {
                return f(str, false);
            }
            throw new NullPointerException("pathSegments == null");
        }

        public Builder g(String str, @Nullable String str2) {
            if (str != null) {
                if (this.f30892g == null) {
                    this.f30892g = new ArrayList();
                }
                this.f30892g.add(HttpUrl.b(str, HttpUrl.q, false, false, true, true));
                this.f30892g.add(str2 != null ? HttpUrl.b(str2, HttpUrl.q, false, false, true, true) : null);
                return this;
            }
            throw new NullPointerException("name == null");
        }

        public HttpUrl h() {
            if (this.f30886a == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.f30889d != null) {
                return new HttpUrl(this);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        /* access modifiers changed from: package-private */
        public int j() {
            int i2 = this.f30890e;
            return i2 != -1 ? i2 : HttpUrl.e(this.f30886a);
        }

        public Builder k(@Nullable String str) {
            this.f30893h = str != null ? HttpUrl.b(str, "", true, false, false, false) : null;
            return this;
        }

        public Builder l(String str) {
            if (str != null) {
                this.f30888c = HttpUrl.b(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                return this;
            }
            throw new NullPointerException("encodedPassword == null");
        }

        public Builder m(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPath == null");
            } else if (str.startsWith("/")) {
                G(str, 0, str.length());
                return this;
            } else {
                throw new IllegalArgumentException("unexpected encodedPath: " + str);
            }
        }

        public Builder n(@Nullable String str) {
            this.f30892g = str != null ? HttpUrl.M(HttpUrl.b(str, HttpUrl.o, true, false, true, true)) : null;
            return this;
        }

        public Builder o(String str) {
            if (str != null) {
                this.f30887b = HttpUrl.b(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                return this;
            }
            throw new NullPointerException("encodedUsername == null");
        }

        public Builder p(@Nullable String str) {
            this.f30893h = str != null ? HttpUrl.b(str, "", false, false, false, false) : null;
            return this;
        }

        public Builder q(String str) {
            if (str != null) {
                String i2 = i(str, 0, str.length());
                if (i2 != null) {
                    this.f30889d = i2;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            throw new NullPointerException("host == null");
        }

        /* access modifiers changed from: package-private */
        public Builder t(@Nullable HttpUrl httpUrl, String str) {
            int p;
            int i2;
            HttpUrl httpUrl2 = httpUrl;
            String str2 = str;
            int F = Util.F(str2, 0, str.length());
            int G = Util.G(str2, F, str.length());
            int I = I(str2, F, G);
            if (I != -1) {
                if (str.regionMatches(true, F, "https:", 0, 6)) {
                    this.f30886a = "https";
                    F += 6;
                } else if (str.regionMatches(true, F, "http:", 0, 5)) {
                    this.f30886a = "http";
                    F += 5;
                } else {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str2.substring(0, I) + "'");
                }
            } else if (httpUrl2 != null) {
                this.f30886a = httpUrl2.f30876a;
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int N = N(str2, F, G);
            char c2 = '?';
            char c3 = '#';
            if (N >= 2 || httpUrl2 == null || !httpUrl2.f30876a.equals(this.f30886a)) {
                int i3 = F + N;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    p = Util.p(str2, i3, G, "@/\\?#");
                    char charAt = p != G ? str2.charAt(p) : 65535;
                    if (charAt == 65535 || charAt == c3 || charAt == '/' || charAt == '\\' || charAt == c2) {
                        int i4 = p;
                        int y = y(str2, i3, i4);
                        int i5 = y + 1;
                    } else {
                        if (charAt == '@') {
                            if (!z) {
                                int o = Util.o(str2, i3, p, ASCIIPropertyListParser.A);
                                int i6 = o;
                                String str3 = "%40";
                                i2 = p;
                                String a2 = HttpUrl.a(str, i3, o, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                                if (z2) {
                                    a2 = this.f30887b + str3 + a2;
                                }
                                this.f30887b = a2;
                                if (i6 != i2) {
                                    this.f30888c = HttpUrl.a(str, i6 + 1, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                                    z = true;
                                }
                                z2 = true;
                            } else {
                                i2 = p;
                                this.f30888c += "%40" + HttpUrl.a(str, i3, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, (Charset) null);
                            }
                            i3 = i2 + 1;
                        }
                        c2 = '?';
                        c3 = '#';
                    }
                }
                int i42 = p;
                int y2 = y(str2, i3, i42);
                int i52 = y2 + 1;
                if (i52 < i42) {
                    this.f30889d = i(str2, i3, y2);
                    int u = u(str2, i52, i42);
                    this.f30890e = u;
                    if (u == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str2.substring(i52, i42) + '\"');
                    }
                } else {
                    this.f30889d = i(str2, i3, y2);
                    this.f30890e = HttpUrl.e(this.f30886a);
                }
                if (this.f30889d != null) {
                    F = i42;
                } else {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str2.substring(i3, y2) + '\"');
                }
            } else {
                this.f30887b = httpUrl.k();
                this.f30888c = httpUrl.g();
                this.f30889d = httpUrl2.f30879d;
                this.f30890e = httpUrl2.f30880e;
                this.f30891f.clear();
                this.f30891f.addAll(httpUrl.i());
                if (F == G || str2.charAt(F) == '#') {
                    n(httpUrl.j());
                }
            }
            int p2 = Util.p(str2, F, G, "?#");
            G(str2, F, p2);
            if (p2 < G && str2.charAt(p2) == '?') {
                int o2 = Util.o(str2, p2, G, '#');
                this.f30892g = HttpUrl.M(HttpUrl.a(str, p2 + 1, o2, HttpUrl.o, true, false, true, true, (Charset) null));
                p2 = o2;
            }
            if (p2 < G && str2.charAt(p2) == '#') {
                this.f30893h = HttpUrl.a(str, 1 + p2, G, "", true, false, false, false, (Charset) null);
            }
            return this;
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            String str2 = this.f30886a;
            if (str2 != null) {
                sb.append(str2);
                str = "://";
            } else {
                str = "//";
            }
            sb.append(str);
            if (!this.f30887b.isEmpty() || !this.f30888c.isEmpty()) {
                sb.append(this.f30887b);
                if (!this.f30888c.isEmpty()) {
                    sb.append(ASCIIPropertyListParser.A);
                    sb.append(this.f30888c);
                }
                sb.append('@');
            }
            String str3 = this.f30889d;
            if (str3 != null) {
                if (str3.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.f30889d);
                    sb.append(']');
                } else {
                    sb.append(this.f30889d);
                }
            }
            if (!(this.f30890e == -1 && this.f30886a == null)) {
                int j2 = j();
                String str4 = this.f30886a;
                if (str4 == null || j2 != HttpUrl.e(str4)) {
                    sb.append(ASCIIPropertyListParser.A);
                    sb.append(j2);
                }
            }
            HttpUrl.x(sb, this.f30891f);
            if (this.f30892g != null) {
                sb.append('?');
                HttpUrl.r(sb, this.f30892g);
            }
            if (this.f30893h != null) {
                sb.append('#');
                sb.append(this.f30893h);
            }
            return sb.toString();
        }

        public Builder v(String str) {
            if (str != null) {
                this.f30888c = HttpUrl.b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
                return this;
            }
            throw new NullPointerException("password == null");
        }

        public Builder x(int i2) {
            if (i2 <= 0 || i2 > 65535) {
                throw new IllegalArgumentException("unexpected port: " + i2);
            }
            this.f30890e = i2;
            return this;
        }
    }

    HttpUrl(Builder builder) {
        this.f30876a = builder.f30886a;
        this.f30877b = A(builder.f30887b, false);
        this.f30878c = A(builder.f30888c, false);
        this.f30879d = builder.f30889d;
        this.f30880e = builder.j();
        this.f30881f = B(builder.f30891f, false);
        List<String> list = builder.f30892g;
        String str = null;
        this.f30882g = list != null ? B(list, true) : null;
        String str2 = builder.f30893h;
        this.f30883h = str2 != null ? A(str2, false) : str;
        this.f30884i = builder.toString();
    }

    static String A(String str, boolean z) {
        return z(str, 0, str.length(), z);
    }

    private List<String> B(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            String str = list.get(i2);
            arrayList.add(str != null ? A(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static void C(Buffer buffer, String str, int i2, int i3, boolean z) {
        int i4;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt == 37 && (i4 = i2 + 2) < i3) {
                int l2 = Util.l(str.charAt(i2 + 1));
                int l3 = Util.l(str.charAt(i4));
                if (!(l2 == -1 || l3 == -1)) {
                    buffer.writeByte((l2 << 4) + l3);
                    i2 = i4;
                    i2 += Character.charCount(codePointAt);
                }
            } else if (codePointAt == 43 && z) {
                buffer.writeByte(32);
                i2 += Character.charCount(codePointAt);
            }
            buffer.U(codePointAt);
            i2 += Character.charCount(codePointAt);
        }
    }

    static boolean D(String str, int i2, int i3) {
        int i4 = i2 + 2;
        return i4 < i3 && str.charAt(i2) == '%' && Util.l(str.charAt(i2 + 1)) != -1 && Util.l(str.charAt(i4)) != -1;
    }

    static List<String> M(String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 <= str.length()) {
            int indexOf = str.indexOf(38, i2);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i2);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i2, indexOf));
                str2 = null;
            } else {
                arrayList.add(str.substring(i2, indexOf2));
                str2 = str.substring(indexOf2 + 1, indexOf);
            }
            arrayList.add(str2);
            i2 = indexOf + 1;
        }
        return arrayList;
    }

    static String a(String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        String str3 = str;
        int i4 = i3;
        int i5 = i2;
        while (i5 < i4) {
            int codePointAt = str.codePointAt(i5);
            if (codePointAt < 32 || codePointAt == 127 || (codePointAt >= 128 && z4)) {
                String str4 = str2;
            } else {
                String str5 = str2;
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || D(str, i5, i3)))) && (codePointAt != 43 || !z3))) {
                    i5 += Character.charCount(codePointAt);
                }
            }
            Buffer buffer = new Buffer();
            int i6 = i2;
            buffer.w1(str, i2, i5);
            d(buffer, str, i5, i3, str2, z, z2, z3, z4, charset);
            return buffer.a2();
        }
        int i7 = i2;
        return str.substring(i2, i3);
    }

    static String b(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, (Charset) null);
    }

    static String c(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, charset);
    }

    static void d(Buffer buffer, String str, int i2, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        Buffer buffer2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt == 43 && z3) {
                    buffer.W0(z ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z || (z2 && !D(str, i2, i3)))))) {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    if (charset == null || charset.equals(Util.f30979j)) {
                        buffer2.U(codePointAt);
                    } else {
                        buffer2.E2(str, i2, Character.charCount(codePointAt) + i2, charset);
                    }
                    while (!buffer2.o0()) {
                        byte readByte = buffer2.readByte();
                        buffer.writeByte(37);
                        char[] cArr = f30871j;
                        buffer.writeByte(cArr[((readByte & 255) >> 4) & 15]);
                        buffer.writeByte(cArr[readByte & 15]);
                    }
                } else {
                    buffer.U(codePointAt);
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    public static int e(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public static HttpUrl m(String str) {
        return new Builder().t((HttpUrl) null, str).h();
    }

    @Nullable
    public static HttpUrl n(URI uri) {
        return u(uri.toString());
    }

    @Nullable
    public static HttpUrl o(URL url) {
        return u(url.toString());
    }

    static void r(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            String str = list.get(i2);
            String str2 = list.get(i2 + 1);
            if (i2 > 0) {
                sb.append(Typography.f29117d);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append(ASCIIPropertyListParser.f18654l);
                sb.append(str2);
            }
        }
    }

    @Nullable
    public static HttpUrl u(String str) {
        try {
            return m(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    static void x(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append('/');
            sb.append(list.get(i2));
        }
    }

    static String z(String str, int i2, int i3, boolean z) {
        for (int i4 = i2; i4 < i3; i4++) {
            char charAt = str.charAt(i4);
            if (charAt == '%' || (charAt == '+' && z)) {
                Buffer buffer = new Buffer();
                buffer.w1(str, i2, i4);
                C(buffer, str, i4, i3, z);
                return buffer.a2();
            }
        }
        return str.substring(i2, i3);
    }

    public int E() {
        return this.f30880e;
    }

    @Nullable
    public String F() {
        if (this.f30882g == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        r(sb, this.f30882g);
        return sb.toString();
    }

    @Nullable
    public String G(String str) {
        List<String> list = this.f30882g;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            if (str.equals(this.f30882g.get(i2))) {
                return this.f30882g.get(i2 + 1);
            }
        }
        return null;
    }

    public String H(int i2) {
        List<String> list = this.f30882g;
        if (list != null) {
            return list.get(i2 * 2);
        }
        throw new IndexOutOfBoundsException();
    }

    public Set<String> I() {
        if (this.f30882g == null) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = this.f30882g.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            linkedHashSet.add(this.f30882g.get(i2));
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public String J(int i2) {
        List<String> list = this.f30882g;
        if (list != null) {
            return list.get((i2 * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public List<String> K(String str) {
        if (this.f30882g == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = this.f30882g.size();
        for (int i2 = 0; i2 < size; i2 += 2) {
            if (str.equals(this.f30882g.get(i2))) {
                arrayList.add(this.f30882g.get(i2 + 1));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public int L() {
        List<String> list = this.f30882g;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public String N() {
        return t("/...").O("").v("").h().toString();
    }

    @Nullable
    public HttpUrl O(String str) {
        Builder t2 = t(str);
        if (t2 != null) {
            return t2.h();
        }
        return null;
    }

    public String P() {
        return this.f30876a;
    }

    @Nullable
    public String Q() {
        if (Util.K(this.f30879d)) {
            return null;
        }
        return PublicSuffixDatabase.c().d(this.f30879d);
    }

    public URI R() {
        String builder = s().B().toString();
        try {
            return new URI(builder);
        } catch (URISyntaxException e2) {
            try {
                return URI.create(builder.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    public URL S() {
        try {
            return new URL(this.f30884i);
        } catch (MalformedURLException e2) {
            throw new RuntimeException(e2);
        }
    }

    public String T() {
        return this.f30877b;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof HttpUrl) && ((HttpUrl) obj).f30884i.equals(this.f30884i);
    }

    @Nullable
    public String f() {
        if (this.f30883h == null) {
            return null;
        }
        return this.f30884i.substring(this.f30884i.indexOf(35) + 1);
    }

    public String g() {
        if (this.f30878c.isEmpty()) {
            return "";
        }
        int indexOf = this.f30884i.indexOf(64);
        return this.f30884i.substring(this.f30884i.indexOf(58, this.f30876a.length() + 3) + 1, indexOf);
    }

    public String h() {
        int indexOf = this.f30884i.indexOf(47, this.f30876a.length() + 3);
        String str = this.f30884i;
        return this.f30884i.substring(indexOf, Util.p(str, indexOf, str.length(), "?#"));
    }

    public int hashCode() {
        return this.f30884i.hashCode();
    }

    public List<String> i() {
        int indexOf = this.f30884i.indexOf(47, this.f30876a.length() + 3);
        String str = this.f30884i;
        int p2 = Util.p(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < p2) {
            int i2 = indexOf + 1;
            int o2 = Util.o(this.f30884i, i2, p2, '/');
            arrayList.add(this.f30884i.substring(i2, o2));
            indexOf = o2;
        }
        return arrayList;
    }

    @Nullable
    public String j() {
        if (this.f30882g == null) {
            return null;
        }
        int indexOf = this.f30884i.indexOf(63) + 1;
        String str = this.f30884i;
        return this.f30884i.substring(indexOf, Util.o(str, indexOf, str.length(), '#'));
    }

    public String k() {
        if (this.f30877b.isEmpty()) {
            return "";
        }
        int length = this.f30876a.length() + 3;
        String str = this.f30884i;
        return this.f30884i.substring(length, Util.p(str, length, str.length(), ":@"));
    }

    @Nullable
    public String l() {
        return this.f30883h;
    }

    public String p() {
        return this.f30879d;
    }

    public boolean q() {
        return this.f30876a.equals("https");
    }

    public Builder s() {
        Builder builder = new Builder();
        builder.f30886a = this.f30876a;
        builder.f30887b = k();
        builder.f30888c = g();
        builder.f30889d = this.f30879d;
        builder.f30890e = this.f30880e != e(this.f30876a) ? this.f30880e : -1;
        builder.f30891f.clear();
        builder.f30891f.addAll(i());
        builder.n(j());
        builder.f30893h = f();
        return builder;
    }

    @Nullable
    public Builder t(String str) {
        try {
            return new Builder().t(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public String toString() {
        return this.f30884i;
    }

    public String v() {
        return this.f30878c;
    }

    public List<String> w() {
        return this.f30881f;
    }

    public int y() {
        return this.f30881f.size();
    }
}
