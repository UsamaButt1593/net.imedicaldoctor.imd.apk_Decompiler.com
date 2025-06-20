package com.itextpdf.text.pdf;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.ts.PsExtractor;
import com.itextpdf.awt.geom.AffineTransform;
import com.itextpdf.text.AccessibleElementId;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.IllegalPdfSyntaxException;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import com.itextpdf.tool.xml.html.HTML;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

public class PdfContentByte {
    public static final int f3 = 1;
    public static final int g3 = 0;
    public static final int h3 = 2;
    public static final int i3 = 0;
    public static final int j3 = 1;
    public static final int k3 = 2;
    public static final int l3 = 0;
    public static final int m3 = 1;
    public static final int n3 = 2;
    public static final int o3 = 0;
    public static final int p3 = 1;
    public static final int q3 = 2;
    public static final int r3 = 3;
    public static final int s3 = 4;
    public static final int t3 = 5;
    public static final int u3 = 6;
    public static final int v3 = 7;
    private static final float[] w3 = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    private static HashMap<PdfName, String> x3;
    protected int X = 0;
    protected GraphicState X2 = new GraphicState();
    protected PdfWriter Y;
    protected ArrayList<GraphicState> Y2 = new ArrayList<>();
    protected PdfDocument Z;
    protected ArrayList<Integer> Z2;
    protected int a3 = 10;
    private int b3 = 0;
    private boolean c3 = false;
    private ArrayList<IAccessibleElement> d3 = new ArrayList<>();
    protected PdfContentByte e3 = null;
    protected ByteBuffer s = new ByteBuffer();

    public static class GraphicState {

        /* renamed from: a  reason: collision with root package name */
        FontDetails f26146a;

        /* renamed from: b  reason: collision with root package name */
        ColorDetails f26147b;

        /* renamed from: c  reason: collision with root package name */
        float f26148c;

        /* renamed from: d  reason: collision with root package name */
        protected float f26149d = 0.0f;

        /* renamed from: e  reason: collision with root package name */
        protected float f26150e = 0.0f;

        /* renamed from: f  reason: collision with root package name */
        protected float f26151f = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        protected float f26152g = 0.0f;

        /* renamed from: h  reason: collision with root package name */
        protected float f26153h = 0.0f;

        /* renamed from: i  reason: collision with root package name */
        protected float f26154i = 1.0f;

        /* renamed from: j  reason: collision with root package name */
        protected float f26155j = 0.0f;

        /* renamed from: k  reason: collision with root package name */
        protected float f26156k = 0.0f;

        /* renamed from: l  reason: collision with root package name */
        protected float f26157l = 100.0f;

        /* renamed from: m  reason: collision with root package name */
        protected float f26158m = 0.0f;

        /* renamed from: n  reason: collision with root package name */
        protected float f26159n = 0.0f;
        protected BaseColor o = new GrayColor(0);
        protected BaseColor p = new GrayColor(0);
        protected int q = 0;
        protected AffineTransform r = new AffineTransform();
        protected PdfObject s = null;

        GraphicState() {
        }

        /* access modifiers changed from: package-private */
        public void a(GraphicState graphicState) {
            this.f26146a = graphicState.f26146a;
            this.f26147b = graphicState.f26147b;
            this.f26148c = graphicState.f26148c;
            this.f26149d = graphicState.f26149d;
            this.f26150e = graphicState.f26150e;
            this.f26151f = graphicState.f26151f;
            this.f26152g = graphicState.f26152g;
            this.f26153h = graphicState.f26153h;
            this.f26154i = graphicState.f26154i;
            this.f26155j = graphicState.f26155j;
            this.f26156k = graphicState.f26156k;
            this.f26157l = graphicState.f26157l;
            this.f26158m = graphicState.f26158m;
            this.f26159n = graphicState.f26159n;
            this.o = graphicState.o;
            this.p = graphicState.p;
            this.r = new AffineTransform(graphicState.r);
            this.q = graphicState.q;
            this.s = graphicState.s;
        }

        /* access modifiers changed from: package-private */
        public void b(GraphicState graphicState) {
            a(graphicState);
        }

        GraphicState(GraphicState graphicState) {
            a(graphicState);
        }
    }

    static class UncoloredPattern extends PatternColor {
        protected BaseColor B;
        protected float C;

