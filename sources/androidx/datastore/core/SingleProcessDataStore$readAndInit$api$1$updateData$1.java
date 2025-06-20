package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1", f = "SingleProcessDataStore.kt", i = {0, 0, 1, 2, 2}, l = {503, 337, 339}, m = "updateData", n = {"transform", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "newData"}, s = {"L$0", "L$1", "L$0", "L$0", "L$2"})
final class SingleProcessDataStore$readAndInit$api$1$updateData$1 extends ContinuationImpl {
    Object X2;
    Object Y2;
    Object Z;
    Object Z2;
    Object a3;
    /* synthetic */ Object b3;
    final /* synthetic */ SingleProcessDataStore$readAndInit$api$1 c3;
    int d3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SingleProcessDataStore$readAndInit$api$1$updateData$1(SingleProcessDataStore$readAndInit$api$1 singleProcessDataStore$readAndInit$api$1, Continuation<? super SingleProcessDataStore$readAndInit$api$1$updateData$1> continuation) {
        super(continuation);
        this.c3 = singleProcessDataStore$readAndInit$api$1;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        this.b3 = obj;
        this.d3 |= Integer.MIN_VALUE;
        return this.c3.a((Function2) null, this);
    }
}
