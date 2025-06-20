package androidx.media3.extractor;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.extractor.ts.PsExtractor;
import com.google.android.material.internal.ViewUtils;
import com.itextpdf.text.DocWriter;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

@UnstableApi
public final class DtsUtil {
    private static final byte A = 113;
    private static final byte B = -24;
    private static final int[] C = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] D = {-1, 8000, AacUtil.f12877g, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, OpusUtil.f13107a, -1, -1};
    private static final int[] E = {64, 112, 128, PsExtractor.x, 224, 256, RendererCapabilities.M, 448, 512, 640, ViewUtils.f21582a, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};
    private static final int[] F = {8000, AacUtil.f12877g, 32000, 64000, 128000, 22050, 44100, 88200, 176400, 352800, 12000, 24000, OpusUtil.f13107a, 96000, f13020f, 384000};
    private static final int[] G = {5, 8, 10, 12};
    private static final int[] H = {6, 9, 12, 15};
    private static final int[] I = {2, 4, 6, 8};
    private static final int[] J = {9, 11, 13, 16};
    private static final int[] K = {5, 8, 10, 12};

    /* renamed from: a  reason: collision with root package name */
    public static final int f13015a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f13016b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f13017c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f13018d = 3;

    /* renamed from: e  reason: collision with root package name */
    public static final int f13019e = 4;

    /* renamed from: f  reason: collision with root package name */
    public static final int f13020f = 192000;

    /* renamed from: g  reason: collision with root package name */
    public static final int f13021g = 2250000;

    /* renamed from: h  reason: collision with root package name */
    public static final int f13022h = 768000;

    /* renamed from: i  reason: collision with root package name */
    private static final int f13023i = 2147385345;

    /* renamed from: j  reason: collision with root package name */
    private static final int f13024j = 536864768;

    /* renamed from: k  reason: collision with root package name */
    private static final int f13025k = -25230976;

    /* renamed from: l  reason: collision with root package name */
    private static final int f13026l = -14745368;

    /* renamed from: m  reason: collision with root package name */
    private static final int f13027m = 1683496997;

    /* renamed from: n  reason: collision with root package name */
    private static final int f13028n = 622876772;
    private static final int o = 1078008818;
    private static final int p = -233094848;
    private static final int q = 1908687592;
    private static final int r = -398277519;
    private static final byte s = Byte.MAX_VALUE;
    private static final byte t = 31;
    private static final byte u = -2;
    private static final byte v = -1;
    private static final byte w = 100;
    private static final byte x = 37;
    private static final byte y = 64;
    private static final byte z = -14;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DtsAudioMimeType {
    }

    public static final class DtsHeader {

        /* renamed from: a  reason: collision with root package name */
        public final String f13029a;

        /* renamed from: b  reason: collision with root package name */
        public final int f13030b;

        /* renamed from: c  reason: collision with root package name */
        public final int f13031c;

        /* renamed from: d  reason: collision with root package name */
        public final int f13032d;

        /* renamed from: e  reason: collision with root package name */
        public final long f13033e;

        /* renamed from: f  reason: collision with root package name */
        public final int f13034f;

        private DtsHeader(String str, int i2, int i3, int i4, long j2, int i5) {
            this.f13029a = str;
            this.f13031c = i2;
            this.f13030b = i3;
            this.f13032d = i4;
            this.f13033e = j2;
            this.f13034f = i5;
        }
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FrameType {
    }

    private DtsUtil() {
    }

    private static void a(byte[] bArr, int i2) throws ParserException {
        int i3 = i2 - 2;
        if (((bArr[i2 - 1] & 255) | ((bArr[i3] << 8) & 65535)) != Util.C(bArr, 0, i3, 65535)) {
            throw ParserException.a("CRC check failed", (Throwable) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int b(byte[] r7) {
        /*
            r0 = 0
            byte r1 = r7[r0]
            r2 = -2
            r3 = 7
            r4 = 6
            r5 = 1
            r6 = 4
            if (r1 == r2) goto L_0x004f
            r2 = -1
            if (r1 == r2) goto L_0x003e
            r2 = 31
            if (r1 == r2) goto L_0x0026
            r1 = 5
            byte r1 = r7[r1]
            r1 = r1 & 3
            int r1 = r1 << 12
            byte r2 = r7[r4]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            byte r7 = r7[r3]
        L_0x0020:
            r7 = r7 & 240(0xf0, float:3.36E-43)
            int r7 = r7 >> r6
            r7 = r7 | r1
            int r7 = r7 + r5
            goto L_0x005e
        L_0x0026:
            byte r0 = r7[r4]
            r0 = r0 & 3
            int r0 = r0 << 12
            byte r1 = r7[r3]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 8
            byte r7 = r7[r1]
        L_0x0036:
            r7 = r7 & 60
            int r7 = r7 >> 2
            r7 = r7 | r0
            int r7 = r7 + r5
            r0 = 1
            goto L_0x005e
        L_0x003e:
            byte r0 = r7[r3]
            r0 = r0 & 3
            int r0 = r0 << 12
            byte r1 = r7[r4]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 9
            byte r7 = r7[r1]
            goto L_0x0036
        L_0x004f:
            byte r1 = r7[r6]
            r1 = r1 & 3
            int r1 = r1 << 12
            byte r2 = r7[r3]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            byte r7 = r7[r4]
            goto L_0x0020
        L_0x005e:
            if (r0 == 0) goto L_0x0064
            int r7 = r7 * 16
            int r7 = r7 / 14
        L_0x0064:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.DtsUtil.b(byte[]):int");
    }

    public static int c(int i2) {
        if (i2 == f13023i || i2 == f13025k || i2 == f13024j || i2 == f13026l) {
            return 1;
        }
        if (i2 == f13027m || i2 == f13028n) {
            return 2;
        }
        if (i2 == o || i2 == p) {
            return 3;
        }
        return (i2 == q || i2 == r) ? 4 : 0;
    }

    private static ParsableBitArray d(byte[] bArr) {
        byte b2 = bArr[0];
        if (b2 == Byte.MAX_VALUE || b2 == 100 || b2 == 64 || b2 == 113) {
            return new ParsableBitArray(bArr);
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        if (e(copyOf)) {
            for (int i2 = 0; i2 < copyOf.length - 1; i2 += 2) {
                byte b3 = copyOf[i2];
                int i3 = i2 + 1;
                copyOf[i2] = copyOf[i3];
                copyOf[i3] = b3;
            }
        }
        ParsableBitArray parsableBitArray = new ParsableBitArray(copyOf);
        if (copyOf[0] == 31) {
            ParsableBitArray parsableBitArray2 = new ParsableBitArray(copyOf);
            while (parsableBitArray2.b() >= 16) {
                parsableBitArray2.s(2);
                parsableBitArray.f(parsableBitArray2.h(14), 14);
            }
        }
        parsableBitArray.o(copyOf);
        return parsableBitArray;
    }

    private static boolean e(byte[] bArr) {
        byte b2 = bArr[0];
        return b2 == -2 || b2 == -1 || b2 == 37 || b2 == -14 || b2 == -24;
    }

    public static int f(ByteBuffer byteBuffer) {
        int i2;
        int i3;
        byte b2;
        int i4;
        int i5;
        if (byteBuffer.getInt(0) == p || byteBuffer.getInt(0) == r) {
            return 1024;
        }
        if (byteBuffer.getInt(0) == f13028n) {
            return 4096;
        }
        int position = byteBuffer.position();
        byte b3 = byteBuffer.get(position);
        if (b3 != -2) {
            if (b3 == -1) {
                i4 = (byteBuffer.get(position + 4) & 7) << 4;
                i5 = position + 7;
            } else if (b3 != 31) {
                i2 = (byteBuffer.get(position + 4) & 1) << 6;
                i3 = position + 5;
            } else {
                i4 = (byteBuffer.get(position + 5) & 7) << 4;
                i5 = position + 6;
            }
            b2 = byteBuffer.get(i5) & DocWriter.b3;
            return (((b2 >> 2) | i4) + 1) * 32;
        }
        i2 = (byteBuffer.get(position + 5) & 1) << 6;
        i3 = position + 4;
        b2 = byteBuffer.get(i3) & 252;
        return (((b2 >> 2) | i4) + 1) * 32;
    }

    public static int g(byte[] bArr) {
        int i2;
        byte b2;
        byte b3;
        int i3;
        byte b4;
        byte b5 = bArr[0];
        if (b5 != -2) {
            if (b5 == -1) {
                i3 = (bArr[4] & 7) << 4;
                b4 = bArr[7];
            } else if (b5 != 31) {
                i2 = (bArr[4] & 1) << 6;
                b2 = bArr[5];
            } else {
                i3 = (bArr[5] & 7) << 4;
                b4 = bArr[6];
            }
            b3 = b4 & DocWriter.b3;
            return (((b3 >> 2) | i3) + 1) * 32;
        }
        i2 = (bArr[5] & 1) << 6;
        b2 = bArr[4];
        b3 = b2 & 252;
        return (((b3 >> 2) | i3) + 1) * 32;
    }

    public static Format h(byte[] bArr, @Nullable String str, @Nullable String str2, int i2, @Nullable DrmInitData drmInitData) {
        ParsableBitArray d2 = d(bArr);
        d2.s(60);
        int i3 = C[d2.h(6)];
        int i4 = D[d2.h(4)];
        int h2 = d2.h(5);
        int[] iArr = E;
        int i5 = h2 >= iArr.length ? -1 : (iArr[h2] * 1000) / 2;
        d2.s(10);
        return new Format.Builder().X(str).k0(MimeTypes.V).K(i5).L(i3 + (d2.h(2) > 0 ? 1 : 0)).l0(i4).R(drmInitData).b0(str2).i0(i2).I();
    }

    public static DtsHeader i(byte[] bArr) throws ParserException {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        long j2;
        int i7;
        ParsableBitArray d2 = d(bArr);
        d2.s(40);
        int h2 = d2.h(2);
        if (!d2.g()) {
            i3 = 16;
            i2 = 8;
        } else {
            i3 = 20;
            i2 = 12;
        }
        d2.s(i2);
        int h3 = d2.h(i3) + 1;
        boolean g2 = d2.g();
        int i8 = 0;
        if (g2) {
            i4 = d2.h(2);
            int h4 = (d2.h(3) + 1) * 512;
            if (d2.g()) {
                d2.s(36);
            }
            int h5 = d2.h(3) + 1;
            int h6 = d2.h(3) + 1;
            if (h5 == 1 && h6 == 1) {
                int i9 = h2 + 1;
                int h7 = d2.h(i9);
                for (int i10 = 0; i10 < i9; i10++) {
                    if (((h7 >> i10) & 1) == 1) {
                        d2.s(8);
                    }
                }
                if (d2.g()) {
                    d2.s(2);
                    int h8 = (d2.h(2) + 1) << 2;
                    int h9 = d2.h(2) + 1;
                    while (i8 < h9) {
                        d2.s(h8);
                        i8++;
                    }
                }
                i8 = h4;
            } else {
                throw ParserException.e("Multiple audio presentations or assets not supported");
            }
        } else {
            i4 = -1;
        }
        d2.s(i3);
        d2.s(12);
        if (g2) {
            if (d2.g()) {
                d2.s(4);
            }
            if (d2.g()) {
                d2.s(24);
            }
            if (d2.g()) {
                d2.t(d2.h(10) + 1);
            }
            d2.s(5);
            int i11 = F[d2.h(4)];
            i6 = d2.h(8) + 1;
            i5 = i11;
        } else {
            i6 = -1;
            i5 = C.f9088f;
        }
        if (g2) {
            if (i4 == 0) {
                i7 = 32000;
            } else if (i4 == 1) {
                i7 = 44100;
            } else if (i4 == 2) {
                i7 = OpusUtil.f13107a;
            } else {
                throw ParserException.a("Unsupported reference clock code in DTS HD header: " + i4, (Throwable) null);
            }
            j2 = Util.c2((long) i8, 1000000, (long) i7);
        } else {
            j2 = C.f9084b;
        }
        return new DtsHeader(MimeTypes.X, i6, i5, h3, j2, 0);
    }

    public static int j(byte[] bArr) {
        ParsableBitArray d2 = d(bArr);
        d2.s(42);
        return d2.h(d2.g() ? 12 : 8) + 1;
    }

    public static DtsHeader k(byte[] bArr, AtomicInteger atomicInteger) throws ParserException {
        long j2;
        int i2;
        int i3;
        int i4;
        ParsableBitArray d2 = d(bArr);
        int i5 = d2.h(32) == o ? 1 : 0;
        int m2 = m(d2, G, true) + 1;
        if (i5 == 0) {
            j2 = -9223372036854775807L;
            i2 = C.f9088f;
        } else if (d2.g()) {
            a(bArr, m2);
            int h2 = d2.h(2);
            if (h2 == 0) {
                i3 = 512;
            } else if (h2 == 1) {
                i3 = 480;
            } else if (h2 == 2) {
                i3 = RendererCapabilities.M;
            } else {
                throw ParserException.a("Unsupported base duration index in DTS UHD header: " + h2, (Throwable) null);
            }
            int h3 = i3 * (d2.h(3) + 1);
            int h4 = d2.h(2);
            if (h4 == 0) {
                i4 = 32000;
            } else if (h4 == 1) {
                i4 = 44100;
            } else if (h4 == 2) {
                i4 = OpusUtil.f13107a;
            } else {
                throw ParserException.a("Unsupported clock rate index in DTS UHD header: " + h4, (Throwable) null);
            }
            if (d2.g()) {
                d2.s(36);
            }
            i2 = (1 << d2.h(2)) * i4;
            j2 = Util.c2((long) h3, 1000000, (long) i4);
        } else {
            throw ParserException.e("Only supports full channel mask-based audio presentation");
        }
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 += m(d2, H, true);
        }
        for (int i8 = 0; i8 < 1; i8++) {
            if (i5 != 0) {
                atomicInteger.set(m(d2, I, true));
            } else {
                AtomicInteger atomicInteger2 = atomicInteger;
            }
            i6 += atomicInteger.get() != 0 ? m(d2, J, true) : 0;
        }
        return new DtsHeader(MimeTypes.Y, 2, i2, m2 + i6, j2, 0);
    }

    public static int l(byte[] bArr) {
        ParsableBitArray d2 = d(bArr);
        d2.s(32);
        return m(d2, K, true) + 1;
    }

    private static int m(ParsableBitArray parsableBitArray, int[] iArr, boolean z2) {
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 3 && parsableBitArray.g(); i4++) {
            i3++;
        }
        if (z2) {
            int i5 = 0;
            while (i2 < i3) {
                i5 += 1 << iArr[i2];
                i2++;
            }
            i2 = i5;
        }
        return i2 + parsableBitArray.h(iArr[i3]);
    }
}
