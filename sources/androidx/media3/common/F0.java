package androidx.media3.common;

import android.view.SurfaceHolder;
import androidx.media3.common.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class F0 implements Supplier {
    public final /* synthetic */ SurfaceHolder X;
    public final /* synthetic */ SimpleBasePlayer.State s;

    public /* synthetic */ F0(SimpleBasePlayer.State state, SurfaceHolder surfaceHolder) {
        this.s = state;
        this.X = surfaceHolder;
    }

    public final Object get() {
        return this.s.a().t0(SimpleBasePlayer.t4(this.X)).O();
    }
}
