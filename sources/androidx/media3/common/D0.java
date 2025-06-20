package androidx.media3.common;

import androidx.media3.common.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class D0 implements Supplier {
    public final /* synthetic */ int X;
    public final /* synthetic */ SimpleBasePlayer.State s;

    public /* synthetic */ D0(SimpleBasePlayer.State state, int i2) {
        this.s = state;
        this.X = i2;
    }

    public final Object get() {
        return this.s.a().p0(this.X).O();
    }
}
