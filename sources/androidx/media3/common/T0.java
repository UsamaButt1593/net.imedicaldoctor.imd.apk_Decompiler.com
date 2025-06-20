package androidx.media3.common;

import androidx.media3.common.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class T0 implements Supplier {
    public final /* synthetic */ SimpleBasePlayer.State s;

    public /* synthetic */ T0(SimpleBasePlayer.State state) {
        this.s = state;
    }

    public final Object get() {
        return SimpleBasePlayer.d5(this.s);
    }
}
