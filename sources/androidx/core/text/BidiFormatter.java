package androidx.core.text;

import android.text.SpannableStringBuilder;
import com.dd.plist.ASCIIPropertyListParser;
import java.util.Locale;

public final class BidiFormatter {

    /* renamed from: d  reason: collision with root package name */
    static final TextDirectionHeuristicCompat f6156d;

    /* renamed from: e  reason: collision with root package name */
    private static final char f6157e = '‪';

    /* renamed from: f  reason: collision with root package name */
    private static final char f6158f = '‫';

    /* renamed from: g  reason: collision with root package name */
    private static final char f6159g = '‬';

    /* renamed from: h  reason: collision with root package name */
    private static final char f6160h = '‎';

    /* renamed from: i  reason: collision with root package name */
    private static final char f6161i = '‏';

    /* renamed from: j  reason: collision with root package name */
    private static final String f6162j = Character.toString(f6160h);

    /* renamed from: k  reason: collision with root package name */
    private static final String f6163k = Character.toString(f6161i);

    /* renamed from: l  reason: collision with root package name */
    private static final String f6164l = "";

    /* renamed from: m  reason: collision with root package name */
    private static final int f6165m = 2;

    /* renamed from: n  reason: collision with root package name */
    private static final int f6166n = 2;
    static final BidiFormatter o;
    static final BidiFormatter p;
    private static final int q = -1;
    private static final int r = 0;
    private static final int s = 1;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f6167a;

    /* renamed from: b  reason: collision with root package name */
    private final int f6168b;

    /* renamed from: c  reason: collision with root package name */
    private final TextDirectionHeuristicCompat f6169c;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private boolean f6170a;

        /* renamed from: b  reason: collision with root package name */
        private int f6171b;

        /* renamed from: c  reason: collision with root package name */
        private TextDirectionHeuristicCompat f6172c;

        public Builder() {
            c(BidiFormatter.j(Locale.getDefault()));
        }

        private static BidiFormatter b(boolean z) {
            return z ? BidiFormatter.p : BidiFormatter.o;
        }

        private void c(boolean z) {
            this.f6170a = z;
            this.f6172c = BidiFormatter.f6156d;
            this.f6171b = 2;
        }

        public BidiFormatter a() {
            return (this.f6171b == 2 && this.f6172c == BidiFormatter.f6156d) ? b(this.f6170a) : new BidiFormatter(this.f6170a, this.f6171b, this.f6172c);
        }

        public Builder d(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.f6172c = textDirectionHeuristicCompat;
            return this;
        }

        public Builder e(boolean z) {
            this.f6171b = z ? this.f6171b | 2 : this.f6171b & -3;
            return this;
        }

        public Builder(Locale locale) {
            c(BidiFormatter.j(locale));
        }

