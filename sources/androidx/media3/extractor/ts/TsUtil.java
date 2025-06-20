package androidx.media3.extractor.ts;

import androidx.media3.common.C;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public final class TsUtil {
    private TsUtil() {
    }

    public static int a(byte[] bArr, int i2, int i3) {
        while (i2 < i3 && bArr[i2] != 71) {
            i2++;
        }
        return i2;
    }

    public static boolean b(byte[] bArr, int i2, int i3, int i4) {
        int i5 = 0;
        for (int i6 = -4; i6 <= 4; i6++) {
            int i7 = (i6 * TsExtractor.D) + i4;
            if (i7 < i2 || i7 >= i3 || bArr[i7] != 71) {
                i5 = 0;
            } else {
                i5++;
                if (i5 == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    public static long c(ParsableByteArray parsableByteArray, int i2, int i3) {
        parsableByteArray.Y(i2);
        if (parsableByteArray.a() < 5) {
            return C.f9084b;
        }
        int s = parsableByteArray.s();
        if ((8388608 & s) != 0 || ((2096896 & s) >> 8) != i3 || (s & 32) == 0 || parsableByteArray.L() < 7 || parsableByteArray.a() < 7 || (parsableByteArray.L() & 16) != 16) {
            return C.f9084b;
        }
        byte[] bArr = new byte[6];
        parsableByteArray.n(bArr, 0, 6);
        return d(bArr);
    }

    private static long d(byte[] bArr) {
        return ((((long) bArr[0]) & 255) << 25) | ((((long) bArr[1]) & 255) << 17) | ((((long) bArr[2]) & 255) << 9) | ((((long) bArr[3]) & 255) << 1) | ((255 & ((long) bArr[4])) >> 7);
    }
}
