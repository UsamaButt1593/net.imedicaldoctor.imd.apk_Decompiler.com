package androidx.media3.common;

import androidx.media3.common.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class N0 implements Supplier {
    public final /* synthetic */ AudioAttributes X;
    public final /* synthetic */ SimpleBasePlayer.State s;

    public /* synthetic */ N0(SimpleBasePlayer.State state, AudioAttributes audioAttributes) {
        this.s = state;
        this.X = audioAttributes;
    }

    public final Object get() {
        return this.s.a().T(this.X).O();
    }
}
