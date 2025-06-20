package androidx.media3.exoplayer.video.spherical;

import androidx.annotation.Nullable;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.video.spherical.Projection;
import java.util.ArrayList;
import java.util.zip.Inflater;

final class ProjectionDecoder {

    /* renamed from: a  reason: collision with root package name */
    private static final int f12839a = 2037673328;

    /* renamed from: b  reason: collision with root package name */
    private static final int f12840b = 1836279920;

    /* renamed from: c  reason: collision with root package name */
    private static final int f12841c = 1918990112;

    /* renamed from: d  reason: collision with root package name */
    private static final int f12842d = 1684433976;

    /* renamed from: e  reason: collision with root package name */
    private static final int f12843e = 1835365224;

    /* renamed from: f  reason: collision with root package name */
    private static final int f12844f = 1886547818;

    /* renamed from: g  reason: collision with root package name */
    private static final int f12845g = 10000;

    /* renamed from: h  reason: collision with root package name */
    private static final int f12846h = 32000;

    /* renamed from: i  reason: collision with root package name */
    private static final int f12847i = 128000;

    private ProjectionDecoder() {
    }

    @Nullable
    public static Projection a(byte[] bArr, int i2) {
        ArrayList<Projection.Mesh> arrayList;
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        try {
            arrayList = c(parsableByteArray) ? f(parsableByteArray) : e(parsableByteArray);
        } catch (ArrayIndexOutOfBoundsException unused) {
            arrayList = null;
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        if (size == 1) {
            return new Projection(arrayList.get(0), i2);
        }
        if (size != 2) {
            return null;
        }
        return new Projection(arrayList.get(0), arrayList.get(1), i2);
    }

    private static int b(int i2) {
        return (-(i2 & 1)) ^ (i2 >> 1);
    }

    private static boolean c(ParsableByteArray parsableByteArray) {
        parsableByteArray.Z(4);
        int s = parsableByteArray.s();
        parsableByteArray.Y(0);
        return s == 1886547818;
    }

    @Nullable
    private static Projection.Mesh d(ParsableByteArray parsableByteArray) {
        int s = parsableByteArray.s();
        if (s > 10000) {
            return null;
        }
        float[] fArr = new float[s];
        for (int i2 = 0; i2 < s; i2++) {
            fArr[i2] = parsableByteArray.r();
        }
        int s2 = parsableByteArray.s();
        if (s2 > f12846h) {
            return null;
        }
        double d2 = 2.0d;
        double log = Math.log(2.0d);
        int ceil = (int) Math.ceil(Math.log(((double) s) * 2.0d) / log);
        ParsableBitArray parsableBitArray = new ParsableBitArray(parsableByteArray.e());
        int i3 = 8;
        parsableBitArray.q(parsableByteArray.f() * 8);
        float[] fArr2 = new float[(s2 * 5)];
        int i4 = 5;
        int[] iArr = new int[5];
        int i5 = 0;
        int i6 = 0;
        while (i5 < s2) {
            int i7 = 0;
            while (i7 < i4) {
                int b2 = iArr[i7] + b(parsableBitArray.h(ceil));
                if (b2 >= s || b2 < 0) {
                    return null;
                }
                fArr2[i6] = fArr[b2];
                iArr[i7] = b2;
                i7++;
                i6++;
                i4 = 5;
            }
            i5++;
            i4 = 5;
        }
        parsableBitArray.q((parsableBitArray.e() + 7) & -8);
        int i8 = 32;
        int h2 = parsableBitArray.h(32);
        Projection.SubMesh[] subMeshArr = new Projection.SubMesh[h2];
        int i9 = 0;
        while (i9 < h2) {
            int h3 = parsableBitArray.h(i3);
            int h4 = parsableBitArray.h(i3);
            int h5 = parsableBitArray.h(i8);
            if (h5 > f12847i) {
                return null;
            }
            int i10 = h3;
            int ceil2 = (int) Math.ceil(Math.log(((double) s2) * d2) / log);
            float[] fArr3 = new float[(h5 * 3)];
            float[] fArr4 = new float[(h5 * 2)];
            int i11 = 0;
            for (int i12 = 0; i12 < h5; i12++) {
                i11 += b(parsableBitArray.h(ceil2));
                if (i11 < 0 || i11 >= s2) {
                    return null;
                }
                int i13 = i12 * 3;
                int i14 = i11 * 5;
                fArr3[i13] = fArr2[i14];
                fArr3[i13 + 1] = fArr2[i14 + 1];
                fArr3[i13 + 2] = fArr2[i14 + 2];
                int i15 = i12 * 2;
                fArr4[i15] = fArr2[i14 + 3];
                fArr4[i15 + 1] = fArr2[i14 + 4];
            }
            subMeshArr[i9] = new Projection.SubMesh(i10, fArr3, fArr4, h4);
            i9++;
            i8 = 32;
            d2 = 2.0d;
            i3 = 8;
        }
        return new Projection.Mesh(subMeshArr);
    }

    @Nullable
    private static ArrayList<Projection.Mesh> e(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.L() != 0) {
            return null;
        }
        parsableByteArray.Z(7);
        int s = parsableByteArray.s();
        if (s == f12842d) {
            ParsableByteArray parsableByteArray2 = new ParsableByteArray();
            Inflater inflater = new Inflater(true);
            try {
                if (!Util.c1(parsableByteArray, parsableByteArray2, inflater)) {
                    return null;
                }
                parsableByteArray = parsableByteArray2;
            } finally {
                inflater.end();
            }
        } else if (s != f12841c) {
            return null;
        }
        return g(parsableByteArray);
    }

    @Nullable
    private static ArrayList<Projection.Mesh> f(ParsableByteArray parsableByteArray) {
        int s;
        parsableByteArray.Z(8);
        int f2 = parsableByteArray.f();
        int g2 = parsableByteArray.g();
        while (f2 < g2 && (s = parsableByteArray.s() + f2) > f2 && s <= g2) {
            int s2 = parsableByteArray.s();
            if (s2 == f12839a || s2 == f12840b) {
                parsableByteArray.X(s);
                return e(parsableByteArray);
            }
            parsableByteArray.Y(s);
            f2 = s;
        }
        return null;
    }

    @Nullable
    private static ArrayList<Projection.Mesh> g(ParsableByteArray parsableByteArray) {
        ArrayList<Projection.Mesh> arrayList = new ArrayList<>();
        int f2 = parsableByteArray.f();
        int g2 = parsableByteArray.g();
        while (f2 < g2) {
            int s = parsableByteArray.s() + f2;
            if (s <= f2 || s > g2) {
                return null;
            }
            if (parsableByteArray.s() == f12843e) {
                Projection.Mesh d2 = d(parsableByteArray);
                if (d2 == null) {
                    return null;
                }
                arrayList.add(d2);
            }
            parsableByteArray.Y(s);
            f2 = s;
        }
        return arrayList;
    }
}
