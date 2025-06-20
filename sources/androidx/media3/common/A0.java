package androidx.media3.common;

import androidx.media3.common.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class A0 implements Supplier {
    public final /* synthetic */ SimpleBasePlayer.State s;

    public /* synthetic */ A0(SimpleBasePlayer.State state) {
        this.s = state;
    }

    public final Object get() {
        return this.s.a().c0(Math.max(0, this.s.t - 1)).O();
    }
}
