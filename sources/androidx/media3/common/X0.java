package androidx.media3.common;

import androidx.media3.common.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class X0 implements Supplier {
    public final /* synthetic */ TrackSelectionParameters X;
    public final /* synthetic */ SimpleBasePlayer.State s;

    public /* synthetic */ X0(SimpleBasePlayer.State state, TrackSelectionParameters trackSelectionParameters) {
        this.s = state;
        this.X = trackSelectionParameters;
    }

    public final Object get() {
        return this.s.a().w0(this.X).O();
    }
}
