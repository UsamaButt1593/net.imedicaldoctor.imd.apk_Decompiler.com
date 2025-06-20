package com.itextpdf.text.pdf;

import com.itextpdf.awt.geom.AffineTransform;
import com.itextpdf.text.AccessibleElementId;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class PdfAnnotation extends PdfDictionary implements IAccessibleElement {
    public static final PdfName A3 = PdfName.x9;
    public static final PdfName B3 = PdfName.Lb;
    public static final PdfName C3 = PdfName.tc;
    public static final PdfName D3 = PdfName.If;
    public static final int E3 = 1;
    public static final int F3 = 2;
    public static final int G3 = 4;
    public static final int H3 = 8;
    public static final int I3 = 16;
    public static final int J3 = 32;
    public static final int K3 = 64;
    public static final int L3 = 128;
    public static final int M3 = 256;
    public static final int N3 = 512;
    public static final PdfName O3;
    public static final PdfName P3 = PdfName.Dd;
    public static final PdfName Q3;
    public static final PdfName R3 = PdfName.c7;
    public static final PdfName S3 = PdfName.Vh;
    public static final PdfName T3;
    public static final PdfName U3 = PdfName.Og;
    public static final PdfName V3 = PdfName.k8;
    public static final PdfName W3 = PdfName.w4;
    public static final PdfName X3 = PdfName.ga;
    public static final PdfName Y3 = PdfName.F7;
    public static final PdfName Z3 = PdfName.kh;
    public static final PdfName a4 = PdfName.K4;
    public static final int b4 = 0;
    public static final int c4 = 1;
    public static final int d4 = 2;
    public static final int e4 = 3;
    public static final PdfName z3;
    protected PdfWriter p3;
    protected PdfIndirectReference q3;
    protected HashSet<PdfTemplate> r3;
    protected boolean s3 = false;
    protected boolean t3 = true;
    protected boolean u3 = false;
    private int v3 = -1;
    protected PdfName w3 = null;
    protected HashMap<PdfName, PdfObject> x3 = null;
    private AccessibleElementId y3 = null;

    public static class PdfImportedLink {

        /* renamed from: a  reason: collision with root package name */
        float f26121a;

        /* renamed from: b  reason: collision with root package name */
        float f26122b;

        /* renamed from: c  reason: collision with root package name */
        float f26123c;

        /* renamed from: d  reason: collision with root package name */
        float f26124d;

        /* renamed from: e  reason: collision with root package name */
        HashMap<PdfName, PdfObject> f26125e;

        /* renamed from: f  reason: collision with root package name */
        PdfArray f26126f = null;

        /* renamed from: g  reason: collision with root package name */
        int f26127g = 0;

        /* renamed from: h  reason: collision with root package name */
        PdfArray f26128h;

        PdfImportedLink(PdfDictionary pdfDictionary) {
            HashMap<PdfName, PdfObject> hashMap = new HashMap<>();
            this.f26125e = hashMap;
            hashMap.putAll(pdfDictionary.j3);
            try {
                PdfArray pdfArray = (PdfArray) this.f26125e.remove(PdfName.x6);
                this.f26126f = pdfArray;
                if (pdfArray != null) {
                    this.f26126f = new PdfArray(pdfArray);
                }
                PdfArray pdfArray2 = (PdfArray) this.f26125e.remove(PdfName.Nd);
                this.f26121a = pdfArray2.J0(0).a0();
                this.f26122b = pdfArray2.J0(1).a0();
                this.f26123c = pdfArray2.J0(2).a0();
                this.f26124d = pdfArray2.J0(3).a0();
                this.f26128h = new PdfArray(pdfArray2);
            } catch (ClassCastException unused) {
                throw new IllegalArgumentException(MessageLocalization.b("you.have.to.consolidate.the.named.destinations.of.your.reader", new Object[0]));
            }
        }

        private void a(StringBuffer stringBuffer, HashMap<PdfName, PdfObject> hashMap) {
            stringBuffer.append(" <<");
            for (Map.Entry next : hashMap.entrySet()) {
                stringBuffer.append(next.getKey());
                stringBuffer.append(":");
                boolean z = next.getValue() instanceof PdfDictionary;
                Object value = next.getValue();
                if (z) {
                    a(stringBuffer, ((PdfDictionary) value).j3);
                } else {
                    stringBuffer.append(value);
                }
                stringBuffer.append(StringUtils.SPACE);
            }
            stringBuffer.append(">> ");
        }

        public PdfAnnotation b(PdfWriter pdfWriter) {
            PdfAnnotation M0 = pdfWriter.M0(new Rectangle(this.f26121a, this.f26122b, this.f26123c, this.f26124d), (PdfName) null);
            int i2 = this.f26127g;
            if (i2 != 0) {
                this.f26126f.V0(0, pdfWriter.A1(i2));
            }
            PdfArray pdfArray = this.f26126f;
            if (pdfArray != null) {
                M0.V0(PdfName.x6, pdfArray);
            }
            M0.j3.putAll(this.f26125e);
            return M0;
        }

        public int c() {
            if (!f()) {
                return 0;
            }
            PRIndirectReference pRIndirectReference = (PRIndirectReference) this.f26126f.G0(0);
            PdfReader a0 = pRIndirectReference.a0();
            for (int i2 = 1; i2 <= a0.c0(); i2++) {
                PRIndirectReference j0 = a0.j0(i2);
                if (j0.Z() == pRIndirectReference.Z() && j0.d() == pRIndirectReference.d()) {
                    return i2;
                }
            }
            throw new IllegalArgumentException(MessageLocalization.b("page.not.found", new Object[0]));
        }

        public Map<PdfName, PdfObject> d() {
            return new HashMap(this.f26125e);
        }

        public PdfArray e() {
            return new PdfArray(this.f26128h);
        }

        public boolean f() {
            return this.f26126f != null;
        }

        public void g(int i2) {
            if (f()) {
                this.f26127g = i2;
                return;
            }
            throw new IllegalArgumentException(MessageLocalization.b("cannot.change.destination.of.external.link", new Object[0]));
        }

        public void h(float f2, float f3, float f4, float f5, float f6, float f7) {
            if (!f()) {
                throw new IllegalArgumentException(MessageLocalization.b("cannot.change.destination.of.external.link", new Object[0]));
            } else if (this.f26126f.I0(1).equals(PdfName.f26251fi)) {
                float a0 = this.f26126f.J0(2).a0();
                float a02 = this.f26126f.J0(3).a0();
                this.f26126f.V0(2, new PdfNumber((f2 * a0) + (f4 * a02) + f6));
                this.f26126f.V0(3, new PdfNumber((a0 * f3) + (a02 * f5) + f7));
            }
        }

        public void i(float f2, float f3, float f4, float f5, float f6, float f7) {
            float f8 = this.f26121a;
            float f9 = this.f26122b;
            this.f26121a = (f8 * f2) + (f9 * f4) + f6;
            this.f26122b = (f8 * f3) + (f9 * f5) + f7;
            float f10 = this.f26123c;
            float f11 = this.f26124d;
            this.f26123c = (f2 * f10) + (f4 * f11) + f6;
            this.f26124d = (f10 * f3) + (f11 * f5) + f7;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("Imported link: location [");
            stringBuffer.append(this.f26121a);
            stringBuffer.append(' ');
            stringBuffer.append(this.f26122b);
            stringBuffer.append(' ');
            stringBuffer.append(this.f26123c);
            stringBuffer.append(' ');
            stringBuffer.append(this.f26124d);
            stringBuffer.append("] destination ");
            stringBuffer.append(this.f26126f);
            stringBuffer.append(" parameters ");
            stringBuffer.append(this.f26125e);
            HashMap<PdfName, PdfObject> hashMap = this.f26125e;
            if (hashMap != null) {
                a(stringBuffer, hashMap);
            }
            return stringBuffer.toString();
        }
    }

    static {
        PdfName pdfName = PdfName.kb;
        z3 = pdfName;
        O3 = pdfName;
        PdfName pdfName2 = PdfName.f6;
        Q3 = pdfName2;
        T3 = pdfName2;
    }

    public PdfAnnotation(PdfWriter pdfWriter, float f2, float f3, float f4, float f5, PdfAction pdfAction) {
        this.p3 = pdfWriter;
        V0(PdfName.Cf, PdfName.Ca);
        V0(PdfName.Nd, new PdfRectangle(f2, f3, f4, f5));
        V0(PdfName.k3, pdfAction);
        V0(PdfName.D4, new PdfBorderArray(0.0f, 0.0f, 0.0f));
        V0(PdfName.K4, new PdfColor(0, 0, 255));
    }

    public static PdfAnnotation B1(PdfWriter pdfWriter, Rectangle rectangle, String str, boolean z, PdfArray pdfArray) {
        PdfAnnotation M0 = pdfWriter.M0(rectangle, z ? PdfName.Xc : PdfName.Yc);
        M0.V0(PdfName.N5, new PdfString(str, PdfObject.h3));
        M0.V0(PdfName.qh, new PdfArray(pdfArray));
        return M0;
    }

    public static PdfAnnotation E1(PdfWriter pdfWriter, Rectangle rectangle, String str, boolean z) {
        PdfAnnotation M0 = pdfWriter.M0(rectangle, PdfName.Zc);
        if (str != null) {
            M0.V0(PdfName.N5, new PdfString(str, PdfObject.h3));
        }
        if (z) {
            M0.V0(PdfName.bc, PdfBoolean.j3);
        }
        return M0;
    }

    public static PdfAnnotation G1(PdfWriter pdfWriter, Rectangle rectangle, String str, PdfFileSpecification pdfFileSpecification, String str2, boolean z) throws IOException {
        PdfAnnotation M0 = pdfWriter.M0(rectangle, PdfName.Ge);
        M0.V0(PdfName.F7, new PdfNumber(4));
        M0.V0(PdfName.Kg, PdfName.P3);
        M0.D2();
        PdfIndirectReference a2 = pdfWriter.v0(PdfAction.L1(str, pdfFileSpecification, str2, M0.L1())).a();
        if (z) {
            PdfDictionary pdfDictionary = new PdfDictionary();
            pdfDictionary.V0(new PdfName("PV"), a2);
            M0.V0(PdfName.m3, pdfDictionary);
        }
        M0.V0(PdfName.k3, a2);
        return M0;
    }

    public static PdfAnnotation I1(PdfWriter pdfWriter, Rectangle rectangle, String str, boolean z) {
        PdfAnnotation M0 = pdfWriter.M0(rectangle, z ? PdfName.ff : PdfName.n5);
        M0.V0(PdfName.N5, new PdfString(str, PdfObject.h3));
        return M0;
    }

    public static PdfAnnotation J1(PdfWriter pdfWriter, Rectangle rectangle, String str, String str2) {
        PdfAnnotation M0 = pdfWriter.M0(rectangle, PdfName.jf);
        M0.V0(PdfName.N5, new PdfString(str, PdfObject.h3));
        M0.V0(PdfName.qb, new PdfName(str2));
        return M0;
    }

    public static PdfAnnotation K1(PdfWriter pdfWriter, Rectangle rectangle, String str, String str2, boolean z, String str3) {
        PdfAnnotation M0 = pdfWriter.M0(rectangle, PdfName.Qf);
        if (str != null) {
            M0.V0(PdfName.If, new PdfString(str, PdfObject.h3));
        }
        if (str2 != null) {
            M0.V0(PdfName.N5, new PdfString(str2, PdfObject.h3));
        }
        if (z) {
            M0.V0(PdfName.bc, PdfBoolean.j3);
        }
        if (str3 != null) {
            M0.V0(PdfName.qb, new PdfName(str3));
        }
        return M0;
    }

    public static PdfArray N1(BaseColor baseColor) {
        PdfNumber pdfNumber;
        PdfArray pdfArray = new PdfArray();
        int k2 = ExtendedColor.k(baseColor);
        if (k2 == 1) {
            pdfNumber = new PdfNumber(((GrayColor) baseColor).m());
        } else if (k2 == 2) {
            CMYKColor cMYKColor = (CMYKColor) baseColor;
            pdfArray.a0(new PdfNumber(cMYKColor.n()));
            pdfArray.a0(new PdfNumber(cMYKColor.o()));
            pdfArray.a0(new PdfNumber(cMYKColor.p()));
            pdfNumber = new PdfNumber(cMYKColor.m());
        } else if (k2 == 3 || k2 == 4 || k2 == 5) {
            throw new RuntimeException(MessageLocalization.b("separations.patterns.and.shadings.are.not.allowed.in.mk.dictionary", new Object[0]));
        } else {
            pdfArray.a0(new PdfNumber(((float) baseColor.g()) / 255.0f));
            pdfArray.a0(new PdfNumber(((float) baseColor.e()) / 255.0f));
            pdfNumber = new PdfNumber(((float) baseColor.d()) / 255.0f);
        }
        pdfArray.a0(pdfNumber);
        return pdfArray;
    }

    public static PdfAnnotation i1(PdfWriter pdfWriter, Rectangle rectangle, String str, PdfFileSpecification pdfFileSpecification) throws IOException {
        PdfAnnotation M0 = pdfWriter.M0(rectangle, PdfName.R7);
        if (str != null) {
            M0.V0(PdfName.N5, new PdfString(str, PdfObject.h3));
        }
        M0.V0(PdfName.B8, pdfFileSpecification.v1());
        return M0;
    }

    public static PdfAnnotation m1(PdfWriter pdfWriter, Rectangle rectangle, String str, byte[] bArr, String str2, String str3) throws IOException {
        return i1(pdfWriter, rectangle, str, PdfFileSpecification.m1(pdfWriter, str2, str3, bArr));
    }

    public static PdfAnnotation n1(PdfWriter pdfWriter, Rectangle rectangle, String str, PdfContentByte pdfContentByte) {
        PdfAnnotation M0 = pdfWriter.M0(rectangle, PdfName.z8);
        M0.V0(PdfName.N5, new PdfString(str, PdfObject.h3));
        M0.m2(pdfContentByte);
        return M0;
    }

    public static PdfAnnotation o1(PdfWriter pdfWriter, Rectangle rectangle, String str, float[][] fArr) {
        PdfAnnotation M0 = pdfWriter.M0(rectangle, PdfName.P9);
        M0.V0(PdfName.N5, new PdfString(str, PdfObject.h3));
        PdfArray pdfArray = new PdfArray();
        for (float[] fArr2 : fArr) {
            PdfArray pdfArray2 = new PdfArray();
            for (float pdfNumber : fArr2) {
                pdfArray2.a0(new PdfNumber(pdfNumber));
            }
            pdfArray.a0(pdfArray2);
        }
        M0.V0(PdfName.Q9, pdfArray);
        return M0;
    }

    public static PdfAnnotation p1(PdfWriter pdfWriter, Rectangle rectangle, String str, float f2, float f3, float f4, float f5) {
        PdfAnnotation M0 = pdfWriter.M0(rectangle, PdfName.za);
        M0.V0(PdfName.N5, new PdfString(str, PdfObject.h3));
        PdfArray pdfArray = new PdfArray((PdfObject) new PdfNumber(f2));
        pdfArray.a0(new PdfNumber(f3));
        pdfArray.a0(new PdfNumber(f4));
        pdfArray.a0(new PdfNumber(f5));
        M0.V0(PdfName.ja, pdfArray);
        return M0;
    }

    protected static PdfAnnotation q1(PdfWriter pdfWriter, Rectangle rectangle, PdfName pdfName) {
        PdfAnnotation M0 = pdfWriter.M0(rectangle, PdfName.Ca);
        if (!pdfName.equals(A3)) {
            M0.V0(PdfName.W8, pdfName);
        }
        return M0;
    }

    public static PdfAnnotation s1(PdfWriter pdfWriter, Rectangle rectangle, PdfName pdfName, int i2, PdfDestination pdfDestination) {
        PdfAnnotation q1 = q1(pdfWriter, rectangle, pdfName);
        PdfIndirectReference A1 = pdfWriter.A1(i2);
        PdfDestination pdfDestination2 = new PdfDestination(pdfDestination);
        pdfDestination2.X0(A1);
        q1.V0(PdfName.x6, pdfDestination2);
        return q1;
    }

    public static PdfAnnotation v1(PdfWriter pdfWriter, Rectangle rectangle, PdfName pdfName, PdfAction pdfAction) {
        PdfAnnotation q1 = q1(pdfWriter, rectangle, pdfName);
        q1.Z0(PdfName.k3, pdfAction);
        return q1;
    }

    public static PdfAnnotation w1(PdfWriter pdfWriter, Rectangle rectangle, PdfName pdfName, String str) {
        PdfAnnotation q1 = q1(pdfWriter, rectangle, pdfName);
        q1.V0(PdfName.x6, new PdfString(str, PdfObject.h3));
        return q1;
    }

    public static PdfAnnotation x1(PdfWriter pdfWriter, Rectangle rectangle, String str, int i2, float[] fArr) {
        PdfName pdfName = PdfName.t9;
        if (i2 == 1) {
            pdfName = PdfName.Sg;
        } else if (i2 == 2) {
            pdfName = PdfName.tf;
        } else if (i2 == 3) {
            pdfName = PdfName.gf;
        }
        PdfAnnotation M0 = pdfWriter.M0(rectangle, pdfName);
        M0.V0(PdfName.N5, new PdfString(str, PdfObject.h3));
        PdfArray pdfArray = new PdfArray();
        for (float pdfNumber : fArr) {
            pdfArray.a0(new PdfNumber(pdfNumber));
        }
        M0.V0(PdfName.Bd, pdfArray);
        return M0;
    }

    public void A2(int i2) {
        M1().V0(PdfName.Dd, new PdfNumber(i2));
    }

    public void B2(int i2) {
        M1().V0(PdfName.qg, new PdfNumber(i2));
    }

    public void C2(String str) {
        V0(PdfName.Cb, new PdfString(str));
    }

    public void D(AccessibleElementId accessibleElementId) {
        this.y3 = accessibleElementId;
    }

    public void D2() {
        V0(PdfName.tc, this.p3.d1());
    }

    public void E2(int i2) {
        V0(PdfName.tc, this.p3.A1(i2));
    }

    public void F2(int i2) {
        this.v3 = i2;
    }

    public void G2(PdfAnnotation pdfAnnotation) {
        V0(PdfName.Zc, pdfAnnotation.L1());
        pdfAnnotation.V0(PdfName.Dc, L1());
    }

    public void H2(int i2) {
        V0(PdfName.te, new PdfNumber(i2));
    }

    public void I2(String str) {
        if (str == null) {
            a1(PdfName.If);
        } else {
            V0(PdfName.If, new PdfString(str, PdfObject.h3));
        }
    }

    public void K2() {
        this.u3 = true;
    }

    public PdfName L() {
        return this.w3;
    }

    public PdfIndirectReference L1() {
        if (this.q3 == null) {
            this.q3 = this.p3.D1();
        }
        return this.q3;
    }

    /* access modifiers changed from: package-private */
    public PdfDictionary M1() {
        PdfName pdfName = PdfName.gb;
        PdfDictionary pdfDictionary = (PdfDictionary) d0(pdfName);
        if (pdfDictionary != null) {
            return pdfDictionary;
        }
        PdfDictionary pdfDictionary2 = new PdfDictionary();
        V0(pdfName, pdfDictionary2);
        return pdfDictionary2;
    }

    public int P1() {
        return this.v3;
    }

    public HashSet<PdfTemplate> Q1() {
        return this.r3;
    }

    public void T(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        PdfWriter.G0(pdfWriter, 13, this);
        super.T(pdfWriter, outputStream);
    }

    public void U(PdfName pdfName, PdfObject pdfObject) {
        if (this.x3 == null) {
            this.x3 = new HashMap<>();
        }
        this.x3.put(pdfName, pdfObject);
    }

    public boolean V1() {
        return this.t3;
    }

    public boolean W1() {
        return this.s3;
    }

    public boolean X1() {
        return this.u3;
    }

    public void Y1(PdfAction pdfAction) {
        V0(PdfName.k3, pdfAction);
    }

    public void Z1(PdfName pdfName, PdfAction pdfAction) {
        PdfName pdfName2 = PdfName.m3;
        PdfObject d0 = d0(pdfName2);
        PdfDictionary pdfDictionary = (d0 == null || !d0.z()) ? new PdfDictionary() : (PdfDictionary) d0;
        pdfDictionary.V0(pdfName, pdfAction);
        V0(pdfName2, pdfDictionary);
    }

    public void c2(PdfName pdfName, PdfTemplate pdfTemplate) {
        PdfName pdfName2 = PdfName.S3;
        PdfDictionary pdfDictionary = (PdfDictionary) d0(pdfName2);
        if (pdfDictionary == null) {
            pdfDictionary = new PdfDictionary();
        }
        pdfDictionary.V0(pdfName, pdfTemplate.J3());
        V0(pdfName2, pdfDictionary);
        if (this.s3) {
            if (this.r3 == null) {
                this.r3 = new HashSet<>();
            }
            this.r3.add(pdfTemplate);
        }
    }

    public void f1(AffineTransform affineTransform) {
        PdfName pdfName = PdfName.Nd;
        PdfArray e0 = e0(pdfName);
        if (e0 != null) {
            V0(pdfName, (e0.size() == 4 ? new PdfRectangle(e0.J0(0).a0(), e0.J0(1).a0(), e0.J0(2).a0(), e0.J0(3).a0()) : new PdfRectangle(e0.J0(0).a0(), e0.J0(1).a0())).v1(affineTransform));
        }
    }

    public AccessibleElementId getId() {
        if (this.y3 == null) {
            this.y3 = new AccessibleElementId();
        }
        return this.y3;
    }

    public void h2(PdfName pdfName, String str, PdfTemplate pdfTemplate) {
        PdfName pdfName2 = PdfName.S3;
        PdfDictionary pdfDictionary = (PdfDictionary) d0(pdfName2);
        if (pdfDictionary == null) {
            pdfDictionary = new PdfDictionary();
        }
        PdfObject d0 = pdfDictionary.d0(pdfName);
        PdfDictionary pdfDictionary2 = (d0 == null || !d0.z()) ? new PdfDictionary() : (PdfDictionary) d0;
        pdfDictionary2.V0(new PdfName(str), pdfTemplate.J3());
        pdfDictionary.V0(pdfName, pdfDictionary2);
        V0(pdfName2, pdfDictionary);
        if (this.s3) {
            if (this.r3 == null) {
                this.r3 = new HashSet<>();
            }
            this.r3.add(pdfTemplate);
        }
    }

    public void i2(String str) {
        if (str == null) {
            a1(PdfName.Z3);
        } else {
            V0(PdfName.Z3, new PdfName(str));
        }
    }

    public void j2(PdfBorderArray pdfBorderArray) {
        V0(PdfName.D4, pdfBorderArray);
    }

    public HashMap<PdfName, PdfObject> k0() {
        return this.x3;
    }

    public void k2(PdfBorderDictionary pdfBorderDictionary) {
        V0(PdfName.H4, pdfBorderDictionary);
    }

    public void l2(BaseColor baseColor) {
        V0(PdfName.K4, new PdfColor(baseColor));
    }

    public void m2(PdfContentByte pdfContentByte) {
        byte[] F = pdfContentByte.a1().F();
        int length = F.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (F[i2] == 10) {
                F[i2] = 32;
            }
        }
        V0(PdfName.g6, new PdfString(F));
    }

    public boolean n() {
        return false;
    }

    public void n2(int i2) {
        if (i2 == 0) {
            a1(PdfName.F7);
        } else {
            V0(PdfName.F7, new PdfNumber(i2));
        }
    }

    public void o(PdfName pdfName) {
        this.w3 = pdfName;
    }

    public void o2(PdfName pdfName) {
        if (pdfName.equals(A3)) {
            a1(PdfName.W8);
        } else {
            V0(PdfName.W8, pdfName);
        }
    }

    public void p2(PdfOCG pdfOCG) {
        V0(PdfName.Pb, pdfOCG.g());
    }

    public void q2(String str) {
        M1().V0(PdfName.o3, new PdfString(str, PdfObject.h3));
    }

    public PdfObject r(PdfName pdfName) {
        HashMap<PdfName, PdfObject> hashMap = this.x3;
        if (hashMap != null) {
            return hashMap.get(pdfName);
        }
        return null;
    }

    public void r2(PdfTemplate pdfTemplate) {
        M1().V0(PdfName.Z9, pdfTemplate.J3());
    }

    public void s2(BaseColor baseColor) {
        if (baseColor == null) {
            M1().a1(PdfName.p4);
        } else {
            M1().V0(PdfName.p4, N1(baseColor));
        }
    }

    public void t2(BaseColor baseColor) {
        if (baseColor == null) {
            M1().a1(PdfName.o4);
        } else {
            M1().V0(PdfName.o4, N1(baseColor));
        }
    }

    public void u2(PdfName pdfName, PdfName pdfName2, float f2, float f3, boolean z) {
        PdfDictionary pdfDictionary = new PdfDictionary();
        PdfName pdfName3 = PdfName.k3;
        if (!pdfName.equals(pdfName3)) {
            pdfDictionary.V0(PdfName.Gf, pdfName);
        }
        if (!pdfName2.equals(PdfName.tc)) {
            pdfDictionary.V0(PdfName.Ce, pdfName2);
        }
        if (!(f2 == 0.5f && f3 == 0.5f)) {
            PdfArray pdfArray = new PdfArray((PdfObject) new PdfNumber(f2));
            pdfArray.a0(new PdfNumber(f3));
            pdfDictionary.V0(pdfName3, pdfArray);
        }
        if (z) {
            pdfDictionary.V0(PdfName.H7, PdfBoolean.j3);
        }
        M1().V0(PdfName.D9, pdfDictionary);
    }

    public void v2(String str) {
        M1().V0(PdfName.N4, new PdfString(str, PdfObject.h3));
    }

    public void x2(PdfTemplate pdfTemplate) {
        M1().V0(PdfName.x9, pdfTemplate.J3());
    }

    public void y2(String str) {
        M1().V0(PdfName.Jd, new PdfString(str, PdfObject.h3));
    }

    public void z2(PdfTemplate pdfTemplate) {
        M1().V0(PdfName.Zd, pdfTemplate.J3());
    }

    public PdfAnnotation(PdfWriter pdfWriter, float f2, float f3, float f4, float f5, PdfString pdfString, PdfString pdfString2) {
        this.p3 = pdfWriter;
        V0(PdfName.Cf, PdfName.Qf);
        V0(PdfName.If, pdfString);
        V0(PdfName.Nd, new PdfRectangle(f2, f3, f4, f5));
        V0(PdfName.N5, pdfString2);
    }

    public PdfAnnotation(PdfWriter pdfWriter, Rectangle rectangle) {
        this.p3 = pdfWriter;
        if (rectangle != null) {
            V0(PdfName.Nd, new PdfRectangle(rectangle));
        }
    }
}
