package androidx.media3.exoplayer;

import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import com.google.common.base.Supplier;

/* renamed from: androidx.media3.exoplayer.y  reason: case insensitive filesystem */
public final /* synthetic */ class C0358y implements Supplier {
    public final /* synthetic */ BandwidthMeter s;

    public /* synthetic */ C0358y(BandwidthMeter bandwidthMeter) {
        this.s = bandwidthMeter;
    }

    public final Object get() {
        return ExoPlayer.Builder.Q(this.s);
    }
}
