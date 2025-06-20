package com.itextpdf.text;

import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.pdf.BaseFont;

public class Font implements Comparable<Font> {
    public static final int Y2 = 0;
    public static final int Z2 = 1;
    public static final int a3 = 2;
    public static final int b3 = 4;
    public static final int c3 = 8;
    public static final int d3 = 3;
    public static final int e3 = -1;
    public static final int f3 = 12;
    private float X;
    private BaseFont X2;
    private int Y;
    private BaseColor Z;
    private FontFamily s;

    /* renamed from: com.itextpdf.text.Font$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25687a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.itextpdf.text.Font$FontFamily[] r0 = com.itextpdf.text.Font.FontFamily.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f25687a = r0
                com.itextpdf.text.Font$FontFamily r1 = com.itextpdf.text.Font.FontFamily.COURIER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f25687a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.itextpdf.text.Font$FontFamily r1 = com.itextpdf.text.Font.FontFamily.HELVETICA     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f25687a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.itextpdf.text.Font$FontFamily r1 = com.itextpdf.text.Font.FontFamily.TIMES_ROMAN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f25687a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.itextpdf.text.Font$FontFamily r1 = com.itextpdf.text.Font.FontFamily.SYMBOL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f25687a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.itextpdf.text.Font$FontFamily r1 = com.itextpdf.text.Font.FontFamily.ZAPFDINGBATS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.Font.AnonymousClass1.<clinit>():void");
        }
    }

    public enum FontFamily {
        COURIER,
        HELVETICA,
        TIMES_ROMAN,
        SYMBOL,
        ZAPFDINGBATS,
        UNDEFINED
    }

    public enum FontStyle {
        NORMAL(HtmlTags.y0),
        BOLD("bold"),
        ITALIC("italic"),
        OBLIQUE("oblique"),
        UNDERLINE("underline"),
        LINETHROUGH("line-through");
        
        private String s;

        private FontStyle(String str) {
            this.s = str;
        }

        public String a() {
            return this.s;
        }
    }

    public Font() {
        this(FontFamily.UNDEFINED, -1.0f, -1, (BaseColor) null);
    }

    public static FontFamily k(String str) {
        if (str.equalsIgnoreCase("Courier")) {
            return FontFamily.COURIER;
        }
        if (str.equalsIgnoreCase("Helvetica")) {
            return FontFamily.HELVETICA;
        }
        if (str.equalsIgnoreCase("Times-Roman")) {
            return FontFamily.TIMES_ROMAN;
        }
        if (str.equalsIgnoreCase("Symbol")) {
            return FontFamily.SYMBOL;
        }
        return str.equalsIgnoreCase("ZapfDingbats") ? FontFamily.ZAPFDINGBATS : FontFamily.UNDEFINED;
    }

    public static int o(String str) {
        str.indexOf(FontStyle.NORMAL.a());
        int i2 = str.indexOf(FontStyle.BOLD.a()) != -1 ? 1 : 0;
        if (str.indexOf(FontStyle.ITALIC.a()) != -1) {
            i2 |= 2;
        }
        if (str.indexOf(FontStyle.OBLIQUE.a()) != -1) {
            i2 |= 2;
        }
        if (str.indexOf(FontStyle.UNDERLINE.a()) != -1) {
            i2 |= 4;
        }
        return str.indexOf(FontStyle.LINETHROUGH.a()) != -1 ? i2 | 8 : i2;
    }

    public void A(String str) {
        if (this.Y == -1) {
            this.Y = 0;
        }
        this.Y = o(str) | this.Y;
    }

    /* renamed from: a */
    public int compareTo(Font font) {
        if (font == null) {
            return -1;
        }
        try {
            BaseFont baseFont = this.X2;
            if (baseFont != null && !baseFont.equals(font.c())) {
                return -2;
            }
            if (this.s != font.j()) {
                return 1;
            }
            if (this.X != font.m()) {
                return 2;
            }
            if (this.Y != font.n()) {
                return 3;
            }
            BaseColor baseColor = this.Z;
            return baseColor == null ? font.Z == null ? 0 : 4 : (font.Z != null && baseColor.equals(font.i())) ? 0 : 4;
        } catch (ClassCastException unused) {
            return -3;
        }
    }

