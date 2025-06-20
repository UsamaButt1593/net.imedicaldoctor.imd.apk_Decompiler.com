package com.itextpdf.text.pdf;

import com.itextpdf.awt.geom.Point;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.BadPasswordException;
import com.itextpdf.text.log.Counter;
import com.itextpdf.text.log.CounterFactory;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.collection.PdfCollection;
import com.itextpdf.text.pdf.internal.PdfViewerPreferencesImp;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

class PdfStamperImp extends PdfWriter {
    HashMap<PdfReader, IntHashtable> V5 = new HashMap<>();
    HashMap<PdfReader, RandomAccessFileOrArray> W5 = new HashMap<>();
    protected RandomAccessFileOrArray X5;
    PdfReader Y5;
    IntHashtable Z5 = new IntHashtable();
    HashMap<PdfDictionary, PageStamp> a6 = new HashMap<>();
    protected boolean b6 = false;
    private boolean c6 = true;
    protected AcroFields d6;
    protected boolean e6 = false;
    protected boolean f6 = false;
    protected boolean g6 = false;
    protected int[] h6 = {0};
    protected HashSet<String> i6 = new HashSet<>();
    protected boolean j6 = false;
    protected PdfViewerPreferencesImp k6 = new PdfViewerPreferencesImp();
    protected HashSet<PdfTemplate> l6 = new HashSet<>();
    protected boolean m6 = false;
    protected int n6 = 0;
    protected boolean o6;
    protected IntHashtable p6;
    protected int q6;
    protected PdfAction r6;
    protected HashMap<Object, PdfObject> s6 = new HashMap<>();
    protected Counter t6 = CounterFactory.b(PdfStamper.class);
    private boolean u6 = false;
    private double[] v6 = {1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d};

    static class PageStamp {

        /* renamed from: a  reason: collision with root package name */
        PdfDictionary f26333a;

        /* renamed from: b  reason: collision with root package name */
        StampContent f26334b;

        /* renamed from: c  reason: collision with root package name */
        StampContent f26335c;

        /* renamed from: d  reason: collision with root package name */
        PageResources f26336d;

        /* renamed from: e  reason: collision with root package name */
        int f26337e = 0;

        PageStamp(PdfStamperImp pdfStamperImp, PdfReader pdfReader, PdfDictionary pdfDictionary) {
            this.f26333a = pdfDictionary;
            this.f26336d = new PageResources();
            this.f26336d.m(pdfDictionary.j0(PdfName.Wd), pdfStamperImp.h6);
        }
    }

