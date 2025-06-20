package com.itextpdf.text.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.BadPasswordException;
import com.itextpdf.text.exceptions.InvalidPdfException;
import com.itextpdf.text.exceptions.UnsupportedPdfException;
import com.itextpdf.text.io.RandomAccessSource;
import com.itextpdf.text.io.RandomAccessSourceFactory;
import com.itextpdf.text.io.WindowRandomAccessSource;
import com.itextpdf.text.log.Counter;
import com.itextpdf.text.log.CounterFactory;
import com.itextpdf.text.log.Level;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.FilterHandlers;
import com.itextpdf.text.pdf.IntHashtable;
import com.itextpdf.text.pdf.PRTokeniser;
import com.itextpdf.text.pdf.PdfAnnotation;
import com.itextpdf.text.pdf.interfaces.PdfViewerPreferences;
import com.itextpdf.text.pdf.internal.PdfViewerPreferencesImp;
import com.itextpdf.text.pdf.security.ExternalDecryptionProcess;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.Key;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.zip.InflaterInputStream;

public class PdfReader implements PdfViewerPreferences {
    public static boolean K3 = false;
    public static boolean L3 = false;
    private static final Logger M3;
    static final PdfName[] N3 = {PdfName.Za, PdfName.te, PdfName.Wd, PdfName.Z5};
    static final byte[] O3 = PdfEncodings.c("endstream", (String) null);
    static final byte[] P3 = PdfEncodings.c("endobj", (String) null);
    protected static Counter Q3;
    private int A3;
    private long B3;
    private boolean C3;
    /* access modifiers changed from: private */
    public int D3;
    /* access modifiers changed from: private */
    public boolean E3;
    private PRIndirectReference F3;
    private final PdfViewerPreferencesImp G3;
    private boolean H3;
    private boolean I3;
    private int J3;
    protected long[] X;
    protected boolean X2;
    protected HashMap<Integer, IntHashtable> Y;
    protected ArrayList<PdfObject> Y2;
    protected LongHashtable Z;
    PdfDictionary Z2;
    protected PdfDictionary a3;
    protected PdfDictionary b3;
    protected PageRefs c3;
    protected PRAcroForm d3;
    protected boolean e3;
    protected boolean f3;
    protected boolean g3;
    protected int h3;
    protected boolean i3;
    protected long j3;
    protected long k3;
    protected char l3;
    protected PdfEncryption m3;
    protected byte[] n3;
    protected Key o3;
    protected Certificate p3;
    protected String q3;
    protected ExternalDecryptionProcess r3;
    protected PRTokeniser s;
    private boolean s3;
    protected ArrayList<PdfString> t3;
    protected boolean u3;
    protected boolean v3;
    protected boolean w3;
    protected int x3;
    protected long y3;
    private int z3;

    /* renamed from: com.itextpdf.text.pdf.PdfReader$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f26285a;

        static {
            /*
                com.itextpdf.text.pdf.PRTokeniser$TokenType[] r0 = com.itextpdf.text.pdf.PRTokeniser.TokenType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f26285a = r0
                com.itextpdf.text.pdf.PRTokeniser$TokenType r1 = com.itextpdf.text.pdf.PRTokeniser.TokenType.START_DIC     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f26285a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.itextpdf.text.pdf.PRTokeniser$TokenType r1 = com.itextpdf.text.pdf.PRTokeniser.TokenType.START_ARRAY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f26285a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.itextpdf.text.pdf.PRTokeniser$TokenType r1 = com.itextpdf.text.pdf.PRTokeniser.TokenType.NUMBER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f26285a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.itextpdf.text.pdf.PRTokeniser$TokenType r1 = com.itextpdf.text.pdf.PRTokeniser.TokenType.STRING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f26285a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.itextpdf.text.pdf.PRTokeniser$TokenType r1 = com.itextpdf.text.pdf.PRTokeniser.TokenType.NAME     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f26285a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.itextpdf.text.pdf.PRTokeniser$TokenType r1 = com.itextpdf.text.pdf.PRTokeniser.TokenType.REF     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f26285a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.itextpdf.text.pdf.PRTokeniser$TokenType r1 = com.itextpdf.text.pdf.PRTokeniser.TokenType.ENDOFFILE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfReader.AnonymousClass1.<clinit>():void");
        }
    }

    static class PageRefs {

        /* renamed from: a  reason: collision with root package name */
        private final PdfReader f26286a;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<PRIndirectReference> f26287b;

        /* renamed from: c  reason: collision with root package name */
        private int f26288c;

        /* renamed from: d  reason: collision with root package name */
        private IntHashtable f26289d;

        /* renamed from: e  reason: collision with root package name */
        private int f26290e;

        /* renamed from: f  reason: collision with root package name */
        private ArrayList<PdfDictionary> f26291f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f26292g;

        /* renamed from: h  reason: collision with root package name */
        private Set<PdfObject> f26293h;

        PageRefs(PageRefs pageRefs, PdfReader pdfReader) {
            this.f26290e = -1;
            this.f26293h = new HashSet();
            this.f26286a = pdfReader;
            this.f26288c = pageRefs.f26288c;
            if (pageRefs.f26287b != null) {
                this.f26287b = new ArrayList<>(pageRefs.f26287b);
                for (int i2 = 0; i2 < this.f26287b.size(); i2++) {
                    ArrayList<PRIndirectReference> arrayList = this.f26287b;
                    arrayList.set(i2, (PRIndirectReference) PdfReader.w(arrayList.get(i2), pdfReader));
                }
                return;
            }
            this.f26289d = (IntHashtable) pageRefs.f26289d.clone();
        }

        private void h(PRIndirectReference pRIndirectReference) throws IOException {
            int i2 = 0;
            if (this.f26293h.add(PdfReader.t0(pRIndirectReference))) {
                PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.t0(pRIndirectReference);
                if (pdfDictionary != null) {
                    PdfArray e0 = pdfDictionary.e0(PdfName.ia);
                    if (e0 == null) {
                        pdfDictionary.V0(PdfName.Kg, PdfName.uc);
                        ArrayList<PdfDictionary> arrayList = this.f26291f;
                        PdfDictionary pdfDictionary2 = arrayList.get(arrayList.size() - 1);
                        for (PdfName next : pdfDictionary2.G0()) {
                            if (pdfDictionary.d0(next) == null) {
                                pdfDictionary.V0(next, pdfDictionary2.d0(next));
                            }
                        }
                        PdfName pdfName = PdfName.Za;
                        if (pdfDictionary.d0(pdfName) == null) {
                            Rectangle rectangle = PageSize.f25708a;
                            pdfDictionary.V0(pdfName, new PdfArray(new float[]{0.0f, 0.0f, rectangle.Q(), rectangle.T()}));
                        }
                        this.f26287b.add(pRIndirectReference);
                        return;
                    }
                    pdfDictionary.V0(PdfName.Kg, PdfName.zc);
                    k(pdfDictionary);
                    while (true) {
                        if (i2 >= e0.size()) {
                            break;
                        }
                        PdfObject T0 = e0.T0(i2);
                        if (!T0.C()) {
                            while (i2 < e0.size()) {
                                e0.U0(i2);
                            }
                        } else {
                            h((PRIndirectReference) T0);
                            i2++;
                        }
                    }
                    j();
                    return;
                }
                return;
            }
            throw new InvalidPdfException(MessageLocalization.b("illegal.pages.tree", new Object[0]));
        }

        private void j() {
            ArrayList<PdfDictionary> arrayList = this.f26291f;
            arrayList.remove(arrayList.size() - 1);
        }

        private void k(PdfDictionary pdfDictionary) {
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            if (!this.f26291f.isEmpty()) {
                ArrayList<PdfDictionary> arrayList = this.f26291f;
                pdfDictionary2.X0(arrayList.get(arrayList.size() - 1));
            }
            int i2 = 0;
            while (true) {
                PdfName[] pdfNameArr = PdfReader.N3;
                if (i2 < pdfNameArr.length) {
                    PdfObject d0 = pdfDictionary.d0(pdfNameArr[i2]);
                    if (d0 != null) {
                        pdfDictionary2.V0(pdfNameArr[i2], d0);
                    }
                    i2++;
                } else {
                    this.f26291f.add(pdfDictionary2);
                    return;
                }
            }
        }

