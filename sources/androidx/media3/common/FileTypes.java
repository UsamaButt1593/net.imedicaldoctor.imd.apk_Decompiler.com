package androidx.media3.common;

import android.net.Uri;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Map;

@UnstableApi
public final class FileTypes {
    private static final String A = ".adts";
    private static final String B = ".aac";
    private static final String C = ".amr";
    private static final String D = ".flac";
    private static final String E = ".flv";
    private static final String F = ".mid";
    private static final String G = ".midi";
    private static final String H = ".smf";
    private static final String I = ".mk";
    private static final String J = ".webm";
    private static final String K = ".og";
    private static final String L = ".opus";
    private static final String M = ".mp3";
    private static final String N = ".mp4";
    private static final String O = ".m4";
    private static final String P = ".mp4";
    private static final String Q = ".cmf";
    private static final String R = ".ps";
    private static final String S = ".mpeg";
    private static final String T = ".mpg";
    private static final String U = ".m2p";
    private static final String V = ".ts";
    private static final String W = ".ts";
    private static final String X = ".wav";
    private static final String Y = ".wave";
    private static final String Z = ".vtt";

    /* renamed from: a  reason: collision with root package name */
    public static final int f9108a = -1;
    private static final String a0 = ".webvtt";

    /* renamed from: b  reason: collision with root package name */
    public static final int f9109b = 0;
    private static final String b0 = ".jpg";

    /* renamed from: c  reason: collision with root package name */
    public static final int f9110c = 1;
    private static final String c0 = ".jpeg";

    /* renamed from: d  reason: collision with root package name */
    public static final int f9111d = 2;
    private static final String d0 = ".avi";

    /* renamed from: e  reason: collision with root package name */
    public static final int f9112e = 3;
    private static final String e0 = ".png";

    /* renamed from: f  reason: collision with root package name */
    public static final int f9113f = 4;
    private static final String f0 = ".webp";

    /* renamed from: g  reason: collision with root package name */
    public static final int f9114g = 5;
    private static final String g0 = ".bmp";

    /* renamed from: h  reason: collision with root package name */
    public static final int f9115h = 6;
    private static final String h0 = ".dib";

    /* renamed from: i  reason: collision with root package name */
    public static final int f9116i = 7;
    private static final String i0 = ".heic";

    /* renamed from: j  reason: collision with root package name */
    public static final int f9117j = 8;

    /* renamed from: k  reason: collision with root package name */
    public static final int f9118k = 9;

    /* renamed from: l  reason: collision with root package name */
    public static final int f9119l = 10;

    /* renamed from: m  reason: collision with root package name */
    public static final int f9120m = 11;

