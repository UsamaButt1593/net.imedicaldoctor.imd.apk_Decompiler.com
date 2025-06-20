package com.itextpdf.text.pdf;

import at.grabner.circleprogress.BuildConfig;
import com.itextpdf.text.AccessibleElementId;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocListener;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.ImgJBIG2;
import com.itextpdf.text.ImgWMF;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Version;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.io.TempFileCache;
import com.itextpdf.text.log.Counter;
import com.itextpdf.text.log.CounterFactory;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.collection.PdfCollection;
import com.itextpdf.text.pdf.events.PdfPageEventForwarder;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import com.itextpdf.text.pdf.interfaces.PdfAnnotations;
import com.itextpdf.text.pdf.interfaces.PdfDocumentActions;
import com.itextpdf.text.pdf.interfaces.PdfEncryptionSettings;
import com.itextpdf.text.pdf.interfaces.PdfIsoConformance;
import com.itextpdf.text.pdf.interfaces.PdfPageActions;
import com.itextpdf.text.pdf.interfaces.PdfRunDirection;
import com.itextpdf.text.pdf.interfaces.PdfVersion;
import com.itextpdf.text.pdf.interfaces.PdfViewerPreferences;
import com.itextpdf.text.pdf.interfaces.PdfXConformance;
import com.itextpdf.text.pdf.internal.PdfVersionImp;
import com.itextpdf.text.pdf.internal.PdfXConformanceImp;
import com.itextpdf.text.xml.xmp.PdfProperties;
import com.itextpdf.text.xml.xmp.XmpWriter;
import com.itextpdf.xmp.XMPConst;
import com.itextpdf.xmp.XMPException;
import com.itextpdf.xmp.options.PropertyOptions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import org.apache.commons.lang3.StringUtils;

public class PdfWriter extends DocWriter implements PdfViewerPreferences, PdfEncryptionSettings, PdfVersion, PdfDocumentActions, PdfPageActions, PdfRunDirection, PdfAnnotations {
    public static final PdfName A4 = new PdfName("1.7");
    @Deprecated
    public static final int A5 = 8;
    public static final int B4 = 1;
    @Deprecated
    public static final int B5 = 16;
    public static final int C4 = 2;
    @Deprecated
    public static final int C5 = 32;
    public static final int D4 = 4;
    @Deprecated
    public static final int D5 = 256;
    public static final int E4 = 8;
    @Deprecated
    public static final int E5 = 512;
    public static final int F4 = 16;
    @Deprecated
    public static final int F5 = 1024;
    public static final int G4 = 32;
    @Deprecated
    public static final int G5 = 4;
    public static final int H4 = 64;
    @Deprecated
    public static final boolean H5 = false;
    public static final int I4 = 128;
    @Deprecated
    public static final boolean I5 = true;
    public static final int J4 = 256;
    public static final int J5 = 0;
    public static final int K4 = 512;
    public static final int K5 = 1;
    public static final int L4 = 1024;
    public static final PdfName L5 = PdfName.Lb;
    public static final int M4 = 2048;
    public static final PdfName M5 = PdfName.K4;
    public static final int N4 = 4096;
    public static final float N5 = 2.5f;
    public static final int O4 = 8192;
    public static final float O5 = 1.0E7f;
    public static final int P4 = 16384;
    public static final int P5 = 0;
    public static final int Q4 = 32768;
    public static final int Q5 = 1;
    public static final int R4 = 65536;
    public static final int R5 = 2;
    public static final int S4 = 131072;
    public static final int S5 = 3;
    public static final int T4 = 262144;
    private static final List<PdfName> T5;
    public static final int U4 = 524288;
    private static final List<PdfName> U5;
    public static final int V4 = 1048576;
    public static final int W4 = 2097152;
    public static final int X4 = 4194304;
    public static final int Y4 = 8388608;
    public static final int Z4 = 16777216;
    public static final PdfName a5 = PdfName.Hh;
    public static final PdfName b5 = PdfName.Th;
    public static final PdfName c5 = PdfName.U6;
    public static final PdfName d5;
    public static final PdfName e5 = PdfName.S6;
    public static final int f5 = 1;
    public static final int g5 = 2;
    public static final int h5 = 0;
    public static final int i5 = 1;
    public static final int j5 = 2;
    public static final int k5 = 0;
    public static final int l5 = 1;
    public static final int m5 = 2;
    public static final int n4 = 65535;
    public static final int n5 = 3;
    protected static Counter o4 = CounterFactory.b(PdfWriter.class);
    static final int o5 = 7;
    public static final char p4 = '2';
    public static final int p5 = 8;
    public static final char q4 = '3';
    public static final int q5 = 24;
    public static final char r4 = '4';
    public static final int r5 = 2052;
    public static final char s4 = '5';
    public static final int s5 = 8;
    public static final char t4 = '6';
    public static final int t5 = 16;
    public static final char u4 = '7';
    public static final int u5 = 32;
    public static final PdfName v4 = new PdfName(BuildConfig.f16618f);
    public static final int v5 = 256;
    public static final PdfName w4 = new PdfName("1.3");
    public static final int w5 = 512;
    public static final PdfName x4 = new PdfName("1.4");
    public static final int x5 = 1024;
    public static final PdfName y4 = new PdfName("1.5");
    public static final int y5 = 4;
    public static final PdfName z4 = new PdfName("1.6");
    @Deprecated
    public static final int z5 = 2052;
    protected PdfEncryption A3;
    protected boolean B3 = false;
    protected int C3 = -1;
    protected LinkedHashMap<BaseFont, FontDetails> D3 = new LinkedHashMap<>();
    protected int E3 = 1;
    protected HashMap<PdfIndirectReference, Object[]> F3 = new HashMap<>();
    protected int G3 = 1;
    protected HashMap<PdfReader, PdfReaderInstance> H3 = new HashMap<>();
    protected PdfReaderInstance I3;
    protected HashMap<ICachedColorSpace, ColorDetails> J3 = new HashMap<>();
    protected int K3 = 1;
    protected HashMap<PdfPatternPainter, PdfName> L3 = new HashMap<>();
    protected int M3 = 1;
    protected HashSet<PdfShadingPattern> N3 = new HashSet<>();
    protected HashSet<PdfShading> O3 = new HashSet<>();
    protected HashMap<PdfDictionary, PdfObject[]> P3 = new HashMap<>();
    protected HashMap<Object, PdfObject[]> Q3 = new HashMap<>();
    protected boolean R3 = false;
    protected int S3 = 1;
    protected PdfStructureTreeRoot T3;
    protected LinkedHashSet<PdfOCG> U3 = new LinkedHashSet<>();
    protected ArrayList<PdfOCG> V3 = new ArrayList<>();
    protected PdfOCProperties W3;
    protected PdfArray X3 = new PdfArray();
    protected PdfArray Y3 = new PdfArray();
    protected PdfDictionary Z3;
    private float a4 = 2.5f;
    protected int b4 = 1;
    protected PdfDictionary c4 = new PdfDictionary();
    protected HashMap<ColorDetails, ColorDetails> d4 = new HashMap<>();
    protected ColorDetails e4;
    protected ColorDetails f4;
    protected ColorDetails g4;
    protected PdfDocument h3;
    protected PdfDictionary h4 = new PdfDictionary();
    protected PdfContentByte i3;
    private final HashMap<Long, PdfName> i4 = new HashMap<>();
    protected PdfContentByte j3;
    protected HashMap<PdfStream, PdfIndirectReference> j4 = new HashMap<>();
    protected PdfBody k3;
    private boolean k4;
    protected ICC_Profile l3;
    private boolean l4;
    protected PdfDictionary m3;
    protected TtfUnicodeWriter m4 = null;
    protected PdfPages n3 = new PdfPages(this);
    protected ArrayList<PdfIndirectReference> o3 = new ArrayList<>();
    protected int p3 = 1;
    protected PdfName q3 = null;
    protected PdfDictionary r3 = new PdfDictionary();
    private PdfPageEvent s3;
    protected long t3 = 0;
    protected byte[] u3 = null;
    protected List<HashMap<String, Object>> v3;
    protected PdfVersionImp w3 = new PdfVersionImp();
    protected byte[] x3 = null;
    protected XmpWriter y3 = null;
    protected PdfIsoConformance z3 = Q1();

    public static class PdfBody {

        /* renamed from: i  reason: collision with root package name */
        private static final int f26365i = 200;

        /* renamed from: a  reason: collision with root package name */
        protected final TreeSet<PdfCrossReference> f26366a;

        /* renamed from: b  reason: collision with root package name */
        protected int f26367b;

        /* renamed from: c  reason: collision with root package name */
        protected long f26368c;

        /* renamed from: d  reason: collision with root package name */
        protected final PdfWriter f26369d;

        /* renamed from: e  reason: collision with root package name */
        protected ByteBuffer f26370e;

        /* renamed from: f  reason: collision with root package name */
        protected ByteBuffer f26371f;

        /* renamed from: g  reason: collision with root package name */
        protected int f26372g;

        /* renamed from: h  reason: collision with root package name */
        protected int f26373h = 0;

        public static class PdfCrossReference implements Comparable<PdfCrossReference> {
            private final long X;
            private final int Y;
            private final int Z;
            private final int s;

            public PdfCrossReference(int i2, int i3, long j2, int i4) {
                this.s = i2;
                this.X = j2;
                this.Y = i3;
                this.Z = i4;
            }

            /* renamed from: a */
            public int compareTo(PdfCrossReference pdfCrossReference) {
                int i2 = this.Y;
                int i3 = pdfCrossReference.Y;
                if (i2 < i3) {
                    return -1;
                }
                return i2 == i3 ? 0 : 1;
            }

            public int b() {
                return this.Y;
            }

            public void c(int i2, OutputStream outputStream) throws IOException {
                byte b2 = (byte) this.s;
                while (true) {
                    outputStream.write(b2);
                    i2--;
                    if (i2 >= 0) {
                        b2 = (byte) ((int) ((this.X >>> (i2 * 8)) & 255));
                    } else {
                        outputStream.write((byte) ((this.Z >>> 8) & 255));
                        outputStream.write((byte) (this.Z & 255));
                        return;
                    }
                }
            }

            public void e(OutputStream outputStream) throws IOException {
                StringBuffer stringBuffer = new StringBuffer("0000000000");
                stringBuffer.append(this.X);
                stringBuffer.delete(0, stringBuffer.length() - 10);
                StringBuffer stringBuffer2 = new StringBuffer("00000");
                stringBuffer2.append(this.Z);
                stringBuffer2.delete(0, stringBuffer2.length() - 5);
                stringBuffer.append(' ');
                stringBuffer.append(stringBuffer2);
                stringBuffer.append(this.Z == 65535 ? " f \n" : " n \n");
                outputStream.write(DocWriter.E(stringBuffer.toString()));
            }

            public boolean equals(Object obj) {
                return (obj instanceof PdfCrossReference) && this.Y == ((PdfCrossReference) obj).Y;
            }

            public int hashCode() {
                return this.Y;
            }

            public PdfCrossReference(int i2, long j2) {
                this.s = 1;
                this.X = j2;
                this.Y = i2;
                this.Z = 0;
            }

            public PdfCrossReference(int i2, long j2, int i3) {
                this.s = 0;
                this.X = j2;
                this.Y = i2;
                this.Z = i3;
            }
        }

        protected PdfBody(PdfWriter pdfWriter) {
            TreeSet<PdfCrossReference> treeSet = new TreeSet<>();
            this.f26366a = treeSet;
            treeSet.add(new PdfCrossReference(0, 0, 65535));
            this.f26368c = pdfWriter.v1().b();
            this.f26367b = 1;
            this.f26369d = pdfWriter;
        }

