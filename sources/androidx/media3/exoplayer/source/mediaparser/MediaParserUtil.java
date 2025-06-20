package androidx.media3.exoplayer.source.mediaparser;

import android.media.MediaFormat;
import android.media.MediaParser;
import android.media.metrics.LogSessionId;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.analytics.PlayerId;
import com.itextpdf.text.Annotation;

@UnstableApi
public final class MediaParserUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final String f12304a = "android.media.mediaparser.inBandCryptoInfo";

    /* renamed from: b  reason: collision with root package name */
    public static final String f12305b = "android.media.mediaparser.includeSupplementalData";

    /* renamed from: c  reason: collision with root package name */
    public static final String f12306c = "android.media.mediaparser.eagerlyExposeTrackType";

    /* renamed from: d  reason: collision with root package name */
    public static final String f12307d = "android.media.mediaparser.exposeDummySeekMap";

    /* renamed from: e  reason: collision with root package name */
    public static final String f12308e = "android.media.mediaParser.exposeChunkIndexAsMediaFormat";

    /* renamed from: f  reason: collision with root package name */
    public static final String f12309f = "android.media.mediaParser.overrideInBandCaptionDeclarations";

    /* renamed from: g  reason: collision with root package name */
    public static final String f12310g = "android.media.mediaParser.exposeCaptionFormats";

    /* renamed from: h  reason: collision with root package name */
    public static final String f12311h = "android.media.mediaparser.ignoreTimestampOffset";

    @RequiresApi(31)
    private static final class Api31 {
        private Api31() {
        }

        @DoNotInline
        public static void a(MediaParser mediaParser, PlayerId playerId) {
            LogSessionId a2 = playerId.a();
            if (!a2.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                mediaParser.setLogSessionId(a2);
            }
        }
    }

    private MediaParserUtil() {
    }

    @RequiresApi(31)
    public static void a(MediaParser mediaParser, PlayerId playerId) {
        Api31.a(mediaParser, playerId);
    }

    public static MediaFormat b(Format format) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(Annotation.w3, format.f3);
        int i2 = format.x3;
        if (i2 != -1) {
            mediaFormat.setInteger("caption-service-number", i2);
        }
        return mediaFormat;
    }
}
