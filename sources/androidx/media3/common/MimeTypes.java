package androidx.media3.common;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ts.TsExtractor;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.dataflow.qual.Pure;

public final class MimeTypes {
    public static final String A = "video/mp42";
    public static final String A0 = "application/x-quicktime-tx3g";
    public static final String B = "video/mp43";
    public static final String B0 = "application/x-mp4-vtt";
    @UnstableApi
    public static final String C = "video/raw";
    public static final String C0 = "application/x-mp4-cea-608";
    @UnstableApi
    public static final String D = "video/x-unknown";
    @Deprecated
    public static final String D0 = "application/x-rawcc";
    public static final String E = "audio/mp4";
    public static final String E0 = "application/vobsub";
    public static final String F = "audio/mp4a-latm";
    public static final String F0 = "application/pgs";
    @UnstableApi
    public static final String G = "audio/x-matroska";
    @UnstableApi
    public static final String G0 = "application/x-scte35";
    public static final String H = "audio/webm";
    @UnstableApi
    public static final String H0 = "application/x-camera-motion";
    public static final String I = "audio/mpeg";
    @UnstableApi
    public static final String I0 = "application/x-emsg";
    public static final String J = "audio/mpeg-L1";
    public static final String J0 = "application/dvbsubs";
    public static final String K = "audio/mpeg-L2";
    @UnstableApi
    public static final String K0 = "application/x-exif";
    public static final String L = "audio/mha1";
    @UnstableApi
    public static final String L0 = "application/x-icy";
    public static final String M = "audio/mhm1";
    public static final String M0 = "application/vnd.dvb.ait";
    public static final String N = "audio/raw";
    public static final String N0 = "application/x-rtsp";
    public static final String O = "audio/g711-alaw";
    @UnstableApi
    public static final String O0 = "application/x-media3-cues";
    public static final String P = "audio/g711-mlaw";
    @UnstableApi
    public static final String P0 = "application/x-image-uri";
    public static final String Q = "audio/ac3";
    public static final String Q0 = "image/jpeg";
    public static final String R = "audio/eac3";
    @UnstableApi
    public static final String R0 = "image/png";
    public static final String S = "audio/eac3-joc";
    @UnstableApi
    public static final String S0 = "image/heif";
    public static final String T = "audio/ac4";
    @UnstableApi
    public static final String T0 = "image/bmp";
    public static final String U = "audio/true-hd";
    @UnstableApi
    public static final String U0 = "image/webp";
    public static final String V = "audio/vnd.dts";
    @UnstableApi
    public static final String V0 = "ec+3";
    public static final String W = "audio/vnd.dts.hd";
    private static final ArrayList<CustomMimeType> W0 = new ArrayList<>();
    public static final String X = "audio/vnd.dts.hd;profile=lbr";
    private static final Pattern X0 = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");
    @UnstableApi
    public static final String Y = "audio/vnd.dts.uhd;profile=p2";
    public static final String Z = "audio/vorbis";
    @UnstableApi

    /* renamed from: a  reason: collision with root package name */
    public static final String f9226a = "video";
    public static final String a0 = "audio/opus";
    @UnstableApi

    /* renamed from: b  reason: collision with root package name */
    public static final String f9227b = "audio";
    public static final String b0 = "audio/amr";
    @UnstableApi

    /* renamed from: c  reason: collision with root package name */
    public static final String f9228c = "text";
    public static final String c0 = "audio/3gpp";
    @UnstableApi

    /* renamed from: d  reason: collision with root package name */
    public static final String f9229d = "image";
    public static final String d0 = "audio/amr-wb";
    @UnstableApi

    /* renamed from: e  reason: collision with root package name */
    public static final String f9230e = "application";
    public static final String e0 = "audio/flac";

    /* renamed from: f  reason: collision with root package name */
    public static final String f9231f = "video/mp4";
    public static final String f0 = "audio/alac";
    @UnstableApi

    /* renamed from: g  reason: collision with root package name */
    public static final String f9232g = "video/x-matroska";
    public static final String g0 = "audio/gsm";

    /* renamed from: h  reason: collision with root package name */
    public static final String f9233h = "video/webm";
    public static final String h0 = "audio/ogg";

    /* renamed from: i  reason: collision with root package name */
    public static final String f9234i = "video/3gpp";
    public static final String i0 = "audio/wav";

    /* renamed from: j  reason: collision with root package name */
    public static final String f9235j = "video/avc";
    public static final String j0 = "audio/midi";