    protected PdfStamperImp(PdfReader pdfReader, OutputStream outputStream, char c2, boolean z) throws DocumentException, IOException {
        super(new PdfDocument(), outputStream);
        if (!pdfReader.R0()) {
            throw new BadPasswordException(MessageLocalization.b("pdfreader.not.opened.with.owner.password", new Object[0]));
        } else if (!pdfReader.U0()) {
            pdfReader.H1(true);
            this.Y5 = pdfReader;
            this.X5 = pdfReader.B0();
            this.o6 = z;
            if (pdfReader.N0() && (z || PdfReader.K3)) {
                this.A3 = new PdfEncryption(pdfReader.L());
            }
            if (!z) {
                super.q(c2 == 0 ? pdfReader.z0() : c2);
            } else if (!pdfReader.S0()) {
                this.w3.f(true);
                if (c2 == 0) {
                    this.w3.q(pdfReader.z0());
                } else {
                    this.w3.q(c2);
                }
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = this.X5.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    this.Y.write(bArr, 0, read);
                }
                this.t3 = pdfReader.S();
                pdfReader.D1(true);
            } else {
                throw new DocumentException(MessageLocalization.b("append.mode.requires.a.document.without.errors.even.if.recovery.was.possible", new Object[0]));
            }
            if (pdfReader.T0()) {
                I2();
            }
            super.open();
            this.h3.i0(this);
            if (z) {
                this.k3.l(pdfReader.J0());
                this.p6 = new IntHashtable();
                if (pdfReader.Q0()) {
                    this.B3 = true;
                }
                if (pdfReader.O0()) {
                    this.B3 = false;
                }
            }
            this.q6 = pdfReader.J0();
            D3();
        } else {
            throw new DocumentException(MessageLocalization.b("the.original.document.was.reused.read.it.again.from.file", new Object[0]));
        }
    }

    private static void A3(PdfDictionary pdfDictionary, PdfReader pdfReader, int i2, PdfName pdfName, String str) {
        Rectangle E = pdfReader.E(i2, str);
        if (E == null) {
            pdfDictionary.a1(pdfName);
        } else {
            pdfDictionary.V0(pdfName, new PdfRectangle(E));
        }
    }

    private void B3(PRIndirectReference pRIndirectReference) {
        while (pRIndirectReference != null) {
            PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.w0(pRIndirectReference);
            PRIndirectReference pRIndirectReference2 = (PRIndirectReference) pdfDictionary.d0(PdfName.U7);
            if (pRIndirectReference2 != null) {
                B3(pRIndirectReference2);
            }
            PdfReader.W0(pdfDictionary.d0(PdfName.x6));
            PdfReader.W0(pdfDictionary.d0(PdfName.k3));
            PdfReader.W0(pRIndirectReference);
            pRIndirectReference = (PRIndirectReference) pdfDictionary.d0(PdfName.Ab);
        }
    }

    private Rectangle T3(Rectangle rectangle, double[] dArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        double[] dArr2 = dArr;
        Point U3 = U3((double) rectangle.O(), (double) rectangle.H(), dArr2);
        arrayList.add(Double.valueOf(U3.s));
        arrayList2.add(Double.valueOf(U3.X));
        Point U32 = U3((double) rectangle.Q(), (double) rectangle.T(), dArr2);
        arrayList.add(Double.valueOf(U32.s));
        arrayList2.add(Double.valueOf(U32.X));
        Point U33 = U3((double) rectangle.O(), (double) rectangle.T(), dArr2);
        arrayList.add(Double.valueOf(U33.s));
        arrayList2.add(Double.valueOf(U33.X));
        Point U34 = U3((double) rectangle.Q(), (double) rectangle.H(), dArr2);
        arrayList.add(Double.valueOf(U34.s));
        arrayList2.add(Double.valueOf(U34.X));
        return new Rectangle(((Double) Collections.min(arrayList)).floatValue(), ((Double) Collections.min(arrayList2)).floatValue(), ((Double) Collections.max(arrayList)).floatValue(), ((Double) Collections.max(arrayList2)).floatValue());
    }

    private Point U3(double d2, double d3, double[] dArr) {
        Point point = new Point();
        point.s = (dArr[0] * d2) + (dArr[2] * d3) + dArr[4];
        point.X = (dArr[1] * d2) + (dArr[3] * d3) + dArr[5];
        return point;
    }

    private void W2(PdfLayer pdfLayer, PdfArray pdfArray, Map<String, PdfLayer> map) {
        int i2 = 0;
        while (i2 < pdfArray.size()) {
            PdfObject T0 = pdfArray.T0(i2);
            if (T0.C()) {
                PdfLayer pdfLayer2 = map.get(T0.toString());
                if (pdfLayer2 != null) {
                    pdfLayer2.G1(true);
                    c2(pdfLayer2);
                    if (pdfLayer != null) {
                        pdfLayer.f1(pdfLayer2);
                    }
                    int i3 = i2 + 1;
                    if (pdfArray.size() > i3 && pdfArray.T0(i3).q()) {
                        W2(pdfLayer2, (PdfArray) pdfArray.T0(i3), map);
                        i2 = i3;
                    }
                }
            } else if (T0.q()) {
                PdfArray pdfArray2 = (PdfArray) T0;
                if (!pdfArray2.isEmpty()) {
                    PdfObject T02 = pdfArray2.T0(0);
                    if (T02.N()) {
                        PdfLayer pdfLayer3 = new PdfLayer(T02.toString());
                        pdfLayer3.G1(true);
                        c2(pdfLayer3);
                        if (pdfLayer != null) {
                            pdfLayer.f1(pdfLayer3);
                        }
                        PdfArray pdfArray3 = new PdfArray();
                        ListIterator<PdfObject> listIterator = pdfArray2.listIterator();
                        while (listIterator.hasNext()) {
                            pdfArray3.a0(listIterator.next());
                        }
                        W2(pdfLayer3, pdfArray3, map);
                    } else {
                        W2(pdfLayer, (PdfArray) T02, map);
                    }
                } else {
                    return;
                }
            } else {
                continue;
            }
            i2++;
        }
    }

    static void g3(PdfReader pdfReader, PdfObject pdfObject, IntHashtable intHashtable) {
        if (pdfObject != null) {
            int W = pdfObject.W();
            if (W == 5) {
                PdfArray pdfArray = (PdfArray) pdfObject;
                for (int i2 = 0; i2 < pdfArray.size(); i2++) {
                    g3(pdfReader, pdfArray.T0(i2), intHashtable);
                }
            } else if (W == 6 || W == 7) {
                PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
                for (PdfName d0 : pdfDictionary.G0()) {
                    g3(pdfReader, pdfDictionary.d0(d0), intHashtable);
                }
            } else if (W == 10) {
                PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
                if (pdfReader == pRIndirectReference.a0() && !intHashtable.c(pRIndirectReference.d())) {
                    intHashtable.l(pRIndirectReference.d(), 1);
                    g3(pdfReader, PdfReader.t0(pdfObject), intHashtable);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x019f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void k3(boolean r19) {
        /*
            r18 = this;
            r0 = r18
            boolean r1 = r0.o6
            r2 = 0
            if (r1 == 0) goto L_0x0023
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            if (r19 == 0) goto L_0x0017
            java.lang.String r3 = "freetext.flattening.is.not.supported.in.append.mode"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r3, r2)
            r1.<init>(r2)
            throw r1
        L_0x0017:
            java.lang.String r3 = "annotation.flattening.is.not.supported.in.append.mode"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r3, r2)
            r1.<init>(r2)
            throw r1
        L_0x0023:
            r1 = 1
            r3 = 1
        L_0x0025:
            com.itextpdf.text.pdf.PdfReader r4 = r0.Y5
            int r4 = r4.c0()
            if (r3 > r4) goto L_0x01b8
            com.itextpdf.text.pdf.PdfReader r4 = r0.Y5
            com.itextpdf.text.pdf.PdfDictionary r4 = r4.h0(r3)
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.Q3
            com.itextpdf.text.pdf.PdfArray r5 = r4.e0(r5)
            if (r5 != 0) goto L_0x003d
            goto L_0x01b4
        L_0x003d:
            r6 = 0
        L_0x003e:
            int r7 = r5.size()
            if (r6 >= r7) goto L_0x01a2
            com.itextpdf.text.pdf.PdfObject r7 = r5.Q0(r6)
            boolean r8 = r7 instanceof com.itextpdf.text.pdf.PdfIndirectReference
            if (r8 == 0) goto L_0x0054
            boolean r8 = r7.C()
            if (r8 != 0) goto L_0x0054
            goto L_0x019f
        L_0x0054:
            boolean r8 = r7 instanceof com.itextpdf.text.pdf.PdfDictionary
            if (r8 != 0) goto L_0x005a
            goto L_0x019f
        L_0x005a:
            com.itextpdf.text.pdf.PdfDictionary r7 = (com.itextpdf.text.pdf.PdfDictionary) r7
            com.itextpdf.text.pdf.PdfName r8 = com.itextpdf.text.pdf.PdfName.Cf
            com.itextpdf.text.pdf.PdfObject r8 = r7.d0(r8)
            if (r19 == 0) goto L_0x006e
            com.itextpdf.text.pdf.PdfName r9 = com.itextpdf.text.pdf.PdfName.z8
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x0078
            goto L_0x019f
        L_0x006e:
            com.itextpdf.text.pdf.PdfName r9 = com.itextpdf.text.pdf.PdfName.Ih
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x0078
            goto L_0x019f
        L_0x0078:
            com.itextpdf.text.pdf.PdfName r8 = com.itextpdf.text.pdf.PdfName.F7
            com.itextpdf.text.pdf.PdfNumber r8 = r7.q0(r8)
            if (r8 == 0) goto L_0x0085
            int r8 = r8.e0()
            goto L_0x0086
        L_0x0085:
            r8 = 0
        L_0x0086:
            r9 = r8 & 4
            if (r9 == 0) goto L_0x019f
            r8 = r8 & 2
            if (r8 != 0) goto L_0x019f
            com.itextpdf.text.pdf.PdfName r8 = com.itextpdf.text.pdf.PdfName.S3
            com.itextpdf.text.pdf.PdfObject r8 = r7.d0(r8)
            if (r8 != 0) goto L_0x0098
            goto L_0x019f
        L_0x0098:
            boolean r9 = r8 instanceof com.itextpdf.text.pdf.PdfIndirectReference
            if (r9 == 0) goto L_0x00a0
            com.itextpdf.text.pdf.PdfObject r8 = com.itextpdf.text.pdf.PdfReader.t0(r8)
        L_0x00a0:
            com.itextpdf.text.pdf.PdfDictionary r8 = (com.itextpdf.text.pdf.PdfDictionary) r8
            com.itextpdf.text.pdf.PdfName r9 = com.itextpdf.text.pdf.PdfName.kb
            com.itextpdf.text.pdf.PdfObject r10 = r8.d0(r9)
            com.itextpdf.text.pdf.PdfStream r9 = r8.x0(r9)
            com.itextpdf.text.pdf.PdfObject r11 = com.itextpdf.text.pdf.PdfReader.t0(r10)
            boolean r12 = r10 instanceof com.itextpdf.text.pdf.PdfIndirectReference
            if (r12 == 0) goto L_0x00c3
            boolean r12 = r10.C()
            if (r12 != 0) goto L_0x00c3
            com.itextpdf.text.pdf.PdfAppearance r8 = new com.itextpdf.text.pdf.PdfAppearance
            com.itextpdf.text.pdf.PdfIndirectReference r10 = (com.itextpdf.text.pdf.PdfIndirectReference) r10
            r8.<init>((com.itextpdf.text.pdf.PdfIndirectReference) r10)
        L_0x00c1:
            r11 = r8
            goto L_0x010c
        L_0x00c3:
            boolean r12 = r11 instanceof com.itextpdf.text.pdf.PdfStream
            if (r12 == 0) goto L_0x00d8
            com.itextpdf.text.pdf.PdfDictionary r11 = (com.itextpdf.text.pdf.PdfDictionary) r11
            com.itextpdf.text.pdf.PdfName r8 = com.itextpdf.text.pdf.PdfName.Cf
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.w8
            r11.V0(r8, r12)
            com.itextpdf.text.pdf.PdfAppearance r8 = new com.itextpdf.text.pdf.PdfAppearance
            com.itextpdf.text.pdf.PdfIndirectReference r10 = (com.itextpdf.text.pdf.PdfIndirectReference) r10
            r8.<init>((com.itextpdf.text.pdf.PdfIndirectReference) r10)
            goto L_0x00c1
        L_0x00d8:
            boolean r10 = r11.z()
            if (r10 == 0) goto L_0x010a
            com.itextpdf.text.pdf.PdfName r10 = com.itextpdf.text.pdf.PdfName.Z3
            com.itextpdf.text.pdf.PdfName r8 = r8.p0(r10)
            if (r8 == 0) goto L_0x010a
            com.itextpdf.text.pdf.PdfDictionary r11 = (com.itextpdf.text.pdf.PdfDictionary) r11
            com.itextpdf.text.pdf.PdfObject r8 = r11.d0(r8)
            com.itextpdf.text.pdf.PdfIndirectReference r8 = (com.itextpdf.text.pdf.PdfIndirectReference) r8
            if (r8 == 0) goto L_0x010a
            com.itextpdf.text.pdf.PdfAppearance r10 = new com.itextpdf.text.pdf.PdfAppearance
            r10.<init>((com.itextpdf.text.pdf.PdfIndirectReference) r8)
            boolean r11 = r8.C()
            if (r11 == 0) goto L_0x0108
            com.itextpdf.text.pdf.PdfObject r8 = com.itextpdf.text.pdf.PdfReader.t0(r8)
            com.itextpdf.text.pdf.PdfDictionary r8 = (com.itextpdf.text.pdf.PdfDictionary) r8
            com.itextpdf.text.pdf.PdfName r11 = com.itextpdf.text.pdf.PdfName.Cf
            com.itextpdf.text.pdf.PdfName r12 = com.itextpdf.text.pdf.PdfName.w8
            r8.V0(r11, r12)
        L_0x0108:
            r11 = r10
            goto L_0x010c
        L_0x010a:
            r8 = 0
            goto L_0x00c1
        L_0x010c:
            if (r11 == 0) goto L_0x019f
            com.itextpdf.text.pdf.PdfName r8 = com.itextpdf.text.pdf.PdfName.Nd
            com.itextpdf.text.pdf.PdfArray r7 = r7.e0(r8)
            com.itextpdf.text.Rectangle r7 = com.itextpdf.text.pdf.PdfReader.b0(r7)
            com.itextpdf.text.pdf.PdfName r8 = com.itextpdf.text.pdf.PdfName.n4
            com.itextpdf.text.pdf.PdfArray r8 = r9.e0(r8)
            com.itextpdf.text.Rectangle r8 = com.itextpdf.text.pdf.PdfReader.b0(r8)
            com.itextpdf.text.pdf.PdfContentByte r15 = r0.o3(r3)
            java.lang.String r10 = "Q "
            r15.M2(r10)
            com.itextpdf.text.pdf.PdfName r10 = com.itextpdf.text.pdf.PdfName.Qa
            com.itextpdf.text.pdf.PdfArray r12 = r9.e0(r10)
            if (r12 == 0) goto L_0x0174
            double[] r12 = r0.v6
            com.itextpdf.text.pdf.PdfArray r13 = r9.e0(r10)
            double[] r13 = r13.j0()
            boolean r12 = java.util.Arrays.equals(r12, r13)
            if (r12 != 0) goto L_0x0174
            com.itextpdf.text.pdf.PdfArray r9 = r9.e0(r10)
            double[] r9 = r9.j0()
            com.itextpdf.text.Rectangle r8 = r0.T3(r8, r9)
            float r9 = r7.a0()
            float r10 = r8.a0()
            float r12 = r9 / r10
            float r9 = r7.N()
            float r8 = r8.N()
            float r8 = r9 / r8
            float r16 = r7.O()
            float r17 = r7.H()
            r13 = 0
            r14 = 0
            r10 = r15
            r9 = r15
            r15 = r8
        L_0x0170:
            r10.A(r11, r12, r13, r14, r15, r16, r17)
            goto L_0x0195
        L_0x0174:
            r9 = r15
            float r10 = r7.a0()
            float r12 = r8.a0()
            float r12 = r10 / r12
            float r10 = r7.N()
            float r8 = r8.N()
            float r15 = r10 / r8
            float r16 = r7.O()
            float r17 = r7.H()
            r13 = 0
            r14 = 0
            r10 = r9
            goto L_0x0170
        L_0x0195:
            java.lang.String r7 = "q "
            r9.M2(r7)
            r5.U0(r6)
            int r6 = r6 + -1
        L_0x019f:
            int r6 = r6 + r1
            goto L_0x003e
        L_0x01a2:
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x01b4
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.Q3
            com.itextpdf.text.pdf.PdfObject r6 = r4.d0(r5)
            com.itextpdf.text.pdf.PdfReader.W0(r6)
            r4.a1(r5)
        L_0x01b4:
            int r3 = r3 + 1
            goto L_0x0025
        L_0x01b8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfStamperImp.k3(boolean):void");
    }

    private PdfArray m3(PdfDictionary pdfDictionary) {
        PdfArray e0 = pdfDictionary.e0(PdfName.ia);
        return e0 != null ? m3(e0.B0(e0.size() - 1)) : pdfDictionary.e0(PdfName.sb);
    }

    public void A(PdfTransition pdfTransition) {
        throw new UnsupportedOperationException(MessageLocalization.b("use.setpageaction.pdfname.actiontype.pdfaction.action.int.page", new Object[0]));
    }

    public PdfIndirectReference A1(int i2) {
        PRIndirectReference j0 = this.Y5.j0(i2);
        if (j0 != null) {
            return j0;
        }
        throw new IllegalArgumentException(MessageLocalization.a("invalid.page.number.1", i2));
    }

    /* access modifiers changed from: package-private */
    public boolean C3(String str) {
        l3();
        if (this.d6.I().z()) {
            throw new UnsupportedOperationException(MessageLocalization.b("partial.form.flattening.is.not.supported.with.xfa.forms", new Object[0]));
        } else if (!this.d6.t().containsKey(str)) {
            return false;
        } else {
            this.i6.add(str);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void D3() {
        PdfArray e0 = this.Y5.F().e0(PdfName.rc);
        if (e0 != null && e0.size() > 0) {
            PdfStream pdfStream = null;
            int i2 = 0;
            while (i2 < e0.size() && ((r3 = e0.B0(i2)) == null || (pdfStream = r3.x0(PdfName.y6)) == null)) {
                i2++;
            }
            if (pdfStream instanceof PRStream) {
                try {
                    this.l3 = ICC_Profile.d(PdfReader.D0((PRStream) pdfStream));
                } catch (IOException e2) {
                    throw new ExceptionConverter(e2);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void E3() {
        PdfDictionary j0;
        if (this.U3.isEmpty() && (j0 = this.Y5.F().j0(PdfName.Tb)) != null) {
            PdfArray e0 = j0.e0(PdfName.Rb);
            HashMap hashMap = new HashMap();
            ListIterator<PdfObject> listIterator = e0.listIterator();
            while (listIterator.hasNext()) {
                PdfIndirectReference pdfIndirectReference = (PdfIndirectReference) listIterator.next();
                PdfLayer pdfLayer = new PdfLayer((String) null);
                pdfLayer.K1(pdfIndirectReference);
                pdfLayer.G1(false);
                pdfLayer.T0((PdfDictionary) PdfReader.t0(pdfIndirectReference));
                hashMap.put(pdfIndirectReference.toString(), pdfLayer);
            }
            PdfDictionary j02 = j0.j0(PdfName.f6);
            PdfArray e02 = j02.e0(PdfName.Yb);
            if (e02 != null) {
                ListIterator<PdfObject> listIterator2 = e02.listIterator();
                while (listIterator2.hasNext()) {
                    ((PdfLayer) hashMap.get(((PdfIndirectReference) listIterator2.next()).toString())).E1(false);
                }
            }
            PdfArray e03 = j02.e0(PdfName.jc);
            if (e03 != null) {
                W2((PdfLayer) null, e03, hashMap);
            }
            this.U3.addAll(hashMap.values());
            PdfArray e04 = j02.e0(PdfName.Id);
            this.X3 = e04;
            if (e04 == null) {
                this.X3 = new PdfArray();
            }
            PdfArray e05 = j02.e0(PdfName.Ia);
            this.Y3 = e05;
            if (e05 == null) {
                this.Y3 = new PdfArray();
            }
        }
    }

    public void F3(PdfReader pdfReader, boolean z) throws IOException {
        if (!this.V5.containsKey(pdfReader)) {
            this.V5.put(pdfReader, new IntHashtable());
            if (z) {
                RandomAccessFileOrArray B0 = pdfReader.B0();
                this.W5.put(pdfReader, B0);
                B0.g();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public RandomAccessFileOrArray G1(PdfReader pdfReader) {
        if (this.V5.containsKey(pdfReader)) {
            RandomAccessFileOrArray randomAccessFileOrArray = this.W5.get(pdfReader);
            return randomAccessFileOrArray != null ? randomAccessFileOrArray : pdfReader.B0();
        }
        PdfReaderInstance pdfReaderInstance = this.I3;
        return pdfReaderInstance == null ? this.X5 : pdfReaderInstance.e();
    }

    /* access modifiers changed from: package-private */
    public void G3(PdfReader pdfReader, int i2, int i3) {
        PdfDictionary h0 = this.Y5.h0(i3);
        if (!this.a6.containsKey(h0)) {
            PdfImportedPage m1 = m1(pdfReader, i2);
            PdfDictionary i0 = this.Y5.i0(i3);
            i0.a1(PdfName.Wd);
            i0.a1(PdfName.N5);
            A3(i0, pdfReader, i2, PdfName.Za, "media");
            A3(i0, pdfReader, i2, PdfName.Z5, "crop");
            A3(i0, pdfReader, i2, PdfName.zg, "trim");
            A3(i0, pdfReader, i2, PdfName.W3, "art");
            A3(i0, pdfReader, i2, PdfName.A4, "bleed");
            i0.V0(PdfName.te, new PdfNumber(pdfReader.m0(i2)));
            o3(i3).z(m1, 0.0f, 0.0f);
            PageStamp pageStamp = this.a6.get(h0);
            pageStamp.f26337e = pageStamp.f26335c.a1().C();
            return;
        }
        throw new IllegalStateException(MessageLocalization.b("this.page.cannot.be.replaced.new.content.was.already.added", new Object[0]));
    }

    /* access modifiers changed from: package-private */
    public void H3(int i2, int i3) {
        PdfDictionary h0 = this.Y5.h0(i3);
        if (i2 < 0) {
            h0.a1(PdfName.W6);
        } else {
            h0.V0(PdfName.W6, new PdfNumber(i2));
        }
        z3(h0);
    }

    public void I3(boolean z) {
        this.g6 = z;
    }

    /* access modifiers changed from: package-private */
    public void J3(boolean z) {
        this.e6 = z;
    }

    public void K2(Image image) {
        throw new UnsupportedOperationException(MessageLocalization.b("use.pdfstamper.setthumbnail", new Object[0]));
    }

    /* access modifiers changed from: package-private */
    public void K3(boolean z) {
        this.f6 = z;
    }

    /* access modifiers changed from: protected */
    public void L3() throws IOException {
        HashMap<String, PdfObject> y0 = this.h3.y0();
        if (!y0.isEmpty()) {
            PdfDictionary F = this.Y5.F();
            PdfName pdfName = PdfName.sb;
            PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.u0(F.d0(pdfName), F);
            if (pdfDictionary == null) {
                pdfDictionary = new PdfDictionary();
                F.V0(pdfName, pdfDictionary);
                z3(F);
            }
            z3(pdfDictionary);
            pdfDictionary.V0(PdfName.aa, v0(PdfNameTree.c(y0, this)).a());
        }
    }

    /* access modifiers changed from: protected */
    public void M3() throws IOException {
        if (this.v3 != null) {
            d3();
            if (!this.v3.isEmpty()) {
                PdfDictionary F = this.Y5.F();
                Q2(F, F.d0(PdfName.z6) != null);
                z3(F);
            }
        }
    }

    public void N0() {
        try {
            this.y3 = P0((ByteArrayOutputStream) null, this.Y5.P());
            this.x3 = null;
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void N3(PdfName pdfName, PdfAction pdfAction, int i2) throws PdfException {
        if (pdfName.equals(PdfWriter.L5) || pdfName.equals(PdfWriter.M5)) {
            PdfDictionary h0 = this.Y5.h0(i2);
            PdfName pdfName2 = PdfName.m3;
            PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.u0(h0.d0(pdfName2), h0);
            if (pdfDictionary == null) {
                pdfDictionary = new PdfDictionary();
                h0.V0(pdfName2, pdfDictionary);
                z3(h0);
            }
            pdfDictionary.V0(pdfName, pdfAction);
            z3(pdfDictionary);
            return;
        }
        throw new PdfException(MessageLocalization.b("invalid.page.additional.action.type.1", pdfName.toString()));
    }

    /* access modifiers changed from: package-private */
    public void O3(boolean z) {
        this.c6 = z;
    }

    /* access modifiers changed from: package-private */
    public void P3(Image image, int i2) throws PdfException, DocumentException {
        PdfIndirectReference l1 = l1(V(image));
        this.Y5.z1();
        this.Y5.h0(i2).V0(PdfName.Zf, l1);
        this.Y5.z1();
    }

    /* access modifiers changed from: package-private */
    public void Q3(PdfTransition pdfTransition, int i2) {
        PdfDictionary h0 = this.Y5.h0(i2);
        if (pdfTransition == null) {
            h0.a1(PdfName.sg);
        } else {
            h0.V0(PdfName.sg, pdfTransition.b());
        }
        z3(h0);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009f A[Catch:{ IOException -> 0x001e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void R2(com.itextpdf.text.pdf.PdfAnnotation r11, com.itextpdf.text.pdf.PdfDictionary r12) {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ IOException -> 0x001e }
            r0.<init>()     // Catch:{ IOException -> 0x001e }
            boolean r1 = r11.W1()     // Catch:{ IOException -> 0x001e }
            if (r1 == 0) goto L_0x0021
            r1 = 1
            r10.m6 = r1     // Catch:{ IOException -> 0x001e }
            r10.l3()     // Catch:{ IOException -> 0x001e }
            com.itextpdf.text.pdf.PdfFormField r11 = (com.itextpdf.text.pdf.PdfFormField) r11     // Catch:{ IOException -> 0x001e }
            com.itextpdf.text.pdf.PdfFormField r1 = r11.a3()     // Catch:{ IOException -> 0x001e }
            if (r1 == 0) goto L_0x001a
            return
        L_0x001a:
            r10.f3(r11, r0)     // Catch:{ IOException -> 0x001e }
            goto L_0x0024
        L_0x001e:
            r11 = move-exception
            goto L_0x0165
        L_0x0021:
            r0.add(r11)     // Catch:{ IOException -> 0x001e }
        L_0x0024:
            r11 = 0
        L_0x0025:
            int r1 = r0.size()     // Catch:{ IOException -> 0x001e }
            if (r11 >= r1) goto L_0x0164
            java.lang.Object r1 = r0.get(r11)     // Catch:{ IOException -> 0x001e }
            com.itextpdf.text.pdf.PdfAnnotation r1 = (com.itextpdf.text.pdf.PdfAnnotation) r1     // Catch:{ IOException -> 0x001e }
            int r2 = r1.P1()     // Catch:{ IOException -> 0x001e }
            if (r2 <= 0) goto L_0x0041
            com.itextpdf.text.pdf.PdfReader r12 = r10.Y5     // Catch:{ IOException -> 0x001e }
            int r2 = r1.P1()     // Catch:{ IOException -> 0x001e }
            com.itextpdf.text.pdf.PdfDictionary r12 = r12.h0(r2)     // Catch:{ IOException -> 0x001e }
        L_0x0041:
            boolean r2 = r1.W1()     // Catch:{ IOException -> 0x001e }
            if (r2 == 0) goto L_0x0068
            boolean r2 = r1.X1()     // Catch:{ IOException -> 0x001e }
            if (r2 != 0) goto L_0x0058
            java.util.HashSet r2 = r1.Q1()     // Catch:{ IOException -> 0x001e }
            if (r2 == 0) goto L_0x0058
            java.util.HashSet<com.itextpdf.text.pdf.PdfTemplate> r3 = r10.l6     // Catch:{ IOException -> 0x001e }
            r3.addAll(r2)     // Catch:{ IOException -> 0x001e }
        L_0x0058:
            r2 = r1
            com.itextpdf.text.pdf.PdfFormField r2 = (com.itextpdf.text.pdf.PdfFormField) r2     // Catch:{ IOException -> 0x001e }
            com.itextpdf.text.pdf.PdfFormField r3 = r2.a3()     // Catch:{ IOException -> 0x001e }
            if (r3 != 0) goto L_0x0068
            com.itextpdf.text.pdf.PdfIndirectReference r2 = r2.L1()     // Catch:{ IOException -> 0x001e }
            r10.T2(r2)     // Catch:{ IOException -> 0x001e }
        L_0x0068:
            boolean r2 = r1.V1()     // Catch:{ IOException -> 0x001e }
            if (r2 == 0) goto L_0x0150
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.Q3     // Catch:{ IOException -> 0x001e }
            com.itextpdf.text.pdf.PdfObject r3 = r12.d0(r2)     // Catch:{ IOException -> 0x001e }
            com.itextpdf.text.pdf.PdfObject r3 = com.itextpdf.text.pdf.PdfReader.u0(r3, r12)     // Catch:{ IOException -> 0x001e }
            if (r3 == 0) goto L_0x0084
            boolean r4 = r3.q()     // Catch:{ IOException -> 0x001e }
            if (r4 != 0) goto L_0x0081
            goto L_0x0084
        L_0x0081:
            com.itextpdf.text.pdf.PdfArray r3 = (com.itextpdf.text.pdf.PdfArray) r3     // Catch:{ IOException -> 0x001e }
            goto L_0x008f
        L_0x0084:
            com.itextpdf.text.pdf.PdfArray r3 = new com.itextpdf.text.pdf.PdfArray     // Catch:{ IOException -> 0x001e }
            r3.<init>()     // Catch:{ IOException -> 0x001e }
            r12.V0(r2, r3)     // Catch:{ IOException -> 0x001e }
            r10.z3(r12)     // Catch:{ IOException -> 0x001e }
        L_0x008f:
            com.itextpdf.text.pdf.PdfIndirectReference r2 = r1.L1()     // Catch:{ IOException -> 0x001e }
            r3.a0(r2)     // Catch:{ IOException -> 0x001e }
            r10.z3(r3)     // Catch:{ IOException -> 0x001e }
            boolean r2 = r1.X1()     // Catch:{ IOException -> 0x001e }
            if (r2 != 0) goto L_0x0150
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.Nd     // Catch:{ IOException -> 0x001e }
            com.itextpdf.text.pdf.PdfObject r3 = r1.d0(r2)     // Catch:{ IOException -> 0x001e }
            com.itextpdf.text.pdf.PdfRectangle r3 = (com.itextpdf.text.pdf.PdfRectangle) r3     // Catch:{ IOException -> 0x001e }
            if (r3 == 0) goto L_0x0150
            float r4 = r3.i1()     // Catch:{ IOException -> 0x001e }
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 != 0) goto L_0x00ca
            float r4 = r3.n1()     // Catch:{ IOException -> 0x001e }
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 != 0) goto L_0x00ca
            float r4 = r3.q1()     // Catch:{ IOException -> 0x001e }
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 != 0) goto L_0x00ca
            float r4 = r3.X0()     // Catch:{ IOException -> 0x001e }
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 == 0) goto L_0x0150
        L_0x00ca:
            com.itextpdf.text.pdf.PdfReader r4 = r10.Y5     // Catch:{ IOException -> 0x001e }
            int r4 = r4.n0(r12)     // Catch:{ IOException -> 0x001e }
            com.itextpdf.text.pdf.PdfReader r5 = r10.Y5     // Catch:{ IOException -> 0x001e }
            com.itextpdf.text.Rectangle r5 = r5.r0(r12)     // Catch:{ IOException -> 0x001e }
            r6 = 90
            if (r4 == r6) goto L_0x0130
            r6 = 180(0xb4, float:2.52E-43)
            if (r4 == r6) goto L_0x0106
            r6 = 270(0x10e, float:3.78E-43)
            if (r4 == r6) goto L_0x00e3
            goto L_0x0150
        L_0x00e3:
            com.itextpdf.text.pdf.PdfRectangle r4 = new com.itextpdf.text.pdf.PdfRectangle     // Catch:{ IOException -> 0x001e }
            float r6 = r3.X0()     // Catch:{ IOException -> 0x001e }
            float r7 = r5.Q()     // Catch:{ IOException -> 0x001e }
            float r8 = r3.i1()     // Catch:{ IOException -> 0x001e }
            float r7 = r7 - r8
            float r8 = r3.q1()     // Catch:{ IOException -> 0x001e }
            float r5 = r5.Q()     // Catch:{ IOException -> 0x001e }
            float r3 = r3.n1()     // Catch:{ IOException -> 0x001e }
            float r5 = r5 - r3
            r4.<init>(r6, r7, r8, r5)     // Catch:{ IOException -> 0x001e }
        L_0x0102:
            r1.V0(r2, r4)     // Catch:{ IOException -> 0x001e }
            goto L_0x0150
        L_0x0106:
            com.itextpdf.text.pdf.PdfRectangle r4 = new com.itextpdf.text.pdf.PdfRectangle     // Catch:{ IOException -> 0x001e }
            float r6 = r5.Q()     // Catch:{ IOException -> 0x001e }
            float r7 = r3.i1()     // Catch:{ IOException -> 0x001e }
            float r6 = r6 - r7
            float r7 = r5.T()     // Catch:{ IOException -> 0x001e }
            float r8 = r3.X0()     // Catch:{ IOException -> 0x001e }
            float r7 = r7 - r8
            float r8 = r5.Q()     // Catch:{ IOException -> 0x001e }
            float r9 = r3.n1()     // Catch:{ IOException -> 0x001e }
            float r8 = r8 - r9
            float r5 = r5.T()     // Catch:{ IOException -> 0x001e }
            float r3 = r3.q1()     // Catch:{ IOException -> 0x001e }
            float r5 = r5 - r3
            r4.<init>(r6, r7, r8, r5)     // Catch:{ IOException -> 0x001e }
            goto L_0x0102
        L_0x0130:
            com.itextpdf.text.pdf.PdfRectangle r4 = new com.itextpdf.text.pdf.PdfRectangle     // Catch:{ IOException -> 0x001e }
            float r6 = r5.T()     // Catch:{ IOException -> 0x001e }
            float r7 = r3.q1()     // Catch:{ IOException -> 0x001e }
            float r6 = r6 - r7
            float r7 = r3.n1()     // Catch:{ IOException -> 0x001e }
            float r5 = r5.T()     // Catch:{ IOException -> 0x001e }
            float r8 = r3.X0()     // Catch:{ IOException -> 0x001e }
            float r5 = r5 - r8
            float r3 = r3.i1()     // Catch:{ IOException -> 0x001e }
            r4.<init>(r6, r7, r5, r3)     // Catch:{ IOException -> 0x001e }
            goto L_0x0102
        L_0x0150:
            boolean r2 = r1.X1()     // Catch:{ IOException -> 0x001e }
            if (r2 != 0) goto L_0x0160
            r1.K2()     // Catch:{ IOException -> 0x001e }
            com.itextpdf.text.pdf.PdfIndirectReference r2 = r1.L1()     // Catch:{ IOException -> 0x001e }
            r10.y0(r1, r2)     // Catch:{ IOException -> 0x001e }
        L_0x0160:
            int r11 = r11 + 1
            goto L_0x0025
        L_0x0164:
            return
        L_0x0165:
            com.itextpdf.text.ExceptionConverter r12 = new com.itextpdf.text.ExceptionConverter
            r12.<init>(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfStamperImp.R2(com.itextpdf.text.pdf.PdfAnnotation, com.itextpdf.text.pdf.PdfDictionary):void");
    }

    /* access modifiers changed from: protected */
    public void R3() {
        this.Y5.I1(this.k6);
        z3(this.Y5.I0().d0(PdfName.se));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00cb, code lost:
        r6 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00cb, code lost:
        r6 = r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void S2(com.itextpdf.text.pdf.FdfReader r13) throws java.io.IOException {
        /*
            r12 = this;
            java.util.HashMap<com.itextpdf.text.pdf.PdfReader, com.itextpdf.text.pdf.IntHashtable> r0 = r12.V5
            boolean r0 = r0.containsKey(r13)
            if (r0 == 0) goto L_0x0009
            return
        L_0x0009:
            com.itextpdf.text.pdf.PdfDictionary r0 = r13.F()
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.K7
            com.itextpdf.text.pdf.PdfDictionary r0 = r0.j0(r1)
            if (r0 != 0) goto L_0x0016
            return
        L_0x0016:
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Q3
            com.itextpdf.text.pdf.PdfArray r0 = r0.e0(r1)
            if (r0 == 0) goto L_0x011b
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0026
            goto L_0x011b
        L_0x0026:
            r1 = 0
            r12.F3(r13, r1)
            com.itextpdf.text.pdf.IntHashtable r2 = new com.itextpdf.text.pdf.IntHashtable
            r2.<init>()
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r5 = 0
        L_0x003a:
            int r6 = r0.size()
            r7 = 3
            if (r5 >= r6) goto L_0x008a
            com.itextpdf.text.pdf.PdfObject r6 = r0.T0(r5)
            com.itextpdf.text.pdf.PdfObject r8 = com.itextpdf.text.pdf.PdfReader.t0(r6)
            com.itextpdf.text.pdf.PdfDictionary r8 = (com.itextpdf.text.pdf.PdfDictionary) r8
            com.itextpdf.text.pdf.PdfName r9 = com.itextpdf.text.pdf.PdfName.uc
            com.itextpdf.text.pdf.PdfNumber r9 = r8.q0(r9)
            if (r9 == 0) goto L_0x0087
            int r9 = r9.e0()
            com.itextpdf.text.pdf.PdfReader r10 = r12.Y5
            int r10 = r10.c0()
            if (r9 < r10) goto L_0x0060
            goto L_0x0087
        L_0x0060:
            g3(r13, r6, r2)
            r4.add(r6)
            int r9 = r6.W()
            r10 = 10
            if (r9 != r10) goto L_0x0087
            com.itextpdf.text.pdf.PdfName r9 = com.itextpdf.text.pdf.PdfName.Cb
            com.itextpdf.text.pdf.PdfObject r8 = r8.d0(r9)
            com.itextpdf.text.pdf.PdfObject r8 = com.itextpdf.text.pdf.PdfReader.t0(r8)
            if (r8 == 0) goto L_0x0087
            int r9 = r8.W()
            if (r9 != r7) goto L_0x0087
            java.lang.String r7 = r8.toString()
            r3.put(r7, r6)
        L_0x0087:
            int r5 = r5 + 1
            goto L_0x003a
        L_0x008a:
            int[] r0 = r2.g()
            r2 = 0
        L_0x008f:
            int r5 = r0.length
            if (r2 >= r5) goto L_0x00d5
            r5 = r0[r2]
            com.itextpdf.text.pdf.PdfObject r6 = r13.s0(r5)
            int r8 = r6.W()
            r9 = 6
            if (r8 != r9) goto L_0x00cb
            r8 = r6
            com.itextpdf.text.pdf.PdfDictionary r8 = (com.itextpdf.text.pdf.PdfDictionary) r8
            com.itextpdf.text.pdf.PdfName r9 = com.itextpdf.text.pdf.PdfName.W9
            com.itextpdf.text.pdf.PdfObject r10 = r8.d0(r9)
            com.itextpdf.text.pdf.PdfObject r10 = com.itextpdf.text.pdf.PdfReader.t0(r10)
            if (r10 == 0) goto L_0x00cb
            int r11 = r10.W()
            if (r11 != r7) goto L_0x00cb
            java.lang.String r10 = r10.toString()
            java.lang.Object r10 = r3.get(r10)
            com.itextpdf.text.pdf.PdfObject r10 = (com.itextpdf.text.pdf.PdfObject) r10
            if (r10 == 0) goto L_0x00cb
            com.itextpdf.text.pdf.PdfDictionary r6 = new com.itextpdf.text.pdf.PdfDictionary
            r6.<init>()
            r6.T0(r8)
            r6.V0(r9, r10)
        L_0x00cb:
            int r5 = r12.s1(r13, r5, r1)
            r12.w0(r6, r5)
            int r2 = r2 + 1
            goto L_0x008f
        L_0x00d5:
            int r13 = r4.size()
            if (r1 >= r13) goto L_0x011b
            java.lang.Object r13 = r4.get(r1)
            com.itextpdf.text.pdf.PdfObject r13 = (com.itextpdf.text.pdf.PdfObject) r13
            com.itextpdf.text.pdf.PdfObject r0 = com.itextpdf.text.pdf.PdfReader.t0(r13)
            com.itextpdf.text.pdf.PdfDictionary r0 = (com.itextpdf.text.pdf.PdfDictionary) r0
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.uc
            com.itextpdf.text.pdf.PdfNumber r0 = r0.q0(r2)
            com.itextpdf.text.pdf.PdfReader r2 = r12.Y5
            int r0 = r0.e0()
            int r0 = r0 + 1
            com.itextpdf.text.pdf.PdfDictionary r0 = r2.h0(r0)
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.Q3
            com.itextpdf.text.pdf.PdfObject r3 = r0.d0(r2)
            com.itextpdf.text.pdf.PdfObject r3 = com.itextpdf.text.pdf.PdfReader.u0(r3, r0)
            com.itextpdf.text.pdf.PdfArray r3 = (com.itextpdf.text.pdf.PdfArray) r3
            if (r3 != 0) goto L_0x0112
            com.itextpdf.text.pdf.PdfArray r3 = new com.itextpdf.text.pdf.PdfArray
            r3.<init>()
            r0.V0(r2, r3)
            r12.z3(r0)
        L_0x0112:
            r12.z3(r3)
            r3.a0(r13)
            int r1 = r1 + 1
            goto L_0x00d5
        L_0x011b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfStamperImp.S2(com.itextpdf.text.pdf.FdfReader):void");
    }

    /* access modifiers changed from: package-private */
    public void S3(PdfObject pdfObject) {
        PdfArray pdfArray;
        PdfObject W0 = PdfReader.W0(pdfObject);
        if (W0 != null && W0.z() && (pdfArray = (PdfArray) PdfReader.W0(((PdfDictionary) W0).d0(PdfName.ia))) != null) {
            for (int i2 = 0; i2 < pdfArray.size(); i2++) {
                S3(pdfArray.T0(i2));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void T2(PdfIndirectReference pdfIndirectReference) {
        PdfDictionary F = this.Y5.F();
        PdfName pdfName = PdfName.p3;
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.u0(F.d0(pdfName), F);
        if (pdfDictionary == null) {
            pdfDictionary = new PdfDictionary();
            F.V0(pdfName, pdfDictionary);
            z3(F);
        }
        PdfName pdfName2 = PdfName.P7;
        PdfArray pdfArray = (PdfArray) PdfReader.u0(pdfDictionary.d0(pdfName2), pdfDictionary);
        if (pdfArray == null) {
            pdfArray = new PdfArray();
            pdfDictionary.V0(pdfName2, pdfArray);
            z3(pdfDictionary);
        }
        PdfName pdfName3 = PdfName.g6;
        if (!pdfDictionary.a0(pdfName3)) {
            pdfDictionary.V0(pdfName3, new PdfString("/Helv 0 Tf 0 g "));
            z3(pdfDictionary);
        }
        pdfArray.a0(pdfIndirectReference);
        z3(pdfArray);
    }

    /* access modifiers changed from: package-private */
    public void U(PdfAnnotation pdfAnnotation, int i2) {
        if (pdfAnnotation.V1()) {
            pdfAnnotation.E2(i2);
        }
        R2(pdfAnnotation, this.Y5.h0(i2));
    }

    /* access modifiers changed from: protected */
    public void U2() throws IOException {
        if (!this.l6.isEmpty()) {
            PdfDictionary F = this.Y5.F();
            PdfName pdfName = PdfName.p3;
            PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.u0(F.d0(pdfName), F);
            if (pdfDictionary == null) {
                pdfDictionary = new PdfDictionary();
                F.V0(pdfName, pdfDictionary);
                z3(F);
            }
            PdfName pdfName2 = PdfName.T6;
            PdfDictionary pdfDictionary2 = (PdfDictionary) PdfReader.u0(pdfDictionary.d0(pdfName2), pdfDictionary);
            if (pdfDictionary2 == null) {
                pdfDictionary2 = new PdfDictionary();
                pdfDictionary.V0(pdfName2, pdfDictionary2);
                z3(pdfDictionary);
            }
            z3(pdfDictionary2);
            Iterator<PdfTemplate> it2 = this.l6.iterator();
            while (it2.hasNext()) {
                PdfFormField.c3(pdfDictionary2, (PdfDictionary) it2.next().N3(), this);
            }
            PdfName pdfName3 = PdfName.l8;
            PdfDictionary j0 = pdfDictionary2.j0(pdfName3);
            if (j0 == null) {
                j0 = new PdfDictionary();
                pdfDictionary2.V0(pdfName3, j0);
            }
            PdfName pdfName4 = PdfName.i9;
            if (!j0.a0(pdfName4)) {
                PdfDictionary pdfDictionary3 = new PdfDictionary(pdfName3);
                pdfDictionary3.V0(PdfName.l4, PdfName.j9);
                pdfDictionary3.V0(PdfName.m7, PdfName.Mh);
                pdfDictionary3.V0(PdfName.qb, pdfName4);
                pdfDictionary3.V0(PdfName.Cf, PdfName.Mg);
                j0.V0(pdfName4, v0(pdfDictionary3).a());
            }
            PdfName pdfName5 = PdfName.hi;
            if (!j0.a0(pdfName5)) {
                PdfDictionary pdfDictionary4 = new PdfDictionary(pdfName3);
                pdfDictionary4.V0(PdfName.l4, PdfName.ii);
                pdfDictionary4.V0(PdfName.qb, pdfName5);
                pdfDictionary4.V0(PdfName.Cf, PdfName.Mg);
                j0.V0(pdfName5, v0(pdfDictionary4).a());
            }
            PdfName pdfName6 = PdfName.g6;
            if (pdfDictionary.d0(pdfName6) == null) {
                pdfDictionary.V0(pdfName6, new PdfString("/Helv 0 Tf 0 g "));
                z3(pdfDictionary);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void V2() throws IOException {
        HashMap<String, PdfObject> x0 = this.h3.x0();
        if (!x0.isEmpty()) {
            PdfDictionary F = this.Y5.F();
            PdfName pdfName = PdfName.sb;
            PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.u0(F.d0(pdfName), F);
            if (pdfDictionary == null) {
                pdfDictionary = new PdfDictionary();
                F.V0(pdfName, pdfDictionary);
                z3(F);
            }
            z3(pdfDictionary);
            HashMap<String, PdfObject> b2 = PdfNameTree.b((PdfDictionary) PdfReader.w0(pdfDictionary.d0(PdfName.j7)));
            for (Map.Entry next : x0.entrySet()) {
                StringBuilder sb = new StringBuilder((String) next.getKey());
                int i2 = 0;
                while (b2.containsKey(sb.toString())) {
                    i2++;
                    sb.append(StringUtils.SPACE);
                    sb.append(i2);
                }
                b2.put(sb.toString(), next.getValue());
            }
            PdfDictionary c2 = PdfNameTree.c(b2, this);
            PdfName pdfName2 = PdfName.j7;
            PdfObject d0 = pdfDictionary.d0(pdfName2);
            if (d0 != null) {
                PdfReader.W0(d0);
            }
            pdfDictionary.V0(pdfName2, v0(c2).a());
        }
    }

    public void V3(PdfReader pdfReader) {
        if (this.V5.containsKey(pdfReader)) {
            this.V5.remove(pdfReader);
            RandomAccessFileOrArray randomAccessFileOrArray = this.W5.get(pdfReader);
            if (randomAccessFileOrArray != null) {
                this.W5.remove(pdfReader);
                try {
                    randomAccessFileOrArray.close();
                } catch (Exception unused) {
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void W3() throws IOException {
        PdfDictionary F = this.Y5.F();
        PdfName pdfName = PdfName.sb;
        PdfDictionary j0 = F.j0(pdfName);
        if (j0 != null) {
            j0 = j0.j0(PdfName.z6);
        }
        if (j0 == null) {
            j0 = this.Y5.F().j0(PdfName.z6);
        }
        if (j0 == null) {
            j0 = new PdfDictionary();
            PdfDictionary pdfDictionary = new PdfDictionary();
            j0.V0(pdfName, new PdfArray());
            pdfDictionary.V0(PdfName.z6, j0);
            this.Y5.F().V0(pdfName, pdfDictionary);
        }
        PdfArray m3 = m3(j0);
        for (Object next : this.s6.keySet()) {
            m3.a0(new PdfString(next.toString()));
            m3.a0(y0(this.s6.get(next), D1()).a());
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00f1 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void X2() throws java.io.IOException {
        /*
            r10 = this;
            java.util.HashMap<com.itextpdf.text.pdf.PdfDictionary, com.itextpdf.text.pdf.PdfStamperImp$PageStamp> r0 = r10.a6
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
        L_0x000a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00f6
            java.lang.Object r1 = r0.next()
            com.itextpdf.text.pdf.PdfStamperImp$PageStamp r1 = (com.itextpdf.text.pdf.PdfStamperImp.PageStamp) r1
            com.itextpdf.text.pdf.PdfDictionary r2 = r1.f26333a
            r10.z3(r2)
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.N5
            com.itextpdf.text.pdf.PdfObject r4 = r2.d0(r3)
            com.itextpdf.text.pdf.PdfObject r4 = com.itextpdf.text.pdf.PdfReader.u0(r4, r2)
            if (r4 != 0) goto L_0x0030
            com.itextpdf.text.pdf.PdfArray r4 = new com.itextpdf.text.pdf.PdfArray
            r4.<init>()
        L_0x002c:
            r2.V0(r3, r4)
            goto L_0x005b
        L_0x0030:
            boolean r5 = r4.q()
            if (r5 == 0) goto L_0x0042
            com.itextpdf.text.pdf.PdfArray r5 = new com.itextpdf.text.pdf.PdfArray
            com.itextpdf.text.pdf.PdfArray r4 = (com.itextpdf.text.pdf.PdfArray) r4
            r5.<init>((com.itextpdf.text.pdf.PdfArray) r4)
            r2.V0(r3, r5)
            r4 = r5
            goto L_0x005b
        L_0x0042:
            boolean r4 = r4.K()
            if (r4 == 0) goto L_0x0055
            com.itextpdf.text.pdf.PdfArray r4 = new com.itextpdf.text.pdf.PdfArray
            r4.<init>()
            com.itextpdf.text.pdf.PdfObject r5 = r2.d0(r3)
            r4.a0(r5)
            goto L_0x002c
        L_0x0055:
            com.itextpdf.text.pdf.PdfArray r4 = new com.itextpdf.text.pdf.PdfArray
            r4.<init>()
            goto L_0x002c
        L_0x005b:
            com.itextpdf.text.pdf.ByteBuffer r3 = new com.itextpdf.text.pdf.ByteBuffer
            r3.<init>()
            com.itextpdf.text.pdf.StampContent r5 = r1.f26334b
            if (r5 == 0) goto L_0x007a
            byte[] r5 = com.itextpdf.text.pdf.PdfContents.E3
            r3.n(r5)
            r10.Z2(r2, r3)
            com.itextpdf.text.pdf.StampContent r5 = r1.f26334b
            com.itextpdf.text.pdf.ByteBuffer r5 = r5.a1()
            r3.i(r5)
            byte[] r5 = com.itextpdf.text.pdf.PdfContents.F3
            r3.n(r5)
        L_0x007a:
            com.itextpdf.text.pdf.StampContent r5 = r1.f26335c
            if (r5 == 0) goto L_0x0083
            byte[] r5 = com.itextpdf.text.pdf.PdfContents.E3
            r3.n(r5)
        L_0x0083:
            com.itextpdf.text.pdf.PdfStream r5 = new com.itextpdf.text.pdf.PdfStream
            byte[] r6 = r3.F()
            r5.<init>(r6)
            int r6 = r10.C3
            r5.i1(r6)
            com.itextpdf.text.pdf.PdfIndirectObject r5 = r10.v0(r5)
            com.itextpdf.text.pdf.PdfIndirectReference r5 = r5.a()
            r4.i0(r5)
            r3.x()
            com.itextpdf.text.pdf.StampContent r5 = r1.f26335c
            if (r5 == 0) goto L_0x00f1
            r5 = 32
            r3.c(r5)
            byte[] r5 = com.itextpdf.text.pdf.PdfContents.F3
            r3.n(r5)
            com.itextpdf.text.pdf.StampContent r6 = r1.f26335c
            com.itextpdf.text.pdf.ByteBuffer r6 = r6.a1()
            byte[] r7 = r6.w()
            r8 = 0
            int r9 = r1.f26337e
            r3.p(r7, r8, r9)
            byte[] r7 = com.itextpdf.text.pdf.PdfContents.E3
            r3.n(r7)
            r10.Z2(r2, r3)
            byte[] r2 = r6.w()
            int r7 = r1.f26337e
            int r6 = r6.C()
            int r8 = r1.f26337e
            int r6 = r6 - r8
            r3.p(r2, r7, r6)
            r3.n(r5)
            com.itextpdf.text.pdf.PdfStream r2 = new com.itextpdf.text.pdf.PdfStream
            byte[] r3 = r3.F()
            r2.<init>(r3)
            int r3 = r10.C3
            r2.i1(r3)
            com.itextpdf.text.pdf.PdfIndirectObject r2 = r10.v0(r2)
            com.itextpdf.text.pdf.PdfIndirectReference r2 = r2.a()
            r4.a0(r2)
        L_0x00f1:
            r10.Y2(r1)
            goto L_0x000a
        L_0x00f6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfStamperImp.X2():void");
    }

    /* access modifiers changed from: package-private */
    public void Y2(PageStamp pageStamp) {
        pageStamp.f26333a.V0(PdfName.Wd, pageStamp.f26336d.k());
    }

    /* access modifiers changed from: package-private */
    public void Z2(PdfDictionary pdfDictionary, ByteBuffer byteBuffer) {
        if (this.c6) {
            Rectangle r0 = this.Y5.r0(pdfDictionary);
            int S = r0.S();
            if (S == 90) {
                byteBuffer.n(PdfContents.G3);
                byteBuffer.e(r0.T());
                byteBuffer.c(' ').c('0').n(PdfContents.J3);
            } else if (S == 180) {
                byteBuffer.n(PdfContents.H3);
                byteBuffer.e(r0.Q());
                byteBuffer.c(' ');
                byteBuffer.e(r0.T());
                byteBuffer.n(PdfContents.J3);
            } else if (S == 270) {
                byteBuffer.n(PdfContents.I3);
                byteBuffer.c('0').c(' ');
                byteBuffer.e(r0.Q());
                byteBuffer.n(PdfContents.J3);
            }
        }
    }

    public void a(int i2) {
        this.j6 = true;
        this.k6.a(i2);
    }

    /* access modifiers changed from: protected */
    public void a3(PdfIndirectReference pdfIndirectReference, int i2) throws IOException {
        PdfIndirectReference pdfIndirectReference2;
        PdfObject pdfObject;
        int i3 = i2;
        X2();
        int d2 = ((PRIndirectReference) this.Y5.a3.d0(PdfName.se)).d();
        if (this.o6) {
            int[] g2 = this.p6.g();
            for (int i4 = 0; i4 < g2.length; i4++) {
                int i5 = g2[i4];
                PdfObject v0 = this.Y5.v0(i5);
                if (!(v0 == null || i3 == i5 || i5 >= this.q6)) {
                    z0(v0, v0.m(), i5 != d2);
                }
            }
            for (int i7 = this.q6; i7 < this.Y5.J0(); i7++) {
                PdfObject s0 = this.Y5.s0(i7);
                if (s0 != null) {
                    w0(s0, s1(this.Y5, i7, 0));
                }
            }
        } else {
            int i8 = 1;
            while (i8 < this.Y5.J0()) {
                PdfObject v02 = this.Y5.v0(i8);
                if (!(v02 == null || i3 == i8)) {
                    x0(v02, s1(this.Y5, i8, 0), i8 != d2);
                }
                i8++;
            }
        }
        PdfEncryption pdfEncryption = this.A3;
        if (pdfEncryption != null) {
            pdfIndirectReference2 = this.o6 ? this.Y5.K() : A0(pdfEncryption.l(), false).a();
            pdfObject = this.A3.n(true);
        } else {
            PdfArray e0 = this.Y5.a3.e0(PdfName.A9);
            pdfIndirectReference2 = null;
            pdfObject = (e0 == null || e0.P0(0) == null) ? PdfEncryption.g(PdfEncryption.f(), true) : PdfEncryption.g(e0.P0(0).k(), true);
        }
        PdfIndirectReference pdfIndirectReference3 = new PdfIndirectReference(0, s1(this.Y5, ((PRIndirectReference) this.Y5.a3.d0(PdfName.se)).d(), 0));
        this.k3.p(this.Y, pdfIndirectReference3, pdfIndirectReference, pdfIndirectReference2, pdfObject, this.t3);
        if (this.B3) {
            PdfWriter.P2(this.Y);
            this.Y.write(DocWriter.E("startxref\n"));
            this.Y.write(DocWriter.E(String.valueOf(this.k3.k())));
            this.Y.write(DocWriter.E("\n%%EOF\n"));
        } else {
            new PdfWriter.PdfTrailer(this.k3.m(), this.k3.k(), pdfIndirectReference3, pdfIndirectReference, pdfIndirectReference2, pdfObject, this.t3).T(this, this.Y);
        }
        this.Y.flush();
        if (F()) {
            this.Y.close();
        }
        b1().c(this.Y.b());
    }

    /* access modifiers changed from: protected */
    public Counter b1() {
        return this.t6;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0298 A[Catch:{ XMPException -> 0x02d7, IOException -> 0x02d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02de  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x032d  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0234  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0243  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0248  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x024a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b3(java.util.Map<java.lang.String, java.lang.String> r13) throws java.io.IOException {
        /*
            r12 = this;
            boolean r0 = r12.b6
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            boolean r0 = r12.j6
            if (r0 == 0) goto L_0x000c
            r12.R3()
        L_0x000c:
            boolean r0 = r12.e6
            if (r0 == 0) goto L_0x0013
            r12.h3()
        L_0x0013:
            boolean r0 = r12.f6
            if (r0 == 0) goto L_0x001a
            r12.i3()
        L_0x001a:
            boolean r0 = r12.g6
            if (r0 == 0) goto L_0x0021
            r12.j3()
        L_0x0021:
            r12.U2()
            com.itextpdf.text.pdf.PdfReader r0 = r12.Y5
            com.itextpdf.text.pdf.PdfDictionary r0 = r0.F()
            com.itextpdf.text.pdf.internal.PdfVersionImp r1 = r12.F1()
            r1.a(r0)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.p3
            com.itextpdf.text.pdf.PdfObject r1 = r0.d0(r1)
            com.itextpdf.text.pdf.PdfReader r2 = r12.Y5
            com.itextpdf.text.pdf.PdfDictionary r2 = r2.F()
            com.itextpdf.text.pdf.PdfObject r1 = com.itextpdf.text.pdf.PdfReader.u0(r1, r2)
            com.itextpdf.text.pdf.PdfDictionary r1 = (com.itextpdf.text.pdf.PdfDictionary) r1
            com.itextpdf.text.pdf.AcroFields r2 = r12.d6
            if (r2 == 0) goto L_0x0061
            com.itextpdf.text.pdf.XfaForm r2 = r2.I()
            boolean r2 = r2.y()
            if (r2 == 0) goto L_0x0061
            r12.z3(r1)
            boolean r2 = r12.e6
            if (r2 != 0) goto L_0x0061
            com.itextpdf.text.pdf.AcroFields r2 = r12.d6
            com.itextpdf.text.pdf.XfaForm r2 = r2.I()
            r2.I(r12)
        L_0x0061:
            int r2 = r12.n6
            if (r2 == 0) goto L_0x0077
            if (r1 == 0) goto L_0x0077
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.Re
            com.itextpdf.text.pdf.PdfNumber r4 = new com.itextpdf.text.pdf.PdfNumber
            r4.<init>((int) r2)
            r1.V0(r3, r4)
            r12.z3(r1)
            r12.z3(r0)
        L_0x0077:
            r1 = 1
            r12.b6 = r1
            r12.m0()
            r12.M3()
            r12.L3()
            r12.V2()
            com.itextpdf.text.pdf.PdfDictionary r1 = r12.m3
            if (r1 == 0) goto L_0x008d
            r0.U0(r1)
        L_0x008d:
            com.itextpdf.text.pdf.PdfAction r1 = r12.r6
            if (r1 == 0) goto L_0x0096
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.cc
            r0.V0(r2, r1)
        L_0x0096:
            com.itextpdf.text.pdf.PdfDocument r1 = r12.h3
            com.itextpdf.text.pdf.PdfPageLabels r1 = r1.V3
            if (r1 == 0) goto L_0x00a5
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.wc
            com.itextpdf.text.pdf.PdfDictionary r1 = r1.f(r12)
            r0.V0(r2, r1)
        L_0x00a5:
            java.util.LinkedHashSet<com.itextpdf.text.pdf.PdfOCG> r1 = r12.U3
            boolean r1 = r1.isEmpty()
            r2 = 0
            if (r1 != 0) goto L_0x0122
            r12.R0(r2)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Tb
            com.itextpdf.text.pdf.PdfDictionary r3 = r0.j0(r1)
            if (r3 != 0) goto L_0x00c5
            com.itextpdf.text.pdf.PdfReader r3 = r12.Y5
            com.itextpdf.text.pdf.PdfDictionary r3 = r3.F()
            com.itextpdf.text.pdf.PdfOCProperties r4 = r12.W3
            r3.V0(r1, r4)
            goto L_0x011c
        L_0x00c5:
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Rb
            com.itextpdf.text.pdf.PdfOCProperties r4 = r12.W3
            com.itextpdf.text.pdf.PdfObject r4 = r4.d0(r1)
            r3.V0(r1, r4)
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.f6
            com.itextpdf.text.pdf.PdfDictionary r4 = r3.j0(r1)
            if (r4 != 0) goto L_0x00e0
            com.itextpdf.text.pdf.PdfDictionary r4 = new com.itextpdf.text.pdf.PdfDictionary
            r4.<init>()
            r3.V0(r1, r4)
        L_0x00e0:
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.jc
            com.itextpdf.text.pdf.PdfOCProperties r5 = r12.W3
            com.itextpdf.text.pdf.PdfDictionary r5 = r5.j0(r1)
            com.itextpdf.text.pdf.PdfObject r5 = r5.d0(r3)
            r4.V0(r3, r5)
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.Id
            com.itextpdf.text.pdf.PdfOCProperties r5 = r12.W3
            com.itextpdf.text.pdf.PdfDictionary r5 = r5.j0(r1)
            com.itextpdf.text.pdf.PdfObject r5 = r5.d0(r3)
            r4.V0(r3, r5)
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.Yb
            com.itextpdf.text.pdf.PdfOCProperties r5 = r12.W3
            com.itextpdf.text.pdf.PdfDictionary r5 = r5.j0(r1)
            com.itextpdf.text.pdf.PdfObject r5 = r5.d0(r3)
            r4.V0(r3, r5)
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.Z3
            com.itextpdf.text.pdf.PdfOCProperties r5 = r12.W3
            com.itextpdf.text.pdf.PdfDictionary r1 = r5.j0(r1)
            com.itextpdf.text.pdf.PdfObject r1 = r1.d0(r3)
            r4.V0(r3, r1)
        L_0x011c:
            r1 = 7
            com.itextpdf.text.pdf.PdfOCProperties r3 = r12.W3
            com.itextpdf.text.pdf.PdfWriter.G0(r12, r1, r3)
        L_0x0122:
            com.itextpdf.text.pdf.PdfReader r1 = r12.Y5
            com.itextpdf.text.pdf.PdfDictionary r1 = r1.I0()
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.O9
            com.itextpdf.text.pdf.PdfIndirectReference r1 = r1.m0(r3)
            r4 = -1
            if (r1 == 0) goto L_0x0136
            int r5 = r1.d()
            goto L_0x0137
        L_0x0136:
            r5 = -1
        L_0x0137:
            com.itextpdf.text.pdf.PdfReader r6 = r12.Y5
            com.itextpdf.text.pdf.PdfDictionary r6 = r6.I0()
            com.itextpdf.text.pdf.PdfDictionary r3 = r6.j0(r3)
            r6 = 0
            if (r3 == 0) goto L_0x0155
            com.itextpdf.text.pdf.PdfName r7 = com.itextpdf.text.pdf.PdfName.sd
            com.itextpdf.text.pdf.PdfObject r8 = r3.d0(r7)
            if (r8 == 0) goto L_0x0155
            com.itextpdf.text.pdf.PdfString r7 = r3.A0(r7)
            java.lang.String r7 = r7.m0()
            goto L_0x0156
        L_0x0155:
            r7 = r6
        L_0x0156:
            com.itextpdf.text.Version r8 = com.itextpdf.text.Version.a()
            if (r7 == 0) goto L_0x0193
            java.lang.String r9 = r8.e()
            java.lang.String r10 = r8.c()
            int r9 = r9.indexOf(r10)
            if (r9 != r4) goto L_0x016b
            goto L_0x0193
        L_0x016b:
            java.lang.String r9 = "; modified using"
            int r9 = r7.indexOf(r9)
            if (r9 != r4) goto L_0x0179
            java.lang.StringBuffer r4 = new java.lang.StringBuffer
            r4.<init>(r7)
            goto L_0x0182
        L_0x0179:
            java.lang.StringBuffer r4 = new java.lang.StringBuffer
            java.lang.String r7 = r7.substring(r2, r9)
            r4.<init>(r7)
        L_0x0182:
            java.lang.String r7 = "; modified using "
            r4.append(r7)
            java.lang.String r7 = r8.e()
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            goto L_0x0197
        L_0x0193:
            java.lang.String r4 = r8.e()
        L_0x0197:
            com.itextpdf.text.pdf.PdfDictionary r7 = new com.itextpdf.text.pdf.PdfDictionary
            r7.<init>()
            if (r3 == 0) goto L_0x01be
            java.util.Set r8 = r3.G0()
            java.util.Iterator r8 = r8.iterator()
        L_0x01a6:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x01be
            java.lang.Object r9 = r8.next()
            com.itextpdf.text.pdf.PdfName r9 = (com.itextpdf.text.pdf.PdfName) r9
            com.itextpdf.text.pdf.PdfObject r10 = r3.d0(r9)
            com.itextpdf.text.pdf.PdfObject r10 = com.itextpdf.text.pdf.PdfReader.t0(r10)
            r7.V0(r9, r10)
            goto L_0x01a6
        L_0x01be:
            java.lang.String r3 = "UnicodeBig"
            if (r13 == 0) goto L_0x01f6
            java.util.Set r8 = r13.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x01ca:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x01f6
            java.lang.Object r9 = r8.next()
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            java.lang.Object r10 = r9.getKey()
            java.lang.String r10 = (java.lang.String) r10
            com.itextpdf.text.pdf.PdfName r11 = new com.itextpdf.text.pdf.PdfName
            r11.<init>((java.lang.String) r10)
            java.lang.Object r9 = r9.getValue()
            java.lang.String r9 = (java.lang.String) r9
            if (r9 != 0) goto L_0x01ed
            r7.a1(r11)
            goto L_0x01ca
        L_0x01ed:
            com.itextpdf.text.pdf.PdfString r10 = new com.itextpdf.text.pdf.PdfString
            r10.<init>(r9, r3)
            r7.V0(r11, r10)
            goto L_0x01ca
        L_0x01f6:
            com.itextpdf.text.pdf.PdfDate r8 = new com.itextpdf.text.pdf.PdfDate
            r8.<init>()
            com.itextpdf.text.pdf.PdfName r9 = com.itextpdf.text.pdf.PdfName.ib
            r7.V0(r9, r8)
            com.itextpdf.text.pdf.PdfName r9 = com.itextpdf.text.pdf.PdfName.sd
            com.itextpdf.text.pdf.PdfString r10 = new com.itextpdf.text.pdf.PdfString
            r10.<init>(r4, r3)
            r7.V0(r9, r10)
            boolean r3 = r12.o6
            if (r3 == 0) goto L_0x0210
            if (r1 != 0) goto L_0x0219
        L_0x0210:
            com.itextpdf.text.pdf.PdfIndirectObject r1 = r12.A0(r7, r2)
        L_0x0214:
            com.itextpdf.text.pdf.PdfIndirectReference r1 = r1.a()
            goto L_0x0222
        L_0x0219:
            int r1 = r1.d()
            com.itextpdf.text.pdf.PdfIndirectObject r1 = r12.x0(r7, r1, r2)
            goto L_0x0214
        L_0x0222:
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.db
            com.itextpdf.text.pdf.PdfObject r3 = r0.d0(r2)
            com.itextpdf.text.pdf.PdfObject r3 = com.itextpdf.text.pdf.PdfReader.t0(r3)
            if (r3 == 0) goto L_0x0243
            boolean r9 = r3.K()
            if (r9 == 0) goto L_0x0243
            r9 = r3
            com.itextpdf.text.pdf.PRStream r9 = (com.itextpdf.text.pdf.PRStream) r9
            byte[] r9 = com.itextpdf.text.pdf.PdfReader.F0(r9)
            com.itextpdf.text.pdf.PdfObject r2 = r0.d0(r2)
            com.itextpdf.text.pdf.PdfReader.W0(r2)
            goto L_0x0244
        L_0x0243:
            r9 = r6
        L_0x0244:
            byte[] r2 = r12.x3
            if (r2 == 0) goto L_0x024a
            r9 = r2
            goto L_0x028d
        L_0x024a:
            com.itextpdf.text.xml.xmp.XmpWriter r2 = r12.y3
            if (r2 == 0) goto L_0x028d
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ XMPException -> 0x028b }
            r2.<init>()     // Catch:{ XMPException -> 0x028b }
            com.itextpdf.text.xml.xmp.XmpWriter r10 = r12.y3     // Catch:{ XMPException -> 0x028b }
            com.itextpdf.xmp.XMPMeta r10 = r10.h()     // Catch:{ XMPException -> 0x028b }
            com.itextpdf.text.xml.xmp.PdfProperties.b(r10, r4)     // Catch:{ XMPException -> 0x028b }
            com.itextpdf.text.xml.xmp.XmpWriter r10 = r12.y3     // Catch:{ XMPException -> 0x028b }
            com.itextpdf.xmp.XMPMeta r10 = r10.h()     // Catch:{ XMPException -> 0x028b }
            java.lang.String r11 = r8.q0()     // Catch:{ XMPException -> 0x028b }
            com.itextpdf.text.xml.xmp.XmpBasicProperties.e(r10, r11)     // Catch:{ XMPException -> 0x028b }
            com.itextpdf.text.xml.xmp.XmpWriter r10 = r12.y3     // Catch:{ XMPException -> 0x028b }
            com.itextpdf.xmp.XMPMeta r10 = r10.h()     // Catch:{ XMPException -> 0x028b }
            java.lang.String r11 = r8.q0()     // Catch:{ XMPException -> 0x028b }
            com.itextpdf.text.xml.xmp.XmpBasicProperties.d(r10, r11)     // Catch:{ XMPException -> 0x028b }
            com.itextpdf.text.xml.xmp.XmpWriter r10 = r12.y3     // Catch:{ XMPException -> 0x028b }
            r10.i(r2)     // Catch:{ XMPException -> 0x028b }
            com.itextpdf.text.xml.xmp.XmpWriter r10 = r12.y3     // Catch:{ XMPException -> 0x028b }
            r10.g()     // Catch:{ XMPException -> 0x028b }
            com.itextpdf.text.pdf.PdfStream r10 = new com.itextpdf.text.pdf.PdfStream     // Catch:{ XMPException -> 0x028b }
            byte[] r2 = r2.toByteArray()     // Catch:{ XMPException -> 0x028b }
            r10.<init>(r2)     // Catch:{ XMPException -> 0x028b }
            r6 = r10
            goto L_0x028d
        L_0x028b:
            r12.y3 = r6
        L_0x028d:
            if (r6 != 0) goto L_0x02dc
            if (r9 == 0) goto L_0x02dc
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ XMPException -> 0x02d7, IOException -> 0x02d1 }
            r2.<init>()     // Catch:{ XMPException -> 0x02d7, IOException -> 0x02d1 }
            if (r13 == 0) goto L_0x02a5
            byte[] r13 = r12.x3     // Catch:{ XMPException -> 0x02d7, IOException -> 0x02d1 }
            if (r13 == 0) goto L_0x029d
            goto L_0x02a5
        L_0x029d:
            com.itextpdf.text.xml.xmp.XmpWriter r13 = r12.O0(r2, r7)     // Catch:{ XMPException -> 0x02d7, IOException -> 0x02d1 }
            r13.g()     // Catch:{ XMPException -> 0x02d7, IOException -> 0x02d1 }
            goto L_0x02c7
        L_0x02a5:
            com.itextpdf.xmp.XMPMeta r13 = com.itextpdf.xmp.XMPMetaFactory.g(r9)     // Catch:{ XMPException -> 0x02d7, IOException -> 0x02d1 }
            com.itextpdf.text.xml.xmp.PdfProperties.b(r13, r4)     // Catch:{ XMPException -> 0x02d7, IOException -> 0x02d1 }
            java.lang.String r4 = r8.q0()     // Catch:{ XMPException -> 0x02d7, IOException -> 0x02d1 }
            com.itextpdf.text.xml.xmp.XmpBasicProperties.e(r13, r4)     // Catch:{ XMPException -> 0x02d7, IOException -> 0x02d1 }
            java.lang.String r4 = r8.q0()     // Catch:{ XMPException -> 0x02d7, IOException -> 0x02d1 }
            com.itextpdf.text.xml.xmp.XmpBasicProperties.d(r13, r4)     // Catch:{ XMPException -> 0x02d7, IOException -> 0x02d1 }
            com.itextpdf.xmp.options.SerializeOptions r4 = new com.itextpdf.xmp.options.SerializeOptions     // Catch:{ XMPException -> 0x02d7, IOException -> 0x02d1 }
            r4.<init>()     // Catch:{ XMPException -> 0x02d7, IOException -> 0x02d1 }
            r6 = 2000(0x7d0, float:2.803E-42)
            r4.O(r6)     // Catch:{ XMPException -> 0x02d7, IOException -> 0x02d1 }
            com.itextpdf.xmp.XMPMetaFactory.m(r13, r2, r4)     // Catch:{ XMPException -> 0x02d7, IOException -> 0x02d1 }
        L_0x02c7:
            com.itextpdf.text.pdf.PdfStream r6 = new com.itextpdf.text.pdf.PdfStream     // Catch:{ XMPException -> 0x02d7, IOException -> 0x02d1 }
            byte[] r13 = r2.toByteArray()     // Catch:{ XMPException -> 0x02d7, IOException -> 0x02d1 }
            r6.<init>(r13)     // Catch:{ XMPException -> 0x02d7, IOException -> 0x02d1 }
            goto L_0x02dc
        L_0x02d1:
            com.itextpdf.text.pdf.PdfStream r6 = new com.itextpdf.text.pdf.PdfStream
            r6.<init>(r9)
            goto L_0x02dc
        L_0x02d7:
            com.itextpdf.text.pdf.PdfStream r6 = new com.itextpdf.text.pdf.PdfStream
            r6.<init>(r9)
        L_0x02dc:
            if (r6 == 0) goto L_0x0325
            com.itextpdf.text.pdf.PdfName r13 = com.itextpdf.text.pdf.PdfName.Kg
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.db
            r6.V0(r13, r2)
            com.itextpdf.text.pdf.PdfName r13 = com.itextpdf.text.pdf.PdfName.Cf
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.Zh
            r6.V0(r13, r4)
            com.itextpdf.text.pdf.PdfEncryption r13 = r12.A3
            if (r13 == 0) goto L_0x0305
            boolean r13 = r13.q()
            if (r13 != 0) goto L_0x0305
            com.itextpdf.text.pdf.PdfArray r13 = new com.itextpdf.text.pdf.PdfArray
            r13.<init>()
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.a6
            r13.a0(r4)
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.T7
            r6.V0(r4, r13)
        L_0x0305:
            boolean r13 = r12.o6
            if (r13 == 0) goto L_0x0315
            if (r3 == 0) goto L_0x0315
            com.itextpdf.text.pdf.PdfWriter$PdfBody r13 = r12.k3
            com.itextpdf.text.pdf.PRIndirectReference r0 = r3.m()
            r13.d(r6, r0)
            goto L_0x0325
        L_0x0315:
            com.itextpdf.text.pdf.PdfWriter$PdfBody r13 = r12.k3
            com.itextpdf.text.pdf.PdfIndirectObject r13 = r13.a(r6)
            com.itextpdf.text.pdf.PdfIndirectReference r13 = r13.a()
            r0.V0(r2, r13)
            r12.z3(r0)
        L_0x0325:
            java.util.HashMap<java.lang.Object, com.itextpdf.text.pdf.PdfObject> r13 = r12.s6
            boolean r13 = r13.isEmpty()
            if (r13 != 0) goto L_0x0330
            r12.W3()
        L_0x0330:
            r12.a3(r1, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfStamperImp.b3(java.util.Map):void");
    }

    /* access modifiers changed from: package-private */
    public void c2(PdfOCG pdfOCG) {
        if (!this.u6) {
            this.u6 = true;
            E3();
        }
        super.c2(pdfOCG);
    }

    /* access modifiers changed from: package-private */
    public void c3(int i2) {
        if (this.d6 != null && i2 <= this.Y5.c0()) {
            for (AcroFields.Item next : this.d6.t().values()) {
                for (int i3 = 0; i3 < next.p(); i3++) {
                    int intValue = next.i(i3).intValue();
                    if (intValue >= i2) {
                        next.g(i3, intValue + 1);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d3() {
        PdfDictionary F = this.Y5.F();
        PdfName pdfName = PdfName.nc;
        PdfObject d0 = F.d0(pdfName);
        if (d0 != null) {
            if (d0 instanceof PRIndirectReference) {
                PRIndirectReference pRIndirectReference = (PRIndirectReference) d0;
                B3(pRIndirectReference);
                PdfReader.W0(pRIndirectReference);
            }
            F.a1(pdfName);
            z3(F);
        }
    }

    /* access modifiers changed from: package-private */
    public void e3() {
        PdfObject d0 = this.Y5.F().d0(PdfName.p3);
        if (d0 != null) {
            PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.t0(d0);
            PdfReader pdfReader = this.Y5;
            PdfName pdfName = PdfName.Yh;
            pdfReader.X0(pdfDictionary.d0(pdfName));
            pdfDictionary.a1(pdfName);
            PdfName pdfName2 = PdfName.P7;
            PdfObject d02 = pdfDictionary.d0(pdfName2);
            if (d02 != null) {
                PdfDictionary pdfDictionary2 = new PdfDictionary();
                pdfDictionary2.V0(PdfName.ia, d02);
                S3(pdfDictionary2);
                PdfReader.W0(d02);
                pdfDictionary.V0(pdfName2, new PdfArray());
            }
            pdfDictionary.a1(PdfName.Re);
            pdfDictionary.a1(PdfName.xb);
            pdfDictionary.a1(PdfName.T6);
        }
    }

    /* access modifiers changed from: package-private */
    public void f3(PdfFormField pdfFormField, ArrayList<PdfAnnotation> arrayList) {
        arrayList.add(pdfFormField);
        ArrayList<PdfFormField> Z2 = pdfFormField.Z2();
        if (Z2 != null) {
            for (int i2 = 0; i2 < Z2.size(); i2++) {
                f3(Z2.get(i2), arrayList);
            }
        }
    }

    public PdfContentByte g1() {
        throw new UnsupportedOperationException(MessageLocalization.b("use.pdfstamper.getundercontent.or.pdfstamper.getovercontent", new Object[0]));
    }

    public void h(int i2) {
        this.n6 = i2 | this.n6;
    }

    public PdfContentByte h1() {
        throw new UnsupportedOperationException(MessageLocalization.b("use.pdfstamper.getundercontent.or.pdfstamper.getovercontent", new Object[0]));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x02c7  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x02d0  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x02e2  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0235  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void h3() {
        /*
            r22 = this;
            r0 = r22
            r2 = 3
            r3 = 2
            r4 = 1
            boolean r6 = r0.o6
            r7 = 0
            if (r6 != 0) goto L_0x0424
            r22.l3()
            com.itextpdf.text.pdf.AcroFields r6 = r0.d6
            java.util.Map r6 = r6.t()
            boolean r8 = r0.m6
            if (r8 == 0) goto L_0x0039
            java.util.HashSet<java.lang.String> r8 = r0.i6
            boolean r8 = r8.isEmpty()
            if (r8 == 0) goto L_0x0039
            java.util.Set r8 = r6.keySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x0027:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0039
            java.lang.Object r9 = r8.next()
            java.lang.String r9 = (java.lang.String) r9
            java.util.HashSet<java.lang.String> r10 = r0.i6
            r10.add(r9)
            goto L_0x0027
        L_0x0039:
            com.itextpdf.text.pdf.PdfReader r8 = r0.Y5
            com.itextpdf.text.pdf.PdfDictionary r8 = r8.F()
            com.itextpdf.text.pdf.PdfName r9 = com.itextpdf.text.pdf.PdfName.p3
            com.itextpdf.text.pdf.PdfDictionary r8 = r8.j0(r9)
            if (r8 == 0) goto L_0x0054
            com.itextpdf.text.pdf.PdfName r10 = com.itextpdf.text.pdf.PdfName.P7
            com.itextpdf.text.pdf.PdfObject r10 = r8.d0(r10)
            com.itextpdf.text.pdf.PdfObject r8 = com.itextpdf.text.pdf.PdfReader.u0(r10, r8)
            com.itextpdf.text.pdf.PdfArray r8 = (com.itextpdf.text.pdf.PdfArray) r8
            goto L_0x0055
        L_0x0054:
            r8 = 0
        L_0x0055:
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x005d:
            boolean r10 = r6.hasNext()
            if (r10 == 0) goto L_0x03af
            java.lang.Object r10 = r6.next()
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            java.lang.Object r11 = r10.getKey()
            java.lang.String r11 = (java.lang.String) r11
            java.util.HashSet<java.lang.String> r12 = r0.i6
            boolean r12 = r12.isEmpty()
            if (r12 != 0) goto L_0x0080
            java.util.HashSet<java.lang.String> r12 = r0.i6
            boolean r12 = r12.contains(r11)
            if (r12 != 0) goto L_0x0080
            goto L_0x005d
        L_0x0080:
            java.lang.Object r10 = r10.getValue()
            com.itextpdf.text.pdf.AcroFields$Item r10 = (com.itextpdf.text.pdf.AcroFields.Item) r10
            r12 = 0
        L_0x0087:
            int r13 = r10.p()
            if (r12 >= r13) goto L_0x03ac
            com.itextpdf.text.pdf.PdfDictionary r13 = r10.h(r12)
            com.itextpdf.text.pdf.PdfName r14 = com.itextpdf.text.pdf.PdfName.F7
            com.itextpdf.text.pdf.PdfNumber r14 = r13.q0(r14)
            if (r14 == 0) goto L_0x009e
            int r14 = r14.e0()
            goto L_0x009f
        L_0x009e:
            r14 = 0
        L_0x009f:
            java.lang.Integer r15 = r10.i(r12)
            int r15 = r15.intValue()
            if (r15 >= r4) goto L_0x00af
            r2 = 1
            r4 = 2
            r16 = 0
            goto L_0x03a5
        L_0x00af:
            com.itextpdf.text.pdf.PdfName r9 = com.itextpdf.text.pdf.PdfName.S3
            com.itextpdf.text.pdf.PdfDictionary r1 = r13.j0(r9)
            if (r1 == 0) goto L_0x00c6
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.kb
            com.itextpdf.text.pdf.PdfStream r17 = r1.x0(r5)
            if (r17 != 0) goto L_0x00c3
            com.itextpdf.text.pdf.PdfDictionary r17 = r1.j0(r5)
        L_0x00c3:
            r5 = r17
            goto L_0x00c7
        L_0x00c6:
            r5 = 0
        L_0x00c7:
            com.itextpdf.text.pdf.AcroFields r4 = r0.d6
            boolean r4 = r4.J()
            r18 = 1065353216(0x3f800000, float:1.0)
            if (r4 == 0) goto L_0x01a0
            if (r1 == 0) goto L_0x00d5
            if (r5 != 0) goto L_0x00d9
        L_0x00d5:
            r16 = 0
            goto L_0x0188
        L_0x00d9:
            boolean r4 = r5.K()
            if (r4 == 0) goto L_0x015e
            com.itextpdf.text.pdf.PdfStream r5 = (com.itextpdf.text.pdf.PdfStream) r5
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.n4
            com.itextpdf.text.pdf.PdfArray r4 = r5.e0(r4)
            com.itextpdf.text.pdf.PdfName r9 = com.itextpdf.text.pdf.PdfName.Nd
            com.itextpdf.text.pdf.PdfArray r9 = r13.e0(r9)
            if (r4 == 0) goto L_0x015e
            if (r9 == 0) goto L_0x015e
            com.itextpdf.text.pdf.PdfNumber r19 = r9.J0(r3)
            float r19 = r19.a0()
            com.itextpdf.text.pdf.PdfNumber r20 = r9.J0(r7)
            float r20 = r20.a0()
            float r19 = r19 - r20
            com.itextpdf.text.pdf.PdfNumber r20 = r4.J0(r3)
            float r20 = r20.a0()
            com.itextpdf.text.pdf.PdfNumber r21 = r4.J0(r7)
            float r21 = r21.a0()
            float r20 = r20 - r21
            com.itextpdf.text.pdf.PdfNumber r21 = r9.J0(r2)
            float r21 = r21.a0()
            r3 = 1
            com.itextpdf.text.pdf.PdfNumber r9 = r9.J0(r3)
            float r9 = r9.a0()
            float r21 = r21 - r9
            com.itextpdf.text.pdf.PdfNumber r9 = r4.J0(r2)
            float r9 = r9.a0()
            com.itextpdf.text.pdf.PdfNumber r4 = r4.J0(r3)
            float r3 = r4.a0()
            float r9 = r9 - r3
            r3 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r4 = 0
            int r16 = (r20 > r4 ? 1 : (r20 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0144
            float r19 = r19 / r20
            goto L_0x0147
        L_0x0144:
            r19 = 2139095039(0x7f7fffff, float:3.4028235E38)
        L_0x0147:
            float r19 = java.lang.Math.abs(r19)
            int r20 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r20 == 0) goto L_0x0151
            float r3 = r21 / r9
        L_0x0151:
            float r3 = java.lang.Math.abs(r3)
            int r4 = (r19 > r18 ? 1 : (r19 == r18 ? 0 : -1))
            if (r4 != 0) goto L_0x0162
            int r4 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
            if (r4 == 0) goto L_0x015e
            goto L_0x0162
        L_0x015e:
            r16 = 0
            goto L_0x022e
        L_0x0162:
            com.itextpdf.text.pdf.NumberArray r4 = new com.itextpdf.text.pdf.NumberArray
            r9 = 6
            float[] r9 = new float[r9]
            r9[r7] = r19
            r16 = 0
            r17 = 1
            r9[r17] = r16
            r18 = 2
            r9[r18] = r16
            r9[r2] = r3
            r3 = 4
            r9[r3] = r16
            r3 = 5
            r9[r3] = r16
            r4.<init>((float[]) r9)
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.Qa
            r5.V0(r3, r4)
            r0.z3(r5)
            goto L_0x022e
        L_0x0188:
            com.itextpdf.text.pdf.AcroFields r3 = r0.d6     // Catch:{ DocumentException | IOException -> 0x019d }
            r3.N(r11)     // Catch:{ DocumentException | IOException -> 0x019d }
            com.itextpdf.text.pdf.AcroFields r3 = r0.d6     // Catch:{ DocumentException | IOException -> 0x019d }
            com.itextpdf.text.pdf.AcroFields$Item r3 = r3.p(r11)     // Catch:{ DocumentException | IOException -> 0x019d }
            com.itextpdf.text.pdf.PdfDictionary r3 = r3.h(r12)     // Catch:{ DocumentException | IOException -> 0x019d }
        L_0x0197:
            com.itextpdf.text.pdf.PdfDictionary r1 = r3.j0(r9)     // Catch:{ DocumentException | IOException -> 0x019d }
            goto L_0x022e
        L_0x019d:
            goto L_0x022e
        L_0x01a0:
            r16 = 0
            if (r1 == 0) goto L_0x022e
            if (r5 == 0) goto L_0x022e
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.n4
            com.itextpdf.text.pdf.PdfArray r3 = r5.e0(r3)
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.Nd
            com.itextpdf.text.pdf.PdfArray r4 = r13.e0(r4)
            if (r3 == 0) goto L_0x022e
            if (r4 == 0) goto L_0x022e
            r5 = 2
            com.itextpdf.text.pdf.PdfNumber r19 = r3.J0(r5)
            float r19 = r19.a0()
            com.itextpdf.text.pdf.PdfNumber r20 = r3.J0(r7)
            float r20 = r20.a0()
            float r19 = r19 - r20
            com.itextpdf.text.pdf.PdfNumber r20 = r4.J0(r5)
            float r5 = r20.a0()
            com.itextpdf.text.pdf.PdfNumber r20 = r4.J0(r7)
            float r20 = r20.a0()
            float r5 = r5 - r20
            float r19 = r19 - r5
            com.itextpdf.text.pdf.PdfNumber r5 = r3.J0(r2)
            float r5 = r5.a0()
            r7 = 1
            com.itextpdf.text.pdf.PdfNumber r3 = r3.J0(r7)
            float r3 = r3.a0()
            float r5 = r5 - r3
            com.itextpdf.text.pdf.PdfNumber r3 = r4.J0(r2)
            float r3 = r3.a0()
            com.itextpdf.text.pdf.PdfNumber r4 = r4.J0(r7)
            float r4 = r4.a0()
            float r3 = r3 - r4
            float r5 = r5 - r3
            float r3 = java.lang.Math.abs(r19)
            int r3 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
            if (r3 > 0) goto L_0x0211
            float r3 = java.lang.Math.abs(r5)
            int r3 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
            if (r3 <= 0) goto L_0x022e
        L_0x0211:
            com.itextpdf.text.pdf.AcroFields r3 = r0.d6     // Catch:{ DocumentException | IOException -> 0x019d }
            r4 = 1
            r3.h0(r4)     // Catch:{ DocumentException | IOException -> 0x019d }
            com.itextpdf.text.pdf.AcroFields r3 = r0.d6     // Catch:{ DocumentException | IOException -> 0x019d }
            r3.N(r11)     // Catch:{ DocumentException | IOException -> 0x019d }
            com.itextpdf.text.pdf.AcroFields r3 = r0.d6     // Catch:{ DocumentException | IOException -> 0x019d }
            r4 = 0
            r3.h0(r4)     // Catch:{ DocumentException | IOException -> 0x019d }
            com.itextpdf.text.pdf.AcroFields r3 = r0.d6     // Catch:{ DocumentException | IOException -> 0x019d }
            com.itextpdf.text.pdf.AcroFields$Item r3 = r3.p(r11)     // Catch:{ DocumentException | IOException -> 0x019d }
            com.itextpdf.text.pdf.PdfDictionary r3 = r3.h(r12)     // Catch:{ DocumentException | IOException -> 0x019d }
            goto L_0x0197
        L_0x022e:
            r3 = 4
            if (r1 == 0) goto L_0x02c7
            r4 = r14 & 4
            if (r4 == 0) goto L_0x02c7
            r4 = 2
            r5 = r14 & 2
            if (r5 != 0) goto L_0x02c8
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.kb
            com.itextpdf.text.pdf.PdfObject r1 = r1.d0(r5)
            if (r1 == 0) goto L_0x02a0
            com.itextpdf.text.pdf.PdfObject r5 = com.itextpdf.text.pdf.PdfReader.t0(r1)
            boolean r7 = r1 instanceof com.itextpdf.text.pdf.PdfIndirectReference
            if (r7 == 0) goto L_0x0258
            boolean r7 = r1.C()
            if (r7 != 0) goto L_0x0258
            com.itextpdf.text.pdf.PdfAppearance r5 = new com.itextpdf.text.pdf.PdfAppearance
            com.itextpdf.text.pdf.PdfIndirectReference r1 = (com.itextpdf.text.pdf.PdfIndirectReference) r1
            r5.<init>((com.itextpdf.text.pdf.PdfIndirectReference) r1)
            goto L_0x02a1
        L_0x0258:
            boolean r7 = r5 instanceof com.itextpdf.text.pdf.PdfStream
            if (r7 == 0) goto L_0x026d
            com.itextpdf.text.pdf.PdfDictionary r5 = (com.itextpdf.text.pdf.PdfDictionary) r5
            com.itextpdf.text.pdf.PdfName r7 = com.itextpdf.text.pdf.PdfName.Cf
            com.itextpdf.text.pdf.PdfName r9 = com.itextpdf.text.pdf.PdfName.w8
            r5.V0(r7, r9)
            com.itextpdf.text.pdf.PdfAppearance r5 = new com.itextpdf.text.pdf.PdfAppearance
            com.itextpdf.text.pdf.PdfIndirectReference r1 = (com.itextpdf.text.pdf.PdfIndirectReference) r1
            r5.<init>((com.itextpdf.text.pdf.PdfIndirectReference) r1)
            goto L_0x02a1
        L_0x026d:
            if (r5 == 0) goto L_0x02a0
            boolean r1 = r5.z()
            if (r1 == 0) goto L_0x02a0
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Z3
            com.itextpdf.text.pdf.PdfName r1 = r13.p0(r1)
            if (r1 == 0) goto L_0x02a0
            com.itextpdf.text.pdf.PdfDictionary r5 = (com.itextpdf.text.pdf.PdfDictionary) r5
            com.itextpdf.text.pdf.PdfObject r1 = r5.d0(r1)
            com.itextpdf.text.pdf.PdfIndirectReference r1 = (com.itextpdf.text.pdf.PdfIndirectReference) r1
            if (r1 == 0) goto L_0x02a0
            com.itextpdf.text.pdf.PdfAppearance r5 = new com.itextpdf.text.pdf.PdfAppearance
            r5.<init>((com.itextpdf.text.pdf.PdfIndirectReference) r1)
            boolean r7 = r1.C()
            if (r7 == 0) goto L_0x02a1
            com.itextpdf.text.pdf.PdfObject r1 = com.itextpdf.text.pdf.PdfReader.t0(r1)
            com.itextpdf.text.pdf.PdfDictionary r1 = (com.itextpdf.text.pdf.PdfDictionary) r1
            com.itextpdf.text.pdf.PdfName r7 = com.itextpdf.text.pdf.PdfName.Cf
            com.itextpdf.text.pdf.PdfName r9 = com.itextpdf.text.pdf.PdfName.w8
            r1.V0(r7, r9)
            goto L_0x02a1
        L_0x02a0:
            r5 = 0
        L_0x02a1:
            if (r5 == 0) goto L_0x02c8
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Nd
            com.itextpdf.text.pdf.PdfArray r1 = r13.e0(r1)
            com.itextpdf.text.Rectangle r1 = com.itextpdf.text.pdf.PdfReader.b0(r1)
            com.itextpdf.text.pdf.PdfContentByte r7 = r0.o3(r15)
            java.lang.String r9 = "Q "
            r7.M2(r9)
            float r9 = r1.O()
            float r1 = r1.H()
            r7.z(r5, r9, r1)
            java.lang.String r1 = "q "
            r7.M2(r1)
            goto L_0x02c8
        L_0x02c7:
            r4 = 2
        L_0x02c8:
            java.util.HashSet<java.lang.String> r1 = r0.i6
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x02d3
        L_0x02d0:
            r2 = 1
            goto L_0x03a5
        L_0x02d3:
            com.itextpdf.text.pdf.PdfReader r1 = r0.Y5
            com.itextpdf.text.pdf.PdfDictionary r1 = r1.h0(r15)
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.Q3
            com.itextpdf.text.pdf.PdfArray r5 = r1.e0(r5)
            if (r5 != 0) goto L_0x02e2
            goto L_0x02d0
        L_0x02e2:
            r7 = 0
        L_0x02e3:
            int r9 = r5.size()
            if (r7 >= r9) goto L_0x0392
            com.itextpdf.text.pdf.PdfObject r9 = r5.T0(r7)
            boolean r13 = r9.C()
            if (r13 != 0) goto L_0x02f6
        L_0x02f3:
            r2 = 1
            goto L_0x038d
        L_0x02f6:
            com.itextpdf.text.pdf.PdfIndirectReference r13 = r10.m(r12)
            boolean r14 = r13.C()
            if (r14 != 0) goto L_0x0301
            goto L_0x02f3
        L_0x0301:
            com.itextpdf.text.pdf.PRIndirectReference r9 = (com.itextpdf.text.pdf.PRIndirectReference) r9
            int r9 = r9.d()
            com.itextpdf.text.pdf.PRIndirectReference r13 = (com.itextpdf.text.pdf.PRIndirectReference) r13
            int r14 = r13.d()
            if (r9 != r14) goto L_0x02f3
            int r9 = r7 + -1
            r5.U0(r7)
        L_0x0314:
            com.itextpdf.text.pdf.PdfObject r7 = com.itextpdf.text.pdf.PdfReader.t0(r13)
            com.itextpdf.text.pdf.PdfDictionary r7 = (com.itextpdf.text.pdf.PdfDictionary) r7
            com.itextpdf.text.pdf.PdfName r14 = com.itextpdf.text.pdf.PdfName.Dc
            com.itextpdf.text.pdf.PdfObject r7 = r7.d0(r14)
            com.itextpdf.text.pdf.PRIndirectReference r7 = (com.itextpdf.text.pdf.PRIndirectReference) r7
            com.itextpdf.text.pdf.PdfReader.W0(r13)
            if (r7 != 0) goto L_0x034e
            r7 = 0
        L_0x0328:
            int r14 = r8.size()
            if (r7 >= r14) goto L_0x034c
            com.itextpdf.text.pdf.PdfObject r14 = r8.T0(r7)
            boolean r15 = r14.C()
            if (r15 == 0) goto L_0x0349
            com.itextpdf.text.pdf.PRIndirectReference r14 = (com.itextpdf.text.pdf.PRIndirectReference) r14
            int r14 = r14.d()
            int r15 = r13.d()
            if (r14 != r15) goto L_0x0349
            r8.U0(r7)
            int r7 = r7 + -1
        L_0x0349:
            r14 = 1
            int r7 = r7 + r14
            goto L_0x0328
        L_0x034c:
            r2 = 1
            goto L_0x0387
        L_0x034e:
            com.itextpdf.text.pdf.PdfObject r14 = com.itextpdf.text.pdf.PdfReader.t0(r7)
            com.itextpdf.text.pdf.PdfDictionary r14 = (com.itextpdf.text.pdf.PdfDictionary) r14
            com.itextpdf.text.pdf.PdfName r15 = com.itextpdf.text.pdf.PdfName.ia
            com.itextpdf.text.pdf.PdfArray r14 = r14.e0(r15)
            r15 = 0
        L_0x035b:
            int r2 = r14.size()
            if (r15 >= r2) goto L_0x0380
            com.itextpdf.text.pdf.PdfObject r2 = r14.T0(r15)
            boolean r18 = r2.C()
            if (r18 == 0) goto L_0x037c
            com.itextpdf.text.pdf.PRIndirectReference r2 = (com.itextpdf.text.pdf.PRIndirectReference) r2
            int r2 = r2.d()
            int r3 = r13.d()
            if (r2 != r3) goto L_0x037c
            r14.U0(r15)
            int r15 = r15 + -1
        L_0x037c:
            r2 = 1
            int r15 = r15 + r2
            r3 = 4
            goto L_0x035b
        L_0x0380:
            r2 = 1
            boolean r3 = r14.isEmpty()
            if (r3 != 0) goto L_0x0389
        L_0x0387:
            r7 = r9
            goto L_0x038d
        L_0x0389:
            r13 = r7
            r2 = 3
            r3 = 4
            goto L_0x0314
        L_0x038d:
            int r7 = r7 + r2
            r2 = 3
            r3 = 4
            goto L_0x02e3
        L_0x0392:
            r2 = 1
            boolean r3 = r5.isEmpty()
            if (r3 == 0) goto L_0x03a5
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.Q3
            com.itextpdf.text.pdf.PdfObject r5 = r1.d0(r3)
            com.itextpdf.text.pdf.PdfReader.W0(r5)
            r1.a1(r3)
        L_0x03a5:
            int r12 = r12 + r2
            r2 = 3
            r3 = 2
            r4 = 1
            r7 = 0
            goto L_0x0087
        L_0x03ac:
            r4 = 1
            goto L_0x005d
        L_0x03af:
            boolean r1 = r0.m6
            if (r1 != 0) goto L_0x0423
            java.util.HashSet<java.lang.String> r1 = r0.i6
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0423
            r3 = 1
        L_0x03bc:
            com.itextpdf.text.pdf.PdfReader r1 = r0.Y5
            int r1 = r1.c0()
            if (r3 > r1) goto L_0x0420
            com.itextpdf.text.pdf.PdfReader r1 = r0.Y5
            com.itextpdf.text.pdf.PdfDictionary r1 = r1.h0(r3)
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.Q3
            com.itextpdf.text.pdf.PdfArray r2 = r1.e0(r2)
            if (r2 != 0) goto L_0x03d4
            r5 = 1
            goto L_0x041e
        L_0x03d4:
            r4 = 0
        L_0x03d5:
            int r5 = r2.size()
            if (r4 >= r5) goto L_0x040b
            com.itextpdf.text.pdf.PdfObject r5 = r2.Q0(r4)
            boolean r6 = r5 instanceof com.itextpdf.text.pdf.PdfIndirectReference
            if (r6 == 0) goto L_0x03ea
            boolean r6 = r5.C()
            if (r6 != 0) goto L_0x03ea
            goto L_0x0401
        L_0x03ea:
            boolean r6 = r5.z()
            if (r6 == 0) goto L_0x0403
            com.itextpdf.text.pdf.PdfName r6 = com.itextpdf.text.pdf.PdfName.Ih
            com.itextpdf.text.pdf.PdfDictionary r5 = (com.itextpdf.text.pdf.PdfDictionary) r5
            com.itextpdf.text.pdf.PdfName r7 = com.itextpdf.text.pdf.PdfName.Cf
            com.itextpdf.text.pdf.PdfObject r5 = r5.d0(r7)
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0401
            goto L_0x0403
        L_0x0401:
            r5 = 1
            goto L_0x0409
        L_0x0403:
            r2.U0(r4)
            int r4 = r4 + -1
            goto L_0x0401
        L_0x0409:
            int r4 = r4 + r5
            goto L_0x03d5
        L_0x040b:
            r5 = 1
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x041e
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.Q3
            com.itextpdf.text.pdf.PdfObject r4 = r1.d0(r2)
            com.itextpdf.text.pdf.PdfReader.W0(r4)
            r1.a1(r2)
        L_0x041e:
            int r3 = r3 + r5
            goto L_0x03bc
        L_0x0420:
            r22.e3()
        L_0x0423:
            return
        L_0x0424:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "field.flattening.is.not.supported.in.append.mode"
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r2, r3)
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfStamperImp.h3():void");
    }

    public void i(PdfAction pdfAction) {
        this.r6 = pdfAction;
    }

    /* access modifiers changed from: protected */
    public void i3() {
        k3(true);
    }

    /* access modifiers changed from: protected */
    public void j3() {
        k3(false);
    }

    public void l(String str) {
        throw new UnsupportedOperationException(MessageLocalization.b("open.actions.by.name.are.not.supported", new Object[0]));
    }

    /* access modifiers changed from: package-private */
    public AcroFields l3() {
        if (this.d6 == null) {
            this.d6 = new AcroFields(this.Y5, this);
        }
        return this.d6;
    }

    /* access modifiers changed from: protected */
    public HashMap<Object, PdfObject> n3() {
        return this.s6;
    }

    /* access modifiers changed from: package-private */
    public PdfContentByte o3(int i2) {
        if (i2 < 1 || i2 > this.Y5.c0()) {
            return null;
        }
        PageStamp p3 = p3(i2);
        if (p3.f26335c == null) {
            p3.f26335c = new StampContent(this, p3);
        }
        return p3.f26335c;
    }

    public void p(PdfName pdfName, PdfAction pdfAction) throws PdfException {
        if (pdfName.equals(PdfWriter.a5) || pdfName.equals(PdfWriter.b5) || pdfName.equals(PdfWriter.c5) || pdfName.equals(PdfWriter.d5) || pdfName.equals(PdfWriter.e5)) {
            PdfDictionary F = this.Y5.F();
            PdfName pdfName2 = PdfName.m3;
            PdfDictionary j0 = F.j0(pdfName2);
            if (j0 == null) {
                if (pdfAction != null) {
                    j0 = new PdfDictionary();
                    this.Y5.F().V0(pdfName2, j0);
                } else {
                    return;
                }
            }
            z3(j0);
            if (pdfAction == null) {
                j0.a1(pdfName);
            } else {
                j0.V0(pdfName, pdfAction);
            }
        } else {
            throw new PdfException(MessageLocalization.b("invalid.additional.action.type.1", pdfName.toString()));
        }
    }

    /* access modifiers changed from: package-private */
    public PageStamp p3(int i2) {
        PdfDictionary h0 = this.Y5.h0(i2);
        PageStamp pageStamp = this.a6.get(h0);
        if (pageStamp != null) {
            return pageStamp;
        }
        PageStamp pageStamp2 = new PageStamp(this, this.Y5, h0);
        this.a6.put(h0, pageStamp2);
        return pageStamp2;
    }

    public Map<String, PdfLayer> q3() {
        String sb;
        if (!this.u6) {
            this.u6 = true;
            E3();
        }
        HashMap hashMap = new HashMap();
        Iterator<PdfOCG> it2 = this.U3.iterator();
        while (it2.hasNext()) {
            PdfLayer pdfLayer = (PdfLayer) it2.next();
            String pdfString = pdfLayer.o1() == null ? pdfLayer.A0(PdfName.qb).toString() : pdfLayer.o1();
            if (hashMap.containsKey(pdfString)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(pdfString);
                sb2.append("(");
                int i2 = 2;
                sb2.append(2);
                while (true) {
                    sb2.append(")");
                    sb = sb2.toString();
                    if (!hashMap.containsKey(sb)) {
                        break;
                    }
                    i2++;
                    sb2 = new StringBuilder();
                    sb2.append(pdfString);
                    sb2.append("(");
                    sb2.append(i2);
                }
                pdfString = sb;
            }
            hashMap.put(pdfString, pdfLayer);
        }
        return hashMap;
    }

    public PdfReader r3() {
        return this.Y5;
    }

    /* access modifiers changed from: protected */
    public int s1(PdfReader pdfReader, int i2, int i3) {
        IntHashtable intHashtable = this.V5.get(pdfReader);
        if (intHashtable != null) {
            int e2 = intHashtable.e(i2);
            if (e2 != 0) {
                return e2;
            }
            int n1 = n1();
            intHashtable.l(i2, n1);
            return n1;
        }
        PdfReaderInstance pdfReaderInstance = this.I3;
        if (pdfReaderInstance != null) {
            return pdfReaderInstance.c(i2, i3);
        }
        if (this.o6 && i2 < this.q6) {
            return i2;
        }
        int e3 = this.Z5.e(i2);
        if (e3 != 0) {
            return e3;
        }
        int n12 = n1();
        this.Z5.l(i2, n12);
        return n12;
    }

    /* access modifiers changed from: package-private */
    public PdfContentByte s3(int i2) {
        if (i2 < 1 || i2 > this.Y5.c0()) {
            return null;
        }
        PageStamp p3 = p3(i2);
        if (p3.f26334b == null) {
            p3.f26334b = new StampContent(this, p3);
        }
        return p3.f26334b;
    }

    /* access modifiers changed from: package-private */
    public void t3(int i2, Rectangle rectangle) {
        PRIndirectReference pRIndirectReference;
        PdfDictionary pdfDictionary;
        Rectangle rectangle2 = new Rectangle(rectangle);
        int S = rectangle2.S() % 360;
        PdfDictionary pdfDictionary2 = new PdfDictionary(PdfName.uc);
        pdfDictionary2.V0(PdfName.Wd, new PdfDictionary());
        pdfDictionary2.V0(PdfName.te, new PdfNumber(S));
        pdfDictionary2.V0(PdfName.Za, new PdfRectangle(rectangle2, S));
        PRIndirectReference j2 = this.Y5.j(pdfDictionary2);
        if (i2 > this.Y5.c0()) {
            PdfReader pdfReader = this.Y5;
            pRIndirectReference = new PRIndirectReference(this.Y5, ((PRIndirectReference) pdfReader.i0(pdfReader.c0()).d0(PdfName.Dc)).d());
            pdfDictionary = (PdfDictionary) PdfReader.t0(pRIndirectReference);
            PdfArray pdfArray = (PdfArray) PdfReader.u0(pdfDictionary.d0(PdfName.ia), pdfDictionary);
            pdfArray.a0(j2);
            z3(pdfArray);
            this.Y5.c3.g(i2, j2);
        } else {
            if (i2 < 1) {
                i2 = 1;
            }
            PdfDictionary h0 = this.Y5.h0(i2);
            PRIndirectReference j0 = this.Y5.j0(i2);
            this.Y5.r1(i2);
            PRIndirectReference pRIndirectReference2 = new PRIndirectReference(this.Y5, ((PRIndirectReference) h0.d0(PdfName.Dc)).d());
            pdfDictionary = (PdfDictionary) PdfReader.t0(pRIndirectReference2);
            PdfArray pdfArray2 = (PdfArray) PdfReader.u0(pdfDictionary.d0(PdfName.ia), pdfDictionary);
            int size = pdfArray2.size();
            int d2 = j0.d();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                } else if (d2 == ((PRIndirectReference) pdfArray2.T0(i3)).d()) {
                    pdfArray2.Z(i3, j2);
                    break;
                } else {
                    i3++;
                }
            }
            if (size != pdfArray2.size()) {
                z3(pdfArray2);
                this.Y5.c3.g(i2, j2);
                c3(i2);
                pRIndirectReference = pRIndirectReference2;
            } else {
                throw new RuntimeException(MessageLocalization.b("internal.inconsistence", new Object[0]));
            }
        }
        pdfDictionary2.V0(PdfName.Dc, pRIndirectReference);
        while (pdfDictionary != null) {
            z3(pdfDictionary);
            PdfName pdfName = PdfName.P5;
            pdfDictionary.V0(pdfName, new PdfNumber(((PdfNumber) PdfReader.w0(pdfDictionary.d0(pdfName))).e0() + 1));
            pdfDictionary = pdfDictionary.j0(PdfName.Dc);
        }
    }

    public void u(PdfAnnotation pdfAnnotation) {
        throw new RuntimeException(MessageLocalization.b("unsupported.in.this.context.use.pdfstamper.addannotation", new Object[0]));
    }

    /* access modifiers changed from: package-private */
    public boolean u3() {
        return this.o6;
    }

    public void v(PdfName pdfName, PdfObject pdfObject) {
        this.j6 = true;
        this.k6.v(pdfName, pdfObject);
    }

    /* access modifiers changed from: package-private */
    public boolean v3() {
        return this.k3.m() > 1;
    }

    /* access modifiers changed from: package-private */
    public boolean w3() {
        return this.c6;
    }

    /* access modifiers changed from: package-private */
    public void x3(PdfCollection pdfCollection) {
        this.Y5.F().V0(PdfName.y5, pdfCollection);
    }

    public void y(int i2) {
        throw new UnsupportedOperationException(MessageLocalization.b("use.setpageaction.pdfname.actiontype.pdfaction.action.int.page", new Object[0]));
    }

    /* access modifiers changed from: protected */
    public void y3(int i2) {
        if (this.o6) {
            this.p6.l(i2, 1);
        }
    }

    public void z(PdfName pdfName, PdfAction pdfAction) throws PdfException {
        throw new UnsupportedOperationException(MessageLocalization.b("use.setpageaction.pdfname.actiontype.pdfaction.action.int.page", new Object[0]));
    }

    /* access modifiers changed from: protected */
    public void z3(PdfObject pdfObject) {
        if (this.o6 && pdfObject != null) {
            PRIndirectReference m2 = pdfObject.W() == 10 ? (PRIndirectReference) pdfObject : pdfObject.m();
            if (m2 != null) {
                this.p6.l(m2.d(), 1);
            }
        }
    }
}
