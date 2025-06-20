package androidx.media3.exoplayer.smoothstreaming;

import androidx.media3.common.Format;
import androidx.media3.exoplayer.smoothstreaming.SsChunkSource;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

public final /* synthetic */ class a {
    @CanIgnoreReturnValue
    public static SsChunkSource.Factory a(SsChunkSource.Factory factory, boolean z) {
        return factory;
    }

    public static Format b(SsChunkSource.Factory factory, Format format) {
        return format;
    }

    @CanIgnoreReturnValue
    public static SsChunkSource.Factory c(SsChunkSource.Factory factory, SubtitleParser.Factory factory2) {
        return factory;
    }
}
