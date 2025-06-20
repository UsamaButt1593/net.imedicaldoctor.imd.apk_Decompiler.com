package androidx.media3.exoplayer.source;

import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public final class TimelineWithUpdatedMediaItem extends ForwardingTimeline {
    private final MediaItem Z2;

    public TimelineWithUpdatedMediaItem(Timeline timeline, MediaItem mediaItem) {
        super(timeline);
        this.Z2 = mediaItem;
    }

    public Timeline.Window v(int i2, Timeline.Window window, long j2) {
        super.v(i2, window, j2);
        MediaItem mediaItem = this.Z2;
        window.Y = mediaItem;
        MediaItem.LocalConfiguration localConfiguration = mediaItem.X;
        window.X = localConfiguration != null ? localConfiguration.b3 : null;
        return window;
    }
}
