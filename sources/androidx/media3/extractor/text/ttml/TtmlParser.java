package androidx.media3.extractor.text.ttml;

import android.text.Layout;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.common.util.XmlPullParserUtil;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.LegacySubtitleUtil;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleDecoderException;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.e;
import com.google.common.base.Ascii;
import com.itextpdf.tool.xml.css.CSS;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

@UnstableApi
public final class TtmlParser implements SubtitleParser {

    /* renamed from: b  reason: collision with root package name */
    public static final int f14027b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final String f14028c = "TtmlParser";

    /* renamed from: d  reason: collision with root package name */
    private static final String f14029d = "http://www.w3.org/ns/ttml#parameter";

    /* renamed from: e  reason: collision with root package name */
    private static final String f14030e = "begin";

    /* renamed from: f  reason: collision with root package name */
    private static final String f14031f = "dur";

    /* renamed from: g  reason: collision with root package name */
    private static final String f14032g = "end";

    /* renamed from: h  reason: collision with root package name */
    private static final String f14033h = "style";

    /* renamed from: i  reason: collision with root package name */
    private static final String f14034i = "region";

    /* renamed from: j  reason: collision with root package name */
    private static final String f14035j = "backgroundImage";

    /* renamed from: k  reason: collision with root package name */
    private static final Pattern f14036k = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* renamed from: l  reason: collision with root package name */
    private static final Pattern f14037l = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* renamed from: m  reason: collision with root package name */
    private static final Pattern f14038m = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* renamed from: n  reason: collision with root package name */
    static final Pattern f14039n = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    static final Pattern o = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    private static final Pattern p = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
    private static final Pattern q = Pattern.compile("^(\\d+) (\\d+)$");
    private static final int r = 30;
    private static final FrameAndTickRate s = new FrameAndTickRate(30.0f, 1, 1);
    private static final int t = 15;

    /* renamed from: a  reason: collision with root package name */
    private final XmlPullParserFactory f14040a;

    private static final class FrameAndTickRate {

        /* renamed from: a  reason: collision with root package name */
        final float f14041a;

        /* renamed from: b  reason: collision with root package name */
        final int f14042b;

        /* renamed from: c  reason: collision with root package name */
        final int f14043c;

        FrameAndTickRate(float f2, int i2, int i3) {
            this.f14041a = f2;
            this.f14042b = i2;
            this.f14043c = i3;
        }
    }

    private static final class TtsExtent {

        /* renamed from: a  reason: collision with root package name */
        final int f14044a;

        /* renamed from: b  reason: collision with root package name */
        final int f14045b;

        TtsExtent(int i2, int i3) {
            this.f14044a = i2;
            this.f14045b = i3;
        }
    }

