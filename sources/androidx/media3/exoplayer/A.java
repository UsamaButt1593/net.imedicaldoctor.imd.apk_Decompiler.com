package androidx.media3.exoplayer;

import androidx.media3.exoplayer.ExoPlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class A implements Supplier {
    public final /* synthetic */ LoadControl s;

    public /* synthetic */ A(LoadControl loadControl) {
        this.s = loadControl;
    }

    public final Object get() {
        return ExoPlayer.Builder.C(this.s);
    }
}
