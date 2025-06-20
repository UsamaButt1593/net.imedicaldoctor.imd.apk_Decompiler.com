package com.itextpdf.text.pdf;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.pdf.fonts.otf.Language;
import com.itextpdf.text.pdf.languages.BanglaGlyphRepositioner;
import com.itextpdf.text.pdf.languages.GlyphRepositioner;
import com.itextpdf.text.pdf.languages.IndicCompositeCharacterComparator;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class FontDetails {

    /* renamed from: a  reason: collision with root package name */
    PdfIndirectReference f26050a;

    /* renamed from: b  reason: collision with root package name */
    PdfName f26051b;

    /* renamed from: c  reason: collision with root package name */
    BaseFont f26052c;

    /* renamed from: d  reason: collision with root package name */
    TrueTypeFontUnicode f26053d;

    /* renamed from: e  reason: collision with root package name */
    CJKFont f26054e;

    /* renamed from: f  reason: collision with root package name */
    byte[] f26055f;

    /* renamed from: g  reason: collision with root package name */
    HashMap<Integer, int[]> f26056g;

    /* renamed from: h  reason: collision with root package name */
    IntHashtable f26057h;

    /* renamed from: i  reason: collision with root package name */
    int f26058i;

    /* renamed from: j  reason: collision with root package name */
    boolean f26059j;

    /* renamed from: k  reason: collision with root package name */
    protected boolean f26060k = true;

    /* renamed from: com.itextpdf.text.pdf.FontDetails$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f26061a;

        static {
            int[] iArr = new int[Language.values().length];
            f26061a = iArr;
            try {
                iArr[Language.BENGALI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    FontDetails(PdfName pdfName, PdfIndirectReference pdfIndirectReference, BaseFont baseFont) {
        this.f26051b = pdfName;
        this.f26050a = pdfIndirectReference;
        this.f26052c = baseFont;
        int K = baseFont.K();
        this.f26058i = K;
        if (K == 0 || K == 1) {
            this.f26055f = new byte[256];
        } else if (K == 2) {
            this.f26057h = new IntHashtable();
            this.f26054e = (CJKFont) baseFont;
        } else if (K == 3) {
            this.f26056g = new HashMap<>();
            this.f26053d = (TrueTypeFontUnicode) baseFont;
            this.f26059j = baseFont.f0();
        }
    }

    private boolean a() {
        return this.f26058i == 3 && this.f26053d.Z0() != null;
    }

    private byte[] c(String str) throws UnsupportedEncodingException {
        if (a()) {
            Map<String, Glyph> Z0 = this.f26053d.Z0();
            TreeSet treeSet = new TreeSet(new IndicCompositeCharacterComparator());
            treeSet.addAll(Z0.keySet());
            String[] b2 = new ArrayBasedStringTokenizer((String[]) treeSet.toArray(new String[0])).b(str);
            ArrayList arrayList = new ArrayList(50);
            for (String str2 : b2) {
                Glyph glyph = Z0.get(str2);
                if (glyph != null) {
                    arrayList.add(glyph);
                } else {
                    for (char c2 : str2.toCharArray()) {
                        int[] F0 = this.f26053d.F0(c2);
                        arrayList.add(new Glyph(F0[0], F0[1], String.valueOf(c2)));
                    }
                }
            }
            GlyphRepositioner g2 = g();
            if (g2 != null) {
                g2.a(arrayList);
            }
            char[] cArr = new char[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                Glyph glyph2 = (Glyph) arrayList.get(i2);
                int i3 = glyph2.f26064a;
                cArr[i2] = (char) i3;
                Integer valueOf = Integer.valueOf(i3);
                if (!this.f26056g.containsKey(valueOf)) {
                    this.f26056g.put(valueOf, new int[]{glyph2.f26064a, glyph2.f26065b, glyph2.f26066c.charAt(0)});
                }
            }
            return new String(cArr).getBytes("UnicodeBigUnmarked");
        }
        throw new IllegalArgumentException("Make sure the font type if TTF Unicode and a valid GlyphSubstitutionTable exists!");
    }

    private GlyphRepositioner g() {
        Language a1 = this.f26053d.a1();
        if (a1 == null) {
            throw new IllegalArgumentException("The supported language field cannot be null in " + this.f26053d.getClass().getName());
        } else if (AnonymousClass1.f26061a[a1.ordinal()] != 1) {
            return null;
        } else {
            return new BanglaGlyphRepositioner(Collections.unmodifiableMap(this.f26053d.M4), this.f26053d.Z0());
        }
    }

    /* access modifiers changed from: package-private */
    public byte[] b(String str) {
        int i2;
        int i3;
        int i4;
        int i5 = this.f26058i;
        if (i5 == 0 || i5 == 1) {
            byte[] e2 = this.f26052c.e(str);
            for (byte b2 : e2) {
                this.f26055f[b2 & 255] = 1;
            }
            return e2;
        } else if (i5 == 2) {
            int length = str.length();
            if (this.f26054e.F0()) {
                for (int i6 = 0; i6 < length; i6++) {
                    this.f26057h.l(str.charAt(i6), 0);
                }
            } else {
                int i7 = 0;
                while (i7 < length) {
                    if (Utilities.n(str, i7)) {
                        i2 = Utilities.f(str, i7);
                        i7++;
                    } else {
                        i2 = str.charAt(i7);
                    }
                    this.f26057h.l(this.f26054e.y(i2), 0);
                    i7++;
                }
            }
            return this.f26054e.e(str);
        } else if (i5 == 3) {
            try {
                int length2 = str.length();
                char[] cArr = new char[length2];
                if (this.f26059j) {
                    byte[] c2 = PdfEncodings.c(str, "symboltt");
                    int length3 = c2.length;
                    i3 = 0;
                    for (int i8 = 0; i8 < length3; i8++) {
                        int[] F0 = this.f26053d.F0(c2[i8] & 255);
                        if (F0 != null) {
                            this.f26056g.put(Integer.valueOf(F0[0]), new int[]{F0[0], F0[1], this.f26053d.T(c2[i8] & 255)});
                            cArr[i3] = (char) F0[0];
                            i3++;
                        }
                    }
                } else if (a()) {
                    return c(str);
                } else {
                    int i9 = 0;
                    i3 = 0;
                    while (i9 < length2) {
                        if (Utilities.n(str, i9)) {
                            i4 = Utilities.f(str, i9);
                            i9++;
                        } else {
                            i4 = str.charAt(i9);
                        }
                        int[] F02 = this.f26053d.F0(i4);
                        if (F02 != null) {
                            int i10 = F02[0];
                            Integer valueOf = Integer.valueOf(i10);
                            if (!this.f26056g.containsKey(valueOf)) {
                                this.f26056g.put(valueOf, new int[]{i10, F02[1], i4});
                            }
                            cArr[i3] = (char) i10;
                            i3++;
                        }
                        i9++;
                    }
                }
                return StringUtils.a(Utilities.h(cArr, 0, i3));
            } catch (UnsupportedEncodingException e3) {
                throw new ExceptionConverter(e3);
            }
        } else if (i5 == 4) {
            return this.f26052c.e(str);
        } else {
            if (i5 != 5) {
                return null;
            }
            return this.f26052c.e(str);
        }
    }

    /* access modifiers changed from: package-private */
    public Object[] d(String str) {
        if (this.f26058i == 3) {
            try {
                StringBuilder sb = new StringBuilder();
                int i2 = 0;
                for (char c2 : str.toCharArray()) {
                    int E0 = this.f26053d.E0(c2);
                    i2 += E0;
                    int V0 = this.f26053d.V0(c2);
                    if (V0 != 0) {
                        sb.append(Utilities.c(V0));
                    }
                    Integer valueOf = Integer.valueOf(c2);
                    if (!this.f26056g.containsKey(valueOf)) {
                        this.f26056g.put(valueOf, new int[]{c2, E0, V0});
                    }
                }
                return new Object[]{str.getBytes("UnicodeBigUnmarked"), sb.toString(), Integer.valueOf(i2)};
            } catch (Exception e2) {
                throw new ExceptionConverter(e2);
            }
        } else {
            throw new IllegalArgumentException("GID require TT Unicode");
        }
    }

    /* access modifiers changed from: package-private */
    public BaseFont e() {
        return this.f26052c;
    }

    /* access modifiers changed from: package-private */
    public PdfName f() {
        return this.f26051b;
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference h() {
        return this.f26050a;
    }

    public boolean i() {
        return this.f26060k;
    }

    public void j(boolean z) {
        this.f26060k = z;
    }

    public void k(PdfWriter pdfWriter) {
        try {
            int i2 = this.f26058i;
            if (i2 == 0 || i2 == 1) {
                int i3 = 0;
                while (true) {
                    if (i3 >= 256) {
                        break;
                    } else if (this.f26055f[i3] != 0) {
                        break;
                    } else {
                        i3++;
                    }
                }
                int i4 = 255;
                int i5 = 255;
                while (true) {
                    if (i5 < i3) {
                        break;
                    } else if (this.f26055f[i5] != 0) {
                        break;
                    } else {
                        i5--;
                    }
                }
                if (i3 > 255) {
                    i3 = 255;
                } else {
                    i4 = i5;
                }
                this.f26052c.t0(pdfWriter, this.f26050a, new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), this.f26055f, Boolean.valueOf(this.f26060k)});
            } else if (i2 == 2) {
                this.f26052c.t0(pdfWriter, this.f26050a, new Object[]{this.f26057h});
            } else if (i2 == 3) {
                this.f26052c.t0(pdfWriter, this.f26050a, new Object[]{this.f26056g, Boolean.valueOf(this.f26060k)});
            } else if (i2 == 5) {
                this.f26052c.t0(pdfWriter, this.f26050a, (Object[]) null);
            }
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }
}
