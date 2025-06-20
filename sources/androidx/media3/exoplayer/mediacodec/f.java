package androidx.media3.exoplayer.mediacodec;

import androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecAdapter;
import com.google.common.base.Supplier;

public final /* synthetic */ class f implements Supplier {
    public final /* synthetic */ int s;

    public /* synthetic */ f(int i2) {
        this.s = i2;
    }

    public final Object get() {
        return AsynchronousMediaCodecAdapter.Factory.g(this.s);
    }
}
