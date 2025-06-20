package androidx.media3.common;

import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.Size;
import com.google.common.base.Supplier;

public final /* synthetic */ class K0 implements Supplier {
    public final /* synthetic */ SimpleBasePlayer.State s;

    public /* synthetic */ K0(SimpleBasePlayer.State state) {
        this.s = state;
    }

    public final Object get() {
        return this.s.a().t0(Size.f9621d).O();
    }
}
