package androidx.media3.exoplayer.hls;

import android.net.Uri;
import androidx.media3.common.Format;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.text.SubtitleParser;
import java.util.List;
import java.util.Map;

public final /* synthetic */ class m implements HlsExtractorFactory {
    public /* synthetic */ HlsExtractorFactory a(SubtitleParser.Factory factory) {
        return a.c(this, factory);
    }

    public /* synthetic */ HlsExtractorFactory b(boolean z) {
        return a.a(this, z);
    }

    public /* synthetic */ Format c(Format format) {
        return a.b(this, format);
    }

    public final HlsMediaChunkExtractor d(Uri uri, Format format, List list, TimestampAdjuster timestampAdjuster, Map map, ExtractorInput extractorInput, PlayerId playerId) {
        return MediaParserHlsMediaChunkExtractor.i(uri, format, list, timestampAdjuster, map, extractorInput, playerId);
    }
}
