package androidx.media3.common;

import android.view.SurfaceView;
import androidx.media3.common.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class I0 implements Supplier {
    public final /* synthetic */ SurfaceView X;
    public final /* synthetic */ SimpleBasePlayer.State s;

    public /* synthetic */ I0(SimpleBasePlayer.State state, SurfaceView surfaceView) {
        this.s = state;
        this.X = surfaceView;
    }

    public final Object get() {
        return this.s.a().t0(SimpleBasePlayer.t4(this.X.getHolder())).O();
    }
}