    /* renamed from: k  reason: collision with root package name */
    public static final String f9236k = "video/hevc";
    @UnstableApi
    public static final String k0 = "audio/x-exoplayer-midi";
    @UnstableApi

    /* renamed from: l  reason: collision with root package name */
    public static final String f9237l = "video/x-vnd.on2.vp8";
    @UnstableApi
    public static final String l0 = "audio/x-unknown";
    @UnstableApi

    /* renamed from: m  reason: collision with root package name */
    public static final String f9238m = "video/x-vnd.on2.vp9";
    public static final String m0 = "text/vtt";

    /* renamed from: n  reason: collision with root package name */
    public static final String f9239n = "video/av01";
    public static final String n0 = "text/x-ssa";
    public static final String o = "video/mp2t";
    @UnstableApi
    public static final String o0 = "text/x-unknown";
    public static final String p = "video/mp4v-es";
    public static final String p0 = "application/mp4";
    public static final String q = "video/mpeg";
    public static final String q0 = "application/webm";
    public static final String r = "video/mp2p";
    public static final String r0 = "application/x-matroska";
    public static final String s = "video/mpeg2";
    public static final String s0 = "application/dash+xml";
    public static final String t = "video/wvc1";
    public static final String t0 = "application/x-mpegURL";
    public static final String u = "video/divx";
    public static final String u0 = "application/vnd.ms-sstr+xml";
    @UnstableApi
    public static final String v = "video/x-flv";
    public static final String v0 = "application/id3";
    public static final String w = "video/dolby-vision";
    public static final String w0 = "application/cea-608";
    public static final String x = "video/ogg";
    public static final String x0 = "application/cea-708";
    public static final String y = "video/x-msvideo";
    public static final String y0 = "application/x-subrip";
    public static final String z = "video/mjpeg";
    public static final String z0 = "application/ttml+xml";

    private static final class CustomMimeType {

        /* renamed from: a  reason: collision with root package name */
        public final String f9240a;

        /* renamed from: b  reason: collision with root package name */
        public final String f9241b;

        /* renamed from: c  reason: collision with root package name */
        public final int f9242c;

        public CustomMimeType(String str, String str2, int i2) {
            this.f9240a = str;
            this.f9241b = str2;
            this.f9242c = i2;
        }
    }

    @VisibleForTesting
    static final class Mp4aObjectType {

        /* renamed from: a  reason: collision with root package name */
        public final int f9243a;

        /* renamed from: b  reason: collision with root package name */
        public final int f9244b;

        public Mp4aObjectType(int i2, int i3) {
            this.f9243a = i2;
            this.f9244b = i3;
        }

        public int a() {
            int i2 = this.f9244b;
            if (i2 == 2) {
                return 10;
            }
            if (i2 == 5) {
                return 11;
            }
            if (i2 == 29) {
                return 12;
            }
            if (i2 == 42) {
                return 16;
            }
            if (i2 != 22) {
                return i2 != 23 ? 0 : 15;
            }
            return 1073741824;
        }
    }

