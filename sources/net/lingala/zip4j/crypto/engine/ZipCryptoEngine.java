package net.lingala.zip4j.crypto.engine;

public class ZipCryptoEngine {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f30571b = new int[256];

    /* renamed from: a  reason: collision with root package name */
    private final int[] f30572a = new int[3];

    static {
        for (int i2 = 0; i2 < 256; i2++) {
            int i3 = i2;
            for (int i4 = 0; i4 < 8; i4++) {
                int i5 = i3 & 1;
                i3 >>>= 1;
                if (i5 == 1) {
                    i3 ^= -306674912;
                }
            }
            f30571b[i2] = i3;
        }
    }

    private int a(int i2, byte b2) {
        return f30571b[(i2 ^ b2) & 255] ^ (i2 >>> 8);
    }

    public byte b() {
        int i2 = this.f30572a[2] | 2;
        return (byte) ((i2 * (i2 ^ 1)) >>> 8);
    }

    public void c(char[] cArr) {
        int[] iArr = this.f30572a;
        iArr[0] = 305419896;
        iArr[1] = 591751049;
        iArr[2] = 878082192;
        for (char c2 : cArr) {
            d((byte) (c2 & 255));
        }
    }

    public void d(byte b2) {
        int[] iArr = this.f30572a;
        iArr[0] = a(iArr[0], b2);
        int[] iArr2 = this.f30572a;
        int i2 = iArr2[1] + (iArr2[0] & 255);
        iArr2[1] = i2;
        int i3 = (i2 * 134775813) + 1;
        iArr2[1] = i3;
        iArr2[2] = a(iArr2[2], (byte) (i3 >> 24));
    }
}
