package androidx.media3.exoplayer.source.chunk;

import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.extractor.ChunkIndex;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.List;

@UnstableApi
public interface ChunkExtractor {

    public interface Factory {
        @CanIgnoreReturnValue
        Factory a(SubtitleParser.Factory factory);

        @CanIgnoreReturnValue
        Factory b(boolean z);

        Format c(Format format);

        @Nullable
        ChunkExtractor d(int i2, Format format, boolean z, List<Format> list, @Nullable TrackOutput trackOutput, PlayerId playerId);
    }

    public interface TrackOutputProvider {
        TrackOutput d(int i2, int i3);
    }

    void a();

    boolean b(ExtractorInput extractorInput) throws IOException;

    @Nullable
    Format[] c();

    void e(@Nullable TrackOutputProvider trackOutputProvider, long j2, long j3);

    @Nullable
    ChunkIndex f();
}
