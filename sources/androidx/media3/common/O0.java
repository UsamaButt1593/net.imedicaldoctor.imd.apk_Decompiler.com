package androidx.media3.common;

import androidx.media3.common.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class O0 implements Supplier {
    public final /* synthetic */ int X;
    public final /* synthetic */ long Y;
    public final /* synthetic */ SimpleBasePlayer.State s;

    public /* synthetic */ O0(SimpleBasePlayer.State state, int i2, long j2) {
        this.s = state;
        this.X = i2;
        this.Y = j2;
    }

    public final Object get() {
        return SimpleBasePlayer.s4(this.s, this.s.y, this.X, this.Y);
    }
}
