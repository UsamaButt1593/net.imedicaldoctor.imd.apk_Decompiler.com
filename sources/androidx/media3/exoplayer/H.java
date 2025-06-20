package androidx.media3.exoplayer;

import android.content.Context;
import androidx.media3.exoplayer.ExoPlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class H implements Supplier {
    public final /* synthetic */ Context s;

    public /* synthetic */ H(Context context) {
        this.s = context;
    }

    public final Object get() {
        return ExoPlayer.Builder.J(this.s);
    }
}
