package androidx.media3.common;

import androidx.media3.common.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class C0 implements Supplier {
    public final /* synthetic */ MediaMetadata X;
    public final /* synthetic */ SimpleBasePlayer.State s;

    public /* synthetic */ C0(SimpleBasePlayer.State state, MediaMetadata mediaMetadata) {
        this.s = state;
        this.X = mediaMetadata;
    }

    public final Object get() {
        return this.s.a().n0(this.X).O();
    }
}
