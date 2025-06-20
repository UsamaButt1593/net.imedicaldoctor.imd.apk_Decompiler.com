package androidx.media3.exoplayer;

import androidx.media3.exoplayer.ExoPlayer;
import com.google.common.base.Supplier;

/* renamed from: androidx.media3.exoplayer.n  reason: case insensitive filesystem */
public final /* synthetic */ class C0323n implements Supplier {
    public final /* synthetic */ LoadControl s;

    public /* synthetic */ C0323n(LoadControl loadControl) {
        this.s = loadControl;
    }

    public final Object get() {
        return ExoPlayer.Builder.R(this.s);
    }
}
