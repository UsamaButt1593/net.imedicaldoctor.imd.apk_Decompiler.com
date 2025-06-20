package androidx.media3.exoplayer;

import androidx.media3.exoplayer.ExoPlayer;
import com.google.common.base.Supplier;

/* renamed from: androidx.media3.exoplayer.u  reason: case insensitive filesystem */
public final /* synthetic */ class C0350u implements Supplier {
    public final /* synthetic */ RenderersFactory s;

    public /* synthetic */ C0350u(RenderersFactory renderersFactory) {
        this.s = renderersFactory;
    }

    public final Object get() {
        return ExoPlayer.Builder.H(this.s);
    }
}
