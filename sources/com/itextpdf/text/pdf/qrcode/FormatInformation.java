package com.itextpdf.text.pdf.qrcode;

final class FormatInformation {

    /* renamed from: c  reason: collision with root package name */
    private static final int f27189c = 21522;

    /* renamed from: d  reason: collision with root package name */
    private static final int[][] f27190d = {new int[]{f27189c, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f27191e = {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};

    /* renamed from: a  reason: collision with root package name */
    private final ErrorCorrectionLevel f27192a;

    /* renamed from: b  reason: collision with root package name */
    private final byte f27193b;

    private FormatInformation(int i2) {
        this.f27192a = ErrorCorrectionLevel.a((i2 >> 3) & 3);
        this.f27193b = (byte) (i2 & 7);
    }

    static FormatInformation a(int i2, int i3) {
        FormatInformation b2 = b(i2, i3);
        return b2 != null ? b2 : b(i2 ^ f27189c, i3 ^ f27189c);
    }

    private static FormatInformation b(int i2, int i3) {
        int[] iArr;
        int e2;
        int i4 = Integer.MAX_VALUE;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int[][] iArr2 = f27190d;
            if (i5 < iArr2.length) {
                iArr = iArr2[i5];
                int i7 = iArr[0];
                if (i7 != i2 && i7 != i3) {
                    int e3 = e(i2, i7);
                    if (e3 < i4) {
                        i6 = iArr[1];
                        i4 = e3;
                    }
                    if (i2 != i3 && (e2 = e(i3, i7)) < i4) {
                        i6 = iArr[1];
                        i4 = e2;
                    }
                    i5++;
                }
            } else if (i4 <= 3) {
                return new FormatInformation(i6);
            } else {
                return null;
            }
        }
        return new FormatInformation(iArr[1]);
    }

    static int e(int i2, int i3) {
        int i4 = i2 ^ i3;
        int[] iArr = f27191e;
        return iArr[i4 & 15] + iArr[(i4 >>> 4) & 15] + iArr[(i4 >>> 8) & 15] + iArr[(i4 >>> 12) & 15] + iArr[(i4 >>> 16) & 15] + iArr[(i4 >>> 20) & 15] + iArr[(i4 >>> 24) & 15] + iArr[(i4 >>> 28) & 15];
    }

    /* access modifiers changed from: package-private */
    public byte c() {
        return this.f27193b;
    }

    /* access modifiers changed from: package-private */
    public ErrorCorrectionLevel d() {
        return this.f27192a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FormatInformation)) {
            return false;
        }
        FormatInformation formatInformation = (FormatInformation) obj;
        return this.f27192a == formatInformation.f27192a && this.f27193b == formatInformation.f27193b;
    }

    public int hashCode() {
        return (this.f27192a.d() << 3) | this.f27193b;
    }
}
