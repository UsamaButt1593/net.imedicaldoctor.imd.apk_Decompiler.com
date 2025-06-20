package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.InvalidPdfException;
import com.itextpdf.text.io.RandomAccessSourceFactory;
import java.io.IOException;

public class PRTokeniser {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean[] f26101h = {true, true, false, false, false, false, false, false, false, false, true, true, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, true, false, false, true, true, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

    /* renamed from: i  reason: collision with root package name */
    static final String f26102i = "";

    /* renamed from: a  reason: collision with root package name */
    private final StringBuilder f26103a = new StringBuilder();

    /* renamed from: b  reason: collision with root package name */
    private final RandomAccessFileOrArray f26104b;

    /* renamed from: c  reason: collision with root package name */
    protected TokenType f26105c;

    /* renamed from: d  reason: collision with root package name */
    protected String f26106d;

    /* renamed from: e  reason: collision with root package name */
    protected int f26107e;

    /* renamed from: f  reason: collision with root package name */
    protected int f26108f;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f26109g;

    public enum TokenType {
        NUMBER,
        STRING,
        NAME,
        COMMENT,
        START_ARRAY,
        END_ARRAY,
        START_DIC,
        END_DIC,
        REF,
        OTHER,
        ENDOFFILE
    }

    public PRTokeniser(RandomAccessFileOrArray randomAccessFileOrArray) {
        this.f26104b = randomAccessFileOrArray;
    }

