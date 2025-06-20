package androidx.media3.common;

import androidx.media3.common.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class G0 implements Supplier {
    public final /* synthetic */ SimpleBasePlayer.State s;

    public /* synthetic */ G0(SimpleBasePlayer.State state) {
        this.s = state;
    }

    public final Object get() {
        return SimpleBasePlayer.e5(this.s);
    }
}
