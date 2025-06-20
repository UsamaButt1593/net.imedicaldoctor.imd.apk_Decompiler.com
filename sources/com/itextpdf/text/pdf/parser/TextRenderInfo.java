package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.DocumentFont;
import com.itextpdf.text.pdf.PdfString;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.text.Typography;
import org.apache.commons.lang3.StringUtils;

public class TextRenderInfo {

    /* renamed from: a  reason: collision with root package name */
    private final PdfString f27053a;

    /* renamed from: b  reason: collision with root package name */
    private String f27054b = null;

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f27055c;

    /* renamed from: d  reason: collision with root package name */
    private final GraphicsState f27056d;

    /* renamed from: e  reason: collision with root package name */
    private Float f27057e = null;

    /* renamed from: f  reason: collision with root package name */
    private double[] f27058f = null;

    /* renamed from: g  reason: collision with root package name */
    private final Collection<MarkedContentInfo> f27059g;

    TextRenderInfo(PdfString pdfString, GraphicsState graphicsState, Matrix matrix, Collection<MarkedContentInfo> collection) {
        this.f27053a = pdfString;
        this.f27055c = matrix.c(graphicsState.f26927a);
        this.f27056d = graphicsState;
        this.f27059g = new ArrayList(collection);
        this.f27058f = graphicsState.f26932f.J();
    }

    private PdfString[] A(PdfString pdfString) {
        ArrayList arrayList = new ArrayList();
        String pdfString2 = pdfString.toString();
        int i2 = 0;
        while (i2 < pdfString2.length()) {
            int i3 = i2 + 1;
            PdfString pdfString3 = new PdfString(pdfString2.substring(i2, i3), pdfString.a0());
            if (c(pdfString3).length() == 0 && i2 < pdfString2.length() - 1) {
                pdfString3 = new PdfString(pdfString2.substring(i2, i2 + 2), pdfString.a0());
                i2 = i3;
            }
            arrayList.add(pdfString3);
            i2++;
        }
        return (PdfString[]) arrayList.toArray(new PdfString[arrayList.size()]);
    }

    private float a(float f2) {
        return new LineSegment(new Vector(0.0f, 0.0f, 1.0f), new Vector(0.0f, f2, 1.0f)).e(this.f27055c).c();
    }

    private float b(float f2) {
        return new LineSegment(new Vector(0.0f, 0.0f, 1.0f), new Vector(f2, 0.0f, 1.0f)).e(this.f27055c).c();
    }

    private String c(PdfString pdfString) {
        byte[] k2 = pdfString.k();
        return this.f27056d.f26932f.N0(k2, 0, k2.length);
    }

