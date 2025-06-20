package androidx.media3.exoplayer.mediacodec;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
@SuppressLint({"InlinedApi"})
public final class MediaCodecUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11714a = "MediaCodecUtil";

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f11715b = Pattern.compile("^\\D?(\\d+)$");
    @GuardedBy("MediaCodecUtil.class")

    /* renamed from: c  reason: collision with root package name */
    private static final HashMap<CodecKey, List<MediaCodecInfo>> f11716c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private static final String f11717d = "avc1";

    /* renamed from: e  reason: collision with root package name */
    private static final String f11718e = "avc2";

    /* renamed from: f  reason: collision with root package name */
    private static final String f11719f = "vp09";

    /* renamed from: g  reason: collision with root package name */
    private static final String f11720g = "hev1";

    /* renamed from: h  reason: collision with root package name */
    private static final String f11721h = "hvc1";

    /* renamed from: i  reason: collision with root package name */
    private static final String f11722i = "av01";

    /* renamed from: j  reason: collision with root package name */
    private static final String f11723j = "mp4a";

    /* renamed from: k  reason: collision with root package name */
    private static int f11724k = -1;

    private static final class CodecKey {

        /* renamed from: a  reason: collision with root package name */
        public final String f11725a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f11726b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f11727c;

        public CodecKey(String str, boolean z, boolean z2) {
            this.f11725a = str;
            this.f11726b = z;
            this.f11727c = z2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != CodecKey.class) {
                return false;
            }
            CodecKey codecKey = (CodecKey) obj;
            return TextUtils.equals(this.f11725a, codecKey.f11725a) && this.f11726b == codecKey.f11726b && this.f11727c == codecKey.f11727c;
        }

        public int hashCode() {
            int i2 = 1237;
            int hashCode = (((this.f11725a.hashCode() + 31) * 31) + (this.f11726b ? 1231 : 1237)) * 31;
            if (this.f11727c) {
                i2 = 1231;
            }
            return hashCode + i2;
        }
    }

    public static class DecoderQueryException extends Exception {
        private DecoderQueryException(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    private interface MediaCodecListCompat {
        MediaCodecInfo a(int i2);

        boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        int d();

        boolean e();
    }

    private static final class MediaCodecListCompatV16 implements MediaCodecListCompat {
        private MediaCodecListCompatV16() {
        }

        public MediaCodecInfo a(int i2) {
            return MediaCodecList.getCodecInfoAt(i2);
        }

        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && MimeTypes.f9235j.equals(str2);
        }

        public boolean c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        public int d() {
            return MediaCodecList.getCodecCount();
        }

        public boolean e() {
            return false;
        }
    }

    @RequiresApi(21)
    private static final class MediaCodecListCompatV21 implements MediaCodecListCompat {

        /* renamed from: a  reason: collision with root package name */
        private final int f11728a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private MediaCodecInfo[] f11729b;

        public MediaCodecListCompatV21(boolean z, boolean z2) {
            this.f11728a = (z || z2) ? 1 : 0;
        }

        @EnsuresNonNull({"mediaCodecInfos"})
        private void f() {
            if (this.f11729b == null) {
                this.f11729b = new MediaCodecList(this.f11728a).getCodecInfos();
            }
        }

        public MediaCodecInfo a(int i2) {
            f();
            return this.f11729b[i2];
        }

        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        public boolean c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        public int d() {
            f();
            return this.f11729b.length;
        }

        public boolean e() {
            return true;
        }
    }

    private interface ScoreProvider<T> {
        int a(T t);
    }

    private MediaCodecUtil() {
    }

    @Nullable
    private static Pair<Integer, Integer> A(String str, String[] strArr, @Nullable ColorInfo colorInfo) {
        String str2;
        StringBuilder sb;
        StringBuilder sb2;
        if (strArr.length < 4) {
            sb = new StringBuilder();
        } else {
            int i2 = 1;
            Matcher matcher = f11715b.matcher(strArr[1]);
            if (!matcher.matches()) {
                sb = new StringBuilder();
            } else {
                str = matcher.group(1);
                if (!IcyHeaders.a3.equals(str)) {
                    if (ExifInterface.Y4.equals(str)) {
                        i2 = (colorInfo == null || colorInfo.Y != 6) ? 2 : 4096;
                    } else {
                        sb2 = new StringBuilder();
                        str2 = "Unknown HEVC profile string: ";
                        sb.append(str2);
                        sb.append(str);
                        Log.n(f11714a, sb.toString());
                        return null;
                    }
                }
                str = strArr[3];
                Integer C = C(str);
                if (C != null) {
                    return new Pair<>(Integer.valueOf(i2), C);
                }
                sb2 = new StringBuilder();
                str2 = "Unknown HEVC level string: ";
                sb.append(str2);
                sb.append(str);
                Log.n(f11714a, sb.toString());
                return null;
            }
        }
        sb.append("Ignoring malformed HEVC codec string: ");
        sb.append(str);
        Log.n(f11714a, sb.toString());
        return null;
    }

    @Nullable
    private static Pair<Integer, Integer> B(String str, String[] strArr) {
        StringBuilder sb;
        String str2;
        if (strArr.length < 3) {
            sb = new StringBuilder();
        } else {
            try {
                int parseInt = Integer.parseInt(strArr[1]);
                int parseInt2 = Integer.parseInt(strArr[2]);
                int U = U(parseInt);
                if (U == -1) {
                    str2 = "Unknown VP9 profile: " + parseInt;
                    Log.n(f11714a, str2);
                    return null;
                }
                int T = T(parseInt2);
                if (T != -1) {
                    return new Pair<>(Integer.valueOf(U), Integer.valueOf(T));
                }
                sb = new StringBuilder();
                sb.append("Unknown VP9 level: ");
                sb.append(parseInt2);
                str2 = sb.toString();
                Log.n(f11714a, str2);
                return null;
            } catch (NumberFormatException unused) {
                sb = new StringBuilder();
            }
        }
        sb.append("Ignoring malformed VP9 codec string: ");
        sb.append(str);
        str2 = sb.toString();
        Log.n(f11714a, str2);
        return null;
    }

    @Nullable
    private static Integer C(@Nullable String str) {
        int i2;
        if (str == null) {
            return null;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case 70821:
                if (str.equals("H30")) {
                    c2 = 0;
                    break;
                }
                break;
            case 70914:
                if (str.equals("H60")) {
                    c2 = 1;
                    break;
                }
                break;
            case 70917:
                if (str.equals("H63")) {
                    c2 = 2;
                    break;
                }
                break;
            case 71007:
                if (str.equals("H90")) {
                    c2 = 3;
                    break;
                }
                break;
            case 71010:
                if (str.equals("H93")) {
                    c2 = 4;
                    break;
                }
                break;
            case 74665:
                if (str.equals("L30")) {
                    c2 = 5;
                    break;
                }
                break;
            case 74758:
                if (str.equals("L60")) {
                    c2 = 6;
                    break;
                }
                break;
            case 74761:
                if (str.equals("L63")) {
                    c2 = 7;
                    break;
                }
                break;
            case 74851:
                if (str.equals("L90")) {
                    c2 = 8;
                    break;
                }
                break;
            case 74854:
                if (str.equals("L93")) {
                    c2 = 9;
                    break;
                }
                break;
            case 2193639:
                if (str.equals("H120")) {
                    c2 = 10;
                    break;
                }
                break;
            case 2193642:
                if (str.equals("H123")) {
                    c2 = 11;
                    break;
                }
                break;
            case 2193732:
                if (str.equals("H150")) {
                    c2 = 12;
                    break;
                }
                break;
            case 2193735:
                if (str.equals("H153")) {
                    c2 = 13;
                    break;
                }
                break;
            case 2193738:
                if (str.equals("H156")) {
                    c2 = 14;
                    break;
                }
                break;
            case 2193825:
                if (str.equals("H180")) {
                    c2 = 15;
                    break;
                }
                break;
            case 2193828:
                if (str.equals("H183")) {
                    c2 = 16;
                    break;
                }
                break;
            case 2193831:
                if (str.equals("H186")) {
                    c2 = 17;
                    break;
                }
                break;
            case 2312803:
                if (str.equals("L120")) {
                    c2 = 18;
                    break;
                }
                break;
            case 2312806:
                if (str.equals("L123")) {
                    c2 = 19;
                    break;
                }
                break;
            case 2312896:
                if (str.equals("L150")) {
                    c2 = 20;
                    break;
                }
                break;
            case 2312899:
                if (str.equals("L153")) {
                    c2 = 21;
                    break;
                }
                break;
            case 2312902:
                if (str.equals("L156")) {
                    c2 = 22;
                    break;
                }
                break;
            case 2312989:
                if (str.equals("L180")) {
                    c2 = 23;
                    break;
                }
                break;
            case 2312992:
                if (str.equals("L183")) {
                    c2 = 24;
                    break;
                }
                break;
            case 2312995:
                if (str.equals("L186")) {
                    c2 = 25;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 2;
            case 1:
                return 8;
            case 2:
                i2 = 32;
                break;
            case 3:
                i2 = 128;
                break;
            case 4:
                i2 = 512;
                break;
            case 5:
                return 1;
            case 6:
                return 4;
            case 7:
                return 16;
            case 8:
                i2 = 64;
                break;
            case 9:
                i2 = 256;
                break;
            case 10:
                i2 = 2048;
                break;
            case 11:
                i2 = 8192;
                break;
            case 12:
                i2 = 32768;
                break;
            case 13:
                i2 = 131072;
                break;
            case 14:
                i2 = 524288;
                break;
            case 15:
                i2 = 2097152;
                break;
            case 16:
                i2 = 8388608;
                break;
            case 17:
                i2 = 33554432;
                break;
            case 18:
                i2 = 1024;
                break;
            case 19:
                i2 = 4096;
                break;
            case 20:
                i2 = 16384;
                break;
            case 21:
                i2 = 65536;
                break;
            case 22:
                i2 = 262144;
                break;
            case 23:
                i2 = 1048576;
                break;
            case 24:
                i2 = 4194304;
                break;
            case 25:
                i2 = 16777216;
                break;
            default:
                return null;
        }
        return Integer.valueOf(i2);
    }

    private static boolean D(MediaCodecInfo mediaCodecInfo) {
        return Util.f9646a >= 29 && E(mediaCodecInfo);
    }

    @RequiresApi(29)
    private static boolean E(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isAlias();
    }

    private static boolean F(MediaCodecInfo mediaCodecInfo, String str, boolean z, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z && str.endsWith(".secure"))) {
            return false;
        }
        int i2 = Util.f9646a;
        if (i2 < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i2 < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
            String str3 = Util.f9647b;
            if ("a70".equals(str3) || ("Xiaomi".equals(Util.f9648c) && str3.startsWith("HM"))) {
                return false;
            }
        }
        if (i2 == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str4 = Util.f9647b;
            if ("dlxu".equals(str4) || "protou".equals(str4) || "ville".equals(str4) || "villeplus".equals(str4) || "villec2".equals(str4) || str4.startsWith("gee") || "C6602".equals(str4) || "C6603".equals(str4) || "C6606".equals(str4) || "C6616".equals(str4) || "L36h".equals(str4) || "SO-02E".equals(str4)) {
                return false;
            }
        }
        if (i2 == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str5 = Util.f9647b;
            if ("C1504".equals(str5) || "C1505".equals(str5) || "C1604".equals(str5) || "C1605".equals(str5)) {
                return false;
            }
        }
        if (i2 < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(Util.f9648c))) {
            String str6 = Util.f9647b;
            if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || "SC-05G".equals(str6) || "marinelteatt".equals(str6) || "404SC".equals(str6) || "SC-04G".equals(str6) || "SCV31".equals(str6)) {
                return false;
            }
        }
        if (i2 <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(Util.f9648c)) {
            String str7 = Util.f9647b;
            if (str7.startsWith("d2") || str7.startsWith("serrano") || str7.startsWith("jflte") || str7.startsWith("santos") || str7.startsWith("t0")) {
                return false;
            }
        }
        if (i2 > 19 || !Util.f9647b.startsWith("jflte") || !"OMX.qcom.video.decoder.vp8".equals(str)) {
            return i2 > 23 || !MimeTypes.S.equals(str2) || !"OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str);
        }
        return false;
    }

    private static boolean G(MediaCodecInfo mediaCodecInfo, String str) {
        return Util.f9646a >= 29 ? H(mediaCodecInfo) : !I(mediaCodecInfo, str);
    }

    @RequiresApi(29)
    private static boolean H(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isHardwareAccelerated();
    }

    private static boolean I(MediaCodecInfo mediaCodecInfo, String str) {
        if (Util.f9646a >= 29) {
            return J(mediaCodecInfo);
        }
        if (MimeTypes.p(str)) {
            return true;
        }
        String g2 = Ascii.g(mediaCodecInfo.getName());
        if (g2.startsWith("arc.")) {
            return false;
        }
        if (g2.startsWith("omx.google.") || g2.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((!g2.startsWith("omx.sec.") || !g2.contains(".sw.")) && !g2.equals("omx.qcom.video.decoder.hevcswvdec") && !g2.startsWith("c2.android.") && !g2.startsWith("c2.google.")) {
            return !g2.startsWith("omx.") && !g2.startsWith("c2.");
        }
        return true;
    }

    @RequiresApi(29)
    private static boolean J(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isSoftwareOnly();
    }

    private static boolean K(MediaCodecInfo mediaCodecInfo) {
        if (Util.f9646a >= 29) {
            return L(mediaCodecInfo);
        }
        String g2 = Ascii.g(mediaCodecInfo.getName());
        return !g2.startsWith("omx.google.") && !g2.startsWith("c2.android.") && !g2.startsWith("c2.google.");
    }

    @RequiresApi(29)
    private static boolean L(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isVendor();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int M(MediaCodecInfo mediaCodecInfo) {
        String str = mediaCodecInfo.f11693a;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (Util.f9646a >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int N(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.f11693a.startsWith("OMX.google") ? 1 : 0;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int O(Format format, MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.o(format) ? 1 : 0;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int P(ScoreProvider scoreProvider, Object obj, Object obj2) {
        return scoreProvider.a(obj2) - scoreProvider.a(obj);
    }

    public static int Q() throws DecoderQueryException {
        if (f11724k == -1) {
            int i2 = 0;
            MediaCodecInfo t = t(MimeTypes.f9235j, false, false);
            if (t != null) {
                MediaCodecInfo.CodecProfileLevel[] i3 = t.i();
                int length = i3.length;
                int i4 = 0;
                while (i2 < length) {
                    i4 = Math.max(h(i3[i2].level), i4);
                    i2++;
                }
                i2 = Math.max(i4, Util.f9646a >= 21 ? 345600 : 172800);
            }
            f11724k = i2;
        }
        return f11724k;
    }

    private static int R(int i2) {
        int i3 = 17;
        if (i2 != 17) {
            i3 = 20;
            if (i2 != 20) {
                i3 = 23;
                if (i2 != 23) {
                    i3 = 29;
                    if (i2 != 29) {
                        i3 = 39;
                        if (i2 != 39) {
                            i3 = 42;
                            if (i2 != 42) {
                                switch (i2) {
                                    case 1:
                                        return 1;
                                    case 2:
                                        return 2;
                                    case 3:
                                        return 3;
                                    case 4:
                                        return 4;
                                    case 5:
                                        return 5;
                                    case 6:
                                        return 6;
                                    default:
                                        return -1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return i3;
    }

    private static <T> void S(List<T> list, ScoreProvider<T> scoreProvider) {
        Collections.sort(list, new x(scoreProvider));
    }

    private static int T(int i2) {
        if (i2 == 10) {
            return 1;
        }
        if (i2 == 11) {
            return 2;
        }
        if (i2 == 20) {
            return 4;
        }
        if (i2 == 21) {
            return 8;
        }
        if (i2 == 30) {
            return 16;
        }
        if (i2 == 31) {
            return 32;
        }
        if (i2 == 40) {
            return 64;
        }
        if (i2 == 41) {
            return 128;
        }
        if (i2 == 50) {
            return 256;
        }
        if (i2 == 51) {
            return 512;
        }
        switch (i2) {
            case 60:
                return 2048;
            case 61:
                return 4096;
            case 62:
                return 8192;
            default:
                return -1;
        }
    }

    private static int U(int i2) {
        if (i2 == 0) {
            return 1;
        }
        if (i2 == 1) {
            return 2;
        }
        if (i2 != 2) {
            return i2 != 3 ? -1 : 8;
        }
        return 4;
    }

    public static void V(String str, boolean z, boolean z2) {
        try {
            u(str, z, z2);
        } catch (DecoderQueryException e2) {
            Log.e(f11714a, "Codec warming failed", e2);
        }
    }

    private static void e(String str, List<MediaCodecInfo> list) {
        if (MimeTypes.N.equals(str)) {
            if (Util.f9646a < 26 && Util.f9647b.equals("R9") && list.size() == 1 && list.get(0).f11693a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(MediaCodecInfo.G("OMX.google.raw.decoder", MimeTypes.N, MimeTypes.N, (MediaCodecInfo.CodecCapabilities) null, false, true, false, false, false));
            }
            S(list, new y());
        }
        int i2 = Util.f9646a;
        if (i2 < 21 && list.size() > 1) {
            String str2 = list.get(0).f11693a;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                S(list, new z());
            }
        }
        if (i2 < 32 && list.size() > 1 && "OMX.qti.audio.decoder.flac".equals(list.get(0).f11693a)) {
            list.add(list.remove(0));
        }
    }

    private static int f(int i2) {
        switch (i2) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            case 9:
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return 4096;
            case 13:
                return 8192;
            case 14:
                return 16384;
            case 15:
                return 32768;
            case 16:
                return 65536;
            case 17:
                return 131072;
            case 18:
                return 262144;
            case 19:
                return 524288;
            case 20:
                return 1048576;
            case 21:
                return 2097152;
            case 22:
                return 4194304;
            case 23:
                return 8388608;
            default:
                return -1;
        }
    }

    private static int g(int i2) {
        switch (i2) {
            case 10:
                return 1;
            case 11:
                return 4;
            case 12:
                return 8;
            case 13:
                return 16;
            default:
                switch (i2) {
                    case 20:
                        return 32;
                    case 21:
                        return 64;
                    case 22:
                        return 128;
                    default:
                        switch (i2) {
                            case 30:
                                return 256;
                            case 31:
                                return 512;
                            case 32:
                                return 1024;
                            default:
                                switch (i2) {
                                    case 40:
                                        return 2048;
                                    case 41:
                                        return 4096;
                                    case 42:
                                        return 8192;
                                    default:
                                        switch (i2) {
                                            case 50:
                                                return 16384;
                                            case 51:
                                                return 32768;
                                            case 52:
                                                return 65536;
                                            default:
                                                return -1;
                                        }
                                }
                        }
                }
        }
    }

    private static int h(int i2) {
        if (i2 == 1 || i2 == 2) {
            return 25344;
        }
        switch (i2) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case 65536:
                return 9437184;
            case 131072:
            case 262144:
            case 524288:
                return 35651584;
            default:
                return -1;
        }
    }

    private static int i(int i2) {
        if (i2 == 66) {
            return 1;
        }
        if (i2 == 77) {
            return 2;
        }
        if (i2 == 88) {
            return 4;
        }
        if (i2 == 100) {
            return 8;
        }
        if (i2 == 110) {
            return 16;
        }
        if (i2 != 122) {
            return i2 != 244 ? -1 : 64;
        }
        return 32;
    }

    @VisibleForTesting
    public static synchronized void j() {
        synchronized (MediaCodecUtil.class) {
            f11716c.clear();
        }
    }

    @Nullable
    private static Integer k(@Nullable String str) {
        int i2;
        if (str == null) {
            return null;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case 1537:
                if (str.equals("01")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1538:
                if (str.equals("02")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1539:
                if (str.equals("03")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1540:
                if (str.equals("04")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1541:
                if (str.equals("05")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1542:
                if (str.equals("06")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1543:
                if (str.equals("07")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1544:
                if (str.equals("08")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1545:
                if (str.equals("09")) {
                    c2 = 8;
                    break;
                }
                break;
            case 1567:
                if (str.equals("10")) {
                    c2 = 9;
                    break;
                }
                break;
            case 1568:
                if (str.equals("11")) {
                    c2 = 10;
                    break;
                }
                break;
            case 1569:
                if (str.equals("12")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1570:
                if (str.equals("13")) {
                    c2 = 12;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                i2 = 16;
                break;
            case 5:
                i2 = 32;
                break;
            case 6:
                i2 = 64;
                break;
            case 7:
                i2 = 128;
                break;
            case 8:
                i2 = 256;
                break;
            case 9:
                i2 = 512;
                break;
            case 10:
                i2 = 1024;
                break;
            case 11:
                i2 = 2048;
                break;
            case 12:
                i2 = 4096;
                break;
            default:
                return null;
        }
        return Integer.valueOf(i2);
    }

    @Nullable
    private static Integer l(@Nullable String str) {
        int i2;
        if (str == null) {
            return null;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case 1536:
                if (str.equals("00")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1537:
                if (str.equals("01")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1538:
                if (str.equals("02")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1539:
                if (str.equals("03")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1540:
                if (str.equals("04")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1541:
                if (str.equals("05")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1542:
                if (str.equals("06")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1543:
                if (str.equals("07")) {
                    c2 = 7;
                    break;
                }
                break;
            case 1544:
                if (str.equals("08")) {
                    c2 = 8;
                    break;
                }
                break;
            case 1545:
                if (str.equals("09")) {
                    c2 = 9;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                i2 = 16;
                break;
            case 5:
                i2 = 32;
                break;
            case 6:
                i2 = 64;
                break;
            case 7:
                i2 = 128;
                break;
            case 8:
                i2 = 256;
                break;
            case 9:
                i2 = 512;
                break;
            default:
                return null;
        }
        return Integer.valueOf(i2);
    }

    @Nullable
    private static Pair<Integer, Integer> m(String str, String[] strArr) {
        int R;
        if (strArr.length != 3) {
            Log.n(f11714a, "Ignoring malformed MP4A codec string: " + str);
            return null;
        }
        try {
            if (MimeTypes.F.equals(MimeTypes.h(Integer.parseInt(strArr[1], 16))) && (R = R(Integer.parseInt(strArr[2]))) != -1) {
                return new Pair<>(Integer.valueOf(R), 0);
            }
        } catch (NumberFormatException unused) {
            Log.n(f11714a, "Ignoring malformed MP4A codec string: " + str);
        }
        return null;
    }

    @Nullable
    public static String n(Format format) {
        Pair<Integer, Integer> s;
        if (MimeTypes.S.equals(format.f3)) {
            return MimeTypes.R;
        }
        if (!MimeTypes.w.equals(format.f3) || (s = s(format)) == null) {
            return null;
        }
        int intValue = ((Integer) s.first).intValue();
        if (intValue == 16 || intValue == 256) {
            return MimeTypes.f9236k;
        }
        if (intValue == 512) {
            return MimeTypes.f9235j;
        }
        return null;
    }

    public static List<MediaCodecInfo> o(MediaCodecSelector mediaCodecSelector, Format format, boolean z, boolean z2) throws DecoderQueryException {
        String n2 = n(format);
        return n2 == null ? ImmutableList.I() : mediaCodecSelector.a(n2, z, z2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0069, code lost:
        r8 = r10.Y;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.util.Pair<java.lang.Integer, java.lang.Integer> p(java.lang.String r8, java.lang.String[] r9, @androidx.annotation.Nullable androidx.media3.common.ColorInfo r10) {
        /*
            int r0 = r9.length
            r1 = 4
            java.lang.String r2 = "Ignoring malformed AV1 codec string: "
            r3 = 0
            java.lang.String r4 = "MediaCodecUtil"
            if (r0 >= r1) goto L_0x001c
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
        L_0x000e:
            r9.append(r2)
            r9.append(r8)
        L_0x0014:
            java.lang.String r8 = r9.toString()
        L_0x0018:
            androidx.media3.common.util.Log.n(r4, r8)
            return r3
        L_0x001c:
            r0 = 1
            r1 = r9[r0]     // Catch:{ NumberFormatException -> 0x0098 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0098 }
            r5 = 2
            r6 = r9[r5]     // Catch:{ NumberFormatException -> 0x0098 }
            r7 = 0
            java.lang.String r6 = r6.substring(r7, r5)     // Catch:{ NumberFormatException -> 0x0098 }
            int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ NumberFormatException -> 0x0098 }
            r7 = 3
            r9 = r9[r7]     // Catch:{ NumberFormatException -> 0x0098 }
            int r8 = java.lang.Integer.parseInt(r9)     // Catch:{ NumberFormatException -> 0x0098 }
            if (r1 == 0) goto L_0x004a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Unknown AV1 profile: "
            r8.append(r9)
            r8.append(r1)
        L_0x0045:
            java.lang.String r8 = r8.toString()
            goto L_0x0018
        L_0x004a:
            r9 = 8
            if (r8 == r9) goto L_0x0060
            r1 = 10
            if (r8 == r1) goto L_0x0060
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Unknown AV1 bit depth: "
            r9.append(r10)
            r9.append(r8)
            goto L_0x0014
        L_0x0060:
            if (r8 != r9) goto L_0x0063
            goto L_0x0075
        L_0x0063:
            if (r10 == 0) goto L_0x0074
            byte[] r8 = r10.Z
            if (r8 != 0) goto L_0x0071
            int r8 = r10.Y
            r9 = 7
            if (r8 == r9) goto L_0x0071
            r9 = 6
            if (r8 != r9) goto L_0x0074
        L_0x0071:
            r0 = 4096(0x1000, float:5.74E-42)
            goto L_0x0075
        L_0x0074:
            r0 = 2
        L_0x0075:
            int r8 = f(r6)
            r9 = -1
            if (r8 != r9) goto L_0x008a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Unknown AV1 level: "
            r8.append(r9)
            r8.append(r6)
            goto L_0x0045
        L_0x008a:
            android.util.Pair r9 = new android.util.Pair
            java.lang.Integer r10 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r9.<init>(r10, r8)
            return r9
        L_0x0098:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            goto L_0x000e
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.p(java.lang.String, java.lang.String[], androidx.media3.common.ColorInfo):android.util.Pair");
    }

    @Nullable
    private static Pair<Integer, Integer> q(String str, String[] strArr) {
        StringBuilder sb;
        int i2;
        int i3;
        String str2;
        if (strArr.length < 2) {
            sb = new StringBuilder();
        } else {
            try {
                if (strArr[1].length() == 6) {
                    i3 = Integer.parseInt(strArr[1].substring(0, 2), 16);
                    i2 = Integer.parseInt(strArr[1].substring(4), 16);
                } else if (strArr.length >= 3) {
                    int parseInt = Integer.parseInt(strArr[1]);
                    i2 = Integer.parseInt(strArr[2]);
                    i3 = parseInt;
                } else {
                    Log.n(f11714a, "Ignoring malformed AVC codec string: " + str);
                    return null;
                }
                int i4 = i(i3);
                if (i4 == -1) {
                    str2 = "Unknown AVC profile: " + i3;
                    Log.n(f11714a, str2);
                    return null;
                }
                int g2 = g(i2);
                if (g2 != -1) {
                    return new Pair<>(Integer.valueOf(i4), Integer.valueOf(g2));
                }
                sb = new StringBuilder();
                sb.append("Unknown AVC level: ");
                sb.append(i2);
                str2 = sb.toString();
                Log.n(f11714a, str2);
                return null;
            } catch (NumberFormatException unused) {
                sb = new StringBuilder();
            }
        }
        sb.append("Ignoring malformed AVC codec string: ");
        sb.append(str);
        str2 = sb.toString();
        Log.n(f11714a, str2);
        return null;
    }

    @Nullable
    private static String r(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals(MimeTypes.w)) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        } else if (str2.equals(MimeTypes.f0) && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        } else {
            if (str2.equals(MimeTypes.e0) && "OMX.lge.flac.decoder".equals(str)) {
                return "audio/x-lg-flac";
            }
            if (!str2.equals(MimeTypes.Q) || !"OMX.lge.ac3.decoder".equals(str)) {
                return null;
            }
            return "audio/lg-ac3";
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0075, code lost:
        if (r3.equals(f11722i) == false) goto L_0x002b;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> s(androidx.media3.common.Format r6) {
        /*
            r0 = 0
            java.lang.String r1 = r6.c3
            r2 = 0
            if (r1 != 0) goto L_0x0007
            return r2
        L_0x0007:
            java.lang.String r3 = "\\."
            java.lang.String[] r1 = r1.split(r3)
            java.lang.String r3 = "video/dolby-vision"
            java.lang.String r4 = r6.f3
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x001e
            java.lang.String r6 = r6.c3
            android.util.Pair r6 = z(r6, r1)
            return r6
        L_0x001e:
            r3 = r1[r0]
            r3.hashCode()
            r4 = -1
            int r5 = r3.hashCode()
            switch(r5) {
                case 3004662: goto L_0x006f;
                case 3006243: goto L_0x0064;
                case 3006244: goto L_0x0059;
                case 3199032: goto L_0x004e;
                case 3214780: goto L_0x0043;
                case 3356560: goto L_0x0038;
                case 3624515: goto L_0x002d;
                default: goto L_0x002b;
            }
        L_0x002b:
            r0 = -1
            goto L_0x0078
        L_0x002d:
            java.lang.String r0 = "vp09"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x0036
            goto L_0x002b
        L_0x0036:
            r0 = 6
            goto L_0x0078
        L_0x0038:
            java.lang.String r0 = "mp4a"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x0041
            goto L_0x002b
        L_0x0041:
            r0 = 5
            goto L_0x0078
        L_0x0043:
            java.lang.String r0 = "hvc1"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x004c
            goto L_0x002b
        L_0x004c:
            r0 = 4
            goto L_0x0078
        L_0x004e:
            java.lang.String r0 = "hev1"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x0057
            goto L_0x002b
        L_0x0057:
            r0 = 3
            goto L_0x0078
        L_0x0059:
            java.lang.String r0 = "avc2"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x0062
            goto L_0x002b
        L_0x0062:
            r0 = 2
            goto L_0x0078
        L_0x0064:
            java.lang.String r0 = "avc1"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x006d
            goto L_0x002b
        L_0x006d:
            r0 = 1
            goto L_0x0078
        L_0x006f:
            java.lang.String r5 = "av01"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0078
            goto L_0x002b
        L_0x0078:
            switch(r0) {
                case 0: goto L_0x009a;
                case 1: goto L_0x0093;
                case 2: goto L_0x0093;
                case 3: goto L_0x008a;
                case 4: goto L_0x008a;
                case 5: goto L_0x0083;
                case 6: goto L_0x007c;
                default: goto L_0x007b;
            }
        L_0x007b:
            return r2
        L_0x007c:
            java.lang.String r6 = r6.c3
            android.util.Pair r6 = B(r6, r1)
            return r6
        L_0x0083:
            java.lang.String r6 = r6.c3
            android.util.Pair r6 = m(r6, r1)
            return r6
        L_0x008a:
            java.lang.String r0 = r6.c3
            androidx.media3.common.ColorInfo r6 = r6.r3
            android.util.Pair r6 = A(r0, r1, r6)
            return r6
        L_0x0093:
            java.lang.String r6 = r6.c3
            android.util.Pair r6 = q(r6, r1)
            return r6
        L_0x009a:
            java.lang.String r0 = r6.c3
            androidx.media3.common.ColorInfo r6 = r6.r3
            android.util.Pair r6 = p(r0, r1, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.s(androidx.media3.common.Format):android.util.Pair");
    }

    @Nullable
    public static MediaCodecInfo t(String str, boolean z, boolean z2) throws DecoderQueryException {
        List<MediaCodecInfo> u = u(str, z, z2);
        if (u.isEmpty()) {
            return null;
        }
        return u.get(0);
    }

    public static synchronized List<MediaCodecInfo> u(String str, boolean z, boolean z2) throws DecoderQueryException {
        synchronized (MediaCodecUtil.class) {
            try {
                CodecKey codecKey = new CodecKey(str, z, z2);
                HashMap<CodecKey, List<MediaCodecInfo>> hashMap = f11716c;
                List<MediaCodecInfo> list = hashMap.get(codecKey);
                if (list != null) {
                    return list;
                }
                int i2 = Util.f9646a;
                ArrayList<MediaCodecInfo> v = v(codecKey, i2 >= 21 ? new MediaCodecListCompatV21(z, z2) : new MediaCodecListCompatV16());
                if (z && v.isEmpty() && 21 <= i2 && i2 <= 23) {
                    v = v(codecKey, new MediaCodecListCompatV16());
                    if (!v.isEmpty()) {
                        Log.n(f11714a, "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + v.get(0).f11693a);
                    }
                }
                e(str, v);
                ImmutableList<MediaCodecInfo> B = ImmutableList.B(v);
                hashMap.put(codecKey, B);
                return B;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008c, code lost:
        if (r1.f11726b == false) goto L_0x008e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0105 A[SYNTHETIC, Splitter:B:60:0x0105] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0130 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<androidx.media3.exoplayer.mediacodec.MediaCodecInfo> v(androidx.media3.exoplayer.mediacodec.MediaCodecUtil.CodecKey r24, androidx.media3.exoplayer.mediacodec.MediaCodecUtil.MediaCodecListCompat r25) throws androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException {
        /*
            r1 = r24
            r2 = r25
            java.lang.String r3 = "secure-playback"
            java.lang.String r4 = "tunneled-playback"
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x012e }
            r5.<init>()     // Catch:{ Exception -> 0x012e }
            java.lang.String r15 = r1.f11725a     // Catch:{ Exception -> 0x012e }
            int r14 = r25.d()     // Catch:{ Exception -> 0x012e }
            boolean r13 = r25.e()     // Catch:{ Exception -> 0x012e }
            r0 = 0
            r12 = 0
        L_0x0019:
            if (r12 >= r14) goto L_0x0154
            android.media.MediaCodecInfo r0 = r2.a(r12)     // Catch:{ Exception -> 0x012e }
            boolean r6 = D(r0)     // Catch:{ Exception -> 0x012e }
            if (r6 == 0) goto L_0x002d
        L_0x0025:
            r22 = r12
            r23 = r13
            r18 = r14
            goto L_0x0124
        L_0x002d:
            java.lang.String r11 = r0.getName()     // Catch:{ Exception -> 0x012e }
            boolean r6 = F(r0, r11, r13, r15)     // Catch:{ Exception -> 0x012e }
            if (r6 != 0) goto L_0x0038
            goto L_0x0025
        L_0x0038:
            java.lang.String r10 = r(r0, r11, r15)     // Catch:{ Exception -> 0x012e }
            if (r10 != 0) goto L_0x003f
            goto L_0x0025
        L_0x003f:
            android.media.MediaCodecInfo$CodecCapabilities r9 = r0.getCapabilitiesForType(r10)     // Catch:{ Exception -> 0x007c }
            boolean r6 = r2.b(r4, r10, r9)     // Catch:{ Exception -> 0x007c }
            boolean r7 = r2.c(r4, r10, r9)     // Catch:{ Exception -> 0x007c }
            boolean r8 = r1.f11727c     // Catch:{ Exception -> 0x007c }
            if (r8 != 0) goto L_0x0051
            if (r7 != 0) goto L_0x0025
        L_0x0051:
            if (r8 == 0) goto L_0x0056
            if (r6 != 0) goto L_0x0056
            goto L_0x0025
        L_0x0056:
            boolean r6 = r2.b(r3, r10, r9)     // Catch:{ Exception -> 0x007c }
            boolean r7 = r2.c(r3, r10, r9)     // Catch:{ Exception -> 0x007c }
            boolean r8 = r1.f11726b     // Catch:{ Exception -> 0x007c }
            if (r8 != 0) goto L_0x0064
            if (r7 != 0) goto L_0x0025
        L_0x0064:
            if (r8 == 0) goto L_0x0069
            if (r6 != 0) goto L_0x0069
            goto L_0x0025
        L_0x0069:
            boolean r16 = G(r0, r15)     // Catch:{ Exception -> 0x007c }
            boolean r17 = I(r0, r15)     // Catch:{ Exception -> 0x007c }
            boolean r0 = K(r0)     // Catch:{ Exception -> 0x007c }
            if (r13 == 0) goto L_0x0088
            boolean r7 = r1.f11726b     // Catch:{ Exception -> 0x007c }
            if (r7 == r6) goto L_0x008e
            goto L_0x0088
        L_0x007c:
            r0 = move-exception
            r20 = r10
            r1 = r11
            r22 = r12
            r23 = r13
            r18 = r14
            goto L_0x00fd
        L_0x0088:
            if (r13 != 0) goto L_0x00b5
            boolean r7 = r1.f11726b     // Catch:{ Exception -> 0x00c0 }
            if (r7 != 0) goto L_0x00b5
        L_0x008e:
            r18 = 0
            r19 = 0
            r6 = r11
            r7 = r15
            r8 = r10
            r20 = r10
            r10 = r16
            r21 = r11
            r11 = r17
            r22 = r12
            r12 = r0
            r23 = r13
            r13 = r18
            r18 = r14
            r14 = r19
            androidx.media3.exoplayer.mediacodec.MediaCodecInfo r0 = androidx.media3.exoplayer.mediacodec.MediaCodecInfo.G(r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x00b1 }
            r5.add(r0)     // Catch:{ Exception -> 0x00b1 }
            goto L_0x0124
        L_0x00b1:
            r0 = move-exception
        L_0x00b2:
            r1 = r21
            goto L_0x00fd
        L_0x00b5:
            r20 = r10
            r21 = r11
            r22 = r12
            r23 = r13
            r18 = r14
            goto L_0x00cc
        L_0x00c0:
            r0 = move-exception
            r20 = r10
            r21 = r11
            r22 = r12
            r23 = r13
            r18 = r14
            goto L_0x00b2
        L_0x00cc:
            if (r23 != 0) goto L_0x0124
            if (r6 == 0) goto L_0x0124
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b1 }
            r6.<init>()     // Catch:{ Exception -> 0x00b1 }
            r14 = r21
            r6.append(r14)     // Catch:{ Exception -> 0x00fb }
            java.lang.String r7 = ".secure"
            r6.append(r7)     // Catch:{ Exception -> 0x00fb }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00fb }
            r13 = 0
            r19 = 1
            r7 = r15
            r8 = r20
            r10 = r16
            r11 = r17
            r12 = r0
            r1 = r14
            r14 = r19
            androidx.media3.exoplayer.mediacodec.MediaCodecInfo r0 = androidx.media3.exoplayer.mediacodec.MediaCodecInfo.G(r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x00f9 }
            r5.add(r0)     // Catch:{ Exception -> 0x00f9 }
            return r5
        L_0x00f9:
            r0 = move-exception
            goto L_0x00fd
        L_0x00fb:
            r0 = move-exception
            r1 = r14
        L_0x00fd:
            int r6 = androidx.media3.common.util.Util.f9646a     // Catch:{ Exception -> 0x012e }
            r7 = 23
            java.lang.String r8 = "MediaCodecUtil"
            if (r6 > r7) goto L_0x0130
            boolean r6 = r5.isEmpty()     // Catch:{ Exception -> 0x012e }
            if (r6 != 0) goto L_0x0130
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012e }
            r0.<init>()     // Catch:{ Exception -> 0x012e }
            java.lang.String r6 = "Skipping codec "
            r0.append(r6)     // Catch:{ Exception -> 0x012e }
            r0.append(r1)     // Catch:{ Exception -> 0x012e }
            java.lang.String r1 = " (failed to query capabilities)"
            r0.append(r1)     // Catch:{ Exception -> 0x012e }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x012e }
            androidx.media3.common.util.Log.d(r8, r0)     // Catch:{ Exception -> 0x012e }
        L_0x0124:
            int r12 = r22 + 1
            r1 = r24
            r14 = r18
            r13 = r23
            goto L_0x0019
        L_0x012e:
            r0 = move-exception
            goto L_0x0155
        L_0x0130:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012e }
            r2.<init>()     // Catch:{ Exception -> 0x012e }
            java.lang.String r3 = "Failed to query codec "
            r2.append(r3)     // Catch:{ Exception -> 0x012e }
            r2.append(r1)     // Catch:{ Exception -> 0x012e }
            java.lang.String r1 = " ("
            r2.append(r1)     // Catch:{ Exception -> 0x012e }
            r1 = r20
            r2.append(r1)     // Catch:{ Exception -> 0x012e }
            java.lang.String r1 = ")"
            r2.append(r1)     // Catch:{ Exception -> 0x012e }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x012e }
            androidx.media3.common.util.Log.d(r8, r1)     // Catch:{ Exception -> 0x012e }
            throw r0     // Catch:{ Exception -> 0x012e }
        L_0x0154:
            return r5
        L_0x0155:
            androidx.media3.exoplayer.mediacodec.MediaCodecUtil$DecoderQueryException r1 = new androidx.media3.exoplayer.mediacodec.MediaCodecUtil$DecoderQueryException
            r2 = 0
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.v(androidx.media3.exoplayer.mediacodec.MediaCodecUtil$CodecKey, androidx.media3.exoplayer.mediacodec.MediaCodecUtil$MediaCodecListCompat):java.util.ArrayList");
    }

    @RequiresNonNull({"#2.sampleMimeType"})
    public static List<MediaCodecInfo> w(MediaCodecSelector mediaCodecSelector, Format format, boolean z, boolean z2) throws DecoderQueryException {
        List<MediaCodecInfo> a2 = mediaCodecSelector.a(format.f3, z, z2);
        return ImmutableList.r().c(a2).c(o(mediaCodecSelector, format, z, z2)).e();
    }

    @CheckResult
    public static List<MediaCodecInfo> x(List<MediaCodecInfo> list, Format format) {
        ArrayList arrayList = new ArrayList(list);
        S(arrayList, new A(format));
        return arrayList;
    }

    @Nullable
    public static MediaCodecInfo y() throws DecoderQueryException {
        return t(MimeTypes.N, false, false);
    }

    @Nullable
    private static Pair<Integer, Integer> z(String str, String[] strArr) {
        StringBuilder sb;
        String str2;
        StringBuilder sb2;
        if (strArr.length < 3) {
            sb2 = new StringBuilder();
        } else {
            Matcher matcher = f11715b.matcher(strArr[1]);
            if (!matcher.matches()) {
                sb2 = new StringBuilder();
            } else {
                str = matcher.group(1);
                Integer l2 = l(str);
                if (l2 == null) {
                    sb = new StringBuilder();
                    str2 = "Unknown Dolby Vision profile string: ";
                } else {
                    str = strArr[2];
                    Integer k2 = k(str);
                    if (k2 != null) {
                        return new Pair<>(l2, k2);
                    }
                    sb = new StringBuilder();
                    str2 = "Unknown Dolby Vision level string: ";
                }
                sb2.append(str2);
                sb2.append(str);
                Log.n(f11714a, sb2.toString());
                return null;
            }
        }
        sb2.append("Ignoring malformed Dolby Vision codec string: ");
        sb2.append(str);
        Log.n(f11714a, sb2.toString());
        return null;
    }
}