        /* access modifiers changed from: private */
        public void p(List<Integer> list) {
            IntHashtable intHashtable = new IntHashtable();
            ArrayList arrayList = new ArrayList();
            int q = q();
            for (Integer next : list) {
                int intValue = next.intValue();
                if (intValue >= 1 && intValue <= q && intHashtable.l(intValue, 1) == 0) {
                    arrayList.add(next);
                }
            }
            if (this.f26286a.E3) {
                for (int i2 = 1; i2 <= q; i2++) {
                    d(i2);
                    o();
                }
            }
            PRIndirectReference pRIndirectReference = (PRIndirectReference) this.f26286a.b3.d0(PdfName.zc);
            PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.t0(pRIndirectReference);
            ArrayList<PRIndirectReference> arrayList2 = new ArrayList<>(arrayList.size());
            PdfArray pdfArray = new PdfArray();
            boolean z = false;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                int intValue2 = ((Integer) arrayList.get(i3)).intValue();
                PRIndirectReference d2 = d(intValue2);
                o();
                pdfArray.a0(d2);
                arrayList2.add(d2);
                b(intValue2).V0(PdfName.Dc, pRIndirectReference);
            }
            AcroFields C = this.f26286a.C();
            if (C.t().size() > 0) {
                z = true;
            }
            for (int i4 = 1; i4 <= q; i4++) {
                if (!intHashtable.c(i4)) {
                    if (z) {
                        C.Q(i4);
                    }
                    int d3 = d(i4).d();
                    this.f26286a.Y2.set(d3, (Object) null);
                    if (this.f26286a.E3) {
                        long[] jArr = this.f26286a.X;
                        int i5 = d3 * 2;
                        jArr[i5] = -1;
                        jArr[i5 + 1] = 0;
                    }
                }
            }
            pdfDictionary.V0(PdfName.P5, new PdfNumber(arrayList.size()));
            pdfDictionary.V0(PdfName.ia, pdfArray);
            this.f26289d = null;
            this.f26287b = arrayList2;
        }

        public PdfDictionary b(int i2) {
            return (PdfDictionary) PdfReader.t0(d(i2));
        }

        public PdfDictionary c(int i2) {
            PdfDictionary b2 = b(i2);
            n(i2);
            return b2;
        }

        public PRIndirectReference d(int i2) {
            int i3 = i2 - 1;
            if (i3 < 0) {
                return null;
            }
            try {
                if (i3 >= q()) {
                    return null;
                }
                ArrayList<PRIndirectReference> arrayList = this.f26287b;
                if (arrayList != null) {
                    return arrayList.get(i3);
                }
                int e2 = this.f26289d.e(i3);
                if (e2 == 0) {
                    PRIndirectReference f2 = f(i3);
                    if (this.f26286a.D3 == -1) {
                        this.f26290e = -1;
                    } else {
                        this.f26290e = i3;
                    }
                    int unused = this.f26286a.D3 = -1;
                    this.f26289d.l(i3, f2.d());
                    if (this.f26292g) {
                        this.f26290e = -1;
                    }
                    return f2;
                }
                if (this.f26290e != i3) {
                    this.f26290e = -1;
                }
                if (this.f26292g) {
                    this.f26290e = -1;
                }
                return new PRIndirectReference(this.f26286a, e2);
            } catch (Exception e3) {
                throw new ExceptionConverter(e3);
            }
        }

        public PRIndirectReference e(int i2) {
            PRIndirectReference d2 = d(i2);
            n(i2);
            return d2;
        }

        /* access modifiers changed from: protected */
        public PRIndirectReference f(int i2) {
            PdfDictionary pdfDictionary = new PdfDictionary();
            PdfDictionary pdfDictionary2 = this.f26286a.Z2;
            int i3 = 0;
            while (true) {
                int i4 = 0;
                while (true) {
                    PdfName[] pdfNameArr = PdfReader.N3;
                    if (i4 >= pdfNameArr.length) {
                        break;
                    }
                    PdfObject d0 = pdfDictionary2.d0(pdfNameArr[i4]);
                    if (d0 != null) {
                        pdfDictionary.V0(pdfNameArr[i4], d0);
                    }
                    i4++;
                }
                ListIterator<PdfObject> listIterator = ((PdfArray) PdfReader.w0(pdfDictionary2.d0(PdfName.ia))).listIterator();
                while (true) {
                    if (!listIterator.hasNext()) {
                        break;
                    }
                    PRIndirectReference pRIndirectReference = (PRIndirectReference) listIterator.next();
                    PdfDictionary pdfDictionary3 = (PdfDictionary) PdfReader.t0(pRIndirectReference);
                    int h2 = this.f26286a.D3;
                    PdfObject w0 = PdfReader.w0(pdfDictionary3.d0(PdfName.P5));
                    int unused = this.f26286a.D3 = h2;
                    int e0 = ((w0 == null || w0.W() != 2) ? 1 : ((PdfNumber) w0).e0()) + i3;
                    if (i2 >= e0) {
                        this.f26286a.p1();
                        i3 = e0;
                    } else if (w0 == null) {
                        pdfDictionary3.U0(pdfDictionary);
                        return pRIndirectReference;
                    } else {
                        this.f26286a.p1();
                        pdfDictionary2 = pdfDictionary3;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void g(int i2, PRIndirectReference pRIndirectReference) {
            int i3 = i2 - 1;
            ArrayList<PRIndirectReference> arrayList = this.f26287b;
            if (arrayList == null) {
                this.f26288c++;
                this.f26290e = -1;
                if (i3 >= q()) {
                    this.f26289d.l(q(), pRIndirectReference.d());
                    return;
                }
                IntHashtable intHashtable = new IntHashtable((this.f26289d.o() + 1) * 2);
                Iterator<IntHashtable.Entry> f2 = this.f26289d.f();
                while (f2.hasNext()) {
                    IntHashtable.Entry next = f2.next();
                    int a2 = next.a();
                    if (a2 >= i3) {
                        a2++;
                    }
                    intHashtable.l(a2, next.b());
                }
                intHashtable.l(i3, pRIndirectReference.d());
                this.f26289d = intHashtable;
            } else if (i3 >= arrayList.size()) {
                this.f26287b.add(pRIndirectReference);
            } else {
                this.f26287b.add(i3, pRIndirectReference);
            }
        }

        /* access modifiers changed from: package-private */
        public void i() {
            IntHashtable intHashtable = this.f26289d;
            if (intHashtable != null && !this.f26292g) {
                this.f26292g = true;
                intHashtable.a();
            }
        }

        /* access modifiers changed from: package-private */
        public void l() throws IOException {
            this.f26287b = null;
            m();
        }

        /* access modifiers changed from: package-private */
        public void m() throws IOException {
            if (this.f26287b == null) {
                this.f26289d = null;
                this.f26287b = new ArrayList<>();
                this.f26291f = new ArrayList<>();
                h((PRIndirectReference) this.f26286a.b3.d0(PdfName.zc));
                this.f26291f = null;
                this.f26286a.Z2.V0(PdfName.P5, new PdfNumber(this.f26287b.size()));
            }
        }

        public void n(int i2) {
            int i3;
            if (this.f26289d != null && i2 - 1 >= 0 && i3 < q() && i3 == this.f26290e) {
                this.f26290e = -1;
                int unused = this.f26286a.D3 = this.f26289d.e(i3);
                this.f26286a.p1();
                this.f26289d.n(i3);
            }
        }

        public void o() {
            if (this.f26289d != null) {
                this.f26290e = -1;
            }
        }

        /* access modifiers changed from: package-private */
        public int q() {
            ArrayList<PRIndirectReference> arrayList = this.f26287b;
            return arrayList != null ? arrayList.size() : this.f26288c;
        }

        private PageRefs(PdfReader pdfReader) throws IOException {
            this.f26290e = -1;
            this.f26293h = new HashSet();
            this.f26286a = pdfReader;
            if (pdfReader.E3) {
                this.f26289d = new IntHashtable();
                this.f26288c = ((PdfNumber) PdfReader.w0(pdfReader.Z2.d0(PdfName.P5))).e0();
                return;
            }
            m();
        }

        /* synthetic */ PageRefs(PdfReader pdfReader, AnonymousClass1 r2) throws IOException {
            this(pdfReader);
        }
    }

    static {
        Class<PdfReader> cls = PdfReader.class;
        M3 = LoggerFactory.b(cls);
        Q3 = CounterFactory.b(cls);
    }

    private PdfReader(RandomAccessSource randomAccessSource, boolean z, byte[] bArr, Certificate certificate, Key key, String str, ExternalDecryptionProcess externalDecryptionProcess, boolean z2) throws IOException {
        this.d3 = null;
        this.e3 = false;
        this.f3 = false;
        this.g3 = false;
        this.i3 = false;
        this.n3 = null;
        this.o3 = null;
        this.p3 = null;
        this.q3 = null;
        this.r3 = null;
        this.t3 = new ArrayList<>();
        this.u3 = true;
        this.v3 = false;
        this.w3 = false;
        this.D3 = -1;
        this.G3 = new PdfViewerPreferencesImp();
        this.J3 = 0;
        this.p3 = certificate;
        this.o3 = key;
        this.q3 = str;
        this.r3 = externalDecryptionProcess;
        this.n3 = bArr;
        this.E3 = z;
        try {
            this.s = d0(randomAccessSource);
            if (z) {
                j1();
            } else {
                i1();
            }
            H().b(this.B3);
        } catch (IOException e2) {
            if (z2) {
                randomAccessSource.close();
            }
            throw e2;
        }
    }

    static boolean A(byte[] bArr, byte[] bArr2) {
        int length = bArr2.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    static boolean B(PdfDictionary pdfDictionary, PdfName pdfName, PdfName pdfName2) {
        PdfObject w0 = w0(pdfDictionary.d0(pdfName));
        if (w0 == null || !w0.E()) {
            return false;
        }
        return ((PdfName) w0).equals(pdfName2);
    }

    public static byte[] D0(PRStream pRStream) throws IOException {
        RandomAccessFileOrArray B0 = pRStream.x1().B0();
        try {
            B0.g();
            return E0(pRStream, B0);
        } finally {
            try {
                B0.close();
            } catch (Exception unused) {
            }
        }
    }

    public static byte[] E0(PRStream pRStream, RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        return q(G0(pRStream, randomAccessFileOrArray), pRStream);
    }

    public static byte[] F0(PRStream pRStream) throws IOException {
        RandomAccessFileOrArray B0 = pRStream.x1().B0();
        try {
            B0.g();
            return G0(pRStream, B0);
        } finally {
            try {
                B0.close();
            } catch (Exception unused) {
            }
        }
    }

    public static byte[] G0(PRStream pRStream, RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        PdfReader x1 = pRStream.x1();
        if (pRStream.w1() < 0) {
            return pRStream.k();
        }
        byte[] bArr = new byte[pRStream.q1()];
        randomAccessFileOrArray.r(pRStream.w1());
        randomAccessFileOrArray.readFully(bArr);
        PdfEncryption L = x1.L();
        if (L != null) {
            PdfObject w0 = w0(pRStream.d0(PdfName.T7));
            ArrayList<PdfObject> arrayList = new ArrayList<>();
            if (w0 != null) {
                if (w0.E()) {
                    arrayList.add(w0);
                } else if (w0.q()) {
                    arrayList = ((PdfArray) w0).q0();
                }
            }
            int i2 = 0;
            while (i2 < arrayList.size()) {
                PdfObject w02 = w0(arrayList.get(i2));
                if (w02 == null || !w02.toString().equals("/Crypt")) {
                    i2++;
                }
            }
            L.u(pRStream.v1(), pRStream.s1());
            return L.h(bArr);
        }
        return bArr;
    }

    static String H0(PdfDictionary pdfDictionary) {
        String O;
        if (pdfDictionary == null || (O = O(pdfDictionary)) == null || O.length() < 8 || O.charAt(6) != '+') {
            return null;
        }
        for (int i2 = 0; i2 < 6; i2++) {
            char charAt = O.charAt(i2);
            if (charAt < 'A' || charAt > 'Z') {
                return null;
            }
        }
        return O;
    }

    private void J1(int i2, PdfObject pdfObject) {
        if (this.E3 && i2 >= 0) {
            this.Y2.set(i2, pdfObject);
        }
    }

    static String O(PdfDictionary pdfDictionary) {
        PdfObject w0;
        if (pdfDictionary == null || (w0 = w0(pdfDictionary.d0(PdfName.l4))) == null || !w0.E()) {
            return null;
        }
        return PdfName.a0(w0.toString());
    }

    private static PdfArray V(PdfObject pdfObject) {
        PdfObject w0;
        PdfObject w02;
        if (pdfObject == null || (w0 = w0(pdfObject)) == null) {
            return null;
        }
        if (w0.q()) {
            return (PdfArray) w0;
        }
        if (!w0.z() || (w02 = w0(((PdfDictionary) w0).d0(PdfName.f6))) == null || !w02.q()) {
            return null;
        }
        return (PdfArray) w02;
    }

    private void V0(PdfObject pdfObject, HashMap<Object, PdfObject> hashMap) {
        while (pdfObject != null) {
            x1(pdfObject, hashMap);
            PdfDictionary pdfDictionary = (PdfDictionary) w0(pdfObject);
            PdfObject d0 = pdfDictionary.d0(PdfName.U7);
            if (d0 != null) {
                V0(d0, hashMap);
            }
            pdfObject = pdfDictionary.d0(PdfName.Ab);
        }
    }

    public static PdfObject W0(PdfObject pdfObject) {
        if (pdfObject == null || pdfObject.H()) {
            return null;
        }
        PdfObject w0 = w0(pdfObject);
        if (pdfObject.C()) {
            PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
            PdfReader a0 = pRIndirectReference.a0();
            int d2 = pRIndirectReference.d();
            a0.Y2.set(d2, (Object) null);
            if (a0.E3) {
                a0.X[d2 * 2] = -1;
            }
        }
        return w0;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a1() {
        /*
            r18 = this;
            r1 = r18
            r0 = 4
            r2 = 1
            boolean r3 = r1.f3
            if (r3 == 0) goto L_0x0009
            return
        L_0x0009:
            com.itextpdf.text.pdf.PdfDictionary r3 = r1.a3
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.n7
            com.itextpdf.text.pdf.PdfObject r3 = r3.d0(r4)
            if (r3 == 0) goto L_0x0509
            java.lang.String r4 = r3.toString()
            java.lang.String r5 = "null"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0021
            goto L_0x0509
        L_0x0021:
            r1.H3 = r2
            r1.f3 = r2
            com.itextpdf.text.pdf.PdfObject r4 = t0(r3)
            com.itextpdf.text.pdf.PdfDictionary r4 = (com.itextpdf.text.pdf.PdfDictionary) r4
            com.itextpdf.text.pdf.PdfDictionary r5 = r1.a3
            com.itextpdf.text.pdf.PdfName r6 = com.itextpdf.text.pdf.PdfName.A9
            com.itextpdf.text.pdf.PdfArray r5 = r5.e0(r6)
            r7 = 0
            if (r5 == 0) goto L_0x0057
            com.itextpdf.text.pdf.PdfObject r8 = r5.T0(r7)
            java.util.ArrayList<com.itextpdf.text.pdf.PdfString> r9 = r1.t3
            r9.remove(r8)
            java.lang.String r8 = r8.toString()
            byte[] r8 = com.itextpdf.text.DocWriter.E(r8)
            int r9 = r5.size()
            if (r9 <= r2) goto L_0x0058
            java.util.ArrayList<com.itextpdf.text.pdf.PdfString> r9 = r1.t3
            com.itextpdf.text.pdf.PdfObject r5 = r5.T0(r2)
            r9.remove(r5)
            goto L_0x0058
        L_0x0057:
            r8 = 0
        L_0x0058:
            if (r8 != 0) goto L_0x005c
            byte[] r8 = new byte[r7]
        L_0x005c:
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.T7
            com.itextpdf.text.pdf.PdfObject r5 = r4.d0(r5)
            com.itextpdf.text.pdf.PdfObject r5 = w0(r5)
            com.itextpdf.text.pdf.PdfName r9 = com.itextpdf.text.pdf.PdfName.lf
            boolean r9 = r5.equals(r9)
            java.lang.String r10 = "no.compatible.encryption.found"
            java.lang.String r11 = "cf.not.found.encryption"
            java.lang.String r13 = "false"
            java.lang.String r6 = "illegal.length.value"
            r2 = 2
            r12 = 3
            if (r9 == 0) goto L_0x0208
            com.itextpdf.text.pdf.PdfName r9 = com.itextpdf.text.pdf.PdfName.Og
            com.itextpdf.text.pdf.PdfObject r16 = r4.d0(r9)
            java.lang.String r16 = r16.toString()
            java.util.ArrayList<com.itextpdf.text.pdf.PdfString> r15 = r1.t3
            com.itextpdf.text.pdf.PdfObject r9 = r4.d0(r9)
            r15.remove(r9)
            byte[] r9 = com.itextpdf.text.DocWriter.E(r16)
            com.itextpdf.text.pdf.PdfName r15 = com.itextpdf.text.pdf.PdfName.Lb
            com.itextpdf.text.pdf.PdfObject r16 = r4.d0(r15)
            java.lang.String r16 = r16.toString()
            java.util.ArrayList<com.itextpdf.text.pdf.PdfString> r7 = r1.t3
            com.itextpdf.text.pdf.PdfObject r15 = r4.d0(r15)
            r7.remove(r15)
            byte[] r7 = com.itextpdf.text.DocWriter.E(r16)
            com.itextpdf.text.pdf.PdfName r15 = com.itextpdf.text.pdf.PdfName.Wb
            boolean r16 = r4.a0(r15)
            if (r16 == 0) goto L_0x00b7
            java.util.ArrayList<com.itextpdf.text.pdf.PdfString> r14 = r1.t3
            com.itextpdf.text.pdf.PdfObject r15 = r4.d0(r15)
            r14.remove(r15)
        L_0x00b7:
            com.itextpdf.text.pdf.PdfName r14 = com.itextpdf.text.pdf.PdfName.Pg
            boolean r15 = r4.a0(r14)
            if (r15 == 0) goto L_0x00c8
            java.util.ArrayList<com.itextpdf.text.pdf.PdfString> r15 = r1.t3
            com.itextpdf.text.pdf.PdfObject r14 = r4.d0(r14)
            r15.remove(r14)
        L_0x00c8:
            com.itextpdf.text.pdf.PdfName r14 = com.itextpdf.text.pdf.PdfName.Qc
            boolean r15 = r4.a0(r14)
            if (r15 == 0) goto L_0x00d9
            java.util.ArrayList<com.itextpdf.text.pdf.PdfString> r15 = r1.t3
            com.itextpdf.text.pdf.PdfObject r14 = r4.d0(r14)
            r15.remove(r14)
        L_0x00d9:
            com.itextpdf.text.pdf.PdfName r14 = com.itextpdf.text.pdf.PdfName.tc
            com.itextpdf.text.pdf.PdfObject r14 = r4.d0(r14)
            boolean r15 = r14.I()
            if (r15 == 0) goto L_0x01f9
            com.itextpdf.text.pdf.PdfNumber r14 = (com.itextpdf.text.pdf.PdfNumber) r14
            long r14 = r14.i0()
            r1.y3 = r14
            com.itextpdf.text.pdf.PdfName r14 = com.itextpdf.text.pdf.PdfName.Dd
            com.itextpdf.text.pdf.PdfObject r14 = r4.d0(r14)
            boolean r15 = r14.I()
            if (r15 == 0) goto L_0x01ea
            com.itextpdf.text.pdf.PdfNumber r14 = (com.itextpdf.text.pdf.PdfNumber) r14
            int r14 = r14.e0()
            r1.x3 = r14
            if (r14 == r2) goto L_0x01e7
            if (r14 == r12) goto L_0x01a7
            if (r14 == r0) goto L_0x0139
            r6 = 5
            if (r14 != r6) goto L_0x012b
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.o7
            com.itextpdf.text.pdf.PdfObject r2 = r4.d0(r2)
            if (r2 == 0) goto L_0x0125
            java.lang.String r2 = r2.toString()
            boolean r2 = r2.equals(r13)
            if (r2 == 0) goto L_0x0125
            r2 = 11
        L_0x011e:
            r17 = r7
            r7 = r9
            r0 = 0
        L_0x0122:
            r6 = 0
            goto L_0x0438
        L_0x0125:
            r17 = r7
            r7 = r9
            r0 = 0
            r2 = 3
            goto L_0x0122
        L_0x012b:
            com.itextpdf.text.exceptions.UnsupportedPdfException r0 = new com.itextpdf.text.exceptions.UnsupportedPdfException
            java.lang.String r2 = "unknown.encryption.type.r.eq.1"
            int r3 = r1.x3
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.a(r2, r3)
            r0.<init>(r2)
            throw r0
        L_0x0139:
            com.itextpdf.text.pdf.PdfName r6 = com.itextpdf.text.pdf.PdfName.c5
            com.itextpdf.text.pdf.PdfObject r6 = r4.d0(r6)
            com.itextpdf.text.pdf.PdfDictionary r6 = (com.itextpdf.text.pdf.PdfDictionary) r6
            if (r6 == 0) goto L_0x019a
            com.itextpdf.text.pdf.PdfName r11 = com.itextpdf.text.pdf.PdfName.pf
            com.itextpdf.text.pdf.PdfObject r6 = r6.d0(r11)
            com.itextpdf.text.pdf.PdfDictionary r6 = (com.itextpdf.text.pdf.PdfDictionary) r6
            if (r6 == 0) goto L_0x018b
            com.itextpdf.text.pdf.PdfName r11 = com.itextpdf.text.pdf.PdfName.lh
            com.itextpdf.text.pdf.PdfName r14 = com.itextpdf.text.pdf.PdfName.d5
            com.itextpdf.text.pdf.PdfObject r15 = r6.d0(r14)
            boolean r11 = r11.equals(r15)
            if (r11 == 0) goto L_0x015d
            r2 = 1
            goto L_0x0169
        L_0x015d:
            com.itextpdf.text.pdf.PdfName r11 = com.itextpdf.text.pdf.PdfName.B3
            com.itextpdf.text.pdf.PdfObject r6 = r6.d0(r14)
            boolean r6 = r11.equals(r6)
            if (r6 == 0) goto L_0x017e
        L_0x0169:
            com.itextpdf.text.pdf.PdfName r6 = com.itextpdf.text.pdf.PdfName.o7
            com.itextpdf.text.pdf.PdfObject r6 = r4.d0(r6)
            if (r6 == 0) goto L_0x011e
            java.lang.String r6 = r6.toString()
            boolean r6 = r6.equals(r13)
            if (r6 == 0) goto L_0x011e
            r2 = r2 | 8
            goto L_0x011e
        L_0x017e:
            com.itextpdf.text.exceptions.UnsupportedPdfException r0 = new com.itextpdf.text.exceptions.UnsupportedPdfException
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r10, r2)
            r0.<init>(r2)
            throw r0
        L_0x018b:
            r2 = 0
            com.itextpdf.text.exceptions.InvalidPdfException r0 = new com.itextpdf.text.exceptions.InvalidPdfException
            java.lang.String r3 = "stdcf.not.found.encryption"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r3, r2)
            r0.<init>(r2)
            throw r0
        L_0x019a:
            r2 = 0
            com.itextpdf.text.exceptions.InvalidPdfException r0 = new com.itextpdf.text.exceptions.InvalidPdfException
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r11, r2)
            r0.<init>(r2)
            throw r0
        L_0x01a7:
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.va
            com.itextpdf.text.pdf.PdfObject r2 = r4.d0(r2)
            boolean r10 = r2.I()
            if (r10 == 0) goto L_0x01da
            com.itextpdf.text.pdf.PdfNumber r2 = (com.itextpdf.text.pdf.PdfNumber) r2
            int r2 = r2.e0()
            r10 = 128(0x80, float:1.794E-43)
            if (r2 > r10) goto L_0x01cd
            r10 = 40
            if (r2 < r10) goto L_0x01cd
            int r10 = r2 % 8
            if (r10 != 0) goto L_0x01cd
            r6 = r2
            r17 = r7
            r7 = r9
            r0 = 0
            r2 = 1
            goto L_0x0438
        L_0x01cd:
            com.itextpdf.text.exceptions.InvalidPdfException r0 = new com.itextpdf.text.exceptions.InvalidPdfException
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r6, r2)
            r0.<init>(r2)
            throw r0
        L_0x01da:
            r2 = 0
            com.itextpdf.text.exceptions.InvalidPdfException r0 = new com.itextpdf.text.exceptions.InvalidPdfException
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r6, r2)
            r0.<init>(r2)
            throw r0
        L_0x01e7:
            r2 = 0
            goto L_0x011e
        L_0x01ea:
            r2 = 0
            com.itextpdf.text.exceptions.InvalidPdfException r0 = new com.itextpdf.text.exceptions.InvalidPdfException
            java.lang.String r3 = "illegal.r.value"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r3, r2)
            r0.<init>(r2)
            throw r0
        L_0x01f9:
            r2 = 0
            com.itextpdf.text.exceptions.InvalidPdfException r0 = new com.itextpdf.text.exceptions.InvalidPdfException
            java.lang.String r3 = "illegal.p.value"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r3, r2)
            r0.<init>(r2)
            throw r0
        L_0x0208:
            com.itextpdf.text.pdf.PdfName r7 = com.itextpdf.text.pdf.PdfName.yd
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L_0x0434
            com.itextpdf.text.pdf.PdfName r7 = com.itextpdf.text.pdf.PdfName.kh
            com.itextpdf.text.pdf.PdfObject r7 = r4.d0(r7)
            boolean r9 = r7.I()
            if (r9 == 0) goto L_0x0425
            com.itextpdf.text.pdf.PdfNumber r7 = (com.itextpdf.text.pdf.PdfNumber) r7
            int r7 = r7.e0()
            r9 = 1
            if (r7 == r9) goto L_0x0309
            if (r7 == r2) goto L_0x02c7
            if (r7 == r0) goto L_0x0239
            r6 = 5
            if (r7 != r6) goto L_0x022d
            goto L_0x0239
        L_0x022d:
            com.itextpdf.text.exceptions.UnsupportedPdfException r0 = new com.itextpdf.text.exceptions.UnsupportedPdfException
            java.lang.String r2 = "unknown.encryption.type.v.eq.1"
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.a(r2, r7)
            r0.<init>(r2)
            throw r0
        L_0x0239:
            com.itextpdf.text.pdf.PdfName r6 = com.itextpdf.text.pdf.PdfName.c5
            com.itextpdf.text.pdf.PdfObject r6 = r4.d0(r6)
            com.itextpdf.text.pdf.PdfDictionary r6 = (com.itextpdf.text.pdf.PdfDictionary) r6
            if (r6 == 0) goto L_0x02ba
            com.itextpdf.text.pdf.PdfName r7 = com.itextpdf.text.pdf.PdfName.q6
            com.itextpdf.text.pdf.PdfObject r6 = r6.d0(r7)
            com.itextpdf.text.pdf.PdfDictionary r6 = (com.itextpdf.text.pdf.PdfDictionary) r6
            if (r6 == 0) goto L_0x02ab
            com.itextpdf.text.pdf.PdfName r7 = com.itextpdf.text.pdf.PdfName.lh
            com.itextpdf.text.pdf.PdfName r9 = com.itextpdf.text.pdf.PdfName.d5
            com.itextpdf.text.pdf.PdfObject r11 = r6.d0(r9)
            boolean r7 = r7.equals(r11)
            if (r7 == 0) goto L_0x025f
            r2 = 1
        L_0x025c:
            r17 = 128(0x80, float:1.794E-43)
            goto L_0x027d
        L_0x025f:
            com.itextpdf.text.pdf.PdfName r7 = com.itextpdf.text.pdf.PdfName.B3
            com.itextpdf.text.pdf.PdfObject r11 = r6.d0(r9)
            boolean r7 = r7.equals(r11)
            if (r7 == 0) goto L_0x026c
            goto L_0x025c
        L_0x026c:
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.C3
            com.itextpdf.text.pdf.PdfObject r7 = r6.d0(r9)
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x029e
            r2 = 256(0x100, float:3.59E-43)
            r2 = 3
            r17 = 256(0x100, float:3.59E-43)
        L_0x027d:
            com.itextpdf.text.pdf.PdfName r7 = com.itextpdf.text.pdf.PdfName.o7
            com.itextpdf.text.pdf.PdfObject r7 = r6.d0(r7)
            if (r7 == 0) goto L_0x0291
            java.lang.String r7 = r7.toString()
            boolean r7 = r7.equals(r13)
            if (r7 == 0) goto L_0x0291
            r2 = r2 | 8
        L_0x0291:
            com.itextpdf.text.pdf.PdfName r7 = com.itextpdf.text.pdf.PdfName.Md
            com.itextpdf.text.pdf.PdfObject r6 = r6.d0(r7)
            com.itextpdf.text.pdf.PdfArray r6 = (com.itextpdf.text.pdf.PdfArray) r6
            r7 = r2
            r2 = r17
            goto L_0x0317
        L_0x029e:
            com.itextpdf.text.exceptions.UnsupportedPdfException r0 = new com.itextpdf.text.exceptions.UnsupportedPdfException
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r10, r2)
            r0.<init>(r2)
            throw r0
        L_0x02ab:
            r2 = 0
            com.itextpdf.text.exceptions.InvalidPdfException r0 = new com.itextpdf.text.exceptions.InvalidPdfException
            java.lang.String r3 = "defaultcryptfilter.not.found.encryption"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r3, r2)
            r0.<init>(r2)
            throw r0
        L_0x02ba:
            r2 = 0
            com.itextpdf.text.exceptions.InvalidPdfException r0 = new com.itextpdf.text.exceptions.InvalidPdfException
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r11, r2)
            r0.<init>(r2)
            throw r0
        L_0x02c7:
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.va
            com.itextpdf.text.pdf.PdfObject r2 = r4.d0(r2)
            boolean r7 = r2.I()
            if (r7 == 0) goto L_0x02fc
            com.itextpdf.text.pdf.PdfNumber r2 = (com.itextpdf.text.pdf.PdfNumber) r2
            int r2 = r2.e0()
            r7 = 128(0x80, float:1.794E-43)
            if (r2 > r7) goto L_0x02ef
            r7 = 40
            if (r2 < r7) goto L_0x02ef
            int r7 = r2 % 8
            if (r7 != 0) goto L_0x02ef
            com.itextpdf.text.pdf.PdfName r6 = com.itextpdf.text.pdf.PdfName.Md
            com.itextpdf.text.pdf.PdfObject r6 = r4.d0(r6)
            com.itextpdf.text.pdf.PdfArray r6 = (com.itextpdf.text.pdf.PdfArray) r6
            r7 = 1
            goto L_0x0317
        L_0x02ef:
            com.itextpdf.text.exceptions.InvalidPdfException r0 = new com.itextpdf.text.exceptions.InvalidPdfException
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r6, r2)
            r0.<init>(r2)
            throw r0
        L_0x02fc:
            r2 = 0
            com.itextpdf.text.exceptions.InvalidPdfException r0 = new com.itextpdf.text.exceptions.InvalidPdfException
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r6, r2)
            r0.<init>(r2)
            throw r0
        L_0x0309:
            r7 = 40
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.Md
            com.itextpdf.text.pdf.PdfObject r2 = r4.d0(r2)
            r6 = r2
            com.itextpdf.text.pdf.PdfArray r6 = (com.itextpdf.text.pdf.PdfArray) r6
            r2 = 40
            r7 = 0
        L_0x0317:
            org.spongycastle.cert.X509CertificateHolder r9 = new org.spongycastle.cert.X509CertificateHolder     // Catch:{ Exception -> 0x041e }
            java.security.cert.Certificate r10 = r1.p3     // Catch:{ Exception -> 0x041e }
            byte[] r10 = r10.getEncoded()     // Catch:{ Exception -> 0x041e }
            r9.<init>(r10)     // Catch:{ Exception -> 0x041e }
            com.itextpdf.text.pdf.security.ExternalDecryptionProcess r10 = r1.r3
            if (r10 != 0) goto L_0x0380
            r10 = 0
            r11 = 0
            r13 = 0
        L_0x0329:
            int r14 = r6.size()
            if (r10 >= r14) goto L_0x03c3
            com.itextpdf.text.pdf.PdfObject r14 = r6.T0(r10)
            java.util.ArrayList<com.itextpdf.text.pdf.PdfString> r15 = r1.t3
            r15.remove(r14)
            org.spongycastle.cms.CMSEnvelopedData r15 = new org.spongycastle.cms.CMSEnvelopedData     // Catch:{ Exception -> 0x0372 }
            byte[] r14 = r14.k()     // Catch:{ Exception -> 0x0372 }
            r15.<init>(r14)     // Catch:{ Exception -> 0x0372 }
            org.spongycastle.cms.RecipientInformationStore r14 = r15.getRecipientInfos()     // Catch:{ Exception -> 0x0372 }
            java.util.Collection r14 = r14.getRecipients()     // Catch:{ Exception -> 0x0372 }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ Exception -> 0x0372 }
        L_0x034d:
            boolean r15 = r14.hasNext()     // Catch:{ Exception -> 0x0372 }
            if (r15 == 0) goto L_0x0376
            java.lang.Object r15 = r14.next()     // Catch:{ Exception -> 0x0372 }
            org.spongycastle.cms.RecipientInformation r15 = (org.spongycastle.cms.RecipientInformation) r15     // Catch:{ Exception -> 0x0372 }
            org.spongycastle.cms.RecipientId r0 = r15.getRID()     // Catch:{ Exception -> 0x0372 }
            boolean r0 = r0.match(r9)     // Catch:{ Exception -> 0x0372 }
            if (r0 == 0) goto L_0x0374
            if (r11 != 0) goto L_0x0374
            java.security.Key r0 = r1.o3     // Catch:{ Exception -> 0x0372 }
            java.security.PrivateKey r0 = (java.security.PrivateKey) r0     // Catch:{ Exception -> 0x0372 }
            java.lang.String r11 = r1.q3     // Catch:{ Exception -> 0x0372 }
            byte[] r0 = com.itextpdf.text.pdf.PdfEncryptor.g(r15, r0, r11)     // Catch:{ Exception -> 0x0372 }
            r13 = r0
            r11 = 1
            goto L_0x0374
        L_0x0372:
            r0 = move-exception
            goto L_0x037a
        L_0x0374:
            r0 = 4
            goto L_0x034d
        L_0x0376:
            r0 = 1
            int r10 = r10 + r0
            r0 = 4
            goto L_0x0329
        L_0x037a:
            com.itextpdf.text.ExceptionConverter r2 = new com.itextpdf.text.ExceptionConverter
            r2.<init>(r0)
            throw r2
        L_0x0380:
            r0 = 0
            r9 = 0
            r13 = 0
        L_0x0383:
            int r10 = r6.size()
            if (r9 >= r10) goto L_0x03c2
            com.itextpdf.text.pdf.PdfObject r10 = r6.T0(r9)
            java.util.ArrayList<com.itextpdf.text.pdf.PdfString> r11 = r1.t3
            r11.remove(r10)
            org.spongycastle.cms.CMSEnvelopedData r11 = new org.spongycastle.cms.CMSEnvelopedData     // Catch:{ Exception -> 0x03b8 }
            byte[] r10 = r10.k()     // Catch:{ Exception -> 0x03b8 }
            r11.<init>(r10)     // Catch:{ Exception -> 0x03b8 }
            org.spongycastle.cms.RecipientInformationStore r10 = r11.getRecipientInfos()     // Catch:{ Exception -> 0x03b8 }
            com.itextpdf.text.pdf.security.ExternalDecryptionProcess r11 = r1.r3     // Catch:{ Exception -> 0x03b8 }
            org.spongycastle.cms.RecipientId r11 = r11.b()     // Catch:{ Exception -> 0x03b8 }
            org.spongycastle.cms.RecipientInformation r10 = r10.get(r11)     // Catch:{ Exception -> 0x03b8 }
            if (r10 == 0) goto L_0x03b6
            com.itextpdf.text.pdf.security.ExternalDecryptionProcess r0 = r1.r3     // Catch:{ Exception -> 0x03b8 }
            org.spongycastle.cms.Recipient r0 = r0.a()     // Catch:{ Exception -> 0x03b8 }
            byte[] r13 = r10.getContent(r0)     // Catch:{ Exception -> 0x03b8 }
            r0 = 1
        L_0x03b6:
            r10 = 1
            goto L_0x03ba
        L_0x03b8:
            r0 = move-exception
            goto L_0x03bc
        L_0x03ba:
            int r9 = r9 + r10
            goto L_0x0383
        L_0x03bc:
            com.itextpdf.text.ExceptionConverter r2 = new com.itextpdf.text.ExceptionConverter
            r2.<init>(r0)
            throw r2
        L_0x03c2:
            r11 = r0
        L_0x03c3:
            if (r11 == 0) goto L_0x040f
            if (r13 == 0) goto L_0x040f
            r0 = r7 & 7
            if (r0 != r12) goto L_0x03d4
            java.lang.String r0 = "SHA-256"
        L_0x03cd:
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r0)     // Catch:{ Exception -> 0x03d2 }
            goto L_0x03d7
        L_0x03d2:
            r0 = move-exception
            goto L_0x0409
        L_0x03d4:
            java.lang.String r0 = "SHA-1"
            goto L_0x03cd
        L_0x03d7:
            r9 = 20
            r10 = 0
            r0.update(r13, r10, r9)     // Catch:{ Exception -> 0x03d2 }
            r9 = 0
        L_0x03de:
            int r10 = r6.size()     // Catch:{ Exception -> 0x03d2 }
            if (r9 >= r10) goto L_0x03f2
            com.itextpdf.text.pdf.PdfObject r10 = r6.T0(r9)     // Catch:{ Exception -> 0x03d2 }
            byte[] r10 = r10.k()     // Catch:{ Exception -> 0x03d2 }
            r0.update(r10)     // Catch:{ Exception -> 0x03d2 }
            r10 = 1
            int r9 = r9 + r10
            goto L_0x03de
        L_0x03f2:
            r6 = r7 & 8
            if (r6 == 0) goto L_0x03ff
            r6 = 4
            byte[] r9 = new byte[r6]     // Catch:{ Exception -> 0x03d2 }
            r9 = {-1, -1, -1, -1} // fill-array     // Catch:{ Exception -> 0x03d2 }
            r0.update(r9)     // Catch:{ Exception -> 0x03d2 }
        L_0x03ff:
            byte[] r0 = r0.digest()     // Catch:{ Exception -> 0x03d2 }
            r6 = r2
            r2 = r7
        L_0x0405:
            r7 = 0
            r17 = 0
            goto L_0x0438
        L_0x0409:
            com.itextpdf.text.ExceptionConverter r2 = new com.itextpdf.text.ExceptionConverter
            r2.<init>(r0)
            throw r2
        L_0x040f:
            com.itextpdf.text.exceptions.UnsupportedPdfException r0 = new com.itextpdf.text.exceptions.UnsupportedPdfException
            java.lang.String r2 = "bad.certificate.and.key"
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r2, r3)
            r0.<init>(r2)
            throw r0
        L_0x041e:
            r0 = move-exception
            com.itextpdf.text.ExceptionConverter r2 = new com.itextpdf.text.ExceptionConverter
            r2.<init>(r0)
            throw r2
        L_0x0425:
            com.itextpdf.text.exceptions.InvalidPdfException r0 = new com.itextpdf.text.exceptions.InvalidPdfException
            java.lang.String r2 = "illegal.v.value"
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r2, r3)
            r0.<init>(r2)
            throw r0
        L_0x0434:
            r0 = 0
            r2 = 0
            r6 = 0
            goto L_0x0405
        L_0x0438:
            com.itextpdf.text.pdf.PdfEncryption r9 = new com.itextpdf.text.pdf.PdfEncryption
            r9.<init>()
            r1.m3 = r9
            r9.t(r2, r6)
            com.itextpdf.text.pdf.PdfName r9 = com.itextpdf.text.pdf.PdfName.lf
            boolean r9 = r5.equals(r9)
            if (r9 == 0) goto L_0x04c3
            int r0 = r1.x3
            r2 = 5
            if (r0 != r2) goto L_0x0466
            com.itextpdf.text.pdf.PdfEncryption r0 = r1.m3
            byte[] r2 = r1.n3
            boolean r0 = r0.s(r4, r2)
            r1.s3 = r0
            com.itextpdf.text.pdf.PdfEncryption r0 = r1.m3
            r0.f26219j = r8
            long r4 = r0.o()
            r1.y3 = r4
        L_0x0463:
            r0 = 1
            goto L_0x04dc
        L_0x0466:
            com.itextpdf.text.pdf.PdfEncryption r9 = r1.m3
            byte[] r11 = r1.n3
            long r14 = r1.y3
            r10 = r8
            r4 = 3
            r12 = r7
            r13 = r17
            r9.z(r10, r11, r12, r13, r14)
            com.itextpdf.text.pdf.PdfEncryption r0 = r1.m3
            byte[] r0 = r0.f26214e
            int r2 = r1.x3
            r5 = 16
            r6 = 32
            if (r2 == r4) goto L_0x0487
            r9 = 4
            if (r2 != r9) goto L_0x0484
            goto L_0x0487
        L_0x0484:
            r2 = 32
            goto L_0x0489
        L_0x0487:
            r2 = 16
        L_0x0489:
            boolean r0 = r1.z(r7, r0, r2)
            if (r0 != 0) goto L_0x04bf
            com.itextpdf.text.pdf.PdfEncryption r9 = r1.m3
            byte[] r11 = r1.n3
            long r13 = r1.y3
            r10 = r8
            r12 = r17
            r9.B(r10, r11, r12, r13)
            com.itextpdf.text.pdf.PdfEncryption r0 = r1.m3
            byte[] r0 = r0.f26214e
            int r2 = r1.x3
            if (r2 == r4) goto L_0x04a9
            r4 = 4
            if (r2 != r4) goto L_0x04a7
            goto L_0x04a9
        L_0x04a7:
            r5 = 32
        L_0x04a9:
            boolean r0 = r1.z(r7, r0, r5)
            if (r0 == 0) goto L_0x04b0
            goto L_0x0463
        L_0x04b0:
            com.itextpdf.text.exceptions.BadPasswordException r0 = new com.itextpdf.text.exceptions.BadPasswordException
            java.lang.String r2 = "bad.user.password"
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r2, r3)
            r0.<init>(r2)
            throw r0
        L_0x04bf:
            r0 = 1
            r1.s3 = r0
            goto L_0x04dc
        L_0x04c3:
            r4 = 3
            com.itextpdf.text.pdf.PdfName r7 = com.itextpdf.text.pdf.PdfName.yd
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0463
            r2 = r2 & 7
            if (r2 != r4) goto L_0x04d6
            com.itextpdf.text.pdf.PdfEncryption r2 = r1.m3
            r2.v(r0)
            goto L_0x04bf
        L_0x04d6:
            com.itextpdf.text.pdf.PdfEncryption r2 = r1.m3
            r2.x(r0, r6)
            goto L_0x04bf
        L_0x04dc:
            r2 = 0
        L_0x04dd:
            java.util.ArrayList<com.itextpdf.text.pdf.PdfString> r4 = r1.t3
            int r4 = r4.size()
            if (r2 >= r4) goto L_0x04f2
            java.util.ArrayList<com.itextpdf.text.pdf.PdfString> r4 = r1.t3
            java.lang.Object r4 = r4.get(r2)
            com.itextpdf.text.pdf.PdfString r4 = (com.itextpdf.text.pdf.PdfString) r4
            r4.Z(r1)
            int r2 = r2 + r0
            goto L_0x04dd
        L_0x04f2:
            boolean r0 = r3.C()
            if (r0 == 0) goto L_0x0506
            com.itextpdf.text.pdf.PRIndirectReference r3 = (com.itextpdf.text.pdf.PRIndirectReference) r3
            r1.F3 = r3
            java.util.ArrayList<com.itextpdf.text.pdf.PdfObject> r0 = r1.Y2
            int r2 = r3.d()
            r3 = 0
            r0.set(r2, r3)
        L_0x0506:
            r0 = 0
            r1.H3 = r0
        L_0x0509:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfReader.a1():void");
    }

    public static byte[] b(byte[] bArr) {
        int i2;
        byte b2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int[] iArr = new int[5];
        int i4 = 0;
        int i5 = 0;
        while (i4 < bArr.length && (b2 = bArr[i4] & 255) != 126) {
            if (!PRTokeniser.t(b2)) {
                if (b2 == 122 && i5 == 0) {
                    byteArrayOutputStream.write(0);
                    byteArrayOutputStream.write(0);
                    byteArrayOutputStream.write(0);
                    byteArrayOutputStream.write(0);
                } else if (b2 < 33 || b2 > 117) {
                    throw new RuntimeException(MessageLocalization.b("illegal.character.in.ascii85decode", new Object[0]));
                } else {
                    iArr[i5] = b2 - 33;
                    i5++;
                    if (i5 == 5) {
                        int i6 = 0;
                        for (int i7 = 0; i7 < 5; i7++) {
                            i6 = (i6 * 85) + iArr[i7];
                        }
                        byteArrayOutputStream.write((byte) (i6 >> 24));
                        byteArrayOutputStream.write((byte) (i6 >> 16));
                        byteArrayOutputStream.write((byte) (i6 >> 8));
                        byteArrayOutputStream.write((byte) i6);
                        i5 = 0;
                    }
                }
            }
            i4++;
        }
        if (i5 == 2) {
            i2 = (((iArr[0] * 52200625) + (iArr[1] * 614125)) + 621435) >> 24;
        } else if (i5 == 3) {
            int i8 = (iArr[0] * 52200625) + (iArr[1] * 614125) + (iArr[2] * 7225) + 7310;
            byteArrayOutputStream.write((byte) (i8 >> 24));
            i2 = i8 >> 16;
        } else {
            if (i5 == 4) {
                int i9 = (iArr[0] * 52200625) + (iArr[1] * 614125) + (iArr[2] * 7225) + (iArr[3] * 85) + 85;
                byteArrayOutputStream.write((byte) (i9 >> 24));
                byteArrayOutputStream.write((byte) (i9 >> 16));
                i2 = i9 >> 8;
            }
            return byteArrayOutputStream.toByteArray();
        }
        byteArrayOutputStream.write((byte) i2);
        return byteArrayOutputStream.toByteArray();
    }

    public static Rectangle b0(PdfArray pdfArray) {
        float a0 = ((PdfNumber) w0(pdfArray.T0(0))).a0();
        float a02 = ((PdfNumber) w0(pdfArray.T0(1))).a0();
        float a03 = ((PdfNumber) w0(pdfArray.T0(2))).a0();
        float a04 = ((PdfNumber) w0(pdfArray.T0(3))).a0();
        return new Rectangle(Math.min(a0, a03), Math.min(a02, a04), Math.max(a0, a03), Math.max(a02, a04));
    }

    public static byte[] c(byte[] bArr) {
        byte b2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean z = true;
        int i2 = 0;
        int i4 = 0;
        while (i2 < bArr.length && (b2 = bArr[i2] & 255) != 62) {
            if (!PRTokeniser.t(b2)) {
                int j2 = PRTokeniser.j(b2);
                if (j2 != -1) {
                    if (z) {
                        i4 = j2;
                    } else {
                        byteArrayOutputStream.write((byte) ((i4 << 4) + j2));
                    }
                    z = !z;
                } else {
                    throw new RuntimeException(MessageLocalization.b("illegal.character.in.asciihexdecode", new Object[0]));
                }
            }
            i2++;
        }
        if (!z) {
            byteArrayOutputStream.write((byte) (i4 << 4));
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] d(byte[] bArr) {
        byte[] e2 = e(bArr, true);
        return e2 == null ? e(bArr, false) : e2;
    }

    private static PRTokeniser d0(RandomAccessSource randomAccessSource) throws IOException {
        PRTokeniser pRTokeniser = new PRTokeniser(new RandomAccessFileOrArray(randomAccessSource));
        int i2 = pRTokeniser.i();
        return i2 != 0 ? new PRTokeniser(new RandomAccessFileOrArray((RandomAccessSource) new WindowRandomAccessSource(randomAccessSource, (long) i2))) : pRTokeniser;
    }

    public static byte[] e(byte[] bArr, boolean z) {
        InflaterInputStream inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(bArr));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[(z ? 4092 : 1)];
        while (true) {
            try {
                int read = inflaterInputStream.read(bArr2);
                if (read >= 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    inflaterInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            } catch (Exception unused) {
                if (z) {
                    return null;
                }
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static byte[] f(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new LZWDecoder().d(bArr, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] g0(com.itextpdf.text.pdf.PdfDictionary r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.N5     // Catch:{ all -> 0x0014 }
            com.itextpdf.text.pdf.PdfObject r5 = r5.d0(r1)     // Catch:{ all -> 0x0014 }
            com.itextpdf.text.pdf.PdfObject r5 = w0(r5)     // Catch:{ all -> 0x0014 }
            r1 = 0
            if (r5 != 0) goto L_0x0017
            byte[] r5 = new byte[r1]     // Catch:{ all -> 0x0014 }
            return r5
        L_0x0014:
            r5 = move-exception
            goto L_0x008f
        L_0x0017:
            boolean r2 = r5.K()     // Catch:{ all -> 0x0014 }
            if (r2 == 0) goto L_0x0035
            r1 = r5
            com.itextpdf.text.pdf.PRStream r1 = (com.itextpdf.text.pdf.PRStream) r1     // Catch:{ all -> 0x0014 }
            com.itextpdf.text.pdf.PdfReader r1 = r1.x1()     // Catch:{ all -> 0x0014 }
            com.itextpdf.text.pdf.RandomAccessFileOrArray r0 = r1.B0()     // Catch:{ all -> 0x0014 }
            r0.g()     // Catch:{ all -> 0x0014 }
            com.itextpdf.text.pdf.PRStream r5 = (com.itextpdf.text.pdf.PRStream) r5     // Catch:{ all -> 0x0014 }
            byte[] r5 = E0(r5, r0)     // Catch:{ all -> 0x0014 }
            r0.close()     // Catch:{ Exception -> 0x0034 }
        L_0x0034:
            return r5
        L_0x0035:
            boolean r2 = r5.q()     // Catch:{ all -> 0x0014 }
            if (r2 == 0) goto L_0x008c
            com.itextpdf.text.pdf.PdfArray r5 = (com.itextpdf.text.pdf.PdfArray) r5     // Catch:{ all -> 0x0014 }
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0014 }
            r2.<init>()     // Catch:{ all -> 0x0014 }
        L_0x0042:
            int r3 = r5.size()     // Catch:{ all -> 0x0014 }
            if (r1 >= r3) goto L_0x0082
            com.itextpdf.text.pdf.PdfObject r3 = r5.T0(r1)     // Catch:{ all -> 0x0014 }
            com.itextpdf.text.pdf.PdfObject r3 = w0(r3)     // Catch:{ all -> 0x0014 }
            if (r3 == 0) goto L_0x007f
            boolean r4 = r3.K()     // Catch:{ all -> 0x0014 }
            if (r4 != 0) goto L_0x0059
            goto L_0x007f
        L_0x0059:
            if (r0 != 0) goto L_0x0069
            r4 = r3
            com.itextpdf.text.pdf.PRStream r4 = (com.itextpdf.text.pdf.PRStream) r4     // Catch:{ all -> 0x0014 }
            com.itextpdf.text.pdf.PdfReader r4 = r4.x1()     // Catch:{ all -> 0x0014 }
            com.itextpdf.text.pdf.RandomAccessFileOrArray r0 = r4.B0()     // Catch:{ all -> 0x0014 }
            r0.g()     // Catch:{ all -> 0x0014 }
        L_0x0069:
            com.itextpdf.text.pdf.PRStream r3 = (com.itextpdf.text.pdf.PRStream) r3     // Catch:{ all -> 0x0014 }
            byte[] r3 = E0(r3, r0)     // Catch:{ all -> 0x0014 }
            r2.write(r3)     // Catch:{ all -> 0x0014 }
            int r3 = r5.size()     // Catch:{ all -> 0x0014 }
            int r3 = r3 + -1
            if (r1 == r3) goto L_0x007f
            r3 = 10
            r2.write(r3)     // Catch:{ all -> 0x0014 }
        L_0x007f:
            int r1 = r1 + 1
            goto L_0x0042
        L_0x0082:
            byte[] r5 = r2.toByteArray()     // Catch:{ all -> 0x0014 }
            if (r0 == 0) goto L_0x008b
            r0.close()     // Catch:{ Exception -> 0x008b }
        L_0x008b:
            return r5
        L_0x008c:
            byte[] r5 = new byte[r1]     // Catch:{ all -> 0x0014 }
            return r5
        L_0x008f:
            if (r0 == 0) goto L_0x0094
            r0.close()     // Catch:{ Exception -> 0x0094 }
        L_0x0094:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfReader.g0(com.itextpdf.text.pdf.PdfDictionary):byte[]");
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void k(com.itextpdf.text.pdf.PRStream r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            com.itextpdf.text.pdf.PRTokeniser r2 = r0.s
            long r2 = r2.v()
            long r4 = r19.w1()
            com.itextpdf.text.pdf.PdfName r6 = com.itextpdf.text.pdf.PdfName.va
            com.itextpdf.text.pdf.PdfObject r6 = r1.d0(r6)
            com.itextpdf.text.pdf.PdfObject r6 = w0(r6)
            java.lang.String r7 = "endstream"
            r8 = 1
            r9 = 0
            r10 = 0
            if (r6 == 0) goto L_0x0067
            int r12 = r6.W()
            r13 = 2
            if (r12 != r13) goto L_0x0067
            com.itextpdf.text.pdf.PdfNumber r6 = (com.itextpdf.text.pdf.PdfNumber) r6
            int r6 = r6.e0()
            long r12 = (long) r6
            long r14 = r12 + r4
            r16 = 20
            long r2 = r2 - r16
            int r6 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r6 <= 0) goto L_0x0039
            goto L_0x0068
        L_0x0039:
            com.itextpdf.text.pdf.PRTokeniser r2 = r0.s
            r2.D(r14)
            com.itextpdf.text.pdf.PRTokeniser r2 = r0.s
            r3 = 20
            java.lang.String r2 = r2.C(r3)
            java.lang.String r3 = "\nendstream"
            boolean r3 = r2.startsWith(r3)
            if (r3 != 0) goto L_0x0065
            java.lang.String r3 = "\r\nendstream"
            boolean r3 = r2.startsWith(r3)
            if (r3 != 0) goto L_0x0065
            java.lang.String r3 = "\rendstream"
            boolean r3 = r2.startsWith(r3)
            if (r3 != 0) goto L_0x0065
            boolean r2 = r2.startsWith(r7)
            if (r2 != 0) goto L_0x0065
            goto L_0x0068
        L_0x0065:
            r8 = 0
            goto L_0x0068
        L_0x0067:
            r12 = r10
        L_0x0068:
            if (r8 == 0) goto L_0x00da
            r2 = 16
            byte[] r3 = new byte[r2]
            com.itextpdf.text.pdf.PRTokeniser r6 = r0.s
            r6.D(r4)
        L_0x0073:
            com.itextpdf.text.pdf.PRTokeniser r6 = r0.s
            long r14 = r6.g()
            com.itextpdf.text.pdf.PRTokeniser r6 = r0.s
            boolean r6 = r6.B(r3, r9)
            if (r6 != 0) goto L_0x0082
            goto L_0x00ae
        L_0x0082:
            byte[] r6 = O3
            boolean r6 = A(r3, r6)
            if (r6 == 0) goto L_0x008d
        L_0x008a:
            long r12 = r14 - r4
            goto L_0x00ae
        L_0x008d:
            byte[] r6 = P3
            boolean r6 = A(r3, r6)
            if (r6 == 0) goto L_0x0073
            com.itextpdf.text.pdf.PRTokeniser r3 = r0.s
            r8 = 16
            long r8 = r14 - r8
            r3.D(r8)
            com.itextpdf.text.pdf.PRTokeniser r3 = r0.s
            java.lang.String r2 = r3.C(r2)
            int r2 = r2.indexOf(r7)
            if (r2 < 0) goto L_0x008a
            long r2 = (long) r2
            long r14 = r8 + r2
            goto L_0x008a
        L_0x00ae:
            com.itextpdf.text.pdf.PRTokeniser r2 = r0.s
            r3 = 2
            long r3 = r14 - r3
            r2.D(r3)
            com.itextpdf.text.pdf.PRTokeniser r2 = r0.s
            int r2 = r2.z()
            r3 = 13
            r4 = 1
            if (r2 != r3) goto L_0x00c4
            long r12 = r12 - r4
        L_0x00c4:
            com.itextpdf.text.pdf.PRTokeniser r2 = r0.s
            long r14 = r14 - r4
            r2.D(r14)
            com.itextpdf.text.pdf.PRTokeniser r2 = r0.s
            int r2 = r2.z()
            r3 = 10
            if (r2 != r3) goto L_0x00d5
            long r12 = r12 - r4
        L_0x00d5:
            int r2 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r2 >= 0) goto L_0x00da
            goto L_0x00db
        L_0x00da:
            r10 = r12
        L_0x00db:
            int r2 = (int) r10
            r1.J1(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfReader.k(com.itextpdf.text.pdf.PRStream):void");
    }

    private boolean o(PdfObject pdfObject, HashMap<Object, PdfObject> hashMap) {
        PdfObject t0;
        PdfObject w0;
        PdfObject t02 = t0(pdfObject);
        int i2 = this.D3;
        p1();
        if (t02 == null || !t02.z() || (t0 = t0(((PdfDictionary) t02).d0(PdfName.k3))) == null) {
            return false;
        }
        int i4 = this.D3;
        p1();
        PdfDictionary pdfDictionary = (PdfDictionary) t0;
        PdfName pdfName = PdfName.Ce;
        if (!PdfName.Q8.equals((PdfName) w0(pdfDictionary.d0(pdfName))) || (w0 = w0(pdfDictionary.d0(PdfName.f6))) == null) {
            return false;
        }
        boolean E = w0.E();
        Object obj = w0;
        if (!E) {
            obj = w0.N() ? w0.toString() : null;
        }
        if (((PdfArray) hashMap.get(obj)) == null) {
            return false;
        }
        pdfDictionary.a1(PdfName.F7);
        pdfDictionary.a1(PdfName.zb);
        pdfDictionary.V0(pdfName, PdfName.N8);
        J1(i4, t0);
        J1(i2, t02);
        return true;
    }

    public static byte[] q(byte[] bArr, PdfDictionary pdfDictionary) throws IOException {
        return r(bArr, pdfDictionary, FilterHandlers.a());
    }

    public static void q1(PdfObject pdfObject) {
        int i2;
        if (pdfObject != null && pdfObject.C() && (pdfObject instanceof PRIndirectReference)) {
            PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
            PdfReader a0 = pRIndirectReference.a0();
            if (a0.E3 && (i2 = a0.D3) != -1 && i2 == pRIndirectReference.d()) {
                a0.Y2.set(a0.D3, (Object) null);
            }
            a0.D3 = -1;
        }
    }

    public static byte[] r(byte[] bArr, PdfDictionary pdfDictionary, Map<PdfName, FilterHandlers.FilterHandler> map) throws IOException {
        PdfObject w0 = w0(pdfDictionary.d0(PdfName.T7));
        ArrayList<PdfObject> arrayList = new ArrayList<>();
        if (w0 != null) {
            if (w0.E()) {
                arrayList.add(w0);
            } else if (w0.q()) {
                arrayList = ((PdfArray) w0).q0();
            }
        }
        ArrayList<PdfObject> arrayList2 = new ArrayList<>();
        PdfObject w02 = w0(pdfDictionary.d0(PdfName.o6));
        if (w02 == null || (!w02.z() && !w02.q())) {
            w02 = w0(pdfDictionary.d0(PdfName.S6));
        }
        if (w02 != null) {
            if (w02.z()) {
                arrayList2.add(w02);
            } else if (w02.q()) {
                arrayList2 = ((PdfArray) w02).q0();
            }
        }
        int i2 = 0;
        while (i2 < arrayList.size()) {
            PdfName pdfName = (PdfName) arrayList.get(i2);
            FilterHandlers.FilterHandler filterHandler = map.get(pdfName);
            if (filterHandler != null) {
                PdfDictionary pdfDictionary2 = null;
                if (i2 < arrayList2.size()) {
                    Object t0 = t0(arrayList2.get(i2));
                    if (t0 instanceof PdfDictionary) {
                        pdfDictionary2 = (PdfDictionary) t0;
                    } else if (t0 != null && !(t0 instanceof PdfNull) && (!(t0 instanceof PdfLiteral) || !Arrays.equals("null".getBytes(), ((PdfLiteral) t0).k()))) {
                        throw new UnsupportedPdfException(MessageLocalization.b("the.decode.parameter.type.1.is.not.supported", t0.getClass().toString()));
                    }
                }
                bArr = filterHandler.a(bArr, pdfName, pdfDictionary2, pdfDictionary);
                i2++;
            } else {
                throw new UnsupportedPdfException(MessageLocalization.b("the.filter.1.is.not.supported", pdfName));
            }
        }
        return bArr;
    }

    public static byte[] s(byte[] bArr, PdfObject pdfObject) {
        byte[] bArr2 = bArr;
        if (pdfObject == null || !pdfObject.z()) {
            return bArr2;
        }
        PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
        PdfObject t0 = t0(pdfDictionary.d0(PdfName.bd));
        if (t0 == null || !t0.I()) {
            return bArr2;
        }
        int e0 = ((PdfNumber) t0).e0();
        if (e0 < 10 && e0 != 2) {
            return bArr2;
        }
        PdfObject t02 = t0(pdfDictionary.d0(PdfName.G5));
        int e02 = (t02 == null || !t02.I()) ? 1 : ((PdfNumber) t02).e0();
        PdfObject t03 = t0(pdfDictionary.d0(PdfName.v5));
        int e03 = (t03 == null || !t03.I()) ? 1 : ((PdfNumber) t03).e0();
        PdfObject t04 = t0(pdfDictionary.d0(PdfName.u4));
        int e04 = (t04 == null || !t04.I()) ? 8 : ((PdfNumber) t04).e0();
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr2));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr2.length);
        int i2 = (e03 * e04) / 8;
        int i4 = (((e03 * e02) * e04) + 7) / 8;
        byte[] bArr3 = new byte[i4];
        byte[] bArr4 = new byte[i4];
        if (e0 == 2) {
            if (e04 == 8) {
                int length = bArr2.length / i4;
                for (int i5 = 0; i5 < length; i5++) {
                    int i6 = i5 * i4;
                    for (int i7 = i2; i7 < i4; i7++) {
                        int i8 = i6 + i7;
                        bArr2[i8] = (byte) (bArr2[i8] + bArr2[i8 - i2]);
                    }
                }
            }
            return bArr2;
        }
        while (true) {
            try {
                int read = dataInputStream.read();
                if (read < 0) {
                    return byteArrayOutputStream.toByteArray();
                }
                dataInputStream.readFully(bArr3, 0, i4);
                if (read != 0) {
                    if (read == 1) {
                        for (int i9 = i2; i9 < i4; i9++) {
                            bArr3[i9] = (byte) (bArr3[i9] + bArr3[i9 - i2]);
                        }
                    } else if (read == 2) {
                        for (int i10 = 0; i10 < i4; i10++) {
                            bArr3[i10] = (byte) (bArr3[i10] + bArr4[i10]);
                        }
                    } else if (read == 3) {
                        for (int i11 = 0; i11 < i2; i11++) {
                            bArr3[i11] = (byte) (bArr3[i11] + (bArr4[i11] / 2));
                        }
                        for (int i12 = i2; i12 < i4; i12++) {
                            bArr3[i12] = (byte) (bArr3[i12] + (((bArr3[i12 - i2] & 255) + (bArr4[i12] & 255)) / 2));
                        }
                    } else if (read == 4) {
                        for (int i13 = 0; i13 < i2; i13++) {
                            bArr3[i13] = (byte) (bArr3[i13] + bArr4[i13]);
                        }
                        for (int i14 = i2; i14 < i4; i14++) {
                            int i15 = i14 - i2;
                            byte b2 = bArr3[i15] & 255;
                            byte b4 = bArr4[i14] & 255;
                            byte b5 = bArr4[i15] & 255;
                            int i16 = (b2 + b4) - b5;
                            int abs = Math.abs(i16 - b2);
                            int abs2 = Math.abs(i16 - b4);
                            int abs3 = Math.abs(i16 - b5);
                            if (abs > abs2 || abs > abs3) {
                                b2 = abs2 <= abs3 ? b4 : b5;
                            }
                            bArr3[i14] = (byte) (bArr3[i14] + ((byte) b2));
                        }
                    } else {
                        throw new RuntimeException(MessageLocalization.b("png.filter.unknown", new Object[0]));
                    }
                }
                try {
                    byteArrayOutputStream.write(bArr3);
                } catch (IOException unused) {
                }
                byte[] bArr5 = bArr4;
                bArr4 = bArr3;
                bArr3 = bArr5;
            } catch (Exception unused2) {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static PdfObject t0(PdfObject pdfObject) {
        PdfObject pdfBoolean;
        if (pdfObject == null) {
            return null;
        }
        if (!pdfObject.C()) {
            return pdfObject;
        }
        try {
            PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
            int d2 = pRIndirectReference.d();
            boolean z = pRIndirectReference.a0().I3;
            PdfObject s0 = pRIndirectReference.a0().s0(d2);
            if (s0 == null) {
                return null;
            }
            if (z) {
                int W = s0.W();
                if (W == 1) {
                    pdfBoolean = new PdfBoolean(((PdfBoolean) s0).Z());
                } else if (W != 4) {
                    if (W == 8) {
                        s0 = new PdfNull();
                    }
                    s0.R(pRIndirectReference);
                } else {
                    pdfBoolean = new PdfName(s0.k());
                }
                s0 = pdfBoolean;
                s0.R(pRIndirectReference);
            }
            return s0;
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    protected static PdfDictionary u(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2, PdfReader pdfReader) {
        if (pdfDictionary2 == null) {
            pdfDictionary2 = new PdfDictionary(pdfDictionary.size());
        }
        for (PdfName next : pdfDictionary.G0()) {
            pdfDictionary2.V0(next, w(pdfDictionary.d0(next), pdfReader));
        }
        return pdfDictionary2;
    }

    public static PdfObject u0(PdfObject pdfObject, PdfObject pdfObject2) {
        PRIndirectReference m2;
        PdfObject pdfBoolean;
        if (pdfObject == null) {
            return null;
        }
        if (pdfObject.C()) {
            return t0(pdfObject);
        }
        if (!(pdfObject2 == null || (m2 = pdfObject2.m()) == null || !m2.a0().M0())) {
            int W = pdfObject.W();
            if (W == 1) {
                pdfBoolean = new PdfBoolean(((PdfBoolean) pdfObject).Z());
            } else if (W != 4) {
                if (W == 8) {
                    pdfObject = new PdfNull();
                }
                pdfObject.R(m2);
            } else {
                pdfBoolean = new PdfName(pdfObject.k());
            }
            pdfObject = pdfBoolean;
            pdfObject.R(m2);
        }
        return pdfObject;
    }

    protected static PdfObject w(PdfObject pdfObject, PdfReader pdfReader) {
        if (pdfObject == null) {
            return null;
        }
        int W = pdfObject.W();
        if (W == 5) {
            PdfArray pdfArray = (PdfArray) pdfObject;
            PdfArray pdfArray2 = new PdfArray(pdfArray.size());
            ListIterator<PdfObject> listIterator = pdfArray.listIterator();
            while (listIterator.hasNext()) {
                pdfArray2.a0(w(listIterator.next(), pdfReader));
            }
            return pdfArray2;
        } else if (W == 6) {
            return u((PdfDictionary) pdfObject, (PdfDictionary) null, pdfReader);
        } else {
            if (W == 7) {
                PRStream pRStream = (PRStream) pdfObject;
                PRStream pRStream2 = new PRStream(pRStream, (PdfDictionary) null, pdfReader);
                u(pRStream, pRStream2, pdfReader);
                return pRStream2;
            } else if (W != 10) {
                return pdfObject;
            } else {
                PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
                return new PRIndirectReference(pdfReader, pRIndirectReference.d(), pRIndirectReference.Z());
            }
        }
    }

    public static PdfObject w0(PdfObject pdfObject) {
        PdfObject t0 = t0(pdfObject);
        q1(pdfObject);
        return t0;
    }

    public static PdfObject x0(PdfObject pdfObject, PdfObject pdfObject2) {
        PdfObject u0 = u0(pdfObject, pdfObject2);
        q1(pdfObject);
        return u0;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean x1(com.itextpdf.text.pdf.PdfObject r10, java.util.HashMap<java.lang.Object, com.itextpdf.text.pdf.PdfObject> r11) {
        /*
            r9 = this;
            com.itextpdf.text.pdf.PdfObject r10 = t0(r10)
            int r0 = r9.D3
            r9.p1()
            if (r10 == 0) goto L_0x0099
            boolean r1 = r10.z()
            if (r1 == 0) goto L_0x0099
            r1 = r10
            com.itextpdf.text.pdf.PdfDictionary r1 = (com.itextpdf.text.pdf.PdfDictionary) r1
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.x6
            com.itextpdf.text.pdf.PdfObject r3 = r1.d0(r2)
            com.itextpdf.text.pdf.PdfObject r3 = w0(r3)
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x0044
            boolean r6 = r3.E()
            if (r6 == 0) goto L_0x0029
            goto L_0x0035
        L_0x0029:
            boolean r6 = r3.N()
            if (r6 == 0) goto L_0x0034
            java.lang.String r3 = r3.toString()
            goto L_0x0035
        L_0x0034:
            r3 = r5
        L_0x0035:
            java.lang.Object r11 = r11.get(r3)
            com.itextpdf.text.pdf.PdfArray r11 = (com.itextpdf.text.pdf.PdfArray) r11
            if (r11 == 0) goto L_0x0099
            r1.V0(r2, r11)
        L_0x0040:
            r9.J1(r0, r10)
            return r4
        L_0x0044:
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.k3
            com.itextpdf.text.pdf.PdfObject r1 = r1.d0(r2)
            com.itextpdf.text.pdf.PdfObject r1 = t0(r1)
            if (r1 == 0) goto L_0x0099
            int r2 = r9.D3
            r9.p1()
            r3 = r1
            com.itextpdf.text.pdf.PdfDictionary r3 = (com.itextpdf.text.pdf.PdfDictionary) r3
            com.itextpdf.text.pdf.PdfName r6 = com.itextpdf.text.pdf.PdfName.Ce
            com.itextpdf.text.pdf.PdfObject r6 = r3.d0(r6)
            com.itextpdf.text.pdf.PdfObject r6 = w0(r6)
            com.itextpdf.text.pdf.PdfName r6 = (com.itextpdf.text.pdf.PdfName) r6
            com.itextpdf.text.pdf.PdfName r7 = com.itextpdf.text.pdf.PdfName.N8
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x0099
            com.itextpdf.text.pdf.PdfName r6 = com.itextpdf.text.pdf.PdfName.f6
            com.itextpdf.text.pdf.PdfObject r7 = r3.d0(r6)
            com.itextpdf.text.pdf.PdfObject r7 = w0(r7)
            if (r7 == 0) goto L_0x008a
            boolean r8 = r7.E()
            if (r8 == 0) goto L_0x0080
            r5 = r7
            goto L_0x008a
        L_0x0080:
            boolean r8 = r7.N()
            if (r8 == 0) goto L_0x008a
            java.lang.String r5 = r7.toString()
        L_0x008a:
            java.lang.Object r11 = r11.get(r5)
            com.itextpdf.text.pdf.PdfArray r11 = (com.itextpdf.text.pdf.PdfArray) r11
            if (r11 == 0) goto L_0x0099
            r3.V0(r6, r11)
            r9.J1(r2, r1)
            goto L_0x0040
        L_0x0099:
            r10 = 0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfReader.x1(com.itextpdf.text.pdf.PdfObject, java.util.HashMap):boolean");
    }

    private void y(int i2) {
        if (i2 != 0) {
            long[] jArr = this.X;
            if (jArr == null) {
                this.X = new long[i2];
            } else if (jArr.length < i2) {
                long[] jArr2 = new long[i2];
                System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
                this.X = jArr2;
            }
        }
    }

    private boolean z(byte[] bArr, byte[] bArr2, int i2) {
        for (int i4 = 0; i4 < i2; i4++) {
            if (bArr[i4] != bArr2[i4]) {
                return false;
            }
        }
        return true;
    }

    public long A0() {
        return this.y3;
    }

    public void A1(String str) {
        B1(SequenceList.a(str, c0()));
    }

    public RandomAccessFileOrArray B0() {
        return this.s.l();
    }

    public void B1(List<Integer> list) {
        C1(list, true);
    }

    public AcroFields C() {
        return new AcroFields(this, (PdfWriter) null);
    }

    public int C0() {
        return PdfViewerPreferencesImp.f(this.b3).d();
    }

    /* access modifiers changed from: protected */
    public void C1(List<Integer> list, boolean z) {
        this.c3.p(list);
        if (z) {
            v1();
        }
    }

    public PRAcroForm D() {
        if (!this.e3) {
            this.e3 = true;
            PdfObject d0 = this.b3.d0(PdfName.p3);
            if (d0 != null) {
                try {
                    PRAcroForm pRAcroForm = new PRAcroForm(this);
                    this.d3 = pRAcroForm;
                    pRAcroForm.q1((PdfDictionary) t0(d0));
                } catch (Exception unused) {
                    this.d3 = null;
                }
            }
        }
        return this.d3;
    }

    public void D1(boolean z) {
        this.I3 = z;
        if (z) {
            t0(this.a3.d0(PdfName.se));
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.Rectangle E(int r3, java.lang.String r4) {
        /*
            r2 = this;
            com.itextpdf.text.pdf.PdfReader$PageRefs r0 = r2.c3
            com.itextpdf.text.pdf.PdfDictionary r3 = r0.c(r3)
            java.lang.String r0 = "trim"
            boolean r0 = r4.equals(r0)
            r1 = 0
            if (r0 == 0) goto L_0x001c
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.zg
        L_0x0011:
            com.itextpdf.text.pdf.PdfObject r3 = r3.d0(r4)
            com.itextpdf.text.pdf.PdfObject r3 = w0(r3)
            com.itextpdf.text.pdf.PdfArray r3 = (com.itextpdf.text.pdf.PdfArray) r3
            goto L_0x0049
        L_0x001c:
            java.lang.String r0 = "art"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0027
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.W3
            goto L_0x0011
        L_0x0027:
            java.lang.String r0 = "bleed"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0032
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.A4
            goto L_0x0011
        L_0x0032:
            java.lang.String r0 = "crop"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x003d
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.Z5
            goto L_0x0011
        L_0x003d:
            java.lang.String r0 = "media"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0048
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.Za
            goto L_0x0011
        L_0x0048:
            r3 = r1
        L_0x0049:
            if (r3 != 0) goto L_0x004c
            return r1
        L_0x004c:
            com.itextpdf.text.Rectangle r3 = b0(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfReader.E(int, java.lang.String):com.itextpdf.text.Rectangle");
    }

    public void E1(int i2, byte[] bArr) {
        F1(i2, bArr, -1);
    }

    public PdfDictionary F() {
        return this.b3;
    }

    public void F1(int i2, byte[] bArr, int i4) {
        G1(i2, bArr, i4, false);
    }

    public int G() {
        PdfDictionary j0;
        PdfArray e0;
        PdfDictionary B0;
        PdfDictionary j02;
        PdfNumber q0;
        PdfDictionary j03 = this.b3.j0(PdfName.Qc);
        if (j03 == null || (j0 = j03.j0(PdfName.M6)) == null || (e0 = j0.e0(PdfName.Pd)) == null || e0.size() == 0 || (B0 = e0.B0(0)) == null || (j02 = B0.j0(PdfName.tg)) == null || (q0 = j02.q0(PdfName.tc)) == null) {
            return 0;
        }
        return q0.e0();
    }

    public void G1(int i2, byte[] bArr, int i4, boolean z) {
        PdfDictionary h0 = h0(i2);
        if (h0 != null) {
            PdfName pdfName = PdfName.N5;
            PdfObject d0 = h0.d0(pdfName);
            this.h3 = -1;
            if (z) {
                X0(d0);
            }
            if (this.h3 == -1) {
                this.Y2.add((Object) null);
                this.h3 = this.Y2.size() - 1;
            }
            h0.V0(pdfName, new PRIndirectReference(this, this.h3));
            this.Y2.set(this.h3, new PRStream(this, bArr, i4));
        }
    }

    /* access modifiers changed from: protected */
    public Counter H() {
        return Q3;
    }

    public void H1(boolean z) {
        this.i3 = z;
        this.c3.i();
    }

    public Rectangle I(int i2) {
        PdfDictionary c2 = this.c3.c(i2);
        PdfArray pdfArray = (PdfArray) w0(c2.d0(PdfName.Z5));
        return pdfArray == null ? p0(c2) : b0(pdfArray);
    }

    public PdfDictionary I0() {
        return this.a3;
    }

    public void I1(PdfViewerPreferencesImp pdfViewerPreferencesImp) {
        pdfViewerPreferencesImp.b(this.b3);
    }

    public int J() {
        PdfEncryption pdfEncryption = this.m3;
        if (pdfEncryption == null) {
            return -1;
        }
        return pdfEncryption.j();
    }

    public int J0() {
        return this.Y2.size();
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference K() {
        PRIndirectReference pRIndirectReference = this.F3;
        if (pRIndirectReference == null) {
            return null;
        }
        return new PdfIndirectReference(0, pRIndirectReference.d(), this.F3.Z());
    }

    public boolean K0() {
        PdfDictionary j0 = this.b3.j0(PdfName.Qc);
        if (j0 == null) {
            return false;
        }
        return j0.a0(PdfName.Wg) || j0.a0(PdfName.Xg);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int K1() {
        /*
            r12 = this;
            r0 = 0
            r1 = 1
            r2 = 0
        L_0x0003:
            java.util.ArrayList<com.itextpdf.text.pdf.PdfObject> r3 = r12.Y2
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x0101
            com.itextpdf.text.pdf.PdfObject r3 = r12.v0(r1)
            if (r3 == 0) goto L_0x00fd
            boolean r4 = r3.z()
            if (r4 != 0) goto L_0x0019
            goto L_0x00fd
        L_0x0019:
            com.itextpdf.text.pdf.PdfDictionary r3 = (com.itextpdf.text.pdf.PdfDictionary) r3
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.Kg
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.l8
            boolean r4 = B(r3, r4, r5)
            if (r4 != 0) goto L_0x0027
            goto L_0x00fd
        L_0x0027:
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.Cf
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.Mg
            boolean r5 = B(r3, r4, r5)
            r6 = 7
            if (r5 != 0) goto L_0x00c2
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.hb
            boolean r5 = B(r3, r4, r5)
            if (r5 != 0) goto L_0x00c2
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.Ag
            boolean r5 = B(r3, r4, r5)
            if (r5 == 0) goto L_0x0044
            goto L_0x00c2
        L_0x0044:
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.Lg
            boolean r4 = B(r3, r4, r5)
            if (r4 == 0) goto L_0x00fd
            java.lang.String r4 = H0(r3)
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.v6
            com.itextpdf.text.pdf.PdfArray r5 = r3.e0(r5)
            if (r5 != 0) goto L_0x005a
            goto L_0x00fd
        L_0x005a:
            boolean r7 = r5.isEmpty()
            if (r7 == 0) goto L_0x0062
            goto L_0x00fd
        L_0x0062:
            com.itextpdf.text.pdf.PdfDictionary r5 = r5.B0(r0)
            java.lang.String r7 = H0(r5)
            if (r7 != 0) goto L_0x006e
            goto L_0x00fd
        L_0x006e:
            java.lang.String r8 = com.itextpdf.text.pdf.BaseFont.o()
            if (r4 == 0) goto L_0x0091
            com.itextpdf.text.pdf.PdfName r9 = com.itextpdf.text.pdf.PdfName.l4
            com.itextpdf.text.pdf.PdfName r10 = new com.itextpdf.text.pdf.PdfName
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r8)
            java.lang.String r4 = r4.substring(r6)
            r11.append(r4)
            java.lang.String r4 = r11.toString()
            r10.<init>((java.lang.String) r4)
            r3.V0(r9, r10)
        L_0x0091:
            r12.J1(r1, r3)
            com.itextpdf.text.pdf.PdfName r3 = new com.itextpdf.text.pdf.PdfName
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r8)
            java.lang.String r6 = r7.substring(r6)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            r3.<init>((java.lang.String) r4)
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.l4
            r5.V0(r4, r3)
            int r2 = r2 + 1
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.n8
            com.itextpdf.text.pdf.PdfDictionary r4 = r5.j0(r4)
            if (r4 != 0) goto L_0x00bc
            goto L_0x00fd
        L_0x00bc:
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.t8
            r4.V0(r5, r3)
            goto L_0x00fd
        L_0x00c2:
            java.lang.String r4 = H0(r3)
            if (r4 != 0) goto L_0x00c9
            goto L_0x00fd
        L_0x00c9:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = com.itextpdf.text.pdf.BaseFont.o()
            r5.append(r7)
            java.lang.String r4 = r4.substring(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            com.itextpdf.text.pdf.PdfName r5 = new com.itextpdf.text.pdf.PdfName
            r5.<init>((java.lang.String) r4)
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.l4
            r3.V0(r4, r5)
            r12.J1(r1, r3)
            int r2 = r2 + 1
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.n8
            com.itextpdf.text.pdf.PdfDictionary r3 = r3.j0(r4)
            if (r3 != 0) goto L_0x00f8
            goto L_0x00fd
        L_0x00f8:
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.t8
            r3.V0(r4, r5)
        L_0x00fd:
            int r1 = r1 + 1
            goto L_0x0003
        L_0x0101:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfReader.K1():int");
    }

    /* access modifiers changed from: package-private */
    public PdfEncryption L() {
        return this.m3;
    }

    public boolean L0() {
        return this.x3 == 3;
    }

    public long M() {
        return this.k3;
    }

    public boolean M0() {
        return this.I3;
    }

    public long N() {
        return this.B3;
    }

    public boolean N0() {
        return this.f3;
    }

    public boolean O0() {
        return this.C3;
    }

    public HashMap<String, String> P() {
        HashMap<String, String> hashMap = new HashMap<>();
        PdfDictionary j0 = this.a3.j0(PdfName.O9);
        if (j0 == null) {
            return hashMap;
        }
        for (PdfName next : j0.G0()) {
            PdfObject t0 = t0(j0.d0(next));
            if (t0 != null) {
                String pdfObject = t0.toString();
                int W = t0.W();
                if (W == 3) {
                    pdfObject = ((PdfString) t0).m0();
                } else if (W == 4) {
                    pdfObject = PdfName.a0(pdfObject);
                }
                hashMap.put(PdfName.a0(next.toString()), pdfObject);
            }
        }
        return hashMap;
    }

    public boolean P0() {
        PdfEncryption pdfEncryption = this.m3;
        if (pdfEncryption == null) {
            return false;
        }
        return pdfEncryption.q();
    }

    public String Q() throws IOException {
        RandomAccessFileOrArray B0 = B0();
        try {
            B0.g();
            return R(B0);
        } finally {
            try {
                B0.close();
            } catch (Exception unused) {
            }
        }
    }

    public boolean Q0() {
        return this.X2;
    }

    public String R(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        PdfDictionary pdfDictionary;
        PdfObject w0;
        String d2;
        PdfDictionary pdfDictionary2 = (PdfDictionary) w0(this.b3.d0(PdfName.sb));
        if (pdfDictionary2 == null || (pdfDictionary = (PdfDictionary) w0(pdfDictionary2.d0(PdfName.aa))) == null) {
            return null;
        }
        HashMap<String, PdfObject> b2 = PdfNameTree.b(pdfDictionary);
        String[] strArr = (String[]) b2.keySet().toArray(new String[b2.size()]);
        Arrays.sort(strArr);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : strArr) {
            PdfDictionary pdfDictionary3 = (PdfDictionary) w0(b2.get(str));
            if (!(pdfDictionary3 == null || (w0 = w0(pdfDictionary3.d0(PdfName.ea))) == null)) {
                if (w0.N()) {
                    d2 = ((PdfString) w0).m0();
                } else if (w0.K()) {
                    byte[] E0 = E0((PRStream) w0, randomAccessFileOrArray);
                    d2 = PdfEncodings.d(E0, (E0.length >= 2 && E0[0] == -2 && E0[1] == -1) ? PdfObject.h3 : PdfObject.g3);
                }
                stringBuffer.append(d2);
                stringBuffer.append(10);
            }
        }
        return stringBuffer.toString();
    }

    public final boolean R0() {
        return !this.f3 || this.s3 || K3;
    }

    public long S() {
        return this.j3;
    }

    public boolean S0() {
        return this.g3;
    }

    public ArrayList<PdfAnnotation.PdfImportedLink> T(int i2) {
        this.c3.o();
        ArrayList<PdfAnnotation.PdfImportedLink> arrayList = new ArrayList<>();
        PdfDictionary b2 = this.c3.b(i2);
        PdfName pdfName = PdfName.Q3;
        if (b2.d0(pdfName) != null) {
            PdfArray e0 = b2.e0(pdfName);
            for (int i4 = 0; i4 < e0.size(); i4++) {
                PdfDictionary pdfDictionary = (PdfDictionary) w0(e0.T0(i4));
                if (PdfName.Ca.equals(pdfDictionary.d0(PdfName.Cf))) {
                    arrayList.add(new PdfAnnotation.PdfImportedLink(pdfDictionary));
                }
            }
        }
        this.c3.n(i2);
        this.c3.o();
        return arrayList;
    }

    public boolean T0() {
        PdfDictionary j0 = this.b3.j0(PdfName.Ua);
        return (j0 == null || !PdfBoolean.j3.equals(j0.i0(PdfName.Ta)) || this.b3.j0(PdfName.xf) == null) ? false : true;
    }

    public byte[] U() throws IOException {
        PdfObject t0 = t0(this.b3.d0(PdfName.db));
        if (!(t0 instanceof PRStream)) {
            return null;
        }
        RandomAccessFileOrArray B0 = B0();
        try {
            B0.g();
            return E0((PRStream) t0, B0);
        } finally {
            try {
                B0.close();
            } catch (Exception unused) {
            }
        }
    }

    public boolean U0() {
        return this.i3;
    }

    public HashMap<Object, PdfObject> W() {
        return X(false);
    }

    public HashMap<Object, PdfObject> X(boolean z) {
        HashMap<Object, PdfObject> Z3 = Z(z);
        Z3.putAll(a0());
        return Z3;
    }

    /* access modifiers changed from: protected */
    public void X0(PdfObject pdfObject) {
        if (pdfObject != null) {
            if (!(pdfObject instanceof PdfIndirectReference) || pdfObject.C()) {
                int W = pdfObject.W();
                if (W == 5) {
                    PdfArray pdfArray = (PdfArray) pdfObject;
                    for (int i2 = 0; i2 < pdfArray.size(); i2++) {
                        X0(pdfArray.T0(i2));
                    }
                } else if (W == 6 || W == 7) {
                    PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
                    for (PdfName d0 : pdfDictionary.G0()) {
                        X0(pdfDictionary.d0(d0));
                    }
                } else if (W == 10) {
                    int d2 = ((PRIndirectReference) pdfObject).d();
                    this.Y2.set(d2, (Object) null);
                    this.h3 = d2;
                    X0(this.Y2.get(d2));
                }
            }
        }
    }

    public HashMap<String, PdfObject> Y() {
        return new HashMap<>(Z(false));
    }

    public void Y0() {
        if (!this.w3) {
            this.w3 = true;
            HashMap<Object, PdfObject> X3 = X(true);
            if (!X3.isEmpty()) {
                for (int i2 = 1; i2 <= this.c3.q(); i2++) {
                    PdfObject d0 = this.c3.b(i2).d0(PdfName.Q3);
                    PdfArray pdfArray = (PdfArray) t0(d0);
                    int i4 = this.D3;
                    p1();
                    if (pdfArray != null) {
                        boolean z = false;
                        for (int i5 = 0; i5 < pdfArray.size(); i5++) {
                            PdfObject T0 = pdfArray.T0(i5);
                            if (o(T0, X3) && !T0.C()) {
                                z = true;
                            }
                        }
                        if (z) {
                            J1(i4, pdfArray);
                        }
                        if (z && !d0.C()) {
                        }
                    }
                    this.c3.n(i2);
                }
            }
        }
    }

    /*  JADX ERROR: IF instruction can be used only in fallback mode
        jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
        	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:579)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:485)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:232)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.util.ArrayList.forEach(ArrayList.java:1259)
        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        */
    public java.util.HashMap<java.lang.Object, com.itextpdf.text.pdf.PdfObject> Z(boolean r6) {
        /*
            r5 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            com.itextpdf.text.pdf.PdfDictionary r1 = r5.b3
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.z6
            com.itextpdf.text.pdf.PdfObject r1 = r1.d0(r2)
            if (r1 == 0) goto L_0x004c
            com.itextpdf.text.pdf.PdfDictionary r1 = r5.b3
            com.itextpdf.text.pdf.PdfObject r1 = r1.d0(r2)
            com.itextpdf.text.pdf.PdfObject r1 = w0(r1)
            com.itextpdf.text.pdf.PdfDictionary r1 = (com.itextpdf.text.pdf.PdfDictionary) r1
            if (r1 != 0) goto L_0x001e
            return r0
        L_0x001e:
            java.util.Set r2 = r1.G0()
            java.util.Iterator r2 = r2.iterator()
        L_0x0026:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x004c
            java.lang.Object r3 = r2.next()
            com.itextpdf.text.pdf.PdfName r3 = (com.itextpdf.text.pdf.PdfName) r3
            com.itextpdf.text.pdf.PdfObject r4 = r1.d0(r3)
            com.itextpdf.text.pdf.PdfArray r4 = V(r4)
            if (r4 != 0) goto L_0x003d
            goto L_0x0026
        L_0x003d:
            if (r6 == 0) goto L_0x0043
        L_0x003f:
            r0.put(r3, r4)
            goto L_0x0026
        L_0x0043:
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = com.itextpdf.text.pdf.PdfName.a0(r3)
            goto L_0x003f
        L_0x004c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfReader.Z(boolean):java.util.HashMap");
    }

    /* access modifiers changed from: protected */
    public PdfArray Z0() throws IOException {
        PdfArray pdfArray = new PdfArray();
        while (true) {
            PdfObject g1 = g1();
            int i2 = -g1.W();
            if (i2 == PRTokeniser.TokenType.END_ARRAY.ordinal()) {
                return pdfArray;
            }
            if (i2 == PRTokeniser.TokenType.END_DIC.ordinal()) {
                this.s.E(MessageLocalization.b("unexpected.gt.gt", new Object[0]));
            }
            pdfArray.a0(g1);
        }
    }

    public void a(int i2) {
        this.G3.a(i2);
        I1(this.G3);
    }

    public HashMap<String, PdfObject> a0() {
        PdfDictionary pdfDictionary;
        PdfDictionary pdfDictionary2;
        PdfDictionary pdfDictionary3 = this.b3;
        PdfName pdfName = PdfName.sb;
        if (pdfDictionary3.d0(pdfName) == null || (pdfDictionary = (PdfDictionary) w0(this.b3.d0(pdfName))) == null || (pdfDictionary2 = (PdfDictionary) w0(pdfDictionary.d0(PdfName.z6))) == null) {
            return new HashMap<>();
        }
        HashMap<String, PdfObject> b2 = PdfNameTree.b(pdfDictionary2);
        Iterator<Map.Entry<String, PdfObject>> it2 = b2.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry next = it2.next();
            PdfArray V = V((PdfObject) next.getValue());
            if (V != null) {
                next.setValue(V);
            } else {
                it2.remove();
            }
        }
        return b2;
    }

    /* access modifiers changed from: protected */
    public PdfDictionary b1() throws IOException {
        PdfDictionary pdfDictionary = new PdfDictionary();
        while (true) {
            this.s.y();
            PRTokeniser.TokenType o = this.s.o();
            PRTokeniser.TokenType tokenType = PRTokeniser.TokenType.END_DIC;
            if (o == tokenType) {
                return pdfDictionary;
            }
            if (this.s.o() != PRTokeniser.TokenType.NAME) {
                PRTokeniser pRTokeniser = this.s;
                pRTokeniser.E(MessageLocalization.b("dictionary.key.1.is.not.a.name", pRTokeniser.n()));
            }
            PdfName pdfName = new PdfName(this.s.n(), false);
            PdfObject g1 = g1();
            int i2 = -g1.W();
            if (i2 == tokenType.ordinal()) {
                this.s.E(MessageLocalization.b("unexpected.gt.gt", new Object[0]));
            }
            if (i2 == PRTokeniser.TokenType.END_ARRAY.ordinal()) {
                this.s.E(MessageLocalization.b("unexpected.close.bracket", new Object[0]));
            }
            pdfDictionary.V0(pdfName, g1);
        }
    }

    public int c0() {
        return this.c3.q();
    }

    /* access modifiers changed from: protected */
    public void c1() throws IOException {
        PdfObject pdfObject;
        ArrayList arrayList = new ArrayList();
        int i2 = 2;
        ArrayList<PdfObject> arrayList2 = new ArrayList<>(this.X.length / 2);
        this.Y2 = arrayList2;
        arrayList2.addAll(Collections.nCopies(this.X.length / 2, (Object) null));
        while (true) {
            long[] jArr = this.X;
            if (i2 < jArr.length) {
                long j2 = jArr[i2];
                if (j2 > 0 && jArr[i2 + 1] <= 0) {
                    this.s.D(j2);
                    this.s.y();
                    PRTokeniser.TokenType o = this.s.o();
                    PRTokeniser.TokenType tokenType = PRTokeniser.TokenType.NUMBER;
                    if (o != tokenType) {
                        this.s.E(MessageLocalization.b("invalid.object.number", new Object[0]));
                    }
                    this.z3 = this.s.p();
                    this.s.y();
                    if (this.s.o() != tokenType) {
                        this.s.E(MessageLocalization.b("invalid.generation.number", new Object[0]));
                    }
                    this.A3 = this.s.p();
                    this.s.y();
                    if (!this.s.n().equals("obj")) {
                        this.s.E(MessageLocalization.b("token.obj.expected", new Object[0]));
                    }
                    try {
                        pdfObject = g1();
                        if (pdfObject.K()) {
                            arrayList.add((PRStream) pdfObject);
                        }
                    } catch (IOException e2) {
                        if (L3) {
                            Logger logger = M3;
                            if (logger.b(Level.ERROR)) {
                                logger.i(e2.getMessage(), e2);
                            }
                            pdfObject = null;
                        } else {
                            throw e2;
                        }
                    }
                    this.Y2.set(i2 / 2, pdfObject);
                }
                i2 += 2;
            } else {
                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                    k((PRStream) arrayList.get(i4));
                }
                a1();
                HashMap<Integer, IntHashtable> hashMap = this.Y;
                if (hashMap != null) {
                    for (Map.Entry next : hashMap.entrySet()) {
                        int intValue = ((Integer) next.getKey()).intValue();
                        e1((PRStream) this.Y2.get(intValue), (IntHashtable) next.getValue());
                        this.Y2.set(intValue, (Object) null);
                    }
                    this.Y = null;
                }
                this.X = null;
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void d1() throws IOException {
        ArrayList<PdfObject> arrayList = new ArrayList<>(this.X.length / 2);
        this.Y2 = arrayList;
        arrayList.addAll(Collections.nCopies(this.X.length / 2, (Object) null));
        a1();
        LongHashtable longHashtable = this.Z;
        if (longHashtable != null) {
            long[] g2 = longHashtable.g();
            for (long j2 : g2) {
                int i2 = (int) (2 * j2);
                this.Z.l(j2, this.X[i2]);
                this.X[i2] = -1;
            }
        }
    }

    public byte[] e0(int i2) throws IOException {
        RandomAccessFileOrArray B0 = B0();
        try {
            B0.g();
            return f0(i2, B0);
        } finally {
            try {
                B0.close();
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0054, code lost:
        r4 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e1(com.itextpdf.text.pdf.PRStream r10, com.itextpdf.text.pdf.IntHashtable r11) throws java.io.IOException {
        /*
            r9 = this;
            if (r10 != 0) goto L_0x0003
            return
        L_0x0003:
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.U7
            com.itextpdf.text.pdf.PdfNumber r0 = r10.q0(r0)
            int r0 = r0.e0()
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.kb
            com.itextpdf.text.pdf.PdfNumber r1 = r10.q0(r1)
            int r1 = r1.e0()
            com.itextpdf.text.pdf.PRTokeniser r2 = r9.s
            com.itextpdf.text.pdf.RandomAccessFileOrArray r2 = r2.f()
            byte[] r10 = E0(r10, r2)
            com.itextpdf.text.pdf.PRTokeniser r2 = r9.s
            com.itextpdf.text.pdf.PRTokeniser r3 = new com.itextpdf.text.pdf.PRTokeniser
            com.itextpdf.text.pdf.RandomAccessFileOrArray r4 = new com.itextpdf.text.pdf.RandomAccessFileOrArray
            com.itextpdf.text.io.RandomAccessSourceFactory r5 = new com.itextpdf.text.io.RandomAccessSourceFactory
            r5.<init>()
            com.itextpdf.text.io.RandomAccessSource r10 = r5.j(r10)
            r4.<init>((com.itextpdf.text.io.RandomAccessSource) r10)
            r3.<init>(r4)
            r9.s = r3
            int[] r10 = new int[r1]     // Catch:{ all -> 0x007c }
            int[] r3 = new int[r1]     // Catch:{ all -> 0x007c }
            r4 = 1
            r5 = 0
            r6 = 0
        L_0x003f:
            if (r6 >= r1) goto L_0x007e
            com.itextpdf.text.pdf.PRTokeniser r4 = r9.s     // Catch:{ all -> 0x007c }
            boolean r4 = r4.x()     // Catch:{ all -> 0x007c }
            if (r4 != 0) goto L_0x004a
            goto L_0x007e
        L_0x004a:
            com.itextpdf.text.pdf.PRTokeniser r4 = r9.s     // Catch:{ all -> 0x007c }
            com.itextpdf.text.pdf.PRTokeniser$TokenType r4 = r4.o()     // Catch:{ all -> 0x007c }
            com.itextpdf.text.pdf.PRTokeniser$TokenType r7 = com.itextpdf.text.pdf.PRTokeniser.TokenType.NUMBER     // Catch:{ all -> 0x007c }
            if (r4 == r7) goto L_0x0056
        L_0x0054:
            r4 = 0
            goto L_0x007e
        L_0x0056:
            com.itextpdf.text.pdf.PRTokeniser r4 = r9.s     // Catch:{ all -> 0x007c }
            int r4 = r4.p()     // Catch:{ all -> 0x007c }
            r3[r6] = r4     // Catch:{ all -> 0x007c }
            com.itextpdf.text.pdf.PRTokeniser r4 = r9.s     // Catch:{ all -> 0x007c }
            boolean r4 = r4.x()     // Catch:{ all -> 0x007c }
            if (r4 != 0) goto L_0x0067
            goto L_0x007e
        L_0x0067:
            com.itextpdf.text.pdf.PRTokeniser r8 = r9.s     // Catch:{ all -> 0x007c }
            com.itextpdf.text.pdf.PRTokeniser$TokenType r8 = r8.o()     // Catch:{ all -> 0x007c }
            if (r8 == r7) goto L_0x0070
            goto L_0x0054
        L_0x0070:
            com.itextpdf.text.pdf.PRTokeniser r7 = r9.s     // Catch:{ all -> 0x007c }
            int r7 = r7.p()     // Catch:{ all -> 0x007c }
            int r7 = r7 + r0
            r10[r6] = r7     // Catch:{ all -> 0x007c }
            int r6 = r6 + 1
            goto L_0x003f
        L_0x007c:
            r10 = move-exception
            goto L_0x00d2
        L_0x007e:
            if (r4 == 0) goto L_0x00c4
        L_0x0080:
            if (r5 >= r1) goto L_0x00c1
            boolean r0 = r11.c(r5)     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x00be
            com.itextpdf.text.pdf.PRTokeniser r0 = r9.s     // Catch:{ all -> 0x007c }
            r4 = r10[r5]     // Catch:{ all -> 0x007c }
            long r6 = (long) r4     // Catch:{ all -> 0x007c }
            r0.D(r6)     // Catch:{ all -> 0x007c }
            com.itextpdf.text.pdf.PRTokeniser r0 = r9.s     // Catch:{ all -> 0x007c }
            r0.x()     // Catch:{ all -> 0x007c }
            com.itextpdf.text.pdf.PRTokeniser r0 = r9.s     // Catch:{ all -> 0x007c }
            com.itextpdf.text.pdf.PRTokeniser$TokenType r0 = r0.o()     // Catch:{ all -> 0x007c }
            com.itextpdf.text.pdf.PRTokeniser$TokenType r4 = com.itextpdf.text.pdf.PRTokeniser.TokenType.NUMBER     // Catch:{ all -> 0x007c }
            if (r0 != r4) goto L_0x00ab
            com.itextpdf.text.pdf.PdfNumber r0 = new com.itextpdf.text.pdf.PdfNumber     // Catch:{ all -> 0x007c }
            com.itextpdf.text.pdf.PRTokeniser r4 = r9.s     // Catch:{ all -> 0x007c }
            java.lang.String r4 = r4.n()     // Catch:{ all -> 0x007c }
            r0.<init>((java.lang.String) r4)     // Catch:{ all -> 0x007c }
            goto L_0x00b7
        L_0x00ab:
            com.itextpdf.text.pdf.PRTokeniser r0 = r9.s     // Catch:{ all -> 0x007c }
            r4 = r10[r5]     // Catch:{ all -> 0x007c }
            long r6 = (long) r4     // Catch:{ all -> 0x007c }
            r0.D(r6)     // Catch:{ all -> 0x007c }
            com.itextpdf.text.pdf.PdfObject r0 = r9.g1()     // Catch:{ all -> 0x007c }
        L_0x00b7:
            java.util.ArrayList<com.itextpdf.text.pdf.PdfObject> r4 = r9.Y2     // Catch:{ all -> 0x007c }
            r6 = r3[r5]     // Catch:{ all -> 0x007c }
            r4.set(r6, r0)     // Catch:{ all -> 0x007c }
        L_0x00be:
            int r5 = r5 + 1
            goto L_0x0080
        L_0x00c1:
            r9.s = r2
            return
        L_0x00c4:
            com.itextpdf.text.exceptions.InvalidPdfException r10 = new com.itextpdf.text.exceptions.InvalidPdfException     // Catch:{ all -> 0x007c }
            java.lang.String r11 = "error.reading.objstm"
            java.lang.Object[] r0 = new java.lang.Object[r5]     // Catch:{ all -> 0x007c }
            java.lang.String r11 = com.itextpdf.text.error_messages.MessageLocalization.b(r11, r0)     // Catch:{ all -> 0x007c }
            r10.<init>(r11)     // Catch:{ all -> 0x007c }
            throw r10     // Catch:{ all -> 0x007c }
        L_0x00d2:
            r9.s = r2
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfReader.e1(com.itextpdf.text.pdf.PRStream, com.itextpdf.text.pdf.IntHashtable):void");
    }

    public byte[] f0(int i2, RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        PdfDictionary i0 = i0(i2);
        if (i0 == null) {
            return null;
        }
        PdfObject w0 = w0(i0.d0(PdfName.N5));
        if (w0 == null) {
            return new byte[0];
        }
        if (w0.K()) {
            return E0((PRStream) w0, randomAccessFileOrArray);
        }
        if (!w0.q()) {
            return new byte[0];
        }
        PdfArray pdfArray = (PdfArray) w0;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i4 = 0; i4 < pdfArray.size(); i4++) {
            PdfObject w02 = w0(pdfArray.T0(i4));
            if (w02 != null && w02.K()) {
                byteArrayOutputStream.write(E0((PRStream) w02, randomAccessFileOrArray));
                if (i4 != pdfArray.size() - 1) {
                    byteArrayOutputStream.write(10);
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0045, code lost:
        r8 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.pdf.PdfObject f1(com.itextpdf.text.pdf.PRStream r8, int r9) throws java.io.IOException {
        /*
            r7 = this;
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.U7
            com.itextpdf.text.pdf.PdfNumber r0 = r8.q0(r0)
            int r0 = r0.e0()
            com.itextpdf.text.pdf.PRTokeniser r1 = r7.s
            com.itextpdf.text.pdf.RandomAccessFileOrArray r1 = r1.f()
            byte[] r8 = E0(r8, r1)
            com.itextpdf.text.pdf.PRTokeniser r1 = r7.s
            com.itextpdf.text.pdf.PRTokeniser r2 = new com.itextpdf.text.pdf.PRTokeniser
            com.itextpdf.text.pdf.RandomAccessFileOrArray r3 = new com.itextpdf.text.pdf.RandomAccessFileOrArray
            com.itextpdf.text.io.RandomAccessSourceFactory r4 = new com.itextpdf.text.io.RandomAccessSourceFactory
            r4.<init>()
            com.itextpdf.text.io.RandomAccessSource r8 = r4.j(r8)
            r3.<init>((com.itextpdf.text.io.RandomAccessSource) r8)
            r2.<init>(r3)
            r7.s = r2
            r8 = 1
            int r9 = r9 + r8
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x0030:
            if (r3 >= r9) goto L_0x0065
            com.itextpdf.text.pdf.PRTokeniser r8 = r7.s     // Catch:{ all -> 0x0063 }
            boolean r8 = r8.x()     // Catch:{ all -> 0x0063 }
            if (r8 != 0) goto L_0x003b
            goto L_0x0065
        L_0x003b:
            com.itextpdf.text.pdf.PRTokeniser r8 = r7.s     // Catch:{ all -> 0x0063 }
            com.itextpdf.text.pdf.PRTokeniser$TokenType r8 = r8.o()     // Catch:{ all -> 0x0063 }
            com.itextpdf.text.pdf.PRTokeniser$TokenType r5 = com.itextpdf.text.pdf.PRTokeniser.TokenType.NUMBER     // Catch:{ all -> 0x0063 }
            if (r8 == r5) goto L_0x0047
        L_0x0045:
            r8 = 0
            goto L_0x0065
        L_0x0047:
            com.itextpdf.text.pdf.PRTokeniser r8 = r7.s     // Catch:{ all -> 0x0063 }
            boolean r8 = r8.x()     // Catch:{ all -> 0x0063 }
            if (r8 != 0) goto L_0x0050
            goto L_0x0065
        L_0x0050:
            com.itextpdf.text.pdf.PRTokeniser r6 = r7.s     // Catch:{ all -> 0x0063 }
            com.itextpdf.text.pdf.PRTokeniser$TokenType r6 = r6.o()     // Catch:{ all -> 0x0063 }
            if (r6 == r5) goto L_0x0059
            goto L_0x0045
        L_0x0059:
            com.itextpdf.text.pdf.PRTokeniser r4 = r7.s     // Catch:{ all -> 0x0063 }
            int r4 = r4.p()     // Catch:{ all -> 0x0063 }
            int r4 = r4 + r0
            int r3 = r3 + 1
            goto L_0x0030
        L_0x0063:
            r8 = move-exception
            goto L_0x00a2
        L_0x0065:
            if (r8 == 0) goto L_0x0094
            com.itextpdf.text.pdf.PRTokeniser r8 = r7.s     // Catch:{ all -> 0x0063 }
            long r2 = (long) r4     // Catch:{ all -> 0x0063 }
            r8.D(r2)     // Catch:{ all -> 0x0063 }
            com.itextpdf.text.pdf.PRTokeniser r8 = r7.s     // Catch:{ all -> 0x0063 }
            r8.x()     // Catch:{ all -> 0x0063 }
            com.itextpdf.text.pdf.PRTokeniser r8 = r7.s     // Catch:{ all -> 0x0063 }
            com.itextpdf.text.pdf.PRTokeniser$TokenType r8 = r8.o()     // Catch:{ all -> 0x0063 }
            com.itextpdf.text.pdf.PRTokeniser$TokenType r9 = com.itextpdf.text.pdf.PRTokeniser.TokenType.NUMBER     // Catch:{ all -> 0x0063 }
            if (r8 != r9) goto L_0x0088
            com.itextpdf.text.pdf.PdfNumber r8 = new com.itextpdf.text.pdf.PdfNumber     // Catch:{ all -> 0x0063 }
            com.itextpdf.text.pdf.PRTokeniser r9 = r7.s     // Catch:{ all -> 0x0063 }
            java.lang.String r9 = r9.n()     // Catch:{ all -> 0x0063 }
            r8.<init>((java.lang.String) r9)     // Catch:{ all -> 0x0063 }
            goto L_0x0091
        L_0x0088:
            com.itextpdf.text.pdf.PRTokeniser r8 = r7.s     // Catch:{ all -> 0x0063 }
            r8.D(r2)     // Catch:{ all -> 0x0063 }
            com.itextpdf.text.pdf.PdfObject r8 = r7.g1()     // Catch:{ all -> 0x0063 }
        L_0x0091:
            r7.s = r1
            return r8
        L_0x0094:
            com.itextpdf.text.exceptions.InvalidPdfException r8 = new com.itextpdf.text.exceptions.InvalidPdfException     // Catch:{ all -> 0x0063 }
            java.lang.String r9 = "error.reading.objstm"
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ all -> 0x0063 }
            java.lang.String r9 = com.itextpdf.text.error_messages.MessageLocalization.b(r9, r0)     // Catch:{ all -> 0x0063 }
            r8.<init>(r9)     // Catch:{ all -> 0x0063 }
            throw r8     // Catch:{ all -> 0x0063 }
        L_0x00a2:
            r7.s = r1
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfReader.f1(com.itextpdf.text.pdf.PRStream, int):com.itextpdf.text.pdf.PdfObject");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0125 A[LOOP:1: B:54:0x0125->B:72:0x0125, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0160  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.pdf.PdfObject g1() throws java.io.IOException {
        /*
            r6 = this;
            com.itextpdf.text.pdf.PRTokeniser r0 = r6.s
            r0.y()
            com.itextpdf.text.pdf.PRTokeniser r0 = r6.s
            com.itextpdf.text.pdf.PRTokeniser$TokenType r0 = r0.o()
            int[] r1 = com.itextpdf.text.pdf.PdfReader.AnonymousClass1.f26285a
            int r2 = r0.ordinal()
            r1 = r1[r2]
            r2 = 0
            r3 = 1
            switch(r1) {
                case 1: goto L_0x00ef;
                case 2: goto L_0x00e0;
                case 3: goto L_0x00d4;
                case 4: goto L_0x00af;
                case 5: goto L_0x008e;
                case 6: goto L_0x007c;
                case 7: goto L_0x006e;
                default: goto L_0x0018;
            }
        L_0x0018:
            com.itextpdf.text.pdf.PRTokeniser r1 = r6.s
            java.lang.String r1 = r1.n()
            java.lang.String r4 = "null"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x0033
            int r0 = r6.J3
            if (r0 != 0) goto L_0x0030
            com.itextpdf.text.pdf.PdfNull r0 = new com.itextpdf.text.pdf.PdfNull
            r0.<init>()
            return r0
        L_0x0030:
            com.itextpdf.text.pdf.PdfNull r0 = com.itextpdf.text.pdf.PdfNull.i3
            return r0
        L_0x0033:
            java.lang.String r4 = "true"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L_0x0048
            int r0 = r6.J3
            if (r0 != 0) goto L_0x0045
            com.itextpdf.text.pdf.PdfBoolean r0 = new com.itextpdf.text.pdf.PdfBoolean
            r0.<init>((boolean) r3)
            return r0
        L_0x0045:
            com.itextpdf.text.pdf.PdfBoolean r0 = com.itextpdf.text.pdf.PdfBoolean.j3
            return r0
        L_0x0048:
            java.lang.String r3 = "false"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x005d
            int r0 = r6.J3
            if (r0 != 0) goto L_0x005a
            com.itextpdf.text.pdf.PdfBoolean r0 = new com.itextpdf.text.pdf.PdfBoolean
            r0.<init>((boolean) r2)
            return r0
        L_0x005a:
            com.itextpdf.text.pdf.PdfBoolean r0 = com.itextpdf.text.pdf.PdfBoolean.k3
            return r0
        L_0x005d:
            com.itextpdf.text.pdf.PdfLiteral r1 = new com.itextpdf.text.pdf.PdfLiteral
            int r0 = r0.ordinal()
            int r0 = -r0
            com.itextpdf.text.pdf.PRTokeniser r2 = r6.s
            java.lang.String r2 = r2.n()
            r1.<init>((int) r0, (java.lang.String) r2)
            return r1
        L_0x006e:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "unexpected.end.of.file"
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.b(r1, r2)
            r0.<init>(r1)
            throw r0
        L_0x007c:
            com.itextpdf.text.pdf.PRTokeniser r0 = r6.s
            int r0 = r0.k()
            com.itextpdf.text.pdf.PRIndirectReference r1 = new com.itextpdf.text.pdf.PRIndirectReference
            com.itextpdf.text.pdf.PRTokeniser r2 = r6.s
            int r2 = r2.h()
            r1.<init>(r6, r0, r2)
            return r1
        L_0x008e:
            java.util.Map<java.lang.String, com.itextpdf.text.pdf.PdfName> r0 = com.itextpdf.text.pdf.PdfName.ki
            com.itextpdf.text.pdf.PRTokeniser r1 = r6.s
            java.lang.String r1 = r1.n()
            java.lang.Object r0 = r0.get(r1)
            com.itextpdf.text.pdf.PdfName r0 = (com.itextpdf.text.pdf.PdfName) r0
            int r1 = r6.J3
            if (r1 <= 0) goto L_0x00a3
            if (r0 == 0) goto L_0x00a3
            return r0
        L_0x00a3:
            com.itextpdf.text.pdf.PdfName r0 = new com.itextpdf.text.pdf.PdfName
            com.itextpdf.text.pdf.PRTokeniser r1 = r6.s
            java.lang.String r1 = r1.n()
            r0.<init>(r1, r2)
            return r0
        L_0x00af:
            com.itextpdf.text.pdf.PdfString r0 = new com.itextpdf.text.pdf.PdfString
            com.itextpdf.text.pdf.PRTokeniser r1 = r6.s
            java.lang.String r1 = r1.n()
            r2 = 0
            r0.<init>(r1, r2)
            com.itextpdf.text.pdf.PRTokeniser r1 = r6.s
            boolean r1 = r1.s()
            com.itextpdf.text.pdf.PdfString r0 = r0.i0(r1)
            int r1 = r6.z3
            int r2 = r6.A3
            r0.j0(r1, r2)
            java.util.ArrayList<com.itextpdf.text.pdf.PdfString> r1 = r6.t3
            if (r1 == 0) goto L_0x00d3
            r1.add(r0)
        L_0x00d3:
            return r0
        L_0x00d4:
            com.itextpdf.text.pdf.PdfNumber r0 = new com.itextpdf.text.pdf.PdfNumber
            com.itextpdf.text.pdf.PRTokeniser r1 = r6.s
            java.lang.String r1 = r1.n()
            r0.<init>((java.lang.String) r1)
            return r0
        L_0x00e0:
            int r0 = r6.J3
            int r0 = r0 + r3
            r6.J3 = r0
            com.itextpdf.text.pdf.PdfArray r0 = r6.Z0()
            int r1 = r6.J3
            int r1 = r1 - r3
            r6.J3 = r1
            return r0
        L_0x00ef:
            int r0 = r6.J3
            int r0 = r0 + r3
            r6.J3 = r0
            com.itextpdf.text.pdf.PdfDictionary r0 = r6.b1()
            int r1 = r6.J3
            int r1 = r1 - r3
            r6.J3 = r1
            com.itextpdf.text.pdf.PRTokeniser r1 = r6.s
            long r1 = r1.g()
        L_0x0103:
            com.itextpdf.text.pdf.PRTokeniser r3 = r6.s
            boolean r3 = r3.x()
            if (r3 == 0) goto L_0x0115
            com.itextpdf.text.pdf.PRTokeniser r4 = r6.s
            com.itextpdf.text.pdf.PRTokeniser$TokenType r4 = r4.o()
            com.itextpdf.text.pdf.PRTokeniser$TokenType r5 = com.itextpdf.text.pdf.PRTokeniser.TokenType.COMMENT
            if (r4 == r5) goto L_0x0103
        L_0x0115:
            if (r3 == 0) goto L_0x0160
            com.itextpdf.text.pdf.PRTokeniser r3 = r6.s
            java.lang.String r3 = r3.n()
            java.lang.String r4 = "stream"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0160
        L_0x0125:
            com.itextpdf.text.pdf.PRTokeniser r1 = r6.s
            int r1 = r1.z()
            r2 = 32
            if (r1 == r2) goto L_0x0125
            r2 = 9
            if (r1 == r2) goto L_0x0125
            if (r1 == 0) goto L_0x0125
            r2 = 12
            if (r1 == r2) goto L_0x0125
            r2 = 10
            if (r1 == r2) goto L_0x0143
            com.itextpdf.text.pdf.PRTokeniser r1 = r6.s
            int r1 = r1.z()
        L_0x0143:
            if (r1 == r2) goto L_0x014a
            com.itextpdf.text.pdf.PRTokeniser r2 = r6.s
            r2.a(r1)
        L_0x014a:
            com.itextpdf.text.pdf.PRStream r1 = new com.itextpdf.text.pdf.PRStream
            com.itextpdf.text.pdf.PRTokeniser r2 = r6.s
            long r2 = r2.g()
            r1.<init>((com.itextpdf.text.pdf.PdfReader) r6, (long) r2)
            r1.X0(r0)
            int r0 = r6.z3
            int r2 = r6.A3
            r1.K1(r0, r2)
            return r1
        L_0x0160:
            com.itextpdf.text.pdf.PRTokeniser r3 = r6.s
            r3.D(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfReader.g1():com.itextpdf.text.pdf.PdfObject");
    }

    public PdfDictionary h0(int i2) {
        PdfDictionary b2 = this.c3.b(i2);
        if (b2 == null) {
            return null;
        }
        if (this.I3) {
            b2.R(this.c3.d(i2));
        }
        return b2;
    }

    /* access modifiers changed from: protected */
    public void h1() throws IOException {
        PdfDictionary j0 = this.a3.j0(PdfName.se);
        this.b3 = j0;
        if (j0 != null) {
            PdfName pdfName = PdfName.zc;
            PdfDictionary j02 = j0.j0(pdfName);
            this.Z2 = j02;
            if (j02 == null || !pdfName.equals(j02.d0(PdfName.Kg))) {
                if (L3) {
                    Logger logger = M3;
                    if (logger.b(Level.ERROR)) {
                        logger.c(MessageLocalization.b("the.document.has.no.page.root", new Object[0]));
                    }
                } else {
                    throw new InvalidPdfException(MessageLocalization.b("the.document.has.no.page.root", new Object[0]));
                }
            }
            this.c3 = new PageRefs(this, (AnonymousClass1) null);
            return;
        }
        throw new InvalidPdfException(MessageLocalization.b("the.document.has.no.catalog.object", new Object[0]));
    }

    public PdfDictionary i0(int i2) {
        PdfDictionary h0 = h0(i2);
        this.c3.n(i2);
        return h0;
    }

    /* access modifiers changed from: protected */
    public void i1() throws IOException {
        this.B3 = this.s.f().e();
        this.l3 = this.s.d();
        try {
            m1();
        } catch (Exception e2) {
            try {
                this.g3 = true;
                o1();
                this.j3 = -1;
            } catch (Exception e4) {
                throw new InvalidPdfException(MessageLocalization.b("rebuild.failed.1.original.message.2", e4.getMessage(), e2.getMessage()));
            }
        }
        try {
            c1();
        } catch (Exception e5) {
            if (e5 instanceof BadPasswordException) {
                throw new BadPasswordException(e5.getMessage());
            } else if (this.g3 || this.H3) {
                throw new InvalidPdfException(e5.getMessage());
            } else {
                this.g3 = true;
                this.f3 = false;
                try {
                    o1();
                    this.j3 = -1;
                    c1();
                } catch (Exception e6) {
                    throw new InvalidPdfException(MessageLocalization.b("rebuild.failed.1.original.message.2", e6.getMessage(), e5.getMessage()));
                }
            }
        }
        this.t3.clear();
        h1();
        v1();
    }

    public PRIndirectReference j(PdfObject pdfObject) {
        this.Y2.add(pdfObject);
        return new PRIndirectReference(this, this.Y2.size() - 1);
    }

    public PRIndirectReference j0(int i2) {
        return this.c3.d(i2);
    }

    /* access modifiers changed from: protected */
    public void j1() throws IOException {
        this.B3 = this.s.f().e();
        this.l3 = this.s.d();
        try {
            m1();
        } catch (Exception e2) {
            try {
                this.g3 = true;
                o1();
                this.j3 = -1;
            } catch (Exception e4) {
                throw new InvalidPdfException(MessageLocalization.b("rebuild.failed.1.original.message.2", e4.getMessage(), e2.getMessage()), e4);
            }
        }
        d1();
        h1();
    }

    public PdfDictionary k0(int i2) {
        return l0(h0(i2));
    }

    /* access modifiers changed from: protected */
    public PdfObject k1(int i2) throws IOException {
        this.t3.clear();
        int i4 = i2 * 2;
        long[] jArr = this.X;
        long j2 = jArr[i4];
        PdfObject pdfObject = null;
        if (j2 < 0) {
            return null;
        }
        int i5 = i4 + 1;
        long j4 = jArr[i5];
        if (j4 > 0) {
            j2 = this.Z.e(j4);
        }
        if (j2 == 0) {
            return null;
        }
        this.s.D(j2);
        this.s.y();
        PRTokeniser.TokenType o = this.s.o();
        PRTokeniser.TokenType tokenType = PRTokeniser.TokenType.NUMBER;
        if (o != tokenType) {
            this.s.E(MessageLocalization.b("invalid.object.number", new Object[0]));
        }
        this.z3 = this.s.p();
        this.s.y();
        if (this.s.o() != tokenType) {
            this.s.E(MessageLocalization.b("invalid.generation.number", new Object[0]));
        }
        this.A3 = this.s.p();
        this.s.y();
        if (!this.s.n().equals("obj")) {
            this.s.E(MessageLocalization.b("token.obj.expected", new Object[0]));
        }
        try {
            PdfObject g1 = g1();
            for (int i6 = 0; i6 < this.t3.size(); i6++) {
                this.t3.get(i6).Z(this);
            }
            if (g1.K()) {
                k((PRStream) g1);
            }
            pdfObject = g1;
        } catch (IOException e2) {
            if (L3) {
                Logger logger = M3;
                if (logger.b(Level.ERROR)) {
                    logger.i(e2.getMessage(), e2);
                }
            } else {
                throw e2;
            }
        }
        long[] jArr2 = this.X;
        if (jArr2[i5] > 0) {
            pdfObject = f1((PRStream) pdfObject, (int) jArr2[i4]);
        }
        this.Y2.set(i2, pdfObject);
        return pdfObject;
    }

    public void l() {
        try {
            this.s.e();
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public PdfDictionary l0(PdfDictionary pdfDictionary) {
        return pdfDictionary.j0(PdfName.Wd);
    }

    /* access modifiers changed from: protected */
    public boolean l1(long j2) throws IOException {
        PRTokeniser.TokenType tokenType;
        PdfArray pdfArray;
        long j4;
        int i2;
        PdfArray pdfArray2;
        int i4;
        this.s.D(j2);
        char c2 = 0;
        if (!this.s.x() || this.s.o() != (tokenType = PRTokeniser.TokenType.NUMBER)) {
            return false;
        }
        int p = this.s.p();
        if (!this.s.x() || this.s.o() != tokenType || !this.s.x() || !this.s.n().equals("obj")) {
            return false;
        }
        PdfObject g1 = g1();
        if (!g1.K()) {
            return false;
        }
        PRStream pRStream = (PRStream) g1;
        if (!PdfName.ci.equals(pRStream.d0(PdfName.Kg))) {
            return false;
        }
        if (this.a3 == null) {
            PdfDictionary pdfDictionary = new PdfDictionary();
            this.a3 = pdfDictionary;
            pdfDictionary.X0(pRStream);
        }
        pRStream.J1(((PdfNumber) pRStream.d0(PdfName.va)).e0());
        int e0 = ((PdfNumber) pRStream.d0(PdfName.Ve)).e0();
        PdfObject d0 = pRStream.d0(PdfName.M9);
        if (d0 == null) {
            pdfArray = new PdfArray();
            pdfArray.e0(new int[]{0, e0});
        } else {
            pdfArray = (PdfArray) d0;
        }
        PdfArray pdfArray3 = (PdfArray) pRStream.d0(PdfName.Dh);
        PdfObject d02 = pRStream.d0(PdfName.gd);
        long i0 = d02 != null ? ((PdfNumber) d02).i0() : -1;
        y(e0 * 2);
        if (this.Y == null && !this.E3) {
            this.Y = new HashMap<>();
        }
        if (this.Z == null && this.E3) {
            this.Z = new LongHashtable();
        }
        byte[] E0 = E0(pRStream, this.s.f());
        int[] iArr = new int[3];
        for (int i5 = 0; i5 < 3; i5++) {
            iArr[i5] = pdfArray3.J0(i5).e0();
        }
        int i6 = 0;
        int i7 = 0;
        while (true) {
            char c4 = 1;
            if (i6 >= pdfArray.size()) {
                break;
            }
            int e02 = pdfArray.J0(i6).e0();
            int e03 = pdfArray.J0(i6 + 1).e0();
            y((e02 + e03) * 2);
            while (true) {
                int i8 = e03 - 1;
                if (e03 <= 0) {
                    break;
                }
                if (iArr[c2] > 0) {
                    int i9 = 0;
                    i2 = 0;
                    while (i9 < iArr[c2]) {
                        i9++;
                        i2 = (E0[i7] & 255) + (i2 << 8);
                        i7++;
                    }
                } else {
                    i2 = 1;
                }
                byte[] bArr = E0;
                long j5 = 0;
                int i10 = 0;
                while (i10 < iArr[c4]) {
                    j5 = (j5 << 8) + ((long) (bArr[i7] & 255));
                    i10++;
                    i7++;
                    e02 = e02;
                    c4 = 1;
                }
                int i11 = e02;
                char c5 = 2;
                int i12 = 0;
                int i13 = 0;
                while (i12 < iArr[c5]) {
                    int i14 = i13 << 8;
                    int i15 = i7 + 1;
                    int i16 = (bArr[i7] & 255) + i14;
                    i12++;
                    c5 = 2;
                    int i17 = i15;
                    i13 = i16;
                    i7 = i17;
                }
                int i18 = i11 * 2;
                long[] jArr = this.X;
                if (jArr[i18] == 0) {
                    int i19 = i18 + 1;
                    if (jArr[i19] == 0) {
                        pdfArray2 = pdfArray;
                        if (i2 == 0) {
                            i4 = i7;
                            jArr[i18] = -1;
                        } else if (i2 != 1) {
                            if (i2 == 2) {
                                i4 = i7;
                                jArr[i18] = (long) i13;
                                jArr[i19] = j5;
                                if (this.E3) {
                                    this.Z.l(j5, 0);
                                } else {
                                    Integer valueOf = Integer.valueOf((int) j5);
                                    IntHashtable intHashtable = this.Y.get(valueOf);
                                    if (intHashtable == null) {
                                        IntHashtable intHashtable2 = new IntHashtable();
                                        intHashtable2.l(i13, 1);
                                        this.Y.put(valueOf, intHashtable2);
                                    } else {
                                        intHashtable.l(i13, 1);
                                    }
                                }
                            }
                            i4 = i7;
                        } else {
                            i4 = i7;
                            jArr[i18] = j5;
                        }
                        e02 = i11 + 1;
                        e03 = i8;
                        i7 = i4;
                        E0 = bArr;
                        pdfArray = pdfArray2;
                        c2 = 0;
                        c4 = 1;
                    }
                }
                pdfArray2 = pdfArray;
                i4 = i7;
                e02 = i11 + 1;
                e03 = i8;
                i7 = i4;
                E0 = bArr;
                pdfArray = pdfArray2;
                c2 = 0;
                c4 = 1;
            }
            byte[] bArr2 = E0;
            PdfArray pdfArray4 = pdfArray;
            i6 += 2;
            c2 = 0;
        }
        int i20 = p * 2;
        int i21 = i20 + 1;
        long[] jArr2 = this.X;
        if (i21 < jArr2.length && jArr2[i20] == 0 && jArr2[i21] == 0) {
            j4 = -1;
            jArr2[i20] = -1;
        } else {
            j4 = -1;
        }
        if (i0 == j4) {
            return true;
        }
        return l1(i0);
    }

    public byte[] m() {
        if (!this.f3 || !this.s3) {
            return null;
        }
        return this.m3.e(this.n3);
    }

    public int m0(int i2) {
        return n0(this.c3.c(i2));
    }

    /* access modifiers changed from: protected */
    public void m1() throws IOException {
        this.C3 = false;
        this.X2 = false;
        PRTokeniser pRTokeniser = this.s;
        pRTokeniser.D(pRTokeniser.m());
        this.s.x();
        if (this.s.n().equals("startxref")) {
            this.s.x();
            if (this.s.o() == PRTokeniser.TokenType.NUMBER) {
                long w = this.s.w();
                this.j3 = w;
                this.k3 = this.s.g();
                try {
                    if (l1(w)) {
                        this.X2 = true;
                        return;
                    }
                } catch (Exception unused) {
                }
                this.X = null;
                this.s.D(w);
                PdfDictionary n1 = n1();
                this.a3 = n1;
                while (true) {
                    PdfNumber pdfNumber = (PdfNumber) n1.d0(PdfName.gd);
                    if (pdfNumber != null) {
                        if (pdfNumber.i0() != w) {
                            w = pdfNumber.i0();
                            this.s.D(w);
                            n1 = n1();
                        } else {
                            throw new InvalidPdfException(MessageLocalization.b("trailer.prev.entry.points.to.its.own.cross.reference.section", new Object[0]));
                        }
                    } else {
                        return;
                    }
                }
            } else {
                throw new InvalidPdfException(MessageLocalization.b("startxref.is.not.followed.by.a.number", new Object[0]));
            }
        } else {
            throw new InvalidPdfException(MessageLocalization.b("startxref.not.found", new Object[0]));
        }
    }

    public void n() {
        if (!this.v3) {
            this.v3 = true;
            HashMap<Object, PdfObject> X3 = X(true);
            if (!X3.isEmpty()) {
                for (int i2 = 1; i2 <= this.c3.q(); i2++) {
                    PdfObject d0 = this.c3.b(i2).d0(PdfName.Q3);
                    PdfArray pdfArray = (PdfArray) t0(d0);
                    int i4 = this.D3;
                    p1();
                    if (pdfArray != null) {
                        boolean z = false;
                        for (int i5 = 0; i5 < pdfArray.size(); i5++) {
                            PdfObject T0 = pdfArray.T0(i5);
                            if (x1(T0, X3) && !T0.C()) {
                                z = true;
                            }
                        }
                        if (z) {
                            J1(i4, pdfArray);
                        }
                        if (z && !d0.C()) {
                        }
                    }
                    this.c3.n(i2);
                }
                PdfDictionary pdfDictionary = (PdfDictionary) w0(this.b3.d0(PdfName.nc));
                if (pdfDictionary != null) {
                    V0(pdfDictionary.d0(PdfName.U7), X3);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int n0(PdfDictionary pdfDictionary) {
        PdfNumber q0 = pdfDictionary.q0(PdfName.te);
        if (q0 == null) {
            return 0;
        }
        int e0 = q0.e0() % 360;
        return e0 < 0 ? e0 + 360 : e0;
    }

    /* access modifiers changed from: protected */
    public PdfDictionary n1() throws IOException {
        this.s.y();
        if (!this.s.n().equals("xref")) {
            this.s.E(MessageLocalization.b("xref.subsection.not.found", new Object[0]));
        }
        while (true) {
            this.s.y();
            if (this.s.n().equals("trailer")) {
                break;
            }
            PRTokeniser.TokenType o = this.s.o();
            PRTokeniser.TokenType tokenType = PRTokeniser.TokenType.NUMBER;
            if (o != tokenType) {
                this.s.E(MessageLocalization.b("object.number.of.the.first.object.in.this.xref.subsection.not.found", new Object[0]));
            }
            int p = this.s.p();
            this.s.y();
            if (this.s.o() != tokenType) {
                this.s.E(MessageLocalization.b("number.of.entries.in.this.xref.subsection.not.found", new Object[0]));
            }
            int p2 = this.s.p() + p;
            if (p == 1) {
                long g2 = this.s.g();
                this.s.y();
                long w = this.s.w();
                this.s.y();
                int p4 = this.s.p();
                if (w == 0 && p4 == 65535) {
                    p--;
                    p2--;
                }
                this.s.D(g2);
            }
            y(p2 * 2);
            while (p < p2) {
                this.s.y();
                long w2 = this.s.w();
                this.s.y();
                this.s.p();
                this.s.y();
                int i2 = p * 2;
                if (this.s.n().equals("n")) {
                    long[] jArr = this.X;
                    if (jArr[i2] == 0 && jArr[i2 + 1] == 0) {
                        jArr[i2] = w2;
                    }
                } else if (this.s.n().equals("f")) {
                    long[] jArr2 = this.X;
                    if (jArr2[i2] == 0 && jArr2[i2 + 1] == 0) {
                        jArr2[i2] = -1;
                    }
                } else {
                    this.s.E(MessageLocalization.b("invalid.cross.reference.entry.in.this.xref.subsection", new Object[0]));
                }
                p++;
            }
        }
        PdfDictionary pdfDictionary = (PdfDictionary) g1();
        y(((PdfNumber) pdfDictionary.d0(PdfName.Ve)).e0() * 2);
        PdfObject d0 = pdfDictionary.d0(PdfName.di);
        if (d0 != null && d0.I()) {
            try {
                l1((long) ((PdfNumber) d0).e0());
                this.X2 = true;
                this.C3 = true;
            } catch (IOException e2) {
                this.X = null;
                throw e2;
            }
        }
        return pdfDictionary;
    }

    public Rectangle o0(int i2) {
        return p0(this.c3.c(i2));
    }

    /* access modifiers changed from: protected */
    public void o1() throws IOException {
        int i2 = 0;
        this.C3 = false;
        this.X2 = false;
        long j2 = 0;
        this.s.D(0);
        long[][] jArr = new long[1024][];
        String str = null;
        this.a3 = null;
        byte[] bArr = new byte[64];
        while (true) {
            long g2 = this.s.g();
            if (!this.s.B(bArr, true)) {
                break;
            }
            byte b2 = bArr[i2];
            if (b2 == 116) {
                if (PdfEncodings.d(bArr, str).startsWith("trailer")) {
                    this.s.D(g2);
                    this.s.x();
                    long g4 = this.s.g();
                    try {
                        PdfDictionary pdfDictionary = (PdfDictionary) g1();
                        if (pdfDictionary.d0(PdfName.se) != null) {
                            this.a3 = pdfDictionary;
                        } else {
                            this.s.D(g4);
                        }
                    } catch (Exception unused) {
                        this.s.D(g4);
                    }
                }
            } else if (b2 >= 48 && b2 <= 57) {
                long[] c2 = PRTokeniser.c(bArr);
                if (c2 != null) {
                    long j4 = c2[i2];
                    long j5 = c2[1];
                    long[][] jArr2 = jArr;
                    if (j4 >= ((long) jArr.length)) {
                        long[][] jArr3 = new long[((int) (2 * j4))][];
                        System.arraycopy(jArr2, 0, jArr3, 0, (int) j2);
                        jArr = jArr3;
                    } else {
                        jArr = jArr2;
                    }
                    if (j4 >= j2) {
                        j2 = 1 + j4;
                    }
                    int i4 = (int) j4;
                    long[] jArr4 = jArr[i4];
                    if (jArr4 == null || j5 >= jArr4[1]) {
                        c2[0] = g2;
                        jArr[i4] = c2;
                        i2 = 0;
                        str = null;
                    } else {
                        i2 = 0;
                        str = null;
                    }
                }
            }
            jArr = jArr;
            i2 = 0;
            str = null;
        }
        if (this.a3 != null) {
            this.X = new long[((int) (2 * j2))];
            for (int i5 = 0; ((long) i5) < j2; i5++) {
                long[] jArr5 = jArr[i5];
                if (jArr5 != null) {
                    this.X[i5 * 2] = jArr5[i2];
                }
            }
            return;
        }
        throw new InvalidPdfException(MessageLocalization.b("trailer.not.found", new Object[i2]));
    }

    public int p() {
        String O;
        int i2 = 0;
        for (int i4 = 1; i4 < this.Y2.size(); i4++) {
            PdfObject v0 = v0(i4);
            if (v0 != null && v0.z()) {
                PdfDictionary pdfDictionary = (PdfDictionary) v0;
                if (B(pdfDictionary, PdfName.Kg, PdfName.l8)) {
                    PdfName pdfName = PdfName.Cf;
                    if ((B(pdfDictionary, pdfName, PdfName.Mg) || B(pdfDictionary, pdfName, PdfName.hb) || B(pdfDictionary, pdfName, PdfName.Ag)) && H0(pdfDictionary) == null && (O = O(pdfDictionary)) != null) {
                        String str = BaseFont.o() + O;
                        PdfName pdfName2 = PdfName.n8;
                        PdfDictionary pdfDictionary2 = (PdfDictionary) w0(pdfDictionary.d0(pdfName2));
                        if (!(pdfDictionary2 == null || (pdfDictionary2.d0(PdfName.p8) == null && pdfDictionary2.d0(PdfName.q8) == null && pdfDictionary2.d0(PdfName.r8) == null))) {
                            PdfDictionary j0 = pdfDictionary.j0(pdfName2);
                            PdfName pdfName3 = new PdfName(str);
                            pdfDictionary.V0(PdfName.l4, pdfName3);
                            j0.V0(PdfName.t8, pdfName3);
                            J1(i4, pdfDictionary);
                            i2++;
                        }
                    }
                }
            }
        }
        return i2;
    }

    public Rectangle p0(PdfDictionary pdfDictionary) {
        return b0(pdfDictionary.e0(PdfName.Za));
    }

    public void p1() {
        int i2;
        if (this.E3 && (i2 = this.D3) != -1) {
            this.Y2.set(i2, (Object) null);
            this.D3 = -1;
        }
    }

    public Rectangle q0(int i2) {
        return r0(this.c3.c(i2));
    }

    public Rectangle r0(PdfDictionary pdfDictionary) {
        Rectangle p0 = p0(pdfDictionary);
        for (int n0 = n0(pdfDictionary); n0 > 0; n0 -= 90) {
            p0 = p0.g0();
        }
        return p0;
    }

    public void r1(int i2) {
        this.c3.n(i2);
    }

    public PdfObject s0(int i2) {
        try {
            this.D3 = -1;
            if (i2 >= 0) {
                if (i2 < this.Y2.size()) {
                    PdfObject pdfObject = this.Y2.get(i2);
                    if (this.E3) {
                        if (pdfObject == null) {
                            if (i2 * 2 >= this.X.length) {
                                return null;
                            }
                            PdfObject k1 = k1(i2);
                            this.D3 = -1;
                            if (k1 != null) {
                                this.D3 = i2;
                            }
                            return k1;
                        }
                    }
                    return pdfObject;
                }
            }
            return null;
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public void s1() {
        this.c3.o();
        for (int i2 = 1; i2 <= this.c3.q(); i2++) {
            PdfDictionary b2 = this.c3.b(i2);
            PdfName pdfName = PdfName.Q3;
            if (b2.d0(pdfName) == null) {
                this.c3.n(i2);
            } else {
                b2.a1(pdfName);
            }
        }
        this.b3.a1(PdfName.p3);
        this.c3.o();
    }

    public double t() {
        int i2 = 0;
        for (int i4 = 0; i4 < this.Y2.size(); i4++) {
            if (this.Y2.get(i4) != null) {
                i2++;
            }
        }
        return (((double) i2) * 100.0d) / ((double) this.Y2.size());
    }

    public void t1() {
        this.c3.o();
        for (int i2 = 1; i2 <= this.c3.q(); i2++) {
            PdfDictionary b2 = this.c3.b(i2);
            PdfArray e0 = b2.e0(PdfName.Q3);
            if (e0 != null) {
                int i4 = 0;
                while (i4 < e0.size()) {
                    PdfObject w0 = w0(e0.T0(i4));
                    if (w0 != null && w0.z() && PdfName.Ih.equals(((PdfDictionary) w0).d0(PdfName.Cf))) {
                        e0.U0(i4);
                        i4--;
                    }
                    i4++;
                }
                if (e0.isEmpty()) {
                    b2.a1(PdfName.Q3);
                }
            }
            this.c3.n(i2);
        }
        this.b3.a1(PdfName.p3);
        this.c3.o();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.Object[]} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void u1(com.itextpdf.text.pdf.PdfObject r13, boolean[] r14) {
        /*
            r12 = this;
            r0 = 0
            r1 = 2
            r2 = 1
            java.util.Stack r3 = new java.util.Stack
            r3.<init>()
        L_0x0008:
            r3.push(r13)
        L_0x000b:
            boolean r13 = r3.empty()
            if (r13 != 0) goto L_0x012d
            java.lang.Object r13 = r3.pop()
            if (r13 != 0) goto L_0x0018
            goto L_0x000b
        L_0x0018:
            boolean r4 = r13 instanceof com.itextpdf.text.pdf.PdfObject
            r5 = 0
            if (r4 == 0) goto L_0x0060
            com.itextpdf.text.pdf.PdfObject r13 = (com.itextpdf.text.pdf.PdfObject) r13
            int r4 = r13.W()
            r6 = 5
            if (r4 == r6) goto L_0x0054
            r6 = 6
            if (r4 == r6) goto L_0x0042
            r6 = 7
            if (r4 == r6) goto L_0x0042
            r5 = 10
            if (r4 == r5) goto L_0x0031
            goto L_0x000b
        L_0x0031:
            com.itextpdf.text.pdf.PRIndirectReference r13 = (com.itextpdf.text.pdf.PRIndirectReference) r13
            int r4 = r13.d()
            boolean r5 = r14[r4]
            if (r5 != 0) goto L_0x000b
            r14[r4] = r2
            com.itextpdf.text.pdf.PdfObject r13 = w0(r13)
            goto L_0x0008
        L_0x0042:
            com.itextpdf.text.pdf.PdfDictionary r13 = (com.itextpdf.text.pdf.PdfDictionary) r13
            int r4 = r13.size()
            com.itextpdf.text.pdf.PdfName[] r4 = new com.itextpdf.text.pdf.PdfName[r4]
            java.util.Set r6 = r13.G0()
            r6.toArray(r4)
            r6 = r5
            r7 = 0
            goto L_0x0089
        L_0x0054:
            com.itextpdf.text.pdf.PdfArray r13 = (com.itextpdf.text.pdf.PdfArray) r13
            java.util.ArrayList r13 = r13.q0()
            r4 = r5
            r6 = r4
            r7 = 0
            r5 = r13
            r13 = r6
            goto L_0x0089
        L_0x0060:
            java.lang.Object[] r13 = (java.lang.Object[]) r13
            r4 = r13[r0]
            boolean r6 = r4 instanceof java.util.ArrayList
            if (r6 == 0) goto L_0x0078
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            r6 = r13[r2]
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r7 = r6
            r6 = r13
            r13 = r5
            r5 = r4
            r4 = r13
            goto L_0x0089
        L_0x0078:
            com.itextpdf.text.pdf.PdfName[] r4 = (com.itextpdf.text.pdf.PdfName[]) r4
            r6 = r13[r2]
            com.itextpdf.text.pdf.PdfDictionary r6 = (com.itextpdf.text.pdf.PdfDictionary) r6
            r7 = r13[r1]
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r11 = r6
            r6 = r13
            r13 = r11
        L_0x0089:
            if (r5 == 0) goto L_0x00d8
        L_0x008b:
            int r13 = r5.size()
            if (r7 >= r13) goto L_0x000b
            java.lang.Object r13 = r5.get(r7)
            com.itextpdf.text.pdf.PdfObject r13 = (com.itextpdf.text.pdf.PdfObject) r13
            boolean r4 = r13.C()
            if (r4 == 0) goto L_0x00bf
            r4 = r13
            com.itextpdf.text.pdf.PRIndirectReference r4 = (com.itextpdf.text.pdf.PRIndirectReference) r4
            int r4 = r4.d()
            java.util.ArrayList<com.itextpdf.text.pdf.PdfObject> r8 = r12.Y2
            int r8 = r8.size()
            if (r4 >= r8) goto L_0x00b8
            boolean r8 = r12.E3
            if (r8 != 0) goto L_0x00bf
            java.util.ArrayList<com.itextpdf.text.pdf.PdfObject> r8 = r12.Y2
            java.lang.Object r4 = r8.get(r4)
            if (r4 != 0) goto L_0x00bf
        L_0x00b8:
            com.itextpdf.text.pdf.PdfNull r13 = com.itextpdf.text.pdf.PdfNull.i3
            r5.set(r7, r13)
            int r7 = r7 + r2
            goto L_0x008b
        L_0x00bf:
            int r7 = r7 + r2
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            if (r6 != 0) goto L_0x00d1
            java.lang.Object[] r6 = new java.lang.Object[r1]
            r6[r0] = r5
            r6[r2] = r4
            r3.push(r6)
            goto L_0x0008
        L_0x00d1:
            r6[r2] = r4
            r3.push(r6)
            goto L_0x0008
        L_0x00d8:
            int r5 = r4.length
            if (r7 >= r5) goto L_0x000b
            r5 = r4[r7]
            com.itextpdf.text.pdf.PdfObject r8 = r13.d0(r5)
            boolean r9 = r8.C()
            if (r9 == 0) goto L_0x010b
            r9 = r8
            com.itextpdf.text.pdf.PRIndirectReference r9 = (com.itextpdf.text.pdf.PRIndirectReference) r9
            int r9 = r9.d()
            if (r9 < 0) goto L_0x0104
            java.util.ArrayList<com.itextpdf.text.pdf.PdfObject> r10 = r12.Y2
            int r10 = r10.size()
            if (r9 >= r10) goto L_0x0104
            boolean r10 = r12.E3
            if (r10 != 0) goto L_0x010b
            java.util.ArrayList<com.itextpdf.text.pdf.PdfObject> r10 = r12.Y2
            java.lang.Object r9 = r10.get(r9)
            if (r9 != 0) goto L_0x010b
        L_0x0104:
            com.itextpdf.text.pdf.PdfNull r8 = com.itextpdf.text.pdf.PdfNull.i3
            r13.V0(r5, r8)
            int r7 = r7 + r2
            goto L_0x00d8
        L_0x010b:
            int r7 = r7 + r2
            if (r6 != 0) goto L_0x011f
            java.lang.Integer r5 = java.lang.Integer.valueOf(r7)
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r0] = r4
            r6[r2] = r13
            r6[r1] = r5
            r3.push(r6)
            goto L_0x0128
        L_0x011f:
            java.lang.Integer r13 = java.lang.Integer.valueOf(r7)
            r6[r1] = r13
            r3.push(r6)
        L_0x0128:
            r3.push(r8)
            goto L_0x000b
        L_0x012d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfReader.u1(com.itextpdf.text.pdf.PdfObject, boolean[]):void");
    }

    public void v(PdfName pdfName, PdfObject pdfObject) {
        this.G3.v(pdfName, pdfObject);
        I1(this.G3);
    }

    public PdfObject v0(int i2) {
        PdfObject s0 = s0(i2);
        p1();
        return s0;
    }

    public int v1() {
        int size = this.Y2.size();
        boolean[] zArr = new boolean[size];
        u1(this.a3, zArr);
        int i2 = 0;
        if (this.E3) {
            for (int i4 = 1; i4 < size; i4++) {
                if (!zArr[i4]) {
                    long[] jArr = this.X;
                    int i5 = i4 * 2;
                    jArr[i5] = -1;
                    jArr[i5 + 1] = 0;
                    this.Y2.set(i4, (Object) null);
                    i2++;
                }
            }
        } else {
            for (int i6 = 1; i6 < size; i6++) {
                if (!zArr[i6]) {
                    this.Y2.set(i6, (Object) null);
                    i2++;
                }
            }
        }
        return i2;
    }

    public void w1() {
        PdfDictionary pdfDictionary = this.b3;
        PdfName pdfName = PdfName.Qc;
        PdfDictionary j0 = pdfDictionary.j0(pdfName);
        if (j0 != null) {
            j0.a1(PdfName.Wg);
            j0.a1(PdfName.Xg);
            if (j0.size() == 0) {
                this.b3.a1(pdfName);
            }
        }
    }

    public void x() {
        if (this.u3) {
            this.u3 = false;
            if (this.c3.q() != 1) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                IntHashtable intHashtable = new IntHashtable();
                for (int i2 = 1; i2 <= this.c3.q(); i2++) {
                    PdfDictionary b2 = this.c3.b(i2);
                    if (b2 != null) {
                        PdfName pdfName = PdfName.N5;
                        PdfObject t0 = t0(b2.d0(pdfName));
                        if (t0 != null) {
                            if (t0.K()) {
                                PRIndirectReference pRIndirectReference = (PRIndirectReference) b2.d0(pdfName);
                                if (intHashtable.c(pRIndirectReference.d())) {
                                    arrayList.add(pRIndirectReference);
                                    arrayList2.add(new PRStream((PRStream) t0, (PdfDictionary) null));
                                } else {
                                    intHashtable.l(pRIndirectReference.d(), 1);
                                }
                            } else if (t0.q()) {
                                PdfArray pdfArray = (PdfArray) t0;
                                for (int i4 = 0; i4 < pdfArray.size(); i4++) {
                                    PRIndirectReference pRIndirectReference2 = (PRIndirectReference) pdfArray.T0(i4);
                                    if (intHashtable.c(pRIndirectReference2.d())) {
                                        arrayList.add(pRIndirectReference2);
                                        arrayList2.add(new PRStream((PRStream) t0(pRIndirectReference2), (PdfDictionary) null));
                                    } else {
                                        intHashtable.l(pRIndirectReference2.d(), 1);
                                    }
                                }
                            }
                        }
                    }
                }
                if (!arrayList2.isEmpty()) {
                    for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                        this.Y2.add(arrayList2.get(i5));
                        ((PRIndirectReference) arrayList.get(i5)).d0(this.Y2.size() - 1, 0);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public PdfReaderInstance y0(PdfWriter pdfWriter) {
        return new PdfReaderInstance(this, pdfWriter);
    }

    public void y1() {
        this.D3 = -1;
    }

    public char z0() {
        return this.l3;
    }

    public void z1() {
        this.c3.o();
    }

    public PdfReader(PdfReader pdfReader) {
        this.d3 = null;
        this.e3 = false;
        this.f3 = false;
        this.g3 = false;
        this.i3 = false;
        this.n3 = null;
        this.o3 = null;
        this.p3 = null;
        this.q3 = null;
        this.r3 = null;
        this.t3 = new ArrayList<>();
        this.u3 = true;
        this.v3 = false;
        this.w3 = false;
        this.D3 = -1;
        this.G3 = new PdfViewerPreferencesImp();
        this.J3 = 0;
        this.I3 = pdfReader.I3;
        this.v3 = pdfReader.v3;
        this.f3 = pdfReader.f3;
        this.g3 = pdfReader.g3;
        this.u3 = pdfReader.u3;
        this.i3 = pdfReader.i3;
        this.n3 = pdfReader.n3;
        this.l3 = pdfReader.l3;
        this.k3 = pdfReader.k3;
        this.h3 = pdfReader.h3;
        this.j3 = pdfReader.j3;
        this.X2 = pdfReader.X2;
        this.s = new PRTokeniser(pdfReader.s.l());
        if (pdfReader.m3 != null) {
            this.m3 = new PdfEncryption(pdfReader.m3);
        }
        this.y3 = pdfReader.y3;
        this.x3 = pdfReader.x3;
        this.Y2 = new ArrayList<>(pdfReader.Y2);
        for (int i2 = 0; i2 < pdfReader.Y2.size(); i2++) {
            this.Y2.set(i2, w(pdfReader.Y2.get(i2), this));
        }
        this.c3 = new PageRefs(pdfReader.c3, this);
        PdfDictionary pdfDictionary = (PdfDictionary) w(pdfReader.a3, this);
        this.a3 = pdfDictionary;
        PdfDictionary j0 = pdfDictionary.j0(PdfName.se);
        this.b3 = j0;
        this.Z2 = j0.j0(PdfName.zc);
        this.B3 = pdfReader.B3;
        this.E3 = pdfReader.E3;
        this.C3 = pdfReader.C3;
        this.Z = pdfReader.Z;
        this.X = pdfReader.X;
        this.F3 = (PRIndirectReference) w(pdfReader.F3, this);
        this.s3 = pdfReader.s3;
    }

    public PdfReader(RandomAccessFileOrArray randomAccessFileOrArray, byte[] bArr) throws IOException {
        this(randomAccessFileOrArray, bArr, true);
    }

    public PdfReader(RandomAccessFileOrArray randomAccessFileOrArray, byte[] bArr, boolean z) throws IOException {
        this(randomAccessFileOrArray.c(), z, bArr, (Certificate) null, (Key) null, (String) null, (ExternalDecryptionProcess) null, false);
    }

    public PdfReader(InputStream inputStream) throws IOException {
        this(inputStream, (byte[]) null);
    }

    public PdfReader(InputStream inputStream, Certificate certificate, ExternalDecryptionProcess externalDecryptionProcess) throws IOException {
        this(new RandomAccessSourceFactory().l(false).m(Document.m3).g(inputStream), false, (byte[]) null, certificate, (Key) null, (String) null, externalDecryptionProcess, true);
    }

    public PdfReader(InputStream inputStream, byte[] bArr) throws IOException {
        this(new RandomAccessSourceFactory().g(inputStream), false, bArr, (Certificate) null, (Key) null, (String) null, (ExternalDecryptionProcess) null, false);
    }

    public PdfReader(String str) throws IOException {
        this(str, (byte[]) null);
    }

    public PdfReader(String str, Certificate certificate, ExternalDecryptionProcess externalDecryptionProcess) throws IOException {
        this(new RandomAccessSourceFactory().l(false).m(Document.m3).b(str), false, (byte[]) null, certificate, (Key) null, (String) null, externalDecryptionProcess, true);
    }

    public PdfReader(String str, Certificate certificate, Key key, String str2) throws IOException {
        this(new RandomAccessSourceFactory().l(false).m(Document.m3).b(str), false, (byte[]) null, certificate, key, str2, (ExternalDecryptionProcess) null, true);
    }

    public PdfReader(String str, byte[] bArr) throws IOException {
        this(str, bArr, false);
    }

    public PdfReader(String str, byte[] bArr, boolean z) throws IOException {
        this(new RandomAccessSourceFactory().l(false).m(Document.m3).b(str), z, bArr, (Certificate) null, (Key) null, (String) null, (ExternalDecryptionProcess) null, true);
    }

    public PdfReader(URL url) throws IOException {
        this(url, (byte[]) null);
    }

    public PdfReader(URL url, byte[] bArr) throws IOException {
        this(new RandomAccessSourceFactory().i(url), false, bArr, (Certificate) null, (Key) null, (String) null, (ExternalDecryptionProcess) null, true);
    }

    public PdfReader(byte[] bArr) throws IOException {
        this(bArr, (byte[]) null);
    }

    public PdfReader(byte[] bArr, Certificate certificate, ExternalDecryptionProcess externalDecryptionProcess) throws IOException {
        this(new RandomAccessSourceFactory().l(false).m(Document.m3).j(bArr), false, (byte[]) null, certificate, (Key) null, (String) null, externalDecryptionProcess, true);
    }

    public PdfReader(byte[] bArr, byte[] bArr2) throws IOException {
        this(new RandomAccessSourceFactory().j(bArr), false, bArr2, (Certificate) null, (Key) null, (String) null, (ExternalDecryptionProcess) null, true);
    }
}
