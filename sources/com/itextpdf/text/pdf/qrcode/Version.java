package com.itextpdf.text.pdf.qrcode;

import androidx.media3.extractor.ts.TsExtractor;

public final class Version {

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f27237e = {31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};

    /* renamed from: f  reason: collision with root package name */
    private static final Version[] f27238f = b();

    /* renamed from: a  reason: collision with root package name */
    private final int f27239a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f27240b;

    /* renamed from: c  reason: collision with root package name */
    private final ECBlocks[] f27241c;

    /* renamed from: d  reason: collision with root package name */
    private final int f27242d;

    public static final class ECB {

        /* renamed from: a  reason: collision with root package name */
        private final int f27243a;

        /* renamed from: b  reason: collision with root package name */
        private final int f27244b;

        ECB(int i2, int i3) {
            this.f27243a = i2;
            this.f27244b = i3;
        }

        public int a() {
            return this.f27243a;
        }

        public int b() {
            return this.f27244b;
        }
    }

    public static final class ECBlocks {

        /* renamed from: a  reason: collision with root package name */
        private final int f27245a;

        /* renamed from: b  reason: collision with root package name */
        private final ECB[] f27246b;

        ECBlocks(int i2, ECB ecb) {
            this.f27245a = i2;
            this.f27246b = new ECB[]{ecb};
        }

        public ECB[] a() {
            return this.f27246b;
        }

        public int b() {
            return this.f27245a;
        }

        public int c() {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                ECB[] ecbArr = this.f27246b;
                if (i2 >= ecbArr.length) {
                    return i3;
                }
                i3 += ecbArr[i2].a();
                i2++;
            }
        }

        public int d() {
            return this.f27245a * c();
        }

