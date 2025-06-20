package androidx.media3.exoplayer.hls;

import androidx.media3.common.Format;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

public final /* synthetic */ class a {
    @CanIgnoreReturnValue
    public static HlsExtractorFactory a(HlsExtractorFactory hlsExtractorFactory, boolean z) {
        return hlsExtractorFactory;
    }

    public static Format b(HlsExtractorFactory hlsExtractorFactory, Format format) {
        return format;
    }

    @CanIgnoreReturnValue
    public static HlsExtractorFactory c(HlsExtractorFactory hlsExtractorFactory, SubtitleParser.Factory factory) {
        return hlsExtractorFactory;
    }
}
