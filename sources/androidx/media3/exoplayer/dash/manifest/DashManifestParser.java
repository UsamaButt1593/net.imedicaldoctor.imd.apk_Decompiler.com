package androidx.media3.exoplayer.dash.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Xml;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.Label;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.UriUtil;
import androidx.media3.common.util.Util;
import androidx.media3.common.util.XmlPullParserUtil;
import androidx.media3.exoplayer.dash.manifest.SegmentBase;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import androidx.media3.extractor.metadata.emsg.EventMessage;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import com.itextpdf.text.xml.xmp.XmpBasicProperties;
import com.itextpdf.tool.xml.html.HTML;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

@UnstableApi
public class DashManifestParser extends DefaultHandler implements ParsingLoadable.Parser<DashManifest> {

    /* renamed from: b  reason: collision with root package name */
    private static final String f11144b = "MpdParser";

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f11145c = Pattern.compile("(\\d+)(?:/(\\d+))?");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f11146d = Pattern.compile("CC([1-4])=.*");

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f11147e = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f11148f = {-1, 1, 2, 3, 4, 5, 6, 8, 2, 3, 4, 7, 8, 24, 8, 12, 10, 12, 14, 12, 14};

    /* renamed from: a  reason: collision with root package name */
    private final XmlPullParserFactory f11149a;

    protected static final class RepresentationInfo {

        /* renamed from: a  reason: collision with root package name */
        public final Format f11150a;

        /* renamed from: b  reason: collision with root package name */
        public final ImmutableList<BaseUrl> f11151b;

        /* renamed from: c  reason: collision with root package name */
        public final SegmentBase f11152c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public final String f11153d;

        /* renamed from: e  reason: collision with root package name */
        public final ArrayList<DrmInitData.SchemeData> f11154e;

        /* renamed from: f  reason: collision with root package name */
        public final ArrayList<Descriptor> f11155f;

        /* renamed from: g  reason: collision with root package name */
        public final long f11156g;

        /* renamed from: h  reason: collision with root package name */
        public final List<Descriptor> f11157h;

        /* renamed from: i  reason: collision with root package name */
        public final List<Descriptor> f11158i;

        public RepresentationInfo(Format format, List<BaseUrl> list, SegmentBase segmentBase, @Nullable String str, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<Descriptor> arrayList2, List<Descriptor> list2, List<Descriptor> list3, long j2) {
            this.f11150a = format;
            this.f11151b = ImmutableList.B(list);
            this.f11152c = segmentBase;
            this.f11153d = str;
            this.f11154e = arrayList;
            this.f11155f = arrayList2;
            this.f11157h = list2;
            this.f11158i = list3;
            this.f11156g = j2;
        }
    }

    public DashManifestParser() {
        try {
            this.f11149a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    protected static int D(List<Descriptor> list) {
        String str;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Descriptor descriptor = list.get(i2);
            if ("urn:scte:dash:cc:cea-608:2015".equals(descriptor.f11159a) && (str = descriptor.f11160b) != null) {
                Matcher matcher = f11146d.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                Log.n(f11144b, "Unable to parse CEA-608 channel number from: " + descriptor.f11160b);
            }
        }
        return -1;
    }

    protected static int E(List<Descriptor> list) {
        String str;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Descriptor descriptor = list.get(i2);
            if ("urn:scte:dash:cc:cea-708:2015".equals(descriptor.f11159a) && (str = descriptor.f11160b) != null) {
                Matcher matcher = f11147e.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                Log.n(f11144b, "Unable to parse CEA-708 service block number from: " + descriptor.f11160b);
            }
        }
        return -1;
    }

    protected static long H(XmlPullParser xmlPullParser, String str, long j2) throws ParserException {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue == null ? j2 : Util.R1(attributeValue);
    }

    protected static Descriptor I(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String r0 = r0(xmlPullParser, "schemeIdUri", "");
        String r02 = r0(xmlPullParser, "value", (String) null);
        String r03 = r0(xmlPullParser, "id", (String) null);
        do {
            xmlPullParser.next();
        } while (!XmlPullParserUtil.d(xmlPullParser, str));
        return new Descriptor(r0, r02, r03);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static int J(org.xmlpull.v1.XmlPullParser r4) {
        /*
            r0 = 2
            r1 = 1
            r2 = 0
            java.lang.String r3 = "value"
            java.lang.String r4 = r4.getAttributeValue(r2, r3)
            r2 = -1
            if (r4 != 0) goto L_0x000d
            return r2
        L_0x000d:
            java.lang.String r4 = com.google.common.base.Ascii.g(r4)
            r4.hashCode()
            int r3 = r4.hashCode()
            switch(r3) {
                case 1596796: goto L_0x0049;
                case 2937391: goto L_0x003e;
                case 3094034: goto L_0x0033;
                case 3094035: goto L_0x0028;
                case 3133436: goto L_0x001d;
                default: goto L_0x001b;
            }
        L_0x001b:
            r4 = -1
            goto L_0x0053
        L_0x001d:
            java.lang.String r3 = "fa01"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x0026
            goto L_0x001b
        L_0x0026:
            r4 = 4
            goto L_0x0053
        L_0x0028:
            java.lang.String r3 = "f801"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x0031
            goto L_0x001b
        L_0x0031:
            r4 = 3
            goto L_0x0053
        L_0x0033:
            java.lang.String r3 = "f800"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x003c
            goto L_0x001b
        L_0x003c:
            r4 = 2
            goto L_0x0053
        L_0x003e:
            java.lang.String r3 = "a000"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x0047
            goto L_0x001b
        L_0x0047:
            r4 = 1
            goto L_0x0053
        L_0x0049:
            java.lang.String r3 = "4000"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x0052
            goto L_0x001b
        L_0x0052:
            r4 = 0
        L_0x0053:
            switch(r4) {
                case 0: goto L_0x005f;
                case 1: goto L_0x005e;
                case 2: goto L_0x005c;
                case 3: goto L_0x005a;
                case 4: goto L_0x0057;
                default: goto L_0x0056;
            }
        L_0x0056:
            return r2
        L_0x0057:
            r4 = 8
            return r4
        L_0x005a:
            r4 = 6
            return r4
        L_0x005c:
            r4 = 5
            return r4
        L_0x005e:
            return r0
        L_0x005f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.manifest.DashManifestParser.J(org.xmlpull.v1.XmlPullParser):int");
    }

    protected static int K(XmlPullParser xmlPullParser) {
        int U = U(xmlPullParser, "value", -1);
        if (U <= 0 || U >= 33) {
            return -1;
        }
        return U;
    }

    protected static int L(XmlPullParser xmlPullParser) {
        int bitCount;
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "value");
        if (attributeValue == null || (bitCount = Integer.bitCount(Integer.parseInt(attributeValue, 16))) == 0) {
            return -1;
        }
        return bitCount;
    }

    protected static long M(XmlPullParser xmlPullParser, String str, long j2) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue == null ? j2 : Util.S1(attributeValue);
    }

    protected static String N(List<Descriptor> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            Descriptor descriptor = list.get(i2);
            String str = descriptor.f11159a;
            if ("tag:dolby.com,2018:dash:EC3_ExtensionType:2018".equals(str) && "JOC".equals(descriptor.f11160b)) {
                return MimeTypes.S;
            }
            if ("tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(str) && MimeTypes.V0.equals(descriptor.f11160b)) {
                return MimeTypes.S;
            }
        }
        return MimeTypes.R;
    }

    protected static float R(XmlPullParser xmlPullParser, String str, float f2) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue == null ? f2 : Float.parseFloat(attributeValue);
    }

    protected static float S(XmlPullParser xmlPullParser, float f2) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "frameRate");
        if (attributeValue == null) {
            return f2;
        }
        Matcher matcher = f11145c.matcher(attributeValue);
        if (!matcher.matches()) {
            return f2;
        }
        int parseInt = Integer.parseInt(matcher.group(1));
        String group = matcher.group(2);
        float f3 = (float) parseInt;
        return !TextUtils.isEmpty(group) ? f3 / ((float) Integer.parseInt(group)) : f3;
    }

    protected static int U(XmlPullParser xmlPullParser, String str, int i2) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue == null ? i2 : Integer.parseInt(attributeValue);
    }

    protected static long W(List<Descriptor> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            Descriptor descriptor = list.get(i2);
            if (Ascii.a("http://dashif.org/guidelines/last-segment-number", descriptor.f11159a)) {
                return Long.parseLong(descriptor.f11160b);
            }
        }
        return -1;
    }

    protected static long X(XmlPullParser xmlPullParser, String str, long j2) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue == null ? j2 : Long.parseLong(attributeValue);
    }

    protected static int Z(XmlPullParser xmlPullParser) {
        int U = U(xmlPullParser, "value", -1);
        if (U < 0) {
            return -1;
        }
        int[] iArr = f11148f;
        if (U < iArr.length) {
            return iArr[U];
        }
        return -1;
    }

    private long b(List<SegmentBase.SegmentTimelineElement> list, long j2, long j3, int i2, long j4) {
        int r = i2 >= 0 ? i2 + 1 : (int) Util.r(j4 - j2, j3);
        for (int i3 = 0; i3 < r; i3++) {
            list.add(m(j2, j3));
            j2 += j3;
        }
        return j2;
    }

    private static int p(int i2, int i3) {
        if (i2 == -1) {
            return i3;
        }
        if (i3 == -1) {
            return i2;
        }
        Assertions.i(i2 == i3);
        return i2;
    }

    @Nullable
    private static String q(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        Assertions.i(str.equals(str2));
        return str;
    }

    private static void r(ArrayList<DrmInitData.SchemeData> arrayList) {
        String str;
        int i2 = 0;
        while (true) {
            if (i2 >= arrayList.size()) {
                str = null;
                break;
            }
            DrmInitData.SchemeData schemeData = arrayList.get(i2);
            if (C.j2.equals(schemeData.X) && (str = schemeData.Y) != null) {
                arrayList.remove(i2);
                break;
            }
            i2++;
        }
        if (str != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                DrmInitData.SchemeData schemeData2 = arrayList.get(i3);
                if (C.i2.equals(schemeData2.X) && schemeData2.Y == null) {
                    arrayList.set(i3, new DrmInitData.SchemeData(C.j2, str, schemeData2.Z, schemeData2.X2));
                }
            }
        }
    }

    protected static String r0(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    private static void s(ArrayList<DrmInitData.SchemeData> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            DrmInitData.SchemeData schemeData = arrayList.get(size);
            if (!schemeData.c()) {
                int i2 = 0;
                while (true) {
                    if (i2 >= arrayList.size()) {
                        break;
                    } else if (arrayList.get(i2).a(schemeData)) {
                        arrayList.remove(size);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
    }

    protected static String s0(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String str2 = "";
        do {
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 4) {
                str2 = xmlPullParser.getText();
            } else {
                w(xmlPullParser);
            }
        } while (!XmlPullParserUtil.d(xmlPullParser, str));
        return str2;
    }

    private static long t(long j2, long j3) {
        if (j3 != C.f9084b) {
            j2 = j3;
        }
        return j2 == Long.MAX_VALUE ? C.f9084b : j2;
    }

    @Nullable
    private static String u(@Nullable String str, @Nullable String str2) {
        if (MimeTypes.p(str)) {
            return MimeTypes.c(str2);
        }
        if (MimeTypes.t(str)) {
            return MimeTypes.o(str2);
        }
        if (MimeTypes.s(str) || MimeTypes.q(str)) {
            return str;
        }
        if (!MimeTypes.p0.equals(str)) {
            return null;
        }
        String g2 = MimeTypes.g(str2);
        return MimeTypes.m0.equals(g2) ? MimeTypes.B0 : g2;
    }

    private boolean v(String[] strArr) {
        for (String startsWith : strArr) {
            if (startsWith.startsWith("urn:dvb:dash:profile:dvb-dash:")) {
                return true;
            }
        }
        return false;
    }

    public static void w(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        if (XmlPullParserUtil.e(xmlPullParser)) {
            int i2 = 1;
            while (i2 != 0) {
                xmlPullParser.next();
                if (XmlPullParserUtil.e(xmlPullParser)) {
                    i2++;
                } else if (XmlPullParserUtil.c(xmlPullParser)) {
                    i2--;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int A(org.xmlpull.v1.XmlPullParser r4) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r3 = this;
            java.lang.String r0 = "schemeIdUri"
            r1 = 0
            java.lang.String r0 = r0(r4, r0, r1)
            r0.hashCode()
            r1 = -1
            int r2 = r0.hashCode()
            switch(r2) {
                case -2128649360: goto L_0x0056;
                case -1352850286: goto L_0x004b;
                case -1138141449: goto L_0x0040;
                case -986633423: goto L_0x0035;
                case -79006963: goto L_0x002a;
                case 312179081: goto L_0x001f;
                case 2036691300: goto L_0x0014;
                default: goto L_0x0012;
            }
        L_0x0012:
            r0 = -1
            goto L_0x0060
        L_0x0014:
            java.lang.String r2 = "urn:dolby:dash:audio_channel_configuration:2011"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x001d
            goto L_0x0012
        L_0x001d:
            r0 = 6
            goto L_0x0060
        L_0x001f:
            java.lang.String r2 = "tag:dts.com,2018:uhd:audio_channel_configuration"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0028
            goto L_0x0012
        L_0x0028:
            r0 = 5
            goto L_0x0060
        L_0x002a:
            java.lang.String r2 = "tag:dts.com,2014:dash:audio_channel_configuration:2012"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0033
            goto L_0x0012
        L_0x0033:
            r0 = 4
            goto L_0x0060
        L_0x0035:
            java.lang.String r2 = "urn:mpeg:mpegB:cicp:ChannelConfiguration"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x003e
            goto L_0x0012
        L_0x003e:
            r0 = 3
            goto L_0x0060
        L_0x0040:
            java.lang.String r2 = "tag:dolby.com,2014:dash:audio_channel_configuration:2011"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0049
            goto L_0x0012
        L_0x0049:
            r0 = 2
            goto L_0x0060
        L_0x004b:
            java.lang.String r2 = "urn:mpeg:dash:23003:3:audio_channel_configuration:2011"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0054
            goto L_0x0012
        L_0x0054:
            r0 = 1
            goto L_0x0060
        L_0x0056:
            java.lang.String r2 = "urn:dts:dash:audio_channel_configuration:2012"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x005f
            goto L_0x0012
        L_0x005f:
            r0 = 0
        L_0x0060:
            switch(r0) {
                case 0: goto L_0x007a;
                case 1: goto L_0x0073;
                case 2: goto L_0x006e;
                case 3: goto L_0x0069;
                case 4: goto L_0x007a;
                case 5: goto L_0x0064;
                case 6: goto L_0x006e;
                default: goto L_0x0063;
            }
        L_0x0063:
            goto L_0x007e
        L_0x0064:
            int r1 = L(r4)
            goto L_0x007e
        L_0x0069:
            int r1 = Z(r4)
            goto L_0x007e
        L_0x006e:
            int r1 = J(r4)
            goto L_0x007e
        L_0x0073:
            java.lang.String r0 = "value"
            int r1 = U(r4, r0, r1)
            goto L_0x007e
        L_0x007a:
            int r1 = K(r4)
        L_0x007e:
            r4.next()
            java.lang.String r0 = "AudioChannelConfiguration"
            boolean r0 = androidx.media3.common.util.XmlPullParserUtil.d(r4, r0)
            if (r0 == 0) goto L_0x007e
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.manifest.DashManifestParser.A(org.xmlpull.v1.XmlPullParser):int");
    }

    /* access modifiers changed from: protected */
    public long B(XmlPullParser xmlPullParser, long j2) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "availabilityTimeOffset");
        if (attributeValue == null) {
            return j2;
        }
        if ("INF".equals(attributeValue)) {
            return Long.MAX_VALUE;
        }
        return (long) (Float.parseFloat(attributeValue) * 1000000.0f);
    }

