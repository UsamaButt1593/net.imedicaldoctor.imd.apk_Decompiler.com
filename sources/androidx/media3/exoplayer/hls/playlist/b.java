package androidx.media3.exoplayer.hls.playlist;

import android.net.Uri;
import androidx.media3.exoplayer.hls.playlist.DefaultHlsPlaylistTracker;

public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ Uri X;
    public final /* synthetic */ DefaultHlsPlaylistTracker.MediaPlaylistBundle s;

    public /* synthetic */ b(DefaultHlsPlaylistTracker.MediaPlaylistBundle mediaPlaylistBundle, Uri uri) {
        this.s = mediaPlaylistBundle;
        this.X = uri;
    }

    public final void run() {
        this.s.l(this.X);
    }
}
