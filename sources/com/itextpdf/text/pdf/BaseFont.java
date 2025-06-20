package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.InvalidPdfException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.scheduling.WorkQueueKt;

public abstract class BaseFont {
    public static final int A3 = 4;
    public static final int B3 = 5;
    public static final int C3 = 6;
    public static final int D3 = 7;
    public static final int E3 = 8;
    public static final int F3 = 9;
    public static final int G3 = 10;
    public static final int H3 = 11;
    public static final int I3 = 12;
    public static final int J3 = 13;
    public static final int K3 = 14;
    public static final int L3 = 15;
    public static final int M3 = 16;
    public static final int N3 = 17;
    public static final int O3 = 18;
    public static final int P3 = 19;
    public static final int Q3 = 20;
    public static final int R3 = 21;
    public static final int S3 = 22;
    public static final int T3 = 23;
    public static final int U3 = 0;
    public static final int V3 = 1;
    public static final int W3 = 2;
    public static final int X3 = 3;
    public static final int Y3 = 4;
    public static final int Z3 = 5;
    public static final String a4 = "Identity-H";
    public static final String b4 = "Identity-V";
    public static final String c4 = "Cp1250";
    public static final String d4 = "Cp1252";
    public static final String e4 = "Cp1257";
    public static final String f4 = "Cp1252";
    public static final String g4 = "MacRoman";
    public static final int[] h4 = {0, 383, 8192, 8303, 8352, 8399, 64256, 64262};
    public static final int[] i4 = {0, WorkQueueKt.f29430c, 1536, 1663, 8352, 8399, 64336, 64511, 65136, 65279};
    public static final String j3 = "Courier";
    public static final int[] j4 = {0, WorkQueueKt.f29430c, 1424, 1535, 8352, 8399, 64285, 64335};
    public static final String k3 = "Courier-Bold";
    public static final int[] k4 = {0, WorkQueueKt.f29430c, 1024, 1327, 8192, 8303, 8352, 8399};
    public static final String l3 = "Courier-Oblique";
    public static final double[] l4 = {0.001d, 0.0d, 0.0d, 0.001d, 0.0d, 0.0d};
    public static final String m3 = "Courier-BoldOblique";
    public static final boolean m4 = true;
    public static final String n3 = "Helvetica";
    public static final boolean n4 = false;
    public static final String o3 = "Helvetica-Bold";
    public static final boolean o4 = true;
    public static final String p3 = "Helvetica-Oblique";
    public static final boolean p4 = false;
    public static final String q3 = "Helvetica-BoldOblique";
    public static final String q4 = "com/itextpdf/text/pdf/fonts/";
    public static final String r3 = "Symbol";
    public static final char r4 = '翿';
    public static final String s3 = "Times-Roman";
    public static final char s4 = ' ';
    public static final String t3 = "Times-Bold";
    public static final String t4 = ".notdef";
    public static final String u3 = "Times-Italic";
    protected static ConcurrentHashMap<String, BaseFont> u4 = new ConcurrentHashMap<>();
    public static final String v3 = "Times-BoldItalic";
    protected static final HashMap<String, PdfName> v4;
    public static final String w3 = "ZapfDingbats";
    public static final int x3 = 1;
    public static final int y3 = 2;
    public static final int z3 = 3;
    int X;
    protected char[] X2 = new char[256];
    protected int[] Y = new int[256];
    protected int[][] Y2 = new int[256][];
    protected String[] Z = new String[256];
    protected String Z2;
    protected boolean a3;
    protected int b3 = -1;
    protected boolean c3 = true;
    protected boolean d3 = false;
    protected boolean e3 = false;
    protected boolean f3 = true;
    protected boolean g3 = false;
    protected IntHashtable h3;
    protected boolean i3 = false;
    protected ArrayList<int[]> s;

    static class StreamFont extends PdfStream {
        public StreamFont(byte[] bArr, String str, int i2) throws DocumentException {
            try {
                this.s = bArr;
                V0(PdfName.va, new PdfNumber(bArr.length));
                if (str != null) {
                    V0(PdfName.Cf, new PdfName(str));
                }
                i1(i2);
            } catch (Exception e2) {
                throw new DocumentException(e2);
            }
        }