        ECBlocks(int i2, ECB ecb, ECB ecb2) {
            this.f27245a = i2;
            this.f27246b = new ECB[]{ecb, ecb2};
        }
    }

    private Version(int i2, int[] iArr, ECBlocks eCBlocks, ECBlocks eCBlocks2, ECBlocks eCBlocks3, ECBlocks eCBlocks4) {
        this.f27239a = i2;
        this.f27240b = iArr;
        this.f27241c = new ECBlocks[]{eCBlocks, eCBlocks2, eCBlocks3, eCBlocks4};
        int b2 = eCBlocks.b();
        ECB[] a2 = eCBlocks.a();
        int i3 = 0;
        for (ECB ecb : a2) {
            i3 += ecb.a() * (ecb.b() + b2);
        }
        this.f27242d = i3;
    }

    private static Version[] b() {
        Version version = new Version(1, new int[0], new ECBlocks(7, new ECB(1, 19)), new ECBlocks(10, new ECB(1, 16)), new ECBlocks(13, new ECB(1, 13)), new ECBlocks(17, new ECB(1, 9)));
        Version version2 = new Version(2, new int[]{6, 18}, new ECBlocks(10, new ECB(1, 34)), new ECBlocks(16, new ECB(1, 28)), new ECBlocks(22, new ECB(1, 22)), new ECBlocks(28, new ECB(1, 16)));
        Version version3 = new Version(3, new int[]{6, 22}, new ECBlocks(15, new ECB(1, 55)), new ECBlocks(26, new ECB(1, 44)), new ECBlocks(18, new ECB(2, 17)), new ECBlocks(22, new ECB(2, 13)));
        Version version4 = new Version(4, new int[]{6, 26}, new ECBlocks(20, new ECB(1, 80)), new ECBlocks(18, new ECB(2, 32)), new ECBlocks(26, new ECB(2, 24)), new ECBlocks(16, new ECB(4, 9)));
        Version version5 = new Version(5, new int[]{6, 30}, new ECBlocks(26, new ECB(1, 108)), new ECBlocks(24, new ECB(2, 43)), new ECBlocks(18, new ECB(2, 15), new ECB(2, 16)), new ECBlocks(22, new ECB(2, 11), new ECB(2, 12)));
        Version version6 = new Version(6, new int[]{6, 34}, new ECBlocks(18, new ECB(2, 68)), new ECBlocks(16, new ECB(4, 27)), new ECBlocks(24, new ECB(4, 19)), new ECBlocks(28, new ECB(4, 15)));
        Version version7 = new Version(7, new int[]{6, 22, 38}, new ECBlocks(20, new ECB(2, 78)), new ECBlocks(18, new ECB(4, 31)), new ECBlocks(18, new ECB(2, 14), new ECB(4, 15)), new ECBlocks(26, new ECB(4, 13), new ECB(1, 14)));
        Version version8 = new Version(8, new int[]{6, 24, 42}, new ECBlocks(24, new ECB(2, 97)), new ECBlocks(22, new ECB(2, 38), new ECB(2, 39)), new ECBlocks(22, new ECB(4, 18), new ECB(2, 19)), new ECBlocks(26, new ECB(4, 14), new ECB(2, 15)));
        Version version9 = new Version(9, new int[]{6, 26, 46}, new ECBlocks(30, new ECB(2, 116)), new ECBlocks(22, new ECB(3, 36), new ECB(2, 37)), new ECBlocks(20, new ECB(4, 16), new ECB(4, 17)), new ECBlocks(24, new ECB(4, 12), new ECB(4, 13)));
        Version version10 = new Version(10, new int[]{6, 28, 50}, new ECBlocks(18, new ECB(2, 68), new ECB(2, 69)), new ECBlocks(26, new ECB(4, 43), new ECB(1, 44)), new ECBlocks(24, new ECB(6, 19), new ECB(2, 20)), new ECBlocks(28, new ECB(6, 15), new ECB(2, 16)));
        Version version11 = new Version(11, new int[]{6, 30, 54}, new ECBlocks(20, new ECB(4, 81)), new ECBlocks(30, new ECB(1, 50), new ECB(4, 51)), new ECBlocks(28, new ECB(4, 22), new ECB(4, 23)), new ECBlocks(24, new ECB(3, 12), new ECB(8, 13)));
        Version version12 = new Version(12, new int[]{6, 32, 58}, new ECBlocks(24, new ECB(2, 92), new ECB(2, 93)), new ECBlocks(22, new ECB(6, 36), new ECB(2, 37)), new ECBlocks(26, new ECB(4, 20), new ECB(6, 21)), new ECBlocks(28, new ECB(7, 14), new ECB(4, 15)));
        Version version13 = new Version(13, new int[]{6, 34, 62}, new ECBlocks(26, new ECB(4, 107)), new ECBlocks(22, new ECB(8, 37), new ECB(1, 38)), new ECBlocks(24, new ECB(8, 20), new ECB(4, 21)), new ECBlocks(22, new ECB(12, 11), new ECB(4, 12)));
        Version version14 = new Version(14, new int[]{6, 26, 46, 66}, new ECBlocks(30, new ECB(3, 115), new ECB(1, 116)), new ECBlocks(24, new ECB(4, 40), new ECB(5, 41)), new ECBlocks(20, new ECB(11, 16), new ECB(5, 17)), new ECBlocks(24, new ECB(11, 12), new ECB(5, 13)));
        Version version15 = new Version(15, new int[]{6, 26, 48, 70}, new ECBlocks(22, new ECB(5, 87), new ECB(1, 88)), new ECBlocks(24, new ECB(5, 41), new ECB(5, 42)), new ECBlocks(30, new ECB(5, 24), new ECB(7, 25)), new ECBlocks(24, new ECB(11, 12), new ECB(7, 13)));
        Version version16 = new Version(16, new int[]{6, 26, 50, 74}, new ECBlocks(24, new ECB(5, 98), new ECB(1, 99)), new ECBlocks(28, new ECB(7, 45), new ECB(3, 46)), new ECBlocks(24, new ECB(15, 19), new ECB(2, 20)), new ECBlocks(30, new ECB(3, 15), new ECB(13, 16)));
        Version version17 = new Version(17, new int[]{6, 30, 54, 78}, new ECBlocks(28, new ECB(1, 107), new ECB(5, 108)), new ECBlocks(28, new ECB(10, 46), new ECB(1, 47)), new ECBlocks(28, new ECB(1, 22), new ECB(15, 23)), new ECBlocks(28, new ECB(2, 14), new ECB(17, 15)));
        Version version18 = new Version(18, new int[]{6, 30, 56, 82}, new ECBlocks(30, new ECB(5, 120), new ECB(1, 121)), new ECBlocks(26, new ECB(9, 43), new ECB(4, 44)), new ECBlocks(28, new ECB(17, 22), new ECB(1, 23)), new ECBlocks(28, new ECB(2, 14), new ECB(19, 15)));
        Version version19 = version7;
        Version version20 = new Version(19, new int[]{6, 30, 58, 86}, new ECBlocks(28, new ECB(3, 113), new ECB(4, 114)), new ECBlocks(26, new ECB(3, 44), new ECB(11, 45)), new ECBlocks(26, new ECB(17, 21), new ECB(4, 22)), new ECBlocks(26, new ECB(9, 13), new ECB(16, 14)));
        Version version21 = new Version(20, new int[]{6, 34, 62, 90}, new ECBlocks(28, new ECB(3, 107), new ECB(5, 108)), new ECBlocks(26, new ECB(3, 41), new ECB(13, 42)), new ECBlocks(30, new ECB(15, 24), new ECB(5, 25)), new ECBlocks(28, new ECB(15, 15), new ECB(10, 16)));
        Version version22 = new Version(21, new int[]{6, 28, 50, 72, 94}, new ECBlocks(28, new ECB(4, 116), new ECB(4, 117)), new ECBlocks(26, new ECB(17, 42)), new ECBlocks(28, new ECB(17, 22), new ECB(6, 23)), new ECBlocks(30, new ECB(19, 16), new ECB(6, 17)));
        Version version23 = new Version(22, new int[]{6, 26, 50, 74, 98}, new ECBlocks(28, new ECB(2, 111), new ECB(7, 112)), new ECBlocks(28, new ECB(17, 46)), new ECBlocks(30, new ECB(7, 24), new ECB(16, 25)), new ECBlocks(24, new ECB(34, 13)));
        Version version24 = version22;
        Version version25 = new Version(23, new int[]{6, 30, 54, 74, 102}, new ECBlocks(30, new ECB(4, 121), new ECB(5, 122)), new ECBlocks(28, new ECB(4, 47), new ECB(14, 48)), new ECBlocks(30, new ECB(11, 24), new ECB(14, 25)), new ECBlocks(30, new ECB(16, 15), new ECB(14, 16)));
        Version version26 = version20;
        Version version27 = new Version(24, new int[]{6, 28, 54, 80, 106}, new ECBlocks(30, new ECB(6, 117), new ECB(4, 118)), new ECBlocks(28, new ECB(6, 45), new ECB(14, 46)), new ECBlocks(30, new ECB(11, 24), new ECB(16, 25)), new ECBlocks(30, new ECB(30, 16), new ECB(2, 17)));
        Version version28 = new Version(25, new int[]{6, 32, 58, 84, 110}, new ECBlocks(26, new ECB(8, 106), new ECB(4, 107)), new ECBlocks(28, new ECB(8, 47), new ECB(13, 48)), new ECBlocks(30, new ECB(7, 24), new ECB(22, 25)), new ECBlocks(30, new ECB(22, 15), new ECB(13, 16)));
        Version version29 = new Version(26, new int[]{6, 30, 58, 86, 114}, new ECBlocks(28, new ECB(10, 114), new ECB(2, 115)), new ECBlocks(28, new ECB(19, 46), new ECB(4, 47)), new ECBlocks(28, new ECB(28, 22), new ECB(6, 23)), new ECBlocks(30, new ECB(33, 16), new ECB(4, 17)));
        Version version30 = version29;
        Version version31 = new Version(27, new int[]{6, 34, 62, 90, 118}, new ECBlocks(30, new ECB(8, 122), new ECB(4, 123)), new ECBlocks(28, new ECB(22, 45), new ECB(3, 46)), new ECBlocks(30, new ECB(8, 23), new ECB(26, 24)), new ECBlocks(30, new ECB(12, 15), new ECB(28, 16)));
        Version version32 = new Version(28, new int[]{6, 26, 50, 74, 98, 122}, new ECBlocks(30, new ECB(3, 117), new ECB(10, 118)), new ECBlocks(28, new ECB(3, 45), new ECB(23, 46)), new ECBlocks(30, new ECB(4, 24), new ECB(31, 25)), new ECBlocks(30, new ECB(11, 15), new ECB(31, 16)));
        Version version33 = new Version(29, new int[]{6, 30, 54, 78, 102, 126}, new ECBlocks(30, new ECB(7, 116), new ECB(7, 117)), new ECBlocks(28, new ECB(21, 45), new ECB(7, 46)), new ECBlocks(30, new ECB(1, 23), new ECB(37, 24)), new ECBlocks(30, new ECB(19, 15), new ECB(26, 16)));
        Version version34 = new Version(30, new int[]{6, 26, 52, 78, 104, TsExtractor.L}, new ECBlocks(30, new ECB(5, 115), new ECB(10, 116)), new ECBlocks(28, new ECB(19, 47), new ECB(10, 48)), new ECBlocks(30, new ECB(15, 24), new ECB(25, 25)), new ECBlocks(30, new ECB(23, 15), new ECB(25, 16)));
        Version version35 = new Version(31, new int[]{6, 30, 56, 82, 108, TsExtractor.T}, new ECBlocks(30, new ECB(13, 115), new ECB(3, 116)), new ECBlocks(28, new ECB(2, 46), new ECB(29, 47)), new ECBlocks(30, new ECB(42, 24), new ECB(1, 25)), new ECBlocks(30, new ECB(23, 15), new ECB(28, 16)));
        Version version36 = new Version(32, new int[]{6, 34, 60, 86, 112, TsExtractor.K}, new ECBlocks(30, new ECB(17, 115)), new ECBlocks(28, new ECB(10, 46), new ECB(23, 47)), new ECBlocks(30, new ECB(10, 24), new ECB(35, 25)), new ECBlocks(30, new ECB(19, 15), new ECB(35, 16)));
        Version version37 = new Version(33, new int[]{6, 30, 58, 86, 114, 142}, new ECBlocks(30, new ECB(17, 115), new ECB(1, 116)), new ECBlocks(28, new ECB(14, 46), new ECB(21, 47)), new ECBlocks(30, new ECB(29, 24), new ECB(19, 25)), new ECBlocks(30, new ECB(11, 15), new ECB(46, 16)));
        Version version38 = new Version(34, new int[]{6, 34, 62, 90, 118, 146}, new ECBlocks(30, new ECB(13, 115), new ECB(6, 116)), new ECBlocks(28, new ECB(14, 46), new ECB(23, 47)), new ECBlocks(30, new ECB(44, 24), new ECB(7, 25)), new ECBlocks(30, new ECB(59, 16), new ECB(1, 17)));
        Version version39 = new Version(35, new int[]{6, 30, 54, 78, 102, 126, 150}, new ECBlocks(30, new ECB(12, 121), new ECB(7, 122)), new ECBlocks(28, new ECB(12, 47), new ECB(26, 48)), new ECBlocks(30, new ECB(39, 24), new ECB(14, 25)), new ECBlocks(30, new ECB(22, 15), new ECB(41, 16)));
        Version version40 = new Version(36, new int[]{6, 24, 50, 76, 102, 128, 154}, new ECBlocks(30, new ECB(6, 121), new ECB(14, 122)), new ECBlocks(28, new ECB(6, 47), new ECB(34, 48)), new ECBlocks(30, new ECB(46, 24), new ECB(10, 25)), new ECBlocks(30, new ECB(2, 15), new ECB(64, 16)));
        Version version41 = new Version(37, new int[]{6, 28, 54, 80, 106, 132, 158}, new ECBlocks(30, new ECB(17, 122), new ECB(4, 123)), new ECBlocks(28, new ECB(29, 46), new ECB(14, 47)), new ECBlocks(30, new ECB(49, 24), new ECB(10, 25)), new ECBlocks(30, new ECB(24, 15), new ECB(46, 16)));
        Version version42 = new Version(38, new int[]{6, 32, 58, 84, 110, TsExtractor.V, 162}, new ECBlocks(30, new ECB(4, 122), new ECB(18, 123)), new ECBlocks(28, new ECB(13, 46), new ECB(32, 47)), new ECBlocks(30, new ECB(48, 24), new ECB(14, 25)), new ECBlocks(30, new ECB(42, 15), new ECB(32, 16)));
        Version version43 = new Version(39, new int[]{6, 26, 54, 82, 110, TsExtractor.K, 166}, new ECBlocks(30, new ECB(20, 117), new ECB(4, 118)), new ECBlocks(28, new ECB(40, 47), new ECB(7, 48)), new ECBlocks(30, new ECB(43, 24), new ECB(22, 25)), new ECBlocks(30, new ECB(10, 15), new ECB(67, 16)));
        return new Version[]{version, version2, version3, version4, version5, version6, version19, version8, version9, version10, version11, version12, version13, version14, version15, version16, version17, version18, version26, version21, version24, version23, version25, version27, version28, version30, version31, version32, version33, version34, version35, version36, version37, version38, version39, version40, version41, version42, version43, new Version(40, new int[]{6, 30, 58, 86, 114, 142, 170}, new ECBlocks(30, new ECB(19, 118), new ECB(6, 119)), new ECBlocks(28, new ECB(18, 47), new ECB(31, 48)), new ECBlocks(30, new ECB(34, 24), new ECB(34, 25)), new ECBlocks(30, new ECB(20, 15), new ECB(61, 16)))};
    }

    static Version c(int i2) {
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int[] iArr = f27237e;
            if (i4 < iArr.length) {
                int i6 = iArr[i4];
                if (i6 == i2) {
                    return i(i4 + 7);
                }
                int e2 = FormatInformation.e(i2, i6);
                if (e2 < i3) {
                    i5 = i4 + 7;
                    i3 = e2;
                }
                i4++;
            } else if (i3 <= 3) {
                return i(i5);
            } else {
                return null;
            }
        }
    }

    public static Version g(int i2) {
        if (i2 % 4 == 1) {
            return i((i2 - 17) >> 2);
        }
        throw new IllegalArgumentException();
    }

    public static Version i(int i2) {
        if (i2 >= 1 && i2 <= 40) {
            return f27238f[i2 - 1];
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public BitMatrix a() {
        int e2 = e();
        BitMatrix bitMatrix = new BitMatrix(e2);
        bitMatrix.i(0, 0, 9, 9);
        int i2 = e2 - 8;
        bitMatrix.i(i2, 0, 8, 9);
        bitMatrix.i(0, i2, 9, 8);
        int length = this.f27240b.length;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = this.f27240b[i3] - 2;
            for (int i5 = 0; i5 < length; i5++) {
                if (!((i3 == 0 && (i5 == 0 || i5 == length - 1)) || (i3 == length - 1 && i5 == 0))) {
                    bitMatrix.i(this.f27240b[i5] - 2, i4, 5, 5);
                }
            }
        }
        int i6 = e2 - 17;
        bitMatrix.i(6, 9, 1, i6);
        bitMatrix.i(9, 6, i6, 1);
        if (this.f27239a > 6) {
            int i7 = e2 - 11;
            bitMatrix.i(i7, 0, 3, 6);
            bitMatrix.i(0, i7, 6, 3);
        }
        return bitMatrix;
    }

    public int[] d() {
        return this.f27240b;
    }

    public int e() {
        return (this.f27239a * 4) + 17;
    }

    public ECBlocks f(ErrorCorrectionLevel errorCorrectionLevel) {
        return this.f27241c[errorCorrectionLevel.d()];
    }

    public int h() {
        return this.f27242d;
    }

    public int j() {
        return this.f27239a;
    }

    public String toString() {
        return String.valueOf(this.f27239a);
    }
}