    private int f(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-16BE");
            int i2 = 0;
            for (int i3 = 0; i3 < bytes.length - 1; i3++) {
                i2 = (i2 + (bytes[i3] & 255)) << 8;
            }
            return bytes.length > 0 ? i2 + (bytes[bytes.length - 1] & 255) : i2;
        } catch (UnsupportedEncodingException unused) {
            return 0;
        }
    }

    private float m(PdfString pdfString, boolean z) {
        if (z) {
            float[] x = x(pdfString, z);
            float f2 = x[0];
            GraphicsState graphicsState = this.f27056d;
            return ((f2 * graphicsState.f26933g) + graphicsState.f26928b + x[1]) * graphicsState.f26930d;
        }
        float f3 = 0.0f;
        for (PdfString m2 : A(pdfString)) {
            f3 += m(m2, true);
        }
        return f3;
    }

    private float p(String str) {
        float f2 = 0.0f;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            float W = ((float) this.f27056d.f26932f.W(charAt)) / 1000.0f;
            float f3 = charAt == ' ' ? this.f27056d.f26929c : 0.0f;
            GraphicsState graphicsState = this.f27056d;
            f2 += ((W * graphicsState.f26933g) + graphicsState.f26928b + f3) * graphicsState.f26930d;
        }
        return f2;
    }

    private LineSegment u(float f2) {
        String m0 = this.f27053a.m0();
        return new LineSegment(new Vector(0.0f, f2, 1.0f), new Vector(w() - ((this.f27056d.f26928b + ((m0.length() <= 0 || m0.charAt(m0.length() + -1) != ' ') ? 0.0f : this.f27056d.f26929c)) * this.f27056d.f26930d), f2, 1.0f));
    }

    private float v() {
        char c2 = ' ';
        if (this.f27056d.f26932f.W(32) == 0) {
            c2 = Typography.f29120g;
        }
        return p(String.valueOf(c2));
    }

    private float[] x(PdfString pdfString, boolean z) {
        if (z) {
            String c2 = c(pdfString);
            return new float[]{(float) (((double) this.f27056d.f26932f.W(f(c2))) * this.f27058f[0]), c2.equals(StringUtils.SPACE) ? this.f27056d.f26929c : 0.0f};
        }
        throw new UnsupportedOperationException();
    }

    public LineSegment d() {
        return u(this.f27056d.f().I(1, this.f27056d.g()) + this.f27056d.f26935i).e(this.f27055c);
    }

    public LineSegment e() {
        return u(this.f27056d.f26935i + 0.0f).e(this.f27055c);
    }

    public List<TextRenderInfo> g() {
        ArrayList<TextRenderInfo> arrayList = new ArrayList<>(this.f27053a.O());
        PdfString[] A = A(this.f27053a);
        float f2 = 0.0f;
        for (int i2 = 0; i2 < A.length; i2++) {
            float[] x = x(A[i2], true);
            arrayList.add(new TextRenderInfo(this, A[i2], f2));
            float f3 = x[0];
            GraphicsState graphicsState = this.f27056d;
            f2 += ((f3 * graphicsState.f26933g) + graphicsState.f26928b + x[1]) * graphicsState.f26930d;
        }
        for (TextRenderInfo w : arrayList) {
            w.w();
        }
        return arrayList;
    }

    public LineSegment h() {
        return u(this.f27056d.f().I(3, this.f27056d.g()) + this.f27056d.f26935i).e(this.f27055c);
    }

    public BaseColor i() {
        return this.f27056d.f26939m;
    }

    public DocumentFont j() {
        return this.f27056d.f();
    }

    public Integer k() {
        Collection<MarkedContentInfo> collection = this.f27059g;
        if (!(collection instanceof ArrayList)) {
            return null;
        }
        ArrayList arrayList = (ArrayList) collection;
        MarkedContentInfo markedContentInfo = arrayList.size() > 0 ? (MarkedContentInfo) arrayList.get(arrayList.size() - 1) : null;
        if (markedContentInfo == null || !markedContentInfo.c()) {
            return null;
        }
        return Integer.valueOf(markedContentInfo.a());
    }

    public PdfString l() {
        return this.f27053a;
    }

    public float n() {
        float f2 = this.f27056d.f26935i;
        if (f2 == 0.0f) {
            return 0.0f;
        }
        return a(f2);
    }

    public float o() {
        return b(v());
    }

    public BaseColor q() {
        return this.f27056d.f26940n;
    }

    public String r() {
        if (this.f27054b == null) {
            this.f27054b = c(this.f27053a);
        }
        return this.f27054b;
    }

    public int s() {
        return this.f27056d.f26934h;
    }

    public LineSegment t() {
        return u(this.f27056d.f26935i + 0.0f);
    }

    /* access modifiers changed from: package-private */
    public float w() {
        if (this.f27057e == null) {
            this.f27057e = Float.valueOf(m(this.f27053a, false));
        }
        return this.f27057e.floatValue();
    }

    public boolean y(int i2) {
        return z(i2, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r6 = k();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean z(int r5, boolean r6) {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            if (r6 == 0) goto L_0x0019
            java.util.Collection<com.itextpdf.text.pdf.parser.MarkedContentInfo> r6 = r4.f27059g
            boolean r6 = r6 instanceof java.util.ArrayList
            if (r6 == 0) goto L_0x0038
            java.lang.Integer r6 = r4.k()
            if (r6 == 0) goto L_0x0017
            int r6 = r6.intValue()
            if (r6 != r5) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            return r0
        L_0x0019:
            java.util.Collection<com.itextpdf.text.pdf.parser.MarkedContentInfo> r6 = r4.f27059g
            java.util.Iterator r6 = r6.iterator()
        L_0x001f:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L_0x0038
            java.lang.Object r2 = r6.next()
            com.itextpdf.text.pdf.parser.MarkedContentInfo r2 = (com.itextpdf.text.pdf.parser.MarkedContentInfo) r2
            boolean r3 = r2.c()
            if (r3 == 0) goto L_0x001f
            int r2 = r2.a()
            if (r2 != r5) goto L_0x001f
            return r0
        L_0x0038:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.parser.TextRenderInfo.z(int, boolean):boolean");
    }

    private TextRenderInfo(TextRenderInfo textRenderInfo, PdfString pdfString, float f2) {
        this.f27053a = pdfString;
        this.f27055c = new Matrix(f2, 0.0f).c(textRenderInfo.f27055c);
        GraphicsState graphicsState = textRenderInfo.f27056d;
        this.f27056d = graphicsState;
        this.f27059g = textRenderInfo.f27059g;
        this.f27058f = graphicsState.f26932f.J();
    }
}
