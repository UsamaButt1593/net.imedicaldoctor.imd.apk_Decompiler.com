package androidx.media3.extractor.jpeg;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.XmlPullParserUtil;
import androidx.media3.extractor.jpeg.MotionPhotoDescription;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

final class XmpMotionPhotoDescriptionParser {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13340a = "MotionPhotoXmpParser";

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f13341b = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f13342c = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f13343d = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    private XmpMotionPhotoDescriptionParser() {
    }

    @Nullable
    public static MotionPhotoDescription a(String str) throws IOException {
        try {
            return b(str);
        } catch (ParserException | NumberFormatException | XmlPullParserException unused) {
            Log.n(f13340a, "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    @Nullable
    private static MotionPhotoDescription b(String str) throws XmlPullParserException, IOException {
        String str2;
        String str3;
        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
        newPullParser.setInput(new StringReader(str));
        newPullParser.next();
        if (XmlPullParserUtil.f(newPullParser, "x:xmpmeta")) {
            ImmutableList<MotionPhotoDescription.ContainerItem> I = ImmutableList.I();
            long j2 = C.f9084b;
            do {
                newPullParser.next();
                if (!XmlPullParserUtil.f(newPullParser, "rdf:Description")) {
                    if (XmlPullParserUtil.f(newPullParser, "Container:Directory")) {
                        str2 = "Container";
                        str3 = "Item";
                    } else if (XmlPullParserUtil.f(newPullParser, "GContainer:Directory")) {
                        str2 = "GContainer";
                        str3 = "GContainerItem";
                    }
                    I = f(newPullParser, str2, str3);
                } else if (!d(newPullParser)) {
                    return null;
                } else {
                    j2 = e(newPullParser);
                    I = c(newPullParser);
                }
            } while (!XmlPullParserUtil.d(newPullParser, "x:xmpmeta"));
            if (I.isEmpty()) {
                return null;
            }
            return new MotionPhotoDescription(j2, I);
        }
        throw ParserException.a("Couldn't find xmp metadata", (Throwable) null);
    }

    private static ImmutableList<MotionPhotoDescription.ContainerItem> c(XmlPullParser xmlPullParser) {
        for (String a2 : f13343d) {
            String a3 = XmlPullParserUtil.a(xmlPullParser, a2);
            if (a3 != null) {
                return ImmutableList.L(new MotionPhotoDescription.ContainerItem(MimeTypes.Q0, "Primary", 0, 0), new MotionPhotoDescription.ContainerItem(MimeTypes.f9231f, "MotionPhoto", Long.parseLong(a3), 0));
            }
        }
        return ImmutableList.I();
    }

    private static boolean d(XmlPullParser xmlPullParser) {
        for (String a2 : f13341b) {
            String a3 = XmlPullParserUtil.a(xmlPullParser, a2);
            if (a3 != null) {
                return Integer.parseInt(a3) == 1;
            }
        }
        return false;
    }

    private static long e(XmlPullParser xmlPullParser) {
        for (String a2 : f13342c) {
            String a3 = XmlPullParserUtil.a(xmlPullParser, a2);
            if (a3 != null) {
                long parseLong = Long.parseLong(a3);
                return parseLong == -1 ? C.f9084b : parseLong;
            }
        }
        return C.f9084b;
    }

    private static ImmutableList<MotionPhotoDescription.ContainerItem> f(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        ImmutableList.Builder r = ImmutableList.r();
        String str3 = str + ":Item";
        String str4 = str + ":Directory";
        do {
            xmlPullParser.next();
            if (XmlPullParserUtil.f(xmlPullParser, str3)) {
                String a2 = XmlPullParserUtil.a(xmlPullParser, str2 + ":Mime");
                String a3 = XmlPullParserUtil.a(xmlPullParser, str2 + ":Semantic");
                String a4 = XmlPullParserUtil.a(xmlPullParser, str2 + ":Length");
                String a5 = XmlPullParserUtil.a(xmlPullParser, str2 + ":Padding");
                if (a2 == null || a3 == null) {
                    return ImmutableList.I();
                }
                r.g(new MotionPhotoDescription.ContainerItem(a2, a3, a4 != null ? Long.parseLong(a4) : 0, a5 != null ? Long.parseLong(a5) : 0));
            }
        } while (!XmlPullParserUtil.d(xmlPullParser, str4));
        return r.e();
    }
}