    public static long[] c(byte[] bArr) {
        try {
            PRTokeniser pRTokeniser = new PRTokeniser(new RandomAccessFileOrArray(new RandomAccessSourceFactory().j(bArr)));
            if (pRTokeniser.x()) {
                TokenType o = pRTokeniser.o();
                TokenType tokenType = TokenType.NUMBER;
                if (o == tokenType) {
                    int p = pRTokeniser.p();
                    if (pRTokeniser.x()) {
                        if (pRTokeniser.o() == tokenType) {
                            int p2 = pRTokeniser.p();
                            if (!pRTokeniser.x() || !pRTokeniser.n().equals("obj")) {
                                return null;
                            }
                            return new long[]{(long) p, (long) p2};
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static int j(int i2) {
        if (i2 >= 48 && i2 <= 57) {
            return i2 - 48;
        }
        if (i2 >= 65 && i2 <= 70) {
            return i2 - 55;
        }
        if (i2 < 97 || i2 > 102) {
            return -1;
        }
        return i2 - 87;
    }

    public static final boolean q(int i2) {
        return i2 == 40 || i2 == 41 || i2 == 60 || i2 == 62 || i2 == 91 || i2 == 93 || i2 == 47 || i2 == 37;
    }

    public static final boolean r(int i2) {
        return f26101h[i2 + 1];
    }

    public static final boolean t(int i2) {
        return u(i2, true);
    }

    public static final boolean u(int i2, boolean z) {
        return (z && i2 == 0) || i2 == 9 || i2 == 10 || i2 == 12 || i2 == 13 || i2 == 32;
    }

    public boolean A(byte[] bArr) throws IOException {
        return B(bArr, true);
    }

    public boolean B(byte[] bArr, boolean z) throws IOException {
        boolean z2;
        int i2;
        int length = bArr.length;
        if (length > 0) {
            do {
                i2 = z();
            } while (u(i2, z));
            z2 = false;
        } else {
            z2 = false;
            i2 = -1;
        }
        int i3 = 0;
        while (!z2 && i3 < length) {
            if (!(i2 == -1 || i2 == 10)) {
                if (i2 != 13) {
                    bArr[i3] = (byte) i2;
                    i3++;
                    if (z2 || length <= i3) {
                        break;
                    }
                    i2 = z();
                } else {
                    long g2 = g();
                    if (z() != 10) {
                        D(g2);
                    }
                }
            }
            z2 = true;
            i2 = z();
        }
        if (i3 >= length) {
            boolean z3 = false;
            while (!z3) {
                i2 = z();
                if (!(i2 == -1 || i2 == 10)) {
                    if (i2 == 13) {
                        long g3 = g();
                        if (z() != 10) {
                            D(g3);
                        }
                    }
                }
                z3 = true;
            }
        }
        if (i2 == -1 && i3 == 0) {
            return false;
        }
        if (i3 + 2 <= length) {
            bArr[i3] = 32;
            bArr[i3 + 1] = 88;
        }
        return true;
    }

    public String C(int i2) throws IOException {
        int z;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i3 = i2 - 1;
            if (i2 > 0 && (z = z()) != -1) {
                sb.append((char) z);
                i2 = i3;
            }
        }
        return sb.toString();
    }

    public void D(long j2) throws IOException {
        this.f26104b.r(j2);
    }

    public void E(String str) throws IOException {
        throw new InvalidPdfException(MessageLocalization.b("1.at.file.pointer.2", str, String.valueOf(this.f26104b.d())));
    }

    public void a(int i2) {
        if (i2 != -1) {
            this.f26104b.f((byte) i2);
        }
    }

    public void b() throws IOException {
        this.f26104b.r(0);
        if (C(1024).indexOf("%FDF-") != 0) {
            throw new InvalidPdfException(MessageLocalization.b("fdf.header.not.found", new Object[0]));
        }
    }

    public char d() throws IOException {
        this.f26104b.r(0);
        String C = C(1024);
        if (C.indexOf("%PDF-") == 0) {
            return C.charAt(7);
        }
        throw new InvalidPdfException(MessageLocalization.b("pdf.header.not.found", new Object[0]));
    }

    public void e() throws IOException {
        this.f26104b.close();
    }

    public RandomAccessFileOrArray f() {
        return this.f26104b;
    }

    public long g() throws IOException {
        return this.f26104b.d();
    }

    public int h() {
        return this.f26108f;
    }

    public int i() throws IOException {
        String C = C(1024);
        int indexOf = C.indexOf("%PDF-");
        if (indexOf >= 0 || (indexOf = C.indexOf("%FDF-")) >= 0) {
            return indexOf;
        }
        throw new InvalidPdfException(MessageLocalization.b("pdf.header.not.found", new Object[0]));
    }

    public int k() {
        return this.f26107e;
    }

    public RandomAccessFileOrArray l() {
        return new RandomAccessFileOrArray(this.f26104b);
    }

    public long m() throws IOException {
        long j2 = (long) 1024;
        long e2 = this.f26104b.e() - j2;
        if (e2 < 1) {
            e2 = 1;
        }
        while (e2 > 0) {
            this.f26104b.r(e2);
            int lastIndexOf = C(1024).lastIndexOf("startxref");
            if (lastIndexOf >= 0) {
                return e2 + ((long) lastIndexOf);
            }
            e2 = (e2 - j2) + 9;
        }
        throw new InvalidPdfException(MessageLocalization.b("pdf.startxref.not.found", new Object[0]));
    }

    public String n() {
        return this.f26106d;
    }

    public TokenType o() {
        return this.f26105c;
    }

    public int p() {
        return Integer.parseInt(this.f26106d);
    }

    public boolean s() {
        return this.f26109g;
    }

    public long v() throws IOException {
        return this.f26104b.e();
    }

    public long w() {
        return Long.parseLong(this.f26106d);
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public boolean x() throws java.io.IOException {
        /*
            r12 = this;
        L_0x0000:
            com.itextpdf.text.pdf.RandomAccessFileOrArray r0 = r12.f26104b
            int r0 = r0.read()
            r1 = -1
            if (r0 == r1) goto L_0x000f
            boolean r2 = t(r0)
            if (r2 != 0) goto L_0x0000
        L_0x000f:
            r2 = 0
            if (r0 != r1) goto L_0x0017
            com.itextpdf.text.pdf.PRTokeniser$TokenType r0 = com.itextpdf.text.pdf.PRTokeniser.TokenType.ENDOFFILE
            r12.f26105c = r0
            return r2
        L_0x0017:
            java.lang.StringBuilder r3 = r12.f26103a
            r3.setLength(r2)
            java.lang.String r3 = ""
            r12.f26106d = r3
            r3 = 37
            r4 = 13
            r5 = 10
            r6 = 1
            if (r0 == r3) goto L_0x024c
            java.lang.String r3 = "error.reading.string"
            r7 = 40
            r8 = 48
            if (r0 == r7) goto L_0x0189
            r4 = 47
            if (r0 == r4) goto L_0x014e
            r4 = 60
            r5 = 62
            if (r0 == r4) goto L_0x00e9
            if (r0 == r5) goto L_0x00d3
            r3 = 91
            if (r0 == r3) goto L_0x00d0
            r3 = 93
            if (r0 == r3) goto L_0x00ca
            java.lang.StringBuilder r3 = r12.f26103a
            r3.setLength(r2)
            r3 = 57
            r4 = 46
            r5 = 45
            if (r0 == r5) goto L_0x0076
            r7 = 43
            if (r0 == r7) goto L_0x0076
            if (r0 == r4) goto L_0x0076
            if (r0 < r8) goto L_0x005d
            if (r0 > r3) goto L_0x005d
            goto L_0x0076
        L_0x005d:
            com.itextpdf.text.pdf.PRTokeniser$TokenType r2 = com.itextpdf.text.pdf.PRTokeniser.TokenType.OTHER
            r12.f26105c = r2
        L_0x0061:
            java.lang.StringBuilder r2 = r12.f26103a
            char r0 = (char) r0
            r2.append(r0)
            com.itextpdf.text.pdf.RandomAccessFileOrArray r0 = r12.f26104b
            int r0 = r0.read()
            boolean[] r2 = f26101h
            int r3 = r0 + 1
            boolean r2 = r2[r3]
            if (r2 == 0) goto L_0x0061
            goto L_0x00c3
        L_0x0076:
            com.itextpdf.text.pdf.PRTokeniser$TokenType r7 = com.itextpdf.text.pdf.PRTokeniser.TokenType.NUMBER
            r12.f26105c = r7
            if (r0 != r5) goto L_0x008f
            r0 = 0
        L_0x007d:
            int r0 = r0 + r6
            com.itextpdf.text.pdf.RandomAccessFileOrArray r7 = r12.f26104b
            int r7 = r7.read()
            if (r7 == r5) goto L_0x007d
            java.lang.StringBuilder r9 = r12.f26103a
            r9.append(r5)
            r5 = r0
            r0 = r7
        L_0x008d:
            r7 = 0
            goto L_0x009d
        L_0x008f:
            java.lang.StringBuilder r5 = r12.f26103a
            char r0 = (char) r0
            r5.append(r0)
            com.itextpdf.text.pdf.RandomAccessFileOrArray r0 = r12.f26104b
            int r0 = r0.read()
            r5 = 0
            goto L_0x008d
        L_0x009d:
            if (r0 == r1) goto L_0x00b5
            if (r0 < r8) goto L_0x00a3
            if (r0 <= r3) goto L_0x00a5
        L_0x00a3:
            if (r0 != r4) goto L_0x00b5
        L_0x00a5:
            if (r0 != r4) goto L_0x00a8
            r7 = 1
        L_0x00a8:
            java.lang.StringBuilder r9 = r12.f26103a
            char r0 = (char) r0
            r9.append(r0)
            com.itextpdf.text.pdf.RandomAccessFileOrArray r0 = r12.f26104b
            int r0 = r0.read()
            goto L_0x009d
        L_0x00b5:
            if (r5 <= r6) goto L_0x00c3
            if (r7 != 0) goto L_0x00c3
            java.lang.StringBuilder r3 = r12.f26103a
            r3.setLength(r2)
            java.lang.StringBuilder r2 = r12.f26103a
            r2.append(r8)
        L_0x00c3:
            if (r0 == r1) goto L_0x025c
        L_0x00c5:
            r12.a(r0)
            goto L_0x025c
        L_0x00ca:
            com.itextpdf.text.pdf.PRTokeniser$TokenType r0 = com.itextpdf.text.pdf.PRTokeniser.TokenType.END_ARRAY
        L_0x00cc:
            r12.f26105c = r0
            goto L_0x025c
        L_0x00d0:
            com.itextpdf.text.pdf.PRTokeniser$TokenType r0 = com.itextpdf.text.pdf.PRTokeniser.TokenType.START_ARRAY
            goto L_0x00cc
        L_0x00d3:
            com.itextpdf.text.pdf.RandomAccessFileOrArray r0 = r12.f26104b
            int r0 = r0.read()
            if (r0 == r5) goto L_0x00e6
            java.lang.String r0 = "greaterthan.not.expected"
            java.lang.Object[] r1 = new java.lang.Object[r2]
            java.lang.String r0 = com.itextpdf.text.error_messages.MessageLocalization.b(r0, r1)
            r12.E(r0)
        L_0x00e6:
            com.itextpdf.text.pdf.PRTokeniser$TokenType r0 = com.itextpdf.text.pdf.PRTokeniser.TokenType.END_DIC
            goto L_0x00cc
        L_0x00e9:
            com.itextpdf.text.pdf.RandomAccessFileOrArray r0 = r12.f26104b
            int r0 = r0.read()
            if (r0 != r4) goto L_0x00f4
            com.itextpdf.text.pdf.PRTokeniser$TokenType r0 = com.itextpdf.text.pdf.PRTokeniser.TokenType.START_DIC
            goto L_0x00cc
        L_0x00f4:
            java.lang.StringBuilder r1 = r12.f26103a
            r1.setLength(r2)
            com.itextpdf.text.pdf.PRTokeniser$TokenType r1 = com.itextpdf.text.pdf.PRTokeniser.TokenType.STRING
            r12.f26105c = r1
            r12.f26109g = r6
            r1 = 0
        L_0x0100:
            boolean r4 = t(r0)
            if (r4 == 0) goto L_0x010d
        L_0x0106:
            com.itextpdf.text.pdf.RandomAccessFileOrArray r0 = r12.f26104b
            int r0 = r0.read()
            goto L_0x0100
        L_0x010d:
            if (r0 != r5) goto L_0x0110
            goto L_0x0135
        L_0x0110:
            int r0 = j(r0)
            if (r0 >= 0) goto L_0x0117
            goto L_0x0135
        L_0x0117:
            com.itextpdf.text.pdf.RandomAccessFileOrArray r1 = r12.f26104b
            int r1 = r1.read()
            boolean r4 = t(r1)
            if (r4 == 0) goto L_0x0124
            goto L_0x0117
        L_0x0124:
            if (r1 != r5) goto L_0x012f
            int r4 = r0 << 4
            java.lang.StringBuilder r5 = r12.f26103a
            char r4 = (char) r4
            r5.append(r4)
            goto L_0x0135
        L_0x012f:
            int r1 = j(r1)
            if (r1 >= 0) goto L_0x0144
        L_0x0135:
            if (r0 < 0) goto L_0x0139
            if (r1 >= 0) goto L_0x025c
        L_0x0139:
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r0 = com.itextpdf.text.error_messages.MessageLocalization.b(r3, r0)
        L_0x013f:
            r12.E(r0)
            goto L_0x025c
        L_0x0144:
            int r0 = r0 << 4
            int r0 = r0 + r1
            java.lang.StringBuilder r4 = r12.f26103a
            char r0 = (char) r0
            r4.append(r0)
            goto L_0x0106
        L_0x014e:
            java.lang.StringBuilder r0 = r12.f26103a
            r0.setLength(r2)
            com.itextpdf.text.pdf.PRTokeniser$TokenType r0 = com.itextpdf.text.pdf.PRTokeniser.TokenType.NAME
            r12.f26105c = r0
        L_0x0157:
            com.itextpdf.text.pdf.RandomAccessFileOrArray r0 = r12.f26104b
            int r0 = r0.read()
            boolean[] r1 = f26101h
            int r2 = r0 + 1
            boolean r1 = r1[r2]
            if (r1 == 0) goto L_0x0167
            goto L_0x00c5
        L_0x0167:
            r1 = 35
            if (r0 != r1) goto L_0x0182
            com.itextpdf.text.pdf.RandomAccessFileOrArray r0 = r12.f26104b
            int r0 = r0.read()
            int r0 = j(r0)
            int r0 = r0 << 4
            com.itextpdf.text.pdf.RandomAccessFileOrArray r1 = r12.f26104b
            int r1 = r1.read()
            int r1 = j(r1)
            int r0 = r0 + r1
        L_0x0182:
            java.lang.StringBuilder r1 = r12.f26103a
            char r0 = (char) r0
            r1.append(r0)
            goto L_0x0157
        L_0x0189:
            java.lang.StringBuilder r0 = r12.f26103a
            r0.setLength(r2)
            com.itextpdf.text.pdf.PRTokeniser$TokenType r0 = com.itextpdf.text.pdf.PRTokeniser.TokenType.STRING
            r12.f26105c = r0
            r12.f26109g = r2
            r0 = 0
        L_0x0195:
            com.itextpdf.text.pdf.RandomAccessFileOrArray r9 = r12.f26104b
            int r9 = r9.read()
            if (r9 != r1) goto L_0x019f
            goto L_0x023a
        L_0x019f:
            if (r9 != r7) goto L_0x01a5
            int r0 = r0 + 1
            goto L_0x0238
        L_0x01a5:
            r10 = 41
            if (r9 != r10) goto L_0x01ad
            int r0 = r0 + -1
            goto L_0x0238
        L_0x01ad:
            r11 = 92
            if (r9 != r11) goto L_0x0226
            com.itextpdf.text.pdf.RandomAccessFileOrArray r9 = r12.f26104b
            int r9 = r9.read()
            if (r9 == r5) goto L_0x021e
            if (r9 == r4) goto L_0x0213
            if (r9 == r11) goto L_0x01fe
            r11 = 98
            if (r9 == r11) goto L_0x0210
            r11 = 102(0x66, float:1.43E-43)
            if (r9 == r11) goto L_0x020d
            r11 = 110(0x6e, float:1.54E-43)
            if (r9 == r11) goto L_0x020a
            r11 = 114(0x72, float:1.6E-43)
            if (r9 == r11) goto L_0x0207
            r11 = 116(0x74, float:1.63E-43)
            if (r9 == r11) goto L_0x0204
            if (r9 == r7) goto L_0x01fe
            if (r9 == r10) goto L_0x01fe
            if (r9 < r8) goto L_0x01fe
            r10 = 55
            if (r9 <= r10) goto L_0x01dc
            goto L_0x01fe
        L_0x01dc:
            int r9 = r9 + -48
            com.itextpdf.text.pdf.RandomAccessFileOrArray r11 = r12.f26104b
            int r11 = r11.read()
            if (r11 < r8) goto L_0x0200
            if (r11 <= r10) goto L_0x01e9
            goto L_0x0200
        L_0x01e9:
            int r9 = r9 << 3
            int r9 = r9 + r11
            int r9 = r9 - r8
            com.itextpdf.text.pdf.RandomAccessFileOrArray r11 = r12.f26104b
            int r11 = r11.read()
            if (r11 < r8) goto L_0x0200
            if (r11 <= r10) goto L_0x01f8
            goto L_0x0200
        L_0x01f8:
            int r9 = r9 << 3
            int r9 = r9 + r11
            int r9 = r9 - r8
            r9 = r9 & 255(0xff, float:3.57E-43)
        L_0x01fe:
            r10 = 0
            goto L_0x021f
        L_0x0200:
            r12.a(r11)
            goto L_0x01fe
        L_0x0204:
            r9 = 9
            goto L_0x01fe
        L_0x0207:
            r9 = 13
            goto L_0x01fe
        L_0x020a:
            r9 = 10
            goto L_0x01fe
        L_0x020d:
            r9 = 12
            goto L_0x01fe
        L_0x0210:
            r9 = 8
            goto L_0x01fe
        L_0x0213:
            com.itextpdf.text.pdf.RandomAccessFileOrArray r9 = r12.f26104b
            int r9 = r9.read()
            if (r9 == r5) goto L_0x021e
            r12.a(r9)
        L_0x021e:
            r10 = 1
        L_0x021f:
            if (r10 == 0) goto L_0x0223
            goto L_0x0195
        L_0x0223:
            if (r9 >= 0) goto L_0x0238
            goto L_0x023a
        L_0x0226:
            if (r9 != r4) goto L_0x0238
            com.itextpdf.text.pdf.RandomAccessFileOrArray r9 = r12.f26104b
            int r9 = r9.read()
            if (r9 >= 0) goto L_0x0231
            goto L_0x023a
        L_0x0231:
            if (r9 == r5) goto L_0x0238
            r12.a(r9)
            r9 = 10
        L_0x0238:
            if (r0 != r1) goto L_0x0244
        L_0x023a:
            if (r9 != r1) goto L_0x025c
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r0 = com.itextpdf.text.error_messages.MessageLocalization.b(r3, r0)
            goto L_0x013f
        L_0x0244:
            java.lang.StringBuilder r10 = r12.f26103a
            char r9 = (char) r9
            r10.append(r9)
            goto L_0x0195
        L_0x024c:
            com.itextpdf.text.pdf.PRTokeniser$TokenType r0 = com.itextpdf.text.pdf.PRTokeniser.TokenType.COMMENT
            r12.f26105c = r0
        L_0x0250:
            com.itextpdf.text.pdf.RandomAccessFileOrArray r0 = r12.f26104b
            int r0 = r0.read()
            if (r0 == r1) goto L_0x025c
            if (r0 == r4) goto L_0x025c
            if (r0 != r5) goto L_0x0250
        L_0x025c:
            java.lang.StringBuilder r0 = r12.f26103a
            if (r0 == 0) goto L_0x0266
            java.lang.String r0 = r0.toString()
            r12.f26106d = r0
        L_0x0266:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PRTokeniser.x():boolean");
    }

    public void y() throws IOException {
        int i2 = 0;
        String str = null;
        long j2 = 0;
        String str2 = null;
        while (x()) {
            TokenType tokenType = this.f26105c;
            if (tokenType != TokenType.COMMENT) {
                if (i2 != 0) {
                    if (i2 == 1) {
                        TokenType tokenType2 = TokenType.NUMBER;
                        if (tokenType != tokenType2) {
                            this.f26104b.r(j2);
                            this.f26105c = tokenType2;
                            this.f26106d = str;
                            return;
                        }
                        str2 = this.f26106d;
                    } else if (tokenType != TokenType.OTHER || !this.f26106d.equals("R")) {
                        this.f26104b.r(j2);
                        this.f26105c = TokenType.NUMBER;
                        this.f26106d = str;
                        return;
                    } else {
                        this.f26105c = TokenType.REF;
                        this.f26107e = Integer.parseInt(str);
                        this.f26108f = Integer.parseInt(str2);
                        return;
                    }
                } else if (tokenType == TokenType.NUMBER) {
                    j2 = this.f26104b.d();
                    str = this.f26106d;
                } else {
                    return;
                }
                i2++;
            }
        }
        if (i2 == 1) {
            this.f26105c = TokenType.NUMBER;
        }
    }

    public int z() throws IOException {
        return this.f26104b.read();
    }
}
