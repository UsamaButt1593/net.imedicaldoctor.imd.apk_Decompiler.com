package androidx.media3.common;

import androidx.media3.common.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class O implements Supplier {
    public final /* synthetic */ boolean X;
    public final /* synthetic */ SimpleBasePlayer.State s;

    public /* synthetic */ O(SimpleBasePlayer.State state, boolean z) {
        this.s = state;
        this.X = z;
    }

    public final Object get() {
        return this.s.a().h0(this.X, 1).O();
    }
}
