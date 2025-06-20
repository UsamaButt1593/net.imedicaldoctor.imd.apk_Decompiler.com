package kotlinx.coroutines.internal;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"", "", "a", "(I)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class LimitedDispatcherKt {
    public static final void a(int i2) {
        if (i2 < 1) {
            throw new IllegalArgumentException(("Expected positive parallelism level, but got " + i2).toString());
        }
    }
}
