package org.ccil.cowan.tagsoup;

import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PushbackReader;
import java.lang.reflect.Array;
import okio.Utf8;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class HTMLScanner implements Scanner, Locator {
    private static final int A = 16;
    private static int[] A0 = {1, 47, 5, 22, 1, 61, 4, 3, 1, 62, 6, 28, 1, 0, 27, 1, 1, -1, 6, 21, 1, 32, 4, 24, 1, 10, 4, 24, 1, 9, 4, 24, 2, 39, 7, 34, 2, 0, 27, 2, 2, -1, 8, 21, 2, 32, 29, 2, 2, 10, 29, 2, 2, 9, 29, 2, 3, 34, 28, 31, 3, 39, 28, 2, 3, 62, 8, 28, 3, 0, 27, 32, 3, -1, 8, 21, 3, 32, 28, 3, 3, 10, 28, 3, 3, 9, 28, 3, 4, 67, 28, 5, 4, 0, 28, 19, 4, -1, 28, 21, 5, 68, 28, 6, 5, 0, 28, 19, 5, -1, 28, 21, 6, 65, 28, 7, 6, 0, 28, 19, 6, -1, 28, 21, 7, 84, 28, 8, 7, 0, 28, 19, 7, -1, 28, 21, 8, 65, 28, 9, 8, 0, 28, 19, 8, -1, 28, 21, 9, 91, 28, 12, 9, 0, 28, 19, 9, -1, 28, 21, 10, 60, 27, 11, 10, 0, 27, 10, 10, -1, 23, 21, 11, 47, 32, 25, 11, 0, 27, 10, 11, -1, 32, 21, 12, 93, 27, 13, 12, 0, 27, 12, 12, -1, 28, 21, 13, 93, 27, 14, 13, 0, 27, 12, 13, -1, 28, 21, 14, 62, 9, 28, 14, 93, 27, 14, 14, 0, 27, 12, 14, -1, 28, 21, 15, 45, 28, 16, 15, 0, 27, 16, 15, -1, 10, 21, 16, 45, 28, 17, 16, 0, 27, 16, 16, -1, 10, 21, 17, 45, 28, 18, 17, 0, 20, 16, 17, -1, 10, 21, 18, 45, 22, 18, 18, 62, 10, 28, 18, 0, 21, 16, 18, -1, 10, 21, 19, 45, 28, 15, 19, 62, 28, 28, 19, 91, 28, 4, 19, 0, 27, 20, 19, -1, 28, 21, 20, 62, 11, 28, 20, 0, 27, 20, 20, -1, 28, 21, 22, 62, 12, 28, 22, 0, 27, 1, 22, 32, 28, 34, 22, 10, 28, 34, 22, 9, 28, 34, 23, 0, 13, 23, 23, -1, 13, 21, 24, 61, 28, 3, 24, 62, 3, 28, 24, 0, 2, 1, 24, -1, 3, 21, 24, 32, 28, 24, 24, 10, 28, 24, 24, 9, 28, 24, 25, 62, 15, 28, 25, 0, 27, 25, 25, -1, 15, 21, 25, 32, 28, 25, 25, 10, 28, 25, 25, 9, 28, 25, 26, 47, 28, 22, 26, 62, 17, 28, 26, 0, 27, 26, 26, -1, 28, 21, 26, 32, 16, 34, 26, 10, 16, 34, 26, 9, 16, 34, 27, 0, 13, 27, 27, -1, 13, 21, 28, 38, 14, 23, 28, 60, 23, 33, 28, 0, 27, 28, 28, -1, 23, 21, 29, 62, 24, 28, 29, 0, 27, 29, 29, -1, 24, 21, 30, 62, 26, 28, 30, 0, 27, 30, 30, -1, 26, 21, 30, 32, 25, 29, 30, 10, 25, 29, 30, 9, 25, 29, 31, 34, 7, 34, 31, 0, 27, 31, 31, -1, 8, 21, 31, 32, 29, 31, 31, 10, 29, 31, 31, 9, 29, 31, 32, 62, 8, 28, 32, 0, 27, 32, 32, -1, 8, 21, 32, 32, 7, 34, 32, 10, 7, 34, 32, 9, 7, 34, 33, 33, 28, 19, 33, 47, 28, 25, 33, 60, 27, 33, 33, 63, 28, 30, 33, 0, 27, 26, 33, -1, 19, 21, 33, 32, 18, 28, 33, 10, 18, 28, 33, 9, 18, 28, 34, 47, 28, 22, 34, 62, 30, 28, 34, 0, 27, 1, 34, -1, 30, 21, 34, 32, 28, 34, 34, 10, 28, 34, 34, 9, 28, 34, 35, 0, 13, 35, 35, -1, 13, 21};
    private static final int B = 17;
    private static final String[] B0 = {"", "A_ADUP", "A_ADUP_SAVE", "A_ADUP_STAGC", "A_ANAME", "A_ANAME_ADUP", "A_ANAME_ADUP_STAGC", "A_AVAL", "A_AVAL_STAGC", "A_CDATA", "A_CMNT", "A_DECL", "A_EMPTYTAG", "A_ENTITY", "A_ENTITY_START", "A_ETAG", "A_GI", "A_GI_STAGC", "A_LT", "A_LT_PCDATA", "A_MINUS", "A_MINUS2", "A_MINUS3", "A_PCDATA", "A_PI", "A_PITARGET", "A_PITARGET_PI", "A_SAVE", "A_SKIP", "A_SP", "A_STAGC", "A_UNGET", "A_UNSAVE_PCDATA"};
    private static final int C = 18;
    private static final String[] C0 = {"", "S_ANAME", "S_APOS", "S_AVAL", "S_BB", "S_BBC", "S_BBCD", "S_BBCDA", "S_BBCDAT", "S_BBCDATA", "S_CDATA", "S_CDATA2", "S_CDSECT", "S_CDSECT1", "S_CDSECT2", "S_COM", "S_COM2", "S_COM3", "S_COM4", "S_DECL", "S_DECL2", "S_DONE", "S_EMPTYTAG", "S_ENT", "S_EQ", "S_ETAG", "S_GI", "S_NCR", "S_PCDATA", "S_PI", "S_PITARGET", "S_QUOT", "S_STAGC", "S_TAG", "S_TAGWS", "S_XNCR"};
    private static final int D = 19;
    static short[][] D0 = null;
    private static final int E = 20;
    static int E0 = 0;
    private static final int F = 21;
    private static final int G = 22;
    private static final int H = 23;
    private static final int I = 24;
    private static final int J = 25;
    private static final int K = 26;
    private static final int L = 27;
    private static final int M = 28;
    private static final int N = 29;
    private static final int O = 30;
    private static final int P = 31;
    private static final int Q = 32;
    private static final int R = 33;
    private static final int S = 34;
    private static final int T = 35;
    private static final int U = 1;
    private static final int V = 2;
    private static final int W = 3;
    private static final int X = 4;
    private static final int Y = 5;
    private static final int Z = 6;
    private static final int a0 = 7;
    private static final int b0 = 8;
    private static final int c0 = 9;
    private static final int d0 = 10;
    private static final int e0 = 11;
    private static final int f0 = 12;
    private static final int g0 = 13;
    private static final int h0 = 14;
    private static final int i0 = 15;
    private static final int j0 = 16;
    private static final int k0 = 17;

    /* renamed from: l  reason: collision with root package name */
    private static final int f31496l = 1;
    private static final int l0 = 18;

    /* renamed from: m  reason: collision with root package name */
    private static final int f31497m = 2;
    private static final int m0 = 19;

    /* renamed from: n  reason: collision with root package name */
    private static final int f31498n = 3;
    private static final int n0 = 20;
    private static final int o = 4;
    private static final int o0 = 21;
    private static final int p = 5;
    private static final int p0 = 22;
    private static final int q = 6;
    private static final int q0 = 23;
    private static final int r = 7;
    private static final int r0 = 24;
    private static final int s = 8;
    private static final int s0 = 25;
    private static final int t = 9;
    private static final int t0 = 26;
    private static final int u = 10;
    private static final int u0 = 27;
    private static final int v = 11;
    private static final int v0 = 28;
    private static final int w = 12;
    private static final int w0 = 29;
    private static final int x = 13;
    private static final int x0 = 30;
    private static final int y = 14;
    private static final int y0 = 31;
    private static final int z = 15;
    private static final int z0 = 32;

    /* renamed from: a  reason: collision with root package name */
    private String f31499a;

    /* renamed from: b  reason: collision with root package name */
    private String f31500b;

    /* renamed from: c  reason: collision with root package name */
    private int f31501c;

    /* renamed from: d  reason: collision with root package name */
    private int f31502d;

    /* renamed from: e  reason: collision with root package name */
    private int f31503e;

    /* renamed from: f  reason: collision with root package name */
    private int f31504f;

    /* renamed from: g  reason: collision with root package name */
    int f31505g;

    /* renamed from: h  reason: collision with root package name */
    int f31506h;

    /* renamed from: i  reason: collision with root package name */
    char[] f31507i = new char[200];

    /* renamed from: j  reason: collision with root package name */
    int f31508j;

    /* renamed from: k  reason: collision with root package name */
    int[] f31509k = {8364, Utf8.f31406c, 8218, 402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, TIFFConstants.H1, Utf8.f31406c, 381, Utf8.f31406c, Utf8.f31406c, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, TIFFConstants.L1, Utf8.f31406c, 382, 376};

    static {
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        while (true) {
            int[] iArr = A0;
            if (i2 >= iArr.length) {
                break;
            }
            int i5 = iArr[i2];
            if (i5 > i4) {
                i4 = i5;
            }
            int i6 = iArr[i2 + 1];
            if (i6 > i3) {
                i3 = i6;
            }
            i2 += 4;
        }
        E0 = i3 + 1;
        int[] iArr2 = new int[2];
        iArr2[1] = i3 + 3;
        iArr2[0] = i4 + 1;
        D0 = (short[][]) Array.newInstance(Short.TYPE, iArr2);
        for (int i7 = 0; i7 <= i4; i7++) {
            for (int i8 = -2; i8 <= i3; i8++) {
                int i9 = 0;
                int i10 = 0;
                int i11 = -1;
                while (true) {
                    int[] iArr3 = A0;
                    if (i9 >= iArr3.length) {
                        break;
                    }
                    if (i7 == iArr3[i9]) {
                        int i12 = iArr3[i9 + 1];
                        if (i12 == 0) {
                            i10 = iArr3[i9 + 2];
                            i11 = i9;
                        } else if (i12 == i8) {
                            int i13 = iArr3[i9 + 2];
                            break;
                        }
                    } else if (i10 != 0) {
                        break;
                    }
                    i9 += 4;
                }
                i9 = i11;
                D0[i7][i8 + 2] = (short) i9;
            }
        }
    }

    public static void c(String[] strArr) throws IOException, SAXException {
        HTMLScanner hTMLScanner = new HTMLScanner();
        InputStreamReader inputStreamReader = new InputStreamReader(System.in, "UTF-8");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out, "UTF-8");
        hTMLScanner.a(inputStreamReader, new PYXWriter(outputStreamWriter));
        outputStreamWriter.close();
    }

    private void d() {
        this.f31502d = this.f31504f;
        this.f31501c = this.f31503e;
    }

    private static String e(int i2) {
        StringBuffer stringBuffer;
        if (i2 == 10) {
            return "\\n";
        }
        if (i2 < 32) {
            stringBuffer = new StringBuffer();
            stringBuffer.append("0x");
            stringBuffer.append(Integer.toHexString(i2));
        } else {
            stringBuffer = new StringBuffer();
            stringBuffer.append("'");
            stringBuffer.append((char) i2);
            stringBuffer.append("'");
        }
        return stringBuffer.toString();
    }

    private void f(int i2, ScanHandler scanHandler) throws IOException, SAXException {
        int i3 = this.f31508j;
        char[] cArr = this.f31507i;
        if (i3 >= cArr.length - 20) {
            int i4 = this.f31505g;
            if (i4 == 28 || i4 == 10) {
                scanHandler.a(cArr, 0, i3);
                this.f31508j = 0;
            } else {
                char[] cArr2 = new char[(cArr.length * 2)];
                System.arraycopy(cArr, 0, cArr2, 0, i3 + 1);
                this.f31507i = cArr2;
            }
        }
        char[] cArr3 = this.f31507i;
        int i5 = this.f31508j;
        this.f31508j = i5 + 1;
        cArr3[i5] = (char) i2;
    }

    private void g(PushbackReader pushbackReader, int i2) throws IOException {
        if (i2 != -1) {
            pushbackReader.unread(i2);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01f2, code lost:
        if (r1 != 59) goto L_0x01f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02a7, code lost:
        r0.f31505g = r0.f31506h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c3, code lost:
        r0.f31508j = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d9, code lost:
        f(32, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x011b, code lost:
        f(45, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x015d, code lost:
        r0.f31508j = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.io.Reader r17, org.ccil.cowan.tagsoup.ScanHandler r18) throws java.io.IOException, org.xml.sax.SAXException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = 28
            r0.f31505g = r3
            boolean r4 = r1 instanceof java.io.BufferedReader
            r5 = 5
            if (r4 == 0) goto L_0x0015
            java.io.PushbackReader r4 = new java.io.PushbackReader
            r4.<init>(r1, r5)
            goto L_0x001f
        L_0x0015:
            java.io.PushbackReader r4 = new java.io.PushbackReader
            java.io.BufferedReader r6 = new java.io.BufferedReader
            r6.<init>(r1)
            r4.<init>(r6, r5)
        L_0x001f:
            int r1 = r4.read()
            r5 = 65279(0xfeff, float:9.1475E-41)
            if (r1 == r5) goto L_0x002b
            r0.g(r4, r1)
        L_0x002b:
            int r1 = r0.f31505g
            r5 = 21
            r6 = 0
            if (r1 == r5) goto L_0x02d6
            int r1 = r4.read()
            r5 = 159(0x9f, float:2.23E-43)
            r7 = 128(0x80, float:1.794E-43)
            if (r1 < r7) goto L_0x0044
            if (r1 > r5) goto L_0x0044
            int[] r8 = r0.f31509k
            int r1 = r1 + -128
            r1 = r8[r1]
        L_0x0044:
            r8 = 13
            r9 = 10
            if (r1 != r8) goto L_0x0055
            int r1 = r4.read()
            if (r1 == r9) goto L_0x0055
            r0.g(r4, r1)
            r1 = 10
        L_0x0055:
            r8 = 1
            if (r1 != r9) goto L_0x0060
            int r10 = r0.f31503e
            int r10 = r10 + r8
            r0.f31503e = r10
            r0.f31504f = r6
            goto L_0x0065
        L_0x0060:
            int r10 = r0.f31504f
            int r10 = r10 + r8
            r0.f31504f = r10
        L_0x0065:
            r10 = -1
            r11 = 32
            if (r1 >= r11) goto L_0x0073
            if (r1 == r9) goto L_0x0073
            r9 = 9
            if (r1 == r9) goto L_0x0073
            if (r1 == r10) goto L_0x0073
            goto L_0x002b
        L_0x0073:
            if (r1 < r10) goto L_0x007b
            int r9 = E0
            if (r1 >= r9) goto L_0x007b
            r9 = r1
            goto L_0x007c
        L_0x007b:
            r9 = -2
        L_0x007c:
            short[][] r12 = D0
            int r13 = r0.f31505g
            r12 = r12[r13]
            int r9 = r9 + 2
            short r9 = r12[r9]
            if (r9 == r10) goto L_0x0095
            int[] r12 = A0
            int r13 = r9 + 2
            r13 = r12[r13]
            int r9 = r9 + 3
            r9 = r12[r9]
            r0.f31506h = r9
            goto L_0x0096
        L_0x0095:
            r13 = 0
        L_0x0096:
            r9 = 60
            r12 = 45
            switch(r13) {
                case 0: goto L_0x02ad;
                case 1: goto L_0x029e;
                case 2: goto L_0x0295;
                case 3: goto L_0x0286;
                case 4: goto L_0x027d;
                case 5: goto L_0x026e;
                case 6: goto L_0x0258;
                case 7: goto L_0x024f;
                case 8: goto L_0x0240;
                case 9: goto L_0x022c;
                case 10: goto L_0x0220;
                case 11: goto L_0x0217;
                case 12: goto L_0x0202;
                case 13: goto L_0x0161;
                case 14: goto L_0x0156;
                case 15: goto L_0x014d;
                case 16: goto L_0x0144;
                case 17: goto L_0x0134;
                case 18: goto L_0x012d;
                case 19: goto L_0x011f;
                case 20: goto L_0x011b;
                case 21: goto L_0x0115;
                case 22: goto L_0x0111;
                case 23: goto L_0x0106;
                case 24: goto L_0x00fb;
                case 25: goto L_0x00f3;
                case 26: goto L_0x00e3;
                case 27: goto L_0x00de;
                case 28: goto L_0x02a7;
                case 29: goto L_0x00d9;
                case 30: goto L_0x00d1;
                case 31: goto L_0x00c7;
                case 32: goto L_0x00b4;
                default: goto L_0x009d;
            }
        L_0x009d:
            java.lang.Error r1 = new java.lang.Error
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r2.<init>()
            java.lang.String r3 = "Can't process state "
            r2.append(r3)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x00b4:
            int r1 = r0.f31508j
            if (r1 <= 0) goto L_0x00bc
            int r1 = r1 + -1
            r0.f31508j = r1
        L_0x00bc:
            char[] r1 = r0.f31507i
            int r5 = r0.f31508j
            r2.a(r1, r6, r5)
        L_0x00c3:
            r0.f31508j = r6
            goto L_0x02a7
        L_0x00c7:
            r0.g(r4, r1)
            int r1 = r0.f31504f
            int r1 = r1 - r8
            r0.f31504f = r1
            goto L_0x02a7
        L_0x00d1:
            char[] r1 = r0.f31507i
            int r5 = r0.f31508j
            r2.l(r1, r6, r5)
            goto L_0x00c3
        L_0x00d9:
            r0.f(r11, r2)
            goto L_0x02a7
        L_0x00de:
            r0.f(r1, r2)
            goto L_0x02a7
        L_0x00e3:
            char[] r1 = r0.f31507i
            int r5 = r0.f31508j
            r2.b(r1, r6, r5)
            r0.f31508j = r6
            char[] r1 = r0.f31507i
            r2.h(r1, r6, r6)
            goto L_0x02a7
        L_0x00f3:
            char[] r1 = r0.f31507i
            int r5 = r0.f31508j
            r2.b(r1, r6, r5)
            goto L_0x00c3
        L_0x00fb:
            r16.d()
            char[] r1 = r0.f31507i
            int r5 = r0.f31508j
            r2.h(r1, r6, r5)
            goto L_0x00c3
        L_0x0106:
            r16.d()
            char[] r1 = r0.f31507i
            int r5 = r0.f31508j
            r2.a(r1, r6, r5)
            goto L_0x00c3
        L_0x0111:
            r0.f(r12, r2)
            goto L_0x00d9
        L_0x0115:
            r0.f(r12, r2)
            r0.f(r11, r2)
        L_0x011b:
            r0.f(r12, r2)
            goto L_0x00de
        L_0x011f:
            r16.d()
            r0.f(r9, r2)
            char[] r1 = r0.f31507i
            int r5 = r0.f31508j
            r2.a(r1, r6, r5)
            goto L_0x00c3
        L_0x012d:
            r16.d()
            r0.f(r9, r2)
            goto L_0x00de
        L_0x0134:
            char[] r1 = r0.f31507i
            int r5 = r0.f31508j
            r2.p(r1, r6, r5)
            r0.f31508j = r6
            char[] r1 = r0.f31507i
            r2.l(r1, r6, r6)
            goto L_0x02a7
        L_0x0144:
            char[] r1 = r0.f31507i
            int r5 = r0.f31508j
            r2.p(r1, r6, r5)
            goto L_0x00c3
        L_0x014d:
            char[] r1 = r0.f31507i
            int r5 = r0.f31508j
            r2.i(r1, r6, r5)
            goto L_0x00c3
        L_0x0156:
            char[] r5 = r0.f31507i
            int r7 = r0.f31508j
            r2.a(r5, r6, r7)
        L_0x015d:
            r0.f31508j = r6
            goto L_0x00de
        L_0x0161:
            r16.d()
            char r9 = (char) r1
            int r12 = r0.f31505g
            r13 = 23
            r14 = 27
            r15 = 35
            if (r12 != r13) goto L_0x0175
            if (r9 != r15) goto L_0x0175
            r0.f31506h = r14
            goto L_0x00de
        L_0x0175:
            if (r12 != r14) goto L_0x0188
            r3 = 120(0x78, float:1.68E-43)
            if (r9 == r3) goto L_0x017f
            r3 = 88
            if (r9 != r3) goto L_0x0188
        L_0x017f:
            r0.f31506h = r15
        L_0x0181:
            r0.f(r1, r2)
            r3 = 28
            goto L_0x02a7
        L_0x0188:
            if (r12 != r13) goto L_0x0191
            boolean r3 = java.lang.Character.isLetterOrDigit(r9)
            if (r3 == 0) goto L_0x0191
        L_0x0190:
            goto L_0x0181
        L_0x0191:
            int r3 = r0.f31505g
            if (r3 != r14) goto L_0x019c
            boolean r3 = java.lang.Character.isDigit(r9)
            if (r3 == 0) goto L_0x019c
            goto L_0x0190
        L_0x019c:
            int r3 = r0.f31505g
            if (r3 != r15) goto L_0x01af
            boolean r3 = java.lang.Character.isDigit(r9)
            if (r3 != 0) goto L_0x0181
            java.lang.String r3 = "abcdefABCDEF"
            int r3 = r3.indexOf(r9)
            if (r3 == r10) goto L_0x01af
            goto L_0x0190
        L_0x01af:
            char[] r3 = r0.f31507i
            int r9 = r0.f31508j
            int r9 = r9 - r8
            r2.e(r3, r8, r9)
            int r3 = r18.c()
            if (r3 == 0) goto L_0x01f4
            r0.f31508j = r6
            if (r3 < r7) goto L_0x01c9
            if (r3 > r5) goto L_0x01c9
            int[] r5 = r0.f31509k
            int r3 = r3 + -128
            r3 = r5[r3]
        L_0x01c9:
            if (r3 >= r11) goto L_0x01cc
            goto L_0x01f0
        L_0x01cc:
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r3 < r5) goto L_0x01d7
            r6 = 57343(0xdfff, float:8.0355E-41)
            if (r3 > r6) goto L_0x01d7
            goto L_0x01f0
        L_0x01d7:
            r6 = 65535(0xffff, float:9.1834E-41)
            if (r3 > r6) goto L_0x01e0
        L_0x01dc:
            r0.f(r3, r2)
            goto L_0x01f0
        L_0x01e0:
            r6 = 65536(0x10000, float:9.18355E-41)
            int r3 = r3 - r6
            int r6 = r3 >> 10
            int r6 = r6 + r5
            r0.f(r6, r2)
            r3 = r3 & 1023(0x3ff, float:1.434E-42)
            r5 = 56320(0xdc00, float:7.8921E-41)
            int r3 = r3 + r5
            goto L_0x01dc
        L_0x01f0:
            r3 = 59
            if (r1 == r3) goto L_0x01fc
        L_0x01f4:
            r0.g(r4, r1)
            int r1 = r0.f31504f
            int r1 = r1 - r8
            r0.f31504f = r1
        L_0x01fc:
            r3 = 28
            r0.f31506h = r3
            goto L_0x02a7
        L_0x0202:
            r16.d()
            int r1 = r0.f31508j
            if (r1 <= 0) goto L_0x020e
            char[] r5 = r0.f31507i
            r2.p(r5, r6, r1)
        L_0x020e:
            r0.f31508j = r6
            char[] r1 = r0.f31507i
            r2.d(r1, r6, r6)
            goto L_0x02a7
        L_0x0217:
            char[] r1 = r0.f31507i
            int r5 = r0.f31508j
            r2.f(r1, r6, r5)
            goto L_0x00c3
        L_0x0220:
            r16.d()
            char[] r1 = r0.f31507i
            int r5 = r0.f31508j
            r2.j(r1, r6, r5)
            goto L_0x00c3
        L_0x022c:
            r16.d()
            int r1 = r0.f31508j
            if (r1 <= r8) goto L_0x0237
            int r1 = r1 + -2
            r0.f31508j = r1
        L_0x0237:
            char[] r1 = r0.f31507i
            int r5 = r0.f31508j
            r2.a(r1, r6, r5)
            goto L_0x00c3
        L_0x0240:
            char[] r1 = r0.f31507i
            int r5 = r0.f31508j
            r2.o(r1, r6, r5)
            r0.f31508j = r6
            char[] r1 = r0.f31507i
            r2.l(r1, r6, r6)
            goto L_0x02a7
        L_0x024f:
            char[] r1 = r0.f31507i
            int r5 = r0.f31508j
            r2.o(r1, r6, r5)
            goto L_0x00c3
        L_0x0258:
            char[] r1 = r0.f31507i
            int r5 = r0.f31508j
            r2.k(r1, r6, r5)
            r0.f31508j = r6
            char[] r1 = r0.f31507i
            r2.n(r1, r6, r6)
            char[] r1 = r0.f31507i
            int r5 = r0.f31508j
            r2.l(r1, r6, r5)
            goto L_0x02a7
        L_0x026e:
            char[] r1 = r0.f31507i
            int r5 = r0.f31508j
            r2.k(r1, r6, r5)
            r0.f31508j = r6
            char[] r1 = r0.f31507i
            r2.n(r1, r6, r6)
            goto L_0x02a7
        L_0x027d:
            char[] r1 = r0.f31507i
            int r5 = r0.f31508j
            r2.k(r1, r6, r5)
            goto L_0x00c3
        L_0x0286:
            char[] r1 = r0.f31507i
            int r5 = r0.f31508j
            r2.n(r1, r6, r5)
            r0.f31508j = r6
            char[] r1 = r0.f31507i
            r2.l(r1, r6, r6)
            goto L_0x02a7
        L_0x0295:
            char[] r5 = r0.f31507i
            int r7 = r0.f31508j
            r2.n(r5, r6, r7)
            goto L_0x015d
        L_0x029e:
            char[] r1 = r0.f31507i
            int r5 = r0.f31508j
            r2.n(r1, r6, r5)
            goto L_0x00c3
        L_0x02a7:
            int r1 = r0.f31506h
            r0.f31505g = r1
            goto L_0x002b
        L_0x02ad:
            java.lang.Error r2 = new java.lang.Error
            java.lang.StringBuffer r3 = new java.lang.StringBuffer
            r3.<init>()
            java.lang.String r4 = "HTMLScanner can't cope with "
            r3.append(r4)
            java.lang.String r1 = java.lang.Integer.toString(r1)
            r3.append(r1)
            java.lang.String r1 = " in state "
            r3.append(r1)
            int r1 = r0.f31505g
            java.lang.String r1 = java.lang.Integer.toString(r1)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x02d6:
            char[] r1 = r0.f31507i
            r2.g(r1, r6, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.ccil.cowan.tagsoup.HTMLScanner.a(java.io.Reader, org.ccil.cowan.tagsoup.ScanHandler):void");
    }

    public void b(String str, String str2) {
        this.f31499a = str;
        this.f31500b = str2;
        this.f31504f = 0;
        this.f31503e = 0;
        this.f31502d = 0;
        this.f31501c = 0;
    }

    public int getColumnNumber() {
        return this.f31502d;
    }

    public int getLineNumber() {
        return this.f31501c;
    }

    public String getPublicId() {
        return this.f31499a;
    }

    public String getSystemId() {
        return this.f31500b;
    }

    public void startCDATA() {
        this.f31506h = 10;
    }
}
