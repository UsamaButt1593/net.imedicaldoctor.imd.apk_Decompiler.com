package androidx.media3.exoplayer.hls.playlist;

import androidx.annotation.Nullable;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.offline.FilteringManifestParser;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import java.util.List;

@UnstableApi
public final class FilteringHlsPlaylistParserFactory implements HlsPlaylistParserFactory {

    /* renamed from: a  reason: collision with root package name */
    private final HlsPlaylistParserFactory f11555a;

    /* renamed from: b  reason: collision with root package name */
    private final List<StreamKey> f11556b;

    public FilteringHlsPlaylistParserFactory(HlsPlaylistParserFactory hlsPlaylistParserFactory, List<StreamKey> list) {
        this.f11555a = hlsPlaylistParserFactory;
        this.f11556b = list;
    }

    public ParsingLoadable.Parser<HlsPlaylist> a(HlsMultivariantPlaylist hlsMultivariantPlaylist, @Nullable HlsMediaPlaylist hlsMediaPlaylist) {
        return new FilteringManifestParser(this.f11555a.a(hlsMultivariantPlaylist, hlsMediaPlaylist), this.f11556b);
    }

    public ParsingLoadable.Parser<HlsPlaylist> b() {
        return new FilteringManifestParser(this.f11555a.b(), this.f11556b);
    }
}
