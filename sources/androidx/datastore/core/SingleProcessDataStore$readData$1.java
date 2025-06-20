package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", i = {0}, l = {381}, m = "readData", n = {"this"}, s = {"L$0"})
final class SingleProcessDataStore$readData$1 extends ContinuationImpl {
    Object X2;
    Object Y2;
    Object Z;
    /* synthetic */ Object Z2;
    final /* synthetic */ SingleProcessDataStore<T> a3;
    int b3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SingleProcessDataStore$readData$1(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super SingleProcessDataStore$readData$1> continuation) {
        super(continuation);
        this.a3 = singleProcessDataStore;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        this.Z2 = obj;
        this.b3 |= Integer.MIN_VALUE;
        return this.a3.x(this);
    }
}