    public Font b(Font font) {
        if (font == null) {
            return this;
        }
        float f2 = font.X;
        if (f2 == -1.0f) {
            f2 = this.X;
        }
        int i2 = this.Y;
        int n2 = font.n();
        int i3 = -1;
        if (!(i2 == -1 && n2 == -1)) {
            if (i2 == -1) {
                i2 = 0;
            }
            if (n2 == -1) {
                n2 = 0;
            }
            i3 = i2 | n2;
        }
        BaseColor baseColor = font.Z;
        if (baseColor == null) {
            baseColor = this.Z;
        }
        BaseFont baseFont = font.X2;
        if (baseFont != null) {
            return new Font(baseFont, f2, i3, baseColor);
        }
        if (font.j() != FontFamily.UNDEFINED) {
            return new Font(font.s, f2, i3, baseColor);
        }
        BaseFont baseFont2 = this.X2;
        if (baseFont2 != null) {
            return i3 == i2 ? new Font(baseFont2, f2, i3, baseColor) : FontFactory.e(l(), f2, i3, baseColor);
        }
        return new Font(this.s, f2, i3, baseColor);
    }

    public BaseFont c() {
        return this.X2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003b, code lost:
        if (r9 != false) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0040, code lost:
        r9 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0044, code lost:
        if (r9 != false) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.pdf.BaseFont e(boolean r9) {
        /*
            r8 = this;
            com.itextpdf.text.pdf.BaseFont r0 = r8.X2
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            int r0 = r8.Y
            r1 = -1
            r2 = 0
            if (r0 != r1) goto L_0x000c
            r0 = 0
        L_0x000c:
            int[] r1 = com.itextpdf.text.Font.AnonymousClass1.f25687a
            com.itextpdf.text.Font$FontFamily r3 = r8.s
            int r3 = r3.ordinal()
            r1 = r1[r3]
            r3 = 2
            r4 = 1
            r5 = 3
            java.lang.String r6 = "Cp1252"
            if (r1 == r4) goto L_0x005b
            if (r1 == r5) goto L_0x0047
            r7 = 4
            if (r1 == r7) goto L_0x0042
            r7 = 5
            if (r1 == r7) goto L_0x0039
            r9 = r0 & 3
            if (r9 == r4) goto L_0x0036
            if (r9 == r3) goto L_0x0033
            if (r9 == r5) goto L_0x0030
            java.lang.String r9 = "Helvetica"
            goto L_0x006e
        L_0x0030:
            java.lang.String r9 = "Helvetica-BoldOblique"
            goto L_0x006e
        L_0x0033:
            java.lang.String r9 = "Helvetica-Oblique"
            goto L_0x006e
        L_0x0036:
            java.lang.String r9 = "Helvetica-Bold"
            goto L_0x006e
        L_0x0039:
            java.lang.String r0 = "ZapfDingbats"
            if (r9 == 0) goto L_0x0040
        L_0x003d:
            r9 = r0
            r6 = r9
            goto L_0x006e
        L_0x0040:
            r9 = r0
            goto L_0x006e
        L_0x0042:
            java.lang.String r0 = "Symbol"
            if (r9 == 0) goto L_0x0040
            goto L_0x003d
        L_0x0047:
            r9 = r0 & 3
            if (r9 == r4) goto L_0x0058
            if (r9 == r3) goto L_0x0055
            if (r9 == r5) goto L_0x0052
            java.lang.String r9 = "Times-Roman"
            goto L_0x006e
        L_0x0052:
            java.lang.String r9 = "Times-BoldItalic"
            goto L_0x006e
        L_0x0055:
            java.lang.String r9 = "Times-Italic"
            goto L_0x006e
        L_0x0058:
            java.lang.String r9 = "Times-Bold"
            goto L_0x006e
        L_0x005b:
            r9 = r0 & 3
            if (r9 == r4) goto L_0x006c
            if (r9 == r3) goto L_0x0069
            if (r9 == r5) goto L_0x0066
            java.lang.String r9 = "Courier"
            goto L_0x006e
        L_0x0066:
            java.lang.String r9 = "Courier-BoldOblique"
            goto L_0x006e
        L_0x0069:
            java.lang.String r9 = "Courier-Oblique"
            goto L_0x006e
        L_0x006c:
            java.lang.String r9 = "Courier-Bold"
        L_0x006e:
            com.itextpdf.text.pdf.BaseFont r9 = com.itextpdf.text.pdf.BaseFont.j(r9, r6, r2)     // Catch:{ Exception -> 0x0073 }
            return r9
        L_0x0073:
            r9 = move-exception
            com.itextpdf.text.ExceptionConverter r0 = new com.itextpdf.text.ExceptionConverter
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.Font.e(boolean):com.itextpdf.text.pdf.BaseFont");
    }

    public float f(float f2) {
        return f2 * g();
    }

    public float g() {
        float f2 = this.X;
        if (f2 == -1.0f) {
            return 12.0f;
        }
        return f2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000b, code lost:
        r1 = r3.s;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int h() {
        /*
            r3 = this;
            int r0 = r3.Y
            r1 = -1
            if (r0 != r1) goto L_0x0006
            r0 = 0
        L_0x0006:
            com.itextpdf.text.pdf.BaseFont r1 = r3.X2
            if (r1 == 0) goto L_0x000b
            return r0
        L_0x000b:
            com.itextpdf.text.Font$FontFamily r1 = r3.s
            com.itextpdf.text.Font$FontFamily r2 = com.itextpdf.text.Font.FontFamily.SYMBOL
            if (r1 == r2) goto L_0x0018
            com.itextpdf.text.Font$FontFamily r2 = com.itextpdf.text.Font.FontFamily.ZAPFDINGBATS
            if (r1 != r2) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            r0 = r0 & -4
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.Font.h():int");
    }

    public BaseColor i() {
        return this.Z;
    }

    public FontFamily j() {
        return this.s;
    }

    public String l() {
        int i2 = AnonymousClass1.f25687a[j().ordinal()];
        if (i2 == 1) {
            return "Courier";
        }
        if (i2 == 2) {
            return "Helvetica";
        }
        if (i2 == 3) {
            return "Times-Roman";
        }
        if (i2 == 4) {
            return "Symbol";
        }
        if (i2 == 5) {
            return "ZapfDingbats";
        }
        BaseFont baseFont = this.X2;
        String str = "unknown";
        if (baseFont != null) {
            for (String[] strArr : baseFont.H()) {
                if ("0".equals(strArr[2])) {
                    return strArr[3];
                }
                if ("1033".equals(strArr[2])) {
                    str = strArr[3];
                }
                if ("".equals(strArr[2])) {
                    str = strArr[3];
                }
            }
        }
        return str;
    }

    public float m() {
        return this.X;
    }

    public int n() {
        return this.Y;
    }

    public boolean p() {
        int i2 = this.Y;
        return i2 != -1 && (i2 & 1) == 1;
    }

    public boolean q() {
        int i2 = this.Y;
        return i2 != -1 && (i2 & 2) == 2;
    }

    public boolean r() {
        return this.s == FontFamily.UNDEFINED && this.X == -1.0f && this.Y == -1 && this.Z == null && this.X2 == null;
    }

    public boolean s() {
        int i2 = this.Y;
        return i2 != -1 && (i2 & 8) == 8;
    }

    public boolean u() {
        int i2 = this.Y;
        return i2 != -1 && (i2 & 4) == 4;
    }

    public void v(int i2, int i3, int i4) {
        this.Z = new BaseColor(i2, i3, i4);
    }

    public void w(BaseColor baseColor) {
        this.Z = baseColor;
    }

    public void x(String str) {
        this.s = k(str);
    }

    public void y(float f2) {
        this.X = f2;
    }

    public void z(int i2) {
        this.Y = i2;
    }

    public Font(FontFamily fontFamily) {
        this(fontFamily, -1.0f, -1, (BaseColor) null);
    }

    public Font(FontFamily fontFamily, float f2) {
        this(fontFamily, f2, -1, (BaseColor) null);
    }

    public Font(FontFamily fontFamily, float f2, int i2) {
        this(fontFamily, f2, i2, (BaseColor) null);
    }

    public Font(FontFamily fontFamily, float f2, int i2, BaseColor baseColor) {
        FontFamily fontFamily2 = FontFamily.UNDEFINED;
        this.X2 = null;
        this.s = fontFamily;
        this.X = f2;
        this.Y = i2;
        this.Z = baseColor;
    }

    public Font(Font font) {
        this.s = FontFamily.UNDEFINED;
        this.X = -1.0f;
        this.Y = -1;
        this.Z = null;
        this.X2 = null;
        this.s = font.s;
        this.X = font.X;
        this.Y = font.Y;
        this.Z = font.Z;
        this.X2 = font.X2;
    }

    public Font(BaseFont baseFont) {
        this(baseFont, -1.0f, -1, (BaseColor) null);
    }

    public Font(BaseFont baseFont, float f2) {
        this(baseFont, f2, -1, (BaseColor) null);
    }

    public Font(BaseFont baseFont, float f2, int i2) {
        this(baseFont, f2, i2, (BaseColor) null);
    }

    public Font(BaseFont baseFont, float f2, int i2, BaseColor baseColor) {
        this.s = FontFamily.UNDEFINED;
        this.X2 = baseFont;
        this.X = f2;
        this.Y = i2;
        this.Z = baseColor;
    }
}
