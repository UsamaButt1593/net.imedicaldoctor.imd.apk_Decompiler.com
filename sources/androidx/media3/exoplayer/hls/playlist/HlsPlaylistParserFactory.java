package androidx.media3.exoplayer.hls.playlist;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.upstream.ParsingLoadable;

@UnstableApi
public interface HlsPlaylistParserFactory {
    ParsingLoadable.Parser<HlsPlaylist> a(HlsMultivariantPlaylist hlsMultivariantPlaylist, @Nullable HlsMediaPlaylist hlsMediaPlaylist);

    ParsingLoadable.Parser<HlsPlaylist> b();
}
