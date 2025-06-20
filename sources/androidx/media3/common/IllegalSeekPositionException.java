package androidx.media3.common;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
public final class IllegalSeekPositionException extends IllegalStateException {
    public final int X;
    public final long Y;
    public final Timeline s;

    public IllegalSeekPositionException(Timeline timeline, int i2, long j2) {
        this.s = timeline;
        this.X = i2;
        this.Y = j2;
    }
}
