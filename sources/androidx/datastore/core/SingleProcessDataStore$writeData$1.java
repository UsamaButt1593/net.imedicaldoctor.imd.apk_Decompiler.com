package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", i = {0, 0, 0}, l = {426}, m = "writeData$datastore_core", n = {"this", "scratchFile", "stream"}, s = {"L$0", "L$1", "L$4"})
final class SingleProcessDataStore$writeData$1 extends ContinuationImpl {
    Object X2;
    Object Y2;
    Object Z;
    Object Z2;
    Object a3;
    /* synthetic */ Object b3;
    final /* synthetic */ SingleProcessDataStore<T> c3;
    int d3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SingleProcessDataStore$writeData$1(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super SingleProcessDataStore$writeData$1> continuation) {
        super(continuation);
        this.c3 = singleProcessDataStore;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        this.b3 = obj;
        this.d3 |= Integer.MIN_VALUE;
        return this.c3.A(null, this);
    }
}
