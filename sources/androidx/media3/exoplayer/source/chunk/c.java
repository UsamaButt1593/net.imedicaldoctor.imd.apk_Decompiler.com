package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.Format;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.chunk.ChunkExtractor;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.text.SubtitleParser;
import java.util.List;

public final /* synthetic */ class c implements ChunkExtractor.Factory {
    public /* synthetic */ ChunkExtractor.Factory a(SubtitleParser.Factory factory) {
        return a.c(this, factory);
    }

    public /* synthetic */ ChunkExtractor.Factory b(boolean z) {
        return a.a(this, z);
    }

    public /* synthetic */ Format c(Format format) {
        return a.b(this, format);
    }

    public final ChunkExtractor d(int i2, Format format, boolean z, List list, TrackOutput trackOutput, PlayerId playerId) {
        return MediaParserChunkExtractor.k(i2, format, z, list, trackOutput, playerId);
    }
}
