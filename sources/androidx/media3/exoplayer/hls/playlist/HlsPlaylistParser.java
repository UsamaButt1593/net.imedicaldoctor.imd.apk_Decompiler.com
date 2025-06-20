package androidx.media3.exoplayer.hls.playlist;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import androidx.media3.extractor.mp4.PsshAtomUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

@UnstableApi
public final class HlsPlaylistParser implements ParsingLoadable.Parser<HlsPlaylist> {
    private static final String A = "#EXT-X-SESSION-KEY";
    private static final Pattern A0 = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    private static final String B = "#EXT-X-BYTERANGE";
    private static final Pattern B0 = Pattern.compile("BYTERANGE-START=(\\d+)\\b");
    private static final String C = "#EXT-X-GAP";
    private static final Pattern C0 = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");
    private static final String D = "#EXT-X-SKIP";
    private static final Pattern D0 = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    private static final String E = "#EXT-X-PRELOAD-HINT";
    private static final Pattern E0 = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    private static final String F = "#EXT-X-RENDITION-REPORT";
    private static final Pattern F0 = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    private static final String G = "AUDIO";
    private static final Pattern G0 = Pattern.compile("URI=\"(.+?)\"");
    private static final String H = "VIDEO";
    private static final Pattern H0 = Pattern.compile("IV=([^,.*]+)");
    private static final String I = "SUBTITLES";
    private static final Pattern I0 = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final String J = "CLOSED-CAPTIONS";
    private static final Pattern J0 = Pattern.compile("TYPE=(PART|MAP)");
    private static final String K = "PART";
    private static final Pattern K0 = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final String L = "MAP";
    private static final Pattern L0 = Pattern.compile("NAME=\"(.+?)\"");
    private static final String M = "NONE";
    private static final Pattern M0 = Pattern.compile("GROUP-ID=\"(.+?)\"");
    private static final String N = "AES-128";
    private static final Pattern N0 = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
    private static final String O = "SAMPLE-AES";
    private static final Pattern O0 = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    private static final String P = "SAMPLE-AES-CENC";
    private static final Pattern P0 = c("AUTOSELECT");
    private static final String Q = "SAMPLE-AES-CTR";
    private static final Pattern Q0 = c("DEFAULT");
    private static final String R = "com.microsoft.playready";
    private static final Pattern R0 = c("FORCED");
    private static final String S = "identity";
    private static final Pattern S0 = c("INDEPENDENT");
    private static final String T = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed";
    private static final Pattern T0 = c("GAP");
    private static final String U = "com.widevine";
    private static final Pattern U0 = c("PRECISE");
    private static final String V = "YES";
    private static final Pattern V0 = Pattern.compile("VALUE=\"(.+?)\"");
    private static final String W = "NO";
    private static final Pattern W0 = Pattern.compile("IMPORT=\"(.+?)\"");
    private static final String X = "CLOSED-CAPTIONS=NONE";
    private static final Pattern X0 = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");
    private static final Pattern Y = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    private static final Pattern Z = Pattern.compile("VIDEO=\"(.+?)\"");
    private static final Pattern a0 = Pattern.compile("AUDIO=\"(.+?)\"");
    private static final Pattern b0 = Pattern.compile("SUBTITLES=\"(.+?)\"");

    /* renamed from: c  reason: collision with root package name */
    private static final String f11600c = "HlsPlaylistParser";
    private static final Pattern c0 = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");

    /* renamed from: d  reason: collision with root package name */
    private static final String f11601d = "#EXTM3U";
    private static final Pattern d0 = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");

    /* renamed from: e  reason: collision with root package name */
    private static final String f11602e = "#EXT";
    private static final Pattern e0 = Pattern.compile("CHANNELS=\"(.+?)\"");

    /* renamed from: f  reason: collision with root package name */
    private static final String f11603f = "#EXT-X-VERSION";
    private static final Pattern f0 = Pattern.compile("CODECS=\"(.+?)\"");

    /* renamed from: g  reason: collision with root package name */
    private static final String f11604g = "#EXT-X-PLAYLIST-TYPE";
    private static final Pattern g0 = Pattern.compile("RESOLUTION=(\\d+x\\d+)");

    /* renamed from: h  reason: collision with root package name */
    private static final String f11605h = "#EXT-X-DEFINE";
    private static final Pattern h0 = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");

    /* renamed from: i  reason: collision with root package name */
    private static final String f11606i = "#EXT-X-SERVER-CONTROL";
    private static final Pattern i0 = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");

    /* renamed from: j  reason: collision with root package name */
    private static final String f11607j = "#EXT-X-STREAM-INF";
    private static final Pattern j0 = Pattern.compile("DURATION=([\\d\\.]+)\\b");

    /* renamed from: k  reason: collision with root package name */
    private static final String f11608k = "#EXT-X-PART-INF";
    private static final Pattern k0 = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");

    /* renamed from: l  reason: collision with root package name */
    private static final String f11609l = "#EXT-X-PART";
    private static final Pattern l0 = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");

    /* renamed from: m  reason: collision with root package name */
    private static final String f11610m = "#EXT-X-I-FRAME-STREAM-INF";
    private static final Pattern m0 = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");

    /* renamed from: n  reason: collision with root package name */
    private static final String f11611n = "#EXT-X-I-FRAMES-ONLY";
    private static final Pattern n0 = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");
    private static final String o = "#EXT-X-MEDIA";
    private static final Pattern o0 = c("CAN-SKIP-DATERANGES");
    private static final String p = "#EXT-X-TARGETDURATION";
    private static final Pattern p0 = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");
    private static final String q = "#EXT-X-DISCONTINUITY";
    private static final Pattern q0 = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");
    private static final String r = "#EXT-X-DISCONTINUITY-SEQUENCE";
    private static final Pattern r0 = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");
    private static final String s = "#EXT-X-PROGRAM-DATE-TIME";
    private static final Pattern s0 = c("CAN-BLOCK-RELOAD");
    private static final String t = "#EXT-X-MAP";
    private static final Pattern t0 = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    private static final String u = "#EXT-X-INDEPENDENT-SEGMENTS";
    private static final Pattern u0 = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    private static final String v = "#EXTINF";
    private static final Pattern v0 = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
    private static final String w = "#EXT-X-MEDIA-SEQUENCE";
    private static final Pattern w0 = Pattern.compile("LAST-MSN=(\\d+)\\b");
    private static final String x = "#EXT-X-START";
    private static final Pattern x0 = Pattern.compile("LAST-PART=(\\d+)\\b");
    private static final String y = "#EXT-X-ENDLIST";
    private static final Pattern y0 = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    private static final String z = "#EXT-X-KEY";
    private static final Pattern z0 = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");

    /* renamed from: a  reason: collision with root package name */
    private final HlsMultivariantPlaylist f11612a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final HlsMediaPlaylist f11613b;

    public static final class DeltaUpdateException extends IOException {
    }

    private static class LineIterator {

        /* renamed from: a  reason: collision with root package name */
        private final BufferedReader f11614a;

        /* renamed from: b  reason: collision with root package name */
        private final Queue<String> f11615b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private String f11616c;

        public LineIterator(Queue<String> queue, BufferedReader bufferedReader) {
            this.f11615b = queue;
            this.f11614a = bufferedReader;
        }

        @EnsuresNonNullIf(expression = {"next"}, result = true)
        public boolean a() throws IOException {
            String trim;
            if (this.f11616c != null) {
                return true;
            }
            if (!this.f11615b.isEmpty()) {
                this.f11616c = (String) Assertions.g(this.f11615b.poll());
                return true;
            }
            do {
                String readLine = this.f11614a.readLine();
                this.f11616c = readLine;
                if (readLine == null) {
                    return false;
                }
                trim = readLine.trim();
                this.f11616c = trim;
            } while (trim.isEmpty());
            return true;
        }

        public String b() throws IOException {
            if (a()) {
                String str = this.f11616c;
                this.f11616c = null;
                return str;
            }
            throw new NoSuchElementException();
        }
    }

    public HlsPlaylistParser() {
        this(HlsMultivariantPlaylist.f11576n, (HlsMediaPlaylist) null);
    }

    private static long A(String str, Pattern pattern) throws ParserException {
        return new BigDecimal(z(str, pattern, Collections.emptyMap())).multiply(new BigDecimal(1000000)).longValue();
    }

