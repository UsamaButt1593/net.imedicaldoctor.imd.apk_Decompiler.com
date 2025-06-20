package com.itextpdf.text.pdf;

import at.grabner.circleprogress.BuildConfig;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Version;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.io.RASInputStream;
import com.itextpdf.text.io.RandomAccessSource;
import com.itextpdf.text.io.RandomAccessSourceFactory;
import com.itextpdf.text.pdf.security.SecurityConstants;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.security.cert.Certificate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

public class PdfSignatureAppearance {
    public static final int N = 0;
    public static final int O = 1;
    public static final int P = 2;
    public static final int Q = 3;
    public static final String R = "% DSUnknown\nq\n1 G\n1 g\n0.1 0 0 0.1 9 0 cm\n0 J 0 j 4 M []0 d\n1 i \n0 g\n313 292 m\n313 404 325 453 432 529 c\n478 561 504 597 504 645 c\n504 736 440 760 391 760 c\n286 760 271 681 265 626 c\n265 625 l\n100 625 l\n100 828 253 898 381 898 c\n451 898 679 878 679 650 c\n679 555 628 499 538 435 c\n488 399 467 376 467 292 c\n313 292 l\nh\n308 214 170 -164 re\nf\n0.44 G\n1.2 w\n1 1 0.4 rg\n287 318 m\n287 430 299 479 406 555 c\n451 587 478 623 478 671 c\n478 762 414 786 365 786 c\n260 786 245 707 239 652 c\n239 651 l\n74 651 l\n74 854 227 924 355 924 c\n425 924 653 904 653 676 c\n653 581 602 525 512 461 c\n462 425 441 402 441 318 c\n287 318 l\nh\n282 240 170 -164 re\nB\nQ\n";
    private static final float S = 0.3f;
    private static final float T = 2.0f;
    private Font A;
    private int B = 1;
    private String C;
    private PdfTemplate D;
    private PdfStamper E;
    private PdfStamperImp F;
    private ByteBuffer G;
    private OutputStream H;
    private File I;
    private HashMap<PdfName, PdfLiteral> J;
    private int K;
    private boolean L = false;
    private PdfSigLockDictionary M;

    /* renamed from: a  reason: collision with root package name */
    private int f26312a = 0;

    /* renamed from: b  reason: collision with root package name */
    private String f26313b = "Reason: ";

    /* renamed from: c  reason: collision with root package name */
    private String f26314c = "Location: ";

    /* renamed from: d  reason: collision with root package name */
    private String f26315d;

    /* renamed from: e  reason: collision with root package name */
    private String f26316e;

    /* renamed from: f  reason: collision with root package name */
    private Calendar f26317f;

    /* renamed from: g  reason: collision with root package name */
    private String f26318g;

    /* renamed from: h  reason: collision with root package name */
    private String f26319h;

    /* renamed from: i  reason: collision with root package name */
    private RandomAccessFile f26320i;

    /* renamed from: j  reason: collision with root package name */
    private byte[] f26321j;

    /* renamed from: k  reason: collision with root package name */
    private long[] f26322k;

    /* renamed from: l  reason: collision with root package name */
    private Certificate f26323l;

    /* renamed from: m  reason: collision with root package name */
    private PdfDictionary f26324m;

    /* renamed from: n  reason: collision with root package name */
    private SignatureEvent f26325n;
    private String o;
    private int p = 1;
    private Rectangle q;
    private Rectangle r;
    private RenderingMode s = RenderingMode.DESCRIPTION;
    private Image t = null;
    private boolean u = true;
    private PdfTemplate[] v = new PdfTemplate[5];
    private boolean w = false;
    private Image x;
    private float y;
    private String z;

    /* renamed from: com.itextpdf.text.pdf.PdfSignatureAppearance$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f26326a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.itextpdf.text.pdf.PdfSignatureAppearance$RenderingMode[] r0 = com.itextpdf.text.pdf.PdfSignatureAppearance.RenderingMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f26326a = r0
                com.itextpdf.text.pdf.PdfSignatureAppearance$RenderingMode r1 = com.itextpdf.text.pdf.PdfSignatureAppearance.RenderingMode.NAME_AND_DESCRIPTION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f26326a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.itextpdf.text.pdf.PdfSignatureAppearance$RenderingMode r1 = com.itextpdf.text.pdf.PdfSignatureAppearance.RenderingMode.GRAPHIC_AND_DESCRIPTION     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f26326a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.itextpdf.text.pdf.PdfSignatureAppearance$RenderingMode r1 = com.itextpdf.text.pdf.PdfSignatureAppearance.RenderingMode.GRAPHIC     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfSignatureAppearance.AnonymousClass1.<clinit>():void");
        }
    }

    public enum RenderingMode {
        DESCRIPTION,
        NAME_AND_DESCRIPTION,
        GRAPHIC_AND_DESCRIPTION,
        GRAPHIC
    }

    public interface SignatureEvent {
        void a(PdfDictionary pdfDictionary);
    }

    PdfSignatureAppearance(PdfStamperImp pdfStamperImp) {
        this.F = pdfStamperImp;
        this.f26317f = new GregorianCalendar();
        this.o = t();
        this.f26318g = Version.a().e();
    }

    private RandomAccessSource K() throws IOException {
        RandomAccessSourceFactory randomAccessSourceFactory = new RandomAccessSourceFactory();
        RandomAccessFile randomAccessFile = this.f26320i;
        return randomAccessFile == null ? randomAccessSourceFactory.j(this.f26321j) : randomAccessSourceFactory.h(randomAccessFile);
    }

    private void b(PdfDictionary pdfDictionary) {
        PdfDictionary pdfDictionary2 = new PdfDictionary();
        PdfDictionary pdfDictionary3 = new PdfDictionary();
        pdfDictionary3.V0(PdfName.tc, new PdfNumber(this.f26312a));
        pdfDictionary3.V0(PdfName.kh, new PdfName(BuildConfig.f16618f));
        PdfName pdfName = PdfName.Kg;
        PdfName pdfName2 = PdfName.tg;
        pdfDictionary3.V0(pdfName, pdfName2);
        pdfDictionary2.V0(PdfName.ug, PdfName.M6);
        pdfDictionary2.V0(pdfName, PdfName.Se);
        pdfDictionary2.V0(pdfName2, pdfDictionary3);
        if (this.F.F1().b() < '6') {
            pdfDictionary2.V0(new PdfName(SecurityConstants.q), new PdfString("aa"));
            PdfArray pdfArray = new PdfArray();
            pdfArray.a0(new PdfNumber(0));
            pdfArray.a0(new PdfNumber(0));
            pdfDictionary2.V0(new PdfName("DigestLocation"), pdfArray);
            pdfDictionary2.V0(new PdfName(SecurityConstants.p), new PdfName("MD5"));
        }
        pdfDictionary2.V0(PdfName.h6, this.F.Y5.I0().d0(PdfName.se));
        PdfArray pdfArray2 = new PdfArray();
        pdfArray2.a0(pdfDictionary2);
        pdfDictionary.V0(PdfName.Pd, pdfArray2);
    }

    private void c(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2) {
        PdfDictionary pdfDictionary3 = new PdfDictionary();
        PdfDictionary pdfDictionary4 = new PdfDictionary();
        pdfDictionary4.X0(pdfDictionary2);
        PdfName pdfName = PdfName.Kg;
        PdfName pdfName2 = PdfName.tg;
        pdfDictionary4.V0(pdfName, pdfName2);
        pdfDictionary4.V0(PdfName.kh, new PdfName(BuildConfig.f16618f));
        pdfDictionary3.V0(PdfName.ug, PdfName.O7);
        pdfDictionary3.V0(pdfName, PdfName.Se);
        pdfDictionary3.V0(pdfName2, pdfDictionary4);
        pdfDictionary3.V0(new PdfName(SecurityConstants.q), new PdfString("aa"));
        PdfArray pdfArray = new PdfArray();
        pdfArray.a0(new PdfNumber(0));
        pdfArray.a0(new PdfNumber(0));
        pdfDictionary3.V0(new PdfName("DigestLocation"), pdfArray);
        pdfDictionary3.V0(new PdfName(SecurityConstants.p), new PdfName("MD5"));
        pdfDictionary3.V0(PdfName.h6, this.F.Y5.I0().d0(PdfName.se));
        PdfName pdfName3 = PdfName.Pd;
        PdfArray e0 = pdfDictionary.e0(pdfName3);
        if (e0 == null) {
            e0 = new PdfArray();
        }
        e0.a0(pdfDictionary3);
        pdfDictionary.V0(pdfName3, e0);
    }

    private void e() {
        PdfTemplate[] pdfTemplateArr = this.v;
        PdfTemplate pdfTemplate = new PdfTemplate(this.F);
        pdfTemplateArr[0] = pdfTemplate;
        pdfTemplate.S3(new Rectangle(100.0f, 100.0f));
        this.F.X(pdfTemplate, new PdfName("n0"));
        pdfTemplate.M2("% DSBlank\n");
    }

    public RenderingMode A() {
        return this.s;
    }

    public int B() {
        return this.B;
    }

    public Calendar C() {
        return this.f26317f;
    }

    public String D() {
        return this.f26318g;
    }

    public SignatureEvent E() {
        return this.f26325n;
    }

    public Image F() {
        return this.t;
    }

    /* access modifiers changed from: package-private */
    public ByteBuffer G() {
        return this.G;
    }

