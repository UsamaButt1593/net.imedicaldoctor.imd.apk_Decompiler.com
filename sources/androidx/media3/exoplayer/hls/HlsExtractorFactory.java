package androidx.media3.exoplayer.hls;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@UnstableApi
public interface HlsExtractorFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final HlsExtractorFactory f11408a = new DefaultHlsExtractorFactory();

    @CanIgnoreReturnValue
    HlsExtractorFactory a(SubtitleParser.Factory factory);

    @CanIgnoreReturnValue
    HlsExtractorFactory b(boolean z);

    Format c(Format format);

    HlsMediaChunkExtractor d(Uri uri, Format format, @Nullable List<Format> list, TimestampAdjuster timestampAdjuster, Map<String, List<String>> map, ExtractorInput extractorInput, PlayerId playerId) throws IOException;
}
