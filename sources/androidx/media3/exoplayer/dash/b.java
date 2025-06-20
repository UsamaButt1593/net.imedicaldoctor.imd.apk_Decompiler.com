package androidx.media3.exoplayer.dash;

import androidx.media3.common.Format;
import androidx.media3.exoplayer.dash.DashChunkSource;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

public final /* synthetic */ class b {
    @CanIgnoreReturnValue
    public static DashChunkSource.Factory a(DashChunkSource.Factory factory, boolean z) {
        return factory;
    }

    public static Format b(DashChunkSource.Factory factory, Format format) {
        return format;
    }

    @CanIgnoreReturnValue
    public static DashChunkSource.Factory c(DashChunkSource.Factory factory, SubtitleParser.Factory factory2) {
        return factory;
    }
}
