package androidx.media3.exoplayer.mediacodec;

import androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecAdapter;
import com.google.common.base.Supplier;

public final /* synthetic */ class e implements Supplier {
    public final /* synthetic */ int s;

    public /* synthetic */ e(int i2) {
        this.s = i2;
    }

    public final Object get() {
        return AsynchronousMediaCodecAdapter.Factory.f(this.s);
    }
}
