package androidx.media3.exoplayer;

import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import com.google.common.base.Supplier;

/* renamed from: androidx.media3.exoplayer.z  reason: case insensitive filesystem */
public final /* synthetic */ class C0360z implements Supplier {
    public final /* synthetic */ TrackSelector s;

    public /* synthetic */ C0360z(TrackSelector trackSelector) {
        this.s = trackSelector;
    }

    public final Object get() {
        return ExoPlayer.Builder.B(this.s);
    }
}