        protected UncoloredPattern(PdfPatternPainter pdfPatternPainter, BaseColor baseColor, float f2) {
            super(pdfPatternPainter);
            this.B = baseColor;
            this.C = f2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof UncoloredPattern) {
                UncoloredPattern uncoloredPattern = (UncoloredPattern) obj;
                return uncoloredPattern.z.equals(this.z) && uncoloredPattern.B.equals(this.B) && uncoloredPattern.C == this.C;
            }
        }
    }

    static {
        HashMap<PdfName, String> hashMap = new HashMap<>();
        x3 = hashMap;
        hashMap.put(PdfName.u4, "/BPC ");
        x3.put(PdfName.w5, "/CS ");
        x3.put(PdfName.n6, "/D ");
        x3.put(PdfName.o6, "/DP ");
        x3.put(PdfName.T7, "/F ");
        x3.put(PdfName.h9, "/H ");
        x3.put(PdfName.J9, "/IM ");
        x3.put(PdfName.T9, "/Intent ");
        x3.put(PdfName.U9, "/I ");
        x3.put(PdfName.Jh, "/W ");
    }

    public PdfContentByte(PdfWriter pdfWriter) {
        if (pdfWriter != null) {
            this.Y = pdfWriter;
            this.Z = pdfWriter.C1();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00aa, code lost:
        if (r0 != false) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00dc, code lost:
        if (r0 == false) goto L_0x00e1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.itextpdf.text.pdf.PdfStructureElement C1(com.itextpdf.text.pdf.interfaces.IAccessibleElement r8) {
        /*
            r7 = this;
            boolean r0 = r7.o1()
            r1 = 0
            if (r0 == 0) goto L_0x00e2
            java.util.ArrayList r0 = r7.e1()
            int r0 = r0.size()
            r2 = 1
            if (r0 <= 0) goto L_0x0026
            java.util.ArrayList r0 = r7.e1()
            java.util.ArrayList r3 = r7.e1()
            int r3 = r3.size()
            int r3 = r3 - r2
            java.lang.Object r0 = r0.get(r3)
            com.itextpdf.text.pdf.interfaces.IAccessibleElement r0 = (com.itextpdf.text.pdf.interfaces.IAccessibleElement) r0
            goto L_0x0027
        L_0x0026:
            r0 = r1
        L_0x0027:
            com.itextpdf.text.pdf.PdfWriter r3 = r7.Y
            r3.E0(r8, r0)
            com.itextpdf.text.pdf.PdfName r0 = r8.L()
            if (r0 == 0) goto L_0x00e2
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.X3
            com.itextpdf.text.pdf.PdfName r3 = r8.L()
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L_0x005c
            com.itextpdf.text.pdf.PdfDocument r3 = r7.Z
            com.itextpdf.text.AccessibleElementId r4 = r8.getId()
            com.itextpdf.text.pdf.PdfStructureElement r3 = r3.H0(r4)
            if (r3 != 0) goto L_0x005d
            com.itextpdf.text.pdf.PdfStructureElement r3 = new com.itextpdf.text.pdf.PdfStructureElement
            com.itextpdf.text.pdf.PdfDictionary r4 = r7.g1()
            com.itextpdf.text.pdf.PdfName r5 = r8.L()
            com.itextpdf.text.AccessibleElementId r6 = r8.getId()
            r3.<init>(r4, r5, r6)
            goto L_0x005d
        L_0x005c:
            r3 = r1
        L_0x005d:
            com.itextpdf.text.pdf.PdfName r4 = r8.L()
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x00ad
            java.util.HashMap r0 = r8.k0()
            if (r0 == 0) goto L_0x009c
            boolean r4 = r0.isEmpty()
            if (r4 != 0) goto L_0x009c
            com.itextpdf.text.pdf.PdfDictionary r1 = new com.itextpdf.text.pdf.PdfDictionary
            r1.<init>()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0080:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x009c
            java.lang.Object r4 = r0.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            com.itextpdf.text.pdf.PdfName r5 = (com.itextpdf.text.pdf.PdfName) r5
            java.lang.Object r4 = r4.getValue()
            com.itextpdf.text.pdf.PdfObject r4 = (com.itextpdf.text.pdf.PdfObject) r4
            r1.V0(r5, r4)
            goto L_0x0080
        L_0x009c:
            boolean r0 = r7.c3
            if (r0 == 0) goto L_0x00a3
            r7.L0()
        L_0x00a3:
            com.itextpdf.text.pdf.PdfName r8 = r8.L()
            r7.O(r8, r1, r2)
            if (r0 == 0) goto L_0x00e1
            goto L_0x00de
        L_0x00ad:
            com.itextpdf.text.pdf.PdfWriter r0 = r7.Y
            boolean r0 = r0.a2(r8)
            if (r0 == 0) goto L_0x00e1
            boolean r0 = r7.c3
            if (r0 == 0) goto L_0x00bc
            r7.L0()
        L_0x00bc:
            java.util.HashMap r4 = r8.k0()
            if (r4 == 0) goto L_0x00d9
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.c7
            com.itextpdf.text.pdf.PdfObject r5 = r8.r(r4)
            if (r5 == 0) goto L_0x00d9
            com.itextpdf.text.pdf.PdfObject r5 = r8.r(r4)
            java.lang.String r5 = r5.toString()
            r7.Q(r3, r5)
            r8.U(r4, r1)
            goto L_0x00dc
        L_0x00d9:
            r7.P(r3)
        L_0x00dc:
            if (r0 == 0) goto L_0x00e1
        L_0x00de:
            r7.S(r2)
        L_0x00e1:
            r1 = r3
        L_0x00e2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfContentByte.C1(com.itextpdf.text.pdf.interfaces.IAccessibleElement):com.itextpdf.text.pdf.PdfStructureElement");
    }

    private void M(PdfOCG pdfOCG) {
        this.s.k("/OC ").n(f1().h((PdfName) this.Y.s0(pdfOCG, pdfOCG.g())[0], pdfOCG.g()).k()).k(" BDC").r(this.a3);
    }

    private void M0() {
        PdfDocument pdfDocument = this.Z;
        if (pdfDocument.u3) {
            pdfDocument.u3 = false;
            this.Y.h1().B1(this.Z);
        }
    }

    private void Q(PdfStructureElement pdfStructureElement, String str) {
        PdfArray pdfArray;
        PdfName pdfName = PdfName.ga;
        PdfObject d0 = pdfStructureElement.d0(pdfName);
        int[] L0 = this.Z.L0(T0());
        int i2 = L0[0];
        int i4 = L0[1];
        if (d0 != null) {
            if (d0.I()) {
                pdfArray = new PdfArray();
                pdfArray.a0(d0);
                pdfStructureElement.V0(pdfName, pdfArray);
            } else if (d0.q()) {
                pdfArray = (PdfArray) d0;
            } else {
                throw new IllegalArgumentException(MessageLocalization.b("unknown.object.at.k.1", d0.getClass().toString()));
            }
            if (pdfArray.J0(0) != null) {
                PdfDictionary pdfDictionary = new PdfDictionary(PdfName.bb);
                pdfDictionary.V0(PdfName.Rc, T0());
                pdfDictionary.V0(PdfName.ab, new PdfNumber(i4));
                pdfArray.a0(pdfDictionary);
            }
            pdfStructureElement.x1(this.Z.K0(T0()), -1);
        } else {
            pdfStructureElement.x1(i2, i4);
            pdfStructureElement.V0(PdfName.Rc, T0());
        }
        N2(d1() + 1);
        int C = this.s.C();
        this.s.n(pdfStructureElement.d0(PdfName.Ce).k()).k(" <</MCID ").f(i4);
        if (str != null) {
            this.s.k("/E (").k(str).k(")");
        }
        this.s.k(">> BDC").r(this.a3);
        this.X += this.s.C() - C;
    }

    public static ArrayList<double[]> T(double d2, double d4, double d5, double d6, double d7, double d8) {
        double d9;
        double d10;
        double d11;
        double d12;
        double d13;
        int i2;
        int i4 = 1;
        if (d2 > d5) {
            d9 = d2;
            d10 = d5;
        } else {
            d10 = d2;
            d9 = d5;
        }
        if (d6 > d4) {
            d11 = d4;
            d12 = d6;
        } else {
            d12 = d4;
            d11 = d6;
        }
        if (Math.abs(d8) <= 90.0d) {
            d13 = d8;
            i2 = 1;
        } else {
            i2 = (int) Math.ceil(Math.abs(d8) / 90.0d);
            d13 = d8 / ((double) i2);
        }
        double d14 = (d10 + d9) / 2.0d;
        double d15 = (d12 + d11) / 2.0d;
        double d16 = (d9 - d10) / 2.0d;
        double d17 = (d11 - d12) / 2.0d;
        double d18 = 3.141592653589793d;
        double d19 = (d13 * 3.141592653589793d) / 360.0d;
        double abs = Math.abs(((1.0d - Math.cos(d19)) * 1.3333333333333333d) / Math.sin(d19));
        ArrayList<double[]> arrayList = new ArrayList<>();
        int i5 = 0;
        while (i5 < i2) {
            double d20 = ((d7 + (((double) i5) * d13)) * d18) / 180.0d;
            i5 += i4;
            double d21 = ((d7 + (((double) i5) * d13)) * d18) / 180.0d;
            double cos = Math.cos(d20);
            double cos2 = Math.cos(d21);
            double sin = Math.sin(d20);
            double sin2 = Math.sin(d21);
            double d22 = d14 + (d16 * cos);
            if (d13 > 0.0d) {
                arrayList.add(new double[]{d22, d15 - (d17 * sin), d14 + ((cos - (abs * sin)) * d16), d15 - ((sin + (cos * abs)) * d17), d14 + ((cos2 + (abs * sin2)) * d16), d15 - ((sin2 - (abs * cos2)) * d17), d14 + (cos2 * d16), d15 - (sin2 * d17)});
            } else {
                arrayList.add(new double[]{d22, d15 - (d17 * sin), d14 + ((cos + (abs * sin)) * d16), d15 - ((sin - (cos * abs)) * d17), d14 + ((cos2 - (abs * sin2)) * d16), d15 - ((sin2 + (abs * cos2)) * d17), d14 + (cos2 * d16), d15 - (sin2 * d17)});
            }
            i4 = 1;
            d18 = 3.141592653589793d;
        }
        return arrayList;
    }

    public static ArrayList<double[]> V(float f2, float f4, float f5, float f6, float f7, float f8) {
        return T((double) f2, (double) f4, (double) f5, (double) f6, (double) f7, (double) f8);
    }

    private float X0(String str, boolean z, float f2) {
        BaseFont e2 = this.X2.f26146a.e();
        float a0 = z ? e2.a0(str, this.X2.f26148c) : e2.Z(str, this.X2.f26148c);
        if (this.X2.f26158m != 0.0f && str.length() > 0) {
            a0 += this.X2.f26158m * ((float) str.length());
        }
        if (this.X2.f26159n != 0.0f && !e2.i0()) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (str.charAt(i2) == ' ') {
                    a0 += this.X2.f26159n;
                }
            }
        }
        GraphicState graphicState = this.X2;
        float f4 = a0 - ((f2 / 1000.0f) * graphicState.f26148c);
        float f5 = graphicState.f26157l;
        return ((double) f5) != 100.0d ? (f4 * f5) / 100.0f : f4;
    }

    private void Y1(BaseColor baseColor, boolean z) {
        if (z) {
            this.X2.o = baseColor;
        } else {
            this.X2.p = baseColor;
        }
    }

    private void a(float f2, float f4, float f5, float f6) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f4 < 0.0f) {
            f4 = 0.0f;
        } else if (f4 > 1.0f) {
            f4 = 1.0f;
        }
        if (f5 < 0.0f) {
            f5 = 0.0f;
        } else if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        if (f6 < 0.0f) {
            f6 = 0.0f;
        } else if (f6 > 1.0f) {
            f6 = 1.0f;
        }
        this.s.e(f2).c(' ').e(f4).c(' ').e(f5).c(' ').e(f6);
    }

    private void b(float f2, float f4, float f5) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f4 < 0.0f) {
            f4 = 0.0f;
        } else if (f4 > 1.0f) {
            f4 = 1.0f;
        }
        if (f5 < 0.0f) {
            f5 = 0.0f;
        } else if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        this.s.e(f2).c(' ').e(f4).c(' ').e(f5);
    }

    public static PdfTextArray b1(String str, BaseFont baseFont) {
        PdfTextArray pdfTextArray = new PdfTextArray();
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length() - 1;
        char[] charArray = str.toCharArray();
        if (length >= 0) {
            stringBuffer.append(charArray, 0, 1);
        }
        int i2 = 0;
        while (i2 < length) {
            int i4 = i2 + 1;
            char c2 = charArray[i4];
            int O = baseFont.O(charArray[i2], c2);
            if (O == 0) {
                stringBuffer.append(c2);
            } else {
                pdfTextArray.c(stringBuffer.toString());
                stringBuffer.setLength(0);
                stringBuffer.append(charArray, i4, 1);
                pdfTextArray.a((float) (-O));
            }
            i2 = i4;
        }
        pdfTextArray.c(stringBuffer.toString());
        return pdfTextArray;
    }

    private void d0(IAccessibleElement iAccessibleElement) {
        if (o1() && iAccessibleElement.L() != null) {
            PdfStructureElement H0 = this.Z.H0(iAccessibleElement.getId());
            if (H0 != null) {
                H0.k2(iAccessibleElement);
            }
            if (this.Y.a2(iAccessibleElement)) {
                boolean z = this.c3;
                if (z) {
                    L0();
                }
                K0();
                if (z) {
                    S(true);
                }
            }
        }
    }

    private PdfDictionary g1() {
        PdfStructureElement H0 = e1().size() > 0 ? this.Z.H0(e1().get(e1().size() - 1).getId()) : null;
        return H0 == null ? this.Y.L1() : H0;
    }

    private boolean i0(BaseColor baseColor, BaseColor baseColor2) {
        if (baseColor == null && baseColor2 == null) {
            return true;
        }
        if (baseColor == null || baseColor2 == null) {
            return false;
        }
        return baseColor instanceof ExtendedColor ? baseColor.equals(baseColor2) : baseColor2.equals(baseColor);
    }

    private void n3(String str) {
        FontDetails fontDetails = this.X2.f26146a;
        if (fontDetails != null) {
            StringUtils.b(fontDetails.b(str), this.s);
            return;
        }
        throw new NullPointerException(MessageLocalization.b("font.and.size.must.be.set.before.writing.any.text", new Object[0]));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void p3(int r16, java.lang.String r17, float r18, float r19, float r20, boolean r21) {
        /*
            r15 = this;
            r7 = r15
            r0 = r16
            r8 = r17
            r1 = r19
            r2 = r20
            r9 = r21
            com.itextpdf.text.pdf.PdfContentByte$GraphicState r3 = r7.X2
            com.itextpdf.text.pdf.FontDetails r3 = r3.f26146a
            if (r3 == 0) goto L_0x0085
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = 2
            r5 = 1
            r10 = 0
            int r6 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r6 != 0) goto L_0x003b
            if (r0 == r5) goto L_0x0028
            if (r0 == r4) goto L_0x0021
            r0 = r18
            goto L_0x002e
        L_0x0021:
            float r0 = r15.W0(r8, r9)
        L_0x0025:
            float r0 = r18 - r0
            goto L_0x002e
        L_0x0028:
            float r0 = r15.W0(r8, r9)
            float r0 = r0 / r3
            goto L_0x0025
        L_0x002e:
            r15.e3(r0, r1)
            if (r9 == 0) goto L_0x0037
            r15.s3(r8)
            goto L_0x0084
        L_0x0037:
            r15.m3(r8)
            goto L_0x0084
        L_0x003b:
            double r11 = (double) r2
            r13 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r11 = r11 * r13
            r13 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r11 = r11 / r13
            double r13 = java.lang.Math.cos(r11)
            float r6 = (float) r13
            double r11 = java.lang.Math.sin(r11)
            float r2 = (float) r11
            if (r0 == r5) goto L_0x006a
            if (r0 == r4) goto L_0x005b
            r5 = r18
            r11 = r1
            goto L_0x0070
        L_0x005b:
            float r0 = r15.W0(r8, r9)
        L_0x005f:
            float r3 = r0 * r6
            float r3 = r18 - r3
            float r0 = r0 * r2
            float r0 = r1 - r0
            r11 = r0
            r5 = r3
            goto L_0x0070
        L_0x006a:
            float r0 = r15.W0(r8, r9)
            float r0 = r0 / r3
            goto L_0x005f
        L_0x0070:
            float r3 = -r2
            r0 = r15
            r1 = r6
            r4 = r6
            r6 = r11
            r0.f3(r1, r2, r3, r4, r5, r6)
            if (r9 == 0) goto L_0x007e
            r15.s3(r8)
            goto L_0x0081
        L_0x007e:
            r15.m3(r8)
        L_0x0081:
            r15.e3(r10, r10)
        L_0x0084:
            return
        L_0x0085:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "font.and.size.must.be.set.before.writing.any.text"
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.b(r2, r1)
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfContentByte.p3(int, java.lang.String, float, float, float, boolean):void");
    }

    private void x(PdfTemplate pdfTemplate, double d2, double d4, double d5, double d6, double d7, double d8, boolean z, boolean z2) {
        PdfTemplate pdfTemplate2 = pdfTemplate;
        Y();
        W(pdfTemplate);
        PdfWriter.G0(this.Y, 20, pdfTemplate);
        PdfName j2 = f1().j(this.Y.X(pdfTemplate, (PdfName) null), pdfTemplate.J3());
        if (o1() && z) {
            if (this.c3) {
                L0();
            }
            if (pdfTemplate.Q3() || (pdfTemplate.M3() != null && z2)) {
                throw new RuntimeException(MessageLocalization.b("template.with.tagged.could.not.be.used.more.than.once", new Object[0]));
            }
            pdfTemplate.Y3(this.Y.d1());
            if (z2) {
                pdfTemplate.T3(true);
                M0();
                ArrayList<IAccessibleElement> e1 = e1();
                if (e1 != null && e1.size() > 0) {
                    pdfTemplate.e1().add(e1.get(e1.size() - 1));
                }
            } else {
                B1(pdfTemplate);
            }
        }
        this.s.k("q ");
        double d9 = d2;
        this.s.d(d2).c(' ');
        double d10 = d4;
        this.s.d(d4).c(' ');
        double d11 = d5;
        this.s.d(d5).c(' ');
        this.s.d(d6).c(' ');
        this.s.d(d7).c(' ');
        this.s.d(d8).k(" cm ");
        this.s.n(j2.k()).k(" Do Q").r(this.a3);
        if (o1() && z && !z2) {
            c0(pdfTemplate);
            pdfTemplate.D((AccessibleElementId) null);
        }
    }

    public void A(PdfTemplate pdfTemplate, float f2, float f4, float f5, float f6, float f7, float f8) {
        B(pdfTemplate, f2, f4, f5, f6, f7, f8, false);
    }

    public void A0(float f2, float f4, float f5, float f6, float f7, float f8) {
        y0((double) f2, (double) f4, (double) f5, (double) f6, (double) f7, (double) f8);
    }

    public void A1() {
        if (!this.c3 && o1()) {
            S(true);
        }
        if (o1()) {
            GraphicState graphicState = this.X2;
            float f2 = graphicState.f26149d;
            if (f2 != graphicState.f26155j) {
                f3(graphicState.f26151f, graphicState.f26152g, graphicState.f26153h, graphicState.f26154i, f2, graphicState.f26150e);
            }
        }
        GraphicState graphicState2 = this.X2;
        graphicState2.f26150e -= graphicState2.f26156k;
        this.s.k("T*").r(this.a3);
    }

    public void A2(double d2, double d4) {
        this.s.k("[").d(d2).k("] ").d(d4).k(" d").r(this.a3);
    }

    public void B(PdfTemplate pdfTemplate, float f2, float f4, float f5, float f6, float f7, float f8, boolean z) {
        w(pdfTemplate, (double) f2, (double) f4, (double) f5, (double) f6, (double) f7, (double) f8, z);
    }

    public void B0(double d2, double d4, double d5, double d6, String str, BaseFont baseFont, float f2) {
        double d7;
        double d8;
        double d9;
        double d10;
        float f4 = f2;
        if (d2 > d5) {
            d7 = d2;
            d8 = d5;
        } else {
            d8 = d2;
            d7 = d5;
        }
        if (d4 > d6) {
            d9 = d4;
            d10 = d6;
        } else {
            d10 = d4;
            d9 = d6;
        }
        a2();
        l2(new BaseColor(0, 0, 0));
        J2(1.0f);
        y2(0);
        double d11 = d7 - d8;
        double d12 = d9 - d10;
        G1(d8, d10, d11, d12);
        v3();
        J2(1.0f);
        y2(0);
        h2(new BaseColor((int) PsExtractor.x, (int) PsExtractor.x, (int) PsExtractor.x));
        G1(d8 + 0.5d, d10 + 0.5d, d11 - 1.0d, d12 - 1.0d);
        Q0();
        l2(new BaseColor(255, 255, 255));
        J2(1.0f);
        y2(0);
        double d13 = d8 + 1.0d;
        double d14 = d10 + 1.0d;
        v1(d13, d14);
        double d15 = d9 - 1.0d;
        p1(d13, d15);
        double d16 = d7 - 1.0d;
        p1(d16, d15);
        v3();
        l2(new BaseColor(160, 160, 160));
        J2(1.0f);
        y2(0);
        v1(d13, d14);
        p1(d16, d14);
        p1(d16, d15);
        v3();
        R1();
        R();
        float f5 = f2;
        s2(baseFont, f5);
        o3(1, str, (float) (d8 + (d11 / 2.0d)), (float) (d10 + ((d12 - ((double) f5)) / 2.0d)), 0.0f);
        L0();
        U1();
    }

    public void B1(IAccessibleElement iAccessibleElement) {
        if (o1()) {
            M0();
            if (iAccessibleElement != null && !e1().contains(iAccessibleElement)) {
                PdfStructureElement C1 = C1(iAccessibleElement);
                e1().add(iAccessibleElement);
                if (C1 != null) {
                    this.Z.e1(iAccessibleElement.getId(), C1);
                }
            }
        }
    }

    public void B2(double d2, double d4, double d5) {
        this.s.k("[").d(d2).c(' ').d(d4).k("] ").d(d5).k(" d").r(this.a3);
    }

    public void C(PdfTemplate pdfTemplate, float f2, float f4, boolean z) {
        B(pdfTemplate, 1.0f, 0.0f, 0.0f, 1.0f, f2, f4, z);
    }

    public void C0(float f2, float f4, float f5, float f6, String str, BaseFont baseFont, float f7) {
        B0((double) f2, (double) f4, (double) f5, (double) f6, str, baseFont, f7);
    }

    public void C2(float f2) {
        z2((double) f2);
    }

    public void D0(double d2, double d4, double d5, double d6, boolean z) {
        double d7;
        double d8;
        double d9;
        double d10;
        if (d2 > d5) {
            d7 = d2;
            d8 = d5;
        } else {
            d8 = d2;
            d7 = d5;
        }
        if (d4 > d6) {
            d9 = d4;
            d10 = d6;
        } else {
            d10 = d4;
            d9 = d6;
        }
        a2();
        J2(1.0f);
        y2(1);
        l2(new BaseColor((int) PsExtractor.x, (int) PsExtractor.x, (int) PsExtractor.x));
        I(d8 + 1.0d, d10 + 1.0d, d7 - 1.0d, d9 - 1.0d, 0.0d, 360.0d);
        v3();
        J2(1.0f);
        y2(1);
        l2(new BaseColor(160, 160, 160));
        double d11 = d8;
        I(d11 + 0.5d, d10 + 0.5d, d7 - 0.5d, d9 - 0.5d, 45.0d, 180.0d);
        v3();
        J2(1.0f);
        y2(1);
        l2(new BaseColor(0, 0, 0));
        I(d11 + 1.5d, d10 + 1.5d, d7 - 1.5d, d9 - 1.5d, 45.0d, 180.0d);
        v3();
        if (z) {
            J2(1.0f);
            y2(1);
            h2(new BaseColor(0, 0, 0));
            I(d11 + 4.0d, d10 + 4.0d, d7 - 4.0d, d9 - 4.0d, 0.0d, 360.0d);
            Q0();
        }
        U1();
    }

    /* access modifiers changed from: package-private */
    public void D1(BaseColor baseColor, float f2) {
        ByteBuffer byteBuffer;
        float d2;
        PdfWriter.G0(this.Y, 1, baseColor);
        int k2 = ExtendedColor.k(baseColor);
        if (k2 == 0) {
            this.s.e(((float) baseColor.g()) / 255.0f);
            this.s.c(' ');
            this.s.e(((float) baseColor.e()) / 255.0f);
            this.s.c(' ');
            byteBuffer = this.s;
            d2 = ((float) baseColor.d()) / 255.0f;
        } else if (k2 == 1) {
            byteBuffer = this.s;
            d2 = ((GrayColor) baseColor).m();
        } else if (k2 == 2) {
            CMYKColor cMYKColor = (CMYKColor) baseColor;
            this.s.e(cMYKColor.n()).c(' ').e(cMYKColor.o());
            byteBuffer = this.s.c(' ').e(cMYKColor.p()).c(' ');
            d2 = cMYKColor.m();
        } else if (k2 == 3) {
            this.s.e(f2);
            return;
        } else {
            throw new RuntimeException(MessageLocalization.b("invalid.color.type", new Object[0]));
        }
        byteBuffer.e(d2);
    }

    public void D2(float f2, float f4) {
        A2((double) f2, (double) f4);
    }

    public void E(PdfTemplate pdfTemplate, AffineTransform affineTransform) {
        F(pdfTemplate, affineTransform, false);
    }

    public void E0(float f2, float f4, float f5, float f6, boolean z) {
        D0((double) f2, (double) f4, (double) f5, (double) f6, z);
    }

    public void E1(PdfShading pdfShading) {
        this.Y.t0(pdfShading);
        PageResources f1 = f1();
        this.s.n(f1.i(pdfShading.g(), pdfShading.h()).k()).k(" sh").r(this.a3);
        ColorDetails e2 = pdfShading.e();
        if (e2 != null) {
            f1.a(e2.a(), e2.b());
        }
    }

    public void E2(float f2, float f4, float f5) {
        B2((double) f2, (double) f4, (double) f5);
    }

    public void F(PdfTemplate pdfTemplate, AffineTransform affineTransform, boolean z) {
        double[] dArr = new double[6];
        affineTransform.g(dArr);
        w(pdfTemplate, dArr[0], dArr[1], dArr[2], dArr[3], dArr[4], dArr[5], z);
    }

    public void F0(double d2, double d4, double d5, double d6) {
        double d7;
        double d8;
        double d9;
        double d10;
        if (d2 > d5) {
            d7 = d2;
            d8 = d5;
        } else {
            d8 = d2;
            d7 = d5;
        }
        if (d4 > d6) {
            d9 = d4;
            d10 = d6;
        } else {
            d10 = d4;
            d9 = d6;
        }
        a2();
        l2(new BaseColor((int) PsExtractor.x, (int) PsExtractor.x, (int) PsExtractor.x));
        J2(1.0f);
        y2(0);
        double d11 = d7 - d8;
        double d12 = d9 - d10;
        G1(d8, d10, d11, d12);
        v3();
        J2(1.0f);
        y2(0);
        h2(new BaseColor(255, 255, 255));
        G1(d8 + 0.5d, d10 + 0.5d, d11 - 1.0d, d12 - 1.0d);
        Q0();
        l2(new BaseColor((int) PsExtractor.x, (int) PsExtractor.x, (int) PsExtractor.x));
        J2(1.0f);
        y2(0);
        double d13 = d8 + 1.0d;
        double d14 = d10 + 1.5d;
        v1(d13, d14);
        double d15 = d7;
        double d16 = d15 - 1.5d;
        p1(d16, d14);
        double d17 = d9 - 1.0d;
        p1(d16, d17);
        v3();
        l2(new BaseColor(160, 160, 160));
        J2(1.0f);
        y2(0);
        v1(d13, d10 + 1.0d);
        p1(d13, d17);
        p1(d15 - 1.0d, d17);
        v3();
        l2(new BaseColor(0, 0, 0));
        J2(1.0f);
        y2(0);
        double d18 = d8 + 2.0d;
        v1(d18, d10 + 2.0d);
        double d19 = d9 - 2.0d;
        p1(d18, d19);
        p1(d15 - 2.0d, d19);
        v3();
        U1();
    }

    public void F1(PdfShadingPattern pdfShadingPattern) {
        E1(pdfShadingPattern.p1());
    }

    public final void F2(double[] dArr, double d2) {
        this.s.k("[");
        for (int i2 = 0; i2 < dArr.length; i2++) {
            this.s.d(dArr[i2]);
            if (i2 < dArr.length - 1) {
                this.s.c(' ');
            }
        }
        this.s.k("] ").d(d2).k(" d").r(this.a3);
    }

    /* access modifiers changed from: package-private */
    public void G(PdfIndirectReference pdfIndirectReference, PdfName pdfName, double d2, double d4, double d5, double d6, double d7, double d8) {
        if (this.c3 && o1()) {
            L0();
        }
        Y();
        PdfName j2 = f1().j(pdfName, pdfIndirectReference);
        this.s.k("q ");
        this.s.d(d2).c(' ');
        this.s.d(d4).c(' ');
        this.s.d(d5).c(' ');
        this.s.d(d6).c(' ');
        this.s.d(d7).c(' ');
        this.s.d(d8).k(" cm ");
        this.s.n(j2.k()).k(" Do Q").r(this.a3);
    }

    public void G0(float f2, float f4, float f5, float f6) {
        F0((double) f2, (double) f4, (double) f5, (double) f6);
    }

    public void G1(double d2, double d4, double d5, double d6) {
        if (this.c3) {
            if (o1()) {
                L0();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.b("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        this.s.d(d2).c(' ').d(d4).c(' ').d(d5).c(' ').d(d6).k(" re").r(this.a3);
    }

    public final void G2(float[] fArr, float f2) {
        this.s.k("[");
        for (int i2 = 0; i2 < fArr.length; i2++) {
            this.s.e(fArr[i2]);
            if (i2 < fArr.length - 1) {
                this.s.c(' ');
            }
        }
        this.s.k("] ").e(f2).k(" d").r(this.a3);
    }

    /* access modifiers changed from: package-private */
    public void H(PdfIndirectReference pdfIndirectReference, PdfName pdfName, float f2, float f4, float f5, float f6, float f7, float f8) {
        G(pdfIndirectReference, pdfName, (double) f2, (double) f4, (double) f5, (double) f6, (double) f7, (double) f8);
    }

    public void H0(double d2, double d4, double d5, double d6) {
        I(d2, d4, d5, d6, 0.0d, 360.0d);
    }

    public void H1(float f2, float f4, float f5, float f6) {
        G1((double) f2, (double) f4, (double) f5, (double) f6);
    }

    public void H2(int i2) {
        if (i2 >= 0 && i2 <= 2) {
            this.s.f(i2).k(" j").r(this.a3);
        }
    }

    public void I(double d2, double d4, double d5, double d6, double d7, double d8) {
        ArrayList<double[]> T = T(d2, d4, d5, d6, d7, d8);
        if (!T.isEmpty()) {
            double[] dArr = T.get(0);
            v1(dArr[0], dArr[1]);
            for (int i2 = 0; i2 < T.size(); i2++) {
                double[] dArr2 = T.get(i2);
                y0(dArr2[2], dArr2[3], dArr2[4], dArr2[5], dArr2[6], dArr2[7]);
            }
        }
    }

    public void I0(float f2, float f4, float f5, float f6) {
        H0((double) f2, (double) f4, (double) f5, (double) f6);
    }

    public void I1(Rectangle rectangle) {
        float O = rectangle.O();
        float H = rectangle.H();
        float Q = rectangle.Q();
        float T = rectangle.T();
        BaseColor k2 = rectangle.k();
        if (k2 != null) {
            a2();
            h2(k2);
            H1(O, H, Q - O, T - H);
            Q0();
            U1();
        }
        if (rectangle.c0()) {
            if (rectangle.d0()) {
                z3(rectangle);
                return;
            }
            if (rectangle.y() != -1.0f) {
                J2(rectangle.y());
            }
            BaseColor p = rectangle.p();
            if (p != null) {
                l2(p);
            }
            if (rectangle.b0(15)) {
                H1(O, H, Q - O, T - H);
            } else {
                if (rectangle.b0(8)) {
                    w1(Q, H);
                    q1(Q, T);
                }
                if (rectangle.b0(4)) {
                    w1(O, H);
                    q1(O, T);
                }
                if (rectangle.b0(2)) {
                    w1(O, H);
                    q1(Q, H);
                }
                if (rectangle.b0(1)) {
                    w1(O, T);
                    q1(Q, T);
                }
            }
            v3();
            if (p != null) {
                S1();
            }
        }
    }

    public void I2(double d2) {
        this.s.d(d2).k(" w").r(this.a3);
    }

    public void J(float f2, float f4, float f5, float f6, float f7, float f8) {
        I((double) f2, (double) f4, (double) f5, (double) f6, (double) f7, (double) f8);
    }

    public void J0() {
        ArrayList<Integer> arrayList = this.Z2;
        if (arrayList == null || arrayList.isEmpty()) {
            throw new IllegalPdfSyntaxException(MessageLocalization.b("unbalanced.layer.operators", new Object[0]));
        }
        ArrayList<Integer> arrayList2 = this.Z2;
        int intValue = arrayList2.get(arrayList2.size() - 1).intValue();
        ArrayList<Integer> arrayList3 = this.Z2;
        arrayList3.remove(arrayList3.size() - 1);
        while (true) {
            int i2 = intValue - 1;
            if (intValue > 0) {
                this.s.k("EMC").r(this.a3);
                intValue = i2;
            } else {
                return;
            }
        }
    }

    public void J1(String str, int i2, float f2, float f4, float f5, float f6) {
        this.Z.c1(str, i2, f2, f4, f5, f6);
    }

    public void J2(float f2) {
        I2((double) f2);
    }

    public void K(PdfOCG pdfOCG) {
        int i2 = 0;
        if (!(pdfOCG instanceof PdfLayer) || ((PdfLayer) pdfOCG).o1() == null) {
            if (this.Z2 == null) {
                this.Z2 = new ArrayList<>();
            }
            if (pdfOCG instanceof PdfLayerMembership) {
                this.Z2.add(1);
                M(pdfOCG);
                return;
            }
            for (PdfLayer pdfLayer = (PdfLayer) pdfOCG; pdfLayer != null; pdfLayer = pdfLayer.n1()) {
                if (pdfLayer.o1() == null) {
                    M(pdfLayer);
                    i2++;
                }
            }
            this.Z2.add(Integer.valueOf(i2));
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.b("a.title.is.not.a.layer", new Object[0]));
    }

    public void K0() {
        if (d1() != 0) {
            int C = this.s.C();
            N2(d1() - 1);
            this.s.k("EMC").r(this.a3);
            this.X += this.s.C() - C;
            return;
        }
        throw new IllegalPdfSyntaxException(MessageLocalization.b("unbalanced.begin.end.marked.content.operators", new Object[0]));
    }

    public void K1(String str, String str2, float f2, float f4, float f5, float f6) {
        this.Z.d1(str, str2, f2, f4, f5, f6);
    }

    public void K2(char c2) {
        this.s.c(c2);
    }

    public void L0() {
        if (this.c3) {
            this.c3 = false;
            this.s.k("ET").r(this.a3);
        } else if (!o1()) {
            throw new IllegalPdfSyntaxException(MessageLocalization.b("unbalanced.begin.end.text.operators", new Object[0]));
        }
    }

    public void L1() {
        M1(true);
    }

    public void L2(float f2) {
        this.s.e(f2);
    }

    public void M1(boolean z) {
        this.s.x();
        this.X = 0;
        if (z) {
            X1();
        }
        this.X2 = new GraphicState();
        this.Y2 = new ArrayList<>();
    }

    public void M2(String str) {
        this.s.k(str);
    }

    public void N(PdfName pdfName) {
        O(pdfName, (PdfDictionary) null, false);
    }

    public void N0() {
        if (this.c3 && o1()) {
            L0();
        }
        this.s.k("W*").r(this.a3);
    }

    public void N1() {
        Y1(new CMYKColor(0, 0, 0, 1), true);
        this.s.k("0 0 0 1 k").r(this.a3);
    }

    /* access modifiers changed from: protected */
    public void N2(int i2) {
        PdfContentByte pdfContentByte = this.e3;
        if (pdfContentByte != null) {
            pdfContentByte.N2(i2);
        } else {
            this.b3 = i2;
        }
    }

    public void O(PdfName pdfName, PdfDictionary pdfDictionary, boolean z) {
        ByteBuffer byteBuffer;
        String str;
        PdfWriter pdfWriter;
        PdfIndirectReference D1;
        int C = this.s.C();
        if (pdfDictionary == null) {
            byteBuffer = this.s.n(pdfName.k());
            str = " BMC";
        } else {
            this.s.n(pdfName.k()).c(' ');
            if (z) {
                try {
                    pdfDictionary.T(this.Y, this.s);
                } catch (Exception e2) {
                    throw new ExceptionConverter(e2);
                }
            } else {
                if (this.Y.b2(pdfDictionary)) {
                    pdfWriter = this.Y;
                    D1 = null;
                } else {
                    pdfWriter = this.Y;
                    D1 = pdfWriter.D1();
                }
                PdfObject[] s0 = pdfWriter.s0(pdfDictionary, D1);
                this.s.n(f1().h((PdfName) s0[0], (PdfIndirectReference) s0[1]).k());
            }
            byteBuffer = this.s;
            str = " BDC";
        }
        byteBuffer.k(str).r(this.a3);
        N2(d1() + 1);
        this.X += this.s.C() - C;
    }

    public void O0() {
        if (this.c3) {
            if (o1()) {
                L0();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.b("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        PdfWriter.G0(this.Y, 1, this.X2.o);
        PdfWriter.G0(this.Y, 6, this.X2.s);
        this.s.k("f*").r(this.a3);
    }

    public void O1() {
        Y1(new CMYKColor(0, 0, 0, 1), false);
        this.s.k("0 0 0 1 K").r(this.a3);
    }

    /* access modifiers changed from: protected */
    public void O2(ArrayList<IAccessibleElement> arrayList) {
        PdfContentByte pdfContentByte = this.e3;
        if (pdfContentByte != null) {
            pdfContentByte.O2(arrayList);
        } else {
            this.d3 = arrayList;
        }
    }

    public void P(PdfStructureElement pdfStructureElement) {
        Q(pdfStructureElement, (String) null);
    }

    public void P0() {
        if (this.c3) {
            if (o1()) {
                L0();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.b("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        PdfWriter.G0(this.Y, 1, this.X2.o);
        PdfWriter.G0(this.Y, 1, this.X2.p);
        PdfWriter.G0(this.Y, 6, this.X2.s);
        this.s.k("B*").r(this.a3);
    }

    public void P1() {
        Y1(new GrayColor(0), true);
        this.s.k("0 g").r(this.a3);
    }

    public void P2(double d2) {
        if (d2 > 1.0d) {
            this.s.d(d2).k(" M").r(this.a3);
        }
    }

    public void Q0() {
        if (this.c3) {
            if (o1()) {
                L0();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.b("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        PdfWriter.G0(this.Y, 1, this.X2.o);
        PdfWriter.G0(this.Y, 6, this.X2.s);
        this.s.k("f").r(this.a3);
    }

    public void Q1() {
        Y1(new GrayColor(0), false);
        this.s.k("0 G").r(this.a3);
    }

    public void Q2(float f2) {
        P2((double) f2);
    }

    public void R() {
        S(false);
    }

    public void R0() {
        if (this.c3) {
            if (o1()) {
                L0();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.b("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        PdfWriter.G0(this.Y, 1, this.X2.o);
        PdfWriter.G0(this.Y, 1, this.X2.p);
        PdfWriter.G0(this.Y, 6, this.X2.s);
        this.s.k("B").r(this.a3);
    }

    public void R1() {
        P1();
    }

    public void R2(PdfPatternPainter pdfPatternPainter) {
        if (pdfPatternPainter.g4()) {
            S2(pdfPatternPainter, pdfPatternPainter.b4());
            return;
        }
        Y();
        PdfName g2 = f1().g(this.Y.q0(pdfPatternPainter), pdfPatternPainter.J3());
        Y1(new PatternColor(pdfPatternPainter), true);
        this.s.n(PdfName.Ic.k()).k(" cs ").n(g2.k()).k(" scn").r(this.a3);
    }

    /* access modifiers changed from: protected */
    public void S(boolean z) {
        if (!this.c3) {
            this.c3 = true;
            this.s.k("BT").r(this.a3);
            if (z) {
                GraphicState graphicState = this.X2;
                float f2 = graphicState.f26149d;
                float f4 = graphicState.f26155j;
                f3(graphicState.f26151f, graphicState.f26152g, graphicState.f26153h, graphicState.f26154i, f4, graphicState.f26150e);
                GraphicState graphicState2 = this.X2;
                graphicState2.f26149d = f2;
                graphicState2.f26155j = f4;
                return;
            }
            GraphicState graphicState3 = this.X2;
            graphicState3.f26149d = 0.0f;
            graphicState3.f26150e = 0.0f;
            graphicState3.f26155j = 0.0f;
        } else if (!o1()) {
            throw new IllegalPdfSyntaxException(MessageLocalization.b("unbalanced.begin.end.text.operators", new Object[0]));
        }
    }

    public float S0() {
        return this.X2.f26158m;
    }

    public void S1() {
        Q1();
    }

    public void S2(PdfPatternPainter pdfPatternPainter, BaseColor baseColor) {
        T2(pdfPatternPainter, baseColor, ExtendedColor.k(baseColor) == 3 ? ((SpotColor) baseColor).n() : 0.0f);
    }

    /* access modifiers changed from: protected */
    public PdfIndirectReference T0() {
        return this.Y.d1();
    }

    /* access modifiers changed from: protected */
    public void T1(ArrayList<IAccessibleElement> arrayList) {
        if (o1() && arrayList != null) {
            O2(arrayList);
            for (int i2 = 0; i2 < e1().size(); i2++) {
                C1(e1().get(i2));
            }
        }
    }

    public void T2(PdfPatternPainter pdfPatternPainter, BaseColor baseColor, float f2) {
        Y();
        if (pdfPatternPainter.g4()) {
            PageResources f1 = f1();
            PdfName g2 = f1.g(this.Y.q0(pdfPatternPainter), pdfPatternPainter.J3());
            ColorDetails r0 = this.Y.r0(baseColor);
            PdfName a2 = f1.a(r0.a(), r0.b());
            Y1(new UncoloredPattern(pdfPatternPainter, baseColor, f2), true);
            this.s.n(a2.k()).k(" cs").r(this.a3);
            D1(baseColor, f2);
            this.s.c(' ').n(g2.k()).k(" scn").r(this.a3);
            return;
        }
        throw new RuntimeException(MessageLocalization.b("an.uncolored.pattern.was.expected", new Object[0]));
    }

    public PdfContentByte U0() {
        PdfContentByte pdfContentByte = new PdfContentByte(this.Y);
        pdfContentByte.e3 = this;
        return pdfContentByte;
    }

    public void U1() {
        PdfWriter.G0(this.Y, 12, "Q");
        if (this.c3 && o1()) {
            L0();
        }
        this.s.k("Q").r(this.a3);
        int size = this.Y2.size() - 1;
        if (size >= 0) {
            this.X2.b(this.Y2.get(size));
            this.Y2.remove(size);
            return;
        }
        throw new IllegalPdfSyntaxException(MessageLocalization.b("unbalanced.save.restore.state.operators", new Object[0]));
    }

    public void U2(PdfPatternPainter pdfPatternPainter) {
        if (pdfPatternPainter.g4()) {
            V2(pdfPatternPainter, pdfPatternPainter.b4());
            return;
        }
        Y();
        PdfName g2 = f1().g(this.Y.q0(pdfPatternPainter), pdfPatternPainter.J3());
        Y1(new PatternColor(pdfPatternPainter), false);
        this.s.n(PdfName.Ic.k()).k(" CS ").n(g2.k()).k(" SCN").r(this.a3);
    }

    public PdfContentByte V0(boolean z) {
        PdfContentByte U0 = U0();
        if (z) {
            U0.X2 = this.X2;
            U0.Y2 = this.Y2;
        }
        return U0;
    }

    public void V1(double d2, double d4, double d5, double d6, double d7) {
        double d8;
        double d9;
        double d10;
        double d11 = d5;
        double d12 = d6;
        double d13 = d7;
        if (d11 < 0.0d) {
            double d14 = d2 + d11;
            d11 = -d11;
            d8 = d14;
        } else {
            d8 = d2;
        }
        if (d12 < 0.0d) {
            d9 = -d12;
            d10 = d4 + d12;
        } else {
            d10 = d4;
            d9 = d12;
        }
        double d15 = d13 < 0.0d ? -d13 : d13;
        double d16 = d8 + d15;
        v1(d16, d10);
        double d17 = d8 + d11;
        double d18 = d17 - d15;
        p1(d18, d10);
        double d19 = d15 * ((double) 0.4477f);
        double d20 = d17 - d19;
        double d21 = d10 + d19;
        double d22 = d10 + d15;
        double d23 = d17;
        double d24 = d8;
        double d25 = d16;
        double d26 = d10;
        y0(d20, d10, d17, d21, d23, d22);
        double d27 = d26 + d9;
        double d28 = d27 - d15;
        double d29 = d23;
        p1(d29, d28);
        double d30 = d27 - d19;
        double d31 = d28;
        double d32 = d27;
        y0(d29, d30, d20, d27, d18, d27);
        p1(d25, d27);
        double d33 = d24;
        double d34 = d33 + d19;
        double d35 = d30;
        double d36 = d25;
        double d37 = d33;
        y0(d34, d27, d33, d35, d33, d31);
        p1(d37, d22);
        y0(d37, d21, d34, d26, d36, d26);
    }

    public void V2(PdfPatternPainter pdfPatternPainter, BaseColor baseColor) {
        W2(pdfPatternPainter, baseColor, ExtendedColor.k(baseColor) == 3 ? ((SpotColor) baseColor).n() : 0.0f);
    }

    /* access modifiers changed from: package-private */
    public void W(PdfTemplate pdfTemplate) {
        if (pdfTemplate.O3() == 3) {
            throw new RuntimeException(MessageLocalization.b("invalid.use.of.a.pattern.a.template.was.expected", new Object[0]));
        }
    }

    public float W0(String str, boolean z) {
        BaseFont e2 = this.X2.f26146a.e();
        float a0 = z ? e2.a0(str, this.X2.f26148c) : e2.Z(str, this.X2.f26148c);
        if (this.X2.f26158m != 0.0f && str.length() > 1) {
            a0 += this.X2.f26158m * ((float) (str.length() - 1));
        }
        if (this.X2.f26159n != 0.0f && !e2.i0()) {
            for (int i2 = 0; i2 < str.length() - 1; i2++) {
                if (str.charAt(i2) == ' ') {
                    a0 += this.X2.f26159n;
                }
            }
        }
        float f2 = this.X2.f26157l;
        return ((double) f2) != 100.0d ? (a0 * f2) / 100.0f : a0;
    }

    public void W1(float f2, float f4, float f5, float f6, float f7) {
        V1((double) f2, (double) f4, (double) f5, (double) f6, (double) f7);
    }

    public void W2(PdfPatternPainter pdfPatternPainter, BaseColor baseColor, float f2) {
        Y();
        if (pdfPatternPainter.g4()) {
            PageResources f1 = f1();
            PdfName g2 = f1.g(this.Y.q0(pdfPatternPainter), pdfPatternPainter.J3());
            ColorDetails r0 = this.Y.r0(baseColor);
            PdfName a2 = f1.a(r0.a(), r0.b());
            Y1(new UncoloredPattern(pdfPatternPainter, baseColor, f2), false);
            this.s.n(a2.k()).k(" CS").r(this.a3);
            D1(baseColor, f2);
            this.s.c(' ').n(g2.k()).k(" SCN").r(this.a3);
            return;
        }
        throw new RuntimeException(MessageLocalization.b("an.uncolored.pattern.was.expected", new Object[0]));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0017  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void X() {
        /*
            r5 = this;
            com.itextpdf.text.pdf.PdfContentByte$GraphicState r0 = r5.X2
            int r1 = r0.q
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x000b
            r1 = 0
        L_0x0009:
            r3 = 1
            goto L_0x0015
        L_0x000b:
            if (r1 != r2) goto L_0x000f
            r1 = 1
            goto L_0x0015
        L_0x000f:
            r4 = 2
            if (r1 != r4) goto L_0x0014
            r1 = 1
            goto L_0x0009
        L_0x0014:
            r1 = 0
        L_0x0015:
            if (r3 == 0) goto L_0x001e
            com.itextpdf.text.pdf.PdfWriter r3 = r5.Y
            com.itextpdf.text.BaseColor r0 = r0.o
            com.itextpdf.text.pdf.PdfWriter.G0(r3, r2, r0)
        L_0x001e:
            if (r1 == 0) goto L_0x0029
            com.itextpdf.text.pdf.PdfWriter r0 = r5.Y
            com.itextpdf.text.pdf.PdfContentByte$GraphicState r1 = r5.X2
            com.itextpdf.text.BaseColor r1 = r1.p
            com.itextpdf.text.pdf.PdfWriter.G0(r0, r2, r1)
        L_0x0029:
            com.itextpdf.text.pdf.PdfWriter r0 = r5.Y
            com.itextpdf.text.pdf.PdfContentByte$GraphicState r1 = r5.X2
            com.itextpdf.text.pdf.PdfObject r1 = r1.s
            r2 = 6
            com.itextpdf.text.pdf.PdfWriter.G0(r0, r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfContentByte.X():void");
    }

    public void X1() {
        if (d1() == 0) {
            if (this.c3) {
                if (o1()) {
                    L0();
                } else {
                    throw new IllegalPdfSyntaxException(MessageLocalization.b("unbalanced.begin.end.text.operators", new Object[0]));
                }
            }
            ArrayList<Integer> arrayList = this.Z2;
            if (arrayList != null && !arrayList.isEmpty()) {
                throw new IllegalPdfSyntaxException(MessageLocalization.b("unbalanced.layer.operators", new Object[0]));
            } else if (!this.Y2.isEmpty()) {
                throw new IllegalPdfSyntaxException(MessageLocalization.b("unbalanced.save.restore.state.operators", new Object[0]));
            }
        } else {
            throw new IllegalPdfSyntaxException(MessageLocalization.b("unbalanced.marked.content.operators", new Object[0]));
        }
    }

    public void X2(int i2, int i4, int i5) {
        Y1(new BaseColor(i2, i4, i5), true);
        b(((float) (i2 & 255)) / 255.0f, ((float) (i4 & 255)) / 255.0f, ((float) (i5 & 255)) / 255.0f);
        this.s.k(" rg").r(this.a3);
    }

    /* access modifiers changed from: protected */
    public void Y() {
        if (this.Y == null) {
            throw new NullPointerException(MessageLocalization.b("the.writer.in.pdfcontentbyte.is.null", new Object[0]));
        }
    }

    public float Y0() {
        return this.X2.f26157l;
    }

    public void Y2(float f2, float f4, float f5) {
        Y1(new BaseColor(f2, f4, f5), true);
        b(f2, f4, f5);
        this.s.k(" rg").r(this.a3);
    }

    public void Z(double d2, double d4, double d5) {
        double d6 = d4;
        double d7 = d2 + d5;
        v1(d7, d6);
        double d8 = d5 * ((double) 0.5523f);
        double d9 = d6 + d8;
        double d10 = d2 + d8;
        double d11 = d6 + d5;
        double d12 = d7;
        y0(d7, d9, d10, d11, d2, d11);
        double d13 = d2 - d8;
        double d14 = d2 - d5;
        y0(d13, d11, d14, d9, d14, d4);
        double d15 = d6 - d8;
        double d16 = d6 - d5;
        y0(d14, d15, d13, d16, d2, d16);
        y0(d10, d16, d12, d15, d12, d4);
    }

    /* access modifiers changed from: protected */
    public boolean Z0() {
        return this.c3;
    }

    /* access modifiers changed from: protected */
    public ArrayList<IAccessibleElement> Z1() {
        ArrayList<IAccessibleElement> arrayList = new ArrayList<>();
        if (o1()) {
            arrayList = e1();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d0(arrayList.get(i2));
            }
            O2(new ArrayList());
        }
        return arrayList;
    }

    public void Z2(int i2, int i4, int i5) {
        Y1(new BaseColor(i2, i4, i5), false);
        b(((float) (i2 & 255)) / 255.0f, ((float) (i4 & 255)) / 255.0f, ((float) (i5 & 255)) / 255.0f);
        this.s.k(" RG").r(this.a3);
    }

    public void a0(float f2, float f4, float f5) {
        Z((double) f2, (double) f4, (double) f5);
    }

    public ByteBuffer a1() {
        return this.s;
    }

    public void a2() {
        PdfWriter.G0(this.Y, 12, HTML.Tag.C0);
        if (this.c3 && o1()) {
            L0();
        }
        this.s.k(HTML.Tag.C0).r(this.a3);
        this.Y2.add(new GraphicState(this.X2));
    }

    public void a3(float f2, float f4, float f5) {
        Y1(new BaseColor(f2, f4, f5), false);
        b(f2, f4, f5);
        this.s.k(" RG").r(this.a3);
    }

    public void b0() {
        if (this.c3 && o1()) {
            L0();
        }
        this.s.k(ExifInterface.T4).r(this.a3);
    }

    public void b2(PdfAction pdfAction, float f2, float f4, float f5, float f6) {
        this.Z.f1(pdfAction, f2, f4, f5, f6);
    }

    public void b3(PdfName pdfName) {
        this.s.n(pdfName.k()).k(" ri").r(this.a3);
    }

    public void c(PdfContentByte pdfContentByte) {
        PdfWriter pdfWriter = pdfContentByte.Y;
        if (pdfWriter == null || this.Y == pdfWriter) {
            this.s.i(pdfContentByte.s);
            this.X += pdfContentByte.X;
            return;
        }
        throw new RuntimeException(MessageLocalization.b("inconsistent.writers.are.you.mixing.two.documents", new Object[0]));
    }

    public void c0(IAccessibleElement iAccessibleElement) {
        if (o1() && iAccessibleElement != null && e1().contains(iAccessibleElement)) {
            d0(iAccessibleElement);
            e1().remove(iAccessibleElement);
        }
    }

    public float c1() {
        return this.X2.f26156k;
    }

    public void c2(int i2, int i4, int i5, int i6) {
        Y1(new CMYKColor(i2, i4, i5, i6), true);
        this.s.e(((float) (i2 & 255)) / 255.0f);
        this.s.c(' ');
        this.s.e(((float) (i4 & 255)) / 255.0f);
        this.s.c(' ');
        this.s.e(((float) (i5 & 255)) / 255.0f);
        this.s.c(' ');
        this.s.e(((float) (i6 & 255)) / 255.0f);
        this.s.k(" k").r(this.a3);
    }

    public void c3(PdfShadingPattern pdfShadingPattern) {
        this.Y.u0(pdfShadingPattern);
        PageResources f1 = f1();
        PdfName g2 = f1.g(pdfShadingPattern.n1(), pdfShadingPattern.o1());
        Y1(new ShadingColor(pdfShadingPattern), true);
        this.s.n(PdfName.Ic.k()).k(" cs ").n(g2.k()).k(" scn").r(this.a3);
        ColorDetails i1 = pdfShadingPattern.i1();
        if (i1 != null) {
            f1.a(i1.a(), i1.b());
        }
    }

    /* access modifiers changed from: package-private */
    public void d(PdfAnnotation pdfAnnotation) {
        boolean z = o1() && pdfAnnotation.L() != null && (!(pdfAnnotation instanceof PdfFormField) || ((PdfFormField) pdfAnnotation).Z2() == null);
        if (z) {
            B1(pdfAnnotation);
        }
        this.Y.u(pdfAnnotation);
        if (z) {
            PdfStructureElement H0 = this.Z.H0(pdfAnnotation.getId());
            if (H0 != null) {
                int K0 = this.Z.K0(pdfAnnotation);
                pdfAnnotation.V0(PdfName.vf, new PdfNumber(K0));
                H0.v1(pdfAnnotation, T0());
                this.Y.L1().w1(K0, H0.p1());
            }
            c0(pdfAnnotation);
        }
    }

    /* access modifiers changed from: protected */
    public int d1() {
        PdfContentByte pdfContentByte = this.e3;
        return pdfContentByte != null ? pdfContentByte.d1() : this.b3;
    }

    public void d2(float f2, float f4, float f5, float f6) {
        Y1(new CMYKColor(f2, f4, f5, f6), true);
        a(f2, f4, f5, f6);
        this.s.k(" k").r(this.a3);
    }

    public void d3(PdfShadingPattern pdfShadingPattern) {
        this.Y.u0(pdfShadingPattern);
        PageResources f1 = f1();
        PdfName g2 = f1.g(pdfShadingPattern.n1(), pdfShadingPattern.o1());
        Y1(new ShadingColor(pdfShadingPattern), false);
        this.s.n(PdfName.Ic.k()).k(" CS ").n(g2.k()).k(" SCN").r(this.a3);
        ColorDetails i1 = pdfShadingPattern.i1();
        if (i1 != null) {
            f1.a(i1.a(), i1.b());
        }
    }

    public void e(PdfAnnotation pdfAnnotation, boolean z) {
        if (z && this.X2.r.u() != 0) {
            pdfAnnotation.f1(this.X2.r);
        }
        d(pdfAnnotation);
    }

    public void e0() {
        if (this.c3) {
            if (o1()) {
                L0();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.b("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        this.s.k(CmcdData.Factory.f12510n).r(this.a3);
    }

    /* access modifiers changed from: protected */
    public ArrayList<IAccessibleElement> e1() {
        PdfContentByte pdfContentByte = this.e3;
        return pdfContentByte != null ? pdfContentByte.e1() : this.d3;
    }

    public void e2(int i2, int i4, int i5, int i6) {
        Y1(new CMYKColor(i2, i4, i5, i6), false);
        this.s.e(((float) (i2 & 255)) / 255.0f);
        this.s.c(' ');
        this.s.e(((float) (i4 & 255)) / 255.0f);
        this.s.c(' ');
        this.s.e(((float) (i5 & 255)) / 255.0f);
        this.s.c(' ');
        this.s.e(((float) (i6 & 255)) / 255.0f);
        this.s.k(" K").r(this.a3);
    }

    public void e3(float f2, float f4) {
        f3(1.0f, 0.0f, 0.0f, 1.0f, f2, f4);
    }

    public PdfName f(PdfStream pdfStream, PdfName pdfName, double d2, double d4, double d5, double d6, double d7, double d8) throws IOException {
        PdfArtifact pdfArtifact;
        PdfStream pdfStream2 = pdfStream;
        Y();
        PdfWriter.G0(this.Y, 9, pdfStream);
        PdfName pdfName2 = pdfName;
        PdfName j2 = f1().j(pdfName, this.Y.v0(pdfStream).a());
        if (o1()) {
            if (this.c3) {
                L0();
            }
            pdfArtifact = new PdfArtifact();
            B1(pdfArtifact);
        } else {
            pdfArtifact = null;
        }
        this.s.k("q ");
        double d9 = d2;
        this.s.d(d2).c(' ');
        double d10 = d4;
        this.s.d(d4).c(' ');
        double d11 = d5;
        this.s.d(d5).c(' ');
        this.s.d(d6).c(' ');
        this.s.d(d7).c(' ');
        this.s.d(d8).k(" cm ");
        this.s.n(j2.k()).k(" Do Q").r(this.a3);
        if (o1()) {
            c0(pdfArtifact);
        }
        return j2;
    }

    public void f0() {
        if (this.c3) {
            if (o1()) {
                L0();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.b("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        PdfWriter.G0(this.Y, 1, this.X2.o);
        PdfWriter.G0(this.Y, 1, this.X2.p);
        PdfWriter.G0(this.Y, 6, this.X2.s);
        this.s.k("b*").r(this.a3);
    }

    /* access modifiers changed from: package-private */
    public PageResources f1() {
        return this.Z.F0();
    }

    public void f2(float f2, float f4, float f5, float f6) {
        Y1(new CMYKColor(f2, f4, f5, f6), false);
        a(f2, f4, f5, f6);
        this.s.k(" K").r(this.a3);
    }

    public void f3(float f2, float f4, float f5, float f6, float f7, float f8) {
        if (!this.c3 && o1()) {
            S(true);
        }
        GraphicState graphicState = this.X2;
        graphicState.f26149d = f7;
        graphicState.f26150e = f8;
        graphicState.f26151f = f2;
        graphicState.f26152g = f4;
        graphicState.f26153h = f5;
        graphicState.f26154i = f6;
        graphicState.f26155j = f7;
        this.s.e(f2).c(' ').e(f4).r(32).e(f5).r(32).e(f6).r(32).e(f7).r(32).e(f8).k(" Tm").r(this.a3);
    }

    public PdfName g(PdfStream pdfStream, PdfName pdfName, float f2, float f4, float f5, float f6, float f7, float f8) throws IOException {
        return f(pdfStream, pdfName, (double) f2, (double) f4, (double) f5, (double) f6, (double) f7, (double) f8);
    }

    public void g0() {
        if (this.c3) {
            if (o1()) {
                L0();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.b("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        PdfWriter.G0(this.Y, 1, this.X2.o);
        PdfWriter.G0(this.Y, 1, this.X2.p);
        PdfWriter.G0(this.Y, 6, this.X2.s);
        this.s.k("b").r(this.a3);
    }

    public void g2(float f2) {
        if (!this.c3 && o1()) {
            S(true);
        }
        this.X2.f26158m = f2;
        this.s.e(f2).k(" Tc").r(this.a3);
    }

    public void g3(AffineTransform affineTransform) {
        double[] dArr = new double[6];
        affineTransform.g(dArr);
        f3((float) dArr[0], (float) dArr[1], (float) dArr[2], (float) dArr[3], (float) dArr[4], (float) dArr[5]);
    }

    public void h(Image image) throws DocumentException {
        q(image, false);
    }

    public void h0() {
        if (this.c3) {
            if (o1()) {
                L0();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.b("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        PdfWriter.G0(this.Y, 1, this.X2.p);
        PdfWriter.G0(this.Y, 6, this.X2.s);
        this.s.k("s").r(this.a3);
    }

    public PdfDocument h1() {
        return this.Z;
    }

    public void h2(BaseColor baseColor) {
        switch (ExtendedColor.k(baseColor)) {
            case 1:
                u2(((GrayColor) baseColor).m());
                break;
            case 2:
                CMYKColor cMYKColor = (CMYKColor) baseColor;
                d2(cMYKColor.n(), cMYKColor.o(), cMYKColor.p(), cMYKColor.m());
                break;
            case 3:
                SpotColor spotColor = (SpotColor) baseColor;
                k2(spotColor.m(), spotColor.n());
                break;
            case 4:
                R2(((PatternColor) baseColor).m());
                break;
            case 5:
                c3(((ShadingColor) baseColor).m());
                break;
            case 6:
                DeviceNColor deviceNColor = (DeviceNColor) baseColor;
                i2(deviceNColor.m(), deviceNColor.n());
                break;
            case 7:
                LabColor labColor = (LabColor) baseColor;
                j2(labColor.p(), labColor.o(), labColor.m(), labColor.n());
                break;
            default:
                X2(baseColor.g(), baseColor.e(), baseColor.d());
                break;
        }
        int c2 = baseColor.c();
        if (c2 < 255) {
            PdfGState pdfGState = new PdfGState();
            pdfGState.m1(((float) c2) / 255.0f);
            t2(pdfGState);
        }
    }

    public void h3(int i2) {
        if (!this.c3 && o1()) {
            S(true);
        }
        this.X2.q = i2;
        this.s.f(i2).k(" Tr").r(this.a3);
    }

    public void i(Image image, double d2, double d4, double d5, double d6, double d7, double d8) throws DocumentException {
        j(image, d2, d4, d5, d6, d7, d8, false);
    }

    public PdfWriter i1() {
        return this.Y;
    }

    public void i2(PdfDeviceNColor pdfDeviceNColor, float[] fArr) {
        Y();
        this.X2.f26147b = this.Y.n0(pdfDeviceNColor);
        PdfName a2 = f1().a(this.X2.f26147b.a(), this.X2.f26147b.b());
        Y1(new DeviceNColor(pdfDeviceNColor, fArr), true);
        this.s.n(a2.k()).k(" cs ");
        for (float f2 : fArr) {
            ByteBuffer byteBuffer = this.s;
            byteBuffer.k(f2 + StringUtils.SPACE);
        }
        this.s.k("scn").r(this.a3);
    }

    public void i3(double d2) {
        if (!this.c3 && o1()) {
            S(true);
        }
        this.s.d(d2).k(" Ts").r(this.a3);
    }

    public void j(Image image, double d2, double d4, double d5, double d6, double d7, double d8, boolean z) throws DocumentException {
        k(image, d2, d4, d5, d6, d7, d8, z, false);
    }

    public void j0(double d2, double d4, double d5, double d6, double d7, double d8) {
        if (this.c3 && o1()) {
            L0();
        }
        this.X2.r.a(new AffineTransform(d2, d4, d5, d6, d7, d8));
        this.s.d(d2).c(' ').d(d4).c(' ').d(d5).c(' ');
        this.s.d(d6).c(' ').d(d7).c(' ').d(d8).k(" cm").r(this.a3);
    }

    public PdfOutline j1() {
        Y();
        return this.Z.G0();
    }

    public void j2(PdfLabColor pdfLabColor, float f2, float f4, float f5) {
        Y();
        this.X2.f26147b = this.Y.n0(pdfLabColor);
        PdfName a2 = f1().a(this.X2.f26147b.a(), this.X2.f26147b.b());
        Y1(new LabColor(pdfLabColor, f2, f4, f5), true);
        this.s.n(a2.k()).k(" cs ");
        ByteBuffer byteBuffer = this.s;
        byteBuffer.k(f2 + StringUtils.SPACE + f4 + StringUtils.SPACE + f5 + StringUtils.SPACE);
        this.s.k("scn").r(this.a3);
    }

    public void j3(float f2) {
        i3((double) f2);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0369 A[Catch:{ IOException -> 0x01d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0398 A[Catch:{ IOException -> 0x0395 }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x039f A[Catch:{ IOException -> 0x0395 }] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x03a8 A[Catch:{ IOException -> 0x0395 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x03a9 A[Catch:{ IOException -> 0x0395 }] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0428  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0432  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k(com.itextpdf.text.Image r31, double r32, double r34, double r36, double r38, double r40, double r42, boolean r44, boolean r45) throws com.itextpdf.text.DocumentException {
        /*
            r30 = this;
            r15 = r30
            r13 = r31
            r11 = r32
            r9 = r34
            r7 = r36
            r5 = r38
            r3 = r40
            r0 = r42
            com.itextpdf.awt.geom.AffineTransform r29 = new com.itextpdf.awt.geom.AffineTransform     // Catch:{ IOException -> 0x0031 }
            r16 = r29
            r17 = r32
            r19 = r34
            r21 = r36
            r23 = r38
            r25 = r40
            r27 = r42
            r16.<init>((double) r17, (double) r19, (double) r21, (double) r23, (double) r25, (double) r27)     // Catch:{ IOException -> 0x0031 }
            com.itextpdf.text.pdf.PdfOCG r16 = r31.h1()     // Catch:{ IOException -> 0x0031 }
            if (r16 == 0) goto L_0x0036
            com.itextpdf.text.pdf.PdfOCG r2 = r31.h1()     // Catch:{ IOException -> 0x0031 }
            r15.K(r2)     // Catch:{ IOException -> 0x0031 }
            goto L_0x0036
        L_0x0031:
            r0 = move-exception
        L_0x0032:
            r14 = r15
        L_0x0033:
            r15 = 1
            goto L_0x0420
        L_0x0036:
            boolean r2 = r30.o1()     // Catch:{ IOException -> 0x0031 }
            if (r2 == 0) goto L_0x0101
            boolean r2 = r15.c3     // Catch:{ IOException -> 0x00fc }
            if (r2 == 0) goto L_0x0043
            r30.L0()     // Catch:{ IOException -> 0x0031 }
        L_0x0043:
            com.itextpdf.awt.geom.Point2D$Float r2 = new com.itextpdf.awt.geom.Point2D$Float     // Catch:{ IOException -> 0x00fc }
            r14 = 0
            r2.<init>(r14, r14)     // Catch:{ IOException -> 0x00fc }
            com.itextpdf.awt.geom.Point2D$Float r14 = new com.itextpdf.awt.geom.Point2D$Float     // Catch:{ IOException -> 0x00fc }
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 0
            r14.<init>(r0, r1)     // Catch:{ IOException -> 0x00fc }
            com.itextpdf.awt.geom.Point2D$Float r1 = new com.itextpdf.awt.geom.Point2D$Float     // Catch:{ IOException -> 0x00fc }
            r1.<init>(r0, r0)     // Catch:{ IOException -> 0x00fc }
            com.itextpdf.awt.geom.Point2D$Float r3 = new com.itextpdf.awt.geom.Point2D$Float     // Catch:{ IOException -> 0x00fc }
            r4 = 0
            r3.<init>(r4, r0)     // Catch:{ IOException -> 0x00fc }
            r0 = 4
            com.itextpdf.awt.geom.Point2D$Float[] r4 = new com.itextpdf.awt.geom.Point2D.Float[r0]     // Catch:{ IOException -> 0x00fc }
            r16 = 0
            r4[r16] = r2     // Catch:{ IOException -> 0x00fc }
            r2 = 1
            r4[r2] = r14     // Catch:{ IOException -> 0x00fc }
            r2 = 2
            r4[r2] = r1     // Catch:{ IOException -> 0x00fc }
            r1 = 3
            r4[r1] = r3     // Catch:{ IOException -> 0x00fc }
            com.itextpdf.awt.geom.Point2D$Float[] r1 = new com.itextpdf.awt.geom.Point2D.Float[r0]     // Catch:{ IOException -> 0x00fc }
            r20 = 0
            r21 = 4
            r18 = 0
            r16 = r29
            r17 = r4
            r19 = r1
            r16.k0(r17, r18, r19, r20, r21)     // Catch:{ IOException -> 0x00fc }
            r0 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            r2 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r2 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            r3 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r4 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r5 = 4
            r14 = 0
        L_0x008e:
            if (r14 >= r5) goto L_0x00de
            r5 = r1[r14]     // Catch:{ IOException -> 0x0031 }
            double r5 = r5.g()     // Catch:{ IOException -> 0x0031 }
            double r7 = (double) r3     // Catch:{ IOException -> 0x0031 }
            int r16 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r16 >= 0) goto L_0x00a2
            r3 = r1[r14]     // Catch:{ IOException -> 0x0031 }
            double r5 = r3.g()     // Catch:{ IOException -> 0x0031 }
            float r3 = (float) r5     // Catch:{ IOException -> 0x0031 }
        L_0x00a2:
            r5 = r1[r14]     // Catch:{ IOException -> 0x0031 }
            double r5 = r5.g()     // Catch:{ IOException -> 0x0031 }
            double r7 = (double) r0     // Catch:{ IOException -> 0x0031 }
            int r16 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r16 <= 0) goto L_0x00b4
            r0 = r1[r14]     // Catch:{ IOException -> 0x0031 }
            double r5 = r0.g()     // Catch:{ IOException -> 0x0031 }
            float r0 = (float) r5     // Catch:{ IOException -> 0x0031 }
        L_0x00b4:
            r5 = r1[r14]     // Catch:{ IOException -> 0x0031 }
            double r5 = r5.h()     // Catch:{ IOException -> 0x0031 }
            double r7 = (double) r4     // Catch:{ IOException -> 0x0031 }
            int r16 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r16 >= 0) goto L_0x00c6
            r4 = r1[r14]     // Catch:{ IOException -> 0x0031 }
            double r4 = r4.h()     // Catch:{ IOException -> 0x0031 }
            float r4 = (float) r4     // Catch:{ IOException -> 0x0031 }
        L_0x00c6:
            r5 = r1[r14]     // Catch:{ IOException -> 0x0031 }
            double r5 = r5.h()     // Catch:{ IOException -> 0x0031 }
            double r7 = (double) r2     // Catch:{ IOException -> 0x0031 }
            int r16 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r16 <= 0) goto L_0x00d8
            r2 = r1[r14]     // Catch:{ IOException -> 0x0031 }
            double r5 = r2.h()     // Catch:{ IOException -> 0x0031 }
            float r2 = (float) r5
        L_0x00d8:
            r5 = 1
            int r14 = r14 + r5
            r7 = r36
            r5 = 4
            goto L_0x008e
        L_0x00de:
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.n4     // Catch:{ IOException -> 0x00fc }
            com.itextpdf.text.pdf.PdfArray r5 = new com.itextpdf.text.pdf.PdfArray     // Catch:{ IOException -> 0x00fc }
            r6 = 4
            float[] r7 = new float[r6]     // Catch:{ IOException -> 0x00fc }
            r6 = 0
            r7[r6] = r3     // Catch:{ IOException -> 0x00f8 }
            r3 = 1
            r7[r3] = r4     // Catch:{ IOException -> 0x0031 }
            r4 = 2
            r7[r4] = r0     // Catch:{ IOException -> 0x0031 }
            r0 = 3
            r7[r0] = r2     // Catch:{ IOException -> 0x0031 }
            r5.<init>((float[]) r7)     // Catch:{ IOException -> 0x0031 }
            r13.U(r1, r5)     // Catch:{ IOException -> 0x0031 }
            goto L_0x0104
        L_0x00f8:
            r0 = move-exception
            r3 = 1
            goto L_0x0032
        L_0x00fc:
            r0 = move-exception
            r3 = 1
            r6 = 0
            goto L_0x0032
        L_0x0101:
            r3 = 1
            r4 = 2
            r6 = 0
        L_0x0104:
            com.itextpdf.text.pdf.PdfWriter r0 = r15.Y     // Catch:{ IOException -> 0x0031 }
            if (r0 == 0) goto L_0x017c
            boolean r0 = r31.B1()     // Catch:{ IOException -> 0x0177 }
            if (r0 == 0) goto L_0x017c
            com.itextpdf.text.pdf.PdfWriter r0 = r15.Y     // Catch:{ IOException -> 0x0177 }
            r0.V(r13)     // Catch:{ IOException -> 0x0177 }
            com.itextpdf.text.pdf.PdfTemplate r2 = r31.r1()     // Catch:{ IOException -> 0x0177 }
            java.util.HashMap r0 = r31.k0()     // Catch:{ IOException -> 0x0177 }
            if (r0 == 0) goto L_0x013d
            java.util.HashMap r0 = r31.k0()     // Catch:{ IOException -> 0x0031 }
            java.util.Set r0 = r0.keySet()     // Catch:{ IOException -> 0x0031 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ IOException -> 0x0031 }
        L_0x0129:
            boolean r1 = r0.hasNext()     // Catch:{ IOException -> 0x0031 }
            if (r1 == 0) goto L_0x013d
            java.lang.Object r1 = r0.next()     // Catch:{ IOException -> 0x0031 }
            com.itextpdf.text.pdf.PdfName r1 = (com.itextpdf.text.pdf.PdfName) r1     // Catch:{ IOException -> 0x0031 }
            com.itextpdf.text.pdf.PdfObject r5 = r13.r(r1)     // Catch:{ IOException -> 0x0031 }
            r2.U(r1, r5)     // Catch:{ IOException -> 0x0031 }
            goto L_0x0129
        L_0x013d:
            float r0 = r2.P3()     // Catch:{ IOException -> 0x0177 }
            float r1 = r2.I3()     // Catch:{ IOException -> 0x0177 }
            double r7 = (double) r0     // Catch:{ IOException -> 0x0177 }
            double r16 = r11 / r7
            double r7 = r9 / r7
            double r0 = (double) r1     // Catch:{ IOException -> 0x0177 }
            double r18 = r36 / r0
            double r20 = r38 / r0
            r0 = 0
            r22 = 0
            r1 = r30
            r5 = 2
            r6 = 1
            r14 = 0
            r3 = r16
            r5 = r7
            r7 = r18
            r9 = r20
            r11 = r40
            r13 = r42
            r15 = r0
            r16 = r22
            r1.x(r2, r3, r5, r7, r9, r11, r13, r15, r16)     // Catch:{ IOException -> 0x0177 }
            r14 = r30
            r4 = r31
            r12 = r32
            r10 = r34
            r8 = r36
            r0 = 2
            r6 = 1
            r7 = 0
            goto L_0x0363
        L_0x0177:
            r0 = move-exception
            r14 = r30
            goto L_0x0033
        L_0x017c:
            r14 = r30
            com.itextpdf.text.pdf.ByteBuffer r0 = r14.s     // Catch:{ IOException -> 0x01d2 }
            java.lang.String r1 = "q "
            r0.k(r1)     // Catch:{ IOException -> 0x01d2 }
            boolean r0 = r29.y()     // Catch:{ IOException -> 0x01d2 }
            r1 = 32
            if (r0 != 0) goto L_0x01d5
            com.itextpdf.text.pdf.ByteBuffer r0 = r14.s     // Catch:{ IOException -> 0x01d2 }
            r12 = r32
            com.itextpdf.text.pdf.ByteBuffer r0 = r0.d(r12)     // Catch:{ IOException -> 0x01d2 }
            r0.c(r1)     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.pdf.ByteBuffer r0 = r14.s     // Catch:{ IOException -> 0x01d2 }
            r10 = r34
            com.itextpdf.text.pdf.ByteBuffer r0 = r0.d(r10)     // Catch:{ IOException -> 0x01d2 }
            r0.c(r1)     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.pdf.ByteBuffer r0 = r14.s     // Catch:{ IOException -> 0x01d2 }
            r8 = r36
            com.itextpdf.text.pdf.ByteBuffer r0 = r0.d(r8)     // Catch:{ IOException -> 0x01d2 }
            r0.c(r1)     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.pdf.ByteBuffer r0 = r14.s     // Catch:{ IOException -> 0x01d2 }
            r6 = r38
            com.itextpdf.text.pdf.ByteBuffer r0 = r0.d(r6)     // Catch:{ IOException -> 0x01d2 }
            r0.c(r1)     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.pdf.ByteBuffer r0 = r14.s     // Catch:{ IOException -> 0x01d2 }
            r4 = r40
            com.itextpdf.text.pdf.ByteBuffer r0 = r0.d(r4)     // Catch:{ IOException -> 0x01d2 }
            r0.c(r1)     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.pdf.ByteBuffer r0 = r14.s     // Catch:{ IOException -> 0x01d2 }
            r2 = r42
            com.itextpdf.text.pdf.ByteBuffer r0 = r0.d(r2)     // Catch:{ IOException -> 0x01d2 }
            java.lang.String r15 = " cm"
            r0.k(r15)     // Catch:{ IOException -> 0x01d2 }
            goto L_0x01e1
        L_0x01d2:
            r0 = move-exception
            goto L_0x0033
        L_0x01d5:
            r12 = r32
            r10 = r34
            r8 = r36
            r6 = r38
            r4 = r40
            r2 = r42
        L_0x01e1:
            if (r44 == 0) goto L_0x031c
            com.itextpdf.text.pdf.ByteBuffer r0 = r14.s     // Catch:{ IOException -> 0x0317 }
            java.lang.String r1 = "\nBI\n"
            r0.k(r1)     // Catch:{ IOException -> 0x0317 }
            com.itextpdf.text.pdf.PdfImage r0 = new com.itextpdf.text.pdf.PdfImage     // Catch:{ IOException -> 0x0317 }
            java.lang.String r1 = ""
            r15 = 0
            r4 = r31
            r0.<init>(r4, r1, r15)     // Catch:{ IOException -> 0x0297 }
            boolean r1 = r4 instanceof com.itextpdf.text.ImgJBIG2     // Catch:{ IOException -> 0x0297 }
            if (r1 == 0) goto L_0x0216
            r1 = r4
            com.itextpdf.text.ImgJBIG2 r1 = (com.itextpdf.text.ImgJBIG2) r1     // Catch:{ IOException -> 0x01d2 }
            byte[] r1 = r1.y2()     // Catch:{ IOException -> 0x01d2 }
            if (r1 == 0) goto L_0x0216
            com.itextpdf.text.pdf.PdfDictionary r5 = new com.itextpdf.text.pdf.PdfDictionary     // Catch:{ IOException -> 0x01d2 }
            r5.<init>()     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.pdf.PdfName r15 = com.itextpdf.text.pdf.PdfName.ca     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.pdf.PdfWriter r2 = r14.Y     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.pdf.PdfIndirectReference r1 = r2.H1(r1)     // Catch:{ IOException -> 0x01d2 }
            r5.V0(r15, r1)     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.o6     // Catch:{ IOException -> 0x01d2 }
            r0.V0(r1, r5)     // Catch:{ IOException -> 0x01d2 }
        L_0x0216:
            com.itextpdf.text.pdf.PdfWriter r1 = r14.Y     // Catch:{ IOException -> 0x0297 }
            r2 = 17
            com.itextpdf.text.pdf.PdfWriter.G0(r1, r2, r0)     // Catch:{ IOException -> 0x0297 }
            java.util.Set r1 = r0.G0()     // Catch:{ IOException -> 0x0297 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ IOException -> 0x0297 }
        L_0x0225:
            boolean r2 = r1.hasNext()     // Catch:{ IOException -> 0x0297 }
            if (r2 == 0) goto L_0x02da
            java.lang.Object r2 = r1.next()     // Catch:{ IOException -> 0x0297 }
            com.itextpdf.text.pdf.PdfName r2 = (com.itextpdf.text.pdf.PdfName) r2     // Catch:{ IOException -> 0x0297 }
            com.itextpdf.text.pdf.PdfObject r3 = r0.d0(r2)     // Catch:{ IOException -> 0x0297 }
            java.util.HashMap<com.itextpdf.text.pdf.PdfName, java.lang.String> r5 = x3     // Catch:{ IOException -> 0x0297 }
            java.lang.Object r5 = r5.get(r2)     // Catch:{ IOException -> 0x0297 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x0297 }
            if (r5 != 0) goto L_0x0240
            goto L_0x0225
        L_0x0240:
            com.itextpdf.text.pdf.ByteBuffer r15 = r14.s     // Catch:{ IOException -> 0x0297 }
            r15.k(r5)     // Catch:{ IOException -> 0x0297 }
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.w5     // Catch:{ IOException -> 0x0297 }
            boolean r15 = r2.equals(r5)     // Catch:{ IOException -> 0x0297 }
            if (r15 == 0) goto L_0x02a0
            boolean r15 = r3.q()     // Catch:{ IOException -> 0x0297 }
            if (r15 == 0) goto L_0x02a0
            r15 = r3
            com.itextpdf.text.pdf.PdfArray r15 = (com.itextpdf.text.pdf.PdfArray) r15     // Catch:{ IOException -> 0x0297 }
            r16 = r1
            int r1 = r15.size()     // Catch:{ IOException -> 0x0297 }
            r6 = 4
            if (r1 != r6) goto L_0x029c
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.N9     // Catch:{ IOException -> 0x0297 }
            r7 = 0
            com.itextpdf.text.pdf.PdfName r6 = r15.I0(r7)     // Catch:{ IOException -> 0x0293 }
            boolean r1 = r1.equals(r6)     // Catch:{ IOException -> 0x0293 }
            if (r1 == 0) goto L_0x0290
            r6 = 1
            com.itextpdf.text.pdf.PdfObject r1 = r15.T0(r6)     // Catch:{ IOException -> 0x01d2 }
            boolean r1 = r1.E()     // Catch:{ IOException -> 0x01d2 }
            if (r1 == 0) goto L_0x028e
            r1 = 2
            com.itextpdf.text.pdf.PdfObject r17 = r15.T0(r1)     // Catch:{ IOException -> 0x01d2 }
            boolean r17 = r17.I()     // Catch:{ IOException -> 0x01d2 }
            if (r17 == 0) goto L_0x028e
            r1 = 3
            com.itextpdf.text.pdf.PdfObject r15 = r15.T0(r1)     // Catch:{ IOException -> 0x01d2 }
            boolean r15 = r15.N()     // Catch:{ IOException -> 0x01d2 }
            if (r15 == 0) goto L_0x02a3
            goto L_0x02c7
        L_0x028e:
            r1 = 3
            goto L_0x02a3
        L_0x0290:
            r1 = 3
            r6 = 1
            goto L_0x02a3
        L_0x0293:
            r0 = move-exception
            r6 = 1
            goto L_0x0033
        L_0x0297:
            r0 = move-exception
        L_0x0298:
            r6 = 1
            r7 = 0
            goto L_0x0033
        L_0x029c:
            r1 = 3
            r6 = 1
            r7 = 0
            goto L_0x02a3
        L_0x02a0:
            r16 = r1
            goto L_0x029c
        L_0x02a3:
            boolean r2 = r2.equals(r5)     // Catch:{ IOException -> 0x01d2 }
            if (r2 == 0) goto L_0x02c7
            boolean r2 = r3.E()     // Catch:{ IOException -> 0x01d2 }
            if (r2 != 0) goto L_0x02c7
            com.itextpdf.text.pdf.PdfWriter r2 = r14.Y     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.pdf.PdfName r2 = r2.Z0()     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.pdf.PageResources r5 = r30.f1()     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.pdf.PdfWriter r15 = r14.Y     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.pdf.PdfIndirectObject r3 = r15.v0(r3)     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.pdf.PdfIndirectReference r3 = r3.a()     // Catch:{ IOException -> 0x01d2 }
            r5.a(r2, r3)     // Catch:{ IOException -> 0x01d2 }
            r3 = r2
        L_0x02c7:
            com.itextpdf.text.pdf.ByteBuffer r2 = r14.s     // Catch:{ IOException -> 0x01d2 }
            r5 = 0
            r3.T(r5, r2)     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.pdf.ByteBuffer r2 = r14.s     // Catch:{ IOException -> 0x01d2 }
            r3 = 10
            r2.c(r3)     // Catch:{ IOException -> 0x01d2 }
            r6 = r38
            r1 = r16
            goto L_0x0225
        L_0x02da:
            r6 = 1
            r7 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x01d2 }
            r1.<init>()     // Catch:{ IOException -> 0x01d2 }
            r0.o1(r1)     // Catch:{ IOException -> 0x01d2 }
            byte[] r0 = r1.toByteArray()     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.pdf.ByteBuffer r1 = r14.s     // Catch:{ IOException -> 0x01d2 }
            java.lang.String r2 = "/L %s\n"
            int r3 = r0.length     // Catch:{ IOException -> 0x01d2 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IOException -> 0x01d2 }
            java.lang.Object[] r5 = new java.lang.Object[r6]     // Catch:{ IOException -> 0x01d2 }
            r5[r7] = r3     // Catch:{ IOException -> 0x01d2 }
            java.lang.String r2 = java.lang.String.format(r2, r5)     // Catch:{ IOException -> 0x01d2 }
            r1.k(r2)     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.pdf.ByteBuffer r1 = r14.s     // Catch:{ IOException -> 0x01d2 }
            java.lang.String r2 = "ID\n"
            r1.k(r2)     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.pdf.ByteBuffer r1 = r14.s     // Catch:{ IOException -> 0x01d2 }
            r1.n(r0)     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.pdf.ByteBuffer r0 = r14.s     // Catch:{ IOException -> 0x01d2 }
            java.lang.String r1 = "\nEI\nQ"
            com.itextpdf.text.pdf.ByteBuffer r0 = r0.k(r1)     // Catch:{ IOException -> 0x01d2 }
            int r1 = r14.a3     // Catch:{ IOException -> 0x01d2 }
            r0.r(r1)     // Catch:{ IOException -> 0x01d2 }
            r0 = 2
            goto L_0x0363
        L_0x0317:
            r0 = move-exception
            r4 = r31
            goto L_0x0298
        L_0x031c:
            r4 = r31
            r0 = 2
            r6 = 1
            r7 = 0
            com.itextpdf.text.pdf.PageResources r2 = r30.f1()     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.Image r3 = r31.Q0()     // Catch:{ IOException -> 0x01d2 }
            if (r3 == 0) goto L_0x033a
            com.itextpdf.text.pdf.PdfWriter r5 = r14.Y     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.pdf.PdfName r3 = r5.V(r3)     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.pdf.PdfWriter r5 = r14.Y     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.pdf.PdfIndirectReference r5 = r5.l1(r3)     // Catch:{ IOException -> 0x01d2 }
            r2.j(r3, r5)     // Catch:{ IOException -> 0x01d2 }
        L_0x033a:
            com.itextpdf.text.pdf.PdfWriter r3 = r14.Y     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.pdf.PdfName r3 = r3.V(r4)     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.pdf.PdfWriter r5 = r14.Y     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.pdf.PdfIndirectReference r5 = r5.l1(r3)     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.pdf.PdfName r2 = r2.j(r3, r5)     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.pdf.ByteBuffer r3 = r14.s     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.pdf.ByteBuffer r1 = r3.c(r1)     // Catch:{ IOException -> 0x01d2 }
            byte[] r2 = r2.k()     // Catch:{ IOException -> 0x01d2 }
            com.itextpdf.text.pdf.ByteBuffer r1 = r1.n(r2)     // Catch:{ IOException -> 0x01d2 }
            java.lang.String r2 = " Do Q"
            com.itextpdf.text.pdf.ByteBuffer r1 = r1.k(r2)     // Catch:{ IOException -> 0x01d2 }
            int r2 = r14.a3     // Catch:{ IOException -> 0x01d2 }
            r1.r(r2)     // Catch:{ IOException -> 0x01d2 }
        L_0x0363:
            boolean r1 = r31.c0()     // Catch:{ IOException -> 0x01d2 }
            if (r1 == 0) goto L_0x0398
            r30.a2()     // Catch:{ IOException -> 0x01d2 }
            float r1 = r31.a0()     // Catch:{ IOException -> 0x01d2 }
            float r2 = r31.N()     // Catch:{ IOException -> 0x01d2 }
            double r6 = (double) r1
            double r15 = r12 / r6
            double r5 = r10 / r6
            double r1 = (double) r2
            double r17 = r8 / r1
            double r19 = r38 / r1
            r1 = r30
            r2 = r15
            r4 = r5
            r15 = 1
            r6 = r17
            r8 = r19
            r10 = r40
            r12 = r42
            r1.j0(r2, r4, r6, r8, r10, r12)     // Catch:{ IOException -> 0x0395 }
            r30.I1(r31)     // Catch:{ IOException -> 0x0395 }
            r30.U1()     // Catch:{ IOException -> 0x0395 }
            goto L_0x0399
        L_0x0395:
            r0 = move-exception
            goto L_0x0420
        L_0x0398:
            r15 = 1
        L_0x0399:
            com.itextpdf.text.pdf.PdfOCG r1 = r31.h1()     // Catch:{ IOException -> 0x0395 }
            if (r1 == 0) goto L_0x03a2
            r30.J0()     // Catch:{ IOException -> 0x0395 }
        L_0x03a2:
            com.itextpdf.text.Annotation r1 = r31.H0()     // Catch:{ IOException -> 0x0395 }
            if (r1 != 0) goto L_0x03a9
            return
        L_0x03a9:
            float[] r2 = w3     // Catch:{ IOException -> 0x0395 }
            int r2 = r2.length     // Catch:{ IOException -> 0x0395 }
            double[] r3 = new double[r2]     // Catch:{ IOException -> 0x0395 }
            r4 = 0
        L_0x03af:
            float[] r5 = w3     // Catch:{ IOException -> 0x0395 }
            int r6 = r5.length     // Catch:{ IOException -> 0x0395 }
            if (r4 >= r6) goto L_0x03d2
            r6 = r5[r4]     // Catch:{ IOException -> 0x0395 }
            double r7 = (double) r6     // Catch:{ IOException -> 0x0395 }
            double r7 = r7 * r32
            int r9 = r4 + 1
            r5 = r5[r9]     // Catch:{ IOException -> 0x0395 }
            double r10 = (double) r5     // Catch:{ IOException -> 0x0395 }
            double r10 = r10 * r36
            double r7 = r7 + r10
            double r7 = r7 + r40
            r3[r4] = r7     // Catch:{ IOException -> 0x0395 }
            double r6 = (double) r6     // Catch:{ IOException -> 0x0395 }
            double r6 = r6 * r34
            double r10 = (double) r5     // Catch:{ IOException -> 0x0395 }
            double r10 = r10 * r38
            double r6 = r6 + r10
            double r6 = r6 + r42
            r3[r9] = r6     // Catch:{ IOException -> 0x0395 }
            int r4 = r4 + r0
            goto L_0x03af
        L_0x03d2:
            r4 = 0
            r5 = r3[r4]     // Catch:{ IOException -> 0x0395 }
            r7 = r3[r15]     // Catch:{ IOException -> 0x0395 }
            r10 = r7
            r12 = r10
            r8 = r5
            r6 = r8
            r5 = 2
        L_0x03dc:
            r44 = r1
            if (r5 >= r2) goto L_0x0402
            r0 = r3[r5]     // Catch:{ IOException -> 0x0395 }
            double r6 = java.lang.Math.min(r6, r0)     // Catch:{ IOException -> 0x0395 }
            int r0 = r5 + 1
            r1 = r5
            r4 = r3[r0]     // Catch:{ IOException -> 0x0395 }
            double r10 = java.lang.Math.min(r10, r4)     // Catch:{ IOException -> 0x0395 }
            r4 = r3[r1]     // Catch:{ IOException -> 0x0395 }
            double r8 = java.lang.Math.max(r8, r4)     // Catch:{ IOException -> 0x0395 }
            r4 = r3[r0]     // Catch:{ IOException -> 0x0395 }
            double r12 = java.lang.Math.max(r12, r4)     // Catch:{ IOException -> 0x0395 }
            r0 = 2
            int r5 = r1 + 2
            r1 = r44
            r4 = 0
            goto L_0x03dc
        L_0x0402:
            com.itextpdf.text.Annotation r0 = new com.itextpdf.text.Annotation     // Catch:{ IOException -> 0x0395 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0395 }
            float r1 = (float) r6     // Catch:{ IOException -> 0x0395 }
            float r2 = (float) r10     // Catch:{ IOException -> 0x0395 }
            float r3 = (float) r8     // Catch:{ IOException -> 0x0395 }
            float r4 = (float) r12     // Catch:{ IOException -> 0x0395 }
            r0.j(r1, r2, r3, r4)     // Catch:{ IOException -> 0x0395 }
            com.itextpdf.text.pdf.PdfWriter r5 = r14.Y     // Catch:{ IOException -> 0x0395 }
            com.itextpdf.text.Rectangle r6 = new com.itextpdf.text.Rectangle     // Catch:{ IOException -> 0x0395 }
            r6.<init>(r1, r2, r3, r4)     // Catch:{ IOException -> 0x0395 }
            com.itextpdf.text.pdf.PdfAnnotation r0 = com.itextpdf.text.pdf.internal.PdfAnnotationsImp.e(r5, r0, r6)     // Catch:{ IOException -> 0x0395 }
            if (r0 != 0) goto L_0x041c
            return
        L_0x041c:
            r14.d(r0)     // Catch:{ IOException -> 0x0395 }
            return
        L_0x0420:
            if (r31 == 0) goto L_0x0432
            java.net.URL r1 = r31.t1()
            if (r1 == 0) goto L_0x0432
            java.net.URL r1 = r31.t1()
            java.lang.String r1 = r1.getPath()
            r2 = 0
            goto L_0x043b
        L_0x0432:
            java.lang.String r1 = "unknown"
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.b(r1, r3)
        L_0x043b:
            com.itextpdf.text.DocumentException r3 = new com.itextpdf.text.DocumentException
            java.lang.String r4 = "add.image.exception"
            java.lang.Object[] r5 = new java.lang.Object[r15]
            r5[r2] = r1
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.b(r4, r5)
            r3.<init>(r1, r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfContentByte.k(com.itextpdf.text.Image, double, double, double, double, double, double, boolean, boolean):void");
    }

    public float k1() {
        return this.X2.f26159n;
    }

    public void k2(PdfSpotColor pdfSpotColor, float f2) {
        Y();
        this.X2.f26147b = this.Y.n0(pdfSpotColor);
        PdfName a2 = f1().a(this.X2.f26147b.a(), this.X2.f26147b.b());
        Y1(new SpotColor(pdfSpotColor, f2), true);
        this.s.n(a2.k()).k(" cs ").e(f2).k(" scn").r(this.a3);
    }

    public void k3(float f2) {
        if (!this.c3 && o1()) {
            S(true);
        }
        this.X2.f26159n = f2;
        this.s.e(f2).k(" Tw").r(this.a3);
    }

    public void l(Image image, float f2, float f4, float f5, float f6, float f7, float f8) throws DocumentException {
        m(image, f2, f4, f5, f6, f7, f8, false);
    }

    public void l0(float f2, float f4, float f5, float f6, float f7, float f8) {
        j0((double) f2, (double) f4, (double) f5, (double) f6, (double) f7, (double) f8);
    }

    public float l1() {
        return this.X2.f26149d;
    }

    public void l2(BaseColor baseColor) {
        switch (ExtendedColor.k(baseColor)) {
            case 1:
                v2(((GrayColor) baseColor).m());
                break;
            case 2:
                CMYKColor cMYKColor = (CMYKColor) baseColor;
                f2(cMYKColor.n(), cMYKColor.o(), cMYKColor.p(), cMYKColor.m());
                break;
            case 3:
                SpotColor spotColor = (SpotColor) baseColor;
                o2(spotColor.m(), spotColor.n());
                break;
            case 4:
                U2(((PatternColor) baseColor).m());
                break;
            case 5:
                d3(((ShadingColor) baseColor).m());
                break;
            case 6:
                DeviceNColor deviceNColor = (DeviceNColor) baseColor;
                m2(deviceNColor.m(), deviceNColor.n());
                break;
            case 7:
                LabColor labColor = (LabColor) baseColor;
                n2(labColor.p(), labColor.o(), labColor.m(), labColor.n());
                break;
            default:
                Z2(baseColor.g(), baseColor.e(), baseColor.d());
                break;
        }
        int c2 = baseColor.c();
        if (c2 < 255) {
            PdfGState pdfGState = new PdfGState();
            pdfGState.s1(((float) c2) / 255.0f);
            t2(pdfGState);
        }
    }

    public void l3(PdfTextArray pdfTextArray) {
        X();
        if (!this.c3 && o1()) {
            S(true);
        }
        if (this.X2.f26146a != null) {
            this.s.k("[");
            Iterator<Object> it2 = pdfTextArray.d().iterator();
            while (true) {
                boolean z = false;
                while (it2.hasNext()) {
                    Object next = it2.next();
                    if (next instanceof String) {
                        String str = (String) next;
                        n3(str);
                        y3(str, 0.0f);
                    } else {
                        if (z) {
                            this.s.c(' ');
                        } else {
                            z = true;
                        }
                        Float f2 = (Float) next;
                        this.s.e(f2.floatValue());
                        y3("", f2.floatValue());
                    }
                }
                this.s.k("]TJ").r(this.a3);
                return;
            }
        }
        throw new NullPointerException(MessageLocalization.b("font.and.size.must.be.set.before.writing.any.text", new Object[0]));
    }

    public void m(Image image, float f2, float f4, float f5, float f6, float f7, float f8, boolean z) throws DocumentException {
        j(image, (double) f2, (double) f4, (double) f5, (double) f6, (double) f7, (double) f8, z);
    }

    public void m0(AffineTransform affineTransform) {
        double[] dArr = new double[6];
        affineTransform.g(dArr);
        j0(dArr[0], dArr[1], dArr[2], dArr[3], dArr[4], dArr[5]);
    }

    public float m1() {
        return this.X2.f26150e;
    }

    public void m2(PdfDeviceNColor pdfDeviceNColor, float[] fArr) {
        Y();
        this.X2.f26147b = this.Y.n0(pdfDeviceNColor);
        PdfName a2 = f1().a(this.X2.f26147b.a(), this.X2.f26147b.b());
        Y1(new DeviceNColor(pdfDeviceNColor, fArr), true);
        this.s.n(a2.k()).k(" CS ");
        for (float f2 : fArr) {
            ByteBuffer byteBuffer = this.s;
            byteBuffer.k(f2 + StringUtils.SPACE);
        }
        this.s.k("SCN").r(this.a3);
    }

    public void m3(String str) {
        X();
        if (!this.c3 && o1()) {
            S(true);
        }
        n3(str);
        y3(str, 0.0f);
        this.s.k("Tj").r(this.a3);
    }

    public PdfAppearance n0(float f2, float f4) {
        return o0(f2, f4, (PdfName) null);
    }

    public void n1(PdfContentByte pdfContentByte) {
        this.X2 = pdfContentByte.X2;
        this.Y2 = pdfContentByte.Y2;
    }

    public void n2(PdfLabColor pdfLabColor, float f2, float f4, float f5) {
        Y();
        this.X2.f26147b = this.Y.n0(pdfLabColor);
        PdfName a2 = f1().a(this.X2.f26147b.a(), this.X2.f26147b.b());
        Y1(new LabColor(pdfLabColor, f2, f4, f5), true);
        this.s.n(a2.k()).k(" CS ");
        ByteBuffer byteBuffer = this.s;
        byteBuffer.k(f2 + StringUtils.SPACE + f4 + StringUtils.SPACE + f5 + StringUtils.SPACE);
        this.s.k("SCN").r(this.a3);
    }

    /* access modifiers changed from: package-private */
    public PdfAppearance o0(float f2, float f4, PdfName pdfName) {
        Y();
        PdfAppearance pdfAppearance = new PdfAppearance(this.Y);
        pdfAppearance.Z3(f2);
        pdfAppearance.V3(f4);
        this.Y.X(pdfAppearance, pdfName);
        return pdfAppearance;
    }

    public boolean o1() {
        PdfWriter pdfWriter = this.Y;
        return pdfWriter != null && pdfWriter.X1();
    }

    public void o2(PdfSpotColor pdfSpotColor, float f2) {
        Y();
        this.X2.f26147b = this.Y.n0(pdfSpotColor);
        PdfName a2 = f1().a(this.X2.f26147b.a(), this.X2.f26147b.b());
        Y1(new SpotColor(pdfSpotColor, f2), false);
        this.s.n(a2.k()).k(" CS ").e(f2).k(" SCN").r(this.a3);
    }

    public void o3(int i2, String str, float f2, float f4, float f5) {
        p3(i2, str, f2, f4, f5, false);
    }

    public void p(Image image, AffineTransform affineTransform) throws DocumentException {
        double[] dArr = new double[6];
        affineTransform.g(dArr);
        j(image, dArr[0], dArr[1], dArr[2], dArr[3], dArr[4], dArr[5], false);
    }

    public PdfPatternPainter p0(float f2, float f4) {
        return q0(f2, f4, f2, f4);
    }

    public void p1(double d2, double d4) {
        if (this.c3) {
            if (o1()) {
                L0();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.b("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        this.s.d(d2).c(' ').d(d4).k(" l").r(this.a3);
    }

    public void p2(PdfName pdfName, PdfObject pdfObject) {
        f1().c(pdfName, pdfObject);
    }

    public void q(Image image, boolean z) throws DocumentException {
        if (image.x1()) {
            float[] L1 = image.L1();
            L1[4] = image.D0() - L1[4];
            float E0 = image.E0() - L1[5];
            L1[5] = E0;
            m(image, L1[0], L1[1], L1[2], L1[3], L1[4], E0, z);
            return;
        }
        throw new DocumentException(MessageLocalization.b("the.image.must.have.absolute.positioning", new Object[0]));
    }

    public PdfPatternPainter q0(float f2, float f4, float f5, float f6) {
        Y();
        if (f5 == 0.0f || f6 == 0.0f) {
            throw new RuntimeException(MessageLocalization.b("xstep.or.ystep.can.not.be.zero", new Object[0]));
        }
        PdfPatternPainter pdfPatternPainter = new PdfPatternPainter(this.Y);
        pdfPatternPainter.Z3(f2);
        pdfPatternPainter.V3(f4);
        pdfPatternPainter.i4(f5);
        pdfPatternPainter.j4(f6);
        this.Y.q0(pdfPatternPainter);
        return pdfPatternPainter;
    }

    public void q1(float f2, float f4) {
        p1((double) f2, (double) f4);
    }

    public void q2(double d2) {
        if (d2 >= 0.0d && d2 <= 100.0d) {
            this.s.d(d2).k(" i").r(this.a3);
        }
    }

    public void q3(int i2, String str, float f2, float f4, float f5) {
        p3(i2, str, f2, f4, f5, true);
    }

    public PdfPatternPainter r0(float f2, float f4, float f5, float f6, BaseColor baseColor) {
        Y();
        if (f5 == 0.0f || f6 == 0.0f) {
            throw new RuntimeException(MessageLocalization.b("xstep.or.ystep.can.not.be.zero", new Object[0]));
        }
        PdfPatternPainter pdfPatternPainter = new PdfPatternPainter(this.Y, baseColor);
        pdfPatternPainter.Z3(f2);
        pdfPatternPainter.V3(f4);
        pdfPatternPainter.i4(f5);
        pdfPatternPainter.j4(f6);
        this.Y.q0(pdfPatternPainter);
        return pdfPatternPainter;
    }

    public boolean r1(String str, PdfDestination pdfDestination) {
        return this.Z.W0(str, pdfDestination);
    }

    public void r2(float f2) {
        q2((double) f2);
    }

    public void r3(String str) {
        X();
        if (!this.c3 && o1()) {
            S(true);
        }
        FontDetails fontDetails = this.X2.f26146a;
        if (fontDetails != null) {
            Object[] d2 = fontDetails.d(str);
            StringUtils.b((byte[]) d2[0], this.s);
            this.X2.f26155j += ((float) ((Integer) d2[2]).intValue()) * 0.001f * this.X2.f26148c;
            this.s.k("Tj").r(this.a3);
            return;
        }
        throw new NullPointerException(MessageLocalization.b("font.and.size.must.be.set.before.writing.any.text", new Object[0]));
    }

    public void s(PdfOutline pdfOutline, String str) {
        Y();
        this.Z.d0(pdfOutline, str);
    }

    public PdfPatternPainter s0(float f2, float f4, BaseColor baseColor) {
        return r0(f2, f4, f2, f4, baseColor);
    }

    public void s1(String str, float f2, float f4, float f5, float f6) {
        this.Z.X0(str, f2, f4, f5, f6);
    }

    public void s2(BaseFont baseFont, float f2) {
        if (!this.c3 && o1()) {
            S(true);
        }
        Y();
        if (f2 >= 1.0E-4f || f2 <= -1.0E-4f) {
            GraphicState graphicState = this.X2;
            graphicState.f26148c = f2;
            graphicState.f26146a = this.Y.o0(baseFont);
            this.s.n(f1().f(this.X2.f26146a.f(), this.X2.f26146a.h()).k()).c(' ').e(f2).k(" Tf").r(this.a3);
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.b("font.size.too.small.1", String.valueOf(f2)));
    }

    public void s3(String str) {
        FontDetails fontDetails = this.X2.f26146a;
        if (fontDetails != null) {
            BaseFont e2 = fontDetails.e();
            if (e2.c0()) {
                l3(b1(str, e2));
            } else {
                m3(str);
            }
        } else {
            throw new NullPointerException(MessageLocalization.b("font.and.size.must.be.set.before.writing.any.text", new Object[0]));
        }
    }

    public void t(PdfPSXObject pdfPSXObject) {
        if (this.c3 && o1()) {
            L0();
        }
        Y();
        this.s.n(f1().j(this.Y.X(pdfPSXObject, (PdfName) null), pdfPSXObject.J3()).k()).k(" Do").r(this.a3);
    }

    public PdfTemplate t0(float f2, float f4) {
        return u0(f2, f4, (PdfName) null);
    }

    public void t1(float f2, float f4) {
        if (!this.c3 && o1()) {
            S(true);
        }
        GraphicState graphicState = this.X2;
        graphicState.f26149d += f2;
        graphicState.f26150e += f4;
        if (o1()) {
            GraphicState graphicState2 = this.X2;
            float f5 = graphicState2.f26149d;
            if (f5 != graphicState2.f26155j) {
                f3(graphicState2.f26151f, graphicState2.f26152g, graphicState2.f26153h, graphicState2.f26154i, f5, graphicState2.f26150e);
                return;
            }
        }
        this.s.e(f2).c(' ').e(f4).k(" Td").r(this.a3);
    }

    public void t2(PdfGState pdfGState) {
        PdfObject[] p0 = this.Y.p0(pdfGState);
        PdfName e2 = f1().e((PdfName) p0[0], (PdfIndirectReference) p0[1]);
        this.X2.s = pdfGState;
        this.s.n(e2.k()).k(" gs").r(this.a3);
    }

    /* access modifiers changed from: package-private */
    public int t3() {
        return u3(true);
    }

    public String toString() {
        return this.s.toString();
    }

    public void u(PdfTemplate pdfTemplate, double d2, double d4) {
        v(pdfTemplate, 1.0d, 0.0d, 0.0d, 1.0d, d2, d4);
    }

    /* access modifiers changed from: package-private */
    public PdfTemplate u0(float f2, float f4, PdfName pdfName) {
        Y();
        PdfTemplate pdfTemplate = new PdfTemplate(this.Y);
        pdfTemplate.Z3(f2);
        pdfTemplate.V3(f4);
        this.Y.X(pdfTemplate, pdfName);
        return pdfTemplate;
    }

    public void u1(float f2, float f4) {
        if (!this.c3 && o1()) {
            S(true);
        }
        GraphicState graphicState = this.X2;
        graphicState.f26149d += f2;
        graphicState.f26150e += f4;
        graphicState.f26156k = -f4;
        if (o1()) {
            GraphicState graphicState2 = this.X2;
            float f5 = graphicState2.f26149d;
            if (f5 != graphicState2.f26155j) {
                f3(graphicState2.f26151f, graphicState2.f26152g, graphicState2.f26153h, graphicState2.f26154i, f5, graphicState2.f26150e);
                return;
            }
        }
        this.s.e(f2).c(' ').e(f4).k(" TD").r(this.a3);
    }

    public void u2(float f2) {
        Y1(new GrayColor(f2), true);
        this.s.e(f2).k(" g").r(this.a3);
    }

    /* access modifiers changed from: package-private */
    public int u3(boolean z) {
        return z ? this.s.C() : this.s.C() - this.X;
    }

    public void v(PdfTemplate pdfTemplate, double d2, double d4, double d5, double d6, double d7, double d8) {
        w(pdfTemplate, d2, d4, d5, d6, d7, d8, false);
    }

    public void v0(double d2, double d4, double d5, double d6) {
        if (this.c3) {
            if (o1()) {
                L0();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.b("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        this.s.d(d2).c(' ').d(d4).c(' ').d(d5).c(' ').d(d6).k(" y").r(this.a3);
    }

    public void v1(double d2, double d4) {
        if (this.c3) {
            if (o1()) {
                L0();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.b("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        this.s.d(d2).c(' ').d(d4).k(" m").r(this.a3);
    }

    public void v2(float f2) {
        Y1(new GrayColor(f2), false);
        this.s.e(f2).k(" G").r(this.a3);
    }

    public void v3() {
        if (this.c3) {
            if (o1()) {
                L0();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.b("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        PdfWriter.G0(this.Y, 1, this.X2.p);
        PdfWriter.G0(this.Y, 6, this.X2.s);
        this.s.k(ExifInterface.R4).r(this.a3);
    }

    public void w(PdfTemplate pdfTemplate, double d2, double d4, double d5, double d6, double d7, double d8, boolean z) {
        x(pdfTemplate, d2, d4, d5, d6, d7, d8, true, z);
    }

    public void w0(float f2, float f4, float f5, float f6) {
        v0((double) f2, (double) f4, (double) f5, (double) f6);
    }

    public void w1(float f2, float f4) {
        v1((double) f2, (double) f4);
    }

    public void w2(float f2) {
        if (!this.c3 && o1()) {
            S(true);
        }
        this.X2.f26157l = f2;
        this.s.e(f2).k(" Tz").r(this.a3);
    }

    public byte[] w3(PdfWriter pdfWriter) {
        X1();
        return this.s.F();
    }

    public void x0(double d2, double d4, double d5, double d6) {
        if (this.c3) {
            if (o1()) {
                L0();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.b("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        this.s.d(d2).c(' ').d(d4).c(' ').d(d5).c(' ').d(d6).k(" v").r(this.a3);
    }

    public void x1() {
        if (this.c3) {
            if (o1()) {
                L0();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.b("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        this.s.k("n").r(this.a3);
    }

    public void x2(float f2) {
        if (!this.c3 && o1()) {
            S(true);
        }
        this.X2.f26156k = f2;
        this.s.e(f2).k(" TL").r(this.a3);
    }

    public void x3(AffineTransform affineTransform) {
        if (this.c3 && o1()) {
            L0();
        }
        double[] dArr = new double[6];
        affineTransform.g(dArr);
        this.X2.r.a(affineTransform);
        this.s.d(dArr[0]).c(' ').d(dArr[1]).c(' ').d(dArr[2]).c(' ');
        this.s.d(dArr[3]).c(' ').d(dArr[4]).c(' ').d(dArr[5]).k(" cm").r(this.a3);
    }

    public void y(PdfTemplate pdfTemplate, double d2, double d4, boolean z) {
        w(pdfTemplate, 1.0d, 0.0d, 0.0d, 1.0d, d2, d4, z);
    }

    public void y0(double d2, double d4, double d5, double d6, double d7, double d8) {
        if (this.c3) {
            if (o1()) {
                L0();
            } else {
                throw new IllegalPdfSyntaxException(MessageLocalization.b("path.construction.operator.inside.text.object", new Object[0]));
            }
        }
        this.s.d(d2).c(' ').d(d4).c(' ').d(d5).c(' ').d(d6).c(' ').d(d7).c(' ').d(d8).k(" c").r(this.a3);
    }

    public void y1(float f2, float f4, String str) {
        X();
        if (!this.c3 && o1()) {
            S(true);
        }
        GraphicState graphicState = this.X2;
        graphicState.f26150e -= graphicState.f26156k;
        this.s.e(f2).c(' ').e(f4);
        n3(str);
        this.s.k("\"").r(this.a3);
        GraphicState graphicState2 = this.X2;
        graphicState2.f26158m = f4;
        graphicState2.f26159n = f2;
        graphicState2.f26155j = graphicState2.f26149d;
        y3(str, 0.0f);
    }

    public void y2(int i2) {
        if (i2 >= 0 && i2 <= 2) {
            this.s.f(i2).k(" J").r(this.a3);
        }
    }

    /* access modifiers changed from: protected */
    public void y3(String str, float f2) {
        this.X2.f26155j += X0(str, false, f2);
    }

    public void z(PdfTemplate pdfTemplate, float f2, float f4) {
        A(pdfTemplate, 1.0f, 0.0f, 0.0f, 1.0f, f2, f4);
    }

    public void z0(float f2, float f4, float f5, float f6) {
        x0((double) f2, (double) f4, (double) f5, (double) f6);
    }

    public void z1(String str) {
        X();
        if (!this.c3 && o1()) {
            S(true);
        }
        GraphicState graphicState = this.X2;
        graphicState.f26150e -= graphicState.f26156k;
        n3(str);
        this.s.k("'").r(this.a3);
        GraphicState graphicState2 = this.X2;
        graphicState2.f26155j = graphicState2.f26149d;
        y3(str, 0.0f);
    }

    public void z2(double d2) {
        this.s.k("[] ").d(d2).k(" d").r(this.a3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0129  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void z3(com.itextpdf.text.Rectangle r26) {
        /*
            r25 = this;
            r0 = r25
            float r1 = r26.T()
            float r2 = r26.H()
            float r3 = r26.Q()
            float r4 = r26.O()
            float r5 = r26.G()
            float r6 = r26.A()
            float r7 = r26.F()
            float r8 = r26.C()
            com.itextpdf.text.BaseColor r9 = r26.w()
            com.itextpdf.text.BaseColor r10 = r26.s()
            com.itextpdf.text.BaseColor r11 = r26.v()
            com.itextpdf.text.BaseColor r12 = r26.u()
            r25.a2()
            r13 = 0
            r0.y2(r13)
            r0.H2(r13)
            r14 = 1073741824(0x40000000, float:2.0)
            r16 = 0
            r17 = 0
            int r18 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
            if (r18 <= 0) goto L_0x0064
            r0.J2(r5)
            if (r9 != 0) goto L_0x004f
            r25.S1()
            goto L_0x0052
        L_0x004f:
            r0.l2(r9)
        L_0x0052:
            float r18 = r5 / r14
            float r13 = r1 - r18
            r0.w1(r4, r13)
            r0.q1(r3, r13)
            r25.v3()
            r13 = r5
            r15 = r9
            r18 = 1
            goto L_0x0069
        L_0x0064:
            r15 = r17
            r13 = 0
            r18 = 0
        L_0x0069:
            int r20 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
            if (r20 <= 0) goto L_0x0096
            int r20 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r20 == 0) goto L_0x0075
            r0.J2(r6)
            r13 = r6
        L_0x0075:
            if (r18 == 0) goto L_0x007d
            boolean r20 = r0.i0(r15, r10)
            if (r20 != 0) goto L_0x0089
        L_0x007d:
            if (r10 != 0) goto L_0x0083
            r25.S1()
            goto L_0x0086
        L_0x0083:
            r0.l2(r10)
        L_0x0086:
            r15 = r10
            r18 = 1
        L_0x0089:
            float r20 = r6 / r14
            float r14 = r2 + r20
            r0.w1(r3, r14)
            r0.q1(r4, r14)
            r25.v3()
        L_0x0096:
            int r14 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r14 <= 0) goto L_0x0122
            int r14 = (r7 > r13 ? 1 : (r7 == r13 ? 0 : -1))
            if (r14 == 0) goto L_0x00a2
            r0.J2(r7)
            r13 = r7
        L_0x00a2:
            if (r18 == 0) goto L_0x00aa
            boolean r14 = r0.i0(r15, r11)
            if (r14 != 0) goto L_0x00b6
        L_0x00aa:
            if (r11 != 0) goto L_0x00b0
            r25.S1()
            goto L_0x00b3
        L_0x00b0:
            r0.l2(r11)
        L_0x00b3:
            r15 = r11
            r18 = 1
        L_0x00b6:
            boolean r14 = r0.i0(r9, r11)
            boolean r20 = r0.i0(r10, r11)
            r21 = 1073741824(0x40000000, float:2.0)
            float r22 = r7 / r21
            r23 = r13
            float r13 = r3 - r22
            if (r14 == 0) goto L_0x00cc
            r24 = r15
            r15 = r1
            goto L_0x00d2
        L_0x00cc:
            float r22 = r1 - r5
            r24 = r15
            r15 = r22
        L_0x00d2:
            r0.w1(r13, r15)
            if (r20 == 0) goto L_0x00d9
            r15 = r2
            goto L_0x00db
        L_0x00d9:
            float r15 = r2 + r6
        L_0x00db:
            r0.q1(r13, r15)
            r25.v3()
            if (r14 == 0) goto L_0x00ef
            if (r20 != 0) goto L_0x00e6
            goto L_0x00ef
        L_0x00e6:
            r11 = r17
            r13 = r23
            r15 = r24
        L_0x00ec:
            r19 = 0
            goto L_0x0125
        L_0x00ef:
            if (r11 != 0) goto L_0x00f5
            r25.R1()
            goto L_0x00f8
        L_0x00f5:
            r0.h2(r11)
        L_0x00f8:
            if (r14 != 0) goto L_0x010a
            r0.w1(r3, r1)
            float r13 = r1 - r5
            r0.q1(r3, r13)
            float r14 = r3 - r7
            r0.q1(r14, r13)
            r25.Q0()
        L_0x010a:
            if (r20 != 0) goto L_0x011b
            r0.w1(r3, r2)
            float r13 = r2 + r6
            r0.q1(r3, r13)
            float r3 = r3 - r7
            r0.q1(r3, r13)
            r25.Q0()
        L_0x011b:
            r13 = r23
            r15 = r24
            r19 = 1
            goto L_0x0125
        L_0x0122:
            r11 = r17
            goto L_0x00ec
        L_0x0125:
            int r3 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r3 <= 0) goto L_0x0199
            int r3 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r3 == 0) goto L_0x0130
            r0.J2(r8)
        L_0x0130:
            if (r18 == 0) goto L_0x0138
            boolean r3 = r0.i0(r15, r12)
            if (r3 != 0) goto L_0x0141
        L_0x0138:
            if (r12 != 0) goto L_0x013e
            r25.S1()
            goto L_0x0141
        L_0x013e:
            r0.l2(r12)
        L_0x0141:
            boolean r3 = r0.i0(r9, r12)
            boolean r7 = r0.i0(r10, r12)
            r9 = 1073741824(0x40000000, float:2.0)
            float r9 = r8 / r9
            float r9 = r9 + r4
            if (r3 == 0) goto L_0x0152
            r10 = r1
            goto L_0x0154
        L_0x0152:
            float r10 = r1 - r5
        L_0x0154:
            r0.w1(r9, r10)
            if (r7 == 0) goto L_0x015b
            r10 = r2
            goto L_0x015d
        L_0x015b:
            float r10 = r2 + r6
        L_0x015d:
            r0.q1(r9, r10)
            r25.v3()
            if (r3 == 0) goto L_0x0167
            if (r7 != 0) goto L_0x0199
        L_0x0167:
            if (r19 == 0) goto L_0x016f
            boolean r9 = r0.i0(r11, r12)
            if (r9 != 0) goto L_0x0178
        L_0x016f:
            if (r12 != 0) goto L_0x0175
            r25.R1()
            goto L_0x0178
        L_0x0175:
            r0.h2(r12)
        L_0x0178:
            if (r3 != 0) goto L_0x0189
            r0.w1(r4, r1)
            float r1 = r1 - r5
            r0.q1(r4, r1)
            float r3 = r4 + r8
            r0.q1(r3, r1)
            r25.Q0()
        L_0x0189:
            if (r7 != 0) goto L_0x0199
            r0.w1(r4, r2)
            float r2 = r2 + r6
            r0.q1(r4, r2)
            float r4 = r4 + r8
            r0.q1(r4, r2)
            r25.Q0()
        L_0x0199:
            r25.U1()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfContentByte.z3(com.itextpdf.text.Rectangle):void");
    }
}
