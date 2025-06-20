package androidx.media3.exoplayer;

import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import com.google.common.base.Supplier;

public final /* synthetic */ class J implements Supplier {
    public final /* synthetic */ TrackSelector s;

    public /* synthetic */ J(TrackSelector trackSelector) {
        this.s = trackSelector;
    }

    public final Object get() {
        return ExoPlayer.Builder.U(this.s);
    }
}
