package androidx.media3.common;

import androidx.media3.common.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class M0 implements Supplier {
    public final /* synthetic */ SimpleBasePlayer.State s;

    public /* synthetic */ M0(SimpleBasePlayer.State state) {
        this.s = state;
    }

    public final Object get() {
        return this.s.a().c0(this.s.t + 1).O();
    }
}
