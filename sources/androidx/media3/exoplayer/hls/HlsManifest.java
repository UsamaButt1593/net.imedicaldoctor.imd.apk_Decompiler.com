package androidx.media3.exoplayer.hls;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist;

@UnstableApi
public final class HlsManifest {

    /* renamed from: a  reason: collision with root package name */
    public final HlsMultivariantPlaylist f11409a;

    /* renamed from: b  reason: collision with root package name */
    public final HlsMediaPlaylist f11410b;

    HlsManifest(HlsMultivariantPlaylist hlsMultivariantPlaylist, HlsMediaPlaylist hlsMediaPlaylist) {
        this.f11409a = hlsMultivariantPlaylist;
        this.f11410b = hlsMediaPlaylist;
    }
}
