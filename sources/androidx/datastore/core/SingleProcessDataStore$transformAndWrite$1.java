package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", i = {0, 0, 0}, l = {402, 410}, m = "transformAndWrite", n = {"this", "curDataAndHash", "curData"}, s = {"L$0", "L$1", "L$2"})
final class SingleProcessDataStore$transformAndWrite$1 extends ContinuationImpl {
    Object X2;
    Object Y2;
    Object Z;
    /* synthetic */ Object Z2;
    final /* synthetic */ SingleProcessDataStore<T> a3;
    int b3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SingleProcessDataStore$transformAndWrite$1(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super SingleProcessDataStore$transformAndWrite$1> continuation) {
        super(continuation);
        this.a3 = singleProcessDataStore;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        this.Z2 = obj;
        this.b3 |= Integer.MIN_VALUE;
        return this.a3.z((Function2) null, (CoroutineContext) null, this);
    }
}
