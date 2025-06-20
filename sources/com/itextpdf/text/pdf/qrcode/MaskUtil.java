package com.itextpdf.text.pdf.qrcode;

public final class MaskUtil {
    private MaskUtil() {
    }

    public static int a(ByteMatrix byteMatrix) {
        return b(byteMatrix, true) + b(byteMatrix, false);
    }

    private static int b(ByteMatrix byteMatrix, boolean z) {
        int d2 = z ? byteMatrix.d() : byteMatrix.e();
        int e2 = z ? byteMatrix.e() : byteMatrix.d();
        byte[][] c2 = byteMatrix.c();
        byte b2 = -1;
        int i2 = 0;
        for (int i3 = 0; i3 < d2; i3++) {
            int i4 = 0;
            for (int i5 = 0; i5 < e2; i5++) {
                byte b3 = z ? c2[i3][i5] : c2[i5][i3];
                if (b3 == b2) {
                    i4++;
                    if (i4 == 5) {
                        i2 += 3;
                    } else if (i4 > 5) {
                        i2++;
                    }
                } else {
                    b2 = b3;
                    i4 = 1;
                }
            }
        }
        return i2;
    }

    public static int c(ByteMatrix byteMatrix) {
        byte[][] c2 = byteMatrix.c();
        int e2 = byteMatrix.e();
        int d2 = byteMatrix.d();
        int i2 = 0;
        for (int i3 = 0; i3 < d2 - 1; i3++) {
            int i4 = 0;
            while (i4 < e2 - 1) {
                byte[] bArr = c2[i3];
                byte b2 = bArr[i4];
                int i5 = i4 + 1;
                if (b2 == bArr[i5]) {
                    byte[] bArr2 = c2[i3 + 1];
                    if (b2 == bArr2[i4] && b2 == bArr2[i5]) {
                        i2 += 3;
                    }
                }
                i4 = i5;
            }
        }
        return i2;
    }

    public static int d(ByteMatrix byteMatrix) {
        int i2;
        int i3;
        int i4;
        int i5;
        byte[][] c2 = byteMatrix.c();
        int e2 = byteMatrix.e();
        int d2 = byteMatrix.d();
        int i6 = 0;
        for (int i7 = 0; i7 < d2; i7++) {
            for (int i8 = 0; i8 < e2; i8++) {
                int i9 = i8 + 6;
                if (i9 < e2) {
                    byte[] bArr = c2[i7];
                    if (bArr[i8] == 1 && bArr[i8 + 1] == 0 && bArr[i8 + 2] == 1 && bArr[i8 + 3] == 1 && bArr[i8 + 4] == 1 && bArr[i8 + 5] == 0 && bArr[i9] == 1 && (((i4 = i8 + 10) < e2 && bArr[i8 + 7] == 0 && bArr[i8 + 8] == 0 && bArr[i8 + 9] == 0 && bArr[i4] == 0) || (i8 - 4 >= 0 && bArr[i8 - 1] == 0 && bArr[i8 - 2] == 0 && bArr[i8 - 3] == 0 && bArr[i5] == 0))) {
                        i6 += 40;
                    }
                }
                int i10 = i7 + 6;
                if (i10 < d2 && c2[i7][i8] == 1 && c2[i7 + 1][i8] == 0 && c2[i7 + 2][i8] == 1 && c2[i7 + 3][i8] == 1 && c2[i7 + 4][i8] == 1 && c2[i7 + 5][i8] == 0 && c2[i10][i8] == 1 && (((i2 = i7 + 10) < d2 && c2[i7 + 7][i8] == 0 && c2[i7 + 8][i8] == 0 && c2[i7 + 9][i8] == 0 && c2[i2][i8] == 0) || (i7 - 4 >= 0 && c2[i7 - 1][i8] == 0 && c2[i7 - 2][i8] == 0 && c2[i7 - 3][i8] == 0 && c2[i3][i8] == 0))) {
                    i6 += 40;
                }
            }
        }
        return i6;
    }

    public static int e(ByteMatrix byteMatrix) {
        byte[][] c2 = byteMatrix.c();
        int e2 = byteMatrix.e();
        int d2 = byteMatrix.d();
        int i2 = 0;
        for (int i3 = 0; i3 < d2; i3++) {
            for (int i4 = 0; i4 < e2; i4++) {
                if (c2[i3][i4] == 1) {
                    i2++;
                }
            }
        }
        return (Math.abs((int) (((((double) i2) / ((double) (byteMatrix.d() * byteMatrix.e()))) * 100.0d) - 50.0d)) / 5) * 10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        r1 = r3 & 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004c, code lost:
        if (r1 != 0) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0028, code lost:
        r1 = r1 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0029, code lost:
        r1 = r1 & 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean f(int r1, int r2, int r3) {
        /*
            boolean r0 = com.itextpdf.text.pdf.qrcode.QRCode.m(r1)
            if (r0 == 0) goto L_0x0051
            r0 = 1
            switch(r1) {
                case 0: goto L_0x004a;
                case 1: goto L_0x0047;
                case 2: goto L_0x0044;
                case 3: goto L_0x0040;
                case 4: goto L_0x003b;
                case 5: goto L_0x0033;
                case 6: goto L_0x002b;
                case 7: goto L_0x0021;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = "Invalid mask pattern: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x0021:
            int r1 = r3 * r2
            int r1 = r1 % 3
            int r3 = r3 + r2
            r2 = r3 & 1
        L_0x0028:
            int r1 = r1 + r2
        L_0x0029:
            r1 = r1 & r0
            goto L_0x004c
        L_0x002b:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L_0x0029
        L_0x0033:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L_0x004c
        L_0x003b:
            int r1 = r3 >>> 1
            int r2 = r2 / 3
            goto L_0x0028
        L_0x0040:
            int r3 = r3 + r2
            int r1 = r3 % 3
            goto L_0x004c
        L_0x0044:
            int r1 = r2 % 3
            goto L_0x004c
        L_0x0047:
            r1 = r3 & 1
            goto L_0x004c
        L_0x004a:
            int r3 = r3 + r2
            goto L_0x0047
        L_0x004c:
            if (r1 != 0) goto L_0x004f
            goto L_0x0050
        L_0x004f:
            r0 = 0
        L_0x0050:
            return r0
        L_0x0051:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Invalid mask pattern"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.qrcode.MaskUtil.f(int, int, int):boolean");
    }
}
