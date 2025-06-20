package androidx.media3.exoplayer;

import android.content.Context;
import androidx.media3.exoplayer.upstream.DefaultBandwidthMeter;
import com.google.common.base.Supplier;

public final /* synthetic */ class F implements Supplier {
    public final /* synthetic */ Context s;

    public /* synthetic */ F(Context context) {
        this.s = context;
    }

    public final Object get() {
        return DefaultBandwidthMeter.n(this.s);
    }
}