    private MimeTypes() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009e, code lost:
        r4 = (r4 = i(r5)).a();
     */
    @androidx.media3.common.util.UnstableApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(@androidx.annotation.Nullable java.lang.String r4, @androidx.annotation.Nullable java.lang.String r5) {
        /*
            r0 = 1
            r1 = 0
            if (r4 != 0) goto L_0x0005
            return r1
        L_0x0005:
            r2 = -1
            int r3 = r4.hashCode()
            switch(r3) {
                case -2123537834: goto L_0x0086;
                case -432837260: goto L_0x007b;
                case -432837259: goto L_0x0070;
                case -53558318: goto L_0x0065;
                case 187078296: goto L_0x005a;
                case 187094639: goto L_0x004f;
                case 1504578661: goto L_0x0044;
                case 1504619009: goto L_0x0039;
                case 1504831518: goto L_0x002b;
                case 1903231877: goto L_0x001d;
                case 1903589369: goto L_0x000f;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0090
        L_0x000f:
            java.lang.String r3 = "audio/g711-mlaw"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x0019
            goto L_0x0090
        L_0x0019:
            r2 = 10
            goto L_0x0090
        L_0x001d:
            java.lang.String r3 = "audio/g711-alaw"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x0027
            goto L_0x0090
        L_0x0027:
            r2 = 9
            goto L_0x0090
        L_0x002b:
            java.lang.String r3 = "audio/mpeg"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x0035
            goto L_0x0090
        L_0x0035:
            r2 = 8
            goto L_0x0090
        L_0x0039:
            java.lang.String r3 = "audio/flac"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x0042
            goto L_0x0090
        L_0x0042:
            r2 = 7
            goto L_0x0090
        L_0x0044:
            java.lang.String r3 = "audio/eac3"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x004d
            goto L_0x0090
        L_0x004d:
            r2 = 6
            goto L_0x0090
        L_0x004f:
            java.lang.String r3 = "audio/raw"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x0058
            goto L_0x0090
        L_0x0058:
            r2 = 5
            goto L_0x0090
        L_0x005a:
            java.lang.String r3 = "audio/ac3"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x0063
            goto L_0x0090
        L_0x0063:
            r2 = 4
            goto L_0x0090
        L_0x0065:
            java.lang.String r3 = "audio/mp4a-latm"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x006e
            goto L_0x0090
        L_0x006e:
            r2 = 3
            goto L_0x0090
        L_0x0070:
            java.lang.String r3 = "audio/mpeg-L2"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x0079
            goto L_0x0090
        L_0x0079:
            r2 = 2
            goto L_0x0090
        L_0x007b:
            java.lang.String r3 = "audio/mpeg-L1"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x0084
            goto L_0x0090
        L_0x0084:
            r2 = 1
            goto L_0x0090
        L_0x0086:
            java.lang.String r3 = "audio/eac3-joc"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x008f
            goto L_0x0090
        L_0x008f:
            r2 = 0
        L_0x0090:
            switch(r2) {
                case 0: goto L_0x00aa;
                case 1: goto L_0x00aa;
                case 2: goto L_0x00aa;
                case 3: goto L_0x0094;
                case 4: goto L_0x00aa;
                case 5: goto L_0x00aa;
                case 6: goto L_0x00aa;
                case 7: goto L_0x00aa;
                case 8: goto L_0x00aa;
                case 9: goto L_0x00aa;
                case 10: goto L_0x00aa;
                default: goto L_0x0093;
            }
        L_0x0093:
            return r1
        L_0x0094:
            if (r5 != 0) goto L_0x0097
            return r1
        L_0x0097:
            androidx.media3.common.MimeTypes$Mp4aObjectType r4 = i(r5)
            if (r4 != 0) goto L_0x009e
            return r1
        L_0x009e:
            int r4 = r4.a()
            if (r4 == 0) goto L_0x00a9
            r5 = 16
            if (r4 == r5) goto L_0x00a9
            goto L_0x00aa
        L_0x00a9:
            r0 = 0
        L_0x00aa:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.MimeTypes.a(java.lang.String, java.lang.String):boolean");
    }

    @UnstableApi
    public static boolean b(@Nullable String str, String str2) {
        return d(str, str2) != null;
    }

    @UnstableApi
    @Nullable
    public static String c(@Nullable String str) {
        if (str == null) {
            return null;
        }
        for (String g2 : Util.r2(str)) {
            String g3 = g(g2);
            if (g3 != null && p(g3)) {
                return g3;
            }
        }
        return null;
    }

    @UnstableApi
    @Nullable
    public static String d(@Nullable String str, @Nullable String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        String[] r2 = Util.r2(str);
        StringBuilder sb = new StringBuilder();
        for (String str3 : r2) {
            if (str2.equals(g(str3))) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str3);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }

    @Nullable
    private static String e(String str) {
        int size = W0.size();
        for (int i2 = 0; i2 < size; i2++) {
            CustomMimeType customMimeType = W0.get(i2);
            if (str.startsWith(customMimeType.f9241b)) {
                return customMimeType.f9240a;
            }
        }
        return null;
    }

    @UnstableApi
    public static int f(String str, @Nullable String str2) {
        Mp4aObjectType i2;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals(S)) {
                    c2 = 0;
                    break;
                }
                break;
            case -1365340241:
                if (str.equals(X)) {
                    c2 = 1;
                    break;
                }
                break;
            case -1095064472:
                if (str.equals(V)) {
                    c2 = 2;
                    break;
                }
                break;
            case -53558318:
                if (str.equals(F)) {
                    c2 = 3;
                    break;
                }
                break;
            case 187078296:
                if (str.equals(Q)) {
                    c2 = 4;
                    break;
                }
                break;
            case 187078297:
                if (str.equals(T)) {
                    c2 = 5;
                    break;
                }
                break;
            case 550520934:
                if (str.equals(Y)) {
                    c2 = 6;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals(R)) {
                    c2 = 7;
                    break;
                }
                break;
            case 1504831518:
                if (str.equals(I)) {
                    c2 = 8;
                    break;
                }
                break;
            case 1504891608:
                if (str.equals(a0)) {
                    c2 = 9;
                    break;
                }
                break;
            case 1505942594:
                if (str.equals(W)) {
                    c2 = 10;
                    break;
                }
                break;
            case 1556697186:
                if (str.equals(U)) {
                    c2 = 11;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 18;
            case 1:
                return 8;
            case 2:
                return 7;
            case 3:
                if (str2 == null || (i2 = i(str2)) == null) {
                    return 0;
                }
                return i2.a();
            case 4:
                return 5;
            case 5:
                return 17;
            case 6:
                return 30;
            case 7:
                return 6;
            case 8:
                return 9;
            case 9:
                return 20;
            case 10:
                return 8;
            case 11:
                return 14;
            default:
                return 0;
        }
    }

    @UnstableApi
    @Nullable
    public static String g(@Nullable String str) {
        Mp4aObjectType i2;
        String str2 = null;
        if (str == null) {
            return null;
        }
        String g2 = Ascii.g(str.trim());
        if (g2.startsWith("avc1") || g2.startsWith("avc3")) {
            return f9235j;
        }
        if (g2.startsWith("hev1") || g2.startsWith("hvc1")) {
            return f9236k;
        }
        if (g2.startsWith("dvav") || g2.startsWith("dva1") || g2.startsWith("dvhe") || g2.startsWith("dvh1")) {
            return w;
        }
        if (g2.startsWith("av01")) {
            return f9239n;
        }
        if (g2.startsWith("vp9") || g2.startsWith("vp09")) {
            return f9238m;
        }
        if (g2.startsWith("vp8") || g2.startsWith("vp08")) {
            return f9237l;
        }
        if (g2.startsWith("mp4a")) {
            if (g2.startsWith("mp4a.") && (i2 = i(g2)) != null) {
                str2 = h(i2.f9243a);
            }
            return str2 == null ? F : str2;
        } else if (g2.startsWith("mha1")) {
            return L;
        } else {
            if (g2.startsWith("mhm1")) {
                return M;
            }
            if (g2.startsWith("ac-3") || g2.startsWith("dac3")) {
                return Q;
            }
            if (g2.startsWith("ec-3") || g2.startsWith("dec3")) {
                return R;
            }
            if (g2.startsWith(V0)) {
                return S;
            }
            if (g2.startsWith("ac-4") || g2.startsWith("dac4")) {
                return T;
            }
            if (g2.startsWith("dtsc")) {
                return V;
            }
            if (g2.startsWith("dtse")) {
                return X;
            }
            if (g2.startsWith("dtsh") || g2.startsWith("dtsl")) {
                return W;
            }
            if (g2.startsWith("dtsx")) {
                return Y;
            }
            if (g2.startsWith("opus")) {
                return a0;
            }
            if (g2.startsWith("vorbis")) {
                return Z;
            }
            if (g2.startsWith("flac")) {
                return e0;
            }
            if (g2.startsWith("stpp")) {
                return z0;
            }
            if (g2.startsWith("wvtt")) {
                return m0;
            }
            if (g2.contains("cea708")) {
                return x0;
            }
            return (g2.contains("eia608") || g2.contains("cea608")) ? w0 : e(g2);
        }
    }

    @UnstableApi
    @Nullable
    public static String h(int i2) {
        if (i2 == 32) {
            return p;
        }
        if (i2 == 33) {
            return f9235j;
        }
        if (i2 == 35) {
            return f9236k;
        }
        if (i2 == 64) {
            return F;
        }
        if (i2 == 163) {
            return t;
        }
        if (i2 == 177) {
            return f9238m;
        }
        if (i2 == 221) {
            return Z;
        }
        if (i2 == 165) {
            return Q;
        }
        if (i2 == 166) {
            return R;
        }
        switch (i2) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return s;
            case 102:
            case 103:
            case 104:
                return F;
            case 105:
            case 107:
                return I;
            case 106:
                return q;
            default:
                switch (i2) {
                    case 169:
                    case TsExtractor.N /*172*/:
                        return V;
                    case 170:
                    case 171:
                        return W;
                    case 173:
                        return a0;
                    case 174:
                        return T;
                    default:
                        return null;
                }
        }
    }

    @VisibleForTesting
    @Nullable
    static Mp4aObjectType i(String str) {
        Matcher matcher = X0.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String str2 = (String) Assertions.g(matcher.group(1));
        String group = matcher.group(2);
        try {
            return new Mp4aObjectType(Integer.parseInt(str2, 16), group != null ? Integer.parseInt(group) : 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @UnstableApi
    @Nullable
    public static String j(@Nullable String str) {
        if (str == null) {
            return null;
        }
        for (String g2 : Util.r2(str)) {
            String g3 = g(g2);
            if (g3 != null && s(g3)) {
                return g3;
            }
        }
        return null;
    }

    @UnstableApi
    @Nullable
    private static String k(@Nullable String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, indexOf);
    }

    @UnstableApi
    public static int l(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (p(str)) {
            return 1;
        }
        if (t(str)) {
            return 2;
        }
        if (s(str)) {
            return 3;
        }
        if (q(str)) {
            return 4;
        }
        if (v0.equals(str) || I0.equals(str) || G0.equals(str)) {
            return 5;
        }
        if (H0.equals(str)) {
            return 6;
        }
        return m(str);
    }

    private static int m(String str) {
        int size = W0.size();
        for (int i2 = 0; i2 < size; i2++) {
            CustomMimeType customMimeType = W0.get(i2);
            if (str.equals(customMimeType.f9240a)) {
                return customMimeType.f9242c;
            }
        }
        return -1;
    }

    @UnstableApi
    public static int n(String str) {
        return l(g(str));
    }

    @UnstableApi
    @Nullable
    public static String o(@Nullable String str) {
        if (str == null) {
            return null;
        }
        for (String g2 : Util.r2(str)) {
            String g3 = g(g2);
            if (g3 != null && t(g3)) {
                return g3;
            }
        }
        return null;
    }

    @UnstableApi
    public static boolean p(@Nullable String str) {
        return "audio".equals(k(str));
    }

    @UnstableApi
    public static boolean q(@Nullable String str) {
        return "image".equals(k(str)) || P0.equals(str);
    }

    @UnstableApi
    public static boolean r(@Nullable String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith(f9233h) || str.startsWith(H) || str.startsWith(q0) || str.startsWith(f9232g) || str.startsWith(G) || str.startsWith(r0);
    }

    @UnstableApi
    @Pure
    public static boolean s(@Nullable String str) {
        return "text".equals(k(str)) || O0.equals(str) || w0.equals(str) || x0.equals(str) || C0.equals(str) || y0.equals(str) || z0.equals(str) || A0.equals(str) || B0.equals(str) || D0.equals(str) || E0.equals(str) || F0.equals(str) || J0.equals(str);
    }

    @UnstableApi
    public static boolean t(@Nullable String str) {
        return "video".equals(k(str));
    }

    @UnstableApi
    public static String u(String str) {
        if (str == null) {
            return null;
        }
        String g2 = Ascii.g(str);
        g2.hashCode();
        char c2 = 65535;
        switch (g2.hashCode()) {
            case -1007807498:
                if (g2.equals("audio/x-flac")) {
                    c2 = 0;
                    break;
                }
                break;
            case -979095690:
                if (g2.equals("application/x-mpegurl")) {
                    c2 = 1;
                    break;
                }
                break;
            case -586683234:
                if (g2.equals("audio/x-wav")) {
                    c2 = 2;
                    break;
                }
                break;
            case -432836268:
                if (g2.equals("audio/mpeg-l1")) {
                    c2 = 3;
                    break;
                }
                break;
            case -432836267:
                if (g2.equals("audio/mpeg-l2")) {
                    c2 = 4;
                    break;
                }
                break;
            case 187090231:
                if (g2.equals("audio/mp3")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return e0;
            case 1:
                return t0;
            case 2:
                return i0;
            case 3:
                return J;
            case 4:
                return K;
            case 5:
                return I;
            default:
                return g2;
        }
    }

    @UnstableApi
    public static void v(String str, String str2, int i2) {
        CustomMimeType customMimeType = new CustomMimeType(str, str2, i2);
        int size = W0.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            ArrayList<CustomMimeType> arrayList = W0;
            if (str.equals(arrayList.get(i3).f9240a)) {
                arrayList.remove(i3);
                break;
            }
            i3++;
        }
        W0.add(customMimeType);
    }
}
