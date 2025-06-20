package androidx.media3.exoplayer.hls.playlist;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.upstream.ParsingLoadable;

@UnstableApi
public final class DefaultHlsPlaylistParserFactory implements HlsPlaylistParserFactory {
    public ParsingLoadable.Parser<HlsPlaylist> a(HlsMultivariantPlaylist hlsMultivariantPlaylist, @Nullable HlsMediaPlaylist hlsMediaPlaylist) {
        return new HlsPlaylistParser(hlsMultivariantPlaylist, hlsMediaPlaylist);
    }

    public ParsingLoadable.Parser<HlsPlaylist> b() {
        return new HlsPlaylistParser();
    }
}