        /* access modifiers changed from: package-private */
        public PdfIndirectObject a(PdfObject pdfObject) throws IOException {
            return b(pdfObject, i());
        }

        /* access modifiers changed from: package-private */
        public PdfIndirectObject b(PdfObject pdfObject, int i2) throws IOException {
            return c(pdfObject, i2, 0, true);
        }

        /* access modifiers changed from: protected */
        public PdfIndirectObject c(PdfObject pdfObject, int i2, int i3, boolean z) throws IOException {
            if (z && pdfObject.j() && this.f26369d.R1()) {
                PdfCrossReference g2 = g(pdfObject, i2);
                PdfIndirectObject pdfIndirectObject = new PdfIndirectObject(i2, pdfObject, this.f26369d);
                if (!this.f26366a.add(g2)) {
                    this.f26366a.remove(g2);
                    this.f26366a.add(g2);
                }
                return pdfIndirectObject;
            } else if (this.f26369d.R1()) {
                PdfIndirectObject pdfIndirectObject2 = new PdfIndirectObject(i2, pdfObject, this.f26369d);
                n(pdfIndirectObject2, i2);
                return pdfIndirectObject2;
            } else {
                PdfIndirectObject pdfIndirectObject3 = new PdfIndirectObject(i2, i3, pdfObject, this.f26369d);
                o(pdfIndirectObject3, i2, i3);
                return pdfIndirectObject3;
            }
        }

        /* access modifiers changed from: package-private */
        public PdfIndirectObject d(PdfObject pdfObject, PdfIndirectReference pdfIndirectReference) throws IOException {
            return e(pdfObject, pdfIndirectReference, true);
        }

        /* access modifiers changed from: package-private */
        public PdfIndirectObject e(PdfObject pdfObject, PdfIndirectReference pdfIndirectReference, boolean z) throws IOException {
            return c(pdfObject, pdfIndirectReference.d(), pdfIndirectReference.Z(), z);
        }

        /* access modifiers changed from: package-private */
        public PdfIndirectObject f(PdfObject pdfObject, boolean z) throws IOException {
            return c(pdfObject, i(), 0, z);
        }

        /* access modifiers changed from: protected */
        public PdfCrossReference g(PdfObject pdfObject, int i2) throws IOException {
            if (this.f26373h >= 200) {
                h();
            }
            if (this.f26370e == null) {
                this.f26370e = new ByteBuffer();
                this.f26371f = new ByteBuffer();
                this.f26372g = i();
                this.f26373h = 0;
            }
            int C = this.f26371f.C();
            int i3 = this.f26373h;
            this.f26373h = i3 + 1;
            PdfWriter pdfWriter = this.f26369d;
            PdfEncryption pdfEncryption = pdfWriter.A3;
            pdfWriter.A3 = null;
            pdfObject.T(pdfWriter, this.f26371f);
            this.f26369d.A3 = pdfEncryption;
            this.f26371f.c(' ');
            this.f26370e.f(i2).c(' ').f(C).c(' ');
            return new PdfCrossReference(2, i2, (long) this.f26372g, i3);
        }

        public void h() throws IOException {
            if (this.f26373h != 0) {
                int C = this.f26370e.C();
                this.f26370e.i(this.f26371f);
                PdfStream pdfStream = new PdfStream(this.f26370e.F());
                pdfStream.i1(this.f26369d.a1());
                pdfStream.V0(PdfName.Kg, PdfName.Ob);
                pdfStream.V0(PdfName.kb, new PdfNumber(this.f26373h));
                pdfStream.V0(PdfName.U7, new PdfNumber(C));
                b(pdfStream, this.f26372g);
                this.f26370e = null;
                this.f26371f = null;
                this.f26373h = 0;
            }
        }

        /* access modifiers changed from: protected */
        public int i() {
            int i2 = this.f26367b;
            this.f26367b = i2 + 1;
            this.f26366a.add(new PdfCrossReference(i2, 0, 65535));
            return i2;
        }

        public PdfIndirectReference j() {
            return new PdfIndirectReference(0, i());
        }

        public long k() {
            return this.f26368c;
        }

        /* access modifiers changed from: package-private */
        public void l(int i2) {
            this.f26367b = i2;
        }

        public int m() {
            return Math.max(this.f26366a.last().b() + 1, this.f26367b);
        }

        /* access modifiers changed from: protected */
        public void n(PdfIndirectObject pdfIndirectObject, int i2) throws IOException {
            PdfCrossReference pdfCrossReference = new PdfCrossReference(i2, this.f26368c);
            if (!this.f26366a.add(pdfCrossReference)) {
                this.f26366a.remove(pdfCrossReference);
                this.f26366a.add(pdfCrossReference);
            }
            pdfIndirectObject.b(this.f26369d.v1());
            this.f26368c = this.f26369d.v1().b();
        }

        /* access modifiers changed from: protected */
        public void o(PdfIndirectObject pdfIndirectObject, int i2, int i3) throws IOException {
            PdfCrossReference pdfCrossReference = new PdfCrossReference(i2, this.f26368c, i3);
            if (!this.f26366a.add(pdfCrossReference)) {
                this.f26366a.remove(pdfCrossReference);
                this.f26366a.add(pdfCrossReference);
            }
            pdfIndirectObject.b(this.f26369d.v1());
            this.f26368c = this.f26369d.v1().b();
        }

