package androidx.media3.common;

import androidx.media3.common.SimpleBasePlayer;
import com.google.common.base.Supplier;
import java.util.List;

/* renamed from: androidx.media3.common.q0  reason: case insensitive filesystem */
public final /* synthetic */ class C0168q0 implements Supplier {
    public final /* synthetic */ SimpleBasePlayer.State X;
    public final /* synthetic */ int X2;
    public final /* synthetic */ List Y;
    public final /* synthetic */ int Z;
    public final /* synthetic */ SimpleBasePlayer s;

    public /* synthetic */ C0168q0(SimpleBasePlayer simpleBasePlayer, SimpleBasePlayer.State state, List list, int i2, int i3) {
        this.s = simpleBasePlayer;
        this.X = state;
        this.Y = list;
        this.Z = i2;
        this.X2 = i3;
    }

    public final Object get() {
        return this.s.g5(this.X, this.Y, this.Z, this.X2);
    }
}
