package com.itextpdf.text.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.BadPasswordException;
import com.itextpdf.text.log.Counter;
import com.itextpdf.text.log.CounterFactory;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.StringTokenizer;

public class PdfCopy extends PdfWriter {
    private static final Logger D6;
    protected static Counter E6;
    private static final PdfName F6;
    private static int G6 = 0;
    private static final PdfName H6 = new PdfName("_iTextTag_");
    private static final Integer I6 = 0;
    protected static final HashSet<PdfName> J6;
    protected static final HashSet<PdfName> K6;
    private HashSet<Object> A6 = new HashSet<>();
    private HashMap<Object, PdfString> B6 = new HashMap<>();
    private HashSet<PdfReader> C6 = new HashSet<>();
    protected HashMap<RefKey, IndirectReferences> V5;
    protected HashMap<PdfReader, HashMap<RefKey, IndirectReferences>> W5;
    protected HashMap<PdfObject, PdfObject> X5;
    protected HashSet<PdfObject> Y5;
    protected PdfReader Z5;
    protected int[] a6 = {0};
    /* access modifiers changed from: private */
    public boolean b6 = true;
    protected PdfArray c6;
    protected HashSet<PdfTemplate> d6;
    private PdfStructTreeController e6 = null;
    private int f6 = 0;
    protected PRIndirectReference g6;
    protected LinkedHashMap<RefKey, PdfIndirectObject> h6;
    protected ArrayList<PdfIndirectObject> i6;
    protected ArrayList<ImportedPage> j6;
    protected boolean k6 = false;
    protected boolean l6 = false;
    private boolean m6 = false;
    private boolean n6;
    private PdfIndirectReference o6;
    private HashMap<PdfArray, ArrayList<Integer>> p6;
    private ArrayList<Object> q6;
    private PdfDictionary r6;
    protected ArrayList<AcroFields> s6;
    private ArrayList<String> t6;
    private HashMap<String, Object> u6;
    private HashMap<Integer, PdfIndirectObject> v6;
    private HashMap<RefKey, PdfIndirectObject> w6;
    private HashMap<Integer, PdfIndirectObject> x6;
    private HashSet<PdfIndirectObject> y6;
    private boolean z6 = false;

    protected static class ImportedPage {

        /* renamed from: a  reason: collision with root package name */
        int f26163a;

        /* renamed from: b  reason: collision with root package name */
        PdfReader f26164b;

        /* renamed from: c  reason: collision with root package name */
        PdfArray f26165c;

        /* renamed from: d  reason: collision with root package name */
        PdfIndirectReference f26166d;

        ImportedPage(PdfReader pdfReader, int i2, boolean z) {
            this.f26163a = i2;
            this.f26164b = pdfReader;
            if (z) {
                this.f26165c = new PdfArray();
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ImportedPage)) {
                return false;
            }
            ImportedPage importedPage = (ImportedPage) obj;
            return this.f26163a == importedPage.f26163a && this.f26164b.equals(importedPage.f26164b);
        }

