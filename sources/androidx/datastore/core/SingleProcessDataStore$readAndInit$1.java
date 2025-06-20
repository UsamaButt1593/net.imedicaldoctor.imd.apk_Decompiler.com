package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", i = {0, 0, 1, 1, 1, 2}, l = {322, 348, 505}, m = "readAndInit", n = {"updateLock", "initData", "updateLock", "initData", "initializationComplete", "$this$withLock_u24default$iv"}, s = {"L$1", "L$2", "L$1", "L$2", "L$3", "L$3"})
final class SingleProcessDataStore$readAndInit$1 extends ContinuationImpl {
    Object X2;
    Object Y2;
    Object Z;
    Object Z2;
    Object a3;
    Object b3;
    /* synthetic */ Object c3;
    final /* synthetic */ SingleProcessDataStore<T> d3;
    int e3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SingleProcessDataStore$readAndInit$1(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super SingleProcessDataStore$readAndInit$1> continuation) {
        super(continuation);
        this.d3 = singleProcessDataStore;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        this.c3 = obj;
        this.e3 |= Integer.MIN_VALUE;
        return this.d3.u(this);
    }
}
