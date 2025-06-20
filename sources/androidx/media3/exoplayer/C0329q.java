package androidx.media3.exoplayer;

import android.content.Context;
import androidx.media3.exoplayer.ExoPlayer;
import com.google.common.base.Supplier;

/* renamed from: androidx.media3.exoplayer.q  reason: case insensitive filesystem */
public final /* synthetic */ class C0329q implements Supplier {
    public final /* synthetic */ Context s;

    public /* synthetic */ C0329q(Context context) {
        this.s = context;
    }

    public final Object get() {
        return ExoPlayer.Builder.A(this.s);
    }
}