    /* renamed from: n  reason: collision with root package name */
    public static final int f9121n = 12;
    public static final int o = 13;
    public static final int p = 14;
    public static final int q = 15;
    public static final int r = 16;
    public static final int s = 17;
    public static final int t = 18;
    public static final int u = 19;
    public static final int v = 20;
    @VisibleForTesting
    static final String w = "Content-Type";
    private static final String x = ".ac3";
    private static final String y = ".ec3";
    private static final String z = ".ac4";

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    private FileTypes() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(@androidx.annotation.Nullable java.lang.String r22) {
        /*
            r0 = 20
            r1 = 19
            r2 = 18
            r3 = 17
            r4 = 16
            r5 = 15
            r6 = 14
            r7 = 13
            r8 = 12
            r11 = 9
            r12 = 8
            r13 = 7
            r14 = 6
            r15 = 5
            r16 = 4
            r17 = 3
            r18 = 1
            r19 = 0
            r20 = -1
            if (r22 != 0) goto L_0x0026
            return r20
        L_0x0026:
            java.lang.String r10 = androidx.media3.common.MimeTypes.u(r22)
            r10.hashCode()
            int r21 = r10.hashCode()
            switch(r21) {
                case -2123537834: goto L_0x01b6;
                case -1662384011: goto L_0x01aa;
                case -1662384007: goto L_0x019e;
                case -1662095187: goto L_0x0192;
                case -1606874997: goto L_0x0186;
                case -1487464690: goto L_0x017a;
                case -1487394660: goto L_0x016e;
                case -1487018032: goto L_0x0162;
                case -1248337486: goto L_0x0154;
                case -1079884372: goto L_0x0146;
                case -1004728940: goto L_0x0138;
                case -879272239: goto L_0x012a;
                case -879258763: goto L_0x011c;
                case -387023398: goto L_0x010e;
                case -43467528: goto L_0x0100;
                case 13915911: goto L_0x00f2;
                case 187078296: goto L_0x00e4;
                case 187078297: goto L_0x00d6;
                case 187078669: goto L_0x00c8;
                case 187090232: goto L_0x00ba;
                case 187091926: goto L_0x00ac;
                case 187099443: goto L_0x009f;
                case 1331848029: goto L_0x0092;
                case 1503095341: goto L_0x0085;
                case 1504578661: goto L_0x0078;
                case 1504619009: goto L_0x006b;
                case 1504824762: goto L_0x005e;
                case 1504831518: goto L_0x0051;
                case 1505118770: goto L_0x0044;
                case 2039520277: goto L_0x0037;
                default: goto L_0x0034;
            }
        L_0x0034:
            r9 = -1
            goto L_0x01c1
        L_0x0037:
            java.lang.String r9 = "video/x-matroska"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x0040
            goto L_0x0034
        L_0x0040:
            r9 = 29
            goto L_0x01c1
        L_0x0044:
            java.lang.String r9 = "audio/webm"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x004d
            goto L_0x0034
        L_0x004d:
            r9 = 28
            goto L_0x01c1
        L_0x0051:
            java.lang.String r9 = "audio/mpeg"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x005a
            goto L_0x0034
        L_0x005a:
            r9 = 27
            goto L_0x01c1
        L_0x005e:
            java.lang.String r9 = "audio/midi"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x0067
            goto L_0x0034
        L_0x0067:
            r9 = 26
            goto L_0x01c1
        L_0x006b:
            java.lang.String r9 = "audio/flac"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x0074
            goto L_0x0034
        L_0x0074:
            r9 = 25
            goto L_0x01c1
        L_0x0078:
            java.lang.String r9 = "audio/eac3"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x0081
            goto L_0x0034
        L_0x0081:
            r9 = 24
            goto L_0x01c1
        L_0x0085:
            java.lang.String r9 = "audio/3gpp"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x008e
            goto L_0x0034
        L_0x008e:
            r9 = 23
            goto L_0x01c1
        L_0x0092:
            java.lang.String r9 = "video/mp4"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x009b
            goto L_0x0034
        L_0x009b:
            r9 = 22
            goto L_0x01c1
        L_0x009f:
            java.lang.String r9 = "audio/wav"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x00a8
            goto L_0x0034
        L_0x00a8:
            r9 = 21
            goto L_0x01c1
        L_0x00ac:
            java.lang.String r9 = "audio/ogg"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x00b6
            goto L_0x0034
        L_0x00b6:
            r9 = 20
            goto L_0x01c1
        L_0x00ba:
            java.lang.String r9 = "audio/mp4"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x00c4
            goto L_0x0034
        L_0x00c4:
            r9 = 19
            goto L_0x01c1
        L_0x00c8:
            java.lang.String r9 = "audio/amr"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x00d2
            goto L_0x0034
        L_0x00d2:
            r9 = 18
            goto L_0x01c1
        L_0x00d6:
            java.lang.String r9 = "audio/ac4"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x00e0
            goto L_0x0034
        L_0x00e0:
            r9 = 17
            goto L_0x01c1
        L_0x00e4:
            java.lang.String r9 = "audio/ac3"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x00ee
            goto L_0x0034
        L_0x00ee:
            r9 = 16
            goto L_0x01c1
        L_0x00f2:
            java.lang.String r9 = "video/x-flv"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x00fc
            goto L_0x0034
        L_0x00fc:
            r9 = 15
            goto L_0x01c1
        L_0x0100:
            java.lang.String r9 = "application/webm"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x010a
            goto L_0x0034
        L_0x010a:
            r9 = 14
            goto L_0x01c1
        L_0x010e:
            java.lang.String r9 = "audio/x-matroska"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x0118
            goto L_0x0034
        L_0x0118:
            r9 = 13
            goto L_0x01c1
        L_0x011c:
            java.lang.String r9 = "image/png"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x0126
            goto L_0x0034
        L_0x0126:
            r9 = 12
            goto L_0x01c1
        L_0x012a:
            java.lang.String r9 = "image/bmp"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x0134
            goto L_0x0034
        L_0x0134:
            r9 = 11
            goto L_0x01c1
        L_0x0138:
            java.lang.String r9 = "text/vtt"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x0142
            goto L_0x0034
        L_0x0142:
            r9 = 10
            goto L_0x01c1
        L_0x0146:
            java.lang.String r9 = "video/x-msvideo"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x0150
            goto L_0x0034
        L_0x0150:
            r9 = 9
            goto L_0x01c1
        L_0x0154:
            java.lang.String r9 = "application/mp4"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x015e
            goto L_0x0034
        L_0x015e:
            r9 = 8
            goto L_0x01c1
        L_0x0162:
            java.lang.String r9 = "image/webp"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x016c
            goto L_0x0034
        L_0x016c:
            r9 = 7
            goto L_0x01c1
        L_0x016e:
            java.lang.String r9 = "image/jpeg"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x0178
            goto L_0x0034
        L_0x0178:
            r9 = 6
            goto L_0x01c1
        L_0x017a:
            java.lang.String r9 = "image/heif"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x0184
            goto L_0x0034
        L_0x0184:
            r9 = 5
            goto L_0x01c1
        L_0x0186:
            java.lang.String r9 = "audio/amr-wb"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x0190
            goto L_0x0034
        L_0x0190:
            r9 = 4
            goto L_0x01c1
        L_0x0192:
            java.lang.String r9 = "video/webm"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x019c
            goto L_0x0034
        L_0x019c:
            r9 = 3
            goto L_0x01c1
        L_0x019e:
            java.lang.String r9 = "video/mp2t"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x01a8
            goto L_0x0034
        L_0x01a8:
            r9 = 2
            goto L_0x01c1
        L_0x01aa:
            java.lang.String r9 = "video/mp2p"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x01b4
            goto L_0x0034
        L_0x01b4:
            r9 = 1
            goto L_0x01c1
        L_0x01b6:
            java.lang.String r9 = "audio/eac3-joc"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x01c0
            goto L_0x0034
        L_0x01c0:
            r9 = 0
        L_0x01c1:
            switch(r9) {
                case 0: goto L_0x01dc;
                case 1: goto L_0x01d9;
                case 2: goto L_0x01d6;
                case 3: goto L_0x01d5;
                case 4: goto L_0x01d4;
                case 5: goto L_0x01d3;
                case 6: goto L_0x01d2;
                case 7: goto L_0x01d1;
                case 8: goto L_0x01d0;
                case 9: goto L_0x01cf;
                case 10: goto L_0x01ce;
                case 11: goto L_0x01cd;
                case 12: goto L_0x01cc;
                case 13: goto L_0x01d5;
                case 14: goto L_0x01d5;
                case 15: goto L_0x01cb;
                case 16: goto L_0x01dc;
                case 17: goto L_0x01ca;
                case 18: goto L_0x01d4;
                case 19: goto L_0x01d0;
                case 20: goto L_0x01c9;
                case 21: goto L_0x01c8;
                case 22: goto L_0x01d0;
                case 23: goto L_0x01d4;
                case 24: goto L_0x01dc;
                case 25: goto L_0x01c7;
                case 26: goto L_0x01c6;
                case 27: goto L_0x01c5;
                case 28: goto L_0x01d5;
                case 29: goto L_0x01d5;
                default: goto L_0x01c4;
            }
        L_0x01c4:
            return r20
        L_0x01c5:
            return r13
        L_0x01c6:
            return r5
        L_0x01c7:
            return r16
        L_0x01c8:
            return r8
        L_0x01c9:
            return r11
        L_0x01ca:
            return r18
        L_0x01cb:
            return r15
        L_0x01cc:
            return r3
        L_0x01cd:
            return r1
        L_0x01ce:
            return r7
        L_0x01cf:
            return r4
        L_0x01d0:
            return r12
        L_0x01d1:
            return r2
        L_0x01d2:
            return r6
        L_0x01d3:
            return r0
        L_0x01d4:
            return r17
        L_0x01d5:
            return r14
        L_0x01d6:
            r0 = 11
            return r0
        L_0x01d9:
            r0 = 10
            return r0
        L_0x01dc:
            return r19
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.FileTypes.a(java.lang.String):int");
    }

    public static int b(Map<String, List<String>> map) {
        List list = map.get("Content-Type");
        return a((list == null || list.isEmpty()) ? null : (String) list.get(0));
    }

    public static int c(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(x) || lastPathSegment.endsWith(y)) {
            return 0;
        }
        if (lastPathSegment.endsWith(z)) {
            return 1;
        }
        if (lastPathSegment.endsWith(A) || lastPathSegment.endsWith(B)) {
            return 2;
        }
        if (lastPathSegment.endsWith(C)) {
            return 3;
        }
        if (lastPathSegment.endsWith(D)) {
            return 4;
        }
        if (lastPathSegment.endsWith(E)) {
            return 5;
        }
        if (lastPathSegment.endsWith(F) || lastPathSegment.endsWith(G) || lastPathSegment.endsWith(H)) {
            return 15;
        }
        if (lastPathSegment.startsWith(I, lastPathSegment.length() - 4) || lastPathSegment.endsWith(J)) {
            return 6;
        }
        if (lastPathSegment.endsWith(M)) {
            return 7;
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(O, lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(Q, lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(K, lastPathSegment.length() - 4) || lastPathSegment.endsWith(L)) {
            return 9;
        }
        if (lastPathSegment.endsWith(R) || lastPathSegment.endsWith(S) || lastPathSegment.endsWith(T) || lastPathSegment.endsWith(U)) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(X) || lastPathSegment.endsWith(Y)) {
            return 12;
        }
        if (lastPathSegment.endsWith(Z) || lastPathSegment.endsWith(a0)) {
            return 13;
        }
        if (lastPathSegment.endsWith(b0) || lastPathSegment.endsWith(c0)) {
            return 14;
        }
        if (lastPathSegment.endsWith(d0)) {
            return 16;
        }
        if (lastPathSegment.endsWith(e0)) {
            return 17;
        }
        if (lastPathSegment.endsWith(f0)) {
            return 18;
        }
        if (lastPathSegment.endsWith(g0) || lastPathSegment.endsWith(h0)) {
            return 19;
        }
        return lastPathSegment.endsWith(i0) ? 20 : -1;
    }
}
