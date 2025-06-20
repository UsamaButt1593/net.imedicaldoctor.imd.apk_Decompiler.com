package androidx.media3.common;

import androidx.media3.common.SimpleBasePlayer;
import com.google.common.base.Supplier;
import java.util.List;

/* renamed from: androidx.media3.common.x0  reason: case insensitive filesystem */
public final /* synthetic */ class C0187x0 implements Supplier {
    public final /* synthetic */ SimpleBasePlayer.State X;
    public final /* synthetic */ List Y;
    public final /* synthetic */ int Z;
    public final /* synthetic */ SimpleBasePlayer s;

    public /* synthetic */ C0187x0(SimpleBasePlayer simpleBasePlayer, SimpleBasePlayer.State state, List list, int i2) {
        this.s = simpleBasePlayer;
        this.X = state;
        this.Y = list;
        this.Z = i2;
    }

    public final Object get() {
        return this.s.U4(this.X, this.Y, this.Z);
    }
}
