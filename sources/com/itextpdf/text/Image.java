package com.itextpdf.text;

import com.itextpdf.text.api.Indentable;
import com.itextpdf.text.api.Spaceable;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.ICC_Profile;
import com.itextpdf.text.pdf.PRIndirectReference;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfIndirectReference;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfOCG;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfString;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.codec.CCITTG4Encoder;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import com.itextpdf.text.pdf.interfaces.IAlternateDescription;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public abstract class Image extends Rectangle implements Indentable, Spaceable, IAccessibleElement, IAlternateDescription {
    public static final int A4 = 7;
    public static final int B4 = 0;
    public static final int C4 = 1;
    public static final int D4 = 2;
    public static final int E4 = 3;
    public static final int F4 = 4;
    public static final int G4 = 5;
    public static final int H4 = 6;
    public static final int I4 = 7;
    public static final int J4 = 8;
    public static final int K4 = 9;
    static long L4 = 0;
    public static final int n4 = 0;
    public static final int o4 = 2;
    public static final int p4 = 0;
    public static final int q4 = 1;
    public static final int r4 = 4;
    public static final int s4 = 8;
    public static final int t4 = 0;
    public static final int u4 = 1;
    public static final int v4 = 2;
    public static final int w4 = 3;
    public static final int x4 = 4;
    public static final int y4 = 5;
    public static final int z4 = 6;
    protected float A3 = Float.NaN;
    protected float B3;
    protected float C3;
    protected float D3;
    protected float E3;
    protected int F3 = -1;
    protected Long G3 = q1();
    protected PdfName H3 = PdfName.Q7;
    protected HashMap<PdfName, PdfObject> I3 = null;
    private AccessibleElementId J3 = null;
    private PdfIndirectReference K3;
    protected float L3;
    private float M3;
    protected float N3 = 0.0f;
    protected float O3 = 0.0f;
    protected float P3;
    protected float Q3;
    protected float R3;
    private float S3 = 100.0f;
    protected boolean T3;
    protected boolean U3 = true;
    protected Annotation V3 = null;
    protected PdfOCG W3;
    protected boolean X3;
    protected int Y3 = 0;
    protected byte[] Z3;
    protected boolean a4 = false;
    protected int b4 = 0;
    protected int c4 = 0;
    private float d4 = 0.0f;
    protected int e4 = -1;
    protected int f4 = 1;
    protected boolean g4 = false;
    protected ICC_Profile h4 = null;
    private PdfDictionary i4 = null;
    protected boolean j4 = false;
    protected Image k4;
    private boolean l4;
    protected int[] m4;
    protected int s3;
    protected URL t3;
    protected byte[] u3;
    protected int v3 = 1;
    protected PdfTemplate[] w3 = new PdfTemplate[1];
    protected int x3;
    protected String y3;
    protected float z3 = Float.NaN;

    protected Image(Image image) {
        super((Rectangle) image);
        this.s3 = image.s3;
        this.t3 = image.t3;
        this.u3 = image.u3;
        this.v3 = image.v3;
        this.w3 = image.w3;
        this.x3 = image.x3;
        this.y3 = image.y3;
        this.z3 = image.z3;
        this.A3 = image.A3;
        this.B3 = image.B3;
        this.C3 = image.C3;
        this.D3 = image.D3;
        this.E3 = image.E3;
        this.G3 = image.G3;
        this.K3 = image.K3;
        this.L3 = image.L3;
        this.M3 = image.M3;
        this.N3 = image.N3;
        this.O3 = image.O3;
        this.P3 = image.P3;
        this.Q3 = image.Q3;
        this.S3 = image.S3;
        this.T3 = image.T3;
        this.U3 = image.U3;
        this.V3 = image.V3;
        this.W3 = image.W3;
        this.X3 = image.X3;
        this.Y3 = image.Y3;
        this.Z3 = image.Z3;
        this.a4 = image.a4;
        this.b4 = image.b4;
        this.c4 = image.c4;
        this.d4 = image.d4;
        this.e4 = image.e4;
        this.g4 = image.g4;
        this.h4 = image.h4;
        this.i4 = image.i4;
        this.j4 = image.j4;
        this.k4 = image.k4;
        this.l4 = image.l4;
        this.m4 = image.m4;
        this.H3 = image.H3;
        if (image.I3 != null) {
            this.I3 = new HashMap<>(image.I3);
        }
        D(image.getId());
    }

    public static Image T0(int i2, int i3, int i5, int i6, byte[] bArr) throws BadElementException {
        return U0(i2, i3, i5, i6, bArr, (int[]) null);
    }

    public static Image U0(int i2, int i3, int i5, int i6, byte[] bArr, int[] iArr) throws BadElementException {
        if (iArr != null && iArr.length != i5 * 2) {
            throw new BadElementException(MessageLocalization.b("transparency.length.must.be.equal.to.componentes.2", new Object[0]));
        } else if (i5 == 1 && i6 == 1) {
            return W0(i2, i3, false, 256, 1, CCITTG4Encoder.d(bArr, i2, i3), iArr);
        } else {
            ImgRaw imgRaw = new ImgRaw(i2, i3, i5, i6, bArr);
            imgRaw.m4 = iArr;
            return imgRaw;
        }
    }

    public static Image V0(int i2, int i3, boolean z, int i5, int i6, byte[] bArr) throws BadElementException {
        return W0(i2, i3, z, i5, i6, bArr, (int[]) null);
    }

    public static Image W0(int i2, int i3, boolean z, int i5, int i6, byte[] bArr, int[] iArr) throws BadElementException {
        if (iArr == null || iArr.length == 2) {
            ImgCCITT imgCCITT = new ImgCCITT(i2, i3, z, i5, i6, bArr);
            imgCCITT.m4 = iArr;
            return imgCCITT;
        }
        throw new BadElementException(MessageLocalization.b("transparency.length.must.be.equal.to.2.with.ccitt.images", new Object[0]));
    }

    public static Image X0(int i2, int i3, byte[] bArr, byte[] bArr2) {
        return new ImgJBIG2(i2, i3, bArr, bArr2);
    }

    public static Image Y0(Image image) {
        if (image == null) {
            return null;
        }
        try {
            return (Image) image.getClass().getDeclaredConstructor(new Class[]{Image.class}).newInstance(new Object[]{image});
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public static Image Z0(PRIndirectReference pRIndirectReference) throws BadElementException {
        Image image;
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.w0(pRIndirectReference);
        int e0 = ((PdfNumber) PdfReader.w0(pdfDictionary.d0(PdfName.Jh))).e0();
        int e02 = ((PdfNumber) PdfReader.w0(pdfDictionary.d0(PdfName.h9))).e0();
        PdfObject d0 = pdfDictionary.d0(PdfName.We);
        if (d0 == null || !d0.C()) {
            PdfObject d02 = pdfDictionary.d0(PdfName.Va);
            image = (d02 == null || !d02.C() || !(PdfReader.w0(d02) instanceof PdfDictionary)) ? null : Z0((PRIndirectReference) d02);
        } else {
            image = Z0((PRIndirectReference) d0);
        }
        ImgRaw imgRaw = new ImgRaw(e0, e02, 1, 1, (byte[]) null);
        imgRaw.k4 = image;
        imgRaw.K3 = pRIndirectReference;
        return imgRaw;
    }

    public static Image a1(PdfTemplate pdfTemplate) throws BadElementException {
        return new ImgTemplate(pdfTemplate);
    }

    public static Image b1(String str) throws BadElementException, MalformedURLException, IOException {
        return d1(Utilities.w(str));
    }

    public static Image c1(String str, boolean z) throws IOException, BadElementException {
        return e1(Utilities.w(str), z);
    }

    public static Image d1(URL url) throws BadElementException, MalformedURLException, IOException {
        return e1(url, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:124:0x0164 A[Catch:{ all -> 0x0161, all -> 0x0048 }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00fe A[SYNTHETIC, Splitter:B:83:0x00fe] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x010a A[SYNTHETIC, Splitter:B:89:0x010a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.itextpdf.text.Image e1(java.net.URL r16, boolean r17) throws com.itextpdf.text.BadElementException, java.net.MalformedURLException, java.io.IOException {
        /*
            r1 = r16
            r2 = r17
            r0 = 0
            r3 = 1
            com.itextpdf.text.io.RandomAccessSourceFactory r4 = new com.itextpdf.text.io.RandomAccessSourceFactory
            r4.<init>()
            java.io.InputStream r6 = r16.openStream()     // Catch:{ all -> 0x0048 }
            int r7 = r6.read()     // Catch:{ all -> 0x017d }
            int r8 = r6.read()     // Catch:{ all -> 0x017d }
            int r9 = r6.read()     // Catch:{ all -> 0x017d }
            int r10 = r6.read()     // Catch:{ all -> 0x017d }
            int r11 = r6.read()     // Catch:{ all -> 0x017d }
            int r12 = r6.read()     // Catch:{ all -> 0x017d }
            int r13 = r6.read()     // Catch:{ all -> 0x017d }
            int r14 = r6.read()     // Catch:{ all -> 0x017d }
            r6.close()     // Catch:{ all -> 0x017d }
            r6 = 71
            r15 = 73
            if (r7 != r6) goto L_0x004c
            if (r8 != r15) goto L_0x004c
            r6 = 70
            if (r9 != r6) goto L_0x004c
            com.itextpdf.text.pdf.codec.GifImage r0 = new com.itextpdf.text.pdf.codec.GifImage     // Catch:{ all -> 0x0048 }
            r0.<init>((java.net.URL) r1)     // Catch:{ all -> 0x0048 }
            com.itextpdf.text.Image r0 = r0.d(r3)     // Catch:{ all -> 0x0048 }
            return r0
        L_0x0048:
            r0 = move-exception
            r5 = 0
            goto L_0x017f
        L_0x004c:
            r6 = 255(0xff, float:3.57E-43)
            if (r7 != r6) goto L_0x005a
            r5 = 216(0xd8, float:3.03E-43)
            if (r8 != r5) goto L_0x005a
            com.itextpdf.text.Jpeg r0 = new com.itextpdf.text.Jpeg     // Catch:{ all -> 0x0048 }
            r0.<init>((java.net.URL) r1)     // Catch:{ all -> 0x0048 }
            return r0
        L_0x005a:
            if (r7 != 0) goto L_0x006a
            if (r8 != 0) goto L_0x006a
            if (r9 != 0) goto L_0x006a
            r5 = 12
            if (r10 != r5) goto L_0x006a
            com.itextpdf.text.Jpeg2000 r0 = new com.itextpdf.text.Jpeg2000     // Catch:{ all -> 0x0048 }
            r0.<init>((java.net.URL) r1)     // Catch:{ all -> 0x0048 }
            return r0
        L_0x006a:
            if (r7 != r6) goto L_0x007c
            r5 = 79
            if (r8 != r5) goto L_0x007c
            if (r9 != r6) goto L_0x007c
            r5 = 81
            if (r10 != r5) goto L_0x007c
            com.itextpdf.text.Jpeg2000 r0 = new com.itextpdf.text.Jpeg2000     // Catch:{ all -> 0x0048 }
            r0.<init>((java.net.URL) r1)     // Catch:{ all -> 0x0048 }
            return r0
        L_0x007c:
            int[] r5 = com.itextpdf.text.pdf.codec.PngImage.L     // Catch:{ all -> 0x0048 }
            r6 = r5[r0]     // Catch:{ all -> 0x0048 }
            if (r7 != r6) goto L_0x0095
            r6 = r5[r3]     // Catch:{ all -> 0x0048 }
            if (r8 != r6) goto L_0x0095
            r6 = 2
            r6 = r5[r6]     // Catch:{ all -> 0x0048 }
            if (r9 != r6) goto L_0x0095
            r6 = 3
            r5 = r5[r6]     // Catch:{ all -> 0x0048 }
            if (r10 != r5) goto L_0x0095
            com.itextpdf.text.Image r0 = com.itextpdf.text.pdf.codec.PngImage.l(r16)     // Catch:{ all -> 0x0048 }
            return r0
        L_0x0095:
            r5 = 215(0xd7, float:3.01E-43)
            if (r7 != r5) goto L_0x00a3
            r5 = 205(0xcd, float:2.87E-43)
            if (r8 != r5) goto L_0x00a3
            com.itextpdf.text.ImgWMF r0 = new com.itextpdf.text.ImgWMF     // Catch:{ all -> 0x0048 }
            r0.<init>((java.net.URL) r1)     // Catch:{ all -> 0x0048 }
            return r0
        L_0x00a3:
            r5 = 66
            r6 = 77
            if (r7 != r5) goto L_0x00b0
            if (r8 != r6) goto L_0x00b0
            com.itextpdf.text.Image r0 = com.itextpdf.text.pdf.codec.BmpImage.h(r16)     // Catch:{ all -> 0x0048 }
            return r0
        L_0x00b0:
            java.lang.String r0 = "file"
            r5 = 42
            if (r7 != r6) goto L_0x00bc
            if (r8 != r6) goto L_0x00bc
            if (r9 != 0) goto L_0x00bc
            if (r10 == r5) goto L_0x00c4
        L_0x00bc:
            if (r7 != r15) goto L_0x0111
            if (r8 != r15) goto L_0x0111
            if (r9 != r5) goto L_0x0111
            if (r10 != 0) goto L_0x0111
        L_0x00c4:
            java.lang.String r5 = r16.getProtocol()     // Catch:{ RuntimeException -> 0x00e3, all -> 0x00e0 }
            boolean r0 = r5.equals(r0)     // Catch:{ RuntimeException -> 0x00e3, all -> 0x00e0 }
            if (r0 == 0) goto L_0x00e6
            java.lang.String r0 = r16.getFile()     // Catch:{ RuntimeException -> 0x00e3, all -> 0x00e0 }
            java.lang.String r0 = com.itextpdf.text.Utilities.x(r0)     // Catch:{ RuntimeException -> 0x00e3, all -> 0x00e0 }
            com.itextpdf.text.pdf.RandomAccessFileOrArray r5 = new com.itextpdf.text.pdf.RandomAccessFileOrArray     // Catch:{ RuntimeException -> 0x00e3, all -> 0x00e0 }
            com.itextpdf.text.io.RandomAccessSource r0 = r4.b(r0)     // Catch:{ RuntimeException -> 0x00e3, all -> 0x00e0 }
            r5.<init>((com.itextpdf.text.io.RandomAccessSource) r0)     // Catch:{ RuntimeException -> 0x00e3, all -> 0x00e0 }
            goto L_0x00ef
        L_0x00e0:
            r0 = move-exception
            r5 = 0
            goto L_0x010b
        L_0x00e3:
            r0 = move-exception
            r5 = 0
            goto L_0x00fc
        L_0x00e6:
            com.itextpdf.text.pdf.RandomAccessFileOrArray r5 = new com.itextpdf.text.pdf.RandomAccessFileOrArray     // Catch:{ RuntimeException -> 0x00e3, all -> 0x00e0 }
            com.itextpdf.text.io.RandomAccessSource r0 = r4.i(r1)     // Catch:{ RuntimeException -> 0x00e3, all -> 0x00e0 }
            r5.<init>((com.itextpdf.text.io.RandomAccessSource) r0)     // Catch:{ RuntimeException -> 0x00e3, all -> 0x00e0 }
        L_0x00ef:
            com.itextpdf.text.Image r0 = com.itextpdf.text.pdf.codec.TiffImage.g(r5, r3)     // Catch:{ RuntimeException -> 0x00fb }
            r0.t3 = r1     // Catch:{ RuntimeException -> 0x00fb }
            r5.close()     // Catch:{ all -> 0x0048 }
            return r0
        L_0x00f9:
            r0 = move-exception
            goto L_0x010b
        L_0x00fb:
            r0 = move-exception
        L_0x00fc:
            if (r2 == 0) goto L_0x010a
            com.itextpdf.text.Image r0 = com.itextpdf.text.pdf.codec.TiffImage.i(r5, r2, r3)     // Catch:{ all -> 0x00f9 }
            r0.t3 = r1     // Catch:{ all -> 0x00f9 }
            if (r5 == 0) goto L_0x0109
            r5.close()     // Catch:{ all -> 0x0048 }
        L_0x0109:
            return r0
        L_0x010a:
            throw r0     // Catch:{ all -> 0x00f9 }
        L_0x010b:
            if (r5 == 0) goto L_0x0110
            r5.close()     // Catch:{ all -> 0x0048 }
        L_0x0110:
            throw r0     // Catch:{ all -> 0x0048 }
        L_0x0111:
            r2 = 151(0x97, float:2.12E-43)
            if (r7 != r2) goto L_0x0168
            r2 = 74
            if (r8 != r2) goto L_0x0168
            r2 = 66
            if (r9 != r2) goto L_0x0168
            r2 = 50
            if (r10 != r2) goto L_0x0168
            r2 = 13
            if (r11 != r2) goto L_0x0168
            r2 = 10
            if (r12 != r2) goto L_0x0168
            r5 = 26
            if (r13 != r5) goto L_0x0168
            if (r14 != r2) goto L_0x0168
            java.lang.String r2 = r16.getProtocol()     // Catch:{ all -> 0x014b }
            boolean r0 = r2.equals(r0)     // Catch:{ all -> 0x014b }
            if (r0 == 0) goto L_0x014e
            java.lang.String r0 = r16.getFile()     // Catch:{ all -> 0x014b }
            java.lang.String r0 = com.itextpdf.text.Utilities.x(r0)     // Catch:{ all -> 0x014b }
            com.itextpdf.text.pdf.RandomAccessFileOrArray r2 = new com.itextpdf.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x014b }
            com.itextpdf.text.io.RandomAccessSource r0 = r4.b(r0)     // Catch:{ all -> 0x014b }
            r2.<init>((com.itextpdf.text.io.RandomAccessSource) r0)     // Catch:{ all -> 0x014b }
            goto L_0x0157
        L_0x014b:
            r0 = move-exception
            r2 = 0
            goto L_0x0162
        L_0x014e:
            com.itextpdf.text.pdf.RandomAccessFileOrArray r2 = new com.itextpdf.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x014b }
            com.itextpdf.text.io.RandomAccessSource r0 = r4.i(r1)     // Catch:{ all -> 0x014b }
            r2.<init>((com.itextpdf.text.io.RandomAccessSource) r0)     // Catch:{ all -> 0x014b }
        L_0x0157:
            com.itextpdf.text.Image r0 = com.itextpdf.text.pdf.codec.JBIG2Image.b(r2, r3)     // Catch:{ all -> 0x0161 }
            r0.t3 = r1     // Catch:{ all -> 0x0161 }
            r2.close()     // Catch:{ all -> 0x0048 }
            return r0
        L_0x0161:
            r0 = move-exception
        L_0x0162:
            if (r2 == 0) goto L_0x0167
            r2.close()     // Catch:{ all -> 0x0048 }
        L_0x0167:
            throw r0     // Catch:{ all -> 0x0048 }
        L_0x0168:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0048 }
            java.lang.String r2 = "unknown.image.format"
            java.lang.String r1 = r16.toString()     // Catch:{ all -> 0x0048 }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0048 }
            r4 = 0
            r3[r4] = r1     // Catch:{ all -> 0x0048 }
            java.lang.String r1 = com.itextpdf.text.error_messages.MessageLocalization.b(r2, r3)     // Catch:{ all -> 0x0048 }
            r0.<init>(r1)     // Catch:{ all -> 0x0048 }
            throw r0     // Catch:{ all -> 0x0048 }
        L_0x017d:
            r0 = move-exception
            r5 = r6
        L_0x017f:
            if (r5 == 0) goto L_0x0184
            r5.close()
        L_0x0184:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.Image.e1(java.net.URL, boolean):com.itextpdf.text.Image");
    }

    public static Image f1(byte[] bArr) throws BadElementException, MalformedURLException, IOException {
        return g1(bArr, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.itextpdf.text.pdf.RandomAccessFileOrArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.io.ByteArrayInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.itextpdf.text.pdf.RandomAccessFileOrArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.io.ByteArrayInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.itextpdf.text.pdf.RandomAccessFileOrArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v7, resolved type: java.io.ByteArrayInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.io.ByteArrayInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.itextpdf.text.pdf.RandomAccessFileOrArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.itextpdf.text.pdf.RandomAccessFileOrArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: com.itextpdf.text.pdf.RandomAccessFileOrArray} */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x014f A[SYNTHETIC, Splitter:B:130:0x014f] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00d5 A[SYNTHETIC, Splitter:B:82:0x00d5] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00e8 A[SYNTHETIC, Splitter:B:90:0x00e8] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:134:0x0154=Splitter:B:134:0x0154, B:74:0x00ca=Splitter:B:74:0x00ca} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.itextpdf.text.Image g1(byte[] r12, boolean r13) throws com.itextpdf.text.BadElementException, java.net.MalformedURLException, java.io.IOException {
        /*
            com.itextpdf.text.io.RandomAccessSourceFactory r0 = new com.itextpdf.text.io.RandomAccessSourceFactory
            r0.<init>()
            r1 = 0
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0035 }
            r2.<init>(r12)     // Catch:{ all -> 0x0035 }
            int r3 = r2.read()     // Catch:{ all -> 0x0162 }
            int r4 = r2.read()     // Catch:{ all -> 0x0162 }
            int r5 = r2.read()     // Catch:{ all -> 0x0162 }
            int r6 = r2.read()     // Catch:{ all -> 0x0162 }
            r2.close()     // Catch:{ all -> 0x0162 }
            r2 = 71
            r7 = 73
            r8 = 1
            if (r3 != r2) goto L_0x0038
            if (r4 != r7) goto L_0x0038
            r2 = 70
            if (r5 != r2) goto L_0x0038
            com.itextpdf.text.pdf.codec.GifImage r13 = new com.itextpdf.text.pdf.codec.GifImage     // Catch:{ all -> 0x0035 }
            r13.<init>((byte[]) r12)     // Catch:{ all -> 0x0035 }
            com.itextpdf.text.Image r12 = r13.d(r8)     // Catch:{ all -> 0x0035 }
            return r12
        L_0x0035:
            r12 = move-exception
            goto L_0x0164
        L_0x0038:
            r2 = 255(0xff, float:3.57E-43)
            if (r3 != r2) goto L_0x0046
            r9 = 216(0xd8, float:3.03E-43)
            if (r4 != r9) goto L_0x0046
            com.itextpdf.text.Jpeg r13 = new com.itextpdf.text.Jpeg     // Catch:{ all -> 0x0035 }
            r13.<init>((byte[]) r12)     // Catch:{ all -> 0x0035 }
            return r13
        L_0x0046:
            if (r3 != 0) goto L_0x0056
            if (r4 != 0) goto L_0x0056
            if (r5 != 0) goto L_0x0056
            r9 = 12
            if (r6 != r9) goto L_0x0056
            com.itextpdf.text.Jpeg2000 r13 = new com.itextpdf.text.Jpeg2000     // Catch:{ all -> 0x0035 }
            r13.<init>((byte[]) r12)     // Catch:{ all -> 0x0035 }
            return r13
        L_0x0056:
            if (r3 != r2) goto L_0x0068
            r9 = 79
            if (r4 != r9) goto L_0x0068
            if (r5 != r2) goto L_0x0068
            r2 = 81
            if (r6 != r2) goto L_0x0068
            com.itextpdf.text.Jpeg2000 r13 = new com.itextpdf.text.Jpeg2000     // Catch:{ all -> 0x0035 }
            r13.<init>((byte[]) r12)     // Catch:{ all -> 0x0035 }
            return r13
        L_0x0068:
            int[] r2 = com.itextpdf.text.pdf.codec.PngImage.L     // Catch:{ all -> 0x0035 }
            r9 = 0
            r10 = r2[r9]     // Catch:{ all -> 0x0035 }
            if (r3 != r10) goto L_0x0082
            r10 = r2[r8]     // Catch:{ all -> 0x0035 }
            if (r4 != r10) goto L_0x0082
            r10 = 2
            r10 = r2[r10]     // Catch:{ all -> 0x0035 }
            if (r5 != r10) goto L_0x0082
            r10 = 3
            r2 = r2[r10]     // Catch:{ all -> 0x0035 }
            if (r6 != r2) goto L_0x0082
            com.itextpdf.text.Image r12 = com.itextpdf.text.pdf.codec.PngImage.m(r12)     // Catch:{ all -> 0x0035 }
            return r12
        L_0x0082:
            r2 = 215(0xd7, float:3.01E-43)
            if (r3 != r2) goto L_0x0090
            r2 = 205(0xcd, float:2.87E-43)
            if (r4 != r2) goto L_0x0090
            com.itextpdf.text.ImgWMF r13 = new com.itextpdf.text.ImgWMF     // Catch:{ all -> 0x0035 }
            r13.<init>((byte[]) r12)     // Catch:{ all -> 0x0035 }
            return r13
        L_0x0090:
            r2 = 66
            r10 = 77
            if (r3 != r2) goto L_0x009d
            if (r4 != r10) goto L_0x009d
            com.itextpdf.text.Image r12 = com.itextpdf.text.pdf.codec.BmpImage.i(r12)     // Catch:{ all -> 0x0035 }
            return r12
        L_0x009d:
            r11 = 42
            if (r3 != r10) goto L_0x00a7
            if (r4 != r10) goto L_0x00a7
            if (r5 != 0) goto L_0x00a7
            if (r6 == r11) goto L_0x00af
        L_0x00a7:
            if (r3 != r7) goto L_0x00ef
            if (r4 != r7) goto L_0x00ef
            if (r5 != r11) goto L_0x00ef
            if (r6 != 0) goto L_0x00ef
        L_0x00af:
            com.itextpdf.text.pdf.RandomAccessFileOrArray r2 = new com.itextpdf.text.pdf.RandomAccessFileOrArray     // Catch:{ RuntimeException -> 0x00d1, all -> 0x00ce }
            com.itextpdf.text.io.RandomAccessSource r0 = r0.j(r12)     // Catch:{ RuntimeException -> 0x00d1, all -> 0x00ce }
            r2.<init>((com.itextpdf.text.io.RandomAccessSource) r0)     // Catch:{ RuntimeException -> 0x00d1, all -> 0x00ce }
            com.itextpdf.text.Image r0 = com.itextpdf.text.pdf.codec.TiffImage.g(r2, r8)     // Catch:{ RuntimeException -> 0x00c8 }
            byte[] r3 = r0.j1()     // Catch:{ RuntimeException -> 0x00c8 }
            if (r3 != 0) goto L_0x00ca
            r0.j2(r12)     // Catch:{ RuntimeException -> 0x00c8 }
            goto L_0x00ca
        L_0x00c6:
            r12 = move-exception
            goto L_0x00e9
        L_0x00c8:
            r0 = move-exception
            goto L_0x00d3
        L_0x00ca:
            r2.close()     // Catch:{ all -> 0x0035 }
            return r0
        L_0x00ce:
            r12 = move-exception
            r2 = r1
            goto L_0x00e9
        L_0x00d1:
            r0 = move-exception
            r2 = r1
        L_0x00d3:
            if (r13 == 0) goto L_0x00e8
            com.itextpdf.text.Image r13 = com.itextpdf.text.pdf.codec.TiffImage.i(r2, r13, r8)     // Catch:{ all -> 0x00c6 }
            byte[] r0 = r13.j1()     // Catch:{ all -> 0x00c6 }
            if (r0 != 0) goto L_0x00e2
            r13.j2(r12)     // Catch:{ all -> 0x00c6 }
        L_0x00e2:
            if (r2 == 0) goto L_0x00e7
            r2.close()     // Catch:{ all -> 0x0035 }
        L_0x00e7:
            return r13
        L_0x00e8:
            throw r0     // Catch:{ all -> 0x00c6 }
        L_0x00e9:
            if (r2 == 0) goto L_0x00ee
            r2.close()     // Catch:{ all -> 0x0035 }
        L_0x00ee:
            throw r12     // Catch:{ all -> 0x0035 }
        L_0x00ef:
            r13 = 151(0x97, float:2.12E-43)
            if (r3 != r13) goto L_0x0154
            r13 = 74
            if (r4 != r13) goto L_0x0154
            if (r5 != r2) goto L_0x0154
            r13 = 50
            if (r6 != r13) goto L_0x0154
            java.io.ByteArrayInputStream r13 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0035 }
            r13.<init>(r12)     // Catch:{ all -> 0x0035 }
            r2 = 4
            r13.skip(r2)     // Catch:{ all -> 0x0149 }
            int r2 = r13.read()     // Catch:{ all -> 0x0149 }
            int r3 = r13.read()     // Catch:{ all -> 0x0149 }
            int r4 = r13.read()     // Catch:{ all -> 0x0149 }
            int r5 = r13.read()     // Catch:{ all -> 0x0149 }
            r13.close()     // Catch:{ all -> 0x0149 }
            r6 = 13
            if (r2 != r6) goto L_0x0153
            r2 = 10
            if (r3 != r2) goto L_0x0153
            r3 = 26
            if (r4 != r3) goto L_0x0153
            if (r5 != r2) goto L_0x0153
            com.itextpdf.text.pdf.RandomAccessFileOrArray r2 = new com.itextpdf.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x014c }
            com.itextpdf.text.io.RandomAccessSource r0 = r0.j(r12)     // Catch:{ all -> 0x014c }
            r2.<init>((com.itextpdf.text.io.RandomAccessSource) r0)     // Catch:{ all -> 0x014c }
            com.itextpdf.text.Image r0 = com.itextpdf.text.pdf.codec.JBIG2Image.b(r2, r8)     // Catch:{ all -> 0x013f }
            byte[] r1 = r0.j1()     // Catch:{ all -> 0x013f }
            if (r1 != 0) goto L_0x0142
            r0.j2(r12)     // Catch:{ all -> 0x013f }
            goto L_0x0142
        L_0x013f:
            r12 = move-exception
            r1 = r2
            goto L_0x014d
        L_0x0142:
            r2.close()     // Catch:{ all -> 0x0149 }
            r13.close()
            return r0
        L_0x0149:
            r12 = move-exception
            r1 = r13
            goto L_0x0164
        L_0x014c:
            r12 = move-exception
        L_0x014d:
            if (r1 == 0) goto L_0x0152
            r1.close()     // Catch:{ all -> 0x0149 }
        L_0x0152:
            throw r12     // Catch:{ all -> 0x0149 }
        L_0x0153:
            r1 = r13
        L_0x0154:
            java.io.IOException r12 = new java.io.IOException     // Catch:{ all -> 0x0035 }
            java.lang.String r13 = "the.byte.array.is.not.a.recognized.imageformat"
            java.lang.Object[] r0 = new java.lang.Object[r9]     // Catch:{ all -> 0x0035 }
            java.lang.String r13 = com.itextpdf.text.error_messages.MessageLocalization.b(r13, r0)     // Catch:{ all -> 0x0035 }
            r12.<init>(r13)     // Catch:{ all -> 0x0035 }
            throw r12     // Catch:{ all -> 0x0035 }
        L_0x0162:
            r12 = move-exception
            r1 = r2
        L_0x0164:
            if (r1 == 0) goto L_0x0169
            r1.close()
        L_0x0169:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.Image.g1(byte[], boolean):com.itextpdf.text.Image");
    }

    protected static synchronized Long q1() {
        Long valueOf;
        synchronized (Image.class) {
            long j2 = L4 + 1;
            L4 = j2;
            valueOf = Long.valueOf(j2);
        }
        return valueOf;
    }

    private PdfObject v2(PdfArray pdfArray) {
        if (pdfArray == null) {
            return pdfArray;
        }
        PdfName I0 = pdfArray.I0(0);
        if (PdfName.P4.equals(I0)) {
            return PdfName.A6;
        }
        return PdfName.Q4.equals(I0) ? PdfName.B6 : pdfArray;
    }

    public boolean A1() {
        return this.s3 == 34;
    }

    public void B(float f2) {
        this.O3 = f2;
    }

    public boolean B1() {
        return this.s3 == 35;
    }

    public boolean C1() {
        return this.X3;
    }

    public void D(AccessibleElementId accessibleElementId) {
        this.J3 = accessibleElementId;
    }

    public float D0() {
        return this.z3;
    }

    public boolean D1() {
        return this.g4;
    }

    public float E() {
        return this.P3;
    }

    public float E0() {
        return this.A3;
    }

    public boolean E1() {
        return this.s3 == 32;
    }

    public PdfDictionary F0() {
        return this.i4;
    }

    public boolean F1() {
        return this.j4;
    }

    public int G0() {
        return this.x3;
    }

    public boolean G1() {
        return (this.s3 == 34 && this.v3 > 255) || this.e4 == 1;
    }

    public Annotation H0() {
        return this.V3;
    }

    public boolean H1() {
        return this.U3;
    }

    public int I0() {
        return this.v3;
    }

    public boolean I1() {
        return this.T3;
    }

    public int J0() {
        return this.f4;
    }

    public boolean J1() {
        return this.l4;
    }

    public float K() {
        return this.Q3;
    }

    public int K0() {
        return this.e4;
    }

    public void K1() throws DocumentException {
        if (G1()) {
            this.j4 = true;
            return;
        }
        throw new DocumentException(MessageLocalization.b("this.image.can.not.be.an.image.mask", new Object[0]));
    }

    public PdfName L() {
        return this.H3;
    }

    public int L0() {
        return this.F3;
    }

    public float[] L1() {
        return M1(1.0f);
    }

    public void M(float f2) {
        this.R3 = f2;
    }

    public PdfIndirectReference M0() {
        return this.K3;
    }

    public float[] M1(float f2) {
        float[] fArr = new float[8];
        float cos = (float) Math.cos((double) this.L3);
        float sin = (float) Math.sin((double) this.L3);
        float f3 = this.B3;
        float f5 = f3 * cos * f2;
        fArr[0] = f5;
        float f6 = f3 * sin * f2;
        fArr[1] = f6;
        float f7 = this.C3;
        float f8 = (-f7) * sin * f2;
        fArr[2] = f8;
        float f9 = f7 * cos * f2;
        fArr[3] = f9;
        float f10 = this.L3;
        if (((double) f10) < 1.5707963267948966d) {
            fArr[4] = f8;
            fArr[5] = 0.0f;
            fArr[6] = f5;
            fArr[7] = f6 + f9;
        } else if (((double) f10) < 3.141592653589793d) {
            fArr[4] = f5 + f8;
            fArr[5] = f9;
            fArr[6] = 0.0f;
            fArr[7] = f6;
        } else if (((double) f10) < 4.71238898038469d) {
            fArr[4] = f5;
            fArr[5] = f6 + f9;
            fArr[6] = f8;
            fArr[7] = 0.0f;
        } else {
            fArr[4] = 0.0f;
            fArr[5] = f6;
            fArr[6] = f5 + f8;
            fArr[7] = f9;
        }
        return fArr;
    }

    public int N0() {
        return this.b4;
    }

    public void N1(float f2, float f3) {
        this.B3 = f2;
        this.C3 = f3;
        float[] L1 = L1();
        this.D3 = L1[6] - L1[4];
        this.E3 = L1[7] - L1[5];
        t2(0.0f);
    }

    public int O0() {
        return this.c4;
    }

    public void O1(Rectangle rectangle) {
        N1(rectangle.a0(), rectangle.N());
    }

    public ICC_Profile P0() {
        return this.h4;
    }

    public void P1(float f2) {
        this.C3 = f2;
        float[] L1 = L1();
        this.D3 = L1[6] - L1[4];
        this.E3 = L1[7] - L1[5];
        t2(0.0f);
    }

    public Image Q0() {
        return this.k4;
    }

    public void Q1(float f2) {
        this.B3 = f2;
        float[] L1 = L1();
        this.D3 = L1[6] - L1[4];
        this.E3 = L1[7] - L1[5];
        t2(0.0f);
    }

    public float R0() {
        float f2 = (float) (((double) (this.L3 - this.M3)) % 6.283185307179586d);
        return f2 < 0.0f ? (float) (((double) f2) + 6.283185307179586d) : f2;
    }

    public void R1(float f2) {
        S1(f2, f2);
    }

    public float S0() {
        return this.M3;
    }

    public void S1(float f2, float f3) {
        this.B3 = (a0() * f2) / 100.0f;
        this.C3 = (N() * f3) / 100.0f;
        float[] L1 = L1();
        this.D3 = L1[6] - L1[4];
        this.E3 = L1[7] - L1[5];
        t2(0.0f);
    }

    public void T1(float f2, float f3) {
        R1(100.0f);
        float p1 = (f2 * 100.0f) / p1();
        float o1 = (f3 * 100.0f) / o1();
        if (p1 >= o1) {
            p1 = o1;
        }
        R1(p1);
        t2(0.0f);
    }

    public void U(PdfName pdfName, PdfObject pdfObject) {
        if (this.I3 == null) {
            this.I3 = new HashMap<>();
        }
        this.I3.put(pdfName, pdfObject);
    }

    public void U1(Rectangle rectangle) {
        T1(rectangle.a0(), rectangle.N());
    }

    public void V1(float f2, float f3) {
        this.z3 = f2;
        this.A3 = f3;
    }

    public void W1(PdfDictionary pdfDictionary) {
        this.i4 = pdfDictionary;
    }

    public float X() {
        return this.R3;
    }

    public void X1(int i2) {
        this.x3 = i2;
    }

    public void Y1(Annotation annotation) {
        this.V3 = annotation;
    }

    public void Z1(int i2) {
        this.f4 = i2;
    }

    public String a() {
        return this.y3;
    }

    public void a2(int i2) {
        if (i2 < 0 || i2 > 9) {
            i2 = -1;
        }
        this.F3 = i2;
    }

    public void b2(boolean z) {
        this.a4 = z;
    }

    public void c(float f2) {
        this.Q3 = f2;
    }

    public void c2(PdfIndirectReference pdfIndirectReference) {
        this.K3 = pdfIndirectReference;
    }

    public void d2(int i2, int i3) {
        this.b4 = i2;
        this.c4 = i3;
    }

    public void e(String str) {
        this.y3 = str;
        U(PdfName.J3, new PdfString(str));
    }

    public void e2(Image image) throws DocumentException {
        boolean z = false;
        if (this.j4) {
            throw new DocumentException(MessageLocalization.b("an.image.mask.cannot.contain.another.image.mask", new Object[0]));
        } else if (image.j4) {
            this.k4 = image;
            int i2 = image.v3;
            if (i2 > 1 && i2 <= 8) {
                z = true;
            }
            this.l4 = z;
        } else {
            throw new DocumentException(MessageLocalization.b("the.image.mask.is.not.a.mask.did.you.do.makemask", new Object[0]));
        }
    }

    public void f2(float f2) {
        this.M3 = f2;
        l2(this.L3 - this.M3);
    }

    public void g(float f2) {
        this.N3 = f2;
    }

    public void g2(boolean z) {
        this.X3 = z;
    }

    public AccessibleElementId getId() {
        if (this.J3 == null) {
            this.J3 = new AccessibleElementId();
        }
        return this.J3;
    }

    public void h(float f2) {
        this.P3 = f2;
    }

    public PdfOCG h1() {
        return this.W3;
    }

    public void h2(boolean z) {
        this.g4 = z;
    }

    public Long i1() {
        return this.G3;
    }

    public void i2(PdfOCG pdfOCG) {
        this.W3 = pdfOCG;
    }

    public byte[] j1() {
        return this.Z3;
    }

    public void j2(byte[] bArr) {
        this.Z3 = bArr;
    }

    public HashMap<PdfName, PdfObject> k0() {
        return this.I3;
    }

    public int k1() {
        return this.Y3;
    }

    public void k2(int i2) {
        this.Y3 = i2;
    }

    public float l1() {
        return this.C3;
    }

    public void l2(float f2) {
        float f3 = (float) (((double) (f2 + this.M3)) % 6.283185307179586d);
        this.L3 = f3;
        if (f3 < 0.0f) {
            this.L3 = (float) (((double) f3) + 6.283185307179586d);
        }
        float[] L1 = L1();
        this.D3 = L1[6] - L1[4];
        this.E3 = L1[7] - L1[5];
    }

    public float m() {
        return this.N3;
    }

    public float m1() {
        return this.B3;
    }

    public void m2(float f2) {
        l2((f2 / 180.0f) * ((float) 3.141592653589793d));
    }

    public boolean n() {
        return true;
    }

    public byte[] n1() {
        return this.u3;
    }

    public void n2(boolean z) {
        this.U3 = z;
    }

    public void o(PdfName pdfName) {
        this.H3 = pdfName;
    }

    public float o1() {
        return this.E3;
    }

    public void o2(boolean z) {
        this.T3 = z;
    }

    public float p1() {
        return this.D3;
    }

    public void p2(boolean z) {
        this.l4 = z;
    }

    public float q() {
        return this.O3;
    }

    public void q2(PdfTemplate pdfTemplate) {
        this.w3[0] = pdfTemplate;
    }

    public PdfObject r(PdfName pdfName) {
        HashMap<PdfName, PdfObject> hashMap = this.I3;
        if (hashMap != null) {
            return hashMap.get(pdfName);
        }
        return null;
    }

    public PdfTemplate r1() {
        return this.w3[0];
    }

    public void r2(int[] iArr) {
        this.m4 = iArr;
    }

    public int[] s1() {
        return this.m4;
    }

    public void s2(URL url) {
        this.t3 = url;
    }

    public URL t1() {
        return this.t3;
    }

    public void t2(float f2) {
        this.S3 = f2;
    }

    public int type() {
        return this.s3;
    }

    public float u1() {
        return this.S3;
    }

    public void u2(float f2) {
        this.d4 = f2;
    }

    public float v1() {
        return this.d4;
    }

    public boolean w1() {
        return !Float.isNaN(this.z3);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.itextpdf.text.pdf.PdfArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: com.itextpdf.text.pdf.PdfObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.itextpdf.text.pdf.PdfArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: com.itextpdf.text.pdf.PdfArray} */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r1 = com.itextpdf.text.pdf.PdfName.w5;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void w2() {
        /*
            r4 = this;
            com.itextpdf.text.pdf.PdfDictionary r0 = r4.i4
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.w5
            com.itextpdf.text.pdf.PdfArray r0 = r0.e0(r1)
            if (r0 != 0) goto L_0x000e
            return
        L_0x000e:
            com.itextpdf.text.pdf.PdfObject r2 = r4.v2(r0)
            boolean r3 = r2.E()
            if (r3 == 0) goto L_0x001a
            r0 = r2
            goto L_0x003c
        L_0x001a:
            r2 = 0
            com.itextpdf.text.pdf.PdfName r2 = r0.I0(r2)
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.N9
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x003c
            int r2 = r0.size()
            r3 = 2
            if (r2 < r3) goto L_0x003c
            r2 = 1
            com.itextpdf.text.pdf.PdfArray r3 = r0.x0(r2)
            if (r3 == 0) goto L_0x003c
            com.itextpdf.text.pdf.PdfObject r3 = r4.v2(r3)
            r0.V0(r2, r3)
        L_0x003c:
            com.itextpdf.text.pdf.PdfDictionary r2 = r4.i4
            r2.V0(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.Image.w2():void");
    }

    public boolean x() {
        return true;
    }

    public boolean x1() {
        return !Float.isNaN(this.A3);
    }

    public void x2(ICC_Profile iCC_Profile) {
        this.h4 = iCC_Profile;
    }

    public boolean y1() {
        return this.h4 != null;
    }

    public boolean z1() {
        return this.a4;
    }

    public Image(URL url) {
        super(0.0f, 0.0f);
        this.t3 = url;
        this.x3 = 0;
        this.L3 = 0.0f;
    }
}
