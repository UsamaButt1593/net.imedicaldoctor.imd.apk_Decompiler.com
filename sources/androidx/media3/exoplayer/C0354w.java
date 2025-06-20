package androidx.media3.exoplayer;

import androidx.media3.exoplayer.ExoPlayer;
import com.google.common.base.Supplier;

/* renamed from: androidx.media3.exoplayer.w  reason: case insensitive filesystem */
public final /* synthetic */ class C0354w implements Supplier {
    public final /* synthetic */ RenderersFactory s;

    public /* synthetic */ C0354w(RenderersFactory renderersFactory) {
        this.s = renderersFactory;
    }

    public final Object get() {
        return ExoPlayer.Builder.N(this.s);
    }
}
