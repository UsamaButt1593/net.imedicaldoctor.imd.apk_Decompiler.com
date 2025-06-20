package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public abstract class BaseField {
    public static final int A = 8388608;
    public static final int B = 8192;
    public static final int C = 1048576;
    public static final int D = 4194304;
    public static final int E = 262144;
    public static final int F = 2097152;
    public static final int G = 16777216;
    private static final HashMap<PdfName, Integer> H;
    public static final float q = 1.0f;
    public static final float r = 2.0f;
    public static final float s = 3.0f;
    public static final int t = 0;
    public static final int u = 1;
    public static final int v = 2;
    public static final int w = 3;
    public static final int x = 1;
    public static final int y = 2;
    public static final int z = 4096;

    /* renamed from: a  reason: collision with root package name */
    protected float f25924a = 1.0f;

    /* renamed from: b  reason: collision with root package name */
    protected int f25925b = 0;

    /* renamed from: c  reason: collision with root package name */
    protected BaseColor f25926c;

    /* renamed from: d  reason: collision with root package name */
    protected BaseColor f25927d;

    /* renamed from: e  reason: collision with root package name */
    protected BaseColor f25928e;

    /* renamed from: f  reason: collision with root package name */
    protected BaseFont f25929f;

    /* renamed from: g  reason: collision with root package name */
    protected float f25930g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    protected int f25931h = 0;

    /* renamed from: i  reason: collision with root package name */
    protected PdfWriter f25932i;

    /* renamed from: j  reason: collision with root package name */
    protected String f25933j;

    /* renamed from: k  reason: collision with root package name */
    protected Rectangle f25934k;

    /* renamed from: l  reason: collision with root package name */
    protected int f25935l = 0;

    /* renamed from: m  reason: collision with root package name */
    protected int f25936m;

    /* renamed from: n  reason: collision with root package name */
    protected String f25937n;
    protected int o;
    protected int p;

    static {
        HashMap<PdfName, Integer> hashMap = new HashMap<>();
        H = hashMap;
        hashMap.putAll(PdfCopyFieldsImp.s6);
        hashMap.put(PdfName.If, 1);
    }

    public BaseField(PdfWriter pdfWriter, Rectangle rectangle, String str) {
        this.f25932i = pdfWriter;
        C(rectangle);
        this.f25937n = str;
    }

    protected static void O(StringBuffer stringBuffer) {
        int length = stringBuffer.length();
        while (length != 0) {
            length--;
            if (stringBuffer.charAt(length) == ' ') {
                stringBuffer.setLength(length);
            } else {
                return;
            }
        }
    }

    protected static ArrayList<String> a(ArrayList<String> arrayList, BaseFont baseFont, float f2, float f3) {
        BaseFont baseFont2 = baseFont;
        float f4 = f2;
        ArrayList<String> arrayList2 = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        int i3 = 0;
        while (i3 < arrayList.size()) {
            stringBuffer.setLength(i2);
            char[] charArray = arrayList.get(i3).toCharArray();
            int length = charArray.length;
            int i4 = 0;
            char c2 = 0;
            float f5 = 0.0f;
            int i5 = -1;
            int i6 = 0;
            while (i4 < length) {
                char c3 = charArray[i4];
                if (c2 != 0) {
                    if (c2 == 1) {
                        f5 += baseFont2.Y(c3, f4);
                        stringBuffer.append(c3);
                        if (c3 == ' ') {
                            i5 = i4;
                        }
                        if (f5 > f3) {
                            if (i5 >= 0) {
                                stringBuffer.setLength(i5 - i6);
                                O(stringBuffer);
                                arrayList2.add(stringBuffer.toString());
                                stringBuffer.setLength(0);
                                i4 = i5;
                                i6 = i4;
                                c2 = 2;
                                f5 = 0.0f;
                                i5 = -1;
                            } else {
                                if (stringBuffer.length() > 1) {
                                    i4--;
                                    stringBuffer.setLength(stringBuffer.length() - 1);
                                }
                                arrayList2.add(stringBuffer.toString());
                                stringBuffer.setLength(0);
                                if (c3 != ' ') {
                                    i6 = i4;
                                    f5 = 0.0f;
                                }
                                i6 = i4;
                                c2 = 2;
                                f5 = 0.0f;
                            }
                        }
                    } else if (c2 == 2 && c3 != ' ') {
                        i4--;
                    }
                    i4++;
                } else {
                    f5 += baseFont2.Y(c3, f4);
                    stringBuffer.append(c3);
                    if (f5 > f3) {
                        if (stringBuffer.length() > 1) {
                            i4--;
                            stringBuffer.setLength(stringBuffer.length() - 1);
                        }
                        arrayList2.add(stringBuffer.toString());
                        stringBuffer.setLength(0);
                        if (c3 != ' ') {
                            i6 = i4;
                        }
                        i6 = i4;
                        c2 = 2;
                        f5 = 0.0f;
                        i4++;
                    } else {
                        if (c3 != ' ') {
                            c2 = 1;
                        }
                        i4++;
                    }
                }
                c2 = 1;
                f5 = 0.0f;
                i4++;
            }
            O(stringBuffer);
            arrayList2.add(stringBuffer.toString());
            i3++;
            i2 = 0;
        }
        return arrayList2;
    }

    private void b(PdfAppearance pdfAppearance) {
        float f2 = this.f25924a;
        pdfAppearance.w1(f2, f2);
        float a0 = this.f25934k.a0();
        float f3 = this.f25924a;
        pdfAppearance.q1(a0 - f3, f3);
        pdfAppearance.q1(this.f25934k.a0() - this.f25924a, this.f25934k.N() - this.f25924a);
        pdfAppearance.q1(this.f25934k.a0() - (this.f25924a * 2.0f), this.f25934k.N() - (this.f25924a * 2.0f));
        float a02 = this.f25934k.a0();
        float f4 = this.f25924a;
        pdfAppearance.q1(a02 - (f4 * 2.0f), f4 * 2.0f);
        float f5 = this.f25924a;
        pdfAppearance.q1(f5 * 2.0f, f5 * 2.0f);
        float f6 = this.f25924a;
        pdfAppearance.q1(f6, f6);
        pdfAppearance.Q0();
    }

    private void c(PdfAppearance pdfAppearance) {
        float f2 = this.f25924a;
        pdfAppearance.w1(f2, f2);
        pdfAppearance.q1(this.f25924a, this.f25934k.N() - this.f25924a);
        pdfAppearance.q1(this.f25934k.a0() - this.f25924a, this.f25934k.N() - this.f25924a);
        pdfAppearance.q1(this.f25934k.a0() - (this.f25924a * 2.0f), this.f25934k.N() - (this.f25924a * 2.0f));
        pdfAppearance.q1(this.f25924a * 2.0f, this.f25934k.N() - (this.f25924a * 2.0f));
        float f3 = this.f25924a;
        pdfAppearance.q1(f3 * 2.0f, f3 * 2.0f);
        float f4 = this.f25924a;
        pdfAppearance.q1(f4, f4);
        pdfAppearance.Q0();
    }

    protected static ArrayList<String> n(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        while (i2 < length) {
            char c2 = charArray[i2];
            if (c2 == 13) {
                int i3 = i2 + 1;
                if (i3 < length && charArray[i3] == 10) {
                    i2 = i3;
                }
                arrayList.add(stringBuffer.toString());
                stringBuffer = new StringBuffer();
            } else if (c2 == 10) {
                arrayList.add(stringBuffer.toString());
                stringBuffer = new StringBuffer();
            } else {
                stringBuffer.append(c2);
            }
            i2++;
        }
        arrayList.add(stringBuffer.toString());
        return arrayList;
    }

    public static void w(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2) {
        Iterator<PdfName> it2 = pdfDictionary.G0().iterator();
        while (it2.hasNext()) {
            PdfName next = it2.next();
            if (H.containsKey(next)) {
                if (pdfDictionary2 != null) {
                    pdfDictionary2.V0(next, pdfDictionary.d0(next));
                }
                it2.remove();
            }
        }
    }

    public void A(int i2) {
        this.f25925b = i2;
    }

    public void B(float f2) {
        this.f25924a = f2;
    }

    public void C(Rectangle rectangle) {
        if (rectangle == null) {
            this.f25934k = null;
            return;
        }
        Rectangle rectangle2 = new Rectangle(rectangle);
        this.f25934k = rectangle2;
        rectangle2.e0();
    }

    public void D(String str) {
        this.f25937n = str;
    }

    public void E(BaseFont baseFont) {
        this.f25929f = baseFont;
    }

    public void F(float f2) {
        this.f25930g = f2;
    }

    public void G(int i2) {
        this.p = i2;
    }

    public void H(int i2) {
        this.o = i2;
    }

    public void I(int i2) {
        if (i2 % 90 == 0) {
            int i3 = i2 % 360;
            if (i3 < 0) {
                i3 += 360;
            }
            this.f25935l = i3;
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.b("rotation.must.be.a.multiple.of.90", new Object[0]));
    }

    public void J(Rectangle rectangle) {
        I(rectangle.S());
    }

    public void K(String str) {
        this.f25933j = str;
    }

    public void L(BaseColor baseColor) {
        this.f25928e = baseColor;
    }

    public void M(int i2) {
        this.f25936m = i2;
    }

    public void N(PdfWriter pdfWriter) {
        this.f25932i = pdfWriter;
    }

    public int d() {
        return this.f25931h;
    }

    public BaseColor e() {
        return this.f25927d;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.pdf.PdfAppearance f() {
        /*
            r10 = this;
            com.itextpdf.text.pdf.PdfWriter r0 = r10.f25932i
            com.itextpdf.text.Rectangle r1 = r10.f25934k
            float r1 = r1.a0()
            com.itextpdf.text.Rectangle r2 = r10.f25934k
            float r2 = r2.N()
            com.itextpdf.text.pdf.PdfAppearance r0 = com.itextpdf.text.pdf.PdfAppearance.a4(r0, r1, r2)
            int r1 = r10.f25935l
            r2 = 90
            if (r1 == r2) goto L_0x0046
            r2 = 180(0xb4, float:2.52E-43)
            if (r1 == r2) goto L_0x0033
            r2 = 270(0x10e, float:3.78E-43)
            if (r1 == r2) goto L_0x0021
            goto L_0x0054
        L_0x0021:
            com.itextpdf.text.Rectangle r1 = r10.f25934k
            float r9 = r1.a0()
            r4 = 0
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r6 = 1065353216(0x3f800000, float:1.0)
            r7 = 0
            r8 = 0
        L_0x002e:
            r3 = r0
            r3.X3(r4, r5, r6, r7, r8, r9)
            goto L_0x0054
        L_0x0033:
            com.itextpdf.text.Rectangle r1 = r10.f25934k
            float r8 = r1.a0()
            com.itextpdf.text.Rectangle r1 = r10.f25934k
            float r9 = r1.N()
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            r5 = 0
            r6 = 0
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L_0x002e
        L_0x0046:
            com.itextpdf.text.Rectangle r1 = r10.f25934k
            float r8 = r1.N()
            r9 = 0
            r4 = 0
            r5 = 1065353216(0x3f800000, float:1.0)
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r7 = 0
            goto L_0x002e
        L_0x0054:
            r0.a2()
            com.itextpdf.text.BaseColor r1 = r10.f25927d
            r2 = 0
            if (r1 == 0) goto L_0x0071
            r0.h2(r1)
            com.itextpdf.text.Rectangle r1 = r10.f25934k
            float r1 = r1.a0()
            com.itextpdf.text.Rectangle r3 = r10.f25934k
            float r3 = r3.N()
            r0.H1(r2, r2, r1, r3)
            r0.Q0()
        L_0x0071:
            int r1 = r10.f25925b
            r3 = 4
            r4 = 1073741824(0x40000000, float:2.0)
            if (r1 != r3) goto L_0x00a1
            float r1 = r10.f25924a
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L_0x0198
            com.itextpdf.text.BaseColor r1 = r10.f25926c
            if (r1 == 0) goto L_0x0198
            r0.l2(r1)
            float r1 = r10.f25924a
            r0.J2(r1)
            float r1 = r10.f25924a
            float r1 = r1 / r4
            r0.w1(r2, r1)
            com.itextpdf.text.Rectangle r1 = r10.f25934k
            float r1 = r1.a0()
            float r2 = r10.f25924a
            float r2 = r2 / r4
            r0.q1(r1, r2)
        L_0x009c:
            r0.v3()
            goto L_0x0198
        L_0x00a1:
            r3 = 2
            if (r1 != r3) goto L_0x00ed
            float r1 = r10.f25924a
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L_0x00d3
            com.itextpdf.text.BaseColor r1 = r10.f25926c
            if (r1 == 0) goto L_0x00d3
            r0.l2(r1)
            float r1 = r10.f25924a
            r0.J2(r1)
            float r1 = r10.f25924a
            float r2 = r1 / r4
            float r1 = r1 / r4
            com.itextpdf.text.Rectangle r3 = r10.f25934k
            float r3 = r3.a0()
            float r4 = r10.f25924a
            float r3 = r3 - r4
            com.itextpdf.text.Rectangle r4 = r10.f25934k
            float r4 = r4.N()
            float r5 = r10.f25924a
            float r4 = r4 - r5
            r0.H1(r2, r1, r3, r4)
            r0.v3()
        L_0x00d3:
            com.itextpdf.text.BaseColor r1 = r10.f25927d
            if (r1 != 0) goto L_0x00d9
            com.itextpdf.text.BaseColor r1 = com.itextpdf.text.BaseColor.f25673b
        L_0x00d9:
            r2 = 1065353216(0x3f800000, float:1.0)
            r0.u2(r2)
            r10.c(r0)
            com.itextpdf.text.BaseColor r1 = r1.b()
            r0.h2(r1)
        L_0x00e8:
            r10.b(r0)
            goto L_0x0198
        L_0x00ed:
            r3 = 3
            if (r1 != r3) goto L_0x012d
            float r1 = r10.f25924a
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L_0x011f
            com.itextpdf.text.BaseColor r1 = r10.f25926c
            if (r1 == 0) goto L_0x011f
            r0.l2(r1)
            float r1 = r10.f25924a
            r0.J2(r1)
            float r1 = r10.f25924a
            float r2 = r1 / r4
            float r1 = r1 / r4
            com.itextpdf.text.Rectangle r3 = r10.f25934k
            float r3 = r3.a0()
            float r4 = r10.f25924a
            float r3 = r3 - r4
            com.itextpdf.text.Rectangle r4 = r10.f25934k
            float r4 = r4.N()
            float r5 = r10.f25924a
            float r4 = r4 - r5
            r0.H1(r2, r1, r3, r4)
            r0.v3()
        L_0x011f:
            r1 = 1056964608(0x3f000000, float:0.5)
            r0.u2(r1)
            r10.c(r0)
            r1 = 1061158912(0x3f400000, float:0.75)
            r0.u2(r1)
            goto L_0x00e8
        L_0x012d:
            float r3 = r10.f25924a
            int r3 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r3 == 0) goto L_0x0198
            com.itextpdf.text.BaseColor r3 = r10.f25926c
            if (r3 == 0) goto L_0x0198
            r3 = 1
            if (r1 != r3) goto L_0x013f
            r1 = 1077936128(0x40400000, float:3.0)
            r0.D2(r1, r2)
        L_0x013f:
            com.itextpdf.text.BaseColor r1 = r10.f25926c
            r0.l2(r1)
            float r1 = r10.f25924a
            r0.J2(r1)
            float r1 = r10.f25924a
            float r2 = r1 / r4
            float r1 = r1 / r4
            com.itextpdf.text.Rectangle r5 = r10.f25934k
            float r5 = r5.a0()
            float r6 = r10.f25924a
            float r5 = r5 - r6
            com.itextpdf.text.Rectangle r6 = r10.f25934k
            float r6 = r6.N()
            float r7 = r10.f25924a
            float r6 = r6 - r7
            r0.H1(r2, r1, r5, r6)
            r0.v3()
            int r1 = r10.o
            r2 = 16777216(0x1000000, float:2.3509887E-38)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0198
            int r1 = r10.p
            if (r1 <= r3) goto L_0x0198
            com.itextpdf.text.Rectangle r1 = r10.f25934k
            float r1 = r1.a0()
            int r2 = r10.p
            float r2 = (float) r2
            float r1 = r1 / r2
            float r2 = r10.f25924a
            float r2 = r2 / r4
            com.itextpdf.text.Rectangle r5 = r10.f25934k
            float r5 = r5.N()
            float r6 = r10.f25924a
            float r6 = r6 / r4
            float r5 = r5 - r6
        L_0x0188:
            int r4 = r10.p
            if (r3 >= r4) goto L_0x009c
            float r4 = (float) r3
            float r4 = r4 * r1
            r0.w1(r4, r2)
            r0.q1(r4, r5)
            int r3 = r3 + 1
            goto L_0x0188
        L_0x0198:
            r0.U1()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.BaseField.f():com.itextpdf.text.pdf.PdfAppearance");
    }

    public BaseColor g() {
        return this.f25926c;
    }

    public int h() {
        return this.f25925b;
    }

    public float i() {
        return this.f25924a;
    }

    public Rectangle j() {
        return this.f25934k;
    }

    public String k() {
        return this.f25937n;
    }

    public BaseFont l() {
        return this.f25929f;
    }

    public float m() {
        return this.f25930g;
    }

    public int o() {
        return this.p;
    }

    public int p() {
        return this.o;
    }

    /* access modifiers changed from: protected */
    public BaseFont q() throws IOException, DocumentException {
        BaseFont baseFont = this.f25929f;
        return baseFont == null ? BaseFont.j("Helvetica", "Cp1252", false) : baseFont;
    }

    public int r() {
        return this.f25935l;
    }

    public String s() {
        return this.f25933j;
    }

    public BaseColor t() {
        return this.f25928e;
    }

    public int u() {
        return this.f25936m;
    }

    public PdfWriter v() {
        return this.f25932i;
    }

    public void x(int i2) {
        this.f25931h = i2;
    }

    public void y(BaseColor baseColor) {
        this.f25927d = baseColor;
    }

    public void z(BaseColor baseColor) {
        this.f25926c = baseColor;
    }
}
