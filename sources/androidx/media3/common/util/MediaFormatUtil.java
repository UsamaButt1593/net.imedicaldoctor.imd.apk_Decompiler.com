package androidx.media3.common.util;

import android.annotation.SuppressLint;
import android.media.MediaFormat;
import androidx.annotation.Nullable;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import com.google.common.collect.ImmutableList;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.nio.ByteBuffer;
import java.util.List;

@UnstableApi
public final class MediaFormatUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final String f9590a = "exo-pixel-width-height-ratio-float";

    /* renamed from: b  reason: collision with root package name */
    public static final String f9591b = "exo-pcm-encoding-int";

    /* renamed from: c  reason: collision with root package name */
    public static final String f9592c = "max-bitrate";

    /* renamed from: d  reason: collision with root package name */
    private static final int f9593d = 1073741824;

    private MediaFormatUtil() {
    }

    @SuppressLint({"InlinedApi"})
    public static Format a(MediaFormat mediaFormat) {
        int i2 = 0;
        Format.Builder e0 = new Format.Builder().k0(mediaFormat.getString(Annotation.w3)).b0(mediaFormat.getString(DublinCoreProperties.f27402h)).f0(h(mediaFormat, f9592c, -1)).K(h(mediaFormat, "bitrate", -1)).M(mediaFormat.getString("codecs-string")).U(g(mediaFormat, -1.0f)).r0(h(mediaFormat, "width", -1)).V(h(mediaFormat, "height", -1)).g0(i(mediaFormat, 1.0f)).c0(h(mediaFormat, "max-input-size", -1)).j0(h(mediaFormat, "rotation-degrees", 0)).N(e(mediaFormat, true)).l0(h(mediaFormat, "sample-rate", -1)).L(h(mediaFormat, "channel-count", -1)).e0(h(mediaFormat, "pcm-encoding", -1));
        ImmutableList.Builder builder = new ImmutableList.Builder();
        while (true) {
            ByteBuffer byteBuffer = mediaFormat.getByteBuffer("csd-" + i2);
            if (byteBuffer == null) {
                e0.Y(builder.e());
                return e0.I();
            }
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            byteBuffer.rewind();
            builder.g(bArr);
            i2++;
        }
    }

    @SuppressLint({"InlinedApi"})
    public static MediaFormat b(Format format) {
        MediaFormat mediaFormat = new MediaFormat();
        s(mediaFormat, "bitrate", format.b3);
        s(mediaFormat, f9592c, format.a3);
        s(mediaFormat, "channel-count", format.s3);
        q(mediaFormat, format.r3);
        v(mediaFormat, Annotation.w3, format.f3);
        v(mediaFormat, "codecs-string", format.c3);
        r(mediaFormat, "frame-rate", format.m3);
        s(mediaFormat, "width", format.k3);
        s(mediaFormat, "height", format.l3);
        x(mediaFormat, format.h3);
        t(mediaFormat, format.u3);
        v(mediaFormat, DublinCoreProperties.f27402h, format.Z);
        s(mediaFormat, "max-input-size", format.g3);
        s(mediaFormat, "sample-rate", format.t3);
        s(mediaFormat, "caption-service-number", format.x3);
        mediaFormat.setInteger("rotation-degrees", format.n3);
        int i2 = format.X2;
        w(mediaFormat, "is-autoselect", i2 & 4);
        w(mediaFormat, "is-default", i2 & 1);
        w(mediaFormat, "is-forced-subtitle", i2 & 2);
        mediaFormat.setInteger("encoder-delay", format.v3);
        mediaFormat.setInteger("encoder-padding", format.w3);
        u(mediaFormat, format.o3);
        return mediaFormat;
    }

    public static byte[] c(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return bArr;
    }

    @Nullable
    public static ColorInfo d(MediaFormat mediaFormat) {
        return e(mediaFormat, false);
    }

    @Nullable
    private static ColorInfo e(MediaFormat mediaFormat, boolean z) {
        if (Util.f9646a < 24) {
            return null;
        }
        int h2 = h(mediaFormat, "color-standard", -1);
        int h3 = h(mediaFormat, "color-range", -1);
        int h4 = h(mediaFormat, "color-transfer", -1);
        ByteBuffer byteBuffer = mediaFormat.getByteBuffer("hdr-static-info");
        byte[] c2 = byteBuffer != null ? c(byteBuffer) : null;
        if (!z) {
            if (!m(h2)) {
                h2 = -1;
            }
            if (!l(h3)) {
                h3 = -1;
            }
            if (!n(h4)) {
                h4 = -1;
            }
        }
        if (h2 == -1 && h3 == -1 && h4 == -1 && c2 == null) {
            return null;
        }
        return new ColorInfo.Builder().d(h2).c(h3).e(h4).f(c2).a();
    }

    public static float f(MediaFormat mediaFormat, String str, float f2) {
        return mediaFormat.containsKey(str) ? mediaFormat.getFloat(str) : f2;
    }

    private static float g(MediaFormat mediaFormat, float f2) {
        if (!mediaFormat.containsKey("frame-rate")) {
            return f2;
        }
        try {
            return mediaFormat.getFloat("frame-rate");
        } catch (ClassCastException unused) {
            return (float) mediaFormat.getInteger("frame-rate");
        }
    }

    public static int h(MediaFormat mediaFormat, String str, int i2) {
        return mediaFormat.containsKey(str) ? mediaFormat.getInteger(str) : i2;
    }

    @SuppressLint({"InlinedApi"})
    private static float i(MediaFormat mediaFormat, float f2) {
        return (!mediaFormat.containsKey("sar-width") || !mediaFormat.containsKey("sar-height")) ? f2 : ((float) mediaFormat.getInteger("sar-width")) / ((float) mediaFormat.getInteger("sar-height"));
    }

    @Nullable
    public static Integer j(MediaFormat mediaFormat) {
        if (!mediaFormat.containsKey("time-lapse-enable") || mediaFormat.getInteger("time-lapse-enable") <= 0 || !mediaFormat.containsKey("time-lapse-fps")) {
            return null;
        }
        return Integer.valueOf(mediaFormat.getInteger("time-lapse-fps"));
    }

    public static boolean k(MediaFormat mediaFormat) {
        return MimeTypes.p(mediaFormat.getString(Annotation.w3));
    }

    private static boolean l(int i2) {
        return i2 == 2 || i2 == 1 || i2 == -1;
    }

    private static boolean m(int i2) {
        return i2 == 2 || i2 == 1 || i2 == 6 || i2 == -1;
    }

    private static boolean n(int i2) {
        return i2 == 1 || i2 == 3 || i2 == 6 || i2 == 7 || i2 == -1;
    }

    public static boolean o(MediaFormat mediaFormat) {
        return MimeTypes.t(mediaFormat.getString(Annotation.w3));
    }

    public static void p(MediaFormat mediaFormat, String str, @Nullable byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public static void q(MediaFormat mediaFormat, @Nullable ColorInfo colorInfo) {
        if (colorInfo != null) {
            s(mediaFormat, "color-transfer", colorInfo.Y);
            s(mediaFormat, "color-standard", colorInfo.s);
            s(mediaFormat, "color-range", colorInfo.X);
            p(mediaFormat, "hdr-static-info", colorInfo.Z);
        }
    }

    public static void r(MediaFormat mediaFormat, String str, float f2) {
        if (f2 != -1.0f) {
            mediaFormat.setFloat(str, f2);
        }
    }

    public static void s(MediaFormat mediaFormat, String str, int i2) {
        if (i2 != -1) {
            mediaFormat.setInteger(str, i2);
        }
    }

    @SuppressLint({"InlinedApi"})
    private static void t(MediaFormat mediaFormat, int i2) {
        int i3;
        if (i2 != -1) {
            s(mediaFormat, f9591b, i2);
            if (i2 != 0) {
                i3 = 2;
                if (i2 != 2) {
                    i3 = 3;
                    if (i2 != 3) {
                        i3 = 4;
                        if (i2 != 4) {
                            i3 = 21;
                            if (i2 != 21) {
                                i3 = 22;
                                if (i2 != 22) {
                                    return;
                                }
                            }
                        }
                    }
                }
            } else {
                i3 = 0;
            }
            mediaFormat.setInteger("pcm-encoding", i3);
        }
    }

    @SuppressLint({"InlinedApi"})
    private static void u(MediaFormat mediaFormat, float f2) {
        int i2;
        mediaFormat.setFloat(f9590a, f2);
        int i3 = 1073741824;
        if (f2 < 1.0f) {
            i3 = (int) (f2 * ((float) 1073741824));
            i2 = 1073741824;
        } else if (f2 > 1.0f) {
            i2 = (int) (((float) 1073741824) / f2);
        } else {
            i3 = 1;
            i2 = 1;
        }
        mediaFormat.setInteger("sar-width", i3);
        mediaFormat.setInteger("sar-height", i2);
    }

    public static void v(MediaFormat mediaFormat, String str, @Nullable String str2) {
        if (str2 != null) {
            mediaFormat.setString(str, str2);
        }
    }

    private static void w(MediaFormat mediaFormat, String str, int i2) {
        mediaFormat.setInteger(str, i2 != 0 ? 1 : 0);
    }

    public static void x(MediaFormat mediaFormat, List<byte[]> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            mediaFormat.setByteBuffer("csd-" + i2, ByteBuffer.wrap(list.get(i2)));
        }
    }
}
