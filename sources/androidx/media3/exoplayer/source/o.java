package androidx.media3.exoplayer.source;

import androidx.annotation.Nullable;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaSource;

public final /* synthetic */ class o {
    @UnstableApi
    public static boolean a(MediaSource mediaSource, MediaItem mediaItem) {
        return false;
    }

    @UnstableApi
    @Nullable
    public static Timeline b(MediaSource mediaSource) {
        return null;
    }

    @UnstableApi
    public static boolean c(MediaSource mediaSource) {
        return true;
    }

    @UnstableApi
    @Deprecated
    public static void d(MediaSource mediaSource, MediaSource.MediaSourceCaller mediaSourceCaller, @Nullable TransferListener transferListener) {
        mediaSource.Y(mediaSourceCaller, transferListener, PlayerId.f10613b);
    }

    @UnstableApi
    public static void e(MediaSource mediaSource, MediaItem mediaItem) {
    }
}