    /* access modifiers changed from: protected */
    public List<BaseUrl> C(XmlPullParser xmlPullParser, List<BaseUrl> list, boolean z) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "dvb:priority");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : z ? 1 : Integer.MIN_VALUE;
        String attributeValue2 = xmlPullParser.getAttributeValue((String) null, "dvb:weight");
        int parseInt2 = attributeValue2 != null ? Integer.parseInt(attributeValue2) : 1;
        String attributeValue3 = xmlPullParser.getAttributeValue((String) null, "serviceLocation");
        String s0 = s0(xmlPullParser, XmpBasicProperties.f27414b);
        if (UriUtil.c(s0)) {
            if (attributeValue3 == null) {
                attributeValue3 = s0;
            }
            return Lists.t(new BaseUrl(s0, attributeValue3, parseInt, parseInt2));
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            BaseUrl baseUrl = list.get(i2);
            String f2 = UriUtil.f(baseUrl.f11127a, s0);
            String str = attributeValue3 == null ? f2 : attributeValue3;
            if (z) {
                parseInt = baseUrl.f11129c;
                parseInt2 = baseUrl.f11130d;
                str = baseUrl.f11128b;
            }
            arrayList.add(new BaseUrl(f2, str, parseInt, parseInt2));
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v22, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v25, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v26, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v27, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v28, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: java.lang.String} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0090, code lost:
        r1 = null;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.util.Pair<java.lang.String, androidx.media3.common.DrmInitData.SchemeData> F(org.xmlpull.v1.XmlPullParser r12) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r11 = this;
            r0 = 1
            java.lang.String r1 = "schemeIdUri"
            r2 = 0
            java.lang.String r1 = r12.getAttributeValue(r2, r1)
            java.lang.String r3 = "MpdParser"
            r4 = 0
            if (r1 == 0) goto L_0x0099
            java.lang.String r1 = com.google.common.base.Ascii.g(r1)
            r1.hashCode()
            r5 = -1
            int r6 = r1.hashCode()
            switch(r6) {
                case -1980789791: goto L_0x003e;
                case 489446379: goto L_0x0033;
                case 755418770: goto L_0x0028;
                case 1812765994: goto L_0x001d;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x0048
        L_0x001d:
            java.lang.String r6 = "urn:mpeg:dash:mp4protection:2011"
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x0026
            goto L_0x0048
        L_0x0026:
            r5 = 3
            goto L_0x0048
        L_0x0028:
            java.lang.String r6 = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed"
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x0031
            goto L_0x0048
        L_0x0031:
            r5 = 2
            goto L_0x0048
        L_0x0033:
            java.lang.String r6 = "urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95"
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x003c
            goto L_0x0048
        L_0x003c:
            r5 = 1
            goto L_0x0048
        L_0x003e:
            java.lang.String r6 = "urn:uuid:e2719d58-a985-b3c9-781a-b030af78d30e"
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x0047
            goto L_0x0048
        L_0x0047:
            r5 = 0
        L_0x0048:
            switch(r5) {
                case 0: goto L_0x0096;
                case 1: goto L_0x0093;
                case 2: goto L_0x008e;
                case 3: goto L_0x004c;
                default: goto L_0x004b;
            }
        L_0x004b:
            goto L_0x0099
        L_0x004c:
            java.lang.String r1 = "value"
            java.lang.String r1 = r12.getAttributeValue(r2, r1)
            java.lang.String r5 = "default_KID"
            java.lang.String r5 = androidx.media3.common.util.XmlPullParserUtil.b(r12, r5)
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x0085
            java.lang.String r6 = "00000000-0000-0000-0000-000000000000"
            boolean r6 = r6.equals(r5)
            if (r6 != 0) goto L_0x0085
            java.lang.String r6 = "\\s+"
            java.lang.String[] r5 = r5.split(r6)
            int r6 = r5.length
            java.util.UUID[] r6 = new java.util.UUID[r6]
            r7 = 0
        L_0x0070:
            int r8 = r5.length
            if (r7 >= r8) goto L_0x007d
            r8 = r5[r7]
            java.util.UUID r8 = java.util.UUID.fromString(r8)
            r6[r7] = r8
            int r7 = r7 + r0
            goto L_0x0070
        L_0x007d:
            java.util.UUID r0 = androidx.media3.common.C.i2
            byte[] r5 = androidx.media3.extractor.mp4.PsshAtomUtil.b(r0, r6, r2)
            r6 = r2
            goto L_0x009c
        L_0x0085:
            java.lang.String r0 = "Ignoring <ContentProtection> with schemeIdUri=\"urn:mpeg:dash:mp4protection:2011\" (ClearKey) due to missing required default_KID attribute."
            androidx.media3.common.util.Log.n(r3, r0)
            r0 = r2
            r5 = r0
        L_0x008c:
            r6 = r5
            goto L_0x009c
        L_0x008e:
            java.util.UUID r0 = androidx.media3.common.C.k2
        L_0x0090:
            r1 = r2
        L_0x0091:
            r5 = r1
            goto L_0x008c
        L_0x0093:
            java.util.UUID r0 = androidx.media3.common.C.l2
            goto L_0x0090
        L_0x0096:
            java.util.UUID r0 = androidx.media3.common.C.j2
            goto L_0x0090
        L_0x0099:
            r0 = r2
            r1 = r0
            goto L_0x0091
        L_0x009c:
            r12.next()
            java.lang.String r7 = "clearkey:Laurl"
            boolean r7 = androidx.media3.common.util.XmlPullParserUtil.f(r12, r7)
            r8 = 4
            if (r7 == 0) goto L_0x00b3
            int r7 = r12.next()
            if (r7 != r8) goto L_0x00b3
            java.lang.String r6 = r12.getText()
            goto L_0x0114
        L_0x00b3:
            java.lang.String r7 = "ms:laurl"
            boolean r7 = androidx.media3.common.util.XmlPullParserUtil.f(r12, r7)
            if (r7 == 0) goto L_0x00c2
            java.lang.String r6 = "licenseUrl"
            java.lang.String r6 = r12.getAttributeValue(r2, r6)
            goto L_0x0114
        L_0x00c2:
            if (r5 != 0) goto L_0x00ec
            java.lang.String r7 = "pssh"
            boolean r7 = androidx.media3.common.util.XmlPullParserUtil.g(r12, r7)
            if (r7 == 0) goto L_0x00ec
            int r7 = r12.next()
            if (r7 != r8) goto L_0x00ec
            java.lang.String r0 = r12.getText()
            byte[] r0 = android.util.Base64.decode(r0, r4)
            java.util.UUID r5 = androidx.media3.extractor.mp4.PsshAtomUtil.f(r0)
            if (r5 != 0) goto L_0x00e8
            java.lang.String r0 = "Skipping malformed cenc:pssh data"
            androidx.media3.common.util.Log.n(r3, r0)
            r0 = r5
            r5 = r2
            goto L_0x0114
        L_0x00e8:
            r10 = r5
            r5 = r0
            r0 = r10
            goto L_0x0114
        L_0x00ec:
            if (r5 != 0) goto L_0x0111
            java.util.UUID r7 = androidx.media3.common.C.l2
            boolean r9 = r7.equals(r0)
            if (r9 == 0) goto L_0x0111
            java.lang.String r9 = "mspr:pro"
            boolean r9 = androidx.media3.common.util.XmlPullParserUtil.f(r12, r9)
            if (r9 == 0) goto L_0x0111
            int r9 = r12.next()
            if (r9 != r8) goto L_0x0111
            java.lang.String r5 = r12.getText()
            byte[] r5 = android.util.Base64.decode(r5, r4)
            byte[] r5 = androidx.media3.extractor.mp4.PsshAtomUtil.a(r7, r5)
            goto L_0x0114
        L_0x0111:
            w(r12)
        L_0x0114:
            java.lang.String r7 = "ContentProtection"
            boolean r7 = androidx.media3.common.util.XmlPullParserUtil.d(r12, r7)
            if (r7 == 0) goto L_0x009c
            if (r0 == 0) goto L_0x0125
            androidx.media3.common.DrmInitData$SchemeData r2 = new androidx.media3.common.DrmInitData$SchemeData
            java.lang.String r12 = "video/mp4"
            r2.<init>(r0, r6, r12, r5)
        L_0x0125:
            android.util.Pair r12 = android.util.Pair.create(r1, r2)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.manifest.DashManifestParser.F(org.xmlpull.v1.XmlPullParser):android.util.Pair");
    }

    /* access modifiers changed from: protected */
    public int G(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if ("audio".equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        if ("text".equals(attributeValue)) {
            return 3;
        }
        return "image".equals(attributeValue) ? 4 : -1;
    }

    /* access modifiers changed from: protected */
    public Pair<Long, EventMessage> O(XmlPullParser xmlPullParser, String str, String str2, long j2, long j3, ByteArrayOutputStream byteArrayOutputStream) throws IOException, XmlPullParserException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        long X = X(xmlPullParser2, "id", 0);
        long X2 = X(xmlPullParser2, TypedValues.TransitionType.f4025b, C.f9084b);
        long X3 = X(xmlPullParser2, "presentationTime", 0);
        long c2 = Util.c2(X2, 1000, j2);
        long c22 = Util.c2(X3 - j3, 1000000, j2);
        String r0 = r0(xmlPullParser2, "messageData", (String) null);
        byte[] P = P(xmlPullParser2, byteArrayOutputStream);
        Long valueOf = Long.valueOf(c22);
        if (r0 != null) {
            P = Util.R0(r0);
        }
        return Pair.create(valueOf, d(str, str2, X, c2, P));
    }

    /* access modifiers changed from: protected */
    public byte[] P(XmlPullParser xmlPullParser, ByteArrayOutputStream byteArrayOutputStream) throws XmlPullParserException, IOException {
        byteArrayOutputStream.reset();
        XmlSerializer newSerializer = Xml.newSerializer();
        newSerializer.setOutput(byteArrayOutputStream, Charsets.f22255c.name());
        while (true) {
            xmlPullParser.nextToken();
            if (!XmlPullParserUtil.d(xmlPullParser, "Event")) {
                switch (xmlPullParser.getEventType()) {
                    case 0:
                        newSerializer.startDocument((String) null, Boolean.FALSE);
                        break;
                    case 1:
                        newSerializer.endDocument();
                        break;
                    case 2:
                        newSerializer.startTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                        for (int i2 = 0; i2 < xmlPullParser.getAttributeCount(); i2++) {
                            newSerializer.attribute(xmlPullParser.getAttributeNamespace(i2), xmlPullParser.getAttributeName(i2), xmlPullParser.getAttributeValue(i2));
                        }
                        break;
                    case 3:
                        newSerializer.endTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                        break;
                    case 4:
                        newSerializer.text(xmlPullParser.getText());
                        break;
                    case 5:
                        newSerializer.cdsect(xmlPullParser.getText());
                        break;
                    case 6:
                        newSerializer.entityRef(xmlPullParser.getText());
                        break;
                    case 7:
                        newSerializer.ignorableWhitespace(xmlPullParser.getText());
                        break;
                    case 8:
                        newSerializer.processingInstruction(xmlPullParser.getText());
                        break;
                    case 9:
                        newSerializer.comment(xmlPullParser.getText());
                        break;
                    case 10:
                        newSerializer.docdecl(xmlPullParser.getText());
                        break;
                }
            } else {
                newSerializer.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    /* access modifiers changed from: protected */
    public EventStream Q(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        long j2;
        ByteArrayOutputStream byteArrayOutputStream;
        ArrayList arrayList;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        String r0 = r0(xmlPullParser2, "schemeIdUri", "");
        String r02 = r0(xmlPullParser2, "value", "");
        long X = X(xmlPullParser2, "timescale", 1);
        long X2 = X(xmlPullParser2, "presentationTimeOffset", 0);
        ArrayList arrayList2 = new ArrayList();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(512);
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser2, "Event")) {
                byteArrayOutputStream = byteArrayOutputStream2;
                long j3 = X2;
                j2 = X2;
                arrayList = arrayList2;
                arrayList.add(O(xmlPullParser, r0, r02, X, j3, byteArrayOutputStream));
            } else {
                byteArrayOutputStream = byteArrayOutputStream2;
                j2 = X2;
                arrayList = arrayList2;
                w(xmlPullParser);
            }
            if (XmlPullParserUtil.d(xmlPullParser2, "EventStream")) {
                break;
            }
            arrayList2 = arrayList;
            byteArrayOutputStream2 = byteArrayOutputStream;
            X2 = j2;
        }
        long[] jArr = new long[arrayList.size()];
        EventMessage[] eventMessageArr = new EventMessage[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Pair pair = (Pair) arrayList.get(i2);
            jArr[i2] = ((Long) pair.first).longValue();
            eventMessageArr[i2] = (EventMessage) pair.second;
        }
        return e(r0, r02, X, jArr, eventMessageArr);
    }

    /* access modifiers changed from: protected */
    public RangedUri T(XmlPullParser xmlPullParser) {
        return d0(xmlPullParser, "sourceURL", "range");
    }

    /* access modifiers changed from: protected */
    public Label V(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return new Label(xmlPullParser.getAttributeValue((String) null, "lang"), s0(xmlPullParser, "Label"));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01dc A[LOOP:0: B:22:0x00a0->B:77:0x01dc, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0197 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.media3.exoplayer.dash.manifest.DashManifest Y(org.xmlpull.v1.XmlPullParser r47, android.net.Uri r48) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r46 = this;
            r14 = r46
            r12 = r47
            r13 = 1
            r0 = 0
            java.lang.String[] r1 = new java.lang.String[r0]
            java.lang.String r2 = "profiles"
            java.lang.String[] r1 = r14.b0(r12, r2, r1)
            boolean r15 = r14.v(r1)
            java.lang.String r1 = "availabilityStartTime"
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r16 = H(r12, r1, r9)
            java.lang.String r1 = "mediaPresentationDuration"
            long r18 = M(r12, r1, r9)
            java.lang.String r1 = "minBufferTime"
            long r20 = M(r12, r1, r9)
            java.lang.String r1 = "type"
            r11 = 0
            java.lang.String r1 = r12.getAttributeValue(r11, r1)
            java.lang.String r2 = "dynamic"
            boolean r22 = r2.equals(r1)
            if (r22 == 0) goto L_0x0041
            java.lang.String r1 = "minimumUpdatePeriod"
            long r1 = M(r12, r1, r9)
            r23 = r1
            goto L_0x0043
        L_0x0041:
            r23 = r9
        L_0x0043:
            if (r22 == 0) goto L_0x004e
            java.lang.String r1 = "timeShiftBufferDepth"
            long r1 = M(r12, r1, r9)
            r25 = r1
            goto L_0x0050
        L_0x004e:
            r25 = r9
        L_0x0050:
            if (r22 == 0) goto L_0x005b
            java.lang.String r1 = "suggestedPresentationDelay"
            long r1 = M(r12, r1, r9)
            r27 = r1
            goto L_0x005d
        L_0x005b:
            r27 = r9
        L_0x005d:
            java.lang.String r1 = "publishTime"
            long r29 = H(r12, r1, r9)
            r1 = 0
            if (r22 == 0) goto L_0x0069
            r3 = r1
            goto L_0x006a
        L_0x0069:
            r3 = r9
        L_0x006a:
            androidx.media3.exoplayer.dash.manifest.BaseUrl r5 = new androidx.media3.exoplayer.dash.manifest.BaseUrl
            java.lang.String r6 = r48.toString()
            java.lang.String r7 = r48.toString()
            if (r15 == 0) goto L_0x0078
            r8 = 1
            goto L_0x007a
        L_0x0078:
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x007a:
            r5.<init>(r6, r7, r8, r13)
            androidx.media3.exoplayer.dash.manifest.BaseUrl[] r6 = new androidx.media3.exoplayer.dash.manifest.BaseUrl[r13]
            r6[r0] = r5
            java.util.ArrayList r7 = com.google.common.collect.Lists.t(r6)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            if (r22 == 0) goto L_0x0092
            r1 = r9
        L_0x0092:
            r33 = r1
            r35 = r11
            r36 = r35
            r37 = r36
            r38 = r37
            r31 = 0
            r32 = 0
        L_0x00a0:
            r47.next()
            java.lang.String r0 = "BaseURL"
            boolean r0 = androidx.media3.common.util.XmlPullParserUtil.f(r12, r0)
            if (r0 == 0) goto L_0x00c4
            if (r31 != 0) goto L_0x00b3
            long r3 = r14.B(r12, r3)
            r31 = 1
        L_0x00b3:
            java.util.List r0 = r14.C(r12, r7, r15)
            r5.addAll(r0)
        L_0x00ba:
            r41 = r5
            r42 = r7
            r44 = r9
            r13 = r11
            r11 = r8
            goto L_0x018f
        L_0x00c4:
            java.lang.String r0 = "ProgramInformation"
            boolean r0 = androidx.media3.common.util.XmlPullParserUtil.f(r12, r0)
            if (r0 == 0) goto L_0x00d3
            androidx.media3.exoplayer.dash.manifest.ProgramInformation r0 = r46.c0(r47)
            r35 = r0
            goto L_0x00ba
        L_0x00d3:
            java.lang.String r0 = "UTCTiming"
            boolean r0 = androidx.media3.common.util.XmlPullParserUtil.f(r12, r0)
            if (r0 == 0) goto L_0x00e2
            androidx.media3.exoplayer.dash.manifest.UtcTimingElement r0 = r46.w0(r47)
            r36 = r0
            goto L_0x00ba
        L_0x00e2:
            java.lang.String r0 = "Location"
            boolean r0 = androidx.media3.common.util.XmlPullParserUtil.f(r12, r0)
            if (r0 == 0) goto L_0x00f9
            java.lang.String r0 = r48.toString()
            java.lang.String r1 = r47.nextText()
            android.net.Uri r0 = androidx.media3.common.util.UriUtil.g(r0, r1)
            r37 = r0
            goto L_0x00ba
        L_0x00f9:
            java.lang.String r0 = "ServiceDescription"
            boolean r0 = androidx.media3.common.util.XmlPullParserUtil.f(r12, r0)
            if (r0 == 0) goto L_0x0108
            androidx.media3.exoplayer.dash.manifest.ServiceDescriptionElement r0 = r46.q0(r47)
            r38 = r0
            goto L_0x00ba
        L_0x0108:
            java.lang.String r0 = "Period"
            boolean r0 = androidx.media3.common.util.XmlPullParserUtil.f(r12, r0)
            if (r0 == 0) goto L_0x0181
            if (r32 != 0) goto L_0x0181
            boolean r0 = r5.isEmpty()
            if (r0 != 0) goto L_0x011a
            r2 = r5
            goto L_0x011b
        L_0x011a:
            r2 = r7
        L_0x011b:
            r0 = r46
            r1 = r47
            r39 = r3
            r3 = r33
            r41 = r5
            r5 = r39
            r42 = r7
            r43 = r8
            r7 = r16
            r44 = r9
            r9 = r25
            r13 = r11
            r11 = r15
            android.util.Pair r0 = r0.a0(r1, r2, r3, r5, r7, r9, r11)
            java.lang.Object r1 = r0.first
            androidx.media3.exoplayer.dash.manifest.Period r1 = (androidx.media3.exoplayer.dash.manifest.Period) r1
            long r2 = r1.f11168b
            int r4 = (r2 > r44 ? 1 : (r2 == r44 ? 0 : -1))
            if (r4 != 0) goto L_0x0162
            if (r22 == 0) goto L_0x0148
            r11 = r43
            r32 = 1
            goto L_0x017e
        L_0x0148:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unable to determine start of period "
            r0.append(r1)
            int r1 = r43.size()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            androidx.media3.common.ParserException r0 = androidx.media3.common.ParserException.c(r0, r13)
            throw r0
        L_0x0162:
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r2 = r0.longValue()
            int r0 = (r2 > r44 ? 1 : (r2 == r44 ? 0 : -1))
            if (r0 != 0) goto L_0x0173
            r11 = r43
            r9 = r44
            goto L_0x0179
        L_0x0173:
            long r4 = r1.f11168b
            long r9 = r4 + r2
            r11 = r43
        L_0x0179:
            r11.add(r1)
            r33 = r9
        L_0x017e:
            r3 = r39
            goto L_0x018f
        L_0x0181:
            r39 = r3
            r41 = r5
            r42 = r7
            r44 = r9
            r13 = r11
            r11 = r8
            w(r47)
            goto L_0x017e
        L_0x018f:
            java.lang.String r0 = "MPD"
            boolean r0 = androidx.media3.common.util.XmlPullParserUtil.d(r12, r0)
            if (r0 == 0) goto L_0x01dc
            int r0 = (r18 > r44 ? 1 : (r18 == r44 ? 0 : -1))
            if (r0 != 0) goto L_0x01ac
            int r0 = (r33 > r44 ? 1 : (r33 == r44 ? 0 : -1))
            if (r0 == 0) goto L_0x01a2
            r3 = r33
            goto L_0x01ae
        L_0x01a2:
            if (r22 == 0) goto L_0x01a5
            goto L_0x01ac
        L_0x01a5:
            java.lang.String r0 = "Unable to determine duration of static manifest."
            androidx.media3.common.ParserException r0 = androidx.media3.common.ParserException.c(r0, r13)
            throw r0
        L_0x01ac:
            r3 = r18
        L_0x01ae:
            boolean r0 = r11.isEmpty()
            if (r0 != 0) goto L_0x01d5
            r0 = r46
            r1 = r16
            r5 = r20
            r7 = r22
            r8 = r23
            r39 = r11
            r10 = r25
            r12 = r27
            r14 = r29
            r16 = r35
            r17 = r36
            r18 = r38
            r19 = r37
            r20 = r39
            androidx.media3.exoplayer.dash.manifest.DashManifest r0 = r0.g(r1, r3, r5, r7, r8, r10, r12, r14, r16, r17, r18, r19, r20)
            return r0
        L_0x01d5:
            java.lang.String r0 = "No periods found."
            androidx.media3.common.ParserException r0 = androidx.media3.common.ParserException.c(r0, r13)
            throw r0
        L_0x01dc:
            r14 = r46
            r8 = r11
            r11 = r13
            r5 = r41
            r7 = r42
            r9 = r44
            r13 = 1
            goto L_0x00a0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.manifest.DashManifestParser.Y(org.xmlpull.v1.XmlPullParser, android.net.Uri):androidx.media3.exoplayer.dash.manifest.DashManifest");
    }

    /* access modifiers changed from: protected */
    public Pair<Period, Long> a0(XmlPullParser xmlPullParser, List<BaseUrl> list, long j2, long j3, long j4, long j5, boolean z) throws XmlPullParserException, IOException {
        long j6;
        ArrayList arrayList;
        Object obj;
        ArrayList arrayList2;
        ArrayList arrayList3;
        long j7;
        long j8;
        SegmentBase l0;
        DashManifestParser dashManifestParser = this;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        Object obj2 = null;
        String attributeValue = xmlPullParser2.getAttributeValue((String) null, "id");
        long M = M(xmlPullParser2, "start", j2);
        long j9 = C.f9084b;
        long j10 = j4 != C.f9084b ? j4 + M : -9223372036854775807L;
        long M2 = M(xmlPullParser2, TypedValues.TransitionType.f4025b, C.f9084b);
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        long j11 = j3;
        long j12 = -9223372036854775807L;
        SegmentBase segmentBase = null;
        Descriptor descriptor = null;
        boolean z2 = false;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser2, XmpBasicProperties.f27414b)) {
                if (!z2) {
                    j11 = dashManifestParser.B(xmlPullParser2, j11);
                    z2 = true;
                }
                arrayList6.addAll(dashManifestParser.C(xmlPullParser2, list, z));
                arrayList = arrayList5;
                arrayList2 = arrayList6;
                j6 = j9;
                obj = obj2;
                arrayList3 = arrayList4;
            } else {
                List<BaseUrl> list2 = list;
                boolean z3 = z;
                if (XmlPullParserUtil.f(xmlPullParser2, "AdaptationSet")) {
                    j7 = j11;
                    arrayList2 = arrayList6;
                    arrayList3 = arrayList4;
                    arrayList3.add(y(xmlPullParser, !arrayList6.isEmpty() ? arrayList6 : list2, segmentBase, M2, j11, j12, j10, j5, z));
                    xmlPullParser2 = xmlPullParser;
                    arrayList = arrayList5;
                } else {
                    j7 = j11;
                    ArrayList arrayList7 = arrayList5;
                    arrayList2 = arrayList6;
                    arrayList3 = arrayList4;
                    xmlPullParser2 = xmlPullParser;
                    if (XmlPullParserUtil.f(xmlPullParser2, "EventStream")) {
                        ArrayList arrayList8 = arrayList7;
                        arrayList8.add(Q(xmlPullParser));
                        arrayList = arrayList8;
                    } else {
                        arrayList = arrayList7;
                        if (XmlPullParserUtil.f(xmlPullParser2, "SegmentBase")) {
                            segmentBase = j0(xmlPullParser2, (SegmentBase.SingleSegmentBase) null);
                            obj = null;
                            j11 = j7;
                            j6 = C.f9084b;
                        } else {
                            if (XmlPullParserUtil.f(xmlPullParser2, "SegmentList")) {
                                long B = B(xmlPullParser2, C.f9084b);
                                obj = null;
                                l0 = k0(xmlPullParser, (SegmentBase.SegmentList) null, j10, M2, j7, B, j5);
                                j12 = B;
                                j11 = j7;
                                j6 = C.f9084b;
                            } else {
                                obj = null;
                                if (XmlPullParserUtil.f(xmlPullParser2, "SegmentTemplate")) {
                                    long B2 = B(xmlPullParser2, C.f9084b);
                                    j6 = -9223372036854775807L;
                                    l0 = l0(xmlPullParser, (SegmentBase.SegmentTemplate) null, ImmutableList.I(), j10, M2, j7, B2, j5);
                                    j12 = B2;
                                    j11 = j7;
                                } else {
                                    j8 = C.f9084b;
                                    if (XmlPullParserUtil.f(xmlPullParser2, "AssetIdentifier")) {
                                        descriptor = I(xmlPullParser2, "AssetIdentifier");
                                    } else {
                                        w(xmlPullParser);
                                    }
                                    j11 = j7;
                                }
                            }
                            segmentBase = l0;
                        }
                    }
                }
                obj = null;
                j8 = C.f9084b;
                j11 = j7;
            }
            if (XmlPullParserUtil.d(xmlPullParser2, "Period")) {
                return Pair.create(h(attributeValue, M, arrayList3, arrayList, descriptor), Long.valueOf(M2));
            }
            arrayList4 = arrayList3;
            arrayList6 = arrayList2;
            obj2 = obj;
            arrayList5 = arrayList;
            j9 = j6;
            dashManifestParser = this;
        }
    }

    /* access modifiers changed from: protected */
    public String[] b0(XmlPullParser xmlPullParser, String str, String[] strArr) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue == null ? strArr : attributeValue.split(",");
    }

    /* access modifiers changed from: protected */
    public AdaptationSet c(long j2, int i2, List<Representation> list, List<Descriptor> list2, List<Descriptor> list3, List<Descriptor> list4) {
        return new AdaptationSet(j2, i2, list, list2, list3, list4);
    }

    /* access modifiers changed from: protected */
    public ProgramInformation c0(XmlPullParser xmlPullParser) throws IOException, XmlPullParserException {
        String str = null;
        String r0 = r0(xmlPullParser, "moreInformationURL", (String) null);
        String r02 = r0(xmlPullParser, "lang", (String) null);
        String str2 = null;
        String str3 = null;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser, "Title")) {
                str = xmlPullParser.nextText();
            } else if (XmlPullParserUtil.f(xmlPullParser, "Source")) {
                str2 = xmlPullParser.nextText();
            } else if (XmlPullParserUtil.f(xmlPullParser, ExifInterface.a0)) {
                str3 = xmlPullParser.nextText();
            } else {
                w(xmlPullParser);
            }
            String str4 = str3;
            if (XmlPullParserUtil.d(xmlPullParser, "ProgramInformation")) {
                return new ProgramInformation(str, str2, str4, r0, r02);
            }
            str3 = str4;
        }
    }

    /* access modifiers changed from: protected */
    public EventMessage d(String str, String str2, long j2, long j3, byte[] bArr) {
        return new EventMessage(str, str2, j3, j2, bArr);
    }

    /* access modifiers changed from: protected */
    public RangedUri d0(XmlPullParser xmlPullParser, String str, String str2) {
        long j2;
        long j3;
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue((String) null, str2);
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split("-");
            j2 = Long.parseLong(split[0]);
            if (split.length == 2) {
                j3 = (Long.parseLong(split[1]) - j2) + 1;
            }
            j3 = -1;
        } else {
            j2 = 0;
            j3 = -1;
        }
        return i(attributeValue, j2, j3);
    }

    /* access modifiers changed from: protected */
    public EventStream e(String str, String str2, long j2, long[] jArr, EventMessage[] eventMessageArr) {
        return new EventStream(str, str2, j2, jArr, eventMessageArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v0, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v4, resolved type: androidx.media3.exoplayer.dash.manifest.SegmentBase$SingleSegmentBase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v3, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v4, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v5, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v6, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v7, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v8, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v9, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v10, resolved type: java.util.ArrayList} */
    /* JADX WARNING: type inference failed for: r31v1 */
    /* JADX WARNING: type inference failed for: r31v2 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01ee A[LOOP:0: B:1:0x006a->B:53:0x01ee, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0198 A[EDGE_INSN: B:54:0x0198->B:45:0x0198 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.media3.exoplayer.dash.manifest.DashManifestParser.RepresentationInfo e0(org.xmlpull.v1.XmlPullParser r36, java.util.List<androidx.media3.exoplayer.dash.manifest.BaseUrl> r37, @androidx.annotation.Nullable java.lang.String r38, @androidx.annotation.Nullable java.lang.String r39, int r40, int r41, float r42, int r43, int r44, @androidx.annotation.Nullable java.lang.String r45, java.util.List<androidx.media3.exoplayer.dash.manifest.Descriptor> r46, java.util.List<androidx.media3.exoplayer.dash.manifest.Descriptor> r47, java.util.List<androidx.media3.exoplayer.dash.manifest.Descriptor> r48, java.util.List<androidx.media3.exoplayer.dash.manifest.Descriptor> r49, @androidx.annotation.Nullable androidx.media3.exoplayer.dash.manifest.SegmentBase r50, long r51, long r53, long r55, long r57, long r59, boolean r61) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r35 = this;
            r15 = r35
            r14 = r36
            java.lang.String r0 = "id"
            r1 = 0
            java.lang.String r16 = r14.getAttributeValue(r1, r0)
            java.lang.String r0 = "bandwidth"
            r2 = -1
            int r17 = U(r14, r0, r2)
            java.lang.String r0 = "mimeType"
            r2 = r38
            java.lang.String r18 = r0(r14, r0, r2)
            java.lang.String r0 = "codecs"
            r2 = r39
            java.lang.String r19 = r0(r14, r0, r2)
            java.lang.String r0 = "width"
            r2 = r40
            int r20 = U(r14, r0, r2)
            java.lang.String r0 = "height"
            r2 = r41
            int r21 = U(r14, r0, r2)
            r0 = r42
            float r22 = S(r14, r0)
            java.lang.String r0 = "audioSamplingRate"
            r2 = r44
            int r23 = U(r14, r0, r2)
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.ArrayList r12 = new java.util.ArrayList
            r0 = r48
            r12.<init>(r0)
            java.util.ArrayList r9 = new java.util.ArrayList
            r10 = r49
            r9.<init>(r10)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r0 = 0
            r24 = r43
            r0 = r50
            r5 = r55
            r26 = r1
            r25 = 0
            r1 = r57
        L_0x006a:
            r36.next()
            java.lang.String r3 = "BaseURL"
            boolean r3 = androidx.media3.common.util.XmlPullParserUtil.f(r14, r3)
            if (r3 == 0) goto L_0x0093
            if (r25 != 0) goto L_0x007d
            long r5 = r15.B(r14, r5)
            r25 = 1
        L_0x007d:
            r8 = r37
            r3 = r61
            java.util.List r4 = r15.C(r14, r8, r3)
            r7.addAll(r4)
        L_0x0088:
            r31 = r7
            r15 = r13
            r7 = r24
            r24 = r0
        L_0x008f:
            r13 = r11
            r11 = r9
            goto L_0x0190
        L_0x0093:
            r8 = r37
            r3 = r61
            java.lang.String r4 = "AudioChannelConfiguration"
            boolean r4 = androidx.media3.common.util.XmlPullParserUtil.f(r14, r4)
            if (r4 == 0) goto L_0x00aa
            int r4 = r35.A(r36)
            r24 = r0
            r31 = r7
            r15 = r13
            r7 = r4
            goto L_0x008f
        L_0x00aa:
            java.lang.String r4 = "SegmentBase"
            boolean r4 = androidx.media3.common.util.XmlPullParserUtil.f(r14, r4)
            if (r4 == 0) goto L_0x00b9
            androidx.media3.exoplayer.dash.manifest.SegmentBase$SingleSegmentBase r0 = (androidx.media3.exoplayer.dash.manifest.SegmentBase.SingleSegmentBase) r0
            androidx.media3.exoplayer.dash.manifest.SegmentBase$SingleSegmentBase r0 = r15.j0(r14, r0)
            goto L_0x0088
        L_0x00b9:
            java.lang.String r4 = "SegmentList"
            boolean r4 = androidx.media3.common.util.XmlPullParserUtil.f(r14, r4)
            if (r4 == 0) goto L_0x00f5
            long r27 = r15.B(r14, r1)
            r2 = r0
            androidx.media3.exoplayer.dash.manifest.SegmentBase$SegmentList r2 = (androidx.media3.exoplayer.dash.manifest.SegmentBase.SegmentList) r2
            r0 = r35
            r1 = r36
            r3 = r51
            r29 = r5
            r5 = r53
            r31 = r7
            r7 = r29
            r32 = r9
            r9 = r27
            r33 = r11
            r34 = r12
            r11 = r59
            androidx.media3.exoplayer.dash.manifest.SegmentBase$SegmentList r0 = r0.k0(r1, r2, r3, r5, r7, r9, r11)
            r15 = r13
        L_0x00e5:
            r7 = r24
            r1 = r27
        L_0x00e9:
            r5 = r29
            r11 = r32
            r13 = r33
            r12 = r34
        L_0x00f1:
            r24 = r0
            goto L_0x0190
        L_0x00f5:
            r29 = r5
            r31 = r7
            r32 = r9
            r33 = r11
            r34 = r12
            java.lang.String r3 = "SegmentTemplate"
            boolean r3 = androidx.media3.common.util.XmlPullParserUtil.f(r14, r3)
            if (r3 == 0) goto L_0x0124
            long r27 = r15.B(r14, r1)
            r2 = r0
            androidx.media3.exoplayer.dash.manifest.SegmentBase$SegmentTemplate r2 = (androidx.media3.exoplayer.dash.manifest.SegmentBase.SegmentTemplate) r2
            r0 = r35
            r1 = r36
            r3 = r49
            r4 = r51
            r6 = r53
            r8 = r29
            r10 = r27
            r15 = r13
            r12 = r59
            androidx.media3.exoplayer.dash.manifest.SegmentBase$SegmentTemplate r0 = r0.l0(r1, r2, r3, r4, r6, r8, r10, r12)
            goto L_0x00e5
        L_0x0124:
            r15 = r13
            java.lang.String r3 = "ContentProtection"
            boolean r3 = androidx.media3.common.util.XmlPullParserUtil.f(r14, r3)
            if (r3 == 0) goto L_0x0145
            android.util.Pair r3 = r35.F(r36)
            java.lang.Object r4 = r3.first
            if (r4 == 0) goto L_0x0139
            r26 = r4
            java.lang.String r26 = (java.lang.String) r26
        L_0x0139:
            java.lang.Object r3 = r3.second
            if (r3 == 0) goto L_0x0142
            androidx.media3.common.DrmInitData$SchemeData r3 = (androidx.media3.common.DrmInitData.SchemeData) r3
            r15.add(r3)
        L_0x0142:
            r7 = r24
            goto L_0x00e9
        L_0x0145:
            java.lang.String r3 = "InbandEventStream"
            boolean r4 = androidx.media3.common.util.XmlPullParserUtil.f(r14, r3)
            if (r4 == 0) goto L_0x015b
            androidx.media3.exoplayer.dash.manifest.Descriptor r3 = I(r14, r3)
            r13 = r33
            r13.add(r3)
            r11 = r32
            r12 = r34
            goto L_0x018a
        L_0x015b:
            r13 = r33
            java.lang.String r3 = "EssentialProperty"
            boolean r4 = androidx.media3.common.util.XmlPullParserUtil.f(r14, r3)
            if (r4 == 0) goto L_0x0171
            androidx.media3.exoplayer.dash.manifest.Descriptor r3 = I(r14, r3)
            r12 = r34
            r12.add(r3)
            r11 = r32
            goto L_0x018a
        L_0x0171:
            r12 = r34
            java.lang.String r3 = "SupplementalProperty"
            boolean r4 = androidx.media3.common.util.XmlPullParserUtil.f(r14, r3)
            if (r4 == 0) goto L_0x0185
            androidx.media3.exoplayer.dash.manifest.Descriptor r3 = I(r14, r3)
            r11 = r32
            r11.add(r3)
            goto L_0x018a
        L_0x0185:
            r11 = r32
            w(r36)
        L_0x018a:
            r7 = r24
            r5 = r29
            goto L_0x00f1
        L_0x0190:
            java.lang.String r0 = "Representation"
            boolean r0 = androidx.media3.common.util.XmlPullParserUtil.d(r14, r0)
            if (r0 == 0) goto L_0x01ee
            r0 = r35
            r1 = r16
            r2 = r18
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r7
            r7 = r23
            r8 = r17
            r9 = r45
            r10 = r46
            r27 = r11
            r11 = r47
            r28 = r12
            r12 = r19
            r29 = r13
            r13 = r28
            r14 = r27
            androidx.media3.common.Format r0 = r0.f(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            if (r24 == 0) goto L_0x01c2
            goto L_0x01c9
        L_0x01c2:
            androidx.media3.exoplayer.dash.manifest.SegmentBase$SingleSegmentBase r1 = new androidx.media3.exoplayer.dash.manifest.SegmentBase$SingleSegmentBase
            r1.<init>()
            r24 = r1
        L_0x01c9:
            androidx.media3.exoplayer.dash.manifest.DashManifestParser$RepresentationInfo r1 = new androidx.media3.exoplayer.dash.manifest.DashManifestParser$RepresentationInfo
            boolean r2 = r31.isEmpty()
            if (r2 != 0) goto L_0x01d2
            goto L_0x01d4
        L_0x01d2:
            r31 = r37
        L_0x01d4:
            r2 = -1
            r36 = r1
            r37 = r0
            r38 = r31
            r39 = r24
            r40 = r26
            r41 = r15
            r42 = r29
            r43 = r28
            r44 = r27
            r45 = r2
            r36.<init>(r37, r38, r39, r40, r41, r42, r43, r44, r45)
            return r1
        L_0x01ee:
            r10 = r49
            r9 = r11
            r11 = r13
            r13 = r15
            r0 = r24
            r15 = r35
            r24 = r7
            r7 = r31
            goto L_0x006a
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.manifest.DashManifestParser.e0(org.xmlpull.v1.XmlPullParser, java.util.List, java.lang.String, java.lang.String, int, int, float, int, int, java.lang.String, java.util.List, java.util.List, java.util.List, java.util.List, androidx.media3.exoplayer.dash.manifest.SegmentBase, long, long, long, long, long, boolean):androidx.media3.exoplayer.dash.manifest.DashManifestParser$RepresentationInfo");
    }

    /* access modifiers changed from: protected */
    public Format f(@Nullable String str, @Nullable String str2, int i2, int i3, float f2, int i4, int i5, int i6, @Nullable String str3, List<Descriptor> list, List<Descriptor> list2, @Nullable String str4, List<Descriptor> list3, List<Descriptor> list4) {
        String str5 = str2;
        int i7 = i2;
        int i8 = i3;
        List<Descriptor> list5 = list;
        List<Descriptor> list6 = list3;
        String str6 = str4;
        String u = u(str2, str6);
        if (MimeTypes.R.equals(u)) {
            u = N(list4);
            if (MimeTypes.S.equals(u)) {
                str6 = MimeTypes.V0;
            }
        }
        int p0 = p0(list5);
        int i0 = i0(list5) | f0(list2) | h0(list6) | h0(list4);
        Pair<Integer, Integer> t0 = t0(list6);
        String str7 = str;
        Format.Builder b0 = new Format.Builder().X(str).O(str2).k0(u).M(str6).f0(i6).m0(p0).i0(i0).b0(str3);
        int i9 = -1;
        Format.Builder q0 = b0.p0(t0 != null ? ((Integer) t0.first).intValue() : -1).q0(t0 != null ? ((Integer) t0.second).intValue() : -1);
        if (MimeTypes.t(u)) {
            q0.r0(i2).V(i8).U(f2);
        } else if (MimeTypes.p(u)) {
            q0.L(i4).l0(i5);
        } else if (MimeTypes.s(u)) {
            if (MimeTypes.w0.equals(u)) {
                i9 = D(list2);
            } else if (MimeTypes.x0.equals(u)) {
                i9 = E(list2);
            }
            q0.J(i9);
        } else if (MimeTypes.q(u)) {
            q0.r0(i2).V(i8);
        }
        return q0.I();
    }

    /* access modifiers changed from: protected */
    public int f0(List<Descriptor> list) {
        int u0;
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            Descriptor descriptor = list.get(i3);
            if (Ascii.a("urn:mpeg:dash:role:2011", descriptor.f11159a)) {
                u0 = g0(descriptor.f11160b);
            } else if (Ascii.a("urn:tva:metadata:cs:AudioPurposeCS:2007", descriptor.f11159a)) {
                u0 = u0(descriptor.f11160b);
            }
            i2 |= u0;
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public DashManifest g(long j2, long j3, long j4, boolean z, long j5, long j6, long j7, long j8, @Nullable ProgramInformation programInformation, @Nullable UtcTimingElement utcTimingElement, @Nullable ServiceDescriptionElement serviceDescriptionElement, @Nullable Uri uri, List<Period> list) {
        return new DashManifest(j2, j3, j4, z, j5, j6, j7, j8, programInformation, utcTimingElement, serviceDescriptionElement, uri, list);
    }

    /* access modifiers changed from: protected */
    public int g0(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2060497896:
                if (str.equals("subtitle")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1724546052:
                if (str.equals(DublinCoreProperties.f27399e)) {
                    c2 = 1;
                    break;
                }
                break;
            case -1580883024:
                if (str.equals("enhanced-audio-intelligibility")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1574842690:
                if (str.equals("forced_subtitle")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1408024454:
                if (str.equals("alternate")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1396432756:
                if (str.equals("forced-subtitle")) {
                    c2 = 5;
                    break;
                }
                break;
            case 99825:
                if (str.equals("dub")) {
                    c2 = 6;
                    break;
                }
                break;
            case 3343801:
                if (str.equals("main")) {
                    c2 = 7;
                    break;
                }
                break;
            case 3530173:
                if (str.equals("sign")) {
                    c2 = 8;
                    break;
                }
                break;
            case 552573414:
                if (str.equals(HTML.Tag.f27619g)) {
                    c2 = 9;
                    break;
                }
                break;
            case 899152809:
                if (str.equals("commentary")) {
                    c2 = 10;
                    break;
                }
                break;
            case 1629013393:
                if (str.equals("emergency")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1855372047:
                if (str.equals("supplementary")) {
                    c2 = 12;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 3:
            case 5:
                return 128;
            case 1:
                return 512;
            case 2:
                return 2048;
            case 4:
                return 2;
            case 6:
                return 16;
            case 7:
                return 1;
            case 8:
                return 256;
            case 9:
                return 64;
            case 10:
                return 8;
            case 11:
                return 32;
            case 12:
                return 4;
            default:
                return 0;
        }
    }

    /* access modifiers changed from: protected */
    public Period h(@Nullable String str, long j2, List<AdaptationSet> list, List<EventStream> list2, @Nullable Descriptor descriptor) {
        return new Period(str, j2, list, list2, descriptor);
    }

    /* access modifiers changed from: protected */
    public int h0(List<Descriptor> list) {
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (Ascii.a("http://dashif.org/guidelines/trickmode", list.get(i3).f11159a)) {
                i2 = 16384;
            }
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public RangedUri i(String str, long j2, long j3) {
        return new RangedUri(str, j2, j3);
    }

    /* access modifiers changed from: protected */
    public int i0(List<Descriptor> list) {
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            Descriptor descriptor = list.get(i3);
            if (Ascii.a("urn:mpeg:dash:role:2011", descriptor.f11159a)) {
                i2 |= g0(descriptor.f11160b);
            }
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public Representation j(RepresentationInfo representationInfo, @Nullable String str, List<Label> list, @Nullable String str2, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<Descriptor> arrayList2) {
        RepresentationInfo representationInfo2 = representationInfo;
        String str3 = str;
        Format.Builder c2 = representationInfo2.f11150a.c();
        if (str3 == null || !list.isEmpty()) {
            c2.a0(list);
        } else {
            c2.Z(str3);
        }
        String str4 = representationInfo2.f11153d;
        if (str4 == null) {
            str4 = str2;
        }
        ArrayList<DrmInitData.SchemeData> arrayList3 = representationInfo2.f11154e;
        arrayList3.addAll(arrayList);
        if (!arrayList3.isEmpty()) {
            r(arrayList3);
            s(arrayList3);
            c2.R(new DrmInitData(str4, (List<DrmInitData.SchemeData>) arrayList3));
        }
        ArrayList<Descriptor> arrayList4 = representationInfo2.f11155f;
        arrayList4.addAll(arrayList2);
        return Representation.p(representationInfo2.f11156g, c2.I(), representationInfo2.f11151b, representationInfo2.f11152c, arrayList4, representationInfo2.f11157h, representationInfo2.f11158i, (String) null);
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SingleSegmentBase j0(XmlPullParser xmlPullParser, @Nullable SegmentBase.SingleSegmentBase singleSegmentBase) throws XmlPullParserException, IOException {
        long j2;
        long j3;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        SegmentBase.SingleSegmentBase singleSegmentBase2 = singleSegmentBase;
        long X = X(xmlPullParser2, "timescale", singleSegmentBase2 != null ? singleSegmentBase2.f11196b : 1);
        long j4 = 0;
        long X2 = X(xmlPullParser2, "presentationTimeOffset", singleSegmentBase2 != null ? singleSegmentBase2.f11197c : 0);
        long j5 = singleSegmentBase2 != null ? singleSegmentBase2.f11210d : 0;
        if (singleSegmentBase2 != null) {
            j4 = singleSegmentBase2.f11211e;
        }
        RangedUri rangedUri = null;
        String attributeValue = xmlPullParser2.getAttributeValue((String) null, "indexRange");
        if (attributeValue != null) {
            String[] split = attributeValue.split("-");
            j3 = Long.parseLong(split[0]);
            j2 = (Long.parseLong(split[1]) - j3) + 1;
        } else {
            j2 = j4;
            j3 = j5;
        }
        if (singleSegmentBase2 != null) {
            rangedUri = singleSegmentBase2.f11195a;
        }
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser2, "Initialization")) {
                rangedUri = T(xmlPullParser);
            } else {
                w(xmlPullParser);
            }
        } while (!XmlPullParserUtil.d(xmlPullParser2, "SegmentBase"));
        return n(rangedUri, X, X2, j3, j2);
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SegmentList k(RangedUri rangedUri, long j2, long j3, long j4, long j5, @Nullable List<SegmentBase.SegmentTimelineElement> list, long j6, @Nullable List<RangedUri> list2, long j7, long j8) {
        return new SegmentBase.SegmentList(rangedUri, j2, j3, j4, j5, list, j6, list2, Util.I1(j7), Util.I1(j8));
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SegmentList k0(XmlPullParser xmlPullParser, @Nullable SegmentBase.SegmentList segmentList, long j2, long j3, long j4, long j5, long j6) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        SegmentBase.SegmentList segmentList2 = segmentList;
        long j7 = 1;
        long X = X(xmlPullParser2, "timescale", segmentList2 != null ? segmentList2.f11196b : 1);
        long X2 = X(xmlPullParser2, "presentationTimeOffset", segmentList2 != null ? segmentList2.f11197c : 0);
        long X3 = X(xmlPullParser2, TypedValues.TransitionType.f4025b, segmentList2 != null ? segmentList2.f11199e : C.f9084b);
        if (segmentList2 != null) {
            j7 = segmentList2.f11198d;
        }
        long X4 = X(xmlPullParser2, "startNumber", j7);
        long t = t(j4, j5);
        List<SegmentBase.SegmentTimelineElement> list = null;
        List list2 = null;
        RangedUri rangedUri = null;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser2, "Initialization")) {
                rangedUri = T(xmlPullParser);
            } else if (XmlPullParserUtil.f(xmlPullParser2, "SegmentTimeline")) {
                list = m0(xmlPullParser, X, j3);
            } else if (XmlPullParserUtil.f(xmlPullParser2, "SegmentURL")) {
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                list2.add(n0(xmlPullParser));
            } else {
                w(xmlPullParser);
            }
        } while (!XmlPullParserUtil.d(xmlPullParser2, "SegmentList"));
        if (segmentList2 != null) {
            if (rangedUri == null) {
                rangedUri = segmentList2.f11195a;
            }
            if (list == null) {
                list = segmentList2.f11200f;
            }
            if (list2 == null) {
                list2 = segmentList2.f11204j;
            }
        }
        return k(rangedUri, X, X2, X4, X3, list, t, list2, j6, j2);
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SegmentTemplate l(RangedUri rangedUri, long j2, long j3, long j4, long j5, long j6, List<SegmentBase.SegmentTimelineElement> list, long j7, @Nullable UrlTemplate urlTemplate, @Nullable UrlTemplate urlTemplate2, long j8, long j9) {
        return new SegmentBase.SegmentTemplate(rangedUri, j2, j3, j4, j5, j6, list, j7, urlTemplate, urlTemplate2, Util.I1(j8), Util.I1(j9));
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SegmentTemplate l0(XmlPullParser xmlPullParser, @Nullable SegmentBase.SegmentTemplate segmentTemplate, List<Descriptor> list, long j2, long j3, long j4, long j5, long j6) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        SegmentBase.SegmentTemplate segmentTemplate2 = segmentTemplate;
        long j7 = 1;
        long X = X(xmlPullParser2, "timescale", segmentTemplate2 != null ? segmentTemplate2.f11196b : 1);
        long X2 = X(xmlPullParser2, "presentationTimeOffset", segmentTemplate2 != null ? segmentTemplate2.f11197c : 0);
        long X3 = X(xmlPullParser2, TypedValues.TransitionType.f4025b, segmentTemplate2 != null ? segmentTemplate2.f11199e : C.f9084b);
        if (segmentTemplate2 != null) {
            j7 = segmentTemplate2.f11198d;
        }
        long X4 = X(xmlPullParser2, "startNumber", j7);
        long W = W(list);
        long t = t(j4, j5);
        List<SegmentBase.SegmentTimelineElement> list2 = null;
        UrlTemplate v0 = v0(xmlPullParser2, "media", segmentTemplate2 != null ? segmentTemplate2.f11206k : null);
        UrlTemplate v02 = v0(xmlPullParser2, "initialization", segmentTemplate2 != null ? segmentTemplate2.f11205j : null);
        RangedUri rangedUri = null;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser2, "Initialization")) {
                rangedUri = T(xmlPullParser);
            } else if (XmlPullParserUtil.f(xmlPullParser2, "SegmentTimeline")) {
                list2 = m0(xmlPullParser, X, j3);
            } else {
                w(xmlPullParser);
            }
            if (XmlPullParserUtil.d(xmlPullParser2, "SegmentTemplate")) {
                break;
            }
        }
        if (segmentTemplate2 != null) {
            if (rangedUri == null) {
                rangedUri = segmentTemplate2.f11195a;
            }
            if (list2 == null) {
                list2 = segmentTemplate2.f11200f;
            }
        }
        return l(rangedUri, X, X2, X4, W, X3, list2, t, v02, v0, j6, j2);
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SegmentTimelineElement m(long j2, long j3) {
        return new SegmentBase.SegmentTimelineElement(j2, j3);
    }

    /* access modifiers changed from: protected */
    public List<SegmentBase.SegmentTimelineElement> m0(XmlPullParser xmlPullParser, long j2, long j3) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        ArrayList arrayList = new ArrayList();
        long j4 = 0;
        long j5 = -9223372036854775807L;
        boolean z = false;
        int i2 = 0;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser2, ExifInterface.R4)) {
                long X = X(xmlPullParser2, "t", C.f9084b);
                if (z) {
                    j4 = b(arrayList, j4, j5, i2, X);
                }
                if (X == C.f9084b) {
                    X = j4;
                }
                j5 = X(xmlPullParser2, "d", C.f9084b);
                i2 = U(xmlPullParser2, "r", 0);
                j4 = X;
                z = true;
            } else {
                w(xmlPullParser);
            }
        } while (!XmlPullParserUtil.d(xmlPullParser2, "SegmentTimeline"));
        if (z) {
            b(arrayList, j4, j5, i2, Util.c2(j3, j2, 1000));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public SegmentBase.SingleSegmentBase n(RangedUri rangedUri, long j2, long j3, long j4, long j5) {
        return new SegmentBase.SingleSegmentBase(rangedUri, j2, j3, j4, j5);
    }

    /* access modifiers changed from: protected */
    public RangedUri n0(XmlPullParser xmlPullParser) {
        return d0(xmlPullParser, "media", "mediaRange");
    }

    /* access modifiers changed from: protected */
    public UtcTimingElement o(String str, String str2) {
        return new UtcTimingElement(str, str2);
    }

    /* access modifiers changed from: protected */
    public int o0(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        return (str.equals("forced_subtitle") || str.equals("forced-subtitle")) ? 2 : 0;
    }

    /* access modifiers changed from: protected */
    public int p0(List<Descriptor> list) {
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            Descriptor descriptor = list.get(i3);
            if (Ascii.a("urn:mpeg:dash:role:2011", descriptor.f11159a)) {
                i2 |= o0(descriptor.f11160b);
            }
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public ServiceDescriptionElement q0(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        long j2 = -9223372036854775807L;
        long j3 = -9223372036854775807L;
        long j4 = -9223372036854775807L;
        float f2 = -3.4028235E38f;
        float f3 = -3.4028235E38f;
        while (true) {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser2, "Latency")) {
                j2 = X(xmlPullParser2, TypedValues.AttributesType.M, C.f9084b);
                j3 = X(xmlPullParser2, "min", C.f9084b);
                j4 = X(xmlPullParser2, "max", C.f9084b);
            } else if (XmlPullParserUtil.f(xmlPullParser2, "PlaybackRate")) {
                f2 = R(xmlPullParser2, "min", -3.4028235E38f);
                f3 = R(xmlPullParser2, "max", -3.4028235E38f);
            }
            long j5 = j2;
            long j6 = j3;
            long j7 = j4;
            float f4 = f2;
            float f5 = f3;
            if (XmlPullParserUtil.d(xmlPullParser2, "ServiceDescription")) {
                return new ServiceDescriptionElement(j5, j6, j7, f4, f5);
            }
            j2 = j5;
            j3 = j6;
            j4 = j7;
            f2 = f4;
            f3 = f5;
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Pair<Integer, Integer> t0(List<Descriptor> list) {
        String str;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Descriptor descriptor = list.get(i2);
            if ((Ascii.a("http://dashif.org/thumbnail_tile", descriptor.f11159a) || Ascii.a("http://dashif.org/guidelines/thumbnail_tile", descriptor.f11159a)) && (str = descriptor.f11160b) != null) {
                String[] p2 = Util.p2(str, "x");
                if (p2.length != 2) {
                    continue;
                } else {
                    try {
                        return Pair.create(Integer.valueOf(Integer.parseInt(p2[0])), Integer.valueOf(Integer.parseInt(p2[1])));
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public int u0(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case 49:
                if (str.equals(IcyHeaders.a3)) {
                    c2 = 0;
                    break;
                }
                break;
            case 50:
                if (str.equals(ExifInterface.Y4)) {
                    c2 = 1;
                    break;
                }
                break;
            case 51:
                if (str.equals(ExifInterface.Z4)) {
                    c2 = 2;
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    c2 = 3;
                    break;
                }
                break;
            case 54:
                if (str.equals("6")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return 512;
            case 1:
                return 2048;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 1;
            default:
                return 0;
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public UrlTemplate v0(XmlPullParser xmlPullParser, String str, @Nullable UrlTemplate urlTemplate) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, str);
        return attributeValue != null ? UrlTemplate.b(attributeValue) : urlTemplate;
    }

    /* access modifiers changed from: protected */
    public UtcTimingElement w0(XmlPullParser xmlPullParser) {
        return o(xmlPullParser.getAttributeValue((String) null, "schemeIdUri"), xmlPullParser.getAttributeValue((String) null, "value"));
    }

    /* renamed from: x */
    public DashManifest a(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser newPullParser = this.f11149a.newPullParser();
            newPullParser.setInput(inputStream, (String) null);
            if (newPullParser.next() == 2 && "MPD".equals(newPullParser.getName())) {
                return Y(newPullParser, uri);
            }
            throw ParserException.c("inputStream does not contain a valid media presentation description", (Throwable) null);
        } catch (XmlPullParserException e2) {
            throw ParserException.c((String) null, e2);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0351 A[LOOP:0: B:1:0x007f->B:72:0x0351, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0310 A[EDGE_INSN: B:73:0x0310->B:66:0x0310 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.media3.exoplayer.dash.manifest.AdaptationSet y(org.xmlpull.v1.XmlPullParser r57, java.util.List<androidx.media3.exoplayer.dash.manifest.BaseUrl> r58, @androidx.annotation.Nullable androidx.media3.exoplayer.dash.manifest.SegmentBase r59, long r60, long r62, long r64, long r66, long r68, boolean r70) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r56 = this;
            r15 = r56
            r14 = r57
            java.lang.String r0 = "id"
            r1 = -1
            long r27 = X(r14, r0, r1)
            int r0 = r56.G(r57)
            java.lang.String r1 = "mimeType"
            r13 = 0
            java.lang.String r29 = r14.getAttributeValue(r13, r1)
            java.lang.String r1 = "codecs"
            java.lang.String r30 = r14.getAttributeValue(r13, r1)
            java.lang.String r1 = "width"
            r2 = -1
            int r31 = U(r14, r1, r2)
            java.lang.String r1 = "height"
            int r32 = U(r14, r1, r2)
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r33 = S(r14, r1)
            java.lang.String r1 = "audioSamplingRate"
            int r34 = U(r14, r1, r2)
            java.lang.String r12 = "lang"
            java.lang.String r1 = r14.getAttributeValue(r13, r12)
            java.lang.String r3 = "label"
            java.lang.String r35 = r14.getAttributeValue(r13, r3)
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r36 = 0
            r37 = r59
            r38 = r1
            r41 = r13
            r39 = -1
            r40 = 0
            r1 = r62
            r62 = r64
        L_0x007f:
            r57.next()
            java.lang.String r13 = "BaseURL"
            boolean r13 = androidx.media3.common.util.XmlPullParserUtil.f(r14, r13)
            if (r13 == 0) goto L_0x00bd
            if (r40 != 0) goto L_0x0092
            long r1 = r15.B(r14, r1)
            r40 = 1
        L_0x0092:
            r13 = r58
            r64 = r1
            r17 = r11
            r11 = r70
            java.util.List r1 = r15.C(r14, r13, r11)
            r3.addAll(r1)
            r1 = r64
            r15 = r4
            r46 = r5
            r47 = r6
            r48 = r7
            r49 = r8
            r51 = r10
            r53 = r12
            r4 = r17
        L_0x00b2:
            r55 = r38
            r54 = 0
            r16 = r62
            r38 = r3
            r3 = r9
            goto L_0x0308
        L_0x00bd:
            r13 = r58
            r18 = r1
            r17 = r11
            r11 = r70
            java.lang.String r1 = "ContentProtection"
            boolean r1 = androidx.media3.common.util.XmlPullParserUtil.f(r14, r1)
            if (r1 == 0) goto L_0x00f4
            android.util.Pair r1 = r56.F(r57)
            java.lang.Object r2 = r1.first
            if (r2 == 0) goto L_0x00d9
            r41 = r2
            java.lang.String r41 = (java.lang.String) r41
        L_0x00d9:
            java.lang.Object r1 = r1.second
            if (r1 == 0) goto L_0x00e2
            androidx.media3.common.DrmInitData$SchemeData r1 = (androidx.media3.common.DrmInitData.SchemeData) r1
            r10.add(r1)
        L_0x00e2:
            r15 = r4
            r46 = r5
            r47 = r6
            r48 = r7
            r49 = r8
            r51 = r10
            r53 = r12
            r4 = r17
            r1 = r18
            goto L_0x00b2
        L_0x00f4:
            java.lang.String r1 = "ContentComponent"
            boolean r1 = androidx.media3.common.util.XmlPullParserUtil.f(r14, r1)
            if (r1 == 0) goto L_0x012b
            r2 = 0
            java.lang.String r1 = r14.getAttributeValue(r2, r12)
            r15 = r38
            java.lang.String r1 = q(r15, r1)
            int r15 = r56.G(r57)
            int r0 = p(r0, r15)
            r55 = r1
            r54 = r2
            r38 = r3
            r15 = r4
            r46 = r5
            r47 = r6
            r48 = r7
            r49 = r8
            r3 = r9
            r51 = r10
            r53 = r12
            r4 = r17
            r1 = r18
        L_0x0127:
            r16 = r62
            goto L_0x0308
        L_0x012b:
            r15 = r38
            r2 = 0
            java.lang.String r1 = "Role"
            boolean r16 = androidx.media3.common.util.XmlPullParserUtil.f(r14, r1)
            if (r16 == 0) goto L_0x015b
            androidx.media3.exoplayer.dash.manifest.Descriptor r1 = I(r14, r1)
            r7.add(r1)
        L_0x013d:
            r44 = r0
            r54 = r2
            r38 = r3
            r46 = r5
            r47 = r6
            r48 = r7
            r49 = r8
            r3 = r9
            r51 = r10
            r53 = r12
            r55 = r15
            r42 = r18
            r0 = r62
            r15 = r4
            r4 = r17
            goto L_0x0302
        L_0x015b:
            java.lang.String r1 = "AudioChannelConfiguration"
            boolean r1 = androidx.media3.common.util.XmlPullParserUtil.f(r14, r1)
            if (r1 == 0) goto L_0x0182
            int r1 = r56.A(r57)
            r39 = r1
            r54 = r2
            r38 = r3
            r46 = r5
            r47 = r6
            r48 = r7
            r49 = r8
            r3 = r9
            r51 = r10
            r53 = r12
            r55 = r15
            r1 = r18
            r15 = r4
            r4 = r17
            goto L_0x0127
        L_0x0182:
            java.lang.String r1 = "Accessibility"
            boolean r16 = androidx.media3.common.util.XmlPullParserUtil.f(r14, r1)
            if (r16 == 0) goto L_0x0192
            androidx.media3.exoplayer.dash.manifest.Descriptor r1 = I(r14, r1)
            r8.add(r1)
            goto L_0x013d
        L_0x0192:
            java.lang.String r1 = "EssentialProperty"
            boolean r16 = androidx.media3.common.util.XmlPullParserUtil.f(r14, r1)
            if (r16 == 0) goto L_0x01a2
            androidx.media3.exoplayer.dash.manifest.Descriptor r1 = I(r14, r1)
            r6.add(r1)
            goto L_0x013d
        L_0x01a2:
            java.lang.String r1 = "SupplementalProperty"
            boolean r16 = androidx.media3.common.util.XmlPullParserUtil.f(r14, r1)
            if (r16 == 0) goto L_0x01b2
            androidx.media3.exoplayer.dash.manifest.Descriptor r1 = I(r14, r1)
            r5.add(r1)
            goto L_0x013d
        L_0x01b2:
            java.lang.String r1 = "Representation"
            boolean r1 = androidx.media3.common.util.XmlPullParserUtil.f(r14, r1)
            if (r1 == 0) goto L_0x0234
            boolean r1 = r3.isEmpty()
            if (r1 != 0) goto L_0x01c4
            r1 = r0
            r16 = r3
            goto L_0x01c7
        L_0x01c4:
            r1 = r0
            r16 = r13
        L_0x01c7:
            r0 = r56
            r44 = r1
            r42 = r18
            r1 = r57
            r18 = r2
            r2 = r16
            r38 = r3
            r3 = r29
            r45 = r4
            r4 = r30
            r46 = r5
            r5 = r31
            r47 = r6
            r6 = r32
            r48 = r7
            r7 = r33
            r49 = r8
            r8 = r39
            r50 = r9
            r9 = r34
            r51 = r10
            r10 = r15
            r52 = r17
            r11 = r48
            r53 = r12
            r12 = r49
            r54 = r18
            r13 = r47
            r14 = r46
            r55 = r15
            r15 = r37
            r16 = r66
            r18 = r60
            r20 = r42
            r22 = r62
            r24 = r68
            r26 = r70
            androidx.media3.exoplayer.dash.manifest.DashManifestParser$RepresentationInfo r0 = r0.e0(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r18, r20, r22, r24, r26)
            androidx.media3.common.Format r1 = r0.f11150a
            java.lang.String r1 = r1.f3
            int r1 = androidx.media3.common.MimeTypes.l(r1)
            r14 = r44
            int r1 = p(r14, r1)
            r15 = r45
            r15.add(r0)
            r14 = r57
            r16 = r62
            r0 = r1
            r1 = r42
        L_0x022e:
            r3 = r50
            r4 = r52
            goto L_0x0308
        L_0x0234:
            r14 = r0
            r54 = r2
            r38 = r3
            r46 = r5
            r47 = r6
            r48 = r7
            r49 = r8
            r50 = r9
            r51 = r10
            r53 = r12
            r55 = r15
            r52 = r17
            r42 = r18
            r15 = r4
            java.lang.String r0 = "SegmentBase"
            r13 = r57
            boolean r0 = androidx.media3.common.util.XmlPullParserUtil.f(r13, r0)
            if (r0 == 0) goto L_0x0270
            r0 = r37
            androidx.media3.exoplayer.dash.manifest.SegmentBase$SingleSegmentBase r0 = (androidx.media3.exoplayer.dash.manifest.SegmentBase.SingleSegmentBase) r0
            r11 = r56
            androidx.media3.exoplayer.dash.manifest.SegmentBase$SingleSegmentBase r0 = r11.j0(r13, r0)
            r16 = r62
            r37 = r0
            r0 = r14
            r1 = r42
            r3 = r50
            r4 = r52
            r14 = r13
            goto L_0x0308
        L_0x0270:
            r11 = r56
            java.lang.String r0 = "SegmentList"
            boolean r0 = androidx.media3.common.util.XmlPullParserUtil.f(r13, r0)
            if (r0 == 0) goto L_0x02a1
            r0 = r62
            long r16 = r11.B(r13, r0)
            r2 = r37
            androidx.media3.exoplayer.dash.manifest.SegmentBase$SegmentList r2 = (androidx.media3.exoplayer.dash.manifest.SegmentBase.SegmentList) r2
            r0 = r56
            r1 = r57
            r3 = r66
            r5 = r60
            r7 = r42
            r9 = r16
            r44 = r14
            r14 = r11
            r11 = r68
            androidx.media3.exoplayer.dash.manifest.SegmentBase$SegmentList r0 = r0.k0(r1, r2, r3, r5, r7, r9, r11)
            r37 = r0
            r14 = r13
        L_0x029c:
            r1 = r42
            r0 = r44
            goto L_0x022e
        L_0x02a1:
            r0 = r62
            r44 = r14
            r14 = r11
            java.lang.String r2 = "SegmentTemplate"
            boolean r2 = androidx.media3.common.util.XmlPullParserUtil.f(r13, r2)
            if (r2 == 0) goto L_0x02ce
            long r16 = r14.B(r13, r0)
            r2 = r37
            androidx.media3.exoplayer.dash.manifest.SegmentBase$SegmentTemplate r2 = (androidx.media3.exoplayer.dash.manifest.SegmentBase.SegmentTemplate) r2
            r0 = r56
            r1 = r57
            r3 = r46
            r4 = r66
            r6 = r60
            r8 = r42
            r10 = r16
            r14 = r13
            r12 = r68
            androidx.media3.exoplayer.dash.manifest.SegmentBase$SegmentTemplate r0 = r0.l0(r1, r2, r3, r4, r6, r8, r10, r12)
            r37 = r0
            goto L_0x029c
        L_0x02ce:
            r14 = r13
            java.lang.String r2 = "InbandEventStream"
            boolean r3 = androidx.media3.common.util.XmlPullParserUtil.f(r14, r2)
            if (r3 == 0) goto L_0x02e3
            androidx.media3.exoplayer.dash.manifest.Descriptor r2 = I(r14, r2)
            r3 = r50
            r3.add(r2)
            r4 = r52
            goto L_0x0302
        L_0x02e3:
            r3 = r50
            java.lang.String r2 = "Label"
            boolean r2 = androidx.media3.common.util.XmlPullParserUtil.f(r14, r2)
            if (r2 == 0) goto L_0x02f7
            androidx.media3.common.Label r2 = r56.V(r57)
            r4 = r52
            r4.add(r2)
            goto L_0x0302
        L_0x02f7:
            r4 = r52
            boolean r2 = androidx.media3.common.util.XmlPullParserUtil.e(r57)
            if (r2 == 0) goto L_0x0302
            r56.z(r57)
        L_0x0302:
            r16 = r0
            r1 = r42
            r0 = r44
        L_0x0308:
            java.lang.String r5 = "AdaptationSet"
            boolean r5 = androidx.media3.common.util.XmlPullParserUtil.d(r14, r5)
            if (r5 == 0) goto L_0x0351
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r15.size()
            r1.<init>(r2)
            r2 = 0
        L_0x031a:
            int r5 = r15.size()
            if (r2 >= r5) goto L_0x033e
            java.lang.Object r5 = r15.get(r2)
            androidx.media3.exoplayer.dash.manifest.DashManifestParser$RepresentationInfo r5 = (androidx.media3.exoplayer.dash.manifest.DashManifestParser.RepresentationInfo) r5
            r57 = r56
            r58 = r5
            r59 = r35
            r60 = r4
            r61 = r41
            r62 = r51
            r63 = r3
            androidx.media3.exoplayer.dash.manifest.Representation r5 = r57.j(r58, r59, r60, r61, r62, r63)
            r1.add(r5)
            int r2 = r2 + 1
            goto L_0x031a
        L_0x033e:
            r57 = r56
            r58 = r27
            r60 = r0
            r61 = r1
            r62 = r49
            r63 = r47
            r64 = r46
            androidx.media3.exoplayer.dash.manifest.AdaptationSet r0 = r57.c(r58, r60, r61, r62, r63, r64)
            return r0
        L_0x0351:
            r9 = r3
            r11 = r4
            r4 = r15
            r62 = r16
            r3 = r38
            r5 = r46
            r6 = r47
            r7 = r48
            r8 = r49
            r10 = r51
            r12 = r53
            r13 = r54
            r38 = r55
            r15 = r56
            goto L_0x007f
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.manifest.DashManifestParser.y(org.xmlpull.v1.XmlPullParser, java.util.List, androidx.media3.exoplayer.dash.manifest.SegmentBase, long, long, long, long, long, boolean):androidx.media3.exoplayer.dash.manifest.AdaptationSet");
    }

    /* access modifiers changed from: protected */
    public void z(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        w(xmlPullParser);
    }
}
