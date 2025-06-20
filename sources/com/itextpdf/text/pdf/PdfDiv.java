package com.itextpdf.text.pdf;

import com.itextpdf.text.AccessibleElementId;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import com.itextpdf.text.Image;
import com.itextpdf.text.api.Spaceable;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PdfDiv implements Element, Spaceable, IAccessibleElement {
    private Float X = null;
    private Float X2 = null;
    private Float Y = null;
    private Float Y2 = null;
    private Float Z = null;
    private Float Z2 = null;
    private Float a3 = null;
    private Float b3 = null;
    private float c3 = 0.0f;
    private float d3 = 0.0f;
    private int e3 = -1;
    private float f3 = 0.0f;
    private float g3 = 0.0f;
    private float h3 = 0.0f;
    private float i3 = 0.0f;
    private FloatType j3 = FloatType.NONE;
    private PositionType k3 = PositionType.STATIC;
    private DisplayType l3;
    private FloatLayout m3 = null;
    private BorderTopStyle n3;
    private float o3;
    protected int p3 = 0;
    private boolean q3 = false;
    protected PdfName r3 = PdfName.J6;
    private ArrayList<Element> s = new ArrayList<>();
    protected HashMap<PdfName, PdfObject> s3 = null;
    protected AccessibleElementId t3 = new AccessibleElementId();
    private BaseColor u3 = null;
    private Image v3;
    private Float w3;
    private Float x3;
    protected float y3;
    protected float z3;

    public enum BorderTopStyle {
        DOTTED,
        DASHED,
        SOLID,
        DOUBLE,
        GROOVE,
        RIDGE,
        INSET,
        OUTSET
    }

    public enum DisplayType {
        NONE,
        BLOCK,
        INLINE,
        INLINE_BLOCK,
        INLINE_TABLE,
        LIST_ITEM,
        RUN_IN,
        TABLE,
        TABLE_CAPTION,
        TABLE_CELL,
        TABLE_COLUMN_GROUP,
        TABLE_COLUMN,
        TABLE_FOOTER_GROUP,
        TABLE_HEADER_GROUP,
        TABLE_ROW,
        TABLE_ROW_GROUP
    }

    public enum FloatType {
        NONE,
        LEFT,
        RIGHT
    }

    public enum PositionType {
        STATIC,
        ABSOLUTE,
        FIXED,
        RELATIVE
    }

    public float A() {
        return this.g3;
    }

    public Float B() {
        return this.a3;
    }

    public Float C() {
        return this.b3;
    }

    public void D(AccessibleElementId accessibleElementId) {
        this.t3 = accessibleElementId;
    }

    public float E() {
        return this.y3;
    }

    public PositionType F() {
        return this.k3;
    }

    public Float G() {
        return this.Z;
    }

    public int H() {
        return this.p3;
    }

    public int I() {
        return this.e3;
    }

    public Float J() {
        return this.Y;
    }

    public float K() {
        return this.z3;
    }

    public PdfName L() {
        return this.r3;
    }

    public void M(float f2) {
        this.h3 = f2;
    }

    public Float N() {
        return this.Y2;
    }

    public float O() {
        return this.o3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0252  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01c0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int P(com.itextpdf.text.pdf.PdfContentByte r21, boolean r22, boolean r23, float r24, float r25, float r26, float r27) throws com.itextpdf.text.DocumentException {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r23
            r3 = r24
            r4 = r25
            r5 = r26
            r6 = r27
            float r7 = java.lang.Math.min(r3, r5)
            float r8 = java.lang.Math.max(r4, r6)
            float r4 = java.lang.Math.min(r4, r6)
            float r3 = java.lang.Math.max(r3, r5)
            r0.o3 = r8
            java.lang.Float r5 = r0.Y2
            r6 = 2
            r9 = 0
            java.lang.Float r10 = java.lang.Float.valueOf(r9)
            if (r5 == 0) goto L_0x0051
            float r5 = r5.floatValue()
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 <= 0) goto L_0x0051
            java.lang.Float r5 = r0.Y2
            float r5 = r5.floatValue()
            float r11 = r3 - r7
            int r5 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r5 >= 0) goto L_0x0046
            java.lang.Float r3 = r0.Y2
            float r3 = r3.floatValue()
        L_0x0044:
            float r3 = r3 + r7
            goto L_0x007b
        L_0x0046:
            java.lang.Float r5 = r0.Y2
            float r5 = r5.floatValue()
            int r5 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r5 <= 0) goto L_0x007b
            return r6
        L_0x0051:
            java.lang.Float r5 = r0.b3
            if (r5 == 0) goto L_0x005f
            float r3 = r3 - r7
            float r5 = r5.floatValue()
            float r3 = r3 * r5
            r0.c3 = r3
            goto L_0x0044
        L_0x005f:
            if (r5 != 0) goto L_0x007b
            com.itextpdf.text.pdf.PdfDiv$FloatType r5 = r0.j3
            com.itextpdf.text.pdf.PdfDiv$FloatType r11 = com.itextpdf.text.pdf.PdfDiv.FloatType.NONE
            if (r5 != r11) goto L_0x007b
            com.itextpdf.text.pdf.PdfDiv$DisplayType r5 = r0.l3
            if (r5 == 0) goto L_0x0077
            com.itextpdf.text.pdf.PdfDiv$DisplayType r11 = com.itextpdf.text.pdf.PdfDiv.DisplayType.BLOCK
            if (r5 == r11) goto L_0x0077
            com.itextpdf.text.pdf.PdfDiv$DisplayType r11 = com.itextpdf.text.pdf.PdfDiv.DisplayType.LIST_ITEM
            if (r5 == r11) goto L_0x0077
            com.itextpdf.text.pdf.PdfDiv$DisplayType r11 = com.itextpdf.text.pdf.PdfDiv.DisplayType.RUN_IN
            if (r5 != r11) goto L_0x007b
        L_0x0077:
            float r5 = r3 - r7
            r0.c3 = r5
        L_0x007b:
            java.lang.Float r5 = r0.Z2
            r11 = 1
            r12 = 0
            if (r5 == 0) goto L_0x00aa
            float r5 = r5.floatValue()
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 <= 0) goto L_0x00aa
            java.lang.Float r5 = r0.Z2
            float r5 = r5.floatValue()
            float r13 = r8 - r4
            int r5 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r5 >= 0) goto L_0x009f
            java.lang.Float r4 = r0.Z2
            float r4 = r4.floatValue()
            float r4 = r8 - r4
            r5 = 1
            goto L_0x00cc
        L_0x009f:
            java.lang.Float r5 = r0.Z2
            float r5 = r5.floatValue()
            int r5 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r5 <= 0) goto L_0x00cb
            return r6
        L_0x00aa:
            java.lang.Float r5 = r0.a3
            if (r5 == 0) goto L_0x00cb
            float r5 = r5.floatValue()
            double r5 = (double) r5
            r13 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r15 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r15 >= 0) goto L_0x00bb
            r5 = 1
            goto L_0x00bc
        L_0x00bb:
            r5 = 0
        L_0x00bc:
            float r4 = r8 - r4
            java.lang.Float r6 = r0.a3
            float r6 = r6.floatValue()
            float r4 = r4 * r6
            r0.d3 = r4
            float r4 = r8 - r4
            goto L_0x00cc
        L_0x00cb:
            r5 = 0
        L_0x00cc:
            if (r2 != 0) goto L_0x0118
            com.itextpdf.text.pdf.PdfDiv$PositionType r6 = r0.k3
            com.itextpdf.text.pdf.PdfDiv$PositionType r13 = com.itextpdf.text.pdf.PdfDiv.PositionType.RELATIVE
            if (r6 != r13) goto L_0x0118
            java.lang.Float r6 = r0.X
            if (r6 == 0) goto L_0x00d9
            goto L_0x00e8
        L_0x00d9:
            java.lang.Float r6 = r0.Z
            if (r6 == 0) goto L_0x00e7
            float r6 = r6.floatValue()
            float r6 = -r6
            java.lang.Float r6 = java.lang.Float.valueOf(r6)
            goto L_0x00e8
        L_0x00e7:
            r6 = r10
        L_0x00e8:
            java.lang.Float r13 = r0.Y
            if (r13 == 0) goto L_0x00f6
            float r10 = r13.floatValue()
            float r10 = -r10
            java.lang.Float r10 = java.lang.Float.valueOf(r10)
            goto L_0x00fb
        L_0x00f6:
            java.lang.Float r13 = r0.X2
            if (r13 == 0) goto L_0x00fb
            r10 = r13
        L_0x00fb:
            r21.a2()
            com.itextpdf.awt.geom.AffineTransform r15 = new com.itextpdf.awt.geom.AffineTransform
            float r18 = r6.floatValue()
            float r19 = r10.floatValue()
            r14 = 1065353216(0x3f800000, float:1.0)
            r6 = 0
            r16 = 0
            r17 = 1065353216(0x3f800000, float:1.0)
            r13 = r15
            r10 = r15
            r15 = r6
            r13.<init>((float) r14, (float) r15, (float) r16, (float) r17, (float) r18, (float) r19)
            r1.x3(r10)
        L_0x0118:
            if (r2 != 0) goto L_0x01bc
            com.itextpdf.text.BaseColor r6 = r0.u3
            if (r6 != 0) goto L_0x0122
            com.itextpdf.text.Image r6 = r0.v3
            if (r6 == 0) goto L_0x01bc
        L_0x0122:
            float r6 = r20.f()
            int r6 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r6 <= 0) goto L_0x01bc
            float r6 = r20.e()
            int r6 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r6 <= 0) goto L_0x01bc
            float r6 = r20.f()
            float r10 = r20.e()
            java.lang.Float r13 = r0.Y2
            if (r13 == 0) goto L_0x014e
            float r6 = r13.floatValue()
            int r6 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r6 <= 0) goto L_0x014d
            java.lang.Float r6 = r0.Y2
            float r6 = r6.floatValue()
            goto L_0x014e
        L_0x014d:
            r6 = 0
        L_0x014e:
            java.lang.Float r13 = r0.Z2
            if (r13 == 0) goto L_0x0162
            float r10 = r13.floatValue()
            int r10 = (r10 > r9 ? 1 : (r10 == r9 ? 0 : -1))
            if (r10 <= 0) goto L_0x0161
            java.lang.Float r10 = r0.Z2
            float r10 = r10.floatValue()
            goto L_0x0162
        L_0x0161:
            r10 = 0
        L_0x0162:
            int r13 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r13 <= 0) goto L_0x01bc
            int r13 = (r10 > r9 ? 1 : (r10 == r9 ? 0 : -1))
            if (r13 <= 0) goto L_0x01bc
            com.itextpdf.text.Rectangle r13 = new com.itextpdf.text.Rectangle
            float r10 = r8 - r10
            float r6 = r6 + r7
            r13.<init>(r7, r10, r6, r8)
            com.itextpdf.text.BaseColor r6 = r0.u3
            if (r6 == 0) goto L_0x0187
            r13.h0(r6)
            com.itextpdf.text.pdf.PdfArtifact r6 = new com.itextpdf.text.pdf.PdfArtifact
            r6.<init>()
            r1.B1(r6)
            r1.I1(r13)
            r1.c0(r6)
        L_0x0187:
            com.itextpdf.text.Image r6 = r0.v3
            if (r6 == 0) goto L_0x01bc
            java.lang.Float r10 = r0.w3
            if (r10 != 0) goto L_0x0193
            r6.U1(r13)
            goto L_0x01a0
        L_0x0193:
            float r10 = r10.floatValue()
            java.lang.Float r14 = r0.x3
            float r14 = r14.floatValue()
            r6.N1(r10, r14)
        L_0x01a0:
            com.itextpdf.text.Image r6 = r0.v3
            float r10 = r13.O()
            float r13 = r13.H()
            r6.V1(r10, r13)
            com.itextpdf.text.Image r6 = r0.v3
            r1.B1(r6)
            com.itextpdf.text.Image r6 = r0.v3
            r1.h(r6)
            com.itextpdf.text.Image r6 = r0.v3
            r1.c0(r6)
        L_0x01bc:
            java.lang.Float r6 = r0.b3
            if (r6 != 0) goto L_0x01c2
            r0.c3 = r9
        L_0x01c2:
            java.lang.Float r6 = r0.a3
            if (r6 != 0) goto L_0x01c8
            r0.d3 = r9
        L_0x01c8:
            float r6 = r0.i3
            float r4 = r4 + r6
            float r6 = r0.f3
            float r7 = r7 + r6
            float r6 = r0.g3
            float r3 = r3 - r6
            float r6 = r0.o3
            float r9 = r0.h3
            float r6 = r6 - r9
            r0.o3 = r6
            java.util.ArrayList<com.itextpdf.text.Element> r6 = r0.s
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L_0x0234
            com.itextpdf.text.pdf.FloatLayout r6 = r0.m3
            if (r6 != 0) goto L_0x01f9
            java.util.ArrayList r6 = new java.util.ArrayList
            java.util.ArrayList<com.itextpdf.text.Element> r9 = r0.s
            r6.<init>(r9)
            com.itextpdf.text.pdf.FloatLayout r9 = new com.itextpdf.text.pdf.FloatLayout
            r10 = r22
            r9.<init>(r6, r10)
            r0.m3 = r9
            int r6 = r0.p3
            r9.g(r6)
        L_0x01f9:
            com.itextpdf.text.pdf.FloatLayout r6 = r0.m3
            float r9 = r0.o3
            r6.h(r7, r4, r3, r9)
            com.itextpdf.text.pdf.PdfDiv$BorderTopStyle r3 = r20.i()
            if (r3 == 0) goto L_0x020d
            com.itextpdf.text.pdf.FloatLayout r3 = r0.m3
            com.itextpdf.text.pdf.ColumnText r3 = r3.f26047i
            r3.d0(r12)
        L_0x020d:
            com.itextpdf.text.pdf.FloatLayout r3 = r0.m3
            int r3 = r3.e(r1, r2)
            com.itextpdf.text.pdf.FloatLayout r4 = r0.m3
            float r4 = r4.d()
            r0.o3 = r4
            java.lang.Float r4 = r0.b3
            if (r4 != 0) goto L_0x0235
            float r4 = r0.c3
            com.itextpdf.text.pdf.FloatLayout r6 = r0.m3
            float r6 = r6.b()
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 >= 0) goto L_0x0235
            com.itextpdf.text.pdf.FloatLayout r4 = r0.m3
            float r4 = r4.b()
            r0.c3 = r4
            goto L_0x0235
        L_0x0234:
            r3 = 1
        L_0x0235:
            if (r2 != 0) goto L_0x0240
            com.itextpdf.text.pdf.PdfDiv$PositionType r2 = r0.k3
            com.itextpdf.text.pdf.PdfDiv$PositionType r4 = com.itextpdf.text.pdf.PdfDiv.PositionType.RELATIVE
            if (r2 != r4) goto L_0x0240
            r21.U1()
        L_0x0240:
            float r1 = r0.o3
            float r2 = r0.i3
            float r1 = r1 - r2
            r0.o3 = r1
            java.lang.Float r2 = r0.a3
            if (r2 != 0) goto L_0x024e
            float r8 = r8 - r1
            r0.d3 = r8
        L_0x024e:
            java.lang.Float r1 = r0.b3
            if (r1 != 0) goto L_0x025c
            float r1 = r0.c3
            float r2 = r0.f3
            float r4 = r0.g3
            float r2 = r2 + r4
            float r1 = r1 + r2
            r0.c3 = r1
        L_0x025c:
            if (r5 == 0) goto L_0x025f
            goto L_0x0260
        L_0x025f:
            r11 = r3
        L_0x0260:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfDiv.P(com.itextpdf.text.pdf.PdfContentByte, boolean, boolean, float, float, float, float):int");
    }

    public void Q(BaseColor baseColor) {
        this.u3 = baseColor;
    }

    public void R(Image image) {
        this.v3 = image;
    }

    public void S(Image image, float f2, float f4) {
        this.v3 = image;
        this.w3 = Float.valueOf(f2);
        this.x3 = Float.valueOf(f4);
    }

    public void T(BorderTopStyle borderTopStyle) {
        this.n3 = borderTopStyle;
    }

    public void U(PdfName pdfName, PdfObject pdfObject) {
        if (this.s3 == null) {
            this.s3 = new HashMap<>();
        }
        this.s3.put(pdfName, pdfObject);
    }

    public boolean V() {
        return true;
    }

    public void W(Float f2) {
        this.X2 = f2;
    }

    public float X() {
        return this.h3;
    }

    public List<Chunk> Y() {
        return new ArrayList();
    }

    public void Z(ArrayList<Element> arrayList) {
        this.s = arrayList;
    }

    public void a(Element element) {
        this.s.add(element);
    }

    public void a0(float f2) {
        this.d3 = f2;
    }

    public void b0(float f2) {
        this.c3 = f2;
    }

    public void c(float f2) {
        this.z3 = f2;
    }

    public void c0(DisplayType displayType) {
        this.l3 = displayType;
    }

    public void d0(FloatType floatType) {
        this.j3 = floatType;
    }

    public float e() {
        Float f2 = this.Z2;
        return (f2 == null || f2.floatValue() < this.d3) ? this.d3 : this.Z2.floatValue();
    }

    public void e0(Float f2) {
        this.Z2 = f2;
    }

    public float f() {
        Float f2 = this.Y2;
        return (f2 == null || f2.floatValue() < this.c3) ? this.c3 : this.Y2.floatValue();
    }

    public void f0(boolean z) {
        this.q3 = z;
    }

    public BaseColor g() {
        return this.u3;
    }

    public void g0(Float f2) {
        this.X = f2;
    }

    public AccessibleElementId getId() {
        return this.t3;
    }

    public void h(float f2) {
        this.y3 = f2;
    }

    public void h0(float f2) {
        this.i3 = f2;
    }

    public BorderTopStyle i() {
        return this.n3;
    }

    public void i0(float f2) {
        this.f3 = f2;
    }

    public Float j() {
        return this.X2;
    }

    public void j0(float f2) {
        this.g3 = f2;
    }

    public ArrayList<Element> k() {
        return this.s;
    }

    public HashMap<PdfName, PdfObject> k0() {
        return this.s3;
    }

    public float l() {
        return this.d3;
    }

    public void l0(Float f2) {
        this.a3 = f2;
    }

    public float m() {
        return this.c3;
    }

    public void m0(Float f2) {
        this.b3 = f2;
    }

    public boolean n() {
        return false;
    }

    public void n0(PositionType positionType) {
        this.k3 = positionType;
    }

    public void o(PdfName pdfName) {
        this.r3 = pdfName;
    }

    public void o0(Float f2) {
        this.Z = f2;
    }

    public DisplayType p() {
        return this.l3;
    }

    public void p0(int i2) {
        this.p3 = i2;
    }

    public FloatType q() {
        return this.j3;
    }

    public void q0(int i2) {
        this.e3 = i2;
    }

    public PdfObject r(PdfName pdfName) {
        HashMap<PdfName, PdfObject> hashMap = this.s3;
        if (hashMap != null) {
            return hashMap.get(pdfName);
        }
        return null;
    }

    public void r0(Float f2) {
        this.Y = f2;
    }

    public Float s() {
        return this.Z2;
    }

    public void s0(Float f2) {
        this.Y2 = f2;
    }

    public boolean t(ElementListener elementListener) {
        try {
            return elementListener.b(this);
        } catch (DocumentException unused) {
            return false;
        }
    }

    public int type() {
        return 37;
    }

    public boolean u() {
        return this.q3;
    }

    public Float v() {
        return this.X;
    }

    public float w() {
        return this.i3;
    }

    public boolean x() {
        return true;
    }

    public float y() {
        return this.f3;
    }
}
