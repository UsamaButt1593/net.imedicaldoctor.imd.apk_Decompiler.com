package androidx.datastore.core;

import androidx.datastore.core.SingleProcessDataStore;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", i = {1, 1}, l = {276, 281, 284}, m = "handleUpdate", n = {"update", "$this$handleUpdate_u24lambda_u2d0"}, s = {"L$0", "L$1"})
final class SingleProcessDataStore$handleUpdate$1 extends ContinuationImpl {
    Object X2;
    Object Y2;
    Object Z;
    /* synthetic */ Object Z2;
    final /* synthetic */ SingleProcessDataStore<T> a3;
    int b3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SingleProcessDataStore$handleUpdate$1(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super SingleProcessDataStore$handleUpdate$1> continuation) {
        super(continuation);
        this.a3 = singleProcessDataStore;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        this.Z2 = obj;
        this.b3 |= Integer.MIN_VALUE;
        return this.a3.t((SingleProcessDataStore.Message.Update) null, this);
    }
}
