package androidx.media3.common;

import androidx.media3.common.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class L0 implements Supplier {
    public final /* synthetic */ SimpleBasePlayer.State X;
    public final /* synthetic */ int X2;
    public final /* synthetic */ int Y;
    public final /* synthetic */ int Z;
    public final /* synthetic */ SimpleBasePlayer s;

    public /* synthetic */ L0(SimpleBasePlayer simpleBasePlayer, SimpleBasePlayer.State state, int i2, int i3, int i4) {
        this.s = simpleBasePlayer;
        this.X = state;
        this.Y = i2;
        this.Z = i3;
        this.X2 = i4;
    }

    public final Object get() {
        return this.s.b5(this.X, this.Y, this.Z, this.X2);
    }
}