        public Builder(boolean z) {
            c(z);
        }
    }

    private static class DirectionalityEstimator {

        /* renamed from: f  reason: collision with root package name */
        private static final int f6173f = 1792;

        /* renamed from: g  reason: collision with root package name */
        private static final byte[] f6174g = new byte[f6173f];

        /* renamed from: a  reason: collision with root package name */
        private final CharSequence f6175a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f6176b;

        /* renamed from: c  reason: collision with root package name */
        private final int f6177c;

        /* renamed from: d  reason: collision with root package name */
        private int f6178d;

        /* renamed from: e  reason: collision with root package name */
        private char f6179e;

        static {
            for (int i2 = 0; i2 < f6173f; i2++) {
                f6174g[i2] = Character.getDirectionality(i2);
            }
        }

        DirectionalityEstimator(CharSequence charSequence, boolean z) {
            this.f6175a = charSequence;
            this.f6176b = z;
            this.f6177c = charSequence.length();
        }

        private static byte c(char c2) {
            return c2 < f6173f ? f6174g[c2] : Character.getDirectionality(c2);
        }

        private byte f() {
            char charAt;
            int i2 = this.f6178d;
            do {
                int i3 = this.f6178d;
                if (i3 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f6175a;
                int i4 = i3 - 1;
                this.f6178d = i4;
                charAt = charSequence.charAt(i4);
                this.f6179e = charAt;
                if (charAt == '&') {
                    return 12;
                }
            } while (charAt != ';');
            this.f6178d = i2;
            this.f6179e = ASCIIPropertyListParser.f18655m;
            return 13;
        }

        private byte g() {
            char charAt;
            do {
                int i2 = this.f6178d;
                if (i2 >= this.f6177c) {
                    return 12;
                }
                CharSequence charSequence = this.f6175a;
                this.f6178d = i2 + 1;
                charAt = charSequence.charAt(i2);
                this.f6179e = charAt;
            } while (charAt != ';');
            return 12;
        }

        private byte h() {
            char charAt;
            int i2 = this.f6178d;
            while (true) {
                int i3 = this.f6178d;
                if (i3 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f6175a;
                int i4 = i3 - 1;
                this.f6178d = i4;
                char charAt2 = charSequence.charAt(i4);
                this.f6179e = charAt2;
                if (charAt2 == '<') {
                    return 12;
                }
                if (charAt2 == '>') {
                    break;
                } else if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i5 = this.f6178d;
                        if (i5 <= 0) {
                            break;
                        }
                        CharSequence charSequence2 = this.f6175a;
                        int i6 = i5 - 1;
                        this.f6178d = i6;
                        charAt = charSequence2.charAt(i6);
                        this.f6179e = charAt;
                    } while (charAt != charAt2);
                }
            }
            this.f6178d = i2;
            this.f6179e = '>';
            return 13;
        }

        private byte i() {
            char charAt;
            int i2 = this.f6178d;
            while (true) {
                int i3 = this.f6178d;
                if (i3 < this.f6177c) {
                    CharSequence charSequence = this.f6175a;
                    this.f6178d = i3 + 1;
                    char charAt2 = charSequence.charAt(i3);
                    this.f6179e = charAt2;
                    if (charAt2 == '>') {
                        return 12;
                    }
                    if (charAt2 == '\"' || charAt2 == '\'') {
                        do {
                            int i4 = this.f6178d;
                            if (i4 >= this.f6177c) {
                                break;
                            }
                            CharSequence charSequence2 = this.f6175a;
                            this.f6178d = i4 + 1;
                            charAt = charSequence2.charAt(i4);
                            this.f6179e = charAt;
                        } while (charAt != charAt2);
                    }
                } else {
                    this.f6178d = i2;
                    this.f6179e = '<';
                    return 13;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public byte a() {
            char charAt = this.f6175a.charAt(this.f6178d - 1);
            this.f6179e = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.f6175a, this.f6178d);
                this.f6178d -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f6178d--;
            byte c2 = c(this.f6179e);
            if (!this.f6176b) {
                return c2;
            }
            char c3 = this.f6179e;
            if (c3 == '>') {
                return h();
            }
            return c3 == ';' ? f() : c2;
        }

        /* access modifiers changed from: package-private */
        public byte b() {
            char charAt = this.f6175a.charAt(this.f6178d);
            this.f6179e = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.f6175a, this.f6178d);
                this.f6178d += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f6178d++;
            byte c2 = c(this.f6179e);
            if (!this.f6176b) {
                return c2;
            }
            char c3 = this.f6179e;
            if (c3 == '<') {
                return i();
            }
            return c3 == '&' ? g() : c2;
        }

        /* access modifiers changed from: package-private */
        public int d() {
            this.f6178d = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (this.f6178d < this.f6177c && i2 == 0) {
                byte b2 = b();
                if (b2 != 0) {
                    if (b2 == 1 || b2 == 2) {
                        if (i4 == 0) {
                            return 1;
                        }
                    } else if (b2 != 9) {
                        switch (b2) {
                            case 14:
                            case 15:
                                i4++;
                                i3 = -1;
                                continue;
                            case 16:
                            case 17:
                                i4++;
                                i3 = 1;
                                continue;
                            case 18:
                                i4--;
                                i3 = 0;
                                continue;
                        }
                    }
                } else if (i4 == 0) {
                    return -1;
                }
                i2 = i4;
            }
            if (i2 == 0) {
                return 0;
            }
            if (i3 != 0) {
                return i3;
            }
            while (this.f6178d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i2 == i4) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i2 == i4) {
                            return 1;
                        }
                        break;
                    case 18:
                        i4++;
                        continue;
                }
                i4--;
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
            r1 = r1 - 1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int e() {
            /*
                r7 = this;
                int r0 = r7.f6177c
                r7.f6178d = r0
                r0 = 0
                r1 = 0
                r2 = 0
            L_0x0007:
                int r3 = r7.f6178d
                if (r3 <= 0) goto L_0x003b
                byte r3 = r7.a()
                r4 = -1
                if (r3 == 0) goto L_0x0034
                r5 = 1
                if (r3 == r5) goto L_0x002e
                r6 = 2
                if (r3 == r6) goto L_0x002e
                r6 = 9
                if (r3 == r6) goto L_0x0007
                switch(r3) {
                    case 14: goto L_0x002b;
                    case 15: goto L_0x002b;
                    case 16: goto L_0x0025;
                    case 17: goto L_0x0025;
                    case 18: goto L_0x0022;
                    default: goto L_0x001f;
                }
            L_0x001f:
                if (r2 != 0) goto L_0x0007
                goto L_0x0039
            L_0x0022:
                int r1 = r1 + 1
                goto L_0x0007
            L_0x0025:
                if (r2 != r1) goto L_0x0028
                return r5
            L_0x0028:
                int r1 = r1 + -1
                goto L_0x0007
            L_0x002b:
                if (r2 != r1) goto L_0x0028
                return r4
            L_0x002e:
                if (r1 != 0) goto L_0x0031
                return r5
            L_0x0031:
                if (r2 != 0) goto L_0x0007
                goto L_0x0039
            L_0x0034:
                if (r1 != 0) goto L_0x0037
                return r4
            L_0x0037:
                if (r2 != 0) goto L_0x0007
            L_0x0039:
                r2 = r1
                goto L_0x0007
            L_0x003b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.text.BidiFormatter.DirectionalityEstimator.e():int");
        }
    }

    static {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.f6205c;
        f6156d = textDirectionHeuristicCompat;
        o = new BidiFormatter(false, 2, textDirectionHeuristicCompat);
        p = new BidiFormatter(true, 2, textDirectionHeuristicCompat);
    }

    BidiFormatter(boolean z, int i2, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.f6167a = z;
        this.f6168b = i2;
        this.f6169c = textDirectionHeuristicCompat;
    }

    private static int a(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).d();
    }

    private static int b(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).e();
    }

    public static BidiFormatter c() {
        return new Builder().a();
    }

    public static BidiFormatter d(Locale locale) {
        return new Builder(locale).a();
    }

    public static BidiFormatter e(boolean z) {
        return new Builder(z).a();
    }

    static boolean j(Locale locale) {
        return TextUtilsCompat.a(locale) == 1;
    }

    private String k(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean b2 = textDirectionHeuristicCompat.b(charSequence, 0, charSequence.length());
        if (!this.f6167a && (b2 || b(charSequence) == 1)) {
            return f6162j;
        }
        if (this.f6167a) {
            return (!b2 || b(charSequence) == -1) ? f6163k : "";
        }
        return "";
    }

    private String l(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean b2 = textDirectionHeuristicCompat.b(charSequence, 0, charSequence.length());
        if (!this.f6167a && (b2 || a(charSequence) == 1)) {
            return f6162j;
        }
        if (this.f6167a) {
            return (!b2 || a(charSequence) == -1) ? f6163k : "";
        }
        return "";
    }

    public boolean f() {
        return (this.f6168b & 2) != 0;
    }

    public boolean g(CharSequence charSequence) {
        return this.f6169c.b(charSequence, 0, charSequence.length());
    }

    public boolean h(String str) {
        return g(str);
    }

    public boolean i() {
        return this.f6167a;
    }

    public CharSequence m(CharSequence charSequence) {
        return o(charSequence, this.f6169c, true);
    }

    public CharSequence n(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return o(charSequence, textDirectionHeuristicCompat, true);
    }

    public CharSequence o(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean b2 = textDirectionHeuristicCompat.b(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (f() && z) {
            spannableStringBuilder.append(l(charSequence, b2 ? TextDirectionHeuristicsCompat.f6204b : TextDirectionHeuristicsCompat.f6203a));
        }
        if (b2 != this.f6167a) {
            spannableStringBuilder.append(b2 ? f6158f : f6157e);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(f6159g);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append(k(charSequence, b2 ? TextDirectionHeuristicsCompat.f6204b : TextDirectionHeuristicsCompat.f6203a));
        }
        return spannableStringBuilder;
    }

    public CharSequence p(CharSequence charSequence, boolean z) {
        return o(charSequence, this.f6169c, z);
    }

    public String q(String str) {
        return s(str, this.f6169c, true);
    }

    public String r(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return s(str, textDirectionHeuristicCompat, true);
    }

    public String s(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        if (str == null) {
            return null;
        }
        return o(str, textDirectionHeuristicCompat, z).toString();
    }

    public String t(String str, boolean z) {
        return s(str, this.f6169c, z);
    }
}
