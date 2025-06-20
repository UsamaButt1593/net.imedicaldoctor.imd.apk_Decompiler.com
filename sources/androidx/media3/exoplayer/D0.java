package androidx.media3.exoplayer;

import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class D0 implements Supplier {
    public final /* synthetic */ AtomicBoolean s;

    public /* synthetic */ D0(AtomicBoolean atomicBoolean) {
        this.s = atomicBoolean;
    }

    public final Object get() {
        return Boolean.valueOf(this.s.get());
    }
}
