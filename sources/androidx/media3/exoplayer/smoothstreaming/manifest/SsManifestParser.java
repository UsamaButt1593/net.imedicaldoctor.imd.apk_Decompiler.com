package androidx.media3.exoplayer.smoothstreaming.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.smoothstreaming.manifest.SsManifest;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.mp4.PsshAtomUtil;
import androidx.media3.extractor.mp4.TrackEncryptionBox;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

@UnstableApi
public class SsManifestParser implements ParsingLoadable.Parser<SsManifest> {

    /* renamed from: a  reason: collision with root package name */
    private final XmlPullParserFactory f12040a;

    private static abstract class ElementParser {

        /* renamed from: a  reason: collision with root package name */
        private final String f12041a;

        /* renamed from: b  reason: collision with root package name */
        private final String f12042b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private final ElementParser f12043c;

        /* renamed from: d  reason: collision with root package name */
        private final List<Pair<String, Object>> f12044d = new LinkedList();

        public ElementParser(@Nullable ElementParser elementParser, String str, String str2) {
            this.f12043c = elementParser;
            this.f12041a = str;
            this.f12042b = str2;
        }

        private ElementParser e(ElementParser elementParser, String str, String str2) {
            if (QualityLevelParser.f12052f.equals(str)) {
                return new QualityLevelParser(elementParser, str2);
            }
            if (ProtectionParser.f12045h.equals(str)) {
                return new ProtectionParser(elementParser, str2);
            }
            if (StreamIndexParser.s.equals(str)) {
                return new StreamIndexParser(elementParser, str2);
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void a(Object obj) {
        }

        /* access modifiers changed from: protected */
        public abstract Object b();

        /* access modifiers changed from: protected */
        @Nullable
        public final Object c(String str) {
            for (int i2 = 0; i2 < this.f12044d.size(); i2++) {
                Pair pair = this.f12044d.get(i2);
                if (((String) pair.first).equals(str)) {
                    return pair.second;
                }
            }
            ElementParser elementParser = this.f12043c;
            if (elementParser == null) {
                return null;
            }
            return elementParser.c(str);
        }

        /* access modifiers changed from: protected */
        public boolean d(String str) {
            return false;
        }

        public final Object f(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            boolean z = false;
            int i2 = 0;
            while (true) {
                int eventType = xmlPullParser.getEventType();
                if (eventType == 1) {
                    return null;
                }
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (this.f12042b.equals(name)) {
                        n(xmlPullParser);
                        z = true;
                    } else if (z) {
                        if (i2 > 0) {
                            i2++;
                        } else if (d(name)) {
                            n(xmlPullParser);
                        } else {
                            ElementParser e2 = e(this, name, this.f12041a);
                            if (e2 == null) {
                                i2 = 1;
                            } else {
                                a(e2.f(xmlPullParser));
                            }
                        }
                    }
                } else if (eventType != 3) {
                    if (eventType == 4 && z && i2 == 0) {
                        o(xmlPullParser);
                    }
                } else if (!z) {
                    continue;
                } else if (i2 > 0) {
                    i2--;
                } else {
                    String name2 = xmlPullParser.getName();
                    h(xmlPullParser);
                    if (!d(name2)) {
                        return b();
                    }
                }
                xmlPullParser.next();
            }
        }

        /* access modifiers changed from: protected */
        public final boolean g(XmlPullParser xmlPullParser, String str, boolean z) {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            return attributeValue != null ? Boolean.parseBoolean(attributeValue) : z;
        }

        /* access modifiers changed from: protected */
        public void h(XmlPullParser xmlPullParser) {
        }

        /* access modifiers changed from: protected */
        public final int i(XmlPullParser xmlPullParser, String str, int i2) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue == null) {
                return i2;
            }
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e2) {
                throw ParserException.c((String) null, e2);
            }
        }

        /* access modifiers changed from: protected */
        public final long j(XmlPullParser xmlPullParser, String str, long j2) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue == null) {
                return j2;
            }
            try {
                return Long.parseLong(attributeValue);
            } catch (NumberFormatException e2) {
                throw ParserException.c((String) null, e2);
            }
        }

        /* access modifiers changed from: protected */
        public final int k(XmlPullParser xmlPullParser, String str) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue != null) {
                try {
                    return Integer.parseInt(attributeValue);
                } catch (NumberFormatException e2) {
                    throw ParserException.c((String) null, e2);
                }
            } else {
                throw new MissingFieldException(str);
            }
        }

        /* access modifiers changed from: protected */
        public final long l(XmlPullParser xmlPullParser, String str) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue != null) {
                try {
                    return Long.parseLong(attributeValue);
                } catch (NumberFormatException e2) {
                    throw ParserException.c((String) null, e2);
                }
            } else {
                throw new MissingFieldException(str);
            }
        }

        /* access modifiers changed from: protected */
        public final String m(XmlPullParser xmlPullParser, String str) throws MissingFieldException {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
            if (attributeValue != null) {
                return attributeValue;
            }
            throw new MissingFieldException(str);
        }

        /* access modifiers changed from: protected */
        public void n(XmlPullParser xmlPullParser) throws ParserException {
        }

        /* access modifiers changed from: protected */
        public void o(XmlPullParser xmlPullParser) {
        }

        /* access modifiers changed from: protected */
        public final void p(String str, @Nullable Object obj) {
            this.f12044d.add(Pair.create(str, obj));
        }
    }

    public static class MissingFieldException extends ParserException {
        public MissingFieldException(String str) {
            super("Missing required field: " + str, (Throwable) null, true, 4);
        }
    }

    private static class ProtectionParser extends ElementParser {

        /* renamed from: h  reason: collision with root package name */
        public static final String f12045h = "Protection";

        /* renamed from: i  reason: collision with root package name */
        public static final String f12046i = "ProtectionHeader";

        /* renamed from: j  reason: collision with root package name */
        public static final String f12047j = "SystemID";

        /* renamed from: k  reason: collision with root package name */
        private static final int f12048k = 8;

        /* renamed from: e  reason: collision with root package name */
        private boolean f12049e;

        /* renamed from: f  reason: collision with root package name */
        private UUID f12050f;

        /* renamed from: g  reason: collision with root package name */
        private byte[] f12051g;

        public ProtectionParser(ElementParser elementParser, String str) {
            super(elementParser, str, f12045h);
        }

        private static TrackEncryptionBox[] q(byte[] bArr) {
            return new TrackEncryptionBox[]{new TrackEncryptionBox(true, (String) null, 8, r(bArr), 0, 0, (byte[]) null)};
        }

        private static byte[] r(byte[] bArr) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < bArr.length; i2 += 2) {
                sb.append((char) bArr[i2]);
            }
            String sb2 = sb.toString();
            byte[] decode = Base64.decode(sb2.substring(sb2.indexOf("<KID>") + 5, sb2.indexOf("</KID>")), 0);
            t(decode, 0, 3);
            t(decode, 1, 2);
            t(decode, 4, 5);
            t(decode, 6, 7);
            return decode;
        }

        private static String s(String str) {
            return (str.charAt(0) == '{' && str.charAt(str.length() - 1) == '}') ? str.substring(1, str.length() - 1) : str;
        }

        private static void t(byte[] bArr, int i2, int i3) {
            byte b2 = bArr[i2];
            bArr[i2] = bArr[i3];
            bArr[i3] = b2;
        }

        public Object b() {
            UUID uuid = this.f12050f;
            return new SsManifest.ProtectionElement(uuid, PsshAtomUtil.a(uuid, this.f12051g), q(this.f12051g));
        }

        public boolean d(String str) {
            return f12046i.equals(str);
        }

        public void h(XmlPullParser xmlPullParser) {
            if (f12046i.equals(xmlPullParser.getName())) {
                this.f12049e = false;
            }
        }

        public void n(XmlPullParser xmlPullParser) {
            if (f12046i.equals(xmlPullParser.getName())) {
                this.f12049e = true;
                this.f12050f = UUID.fromString(s(xmlPullParser.getAttributeValue((String) null, f12047j)));
            }
        }

        public void o(XmlPullParser xmlPullParser) {
            if (this.f12049e) {
                this.f12051g = Base64.decode(xmlPullParser.getText(), 0);
            }
        }
    }

    private static class QualityLevelParser extends ElementParser {

        /* renamed from: f  reason: collision with root package name */
        public static final String f12052f = "QualityLevel";

        /* renamed from: g  reason: collision with root package name */
        private static final String f12053g = "Index";

        /* renamed from: h  reason: collision with root package name */
        private static final String f12054h = "Bitrate";

        /* renamed from: i  reason: collision with root package name */
        private static final String f12055i = "CodecPrivateData";

        /* renamed from: j  reason: collision with root package name */
        private static final String f12056j = "SamplingRate";

        /* renamed from: k  reason: collision with root package name */
        private static final String f12057k = "Channels";

        /* renamed from: l  reason: collision with root package name */
        private static final String f12058l = "FourCC";

        /* renamed from: m  reason: collision with root package name */
        private static final String f12059m = "Type";

        /* renamed from: n  reason: collision with root package name */
        private static final String f12060n = "Subtype";
        private static final String o = "Language";
        private static final String p = "Name";
        private static final String q = "MaxWidth";
        private static final String r = "MaxHeight";

        /* renamed from: e  reason: collision with root package name */
        private Format f12061e;

        public QualityLevelParser(ElementParser elementParser, String str) {
            super(elementParser, str, f12052f);
        }

        private static List<byte[]> q(String str) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                byte[] e0 = Util.e0(str);
                byte[][] j2 = CodecSpecificDataUtil.j(e0);
                if (j2 == null) {
                    arrayList.add(e0);
                } else {
                    Collections.addAll(arrayList, j2);
                }
            }
            return arrayList;
        }

        @Nullable
        private static String r(String str) {
            if (str.equalsIgnoreCase("H264") || str.equalsIgnoreCase("X264") || str.equalsIgnoreCase("AVC1") || str.equalsIgnoreCase("DAVC")) {
                return MimeTypes.f9235j;
            }
            if (str.equalsIgnoreCase("AAC") || str.equalsIgnoreCase("AACL") || str.equalsIgnoreCase("AACH") || str.equalsIgnoreCase("AACP")) {
                return MimeTypes.F;
            }
            if (str.equalsIgnoreCase("TTML") || str.equalsIgnoreCase("DFXP")) {
                return MimeTypes.z0;
            }
            if (str.equalsIgnoreCase("ac-3") || str.equalsIgnoreCase("dac3")) {
                return MimeTypes.Q;
            }
            if (str.equalsIgnoreCase("ec-3") || str.equalsIgnoreCase("dec3")) {
                return MimeTypes.R;
            }
            if (str.equalsIgnoreCase("dtsc")) {
                return MimeTypes.V;
            }
            if (str.equalsIgnoreCase("dtsh") || str.equalsIgnoreCase("dtsl")) {
                return MimeTypes.W;
            }
            if (str.equalsIgnoreCase("dtse")) {
                return MimeTypes.X;
            }
            if (str.equalsIgnoreCase("opus")) {
                return MimeTypes.a0;
            }
            return null;
        }

        public Object b() {
            return this.f12061e;
        }

        public void n(XmlPullParser xmlPullParser) throws ParserException {
            int i2;
            Format.Builder builder = new Format.Builder();
            String r2 = r(m(xmlPullParser, f12058l));
            int intValue = ((Integer) c(f12059m)).intValue();
            if (intValue == 2) {
                builder.O(MimeTypes.f9231f).r0(k(xmlPullParser, q)).V(k(xmlPullParser, r)).Y(q(xmlPullParser.getAttributeValue((String) null, f12055i)));
            } else if (intValue == 1) {
                if (r2 == null) {
                    r2 = MimeTypes.F;
                }
                int k2 = k(xmlPullParser, f12057k);
                int k3 = k(xmlPullParser, f12056j);
                List<byte[]> q2 = q(xmlPullParser.getAttributeValue((String) null, f12055i));
                if (q2.isEmpty() && MimeTypes.F.equals(r2)) {
                    q2 = Collections.singletonList(AacUtil.a(k3, k2));
                }
                builder.O(MimeTypes.E).L(k2).l0(k3).Y(q2);
            } else if (intValue == 3) {
                String str = (String) c(f12060n);
                if (str != null) {
                    if (str.equals("CAPT")) {
                        i2 = 64;
                    } else if (str.equals("DESC")) {
                        i2 = 1024;
                    }
                    builder.O(MimeTypes.p0).i0(i2);
                }
                i2 = 0;
                builder.O(MimeTypes.p0).i0(i2);
            } else {
                builder.O(MimeTypes.p0);
            }
            this.f12061e = builder.X(xmlPullParser.getAttributeValue((String) null, f12053g)).Z((String) c(p)).k0(r2).K(k(xmlPullParser, f12054h)).b0((String) c(o)).I();
        }
    }

    private static class SmoothStreamingMediaParser extends ElementParser {

        /* renamed from: n  reason: collision with root package name */
        public static final String f12062n = "SmoothStreamingMedia";
        private static final String o = "MajorVersion";
        private static final String p = "MinorVersion";
        private static final String q = "TimeScale";
        private static final String r = "DVRWindowLength";
        private static final String s = "Duration";
        private static final String t = "LookaheadCount";
        private static final String u = "IsLive";

        /* renamed from: e  reason: collision with root package name */
        private final List<SsManifest.StreamElement> f12063e = new LinkedList();

        /* renamed from: f  reason: collision with root package name */
        private int f12064f;

        /* renamed from: g  reason: collision with root package name */
        private int f12065g;

        /* renamed from: h  reason: collision with root package name */
        private long f12066h;

        /* renamed from: i  reason: collision with root package name */
        private long f12067i;

        /* renamed from: j  reason: collision with root package name */
        private long f12068j;

        /* renamed from: k  reason: collision with root package name */
        private int f12069k = -1;

        /* renamed from: l  reason: collision with root package name */
        private boolean f12070l;
        @Nullable

        /* renamed from: m  reason: collision with root package name */
        private SsManifest.ProtectionElement f12071m = null;

        public SmoothStreamingMediaParser(ElementParser elementParser, String str) {
            super(elementParser, str, f12062n);
        }

        public void a(Object obj) {
            if (obj instanceof SsManifest.StreamElement) {
                this.f12063e.add((SsManifest.StreamElement) obj);
            } else if (obj instanceof SsManifest.ProtectionElement) {
                Assertions.i(this.f12071m == null);
                this.f12071m = (SsManifest.ProtectionElement) obj;
            }
        }

        public Object b() {
            int size = this.f12063e.size();
            SsManifest.StreamElement[] streamElementArr = new SsManifest.StreamElement[size];
            this.f12063e.toArray(streamElementArr);
            if (this.f12071m != null) {
                SsManifest.ProtectionElement protectionElement = this.f12071m;
                DrmInitData drmInitData = new DrmInitData(new DrmInitData.SchemeData(protectionElement.f12023a, MimeTypes.f9231f, protectionElement.f12024b));
                for (int i2 = 0; i2 < size; i2++) {
                    SsManifest.StreamElement streamElement = streamElementArr[i2];
                    int i3 = streamElement.f12026a;
                    if (i3 == 2 || i3 == 1) {
                        Format[] formatArr = streamElement.f12035j;
                        for (int i4 = 0; i4 < formatArr.length; i4++) {
                            formatArr[i4] = formatArr[i4].c().R(drmInitData).I();
                        }
                    }
                }
            }
            return new SsManifest(this.f12064f, this.f12065g, this.f12066h, this.f12067i, this.f12068j, this.f12069k, this.f12070l, this.f12071m, streamElementArr);
        }

        public void n(XmlPullParser xmlPullParser) throws ParserException {
            this.f12064f = k(xmlPullParser, o);
            this.f12065g = k(xmlPullParser, p);
            this.f12066h = j(xmlPullParser, q, 10000000);
            this.f12067i = l(xmlPullParser, s);
            this.f12068j = j(xmlPullParser, r, 0);
            this.f12069k = i(xmlPullParser, t, -1);
            this.f12070l = g(xmlPullParser, u, false);
            p(q, Long.valueOf(this.f12066h));
        }
    }

    private static class StreamIndexParser extends ElementParser {
        private static final String A = "Url";
        private static final String B = "MaxWidth";
        private static final String C = "MaxHeight";
        private static final String D = "DisplayWidth";
        private static final String E = "DisplayHeight";
        private static final String F = "Language";
        private static final String G = "TimeScale";
        private static final String H = "d";
        private static final String I = "t";
        private static final String J = "r";
        public static final String s = "StreamIndex";
        private static final String t = "c";
        private static final String u = "Type";
        private static final String v = "audio";
        private static final String w = "video";
        private static final String x = "text";
        private static final String y = "Subtype";
        private static final String z = "Name";

        /* renamed from: e  reason: collision with root package name */
        private final String f12072e;

        /* renamed from: f  reason: collision with root package name */
        private final List<Format> f12073f = new LinkedList();

        /* renamed from: g  reason: collision with root package name */
        private int f12074g;

        /* renamed from: h  reason: collision with root package name */
        private String f12075h;

        /* renamed from: i  reason: collision with root package name */
        private long f12076i;

        /* renamed from: j  reason: collision with root package name */
        private String f12077j;

        /* renamed from: k  reason: collision with root package name */
        private String f12078k;

        /* renamed from: l  reason: collision with root package name */
        private int f12079l;

        /* renamed from: m  reason: collision with root package name */
        private int f12080m;

        /* renamed from: n  reason: collision with root package name */
        private int f12081n;
        private int o;
        private String p;
        private ArrayList<Long> q;
        private long r;

        public StreamIndexParser(ElementParser elementParser, String str) {
            super(elementParser, str, s);
            this.f12072e = str;
        }

        private void q(XmlPullParser xmlPullParser) throws ParserException {
            int s2 = s(xmlPullParser);
            this.f12074g = s2;
            p(u, Integer.valueOf(s2));
            this.f12075h = this.f12074g == 3 ? m(xmlPullParser, y) : xmlPullParser.getAttributeValue((String) null, y);
            p(y, this.f12075h);
            String attributeValue = xmlPullParser.getAttributeValue((String) null, z);
            this.f12077j = attributeValue;
            p(z, attributeValue);
            this.f12078k = m(xmlPullParser, A);
            this.f12079l = i(xmlPullParser, B, -1);
            this.f12080m = i(xmlPullParser, C, -1);
            this.f12081n = i(xmlPullParser, D, -1);
            this.o = i(xmlPullParser, E, -1);
            String attributeValue2 = xmlPullParser.getAttributeValue((String) null, F);
            this.p = attributeValue2;
            p(F, attributeValue2);
            long i2 = (long) i(xmlPullParser, G, -1);
            this.f12076i = i2;
            if (i2 == -1) {
                this.f12076i = ((Long) c(G)).longValue();
            }
            this.q = new ArrayList<>();
        }

        private void r(XmlPullParser xmlPullParser) throws ParserException {
            int size = this.q.size();
            long j2 = j(xmlPullParser, I, C.f9084b);
            int i2 = 1;
            if (j2 == C.f9084b) {
                if (size == 0) {
                    j2 = 0;
                } else if (this.r != -1) {
                    j2 = this.q.get(size - 1).longValue() + this.r;
                } else {
                    throw ParserException.c("Unable to infer start time", (Throwable) null);
                }
            }
            this.q.add(Long.valueOf(j2));
            this.r = j(xmlPullParser, "d", C.f9084b);
            long j3 = j(xmlPullParser, J, 1);
            if (j3 <= 1 || this.r != C.f9084b) {
                while (true) {
                    long j4 = (long) i2;
                    if (j4 < j3) {
                        this.q.add(Long.valueOf((this.r * j4) + j2));
                        i2++;
                    } else {
                        return;
                    }
                }
            } else {
                throw ParserException.c("Repeated chunk with unspecified duration", (Throwable) null);
            }
        }

        private int s(XmlPullParser xmlPullParser) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue((String) null, u);
            if (attributeValue == null) {
                throw new MissingFieldException(u);
            } else if ("audio".equalsIgnoreCase(attributeValue)) {
                return 1;
            } else {
                if ("video".equalsIgnoreCase(attributeValue)) {
                    return 2;
                }
                if ("text".equalsIgnoreCase(attributeValue)) {
                    return 3;
                }
                throw ParserException.c("Invalid key value[" + attributeValue + "]", (Throwable) null);
            }
        }

        public void a(Object obj) {
            if (obj instanceof Format) {
                this.f12073f.add((Format) obj);
            }
        }

        public Object b() {
            Format[] formatArr = new Format[this.f12073f.size()];
            this.f12073f.toArray(formatArr);
            SsManifest.StreamElement streamElement = r2;
            SsManifest.StreamElement streamElement2 = new SsManifest.StreamElement(this.f12072e, this.f12078k, this.f12074g, this.f12075h, this.f12076i, this.f12077j, this.f12079l, this.f12080m, this.f12081n, this.o, this.p, formatArr, this.q, this.r);
            return streamElement;
        }

        public boolean d(String str) {
            return t.equals(str);
        }

        public void n(XmlPullParser xmlPullParser) throws ParserException {
            if (t.equals(xmlPullParser.getName())) {
                r(xmlPullParser);
            } else {
                q(xmlPullParser);
            }
        }
    }

    public SsManifestParser() {
        try {
            this.f12040a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    /* renamed from: b */
    public SsManifest a(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser newPullParser = this.f12040a.newPullParser();
            newPullParser.setInput(inputStream, (String) null);
            return (SsManifest) new SmoothStreamingMediaParser((ElementParser) null, uri.toString()).f(newPullParser);
        } catch (XmlPullParserException e2) {
            throw ParserException.c((String) null, e2);
        }
    }
}