        public StreamFont(byte[] bArr, int[] iArr, int i2) throws DocumentException {
            try {
                this.s = bArr;
                V0(PdfName.va, new PdfNumber(bArr.length));
                int i3 = 0;
                while (i3 < iArr.length) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Length");
                    int i4 = i3 + 1;
                    sb.append(i4);
                    V0(new PdfName(sb.toString()), new PdfNumber(iArr[i3]));
                    i3 = i4;
                }
                i1(i2);
            } catch (Exception e2) {
                throw new DocumentException(e2);
            }
        }
    }

    static {
        HashMap<String, PdfName> hashMap = new HashMap<>();
        v4 = hashMap;
        hashMap.put("Courier", PdfName.Q5);
        hashMap.put("Courier-Bold", PdfName.R5);
        hashMap.put("Courier-BoldOblique", PdfName.T5);
        hashMap.put("Courier-Oblique", PdfName.S5);
        hashMap.put("Helvetica", PdfName.j9);
        hashMap.put("Helvetica-Bold", PdfName.k9);
        hashMap.put("Helvetica-BoldOblique", PdfName.m9);
        hashMap.put("Helvetica-Oblique", PdfName.l9);
        hashMap.put("Symbol", PdfName.Hf);
        hashMap.put("Times-Roman", PdfName.eg);
        hashMap.put("Times-Bold", PdfName.fg);
        hashMap.put("Times-BoldItalic", PdfName.hg);
        hashMap.put("Times-Italic", PdfName.gg);
        hashMap.put("ZapfDingbats", PdfName.ii);
    }

    protected BaseFont() {
    }

    public static ArrayList<Object[]> E(PdfReader pdfReader) {
        IntHashtable intHashtable = new IntHashtable();
        ArrayList<Object[]> arrayList = new ArrayList<>();
        int c0 = pdfReader.c0();
        for (int i2 = 1; i2 <= c0; i2++) {
            k0(pdfReader.h0(i2), intHashtable, arrayList, 1, new HashSet());
        }
        return arrayList;
    }

    public static ArrayList<Object[]> F(PdfReader pdfReader, int i2) {
        IntHashtable intHashtable = new IntHashtable();
        ArrayList<Object[]> arrayList = new ArrayList<>();
        k0(pdfReader.h0(i2), intHashtable, arrayList, 1, new HashSet());
        return arrayList;
    }

    public static String[][] M(String str, String str2, byte[] bArr) throws DocumentException, IOException {
        String w = w(str);
        return ((w.toLowerCase().endsWith(".ttf") || w.toLowerCase().endsWith(".otf") || w.toLowerCase().indexOf(".ttc,") > 0) ? new TrueTypeFont(str, "Cp1252", false, bArr, true, false) : l(str, str2, false, false, bArr, (byte[]) null)).L();
    }

    private static void a(PRIndirectReference pRIndirectReference, IntHashtable intHashtable, ArrayList<Object[]> arrayList) {
        PdfObject t0 = PdfReader.t0(pRIndirectReference);
        if (t0 != null && t0.z()) {
            PdfDictionary pdfDictionary = (PdfDictionary) t0;
            PdfName p0 = pdfDictionary.p0(PdfName.Cf);
            if (PdfName.Mg.equals(p0) || PdfName.Ag.equals(p0) || PdfName.Lg.equals(p0)) {
                arrayList.add(new Object[]{PdfName.a0(pdfDictionary.p0(PdfName.l4).toString()), pRIndirectReference});
                intHashtable.l(pRIndirectReference.d(), 1);
            }
        }
    }

    public static BaseFont h() throws DocumentException, IOException {
        return j("Helvetica", "Cp1252", false);
    }

    public static BaseFont i(PRIndirectReference pRIndirectReference) {
        return new DocumentFont(pRIndirectReference);
    }

    public static BaseFont j(String str, String str2, boolean z) throws DocumentException, IOException {
        return m(str, str2, z, true, (byte[]) null, (byte[]) null, false);
    }

    protected static String j0(String str) {
        if (str.equals("winansi") || str.equals("")) {
            return "Cp1252";
        }
        return str.equals("macroman") ? g4 : str;
    }

    public static BaseFont k(String str, String str2, boolean z, boolean z2) throws DocumentException, IOException {
        return m(str, str2, z, true, (byte[]) null, (byte[]) null, z2);
    }

    private static void k0(PdfDictionary pdfDictionary, IntHashtable intHashtable, ArrayList<Object[]> arrayList, int i2, HashSet<PdfDictionary> hashSet) {
        PdfDictionary j0;
        int i5 = i2 + 1;
        if (i5 <= 50 && pdfDictionary != null && (j0 = pdfDictionary.j0(PdfName.Wd)) != null) {
            PdfDictionary j02 = j0.j0(PdfName.l8);
            if (j02 != null) {
                for (PdfName d0 : j02.G0()) {
                    PdfObject d02 = j02.d0(d0);
                    if (d02 != null && d02.C()) {
                        PRIndirectReference pRIndirectReference = (PRIndirectReference) d02;
                        if (!intHashtable.c(pRIndirectReference.d())) {
                            a(pRIndirectReference, intHashtable, arrayList);
                        }
                    }
                }
            }
            PdfDictionary j03 = j0.j0(PdfName.ai);
            if (j03 == null) {
                return;
            }
            if (hashSet.add(j03)) {
                for (PdfName B0 : j03.G0()) {
                    PdfObject B02 = j03.B0(B0);
                    if (B02 instanceof PdfDictionary) {
                        k0((PdfDictionary) B02, intHashtable, arrayList, i5, hashSet);
                    }
                }
                hashSet.remove(j03);
                return;
            }
            throw new ExceptionConverter(new InvalidPdfException(MessageLocalization.b("illegal.resources.tree", new Object[0])));
        }
    }

    public static BaseFont l(String str, String str2, boolean z, boolean z2, byte[] bArr, byte[] bArr2) throws DocumentException, IOException {
        return m(str, str2, z, z2, bArr, bArr2, false);
    }

    public static BaseFont m(String str, String str2, boolean z, boolean z2, byte[] bArr, byte[] bArr2, boolean z4) throws DocumentException, IOException {
        return n(str, str2, z, z2, bArr, bArr2, z4, false);
    }

    /* JADX WARNING: type inference failed for: r8v2, types: [com.itextpdf.text.pdf.BaseFont] */
    /* JADX WARNING: type inference failed for: r0v12, types: [com.itextpdf.text.pdf.Type1Font] */
    /* JADX WARNING: type inference failed for: r0v13, types: [com.itextpdf.text.pdf.TrueTypeFont] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0101  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.itextpdf.text.pdf.BaseFont n(java.lang.String r13, java.lang.String r14, boolean r15, boolean r16, byte[] r17, byte[] r18, boolean r19, boolean r20) throws com.itextpdf.text.DocumentException, java.io.IOException {
        /*
            r1 = r13
            r0 = 1
            java.lang.String r2 = w(r13)
            java.lang.String r7 = j0(r14)
            java.util.HashMap<java.lang.String, com.itextpdf.text.pdf.PdfName> r3 = v4
            boolean r3 = r3.containsKey(r13)
            r4 = 0
            if (r3 == 0) goto L_0x0015
            r5 = 0
            goto L_0x0019
        L_0x0015:
            boolean r5 = com.itextpdf.text.pdf.CJKFont.E0(r2, r7)
        L_0x0019:
            java.lang.String r6 = "Identity-V"
            java.lang.String r8 = "Identity-H"
            if (r3 != 0) goto L_0x0033
            if (r5 == 0) goto L_0x0022
            goto L_0x0033
        L_0x0022:
            boolean r9 = r7.equals(r8)
            if (r9 != 0) goto L_0x0031
            boolean r9 = r7.equals(r6)
            if (r9 == 0) goto L_0x002f
            goto L_0x0031
        L_0x002f:
            r9 = r15
            goto L_0x0034
        L_0x0031:
            r9 = 1
            goto L_0x0034
        L_0x0033:
            r9 = 0
        L_0x0034:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r13)
            java.lang.String r11 = "\n"
            r10.append(r11)
            r10.append(r7)
            r10.append(r11)
            r10.append(r9)
            java.lang.String r10 = r10.toString()
            if (r16 == 0) goto L_0x005b
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.itextpdf.text.pdf.BaseFont> r11 = u4
            java.lang.Object r11 = r11.get(r10)
            com.itextpdf.text.pdf.BaseFont r11 = (com.itextpdf.text.pdf.BaseFont) r11
            if (r11 == 0) goto L_0x005b
            return r11
        L_0x005b:
            java.lang.String r11 = "Cp1252"
            if (r3 != 0) goto L_0x00ef
            java.lang.String r3 = r13.toLowerCase()
            java.lang.String r12 = ".afm"
            boolean r3 = r3.endsWith(r12)
            if (r3 != 0) goto L_0x00ef
            java.lang.String r3 = r13.toLowerCase()
            java.lang.String r12 = ".pfm"
            boolean r3 = r3.endsWith(r12)
            if (r3 == 0) goto L_0x0079
            goto L_0x00ef
        L_0x0079:
            java.lang.String r3 = r2.toLowerCase()
            java.lang.String r12 = ".ttf"
            boolean r3 = r3.endsWith(r12)
            if (r3 != 0) goto L_0x00be
            java.lang.String r3 = r2.toLowerCase()
            java.lang.String r12 = ".otf"
            boolean r3 = r3.endsWith(r12)
            if (r3 != 0) goto L_0x00be
            java.lang.String r2 = r2.toLowerCase()
            java.lang.String r3 = ".ttc,"
            int r2 = r2.indexOf(r3)
            if (r2 <= 0) goto L_0x009e
            goto L_0x00be
        L_0x009e:
            if (r5 == 0) goto L_0x00a7
            com.itextpdf.text.pdf.CJKFont r0 = new com.itextpdf.text.pdf.CJKFont
            r0.<init>(r13, r7, r9)
            goto L_0x00ff
        L_0x00a7:
            if (r19 == 0) goto L_0x00ab
            r0 = 0
            return r0
        L_0x00ab:
            com.itextpdf.text.DocumentException r2 = new com.itextpdf.text.DocumentException
            java.lang.String r3 = "font.1.with.2.is.not.recognized"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r4] = r1
            r5[r0] = r7
            java.lang.String r0 = com.itextpdf.text.error_messages.MessageLocalization.b(r3, r5)
            r2.<init>((java.lang.String) r0)
            throw r2
        L_0x00be:
            boolean r0 = r7.equals(r8)
            if (r0 != 0) goto L_0x00e1
            boolean r0 = r7.equals(r6)
            if (r0 == 0) goto L_0x00cb
            goto L_0x00e1
        L_0x00cb:
            com.itextpdf.text.pdf.TrueTypeFont r8 = new com.itextpdf.text.pdf.TrueTypeFont
            r5 = 0
            r0 = r8
            r1 = r13
            r2 = r7
            r3 = r9
            r4 = r17
            r6 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6)
        L_0x00d9:
            boolean r0 = r7.equals(r11)
            r8.g3 = r0
            r0 = r8
            goto L_0x00ff
        L_0x00e1:
            com.itextpdf.text.pdf.TrueTypeFontUnicode r6 = new com.itextpdf.text.pdf.TrueTypeFontUnicode
            r0 = r6
            r1 = r13
            r2 = r7
            r3 = r9
            r4 = r17
            r5 = r20
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x00ff
        L_0x00ef:
            com.itextpdf.text.pdf.Type1Font r8 = new com.itextpdf.text.pdf.Type1Font
            r0 = r8
            r1 = r13
            r2 = r7
            r3 = r9
            r4 = r17
            r5 = r18
            r6 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6)
            goto L_0x00d9
        L_0x00ff:
            if (r16 == 0) goto L_0x0111
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.itextpdf.text.pdf.BaseFont> r1 = u4
            java.lang.Object r1 = r1.get(r10)
            com.itextpdf.text.pdf.BaseFont r1 = (com.itextpdf.text.pdf.BaseFont) r1
            if (r1 == 0) goto L_0x010c
            return r1
        L_0x010c:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.itextpdf.text.pdf.BaseFont> r1 = u4
            r1.putIfAbsent(r10, r0)
        L_0x0111:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.BaseFont.n(java.lang.String, java.lang.String, boolean, boolean, byte[], byte[], boolean, boolean):com.itextpdf.text.pdf.BaseFont");
    }

    public static String o() {
        StringBuilder sb = new StringBuilder("");
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append((char) ((int) ((Math.random() * 26.0d) + 65.0d)));
        }
        return sb + "+";
    }

    public static String[] p(String str) throws DocumentException, IOException {
        return new EnumerateTTC(str).W0();
    }

    public static String[] q(byte[] bArr) throws DocumentException, IOException {
        return new EnumerateTTC(bArr).W0();
    }

    public static Object[] r(String str, String str2, byte[] bArr) throws DocumentException, IOException {
        String w = w(str);
        BaseFont trueTypeFont = (w.toLowerCase().endsWith(".ttf") || w.toLowerCase().endsWith(".otf") || w.toLowerCase().indexOf(".ttc,") > 0) ? new TrueTypeFont(str, "Cp1252", false, bArr, true, false) : l(str, str2, false, false, bArr, (byte[]) null);
        return new Object[]{trueTypeFont.P(), trueTypeFont.H(), trueTypeFont.L()};
    }

    public static String[][] t(String str, String str2, byte[] bArr) throws DocumentException, IOException {
        String w = w(str);
        return ((w.toLowerCase().endsWith(".ttf") || w.toLowerCase().endsWith(".otf") || w.toLowerCase().indexOf(".ttc,") > 0) ? new TrueTypeFont(str, "Cp1252", false, bArr, true, false) : l(str, str2, false, false, bArr, (byte[]) null)).s();
    }

    protected static String w(String str) {
        int length;
        if (str.endsWith(",Bold")) {
            length = str.length() - 5;
        } else if (str.endsWith(",Italic")) {
            length = str.length() - 7;
        } else if (!str.endsWith(",BoldItalic")) {
            return str;
        } else {
            length = str.length() - 11;
        }
        return str.substring(0, length);
    }

    public int A() {
        return this.b3;
    }

    public int B(String str) {
        int i2;
        char[] charArray = str.toCharArray();
        int i5 = 0;
        for (char x : charArray) {
            int[] x2 = x(x);
            if (x2 != null && (i2 = x2[1]) < i5) {
                i5 = i2;
            }
        }
        return i5;
    }

    public float C(String str, float f2) {
        return ((float) B(str)) * 0.001f * f2;
    }

    public String[] D() {
        return this.Z;
    }

    public String G() {
        return this.Z2;
    }

    public abstract String[][] H();

    public abstract float I(int i2, float f2);

    public double[] J() {
        return l4;
    }

    public int K() {
        return this.X;
    }

    public abstract String[][] L();

    /* access modifiers changed from: package-private */
    public abstract PdfStream N() throws IOException, DocumentException;

    public abstract int O(int i2, int i5);

    public abstract String P();

    /* access modifiers changed from: protected */
    public abstract int[] Q(int i2, String str);

    /* access modifiers changed from: package-private */
    public abstract int R(int i2, String str);

    public String S() {
        return "";
    }

    /* access modifiers changed from: package-private */
    public char T(int i2) {
        return this.X2[i2];
    }

    public char[] U() {
        return this.X2;
    }

    public int V(int i2) {
        return i2;
    }

    public int W(int i2) {
        if (this.g3) {
            return (i2 < 128 || (i2 >= 160 && i2 <= 255)) ? this.Y[i2] : this.Y[PdfEncodings.f26198c.e(i2)];
        }
        byte[] d2 = d(i2);
        int i5 = 0;
        for (byte b2 : d2) {
            i5 += this.Y[b2 & 255];
        }
        return i5;
    }

    public int X(String str) {
        int i2 = 0;
        if (this.g3) {
            int length = str.length();
            int i5 = 0;
            while (i2 < length) {
                char charAt = str.charAt(i2);
                i5 += (charAt < 128 || (charAt >= 160 && charAt <= 255)) ? this.Y[charAt] : this.Y[PdfEncodings.f26198c.e(charAt)];
                i2++;
            }
            return i5;
        }
        byte[] e2 = e(str);
        int i6 = 0;
        while (i2 < e2.length) {
            i6 += this.Y[e2[i2] & 255];
            i2++;
        }
        return i6;
    }

    public float Y(int i2, float f2) {
        return ((float) W(i2)) * 0.001f * f2;
    }

    public float Z(String str, float f2) {
        return ((float) X(str)) * 0.001f * f2;
    }

    public float a0(String str, float f2) {
        float X4 = ((float) X(str)) * 0.001f * f2;
        if (!c0()) {
            return X4;
        }
        int length = str.length() - 1;
        char[] charArray = str.toCharArray();
        int i2 = 0;
        int i5 = 0;
        while (i2 < length) {
            char c2 = charArray[i2];
            i2++;
            i5 += O(c2, charArray[i2]);
        }
        return X4 + (((float) i5) * 0.001f * f2);
    }

    public void b(int[] iArr) {
        if (this.s == null) {
            this.s = new ArrayList<>();
        }
        this.s.add(iArr);
    }

    public int[] b0() {
        return this.Y;
    }

    public boolean c(int i2) {
        return d(i2).length > 0;
    }

    public abstract boolean c0();

    /* access modifiers changed from: package-private */
    public byte[] d(int i2) {
        char c2;
        String str;
        if (this.e3) {
            c2 = (char) i2;
            str = null;
        } else {
            IntHashtable intHashtable = this.h3;
            if (intHashtable == null) {
                c2 = (char) i2;
                str = this.Z2;
            } else if (!intHashtable.c(i2)) {
                return new byte[0];
            } else {
                return new byte[]{(byte) this.h3.e(i2)};
            }
        }
        return PdfEncodings.b(c2, str);
    }

    public boolean d0() {
        return this.e3;
    }

    public byte[] e(String str) {
        if (this.e3) {
            return PdfEncodings.c(str, (String) null);
        }
        if (this.h3 == null) {
            return PdfEncodings.c(str, this.Z2);
        }
        byte[] bArr = new byte[str.length()];
        int length = str.length();
        int i2 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            char charAt = str.charAt(i5);
            if (this.h3.c(charAt)) {
                bArr[i2] = (byte) this.h3.e(charAt);
                i2++;
            }
        }
        if (i2 >= length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        return bArr2;
    }

    public boolean e0() {
        return this.a3;
    }

    public void f() {
        for (char c2 = 1611; c2 <= 1624; c2 = (char) (c2 + 1)) {
            l0(c2, 0);
        }
        l0(1648, 0);
        for (char c5 = 1750; c5 <= 1756; c5 = (char) (c5 + 1)) {
            l0(c5, 0);
        }
        for (char c6 = 1759; c6 <= 1764; c6 = (char) (c6 + 1)) {
            l0(c6, 0);
        }
        for (char c7 = 1767; c7 <= 1768; c7 = (char) (c7 + 1)) {
            l0(c7, 0);
        }
        for (char c8 = 1770; c8 <= 1773; c8 = (char) (c8 + 1)) {
            l0(c8, 0);
        }
    }

    public boolean f0() {
        return this.c3;
    }

    /* access modifiers changed from: protected */
    public void g() {
        int i2 = 0;
        if (this.Z2.startsWith("#")) {
            this.h3 = new IntHashtable();
            StringTokenizer stringTokenizer = new StringTokenizer(this.Z2.substring(1), " ,\t\n\r\f");
            if (stringTokenizer.nextToken().equals("full")) {
                while (stringTokenizer.hasMoreTokens()) {
                    String nextToken = stringTokenizer.nextToken();
                    String nextToken2 = stringTokenizer.nextToken();
                    char parseInt = (char) Integer.parseInt(stringTokenizer.nextToken(), 16);
                    int charAt = (nextToken.startsWith("'") ? nextToken.charAt(1) : Integer.parseInt(nextToken)) % 256;
                    this.h3.l(parseInt, charAt);
                    this.Z[charAt] = nextToken2;
                    this.X2[charAt] = parseInt;
                    this.Y[charAt] = R(parseInt, nextToken2);
                    this.Y2[charAt] = Q(parseInt, nextToken2);
                }
            } else {
                int parseInt2 = stringTokenizer.hasMoreTokens() ? Integer.parseInt(stringTokenizer.nextToken()) : 0;
                while (stringTokenizer.hasMoreTokens() && parseInt2 < 256) {
                    int parseInt3 = Integer.parseInt(stringTokenizer.nextToken(), 16) % 65536;
                    String b2 = GlyphList.b(parseInt3);
                    if (b2 != null) {
                        this.h3.l(parseInt3, parseInt2);
                        this.Z[parseInt2] = b2;
                        this.X2[parseInt2] = (char) parseInt3;
                        this.Y[parseInt2] = R(parseInt3, b2);
                        this.Y2[parseInt2] = Q(parseInt3, b2);
                        parseInt2++;
                    }
                }
            }
            while (i2 < 256) {
                String[] strArr = this.Z;
                if (strArr[i2] == null) {
                    strArr[i2] = t4;
                }
                i2++;
            }
        } else if (this.c3) {
            while (i2 < 256) {
                this.Y[i2] = R(i2, (String) null);
                this.Y2[i2] = Q(i2, (String) null);
                i2++;
            }
        } else {
            for (int i5 = 0; i5 < 256; i5++) {
                String d2 = PdfEncodings.d(new byte[]{(byte) i5}, this.Z2);
                char charAt2 = d2.length() > 0 ? d2.charAt(0) : '?';
                String b5 = GlyphList.b(charAt2);
                if (b5 == null) {
                    b5 = t4;
                }
                this.Z[i5] = b5;
                this.X2[i5] = charAt2;
                this.Y[i5] = R(charAt2, b5);
                this.Y2[i5] = Q(charAt2, b5);
            }
        }
    }

    public boolean g0() {
        return this.d3;
    }

    public boolean h0() {
        return this.f3;
    }

    public boolean i0() {
        return this.i3;
    }

    public boolean l0(int i2, int i5) {
        byte[] d2 = d(i2);
        if (d2.length == 0) {
            return false;
        }
        this.Y[d2[0] & 255] = i5;
        return true;
    }

    public void m0(int i2) {
        if (i2 < 0 || i2 > 9) {
            i2 = -1;
        }
        this.b3 = i2;
    }

    public void n0(boolean z) {
        this.e3 = z;
    }

    public void o0(int i2, float f2) {
    }

    public void p0(boolean z) {
        this.d3 = z;
    }

    public abstract boolean q0(int i2, int i5, int i6);

    public abstract void r0(String str);

    public abstract String[][] s();

    public void s0(boolean z) {
        this.f3 = z;
    }

    /* access modifiers changed from: package-private */
    public abstract void t0(PdfWriter pdfWriter, PdfIndirectReference pdfIndirectReference, Object[] objArr) throws DocumentException, IOException;

    public int u(String str) {
        int i2;
        char[] charArray = str.toCharArray();
        int i5 = 0;
        for (char x : charArray) {
            int[] x2 = x(x);
            if (x2 != null && (i2 = x2[3]) > i5) {
                i5 = i2;
            }
        }
        return i5;
    }

    public float v(String str, float f2) {
        return ((float) u(str)) * 0.001f * f2;
    }

    public int[] x(int i2) {
        byte[] d2 = d(i2);
        if (d2.length == 0) {
            return null;
        }
        return this.Y2[d2[0] & 255];
    }

    public int y(int i2) {
        return i2;
    }

    public String[] z() {
        return new String[0];
    }
}
