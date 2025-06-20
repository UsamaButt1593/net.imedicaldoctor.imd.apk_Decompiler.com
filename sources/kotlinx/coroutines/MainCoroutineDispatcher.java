package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LimitedDispatcherKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0005¢\u0006\u0004\b\u000b\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "parallelism", "W", "(I)Lkotlinx/coroutines/CoroutineDispatcher;", "q0", "i0", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "immediate", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class MainCoroutineDispatcher extends CoroutineDispatcher {
    @NotNull
    public CoroutineDispatcher W(int i2) {
        LimitedDispatcherKt.a(i2);
        return this;
    }

    @NotNull
    public abstract MainCoroutineDispatcher i0();

    /* access modifiers changed from: protected */
    @Nullable
    @InternalCoroutinesApi
    public final String q0() {
        MainCoroutineDispatcher mainCoroutineDispatcher;
        MainCoroutineDispatcher e2 = Dispatchers.e();
        if (this == e2) {
            return "Dispatchers.Main";
        }
        try {
            mainCoroutineDispatcher = e2.i0();
        } catch (UnsupportedOperationException unused) {
            mainCoroutineDispatcher = null;
        }
        if (this == mainCoroutineDispatcher) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @NotNull
    public String toString() {
        String q0 = q0();
        if (q0 != null) {
            return q0;
        }
        return DebugStringsKt.a(this) + '@' + DebugStringsKt.b(this);
    }
}
