package com.itextpdf.text.pdf.qrcode;

import com.itextpdf.text.pdf.qrcode.Version;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

public final class Encoder {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f27179a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* renamed from: b  reason: collision with root package name */
    static final String f27180b = "ISO-8859-1";

    private Encoder() {
    }

    static void a(String str, BitVector bitVector, String str2) throws WriterException {
        try {
            byte[] bytes = str.getBytes(str2);
            for (byte c2 : bytes) {
                bitVector.c(c2, 8);
            }
        } catch (UnsupportedEncodingException e2) {
            throw new WriterException(e2.toString());
        }
    }

    static void b(String str, BitVector bitVector) throws WriterException {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int p = p(str.charAt(i2));
            if (p != -1) {
                int i3 = i2 + 1;
                if (i3 < length) {
                    int p2 = p(str.charAt(i3));
                    if (p2 != -1) {
                        bitVector.c((p * 45) + p2, 11);
                        i2 += 2;
                    } else {
                        throw new WriterException();
                    }
                } else {
                    bitVector.c(p, 6);
                    i2 = i3;
                }
            } else {
                throw new WriterException();
            }
        }
    }

    static void c(String str, Mode mode, BitVector bitVector, String str2) throws WriterException {
        if (mode.equals(Mode.f27212e)) {
            h(str, bitVector);
        } else if (mode.equals(Mode.f27213f)) {
            b(str, bitVector);
        } else if (mode.equals(Mode.f27215h)) {
            a(str, bitVector, str2);
        } else if (mode.equals(Mode.f27217j)) {
            e(str, bitVector);
        } else {
            throw new WriterException("Invalid mode: " + mode);
        }
    }

    private static void d(CharacterSetECI characterSetECI, BitVector bitVector) {
        bitVector.c(Mode.f27216i.b(), 4);
        bitVector.c(characterSetECI.e(), 8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0035 A[LOOP:0: B:4:0x0008->B:17:0x0035, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0044 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void e(java.lang.String r6, com.itextpdf.text.pdf.qrcode.BitVector r7) throws com.itextpdf.text.pdf.qrcode.WriterException {
        /*
            java.lang.String r0 = "Shift_JIS"
            byte[] r6 = r6.getBytes(r0)     // Catch:{ UnsupportedEncodingException -> 0x004d }
            int r0 = r6.length
            r1 = 0
        L_0x0008:
            if (r1 >= r0) goto L_0x004c
            byte r2 = r6[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r1 + 1
            byte r3 = r6[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r2 = r2 | r3
            r3 = 33088(0x8140, float:4.6366E-41)
            r4 = -1
            if (r2 < r3) goto L_0x0024
            r5 = 40956(0x9ffc, float:5.7392E-41)
            if (r2 > r5) goto L_0x0024
        L_0x0022:
            int r2 = r2 - r3
            goto L_0x0033
        L_0x0024:
            r3 = 57408(0xe040, float:8.0446E-41)
            if (r2 < r3) goto L_0x0032
            r3 = 60351(0xebbf, float:8.457E-41)
            if (r2 > r3) goto L_0x0032
            r3 = 49472(0xc140, float:6.9325E-41)
            goto L_0x0022
        L_0x0032:
            r2 = -1
        L_0x0033:
            if (r2 == r4) goto L_0x0044
            int r3 = r2 >> 8
            int r3 = r3 * 192
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r3 + r2
            r2 = 13
            r7.c(r3, r2)
            int r1 = r1 + 2
            goto L_0x0008
        L_0x0044:
            com.itextpdf.text.pdf.qrcode.WriterException r6 = new com.itextpdf.text.pdf.qrcode.WriterException
            java.lang.String r7 = "Invalid byte sequence"
            r6.<init>(r7)
            throw r6
        L_0x004c:
            return
        L_0x004d:
            r6 = move-exception
            com.itextpdf.text.pdf.qrcode.WriterException r7 = new com.itextpdf.text.pdf.qrcode.WriterException
            java.lang.String r6 = r6.toString()
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.qrcode.Encoder.e(java.lang.String, com.itextpdf.text.pdf.qrcode.BitVector):void");
    }

    static void f(int i2, int i3, Mode mode, BitVector bitVector) throws WriterException {
        int c2 = mode.c(Version.i(i3));
        int i4 = (1 << c2) - 1;
        if (i2 <= i4) {
            bitVector.c(i2, c2);
            return;
        }
        throw new WriterException(i2 + "is bigger than" + i4);
    }

    static void g(Mode mode, BitVector bitVector) {
        bitVector.c(mode.b(), 4);
    }

    static void h(String str, BitVector bitVector) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int charAt = str.charAt(i2) - '0';
            int i3 = i2 + 2;
            if (i3 < length) {
                bitVector.c((charAt * 100) + ((str.charAt(i2 + 1) - '0') * 10) + (str.charAt(i3) - '0'), 10);
                i2 += 3;
            } else {
                i2++;
                if (i2 < length) {
                    bitVector.c((charAt * 10) + (str.charAt(i2) - '0'), 7);
                    i2 = i3;
                } else {
                    bitVector.c(charAt, 4);
                }
            }
        }
    }

    private static int i(ByteMatrix byteMatrix) {
        return MaskUtil.a(byteMatrix) + MaskUtil.c(byteMatrix) + MaskUtil.d(byteMatrix) + MaskUtil.e(byteMatrix);
    }

    private static int j(BitVector bitVector, ErrorCorrectionLevel errorCorrectionLevel, int i2, ByteMatrix byteMatrix) throws WriterException {
        int i3 = Integer.MAX_VALUE;
        int i4 = -1;
        for (int i5 = 0; i5 < 8; i5++) {
            MatrixUtil.a(bitVector, errorCorrectionLevel, i2, i5, byteMatrix);
            int i6 = i(byteMatrix);
            if (i6 < i3) {
                i4 = i5;
                i3 = i6;
            }
        }
        return i4;
    }

    public static Mode k(String str) {
        return l(str, (String) null);
    }

    public static Mode l(String str, String str2) {
        if ("Shift_JIS".equals(str2)) {
            return t(str) ? Mode.f27217j : Mode.f27215h;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt >= '0' && charAt <= '9') {
                z2 = true;
            } else if (p(charAt) == -1) {
                return Mode.f27215h;
            } else {
                z = true;
            }
        }
        if (z) {
            return Mode.f27213f;
        }
        return z2 ? Mode.f27212e : Mode.f27215h;
    }

    public static void m(String str, ErrorCorrectionLevel errorCorrectionLevel, QRCode qRCode) throws WriterException {
        n(str, errorCorrectionLevel, (Map<EncodeHintType, Object>) null, qRCode);
    }

    public static void n(String str, ErrorCorrectionLevel errorCorrectionLevel, Map<EncodeHintType, Object> map, QRCode qRCode) throws WriterException {
        CharacterSetECI c2;
        String str2 = map == null ? null : (String) map.get(EncodeHintType.f27178b);
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        Mode l2 = l(str, str2);
        BitVector bitVector = new BitVector();
        c(str, l2, bitVector, str2);
        r(bitVector.h(), errorCorrectionLevel, l2, qRCode);
        BitVector bitVector2 = new BitVector();
        Mode mode = Mode.f27215h;
        if (l2 == mode && !"ISO-8859-1".equals(str2) && (c2 = CharacterSetECI.c(str2)) != null) {
            d(c2, bitVector2);
        }
        g(l2, bitVector2);
        f(l2.equals(mode) ? bitVector.h() : str.length(), qRCode.k(), l2, bitVector2);
        bitVector2.b(bitVector);
        u(qRCode.g(), bitVector2);
        BitVector bitVector3 = new BitVector();
        s(bitVector2, qRCode.j(), qRCode.g(), qRCode.i(), bitVector3);
        ByteMatrix byteMatrix = new ByteMatrix(qRCode.e(), qRCode.e());
        qRCode.o(j(bitVector3, qRCode.b(), qRCode.k(), byteMatrix));
        MatrixUtil.a(bitVector3, qRCode.b(), qRCode.k(), qRCode.c(), byteMatrix);
        qRCode.p(byteMatrix);
        if (!qRCode.l()) {
            throw new WriterException("Invalid QR code: " + qRCode.toString());
        }
    }

    static ByteArray o(ByteArray byteArray, int i2) {
        int g2 = byteArray.g();
        int[] iArr = new int[(g2 + i2)];
        for (int i3 = 0; i3 < g2; i3++) {
            iArr[i3] = byteArray.b(i3);
        }
        new ReedSolomonEncoder(GF256.f27194e).b(iArr, i2);
        ByteArray byteArray2 = new ByteArray(i2);
        for (int i4 = 0; i4 < i2; i4++) {
            byteArray2.e(i4, iArr[g2 + i4]);
        }
        return byteArray2;
    }

    static int p(int i2) {
        int[] iArr = f27179a;
        if (i2 < iArr.length) {
            return iArr[i2];
        }
        return -1;
    }

    static void q(int i2, int i3, int i4, int i5, int[] iArr, int[] iArr2) throws WriterException {
        if (i5 < i4) {
            int i6 = i2 % i4;
            int i7 = i4 - i6;
            int i8 = i2 / i4;
            int i9 = i8 + 1;
            int i10 = i3 / i4;
            int i11 = i10 + 1;
            int i12 = i8 - i10;
            int i13 = i9 - i11;
            if (i12 != i13) {
                throw new WriterException("EC bytes mismatch");
            } else if (i4 != i7 + i6) {
                throw new WriterException("RS blocks mismatch");
            } else if (i2 != ((i10 + i12) * i7) + ((i11 + i13) * i6)) {
                throw new WriterException("Total bytes mismatch");
            } else if (i5 < i7) {
                iArr[0] = i10;
                iArr2[0] = i12;
            } else {
                iArr[0] = i11;
                iArr2[0] = i13;
            }
        } else {
            throw new WriterException("Block ID too large");
        }
    }

    private static void r(int i2, ErrorCorrectionLevel errorCorrectionLevel, Mode mode, QRCode qRCode) throws WriterException {
        qRCode.n(errorCorrectionLevel);
        qRCode.r(mode);
        for (int i3 = 1; i3 <= 40; i3++) {
            Version i4 = Version.i(i3);
            int h2 = i4.h();
            Version.ECBlocks f2 = i4.f(errorCorrectionLevel);
            int d2 = f2.d();
            int c2 = f2.c();
            int i5 = h2 - d2;
            if (i5 >= i2 + 3) {
                qRCode.w(i3);
                qRCode.v(h2);
                qRCode.s(i5);
                qRCode.u(c2);
                qRCode.t(d2);
                qRCode.q(i4.e());
                return;
            }
        }
        throw new WriterException("Cannot find proper rs block info (input data too big?)");
    }

    static void s(BitVector bitVector, int i2, int i3, int i4, BitVector bitVector2) throws WriterException {
        int i5 = i2;
        int i6 = i3;
        int i7 = i4;
        BitVector bitVector3 = bitVector2;
        if (bitVector.h() == i6) {
            ArrayList arrayList = new ArrayList(i7);
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            for (int i11 = 0; i11 < i7; i11++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                int[] iArr3 = iArr;
                q(i2, i3, i4, i11, iArr, iArr2);
                ByteArray byteArray = new ByteArray();
                byteArray.f(bitVector.f(), i8, iArr3[0]);
                ByteArray o = o(byteArray, iArr2[0]);
                arrayList.add(new BlockPair(byteArray, o));
                i9 = Math.max(i9, byteArray.g());
                i10 = Math.max(i10, o.g());
                i8 += iArr3[0];
            }
            if (i6 == i8) {
                for (int i12 = 0; i12 < i9; i12++) {
                    for (int i13 = 0; i13 < arrayList.size(); i13++) {
                        ByteArray a2 = ((BlockPair) arrayList.get(i13)).a();
                        if (i12 < a2.g()) {
                            bitVector3.c(a2.b(i12), 8);
                        }
                    }
                }
                for (int i14 = 0; i14 < i10; i14++) {
                    for (int i15 = 0; i15 < arrayList.size(); i15++) {
                        ByteArray b2 = ((BlockPair) arrayList.get(i15)).b();
                        if (i14 < b2.g()) {
                            bitVector3.c(b2.b(i14), 8);
                        }
                    }
                }
                if (i5 != bitVector2.h()) {
                    throw new WriterException("Interleaving error: " + i5 + " and " + bitVector2.h() + " differ.");
                }
                return;
            }
            throw new WriterException("Data bytes does not match offset");
        }
        throw new WriterException("Number of bits and data bytes does not match");
    }

    private static boolean t(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i2 = 0; i2 < length; i2 += 2) {
                byte b2 = bytes[i2] & 255;
                if ((b2 < 129 || b2 > 159) && (b2 < 224 || b2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    static void u(int i2, BitVector bitVector) throws WriterException {
        int i3 = i2 << 3;
        if (bitVector.g() <= i3) {
            for (int i4 = 0; i4 < 4 && bitVector.g() < i3; i4++) {
                bitVector.a(0);
            }
            int g2 = bitVector.g() % 8;
            if (g2 > 0) {
                int i5 = 8 - g2;
                for (int i6 = 0; i6 < i5; i6++) {
                    bitVector.a(0);
                }
            }
            if (bitVector.g() % 8 == 0) {
                int h2 = i2 - bitVector.h();
                for (int i7 = 0; i7 < h2; i7++) {
                    bitVector.c(i7 % 2 == 0 ? 236 : 17, 8);
                }
                if (bitVector.g() != i3) {
                    throw new WriterException("Bits size does not equal capacity");
                }
                return;
            }
            throw new WriterException("Number of bits is not a multiple of 8");
        }
        throw new WriterException("data bits cannot fit in the QR Code" + bitVector.g() + " > " + i3);
    }
}
