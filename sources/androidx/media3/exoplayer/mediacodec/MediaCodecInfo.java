package androidx.media3.exoplayer.mediacodec;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;

@UnstableApi
public final class MediaCodecInfo {

    /* renamed from: l  reason: collision with root package name */
    public static final String f11691l = "MediaCodecInfo";

    /* renamed from: m  reason: collision with root package name */
    public static final int f11692m = -1;

    /* renamed from: a  reason: collision with root package name */
    public final String f11693a;

    /* renamed from: b  reason: collision with root package name */
    public final String f11694b;

    /* renamed from: c  reason: collision with root package name */
    public final String f11695c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final MediaCodecInfo.CodecCapabilities f11696d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f11697e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f11698f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f11699g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f11700h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f11701i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f11702j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f11703k;

    @VisibleForTesting
    MediaCodecInfo(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.f11693a = (String) Assertions.g(str);
        this.f11694b = str2;
        this.f11695c = str3;
        this.f11696d = codecCapabilities;
        this.f11700h = z;
        this.f11701i = z2;
        this.f11702j = z3;
        this.f11697e = z4;
        this.f11698f = z5;
        this.f11699g = z6;
        this.f11703k = MimeTypes.t(str2);
    }

    private void A(String str) {
        Log.b(f11691l, "NoSupport [" + str + "] [" + this.f11693a + ", " + this.f11694b + "] [" + Util.f9650e + "]");
    }

    private static boolean B(String str) {
        return MimeTypes.a0.equals(str);
    }

    private static boolean C(String str) {
        return Util.f9649d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    private static boolean D(String str) {
        if (Util.f9646a <= 22) {
            String str2 = Util.f9649d;
            if (("ODROID-XU3".equals(str2) || "Nexus 10".equals(str2)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str))) {
                return true;
            }
        }
        return false;
    }