    private static String B(String str, Map<String, String> map) {
        Matcher matcher = X0.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String group = matcher.group(1);
            if (map.containsKey(group)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(map.get(group)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private static int C(BufferedReader bufferedReader, boolean z2, int i2) throws IOException {
        while (i2 != -1 && Character.isWhitespace(i2) && (z2 || !Util.k1(i2))) {
            i2 = bufferedReader.read();
        }
        return i2;
    }

    private static boolean b(BufferedReader bufferedReader) throws IOException {
        int read = bufferedReader.read();
        if (read == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            read = bufferedReader.read();
        }
        int C2 = C(bufferedReader, true, read);
        for (int i2 = 0; i2 < 7; i2++) {
            if (C2 != f11601d.charAt(i2)) {
                return false;
            }
            C2 = bufferedReader.read();
        }
        return Util.k1(C(bufferedReader, false, C2));
    }

    private static Pattern c(String str) {
        return Pattern.compile(str + "=(" + W + "|" + V + ")");
    }

    private static DrmInitData d(@Nullable String str, DrmInitData.SchemeData[] schemeDataArr) {
        DrmInitData.SchemeData[] schemeDataArr2 = new DrmInitData.SchemeData[schemeDataArr.length];
        for (int i2 = 0; i2 < schemeDataArr.length; i2++) {
            schemeDataArr2[i2] = schemeDataArr[i2].b((byte[]) null);
        }
        return new DrmInitData(str, schemeDataArr2);
    }

    @Nullable
    private static String e(long j2, @Nullable String str, @Nullable String str2) {
        if (str == null) {
            return null;
        }
        return str2 != null ? str2 : Long.toHexString(j2);
    }

    @Nullable
    private static HlsMultivariantPlaylist.Variant f(ArrayList<HlsMultivariantPlaylist.Variant> arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            HlsMultivariantPlaylist.Variant variant = arrayList.get(i2);
            if (str.equals(variant.f11594d)) {
                return variant;
            }
        }
        return null;
    }

    @Nullable
    private static HlsMultivariantPlaylist.Variant g(ArrayList<HlsMultivariantPlaylist.Variant> arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            HlsMultivariantPlaylist.Variant variant = arrayList.get(i2);
            if (str.equals(variant.f11595e)) {
                return variant;
            }
        }
        return null;
    }

    @Nullable
    private static HlsMultivariantPlaylist.Variant h(ArrayList<HlsMultivariantPlaylist.Variant> arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            HlsMultivariantPlaylist.Variant variant = arrayList.get(i2);
            if (str.equals(variant.f11593c)) {
                return variant;
            }
        }
        return null;
    }

    private static double j(String str, Pattern pattern) throws ParserException {
        return Double.parseDouble(z(str, pattern, Collections.emptyMap()));
    }

    @Nullable
    private static DrmInitData.SchemeData k(String str, String str2, Map<String, String> map) throws ParserException {
        String u2 = u(str, F0, IcyHeaders.a3, map);
        if (T.equals(str2)) {
            String z2 = z(str, G0, map);
            return new DrmInitData.SchemeData(C.k2, MimeTypes.f9231f, Base64.decode(z2.substring(z2.indexOf(44)), 0));
        } else if (U.equals(str2)) {
            return new DrmInitData.SchemeData(C.k2, "hls", Util.R0(str));
        } else {
            if (!R.equals(str2) || !IcyHeaders.a3.equals(u2)) {
                return null;
            }
            String z3 = z(str, G0, map);
            byte[] decode = Base64.decode(z3.substring(z3.indexOf(44)), 0);
            UUID uuid = C.l2;
            return new DrmInitData.SchemeData(uuid, MimeTypes.f9231f, PsshAtomUtil.a(uuid, decode));
        }
    }

    private static String l(String str) {
        return (P.equals(str) || Q.equals(str)) ? C.d2 : C.g2;
    }

    private static int m(String str, Pattern pattern) throws ParserException {
        return Integer.parseInt(z(str, pattern, Collections.emptyMap()));
    }

