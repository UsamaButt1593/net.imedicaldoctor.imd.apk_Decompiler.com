package androidx.core.util;

import androidx.annotation.RestrictTo;
import com.itextpdf.text.pdf.Barcode128;
import java.io.PrintWriter;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class TimeUtils {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})

    /* renamed from: a  reason: collision with root package name */
    public static final int f6317a = 19;

    /* renamed from: b  reason: collision with root package name */
    private static final int f6318b = 60;

    /* renamed from: c  reason: collision with root package name */
    private static final int f6319c = 3600;

    /* renamed from: d  reason: collision with root package name */
    private static final int f6320d = 86400;

    /* renamed from: e  reason: collision with root package name */
    private static final Object f6321e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private static char[] f6322f = new char[24];

    private TimeUtils() {
    }

    private static int a(int i2, int i3, boolean z, int i4) {
        if (i2 > 99 || (z && i4 >= 3)) {
            return i3 + 3;
        }
        if (i2 > 9 || (z && i4 >= 2)) {
            return i3 + 2;
        }
        if (z || i2 > 0) {
            return i3 + 1;
        }
        return 0;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void b(long j2, long j3, PrintWriter printWriter) {
        if (j2 == 0) {
            printWriter.print("--");
        } else {
            d(j2 - j3, printWriter, 0);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void c(long j2, PrintWriter printWriter) {
        d(j2, printWriter, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void d(long j2, PrintWriter printWriter, int i2) {
        synchronized (f6321e) {
            printWriter.print(new String(f6322f, 0, f(j2, i2)));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void e(long j2, StringBuilder sb) {
        synchronized (f6321e) {
            sb.append(f6322f, 0, f(j2, 0));
        }
    }

    private static int f(long j2, int i2) {
        char c2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        long j3 = j2;
        int i8 = i2;
        if (f6322f.length < i8) {
            f6322f = new char[i8];
        }
        char[] cArr = f6322f;
        int i9 = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
        if (i9 == 0) {
            int i10 = i8 - 1;
            while (i10 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (i9 > 0) {
            c2 = '+';
        } else {
            j3 = -j3;
            c2 = '-';
        }
        int i11 = (int) (j3 % 1000);
        int floor = (int) Math.floor((double) (j3 / 1000));
        if (floor > f6320d) {
            i3 = floor / f6320d;
            floor -= f6320d * i3;
        } else {
            i3 = 0;
        }
        if (floor > f6319c) {
            i4 = floor / f6319c;
            floor -= i4 * f6319c;
        } else {
            i4 = 0;
        }
        if (floor > 60) {
            int i12 = floor / 60;
            i5 = floor - (i12 * 60);
            i6 = i12;
        } else {
            i5 = floor;
            i6 = 0;
        }
        if (i8 != 0) {
            int a2 = a(i3, 1, false, 0);
            int a3 = a2 + a(i4, 1, a2 > 0, 2);
            int a4 = a3 + a(i6, 1, a3 > 0, 2);
            int a5 = a4 + a(i5, 1, a4 > 0, 2);
            i7 = 0;
            for (int a6 = a5 + a(i11, 2, true, a5 > 0 ? 3 : 0) + 1; a6 < i8; a6++) {
                cArr[i7] = ' ';
                i7++;
            }
        } else {
            i7 = 0;
        }
        cArr[i7] = c2;
        int i13 = i7 + 1;
        boolean z = i8 != 0;
        int i14 = i13;
        int g2 = g(cArr, i3, Barcode128.G, i13, false, 0);
        int g3 = g(cArr, i4, Barcode128.K, g2, g2 != i14, z ? 2 : 0);
        int g4 = g(cArr, i6, 'm', g3, g3 != i14, z ? 2 : 0);
        int g5 = g(cArr, i5, 's', g4, g4 != i14, z ? 2 : 0);
        int g6 = g(cArr, i11, 'm', g5, true, (!z || g5 == i14) ? 0 : 3);
        cArr[g6] = 's';
        return g6 + 1;
    }

    private static int g(char[] cArr, int i2, char c2, int i3, boolean z, int i4) {
        int i5;
        if (!z && i2 <= 0) {
            return i3;
        }
        if ((!z || i4 < 3) && i2 <= 99) {
            i5 = i3;
        } else {
            int i6 = i2 / 100;
            cArr[i3] = (char) (i6 + 48);
            i5 = i3 + 1;
            i2 -= i6 * 100;
        }
        if ((z && i4 >= 2) || i2 > 9 || i3 != i5) {
            int i7 = i2 / 10;
            cArr[i5] = (char) (i7 + 48);
            i5++;
            i2 -= i7 * 10;
        }
        cArr[i5] = (char) (i2 + 48);
        cArr[i5 + 1] = c2;
        return i5 + 2;
    }
}
