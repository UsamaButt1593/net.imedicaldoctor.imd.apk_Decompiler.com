package androidx.media3.common;

import androidx.media3.common.SimpleBasePlayer;
import com.google.common.base.Supplier;
import java.util.List;

/* renamed from: androidx.media3.common.r0  reason: case insensitive filesystem */
public final /* synthetic */ class C0170r0 implements Supplier {
    public final /* synthetic */ List X;
    public final /* synthetic */ long X2;
    public final /* synthetic */ SimpleBasePlayer.State Y;
    public final /* synthetic */ int Z;
    public final /* synthetic */ SimpleBasePlayer s;

    public /* synthetic */ C0170r0(SimpleBasePlayer simpleBasePlayer, List list, SimpleBasePlayer.State state, int i2, long j2) {
        this.s = simpleBasePlayer;
        this.X = list;
        this.Y = state;
        this.Z = i2;
        this.X2 = j2;
    }

    public final Object get() {
        return this.s.n5(this.X, this.Y, this.Z, this.X2);
    }
}