    private static boolean E(String str, int i2) {
        if (MimeTypes.f9236k.equals(str) && 2 == i2) {
            String str2 = Util.f9647b;
            if ("sailfish".equals(str2) || "marlin".equals(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean F(String str) {
        return !"OMX.MTK.VIDEO.DECODER.HEVC".equals(str) || !"mcv5a".equals(Util.f9647b);
    }

    public static MediaCodecInfo G(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return new MediaCodecInfo(str, str2, str3, codecCapabilities, z, z2, z3, !z4 && codecCapabilities != null && j(codecCapabilities) && !D(str), codecCapabilities != null && w(codecCapabilities), z5 || (codecCapabilities != null && u(codecCapabilities)));
    }

    private static int a(String str, String str2, int i2) {
        if (i2 > 1 || ((Util.f9646a >= 26 && i2 > 0) || MimeTypes.I.equals(str2) || MimeTypes.c0.equals(str2) || MimeTypes.d0.equals(str2) || MimeTypes.F.equals(str2) || MimeTypes.Z.equals(str2) || MimeTypes.a0.equals(str2) || MimeTypes.N.equals(str2) || MimeTypes.e0.equals(str2) || MimeTypes.O.equals(str2) || MimeTypes.P.equals(str2) || MimeTypes.g0.equals(str2))) {
            return i2;
        }
        int i3 = MimeTypes.Q.equals(str2) ? 6 : MimeTypes.R.equals(str2) ? 16 : 30;
        Log.n(f11691l, "AssumedMaxChannelAdjustment: " + str + ", [" + i2 + " to " + i3 + "]");
        return i3;
    }

    @RequiresApi(21)
    private static Point c(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i3) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(Util.q(i2, widthAlignment) * widthAlignment, Util.q(i3, heightAlignment) * heightAlignment);
    }

    @RequiresApi(21)
    private static boolean d(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i3, double d2) {
        Point c2 = c(videoCapabilities, i2, i3);
        int i4 = c2.x;
        int i5 = c2.y;
        return (d2 == -1.0d || d2 < 1.0d) ? videoCapabilities.isSizeSupported(i4, i5) : videoCapabilities.areSizeAndRateSupported(i4, i5, Math.floor(d2));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r3 = r3.getVideoCapabilities();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.media.MediaCodecInfo.CodecProfileLevel[] f(@androidx.annotation.Nullable android.media.MediaCodecInfo.CodecCapabilities r3) {
        /*
            r0 = 1
            r1 = 0
            if (r3 == 0) goto L_0x0019
            android.media.MediaCodecInfo$VideoCapabilities r3 = r3.getVideoCapabilities()
            if (r3 == 0) goto L_0x0019
            android.util.Range r3 = r3.getBitrateRange()
            java.lang.Comparable r3 = r3.getUpper()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            goto L_0x001a
        L_0x0019:
            r3 = 0
        L_0x001a:
            r2 = 180000000(0xaba9500, float:1.7967196E-32)
            if (r3 < r2) goto L_0x0022
            r3 = 1024(0x400, float:1.435E-42)
            goto L_0x0069
        L_0x0022:
            r2 = 120000000(0x7270e00, float:1.2567798E-34)
            if (r3 < r2) goto L_0x002a
            r3 = 512(0x200, float:7.175E-43)
            goto L_0x0069
        L_0x002a:
            r2 = 60000000(0x3938700, float:8.670878E-37)
            if (r3 < r2) goto L_0x0032
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0069
        L_0x0032:
            r2 = 30000000(0x1c9c380, float:7.411627E-38)
            if (r3 < r2) goto L_0x003a
            r3 = 128(0x80, float:1.794E-43)
            goto L_0x0069
        L_0x003a:
            r2 = 18000000(0x112a880, float:2.6936858E-38)
            if (r3 < r2) goto L_0x0042
            r3 = 64
            goto L_0x0069
        L_0x0042:
            r2 = 12000000(0xb71b00, float:1.6815582E-38)
            if (r3 < r2) goto L_0x004a
            r3 = 32
            goto L_0x0069
        L_0x004a:
            r2 = 7200000(0x6ddd00, float:1.0089349E-38)
            if (r3 < r2) goto L_0x0052
            r3 = 16
            goto L_0x0069
        L_0x0052:
            r2 = 3600000(0x36ee80, float:5.044674E-39)
            if (r3 < r2) goto L_0x005a
            r3 = 8
            goto L_0x0069
        L_0x005a:
            r2 = 1800000(0x1b7740, float:2.522337E-39)
            if (r3 < r2) goto L_0x0061
            r3 = 4
            goto L_0x0069
        L_0x0061:
            r2 = 800000(0xc3500, float:1.121039E-39)
            if (r3 < r2) goto L_0x0068
            r3 = 2
            goto L_0x0069
        L_0x0068:
            r3 = 1
        L_0x0069:
            android.media.MediaCodecInfo$CodecProfileLevel r2 = new android.media.MediaCodecInfo$CodecProfileLevel
            r2.<init>()
            r2.profile = r0
            r2.level = r3
            android.media.MediaCodecInfo$CodecProfileLevel[] r3 = new android.media.MediaCodecInfo.CodecProfileLevel[r0]
            r3[r1] = r2
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecInfo.f(android.media.MediaCodecInfo$CodecCapabilities):android.media.MediaCodecInfo$CodecProfileLevel[]");
    }

    @RequiresApi(23)
    private static int h(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.getMaxSupportedInstances();
    }

    private static boolean j(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return Util.f9646a >= 19 && k(codecCapabilities);
    }

    @RequiresApi(19)
    private static boolean k(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private boolean n(Format format, boolean z) {
        Pair<Integer, Integer> s = MediaCodecUtil.s(format);
        if (s == null) {
            return true;
        }
        int intValue = ((Integer) s.first).intValue();
        int intValue2 = ((Integer) s.second).intValue();
        if (MimeTypes.w.equals(format.f3)) {
            if (MimeTypes.f9235j.equals(this.f11694b)) {
                intValue = 8;
            } else if (MimeTypes.f9236k.equals(this.f11694b)) {
                intValue = 2;
            }
            intValue2 = 0;
        }
        if (!this.f11703k && intValue != 42) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] i2 = i();
        if (Util.f9646a <= 23 && MimeTypes.f9238m.equals(this.f11694b) && i2.length == 0) {
            i2 = f(this.f11696d);
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : i2) {
            if (codecProfileLevel.profile == intValue && ((codecProfileLevel.level >= intValue2 || !z) && !E(this.f11694b, intValue))) {
                return true;
            }
        }
        A("codec.profileLevel, " + format.c3 + ", " + this.f11695c);
        return false;
    }

    private boolean r(Format format) {
        return this.f11694b.equals(format.f3) || this.f11694b.equals(MediaCodecUtil.n(format));
    }

    private static boolean u(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return Util.f9646a >= 21 && v(codecCapabilities);
    }

    @RequiresApi(21)
    private static boolean v(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private static boolean w(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return Util.f9646a >= 21 && x(codecCapabilities);
    }

    @RequiresApi(21)
    private static boolean x(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    private void z(String str) {
        Log.b(f11691l, "AssumedSupport [" + str + "] [" + this.f11693a + ", " + this.f11694b + "] [" + Util.f9650e + "]");
    }

    @RequiresApi(21)
    @Nullable
    public Point b(int i2, int i3) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f11696d;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return c(videoCapabilities, i2, i3);
    }

    public DecoderReuseEvaluation e(Format format, Format format2) {
        int i2 = !Util.g(format.f3, format2.f3) ? 8 : 0;
        if (this.f11703k) {
            if (format.n3 != format2.n3) {
                i2 |= 1024;
            }
            if (!this.f11697e && !(format.k3 == format2.k3 && format.l3 == format2.l3)) {
                i2 |= 512;
            }
            if ((!ColorInfo.j(format.r3) || !ColorInfo.j(format2.r3)) && !Util.g(format.r3, format2.r3)) {
                i2 |= 2048;
            }
            if (C(this.f11693a) && !format.i(format2)) {
                i2 |= 2;
            }
            if (i2 == 0) {
                return new DecoderReuseEvaluation(this.f11693a, format, format2, format.i(format2) ? 3 : 2, 0);
            }
        } else {
            if (format.s3 != format2.s3) {
                i2 |= 4096;
            }
            if (format.t3 != format2.t3) {
                i2 |= 8192;
            }
            if (format.u3 != format2.u3) {
                i2 |= 16384;
            }
            if (i2 == 0 && MimeTypes.F.equals(this.f11694b)) {
                Pair<Integer, Integer> s = MediaCodecUtil.s(format);
                Pair<Integer, Integer> s2 = MediaCodecUtil.s(format2);
                if (!(s == null || s2 == null)) {
                    int intValue = ((Integer) s.first).intValue();
                    int intValue2 = ((Integer) s2.first).intValue();
                    if (intValue == 42 && intValue2 == 42) {
                        return new DecoderReuseEvaluation(this.f11693a, format, format2, 3, 0);
                    }
                }
            }
            if (!format.i(format2)) {
                i2 |= 32;
            }
            if (B(this.f11694b)) {
                i2 |= 2;
            }
            if (i2 == 0) {
                return new DecoderReuseEvaluation(this.f11693a, format, format2, 1, 0);
            }
        }
        return new DecoderReuseEvaluation(this.f11693a, format, format2, 0, i2);
    }

    public int g() {
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        if (Util.f9646a < 23 || (codecCapabilities = this.f11696d) == null) {
            return -1;
        }
        return h(codecCapabilities);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.profileLevels;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.media.MediaCodecInfo.CodecProfileLevel[] i() {
        /*
            r1 = this;
            android.media.MediaCodecInfo$CodecCapabilities r0 = r1.f11696d
            if (r0 == 0) goto L_0x0008
            android.media.MediaCodecInfo$CodecProfileLevel[] r0 = r0.profileLevels
            if (r0 != 0) goto L_0x000b
        L_0x0008:
            r0 = 0
            android.media.MediaCodecInfo$CodecProfileLevel[] r0 = new android.media.MediaCodecInfo.CodecProfileLevel[r0]
        L_0x000b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecInfo.i():android.media.MediaCodecInfo$CodecProfileLevel[]");
    }

    @RequiresApi(21)
    public boolean l(int i2) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f11696d;
        if (codecCapabilities == null) {
            str = "channelCount.caps";
        } else {
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                str = "channelCount.aCaps";
            } else if (a(this.f11693a, this.f11694b, audioCapabilities.getMaxInputChannelCount()) >= i2) {
                return true;
            } else {
                str = "channelCount.support, " + i2;
            }
        }
        A(str);
        return false;
    }

    @RequiresApi(21)
    public boolean m(int i2) {
        String str;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f11696d;
        if (codecCapabilities == null) {
            str = "sampleRate.caps";
        } else {
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                str = "sampleRate.aCaps";
            } else if (audioCapabilities.isSampleRateSupported(i2)) {
                return true;
            } else {
                str = "sampleRate.support, " + i2;
            }
        }
        A(str);
        return false;
    }

    public boolean o(Format format) {
        return r(format) && n(format, false);
    }

    public boolean p(Format format) throws MediaCodecUtil.DecoderQueryException {
        int i2;
        boolean z = false;
        if (!r(format) || !n(format, true)) {
            return false;
        }
        if (this.f11703k) {
            int i3 = format.k3;
            if (i3 <= 0 || (i2 = format.l3) <= 0) {
                return true;
            }
            if (Util.f9646a >= 21) {
                return y(i3, i2, (double) format.m3);
            }
            if (i3 * i2 <= MediaCodecUtil.Q()) {
                z = true;
            }
            if (!z) {
                A("legacyFrameSize, " + format.k3 + "x" + format.l3);
            }
            return z;
        }
        if (Util.f9646a >= 21) {
            int i4 = format.t3;
            if (i4 != -1 && !m(i4)) {
                return false;
            }
            int i5 = format.s3;
            return i5 == -1 || l(i5);
        }
    }

    public boolean q() {
        if (Util.f9646a >= 29 && MimeTypes.f9238m.equals(this.f11694b)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : i()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean s(Format format) {
        if (this.f11703k) {
            return this.f11697e;
        }
        Pair<Integer, Integer> s = MediaCodecUtil.s(format);
        return s != null && ((Integer) s.first).intValue() == 42;
    }

    @Deprecated
    public boolean t(Format format, Format format2, boolean z) {
        if (!z && format.r3 != null && format2.r3 == null) {
            format2 = format2.c().N(format.r3).I();
        }
        int i2 = e(format, format2).f10122d;
        return i2 == 2 || i2 == 3;
    }

    public String toString() {
        return this.f11693a;
    }

    @RequiresApi(21)
    public boolean y(int i2, int i3, double d2) {
        StringBuilder sb;
        String str;
        String sb2;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f11696d;
        if (codecCapabilities == null) {
            sb2 = "sizeAndRate.caps";
        } else {
            MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
            if (videoCapabilities == null) {
                sb2 = "sizeAndRate.vCaps";
            } else {
                if (Util.f9646a >= 29) {
                    int c2 = MediaCodecPerformancePointCoverageProvider.c(videoCapabilities, i2, i3, d2);
                    if (c2 == 2) {
                        return true;
                    }
                    if (c2 == 1) {
                        sb = new StringBuilder();
                        str = "sizeAndRate.cover, ";
                        sb.append(str);
                        sb.append(i2);
                        sb.append("x");
                        sb.append(i3);
                        sb.append("@");
                        sb.append(d2);
                        sb2 = sb.toString();
                    }
                }
                if (!d(videoCapabilities, i2, i3, d2)) {
                    if (i2 >= i3 || !F(this.f11693a) || !d(videoCapabilities, i3, i2, d2)) {
                        sb = new StringBuilder();
                        str = "sizeAndRate.support, ";
                        sb.append(str);
                        sb.append(i2);
                        sb.append("x");
                        sb.append(i3);
                        sb.append("@");
                        sb.append(d2);
                        sb2 = sb.toString();
                    } else {
                        z("sizeAndRate.rotated, " + i2 + "x" + i3 + "@" + d2);
                    }
                }
                return true;
            }
        }
        A(sb2);
        return false;
    }
}
