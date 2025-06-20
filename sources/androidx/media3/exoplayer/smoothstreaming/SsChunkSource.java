package androidx.media3.exoplayer.smoothstreaming;

import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.smoothstreaming.manifest.SsManifest;
import androidx.media3.exoplayer.source.chunk.ChunkSource;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoaderErrorThrower;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@UnstableApi
public interface SsChunkSource extends ChunkSource {

    public interface Factory {
        @CanIgnoreReturnValue
        Factory a(SubtitleParser.Factory factory);

        @CanIgnoreReturnValue
        Factory b(boolean z);

        Format c(Format format);

        SsChunkSource d(LoaderErrorThrower loaderErrorThrower, SsManifest ssManifest, int i2, ExoTrackSelection exoTrackSelection, @Nullable TransferListener transferListener, @Nullable CmcdConfiguration cmcdConfiguration);
    }

    void c(ExoTrackSelection exoTrackSelection);

    void h(SsManifest ssManifest);
}