    public PdfStamper H() {
        return this.E;
    }

    public File I() {
        return this.I;
    }

    public PdfTemplate J() {
        if (this.D == null) {
            PdfTemplate pdfTemplate = new PdfTemplate(this.F);
            this.D = pdfTemplate;
            pdfTemplate.S3(this.q);
            this.F.X(this.D, new PdfName("FRM"));
        }
        return this.D;
    }

    public boolean L() {
        return this.u;
    }

    public boolean M() {
        Rectangle rectangle = this.q;
        return rectangle == null || rectangle.a0() == 0.0f || this.q.N() == 0.0f;
    }

    public boolean N() {
        return this.L;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:63|64|66|67|68|69|70) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x02a3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void O(java.util.HashMap<com.itextpdf.text.pdf.PdfName, java.lang.Integer> r14) throws java.io.IOException, com.itextpdf.text.DocumentException {
        /*
            r13 = this;
            boolean r0 = r13.L
            r1 = 0
            if (r0 != 0) goto L_0x02b1
            com.itextpdf.text.pdf.PdfStamper r0 = r13.E
            r0.L()
            r0 = 1
            r13.L = r0
            com.itextpdf.text.pdf.PdfStamperImp r2 = r13.F
            com.itextpdf.text.pdf.AcroFields r2 = r2.l3()
            java.lang.String r3 = r13.l()
            boolean r4 = r2.f(r3)
            com.itextpdf.text.pdf.PdfStamperImp r5 = r13.F
            com.itextpdf.text.pdf.PdfIndirectReference r5 = r5.D1()
            com.itextpdf.text.pdf.PdfStamperImp r6 = r13.F
            r7 = 3
            r6.h(r7)
            if (r4 == 0) goto L_0x00a1
            com.itextpdf.text.pdf.AcroFields$Item r2 = r2.p(r3)
            com.itextpdf.text.pdf.PdfDictionary r2 = r2.l(r1)
            com.itextpdf.text.pdf.PdfStamperImp r3 = r13.F
            r3.z3(r2)
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.Ha
            com.itextpdf.text.pdf.PdfDictionary r4 = r2.j0(r3)
            if (r4 != 0) goto L_0x0051
            com.itextpdf.text.pdf.PdfSigLockDictionary r6 = r13.M
            if (r6 == 0) goto L_0x0051
            com.itextpdf.text.pdf.PdfStamperImp r4 = r13.F
            com.itextpdf.text.pdf.PdfIndirectObject r4 = r4.v0(r6)
            com.itextpdf.text.pdf.PdfIndirectReference r4 = r4.a()
            r2.V0(r3, r4)
            com.itextpdf.text.pdf.PdfSigLockDictionary r4 = r13.M
        L_0x0051:
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.tc
            com.itextpdf.text.pdf.PdfStamperImp r6 = r13.F
            int r8 = r13.v()
            com.itextpdf.text.pdf.PdfIndirectReference r6 = r6.A1(r8)
            r2.V0(r3, r6)
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.kh
            r2.V0(r3, r5)
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.F7
            com.itextpdf.text.pdf.PdfObject r6 = r2.d0(r3)
            com.itextpdf.text.pdf.PdfObject r6 = com.itextpdf.text.pdf.PdfReader.w0(r6)
            if (r6 == 0) goto L_0x007e
            boolean r8 = r6.I()
            if (r8 == 0) goto L_0x007e
            com.itextpdf.text.pdf.PdfNumber r6 = (com.itextpdf.text.pdf.PdfNumber) r6
            int r6 = r6.e0()
            goto L_0x007f
        L_0x007e:
            r6 = 0
        L_0x007f:
            r6 = r6 | 128(0x80, float:1.794E-43)
            com.itextpdf.text.pdf.PdfNumber r8 = new com.itextpdf.text.pdf.PdfNumber
            r8.<init>((int) r6)
            r2.V0(r3, r8)
            com.itextpdf.text.pdf.PdfDictionary r3 = new com.itextpdf.text.pdf.PdfDictionary
            r3.<init>()
            com.itextpdf.text.pdf.PdfName r6 = com.itextpdf.text.pdf.PdfName.kb
            com.itextpdf.text.pdf.PdfTemplate r8 = r13.f()
            com.itextpdf.text.pdf.PdfIndirectReference r8 = r8.J3()
            r3.V0(r6, r8)
            com.itextpdf.text.pdf.PdfName r6 = com.itextpdf.text.pdf.PdfName.S3
            r2.V0(r6, r3)
            goto L_0x00f7
        L_0x00a1:
            com.itextpdf.text.pdf.PdfStamperImp r2 = r13.F
            com.itextpdf.text.pdf.PdfFormField r2 = com.itextpdf.text.pdf.PdfFormField.X2(r2)
            r2.j3(r3)
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.kh
            r2.V0(r3, r5)
            r3 = 132(0x84, float:1.85E-43)
            r2.n2(r3)
            com.itextpdf.text.pdf.PdfSigLockDictionary r3 = r13.M
            r4 = 0
            if (r3 == 0) goto L_0x00cb
            com.itextpdf.text.pdf.PdfName r6 = com.itextpdf.text.pdf.PdfName.Ha
            com.itextpdf.text.pdf.PdfStamperImp r8 = r13.F
            com.itextpdf.text.pdf.PdfIndirectObject r3 = r8.v0(r3)
            com.itextpdf.text.pdf.PdfIndirectReference r3 = r3.a()
            r2.V0(r6, r3)
            com.itextpdf.text.pdf.PdfSigLockDictionary r3 = r13.M
            goto L_0x00cc
        L_0x00cb:
            r3 = r4
        L_0x00cc:
            int r6 = r13.v()
            boolean r8 = r13.M()
            if (r8 != 0) goto L_0x00de
            com.itextpdf.text.Rectangle r8 = r13.w()
        L_0x00da:
            r2.r3(r8, r4)
            goto L_0x00e5
        L_0x00de:
            com.itextpdf.text.Rectangle r8 = new com.itextpdf.text.Rectangle
            r9 = 0
            r8.<init>(r9, r9)
            goto L_0x00da
        L_0x00e5:
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfAnnotation.O3
            com.itextpdf.text.pdf.PdfTemplate r8 = r13.f()
            r2.c2(r4, r8)
            r2.E2(r6)
            com.itextpdf.text.pdf.PdfStamperImp r4 = r13.F
            r4.U(r2, r6)
            r4 = r3
        L_0x00f7:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r13.J = r2
            com.itextpdf.text.pdf.PdfDictionary r2 = r13.f26324m
            if (r2 == 0) goto L_0x02a9
            com.itextpdf.text.pdf.PdfLiteral r2 = new com.itextpdf.text.pdf.PdfLiteral
            r3 = 80
            r2.<init>((int) r3)
            java.util.HashMap<com.itextpdf.text.pdf.PdfName, com.itextpdf.text.pdf.PdfLiteral> r3 = r13.J
            com.itextpdf.text.pdf.PdfName r6 = com.itextpdf.text.pdf.PdfName.J4
            r3.put(r6, r2)
            com.itextpdf.text.pdf.PdfDictionary r3 = r13.f26324m
            r3.V0(r6, r2)
            java.util.Set r14 = r14.entrySet()
            java.util.Iterator r14 = r14.iterator()
        L_0x011d:
            boolean r2 = r14.hasNext()
            if (r2 == 0) goto L_0x0149
            java.lang.Object r2 = r14.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            com.itextpdf.text.pdf.PdfName r3 = (com.itextpdf.text.pdf.PdfName) r3
            java.lang.Object r2 = r2.getValue()
            java.lang.Integer r2 = (java.lang.Integer) r2
            com.itextpdf.text.pdf.PdfLiteral r6 = new com.itextpdf.text.pdf.PdfLiteral
            int r2 = r2.intValue()
            r6.<init>((int) r2)
            java.util.HashMap<com.itextpdf.text.pdf.PdfName, com.itextpdf.text.pdf.PdfLiteral> r2 = r13.J
            r2.put(r3, r6)
            com.itextpdf.text.pdf.PdfDictionary r2 = r13.f26324m
            r2.V0(r3, r6)
            goto L_0x011d
        L_0x0149:
            int r14 = r13.f26312a
            if (r14 <= 0) goto L_0x0152
            com.itextpdf.text.pdf.PdfDictionary r14 = r13.f26324m
            r13.b(r14)
        L_0x0152:
            if (r4 == 0) goto L_0x0159
            com.itextpdf.text.pdf.PdfDictionary r14 = r13.f26324m
            r13.c(r14, r4)
        L_0x0159:
            com.itextpdf.text.pdf.PdfSignatureAppearance$SignatureEvent r14 = r13.f26325n
            if (r14 == 0) goto L_0x0162
            com.itextpdf.text.pdf.PdfDictionary r2 = r13.f26324m
            r14.a(r2)
        L_0x0162:
            com.itextpdf.text.pdf.PdfStamperImp r14 = r13.F
            com.itextpdf.text.pdf.PdfDictionary r2 = r13.f26324m
            r14.z0(r2, r5, r1)
            int r14 = r13.f26312a
            if (r14 <= 0) goto L_0x018e
            com.itextpdf.text.pdf.PdfDictionary r14 = new com.itextpdf.text.pdf.PdfDictionary
            r14.<init>()
            com.itextpdf.text.pdf.PdfName r2 = new com.itextpdf.text.pdf.PdfName
            java.lang.String r3 = "DocMDP"
            r2.<init>((java.lang.String) r3)
            r14.V0(r2, r5)
            com.itextpdf.text.pdf.PdfStamperImp r2 = r13.F
            com.itextpdf.text.pdf.PdfReader r2 = r2.Y5
            com.itextpdf.text.pdf.PdfDictionary r2 = r2.F()
            com.itextpdf.text.pdf.PdfName r3 = new com.itextpdf.text.pdf.PdfName
            java.lang.String r4 = "Perms"
            r3.<init>((java.lang.String) r4)
            r2.V0(r3, r14)
        L_0x018e:
            com.itextpdf.text.pdf.PdfStamperImp r14 = r13.F
            com.itextpdf.text.pdf.PdfStamper r2 = r13.E
            java.util.Map r2 = r2.w()
            r14.b3(r2)
            java.util.HashMap<com.itextpdf.text.pdf.PdfName, com.itextpdf.text.pdf.PdfLiteral> r14 = r13.J
            int r14 = r14.size()
            int r14 = r14 * 2
            long[] r14 = new long[r14]
            r13.f26322k = r14
            java.util.HashMap<com.itextpdf.text.pdf.PdfName, com.itextpdf.text.pdf.PdfLiteral> r14 = r13.J
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.J4
            java.lang.Object r14 = r14.get(r2)
            com.itextpdf.text.pdf.PdfLiteral r14 = (com.itextpdf.text.pdf.PdfLiteral) r14
            long r3 = r14.a0()
            java.util.HashMap<com.itextpdf.text.pdf.PdfName, com.itextpdf.text.pdf.PdfLiteral> r14 = r13.J
            r14.remove(r2)
            java.util.HashMap<com.itextpdf.text.pdf.PdfName, com.itextpdf.text.pdf.PdfLiteral> r14 = r13.J
            java.util.Collection r14 = r14.values()
            java.util.Iterator r14 = r14.iterator()
            r2 = 1
        L_0x01c3:
            boolean r5 = r14.hasNext()
            if (r5 == 0) goto L_0x01e4
            java.lang.Object r5 = r14.next()
            com.itextpdf.text.pdf.PdfLiteral r5 = (com.itextpdf.text.pdf.PdfLiteral) r5
            long r8 = r5.a0()
            long[] r6 = r13.f26322k
            int r10 = r2 + 1
            r6[r2] = r8
            int r2 = r2 + 2
            int r5 = r5.Z()
            long r11 = (long) r5
            long r11 = r11 + r8
            r6[r10] = r11
            goto L_0x01c3
        L_0x01e4:
            long[] r14 = r13.f26322k
            int r2 = r14.length
            int r2 = r2 - r0
            java.util.Arrays.sort(r14, r0, r2)
        L_0x01eb:
            long[] r14 = r13.f26322k
            int r2 = r14.length
            int r2 = r2 + -2
            if (r7 >= r2) goto L_0x01fe
            r5 = r14[r7]
            int r2 = r7 + -1
            r8 = r14[r2]
            long r5 = r5 - r8
            r14[r7] = r5
            int r7 = r7 + 2
            goto L_0x01eb
        L_0x01fe:
            java.io.File r14 = r13.I
            r2 = 93
            r5 = 32
            r6 = 91
            if (r14 != 0) goto L_0x0251
            com.itextpdf.text.pdf.ByteBuffer r14 = r13.G
            byte[] r14 = r14.w()
            r13.f26321j = r14
            com.itextpdf.text.pdf.ByteBuffer r14 = r13.G
            int r14 = r14.C()
            r13.K = r14
            long[] r7 = r13.f26322k
            int r8 = r7.length
            int r8 = r8 - r0
            long r9 = (long) r14
            int r14 = r7.length
            int r14 = r14 + -2
            r11 = r7[r14]
            long r9 = r9 - r11
            r7[r8] = r9
            com.itextpdf.text.pdf.ByteBuffer r14 = new com.itextpdf.text.pdf.ByteBuffer
            r14.<init>()
            r14.c(r6)
            r0 = 0
        L_0x022e:
            long[] r6 = r13.f26322k
            int r7 = r6.length
            if (r0 >= r7) goto L_0x023f
            r7 = r6[r0]
            com.itextpdf.text.pdf.ByteBuffer r6 = r14.h(r7)
            r6.c(r5)
            int r0 = r0 + 1
            goto L_0x022e
        L_0x023f:
            r14.c(r2)
            byte[] r0 = r14.w()
            byte[] r2 = r13.f26321j
            int r4 = (int) r3
            int r14 = r14.C()
            java.lang.System.arraycopy(r0, r1, r2, r4, r14)
            goto L_0x029d
        L_0x0251:
            java.io.RandomAccessFile r14 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x0286 }
            java.io.File r7 = r13.I     // Catch:{ IOException -> 0x0286 }
            java.lang.String r8 = "rw"
            r14.<init>(r7, r8)     // Catch:{ IOException -> 0x0286 }
            r13.f26320i = r14     // Catch:{ IOException -> 0x0286 }
            long r7 = r14.length()     // Catch:{ IOException -> 0x0286 }
            long[] r14 = r13.f26322k     // Catch:{ IOException -> 0x0286 }
            int r9 = r14.length     // Catch:{ IOException -> 0x0286 }
            int r9 = r9 - r0
            int r0 = r14.length     // Catch:{ IOException -> 0x0286 }
            int r0 = r0 + -2
            r10 = r14[r0]     // Catch:{ IOException -> 0x0286 }
            long r7 = r7 - r10
            r14[r9] = r7     // Catch:{ IOException -> 0x0286 }
            com.itextpdf.text.pdf.ByteBuffer r14 = new com.itextpdf.text.pdf.ByteBuffer     // Catch:{ IOException -> 0x0286 }
            r14.<init>()     // Catch:{ IOException -> 0x0286 }
            r14.c(r6)     // Catch:{ IOException -> 0x0286 }
            r0 = 0
        L_0x0275:
            long[] r6 = r13.f26322k     // Catch:{ IOException -> 0x0286 }
            int r7 = r6.length     // Catch:{ IOException -> 0x0286 }
            if (r0 >= r7) goto L_0x0288
            r7 = r6[r0]     // Catch:{ IOException -> 0x0286 }
            com.itextpdf.text.pdf.ByteBuffer r6 = r14.h(r7)     // Catch:{ IOException -> 0x0286 }
            r6.c(r5)     // Catch:{ IOException -> 0x0286 }
            int r0 = r0 + 1
            goto L_0x0275
        L_0x0286:
            r14 = move-exception
            goto L_0x029e
        L_0x0288:
            r14.c(r2)     // Catch:{ IOException -> 0x0286 }
            java.io.RandomAccessFile r0 = r13.f26320i     // Catch:{ IOException -> 0x0286 }
            r0.seek(r3)     // Catch:{ IOException -> 0x0286 }
            java.io.RandomAccessFile r0 = r13.f26320i     // Catch:{ IOException -> 0x0286 }
            byte[] r2 = r14.w()     // Catch:{ IOException -> 0x0286 }
            int r14 = r14.C()     // Catch:{ IOException -> 0x0286 }
            r0.write(r2, r1, r14)     // Catch:{ IOException -> 0x0286 }
        L_0x029d:
            return
        L_0x029e:
            java.io.RandomAccessFile r0 = r13.f26320i     // Catch:{ Exception -> 0x02a3 }
            r0.close()     // Catch:{ Exception -> 0x02a3 }
        L_0x02a3:
            java.io.File r0 = r13.I     // Catch:{ Exception -> 0x02a8 }
            r0.delete()     // Catch:{ Exception -> 0x02a8 }
        L_0x02a8:
            throw r14
        L_0x02a9:
            com.itextpdf.text.DocumentException r14 = new com.itextpdf.text.DocumentException
            java.lang.String r0 = "No crypto dictionary defined."
            r14.<init>((java.lang.String) r0)
            throw r14
        L_0x02b1:
            com.itextpdf.text.DocumentException r14 = new com.itextpdf.text.DocumentException
            java.lang.String r0 = "document.already.pre.closed"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r0 = com.itextpdf.text.error_messages.MessageLocalization.b(r0, r1)
            r14.<init>((java.lang.String) r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfSignatureAppearance.O(java.util.HashMap):void");
    }

    public void P(boolean z2) {
        this.u = z2;
    }

    public void Q(Certificate certificate) {
        this.f26323l = certificate;
    }

    public void R(int i2) {
        this.f26312a = i2;
    }

    public void S(String str) {
        this.f26319h = str;
    }

    public void T(PdfDictionary pdfDictionary) {
        this.f26324m = pdfDictionary;
    }

    public void U(PdfSigLockDictionary pdfSigLockDictionary) {
        this.M = pdfSigLockDictionary;
    }

    public void V(Image image) {
        this.x = image;
    }

    public void W(float f2) {
        this.y = f2;
    }

    public void X(Font font) {
        this.A = font;
    }

    public void Y(String str) {
        this.z = str;
    }

    public void Z(String str) {
        this.C = str;
    }

    public void a(PdfDeveloperExtension pdfDeveloperExtension) {
        this.F.w(pdfDeveloperExtension);
    }

    public void a0(String str) {
        this.f26316e = str;
    }

    public void b0(String str) {
        this.f26314c = str;
    }

    /* access modifiers changed from: package-private */
    public void c0(OutputStream outputStream) {
        this.H = outputStream;
    }

    public void d(PdfDictionary pdfDictionary) throws IOException, DocumentException {
        try {
            if (this.L) {
                ByteBuffer byteBuffer = new ByteBuffer();
                for (PdfName next : pdfDictionary.G0()) {
                    PdfObject d0 = pdfDictionary.d0(next);
                    PdfLiteral pdfLiteral = this.J.get(next);
                    if (pdfLiteral != null) {
                        byteBuffer.x();
                        d0.T((PdfWriter) null, byteBuffer);
                        if (byteBuffer.C() > pdfLiteral.Z()) {
                            throw new IllegalArgumentException(MessageLocalization.b("the.key.1.is.too.big.is.2.reserved.3", next.toString(), String.valueOf(byteBuffer.C()), String.valueOf(pdfLiteral.Z())));
                        } else if (this.I == null) {
                            System.arraycopy(byteBuffer.w(), 0, this.f26321j, (int) pdfLiteral.a0(), byteBuffer.C());
                        } else {
                            this.f26320i.seek(pdfLiteral.a0());
                            this.f26320i.write(byteBuffer.w(), 0, byteBuffer.C());
                        }
                    } else {
                        throw new IllegalArgumentException(MessageLocalization.b("the.key.1.didn.t.reserve.space.in.preclose", next.toString()));
                    }
                }
                if (pdfDictionary.size() == this.J.size()) {
                    if (this.I == null) {
                        this.H.write(this.f26321j, 0, this.K);
                    } else if (this.H != null) {
                        this.f26320i.seek(0);
                        long length = this.f26320i.length();
                        byte[] bArr = new byte[8192];
                        while (length > 0) {
                            int read = this.f26320i.read(bArr, 0, (int) Math.min((long) 8192, length));
                            if (read >= 0) {
                                this.H.write(bArr, 0, read);
                                length -= (long) read;
                            } else {
                                throw new EOFException(MessageLocalization.b("unexpected.eof", new Object[0]));
                            }
                        }
                    }
                } else {
                    throw new IllegalArgumentException(MessageLocalization.b("the.update.dictionary.has.less.keys.than.required", new Object[0]));
                }
            } else {
                throw new DocumentException(MessageLocalization.b("preclose.must.be.called.first", new Object[0]));
            }
        } finally {
            this.F.Y5.l();
            if (this.I != null) {
                try {
                    this.f26320i.close();
                } catch (Exception unused) {
                }
                if (this.H != null) {
                    try {
                        this.I.delete();
                    } catch (Exception unused2) {
                    }
                }
            }
            OutputStream outputStream = this.H;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception unused3) {
                }
            }
        }
    }

    public void d0(String str) {
        this.f26315d = str;
    }

    public void e0(String str) {
        this.f26313b = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:125:0x0571  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x05af  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x05bd  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x05e2  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x03a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.pdf.PdfTemplate f() throws com.itextpdf.text.DocumentException {
        /*
            r34 = this;
            r0 = r34
            boolean r1 = r34.M()
            r2 = 0
            r3 = 0
            if (r1 == 0) goto L_0x001f
            com.itextpdf.text.pdf.PdfTemplate r1 = new com.itextpdf.text.pdf.PdfTemplate
            com.itextpdf.text.pdf.PdfStamperImp r4 = r0.F
            r1.<init>(r4)
            com.itextpdf.text.Rectangle r4 = new com.itextpdf.text.Rectangle
            r4.<init>(r3, r3)
            r1.S3(r4)
            com.itextpdf.text.pdf.PdfStamperImp r3 = r0.F
            r3.X(r1, r2)
            return r1
        L_0x001f:
            com.itextpdf.text.pdf.PdfTemplate[] r1 = r0.v
            r4 = 0
            r1 = r1[r4]
            if (r1 != 0) goto L_0x002d
            boolean r1 = r0.w
            if (r1 != 0) goto L_0x002d
            r34.e()
        L_0x002d:
            com.itextpdf.text.pdf.PdfTemplate[] r1 = r0.v
            r5 = 1
            r6 = r1[r5]
            r7 = 1120403456(0x42c80000, float:100.0)
            if (r6 != 0) goto L_0x005c
            boolean r6 = r0.u
            if (r6 != 0) goto L_0x005c
            com.itextpdf.text.pdf.PdfTemplate r6 = new com.itextpdf.text.pdf.PdfTemplate
            com.itextpdf.text.pdf.PdfStamperImp r8 = r0.F
            r6.<init>(r8)
            r1[r5] = r6
            com.itextpdf.text.Rectangle r1 = new com.itextpdf.text.Rectangle
            r1.<init>(r7, r7)
            r6.S3(r1)
            com.itextpdf.text.pdf.PdfStamperImp r1 = r0.F
            com.itextpdf.text.pdf.PdfName r8 = new com.itextpdf.text.pdf.PdfName
            java.lang.String r9 = "n1"
            r8.<init>((java.lang.String) r9)
            r1.X(r6, r8)
            java.lang.String r1 = "% DSUnknown\nq\n1 G\n1 g\n0.1 0 0 0.1 9 0 cm\n0 J 0 j 4 M []0 d\n1 i \n0 g\n313 292 m\n313 404 325 453 432 529 c\n478 561 504 597 504 645 c\n504 736 440 760 391 760 c\n286 760 271 681 265 626 c\n265 625 l\n100 625 l\n100 828 253 898 381 898 c\n451 898 679 878 679 650 c\n679 555 628 499 538 435 c\n488 399 467 376 467 292 c\n313 292 l\nh\n308 214 170 -164 re\nf\n0.44 G\n1.2 w\n1 1 0.4 rg\n287 318 m\n287 430 299 479 406 555 c\n451 587 478 623 478 671 c\n478 762 414 786 365 786 c\n260 786 245 707 239 652 c\n239 651 l\n74 651 l\n74 854 227 924 355 924 c\n425 924 653 904 653 676 c\n653 581 602 525 512 461 c\n462 425 441 402 441 318 c\n287 318 l\nh\n282 240 170 -164 re\nB\nQ\n"
            r6.M2(r1)
        L_0x005c:
            com.itextpdf.text.pdf.PdfTemplate[] r1 = r0.v
            r6 = 2
            r1 = r1[r6]
            r9 = 1060320051(0x3f333333, float:0.7)
            r11 = 1073741824(0x40000000, float:2.0)
            if (r1 != 0) goto L_0x03e7
            java.lang.String r1 = r0.z
            java.lang.String r12 = ""
            java.lang.String r13 = "E"
            java.lang.String r14 = "CN"
            if (r1 != 0) goto L_0x00e0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r15 = "Digitally signed by "
            r1.append(r15)
            java.security.cert.Certificate r15 = r0.f26323l
            java.security.cert.X509Certificate r15 = (java.security.cert.X509Certificate) r15
            com.itextpdf.text.pdf.security.CertificateInfo$X500Name r15 = com.itextpdf.text.pdf.security.CertificateInfo.d(r15)
            if (r15 == 0) goto L_0x0091
            java.lang.String r16 = r15.a(r14)
            if (r16 != 0) goto L_0x0093
            java.lang.String r16 = r15.a(r13)
            goto L_0x0093
        L_0x0091:
            r16 = r2
        L_0x0093:
            if (r16 != 0) goto L_0x0097
            r15 = r12
            goto L_0x0099
        L_0x0097:
            r15 = r16
        L_0x0099:
            r1.append(r15)
            r15 = 10
            r1.append(r15)
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.lang.String r7 = "yyyy.MM.dd HH:mm:ss z"
            r2.<init>(r7)
            java.lang.String r7 = "Date: "
            r1.append(r7)
            java.util.Calendar r7 = r0.f26317f
            java.util.Date r7 = r7.getTime()
            java.lang.String r2 = r2.format(r7)
            r1.append(r2)
            java.lang.String r2 = r0.f26315d
            if (r2 == 0) goto L_0x00cb
            r1.append(r15)
            java.lang.String r2 = r0.f26313b
            r1.append(r2)
            java.lang.String r2 = r0.f26315d
            r1.append(r2)
        L_0x00cb:
            java.lang.String r2 = r0.f26316e
            if (r2 == 0) goto L_0x00dc
            r1.append(r15)
            java.lang.String r2 = r0.f26314c
            r1.append(r2)
            java.lang.String r2 = r0.f26316e
            r1.append(r2)
        L_0x00dc:
            java.lang.String r1 = r1.toString()
        L_0x00e0:
            com.itextpdf.text.pdf.PdfTemplate[] r2 = r0.v
            com.itextpdf.text.pdf.PdfTemplate r7 = new com.itextpdf.text.pdf.PdfTemplate
            com.itextpdf.text.pdf.PdfStamperImp r15 = r0.F
            r7.<init>(r15)
            r2[r6] = r7
            com.itextpdf.text.Rectangle r2 = r0.q
            r7.S3(r2)
            com.itextpdf.text.pdf.PdfStamperImp r2 = r0.F
            com.itextpdf.text.pdf.PdfName r15 = new com.itextpdf.text.pdf.PdfName
            java.lang.String r8 = "n2"
            r15.<init>((java.lang.String) r8)
            r2.X(r7, r15)
            com.itextpdf.text.Image r2 = r0.x
            if (r2 == 0) goto L_0x016b
            float r8 = r0.y
            int r15 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r15 != 0) goto L_0x0122
            com.itextpdf.text.Rectangle r8 = r0.q
            float r19 = r8.a0()
            com.itextpdf.text.Rectangle r8 = r0.q
            float r22 = r8.N()
            r23 = 0
            r24 = 0
        L_0x0116:
            r20 = 0
            r21 = 0
            r17 = r7
            r18 = r2
            r17.l(r18, r19, r20, r21, r22, r23, r24)
            goto L_0x016b
        L_0x0122:
            int r2 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r2 >= 0) goto L_0x0144
            com.itextpdf.text.Rectangle r2 = r0.q
            float r2 = r2.a0()
            com.itextpdf.text.Image r8 = r0.x
            float r8 = r8.a0()
            float r2 = r2 / r8
            com.itextpdf.text.Rectangle r8 = r0.q
            float r8 = r8.N()
            com.itextpdf.text.Image r15 = r0.x
            float r15 = r15.N()
            float r8 = r8 / r15
            float r8 = java.lang.Math.min(r2, r8)
        L_0x0144:
            com.itextpdf.text.Image r2 = r0.x
            float r2 = r2.a0()
            float r19 = r2 * r8
            com.itextpdf.text.Image r2 = r0.x
            float r2 = r2.N()
            float r22 = r2 * r8
            com.itextpdf.text.Rectangle r2 = r0.q
            float r2 = r2.a0()
            float r2 = r2 - r19
            float r23 = r2 / r11
            com.itextpdf.text.Rectangle r2 = r0.q
            float r2 = r2.N()
            float r2 = r2 - r22
            float r24 = r2 / r11
            com.itextpdf.text.Image r2 = r0.x
            goto L_0x0116
        L_0x016b:
            com.itextpdf.text.Font r2 = r0.A
            if (r2 != 0) goto L_0x0175
            com.itextpdf.text.Font r2 = new com.itextpdf.text.Font
            r2.<init>()
            goto L_0x017b
        L_0x0175:
            com.itextpdf.text.Font r8 = new com.itextpdf.text.Font
            r8.<init>((com.itextpdf.text.Font) r2)
            r2 = r8
        L_0x017b:
            float r8 = r2.m()
            com.itextpdf.text.pdf.PdfSignatureAppearance$RenderingMode r15 = r0.s
            com.itextpdf.text.pdf.PdfSignatureAppearance$RenderingMode r3 = com.itextpdf.text.pdf.PdfSignatureAppearance.RenderingMode.NAME_AND_DESCRIPTION
            if (r15 == r3) goto L_0x01d2
            com.itextpdf.text.pdf.PdfSignatureAppearance$RenderingMode r3 = com.itextpdf.text.pdf.PdfSignatureAppearance.RenderingMode.GRAPHIC_AND_DESCRIPTION
            if (r15 != r3) goto L_0x018e
            com.itextpdf.text.Image r3 = r0.t
            if (r3 == 0) goto L_0x018e
            goto L_0x01d2
        L_0x018e:
            com.itextpdf.text.pdf.PdfSignatureAppearance$RenderingMode r3 = com.itextpdf.text.pdf.PdfSignatureAppearance.RenderingMode.GRAPHIC
            if (r15 != r3) goto L_0x01ba
            com.itextpdf.text.Image r3 = r0.t
            if (r3 == 0) goto L_0x01ac
            com.itextpdf.text.Rectangle r3 = new com.itextpdf.text.Rectangle
            com.itextpdf.text.Rectangle r15 = r0.q
            float r15 = r15.a0()
            float r15 = r15 - r11
            com.itextpdf.text.Rectangle r10 = r0.q
            float r10 = r10.N()
            float r10 = r10 - r11
            r3.<init>(r11, r11, r15, r10)
            r4 = 0
            goto L_0x0244
        L_0x01ac:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "a.signature.image.should.be.present.when.rendering.mode.is.graphic.only"
            java.lang.Object[] r3 = new java.lang.Object[r4]
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r2, r3)
            r1.<init>(r2)
            throw r1
        L_0x01ba:
            com.itextpdf.text.Rectangle r3 = new com.itextpdf.text.Rectangle
            com.itextpdf.text.Rectangle r10 = r0.q
            float r10 = r10.a0()
            float r10 = r10 - r11
            com.itextpdf.text.Rectangle r15 = r0.q
            float r15 = r15.N()
            float r15 = r15 * r9
            float r15 = r15 - r11
            r3.<init>(r11, r11, r10, r15)
            r4 = r3
            r3 = 0
            goto L_0x0244
        L_0x01d2:
            com.itextpdf.text.Rectangle r3 = new com.itextpdf.text.Rectangle
            com.itextpdf.text.Rectangle r10 = r0.q
            float r10 = r10.a0()
            float r10 = r10 / r11
            float r10 = r10 - r11
            com.itextpdf.text.Rectangle r15 = r0.q
            float r15 = r15.N()
            float r15 = r15 - r11
            r3.<init>(r11, r11, r10, r15)
            com.itextpdf.text.Rectangle r10 = new com.itextpdf.text.Rectangle
            com.itextpdf.text.Rectangle r15 = r0.q
            float r15 = r15.a0()
            float r15 = r15 / r11
            r19 = 1065353216(0x3f800000, float:1.0)
            float r15 = r15 + r19
            com.itextpdf.text.Rectangle r9 = r0.q
            float r9 = r9.a0()
            float r9 = r9 - r19
            com.itextpdf.text.Rectangle r4 = r0.q
            float r4 = r4.N()
            float r4 = r4 - r11
            r10.<init>(r15, r11, r9, r4)
            com.itextpdf.text.Rectangle r4 = r0.q
            float r4 = r4.N()
            com.itextpdf.text.Rectangle r9 = r0.q
            float r9 = r9.a0()
            int r4 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r4 <= 0) goto L_0x0243
            com.itextpdf.text.Rectangle r3 = new com.itextpdf.text.Rectangle
            com.itextpdf.text.Rectangle r4 = r0.q
            float r4 = r4.N()
            float r4 = r4 / r11
            com.itextpdf.text.Rectangle r9 = r0.q
            float r9 = r9.a0()
            float r9 = r9 - r11
            com.itextpdf.text.Rectangle r10 = r0.q
            float r10 = r10.N()
            r3.<init>(r11, r4, r9, r10)
            com.itextpdf.text.Rectangle r4 = new com.itextpdf.text.Rectangle
            com.itextpdf.text.Rectangle r9 = r0.q
            float r9 = r9.a0()
            float r9 = r9 - r11
            com.itextpdf.text.Rectangle r10 = r0.q
            float r10 = r10.N()
            float r10 = r10 / r11
            float r10 = r10 - r11
            r4.<init>(r11, r11, r9, r10)
            goto L_0x0244
        L_0x0243:
            r4 = r10
        L_0x0244:
            int[] r9 = com.itextpdf.text.pdf.PdfSignatureAppearance.AnonymousClass1.f26326a
            com.itextpdf.text.pdf.PdfSignatureAppearance$RenderingMode r10 = r0.s
            int r10 = r10.ordinal()
            r9 = r9[r10]
            if (r9 == r5) goto L_0x033b
            if (r9 == r6) goto L_0x02b9
            r10 = 3
            if (r9 == r10) goto L_0x0257
            goto L_0x039a
        L_0x0257:
            com.itextpdf.text.pdf.ColumnText r9 = new com.itextpdf.text.pdf.ColumnText
            r9.<init>(r7)
            int r10 = r0.B
            r9.k0(r10)
            float r27 = r3.O()
            float r28 = r3.H()
            float r29 = r3.Q()
            float r30 = r3.T()
            r31 = 0
            r32 = 2
            r26 = r9
            r26.m0(r27, r28, r29, r30, r31, r32)
            com.itextpdf.text.Image r10 = r0.t
            com.itextpdf.text.Image r10 = com.itextpdf.text.Image.Y0(r10)
            float r12 = r3.a0()
            float r13 = r3.N()
            r10.T1(r12, r13)
            com.itextpdf.text.Paragraph r12 = new com.itextpdf.text.Paragraph
            float r13 = r3.N()
            r12.<init>((float) r13)
            float r13 = r3.a0()
            float r14 = r10.p1()
            float r13 = r13 - r14
            float r13 = r13 / r11
            float r3 = r3.N()
            float r14 = r10.o1()
            float r3 = r3 - r14
            float r3 = r3 / r11
            com.itextpdf.text.Chunk r14 = new com.itextpdf.text.Chunk
            r15 = 0
            r14.<init>(r10, r13, r3, r15)
            r12.add(r14)
        L_0x02b1:
            r9.a(r12)
        L_0x02b4:
            r9.I()
            goto L_0x039a
        L_0x02b9:
            com.itextpdf.text.Image r9 = r0.t
            if (r9 == 0) goto L_0x032c
            com.itextpdf.text.pdf.ColumnText r9 = new com.itextpdf.text.pdf.ColumnText
            r9.<init>(r7)
            int r10 = r0.B
            r9.k0(r10)
            float r27 = r3.O()
            float r28 = r3.H()
            float r29 = r3.Q()
            float r30 = r3.T()
            r31 = 0
            r32 = 2
            r26 = r9
            r26.m0(r27, r28, r29, r30, r31, r32)
            com.itextpdf.text.Image r10 = r0.t
            com.itextpdf.text.Image r10 = com.itextpdf.text.Image.Y0(r10)
            float r12 = r3.a0()
            float r13 = r3.N()
            r10.T1(r12, r13)
            com.itextpdf.text.Paragraph r12 = new com.itextpdf.text.Paragraph
            r12.<init>()
            float r13 = r10.o1()
            float r13 = -r13
            r14 = 1097859072(0x41700000, float:15.0)
            float r13 = r13 + r14
            float r14 = r3.a0()
            float r15 = r10.p1()
            float r14 = r14 - r15
            float r14 = r14 / r11
            r15 = 0
            float r14 = r14 + r15
            float r15 = r3.N()
            float r21 = r10.o1()
            float r15 = r15 - r21
            float r15 = r15 / r11
            float r13 = r13 - r15
            com.itextpdf.text.Chunk r15 = new com.itextpdf.text.Chunk
            float r3 = r3.a0()
            float r21 = r10.p1()
            float r3 = r3 - r21
            float r3 = r3 / r11
            float r14 = r14 + r3
            r3 = 0
            r15.<init>(r10, r14, r13, r3)
            r12.add(r15)
            goto L_0x02b1
        L_0x032c:
            r3 = 0
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "a.signature.image.should.be.present.when.rendering.mode.is.graphic.and.description"
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r2 = com.itextpdf.text.error_messages.MessageLocalization.b(r2, r3)
            r1.<init>(r2)
            throw r1
        L_0x033b:
            java.security.cert.Certificate r9 = r0.f26323l
            java.security.cert.X509Certificate r9 = (java.security.cert.X509Certificate) r9
            com.itextpdf.text.pdf.security.CertificateInfo$X500Name r9 = com.itextpdf.text.pdf.security.CertificateInfo.d(r9)
            java.lang.String r9 = r9.a(r14)
            if (r9 != 0) goto L_0x0355
            java.security.cert.Certificate r9 = r0.f26323l
            java.security.cert.X509Certificate r9 = (java.security.cert.X509Certificate) r9
            com.itextpdf.text.pdf.security.CertificateInfo$X500Name r9 = com.itextpdf.text.pdf.security.CertificateInfo.d(r9)
            java.lang.String r9 = r9.a(r13)
        L_0x0355:
            if (r9 != 0) goto L_0x0358
            goto L_0x0359
        L_0x0358:
            r12 = r9
        L_0x0359:
            com.itextpdf.text.Rectangle r9 = new com.itextpdf.text.Rectangle
            float r10 = r3.a0()
            float r10 = r10 - r11
            float r13 = r3.N()
            float r13 = r13 - r11
            r9.<init>(r10, r13)
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r13 = r0.B
            float r32 = com.itextpdf.text.pdf.ColumnText.k(r2, r12, r9, r10, r13)
            com.itextpdf.text.pdf.ColumnText r9 = new com.itextpdf.text.pdf.ColumnText
            r9.<init>(r7)
            int r10 = r0.B
            r9.k0(r10)
            com.itextpdf.text.Phrase r10 = new com.itextpdf.text.Phrase
            r10.<init>((java.lang.String) r12, (com.itextpdf.text.Font) r2)
            float r28 = r3.O()
            float r29 = r3.H()
            float r30 = r3.Q()
            float r31 = r3.T()
            r33 = 0
            r26 = r9
            r27 = r10
            r26.n0(r27, r28, r29, r30, r31, r32, r33)
            goto L_0x02b4
        L_0x039a:
            com.itextpdf.text.pdf.PdfSignatureAppearance$RenderingMode r3 = r0.s
            com.itextpdf.text.pdf.PdfSignatureAppearance$RenderingMode r9 = com.itextpdf.text.pdf.PdfSignatureAppearance.RenderingMode.GRAPHIC
            if (r3 == r9) goto L_0x03e7
            r3 = 0
            int r9 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r9 > 0) goto L_0x03ba
            com.itextpdf.text.Rectangle r3 = new com.itextpdf.text.Rectangle
            float r8 = r4.a0()
            float r9 = r4.N()
            r3.<init>(r8, r9)
            r8 = 1094713344(0x41400000, float:12.0)
            int r9 = r0.B
            float r8 = com.itextpdf.text.pdf.ColumnText.k(r2, r1, r3, r8, r9)
        L_0x03ba:
            r32 = r8
            com.itextpdf.text.pdf.ColumnText r3 = new com.itextpdf.text.pdf.ColumnText
            r3.<init>(r7)
            int r7 = r0.B
            r3.k0(r7)
            com.itextpdf.text.Phrase r7 = new com.itextpdf.text.Phrase
            r7.<init>((java.lang.String) r1, (com.itextpdf.text.Font) r2)
            float r28 = r4.O()
            float r29 = r4.H()
            float r30 = r4.Q()
            float r31 = r4.T()
            r33 = 0
            r26 = r3
            r27 = r7
            r26.n0(r27, r28, r29, r30, r31, r32, r33)
            r3.I()
        L_0x03e7:
            com.itextpdf.text.pdf.PdfTemplate[] r1 = r0.v
            r2 = 3
            r3 = r1[r2]
            if (r3 != 0) goto L_0x0416
            boolean r3 = r0.u
            if (r3 != 0) goto L_0x0416
            com.itextpdf.text.pdf.PdfTemplate r3 = new com.itextpdf.text.pdf.PdfTemplate
            com.itextpdf.text.pdf.PdfStamperImp r4 = r0.F
            r3.<init>(r4)
            r1[r2] = r3
            com.itextpdf.text.Rectangle r1 = new com.itextpdf.text.Rectangle
            r2 = 1120403456(0x42c80000, float:100.0)
            r1.<init>(r2, r2)
            r3.S3(r1)
            com.itextpdf.text.pdf.PdfStamperImp r1 = r0.F
            com.itextpdf.text.pdf.PdfName r2 = new com.itextpdf.text.pdf.PdfName
            java.lang.String r4 = "n3"
            r2.<init>((java.lang.String) r4)
            r1.X(r3, r2)
            java.lang.String r1 = "% DSBlank\n"
            r3.M2(r1)
        L_0x0416:
            com.itextpdf.text.pdf.PdfTemplate[] r1 = r0.v
            r2 = 4
            r3 = r1[r2]
            if (r3 != 0) goto L_0x04be
            boolean r3 = r0.u
            if (r3 != 0) goto L_0x04be
            com.itextpdf.text.pdf.PdfTemplate r3 = new com.itextpdf.text.pdf.PdfTemplate
            com.itextpdf.text.pdf.PdfStamperImp r4 = r0.F
            r3.<init>(r4)
            r1[r2] = r3
            com.itextpdf.text.Rectangle r1 = new com.itextpdf.text.Rectangle
            com.itextpdf.text.Rectangle r4 = r0.q
            float r4 = r4.N()
            r7 = 1060320051(0x3f333333, float:0.7)
            float r4 = r4 * r7
            com.itextpdf.text.Rectangle r7 = r0.q
            float r7 = r7.Q()
            com.itextpdf.text.Rectangle r8 = r0.q
            float r8 = r8.T()
            r9 = 0
            r1.<init>(r9, r4, r7, r8)
            r3.S3(r1)
            com.itextpdf.text.pdf.PdfStamperImp r1 = r0.F
            com.itextpdf.text.pdf.PdfName r4 = new com.itextpdf.text.pdf.PdfName
            java.lang.String r7 = "n4"
            r4.<init>((java.lang.String) r7)
            r1.X(r3, r4)
            com.itextpdf.text.Font r1 = r0.A
            if (r1 != 0) goto L_0x0460
            com.itextpdf.text.Font r1 = new com.itextpdf.text.Font
            r1.<init>()
            goto L_0x0466
        L_0x0460:
            com.itextpdf.text.Font r4 = new com.itextpdf.text.Font
            r4.<init>((com.itextpdf.text.Font) r1)
            r1 = r4
        L_0x0466:
            java.lang.String r4 = r0.C
            if (r4 == 0) goto L_0x046b
            goto L_0x046d
        L_0x046b:
            java.lang.String r4 = "Signature Not Verified"
        L_0x046d:
            com.itextpdf.text.Rectangle r7 = new com.itextpdf.text.Rectangle
            com.itextpdf.text.Rectangle r8 = r0.q
            float r8 = r8.a0()
            r9 = 1082130432(0x40800000, float:4.0)
            float r8 = r8 - r9
            com.itextpdf.text.Rectangle r10 = r0.q
            float r10 = r10.N()
            r12 = 1050253722(0x3e99999a, float:0.3)
            float r10 = r10 * r12
            float r10 = r10 - r9
            r7.<init>(r8, r10)
            int r8 = r0.B
            r9 = 1097859072(0x41700000, float:15.0)
            float r26 = com.itextpdf.text.pdf.ColumnText.k(r1, r4, r7, r9, r8)
            com.itextpdf.text.pdf.ColumnText r7 = new com.itextpdf.text.pdf.ColumnText
            r7.<init>(r3)
            int r3 = r0.B
            r7.k0(r3)
            com.itextpdf.text.Phrase r3 = new com.itextpdf.text.Phrase
            r3.<init>((java.lang.String) r4, (com.itextpdf.text.Font) r1)
            com.itextpdf.text.Rectangle r1 = r0.q
            float r1 = r1.a0()
            float r24 = r1 - r11
            com.itextpdf.text.Rectangle r1 = r0.q
            float r1 = r1.N()
            float r25 = r1 - r11
            r27 = 0
            r22 = 1073741824(0x40000000, float:2.0)
            r23 = 0
            r20 = r7
            r21 = r3
            r20.n0(r21, r22, r23, r24, r25, r26, r27)
            r7.I()
        L_0x04be:
            com.itextpdf.text.pdf.PdfStamperImp r1 = r0.F
            com.itextpdf.text.pdf.PdfReader r1 = r1.Y5
            int r3 = r0.p
            int r1 = r1.m0(r3)
            com.itextpdf.text.Rectangle r3 = new com.itextpdf.text.Rectangle
            com.itextpdf.text.Rectangle r4 = r0.q
            r3.<init>((com.itextpdf.text.Rectangle) r4)
            r4 = r1
        L_0x04d0:
            if (r4 <= 0) goto L_0x04d9
            com.itextpdf.text.Rectangle r3 = r3.g0()
            int r4 = r4 + -90
            goto L_0x04d0
        L_0x04d9:
            com.itextpdf.text.pdf.PdfTemplate r4 = r0.D
            if (r4 != 0) goto L_0x0605
            com.itextpdf.text.pdf.PdfTemplate r4 = new com.itextpdf.text.pdf.PdfTemplate
            com.itextpdf.text.pdf.PdfStamperImp r7 = r0.F
            r4.<init>(r7)
            r0.D = r4
            r4.S3(r3)
            com.itextpdf.text.pdf.PdfStamperImp r4 = r0.F
            com.itextpdf.text.pdf.PdfTemplate r7 = r0.D
            com.itextpdf.text.pdf.PdfName r8 = new com.itextpdf.text.pdf.PdfName
            java.lang.String r9 = "FRM"
            r8.<init>((java.lang.String) r9)
            r4.X(r7, r8)
            com.itextpdf.text.Rectangle r4 = r0.q
            float r4 = r4.a0()
            com.itextpdf.text.Rectangle r7 = r0.q
            float r7 = r7.N()
            float r4 = java.lang.Math.min(r4, r7)
            r7 = 1063675494(0x3f666666, float:0.9)
            float r4 = r4 * r7
            com.itextpdf.text.Rectangle r7 = r0.q
            float r7 = r7.a0()
            float r7 = r7 - r4
            float r7 = r7 / r11
            com.itextpdf.text.Rectangle r8 = r0.q
            float r8 = r8.N()
            float r8 = r8 - r4
            float r8 = r8 / r11
            r9 = 1120403456(0x42c80000, float:100.0)
            float r4 = r4 / r9
            r9 = 90
            if (r1 != r9) goto L_0x053b
            com.itextpdf.text.pdf.PdfTemplate r1 = r0.D
            com.itextpdf.text.Rectangle r9 = r0.q
            float r25 = r9.N()
            r26 = 0
            r21 = 0
            r22 = 1065353216(0x3f800000, float:1.0)
            r23 = -1082130432(0xffffffffbf800000, float:-1.0)
            r24 = 0
        L_0x0535:
            r20 = r1
            r20.l0(r21, r22, r23, r24, r25, r26)
            goto L_0x056d
        L_0x053b:
            r9 = 180(0xb4, float:2.52E-43)
            if (r1 != r9) goto L_0x0556
            com.itextpdf.text.pdf.PdfTemplate r1 = r0.D
            com.itextpdf.text.Rectangle r9 = r0.q
            float r25 = r9.a0()
            com.itextpdf.text.Rectangle r9 = r0.q
            float r26 = r9.N()
            r21 = -1082130432(0xffffffffbf800000, float:-1.0)
            r22 = 0
            r23 = 0
            r24 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L_0x0535
        L_0x0556:
            r9 = 270(0x10e, float:3.78E-43)
            if (r1 != r9) goto L_0x056d
            com.itextpdf.text.pdf.PdfTemplate r1 = r0.D
            com.itextpdf.text.Rectangle r9 = r0.q
            float r26 = r9.a0()
            r21 = 0
            r22 = -1082130432(0xffffffffbf800000, float:-1.0)
            r23 = 1065353216(0x3f800000, float:1.0)
            r24 = 0
            r25 = 0
            goto L_0x0535
        L_0x056d:
            boolean r1 = r0.w
            if (r1 == 0) goto L_0x059d
            com.itextpdf.text.pdf.PdfStamperImp r1 = r0.F
            com.itextpdf.text.pdf.AcroFields r1 = r1.l3()
            java.lang.String r9 = r34.l()
            com.itextpdf.text.pdf.PdfIndirectReference r21 = r1.B(r9)
            if (r21 == 0) goto L_0x059f
            com.itextpdf.text.pdf.PdfTemplate r1 = r0.D
            com.itextpdf.text.pdf.PdfName r9 = new com.itextpdf.text.pdf.PdfName
            java.lang.String r10 = "n0"
            r9.<init>((java.lang.String) r10)
            r27 = 0
            r28 = 0
            r23 = 1065353216(0x3f800000, float:1.0)
            r24 = 0
            r25 = 0
            r26 = 1065353216(0x3f800000, float:1.0)
            r20 = r1
            r22 = r9
            r20.H(r21, r22, r23, r24, r25, r26, r27, r28)
        L_0x059d:
            r1 = 0
            goto L_0x05ab
        L_0x059f:
            r1 = 0
            r0.w = r1
            com.itextpdf.text.pdf.PdfTemplate[] r9 = r0.v
            r9 = r9[r1]
            if (r9 != 0) goto L_0x05ab
            r34.e()
        L_0x05ab:
            boolean r9 = r0.w
            if (r9 != 0) goto L_0x05b9
            com.itextpdf.text.pdf.PdfTemplate r9 = r0.D
            com.itextpdf.text.pdf.PdfTemplate[] r10 = r0.v
            r1 = r10[r1]
            r10 = 0
            r9.z(r1, r10, r10)
        L_0x05b9:
            boolean r1 = r0.u
            if (r1 != 0) goto L_0x05d4
            com.itextpdf.text.pdf.PdfTemplate r1 = r0.D
            com.itextpdf.text.pdf.PdfTemplate[] r9 = r0.v
            r21 = r9[r5]
            r23 = 0
            r24 = 0
            r20 = r1
            r22 = r4
            r25 = r4
            r26 = r7
            r27 = r8
            r20.A(r21, r22, r23, r24, r25, r26, r27)
        L_0x05d4:
            com.itextpdf.text.pdf.PdfTemplate r1 = r0.D
            com.itextpdf.text.pdf.PdfTemplate[] r5 = r0.v
            r5 = r5[r6]
            r6 = 0
            r1.z(r5, r6, r6)
            boolean r1 = r0.u
            if (r1 != 0) goto L_0x0605
            com.itextpdf.text.pdf.PdfTemplate r1 = r0.D
            com.itextpdf.text.pdf.PdfTemplate[] r5 = r0.v
            r6 = 3
            r21 = r5[r6]
            r23 = 0
            r24 = 0
            r20 = r1
            r22 = r4
            r25 = r4
            r26 = r7
            r27 = r8
            r20.A(r21, r22, r23, r24, r25, r26, r27)
            com.itextpdf.text.pdf.PdfTemplate r1 = r0.D
            com.itextpdf.text.pdf.PdfTemplate[] r4 = r0.v
            r2 = r4[r2]
            r4 = 0
            r1.z(r2, r4, r4)
            goto L_0x0606
        L_0x0605:
            r4 = 0
        L_0x0606:
            com.itextpdf.text.pdf.PdfTemplate r1 = new com.itextpdf.text.pdf.PdfTemplate
            com.itextpdf.text.pdf.PdfStamperImp r2 = r0.F
            r1.<init>(r2)
            r1.S3(r3)
            com.itextpdf.text.pdf.PdfStamperImp r2 = r0.F
            r3 = 0
            r2.X(r1, r3)
            com.itextpdf.text.pdf.PdfTemplate r2 = r0.D
            r1.z(r2, r4, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfSignatureAppearance.f():com.itextpdf.text.pdf.PdfTemplate");
    }

    public void f0(RenderingMode renderingMode) {
        this.s = renderingMode;
    }

    public Certificate g() {
        return this.f26323l;
    }

    public void g0(boolean z2) {
        this.w = z2;
    }

    public int h() {
        return this.f26312a;
    }

    public void h0(int i2) {
        if (i2 < 0 || i2 > 3) {
            throw new RuntimeException(MessageLocalization.a("invalid.run.direction.1", i2));
        }
        this.B = i2;
    }

    public String i() {
        return this.f26319h;
    }

    public void i0(Calendar calendar) {
        this.f26317f = calendar;
    }

    public PdfDictionary j() {
        return this.f26324m;
    }

    public void j0(String str) {
        this.f26318g = str;
    }

    public PdfSigLockDictionary k() {
        return this.M;
    }

    public void k0(SignatureEvent signatureEvent) {
        this.f26325n = signatureEvent;
    }

    public String l() {
        return this.o;
    }

    public void l0(Image image) {
        this.t = image;
    }

    public Image m() {
        return this.x;
    }

    /* access modifiers changed from: package-private */
    public void m0(ByteBuffer byteBuffer) {
        this.G = byteBuffer;
    }

    public float n() {
        return this.y;
    }

    /* access modifiers changed from: package-private */
    public void n0(PdfStamper pdfStamper) {
        this.E = pdfStamper;
    }

    public PdfTemplate o(int i2) {
        if (i2 < 0) {
            return null;
        }
        PdfTemplate[] pdfTemplateArr = this.v;
        if (i2 >= pdfTemplateArr.length) {
            return null;
        }
        PdfTemplate pdfTemplate = pdfTemplateArr[i2];
        if (pdfTemplate != null) {
            return pdfTemplate;
        }
        PdfTemplate pdfTemplate2 = new PdfTemplate(this.F);
        pdfTemplateArr[i2] = pdfTemplate2;
        pdfTemplate2.S3(this.q);
        PdfStamperImp pdfStamperImp = this.F;
        pdfStamperImp.X(pdfTemplate2, new PdfName("n" + i2));
        return pdfTemplate2;
    }

    /* access modifiers changed from: package-private */
    public void o0(File file) {
        this.I = file;
    }

    public Font p() {
        return this.A;
    }

    public void p0(Rectangle rectangle, int i2, String str) {
        if (str != null) {
            if (str.indexOf(46) >= 0) {
                throw new IllegalArgumentException(MessageLocalization.b("field.names.cannot.contain.a.dot", new Object[0]));
            } else if (this.F.l3().p(str) == null) {
                this.o = str;
            } else {
                throw new IllegalArgumentException(MessageLocalization.b("the.field.1.already.exists", str));
            }
        }
        if (i2 < 1 || i2 > this.F.Y5.c0()) {
            throw new IllegalArgumentException(MessageLocalization.a("invalid.page.number.1", i2));
        }
        Rectangle rectangle2 = new Rectangle(rectangle);
        this.r = rectangle2;
        rectangle2.e0();
        this.q = new Rectangle(this.r.a0(), this.r.N());
        this.p = i2;
    }

    public String q() {
        return this.z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0108  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void q0(java.lang.String r7) {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            com.itextpdf.text.pdf.PdfStamperImp r2 = r6.F
            com.itextpdf.text.pdf.AcroFields r2 = r2.l3()
            com.itextpdf.text.pdf.AcroFields$Item r2 = r2.p(r7)
            if (r2 == 0) goto L_0x0131
            com.itextpdf.text.pdf.PdfDictionary r3 = r2.h(r1)
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.Pe
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.C8
            com.itextpdf.text.pdf.PdfObject r5 = r3.d0(r5)
            com.itextpdf.text.pdf.PdfObject r5 = com.itextpdf.text.pdf.PdfReader.t0(r5)
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0121
            r6.o = r7
            com.itextpdf.text.pdf.PdfName r7 = com.itextpdf.text.pdf.PdfName.Nd
            com.itextpdf.text.pdf.PdfArray r7 = r3.e0(r7)
            com.itextpdf.text.pdf.PdfNumber r3 = r7.J0(r1)
            float r3 = r3.a0()
            com.itextpdf.text.pdf.PdfNumber r0 = r7.J0(r0)
            float r0 = r0.a0()
            r4 = 2
            com.itextpdf.text.pdf.PdfNumber r4 = r7.J0(r4)
            float r4 = r4.a0()
            r5 = 3
            com.itextpdf.text.pdf.PdfNumber r7 = r7.J0(r5)
            float r7 = r7.a0()
            com.itextpdf.text.Rectangle r5 = new com.itextpdf.text.Rectangle
            r5.<init>(r3, r0, r4, r7)
            r6.r = r5
            r5.e0()
            java.lang.Integer r7 = r2.i(r1)
            int r7 = r7.intValue()
            r6.p = r7
            com.itextpdf.text.pdf.PdfStamperImp r0 = r6.F
            com.itextpdf.text.pdf.PdfReader r0 = r0.Y5
            int r7 = r0.m0(r7)
            com.itextpdf.text.pdf.PdfStamperImp r0 = r6.F
            com.itextpdf.text.pdf.PdfReader r0 = r0.Y5
            int r1 = r6.p
            com.itextpdf.text.Rectangle r0 = r0.q0(r1)
            r1 = 90
            if (r7 == r1) goto L_0x00de
            r1 = 180(0xb4, float:2.52E-43)
            if (r7 == r1) goto L_0x00ac
            r1 = 270(0x10e, float:3.78E-43)
            if (r7 == r1) goto L_0x0082
            goto L_0x0106
        L_0x0082:
            com.itextpdf.text.Rectangle r1 = new com.itextpdf.text.Rectangle
            float r2 = r0.Q()
            com.itextpdf.text.Rectangle r3 = r6.r
            float r3 = r3.H()
            float r2 = r2 - r3
            com.itextpdf.text.Rectangle r3 = r6.r
            float r3 = r3.O()
            float r0 = r0.Q()
            com.itextpdf.text.Rectangle r4 = r6.r
            float r4 = r4.T()
            float r0 = r0 - r4
            com.itextpdf.text.Rectangle r4 = r6.r
            float r4 = r4.Q()
            r1.<init>(r2, r3, r0, r4)
        L_0x00a9:
            r6.r = r1
            goto L_0x0106
        L_0x00ac:
            com.itextpdf.text.Rectangle r1 = new com.itextpdf.text.Rectangle
            float r2 = r0.Q()
            com.itextpdf.text.Rectangle r3 = r6.r
            float r3 = r3.O()
            float r2 = r2 - r3
            float r3 = r0.T()
            com.itextpdf.text.Rectangle r4 = r6.r
            float r4 = r4.H()
            float r3 = r3 - r4
            float r4 = r0.Q()
            com.itextpdf.text.Rectangle r5 = r6.r
            float r5 = r5.Q()
            float r4 = r4 - r5
            float r0 = r0.T()
            com.itextpdf.text.Rectangle r5 = r6.r
            float r5 = r5.T()
            float r0 = r0 - r5
            r1.<init>(r2, r3, r4, r0)
            goto L_0x00a9
        L_0x00de:
            com.itextpdf.text.Rectangle r1 = new com.itextpdf.text.Rectangle
            com.itextpdf.text.Rectangle r2 = r6.r
            float r2 = r2.H()
            float r3 = r0.T()
            com.itextpdf.text.Rectangle r4 = r6.r
            float r4 = r4.O()
            float r3 = r3 - r4
            com.itextpdf.text.Rectangle r4 = r6.r
            float r4 = r4.T()
            float r0 = r0.T()
            com.itextpdf.text.Rectangle r5 = r6.r
            float r5 = r5.Q()
            float r0 = r0 - r5
            r1.<init>(r2, r3, r4, r0)
            goto L_0x00a9
        L_0x0106:
            if (r7 == 0) goto L_0x010d
            com.itextpdf.text.Rectangle r7 = r6.r
            r7.e0()
        L_0x010d:
            com.itextpdf.text.Rectangle r7 = new com.itextpdf.text.Rectangle
            com.itextpdf.text.Rectangle r0 = r6.r
            float r0 = r0.a0()
            com.itextpdf.text.Rectangle r1 = r6.r
            float r1 = r1.N()
            r7.<init>(r0, r1)
            r6.q = r7
            return
        L_0x0121:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "the.field.1.is.not.a.signature.field"
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r7
            java.lang.String r7 = com.itextpdf.text.error_messages.MessageLocalization.b(r3, r0)
            r2.<init>(r7)
            throw r2
        L_0x0131:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "the.field.1.does.not.exist"
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r7
            java.lang.String r7 = com.itextpdf.text.error_messages.MessageLocalization.b(r3, r0)
            r2.<init>(r7)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfSignatureAppearance.q0(java.lang.String):void");
    }

    public String r() {
        return this.C;
    }

    public String s() {
        return this.f26316e;
    }

    public String t() {
        AcroFields l3 = this.F.l3();
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            i2++;
            String str = SecurityConstants.r + i2;
            if (l3.p(str) == null) {
                String str2 = str + ".";
                Iterator<String> it2 = l3.t().keySet().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (it2.next().startsWith(str2)) {
                            z2 = false;
                            break;
                        }
                    } else {
                        z2 = true;
                        break;
                    }
                }
            }
        }
        return SecurityConstants.r + i2;
    }

    /* access modifiers changed from: package-private */
    public OutputStream u() {
        return this.H;
    }

    public int v() {
        return this.p;
    }

    public Rectangle w() {
        return this.r;
    }

    public InputStream x() throws IOException {
        return new RASInputStream(new RandomAccessSourceFactory().f(K(), this.f26322k));
    }

    public String y() {
        return this.f26315d;
    }

    public Rectangle z() {
        return this.q;
    }
}