        public String toString() {
            return Integer.toString(this.f26163a);
        }
    }

    static class IndirectReferences {

        /* renamed from: a  reason: collision with root package name */
        PdfIndirectReference f26167a;

        /* renamed from: b  reason: collision with root package name */
        boolean f26168b = false;

        IndirectReferences(PdfIndirectReference pdfIndirectReference) {
            this.f26167a = pdfIndirectReference;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f26168b;
        }

        /* access modifiers changed from: package-private */
        public PdfIndirectReference b() {
            return this.f26167a;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f26168b = true;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f26168b = false;
        }

        public String toString() {
            String str = "";
            if (this.f26168b) {
                str = str + " Copied";
            }
            return b() + str;
        }
    }

    public static class PageStamp {

        /* renamed from: a  reason: collision with root package name */
        PdfDictionary f26169a;

        /* renamed from: b  reason: collision with root package name */
        StampContent f26170b;

        /* renamed from: c  reason: collision with root package name */
        StampContent f26171c;

        /* renamed from: d  reason: collision with root package name */
        PageResources f26172d;

        /* renamed from: e  reason: collision with root package name */
        PdfReader f26173e;

        /* renamed from: f  reason: collision with root package name */
        PdfCopy f26174f;

        PageStamp(PdfReader pdfReader, PdfDictionary pdfDictionary, PdfCopy pdfCopy) {
            this.f26169a = pdfDictionary;
            this.f26173e = pdfReader;
            this.f26174f = pdfCopy;
        }

        private void b(PdfIndirectReference pdfIndirectReference) {
            PdfCopy pdfCopy = this.f26174f;
            if (pdfCopy.c6 == null) {
                pdfCopy.c6 = new PdfArray();
            }
            this.f26174f.c6.a0(pdfIndirectReference);
        }

        private void e(PdfFormField pdfFormField, ArrayList<PdfAnnotation> arrayList) {
            arrayList.add(pdfFormField);
            ArrayList<PdfFormField> Z2 = pdfFormField.Z2();
            if (Z2 != null) {
                Iterator<PdfFormField> it2 = Z2.iterator();
                while (it2.hasNext()) {
                    e(it2.next(), arrayList);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:36:0x0098 A[Catch:{ IOException -> 0x0025 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(com.itextpdf.text.pdf.PdfAnnotation r11) {
            /*
                r10 = this;
                java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ IOException -> 0x0025 }
                r0.<init>()     // Catch:{ IOException -> 0x0025 }
                boolean r1 = r11.W1()     // Catch:{ IOException -> 0x0025 }
                if (r1 == 0) goto L_0x0028
                com.itextpdf.text.pdf.PdfFormField r11 = (com.itextpdf.text.pdf.PdfFormField) r11     // Catch:{ IOException -> 0x0025 }
                com.itextpdf.text.pdf.PdfFormField r1 = r11.a3()     // Catch:{ IOException -> 0x0025 }
                if (r1 == 0) goto L_0x0014
                return
            L_0x0014:
                r10.e(r11, r0)     // Catch:{ IOException -> 0x0025 }
                com.itextpdf.text.pdf.PdfCopy r11 = r10.f26174f     // Catch:{ IOException -> 0x0025 }
                java.util.HashSet<com.itextpdf.text.pdf.PdfTemplate> r1 = r11.d6     // Catch:{ IOException -> 0x0025 }
                if (r1 != 0) goto L_0x002b
                java.util.HashSet r1 = new java.util.HashSet     // Catch:{ IOException -> 0x0025 }
                r1.<init>()     // Catch:{ IOException -> 0x0025 }
                r11.d6 = r1     // Catch:{ IOException -> 0x0025 }
                goto L_0x002b
            L_0x0025:
                r11 = move-exception
                goto L_0x0164
            L_0x0028:
                r0.add(r11)     // Catch:{ IOException -> 0x0025 }
            L_0x002b:
                r11 = 0
            L_0x002c:
                int r1 = r0.size()     // Catch:{ IOException -> 0x0025 }
                if (r11 >= r1) goto L_0x0163
                java.lang.Object r1 = r0.get(r11)     // Catch:{ IOException -> 0x0025 }
                com.itextpdf.text.pdf.PdfAnnotation r1 = (com.itextpdf.text.pdf.PdfAnnotation) r1     // Catch:{ IOException -> 0x0025 }
                boolean r2 = r1.W1()     // Catch:{ IOException -> 0x0025 }
                if (r2 == 0) goto L_0x0061
                boolean r2 = r1.X1()     // Catch:{ IOException -> 0x0025 }
                if (r2 != 0) goto L_0x0051
                java.util.HashSet r2 = r1.Q1()     // Catch:{ IOException -> 0x0025 }
                if (r2 == 0) goto L_0x0051
                com.itextpdf.text.pdf.PdfCopy r3 = r10.f26174f     // Catch:{ IOException -> 0x0025 }
                java.util.HashSet<com.itextpdf.text.pdf.PdfTemplate> r3 = r3.d6     // Catch:{ IOException -> 0x0025 }
                r3.addAll(r2)     // Catch:{ IOException -> 0x0025 }
            L_0x0051:
                r2 = r1
                com.itextpdf.text.pdf.PdfFormField r2 = (com.itextpdf.text.pdf.PdfFormField) r2     // Catch:{ IOException -> 0x0025 }
                com.itextpdf.text.pdf.PdfFormField r3 = r2.a3()     // Catch:{ IOException -> 0x0025 }
                if (r3 != 0) goto L_0x0061
                com.itextpdf.text.pdf.PdfIndirectReference r2 = r2.L1()     // Catch:{ IOException -> 0x0025 }
                r10.b(r2)     // Catch:{ IOException -> 0x0025 }
            L_0x0061:
                boolean r2 = r1.V1()     // Catch:{ IOException -> 0x0025 }
                if (r2 == 0) goto L_0x014d
                com.itextpdf.text.pdf.PdfDictionary r2 = r10.f26169a     // Catch:{ IOException -> 0x0025 }
                com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.Q3     // Catch:{ IOException -> 0x0025 }
                com.itextpdf.text.pdf.PdfObject r2 = r2.d0(r3)     // Catch:{ IOException -> 0x0025 }
                com.itextpdf.text.pdf.PdfDictionary r4 = r10.f26169a     // Catch:{ IOException -> 0x0025 }
                com.itextpdf.text.pdf.PdfObject r2 = com.itextpdf.text.pdf.PdfReader.u0(r2, r4)     // Catch:{ IOException -> 0x0025 }
                if (r2 == 0) goto L_0x0081
                boolean r4 = r2.q()     // Catch:{ IOException -> 0x0025 }
                if (r4 != 0) goto L_0x007e
                goto L_0x0081
            L_0x007e:
                com.itextpdf.text.pdf.PdfArray r2 = (com.itextpdf.text.pdf.PdfArray) r2     // Catch:{ IOException -> 0x0025 }
                goto L_0x008b
            L_0x0081:
                com.itextpdf.text.pdf.PdfArray r2 = new com.itextpdf.text.pdf.PdfArray     // Catch:{ IOException -> 0x0025 }
                r2.<init>()     // Catch:{ IOException -> 0x0025 }
                com.itextpdf.text.pdf.PdfDictionary r4 = r10.f26169a     // Catch:{ IOException -> 0x0025 }
                r4.V0(r3, r2)     // Catch:{ IOException -> 0x0025 }
            L_0x008b:
                com.itextpdf.text.pdf.PdfIndirectReference r3 = r1.L1()     // Catch:{ IOException -> 0x0025 }
                r2.a0(r3)     // Catch:{ IOException -> 0x0025 }
                boolean r2 = r1.X1()     // Catch:{ IOException -> 0x0025 }
                if (r2 != 0) goto L_0x014d
                com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.Nd     // Catch:{ IOException -> 0x0025 }
                com.itextpdf.text.pdf.PdfObject r3 = r1.d0(r2)     // Catch:{ IOException -> 0x0025 }
                com.itextpdf.text.pdf.PdfRectangle r3 = (com.itextpdf.text.pdf.PdfRectangle) r3     // Catch:{ IOException -> 0x0025 }
                if (r3 == 0) goto L_0x014d
                float r4 = r3.i1()     // Catch:{ IOException -> 0x0025 }
                r5 = 0
                int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r4 != 0) goto L_0x00c3
                float r4 = r3.n1()     // Catch:{ IOException -> 0x0025 }
                int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r4 != 0) goto L_0x00c3
                float r4 = r3.q1()     // Catch:{ IOException -> 0x0025 }
                int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r4 != 0) goto L_0x00c3
                float r4 = r3.X0()     // Catch:{ IOException -> 0x0025 }
                int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r4 == 0) goto L_0x014d
            L_0x00c3:
                com.itextpdf.text.pdf.PdfReader r4 = r10.f26173e     // Catch:{ IOException -> 0x0025 }
                com.itextpdf.text.pdf.PdfDictionary r5 = r10.f26169a     // Catch:{ IOException -> 0x0025 }
                int r4 = r4.n0(r5)     // Catch:{ IOException -> 0x0025 }
                com.itextpdf.text.pdf.PdfReader r5 = r10.f26173e     // Catch:{ IOException -> 0x0025 }
                com.itextpdf.text.pdf.PdfDictionary r6 = r10.f26169a     // Catch:{ IOException -> 0x0025 }
                com.itextpdf.text.Rectangle r5 = r5.r0(r6)     // Catch:{ IOException -> 0x0025 }
                r6 = 90
                if (r4 == r6) goto L_0x012d
                r6 = 180(0xb4, float:2.52E-43)
                if (r4 == r6) goto L_0x0103
                r6 = 270(0x10e, float:3.78E-43)
                if (r4 == r6) goto L_0x00e0
                goto L_0x014d
            L_0x00e0:
                com.itextpdf.text.pdf.PdfRectangle r4 = new com.itextpdf.text.pdf.PdfRectangle     // Catch:{ IOException -> 0x0025 }
                float r6 = r3.X0()     // Catch:{ IOException -> 0x0025 }
                float r7 = r5.Q()     // Catch:{ IOException -> 0x0025 }
                float r8 = r3.i1()     // Catch:{ IOException -> 0x0025 }
                float r7 = r7 - r8
                float r8 = r3.q1()     // Catch:{ IOException -> 0x0025 }
                float r5 = r5.Q()     // Catch:{ IOException -> 0x0025 }
                float r3 = r3.n1()     // Catch:{ IOException -> 0x0025 }
                float r5 = r5 - r3
                r4.<init>(r6, r7, r8, r5)     // Catch:{ IOException -> 0x0025 }
            L_0x00ff:
                r1.V0(r2, r4)     // Catch:{ IOException -> 0x0025 }
                goto L_0x014d
            L_0x0103:
                com.itextpdf.text.pdf.PdfRectangle r4 = new com.itextpdf.text.pdf.PdfRectangle     // Catch:{ IOException -> 0x0025 }
                float r6 = r5.Q()     // Catch:{ IOException -> 0x0025 }
                float r7 = r3.i1()     // Catch:{ IOException -> 0x0025 }
                float r6 = r6 - r7
                float r7 = r5.T()     // Catch:{ IOException -> 0x0025 }
                float r8 = r3.X0()     // Catch:{ IOException -> 0x0025 }
                float r7 = r7 - r8
                float r8 = r5.Q()     // Catch:{ IOException -> 0x0025 }
                float r9 = r3.n1()     // Catch:{ IOException -> 0x0025 }
                float r8 = r8 - r9
                float r5 = r5.T()     // Catch:{ IOException -> 0x0025 }
                float r3 = r3.q1()     // Catch:{ IOException -> 0x0025 }
                float r5 = r5 - r3
                r4.<init>(r6, r7, r8, r5)     // Catch:{ IOException -> 0x0025 }
                goto L_0x00ff
            L_0x012d:
                com.itextpdf.text.pdf.PdfRectangle r4 = new com.itextpdf.text.pdf.PdfRectangle     // Catch:{ IOException -> 0x0025 }
                float r6 = r5.T()     // Catch:{ IOException -> 0x0025 }
                float r7 = r3.X0()     // Catch:{ IOException -> 0x0025 }
                float r6 = r6 - r7
                float r7 = r3.i1()     // Catch:{ IOException -> 0x0025 }
                float r5 = r5.T()     // Catch:{ IOException -> 0x0025 }
                float r8 = r3.q1()     // Catch:{ IOException -> 0x0025 }
                float r5 = r5 - r8
                float r3 = r3.n1()     // Catch:{ IOException -> 0x0025 }
                r4.<init>(r6, r7, r5, r3)     // Catch:{ IOException -> 0x0025 }
                goto L_0x00ff
            L_0x014d:
                boolean r2 = r1.X1()     // Catch:{ IOException -> 0x0025 }
                if (r2 != 0) goto L_0x015f
                r1.K2()     // Catch:{ IOException -> 0x0025 }
                com.itextpdf.text.pdf.PdfCopy r2 = r10.f26174f     // Catch:{ IOException -> 0x0025 }
                com.itextpdf.text.pdf.PdfIndirectReference r3 = r1.L1()     // Catch:{ IOException -> 0x0025 }
                r2.y0(r1, r3)     // Catch:{ IOException -> 0x0025 }
            L_0x015f:
                int r11 = r11 + 1
                goto L_0x002c
            L_0x0163:
                return
            L_0x0164:
                com.itextpdf.text.ExceptionConverter r0 = new com.itextpdf.text.ExceptionConverter
                r0.<init>(r11)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfCopy.PageStamp.a(com.itextpdf.text.pdf.PdfAnnotation):void");
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x0051  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x006d  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0098  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c() throws java.io.IOException {
            /*
                r4 = this;
                com.itextpdf.text.pdf.PdfCopy$StampContent r0 = r4.f26171c
                if (r0 != 0) goto L_0x0009
                com.itextpdf.text.pdf.PdfCopy$StampContent r0 = r4.f26170b
                if (r0 != 0) goto L_0x0009
                return
            L_0x0009:
                com.itextpdf.text.pdf.PdfDictionary r0 = r4.f26169a
                com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.N5
                com.itextpdf.text.pdf.PdfObject r0 = r0.d0(r1)
                com.itextpdf.text.pdf.PdfDictionary r2 = r4.f26169a
                com.itextpdf.text.pdf.PdfObject r0 = com.itextpdf.text.pdf.PdfReader.u0(r0, r2)
                if (r0 != 0) goto L_0x0024
                com.itextpdf.text.pdf.PdfArray r0 = new com.itextpdf.text.pdf.PdfArray
                r0.<init>()
            L_0x001e:
                com.itextpdf.text.pdf.PdfDictionary r2 = r4.f26169a
                r2.V0(r1, r0)
                goto L_0x0048
            L_0x0024:
                boolean r2 = r0.q()
                if (r2 == 0) goto L_0x002d
                com.itextpdf.text.pdf.PdfArray r0 = (com.itextpdf.text.pdf.PdfArray) r0
                goto L_0x0048
            L_0x002d:
                boolean r0 = r0.K()
                if (r0 == 0) goto L_0x0042
                com.itextpdf.text.pdf.PdfArray r0 = new com.itextpdf.text.pdf.PdfArray
                r0.<init>()
                com.itextpdf.text.pdf.PdfDictionary r2 = r4.f26169a
                com.itextpdf.text.pdf.PdfObject r2 = r2.d0(r1)
                r0.a0(r2)
                goto L_0x001e
            L_0x0042:
                com.itextpdf.text.pdf.PdfArray r0 = new com.itextpdf.text.pdf.PdfArray
                r0.<init>()
                goto L_0x001e
            L_0x0048:
                com.itextpdf.text.pdf.ByteBuffer r1 = new com.itextpdf.text.pdf.ByteBuffer
                r1.<init>()
                com.itextpdf.text.pdf.PdfCopy$StampContent r2 = r4.f26170b
                if (r2 == 0) goto L_0x0069
                byte[] r2 = com.itextpdf.text.pdf.PdfContents.E3
                r1.n(r2)
                com.itextpdf.text.pdf.PdfDictionary r2 = r4.f26169a
                r4.d(r2, r1)
                com.itextpdf.text.pdf.PdfCopy$StampContent r2 = r4.f26170b
                com.itextpdf.text.pdf.ByteBuffer r2 = r2.a1()
                r1.i(r2)
                byte[] r2 = com.itextpdf.text.pdf.PdfContents.F3
                r1.n(r2)
            L_0x0069:
                com.itextpdf.text.pdf.PdfCopy$StampContent r2 = r4.f26171c
                if (r2 == 0) goto L_0x0072
                byte[] r2 = com.itextpdf.text.pdf.PdfContents.E3
                r1.n(r2)
            L_0x0072:
                com.itextpdf.text.pdf.PdfStream r2 = new com.itextpdf.text.pdf.PdfStream
                byte[] r3 = r1.F()
                r2.<init>(r3)
                com.itextpdf.text.pdf.PdfCopy r3 = r4.f26174f
                int r3 = r3.a1()
                r2.i1(r3)
                com.itextpdf.text.pdf.PdfCopy r3 = r4.f26174f
                com.itextpdf.text.pdf.PdfIndirectObject r2 = r3.v0(r2)
                com.itextpdf.text.pdf.PdfIndirectReference r2 = r2.a()
                r0.i0(r2)
                r1.x()
                com.itextpdf.text.pdf.PdfCopy$StampContent r2 = r4.f26171c
                if (r2 == 0) goto L_0x00d7
                r2 = 32
                r1.c(r2)
                byte[] r2 = com.itextpdf.text.pdf.PdfContents.F3
                r1.n(r2)
                byte[] r3 = com.itextpdf.text.pdf.PdfContents.E3
                r1.n(r3)
                com.itextpdf.text.pdf.PdfDictionary r3 = r4.f26169a
                r4.d(r3, r1)
                com.itextpdf.text.pdf.PdfCopy$StampContent r3 = r4.f26171c
                com.itextpdf.text.pdf.ByteBuffer r3 = r3.a1()
                r1.i(r3)
                r1.n(r2)
                com.itextpdf.text.pdf.PdfStream r2 = new com.itextpdf.text.pdf.PdfStream
                byte[] r1 = r1.F()
                r2.<init>(r1)
                com.itextpdf.text.pdf.PdfCopy r1 = r4.f26174f
                int r1 = r1.a1()
                r2.i1(r1)
                com.itextpdf.text.pdf.PdfCopy r1 = r4.f26174f
                com.itextpdf.text.pdf.PdfIndirectObject r1 = r1.v0(r2)
                com.itextpdf.text.pdf.PdfIndirectReference r1 = r1.a()
                r0.a0(r1)
            L_0x00d7:
                com.itextpdf.text.pdf.PdfDictionary r0 = r4.f26169a
                com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Wd
                com.itextpdf.text.pdf.PageResources r2 = r4.f26172d
                com.itextpdf.text.pdf.PdfDictionary r2 = r2.k()
                r0.V0(r1, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfCopy.PageStamp.c():void");
        }

        /* access modifiers changed from: package-private */
        public void d(PdfDictionary pdfDictionary, ByteBuffer byteBuffer) {
            if (this.f26174f.b6) {
                Rectangle r0 = this.f26173e.r0(pdfDictionary);
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

        public PdfContentByte f() {
            if (this.f26171c == null) {
                if (this.f26172d == null) {
                    this.f26172d = new PageResources();
                    this.f26172d.m(this.f26169a.j0(PdfName.Wd), this.f26174f.a6);
                }
                this.f26171c = new StampContent(this.f26174f, this.f26172d);
            }
            return this.f26171c;
        }

        public PdfContentByte g() {
            if (this.f26170b == null) {
                if (this.f26172d == null) {
                    this.f26172d = new PageResources();
                    this.f26172d.m(this.f26169a.j0(PdfName.Wd), this.f26174f.a6);
                }
                this.f26170b = new StampContent(this.f26174f, this.f26172d);
            }
            return this.f26170b;
        }
    }

    public static class StampContent extends PdfContentByte {
        PageResources y3;

        StampContent(PdfWriter pdfWriter, PageResources pageResources) {
            super(pdfWriter);
            this.y3 = pageResources;
        }

        public PdfContentByte U0() {
            return new StampContent(this.Y, this.y3);
        }

        /* access modifiers changed from: package-private */
        public PageResources f1() {
            return this.y3;
        }
    }

    static {
        Class<PdfCopy> cls = PdfCopy.class;
        D6 = LoggerFactory.b(cls);
        E6 = CounterFactory.b(cls);
        PdfName pdfName = new PdfName("iTextAnnotId");
        F6 = pdfName;
        HashSet<PdfName> hashSet = new HashSet<>();
        J6 = hashSet;
        HashSet<PdfName> hashSet2 = new HashSet<>();
        K6 = hashSet2;
        hashSet.add(PdfName.Cf);
        hashSet.add(PdfName.N5);
        hashSet.add(PdfName.Nd);
        hashSet.add(PdfName.Cb);
        hashSet.add(PdfName.Na);
        hashSet.add(PdfName.F7);
        hashSet.add(PdfName.H4);
        hashSet.add(PdfName.D4);
        hashSet.add(PdfName.S3);
        hashSet.add(PdfName.Z3);
        hashSet.add(PdfName.K4);
        hashSet.add(PdfName.k3);
        hashSet.add(PdfName.vf);
        hashSet.add(PdfName.Pb);
        hashSet.add(PdfName.W8);
        hashSet.add(PdfName.gb);
        hashSet.add(PdfName.g6);
        hashSet.add(PdfName.Ad);
        hashSet.add(PdfName.tc);
        hashSet.add(PdfName.Kg);
        hashSet.add(pdfName);
        hashSet2.add(PdfName.m3);
        hashSet2.add(PdfName.C8);
        hashSet2.add(PdfName.Dg);
        hashSet2.add(PdfName.kg);
        hashSet2.add(PdfName.L7);
        hashSet2.add(PdfName.kh);
        hashSet2.add(PdfName.a7);
        hashSet2.add(PdfName.U6);
        hashSet2.add(PdfName.Be);
        hashSet2.add(PdfName.hc);
        hashSet2.add(PdfName.Ya);
        hashSet2.add(PdfName.bg);
        hashSet2.add(PdfName.x9);
        hashSet2.add(PdfName.Ha);
        hashSet2.add(PdfName.Ff);
    }

    public PdfCopy(Document document, OutputStream outputStream) throws DocumentException {
        super(new PdfDocument(), outputStream);
        document.h(this.h3);
        this.h3.i0(this);
        this.W5 = new HashMap<>();
        this.X5 = new HashMap<>();
        this.Y5 = new HashSet<>();
        this.h6 = new LinkedHashMap<>();
        this.i6 = new ArrayList<>();
        this.j6 = new ArrayList<>();
    }

    private static String A3(PdfReader pdfReader, PRIndirectReference pRIndirectReference) {
        PdfObject t0;
        String str = "";
        while (pRIndirectReference != null && (t0 = PdfReader.t0(pRIndirectReference)) != null && t0.W() == 6) {
            PdfDictionary pdfDictionary = (PdfDictionary) t0;
            PdfString A0 = pdfDictionary.A0(PdfName.If);
            if (A0 != null) {
                str = A0.m0() + "." + str;
            }
            pRIndirectReference = (PRIndirectReference) pdfDictionary.d0(PdfName.Dc);
        }
        return str.endsWith(".") ? str.substring(0, str.length() - 2) : str;
    }

    static Integer B3(PdfDictionary pdfDictionary) {
        PdfNumber q0;
        if (PdfName.I4.equals(pdfDictionary.p0(PdfName.C8)) && (q0 = pdfDictionary.q0(PdfName.L7)) != null) {
            return Integer.valueOf(q0.e0());
        }
        return null;
    }

    static boolean F3(PdfDictionary pdfDictionary) {
        Integer B3 = B3(pdfDictionary);
        return B3 == null || ((B3.intValue() & 65536) == 0 && (B3.intValue() & 32768) == 0);
    }

    static boolean G3(PdfDictionary pdfDictionary) {
        Integer B3 = B3(pdfDictionary);
        return (B3 == null || (B3.intValue() & 65536) != 0 || (B3.intValue() & 32768) == 0) ? false : true;
    }

    static boolean J3(PdfDictionary pdfDictionary) {
        return PdfName.Jg.equals(pdfDictionary.p0(PdfName.C8));
    }

    private void K3(String str, AcroFields.Item item) {
        HashMap<String, Object> hashMap = this.u6;
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        if (stringTokenizer.hasMoreTokens()) {
            while (true) {
                String nextToken = stringTokenizer.nextToken();
                Object obj = hashMap.get(nextToken);
                if (stringTokenizer.hasMoreTokens()) {
                    if (obj == null) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        hashMap.put(nextToken, linkedHashMap);
                        hashMap = linkedHashMap;
                    } else if (obj instanceof HashMap) {
                        hashMap = obj;
                    } else {
                        return;
                    }
                } else if (!(obj instanceof HashMap)) {
                    int i2 = 0;
                    PdfDictionary h2 = item.h(0);
                    if (obj == null) {
                        PdfDictionary pdfDictionary = new PdfDictionary();
                        if (PdfName.Pe.equals(h2.d0(PdfName.C8))) {
                            this.n6 = true;
                        }
                        for (PdfName next : h2.G0()) {
                            if (K6.contains(next)) {
                                pdfDictionary.V0(next, h2.d0(next));
                            }
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(pdfDictionary);
                        q3(arrayList, item);
                        hashMap.put(nextToken, arrayList);
                        return;
                    }
                    ArrayList arrayList2 = (ArrayList) obj;
                    PdfDictionary pdfDictionary2 = (PdfDictionary) arrayList2.get(0);
                    PdfName pdfName = PdfName.C8;
                    PdfName pdfName2 = (PdfName) pdfDictionary2.d0(pdfName);
                    PdfName pdfName3 = (PdfName) h2.d0(pdfName);
                    if (pdfName2 != null && pdfName2.equals(pdfName3)) {
                        PdfName pdfName4 = PdfName.L7;
                        PdfObject d0 = pdfDictionary2.d0(pdfName4);
                        int e0 = (d0 == null || !d0.I()) ? 0 : ((PdfNumber) d0).e0();
                        PdfObject d02 = h2.d0(pdfName4);
                        if (d02 != null && d02.I()) {
                            i2 = ((PdfNumber) d02).e0();
                        }
                        if (pdfName2.equals(PdfName.I4)) {
                            int i3 = e0 ^ i2;
                            if ((i3 & 65536) == 0) {
                                if ((e0 & 65536) == 0 && (32768 & i3) != 0) {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else if (pdfName2.equals(PdfName.e5) && ((e0 ^ i2) & 131072) != 0) {
                            return;
                        }
                        q3(arrayList2, item);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
        }
    }

    private void L3() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.s6.size(); i3++) {
            AcroFields acroFields = this.s6.get(i3);
            Map<String, AcroFields.Item> t = acroFields.t();
            if (i2 < this.j6.size() && this.j6.get(i2).f26164b == acroFields.f25824a) {
                Y2(t, i2);
                i2 += acroFields.f25824a.c0();
            }
            M3(t);
        }
    }

    private void M3(Map<String, AcroFields.Item> map) {
        for (Map.Entry next : map.entrySet()) {
            K3((String) next.getKey(), (AcroFields.Item) next.getValue());
        }
    }

    private PdfObject N3(PdfObject pdfObject) throws IOException {
        if (pdfObject == null) {
            return new PdfNull();
        }
        if (pdfObject.q()) {
            PdfArray pdfArray = (PdfArray) pdfObject;
            for (int i2 = 0; i2 < pdfArray.size(); i2++) {
                pdfArray.V0(i2, N3(pdfArray.T0(i2)));
            }
            return pdfArray;
        } else if (!pdfObject.z() && !pdfObject.K()) {
            return pdfObject.C() ? v0(N3(PdfReader.t0(pdfObject))).a() : pdfObject;
        } else {
            PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
            for (PdfName next : pdfDictionary.G0()) {
                pdfDictionary.V0(next, N3(pdfDictionary.d0(next)));
            }
            return pdfDictionary;
        }
    }

    private void O3(PdfArray pdfArray, HashSet<RefKey> hashSet) {
        int i2 = 0;
        while (i2 < pdfArray.size()) {
            PdfObject T0 = pdfArray.T0(i2);
            if ((T0.W() == 0 && !hashSet.contains(new RefKey((PdfIndirectReference) T0))) || (T0.z() && d3((PdfDictionary) T0, hashSet))) {
                pdfArray.U0(i2);
                i2--;
            }
            i2++;
        }
    }

    private void U3(PdfObject pdfObject) {
        PdfNumber q0;
        PdfIndirectObject pdfIndirectObject;
        PdfNumber q02;
        PdfIndirectObject pdfIndirectObject2;
        if (pdfObject.q()) {
            PdfArray pdfArray = (PdfArray) pdfObject;
            for (int i2 = 0; i2 < pdfArray.size(); i2++) {
                PdfObject T0 = pdfArray.T0(i2);
                if (T0 == null || T0.W() != 0) {
                    U3(T0);
                } else {
                    PdfIndirectObject pdfIndirectObject3 = this.w6.get(new RefKey((PdfIndirectReference) T0));
                    if (!(pdfIndirectObject3 == null || !pdfIndirectObject3.f26232c.z() || (q02 = ((PdfDictionary) pdfIndirectObject3.f26232c).q0(F6)) == null || (pdfIndirectObject2 = this.x6.get(Integer.valueOf(q02.e0()))) == null)) {
                        pdfArray.V0(i2, pdfIndirectObject2.a());
                    }
                }
            }
        } else if (pdfObject.z() || pdfObject.K()) {
            PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
            for (PdfName next : pdfDictionary.G0()) {
                PdfObject d0 = pdfDictionary.d0(next);
                if (d0 == null || d0.W() != 0) {
                    U3(d0);
                } else {
                    PdfIndirectObject pdfIndirectObject4 = this.w6.get(new RefKey((PdfIndirectReference) d0));
                    if (!(pdfIndirectObject4 == null || !pdfIndirectObject4.f26232c.z() || (q0 = ((PdfDictionary) pdfIndirectObject4.f26232c).q0(F6)) == null || (pdfIndirectObject = this.x6.get(Integer.valueOf(q0.e0()))) == null)) {
                        pdfDictionary.V0(next, pdfIndirectObject.a());
                    }
                }
            }
        }
    }

    private void V2(PdfDictionary pdfDictionary) throws IOException {
        if (this.c6 != null) {
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            pdfDictionary.V0(PdfName.p3, pdfDictionary2);
            pdfDictionary2.V0(PdfName.P7, this.c6);
            pdfDictionary2.V0(PdfName.g6, new PdfString("/Helv 0 Tf 0 g "));
            if (!this.d6.isEmpty()) {
                PdfDictionary pdfDictionary3 = new PdfDictionary();
                pdfDictionary2.V0(PdfName.T6, pdfDictionary3);
                Iterator<PdfTemplate> it2 = this.d6.iterator();
                while (it2.hasNext()) {
                    PdfFormField.b3(pdfDictionary3, (PdfDictionary) it2.next().N3());
                }
                PdfName pdfName = PdfName.l8;
                PdfDictionary j0 = pdfDictionary3.j0(pdfName);
                if (j0 == null) {
                    j0 = new PdfDictionary();
                    pdfDictionary3.V0(pdfName, j0);
                }
                PdfName pdfName2 = PdfName.i9;
                if (!j0.a0(pdfName2)) {
                    PdfDictionary pdfDictionary4 = new PdfDictionary(pdfName);
                    pdfDictionary4.V0(PdfName.l4, PdfName.j9);
                    pdfDictionary4.V0(PdfName.m7, PdfName.Mh);
                    pdfDictionary4.V0(PdfName.qb, pdfName2);
                    pdfDictionary4.V0(PdfName.Cf, PdfName.Mg);
                    j0.V0(pdfName2, v0(pdfDictionary4).a());
                }
                PdfName pdfName3 = PdfName.hi;
                if (!j0.a0(pdfName3)) {
                    PdfDictionary pdfDictionary5 = new PdfDictionary(pdfName);
                    pdfDictionary5.V0(PdfName.l4, PdfName.ii);
                    pdfDictionary5.V0(PdfName.qb, pdfName3);
                    pdfDictionary5.V0(PdfName.Cf, PdfName.Mg);
                    j0.V0(pdfName3, v0(pdfDictionary5).a());
                }
            }
        }
    }

    private void V3(PdfReader pdfReader) {
        PdfArray e0;
        PdfDictionary j0 = pdfReader.F().j0(PdfName.p3);
        if (j0 != null && (e0 = j0.e0(PdfName.r5)) != null && e0.size() != 0) {
            AcroFields C = pdfReader.C();
            for (int i2 = 0; i2 < e0.size(); i2++) {
                PdfObject T0 = e0.T0(i2);
                if (T0 != null && T0.C()) {
                    String A3 = A3(pdfReader, (PRIndirectReference) T0);
                    if (C.p(A3) != null) {
                        String str = "." + A3;
                        if (!this.t6.contains(str)) {
                            this.t6.add(str);
                        }
                    }
                }
            }
        }
    }

    private void W3(PdfObject pdfObject) {
        if (pdfObject.z() || pdfObject.K()) {
            PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
            for (PdfName next : pdfDictionary.G0()) {
                PdfObject d0 = pdfDictionary.d0(next);
                if (d0.C()) {
                    PRIndirectReference pRIndirectReference = (PRIndirectReference) d0;
                    IndirectReferences indirectReferences = (IndirectReferences) this.W5.get(pRIndirectReference.a0()).get(new RefKey(pRIndirectReference));
                    if (indirectReferences != null) {
                        pdfDictionary.V0(next, indirectReferences.b());
                    }
                } else {
                    W3(d0);
                }
            }
        } else if (pdfObject.q()) {
            PdfArray pdfArray = (PdfArray) pdfObject;
            for (int i2 = 0; i2 < pdfArray.size(); i2++) {
                PdfObject T0 = pdfArray.T0(i2);
                if (T0.C()) {
                    PRIndirectReference pRIndirectReference2 = (PRIndirectReference) T0;
                    IndirectReferences indirectReferences2 = (IndirectReferences) this.W5.get(pRIndirectReference2.a0()).get(new RefKey(pRIndirectReference2));
                    if (indirectReferences2 != null) {
                        pdfArray.V0(i2, indirectReferences2.b());
                    }
                } else {
                    W3(T0);
                }
            }
        }
    }

    private void X3(PdfIndirectObject pdfIndirectObject) throws IOException {
        PdfNumber pdfNumber;
        PdfDictionary pdfDictionary;
        PdfNumber q0;
        PdfIndirectObject pdfIndirectObject2;
        PdfName pdfName;
        PdfNumber q02;
        PdfNumber q03;
        boolean z = false;
        if (this.l6) {
            U3(pdfIndirectObject.f26232c);
            if (pdfIndirectObject.f26232c.z() || pdfIndirectObject.f26232c.K()) {
                PdfDictionary pdfDictionary2 = (PdfDictionary) pdfIndirectObject.f26232c;
                if (this.w6.containsKey(new RefKey(pdfIndirectObject.f26230a, pdfIndirectObject.f26231b)) && (q03 = pdfDictionary2.q0(F6)) != null && this.x6.containsKey(Integer.valueOf(q03.e0()))) {
                    z = true;
                }
                if (!(!this.y6.contains(pdfIndirectObject) || (q0 = pdfDictionary2.q0(F6)) == null || (pdfIndirectObject2 = this.v6.get(Integer.valueOf(q0.e0()))) == null || !pdfIndirectObject2.f26232c.z() || (q02 = ((PdfDictionary) pdfIndirectObject2.f26232c).q0(pdfName)) == null)) {
                    pdfDictionary2.V0((pdfName = PdfName.vf), q02);
                }
            }
        }
        if (!z) {
            if (!this.l6 || !pdfIndirectObject.f26232c.z()) {
                pdfDictionary = null;
                pdfNumber = null;
            } else {
                pdfDictionary = (PdfDictionary) pdfIndirectObject.f26232c;
                PdfName pdfName2 = F6;
                pdfNumber = pdfDictionary.q0(pdfName2);
                if (pdfNumber != null) {
                    pdfDictionary.a1(pdfName2);
                }
            }
            this.k3.c(pdfIndirectObject.f26232c, pdfIndirectObject.f26230a, pdfIndirectObject.f26231b, true);
            if (pdfNumber != null) {
                pdfDictionary.V0(F6, pdfNumber);
            }
        }
    }

    private void Y2(Map<String, AcroFields.Item> map, int i2) {
        if (i2 != 0) {
            for (AcroFields.Item next : map.values()) {
                for (int i3 = 0; i3 < next.p(); i3++) {
                    next.g(i3, next.i(i3).intValue() + i2);
                }
            }
        }
    }

    private void Z2(PdfArray pdfArray, PdfIndirectReference pdfIndirectReference, PdfNumber pdfNumber) {
        int e0 = pdfNumber.e0();
        ArrayList arrayList = this.p6.get(pdfArray);
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            int size = pdfArray.size() - 1;
            for (int i2 = 0; i2 < size; i2++) {
                arrayList2.add(I6);
            }
            arrayList2.add(Integer.valueOf(e0));
            this.p6.put(pdfArray, arrayList2);
            pdfArray.a0(pdfIndirectReference);
            return;
        }
        int size2 = arrayList.size() - 1;
        int i3 = size2;
        while (true) {
            if (i3 < 0) {
                break;
            } else if (((Integer) arrayList.get(i3)).intValue() <= e0) {
                int i4 = i3 + 1;
                arrayList.add(i4, Integer.valueOf(e0));
                pdfArray.Z(i4, pdfIndirectReference);
                size2 = -2;
                break;
            } else {
                i3--;
            }
        }
        if (size2 != -2) {
            arrayList.add(0, Integer.valueOf(e0));
            pdfArray.Z(0, pdfIndirectReference);
        }
    }

    private PdfArray a3(HashMap<String, Object> hashMap, PdfIndirectReference pdfIndirectReference, String str) throws IOException, BadPdfFormatException {
        Iterator<Map.Entry<String, Object>> it2;
        boolean z;
        Iterator<Map.Entry<String, Object>> it3;
        PdfName pdfName;
        PdfName pdfName2;
        PdfIndirectReference pdfIndirectReference2 = pdfIndirectReference;
        PdfArray pdfArray = new PdfArray();
        Iterator<Map.Entry<String, Object>> it4 = hashMap.entrySet().iterator();
        while (it4.hasNext()) {
            Map.Entry next = it4.next();
            String str2 = (String) next.getKey();
            Object value = next.getValue();
            PdfIndirectReference D1 = D1();
            PdfDictionary pdfDictionary = new PdfDictionary();
            if (pdfIndirectReference2 != null) {
                pdfDictionary.V0(PdfName.Dc, pdfIndirectReference2);
            }
            pdfDictionary.V0(PdfName.If, new PdfString(str2, PdfObject.h3));
            String str3 = str + "." + str2;
            int indexOf = this.t6.indexOf(str3);
            if (indexOf >= 0) {
                this.q6.set(indexOf, D1);
            }
            int i2 = 1;
            if (value instanceof HashMap) {
                pdfDictionary.V0(PdfName.ia, a3((HashMap) value, D1, str3));
                pdfArray.a0(D1);
                z0(pdfDictionary, D1, true);
                it2 = it4;
            } else {
                ArrayList arrayList = (ArrayList) value;
                pdfDictionary.U0((PdfDictionary) arrayList.get(0));
                if (arrayList.size() == 3) {
                    pdfDictionary.U0((PdfDictionary) arrayList.get(2));
                    PdfArray pdfArray2 = this.j6.get(((Integer) arrayList.get(1)).intValue() - 1).f26165c;
                    PdfName pdfName3 = H6;
                    pdfDictionary.a1(pdfName3);
                    pdfDictionary.V0(PdfName.Kg, PdfName.P3);
                    Z2(pdfArray2, D1, (PdfNumber) pdfDictionary.d0(pdfName3));
                    it2 = it4;
                    z = true;
                } else {
                    PdfDictionary pdfDictionary2 = (PdfDictionary) arrayList.get(0);
                    PdfArray pdfArray3 = new PdfArray();
                    int i3 = 1;
                    while (i3 < arrayList.size()) {
                        PdfArray pdfArray4 = this.j6.get(((Integer) arrayList.get(i3)).intValue() - i2).f26165c;
                        PdfDictionary pdfDictionary3 = new PdfDictionary();
                        pdfDictionary3.T0((PdfDictionary) arrayList.get(i3 + 1));
                        pdfDictionary3.V0(PdfName.Dc, D1);
                        PdfName pdfName4 = H6;
                        PdfNumber pdfNumber = (PdfNumber) pdfDictionary3.d0(pdfName4);
                        pdfDictionary3.a1(pdfName4);
                        if (J3(pdfDictionary2)) {
                            PdfString A0 = pdfDictionary2.A0(PdfName.kh);
                            PdfObject B0 = pdfDictionary3.B0(PdfName.S3);
                            if (!(A0 == null || B0 == null)) {
                                if (!this.B6.containsKey(arrayList)) {
                                    this.B6.put(arrayList, A0);
                                } else {
                                    try {
                                        TextField textField = new TextField(this, (Rectangle) null, (String) null);
                                        it3 = it4;
                                        try {
                                            this.s6.get(0).e(pdfDictionary3, textField);
                                            Rectangle b0 = PdfReader.b0(pdfDictionary3.e0(PdfName.Nd));
                                            if (textField.r() == 90 || textField.r() == 270) {
                                                b0 = b0.g0();
                                            }
                                            textField.C(b0);
                                            textField.K(this.B6.get(arrayList).m0());
                                            ((PdfDictionary) B0).V0(PdfName.kb, textField.T().J3());
                                        } catch (DocumentException unused) {
                                        }
                                    } catch (DocumentException unused2) {
                                    }
                                }
                            }
                            it3 = it4;
                        } else {
                            it3 = it4;
                            if (F3(pdfDictionary2)) {
                                pdfName2 = pdfDictionary2.p0(PdfName.kh);
                                pdfName = PdfName.Z3;
                                PdfName p0 = pdfDictionary3.p0(pdfName);
                                if (pdfName2 != null) {
                                    if (p0 == null) {
                                    }
                                }
                            } else if (G3(pdfDictionary2)) {
                                pdfName2 = pdfDictionary2.p0(PdfName.kh);
                                pdfName = PdfName.Z3;
                                PdfName p02 = pdfDictionary3.p0(pdfName);
                                if (!(pdfName2 == null || p02 == null || p02.equals(E3(pdfDictionary3)))) {
                                    if (!this.A6.contains(arrayList)) {
                                        this.A6.add(arrayList);
                                    } else {
                                        pdfName2 = E3(pdfDictionary3);
                                    }
                                }
                            }
                            pdfDictionary3.V0(pdfName, pdfName2);
                        }
                        pdfDictionary3.V0(PdfName.Kg, PdfName.P3);
                        PdfIndirectReference a2 = z0(pdfDictionary3, D1(), true).a();
                        Z2(pdfArray4, a2, pdfNumber);
                        pdfArray3.a0(a2);
                        i3 += 2;
                        PdfIndirectReference pdfIndirectReference3 = pdfIndirectReference;
                        String str4 = str;
                        it4 = it3;
                        i2 = 1;
                    }
                    it2 = it4;
                    z = true;
                    pdfDictionary.V0(PdfName.ia, pdfArray3);
                }
                pdfArray.a0(D1);
                z0(pdfDictionary, D1, z);
            }
            pdfIndirectReference2 = pdfIndirectReference;
            it4 = it2;
        }
        return pdfArray;
    }

    private int b3(ImportedPage importedPage) {
        if (this.j6.size() == 0) {
            return 1;
        }
        Iterator<ImportedPage> it2 = this.j6.iterator();
        while (it2.hasNext()) {
            if (it2.next().f26164b.equals(importedPage.f26164b)) {
                ArrayList<ImportedPage> arrayList = this.j6;
                ImportedPage importedPage2 = arrayList.get(arrayList.size() - 1);
                if (!importedPage2.f26164b.equals(importedPage.f26164b) || importedPage.f26163a <= importedPage2.f26163a) {
                    return -1;
                }
                return this.C6.contains(importedPage.f26164b) ? 0 : 1;
            }
        }
        return 1;
    }

    private void c3(PdfReader pdfReader) {
        HashMap hashMap = this.W5.get(pdfReader);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            PdfIndirectObject pdfIndirectObject = this.h6.get(new RefKey(((IndirectReferences) entry.getValue()).f26167a));
            if (pdfIndirectObject == null || pdfIndirectObject.f26232c.q() || pdfIndirectObject.f26232c.z() || pdfIndirectObject.f26232c.K()) {
                arrayList.add(entry.getKey());
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            hashMap.remove((RefKey) it2.next());
        }
    }

    private boolean d3(PdfDictionary pdfDictionary, HashSet<RefKey> hashSet) {
        PdfObject d0 = pdfDictionary.d0(PdfName.Rc);
        return d0 != null && !hashSet.contains(new RefKey((PdfIndirectReference) d0));
    }

    private void o3() throws IOException, BadPdfFormatException {
        if (this.u6.isEmpty()) {
            Iterator<ImportedPage> it2 = this.j6.iterator();
            while (it2.hasNext()) {
                ImportedPage next = it2.next();
                if (next.f26165c.size() > 0) {
                    y0(next.f26165c, next.f26166d);
                }
            }
            return;
        }
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.V0(PdfName.T6, N3(this.r6));
        if (this.m6) {
            pdfDictionary.V0(PdfName.xb, PdfBoolean.j3);
        }
        pdfDictionary.V0(PdfName.g6, new PdfString("/Helv 0 Tf 0 g "));
        this.p6 = new HashMap<>();
        this.q6 = new ArrayList<>(this.t6);
        pdfDictionary.V0(PdfName.P7, a3(this.u6, (PdfIndirectReference) null, ""));
        if (this.n6) {
            pdfDictionary.V0(PdfName.Re, new PdfNumber(3));
        }
        PdfArray pdfArray = new PdfArray();
        for (int i2 = 0; i2 < this.q6.size(); i2++) {
            Object obj = this.q6.get(i2);
            if (obj instanceof PdfIndirectReference) {
                pdfArray.a0((PdfIndirectReference) obj);
            }
        }
        if (pdfArray.size() > 0) {
            pdfDictionary.V0(PdfName.r5, pdfArray);
        }
        this.o6 = v0(pdfDictionary).a();
        Iterator<ImportedPage> it3 = this.j6.iterator();
        while (it3.hasNext()) {
            ImportedPage next2 = it3.next();
            y0(next2.f26165c, next2.f26166d);
        }
    }

    private void q3(ArrayList<Object> arrayList, AcroFields.Item item) {
        for (int i2 = 0; i2 < item.p(); i2++) {
            arrayList.add(item.i(i2));
            PdfDictionary h2 = item.h(i2);
            PdfObject d0 = h2.d0(PdfName.T6);
            if (d0 != null) {
                PdfFormField.b3(this.r6, (PdfDictionary) PdfReader.t0(d0));
            }
            PdfDictionary pdfDictionary = new PdfDictionary();
            for (PdfName next : h2.G0()) {
                if (J6.contains(next)) {
                    pdfDictionary.V0(next, h2.d0(next));
                }
            }
            pdfDictionary.V0(H6, new PdfNumber(item.j(i2).intValue() + 1));
            arrayList.add(pdfDictionary);
        }
    }

    private ArrayList<PdfIndirectReference> r3(HashSet<RefKey> hashSet) {
        PdfObject d0;
        ArrayList<PdfIndirectReference> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList(hashSet);
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            PdfIndirectObject pdfIndirectObject = this.h6.get(arrayList2.get(i2));
            if (pdfIndirectObject != null && pdfIndirectObject.f26232c.z() && (d0 = ((PdfDictionary) pdfIndirectObject.f26232c).d0(PdfName.tc)) != null && d0.W() == 0) {
                PdfIndirectReference pdfIndirectReference = (PdfIndirectReference) d0;
                RefKey refKey = new RefKey(pdfIndirectReference);
                if (!hashSet.contains(refKey)) {
                    hashSet.add(refKey);
                    arrayList2.add(refKey);
                    arrayList.add(pdfIndirectReference);
                }
            }
        }
        return arrayList;
    }

    private void s3(ArrayList<PdfIndirectReference> arrayList, HashSet<RefKey> hashSet, HashSet<PdfName> hashSet2) {
        PdfObject pdfObject;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            PdfIndirectObject pdfIndirectObject = this.h6.get(new RefKey(arrayList.get(i2)));
            if (!(pdfIndirectObject == null || (pdfObject = pdfIndirectObject.f26232c) == null)) {
                int W = pdfObject.W();
                if (W == 0) {
                    v3((PdfIndirectReference) pdfIndirectObject.f26232c, arrayList, hashSet);
                } else if (W == 5) {
                    t3((PdfArray) pdfIndirectObject.f26232c, arrayList, hashSet, hashSet2);
                } else if (W == 6 || W == 7) {
                    u3((PdfDictionary) pdfIndirectObject.f26232c, arrayList, hashSet, hashSet2);
                }
            }
        }
    }

    private void t3(PdfArray pdfArray, ArrayList<PdfIndirectReference> arrayList, HashSet<RefKey> hashSet, HashSet<PdfName> hashSet2) {
        Iterator<PdfObject> it2 = pdfArray.iterator();
        while (it2.hasNext()) {
            PdfObject next = it2.next();
            int W = next.W();
            if (W == 0) {
                v3((PdfIndirectReference) next, arrayList, hashSet);
            } else if (W == 5) {
                t3((PdfArray) next, arrayList, hashSet, hashSet2);
            } else if (W == 6 || W == 7) {
                u3((PdfDictionary) next, arrayList, hashSet, hashSet2);
            }
        }
    }

    private void u3(PdfDictionary pdfDictionary, ArrayList<PdfIndirectReference> arrayList, HashSet<RefKey> hashSet, HashSet<PdfName> hashSet2) {
        if (!d3(pdfDictionary, hashSet)) {
            for (PdfName next : pdfDictionary.G0()) {
                PdfObject d0 = pdfDictionary.d0(next);
                if (!next.equals(PdfName.tc)) {
                    if (!next.equals(PdfName.K4)) {
                        int W = d0.W();
                        if (W == 0) {
                            v3((PdfIndirectReference) d0, arrayList, hashSet);
                        } else if (W == 5) {
                            t3((PdfArray) d0, arrayList, hashSet, hashSet2);
                        } else if (W == 6 || W == 7) {
                            u3((PdfDictionary) d0, arrayList, hashSet, hashSet2);
                        }
                    } else if (d0.q()) {
                        Iterator<PdfObject> it2 = ((PdfArray) d0).iterator();
                        while (it2.hasNext()) {
                            PdfObject next2 = it2.next();
                            if (next2.E()) {
                                hashSet2.add((PdfName) next2);
                            }
                        }
                    } else if (d0.E()) {
                        hashSet2.add((PdfName) d0);
                    }
                }
            }
        }
    }

    private void v3(PdfIndirectReference pdfIndirectReference, ArrayList<PdfIndirectReference> arrayList, HashSet<RefKey> hashSet) {
        RefKey refKey = new RefKey(pdfIndirectReference);
        PdfIndirectObject pdfIndirectObject = this.h6.get(refKey);
        if ((pdfIndirectObject == null || !pdfIndirectObject.f26232c.z() || !d3((PdfDictionary) pdfIndirectObject.f26232c, hashSet)) && !hashSet.contains(refKey)) {
            hashSet.add(refKey);
            arrayList.add(pdfIndirectReference);
        }
    }

    private void w3(ArrayList<PdfIndirectReference> arrayList, HashSet<RefKey> hashSet) {
        PdfDictionary pdfDictionary;
        PdfObject d0;
        PdfArray e0;
        PdfName pdfName;
        PdfObject d02;
        Iterator<PdfIndirectReference> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            PdfIndirectObject pdfIndirectObject = this.h6.get(new RefKey(it2.next()));
            if (pdfIndirectObject != null && pdfIndirectObject.f26232c.z() && (d0 = pdfDictionary.d0(PdfName.Rc)) != null && !hashSet.contains(new RefKey((PdfIndirectReference) d0)) && (e0 = pdfDictionary.e0(PdfName.ga)) != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= e0.size()) {
                        break;
                    }
                    PdfObject T0 = e0.T0(i2);
                    if (T0.W() == 0) {
                        PdfIndirectObject pdfIndirectObject2 = this.h6.get(new RefKey((PdfIndirectReference) T0));
                        if (pdfIndirectObject2 != null && pdfIndirectObject2.f26232c.z() && (d02 = ((PdfDictionary) pdfIndirectObject2.f26232c).d0(pdfName)) != null && hashSet.contains(new RefKey((PdfIndirectReference) d02))) {
                            (pdfDictionary = (PdfDictionary) pdfIndirectObject.f26232c).V0((pdfName = PdfName.Rc), d02);
                            break;
                        }
                    } else {
                        e0.U0(i2);
                        i2--;
                    }
                    i2++;
                }
            }
        }
    }

    public void A2(PdfPageEvent pdfPageEvent) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
        if (r2 != 1) goto L_0x0062;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.pdf.PdfImportedPage C3(com.itextpdf.text.pdf.PdfReader r5, int r6, boolean r7) throws com.itextpdf.text.pdf.BadPdfFormatException {
        /*
            r4 = this;
            r0 = 0
            r1 = 1
            boolean r2 = r4.l6
            if (r2 == 0) goto L_0x001d
            boolean r3 = r4.z6
            if (r3 == 0) goto L_0x000b
            goto L_0x001d
        L_0x000b:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.Object[] r6 = new java.lang.Object[r1]
            java.lang.String r7 = "getImportedPage"
            r6[r0] = r7
            java.lang.String r7 = "1.method.cannot.be.used.in.mergeFields.mode.please.use.addDocument"
            java.lang.String r6 = com.itextpdf.text.error_messages.MessageLocalization.b(r7, r6)
            r5.<init>(r6)
            throw r5
        L_0x001d:
            r4.k6 = r0
            if (r7 != 0) goto L_0x0032
            if (r2 == 0) goto L_0x002d
            com.itextpdf.text.pdf.PdfCopy$ImportedPage r7 = new com.itextpdf.text.pdf.PdfCopy$ImportedPage
            r7.<init>(r5, r6, r2)
            java.util.ArrayList<com.itextpdf.text.pdf.PdfCopy$ImportedPage> r0 = r4.j6
            r0.add(r7)
        L_0x002d:
            com.itextpdf.text.pdf.PdfImportedPage r5 = r4.D3(r5, r6)
            return r5
        L_0x0032:
            com.itextpdf.text.pdf.PdfStructTreeController r7 = r4.e6
            if (r7 == 0) goto L_0x003e
            com.itextpdf.text.pdf.PdfReader r2 = r7.f26342e
            if (r5 == r2) goto L_0x0045
            r7.o(r5)
            goto L_0x0045
        L_0x003e:
            com.itextpdf.text.pdf.PdfStructTreeController r7 = new com.itextpdf.text.pdf.PdfStructTreeController
            r7.<init>(r5, r4)
            r4.e6 = r7
        L_0x0045:
            com.itextpdf.text.pdf.PdfCopy$ImportedPage r7 = new com.itextpdf.text.pdf.PdfCopy$ImportedPage
            boolean r2 = r4.l6
            r7.<init>(r5, r6, r2)
            int r2 = r4.b3(r7)
            r3 = -1
            if (r2 == r3) goto L_0x005e
            if (r2 == 0) goto L_0x005b
            if (r2 == r1) goto L_0x0058
            goto L_0x0062
        L_0x0058:
            r4.k6 = r1
            goto L_0x0062
        L_0x005b:
            r4.k6 = r0
            goto L_0x0062
        L_0x005e:
            r4.c3(r5)
            goto L_0x0058
        L_0x0062:
            java.util.ArrayList<com.itextpdf.text.pdf.PdfCopy$ImportedPage> r0 = r4.j6
            r0.add(r7)
            java.util.HashSet<com.itextpdf.text.pdf.PdfObject> r7 = r4.Y5
            r7.clear()
            java.util.HashMap<com.itextpdf.text.pdf.PdfObject, com.itextpdf.text.pdf.PdfObject> r7 = r4.X5
            r7.clear()
            com.itextpdf.text.pdf.PdfImportedPage r5 = r4.D3(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfCopy.C3(com.itextpdf.text.pdf.PdfReader, int, boolean):com.itextpdf.text.pdf.PdfImportedPage");
    }

    /* access modifiers changed from: protected */
    public void D0(PdfIndirectObject pdfIndirectObject) {
        if ((this.R3 || this.l6) && this.h6 != null) {
            this.i6.add(pdfIndirectObject);
            RefKey refKey = new RefKey(pdfIndirectObject.f26230a, pdfIndirectObject.f26231b);
            if (!this.h6.containsKey(refKey)) {
                this.h6.put(refKey, pdfIndirectObject);
            }
        }
    }

    /* access modifiers changed from: protected */
    public PdfImportedPage D3(PdfReader pdfReader, int i2) {
        PdfReaderInstance pdfReaderInstance = this.I3;
        if (pdfReaderInstance == null || pdfReaderInstance.d() != pdfReader) {
            this.I3 = super.E1(pdfReader);
        }
        return this.I3.b(i2);
    }

    /* access modifiers changed from: protected */
    public PdfName E3(PdfDictionary pdfDictionary) {
        return PdfName.Xb;
    }

    public boolean H3() {
        return this.b6;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r4.g6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean I3(com.itextpdf.text.pdf.PdfIndirectReference r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L_0x0015
            com.itextpdf.text.pdf.PRIndirectReference r1 = r4.g6
            if (r1 != 0) goto L_0x0008
            goto L_0x0015
        L_0x0008:
            int r2 = r5.i3
            int r3 = r1.i3
            if (r2 != r3) goto L_0x0015
            int r5 = r5.j3
            int r1 = r1.j3
            if (r5 != r1) goto L_0x0015
            r0 = 1
        L_0x0015:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfCopy.I3(com.itextpdf.text.pdf.PdfIndirectReference):boolean");
    }

    /* access modifiers changed from: protected */
    public int P3(PdfImportedPage pdfImportedPage) {
        int b4 = pdfImportedPage.b4();
        PdfReaderInstance c4 = pdfImportedPage.c4();
        this.I3 = c4;
        PdfReader d2 = c4.d();
        this.Z5 = d2;
        Q3(d2);
        return b4;
    }

    /* access modifiers changed from: protected */
    public void Q3(PdfReader pdfReader) {
        this.Z5 = pdfReader;
        HashMap<RefKey, IndirectReferences> hashMap = this.W5.get(pdfReader);
        this.V5 = hashMap;
        if (hashMap == null) {
            HashMap<RefKey, IndirectReferences> hashMap2 = new HashMap<>();
            this.V5 = hashMap2;
            this.W5.put(pdfReader, hashMap2);
        }
    }

    public void R3() {
        this.l6 = true;
        this.r6 = new PdfDictionary();
        this.s6 = new ArrayList<>();
        this.t6 = new ArrayList<>();
        this.u6 = new LinkedHashMap();
        this.v6 = new HashMap<>();
        this.w6 = new HashMap<>();
        this.x6 = new HashMap<>();
        this.y6 = new HashSet<>();
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference S(PdfPage pdfPage, PdfContents pdfContents) throws PdfException {
        return null;
    }

    /* access modifiers changed from: protected */
    public void S0() throws IOException, BadPdfFormatException {
        PdfArray e0;
        if (this.l6) {
            try {
                Iterator<ImportedPage> it2 = this.j6.iterator();
                while (it2.hasNext()) {
                    ImportedPage next = it2.next();
                    PdfDictionary h0 = next.f26164b.h0(next.f26163a);
                    if (!(h0 == null || (e0 = h0.e0(PdfName.Q3)) == null)) {
                        if (e0.size() != 0) {
                            for (AcroFields.Item item : next.f26164b.C().t().values()) {
                                Iterator<PdfIndirectReference> it3 = item.f25846c.iterator();
                                while (it3.hasNext()) {
                                    e0.i3.remove(it3.next());
                                }
                            }
                            this.V5 = this.W5.get(next.f26164b);
                            Iterator<PdfObject> it4 = e0.i3.iterator();
                            while (it4.hasNext()) {
                                next.f26165c.a0(l3(it4.next()));
                            }
                        }
                    }
                }
                for (PdfReader t1 : this.W5.keySet()) {
                    t1.t1();
                }
                L3();
                o3();
                if (this.R3) {
                    return;
                }
            } catch (ClassCastException unused) {
                if (this.R3) {
                    return;
                }
            } catch (Throwable th) {
                if (!this.R3) {
                    z3();
                }
                throw th;
            }
            z3();
        }
    }

    public PdfIndirectReference S2(PdfOutline pdfOutline) {
        return null;
    }

    public void S3(boolean z) {
        this.b6 = z;
    }

    /* access modifiers changed from: protected */
    public void T0() throws IOException {
        try {
            y3();
        } catch (ClassCastException unused) {
        } catch (Throwable th) {
            z3();
            throw th;
        }
        z3();
    }

    public void T2(PdfReader pdfReader) throws DocumentException, IOException {
        PdfArray e0;
        if (!this.X.F()) {
            throw new DocumentException(MessageLocalization.b("the.document.is.not.open.yet.you.can.only.add.meta.information", new Object[0]));
        } else if (this.W5.containsKey(pdfReader)) {
            throw new IllegalArgumentException(MessageLocalization.b("document.1.has.already.been.added", pdfReader.toString()));
        } else if (pdfReader.R0()) {
            if (this.l6) {
                pdfReader.n();
                pdfReader.K1();
                for (int i2 = 1; i2 <= pdfReader.c0(); i2++) {
                    PdfDictionary i0 = pdfReader.i0(i2);
                    if (i0 != null) {
                        PdfName pdfName = PdfName.Q3;
                        if (i0.a0(pdfName) && (e0 = i0.e0(pdfName)) != null) {
                            for (int i3 = 0; i3 < e0.size(); i3++) {
                                PdfDictionary B0 = e0.B0(i3);
                                if (B0 != null) {
                                    PdfName pdfName2 = F6;
                                    int i4 = G6 + 1;
                                    G6 = i4;
                                    B0.V0(pdfName2, new PdfNumber(i4));
                                }
                            }
                        }
                    }
                }
                AcroFields C = pdfReader.C();
                if (!C.J()) {
                    this.m6 = true;
                }
                this.s6.add(C);
                V3(pdfReader);
            }
            boolean z = this.R3 && PdfStructTreeController.f(pdfReader);
            this.z6 = true;
            for (int i5 = 1; i5 <= pdfReader.c0(); i5++) {
                X2(C3(pdfReader, i5, z));
            }
            this.z6 = false;
        } else {
            throw new BadPasswordException(MessageLocalization.b("pdfreader.not.opened.with.owner.password", new Object[0]));
        }
    }

    /* access modifiers changed from: protected */
    public void T3(PdfReader pdfReader) {
        this.C6.add(pdfReader);
    }

    public void U0(PdfReader pdfReader) throws IOException {
        if (!this.l6) {
            PdfArray e0 = pdfReader.a3.e0(PdfName.A9);
            if (e0 != null) {
                this.u3 = e0.P0(0).k();
            }
            this.W5.remove(pdfReader);
            this.I3 = null;
            super.U0(pdfReader);
            return;
        }
        throw new UnsupportedOperationException(MessageLocalization.b("it.is.not.possible.to.free.reader.in.merge.fields.mode", new Object[0]));
    }

    public void U2(PdfReader pdfReader, List<Integer> list) throws DocumentException, IOException {
        if (!this.W5.containsKey(pdfReader)) {
            pdfReader.C1(list, false);
            T2(pdfReader);
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.b("document.1.has.already.been.added", pdfReader.toString()));
    }

    public void W2(Rectangle rectangle, int i2) throws DocumentException {
        if (!this.l6 || this.z6) {
            PdfPage pdfPage = new PdfPage(new PdfRectangle(rectangle, i2), new HashMap(), new PageResources().k(), 0);
            pdfPage.V0(PdfName.Lf, M1());
            this.n3.a(pdfPage);
            int i3 = this.p3 + 1;
            this.p3 = i3;
            this.h3.t(i3);
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.b("1.method.cannot.be.used.in.mergeFields.mode.please.use.addDocument", "addPage"));
    }

    /* access modifiers changed from: protected */
    public PdfDictionary X0(PdfIndirectReference pdfIndirectReference) {
        PdfIndirectReference pdfIndirectReference2;
        try {
            PdfDocument.PdfCatalog w0 = this.h3.w0(pdfIndirectReference);
            C0(w0);
            if (this.c6 != null) {
                V2(w0);
            } else if (this.l6 && (pdfIndirectReference2 = this.o6) != null) {
                w0.V0(PdfName.p3, pdfIndirectReference2);
            }
            return w0;
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public void X2(PdfImportedPage pdfImportedPage) throws IOException, BadPdfFormatException {
        if (!this.l6 || this.z6) {
            int P3 = P3(pdfImportedPage);
            PdfDictionary h0 = this.Z5.h0(P3);
            PRIndirectReference j0 = this.Z5.j0(P3);
            this.Z5.r1(P3);
            RefKey refKey = new RefKey(j0);
            IndirectReferences indirectReferences = this.V5.get(refKey);
            if (indirectReferences != null && !indirectReferences.a()) {
                this.o3.add(indirectReferences.b());
                indirectReferences.c();
            }
            PdfIndirectReference d1 = d1();
            if (indirectReferences == null) {
                indirectReferences = new IndirectReferences(d1);
                this.V5.put(refKey, indirectReferences);
            }
            indirectReferences.c();
            if (this.R3) {
                this.g6 = (PRIndirectReference) this.Z5.F().d0(PdfName.xf);
            }
            PdfDictionary g3 = g3(h0);
            if (this.l6) {
                ArrayList<ImportedPage> arrayList = this.j6;
                PdfIndirectReference j2 = this.k3.j();
                arrayList.get(arrayList.size() - 1).f26166d = j2;
                g3.V0(PdfName.Q3, j2);
            }
            this.n3.a(g3);
            pdfImportedPage.f4();
            int i2 = this.p3 + 1;
            this.p3 = i2;
            this.h3.t(i2);
            this.g6 = null;
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.b("1.method.cannot.be.used.in.mergeFields.mode.please.use.addDocument", "addPage"));
    }

    /* access modifiers changed from: protected */
    public Counter b1() {
        return E6;
    }

    public void close() {
        if (this.Z) {
            this.h3.close();
            super.close();
        }
    }

    /* access modifiers changed from: protected */
    public PdfArray e3(PdfArray pdfArray) throws IOException, BadPdfFormatException {
        return f3(pdfArray, false, false);
    }

    /* access modifiers changed from: protected */
    public PdfArray f3(PdfArray pdfArray, boolean z, boolean z2) throws IOException, BadPdfFormatException {
        PdfArray pdfArray2 = new PdfArray(pdfArray.size());
        ListIterator<PdfObject> listIterator = pdfArray.listIterator();
        while (listIterator.hasNext()) {
            PdfObject next = listIterator.next();
            this.X5.put(next, pdfArray);
            PdfObject m3 = m3(next, z, z2);
            if (m3 != null) {
                pdfArray2.a0(m3);
            }
        }
        return pdfArray2;
    }

    /* access modifiers changed from: protected */
    public PdfDictionary g3(PdfDictionary pdfDictionary) throws IOException, BadPdfFormatException {
        return h3(pdfDictionary, false, false);
    }

    /* access modifiers changed from: protected */
    public PdfDictionary h3(PdfDictionary pdfDictionary, boolean z, boolean z2) throws IOException, BadPdfFormatException {
        PdfObject m3;
        PdfDictionary pdfDictionary2 = new PdfDictionary(pdfDictionary.size());
        PdfObject w0 = PdfReader.w0(pdfDictionary.d0(PdfName.Kg));
        if (z) {
            if (z2) {
                boolean a0 = pdfDictionary.a0(PdfName.Rc);
                Object obj = pdfDictionary;
                if (a0) {
                    while (true) {
                        this.Y5.add(obj);
                        if (!this.X5.containsKey(obj) || this.Y5.contains(obj)) {
                            return null;
                        }
                        obj = (PdfObject) this.X5.get(obj);
                    }
                }
            }
            this.e6.d(pdfDictionary.p0(PdfName.Ce));
            this.e6.a(pdfDictionary);
        }
        PdfStructTreeController pdfStructTreeController = this.e6;
        if (!(pdfStructTreeController == null || pdfStructTreeController.f26342e == null)) {
            PdfName pdfName = PdfName.wf;
            if (pdfDictionary.a0(pdfName) || pdfDictionary.a0(PdfName.vf)) {
                PdfName pdfName2 = PdfName.vf;
                if (!pdfDictionary.a0(pdfName)) {
                    pdfName = pdfName2;
                }
                PdfObject d0 = pdfDictionary.d0(pdfName);
                pdfDictionary2.V0(pdfName, new PdfNumber(this.f6));
                int i2 = this.f6;
                this.f6 = i2 + 1;
                this.e6.i((PdfNumber) d0, i2);
            }
        }
        for (PdfName next : pdfDictionary.G0()) {
            PdfObject d02 = pdfDictionary.d0(next);
            PdfStructTreeController pdfStructTreeController2 = this.e6;
            if (pdfStructTreeController2 == null || pdfStructTreeController2.f26342e == null || (!next.equals(PdfName.wf) && !next.equals(PdfName.vf))) {
                if (!PdfName.uc.equals(w0)) {
                    m3 = (!this.R3 || !d02.C() || !I3((PRIndirectReference) d02)) ? m3(d02, z, z2) : this.T3.o1();
                    if (m3 == null) {
                    }
                } else if (!next.equals(PdfName.h4) && !next.equals(PdfName.Dc)) {
                    this.X5.put(d02, pdfDictionary);
                    m3 = m3(d02, z, z2);
                    if (m3 == null) {
                    }
                }
                pdfDictionary2.V0(next, m3);
            }
        }
        return pdfDictionary2;
    }

    public void i3(PdfReader pdfReader) throws DocumentException, IOException {
        PdfStructTreeController pdfStructTreeController;
        PdfArray e0;
        if (!this.X.F()) {
            throw new DocumentException(MessageLocalization.b("the.document.is.not.open.yet.you.can.only.add.meta.information", new Object[0]));
        } else if (this.W5.containsKey(pdfReader)) {
            throw new IllegalArgumentException(MessageLocalization.b("document.1.has.already.been.added", pdfReader.toString()));
        } else if (!pdfReader.R0()) {
            throw new BadPasswordException(MessageLocalization.b("pdfreader.not.opened.with.owner.password", new Object[0]));
        } else if (this.l6) {
            HashMap<RefKey, IndirectReferences> hashMap = new HashMap<>();
            this.V5 = hashMap;
            this.W5.put(pdfReader, hashMap);
            pdfReader.n();
            pdfReader.K1();
            if (this.R3 && PdfStructTreeController.f(pdfReader)) {
                this.g6 = (PRIndirectReference) pdfReader.F().d0(PdfName.xf);
                PdfStructTreeController pdfStructTreeController2 = this.e6;
                if (pdfStructTreeController2 == null) {
                    this.e6 = new PdfStructTreeController(pdfReader, this);
                } else if (pdfReader != pdfStructTreeController2.f26342e) {
                    pdfStructTreeController2.o(pdfReader);
                }
            }
            ArrayList<PdfObject> arrayList = new ArrayList<>();
            for (int i2 = 1; i2 <= pdfReader.c0(); i2++) {
                PdfDictionary i0 = pdfReader.i0(i2);
                if (i0 != null) {
                    PdfName pdfName = PdfName.Q3;
                    if (i0.a0(pdfName) && (e0 = i0.e0(pdfName)) != null && e0.size() > 0) {
                        if (this.j6.size() >= i2) {
                            this.W5.get(pdfReader).put(new RefKey(pdfReader.c3.d(i2)), new IndirectReferences(this.o3.get(i2 - 1)));
                            for (int i3 = 0; i3 < e0.size(); i3++) {
                                PdfDictionary B0 = e0.B0(i3);
                                if (B0 != null) {
                                    PdfName pdfName2 = F6;
                                    int i4 = G6 + 1;
                                    G6 = i4;
                                    B0.V0(pdfName2, new PdfNumber(i4));
                                    arrayList.add(e0.T0(i3));
                                }
                            }
                        } else {
                            throw new DocumentException(MessageLocalization.b("there.are.not.enough.imported.pages.for.copied.fields", new Object[0]));
                        }
                    }
                }
            }
            for (PdfObject l3 : arrayList) {
                l3(l3);
            }
            if (this.R3 && (pdfStructTreeController = this.e6) != null) {
                pdfStructTreeController.e((PdfObject) null);
            }
            AcroFields C = pdfReader.C();
            if (!C.J()) {
                this.m6 = true;
            }
            this.s6.add(C);
            V3(pdfReader);
            this.g6 = null;
        } else {
            throw new IllegalArgumentException(MessageLocalization.b("1.method.can.be.only.used.in.mergeFields.mode.please.use.addDocument", "copyDocumentFields"));
        }
    }

    /* access modifiers changed from: protected */
    public PdfIndirectReference j3(PRIndirectReference pRIndirectReference) throws IOException, BadPdfFormatException {
        return k3(pRIndirectReference, false, false);
    }

    /* access modifiers changed from: protected */
    public PdfIndirectReference k3(PRIndirectReference pRIndirectReference, boolean z, boolean z2) throws IOException, BadPdfFormatException {
        PdfIndirectReference pdfIndirectReference;
        PdfObject w0;
        RefKey refKey = new RefKey(pRIndirectReference);
        IndirectReferences indirectReferences = this.V5.get(refKey);
        PdfObject w02 = PdfReader.w0(pRIndirectReference);
        if (z && z2 && (w02 instanceof PdfDictionary) && ((PdfDictionary) w02).a0(PdfName.Rc)) {
            return null;
        }
        if (indirectReferences != null) {
            pdfIndirectReference = indirectReferences.b();
            if (indirectReferences.a()) {
                return pdfIndirectReference;
            }
        } else {
            pdfIndirectReference = this.k3.j();
            indirectReferences = new IndirectReferences(pdfIndirectReference);
            this.V5.put(refKey, indirectReferences);
        }
        if (!(w02 == null || !w02.z() || (w0 = PdfReader.w0(((PdfDictionary) w02).d0(PdfName.Kg))) == null)) {
            if (PdfName.uc.equals(w0)) {
                return pdfIndirectReference;
            }
            if (PdfName.U4.equals(w0)) {
                D6.g(MessageLocalization.b("make.copy.of.catalog.dictionary.is.forbidden", new Object[0]));
                return null;
            }
        }
        indirectReferences.c();
        if (w02 != null) {
            this.X5.put(w02, pRIndirectReference);
        }
        PdfObject m3 = m3(w02, z, z2);
        if (this.Y5.contains(w02)) {
            indirectReferences.d();
        }
        if (m3 != null) {
            y0(m3, pdfIndirectReference);
            return pdfIndirectReference;
        }
        this.V5.remove(refKey);
        return null;
    }

    /* access modifiers changed from: protected */
    public PdfObject l3(PdfObject pdfObject) throws IOException, BadPdfFormatException {
        return m3(pdfObject, false, false);
    }

    public PdfImportedPage m1(PdfReader pdfReader, int i2) {
        boolean z = this.l6;
        if (!z || this.z6) {
            if (z) {
                this.j6.add(new ImportedPage(pdfReader, i2, z));
            }
            PdfStructTreeController pdfStructTreeController = this.e6;
            if (pdfStructTreeController != null) {
                pdfStructTreeController.f26342e = null;
            }
            this.Y5.clear();
            this.X5.clear();
            return D3(pdfReader, i2);
        }
        throw new IllegalArgumentException(MessageLocalization.b("1.method.cannot.be.used.in.mergeFields.mode.please.use.addDocument", "getImportedPage"));
    }

    /* access modifiers changed from: protected */
    public PdfObject m3(PdfObject pdfObject, boolean z, boolean z2) throws IOException, BadPdfFormatException {
        if (pdfObject == null) {
            return PdfNull.i3;
        }
        int i2 = pdfObject.X;
        switch (i2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 8:
                return pdfObject;
            case 5:
                return f3((PdfArray) pdfObject, z, z2);
            case 6:
                return h3((PdfDictionary) pdfObject, z, z2);
            case 7:
                return n3((PRStream) pdfObject);
            case 10:
                return (z || z2) ? k3((PRIndirectReference) pdfObject, z, z2) : j3((PRIndirectReference) pdfObject);
            default:
                if (i2 < 0) {
                    String pdfObject2 = ((PdfLiteral) pdfObject).toString();
                    return (pdfObject2.equals(PdfBoolean.l3) || pdfObject2.equals("false")) ? new PdfBoolean(pdfObject2) : new PdfLiteral(pdfObject2);
                }
                PrintStream printStream = System.out;
                printStream.println("CANNOT COPY type " + pdfObject.X);
                return null;
        }
    }

    /* access modifiers changed from: protected */
    public PdfStream n3(PRStream pRStream) throws IOException, BadPdfFormatException {
        PRStream pRStream2 = new PRStream(pRStream, (PdfDictionary) null);
        for (PdfName next : pRStream.G0()) {
            PdfObject d0 = pRStream.d0(next);
            this.X5.put(d0, pRStream);
            PdfObject l3 = l3(d0);
            if (l3 != null) {
                pRStream2.V0(next, l3);
            }
        }
        return pRStream2;
    }

    public PageStamp p3(PdfImportedPage pdfImportedPage) {
        int b4 = pdfImportedPage.b4();
        PdfReader d2 = pdfImportedPage.c4().d();
        if (!X1()) {
            return new PageStamp(d2, d2.h0(b4), this);
        }
        throw new RuntimeException(MessageLocalization.b("creating.page.stamp.not.allowed.for.tagged.reader", new Object[0]));
    }

    public void u(PdfAnnotation pdfAnnotation) {
    }

    /* access modifiers changed from: protected */
    public void x3(HashSet<RefKey> hashSet, HashSet<PdfName> hashSet2) {
        HashMap<PdfName, PdfObject> hashMap = new HashMap<>(hashSet2.size());
        Iterator<PdfName> it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            PdfName next = it2.next();
            PdfObject pdfObject = this.T3.s3.get(next);
            if (pdfObject != null) {
                hashMap.put(next, pdfObject);
            }
        }
        PdfStructureTreeRoot pdfStructureTreeRoot = this.T3;
        pdfStructureTreeRoot.s3 = hashMap;
        PdfArray e0 = pdfStructureTreeRoot.e0(PdfName.ga);
        if (e0 != null) {
            int i2 = 0;
            while (i2 < e0.size()) {
                if (!hashSet.contains(new RefKey((PdfIndirectReference) e0.T0(i2)))) {
                    e0.U0(i2);
                    i2--;
                }
                i2++;
            }
        }
    }

    public PdfIndirectObject y0(PdfObject pdfObject, PdfIndirectReference pdfIndirectReference) throws IOException {
        return z0(pdfObject, pdfIndirectReference, false);
    }

    /* access modifiers changed from: protected */
    public void y3() throws IOException {
        PdfObject d0;
        PdfDictionary n2;
        PdfIndirectReference pdfIndirectReference;
        HashMap<Integer, PdfIndirectReference> n1 = this.T3.n1();
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        if (this.l6 && (pdfIndirectReference = this.o6) != null) {
            arrayList.add(pdfIndirectReference);
            hashSet.add(new RefKey(this.o6));
        }
        Iterator<PdfIndirectReference> it2 = this.o3.iterator();
        while (it2.hasNext()) {
            PdfIndirectReference next = it2.next();
            arrayList.add(next);
            hashSet.add(new RefKey(next));
        }
        int size = n1.size() - 1;
        int i2 = 0;
        while (true) {
            PdfIndirectReference pdfIndirectReference2 = null;
            if (size < 0) {
                break;
            }
            PdfIndirectReference pdfIndirectReference3 = n1.get(Integer.valueOf(size));
            if (pdfIndirectReference3 != null) {
                RefKey refKey = new RefKey(pdfIndirectReference3);
                PdfObject pdfObject = this.h6.get(refKey).f26232c;
                if (pdfObject.z()) {
                    ArrayList<PdfIndirectReference> arrayList2 = this.o3;
                    PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
                    PdfName pdfName = PdfName.Rc;
                    if (!arrayList2.contains(pdfDictionary.d0(pdfName)) && ((n2 = PdfStructTreeController.n(pdfDictionary)) == null || !this.o3.contains(n2.d0(pdfName)))) {
                        n1.remove(Integer.valueOf(size));
                    } else {
                        hashSet.add(refKey);
                        arrayList.add(pdfIndirectReference3);
                    }
                } else if (pdfObject.q()) {
                    hashSet.add(refKey);
                    arrayList.add(pdfIndirectReference3);
                    PdfArray pdfArray = (PdfArray) pdfObject;
                    int i3 = i2 + 1;
                    PdfIndirectReference pdfIndirectReference4 = this.o3.get(i2);
                    arrayList.add(pdfIndirectReference4);
                    hashSet.add(new RefKey(pdfIndirectReference4));
                    for (int i4 = 0; i4 < pdfArray.size(); i4++) {
                        PdfIndirectReference pdfIndirectReference5 = (PdfIndirectReference) pdfArray.Q0(i4);
                        if (!pdfIndirectReference5.equals(pdfIndirectReference2)) {
                            RefKey refKey2 = new RefKey(pdfIndirectReference5);
                            hashSet.add(refKey2);
                            arrayList.add(pdfIndirectReference5);
                            PdfIndirectObject pdfIndirectObject = this.h6.get(refKey2);
                            if (pdfIndirectObject.f26232c.z()) {
                                PdfDictionary pdfDictionary2 = (PdfDictionary) pdfIndirectObject.f26232c;
                                PdfName pdfName2 = PdfName.Rc;
                                PdfIndirectReference pdfIndirectReference6 = (PdfIndirectReference) pdfDictionary2.d0(pdfName2);
                                if (pdfIndirectReference6 != null && !this.o3.contains(pdfIndirectReference6) && !pdfIndirectReference6.equals(pdfIndirectReference4)) {
                                    pdfDictionary2.V0(pdfName2, pdfIndirectReference4);
                                    PdfArray e0 = pdfDictionary2.e0(PdfName.ga);
                                    if (e0 != null && e0.Q0(0).I()) {
                                        e0.U0(0);
                                    }
                                }
                            }
                            pdfIndirectReference2 = pdfIndirectReference5;
                        }
                    }
                    i2 = i3;
                }
            }
            size--;
        }
        HashSet hashSet2 = new HashSet();
        s3(arrayList, hashSet, hashSet2);
        w3(r3(hashSet), hashSet);
        x3(hashSet, hashSet2);
        for (Map.Entry next2 : this.h6.entrySet()) {
            if (!hashSet.contains(next2.getKey())) {
                next2.setValue((Object) null);
            } else {
                if (((PdfIndirectObject) next2.getValue()).f26232c.q()) {
                    d0 = ((PdfIndirectObject) next2.getValue()).f26232c;
                } else if (((PdfIndirectObject) next2.getValue()).f26232c.z()) {
                    d0 = ((PdfDictionary) ((PdfIndirectObject) next2.getValue()).f26232c).d0(PdfName.ga);
                    if (d0 != null) {
                        if (!d0.q()) {
                        }
                    }
                }
                O3((PdfArray) d0, hashSet);
            }
        }
    }

    public PdfIndirectObject z0(PdfObject pdfObject, PdfIndirectReference pdfIndirectReference, boolean z) throws IOException {
        PdfIndirectObject pdfIndirectObject;
        PdfNumber q0;
        if (z) {
            W3(pdfObject);
        }
        if ((this.R3 || this.l6) && this.h6 != null && (pdfObject.q() || pdfObject.z() || pdfObject.K() || pdfObject.H())) {
            RefKey refKey = new RefKey(pdfIndirectReference);
            pdfIndirectObject = this.h6.get(refKey);
            if (pdfIndirectObject == null) {
                pdfIndirectObject = new PdfIndirectObject(pdfIndirectReference, pdfObject, (PdfWriter) this);
                this.h6.put(refKey, pdfIndirectObject);
            }
        } else {
            pdfIndirectObject = super.y0(pdfObject, pdfIndirectReference);
        }
        if (this.l6 && pdfObject.z() && (q0 = ((PdfDictionary) pdfObject).q0(F6)) != null) {
            if (z) {
                this.x6.put(Integer.valueOf(q0.e0()), pdfIndirectObject);
                this.y6.add(pdfIndirectObject);
            } else {
                this.v6.put(Integer.valueOf(q0.e0()), pdfIndirectObject);
                this.w6.put(new RefKey(pdfIndirectObject.f26230a, pdfIndirectObject.f26231b), pdfIndirectObject);
            }
        }
        return pdfIndirectObject;
    }

    /* access modifiers changed from: protected */
    public void z3() throws IOException {
        Iterator<PdfIndirectObject> it2 = this.i6.iterator();
        while (it2.hasNext()) {
            PdfIndirectObject next = it2.next();
            this.h6.remove(new RefKey(next.f26230a, next.f26231b));
        }
        HashSet hashSet = new HashSet();
        for (Map.Entry next2 : this.h6.entrySet()) {
            if (next2.getValue() != null) {
                X3((PdfIndirectObject) next2.getValue());
            } else {
                hashSet.add(next2.getKey());
            }
        }
        Iterator it3 = new ArrayList(this.k3.f26366a).iterator();
        while (it3.hasNext()) {
            PdfWriter.PdfBody.PdfCrossReference pdfCrossReference = (PdfWriter.PdfBody.PdfCrossReference) it3.next();
            if (hashSet.contains(new RefKey(pdfCrossReference.b(), 0))) {
                this.k3.f26366a.remove(pdfCrossReference);
            }
        }
        this.h6 = null;
    }
}
