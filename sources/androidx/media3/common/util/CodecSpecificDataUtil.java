package androidx.media3.common.util;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@UnstableApi
public final class CodecSpecificDataUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f9503a = {0, 0, 0, 1};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f9504b = {"", ExifInterface.W4, "B", "C"};

    /* renamed from: c  reason: collision with root package name */
    private static final int f9505c = 1;

    /* renamed from: d  reason: collision with root package name */
    private static final int f9506d = 32;

    /* renamed from: e  reason: collision with root package name */
    private static final int f9507e = 15;

    /* renamed from: f  reason: collision with root package name */
    private static final int f9508f = 0;

    private CodecSpecificDataUtil() {
    }

    public static String a(int i2, int i3, int i4) {
        return String.format("avc1.%02X%02X%02X", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
    }

    public static List<byte[]> b(boolean z) {
        return Collections.singletonList(z ? new byte[]{1} : new byte[]{0});
    }

    public static String c(int i2, boolean z, int i3, int i4, int[] iArr, int i5) {
        StringBuilder sb = new StringBuilder(Util.S("hvc1.%s%d.%X.%c%d", f9504b[i2], Integer.valueOf(i3), Integer.valueOf(i4), Character.valueOf(z ? 'H' : 'L'), Integer.valueOf(i5)));
        int length = iArr.length;
        while (length > 0 && iArr[length - 1] == 0) {
            length--;
        }
        for (int i6 = 0; i6 < length; i6++) {
            sb.append(String.format(".%02X", new Object[]{Integer.valueOf(iArr[i6])}));
        }
        return sb.toString();
    }

    public static byte[] d(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = f9503a;
        byte[] bArr3 = new byte[(bArr2.length + i3)];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i2, bArr3, bArr2.length, i3);
        return bArr3;
    }

    private static int e(byte[] bArr, int i2) {
        int length = bArr.length - f9503a.length;
        while (i2 <= length) {
            if (g(bArr, i2)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static Pair<Integer, Integer> f(byte[] bArr) {
        boolean z;
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3 + 3;
            if (i4 < bArr.length) {
                if (parsableByteArray.O() == 1 && (bArr[i4] & 240) == 32) {
                    z = true;
                    break;
                }
                parsableByteArray.Y(parsableByteArray.f() - 2);
                i3++;
            } else {
                z = false;
                break;
            }
        }
        Assertions.b(z, "Invalid input: VOL not found.");
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        parsableBitArray.s((i3 + 4) * 8);
        parsableBitArray.s(1);
        parsableBitArray.s(8);
        if (parsableBitArray.g()) {
            parsableBitArray.s(4);
            parsableBitArray.s(3);
        }
        if (parsableBitArray.h(4) == 15) {
            parsableBitArray.s(8);
            parsableBitArray.s(8);
        }
        if (parsableBitArray.g()) {
            parsableBitArray.s(2);
            parsableBitArray.s(1);
            if (parsableBitArray.g()) {
                parsableBitArray.s(79);
            }
        }
        Assertions.b(parsableBitArray.h(2) == 0, "Only supports rectangular video object layer shape.");
        Assertions.a(parsableBitArray.g());
        int h2 = parsableBitArray.h(16);
        Assertions.a(parsableBitArray.g());
        if (parsableBitArray.g()) {
            Assertions.a(h2 > 0);
            for (int i5 = h2 - 1; i5 > 0; i5 >>= 1) {
                i2++;
            }
            parsableBitArray.s(i2);
        }
        Assertions.a(parsableBitArray.g());
        int h3 = parsableBitArray.h(13);
        Assertions.a(parsableBitArray.g());
        int h4 = parsableBitArray.h(13);
        Assertions.a(parsableBitArray.g());
        parsableBitArray.s(1);
        return Pair.create(Integer.valueOf(h3), Integer.valueOf(h4));
    }

    private static boolean g(byte[] bArr, int i2) {
        if (bArr.length - i2 <= f9503a.length) {
            return false;
        }
        int i3 = 0;
        while (true) {
            byte[] bArr2 = f9503a;
            if (i3 >= bArr2.length) {
                return true;
            }
            if (bArr[i2 + i3] != bArr2[i3]) {
                return false;
            }
            i3++;
        }
    }

    public static Pair<Integer, Integer> h(byte[] bArr) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        parsableByteArray.Y(9);
        int L = parsableByteArray.L();
        parsableByteArray.Y(20);
        return Pair.create(Integer.valueOf(parsableByteArray.P()), Integer.valueOf(L));
    }

    public static boolean i(List<byte[]> list) {
        return list.size() == 1 && list.get(0).length == 1 && list.get(0)[0] == 1;
    }

    @Nullable
    public static byte[][] j(byte[] bArr) {
        if (!g(bArr, 0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        do {
            arrayList.add(Integer.valueOf(i2));
            i2 = e(bArr, i2 + f9503a.length);
        } while (i2 != -1);
        byte[][] bArr2 = new byte[arrayList.size()][];
        int i3 = 0;
        while (i3 < arrayList.size()) {
            int intValue = ((Integer) arrayList.get(i3)).intValue();
            int intValue2 = (i3 < arrayList.size() + -1 ? ((Integer) arrayList.get(i3 + 1)).intValue() : bArr.length) - intValue;
            byte[] bArr3 = new byte[intValue2];
            System.arraycopy(bArr, intValue, bArr3, 0, intValue2);
            bArr2[i3] = bArr3;
            i3++;
        }
        return bArr2;
    }
}
