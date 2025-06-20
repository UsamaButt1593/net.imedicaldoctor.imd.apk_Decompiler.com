package androidx.media3.exoplayer.source.chunk;

import androidx.media3.common.Format;
import androidx.media3.exoplayer.source.chunk.ChunkExtractor;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

public final /* synthetic */ class a {
    @CanIgnoreReturnValue
    public static ChunkExtractor.Factory a(ChunkExtractor.Factory factory, boolean z) {
        return factory;
    }

    public static Format b(ChunkExtractor.Factory factory, Format format) {
        return format;
    }

    @CanIgnoreReturnValue
    public static ChunkExtractor.Factory c(ChunkExtractor.Factory factory, SubtitleParser.Factory factory2) {
        return factory;
    }
}