    public TtmlParser() {
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.f14040a = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    private static TtmlStyle e(@Nullable TtmlStyle ttmlStyle) {
        return ttmlStyle == null ? new TtmlStyle() : ttmlStyle;
    }

    private static boolean f(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals(TtmlNode.v) || str.equals(TtmlNode.w) || str.equals("region") || str.equals(TtmlNode.y) || str.equals("image") || str.equals("data") || str.equals(TtmlNode.B);
    }

    @Nullable
    private static Layout.Alignment g(String str) {
        String g2 = Ascii.g(str);
        g2.hashCode();
        char c2 = 65535;
        switch (g2.hashCode()) {
            case -1364013995:
                if (g2.equals("center")) {
                    c2 = 0;
                    break;
                }
                break;
            case 100571:
                if (g2.equals("end")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3317767:
                if (g2.equals("left")) {
                    c2 = 2;
                    break;
                }
                break;
            case 108511772:
                if (g2.equals("right")) {
                    c2 = 3;
                    break;
                }
                break;
            case 109757538:
                if (g2.equals("start")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return Layout.Alignment.ALIGN_CENTER;
            case 1:
            case 3:
                return Layout.Alignment.ALIGN_OPPOSITE;
            case 2:
            case 4:
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                return null;
        }
    }

    private static int h(XmlPullParser xmlPullParser, int i2) {
        StringBuilder sb;
        String attributeValue = xmlPullParser.getAttributeValue(f14029d, "cellResolution");
        if (attributeValue == null) {
            return i2;
        }
        Matcher matcher = q.matcher(attributeValue);
        if (!matcher.matches()) {
            sb = new StringBuilder();
        } else {
            boolean z = true;
            try {
                int parseInt = Integer.parseInt((String) Assertions.g(matcher.group(1)));
                int parseInt2 = Integer.parseInt((String) Assertions.g(matcher.group(2)));
                if (parseInt == 0 || parseInt2 == 0) {
                    z = false;
                }
                Assertions.b(z, "Invalid cell resolution " + parseInt + StringUtils.SPACE + parseInt2);
                return parseInt2;
            } catch (NumberFormatException unused) {
                sb = new StringBuilder();
            }
        }
        sb.append("Ignoring malformed cell resolution: ");
        sb.append(attributeValue);
        Log.n(f14028c, sb.toString());
        return i2;
    }

    private static void i(String str, TtmlStyle ttmlStyle) throws SubtitleDecoderException {
        Matcher matcher;
        String[] p2 = Util.p2(str, "\\s+");
        if (p2.length == 1) {
            matcher = f14038m.matcher(str);
        } else if (p2.length == 2) {
            matcher = f14038m.matcher(p2[1]);
            Log.n(f14028c, "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + p2.length + ".");
        }
        if (matcher.matches()) {
            String str2 = (String) Assertions.g(matcher.group(3));
            str2.hashCode();
            char c2 = 65535;
            switch (str2.hashCode()) {
                case 37:
                    if (str2.equals(CSS.Value.n0)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3240:
                    if (str2.equals("em")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3592:
                    if (str2.equals(CSS.Value.h0)) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    ttmlStyle.A(3);
                    break;
                case 1:
                    ttmlStyle.A(2);
                    break;
                case 2:
                    ttmlStyle.A(1);
                    break;
                default:
                    throw new SubtitleDecoderException("Invalid unit for fontSize: '" + str2 + "'.");
            }
            ttmlStyle.z(Float.parseFloat((String) Assertions.g(matcher.group(1))));
            return;
        }
        throw new SubtitleDecoderException("Invalid expression for fontSize: '" + str + "'.");
    }

    private static FrameAndTickRate j(XmlPullParser xmlPullParser) {
        float f2;
        String attributeValue = xmlPullParser.getAttributeValue(f14029d, "frameRate");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlPullParser.getAttributeValue(f14029d, "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] p2 = Util.p2(attributeValue2, StringUtils.SPACE);
            Assertions.b(p2.length == 2, "frameRateMultiplier doesn't have 2 parts");
            f2 = ((float) Integer.parseInt(p2[0])) / ((float) Integer.parseInt(p2[1]));
        } else {
            f2 = 1.0f;
        }
        FrameAndTickRate frameAndTickRate = s;
        int i2 = frameAndTickRate.f14042b;
        String attributeValue3 = xmlPullParser.getAttributeValue(f14029d, "subFrameRate");
        if (attributeValue3 != null) {
            i2 = Integer.parseInt(attributeValue3);
        }
        int i3 = frameAndTickRate.f14043c;
        String attributeValue4 = xmlPullParser.getAttributeValue(f14029d, "tickRate");
        if (attributeValue4 != null) {
            i3 = Integer.parseInt(attributeValue4);
        }
        return new FrameAndTickRate(((float) parseInt) * f2, i2, i3);
    }

    private static Map<String, TtmlStyle> k(XmlPullParser xmlPullParser, Map<String, TtmlStyle> map, int i2, @Nullable TtsExtent ttsExtent, Map<String, TtmlRegion> map2, Map<String, String> map3) throws IOException, XmlPullParserException {
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser, "style")) {
                String a2 = XmlPullParserUtil.a(xmlPullParser, "style");
                TtmlStyle p2 = p(xmlPullParser, new TtmlStyle());
                if (a2 != null) {
                    for (String str : q(a2)) {
                        p2.a(map.get(str));
                    }
                }
                String g2 = p2.g();
                if (g2 != null) {
                    map.put(g2, p2);
                }
            } else if (XmlPullParserUtil.f(xmlPullParser, "region")) {
                TtmlRegion n2 = n(xmlPullParser, i2, ttsExtent);
                if (n2 != null) {
                    map2.put(n2.f14046a, n2);
                }
            } else if (XmlPullParserUtil.f(xmlPullParser, TtmlNode.y)) {
                l(xmlPullParser, map3);
            }
        } while (!XmlPullParserUtil.d(xmlPullParser, "head"));
        return map;
    }

    private static void l(XmlPullParser xmlPullParser, Map<String, String> map) throws IOException, XmlPullParserException {
        String a2;
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser, "image") && (a2 = XmlPullParserUtil.a(xmlPullParser, "id")) != null) {
                map.put(a2, xmlPullParser.nextText());
            }
        } while (!XmlPullParserUtil.d(xmlPullParser, TtmlNode.y));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.media3.extractor.text.ttml.TtmlNode m(org.xmlpull.v1.XmlPullParser r20, @androidx.annotation.Nullable androidx.media3.extractor.text.ttml.TtmlNode r21, java.util.Map<java.lang.String, androidx.media3.extractor.text.ttml.TtmlRegion> r22, androidx.media3.extractor.text.ttml.TtmlParser.FrameAndTickRate r23) throws androidx.media3.extractor.text.SubtitleDecoderException {
        /*
            r0 = r20
            r9 = r21
            r1 = r23
            r2 = 1
            int r3 = r20.getAttributeCount()
            r4 = 0
            androidx.media3.extractor.text.ttml.TtmlStyle r5 = p(r0, r4)
            java.lang.String r8 = ""
            r12 = r4
            r11 = r8
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r15 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r17 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r8 = r12
            r4 = 0
        L_0x0025:
            if (r4 >= r3) goto L_0x00b5
            java.lang.String r10 = r0.getAttributeName(r4)
            java.lang.String r6 = r0.getAttributeValue(r4)
            r10.hashCode()
            int r19 = r10.hashCode()
            switch(r19) {
                case -934795532: goto L_0x0072;
                case 99841: goto L_0x0067;
                case 100571: goto L_0x005c;
                case 93616297: goto L_0x0051;
                case 109780401: goto L_0x0046;
                case 1292595405: goto L_0x003b;
                default: goto L_0x0039;
            }
        L_0x0039:
            r7 = -1
            goto L_0x007c
        L_0x003b:
            java.lang.String r7 = "backgroundImage"
            boolean r7 = r10.equals(r7)
            if (r7 != 0) goto L_0x0044
            goto L_0x0039
        L_0x0044:
            r7 = 5
            goto L_0x007c
        L_0x0046:
            java.lang.String r7 = "style"
            boolean r7 = r10.equals(r7)
            if (r7 != 0) goto L_0x004f
            goto L_0x0039
        L_0x004f:
            r7 = 4
            goto L_0x007c
        L_0x0051:
            java.lang.String r7 = "begin"
            boolean r7 = r10.equals(r7)
            if (r7 != 0) goto L_0x005a
            goto L_0x0039
        L_0x005a:
            r7 = 3
            goto L_0x007c
        L_0x005c:
            java.lang.String r7 = "end"
            boolean r7 = r10.equals(r7)
            if (r7 != 0) goto L_0x0065
            goto L_0x0039
        L_0x0065:
            r7 = 2
            goto L_0x007c
        L_0x0067:
            java.lang.String r7 = "dur"
            boolean r7 = r10.equals(r7)
            if (r7 != 0) goto L_0x0070
            goto L_0x0039
        L_0x0070:
            r7 = 1
            goto L_0x007c
        L_0x0072:
            java.lang.String r7 = "region"
            boolean r7 = r10.equals(r7)
            if (r7 != 0) goto L_0x007b
            goto L_0x0039
        L_0x007b:
            r7 = 0
        L_0x007c:
            switch(r7) {
                case 0: goto L_0x00a9;
                case 1: goto L_0x00a4;
                case 2: goto L_0x009f;
                case 3: goto L_0x009a;
                case 4: goto L_0x008f;
                case 5: goto L_0x0080;
                default: goto L_0x007f;
            }
        L_0x007f:
            goto L_0x008c
        L_0x0080:
            java.lang.String r7 = "#"
            boolean r7 = r6.startsWith(r7)
            if (r7 == 0) goto L_0x008c
            java.lang.String r12 = r6.substring(r2)
        L_0x008c:
            r7 = r22
            goto L_0x00b2
        L_0x008f:
            java.lang.String[] r6 = q(r6)
            int r7 = r6.length
            if (r7 <= 0) goto L_0x008c
            r7 = r22
            r8 = r6
            goto L_0x00b2
        L_0x009a:
            long r13 = r(r6, r1)
            goto L_0x008c
        L_0x009f:
            long r15 = r(r6, r1)
            goto L_0x008c
        L_0x00a4:
            long r17 = r(r6, r1)
            goto L_0x008c
        L_0x00a9:
            r7 = r22
            boolean r10 = r7.containsKey(r6)
            if (r10 == 0) goto L_0x00b2
            r11 = r6
        L_0x00b2:
            int r4 = r4 + r2
            goto L_0x0025
        L_0x00b5:
            if (r9 == 0) goto L_0x00ce
            long r1 = r9.f14017d
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x00cc
            int r6 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x00c7
            long r13 = r13 + r1
        L_0x00c7:
            int r6 = (r15 > r3 ? 1 : (r15 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x00cc
            long r15 = r15 + r1
        L_0x00cc:
            r1 = r13
            goto L_0x00d4
        L_0x00ce:
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x00cc
        L_0x00d4:
            int r6 = (r15 > r3 ? 1 : (r15 == r3 ? 0 : -1))
            if (r6 != 0) goto L_0x00eb
            int r6 = (r17 > r3 ? 1 : (r17 == r3 ? 0 : -1))
            if (r6 == 0) goto L_0x00e1
            long r17 = r1 + r17
            r3 = r17
            goto L_0x00ec
        L_0x00e1:
            if (r9 == 0) goto L_0x00eb
            long r6 = r9.f14018e
            int r10 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r10 == 0) goto L_0x00eb
            r3 = r6
            goto L_0x00ec
        L_0x00eb:
            r3 = r15
        L_0x00ec:
            java.lang.String r0 = r20.getName()
            r6 = r8
            r7 = r11
            r8 = r12
            r9 = r21
            androidx.media3.extractor.text.ttml.TtmlNode r0 = androidx.media3.extractor.text.ttml.TtmlNode.c(r0, r1, r3, r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.ttml.TtmlParser.m(org.xmlpull.v1.XmlPullParser, androidx.media3.extractor.text.ttml.TtmlNode, java.util.Map, androidx.media3.extractor.text.ttml.TtmlParser$FrameAndTickRate):androidx.media3.extractor.text.ttml.TtmlNode");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0184, code lost:
        if (r0.equals("tb") == false) goto L_0x0166;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01b4  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.media3.extractor.text.ttml.TtmlRegion n(org.xmlpull.v1.XmlPullParser r18, int r19, @androidx.annotation.Nullable androidx.media3.extractor.text.ttml.TtmlParser.TtsExtent r20) {
        /*
            r0 = r18
            r1 = r20
            r2 = 0
            r3 = 1
            r4 = 2
            java.lang.String r5 = "id"
            java.lang.String r7 = androidx.media3.common.util.XmlPullParserUtil.a(r0, r5)
            r5 = 0
            if (r7 != 0) goto L_0x0011
            return r5
        L_0x0011:
            java.lang.String r6 = "origin"
            java.lang.String r6 = androidx.media3.common.util.XmlPullParserUtil.a(r0, r6)
            java.lang.String r8 = "TtmlParser"
            if (r6 == 0) goto L_0x01c7
            java.util.regex.Pattern r9 = o
            java.util.regex.Matcher r10 = r9.matcher(r6)
            java.util.regex.Pattern r11 = p
            java.util.regex.Matcher r12 = r11.matcher(r6)
            boolean r13 = r10.matches()
            java.lang.String r14 = "Ignoring region with missing tts:extent: "
            java.lang.String r15 = "Ignoring region with malformed origin: "
            r16 = 1120403456(0x42c80000, float:100.0)
            if (r13 == 0) goto L_0x006c
            java.lang.String r12 = r10.group(r3)     // Catch:{ NumberFormatException -> 0x0059 }
            java.lang.Object r12 = androidx.media3.common.util.Assertions.g(r12)     // Catch:{ NumberFormatException -> 0x0059 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ NumberFormatException -> 0x0059 }
            float r12 = java.lang.Float.parseFloat(r12)     // Catch:{ NumberFormatException -> 0x0059 }
            float r12 = r12 / r16
            java.lang.String r10 = r10.group(r4)     // Catch:{ NumberFormatException -> 0x0059 }
            java.lang.Object r10 = androidx.media3.common.util.Assertions.g(r10)     // Catch:{ NumberFormatException -> 0x0059 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ NumberFormatException -> 0x0059 }
            float r10 = java.lang.Float.parseFloat(r10)     // Catch:{ NumberFormatException -> 0x0059 }
            float r10 = r10 / r16
            r17 = r12
            r12 = r10
            r10 = r17
            goto L_0x00a3
        L_0x0059:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L_0x005e:
            r0.append(r15)
        L_0x0061:
            r0.append(r6)
            java.lang.String r0 = r0.toString()
        L_0x0068:
            androidx.media3.common.util.Log.n(r8, r0)
            return r5
        L_0x006c:
            boolean r10 = r12.matches()
            if (r10 == 0) goto L_0x01bf
            if (r1 != 0) goto L_0x007d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L_0x0079:
            r0.append(r14)
            goto L_0x0061
        L_0x007d:
            java.lang.String r10 = r12.group(r3)     // Catch:{ NumberFormatException -> 0x01b8 }
            java.lang.Object r10 = androidx.media3.common.util.Assertions.g(r10)     // Catch:{ NumberFormatException -> 0x01b8 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ NumberFormatException -> 0x01b8 }
            int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ NumberFormatException -> 0x01b8 }
            java.lang.String r12 = r12.group(r4)     // Catch:{ NumberFormatException -> 0x01b8 }
            java.lang.Object r12 = androidx.media3.common.util.Assertions.g(r12)     // Catch:{ NumberFormatException -> 0x01b8 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ NumberFormatException -> 0x01b8 }
            int r12 = java.lang.Integer.parseInt(r12)     // Catch:{ NumberFormatException -> 0x01b8 }
            float r10 = (float) r10     // Catch:{ NumberFormatException -> 0x01b8 }
            int r13 = r1.f14044a     // Catch:{ NumberFormatException -> 0x01b8 }
            float r13 = (float) r13     // Catch:{ NumberFormatException -> 0x01b8 }
            float r10 = r10 / r13
            float r12 = (float) r12     // Catch:{ NumberFormatException -> 0x01b8 }
            int r13 = r1.f14045b     // Catch:{ NumberFormatException -> 0x01b8 }
            float r13 = (float) r13
            float r12 = r12 / r13
        L_0x00a3:
            java.lang.String r13 = "extent"
            java.lang.String r13 = androidx.media3.common.util.XmlPullParserUtil.a(r0, r13)
            if (r13 == 0) goto L_0x01b4
            java.util.regex.Matcher r9 = r9.matcher(r13)
            java.util.regex.Matcher r11 = r11.matcher(r13)
            boolean r13 = r9.matches()
            java.lang.String r15 = "Ignoring region with malformed extent: "
            if (r13 == 0) goto L_0x00e4
            java.lang.String r1 = r9.group(r3)     // Catch:{ NumberFormatException -> 0x00dd }
            java.lang.Object r1 = androidx.media3.common.util.Assertions.g(r1)     // Catch:{ NumberFormatException -> 0x00dd }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ NumberFormatException -> 0x00dd }
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ NumberFormatException -> 0x00dd }
            float r1 = r1 / r16
            java.lang.String r9 = r9.group(r4)     // Catch:{ NumberFormatException -> 0x00dd }
            java.lang.Object r9 = androidx.media3.common.util.Assertions.g(r9)     // Catch:{ NumberFormatException -> 0x00dd }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ NumberFormatException -> 0x00dd }
            float r5 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x00dd }
            float r5 = r5 / r16
            r13 = r5
            goto L_0x011a
        L_0x00dd:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            goto L_0x005e
        L_0x00e4:
            boolean r9 = r11.matches()
            if (r9 == 0) goto L_0x01a8
            if (r1 != 0) goto L_0x00f2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            goto L_0x0079
        L_0x00f2:
            java.lang.String r9 = r11.group(r3)     // Catch:{ NumberFormatException -> 0x01a1 }
            java.lang.Object r9 = androidx.media3.common.util.Assertions.g(r9)     // Catch:{ NumberFormatException -> 0x01a1 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ NumberFormatException -> 0x01a1 }
            int r9 = java.lang.Integer.parseInt(r9)     // Catch:{ NumberFormatException -> 0x01a1 }
            java.lang.String r11 = r11.group(r4)     // Catch:{ NumberFormatException -> 0x01a1 }
            java.lang.Object r11 = androidx.media3.common.util.Assertions.g(r11)     // Catch:{ NumberFormatException -> 0x01a1 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ NumberFormatException -> 0x01a1 }
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ NumberFormatException -> 0x01a1 }
            float r9 = (float) r9     // Catch:{ NumberFormatException -> 0x01a1 }
            int r13 = r1.f14044a     // Catch:{ NumberFormatException -> 0x01a1 }
            float r13 = (float) r13     // Catch:{ NumberFormatException -> 0x01a1 }
            float r9 = r9 / r13
            float r11 = (float) r11     // Catch:{ NumberFormatException -> 0x01a1 }
            int r1 = r1.f14045b     // Catch:{ NumberFormatException -> 0x01a1 }
            float r1 = (float) r1
            float r11 = r11 / r1
            r1 = r9
            r13 = r11
        L_0x011a:
            java.lang.String r5 = "displayAlign"
            java.lang.String r5 = androidx.media3.common.util.XmlPullParserUtil.a(r0, r5)
            if (r5 == 0) goto L_0x0146
            java.lang.String r5 = com.google.common.base.Ascii.g(r5)
            r5.hashCode()
            java.lang.String r6 = "center"
            boolean r6 = r5.equals(r6)
            if (r6 != 0) goto L_0x013e
            java.lang.String r6 = "after"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x013a
            goto L_0x0146
        L_0x013a:
            float r12 = r12 + r13
            r9 = r12
            r11 = 2
            goto L_0x0148
        L_0x013e:
            r5 = 1073741824(0x40000000, float:2.0)
            float r5 = r13 / r5
            float r12 = r12 + r5
            r9 = r12
            r11 = 1
            goto L_0x0148
        L_0x0146:
            r9 = r12
            r11 = 0
        L_0x0148:
            r5 = 1065353216(0x3f800000, float:1.0)
            r6 = r19
            float r6 = (float) r6
            float r15 = r5 / r6
            java.lang.String r5 = "writingMode"
            java.lang.String r0 = androidx.media3.common.util.XmlPullParserUtil.a(r0, r5)
            if (r0 == 0) goto L_0x0191
            java.lang.String r0 = com.google.common.base.Ascii.g(r0)
            r0.hashCode()
            r5 = -1
            int r6 = r0.hashCode()
            switch(r6) {
                case 3694: goto L_0x017e;
                case 3553396: goto L_0x0173;
                case 3553576: goto L_0x0168;
                default: goto L_0x0166;
            }
        L_0x0166:
            r2 = -1
            goto L_0x0187
        L_0x0168:
            java.lang.String r2 = "tbrl"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0171
            goto L_0x0166
        L_0x0171:
            r2 = 2
            goto L_0x0187
        L_0x0173:
            java.lang.String r2 = "tblr"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x017c
            goto L_0x0166
        L_0x017c:
            r2 = 1
            goto L_0x0187
        L_0x017e:
            java.lang.String r6 = "tb"
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L_0x0187
            goto L_0x0166
        L_0x0187:
            switch(r2) {
                case 0: goto L_0x018e;
                case 1: goto L_0x018e;
                case 2: goto L_0x018b;
                default: goto L_0x018a;
            }
        L_0x018a:
            goto L_0x0191
        L_0x018b:
            r16 = 1
            goto L_0x0195
        L_0x018e:
            r16 = 2
            goto L_0x0195
        L_0x0191:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r16 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x0195:
            androidx.media3.extractor.text.ttml.TtmlRegion r0 = new androidx.media3.extractor.text.ttml.TtmlRegion
            r2 = 0
            r14 = 1
            r6 = r0
            r8 = r10
            r10 = r2
            r12 = r1
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r0
        L_0x01a1:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            goto L_0x005e
        L_0x01a8:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Ignoring region with unsupported extent: "
        L_0x01af:
            r0.append(r1)
            goto L_0x0061
        L_0x01b4:
            java.lang.String r0 = "Ignoring region without an extent"
            goto L_0x0068
        L_0x01b8:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            goto L_0x005e
        L_0x01bf:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Ignoring region with unsupported origin: "
            goto L_0x01af
        L_0x01c7:
            java.lang.String r0 = "Ignoring region without an origin"
            goto L_0x0068
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.ttml.TtmlParser.n(org.xmlpull.v1.XmlPullParser, int, androidx.media3.extractor.text.ttml.TtmlParser$TtsExtent):androidx.media3.extractor.text.ttml.TtmlRegion");
    }

    private static float o(String str) {
        Matcher matcher = f14039n.matcher(str);
        if (!matcher.matches()) {
            Log.n(f14028c, "Invalid value for shear: " + str);
            return Float.MAX_VALUE;
        }
        try {
            return Math.min(100.0f, Math.max(-100.0f, Float.parseFloat((String) Assertions.g(matcher.group(1)))));
        } catch (NumberFormatException e2) {
            Log.o(f14028c, "Failed to parse shear: " + str, e2);
            return Float.MAX_VALUE;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.media3.extractor.text.ttml.TtmlStyle p(org.xmlpull.v1.XmlPullParser r13, androidx.media3.extractor.text.ttml.TtmlStyle r14) {
        /*
            r0 = 5
            r1 = 4
            r2 = -1
            r3 = 3
            r4 = 2
            r5 = 1
            int r6 = r13.getAttributeCount()
            r7 = 0
            r8 = 0
        L_0x000c:
            if (r8 >= r6) goto L_0x02dc
            java.lang.String r9 = r13.getAttributeValue(r8)
            java.lang.String r10 = r13.getAttributeName(r8)
            r10.hashCode()
            java.lang.String r11 = "TtmlParser"
            int r12 = r10.hashCode()
            switch(r12) {
                case -1550943582: goto L_0x00d1;
                case -1224696685: goto L_0x00c5;
                case -1065511464: goto L_0x00b9;
                case -879295043: goto L_0x00ad;
                case -734428249: goto L_0x00a1;
                case 3355: goto L_0x0096;
                case 3511770: goto L_0x008b;
                case 94842723: goto L_0x0080;
                case 109403361: goto L_0x0073;
                case 110138194: goto L_0x0066;
                case 365601008: goto L_0x0059;
                case 921125321: goto L_0x004c;
                case 1115953443: goto L_0x003f;
                case 1287124693: goto L_0x0032;
                case 1754920356: goto L_0x0025;
                default: goto L_0x0022;
            }
        L_0x0022:
            r10 = -1
            goto L_0x00dc
        L_0x0025:
            java.lang.String r12 = "multiRowAlign"
            boolean r10 = r10.equals(r12)
            if (r10 != 0) goto L_0x002e
            goto L_0x0022
        L_0x002e:
            r10 = 14
            goto L_0x00dc
        L_0x0032:
            java.lang.String r12 = "backgroundColor"
            boolean r10 = r10.equals(r12)
            if (r10 != 0) goto L_0x003b
            goto L_0x0022
        L_0x003b:
            r10 = 13
            goto L_0x00dc
        L_0x003f:
            java.lang.String r12 = "rubyPosition"
            boolean r10 = r10.equals(r12)
            if (r10 != 0) goto L_0x0048
            goto L_0x0022
        L_0x0048:
            r10 = 12
            goto L_0x00dc
        L_0x004c:
            java.lang.String r12 = "textEmphasis"
            boolean r10 = r10.equals(r12)
            if (r10 != 0) goto L_0x0055
            goto L_0x0022
        L_0x0055:
            r10 = 11
            goto L_0x00dc
        L_0x0059:
            java.lang.String r12 = "fontSize"
            boolean r10 = r10.equals(r12)
            if (r10 != 0) goto L_0x0062
            goto L_0x0022
        L_0x0062:
            r10 = 10
            goto L_0x00dc
        L_0x0066:
            java.lang.String r12 = "textCombine"
            boolean r10 = r10.equals(r12)
            if (r10 != 0) goto L_0x006f
            goto L_0x0022
        L_0x006f:
            r10 = 9
            goto L_0x00dc
        L_0x0073:
            java.lang.String r12 = "shear"
            boolean r10 = r10.equals(r12)
            if (r10 != 0) goto L_0x007c
            goto L_0x0022
        L_0x007c:
            r10 = 8
            goto L_0x00dc
        L_0x0080:
            java.lang.String r12 = "color"
            boolean r10 = r10.equals(r12)
            if (r10 != 0) goto L_0x0089
            goto L_0x0022
        L_0x0089:
            r10 = 7
            goto L_0x00dc
        L_0x008b:
            java.lang.String r12 = "ruby"
            boolean r10 = r10.equals(r12)
            if (r10 != 0) goto L_0x0094
            goto L_0x0022
        L_0x0094:
            r10 = 6
            goto L_0x00dc
        L_0x0096:
            java.lang.String r12 = "id"
            boolean r10 = r10.equals(r12)
            if (r10 != 0) goto L_0x009f
            goto L_0x0022
        L_0x009f:
            r10 = 5
            goto L_0x00dc
        L_0x00a1:
            java.lang.String r12 = "fontWeight"
            boolean r10 = r10.equals(r12)
            if (r10 != 0) goto L_0x00ab
            goto L_0x0022
        L_0x00ab:
            r10 = 4
            goto L_0x00dc
        L_0x00ad:
            java.lang.String r12 = "textDecoration"
            boolean r10 = r10.equals(r12)
            if (r10 != 0) goto L_0x00b7
            goto L_0x0022
        L_0x00b7:
            r10 = 3
            goto L_0x00dc
        L_0x00b9:
            java.lang.String r12 = "textAlign"
            boolean r10 = r10.equals(r12)
            if (r10 != 0) goto L_0x00c3
            goto L_0x0022
        L_0x00c3:
            r10 = 2
            goto L_0x00dc
        L_0x00c5:
            java.lang.String r12 = "fontFamily"
            boolean r10 = r10.equals(r12)
            if (r10 != 0) goto L_0x00cf
            goto L_0x0022
        L_0x00cf:
            r10 = 1
            goto L_0x00dc
        L_0x00d1:
            java.lang.String r12 = "fontStyle"
            boolean r10 = r10.equals(r12)
            if (r10 != 0) goto L_0x00db
            goto L_0x0022
        L_0x00db:
            r10 = 0
        L_0x00dc:
            switch(r10) {
                case 0: goto L_0x02cb;
                case 1: goto L_0x02c2;
                case 2: goto L_0x02b5;
                case 3: goto L_0x0252;
                case 4: goto L_0x0242;
                case 5: goto L_0x022c;
                case 6: goto L_0x01ae;
                case 7: goto L_0x0199;
                case 8: goto L_0x018b;
                case 9: goto L_0x015e;
                case 10: goto L_0x013f;
                case 11: goto L_0x0131;
                case 12: goto L_0x0104;
                case 13: goto L_0x00ef;
                case 14: goto L_0x00e1;
                default: goto L_0x00df;
            }
        L_0x00df:
            goto L_0x02d9
        L_0x00e1:
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = e(r14)
            android.text.Layout$Alignment r9 = g(r9)
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = r14.E(r9)
            goto L_0x02d9
        L_0x00ef:
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = e(r14)
            int r10 = androidx.media3.common.util.ColorParser.c(r9)     // Catch:{ IllegalArgumentException -> 0x00fc }
            r14.v(r10)     // Catch:{ IllegalArgumentException -> 0x00fc }
            goto L_0x02d9
        L_0x00fc:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r12 = "Failed parsing background value: "
            goto L_0x014f
        L_0x0104:
            java.lang.String r9 = com.google.common.base.Ascii.g(r9)
            r9.hashCode()
            java.lang.String r10 = "before"
            boolean r10 = r9.equals(r10)
            if (r10 != 0) goto L_0x0127
            java.lang.String r10 = "after"
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x011d
            goto L_0x02d9
        L_0x011d:
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = e(r14)
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = r14.F(r4)
            goto L_0x02d9
        L_0x0127:
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = e(r14)
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = r14.F(r5)
            goto L_0x02d9
        L_0x0131:
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = e(r14)
            androidx.media3.extractor.text.ttml.TextEmphasis r9 = androidx.media3.extractor.text.ttml.TextEmphasis.a(r9)
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = r14.K(r9)
            goto L_0x02d9
        L_0x013f:
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = e(r14)     // Catch:{ SubtitleDecoderException -> 0x0148 }
            i(r9, r14)     // Catch:{ SubtitleDecoderException -> 0x0148 }
            goto L_0x02d9
        L_0x0148:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r12 = "Failed parsing fontSize value: "
        L_0x014f:
            r10.append(r12)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            androidx.media3.common.util.Log.n(r11, r9)
            goto L_0x02d9
        L_0x015e:
            java.lang.String r9 = com.google.common.base.Ascii.g(r9)
            r9.hashCode()
            java.lang.String r10 = "all"
            boolean r10 = r9.equals(r10)
            if (r10 != 0) goto L_0x0181
            java.lang.String r10 = "none"
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x0177
            goto L_0x02d9
        L_0x0177:
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = e(r14)
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = r14.J(r7)
            goto L_0x02d9
        L_0x0181:
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = e(r14)
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = r14.J(r5)
            goto L_0x02d9
        L_0x018b:
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = e(r14)
            float r9 = o(r9)
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = r14.H(r9)
            goto L_0x02d9
        L_0x0199:
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = e(r14)
            int r10 = androidx.media3.common.util.ColorParser.c(r9)     // Catch:{ IllegalArgumentException -> 0x01a6 }
            r14.x(r10)     // Catch:{ IllegalArgumentException -> 0x01a6 }
            goto L_0x02d9
        L_0x01a6:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r12 = "Failed parsing color value: "
            goto L_0x014f
        L_0x01ae:
            java.lang.String r9 = com.google.common.base.Ascii.g(r9)
            r9.hashCode()
            int r10 = r9.hashCode()
            switch(r10) {
                case -618561360: goto L_0x01f5;
                case -410956671: goto L_0x01ea;
                case -250518009: goto L_0x01df;
                case -136074796: goto L_0x01d4;
                case 3016401: goto L_0x01c9;
                case 3556653: goto L_0x01be;
                default: goto L_0x01bc;
            }
        L_0x01bc:
            r9 = -1
            goto L_0x01ff
        L_0x01be:
            java.lang.String r10 = "text"
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x01c7
            goto L_0x01bc
        L_0x01c7:
            r9 = 5
            goto L_0x01ff
        L_0x01c9:
            java.lang.String r10 = "base"
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x01d2
            goto L_0x01bc
        L_0x01d2:
            r9 = 4
            goto L_0x01ff
        L_0x01d4:
            java.lang.String r10 = "textContainer"
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x01dd
            goto L_0x01bc
        L_0x01dd:
            r9 = 3
            goto L_0x01ff
        L_0x01df:
            java.lang.String r10 = "delimiter"
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x01e8
            goto L_0x01bc
        L_0x01e8:
            r9 = 2
            goto L_0x01ff
        L_0x01ea:
            java.lang.String r10 = "container"
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x01f3
            goto L_0x01bc
        L_0x01f3:
            r9 = 1
            goto L_0x01ff
        L_0x01f5:
            java.lang.String r10 = "baseContainer"
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x01fe
            goto L_0x01bc
        L_0x01fe:
            r9 = 0
        L_0x01ff:
            switch(r9) {
                case 0: goto L_0x0222;
                case 1: goto L_0x0218;
                case 2: goto L_0x020e;
                case 3: goto L_0x0204;
                case 4: goto L_0x0222;
                case 5: goto L_0x0204;
                default: goto L_0x0202;
            }
        L_0x0202:
            goto L_0x02d9
        L_0x0204:
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = e(r14)
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = r14.G(r3)
            goto L_0x02d9
        L_0x020e:
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = e(r14)
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = r14.G(r1)
            goto L_0x02d9
        L_0x0218:
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = e(r14)
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = r14.G(r5)
            goto L_0x02d9
        L_0x0222:
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = e(r14)
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = r14.G(r4)
            goto L_0x02d9
        L_0x022c:
            java.lang.String r10 = "style"
            java.lang.String r11 = r13.getName()
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L_0x02d9
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = e(r14)
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = r14.B(r9)
            goto L_0x02d9
        L_0x0242:
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = e(r14)
            java.lang.String r10 = "bold"
            boolean r9 = r10.equalsIgnoreCase(r9)
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = r14.w(r9)
            goto L_0x02d9
        L_0x0252:
            java.lang.String r9 = com.google.common.base.Ascii.g(r9)
            r9.hashCode()
            int r10 = r9.hashCode()
            switch(r10) {
                case -1461280213: goto L_0x0283;
                case -1026963764: goto L_0x0278;
                case 913457136: goto L_0x026d;
                case 1679736913: goto L_0x0262;
                default: goto L_0x0260;
            }
        L_0x0260:
            r9 = -1
            goto L_0x028d
        L_0x0262:
            java.lang.String r10 = "linethrough"
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x026b
            goto L_0x0260
        L_0x026b:
            r9 = 3
            goto L_0x028d
        L_0x026d:
            java.lang.String r10 = "nolinethrough"
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x0276
            goto L_0x0260
        L_0x0276:
            r9 = 2
            goto L_0x028d
        L_0x0278:
            java.lang.String r10 = "underline"
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x0281
            goto L_0x0260
        L_0x0281:
            r9 = 1
            goto L_0x028d
        L_0x0283:
            java.lang.String r10 = "nounderline"
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x028c
            goto L_0x0260
        L_0x028c:
            r9 = 0
        L_0x028d:
            switch(r9) {
                case 0: goto L_0x02ac;
                case 1: goto L_0x02a3;
                case 2: goto L_0x029a;
                case 3: goto L_0x0291;
                default: goto L_0x0290;
            }
        L_0x0290:
            goto L_0x02d9
        L_0x0291:
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = e(r14)
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = r14.D(r5)
            goto L_0x02d9
        L_0x029a:
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = e(r14)
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = r14.D(r7)
            goto L_0x02d9
        L_0x02a3:
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = e(r14)
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = r14.L(r5)
            goto L_0x02d9
        L_0x02ac:
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = e(r14)
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = r14.L(r7)
            goto L_0x02d9
        L_0x02b5:
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = e(r14)
            android.text.Layout$Alignment r9 = g(r9)
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = r14.I(r9)
            goto L_0x02d9
        L_0x02c2:
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = e(r14)
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = r14.y(r9)
            goto L_0x02d9
        L_0x02cb:
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = e(r14)
            java.lang.String r10 = "italic"
            boolean r9 = r10.equalsIgnoreCase(r9)
            androidx.media3.extractor.text.ttml.TtmlStyle r14 = r14.C(r9)
        L_0x02d9:
            int r8 = r8 + r5
            goto L_0x000c
        L_0x02dc:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.ttml.TtmlParser.p(org.xmlpull.v1.XmlPullParser, androidx.media3.extractor.text.ttml.TtmlStyle):androidx.media3.extractor.text.ttml.TtmlStyle");
    }

    private static String[] q(String str) {
        String trim = str.trim();
        return trim.isEmpty() ? new String[0] : Util.p2(trim, "\\s+");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00be, code lost:
        if (r13.equals("ms") == false) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00f5, code lost:
        r8 = r8 / r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00fd, code lost:
        r8 = r8 * r13;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long r(java.lang.String r13, androidx.media3.extractor.text.ttml.TtmlParser.FrameAndTickRate r14) throws androidx.media3.extractor.text.SubtitleDecoderException {
        /*
            r0 = 4
            r1 = 3
            java.util.regex.Pattern r2 = f14036k
            java.util.regex.Matcher r2 = r2.matcher(r13)
            boolean r3 = r2.matches()
            r4 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            r6 = 2
            r7 = 1
            if (r3 == 0) goto L_0x0087
            java.lang.String r13 = r2.group(r7)
            java.lang.Object r13 = androidx.media3.common.util.Assertions.g(r13)
            java.lang.String r13 = (java.lang.String) r13
            long r7 = java.lang.Long.parseLong(r13)
            r9 = 3600(0xe10, double:1.7786E-320)
            long r7 = r7 * r9
            double r7 = (double) r7
            java.lang.String r13 = r2.group(r6)
            java.lang.Object r13 = androidx.media3.common.util.Assertions.g(r13)
            java.lang.String r13 = (java.lang.String) r13
            long r9 = java.lang.Long.parseLong(r13)
            r11 = 60
            long r9 = r9 * r11
            double r9 = (double) r9
            double r7 = r7 + r9
            java.lang.String r13 = r2.group(r1)
            java.lang.Object r13 = androidx.media3.common.util.Assertions.g(r13)
            java.lang.String r13 = (java.lang.String) r13
            long r9 = java.lang.Long.parseLong(r13)
            double r9 = (double) r9
            double r7 = r7 + r9
            java.lang.String r13 = r2.group(r0)
            r0 = 0
            if (r13 == 0) goto L_0x0059
            double r9 = java.lang.Double.parseDouble(r13)
            goto L_0x005a
        L_0x0059:
            r9 = r0
        L_0x005a:
            double r7 = r7 + r9
            r13 = 5
            java.lang.String r13 = r2.group(r13)
            if (r13 == 0) goto L_0x006c
            long r9 = java.lang.Long.parseLong(r13)
            float r13 = (float) r9
            float r3 = r14.f14041a
            float r13 = r13 / r3
            double r9 = (double) r13
            goto L_0x006d
        L_0x006c:
            r9 = r0
        L_0x006d:
            double r7 = r7 + r9
            r13 = 6
            java.lang.String r13 = r2.group(r13)
            if (r13 == 0) goto L_0x0082
            long r0 = java.lang.Long.parseLong(r13)
            double r0 = (double) r0
            int r13 = r14.f14042b
            double r2 = (double) r13
            double r0 = r0 / r2
            float r13 = r14.f14041a
            double r13 = (double) r13
            double r0 = r0 / r13
        L_0x0082:
            double r7 = r7 + r0
            double r7 = r7 * r4
            long r13 = (long) r7
            return r13
        L_0x0087:
            java.util.regex.Pattern r2 = f14037l
            java.util.regex.Matcher r2 = r2.matcher(r13)
            boolean r3 = r2.matches()
            if (r3 == 0) goto L_0x010e
            java.lang.String r13 = r2.group(r7)
            java.lang.Object r13 = androidx.media3.common.util.Assertions.g(r13)
            java.lang.String r13 = (java.lang.String) r13
            double r8 = java.lang.Double.parseDouble(r13)
            java.lang.String r13 = r2.group(r6)
            java.lang.Object r13 = androidx.media3.common.util.Assertions.g(r13)
            java.lang.String r13 = (java.lang.String) r13
            r13.hashCode()
            r2 = -1
            int r3 = r13.hashCode()
            switch(r3) {
                case 102: goto L_0x00e2;
                case 104: goto L_0x00d7;
                case 109: goto L_0x00cc;
                case 116: goto L_0x00c1;
                case 3494: goto L_0x00b8;
                default: goto L_0x00b6;
            }
        L_0x00b6:
            r0 = -1
            goto L_0x00ec
        L_0x00b8:
            java.lang.String r1 = "ms"
            boolean r13 = r13.equals(r1)
            if (r13 != 0) goto L_0x00ec
            goto L_0x00b6
        L_0x00c1:
            java.lang.String r0 = "t"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00ca
            goto L_0x00b6
        L_0x00ca:
            r0 = 3
            goto L_0x00ec
        L_0x00cc:
            java.lang.String r0 = "m"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00d5
            goto L_0x00b6
        L_0x00d5:
            r0 = 2
            goto L_0x00ec
        L_0x00d7:
            java.lang.String r0 = "h"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00e0
            goto L_0x00b6
        L_0x00e0:
            r0 = 1
            goto L_0x00ec
        L_0x00e2:
            java.lang.String r0 = "f"
            boolean r13 = r13.equals(r0)
            if (r13 != 0) goto L_0x00eb
            goto L_0x00b6
        L_0x00eb:
            r0 = 0
        L_0x00ec:
            switch(r0) {
                case 0: goto L_0x0106;
                case 1: goto L_0x0100;
                case 2: goto L_0x00fb;
                case 3: goto L_0x00f7;
                case 4: goto L_0x00f0;
                default: goto L_0x00ef;
            }
        L_0x00ef:
            goto L_0x010a
        L_0x00f0:
            r13 = 4652007308841189376(0x408f400000000000, double:1000.0)
        L_0x00f5:
            double r8 = r8 / r13
            goto L_0x010a
        L_0x00f7:
            int r13 = r14.f14043c
            double r13 = (double) r13
            goto L_0x00f5
        L_0x00fb:
            r13 = 4633641066610819072(0x404e000000000000, double:60.0)
        L_0x00fd:
            double r8 = r8 * r13
            goto L_0x010a
        L_0x0100:
            r13 = 4660134898793709568(0x40ac200000000000, double:3600.0)
            goto L_0x00fd
        L_0x0106:
            float r13 = r14.f14041a
            double r13 = (double) r13
            goto L_0x00f5
        L_0x010a:
            double r8 = r8 * r4
            long r13 = (long) r8
            return r13
        L_0x010e:
            androidx.media3.extractor.text.SubtitleDecoderException r14 = new androidx.media3.extractor.text.SubtitleDecoderException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Malformed time expression: "
            r0.append(r1)
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            r14.<init>((java.lang.String) r13)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.ttml.TtmlParser.r(java.lang.String, androidx.media3.extractor.text.ttml.TtmlParser$FrameAndTickRate):long");
    }

    @Nullable
    private static TtsExtent s(XmlPullParser xmlPullParser) {
        StringBuilder sb;
        String str;
        String a2 = XmlPullParserUtil.a(xmlPullParser, TtmlNode.F);
        if (a2 == null) {
            return null;
        }
        Matcher matcher = p.matcher(a2);
        if (!matcher.matches()) {
            sb = new StringBuilder();
            str = "Ignoring non-pixel tts extent: ";
        } else {
            try {
                return new TtsExtent(Integer.parseInt((String) Assertions.g(matcher.group(1))), Integer.parseInt((String) Assertions.g(matcher.group(2))));
            } catch (NumberFormatException unused) {
                sb = new StringBuilder();
                str = "Ignoring malformed tts extent: ";
            }
        }
        sb.append(str);
        sb.append(a2);
        Log.n(f14028c, sb.toString());
        return null;
    }

    public void a(byte[] bArr, int i2, int i3, SubtitleParser.OutputOptions outputOptions, Consumer<CuesWithTiming> consumer) {
        LegacySubtitleUtil.c(b(bArr, i2, i3), outputOptions, consumer);
    }

    public Subtitle b(byte[] bArr, int i2, int i3) {
        FrameAndTickRate frameAndTickRate;
        try {
            XmlPullParser newPullParser = this.f14040a.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            hashMap2.put("", new TtmlRegion(""));
            TtsExtent ttsExtent = null;
            newPullParser.setInput(new ByteArrayInputStream(bArr, i2, i3), (String) null);
            ArrayDeque arrayDeque = new ArrayDeque();
            FrameAndTickRate frameAndTickRate2 = s;
            TtmlSubtitle ttmlSubtitle = null;
            int i4 = 15;
            int i5 = 0;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                TtmlNode ttmlNode = (TtmlNode) arrayDeque.peek();
                if (i5 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            frameAndTickRate2 = j(newPullParser);
                            i4 = h(newPullParser, 15);
                            ttsExtent = s(newPullParser);
                        }
                        TtsExtent ttsExtent2 = ttsExtent;
                        FrameAndTickRate frameAndTickRate3 = frameAndTickRate2;
                        int i6 = i4;
                        if (!f(name)) {
                            Log.h(f14028c, "Ignoring unsupported tag: " + newPullParser.getName());
                            i5++;
                            frameAndTickRate2 = frameAndTickRate3;
                        } else {
                            if ("head".equals(name)) {
                                frameAndTickRate = frameAndTickRate3;
                                k(newPullParser, hashMap, i6, ttsExtent2, hashMap2, hashMap3);
                            } else {
                                frameAndTickRate = frameAndTickRate3;
                                try {
                                    TtmlNode m2 = m(newPullParser, ttmlNode, hashMap2, frameAndTickRate);
                                    arrayDeque.push(m2);
                                    if (ttmlNode != null) {
                                        ttmlNode.a(m2);
                                    }
                                } catch (SubtitleDecoderException e2) {
                                    Log.o(f14028c, "Suppressing parser error", e2);
                                    i5++;
                                }
                            }
                            frameAndTickRate2 = frameAndTickRate;
                        }
                        ttsExtent = ttsExtent2;
                        i4 = i6;
                    } else if (eventType == 4) {
                        ((TtmlNode) Assertions.g(ttmlNode)).a(TtmlNode.d(newPullParser.getText()));
                    } else if (eventType == 3) {
                        if (newPullParser.getName().equals("tt")) {
                            ttmlSubtitle = new TtmlSubtitle((TtmlNode) Assertions.g((TtmlNode) arrayDeque.peek()), hashMap, hashMap2, hashMap3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i5++;
                } else if (eventType == 3) {
                    i5--;
                }
                newPullParser.next();
            }
            return (Subtitle) Assertions.g(ttmlSubtitle);
        } catch (XmlPullParserException e3) {
            throw new IllegalStateException("Unable to decode source", e3);
        } catch (IOException e4) {
            throw new IllegalStateException("Unexpected error when reading input.", e4);
        }
    }

    public /* synthetic */ void c(byte[] bArr, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        e.a(this, bArr, outputOptions, consumer);
    }

    public int d() {
        return 1;
    }

    public /* synthetic */ void reset() {
        e.c(this);
    }
}
