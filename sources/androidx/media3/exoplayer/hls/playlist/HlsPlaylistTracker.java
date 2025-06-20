package androidx.media3.exoplayer.hls.playlist;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.hls.HlsDataSourceFactory;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import java.io.IOException;

@UnstableApi
public interface HlsPlaylistTracker {

    public interface Factory {
        HlsPlaylistTracker a(HlsDataSourceFactory hlsDataSourceFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistParserFactory hlsPlaylistParserFactory);
    }

    public interface PlaylistEventListener {
        void b();

        boolean d(Uri uri, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, boolean z);
    }

    public static final class PlaylistResetException extends IOException {
        public final Uri s;

        public PlaylistResetException(Uri uri) {
            this.s = uri;
        }
    }

    public static final class PlaylistStuckException extends IOException {
        public final Uri s;

        public PlaylistStuckException(Uri uri) {
            this.s = uri;
        }
    }

    public interface PrimaryPlaylistListener {
        void s(HlsMediaPlaylist hlsMediaPlaylist);
    }

    void a(Uri uri, MediaSourceEventListener.EventDispatcher eventDispatcher, PrimaryPlaylistListener primaryPlaylistListener);

    boolean b(Uri uri);

    void c(Uri uri) throws IOException;

    void d(PlaylistEventListener playlistEventListener);

    void e(PlaylistEventListener playlistEventListener);

    long f();

    boolean g();

    @Nullable
    HlsMultivariantPlaylist h();

    boolean i(Uri uri, long j2);

    void j() throws IOException;

    void k(Uri uri);

    @Nullable
    HlsMediaPlaylist l(Uri uri, boolean z);

    void stop();
}