        public void p(OutputStream outputStream, PdfIndirectReference pdfIndirectReference, PdfIndirectReference pdfIndirectReference2, PdfIndirectReference pdfIndirectReference3, PdfObject pdfObject, long j2) throws IOException {
            int i2;
            int i3;
            OutputStream outputStream2 = outputStream;
            PdfIndirectReference pdfIndirectReference4 = pdfIndirectReference2;
            PdfIndirectReference pdfIndirectReference5 = pdfIndirectReference3;
            PdfObject pdfObject2 = pdfObject;
            long j3 = j2;
            if (this.f26369d.R1()) {
                h();
                i2 = i();
                this.f26366a.add(new PdfCrossReference(i2, this.f26368c));
            } else {
                i2 = 0;
            }
            int b2 = this.f26366a.first().b();
            ArrayList arrayList = new ArrayList();
            Iterator<PdfCrossReference> it2 = this.f26366a.iterator();
            int i4 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                PdfCrossReference next = it2.next();
                if (b2 + i4 == next.b()) {
                    i4++;
                } else {
                    arrayList.add(Integer.valueOf(b2));
                    arrayList.add(Integer.valueOf(i4));
                    b2 = next.b();
                    i4 = 1;
                }
            }
            arrayList.add(Integer.valueOf(b2));
            arrayList.add(Integer.valueOf(i4));
            if (this.f26369d.R1()) {
                int i5 = 5;
                long j4 = 1095216660480L;
                for (i3 = 1; i5 > i3 && (this.f26368c & j4) == 0; i3 = 1) {
                    j4 >>>= 8;
                    i5--;
                }
                ByteBuffer byteBuffer = new ByteBuffer();
                Iterator<PdfCrossReference> it3 = this.f26366a.iterator();
                while (it3.hasNext()) {
                    it3.next().c(i5, byteBuffer);
                }
                PdfStream pdfStream = new PdfStream(byteBuffer.F());
                pdfStream.i1(this.f26369d.a1());
                pdfStream.V0(PdfName.Ve, new PdfNumber(m()));
                pdfStream.V0(PdfName.se, pdfIndirectReference);
                if (pdfIndirectReference4 != null) {
                    pdfStream.V0(PdfName.O9, pdfIndirectReference4);
                }
                if (pdfIndirectReference5 != null) {
                    pdfStream.V0(PdfName.n7, pdfIndirectReference5);
                }
                if (pdfObject2 != null) {
                    pdfStream.V0(PdfName.A9, pdfObject2);
                }
                pdfStream.V0(PdfName.Dh, new PdfArray(new int[]{1, i5, 2}));
                pdfStream.V0(PdfName.Kg, PdfName.ci);
                PdfArray pdfArray = new PdfArray();
                for (int i6 = 0; i6 < arrayList.size(); i6++) {
                    pdfArray.a0(new PdfNumber(((Integer) arrayList.get(i6)).intValue()));
                }
                pdfStream.V0(PdfName.M9, pdfArray);
                if (j3 > 0) {
                    pdfStream.V0(PdfName.gd, new PdfNumber(j3));
                }
                PdfWriter pdfWriter = this.f26369d;
                PdfEncryption pdfEncryption = pdfWriter.A3;
                pdfWriter.A3 = null;
                new PdfIndirectObject(i2, (PdfObject) pdfStream, this.f26369d).b(this.f26369d.v1());
                this.f26369d.A3 = pdfEncryption;
                return;
            }
            outputStream2.write(DocWriter.E("xref\n"));
            Iterator<PdfCrossReference> it4 = this.f26366a.iterator();
            for (int i7 = 0; i7 < arrayList.size(); i7 += 2) {
                int intValue = ((Integer) arrayList.get(i7)).intValue();
                int intValue2 = ((Integer) arrayList.get(i7 + 1)).intValue();
                outputStream2.write(DocWriter.E(String.valueOf(intValue)));
                outputStream2.write(DocWriter.E(StringUtils.SPACE));
                outputStream2.write(DocWriter.E(String.valueOf(intValue2)));
                outputStream2.write(10);
                while (true) {
                    int i8 = intValue2 - 1;
                    if (intValue2 <= 0) {
                        break;
                    }
                    it4.next().e(outputStream2);
                    intValue2 = i8;
                }
            }
        }
    }

    public static class PdfTrailer extends PdfDictionary {
        long p3;

        public PdfTrailer(int i2, long j2, PdfIndirectReference pdfIndirectReference, PdfIndirectReference pdfIndirectReference2, PdfIndirectReference pdfIndirectReference3, PdfObject pdfObject, long j3) {
            this.p3 = j2;
            V0(PdfName.Ve, new PdfNumber(i2));
            V0(PdfName.se, pdfIndirectReference);
            if (pdfIndirectReference2 != null) {
                V0(PdfName.O9, pdfIndirectReference2);
            }
            if (pdfIndirectReference3 != null) {
                V0(PdfName.n7, pdfIndirectReference3);
            }
            if (pdfObject != null) {
                V0(PdfName.A9, pdfObject);
            }
            if (j3 > 0) {
                V0(PdfName.gd, new PdfNumber(j3));
            }
        }

        public void T(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
            PdfWriter.G0(pdfWriter, 8, this);
            outputStream.write(DocWriter.E("trailer\n"));
            super.T((PdfWriter) null, outputStream);
            outputStream.write(10);
            PdfWriter.P2(outputStream);
            outputStream.write(DocWriter.E("startxref\n"));
            outputStream.write(DocWriter.E(String.valueOf(this.p3)));
            outputStream.write(DocWriter.E("\n%%EOF\n"));
        }
    }

    static {
        PdfName pdfName = PdfName.Sh;
        d5 = pdfName;
        PdfName pdfName2 = PdfName.P6;
        PdfName pdfName3 = PdfName.Gc;
        PdfName pdfName4 = PdfName.V3;
        PdfName pdfName5 = PdfName.Ie;
        PdfName pdfName6 = PdfName.J6;
        PdfName pdfName7 = PdfName.z4;
        PdfName pdfName8 = PdfName.T4;
        PdfName pdfName9 = PdfName.lg;
        PdfName pdfName10 = PdfName.mg;
        PdfName pdfName11 = PdfName.M9;
        PdfName pdfName12 = PdfName.Fb;
        PdfName pdfName13 = PdfName.qd;
        PdfName pdfName14 = PdfName.tc;
        PdfName pdfName15 = PdfName.W8;
        PdfName pdfName16 = PdfName.X8;
        PdfName pdfName17 = PdfName.Y8;
        PdfName pdfName18 = PdfName.Z8;
        PdfName pdfName19 = PdfName.a9;
        PdfName pdfName20 = PdfName.b9;
        PdfName pdfName21 = PdfName.c9;
        PdfName pdfName22 = PdfName.ja;
        PdfName pdfName23 = PdfName.ta;
        PdfName pdfName24 = PdfName.xa;
        PdfName pdfName25 = PdfName.ua;
        PdfName pdfName26 = PdfName.Kf;
        PdfName pdfName27 = PdfName.Of;
        PdfName pdfName28 = PdfName.Xf;
        PdfName pdfName29 = PdfName.Nf;
        PdfName pdfName30 = PdfName.cf;
        PdfName pdfName31 = PdfName.Cd;
        PdfName pdfName32 = PdfName.Hb;
        PdfName pdfName33 = PdfName.Pd;
        PdfName pdfName34 = PdfName.q4;
        PdfName pdfName35 = PdfName.s5;
        PdfName pdfName36 = PdfName.Ca;
        PdfName pdfName37 = PdfName.Q7;
        PdfName pdfName38 = PdfName.y8;
        PdfName pdfName39 = PdfName.w8;
        PdfName pdfName40 = pdfName16;
        T5 = Arrays.asList(new PdfName[]{pdfName2, pdfName3, pdfName4, pdfName5, pdfName6, pdfName7, pdfName8, pdfName9, pdfName10, pdfName11, pdfName12, pdfName13, pdfName14, pdfName15, pdfName40, pdfName17, pdfName18, pdfName19, pdfName20, pdfName21, pdfName22, pdfName23, pdfName24, pdfName25, pdfName26, pdfName27, pdfName28, pdfName29, pdfName30, pdfName31, pdfName32, pdfName33, pdfName34, pdfName35, pdfName36, pdfName37, pdfName38, pdfName39});
        U5 = Arrays.asList(new PdfName[]{pdfName2, pdfName3, pdfName4, pdfName5, pdfName6, pdfName7, pdfName8, pdfName9, pdfName10, pdfName11, pdfName12, pdfName13, pdfName14, pdfName15, pdfName40, pdfName17, pdfName18, pdfName19, pdfName20, pdfName21, pdfName22, pdfName23, pdfName24, pdfName25, pdfName26, pdfName27, pdfName28, pdfName29, PdfName.Yf, PdfName.Mf, PdfName.Wf, pdfName30, pdfName31, pdfName32, pdfName33, pdfName34, pdfName35, pdfName36, PdfName.P3, PdfName.ze, PdfName.Gd, PdfName.ye, PdfName.xe, PdfName.Fh, PdfName.Uh, pdfName, pdfName37, pdfName38, pdfName39});
    }

    protected PdfWriter() {
    }

    public static void G0(PdfWriter pdfWriter, int i2, Object obj) {
        if (pdfWriter != null) {
            pdfWriter.F0(i2, obj);
        }
    }

    private void I0(PdfDictionary pdfDictionary) {
        if (U1()) {
            PdfName pdfName = PdfName.rc;
            if (pdfDictionary.d0(pdfName) == null) {
                PdfDictionary pdfDictionary2 = new PdfDictionary(PdfName.qc);
                pdfDictionary2.V0(PdfName.oc, new PdfString("SWOP CGATS TR 001-1995"));
                pdfDictionary2.V0(PdfName.pc, new PdfString("CGATS TR 001"));
                pdfDictionary2.V0(PdfName.Rd, new PdfString("http://www.color.org"));
                pdfDictionary2.V0(PdfName.O9, new PdfString(""));
                pdfDictionary2.V0(PdfName.Ce, PdfName.U8);
                pdfDictionary.V0(pdfName, new PdfArray((PdfObject) pdfDictionary2));
            }
        }
    }

    private void J0(PdfDictionary pdfDictionary) {
        PdfString pdfString;
        if (U1()) {
            PdfName pdfName = PdfName.V8;
            if (pdfDictionary.d0(pdfName) == null) {
                if (((PdfXConformanceImp) this.z3).f()) {
                    pdfDictionary.V0(pdfName, new PdfString("PDF/X-1:2001"));
                    pdfName = new PdfName("GTS_PDFXConformance");
                    pdfString = new PdfString("PDF/X-1a:2001");
                } else if (((PdfXConformanceImp) this.z3).g()) {
                    pdfString = new PdfString("PDF/X-3:2002");
                }
                pdfDictionary.V0(pdfName, pdfString);
            }
            PdfName pdfName2 = PdfName.ig;
            if (pdfDictionary.d0(pdfName2) == null) {
                pdfDictionary.V0(pdfName2, new PdfString("Pdf document"));
            }
            PdfName pdfName3 = PdfName.V5;
            if (pdfDictionary.d0(pdfName3) == null) {
                pdfDictionary.V0(pdfName3, new PdfString("Unknown"));
            }
            PdfName pdfName4 = PdfName.yg;
            if (pdfDictionary.d0(pdfName4) == null) {
                pdfDictionary.V0(pdfName4, new PdfName(XMPConst.m2));
            }
        }
    }

    protected static void P2(OutputStream outputStream) throws IOException {
        Version a2 = Version.a();
        String b2 = a2.b();
        if (b2 == null) {
            b2 = "iText";
        }
        outputStream.write(DocWriter.E(String.format("%%%s-%s\n", new Object[]{b2, a2.d()})));
    }

    private void T(PdfName pdfName, PdfName pdfName2) {
        PdfArray pdfArray = new PdfArray();
        Iterator<PdfOCG> it2 = this.U3.iterator();
        while (it2.hasNext()) {
            PdfLayer pdfLayer = (PdfLayer) it2.next();
            PdfDictionary j0 = pdfLayer.j0(PdfName.ah);
            if (!(j0 == null || j0.d0(pdfName2) == null)) {
                pdfArray.a0(pdfLayer.g());
            }
        }
        if (pdfArray.size() != 0) {
            PdfDictionary j02 = this.W3.j0(PdfName.f6);
            PdfName pdfName3 = PdfName.Z3;
            PdfArray e0 = j02.e0(pdfName3);
            if (e0 == null) {
                e0 = new PdfArray();
                j02.V0(pdfName3, e0);
            }
            PdfDictionary pdfDictionary = new PdfDictionary();
            pdfDictionary.V0(PdfName.E7, pdfName);
            pdfDictionary.V0(PdfName.V4, new PdfArray((PdfObject) pdfName2));
            pdfDictionary.V0(PdfName.Rb, pdfArray);
            e0.a0(pdfDictionary);
        }
    }

    public static PdfWriter p1(Document document, OutputStream outputStream) throws DocumentException {
        PdfDocument pdfDocument = new PdfDocument();
        document.h(pdfDocument);
        PdfWriter pdfWriter = new PdfWriter(pdfDocument, outputStream);
        pdfDocument.i0(pdfWriter);
        return pdfWriter;
    }

    public static PdfWriter q1(Document document, OutputStream outputStream, DocListener docListener) throws DocumentException {
        PdfDocument pdfDocument = new PdfDocument();
        pdfDocument.h(docListener);
        document.h(pdfDocument);
        PdfWriter pdfWriter = new PdfWriter(pdfDocument, outputStream);
        pdfDocument.i0(pdfWriter);
        return pdfWriter;
    }

    protected static String r1(PdfDictionary pdfDictionary, PdfName pdfName) {
        PdfObject t0 = PdfReader.t0(pdfDictionary.d0(pdfName));
        if (t0 == null || !t0.N()) {
            return null;
        }
        return ((PdfString) t0).m0();
    }

    private static void t1(PdfArray pdfArray, PdfLayer pdfLayer) {
        if (pdfLayer.s1()) {
            if (pdfLayer.o1() == null) {
                pdfArray.a0(pdfLayer.g());
            }
            ArrayList<PdfLayer> m1 = pdfLayer.m1();
            if (m1 != null) {
                PdfArray pdfArray2 = new PdfArray();
                if (pdfLayer.o1() != null) {
                    pdfArray2.a0(new PdfString(pdfLayer.o1(), PdfObject.h3));
                }
                for (int i2 = 0; i2 < m1.size(); i2++) {
                    t1(pdfArray2, m1.get(i2));
                }
                if (pdfArray2.size() > 0) {
                    pdfArray.a0(pdfArray2);
                }
            }
        }
    }

    public void A(PdfTransition pdfTransition) {
        this.h3.w1(pdfTransition);
    }

    public PdfIndirectObject A0(PdfObject pdfObject, boolean z) throws IOException {
        PdfIndirectObject f2 = this.k3.f(pdfObject, z);
        D0(f2);
        return f2;
    }

    public PdfIndirectReference A1(int i2) {
        int i6 = i2 - 1;
        if (i6 < 0) {
            throw new IndexOutOfBoundsException(MessageLocalization.b("the.page.number.must.be.gt.eq.1", new Object[0]));
        } else if (i6 < this.o3.size()) {
            PdfIndirectReference pdfIndirectReference = this.o3.get(i6);
            if (pdfIndirectReference != null) {
                return pdfIndirectReference;
            }
            PdfIndirectReference j2 = this.k3.j();
            this.o3.set(i6, j2);
            return j2;
        } else {
            int size = i6 - this.o3.size();
            for (int i7 = 0; i7 < size; i7++) {
                this.o3.add((Object) null);
            }
            PdfIndirectReference j6 = this.k3.j();
            this.o3.add(j6);
            return j6;
        }
    }

    public void A2(PdfPageEvent pdfPageEvent) {
        if (pdfPageEvent == null) {
            pdfPageEvent = null;
        } else {
            PdfPageEvent pdfPageEvent2 = this.s3;
            if (pdfPageEvent2 != null) {
                if (pdfPageEvent2 instanceof PdfPageEventForwarder) {
                    ((PdfPageEventForwarder) pdfPageEvent2).a(pdfPageEvent);
                    return;
                }
                PdfPageEventForwarder pdfPageEventForwarder = new PdfPageEventForwarder();
                pdfPageEventForwarder.a(this.s3);
                pdfPageEventForwarder.a(pdfPageEvent);
                this.s3 = pdfPageEventForwarder;
                return;
            }
        }
        this.s3 = pdfPageEvent;
    }

    public PdfAcroForm B() {
        return this.h3.u0();
    }

    /* access modifiers changed from: protected */
    public void B0() throws IOException {
        for (Object[] objArr : this.F3.values()) {
            PdfTemplate pdfTemplate = (PdfTemplate) objArr[1];
            if ((pdfTemplate == null || !(pdfTemplate.J3() instanceof PRIndirectReference)) && pdfTemplate != null && pdfTemplate.O3() == 1) {
                y0(pdfTemplate.G3(this.C3), pdfTemplate.J3());
            }
        }
    }

    public Rectangle B1() {
        return this.h3.C();
    }

    public void B2(PdfPageLabels pdfPageLabels) {
        this.h3.r1(pdfPageLabels);
    }

    /* access modifiers changed from: protected */
    public void C0(PdfDictionary pdfDictionary) {
        if (this.R3) {
            try {
                L1().f1();
                for (AccessibleElementId I0 : this.h3.J0()) {
                    PdfStructureElement I02 = this.h3.I0(I0, false);
                    y0(I02, I02.p1());
                }
                pdfDictionary.V0(PdfName.xf, this.T3.o1());
                PdfDictionary pdfDictionary2 = new PdfDictionary();
                PdfName pdfName = PdfName.Ta;
                PdfBoolean pdfBoolean = PdfBoolean.j3;
                pdfDictionary2.V0(pdfName, pdfBoolean);
                if (this.k4) {
                    pdfDictionary2.V0(PdfName.gh, pdfBoolean);
                }
                pdfDictionary.V0(PdfName.Ua, pdfDictionary2);
            } catch (Exception e2) {
                throw new ExceptionConverter(e2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public PdfDocument C1() {
        return this.h3;
    }

    public void C2(PdfArray pdfArray) {
        l0(PdfName.Bh, pdfArray);
    }

    /* access modifiers changed from: protected */
    public void D0(PdfIndirectObject pdfIndirectObject) {
    }

    public PdfIndirectReference D1() {
        return this.k3.j();
    }

    public void D2(byte[] bArr) throws IOException {
        this.h3.y1(bArr);
    }

    public void E0(IAccessibleElement iAccessibleElement, IAccessibleElement iAccessibleElement2) {
        if (iAccessibleElement2 != null && (iAccessibleElement2.L() == null || PdfName.X3.equals(iAccessibleElement2.L()))) {
            iAccessibleElement.o((PdfName) null);
        } else if ((this.S3 & 1) != 0 && iAccessibleElement.n() && iAccessibleElement.L() == null) {
            if (iAccessibleElement2 == null || !iAccessibleElement2.n()) {
                throw new IllegalArgumentException(MessageLocalization.b("inline.elements.with.role.null.are.not.allowed", new Object[0]));
            }
        }
    }

    /* access modifiers changed from: protected */
    public PdfReaderInstance E1(PdfReader pdfReader) {
        PdfReaderInstance pdfReaderInstance = this.H3.get(pdfReader);
        if (pdfReaderInstance != null) {
            return pdfReaderInstance;
        }
        PdfReaderInstance y0 = pdfReader.y0(this);
        this.H3.put(pdfReader, y0);
        return y0;
    }

    public void E2(boolean z) {
        this.l4 = z;
    }

    public void F0(int i2, Object obj) {
        this.z3.d(i2, obj);
    }

    /* access modifiers changed from: package-private */
    public PdfVersionImp F1() {
        return this.w3;
    }

    public void F2(float f2) {
        if (f2 < 0.001f) {
            this.a4 = 0.001f;
        } else {
            this.a4 = f2;
        }
    }

    /* access modifiers changed from: package-private */
    public RandomAccessFileOrArray G1(PdfReader pdfReader) {
        return this.I3.e();
    }

    public void G2(boolean z) {
        this.h3.t1(z);
    }

    public void H0() throws DocumentException {
        this.h3.n0();
    }

    /* access modifiers changed from: protected */
    public PdfIndirectReference H1(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        for (PdfStream next : this.j4.keySet()) {
            if (Arrays.equals(bArr, next.k())) {
                return this.j4.get(next);
            }
        }
        PdfStream pdfStream = new PdfStream(bArr);
        try {
            PdfIndirectObject v0 = v0(pdfStream);
            this.j4.put(pdfStream, v0.a());
            return v0.a();
        } catch (IOException unused) {
            return null;
        }
    }

    public void H2(PdfName pdfName) {
        this.q3 = pdfName;
    }

    public PdfOutline I1() {
        return this.i3.j1();
    }

    public void I2() {
        J2(1);
    }

    public float J1() {
        return this.a4;
    }

    public void J2(int i2) {
        if (!this.Z) {
            this.R3 = true;
            this.S3 = i2;
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.b("tagging.must.be.set.before.opening.the.document", new Object[0]));
    }

    public PdfAnnotation K0(float f2, float f3, float f6, float f7, PdfAction pdfAction, PdfName pdfName) {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(this, f2, f3, f6, f7, pdfAction);
        if (pdfName != null) {
            pdfAnnotation.V0(PdfName.Cf, pdfName);
        }
        return pdfAnnotation;
    }

    public List<PdfName> K1() {
        return this.w3.b() < '7' ? T5 : U5;
    }

    public void K2(Image image) throws PdfException, DocumentException {
        this.h3.v1(image);
    }

    public PdfAnnotation L0(float f2, float f3, float f6, float f7, PdfString pdfString, PdfString pdfString2, PdfName pdfName) {
        PdfName pdfName2 = pdfName;
        PdfAnnotation pdfAnnotation = new PdfAnnotation(this, f2, f3, f6, f7, pdfString, pdfString2);
        if (pdfName2 != null) {
            pdfAnnotation.V0(PdfName.Cf, pdfName2);
        }
        return pdfAnnotation;
    }

    public PdfStructureTreeRoot L1() {
        if (this.R3 && this.T3 == null) {
            this.T3 = new PdfStructureTreeRoot(this);
        }
        return this.T3;
    }

    public void L2(boolean z) {
        this.k4 = z;
    }

    public PdfAnnotation M0(Rectangle rectangle, PdfName pdfName) {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(this, rectangle);
        if (pdfName != null) {
            pdfAnnotation.V0(PdfName.Cf, pdfName);
        }
        return pdfAnnotation;
    }

    public PdfName M1() {
        return this.q3;
    }

    public void M2(float f2) throws DocumentException {
        if (f2 < 1.0f || f2 > 75000.0f) {
            throw new DocumentException(MessageLocalization.b("userunit.should.be.a.value.between.1.and.75000", new Object[0]));
        }
        l0(PdfName.hh, new PdfNumber(f2));
        e(t4);
    }

    public void N0() {
        try {
            this.y3 = O0((ByteArrayOutputStream) null, this.h3.z0());
            if (X1()) {
                this.y3.h().E1(XMPConst.B1, PdfProperties.f27412d, 1, new PropertyOptions(1073741824));
            }
            this.x3 = null;
        } catch (XMPException e2) {
            throw new ExceptionConverter(e2);
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public TtfUnicodeWriter N1() {
        if (this.m4 == null) {
            this.m4 = new TtfUnicodeWriter(this);
        }
        return this.m4;
    }

    public void N2(byte[] bArr) {
        this.x3 = bArr;
    }

    /* access modifiers changed from: protected */
    public XmpWriter O0(ByteArrayOutputStream byteArrayOutputStream, PdfDictionary pdfDictionary) throws IOException {
        return new XmpWriter((OutputStream) byteArrayOutputStream, pdfDictionary);
    }

    public float O1(boolean z) {
        return this.h3.N0(z);
    }

    public void O2(TempFileCache tempFileCache) {
        this.h3.A1(tempFileCache);
    }

    /* access modifiers changed from: protected */
    public XmpWriter P0(ByteArrayOutputStream byteArrayOutputStream, HashMap<String, String> hashMap) throws IOException {
        return new XmpWriter((OutputStream) byteArrayOutputStream, (Map<String, String>) hashMap);
    }

    public XmpWriter P1() {
        return this.y3;
    }

    /* access modifiers changed from: protected */
    public PdfIndirectReference Q(PdfICCBased pdfICCBased) {
        try {
            return v0(pdfICCBased).a();
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public void Q0(PdfDictionary pdfDictionary) {
        for (FontDetails next : this.D3.values()) {
            if (pdfDictionary.d0(next.f()) != null) {
                next.j(false);
            }
        }
    }

    /* access modifiers changed from: protected */
    public PdfIsoConformance Q1() {
        return new PdfXConformanceImp(this);
    }

    /* access modifiers changed from: protected */
    public void Q2(PdfDictionary pdfDictionary, boolean z) throws IOException {
        List<HashMap<String, Object>> list = this.v3;
        if (list != null && !list.isEmpty()) {
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            PdfIndirectReference D1 = D1();
            Object[] o = SimpleBookmark.o(this, D1, this.v3, z);
            pdfDictionary2.V0(PdfName.U7, (PdfIndirectReference) o[0]);
            pdfDictionary2.V0(PdfName.oa, (PdfIndirectReference) o[1]);
            pdfDictionary2.V0(PdfName.P5, new PdfNumber(((Integer) o[2]).intValue()));
            y0(pdfDictionary2, D1);
            pdfDictionary.V0(PdfName.nc, D1);
        }
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference R(PdfImage pdfImage, PdfIndirectReference pdfIndirectReference) throws PdfException {
        if (this.h4.a0(pdfImage.w1())) {
            return (PdfIndirectReference) this.h4.d0(pdfImage.w1());
        }
        G0(this, 5, pdfImage);
        if (pdfIndirectReference instanceof PRIndirectReference) {
            PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfIndirectReference;
            pdfIndirectReference = new PdfIndirectReference(0, s1(pRIndirectReference.a0(), pRIndirectReference.d(), pRIndirectReference.Z()));
        }
        if (pdfIndirectReference == null) {
            try {
                pdfIndirectReference = v0(pdfImage).a();
            } catch (IOException e2) {
                throw new ExceptionConverter(e2);
            }
        } else {
            y0(pdfImage, pdfIndirectReference);
        }
        this.h4.V0(pdfImage.w1(), pdfIndirectReference);
        return pdfIndirectReference;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b0, code lost:
        r0 = com.itextpdf.text.pdf.PdfName.qb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void R0(boolean r5) {
        /*
            r4 = this;
            com.itextpdf.text.pdf.PdfOCProperties r0 = r4.W3
            if (r0 != 0) goto L_0x000b
            com.itextpdf.text.pdf.PdfOCProperties r0 = new com.itextpdf.text.pdf.PdfOCProperties
            r0.<init>()
            r4.W3 = r0
        L_0x000b:
            if (r5 == 0) goto L_0x001b
            com.itextpdf.text.pdf.PdfOCProperties r5 = r4.W3
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.Rb
            r5.a1(r0)
            com.itextpdf.text.pdf.PdfOCProperties r5 = r4.W3
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.f6
            r5.a1(r0)
        L_0x001b:
            com.itextpdf.text.pdf.PdfOCProperties r5 = r4.W3
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.Rb
            com.itextpdf.text.pdf.PdfObject r5 = r5.d0(r0)
            if (r5 != 0) goto L_0x004b
            com.itextpdf.text.pdf.PdfArray r5 = new com.itextpdf.text.pdf.PdfArray
            r5.<init>()
            java.util.LinkedHashSet<com.itextpdf.text.pdf.PdfOCG> r0 = r4.U3
            java.util.Iterator r0 = r0.iterator()
        L_0x0030:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0044
            java.lang.Object r1 = r0.next()
            com.itextpdf.text.pdf.PdfLayer r1 = (com.itextpdf.text.pdf.PdfLayer) r1
            com.itextpdf.text.pdf.PdfIndirectReference r1 = r1.g()
            r5.a0(r1)
            goto L_0x0030
        L_0x0044:
            com.itextpdf.text.pdf.PdfOCProperties r0 = r4.W3
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Rb
            r0.V0(r1, r5)
        L_0x004b:
            com.itextpdf.text.pdf.PdfOCProperties r5 = r4.W3
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.f6
            com.itextpdf.text.pdf.PdfObject r5 = r5.d0(r0)
            if (r5 == 0) goto L_0x0056
            return
        L_0x0056:
            java.util.ArrayList r5 = new java.util.ArrayList
            java.util.ArrayList<com.itextpdf.text.pdf.PdfOCG> r0 = r4.V3
            r5.<init>(r0)
            java.util.Iterator r0 = r5.iterator()
        L_0x0061:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0077
            java.lang.Object r1 = r0.next()
            com.itextpdf.text.pdf.PdfLayer r1 = (com.itextpdf.text.pdf.PdfLayer) r1
            com.itextpdf.text.pdf.PdfLayer r1 = r1.n1()
            if (r1 == 0) goto L_0x0061
            r0.remove()
            goto L_0x0061
        L_0x0077:
            com.itextpdf.text.pdf.PdfArray r0 = new com.itextpdf.text.pdf.PdfArray
            r0.<init>()
            java.util.Iterator r1 = r5.iterator()
        L_0x0080:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0090
            java.lang.Object r2 = r1.next()
            com.itextpdf.text.pdf.PdfLayer r2 = (com.itextpdf.text.pdf.PdfLayer) r2
            t1(r0, r2)
            goto L_0x0080
        L_0x0090:
            com.itextpdf.text.pdf.PdfDictionary r1 = new com.itextpdf.text.pdf.PdfDictionary
            r1.<init>()
            com.itextpdf.text.pdf.PdfOCProperties r2 = r4.W3
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.f6
            r2.V0(r3, r1)
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.jc
            r1.V0(r2, r0)
            int r0 = r5.size()
            if (r0 <= 0) goto L_0x00c1
            r0 = 0
            java.lang.Object r2 = r5.get(r0)
            boolean r2 = r2 instanceof com.itextpdf.text.pdf.PdfLayer
            if (r2 == 0) goto L_0x00c1
            java.lang.Object r5 = r5.get(r0)
            com.itextpdf.text.pdf.PdfLayer r5 = (com.itextpdf.text.pdf.PdfLayer) r5
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.qb
            com.itextpdf.text.pdf.PdfString r5 = r5.A0(r0)
            if (r5 == 0) goto L_0x00c1
            r1.V0(r0, r5)
        L_0x00c1:
            com.itextpdf.text.pdf.PdfArray r5 = new com.itextpdf.text.pdf.PdfArray
            r5.<init>()
            java.util.LinkedHashSet<com.itextpdf.text.pdf.PdfOCG> r0 = r4.U3
            java.util.Iterator r0 = r0.iterator()
        L_0x00cc:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00e6
            java.lang.Object r2 = r0.next()
            com.itextpdf.text.pdf.PdfLayer r2 = (com.itextpdf.text.pdf.PdfLayer) r2
            boolean r3 = r2.q1()
            if (r3 != 0) goto L_0x00cc
            com.itextpdf.text.pdf.PdfIndirectReference r2 = r2.g()
            r5.a0(r2)
            goto L_0x00cc
        L_0x00e6:
            int r0 = r5.size()
            if (r0 <= 0) goto L_0x00f1
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.Yb
            r1.V0(r0, r5)
        L_0x00f1:
            com.itextpdf.text.pdf.PdfArray r5 = r4.X3
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x0100
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.Id
            com.itextpdf.text.pdf.PdfArray r0 = r4.X3
            r1.V0(r5, r0)
        L_0x0100:
            com.itextpdf.text.pdf.PdfArray r5 = r4.Y3
            int r5 = r5.size()
            if (r5 <= 0) goto L_0x010f
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.Ia
            com.itextpdf.text.pdf.PdfArray r0 = r4.Y3
            r1.V0(r5, r0)
        L_0x010f:
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.sh
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.ji
            r4.T(r5, r0)
            r4.T(r5, r5)
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.id
            r4.T(r5, r5)
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.C7
            r4.T(r5, r5)
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.Ea
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.zh
            r1.V0(r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfWriter.R0(boolean):void");
    }

    public boolean R1() {
        return this.B3;
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference S(PdfPage pdfPage, PdfContents pdfContents) throws PdfException {
        if (this.Z) {
            try {
                pdfPage.f1(v0(pdfContents).a());
                PdfDictionary pdfDictionary = this.Z3;
                if (pdfDictionary != null) {
                    pdfPage.V0(PdfName.S8, pdfDictionary);
                    this.Z3 = null;
                } else if (this.l4) {
                    PdfDictionary pdfDictionary2 = new PdfDictionary();
                    PdfName pdfName = PdfName.Kg;
                    PdfName pdfName2 = PdfName.S8;
                    pdfDictionary2.V0(pdfName, pdfName2);
                    pdfDictionary2.V0(PdfName.Ce, PdfName.vg);
                    pdfDictionary2.V0(PdfName.b6, PdfName.B6);
                    pdfPage.V0(pdfName2, pdfDictionary2);
                }
                this.n3.a(pdfPage);
                this.p3++;
                return null;
            } catch (IOException e2) {
                throw new ExceptionConverter(e2);
            }
        } else {
            throw new PdfException(MessageLocalization.b("the.document.is.not.open", new Object[0]));
        }
    }

    /* access modifiers changed from: protected */
    public void S0() throws IOException, BadPdfFormatException {
    }

    public boolean S1() {
        return this.h3.T0();
    }

    /* access modifiers changed from: protected */
    public void T0() throws IOException {
    }

    public boolean T1() {
        return this.z3.b();
    }

    /* access modifiers changed from: package-private */
    public void U(PdfAnnotation pdfAnnotation, int i2) {
        u(pdfAnnotation);
    }

    public void U0(PdfReader pdfReader) throws IOException {
        PdfReaderInstance pdfReaderInstance = this.H3.get(pdfReader);
        this.I3 = pdfReaderInstance;
        if (pdfReaderInstance != null) {
            pdfReaderInstance.g();
            this.I3 = null;
            this.H3.remove(pdfReader);
        }
    }

    public boolean U1() {
        PdfIsoConformance pdfIsoConformance = this.z3;
        if (pdfIsoConformance instanceof PdfXConformanceImp) {
            return ((PdfXConformance) pdfIsoConformance).a();
        }
        return false;
    }

    public PdfName V(Image image) throws PdfException, DocumentException {
        return W(image, (PdfIndirectReference) null);
    }

    public Rectangle V0(String str) {
        return this.h3.v0(str);
    }

    public boolean V1() {
        return this.l4;
    }

    public PdfName W(Image image, PdfIndirectReference pdfIndirectReference) throws PdfException, DocumentException {
        PdfName pdfName;
        byte[] y2;
        if (this.i4.containsKey(image.i1())) {
            return this.i4.get(image.i1());
        }
        if (image.B1()) {
            pdfName = new PdfName("img" + this.i4.size());
            if (image instanceof ImgWMF) {
                try {
                    ((ImgWMF) image).z2(PdfTemplate.B3(this, 0.0f, 0.0f));
                } catch (Exception e2) {
                    throw new DocumentException(e2);
                }
            }
        } else {
            PdfIndirectReference M0 = image.M0();
            if (M0 != null) {
                PdfName pdfName2 = new PdfName("img" + this.i4.size());
                this.i4.put(image.i1(), pdfName2);
                this.h4.V0(pdfName2, M0);
                return pdfName2;
            }
            Image Q0 = image.Q0();
            PdfIndirectReference l1 = Q0 != null ? l1(this.i4.get(Q0.i1())) : null;
            PdfImage pdfImage = new PdfImage(image, "img" + this.i4.size(), l1);
            if ((image instanceof ImgJBIG2) && (y2 = ((ImgJBIG2) image).y2()) != null) {
                PdfDictionary pdfDictionary = new PdfDictionary();
                pdfDictionary.V0(PdfName.ca, H1(y2));
                pdfImage.V0(PdfName.o6, pdfDictionary);
            }
            if (image.y1()) {
                PdfIndirectReference Q = Q(new PdfICCBased(image.P0(), image.L0()));
                PdfArray pdfArray = new PdfArray();
                pdfArray.a0(PdfName.z9);
                pdfArray.a0(Q);
                PdfName pdfName3 = PdfName.w5;
                PdfArray e0 = pdfImage.e0(pdfName3);
                if (e0 == null || e0.size() <= 1 || !PdfName.N9.equals(e0.T0(0))) {
                    pdfImage.V0(pdfName3, pdfArray);
                } else {
                    e0.V0(1, pdfArray);
                }
            }
            R(pdfImage, pdfIndirectReference);
            pdfName = pdfImage.w1();
        }
        this.i4.put(image.i1(), pdfName);
        return pdfName;
    }

    public Rectangle W0(String str, Rectangle rectangle) {
        Rectangle v0 = this.h3.v0(str);
        if (v0 == null || rectangle == null) {
            return null;
        }
        com.itextpdf.awt.geom.Rectangle w0 = new com.itextpdf.awt.geom.Rectangle(v0).w0(new com.itextpdf.awt.geom.Rectangle(rectangle));
        if (w0.w()) {
            return null;
        }
        Rectangle rectangle2 = new Rectangle((float) w0.u(), (float) w0.v(), (float) (w0.u() + w0.t()), (float) (w0.v() + w0.o()));
        rectangle2.e0();
        return rectangle2;
    }

    public boolean W1() {
        return this.h3.U0();
    }

    /* access modifiers changed from: package-private */
    public PdfName X(PdfTemplate pdfTemplate, PdfName pdfName) {
        PdfIndirectReference J32 = pdfTemplate.J3();
        Object[] objArr = this.F3.get(J32);
        if (objArr != null) {
            return (PdfName) objArr[0];
        }
        if (pdfName == null) {
            try {
                pdfName = new PdfName("Xf" + this.G3);
                this.G3 = this.G3 + 1;
            } catch (Exception e2) {
                throw new ExceptionConverter(e2);
            }
        }
        if (pdfTemplate.O3() == 2) {
            PdfImportedPage pdfImportedPage = (PdfImportedPage) pdfTemplate;
            PdfReader d2 = pdfImportedPage.c4().d();
            if (!this.H3.containsKey(d2)) {
                this.H3.put(d2, pdfImportedPage.c4());
            }
            pdfTemplate = null;
        }
        this.F3.put(J32, new Object[]{pdfName, pdfTemplate});
        return pdfName;
    }

    /* access modifiers changed from: protected */
    public PdfDictionary X0(PdfIndirectReference pdfIndirectReference) {
        PdfDocument.PdfCatalog w0 = this.h3.w0(pdfIndirectReference);
        C0(w0);
        if (!this.U3.isEmpty()) {
            R0(false);
            w0.V0(PdfName.Tb, this.W3);
        }
        return w0;
    }

    public boolean X1() {
        return this.R3;
    }

    public void Y(PdfFileSpecification pdfFileSpecification) throws IOException {
        Z((String) null, pdfFileSpecification);
    }

    public ICC_Profile Y0() {
        return this.l3;
    }

    public boolean Y1() {
        return this.k4;
    }

    public void Z(String str, PdfFileSpecification pdfFileSpecification) throws IOException {
        this.h3.a0(str, pdfFileSpecification);
    }

    /* access modifiers changed from: package-private */
    public PdfName Z0() {
        StringBuilder sb = new StringBuilder();
        sb.append("CS");
        int i2 = this.K3;
        this.K3 = i2 + 1;
        sb.append(i2);
        return new PdfName(sb.toString());
    }

    public void Z1(PdfLayer pdfLayer) {
        this.Y3.a0(pdfLayer.g());
    }

    public void a(int i2) {
        this.h3.x1(i2);
    }

    public void a0(String str, byte[] bArr, String str2, String str3) throws IOException {
        Z(str, PdfFileSpecification.m1(this, str2, str3, bArr));
    }

    public int a1() {
        return this.C3;
    }

    public boolean a2(IAccessibleElement iAccessibleElement) {
        return (this.S3 & 1) == 0 || iAccessibleElement.n() || PdfName.X3.equals(iAccessibleElement.L());
    }

    public void b0(PdfAction pdfAction) {
        this.h3.b0(pdfAction);
    }

    /* access modifiers changed from: protected */
    public Counter b1() {
        return o4;
    }

    /* access modifiers changed from: package-private */
    public boolean b2(Object obj) {
        return this.Q3.containsKey(obj);
    }

    public void c0(String str) {
        g0(str, false);
    }

    public long c1() {
        return this.k3.k() + ((long) (this.k3.m() * 20)) + 72;
    }

    /* access modifiers changed from: package-private */
    public void c2(PdfOCG pdfOCG) {
        G0(this, 7, pdfOCG);
        if (pdfOCG instanceof PdfLayer) {
            if (((PdfLayer) pdfOCG).o1() == null) {
                if (!this.U3.contains(pdfOCG)) {
                    this.U3.add(pdfOCG);
                } else {
                    return;
                }
            }
            this.V3.add(pdfOCG);
            return;
        }
        throw new IllegalArgumentException(MessageLocalization.b("only.pdflayer.is.accepted", new Object[0]));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:21|22|23|24) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0073 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r15 = this;
            boolean r0 = r15.Z
            if (r0 == 0) goto L_0x01b0
            int r0 = r15.p3
            r1 = 1
            int r0 = r0 - r1
            java.util.ArrayList<com.itextpdf.text.pdf.PdfIndirectReference> r2 = r15.o3
            int r2 = r2.size()
            if (r0 != r2) goto L_0x0183
            com.itextpdf.text.pdf.PdfDocument r0 = r15.h3
            r0.close()
            r15.m0()     // Catch:{ IOException -> 0x0039 }
            java.util.LinkedHashSet<com.itextpdf.text.pdf.PdfOCG> r0 = r15.U3     // Catch:{ IOException -> 0x0039 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ IOException -> 0x0039 }
        L_0x001e:
            boolean r2 = r0.hasNext()     // Catch:{ IOException -> 0x0039 }
            if (r2 == 0) goto L_0x003c
            java.lang.Object r2 = r0.next()     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfOCG r2 = (com.itextpdf.text.pdf.PdfOCG) r2     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfObject r3 = r2.c()     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfIndirectReference r2 = r2.g()     // Catch:{ IOException -> 0x0039 }
            r15.y0(r3, r2)     // Catch:{ IOException -> 0x0039 }
            goto L_0x001e
        L_0x0036:
            r0 = move-exception
            goto L_0x017f
        L_0x0039:
            r0 = move-exception
            goto L_0x0179
        L_0x003c:
            com.itextpdf.text.pdf.PdfPages r0 = r15.n3     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfIndirectReference r0 = r0.g()     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfDictionary r0 = r15.X0(r0)     // Catch:{ IOException -> 0x0039 }
            java.util.LinkedHashSet<com.itextpdf.text.pdf.PdfOCG> r2 = r15.U3     // Catch:{ IOException -> 0x0039 }
            boolean r2 = r2.isEmpty()     // Catch:{ IOException -> 0x0039 }
            if (r2 != 0) goto L_0x0054
            com.itextpdf.text.pdf.PdfOCProperties r2 = r15.W3     // Catch:{ IOException -> 0x0039 }
            r3 = 7
            G0(r15, r3, r2)     // Catch:{ IOException -> 0x0039 }
        L_0x0054:
            byte[] r2 = r15.x3     // Catch:{ IOException -> 0x0039 }
            r3 = 0
            if (r2 != 0) goto L_0x0075
            com.itextpdf.text.xml.xmp.XmpWriter r2 = r15.y3     // Catch:{ IOException -> 0x0039 }
            if (r2 == 0) goto L_0x0075
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ XMPException | IOException -> 0x0073 }
            r2.<init>()     // Catch:{ XMPException | IOException -> 0x0073 }
            com.itextpdf.text.xml.xmp.XmpWriter r4 = r15.y3     // Catch:{ XMPException | IOException -> 0x0073 }
            r4.i(r2)     // Catch:{ XMPException | IOException -> 0x0073 }
            com.itextpdf.text.xml.xmp.XmpWriter r4 = r15.y3     // Catch:{ XMPException | IOException -> 0x0073 }
            r4.g()     // Catch:{ XMPException | IOException -> 0x0073 }
            byte[] r2 = r2.toByteArray()     // Catch:{ XMPException | IOException -> 0x0073 }
            r15.x3 = r2     // Catch:{ XMPException | IOException -> 0x0073 }
            goto L_0x0075
        L_0x0073:
            r15.y3 = r3     // Catch:{ IOException -> 0x0039 }
        L_0x0075:
            byte[] r2 = r15.x3     // Catch:{ IOException -> 0x0039 }
            if (r2 == 0) goto L_0x00b4
            com.itextpdf.text.pdf.PdfStream r2 = new com.itextpdf.text.pdf.PdfStream     // Catch:{ IOException -> 0x0039 }
            byte[] r4 = r15.x3     // Catch:{ IOException -> 0x0039 }
            r2.<init>(r4)     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.Kg     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.db     // Catch:{ IOException -> 0x0039 }
            r2.V0(r4, r5)     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.Cf     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfName r6 = com.itextpdf.text.pdf.PdfName.Zh     // Catch:{ IOException -> 0x0039 }
            r2.V0(r4, r6)     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfEncryption r4 = r15.A3     // Catch:{ IOException -> 0x0039 }
            if (r4 == 0) goto L_0x00a7
            boolean r4 = r4.q()     // Catch:{ IOException -> 0x0039 }
            if (r4 != 0) goto L_0x00a7
            com.itextpdf.text.pdf.PdfArray r4 = new com.itextpdf.text.pdf.PdfArray     // Catch:{ IOException -> 0x0039 }
            r4.<init>()     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfName r6 = com.itextpdf.text.pdf.PdfName.a6     // Catch:{ IOException -> 0x0039 }
            r4.a0(r6)     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfName r6 = com.itextpdf.text.pdf.PdfName.T7     // Catch:{ IOException -> 0x0039 }
            r2.V0(r6, r4)     // Catch:{ IOException -> 0x0039 }
        L_0x00a7:
            com.itextpdf.text.pdf.PdfWriter$PdfBody r4 = r15.k3     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfIndirectObject r2 = r4.a(r2)     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfIndirectReference r2 = r2.a()     // Catch:{ IOException -> 0x0039 }
            r0.V0(r5, r2)     // Catch:{ IOException -> 0x0039 }
        L_0x00b4:
            boolean r2 = r15.U1()     // Catch:{ IOException -> 0x0039 }
            if (r2 == 0) goto L_0x00c8
            com.itextpdf.text.pdf.PdfDictionary r2 = r15.o1()     // Catch:{ IOException -> 0x0039 }
            r15.J0(r2)     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfDictionary r2 = r15.j1()     // Catch:{ IOException -> 0x0039 }
            r15.I0(r2)     // Catch:{ IOException -> 0x0039 }
        L_0x00c8:
            com.itextpdf.text.pdf.PdfDictionary r2 = r15.m3     // Catch:{ IOException -> 0x0039 }
            if (r2 == 0) goto L_0x00cf
            r0.U0(r2)     // Catch:{ IOException -> 0x0039 }
        L_0x00cf:
            r2 = 0
            r15.Q2(r0, r2)     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfIndirectObject r0 = r15.A0(r0, r2)     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfDictionary r4 = r15.o1()     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfIndirectObject r4 = r15.A0(r4, r2)     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfWriter$PdfBody r5 = r15.k3     // Catch:{ IOException -> 0x0039 }
            r5.h()     // Catch:{ IOException -> 0x0039 }
            byte[] r5 = r15.u3     // Catch:{ IOException -> 0x0039 }
            if (r5 == 0) goto L_0x00e9
            goto L_0x00ea
        L_0x00e9:
            r1 = 0
        L_0x00ea:
            com.itextpdf.text.pdf.PdfEncryption r6 = r15.A3     // Catch:{ IOException -> 0x0039 }
            if (r6 == 0) goto L_0x0101
            com.itextpdf.text.pdf.PdfDictionary r3 = r6.l()     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfIndirectObject r2 = r15.A0(r3, r2)     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfIndirectReference r3 = r2.a()     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfEncryption r2 = r15.A3     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfObject r1 = r2.n(r1)     // Catch:{ IOException -> 0x0039 }
            goto L_0x010c
        L_0x0101:
            if (r1 == 0) goto L_0x0104
            goto L_0x0108
        L_0x0104:
            byte[] r5 = com.itextpdf.text.pdf.PdfEncryption.f()     // Catch:{ IOException -> 0x0039 }
        L_0x0108:
            com.itextpdf.text.pdf.PdfObject r1 = com.itextpdf.text.pdf.PdfEncryption.g(r5, r1)     // Catch:{ IOException -> 0x0039 }
        L_0x010c:
            com.itextpdf.text.pdf.PdfWriter$PdfBody r5 = r15.k3     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.OutputStreamCounter r6 = r15.Y     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfIndirectReference r7 = r0.a()     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfIndirectReference r8 = r4.a()     // Catch:{ IOException -> 0x0039 }
            long r11 = r15.t3     // Catch:{ IOException -> 0x0039 }
            r9 = r3
            r10 = r1
            r5.p(r6, r7, r8, r9, r10, r11)     // Catch:{ IOException -> 0x0039 }
            boolean r2 = r15.B3     // Catch:{ IOException -> 0x0039 }
            if (r2 == 0) goto L_0x0152
            com.itextpdf.text.pdf.OutputStreamCounter r0 = r15.Y     // Catch:{ IOException -> 0x0039 }
            P2(r0)     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.OutputStreamCounter r0 = r15.Y     // Catch:{ IOException -> 0x0039 }
            java.lang.String r1 = "startxref\n"
            byte[] r1 = com.itextpdf.text.DocWriter.E(r1)     // Catch:{ IOException -> 0x0039 }
            r0.write((byte[]) r1)     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.OutputStreamCounter r0 = r15.Y     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfWriter$PdfBody r1 = r15.k3     // Catch:{ IOException -> 0x0039 }
            long r1 = r1.k()     // Catch:{ IOException -> 0x0039 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x0039 }
            byte[] r1 = com.itextpdf.text.DocWriter.E(r1)     // Catch:{ IOException -> 0x0039 }
            r0.write((byte[]) r1)     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.OutputStreamCounter r0 = r15.Y     // Catch:{ IOException -> 0x0039 }
            java.lang.String r1 = "\n%%EOF\n"
            byte[] r1 = com.itextpdf.text.DocWriter.E(r1)     // Catch:{ IOException -> 0x0039 }
            r0.write((byte[]) r1)     // Catch:{ IOException -> 0x0039 }
            goto L_0x0175
        L_0x0152:
            com.itextpdf.text.pdf.PdfWriter$PdfTrailer r2 = new com.itextpdf.text.pdf.PdfWriter$PdfTrailer     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfWriter$PdfBody r5 = r15.k3     // Catch:{ IOException -> 0x0039 }
            int r6 = r5.m()     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfWriter$PdfBody r5 = r15.k3     // Catch:{ IOException -> 0x0039 }
            long r7 = r5.k()     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfIndirectReference r9 = r0.a()     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.PdfIndirectReference r10 = r4.a()     // Catch:{ IOException -> 0x0039 }
            long r13 = r15.t3     // Catch:{ IOException -> 0x0039 }
            r5 = r2
            r11 = r3
            r12 = r1
            r5.<init>(r6, r7, r9, r10, r11, r12, r13)     // Catch:{ IOException -> 0x0039 }
            com.itextpdf.text.pdf.OutputStreamCounter r0 = r15.Y     // Catch:{ IOException -> 0x0039 }
            r2.T(r15, r0)     // Catch:{ IOException -> 0x0039 }
        L_0x0175:
            super.close()
            goto L_0x01b0
        L_0x0179:
            com.itextpdf.text.ExceptionConverter r1 = new com.itextpdf.text.ExceptionConverter     // Catch:{ all -> 0x0036 }
            r1.<init>(r0)     // Catch:{ all -> 0x0036 }
            throw r1     // Catch:{ all -> 0x0036 }
        L_0x017f:
            super.close()
            throw r0
        L_0x0183:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "The page "
            r2.append(r3)
            java.util.ArrayList<com.itextpdf.text.pdf.PdfIndirectReference> r3 = r15.o3
            int r3 = r3.size()
            r2.append(r3)
            java.lang.String r3 = " was requested but the document has only "
            r2.append(r3)
            int r3 = r15.p3
            int r3 = r3 - r1
            r2.append(r3)
            java.lang.String r1 = " pages."
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x01b0:
            com.itextpdf.text.log.Counter r0 = r15.b1()
            com.itextpdf.text.pdf.OutputStreamCounter r1 = r15.Y
            long r1 = r1.b()
            r0.c(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfWriter.close():void");
    }

    public int d() {
        return this.b4;
    }

    public void d0(String str, PdfAction pdfAction) {
        this.h3.c0(str, pdfAction);
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference d1() {
        return A1(this.p3);
    }

    public void d2(PdfTemplate pdfTemplate) throws IOException {
        Object obj;
        Object[] objArr = this.F3.get(pdfTemplate.J3());
        if (objArr != null && (obj = objArr[1]) != null) {
            PdfTemplate pdfTemplate2 = (PdfTemplate) obj;
            if (!(pdfTemplate2.J3() instanceof PRIndirectReference) && pdfTemplate2.O3() == 1) {
                y0(pdfTemplate2.G3(this.C3), pdfTemplate2.J3());
                objArr[1] = null;
            }
        }
    }

    public void e(char c2) {
        this.w3.e(c2);
    }

    public void e0(String str, String str2) {
        f0(str, str2, false);
    }

    public int e1() {
        return this.p3;
    }

    public int e2(int[] iArr) throws DocumentException {
        return this.n3.e(iArr);
    }

    public void f0(String str, String str2, boolean z) {
        d0(str, PdfAction.J1(str2, this, z));
    }

    public PdfDictionary f1() {
        return this.c4;
    }

    /* access modifiers changed from: package-private */
    public void f2() {
        this.i3.L1();
        this.j3.L1();
    }

    public void g0(String str, boolean z) {
        b0(PdfAction.J1(str, this, z));
    }

    public PdfContentByte g1() {
        if (this.Z) {
            return this.i3;
        }
        throw new RuntimeException(MessageLocalization.b("the.document.is.not.open", new Object[0]));
    }

    public void g2() {
        this.r3 = new PdfDictionary();
    }

    public void h(int i2) {
        this.h3.s1(i2);
    }

    /* access modifiers changed from: package-private */
    public void h0(TreeMap<String, PdfDocument.Destination> treeMap) throws IOException {
        for (Map.Entry next : treeMap.entrySet()) {
            String str = (String) next.getKey();
            PdfDocument.Destination destination = (PdfDocument.Destination) next.getValue();
            PdfObject pdfObject = destination.f26185c;
            if (destination.f26184b == null) {
                destination.f26184b = D1();
            }
            if (pdfObject == null) {
                pdfObject = new PdfString("invalid_" + str);
            }
            y0(pdfObject, destination.f26184b);
        }
    }

    public PdfContentByte h1() {
        if (this.Z) {
            return this.j3;
        }
        throw new RuntimeException(MessageLocalization.b("the.document.is.not.open", new Object[0]));
    }

    public void h2(String str, Rectangle rectangle) {
        this.h3.g1(str, rectangle);
    }

    public void i(PdfAction pdfAction) {
        this.h3.n1(pdfAction);
    }

    public void i0(String str, int i2, PdfDestination pdfDestination) {
        PdfDestination pdfDestination2 = new PdfDestination(pdfDestination);
        pdfDestination2.X0(A1(i2));
        this.h3.W0(str, pdfDestination2);
    }

    /* access modifiers changed from: package-private */
    public PdfEncryption i1() {
        return this.A3;
    }

    public void i2(PdfCollection pdfCollection) {
        e(u4);
        this.h3.h1(pdfCollection);
    }

    public void j0(Map<String, String> map, int i2) {
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getValue();
            int parseInt = Integer.parseInt(str.substring(0, str.indexOf(StringUtils.SPACE)));
            i0((String) next.getKey(), parseInt + i2, new PdfDestination(str.substring(str.indexOf(StringUtils.SPACE) + 1)));
        }
    }

    public PdfDictionary j1() {
        if (this.m3 == null) {
            this.m3 = new PdfDictionary();
        }
        return this.m3;
    }

    public void j2(int i2) {
        if (i2 < 0 || i2 > 9) {
            i2 = -1;
        }
        this.C3 = i2;
    }

    public void k0(ArrayList<PdfLayer> arrayList) {
        PdfArray pdfArray = new PdfArray();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            PdfLayer pdfLayer = arrayList.get(i2);
            if (pdfLayer.o1() == null) {
                pdfArray.a0(pdfLayer.g());
            }
        }
        if (pdfArray.size() != 0) {
            this.X3.a0(pdfArray);
        }
    }

    public PdfDictionary k1() {
        return this.Z3;
    }

    public void k2(Rectangle rectangle) {
        this.h3.i1(rectangle);
    }

    public void l(String str) {
        this.h3.o1(str);
    }

    public void l0(PdfName pdfName, PdfObject pdfObject) {
        this.r3.V0(pdfName, pdfObject);
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference l1(PdfName pdfName) {
        return (PdfIndirectReference) this.h4.d0(pdfName);
    }

    public void l2(PdfName pdfName, PdfObject pdfObject) {
        if (pdfObject == null || pdfObject.H()) {
            this.c4.a1(pdfName);
        }
        this.c4.V0(pdfName, pdfObject);
    }

    public void m(Certificate[] certificateArr, int[] iArr, int i2) throws DocumentException {
        if (!this.h3.F()) {
            this.A3 = new PdfEncryption();
            if (certificateArr != null) {
                for (int i6 = 0; i6 < certificateArr.length; i6++) {
                    this.A3.a(certificateArr[i6], iArr[i6]);
                }
            }
            this.A3.t(i2, 0);
            this.A3.l();
            return;
        }
        throw new DocumentException(MessageLocalization.b("encryption.can.only.be.added.before.opening.the.document", new Object[0]));
    }

    /* access modifiers changed from: protected */
    public void m0() throws IOException {
        for (FontDetails k2 : this.D3.values()) {
            k2.k(this);
        }
        B0();
        for (PdfReaderInstance next : this.H3.values()) {
            this.I3 = next;
            next.g();
        }
        this.I3 = null;
        for (ColorDetails next2 : this.J3.values()) {
            y0(next2.c(this), next2.b());
        }
        for (PdfPatternPainter next3 : this.L3.keySet()) {
            y0(next3.d4(this.C3), next3.J3());
        }
        Iterator<PdfShadingPattern> it2 = this.N3.iterator();
        while (it2.hasNext()) {
            it2.next().f1();
        }
        Iterator<PdfShading> it3 = this.O3.iterator();
        while (it3.hasNext()) {
            it3.next().a();
        }
        for (Map.Entry next4 : this.P3.entrySet()) {
            y0((PdfDictionary) next4.getKey(), (PdfIndirectReference) ((PdfObject[]) next4.getValue())[1]);
        }
        for (Map.Entry next5 : this.Q3.entrySet()) {
            Object key = next5.getKey();
            PdfObject[] pdfObjectArr = (PdfObject[]) next5.getValue();
            if (key instanceof PdfLayerMembership) {
                PdfLayerMembership pdfLayerMembership = (PdfLayerMembership) key;
                y0(pdfLayerMembership.c(), pdfLayerMembership.g());
            } else if ((key instanceof PdfDictionary) && !(key instanceof PdfLayer)) {
                y0((PdfDictionary) key, (PdfIndirectReference) pdfObjectArr[1]);
            }
        }
    }

    public PdfImportedPage m1(PdfReader pdfReader, int i2) {
        return E1(pdfReader).b(i2);
    }

    @Deprecated
    public void m2(int i2, String str, String str2, int i6) throws DocumentException {
        r(DocWriter.E(str), DocWriter.E(str2), i6, i2);
    }

    public void n(PdfFormField pdfFormField) {
        this.h3.Y(pdfFormField);
    }

    /* access modifiers changed from: package-private */
    public ColorDetails n0(ICachedColorSpace iCachedColorSpace) {
        ColorDetails colorDetails = this.J3.get(iCachedColorSpace);
        if (colorDetails == null) {
            colorDetails = new ColorDetails(Z0(), this.k3.j(), iCachedColorSpace);
            if (iCachedColorSpace instanceof IPdfSpecialColorSpace) {
                ((IPdfSpecialColorSpace) iCachedColorSpace).a(this);
            }
            this.J3.put(iCachedColorSpace, colorDetails);
        }
        return colorDetails;
    }

    /* access modifiers changed from: protected */
    public int n1() {
        return this.k3.i();
    }

    @Deprecated
    public void n2(boolean z, String str, String str2, int i2) throws DocumentException {
        r(DocWriter.E(str), DocWriter.E(str2), i2, z ? 1 : 0);
    }

    public void o(int i2) {
        if (i2 < 1 || i2 > 3) {
            throw new RuntimeException(MessageLocalization.a("invalid.run.direction.1", i2));
        }
        this.b4 = i2;
    }

    /* access modifiers changed from: package-private */
    public FontDetails o0(BaseFont baseFont) {
        FontDetails fontDetails = this.D3.get(baseFont);
        if (fontDetails == null) {
            G0(this, 4, baseFont);
            if (baseFont.K() == 4) {
                StringBuilder sb = new StringBuilder();
                sb.append("F");
                int i2 = this.E3;
                this.E3 = i2 + 1;
                sb.append(i2);
                fontDetails = new FontDetails(new PdfName(sb.toString()), ((DocumentFont) baseFont).F0(), baseFont);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("F");
                int i6 = this.E3;
                this.E3 = i6 + 1;
                sb2.append(i6);
                fontDetails = new FontDetails(new PdfName(sb2.toString()), this.k3.j(), baseFont);
            }
            this.D3.put(baseFont, fontDetails);
        }
        return fontDetails;
    }

    public PdfDictionary o1() {
        return this.h3.z0();
    }

    @Deprecated
    public void o2(byte[] bArr, byte[] bArr2, int i2, boolean z) throws DocumentException {
        r(bArr, bArr2, i2, z ? 1 : 0);
    }

    public void open() {
        super.open();
        try {
            this.w3.g(this.Y);
            this.k3 = new PdfBody(this);
            if (U1() && ((PdfXConformanceImp) this.z3).g()) {
                PdfDictionary pdfDictionary = new PdfDictionary();
                pdfDictionary.V0(PdfName.H8, new PdfArray(new float[]{2.2f, 2.2f, 2.2f}));
                pdfDictionary.V0(PdfName.Qa, new PdfArray(new float[]{0.4124f, 0.2126f, 0.0193f, 0.3576f, 0.7152f, 0.1192f, 0.1805f, 0.0722f, 0.9505f}));
                pdfDictionary.V0(PdfName.Qh, new PdfArray(new float[]{0.9505f, 1.0f, 1.089f}));
                PdfArray pdfArray = new PdfArray((PdfObject) PdfName.Q4);
                pdfArray.a0(pdfDictionary);
                l2(PdfName.t6, v0(pdfArray).a());
            }
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public void p(PdfName pdfName, PdfAction pdfAction) throws DocumentException {
        if (pdfName.equals(a5) || pdfName.equals(b5) || pdfName.equals(c5) || pdfName.equals(d5) || pdfName.equals(e5)) {
            this.h3.W(pdfName, pdfAction);
        } else {
            throw new DocumentException(MessageLocalization.b("invalid.additional.action.type.1", pdfName.toString()));
        }
    }

    /* access modifiers changed from: package-private */
    public PdfObject[] p0(PdfDictionary pdfDictionary) {
        if (!this.P3.containsKey(pdfDictionary)) {
            HashMap<PdfDictionary, PdfObject[]> hashMap = this.P3;
            hashMap.put(pdfDictionary, new PdfObject[]{new PdfName("GS" + (this.P3.size() + 1)), D1()});
        }
        return this.P3.get(pdfDictionary);
    }

    public void p2() throws DocumentException {
        if (!this.Z) {
            this.B3 = true;
            e(s4);
            return;
        }
        throw new DocumentException(MessageLocalization.b("you.can.t.set.the.full.compression.if.the.document.is.already.open", new Object[0]));
    }

    public void q(char c2) {
        this.w3.q(c2);
    }

    /* access modifiers changed from: package-private */
    public PdfName q0(PdfPatternPainter pdfPatternPainter) {
        PdfName pdfName = this.L3.get(pdfPatternPainter);
        if (pdfName != null) {
            return pdfName;
        }
        try {
            PdfName pdfName2 = new PdfName("P" + this.M3);
            this.M3 = this.M3 + 1;
            this.L3.put(pdfPatternPainter, pdfName2);
            return pdfName2;
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public void q2(PdfDictionary pdfDictionary) {
        this.Z3 = pdfDictionary;
    }

    public void r(byte[] bArr, byte[] bArr2, int i2, int i6) throws DocumentException {
        if (!this.h3.F()) {
            PdfEncryption pdfEncryption = new PdfEncryption();
            this.A3 = pdfEncryption;
            pdfEncryption.t(i6, 0);
            this.A3.w(bArr, bArr2, i2);
            return;
        }
        throw new DocumentException(MessageLocalization.b("encryption.can.only.be.added.before.opening.the.document", new Object[0]));
    }

    /* access modifiers changed from: package-private */
    public ColorDetails r0(BaseColor baseColor) {
        int k2 = ExtendedColor.k(baseColor);
        if (k2 == 4 || k2 == 5) {
            throw new RuntimeException(MessageLocalization.b("an.uncolored.tile.pattern.can.not.have.another.pattern.or.shading.as.color", new Object[0]));
        } else if (k2 == 0) {
            if (this.e4 == null) {
                this.e4 = new ColorDetails(Z0(), this.k3.j(), (ICachedColorSpace) null);
                PdfArray pdfArray = new PdfArray((PdfObject) PdfName.Ic);
                pdfArray.a0(PdfName.B6);
                y0(pdfArray, this.e4.b());
            }
            return this.e4;
        } else if (k2 == 1) {
            if (this.f4 == null) {
                this.f4 = new ColorDetails(Z0(), this.k3.j(), (ICachedColorSpace) null);
                PdfArray pdfArray2 = new PdfArray((PdfObject) PdfName.Ic);
                pdfArray2.a0(PdfName.A6);
                y0(pdfArray2, this.f4.b());
            }
            return this.f4;
        } else if (k2 == 2) {
            if (this.g4 == null) {
                this.g4 = new ColorDetails(Z0(), this.k3.j(), (ICachedColorSpace) null);
                PdfArray pdfArray3 = new PdfArray((PdfObject) PdfName.Ic);
                pdfArray3.a0(PdfName.C6);
                y0(pdfArray3, this.g4.b());
            }
            return this.g4;
        } else if (k2 == 3) {
            try {
                ColorDetails n0 = n0(((SpotColor) baseColor).m());
                ColorDetails colorDetails = this.d4.get(n0);
                if (colorDetails != null) {
                    return colorDetails;
                }
                ColorDetails colorDetails2 = new ColorDetails(Z0(), this.k3.j(), (ICachedColorSpace) null);
                PdfArray pdfArray4 = new PdfArray((PdfObject) PdfName.Ic);
                pdfArray4.a0(n0.b());
                y0(pdfArray4, colorDetails2.b());
                this.d4.put(n0, colorDetails2);
                return colorDetails2;
            } catch (Exception e2) {
                throw new RuntimeException(e2.getMessage());
            }
        } else {
            throw new RuntimeException(MessageLocalization.b("invalid.color.type", new Object[0]));
        }
    }

    public void r2(float f2) throws DocumentException {
        if (!this.Z) {
            this.h3.l1(f2);
            return;
        }
        throw new DocumentException(MessageLocalization.b("you.can.t.set.the.initial.leading.if.the.document.is.already.open", new Object[0]));
    }

    /* access modifiers changed from: package-private */
    public PdfObject[] s0(Object obj, PdfIndirectReference pdfIndirectReference) {
        if (!this.Q3.containsKey(obj)) {
            if (obj instanceof PdfOCG) {
                G0(this, 7, obj);
            }
            HashMap<Object, PdfObject[]> hashMap = this.Q3;
            hashMap.put(obj, new PdfObject[]{new PdfName("Pr" + (this.Q3.size() + 1)), pdfIndirectReference});
        }
        return this.Q3.get(obj);
    }

    /* access modifiers changed from: protected */
    public int s1(PdfReader pdfReader, int i2, int i6) {
        PdfReaderInstance pdfReaderInstance = this.I3;
        if (pdfReaderInstance == null || pdfReaderInstance.d() != pdfReader) {
            this.I3 = E1(pdfReader);
        }
        return this.I3.c(i2, i6);
    }

    public void s2(String str) {
        this.h3.k1(str);
    }

    /* access modifiers changed from: package-private */
    public void t0(PdfShading pdfShading) {
        if (!this.O3.contains(pdfShading)) {
            this.O3.add(pdfShading);
            pdfShading.n(this.O3.size());
        }
    }

    public void t2() {
        this.n3.f((PdfIndirectReference) null);
    }

    public void u(PdfAnnotation pdfAnnotation) {
        this.h3.X(pdfAnnotation);
    }

    /* access modifiers changed from: package-private */
    public void u0(PdfShadingPattern pdfShadingPattern) {
        if (!this.N3.contains(pdfShadingPattern)) {
            pdfShadingPattern.w1(this.M3);
            this.M3++;
            this.N3.add(pdfShadingPattern);
            t0(pdfShadingPattern.p1());
        }
    }

    public PdfOCProperties u1() {
        R0(true);
        return this.W3;
    }

    public void u2(List<HashMap<String, Object>> list) {
        this.v3 = list;
    }

    public void v(PdfName pdfName, PdfObject pdfObject) {
        this.h3.h0(pdfName, pdfObject);
    }

    public PdfIndirectObject v0(PdfObject pdfObject) throws IOException {
        PdfIndirectObject a2 = this.k3.a(pdfObject);
        D0(a2);
        return a2;
    }

    public OutputStreamCounter v1() {
        return this.Y;
    }

    public void v2(String str, String str2, String str3, String str4, ICC_Profile iCC_Profile) throws IOException {
        G0(this, 19, iCC_Profile);
        j1();
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.qc);
        if (str2 != null) {
            pdfDictionary.V0(PdfName.oc, new PdfString(str2, PdfObject.h3));
        }
        if (str != null) {
            pdfDictionary.V0(PdfName.pc, new PdfString(str, PdfObject.h3));
        }
        if (str3 != null) {
            pdfDictionary.V0(PdfName.Rd, new PdfString(str3, PdfObject.h3));
        }
        if (str4 != null) {
            pdfDictionary.V0(PdfName.O9, new PdfString(str4, PdfObject.h3));
        }
        if (iCC_Profile != null) {
            pdfDictionary.V0(PdfName.y6, v0(new PdfICCBased(iCC_Profile, this.C3)).a());
        }
        pdfDictionary.V0(PdfName.Ce, PdfName.U8);
        this.m3.V0(PdfName.rc, new PdfArray((PdfObject) pdfDictionary));
        this.l3 = iCC_Profile;
    }

    public void w(PdfDeveloperExtension pdfDeveloperExtension) {
        this.w3.w(pdfDeveloperExtension);
    }

    public PdfIndirectObject w0(PdfObject pdfObject, int i2) throws IOException {
        PdfIndirectObject b2 = this.k3.b(pdfObject, i2);
        D0(b2);
        return b2;
    }

    public int w1() {
        PdfIsoConformance pdfIsoConformance = this.z3;
        if (pdfIsoConformance instanceof PdfXConformanceImp) {
            return ((PdfXConformance) pdfIsoConformance).e();
        }
        return 0;
    }

    public void w2(String str, String str2, String str3, String str4, byte[] bArr) throws IOException {
        v2(str, str2, str3, str4, bArr == null ? null : ICC_Profile.d(bArr));
    }

    public void x(PdfName pdfName) {
        this.w3.x(pdfName);
    }

    public PdfIndirectObject x0(PdfObject pdfObject, int i2, boolean z) throws IOException {
        PdfIndirectObject c2 = this.k3.c(pdfObject, i2, 0, z);
        D0(c2);
        return c2;
    }

    public PdfDictionary x1() {
        return this.r3;
    }

    public boolean x2(PdfReader pdfReader, boolean z) throws IOException {
        PdfArray e0 = pdfReader.F().e0(PdfName.rc);
        boolean z2 = false;
        if (e0 == null || e0.isEmpty()) {
            return false;
        }
        PdfDictionary B0 = e0.B0(0);
        PdfObject t0 = PdfReader.t0(B0.d0(PdfName.Ce));
        if (t0 != null && PdfName.U8.equals(t0)) {
            z2 = true;
            if (z) {
                return true;
            }
            PRStream pRStream = (PRStream) PdfReader.t0(B0.d0(PdfName.y6));
            w2(r1(B0, PdfName.pc), r1(B0, PdfName.oc), r1(B0, PdfName.Rd), r1(B0, PdfName.O9), pRStream != null ? PdfReader.D0(pRStream) : null);
        }
        return z2;
    }

    public void y(int i2) {
        this.h3.j1(i2);
    }

    public PdfIndirectObject y0(PdfObject pdfObject, PdfIndirectReference pdfIndirectReference) throws IOException {
        PdfIndirectObject d2 = this.k3.d(pdfObject, pdfIndirectReference);
        D0(d2);
        return d2;
    }

    public PdfPageEvent y1() {
        return this.s3;
    }

    public void y2(int i2) {
        PdfIsoConformance pdfIsoConformance = this.z3;
        if (!(pdfIsoConformance instanceof PdfXConformanceImp) || ((PdfXConformance) pdfIsoConformance).e() == i2) {
            return;
        }
        if (this.h3.F()) {
            throw new PdfXConformanceException(MessageLocalization.b("pdfx.conformance.can.only.be.set.before.opening.the.document", new Object[0]));
        } else if (this.A3 == null) {
            if (i2 != 0) {
                q(q4);
            }
            ((PdfXConformance) this.z3).c(i2);
        } else {
            throw new PdfXConformanceException(MessageLocalization.b("a.pdfx.conforming.document.cannot.be.encrypted", new Object[0]));
        }
    }

    public void z(PdfName pdfName, PdfAction pdfAction) throws DocumentException {
        if (pdfName.equals(L5) || pdfName.equals(M5)) {
            this.h3.p1(pdfName, pdfAction);
        } else {
            throw new DocumentException(MessageLocalization.b("invalid.page.additional.action.type.1", pdfName.toString()));
        }
    }

    public PdfIndirectObject z0(PdfObject pdfObject, PdfIndirectReference pdfIndirectReference, boolean z) throws IOException {
        PdfIndirectObject e2 = this.k3.e(pdfObject, pdfIndirectReference, z);
        D0(e2);
        return e2;
    }

    public int z1() {
        return this.h3.B();
    }

    public void z2(boolean z) {
        if (!z) {
            this.h3.q1(z);
        }
    }

    protected PdfWriter(PdfDocument pdfDocument, OutputStream outputStream) {
        super(pdfDocument, outputStream);
        this.h3 = pdfDocument;
        PdfContentByte pdfContentByte = new PdfContentByte(this);
        this.j3 = pdfContentByte;
        this.i3 = pdfContentByte.U0();
    }
}
