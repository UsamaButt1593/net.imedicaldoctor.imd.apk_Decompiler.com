package androidx.media3.common;

import androidx.media3.common.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class R0 implements Supplier {
    public final /* synthetic */ SimpleBasePlayer.State s;

    public /* synthetic */ R0(SimpleBasePlayer.State state) {
        this.s = state;
    }

    public final Object get() {
        return this.s.a().j0(1).v0(SimpleBasePlayer.PositionSupplier.f9306a).V(e1.a(SimpleBasePlayer.b4(this.s))).Q(this.s.F).e0(false).O();
    }
}
