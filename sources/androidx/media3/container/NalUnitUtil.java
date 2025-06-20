package androidx.media3.container;

import androidx.annotation.Nullable;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.util.Arrays;

@UnstableApi
public final class NalUnitUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9666a = "NalUnitUtil";

    /* renamed from: b  reason: collision with root package name */
    public static final int f9667b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f9668c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f9669d = 5;

    /* renamed from: e  reason: collision with root package name */
    public static final int f9670e = 6;

    /* renamed from: f  reason: collision with root package name */
    public static final int f9671f = 7;

    /* renamed from: g  reason: collision with root package name */
    public static final int f9672g = 8;

    /* renamed from: h  reason: collision with root package name */
    public static final int f9673h = 9;

    /* renamed from: i  reason: collision with root package name */
    public static final int f9674i = 14;

    /* renamed from: j  reason: collision with root package name */
    public static final byte[] f9675j = {0, 0, 0, 1};

    /* renamed from: k  reason: collision with root package name */
    public static final int f9676k = 255;

    /* renamed from: l  reason: collision with root package name */
    public static final float[] f9677l = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* renamed from: m  reason: collision with root package name */
    private static final int f9678m = 6;

    /* renamed from: n  reason: collision with root package name */
    private static final int f9679n = 7;
    private static final int o = 39;
    private static final Object p = new Object();
    private static int[] q = new int[10];

    public static final class H265SpsData {

        /* renamed from: a  reason: collision with root package name */
        public final int f9680a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f9681b;

        /* renamed from: c  reason: collision with root package name */
        public final int f9682c;

        /* renamed from: d  reason: collision with root package name */
        public final int f9683d;

        /* renamed from: e  reason: collision with root package name */
        public final int f9684e;

        /* renamed from: f  reason: collision with root package name */
        public final int f9685f;

        /* renamed from: g  reason: collision with root package name */
        public final int f9686g;

        /* renamed from: h  reason: collision with root package name */
        public final int[] f9687h;

        /* renamed from: i  reason: collision with root package name */
        public final int f9688i;

        /* renamed from: j  reason: collision with root package name */
        public final int f9689j;

        /* renamed from: k  reason: collision with root package name */
        public final int f9690k;

        /* renamed from: l  reason: collision with root package name */
        public final int f9691l;

        /* renamed from: m  reason: collision with root package name */
        public final float f9692m;

        /* renamed from: n  reason: collision with root package name */
        public final int f9693n;
        public final int o;
        public final int p;

        public H265SpsData(int i2, boolean z, int i3, int i4, int i5, int i6, int i7, int[] iArr, int i8, int i9, int i10, int i11, float f2, int i12, int i13, int i14) {
            this.f9680a = i2;
            this.f9681b = z;
            this.f9682c = i3;
            this.f9683d = i4;
            this.f9684e = i5;
            this.f9685f = i6;
            this.f9686g = i7;
            this.f9687h = iArr;
            this.f9688i = i8;
            this.f9689j = i9;
            this.f9690k = i10;
            this.f9691l = i11;
            this.f9692m = f2;
            this.f9693n = i12;
            this.o = i13;
            this.p = i14;
        }
    }

    public static final class PpsData {

        /* renamed from: a  reason: collision with root package name */
        public final int f9694a;

        /* renamed from: b  reason: collision with root package name */
        public final int f9695b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f9696c;

        public PpsData(int i2, int i3, boolean z) {
            this.f9694a = i2;
            this.f9695b = i3;
            this.f9696c = z;
        }
    }

    public static final class SpsData {

        /* renamed from: a  reason: collision with root package name */
        public final int f9697a;

        /* renamed from: b  reason: collision with root package name */
        public final int f9698b;

        /* renamed from: c  reason: collision with root package name */
        public final int f9699c;

        /* renamed from: d  reason: collision with root package name */
        public final int f9700d;

        /* renamed from: e  reason: collision with root package name */
        public final int f9701e;

        /* renamed from: f  reason: collision with root package name */
        public final int f9702f;

        /* renamed from: g  reason: collision with root package name */
        public final int f9703g;

        /* renamed from: h  reason: collision with root package name */
        public final float f9704h;

        /* renamed from: i  reason: collision with root package name */
        public final int f9705i;

        /* renamed from: j  reason: collision with root package name */
        public final int f9706j;

        /* renamed from: k  reason: collision with root package name */
        public final boolean f9707k;

        /* renamed from: l  reason: collision with root package name */
        public final boolean f9708l;

        /* renamed from: m  reason: collision with root package name */
        public final int f9709m;

        /* renamed from: n  reason: collision with root package name */
        public final int f9710n;
        public final int o;
        public final boolean p;
        public final int q;
        public final int r;
        public final int s;

        public SpsData(int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f2, int i9, int i10, boolean z, boolean z2, int i11, int i12, int i13, boolean z3, int i14, int i15, int i16) {
            this.f9697a = i2;
            this.f9698b = i3;
            this.f9699c = i4;
            this.f9700d = i5;
            this.f9701e = i6;
            this.f9702f = i7;
            this.f9703g = i8;
            this.f9704h = f2;
            this.f9705i = i9;
            this.f9706j = i10;
            this.f9707k = z;
            this.f9708l = z2;
            this.f9709m = i11;
            this.f9710n = i12;
            this.o = i13;
            this.p = z3;
            this.q = i14;
            this.r = i15;
            this.s = i16;
        }
    }

    private NalUnitUtil() {
    }

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static void b(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i2 + 1;
            if (i4 < position) {
                byte b2 = byteBuffer.get(i2) & 255;
                if (i3 == 3) {
                    if (b2 == 1 && (byteBuffer.get(i4) & Ascii.I) == 7) {
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.position(i2 - 3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                } else if (b2 == 0) {
                    i3++;
                }
                if (b2 != 0) {
                    i3 = 0;
                }
                i2 = i4;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }

    public static int c(byte[] bArr, int i2, int i3, boolean[] zArr) {
        int i4 = i3 - i2;
        boolean z = false;
        Assertions.i(i4 >= 0);
        if (i4 == 0) {
            return i3;
        }
        if (zArr[0]) {
            a(zArr);
            return i2 - 3;
        } else if (i4 > 1 && zArr[1] && bArr[i2] == 1) {
            a(zArr);
            return i2 - 2;
        } else if (i4 <= 2 || !zArr[2] || bArr[i2] != 0 || bArr[i2 + 1] != 1) {
            int i5 = i3 - 1;
            int i6 = i2 + 2;
            while (i6 < i5) {
                byte b2 = bArr[i6];
                if ((b2 & 254) == 0) {
                    int i7 = i6 - 2;
                    if (bArr[i7] == 0 && bArr[i6 - 1] == 0 && b2 == 1) {
                        a(zArr);
                        return i7;
                    }
                    i6 -= 2;
                }
                i6 += 3;
            }
            zArr[0] = i4 <= 2 ? !(i4 != 2 ? !zArr[1] || bArr[i5] != 1 : !(zArr[2] && bArr[i3 + -2] == 0 && bArr[i5] == 1)) : bArr[i3 + -3] == 0 && bArr[i3 + -2] == 0 && bArr[i5] == 1;
            zArr[1] = i4 <= 1 ? !(!zArr[2] || bArr[i5] != 0) : bArr[i3 + -2] == 0 && bArr[i5] == 0;
            if (bArr[i5] == 0) {
                z = true;
            }
            zArr[2] = z;
            return i3;
        } else {
            a(zArr);
            return i2 - 1;
        }
    }

    private static int d(byte[] bArr, int i2, int i3) {
        while (i2 < i3 - 2) {
            if (bArr[i2] == 0 && bArr[i2 + 1] == 0 && bArr[i2 + 2] == 3) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int e(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 126) >> 1;
    }

    public static int f(byte[] bArr, int i2) {
        return bArr[i2 + 3] & Ascii.I;
    }

    public static boolean g(@Nullable String str, byte b2) {
        if (!MimeTypes.f9235j.equals(str) || (b2 & Ascii.I) != 6) {
            return MimeTypes.f9236k.equals(str) && ((b2 & 126) >> 1) == 39;
        }
        return true;
    }

    public static H265SpsData h(byte[] bArr, int i2, int i3) {
        return i(bArr, i2 + 2, i3);
    }

    public static H265SpsData i(byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        float f2;
        int i7;
        int i8;
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i2, i3);
        parsableNalUnitBitArray.l(4);
        int e2 = parsableNalUnitBitArray.e(3);
        parsableNalUnitBitArray.k();
        int e3 = parsableNalUnitBitArray.e(2);
        boolean d2 = parsableNalUnitBitArray.d();
        int e4 = parsableNalUnitBitArray.e(5);
        int i9 = 0;
        for (int i10 = 0; i10 < 32; i10++) {
            if (parsableNalUnitBitArray.d()) {
                i9 |= 1 << i10;
            }
        }
        int[] iArr = new int[6];
        for (int i11 = 0; i11 < 6; i11++) {
            iArr[i11] = parsableNalUnitBitArray.e(8);
        }
        int e5 = parsableNalUnitBitArray.e(8);
        int i12 = 0;
        for (int i13 = 0; i13 < e2; i13++) {
            if (parsableNalUnitBitArray.d()) {
                i12 += 89;
            }
            if (parsableNalUnitBitArray.d()) {
                i12 += 8;
            }
        }
        parsableNalUnitBitArray.l(i12);
        if (e2 > 0) {
            parsableNalUnitBitArray.l((8 - e2) * 2);
        }
        int h2 = parsableNalUnitBitArray.h();
        int h3 = parsableNalUnitBitArray.h();
        if (h3 == 3) {
            parsableNalUnitBitArray.k();
        }
        int h4 = parsableNalUnitBitArray.h();
        int h5 = parsableNalUnitBitArray.h();
        if (parsableNalUnitBitArray.d()) {
            int h6 = parsableNalUnitBitArray.h();
            int h7 = parsableNalUnitBitArray.h();
            int h8 = parsableNalUnitBitArray.h();
            int h9 = parsableNalUnitBitArray.h();
            h4 -= ((h3 == 1 || h3 == 2) ? 2 : 1) * (h6 + h7);
            h5 -= (h3 == 1 ? 2 : 1) * (h8 + h9);
        }
        int i14 = h5;
        int i15 = h4;
        int i16 = i14;
        int h10 = parsableNalUnitBitArray.h();
        int h11 = parsableNalUnitBitArray.h();
        int h12 = parsableNalUnitBitArray.h();
        int i17 = parsableNalUnitBitArray.d() ? 0 : e2;
        while (true) {
            parsableNalUnitBitArray.h();
            parsableNalUnitBitArray.h();
            parsableNalUnitBitArray.h();
            if (i17 > e2) {
                break;
            }
            i17++;
        }
        parsableNalUnitBitArray.h();
        parsableNalUnitBitArray.h();
        parsableNalUnitBitArray.h();
        if (parsableNalUnitBitArray.d() && parsableNalUnitBitArray.d()) {
            n(parsableNalUnitBitArray);
        }
        parsableNalUnitBitArray.l(2);
        if (parsableNalUnitBitArray.d()) {
            parsableNalUnitBitArray.l(8);
            parsableNalUnitBitArray.h();
            parsableNalUnitBitArray.h();
            parsableNalUnitBitArray.k();
        }
        p(parsableNalUnitBitArray);
        if (parsableNalUnitBitArray.d()) {
            int h13 = parsableNalUnitBitArray.h();
            for (int i18 = 0; i18 < h13; i18++) {
                parsableNalUnitBitArray.l(h12 + 5);
            }
        }
        parsableNalUnitBitArray.l(2);
        int i19 = -1;
        float f3 = 1.0f;
        if (parsableNalUnitBitArray.d()) {
            if (parsableNalUnitBitArray.d()) {
                int e6 = parsableNalUnitBitArray.e(8);
                if (e6 == 255) {
                    int e7 = parsableNalUnitBitArray.e(16);
                    int e8 = parsableNalUnitBitArray.e(16);
                    if (!(e7 == 0 || e8 == 0)) {
                        f3 = ((float) e7) / ((float) e8);
                    }
                } else {
                    float[] fArr = f9677l;
                    if (e6 < fArr.length) {
                        f3 = fArr[e6];
                    } else {
                        Log.n(f9666a, "Unexpected aspect_ratio_idc value: " + e6);
                    }
                }
            }
            if (parsableNalUnitBitArray.d()) {
                parsableNalUnitBitArray.k();
            }
            if (parsableNalUnitBitArray.d()) {
                parsableNalUnitBitArray.l(3);
                i5 = parsableNalUnitBitArray.d() ? 1 : 2;
                if (parsableNalUnitBitArray.d()) {
                    int e9 = parsableNalUnitBitArray.e(8);
                    int e10 = parsableNalUnitBitArray.e(8);
                    parsableNalUnitBitArray.l(8);
                    i19 = ColorInfo.m(e9);
                    i8 = ColorInfo.n(e10);
                } else {
                    i8 = -1;
                }
            } else {
                i8 = -1;
                i5 = -1;
            }
            if (parsableNalUnitBitArray.d()) {
                parsableNalUnitBitArray.h();
                parsableNalUnitBitArray.h();
            }
            parsableNalUnitBitArray.k();
            if (parsableNalUnitBitArray.d()) {
                i16 *= 2;
            }
            i4 = i8;
            i6 = i19;
            f2 = f3;
            i7 = i16;
        } else {
            i7 = i16;
            f2 = 1.0f;
            i6 = -1;
            i5 = -1;
            i4 = -1;
        }
        return new H265SpsData(e3, d2, e4, i9, h3, h10, h11, iArr, e5, h2, i15, i7, f2, i6, i5, i4);
    }

    public static PpsData j(byte[] bArr, int i2, int i3) {
        return k(bArr, i2 + 1, i3);
    }

    public static PpsData k(byte[] bArr, int i2, int i3) {
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i2, i3);
        int h2 = parsableNalUnitBitArray.h();
        int h3 = parsableNalUnitBitArray.h();
        parsableNalUnitBitArray.k();
        return new PpsData(h2, h3, parsableNalUnitBitArray.d());
    }

    public static SpsData l(byte[] bArr, int i2, int i3) {
        return m(bArr, i2 + 1, i3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x013d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.media3.container.NalUnitUtil.SpsData m(byte[] r26, int r27, int r28) {
        /*
            androidx.media3.container.ParsableNalUnitBitArray r0 = new androidx.media3.container.ParsableNalUnitBitArray
            r1 = r26
            r2 = r27
            r3 = r28
            r0.<init>(r1, r2, r3)
            r1 = 8
            int r3 = r0.e(r1)
            int r4 = r0.e(r1)
            int r5 = r0.e(r1)
            int r6 = r0.h()
            r2 = 100
            r7 = 3
            r9 = 1
            if (r3 == r2) goto L_0x004d
            r2 = 110(0x6e, float:1.54E-43)
            if (r3 == r2) goto L_0x004d
            r2 = 122(0x7a, float:1.71E-43)
            if (r3 == r2) goto L_0x004d
            r2 = 244(0xf4, float:3.42E-43)
            if (r3 == r2) goto L_0x004d
            r2 = 44
            if (r3 == r2) goto L_0x004d
            r2 = 83
            if (r3 == r2) goto L_0x004d
            r2 = 86
            if (r3 == r2) goto L_0x004d
            r2 = 118(0x76, float:1.65E-43)
            if (r3 == r2) goto L_0x004d
            r2 = 128(0x80, float:1.794E-43)
            if (r3 == r2) goto L_0x004d
            r2 = 138(0x8a, float:1.93E-43)
            if (r3 != r2) goto L_0x0048
            goto L_0x004d
        L_0x0048:
            r2 = 1
            r11 = 0
            r12 = 0
            r13 = 0
            goto L_0x008e
        L_0x004d:
            int r2 = r0.h()
            if (r2 != r7) goto L_0x0058
            boolean r11 = r0.d()
            goto L_0x0059
        L_0x0058:
            r11 = 0
        L_0x0059:
            int r12 = r0.h()
            int r13 = r0.h()
            r0.k()
            boolean r14 = r0.d()
            if (r14 == 0) goto L_0x0088
            if (r2 == r7) goto L_0x006f
            r14 = 8
            goto L_0x0071
        L_0x006f:
            r14 = 12
        L_0x0071:
            r15 = 0
        L_0x0072:
            if (r15 >= r14) goto L_0x0088
            boolean r16 = r0.d()
            if (r16 == 0) goto L_0x0085
            r10 = 6
            if (r15 >= r10) goto L_0x0080
            r10 = 16
            goto L_0x0082
        L_0x0080:
            r10 = 64
        L_0x0082:
            o(r0, r10)
        L_0x0085:
            int r15 = r15 + 1
            goto L_0x0072
        L_0x0088:
            r25 = r13
            r13 = r11
            r11 = r12
            r12 = r25
        L_0x008e:
            int r10 = r0.h()
            int r15 = r10 + 4
            int r14 = r0.h()
            if (r14 != 0) goto L_0x00a4
            int r10 = r0.h()
            int r10 = r10 + 4
            r1 = r10
        L_0x00a1:
            r18 = 0
            goto L_0x00c7
        L_0x00a4:
            if (r14 != r9) goto L_0x00c5
            boolean r10 = r0.d()
            r0.g()
            r0.g()
            int r1 = r0.h()
            long r7 = (long) r1
            r18 = r10
            r1 = 0
        L_0x00b8:
            long r9 = (long) r1
            int r19 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r19 >= 0) goto L_0x00c3
            r0.h()
            int r1 = r1 + 1
            goto L_0x00b8
        L_0x00c3:
            r1 = 0
            goto L_0x00c7
        L_0x00c5:
            r1 = 0
            goto L_0x00a1
        L_0x00c7:
            int r7 = r0.h()
            r0.k()
            int r8 = r0.h()
            r9 = 1
            int r8 = r8 + r9
            int r10 = r0.h()
            int r10 = r10 + r9
            boolean r19 = r0.d()
            int r9 = 2 - r19
            int r9 = r9 * r10
            if (r19 != 0) goto L_0x00e6
            r0.k()
        L_0x00e6:
            r0.k()
            r10 = 16
            int r8 = r8 * 16
            int r9 = r9 * 16
            boolean r10 = r0.d()
            r20 = 2
            if (r10 == 0) goto L_0x0132
            int r10 = r0.h()
            int r21 = r0.h()
            int r22 = r0.h()
            int r23 = r0.h()
            if (r2 != 0) goto L_0x0111
            int r2 = 2 - r19
            r26 = r14
            r14 = 1
            r17 = 1
            goto L_0x0126
        L_0x0111:
            r26 = r14
            r14 = 3
            if (r2 != r14) goto L_0x011a
            r14 = 1
            r17 = 1
            goto L_0x011d
        L_0x011a:
            r14 = 1
            r17 = 2
        L_0x011d:
            if (r2 != r14) goto L_0x0121
            r2 = 2
            goto L_0x0122
        L_0x0121:
            r2 = 1
        L_0x0122:
            int r24 = 2 - r19
            int r2 = r2 * r24
        L_0x0126:
            int r10 = r10 + r21
            int r10 = r10 * r17
            int r8 = r8 - r10
            int r22 = r22 + r23
            int r22 = r22 * r2
            int r9 = r9 - r22
            goto L_0x0135
        L_0x0132:
            r26 = r14
            r14 = 1
        L_0x0135:
            boolean r2 = r0.d()
            r17 = 1065353216(0x3f800000, float:1.0)
            if (r2 == 0) goto L_0x01cd
            boolean r2 = r0.d()
            if (r2 == 0) goto L_0x017e
            r2 = 8
            int r10 = r0.e(r2)
            r2 = 255(0xff, float:3.57E-43)
            if (r10 != r2) goto L_0x0160
            r2 = 16
            int r10 = r0.e(r2)
            int r2 = r0.e(r2)
            if (r10 == 0) goto L_0x017e
            if (r2 == 0) goto L_0x017e
            float r10 = (float) r10
            float r2 = (float) r2
            float r17 = r10 / r2
            goto L_0x017e
        L_0x0160:
            float[] r2 = f9677l
            int r14 = r2.length
            if (r10 >= r14) goto L_0x0168
            r17 = r2[r10]
            goto L_0x017e
        L_0x0168:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r14 = "Unexpected aspect_ratio_idc value: "
            r2.append(r14)
            r2.append(r10)
            java.lang.String r2 = r2.toString()
            java.lang.String r10 = "NalUnitUtil"
            androidx.media3.common.util.Log.n(r10, r2)
        L_0x017e:
            boolean r2 = r0.d()
            if (r2 == 0) goto L_0x0187
            r0.k()
        L_0x0187:
            boolean r2 = r0.d()
            if (r2 == 0) goto L_0x01c7
            r2 = 3
            r0.l(r2)
            boolean r2 = r0.d()
            if (r2 == 0) goto L_0x019a
            r16 = 1
            goto L_0x019c
        L_0x019a:
            r16 = 2
        L_0x019c:
            boolean r2 = r0.d()
            if (r2 == 0) goto L_0x01bf
            r2 = 8
            int r10 = r0.e(r2)
            int r14 = r0.e(r2)
            r0.l(r2)
            int r0 = androidx.media3.common.ColorInfo.m(r10)
            int r2 = androidx.media3.common.ColorInfo.n(r14)
            r21 = r0
            r0 = r2
            r20 = r16
            r10 = r17
            goto L_0x01d1
        L_0x01bf:
            r20 = r16
            r10 = r17
            r0 = -1
        L_0x01c4:
            r21 = -1
            goto L_0x01d1
        L_0x01c7:
            r10 = r17
            r0 = -1
        L_0x01ca:
            r20 = -1
            goto L_0x01c4
        L_0x01cd:
            r0 = -1
            r10 = 1065353216(0x3f800000, float:1.0)
            goto L_0x01ca
        L_0x01d1:
            androidx.media3.container.NalUnitUtil$SpsData r22 = new androidx.media3.container.NalUnitUtil$SpsData
            r2 = r22
            r16 = r26
            r14 = r19
            r17 = r1
            r19 = r21
            r21 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r22
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.container.NalUnitUtil.m(byte[], int, int):androidx.media3.container.NalUnitUtil$SpsData");
    }

    private static void n(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = 0;
            while (i3 < 6) {
                int i4 = 1;
                if (!parsableNalUnitBitArray.d()) {
                    parsableNalUnitBitArray.h();
                } else {
                    int min = Math.min(64, 1 << ((i2 << 1) + 4));
                    if (i2 > 1) {
                        parsableNalUnitBitArray.g();
                    }
                    for (int i5 = 0; i5 < min; i5++) {
                        parsableNalUnitBitArray.g();
                    }
                }
                if (i2 == 3) {
                    i4 = 3;
                }
                i3 += i4;
            }
        }
    }

    private static void o(ParsableNalUnitBitArray parsableNalUnitBitArray, int i2) {
        int i3 = 8;
        int i4 = 8;
        for (int i5 = 0; i5 < i2; i5++) {
            if (i3 != 0) {
                i3 = ((parsableNalUnitBitArray.g() + i4) + 256) % 256;
            }
            if (i3 != 0) {
                i4 = i3;
            }
        }
    }

    private static void p(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        int h2 = parsableNalUnitBitArray.h();
        int[] iArr = new int[0];
        int[] iArr2 = new int[0];
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < h2; i4++) {
            if (i4 == 0 || !parsableNalUnitBitArray.d()) {
                int h3 = parsableNalUnitBitArray.h();
                int h4 = parsableNalUnitBitArray.h();
                int[] iArr3 = new int[h3];
                int i5 = 0;
                while (i5 < h3) {
                    iArr3[i5] = (i5 > 0 ? iArr3[i5 - 1] : 0) - (parsableNalUnitBitArray.h() + 1);
                    parsableNalUnitBitArray.k();
                    i5++;
                }
                int[] iArr4 = new int[h4];
                int i6 = 0;
                while (i6 < h4) {
                    iArr4[i6] = (i6 > 0 ? iArr4[i6 - 1] : 0) + parsableNalUnitBitArray.h() + 1;
                    parsableNalUnitBitArray.k();
                    i6++;
                }
                int[] iArr5 = iArr3;
                i2 = h3;
                iArr = iArr5;
                int[] iArr6 = iArr4;
                i3 = h4;
                iArr2 = iArr6;
            } else {
                int i7 = i2 + i3;
                int h5 = (1 - ((parsableNalUnitBitArray.d() ? 1 : 0) * true)) * (parsableNalUnitBitArray.h() + 1);
                int i8 = i7 + 1;
                boolean[] zArr = new boolean[i8];
                for (int i9 = 0; i9 <= i7; i9++) {
                    if (!parsableNalUnitBitArray.d()) {
                        zArr[i9] = parsableNalUnitBitArray.d();
                    } else {
                        zArr[i9] = true;
                    }
                }
                int[] iArr7 = new int[i8];
                int[] iArr8 = new int[i8];
                int i10 = 0;
                for (int i11 = i3 - 1; i11 >= 0; i11--) {
                    int i12 = iArr2[i11] + h5;
                    if (i12 < 0 && zArr[i2 + i11]) {
                        iArr7[i10] = i12;
                        i10++;
                    }
                }
                if (h5 < 0 && zArr[i7]) {
                    iArr7[i10] = h5;
                    i10++;
                }
                for (int i13 = 0; i13 < i2; i13++) {
                    int i14 = iArr[i13] + h5;
                    if (i14 < 0 && zArr[i13]) {
                        iArr7[i10] = i14;
                        i10++;
                    }
                }
                int[] copyOf = Arrays.copyOf(iArr7, i10);
                int i15 = 0;
                for (int i16 = i2 - 1; i16 >= 0; i16--) {
                    int i17 = iArr[i16] + h5;
                    if (i17 > 0 && zArr[i16]) {
                        iArr8[i15] = i17;
                        i15++;
                    }
                }
                if (h5 > 0 && zArr[i7]) {
                    iArr8[i15] = h5;
                    i15++;
                }
                for (int i18 = 0; i18 < i3; i18++) {
                    int i19 = iArr2[i18] + h5;
                    if (i19 > 0 && zArr[i2 + i18]) {
                        iArr8[i15] = i19;
                        i15++;
                    }
                }
                iArr2 = Arrays.copyOf(iArr8, i15);
                iArr = copyOf;
                i2 = i10;
                i3 = i15;
            }
        }
    }

    public static int q(byte[] bArr, int i2) {
        int i3;
        synchronized (p) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < i2) {
                try {
                    i4 = d(bArr, i4, i2);
                    if (i4 < i2) {
                        int[] iArr = q;
                        if (iArr.length <= i5) {
                            q = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        q[i5] = i4;
                        i4 += 3;
                        i5++;
                    }
                } finally {
                }
            }
            i3 = i2 - i5;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i5; i8++) {
                int i9 = q[i8] - i7;
                System.arraycopy(bArr, i7, bArr, i6, i9);
                int i10 = i6 + i9;
                int i11 = i10 + 1;
                bArr[i10] = 0;
                i6 = i10 + 2;
                bArr[i11] = 0;
                i7 += i9 + 3;
            }
            System.arraycopy(bArr, i7, bArr, i6, i3 - i6);
        }
        return i3;
    }
}
