package androidx.media3.exoplayer;

import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import com.google.common.base.Supplier;

public final /* synthetic */ class B implements Supplier {
    public final /* synthetic */ BandwidthMeter s;

    public /* synthetic */ B(BandwidthMeter bandwidthMeter) {
        this.s = bandwidthMeter;
    }

    public final Object get() {
        return ExoPlayer.Builder.D(this.s);
    }
}
