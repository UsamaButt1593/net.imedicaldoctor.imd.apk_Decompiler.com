package androidx.media3.exoplayer;

import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.source.MediaSource;
import com.google.common.base.Supplier;

public final /* synthetic */ class K implements Supplier {
    public final /* synthetic */ MediaSource.Factory s;

    public /* synthetic */ K(MediaSource.Factory factory) {
        this.s = factory;
    }

    public final Object get() {
        return ExoPlayer.Builder.S(this.s);
    }
}
