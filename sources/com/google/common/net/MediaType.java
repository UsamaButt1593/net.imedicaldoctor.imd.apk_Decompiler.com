package com.google.common.net;

import com.dd.plist.ASCIIPropertyListParser;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.itextpdf.text.xml.xmp.PdfSchema;
import com.itextpdf.tool.xml.html.HTML;
import java.nio.charset.Charset;
import java.util.Map;
import javax.annotation.CheckForNull;
import org.apache.commons.httpclient.auth.AuthState;
import org.apache.commons.httpclient.methods.multipart.FilePart;

@GwtCompatible
@ElementTypesAreNonnullByDefault
@Immutable
public final class MediaType {
    public static final MediaType A = k("text", "cache-manifest");
    public static final MediaType A0 = j("application", "epub+zip");
    public static final MediaType A1 = j("font", "sfnt");
    public static final MediaType B = k("text", "css");
    public static final MediaType B0 = j("application", "x-www-form-urlencoded");
    public static final MediaType B1 = j("font", "ttf");
    public static final MediaType C = k("text", "csv");
    public static final MediaType C0 = j("application", "pkcs12");
    public static final MediaType C1 = j("font", "woff");
    public static final MediaType D = k("text", HTML.Tag.y);
    public static final MediaType D0 = j("application", FilePart.DEFAULT_TRANSFER_ENCODING);
    public static final MediaType D1 = j("font", "woff2");
    public static final MediaType E = k("text", "calendar");
    public static final MediaType E0 = j("application", "geo+json");
    private static final Joiner.MapJoiner E1 = Joiner.p("; ").u("=");
    public static final MediaType F = k("text", "plain");
    public static final MediaType F0 = j("application", "x-gzip");
    public static final MediaType G = k("text", "javascript");
    public static final MediaType G0 = j("application", "hal+json");
    public static final MediaType H = k("text", "tab-separated-values");
    public static final MediaType H0 = k("application", "javascript");
    public static final MediaType I = k("text", "vcard");
    public static final MediaType I0 = j("application", "jose");
    public static final MediaType J = k("text", "vnd.wap.wml");
    public static final MediaType J0 = j("application", "jose+json");
    public static final MediaType K = k("text", HTML.Tag.f27613a);
    public static final MediaType K0 = k("application", "json");
    public static final MediaType L = k("text", "vtt");
    public static final MediaType L0 = j("application", "jwt");
    public static final MediaType M = j("image", "bmp");
    public static final MediaType M0 = k("application", "manifest+json");
    public static final MediaType N = j("image", "x-canon-crw");
    public static final MediaType N0 = j("application", "vnd.google-earth.kml+xml");
    public static final MediaType O = j("image", "gif");
    public static final MediaType O0 = j("application", "vnd.google-earth.kmz");
    public static final MediaType P = j("image", "vnd.microsoft.icon");
    public static final MediaType P0 = j("application", "mbox");
    public static final MediaType Q = j("image", "jpeg");
    public static final MediaType Q0 = j("application", "x-apple-aspen-config");
    public static final MediaType R = j("image", "png");
    public static final MediaType R0 = j("application", "vnd.ms-excel");
    public static final MediaType S = j("image", "vnd.adobe.photoshop");
    public static final MediaType S0 = j("application", "vnd.ms-outlook");
    public static final MediaType T = k("image", "svg+xml");
    public static final MediaType T0 = j("application", "vnd.ms-powerpoint");
    public static final MediaType U = j("image", "tiff");
    public static final MediaType U0 = j("application", "msword");
    public static final MediaType V = j("image", "webp");
    public static final MediaType V0 = j("application", "dash+xml");
    public static final MediaType W = j("image", "heif");
    public static final MediaType W0 = j("application", "wasm");
    public static final MediaType X = j("image", "jp2");
    public static final MediaType X0 = j("application", "x-nacl");
    public static final MediaType Y = j("audio", "mp4");
    public static final MediaType Y0 = j("application", "x-pnacl");
    public static final MediaType Z = j("audio", "mpeg");
    public static final MediaType Z0 = j("application", "octet-stream");
    public static final MediaType a0 = j("audio", "ogg");
    public static final MediaType a1 = j("application", "ogg");
    public static final MediaType b0 = j("audio", "webm");
    public static final MediaType b1 = j("application", "vnd.openxmlformats-officedocument.wordprocessingml.document");
    public static final MediaType c0 = j("audio", "l16");
    public static final MediaType c1 = j("application", "vnd.openxmlformats-officedocument.presentationml.presentation");
    public static final MediaType d0 = j("audio", "l24");
    public static final MediaType d1 = j("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    public static final MediaType e0 = j("audio", AuthState.PREEMPTIVE_AUTH_SCHEME);
    public static final MediaType e1 = j("application", "vnd.oasis.opendocument.graphics");
    public static final MediaType f0 = j("audio", "aac");
    public static final MediaType f1 = j("application", "vnd.oasis.opendocument.presentation");

    /* renamed from: g  reason: collision with root package name */
    private static final String f22921g = "charset";
    public static final MediaType g0 = j("audio", "vorbis");
    public static final MediaType g1 = j("application", "vnd.oasis.opendocument.spreadsheet");

    /* renamed from: h  reason: collision with root package name */
    private static final ImmutableListMultimap<String, String> f22922h = ImmutableListMultimap.T(f22921g, Ascii.g(Charsets.f22255c.name()));
    public static final MediaType h0 = j("audio", "x-ms-wma");
    public static final MediaType h1 = j("application", "vnd.oasis.opendocument.text");

    /* renamed from: i  reason: collision with root package name */
    private static final CharMatcher f22923i = CharMatcher.f().b(CharMatcher.v().F()).b(CharMatcher.s(' ')).b(CharMatcher.H("()<>@,;:\\\"/[]?="));
    public static final MediaType i0 = j("audio", "x-ms-wax");
    public static final MediaType i1 = k("application", "opensearchdescription+xml");

    /* renamed from: j  reason: collision with root package name */
    private static final CharMatcher f22924j = CharMatcher.f().b(CharMatcher.H("\"\\\r"));
    public static final MediaType j0 = j("audio", "vnd.rn-realaudio");
    public static final MediaType j1 = j("application", PdfSchema.Z);

    /* renamed from: k  reason: collision with root package name */
    private static final CharMatcher f22925k = CharMatcher.d(" \t\r\n");
    public static final MediaType k0 = j("audio", "vnd.wave");
    public static final MediaType k1 = j("application", "postscript");

    /* renamed from: l  reason: collision with root package name */
    private static final String f22926l = "application";
    public static final MediaType l0 = j("video", "mp4");
    public static final MediaType l1 = j("application", "protobuf");

    /* renamed from: m  reason: collision with root package name */
    private static final String f22927m = "audio";
    public static final MediaType m0 = j("video", "mpeg");
    public static final MediaType m1 = k("application", "rdf+xml");

    /* renamed from: n  reason: collision with root package name */
    private static final String f22928n = "image";
    public static final MediaType n0 = j("video", "ogg");
    public static final MediaType n1 = k("application", "rtf");
    private static final String o = "text";
    public static final MediaType o0 = j("video", "quicktime");
    public static final MediaType o1 = j("application", "font-sfnt");
    private static final String p = "video";
    public static final MediaType p0 = j("video", "webm");
    public static final MediaType p1 = j("application", "x-shockwave-flash");
    private static final String q = "font";
    public static final MediaType q0 = j("video", "x-ms-wmv");
    public static final MediaType q1 = j("application", "vnd.sketchup.skp");
    private static final String r = "*";
    public static final MediaType r0 = j("video", "x-flv");
    public static final MediaType r1 = k("application", "soap+xml");
    private static final Map<MediaType, MediaType> s = Maps.Y();
    public static final MediaType s0 = j("video", "3gpp");
    public static final MediaType s1 = j("application", "x-tar");
    public static final MediaType t = j(r, r);
    public static final MediaType t0 = j("video", "3gpp2");
    public static final MediaType t1 = j("application", "font-woff");
    public static final MediaType u = j("text", r);
    public static final MediaType u0 = k("application", HTML.Tag.f27613a);
    public static final MediaType u1 = j("application", "font-woff2");
    public static final MediaType v = j("image", r);
    public static final MediaType v0 = k("application", "atom+xml");
    public static final MediaType v1 = k("application", "xhtml+xml");
    public static final MediaType w = j("audio", r);
    public static final MediaType w0 = j("application", "x-bzip2");
    public static final MediaType w1 = k("application", "xrd+xml");
    public static final MediaType x = j("video", r);
    public static final MediaType x0 = k("application", "dart");
    public static final MediaType x1 = j("application", "zip");
    public static final MediaType y = j("application", r);
    public static final MediaType y0 = j("application", "vnd.apple.pkpass");
    public static final MediaType y1 = j("font", "collection");
    public static final MediaType z = j("font", r);
    public static final MediaType z0 = j("application", "vnd.ms-fontobject");
    public static final MediaType z1 = j("font", "otf");

    /* renamed from: a  reason: collision with root package name */
    private final String f22929a;

    /* renamed from: b  reason: collision with root package name */
    private final String f22930b;

    /* renamed from: c  reason: collision with root package name */
    private final ImmutableListMultimap<String, String> f22931c;
    @CheckForNull
    @LazyInit

    /* renamed from: d  reason: collision with root package name */
    private String f22932d;
    @LazyInit

    /* renamed from: e  reason: collision with root package name */
    private int f22933e;
    @CheckForNull
    @LazyInit

    /* renamed from: f  reason: collision with root package name */
    private Optional<Charset> f22934f;

    private static final class Tokenizer {

        /* renamed from: a  reason: collision with root package name */
        final String f22935a;

        /* renamed from: b  reason: collision with root package name */
        int f22936b = 0;

        Tokenizer(String str) {
            this.f22935a = str;
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public char a(char c2) {
            Preconditions.g0(e());
            Preconditions.g0(f() == c2);
            this.f22936b++;
            return c2;
        }

        /* access modifiers changed from: package-private */
        public char b(CharMatcher charMatcher) {
            Preconditions.g0(e());
            char f2 = f();
            Preconditions.g0(charMatcher.B(f2));
            this.f22936b++;
            return f2;
        }

        /* access modifiers changed from: package-private */
        public String c(CharMatcher charMatcher) {
            int i2 = this.f22936b;
            String d2 = d(charMatcher);
            Preconditions.g0(this.f22936b != i2);
            return d2;
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public String d(CharMatcher charMatcher) {
            Preconditions.g0(e());
            int i2 = this.f22936b;
            this.f22936b = charMatcher.F().o(this.f22935a, i2);
            return e() ? this.f22935a.substring(i2, this.f22936b) : this.f22935a.substring(i2);
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            int i2 = this.f22936b;
            return i2 >= 0 && i2 < this.f22935a.length();
        }

        /* access modifiers changed from: package-private */
        public char f() {
            Preconditions.g0(e());
            return this.f22935a.charAt(this.f22936b);
        }
    }

    private MediaType(String str, String str2, ImmutableListMultimap<String, String> immutableListMultimap) {
        this.f22929a = str;
        this.f22930b = str2;
        this.f22931c = immutableListMultimap;
    }

    private static MediaType b(MediaType mediaType) {
        s.put(mediaType, mediaType);
        return mediaType;
    }

    private String d() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f22929a);
        sb.append('/');
        sb.append(this.f22930b);
        if (!this.f22931c.isEmpty()) {
            sb.append("; ");
            E1.d(sb, Multimaps.E(this.f22931c, new a()).j());
        }
        return sb.toString();
    }

    private static void e(Tokenizer tokenizer, char c2) {
        CharMatcher charMatcher = f22925k;
        tokenizer.d(charMatcher);
        tokenizer.a(c2);
        tokenizer.d(charMatcher);
    }

    public static MediaType f(String str, String str2) {
        MediaType g2 = g(str, str2, ImmutableListMultimap.S());
        g2.f22934f = Optional.a();
        return g2;
    }

    private static MediaType g(String str, String str2, Multimap<String, String> multimap) {
        Preconditions.E(str);
        Preconditions.E(str2);
        Preconditions.E(multimap);
        String u2 = u(str);
        String u3 = u(str2);
        Preconditions.e(!r.equals(u2) || r.equals(u3), "A wildcard type cannot be used with a non-wildcard subtype");
        ImmutableListMultimap.Builder L2 = ImmutableListMultimap.L();
        for (Map.Entry next : multimap.j()) {
            String u4 = u((String) next.getKey());
            L2.f(u4, t(u4, (String) next.getValue()));
        }
        MediaType mediaType = new MediaType(u2, u3, L2.a());
        return (MediaType) MoreObjects.a(s.get(mediaType), mediaType);
    }

    static MediaType h(String str) {
        return f("application", str);
    }

    static MediaType i(String str) {
        return f("audio", str);
    }

    private static MediaType j(String str, String str2) {
        MediaType b2 = b(new MediaType(str, str2, ImmutableListMultimap.S()));
        b2.f22934f = Optional.a();
        return b2;
    }

    private static MediaType k(String str, String str2) {
        MediaType b2 = b(new MediaType(str, str2, f22922h));
        b2.f22934f = Optional.f(Charsets.f22255c);
        return b2;
    }

    static MediaType l(String str) {
        return f("font", str);
    }

    static MediaType m(String str) {
        return f("image", str);
    }

    static MediaType n(String str) {
        return f("text", str);
    }

    static MediaType o(String str) {
        return f("video", str);
    }

    private static String p(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 16);
        sb.append('\"');
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt == 13 || charAt == '\\' || charAt == '\"') {
                sb.append(ASCIIPropertyListParser.p);
            }
            sb.append(charAt);
        }
        sb.append('\"');
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String s(String str) {
        return (!f22923i.C(str) || str.isEmpty()) ? p(str) : str;
    }

    private static String t(String str, String str2) {
        Preconditions.E(str2);
        Preconditions.u(CharMatcher.f().C(str2), "parameter values must be ASCII: %s", str2);
        return f22921g.equals(str) ? Ascii.g(str2) : str2;
    }

    private static String u(String str) {
        Preconditions.d(f22923i.C(str));
        Preconditions.d(!str.isEmpty());
        return Ascii.g(str);
    }

    private Map<String, ImmutableMultiset<String>> w() {
        return Maps.B0(this.f22931c.g(), new b());
    }

    @CanIgnoreReturnValue
    public static MediaType x(String str) {
        String str2;
        Preconditions.E(str);
        Tokenizer tokenizer = new Tokenizer(str);
        try {
            CharMatcher charMatcher = f22923i;
            String c2 = tokenizer.c(charMatcher);
            e(tokenizer, '/');
            String c3 = tokenizer.c(charMatcher);
            ImmutableListMultimap.Builder L2 = ImmutableListMultimap.L();
            while (tokenizer.e()) {
                e(tokenizer, ASCIIPropertyListParser.f18655m);
                CharMatcher charMatcher2 = f22923i;
                String c4 = tokenizer.c(charMatcher2);
                e(tokenizer, ASCIIPropertyListParser.f18654l);
                if ('\"' == tokenizer.f()) {
                    tokenizer.a('\"');
                    StringBuilder sb = new StringBuilder();
                    while ('\"' != tokenizer.f()) {
                        if ('\\' == tokenizer.f()) {
                            tokenizer.a(ASCIIPropertyListParser.p);
                            sb.append(tokenizer.b(CharMatcher.f()));
                        } else {
                            sb.append(tokenizer.c(f22924j));
                        }
                    }
                    str2 = sb.toString();
                    tokenizer.a('\"');
                } else {
                    str2 = tokenizer.c(charMatcher2);
                }
                L2.f(c4, str2);
            }
            return g(c2, c3, L2.a());
        } catch (IllegalStateException e2) {
            throw new IllegalArgumentException("Could not parse '" + str + "'", e2);
        }
    }

    public MediaType A(Charset charset) {
        Preconditions.E(charset);
        MediaType B2 = B(f22921g, charset.name());
        B2.f22934f = Optional.f(charset);
        return B2;
    }

    public MediaType B(String str, String str2) {
        return D(str, ImmutableSet.L(str2));
    }

    public MediaType C(Multimap<String, String> multimap) {
        return g(this.f22929a, this.f22930b, multimap);
    }

    public MediaType D(String str, Iterable<String> iterable) {
        Preconditions.E(str);
        Preconditions.E(iterable);
        String u2 = u(str);
        ImmutableListMultimap.Builder L2 = ImmutableListMultimap.L();
        UnmodifiableIterator<Map.Entry<String, String>> k2 = this.f22931c.j().iterator();
        while (k2.hasNext()) {
            Map.Entry next = k2.next();
            String str2 = (String) next.getKey();
            if (!u2.equals(str2)) {
                L2.f(str2, (String) next.getValue());
            }
        }
        for (String t2 : iterable) {
            L2.f(u2, t(u2, t2));
        }
        MediaType mediaType = new MediaType(this.f22929a, this.f22930b, L2.a());
        if (!u2.equals(f22921g)) {
            mediaType.f22934f = this.f22934f;
        }
        return (MediaType) MoreObjects.a(s.get(mediaType), mediaType);
    }

    public MediaType E() {
        return this.f22931c.isEmpty() ? this : f(this.f22929a, this.f22930b);
    }

    public Optional<Charset> c() {
        Optional<Charset> optional = this.f22934f;
        if (optional == null) {
            optional = Optional.a();
            UnmodifiableIterator<String> k2 = this.f22931c.v(f22921g).iterator();
            String str = null;
            while (k2.hasNext()) {
                String next = k2.next();
                if (str == null) {
                    optional = Optional.f(Charset.forName(next));
                    str = next;
                } else if (!str.equals(next)) {
                    throw new IllegalStateException("Multiple charset values defined: " + str + ", " + next);
                }
            }
            this.f22934f = optional;
        }
        return optional;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MediaType)) {
            return false;
        }
        MediaType mediaType = (MediaType) obj;
        return this.f22929a.equals(mediaType.f22929a) && this.f22930b.equals(mediaType.f22930b) && w().equals(mediaType.w());
    }

    public int hashCode() {
        int i2 = this.f22933e;
        if (i2 != 0) {
            return i2;
        }
        int b2 = Objects.b(this.f22929a, this.f22930b, w());
        this.f22933e = b2;
        return b2;
    }

    public boolean q() {
        return r.equals(this.f22929a) || r.equals(this.f22930b);
    }

    public boolean r(MediaType mediaType) {
        return (mediaType.f22929a.equals(r) || mediaType.f22929a.equals(this.f22929a)) && (mediaType.f22930b.equals(r) || mediaType.f22930b.equals(this.f22930b)) && this.f22931c.j().containsAll(mediaType.f22931c.j());
    }

    public String toString() {
        String str = this.f22932d;
        if (str != null) {
            return str;
        }
        String d2 = d();
        this.f22932d = d2;
        return d2;
    }

    public ImmutableListMultimap<String, String> v() {
        return this.f22931c;
    }

    public String y() {
        return this.f22930b;
    }

    public String z() {
        return this.f22929a;
    }
}
