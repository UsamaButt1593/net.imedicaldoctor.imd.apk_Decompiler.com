package androidx.media3.extractor;

import androidx.annotation.Nullable;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public final class MpegAudioUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final int f13087a = 4096;

    /* renamed from: b  reason: collision with root package name */
    public static final int f13088b = 40000;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f13089c = {MimeTypes.J, MimeTypes.K, MimeTypes.I};
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f13090d = {44100, OpusUtil.f13107a, 32000};
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f13091e = {32000, 64000, 96000, 128000, 160000, DtsUtil.f13020f, 224000, AacUtil.f12879i, 288000, 320000, 352000, 384000, 416000, 448000};
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f13092f = {32000, OpusUtil.f13107a, 56000, 64000, Ac3Util.f12888a, 96000, 112000, 128000, 144000, 160000, 176000, DtsUtil.f13020f, 224000, AacUtil.f12879i};
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final int[] f13093g = {32000, OpusUtil.f13107a, 56000, 64000, Ac3Util.f12888a, 96000, 112000, 128000, 160000, DtsUtil.f13020f, 224000, AacUtil.f12879i, 320000, 384000};
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final int[] f13094h = {32000, f13088b, OpusUtil.f13107a, 56000, 64000, Ac3Util.f12888a, 96000, 112000, 128000, 160000, DtsUtil.f13020f, 224000, AacUtil.f12879i, 320000};
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final int[] f13095i = {8000, AacUtil.f12877g, 24000, 32000, f13088b, OpusUtil.f13107a, 56000, 64000, Ac3Util.f12888a, 96000, 112000, 128000, 144000, 160000};

    /* renamed from: j  reason: collision with root package name */
    private static final int f13096j = 384;

    /* renamed from: k  reason: collision with root package name */
    private static final int f13097k = 1152;

    /* renamed from: l  reason: collision with root package name */
    private static final int f13098l = 1152;

    /* renamed from: m  reason: collision with root package name */
    private static final int f13099m = 576;

    public static final class Header {

        /* renamed from: a  reason: collision with root package name */
        public int f13100a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public String f13101b;

        /* renamed from: c  reason: collision with root package name */
        public int f13102c;

        /* renamed from: d  reason: collision with root package name */
        public int f13103d;

        /* renamed from: e  reason: collision with root package name */
        public int f13104e;

        /* renamed from: f  reason: collision with root package name */
        public int f13105f;

        /* renamed from: g  reason: collision with root package name */
        public int f13106g;

        /* JADX WARNING: Removed duplicated region for block: B:23:0x0052  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00a8  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(int r9) {
            /*
                r8 = this;
                boolean r0 = androidx.media3.extractor.MpegAudioUtil.l(r9)
                r1 = 0
                if (r0 != 0) goto L_0x0008
                return r1
            L_0x0008:
                int r0 = r9 >>> 19
                r2 = 3
                r0 = r0 & r2
                r3 = 1
                if (r0 != r3) goto L_0x0010
                return r1
            L_0x0010:
                int r4 = r9 >>> 17
                r4 = r4 & r2
                if (r4 != 0) goto L_0x0016
                return r1
            L_0x0016:
                int r5 = r9 >>> 12
                r6 = 15
                r5 = r5 & r6
                if (r5 == 0) goto L_0x00ac
                if (r5 != r6) goto L_0x0021
                goto L_0x00ac
            L_0x0021:
                int r6 = r9 >>> 10
                r6 = r6 & r2
                if (r6 != r2) goto L_0x0027
                return r1
            L_0x0027:
                r8.f13100a = r0
                java.lang.String[] r1 = androidx.media3.extractor.MpegAudioUtil.f13089c
                int r7 = 3 - r4
                r1 = r1[r7]
                r8.f13101b = r1
                int[] r1 = androidx.media3.extractor.MpegAudioUtil.f13090d
                r1 = r1[r6]
                r8.f13103d = r1
                r6 = 2
                if (r0 != r6) goto L_0x0042
                int r1 = r1 / r6
            L_0x003f:
                r8.f13103d = r1
                goto L_0x0047
            L_0x0042:
                if (r0 != 0) goto L_0x0047
                int r1 = r1 / 4
                goto L_0x003f
            L_0x0047:
                int r1 = r9 >>> 9
                r1 = r1 & r3
                int r7 = androidx.media3.extractor.MpegAudioUtil.k(r0, r4)
                r8.f13106g = r7
                if (r4 != r2) goto L_0x0070
                if (r0 != r2) goto L_0x005c
                int[] r0 = androidx.media3.extractor.MpegAudioUtil.f13091e
                int r5 = r5 - r3
                r0 = r0[r5]
                goto L_0x0063
            L_0x005c:
                int[] r0 = androidx.media3.extractor.MpegAudioUtil.f13092f
                int r5 = r5 - r3
                r0 = r0[r5]
            L_0x0063:
                r8.f13105f = r0
                int r0 = r0 * 12
                int r4 = r8.f13103d
                int r0 = r0 / r4
                int r0 = r0 + r1
                int r0 = r0 * 4
            L_0x006d:
                r8.f13102c = r0
                goto L_0x00a3
            L_0x0070:
                r7 = 144(0x90, float:2.02E-43)
                if (r0 != r2) goto L_0x008e
                if (r4 != r6) goto L_0x007e
                int[] r0 = androidx.media3.extractor.MpegAudioUtil.f13093g
                int r5 = r5 - r3
                r0 = r0[r5]
                goto L_0x0085
            L_0x007e:
                int[] r0 = androidx.media3.extractor.MpegAudioUtil.f13094h
                int r5 = r5 - r3
                r0 = r0[r5]
            L_0x0085:
                r8.f13105f = r0
                int r0 = r0 * 144
                int r4 = r8.f13103d
                int r0 = r0 / r4
                int r0 = r0 + r1
                goto L_0x006d
            L_0x008e:
                int[] r0 = androidx.media3.extractor.MpegAudioUtil.f13095i
                int r5 = r5 - r3
                r0 = r0[r5]
                r8.f13105f = r0
                if (r4 != r3) goto L_0x009b
                r7 = 72
            L_0x009b:
                int r7 = r7 * r0
                int r0 = r8.f13103d
                int r7 = r7 / r0
                int r7 = r7 + r1
                r8.f13102c = r7
            L_0x00a3:
                int r9 = r9 >> 6
                r9 = r9 & r2
                if (r9 != r2) goto L_0x00a9
                r6 = 1
            L_0x00a9:
                r8.f13104e = r6
                return r3
            L_0x00ac:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.MpegAudioUtil.Header.a(int):boolean");
        }
    }

    private MpegAudioUtil() {
    }

    public static int j(int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (!l(i2) || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0 || (i5 = (i2 >>> 12) & 15) == 0 || i5 == 15 || (i6 = (i2 >>> 10) & 3) == 3) {
            return -1;
        }
        int i7 = f13090d[i6];
        if (i3 == 2) {
            i7 /= 2;
        } else if (i3 == 0) {
            i7 /= 4;
        }
        int i8 = (i2 >>> 9) & 1;
        if (i4 == 3) {
            return ((((i3 == 3 ? f13091e[i5 - 1] : f13092f[i5 - 1]) * 12) / i7) + i8) * 4;
        }
        int i9 = i3 == 3 ? i4 == 2 ? f13093g[i5 - 1] : f13094h[i5 - 1] : f13095i[i5 - 1];
        int i10 = 144;
        if (i3 == 3) {
            return ((i9 * 144) / i7) + i8;
        }
        if (i4 == 1) {
            i10 = 72;
        }
        return ((i10 * i9) / i7) + i8;
    }

    /* access modifiers changed from: private */
    public static int k(int i2, int i3) {
        if (i3 != 1) {
            if (i3 == 2) {
                return 1152;
            }
            if (i3 == 3) {
                return 384;
            }
            throw new IllegalArgumentException();
        } else if (i2 == 3) {
            return 1152;
        } else {
            return f13099m;
        }
    }

    /* access modifiers changed from: private */
    public static boolean l(int i2) {
        return (i2 & -2097152) == -2097152;
    }

    public static int m(int i2) {
        int i3;
        int i4;
        if (!l(i2) || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0) {
            return -1;
        }
        int i5 = (i2 >>> 12) & 15;
        int i6 = (i2 >>> 10) & 3;
        if (i5 == 0 || i5 == 15 || i6 == 3) {
            return -1;
        }
        return k(i3, i4);
    }
}
