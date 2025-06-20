package androidx.media3.common;

import androidx.media3.common.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class E0 implements Supplier {
    public final /* synthetic */ float X;
    public final /* synthetic */ SimpleBasePlayer.State s;

    public /* synthetic */ E0(SimpleBasePlayer.State state, float f2) {
        this.s = state;
        this.X = f2;
    }

    public final Object get() {
        return this.s.a().y0(this.X).O();
    }
}
