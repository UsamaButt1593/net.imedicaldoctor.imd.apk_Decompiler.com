package androidx.media3.exoplayer;

import androidx.media3.exoplayer.ExoPlayer;
import com.google.common.base.Supplier;

/* renamed from: androidx.media3.exoplayer.r  reason: case insensitive filesystem */
public final /* synthetic */ class C0331r implements Supplier {
    public final /* synthetic */ RenderersFactory s;

    public /* synthetic */ C0331r(RenderersFactory renderersFactory) {
        this.s = renderersFactory;
    }

    public final Object get() {
        return ExoPlayer.Builder.T(this.s);
    }
}