    private static long n(String str, Pattern pattern) throws ParserException {
        return Long.parseLong(z(str, pattern, Collections.emptyMap()));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r65v0, resolved type: androidx.media3.common.DrmInitData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r65v1, resolved type: androidx.media3.common.DrmInitData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r50v16, resolved type: java.lang.Object} */
    /* JADX WARNING: type inference failed for: r10v0 */
    /* JADX WARNING: type inference failed for: r10v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r13v4 */
    /* JADX WARNING: type inference failed for: r10v49 */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01c6, code lost:
        if (r12 != null) goto L_0x01d5;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist o(androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist r92, @androidx.annotation.Nullable androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist r93, androidx.media3.exoplayer.hls.playlist.HlsPlaylistParser.LineIterator r94, java.lang.String r95) throws java.io.IOException {
        /*
            r0 = r92
            r1 = r93
            boolean r2 = r0.f11599c
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$ServerControl r7 = new androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$ServerControl
            r22 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r24 = 0
            r17 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r19 = 0
            r20 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r16 = r7
            r16.<init>(r17, r19, r20, r22, r24)
            java.util.TreeMap r9 = new java.util.TreeMap
            r9.<init>()
            r10 = 0
            java.lang.String r13 = ""
            r20 = r13
            r35 = r2
            r56 = r7
            r41 = r20
            r2 = 0
            r14 = 0
            r21 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r23 = 0
            r24 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r30 = 1
            r31 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r33 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r36 = 0
            r37 = 0
            r39 = 0
            r50 = 0
            r51 = 0
            r54 = 0
            r75 = -1
            r77 = 0
            r78 = 0
            r79 = 0
            r80 = 0
            r82 = 0
            r84 = 0
            r85 = 0
            r86 = 0
            r88 = 0
            r7 = r5
            r5 = 0
        L_0x008d:
            boolean r42 = r94.a()
            if (r42 == 0) goto L_0x0643
            java.lang.String r13 = r94.b()
            java.lang.String r12 = "#EXT"
            boolean r12 = r13.startsWith(r12)
            if (r12 == 0) goto L_0x00a2
            r8.add(r13)
        L_0x00a2:
            java.lang.String r12 = "#EXT-X-PLAYLIST-TYPE"
            boolean r12 = r13.startsWith(r12)
            if (r12 == 0) goto L_0x00c4
            java.util.regex.Pattern r12 = m0
            java.lang.String r12 = z(r13, r12, r3)
            java.lang.String r13 = "VOD"
            boolean r13 = r13.equals(r12)
            if (r13 == 0) goto L_0x00ba
            r2 = 1
            goto L_0x008d
        L_0x00ba:
            java.lang.String r13 = "EVENT"
            boolean r12 = r13.equals(r12)
            if (r12 == 0) goto L_0x008d
            r2 = 2
            goto L_0x008d
        L_0x00c4:
            java.lang.String r12 = "#EXT-X-I-FRAMES-ONLY"
            boolean r12 = r13.equals(r12)
            if (r12 == 0) goto L_0x00cf
            r84 = 1
            goto L_0x008d
        L_0x00cf:
            java.lang.String r12 = "#EXT-X-START"
            boolean r12 = r13.startsWith(r12)
            r43 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            if (r12 == 0) goto L_0x00ee
            java.util.regex.Pattern r12 = y0
            double r21 = j(r13, r12)
            double r11 = r21 * r43
            long r11 = (long) r11
            r21 = r11
            java.util.regex.Pattern r11 = U0
            boolean r23 = q(r13, r11, r10)
            goto L_0x008d
        L_0x00ee:
            java.lang.String r11 = "#EXT-X-SERVER-CONTROL"
            boolean r11 = r13.startsWith(r11)
            if (r11 == 0) goto L_0x00fb
            androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$ServerControl r56 = y(r13)
            goto L_0x008d
        L_0x00fb:
            java.lang.String r11 = "#EXT-X-PART-INF"
            boolean r11 = r13.startsWith(r11)
            if (r11 == 0) goto L_0x0110
            java.util.regex.Pattern r11 = k0
            double r11 = j(r13, r11)
            double r11 = r11 * r43
            long r11 = (long) r11
            r33 = r11
            goto L_0x008d
        L_0x0110:
            java.lang.String r11 = "#EXT-X-MAP"
            boolean r11 = r13.startsWith(r11)
            java.lang.String r12 = "@"
            if (r11 == 0) goto L_0x016f
            java.util.regex.Pattern r11 = G0
            java.lang.String r43 = z(r13, r11, r3)
            java.util.regex.Pattern r11 = A0
            java.lang.String r11 = v(r13, r11, r3)
            if (r11 == 0) goto L_0x013e
            java.lang.String[] r11 = androidx.media3.common.util.Util.p2(r11, r12)
            r12 = r11[r10]
            long r75 = java.lang.Long.parseLong(r12)
            int r12 = r11.length
            r13 = 1
            if (r12 <= r13) goto L_0x013e
            r11 = r11[r13]
            long r11 = java.lang.Long.parseLong(r11)
            r39 = r11
        L_0x013e:
            r11 = -1
            int r13 = (r75 > r11 ? 1 : (r75 == r11 ? 0 : -1))
            if (r13 != 0) goto L_0x0146
            r39 = 0
        L_0x0146:
            r11 = r77
            if (r14 == 0) goto L_0x014c
            if (r11 == 0) goto L_0x014e
        L_0x014c:
            r12 = 0
            goto L_0x0156
        L_0x014e:
            java.lang.String r0 = "The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128."
            r12 = 0
            androidx.media3.common.ParserException r0 = androidx.media3.common.ParserException.c(r0, r12)
            throw r0
        L_0x0156:
            androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$Segment r85 = new androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$Segment
            r42 = r85
            r44 = r39
            r46 = r75
            r48 = r14
            r49 = r11
            r42.<init>(r43, r44, r46, r48, r49)
            if (r13 == 0) goto L_0x0169
            long r39 = r39 + r75
        L_0x0169:
            r77 = r11
            r75 = -1
            goto L_0x008d
        L_0x016f:
            r11 = r77
            r77 = 0
            java.lang.String r10 = "#EXT-X-TARGETDURATION"
            boolean r10 = r13.startsWith(r10)
            if (r10 == 0) goto L_0x018c
            java.util.regex.Pattern r10 = i0
            int r10 = m(r13, r10)
            long r12 = (long) r10
            r31 = 1000000(0xf4240, double:4.940656E-318)
            long r31 = r31 * r12
        L_0x0187:
            r77 = r11
        L_0x0189:
            r10 = 0
            goto L_0x008d
        L_0x018c:
            java.lang.String r10 = "#EXT-X-MEDIA-SEQUENCE"
            boolean r10 = r13.startsWith(r10)
            if (r10 == 0) goto L_0x019f
            java.util.regex.Pattern r10 = t0
            long r82 = n(r13, r10)
            r77 = r11
            r28 = r82
            goto L_0x0189
        L_0x019f:
            java.lang.String r10 = "#EXT-X-VERSION"
            boolean r10 = r13.startsWith(r10)
            if (r10 == 0) goto L_0x01ae
            java.util.regex.Pattern r10 = l0
            int r30 = m(r13, r10)
            goto L_0x0187
        L_0x01ae:
            java.lang.String r10 = "#EXT-X-DEFINE"
            boolean r10 = r13.startsWith(r10)
            if (r10 == 0) goto L_0x01e6
            java.util.regex.Pattern r10 = W0
            java.lang.String r10 = v(r13, r10, r3)
            if (r10 == 0) goto L_0x01c9
            java.util.Map<java.lang.String, java.lang.String> r12 = r0.f11585l
            java.lang.Object r12 = r12.get(r10)
            java.lang.String r12 = (java.lang.String) r12
            if (r12 == 0) goto L_0x01d8
            goto L_0x01d5
        L_0x01c9:
            java.util.regex.Pattern r10 = L0
            java.lang.String r10 = z(r13, r10, r3)
            java.util.regex.Pattern r12 = V0
            java.lang.String r12 = z(r13, r12, r3)
        L_0x01d5:
            r3.put(r10, r12)
        L_0x01d8:
            r12 = r7
            r91 = r8
            r10 = r78
            r7 = r82
            r1 = 0
            r78 = r2
        L_0x01e2:
            r82 = r5
            goto L_0x0576
        L_0x01e6:
            java.lang.String r10 = "#EXTINF"
            boolean r10 = r13.startsWith(r10)
            if (r10 == 0) goto L_0x01fd
            java.util.regex.Pattern r10 = u0
            long r86 = A(r13, r10)
            java.util.regex.Pattern r10 = v0
            r12 = r20
            java.lang.String r41 = u(r13, r10, r12, r3)
            goto L_0x0187
        L_0x01fd:
            r10 = r20
            java.lang.String r0 = "#EXT-X-SKIP"
            boolean r0 = r13.startsWith(r0)
            r45 = 1
            if (r0 == 0) goto L_0x02b3
            java.util.regex.Pattern r0 = p0
            int r0 = m(r13, r0)
            if (r1 == 0) goto L_0x0219
            boolean r12 = r15.isEmpty()
            if (r12 == 0) goto L_0x0219
            r12 = 1
            goto L_0x021a
        L_0x0219:
            r12 = 0
        L_0x021a:
            androidx.media3.common.util.Assertions.i(r12)
            java.lang.Object r12 = androidx.media3.common.util.Util.o(r93)
            androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist r12 = (androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist) r12
            long r12 = r12.f11564k
            long r12 = r28 - r12
            int r13 = (int) r12
            int r0 = r0 + r13
            if (r13 < 0) goto L_0x02ad
            java.util.List<androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$Segment> r12 = r1.r
            int r12 = r12.size()
            if (r0 > r12) goto L_0x02ad
            r20 = r10
            r12 = r11
            r10 = r80
        L_0x0238:
            if (r13 >= r0) goto L_0x02a1
            java.util.List<androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$Segment> r14 = r1.r
            java.lang.Object r14 = r14.get(r13)
            androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$Segment r14 = (androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist.Segment) r14
            r55 = r7
            r91 = r8
            long r7 = r1.f11564k
            int r38 = (r28 > r7 ? 1 : (r28 == r7 ? 0 : -1))
            if (r38 == 0) goto L_0x0257
            int r7 = r1.f11563j
            int r7 = r7 - r27
            int r8 = r14.Z
            int r7 = r7 + r8
            androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$Segment r14 = r14.b(r10, r7)
        L_0x0257:
            r15.add(r14)
            long r7 = r14.Y
            long r10 = r10 + r7
            long r7 = r14.c3
            r42 = -1
            int r38 = (r7 > r42 ? 1 : (r7 == r42 ? 0 : -1))
            if (r38 == 0) goto L_0x026c
            r38 = r0
            long r0 = r14.b3
            long r39 = r0 + r7
            goto L_0x026e
        L_0x026c:
            r38 = r0
        L_0x026e:
            int r0 = r14.Z
            androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$Segment r1 = r14.X
            androidx.media3.common.DrmInitData r7 = r14.Y2
            java.lang.String r8 = r14.Z2
            r42 = r0
            java.lang.String r0 = r14.a3
            r43 = r1
            if (r0 == 0) goto L_0x0288
            java.lang.String r1 = java.lang.Long.toHexString(r82)
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x028b
        L_0x0288:
            java.lang.String r0 = r14.a3
            r12 = r0
        L_0x028b:
            long r82 = r82 + r45
            int r13 = r13 + 1
            r1 = r93
            r50 = r7
            r14 = r8
            r51 = r10
            r0 = r38
            r79 = r42
            r85 = r43
            r7 = r55
            r8 = r91
            goto L_0x0238
        L_0x02a1:
            r55 = r7
            r0 = r92
            r1 = r93
            r80 = r10
            r77 = r12
            goto L_0x0189
        L_0x02ad:
            androidx.media3.exoplayer.hls.playlist.HlsPlaylistParser$DeltaUpdateException r0 = new androidx.media3.exoplayer.hls.playlist.HlsPlaylistParser$DeltaUpdateException
            r0.<init>()
            throw r0
        L_0x02b3:
            r55 = r7
            r91 = r8
            r20 = r10
            java.lang.String r0 = "#EXT-X-KEY"
            boolean r0 = r13.startsWith(r0)
            if (r0 == 0) goto L_0x0322
            java.util.regex.Pattern r0 = D0
            java.lang.String r0 = z(r13, r0, r3)
            java.util.regex.Pattern r1 = E0
            java.lang.String r7 = "identity"
            java.lang.String r1 = u(r13, r1, r7, r3)
            java.lang.String r8 = "NONE"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x02e0
            r9.clear()
            r8 = r77
            r14 = r8
        L_0x02dd:
            r50 = r14
            goto L_0x0316
        L_0x02e0:
            java.util.regex.Pattern r8 = H0
            java.lang.String r8 = v(r13, r8, r3)
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L_0x02ff
            java.lang.String r1 = "AES-128"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x02fc
            java.util.regex.Pattern r0 = G0
            java.lang.String r0 = z(r13, r0, r3)
            r14 = r0
            goto L_0x0316
        L_0x02fc:
            r14 = r77
            goto L_0x0316
        L_0x02ff:
            r7 = r78
            if (r7 != 0) goto L_0x0308
            java.lang.String r78 = l(r0)
            goto L_0x030a
        L_0x0308:
            r78 = r7
        L_0x030a:
            androidx.media3.common.DrmInitData$SchemeData r0 = k(r13, r1, r3)
            if (r0 == 0) goto L_0x02fc
            r9.put(r1, r0)
            r14 = r77
            goto L_0x02dd
        L_0x0316:
            r0 = r92
            r1 = r93
            r77 = r8
        L_0x031c:
            r7 = r55
        L_0x031e:
            r8 = r91
            goto L_0x0189
        L_0x0322:
            r7 = r78
            java.lang.String r0 = "#EXT-X-BYTERANGE"
            boolean r0 = r13.startsWith(r0)
            if (r0 == 0) goto L_0x0352
            java.util.regex.Pattern r0 = z0
            java.lang.String r0 = z(r13, r0, r3)
            java.lang.String[] r0 = androidx.media3.common.util.Util.p2(r0, r12)
            r1 = 0
            r8 = r0[r1]
            long r75 = java.lang.Long.parseLong(r8)
            int r1 = r0.length
            r8 = 1
            if (r1 <= r8) goto L_0x0349
            r0 = r0[r8]
            long r0 = java.lang.Long.parseLong(r0)
            r39 = r0
        L_0x0349:
            r0 = r92
            r1 = r93
            r78 = r7
            r77 = r11
            goto L_0x031c
        L_0x0352:
            r8 = 1
            java.lang.String r0 = "#EXT-X-DISCONTINUITY-SEQUENCE"
            boolean r0 = r13.startsWith(r0)
            r1 = 58
            if (r0 == 0) goto L_0x037b
            int r0 = r13.indexOf(r1)
            int r0 = r0 + r8
            java.lang.String r0 = r13.substring(r0)
            int r27 = java.lang.Integer.parseInt(r0)
            r0 = r92
            r1 = r93
            r78 = r7
            r77 = r11
            r7 = r55
            r8 = r91
            r10 = 0
            r26 = 1
            goto L_0x008d
        L_0x037b:
            java.lang.String r0 = "#EXT-X-DISCONTINUITY"
            boolean r0 = r13.equals(r0)
            if (r0 == 0) goto L_0x0386
            int r79 = r79 + 1
            goto L_0x0349
        L_0x0386:
            java.lang.String r0 = "#EXT-X-PROGRAM-DATE-TIME"
            boolean r0 = r13.startsWith(r0)
            if (r0 == 0) goto L_0x03b3
            r18 = 0
            int r0 = (r24 > r18 ? 1 : (r24 == r18 ? 0 : -1))
            if (r0 != 0) goto L_0x03a9
            int r0 = r13.indexOf(r1)
            r1 = 1
            int r0 = r0 + r1
            java.lang.String r0 = r13.substring(r0)
            long r0 = androidx.media3.common.util.Util.R1(r0)
            long r0 = androidx.media3.common.util.Util.I1(r0)
            long r24 = r0 - r80
            goto L_0x0349
        L_0x03a9:
            r78 = r2
            r10 = r7
        L_0x03ac:
            r12 = r55
            r7 = r82
            r1 = 0
            goto L_0x01e2
        L_0x03b3:
            java.lang.String r0 = "#EXT-X-GAP"
            boolean r0 = r13.equals(r0)
            if (r0 == 0) goto L_0x03cc
            r0 = r92
            r1 = r93
            r78 = r7
            r77 = r11
            r7 = r55
            r8 = r91
            r10 = 0
            r54 = 1
            goto L_0x008d
        L_0x03cc:
            java.lang.String r0 = "#EXT-X-INDEPENDENT-SEGMENTS"
            boolean r0 = r13.equals(r0)
            if (r0 == 0) goto L_0x03e5
            r0 = r92
            r1 = r93
            r78 = r7
            r77 = r11
            r7 = r55
            r8 = r91
            r10 = 0
            r35 = 1
            goto L_0x008d
        L_0x03e5:
            java.lang.String r0 = "#EXT-X-ENDLIST"
            boolean r0 = r13.equals(r0)
            if (r0 == 0) goto L_0x03fe
            r0 = r92
            r1 = r93
            r78 = r7
            r77 = r11
            r7 = r55
            r8 = r91
            r10 = 0
            r36 = 1
            goto L_0x008d
        L_0x03fe:
            java.lang.String r0 = "#EXT-X-RENDITION-REPORT"
            boolean r0 = r13.startsWith(r0)
            if (r0 == 0) goto L_0x0432
            java.util.regex.Pattern r0 = w0
            r78 = r2
            r10 = r7
            r1 = -1
            long r7 = t(r13, r0, r1)
            java.util.regex.Pattern r0 = x0
            r1 = -1
            int r0 = s(r13, r0, r1)
            java.util.regex.Pattern r1 = G0
            java.lang.String r1 = z(r13, r1, r3)
            r2 = r95
            java.lang.String r1 = androidx.media3.common.util.UriUtil.f(r2, r1)
            android.net.Uri r1 = android.net.Uri.parse(r1)
            androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$RenditionReport r12 = new androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$RenditionReport
            r12.<init>(r1, r7, r0)
            r6.add(r12)
            goto L_0x03ac
        L_0x0432:
            r78 = r2
            r10 = r7
            r2 = r95
            java.lang.String r0 = "#EXT-X-PRELOAD-HINT"
            boolean r0 = r13.startsWith(r0)
            if (r0 == 0) goto L_0x04ca
            if (r5 == 0) goto L_0x0443
        L_0x0441:
            goto L_0x03ac
        L_0x0443:
            java.util.regex.Pattern r0 = J0
            java.lang.String r0 = z(r13, r0, r3)
            java.lang.String r1 = "PART"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0452
            goto L_0x0441
        L_0x0452:
            java.util.regex.Pattern r0 = G0
            java.lang.String r58 = z(r13, r0, r3)
            java.util.regex.Pattern r0 = B0
            r7 = -1
            long r0 = t(r13, r0, r7)
            java.util.regex.Pattern r12 = C0
            long r70 = t(r13, r12, r7)
            r7 = r82
            java.lang.String r67 = e(r7, r14, r11)
            if (r50 != 0) goto L_0x048e
            boolean r12 = r9.isEmpty()
            if (r12 != 0) goto L_0x048e
            java.util.Collection r12 = r9.values()
            r13 = 0
            androidx.media3.common.DrmInitData$SchemeData[] r2 = new androidx.media3.common.DrmInitData.SchemeData[r13]
            java.lang.Object[] r2 = r12.toArray(r2)
            androidx.media3.common.DrmInitData$SchemeData[] r2 = (androidx.media3.common.DrmInitData.SchemeData[]) r2
            androidx.media3.common.DrmInitData r12 = new androidx.media3.common.DrmInitData
            r12.<init>((java.lang.String) r10, (androidx.media3.common.DrmInitData.SchemeData[]) r2)
            if (r37 != 0) goto L_0x048c
            androidx.media3.common.DrmInitData r37 = d(r10, r2)
        L_0x048c:
            r50 = r12
        L_0x048e:
            r12 = -1
            int r2 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r2 == 0) goto L_0x0498
            int r38 = (r70 > r12 ? 1 : (r70 == r12 ? 0 : -1))
            if (r38 == 0) goto L_0x04b8
        L_0x0498:
            androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$Part r5 = new androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$Part
            if (r2 == 0) goto L_0x049f
            r68 = r0
            goto L_0x04a1
        L_0x049f:
            r68 = 0
        L_0x04a1:
            r73 = 0
            r74 = 1
            r60 = 0
            r72 = 0
            r57 = r5
            r59 = r85
            r62 = r79
            r63 = r51
            r65 = r50
            r66 = r14
            r57.<init>(r58, r59, r60, r62, r63, r65, r66, r67, r68, r70, r72, r73, r74)
        L_0x04b8:
            r0 = r92
            r1 = r93
            r82 = r7
            r77 = r11
            r7 = r55
            r2 = r78
            r8 = r91
            r78 = r10
            goto L_0x0189
        L_0x04ca:
            r7 = r82
            java.lang.String r0 = "#EXT-X-PART"
            boolean r0 = r13.startsWith(r0)
            if (r0 == 0) goto L_0x0587
            java.lang.String r67 = e(r7, r14, r11)
            java.util.regex.Pattern r0 = G0
            java.lang.String r58 = z(r13, r0, r3)
            java.util.regex.Pattern r0 = j0
            double r0 = j(r13, r0)
            double r0 = r0 * r43
            long r0 = (long) r0
            java.util.regex.Pattern r2 = S0
            r82 = r5
            r5 = 0
            boolean r2 = q(r13, r2, r5)
            if (r35 == 0) goto L_0x04fb
            boolean r38 = r55.isEmpty()
            if (r38 == 0) goto L_0x04fb
            r38 = 1
            goto L_0x04fd
        L_0x04fb:
            r38 = 0
        L_0x04fd:
            r73 = r2 | r38
            java.util.regex.Pattern r2 = T0
            boolean r72 = q(r13, r2, r5)
            java.util.regex.Pattern r2 = A0
            java.lang.String r2 = v(r13, r2, r3)
            if (r2 == 0) goto L_0x0526
            java.lang.String[] r2 = androidx.media3.common.util.Util.p2(r2, r12)
            r12 = r2[r5]
            long r12 = java.lang.Long.parseLong(r12)
            int r5 = r2.length
            r42 = r12
            r12 = 1
            if (r5 <= r12) goto L_0x0523
            r2 = r2[r12]
            long r88 = java.lang.Long.parseLong(r2)
        L_0x0523:
            r12 = -1
            goto L_0x052a
        L_0x0526:
            r12 = -1
            r42 = -1
        L_0x052a:
            int r2 = (r42 > r12 ? 1 : (r42 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x0530
            r88 = 0
        L_0x0530:
            if (r50 != 0) goto L_0x0552
            boolean r5 = r9.isEmpty()
            if (r5 != 0) goto L_0x0552
            java.util.Collection r5 = r9.values()
            r12 = 0
            androidx.media3.common.DrmInitData$SchemeData[] r13 = new androidx.media3.common.DrmInitData.SchemeData[r12]
            java.lang.Object[] r5 = r5.toArray(r13)
            androidx.media3.common.DrmInitData$SchemeData[] r5 = (androidx.media3.common.DrmInitData.SchemeData[]) r5
            androidx.media3.common.DrmInitData r12 = new androidx.media3.common.DrmInitData
            r12.<init>((java.lang.String) r10, (androidx.media3.common.DrmInitData.SchemeData[]) r5)
            if (r37 != 0) goto L_0x0550
            androidx.media3.common.DrmInitData r37 = d(r10, r5)
        L_0x0550:
            r50 = r12
        L_0x0552:
            androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$Part r5 = new androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$Part
            r57 = r5
            r74 = 0
            r59 = r85
            r60 = r0
            r62 = r79
            r63 = r51
            r65 = r50
            r66 = r14
            r68 = r88
            r70 = r42
            r57.<init>(r58, r59, r60, r62, r63, r65, r66, r67, r68, r70, r72, r73, r74)
            r12 = r55
            r12.add(r5)
            long r51 = r51 + r0
            if (r2 == 0) goto L_0x0576
            long r88 = r88 + r42
        L_0x0576:
            r0 = r92
            r1 = r93
            r77 = r11
            r2 = r78
            r5 = r82
            r82 = r7
            r78 = r10
            r7 = r12
            goto L_0x031e
        L_0x0587:
            r82 = r5
            r12 = r55
            java.lang.String r0 = "#"
            boolean r0 = r13.startsWith(r0)
            if (r0 != 0) goto L_0x0640
            java.lang.String r0 = e(r7, r14, r11)
            long r1 = r7 + r45
            java.lang.String r5 = B(r13, r3)
            java.lang.Object r7 = r4.get(r5)
            androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$Segment r7 = (androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist.Segment) r7
            r42 = -1
            int r8 = (r75 > r42 ? 1 : (r75 == r42 ? 0 : -1))
            if (r8 != 0) goto L_0x05ac
            r57 = 0
            goto L_0x05c8
        L_0x05ac:
            if (r84 == 0) goto L_0x05c6
            if (r85 != 0) goto L_0x05c6
            if (r7 != 0) goto L_0x05c6
            androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$Segment r7 = new androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$Segment
            r48 = 0
            r49 = 0
            r44 = 0
            r42 = r7
            r43 = r5
            r46 = r39
            r42.<init>(r43, r44, r46, r48, r49)
            r4.put(r5, r7)
        L_0x05c6:
            r57 = r39
        L_0x05c8:
            if (r50 != 0) goto L_0x05eb
            boolean r13 = r9.isEmpty()
            if (r13 != 0) goto L_0x05eb
            java.util.Collection r13 = r9.values()
            r59 = r1
            r1 = 0
            androidx.media3.common.DrmInitData$SchemeData[] r2 = new androidx.media3.common.DrmInitData.SchemeData[r1]
            java.lang.Object[] r2 = r13.toArray(r2)
            androidx.media3.common.DrmInitData$SchemeData[] r2 = (androidx.media3.common.DrmInitData.SchemeData[]) r2
            androidx.media3.common.DrmInitData r13 = new androidx.media3.common.DrmInitData
            r13.<init>((java.lang.String) r10, (androidx.media3.common.DrmInitData.SchemeData[]) r2)
            if (r37 != 0) goto L_0x05f0
            androidx.media3.common.DrmInitData r37 = d(r10, r2)
            goto L_0x05f0
        L_0x05eb:
            r59 = r1
            r1 = 0
            r13 = r50
        L_0x05f0:
            androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$Segment r2 = new androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$Segment
            if (r85 == 0) goto L_0x05f7
            r40 = r85
            goto L_0x05f9
        L_0x05f7:
            r40 = r7
        L_0x05f9:
            r38 = r2
            r39 = r5
            r42 = r86
            r44 = r79
            r45 = r80
            r47 = r13
            r48 = r14
            r49 = r0
            r50 = r57
            r52 = r75
            r55 = r12
            r38.<init>(r39, r40, r41, r42, r44, r45, r47, r48, r49, r50, r52, r54, r55)
            r15.add(r2)
            long r51 = r80 + r86
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            if (r8 == 0) goto L_0x0620
            long r57 = r57 + r75
        L_0x0620:
            r39 = r57
            r0 = r92
            r1 = r93
            r77 = r11
            r50 = r13
            r41 = r20
            r80 = r51
            r2 = r78
            r5 = r82
            r8 = r91
            r54 = 0
            r75 = -1
            r86 = 0
            r78 = r10
            r82 = r59
            goto L_0x0189
        L_0x0640:
            r1 = 0
            goto L_0x0576
        L_0x0643:
            r78 = r2
            r82 = r5
            r12 = r7
            r91 = r8
            r1 = 0
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r2 = 0
        L_0x0651:
            int r3 = r6.size()
            if (r2 >= r3) goto L_0x06ad
            java.lang.Object r3 = r6.get(r2)
            androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$RenditionReport r3 = (androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist.RenditionReport) r3
            long r4 = r3.f11569b
            r7 = -1
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x0672
            int r4 = r15.size()
            long r4 = (long) r4
            long r4 = r28 + r4
            boolean r9 = r12.isEmpty()
            long r9 = (long) r9
            long r4 = r4 - r9
        L_0x0672:
            int r9 = r3.f11570c
            r10 = -1
            if (r9 != r10) goto L_0x0699
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r11 = (r33 > r13 ? 1 : (r33 == r13 ? 0 : -1))
            if (r11 == 0) goto L_0x0697
            boolean r9 = r12.isEmpty()
            if (r9 == 0) goto L_0x068f
            java.lang.Object r9 = com.google.common.collect.Iterables.w(r15)
            androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$Segment r9 = (androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist.Segment) r9
            java.util.List<androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$Part> r9 = r9.f3
            goto L_0x0690
        L_0x068f:
            r9 = r12
        L_0x0690:
            int r9 = r9.size()
            r11 = 1
            int r9 = r9 - r11
            goto L_0x069f
        L_0x0697:
            r11 = 1
            goto L_0x069f
        L_0x0699:
            r11 = 1
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x069f:
            android.net.Uri r3 = r3.f11568a
            androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$RenditionReport r1 = new androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist$RenditionReport
            r1.<init>(r3, r4, r9)
            r0.put(r3, r1)
            int r2 = r2 + 1
            r1 = 0
            goto L_0x0651
        L_0x06ad:
            r11 = 1
            if (r82 == 0) goto L_0x06b5
            r5 = r82
            r12.add(r5)
        L_0x06b5:
            androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist r1 = new androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist
            r2 = 0
            int r4 = (r24 > r2 ? 1 : (r24 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x06c0
            r90 = 1
            goto L_0x06c2
        L_0x06c0:
            r90 = 0
        L_0x06c2:
            r5 = r1
            r6 = r78
            r55 = r12
            r7 = r95
            r8 = r91
            r9 = r21
            r11 = r23
            r12 = r24
            r14 = r26
            r2 = r15
            r15 = r27
            r16 = r28
            r18 = r30
            r19 = r31
            r21 = r33
            r23 = r35
            r24 = r36
            r25 = r90
            r26 = r37
            r27 = r2
            r28 = r55
            r29 = r56
            r30 = r0
            r5.<init>(r6, r7, r8, r9, r11, r12, r14, r15, r16, r18, r19, r21, r23, r24, r25, r26, r27, r28, r29, r30)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.hls.playlist.HlsPlaylistParser.o(androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist, androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist, androidx.media3.exoplayer.hls.playlist.HlsPlaylistParser$LineIterator, java.lang.String):androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0493, code lost:
        r0 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0494, code lost:
        r2 = r2 + r0;
        r33 = r4;
        r31 = r7;
        r32 = r9;
        r0 = r21;
        r9 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist p(androidx.media3.exoplayer.hls.playlist.HlsPlaylistParser.LineIterator r37, java.lang.String r38) throws java.io.IOException {
        /*
            r1 = r38
            r4 = 1
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            r16 = 0
            r17 = 0
        L_0x0039:
            boolean r18 = r37.a()
            java.lang.String r0 = "application/x-mpegURL"
            if (r18 == 0) goto L_0x0208
            java.lang.String r2 = r37.b()
            java.lang.String r3 = "#EXT"
            boolean r3 = r2.startsWith(r3)
            if (r3 == 0) goto L_0x0050
            r14.add(r2)
        L_0x0050:
            java.lang.String r3 = "#EXT-X-I-FRAME-STREAM-INF"
            boolean r3 = r2.startsWith(r3)
            java.lang.String r15 = "#EXT-X-DEFINE"
            boolean r15 = r2.startsWith(r15)
            if (r15 == 0) goto L_0x006e
            java.util.regex.Pattern r0 = L0
            java.lang.String r0 = z(r2, r0, r11)
            java.util.regex.Pattern r3 = V0
            java.lang.String r2 = z(r2, r3, r11)
            r11.put(r0, r2)
            goto L_0x00cf
        L_0x006e:
            java.lang.String r15 = "#EXT-X-INDEPENDENT-SEGMENTS"
            boolean r15 = r2.equals(r15)
            if (r15 == 0) goto L_0x0089
            r1 = r5
            r33 = r7
            r32 = r8
            r31 = r9
            r29 = r10
            r34 = r12
            r28 = r13
            r30 = r14
            r16 = 1
            goto L_0x01ec
        L_0x0089:
            java.lang.String r15 = "#EXT-X-MEDIA"
            boolean r15 = r2.startsWith(r15)
            if (r15 == 0) goto L_0x0095
            r12.add(r2)
            goto L_0x00cf
        L_0x0095:
            java.lang.String r15 = "#EXT-X-SESSION-KEY"
            boolean r15 = r2.startsWith(r15)
            if (r15 == 0) goto L_0x00c4
            java.util.regex.Pattern r0 = E0
            java.lang.String r3 = "identity"
            java.lang.String r0 = u(r2, r0, r3, r11)
            androidx.media3.common.DrmInitData$SchemeData r0 = k(r2, r0, r11)
            if (r0 == 0) goto L_0x00cf
            java.util.regex.Pattern r3 = D0
            java.lang.String r2 = z(r2, r3, r11)
            java.lang.String r2 = l(r2)
            androidx.media3.common.DrmInitData r3 = new androidx.media3.common.DrmInitData
            androidx.media3.common.DrmInitData$SchemeData[] r15 = new androidx.media3.common.DrmInitData.SchemeData[r4]
            r18 = 0
            r15[r18] = r0
            r3.<init>((java.lang.String) r2, (androidx.media3.common.DrmInitData.SchemeData[]) r15)
            r13.add(r3)
            goto L_0x00cf
        L_0x00c4:
            java.lang.String r15 = "#EXT-X-STREAM-INF"
            boolean r15 = r2.startsWith(r15)
            if (r15 != 0) goto L_0x00e0
            if (r3 == 0) goto L_0x00cf
            goto L_0x00e0
        L_0x00cf:
            r1 = r5
            r33 = r7
            r32 = r8
            r31 = r9
            r29 = r10
            r34 = r12
            r28 = r13
            r30 = r14
            goto L_0x01ec
        L_0x00e0:
            java.lang.String r15 = "CLOSED-CAPTIONS=NONE"
            boolean r15 = r2.contains(r15)
            r17 = r17 | r15
            if (r3 == 0) goto L_0x00ed
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ee
        L_0x00ed:
            r15 = 0
        L_0x00ee:
            java.util.regex.Pattern r4 = d0
            int r4 = m(r2, r4)
            r28 = r13
            java.util.regex.Pattern r13 = Y
            r29 = r10
            r10 = -1
            int r13 = s(r2, r13, r10)
            java.util.regex.Pattern r10 = f0
            java.lang.String r10 = v(r2, r10, r11)
            r30 = r14
            java.util.regex.Pattern r14 = g0
            java.lang.String r14 = v(r2, r14, r11)
            r31 = r9
            if (r14 == 0) goto L_0x012f
            java.lang.String r9 = "x"
            java.lang.String[] r9 = androidx.media3.common.util.Util.p2(r14, r9)
            r14 = 0
            r21 = r9[r14]
            int r14 = java.lang.Integer.parseInt(r21)
            r20 = 1
            r9 = r9[r20]
            int r9 = java.lang.Integer.parseInt(r9)
            if (r14 <= 0) goto L_0x012a
            if (r9 > 0) goto L_0x012c
        L_0x012a:
            r9 = -1
            r14 = -1
        L_0x012c:
            r32 = r8
            goto L_0x0133
        L_0x012f:
            r32 = r8
            r9 = -1
            r14 = -1
        L_0x0133:
            java.util.regex.Pattern r8 = h0
            java.lang.String r8 = v(r2, r8, r11)
            if (r8 == 0) goto L_0x0142
            float r8 = java.lang.Float.parseFloat(r8)
        L_0x013f:
            r33 = r7
            goto L_0x0145
        L_0x0142:
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L_0x013f
        L_0x0145:
            java.util.regex.Pattern r7 = Z
            java.lang.String r7 = v(r2, r7, r11)
            r34 = r12
            java.util.regex.Pattern r12 = a0
            java.lang.String r12 = v(r2, r12, r11)
            r35 = r5
            java.util.regex.Pattern r5 = b0
            java.lang.String r5 = v(r2, r5, r11)
            r36 = r5
            java.util.regex.Pattern r5 = c0
            java.lang.String r5 = v(r2, r5, r11)
            if (r3 == 0) goto L_0x0170
            java.util.regex.Pattern r3 = G0
            java.lang.String r2 = z(r2, r3, r11)
        L_0x016b:
            android.net.Uri r2 = androidx.media3.common.util.UriUtil.g(r1, r2)
            goto L_0x017f
        L_0x0170:
            boolean r2 = r37.a()
            if (r2 == 0) goto L_0x0200
            java.lang.String r2 = r37.b()
            java.lang.String r2 = B(r2, r11)
            goto L_0x016b
        L_0x017f:
            androidx.media3.common.Format$Builder r3 = new androidx.media3.common.Format$Builder
            r3.<init>()
            int r1 = r6.size()
            androidx.media3.common.Format$Builder r1 = r3.W(r1)
            androidx.media3.common.Format$Builder r0 = r1.O(r0)
            androidx.media3.common.Format$Builder r0 = r0.M(r10)
            androidx.media3.common.Format$Builder r0 = r0.K(r13)
            androidx.media3.common.Format$Builder r0 = r0.f0(r4)
            androidx.media3.common.Format$Builder r0 = r0.r0(r14)
            androidx.media3.common.Format$Builder r0 = r0.V(r9)
            androidx.media3.common.Format$Builder r0 = r0.U(r8)
            androidx.media3.common.Format$Builder r0 = r0.i0(r15)
            androidx.media3.common.Format r23 = r0.I()
            androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Variant r0 = new androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Variant
            r21 = r0
            r22 = r2
            r24 = r7
            r25 = r12
            r26 = r36
            r27 = r5
            r21.<init>(r22, r23, r24, r25, r26, r27)
            r6.add(r0)
            r1 = r35
            java.lang.Object r0 = r1.get(r2)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            if (r0 != 0) goto L_0x01d6
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1.put(r2, r0)
        L_0x01d6:
            androidx.media3.exoplayer.hls.HlsTrackMetadataEntry$VariantInfo r2 = new androidx.media3.exoplayer.hls.HlsTrackMetadataEntry$VariantInfo
            r21 = r2
            r22 = r13
            r23 = r4
            r24 = r7
            r25 = r12
            r26 = r36
            r27 = r5
            r21.<init>(r22, r23, r24, r25, r26, r27)
            r0.add(r2)
        L_0x01ec:
            r5 = r1
            r13 = r28
            r10 = r29
            r14 = r30
            r9 = r31
            r8 = r32
            r7 = r33
            r12 = r34
            r4 = 1
            r1 = r38
            goto L_0x0039
        L_0x0200:
            java.lang.String r0 = "#EXT-X-STREAM-INF must be followed by another line"
            r1 = 0
            androidx.media3.common.ParserException r0 = androidx.media3.common.ParserException.c(r0, r1)
            throw r0
        L_0x0208:
            r1 = r5
            r33 = r7
            r32 = r8
            r31 = r9
            r29 = r10
            r34 = r12
            r28 = r13
            r30 = r14
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            r4 = 0
        L_0x0222:
            int r5 = r6.size()
            if (r4 >= r5) goto L_0x027b
            java.lang.Object r5 = r6.get(r4)
            androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Variant r5 = (androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist.Variant) r5
            android.net.Uri r7 = r5.f11591a
            boolean r7 = r2.add(r7)
            if (r7 == 0) goto L_0x0277
            androidx.media3.common.Format r7 = r5.f11592b
            androidx.media3.common.Metadata r7 = r7.d3
            if (r7 != 0) goto L_0x023e
            r7 = 1
            goto L_0x023f
        L_0x023e:
            r7 = 0
        L_0x023f:
            androidx.media3.common.util.Assertions.i(r7)
            androidx.media3.exoplayer.hls.HlsTrackMetadataEntry r7 = new androidx.media3.exoplayer.hls.HlsTrackMetadataEntry
            android.net.Uri r8 = r5.f11591a
            java.lang.Object r8 = r1.get(r8)
            java.util.ArrayList r8 = (java.util.ArrayList) r8
            java.lang.Object r8 = androidx.media3.common.util.Assertions.g(r8)
            java.util.List r8 = (java.util.List) r8
            r9 = 0
            r7.<init>(r9, r9, r8)
            androidx.media3.common.Metadata r8 = new androidx.media3.common.Metadata
            r10 = 1
            androidx.media3.common.Metadata$Entry[] r12 = new androidx.media3.common.Metadata.Entry[r10]
            r13 = 0
            r12[r13] = r7
            r8.<init>((androidx.media3.common.Metadata.Entry[]) r12)
            androidx.media3.common.Format r7 = r5.f11592b
            androidx.media3.common.Format$Builder r7 = r7.c()
            androidx.media3.common.Format$Builder r7 = r7.d0(r8)
            androidx.media3.common.Format r7 = r7.I()
            androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Variant r5 = r5.a(r7)
            r3.add(r5)
            goto L_0x0279
        L_0x0277:
            r9 = 0
            r10 = 1
        L_0x0279:
            int r4 = r4 + r10
            goto L_0x0222
        L_0x027b:
            r9 = 0
            r1 = r9
            r8 = r1
            r2 = 0
        L_0x027f:
            int r4 = r34.size()
            if (r2 >= r4) goto L_0x04a0
            r4 = r34
            java.lang.Object r5 = r4.get(r2)
            java.lang.String r5 = (java.lang.String) r5
            java.util.regex.Pattern r7 = M0
            java.lang.String r7 = z(r5, r7, r11)
            java.util.regex.Pattern r10 = L0
            java.lang.String r10 = z(r5, r10, r11)
            androidx.media3.common.Format$Builder r12 = new androidx.media3.common.Format$Builder
            r12.<init>()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r7)
            java.lang.String r14 = ":"
            r13.append(r14)
            r13.append(r10)
            java.lang.String r13 = r13.toString()
            androidx.media3.common.Format$Builder r12 = r12.X(r13)
            androidx.media3.common.Format$Builder r12 = r12.Z(r10)
            androidx.media3.common.Format$Builder r12 = r12.O(r0)
            int r13 = x(r5)
            androidx.media3.common.Format$Builder r12 = r12.m0(r13)
            int r13 = w(r5, r11)
            androidx.media3.common.Format$Builder r12 = r12.i0(r13)
            java.util.regex.Pattern r13 = K0
            java.lang.String r13 = v(r5, r13, r11)
            androidx.media3.common.Format$Builder r12 = r12.b0(r13)
            java.util.regex.Pattern r13 = G0
            java.lang.String r13 = v(r5, r13, r11)
            r14 = r38
            if (r13 != 0) goto L_0x02e4
            r13 = r9
            goto L_0x02e8
        L_0x02e4:
            android.net.Uri r13 = androidx.media3.common.util.UriUtil.g(r14, r13)
        L_0x02e8:
            androidx.media3.common.Metadata r15 = new androidx.media3.common.Metadata
            androidx.media3.exoplayer.hls.HlsTrackMetadataEntry r9 = new androidx.media3.exoplayer.hls.HlsTrackMetadataEntry
            r21 = r0
            java.util.List r0 = java.util.Collections.emptyList()
            r9.<init>(r7, r10, r0)
            r34 = r4
            r0 = 1
            androidx.media3.common.Metadata$Entry[] r4 = new androidx.media3.common.Metadata.Entry[r0]
            r0 = 0
            r4[r0] = r9
            r15.<init>((androidx.media3.common.Metadata.Entry[]) r4)
            java.util.regex.Pattern r0 = I0
            java.lang.String r0 = z(r5, r0, r11)
            r0.hashCode()
            int r4 = r0.hashCode()
            switch(r4) {
                case -959297733: goto L_0x0333;
                case -333210994: goto L_0x0328;
                case 62628790: goto L_0x031d;
                case 81665115: goto L_0x0312;
                default: goto L_0x0310;
            }
        L_0x0310:
            r0 = -1
            goto L_0x033d
        L_0x0312:
            java.lang.String r4 = "VIDEO"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x031b
            goto L_0x0310
        L_0x031b:
            r0 = 3
            goto L_0x033d
        L_0x031d:
            java.lang.String r4 = "AUDIO"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x0326
            goto L_0x0310
        L_0x0326:
            r0 = 2
            goto L_0x033d
        L_0x0328:
            java.lang.String r4 = "CLOSED-CAPTIONS"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x0331
            goto L_0x0310
        L_0x0331:
            r0 = 1
            goto L_0x033d
        L_0x0333:
            java.lang.String r4 = "SUBTITLES"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x033c
            goto L_0x0310
        L_0x033c:
            r0 = 0
        L_0x033d:
            switch(r0) {
                case 0: goto L_0x044e;
                case 1: goto L_0x0409;
                case 2: goto L_0x0391;
                case 3: goto L_0x034c;
                default: goto L_0x0340;
            }
        L_0x0340:
            r7 = r31
            r9 = r32
            r4 = r33
        L_0x0346:
            r5 = 2
            r14 = 3
            r19 = 0
            goto L_0x0493
        L_0x034c:
            androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Variant r0 = h(r6, r7)
            if (r0 == 0) goto L_0x0378
            androidx.media3.common.Format r0 = r0.f11592b
            java.lang.String r4 = r0.c3
            r5 = 2
            java.lang.String r4 = androidx.media3.common.util.Util.g0(r4, r5)
            androidx.media3.common.Format$Builder r5 = r12.M(r4)
            java.lang.String r4 = androidx.media3.common.MimeTypes.g(r4)
            androidx.media3.common.Format$Builder r4 = r5.k0(r4)
            int r5 = r0.k3
            androidx.media3.common.Format$Builder r4 = r4.r0(r5)
            int r5 = r0.l3
            androidx.media3.common.Format$Builder r4 = r4.V(r5)
            float r0 = r0.m3
            r4.U(r0)
        L_0x0378:
            if (r13 != 0) goto L_0x037b
            goto L_0x0340
        L_0x037b:
            r12.d0(r15)
            androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Rendition r0 = new androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Rendition
            androidx.media3.common.Format r4 = r12.I()
            r0.<init>(r13, r4, r7, r10)
            r4 = r33
            r4.add(r0)
            r7 = r31
            r9 = r32
            goto L_0x0346
        L_0x0391:
            r4 = r33
            androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Variant r0 = f(r6, r7)
            if (r0 == 0) goto L_0x03aa
            androidx.media3.common.Format r9 = r0.f11592b
            java.lang.String r9 = r9.c3
            r14 = 1
            java.lang.String r9 = androidx.media3.common.util.Util.g0(r9, r14)
            r12.M(r9)
            java.lang.String r9 = androidx.media3.common.MimeTypes.g(r9)
            goto L_0x03ab
        L_0x03aa:
            r9 = 0
        L_0x03ab:
            java.util.regex.Pattern r14 = e0
            java.lang.String r5 = v(r5, r14, r11)
            if (r5 == 0) goto L_0x03dc
            java.lang.String r14 = "/"
            java.lang.String[] r14 = androidx.media3.common.util.Util.q2(r5, r14)
            r19 = 0
            r14 = r14[r19]
            int r14 = java.lang.Integer.parseInt(r14)
            r12.L(r14)
            java.lang.String r14 = "audio/eac3"
            boolean r14 = r14.equals(r9)
            if (r14 == 0) goto L_0x03de
            java.lang.String r14 = "/JOC"
            boolean r5 = r5.endsWith(r14)
            if (r5 == 0) goto L_0x03de
            java.lang.String r5 = "ec+3"
            r12.M(r5)
            java.lang.String r9 = "audio/eac3-joc"
            goto L_0x03de
        L_0x03dc:
            r19 = 0
        L_0x03de:
            r12.k0(r9)
            if (r13 == 0) goto L_0x03fa
            r12.d0(r15)
            androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Rendition r0 = new androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Rendition
            androidx.media3.common.Format r5 = r12.I()
            r0.<init>(r13, r5, r7, r10)
            r9 = r32
            r9.add(r0)
        L_0x03f4:
            r7 = r31
            r5 = 2
            r14 = 3
            goto L_0x0493
        L_0x03fa:
            r9 = r32
            if (r0 == 0) goto L_0x03f4
            androidx.media3.common.Format r8 = r12.I()
            r7 = r31
            r0 = 1
            r5 = 2
        L_0x0406:
            r14 = 3
            goto L_0x0494
        L_0x0409:
            r9 = r32
            r4 = r33
            r19 = 0
            java.util.regex.Pattern r0 = O0
            java.lang.String r0 = z(r5, r0, r11)
            java.lang.String r5 = "CC"
            boolean r5 = r0.startsWith(r5)
            if (r5 == 0) goto L_0x0429
            r5 = 2
            java.lang.String r0 = r0.substring(r5)
            int r0 = java.lang.Integer.parseInt(r0)
            java.lang.String r7 = "application/cea-608"
            goto L_0x0435
        L_0x0429:
            r5 = 2
            r7 = 7
            java.lang.String r0 = r0.substring(r7)
            int r0 = java.lang.Integer.parseInt(r0)
            java.lang.String r7 = "application/cea-708"
        L_0x0435:
            if (r1 != 0) goto L_0x043c
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
        L_0x043c:
            androidx.media3.common.Format$Builder r7 = r12.k0(r7)
            r7.J(r0)
            androidx.media3.common.Format r0 = r12.I()
            r1.add(r0)
            r7 = r31
            r0 = 1
            goto L_0x0406
        L_0x044e:
            r9 = r32
            r4 = r33
            r5 = 2
            r19 = 0
            androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Variant r0 = g(r6, r7)
            if (r0 == 0) goto L_0x046c
            androidx.media3.common.Format r0 = r0.f11592b
            java.lang.String r0 = r0.c3
            r14 = 3
            java.lang.String r0 = androidx.media3.common.util.Util.g0(r0, r14)
            r12.M(r0)
            java.lang.String r0 = androidx.media3.common.MimeTypes.g(r0)
            goto L_0x046e
        L_0x046c:
            r14 = 3
            r0 = 0
        L_0x046e:
            if (r0 != 0) goto L_0x0472
            java.lang.String r0 = "text/vtt"
        L_0x0472:
            androidx.media3.common.Format$Builder r0 = r12.k0(r0)
            r0.d0(r15)
            if (r13 == 0) goto L_0x048a
            androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Rendition r0 = new androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist$Rendition
            androidx.media3.common.Format r12 = r12.I()
            r0.<init>(r13, r12, r7, r10)
            r7 = r31
            r7.add(r0)
            goto L_0x0493
        L_0x048a:
            r7 = r31
            java.lang.String r0 = "HlsPlaylistParser"
            java.lang.String r10 = "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping"
            androidx.media3.common.util.Log.n(r0, r10)
        L_0x0493:
            r0 = 1
        L_0x0494:
            int r2 = r2 + r0
            r33 = r4
            r31 = r7
            r32 = r9
            r0 = r21
            r9 = 0
            goto L_0x027f
        L_0x04a0:
            r7 = r31
            r9 = r32
            r4 = r33
            if (r17 == 0) goto L_0x04ae
            java.util.List r0 = java.util.Collections.emptyList()
            r10 = r0
            goto L_0x04af
        L_0x04ae:
            r10 = r1
        L_0x04af:
            androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist r13 = new androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist
            r0 = r13
            r1 = r38
            r2 = r30
            r5 = r9
            r6 = r7
            r7 = r29
            r9 = r10
            r10 = r16
            r12 = r28
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.hls.playlist.HlsPlaylistParser.p(androidx.media3.exoplayer.hls.playlist.HlsPlaylistParser$LineIterator, java.lang.String):androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist");
    }

    private static boolean q(String str, Pattern pattern, boolean z2) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? V.equals(matcher.group(1)) : z2;
    }

    private static double r(String str, Pattern pattern, double d2) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Double.parseDouble((String) Assertions.g(matcher.group(1))) : d2;
    }

    private static int s(String str, Pattern pattern, int i2) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Integer.parseInt((String) Assertions.g(matcher.group(1))) : i2;
    }

    private static long t(String str, Pattern pattern, long j2) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? Long.parseLong((String) Assertions.g(matcher.group(1))) : j2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String u(java.lang.String r0, java.util.regex.Pattern r1, java.lang.String r2, java.util.Map<java.lang.String, java.lang.String> r3) {
        /*
            java.util.regex.Matcher r0 = r1.matcher(r0)
            boolean r1 = r0.find()
            if (r1 == 0) goto L_0x0016
            r1 = 1
            java.lang.String r0 = r0.group(r1)
            java.lang.Object r0 = androidx.media3.common.util.Assertions.g(r0)
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2
        L_0x0016:
            boolean r0 = r3.isEmpty()
            if (r0 != 0) goto L_0x0023
            if (r2 != 0) goto L_0x001f
            goto L_0x0023
        L_0x001f:
            java.lang.String r2 = B(r2, r3)
        L_0x0023:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.hls.playlist.HlsPlaylistParser.u(java.lang.String, java.util.regex.Pattern, java.lang.String, java.util.Map):java.lang.String");
    }

    @Nullable
    private static String v(String str, Pattern pattern, Map<String, String> map) {
        return u(str, pattern, (String) null, map);
    }

    private static int w(String str, Map<String, String> map) {
        String v2 = v(str, N0, map);
        int i2 = 0;
        if (TextUtils.isEmpty(v2)) {
            return 0;
        }
        String[] p2 = Util.p2(v2, ",");
        if (Util.z(p2, "public.accessibility.describes-video")) {
            i2 = 512;
        }
        if (Util.z(p2, "public.accessibility.transcribes-spoken-dialog")) {
            i2 |= 4096;
        }
        if (Util.z(p2, "public.accessibility.describes-music-and-sound")) {
            i2 |= 1024;
        }
        return Util.z(p2, "public.easy-to-read") ? i2 | 8192 : i2;
    }

    private static int x(String str) {
        boolean q2 = q(str, Q0, false);
        if (q(str, R0, false)) {
            q2 |= true;
        }
        return q(str, P0, false) ? q2 | true ? 1 : 0 : q2 ? 1 : 0;
    }

    private static HlsMediaPlaylist.ServerControl y(String str) {
        String str2 = str;
        double r2 = r(str2, n0, -9.223372036854776E18d);
        long j2 = C.f9084b;
        long j3 = r2 == -9.223372036854776E18d ? -9223372036854775807L : (long) (r2 * 1000000.0d);
        boolean q2 = q(str2, o0, false);
        double r3 = r(str2, q0, -9.223372036854776E18d);
        long j4 = r3 == -9.223372036854776E18d ? -9223372036854775807L : (long) (r3 * 1000000.0d);
        double r4 = r(str2, r0, -9.223372036854776E18d);
        if (r4 != -9.223372036854776E18d) {
            j2 = (long) (r4 * 1000000.0d);
        }
        return new HlsMediaPlaylist.ServerControl(j3, q2, j4, j2, q(str2, s0, false));
    }

    private static String z(String str, Pattern pattern, Map<String, String> map) throws ParserException {
        String v2 = v(str, pattern, map);
        if (v2 != null) {
            return v2;
        }
        throw ParserException.c("Couldn't match " + pattern.pattern() + " in " + str, (Throwable) null);
    }

    /* renamed from: i */
    public HlsPlaylist a(Uri uri, InputStream inputStream) throws IOException {
        String trim;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            if (b(bufferedReader)) {
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        trim = readLine.trim();
                        if (!trim.isEmpty()) {
                            if (!trim.startsWith(f11607j)) {
                                if (trim.startsWith(p) || trim.startsWith(w) || trim.startsWith(v) || trim.startsWith(z) || trim.startsWith(B) || trim.equals(q) || trim.equals(r)) {
                                    break;
                                } else if (trim.equals(y)) {
                                    break;
                                } else {
                                    arrayDeque.add(trim);
                                }
                            } else {
                                arrayDeque.add(trim);
                                HlsMultivariantPlaylist p2 = p(new LineIterator(arrayDeque, bufferedReader), uri.toString());
                                Util.t(bufferedReader);
                                return p2;
                            }
                        }
                    } else {
                        Util.t(bufferedReader);
                        throw ParserException.c("Failed to parse the playlist, could not identify any tags.", (Throwable) null);
                    }
                }
                arrayDeque.add(trim);
                return o(this.f11612a, this.f11613b, new LineIterator(arrayDeque, bufferedReader), uri.toString());
            }
            throw ParserException.c("Input does not start with the #EXTM3U header.", (Throwable) null);
        } finally {
            Util.t(bufferedReader);
        }
    }

    public HlsPlaylistParser(HlsMultivariantPlaylist hlsMultivariantPlaylist, @Nullable HlsMediaPlaylist hlsMediaPlaylist) {
        this.f11612a = hlsMultivariantPlaylist;
        this.f11613b = hlsMediaPlaylist;
    }
}
