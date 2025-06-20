package androidx.media3.extractor;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
public final class AacUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12871a = "AacUtil";

    /* renamed from: b  reason: collision with root package name */
    public static final int f12872b = 1024;

    /* renamed from: c  reason: collision with root package name */
    public static final int f12873c = 1024;

    /* renamed from: d  reason: collision with root package name */
    public static final int f12874d = 2048;

    /* renamed from: e  reason: collision with root package name */
    public static final int f12875e = 512;

    /* renamed from: f  reason: collision with root package name */
    public static final int f12876f = 100000;

    /* renamed from: g  reason: collision with root package name */
    public static final int f12877g = 16000;

    /* renamed from: h  reason: collision with root package name */
    public static final int f12878h = 7000;

    /* renamed from: i  reason: collision with root package name */
    public static final int f12879i = 256000;

    /* renamed from: j  reason: collision with root package name */
    public static final int f12880j = 8000;

    /* renamed from: k  reason: collision with root package name */
    private static final int f12881k = 15;

    /* renamed from: l  reason: collision with root package name */
    private static final int[] f12882l = {96000, 88200, 64000, OpusUtil.f13107a, 44100, 32000, 24000, 22050, f12877g, 12000, 11025, 8000, 7350};

    /* renamed from: m  reason: collision with root package name */
    private static final int f12883m = -1;

    /* renamed from: n  reason: collision with root package name */
    private static final int[] f12884n = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};
    private static final String o = "mp4a.40.";
    public static final int p = 2;
    public static final int q = 5;
    public static final int r = 22;
    public static final int s = 23;
    public static final int t = 29;
    private static final int u = 31;
    public static final int v = 42;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AacAudioObjectType {
    }

    public static final class Config {

        /* renamed from: a  reason: collision with root package name */
        public final int f12885a;

        /* renamed from: b  reason: collision with root package name */
        public final int f12886b;

        /* renamed from: c  reason: collision with root package name */
        public final String f12887c;

        private Config(int i2, int i3, String str) {
            this.f12885a = i2;
            this.f12886b = i3;
            this.f12887c = str;
        }
    }

    private AacUtil() {
    }

    public static byte[] a(int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = -1;
        while (true) {
            int[] iArr = f12882l;
            if (i5 >= iArr.length) {
                break;
            }
            if (i2 == iArr[i5]) {
                i6 = i5;
            }
            i5++;
        }
        int i7 = -1;
        while (true) {
            int[] iArr2 = f12884n;
            if (i4 >= iArr2.length) {
                break;
            }
            if (i3 == iArr2[i4]) {
                i7 = i4;
            }
            i4++;
        }
        if (i2 != -1 && i7 != -1) {
            return b(2, i6, i7);
        }
        throw new IllegalArgumentException("Invalid sample rate or number of channels: " + i2 + ", " + i3);
    }

    public static byte[] b(int i2, int i3, int i4) {
        return new byte[]{(byte) (((i2 << 3) & 248) | ((i3 >> 1) & 7)), (byte) (((i3 << 7) & 128) | ((i4 << 3) & 120))};
    }

    private static int c(ParsableBitArray parsableBitArray) {
        int h2 = parsableBitArray.h(5);
        return h2 == 31 ? parsableBitArray.h(6) + 32 : h2;
    }

    private static int d(ParsableBitArray parsableBitArray) throws ParserException {
        int h2 = parsableBitArray.h(4);
        if (h2 == 15) {
            if (parsableBitArray.b() >= 24) {
                return parsableBitArray.h(24);
            }
            throw ParserException.a("AAC header insufficient data", (Throwable) null);
        } else if (h2 < 13) {
            return f12882l[h2];
        } else {
            throw ParserException.a("AAC header wrong Sampling Frequency Index", (Throwable) null);
        }
    }

    public static Config e(ParsableBitArray parsableBitArray, boolean z) throws ParserException {
        int c2 = c(parsableBitArray);
        int d2 = d(parsableBitArray);
        int h2 = parsableBitArray.h(4);
        String str = o + c2;
        if (c2 == 5 || c2 == 29) {
            d2 = d(parsableBitArray);
            c2 = c(parsableBitArray);
            if (c2 == 22) {
                h2 = parsableBitArray.h(4);
            }
        }
        if (z) {
            if (!(c2 == 1 || c2 == 2 || c2 == 3 || c2 == 4 || c2 == 6 || c2 == 7 || c2 == 17)) {
                switch (c2) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw ParserException.e("Unsupported audio object type: " + c2);
                }
            }
            g(parsableBitArray, c2, h2);
            switch (c2) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int h3 = parsableBitArray.h(2);
                    if (h3 == 2 || h3 == 3) {
                        throw ParserException.e("Unsupported epConfig: " + h3);
                    }
            }
        }
        int i2 = f12884n[h2];
        if (i2 != -1) {
            return new Config(d2, i2, str);
        }
        throw ParserException.a((String) null, (Throwable) null);
    }

    public static Config f(byte[] bArr) throws ParserException {
        return e(new ParsableBitArray(bArr), false);
    }

    private static void g(ParsableBitArray parsableBitArray, int i2, int i3) {
        if (parsableBitArray.g()) {
            Log.n(f12871a, "Unexpected frameLengthFlag = 1");
        }
        if (parsableBitArray.g()) {
            parsableBitArray.s(14);
        }
        boolean g2 = parsableBitArray.g();
        if (i3 != 0) {
            if (i2 == 6 || i2 == 20) {
                parsableBitArray.s(3);
            }
            if (g2) {
                if (i2 == 22) {
                    parsableBitArray.s(16);
                }
                if (i2 == 17 || i2 == 19 || i2 == 20 || i2 == 23) {
                    parsableBitArray.s(3);
                }
                parsableBitArray.s(1);
                return;
            }
            return;
        }
        throw new UnsupportedOperationException();
    }
}
