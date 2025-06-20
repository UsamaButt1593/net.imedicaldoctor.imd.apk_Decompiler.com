package androidx.datastore.core;

import androidx.datastore.core.SingleProcessDataStore;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "msg", "Landroidx/datastore/core/SingleProcessDataStore$Message;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore$actor$3", f = "SingleProcessDataStore.kt", i = {}, l = {239, 242}, m = "invokeSuspend", n = {}, s = {})
final class SingleProcessDataStore$actor$3 extends SuspendLambda implements Function2<SingleProcessDataStore.Message<T>, Continuation<? super Unit>, Object> {
    int X2;
    /* synthetic */ Object Y2;
    final /* synthetic */ SingleProcessDataStore<T> Z2;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SingleProcessDataStore$actor$3(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super SingleProcessDataStore$actor$3> continuation) {
        super(2, continuation);
        this.Z2 = singleProcessDataStore;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        Object l2 = IntrinsicsKt.l();
        int i2 = this.X2;
        if (i2 == 0) {
            ResultKt.n(obj);
            SingleProcessDataStore.Message message = (SingleProcessDataStore.Message) this.Y2;
            if (message instanceof SingleProcessDataStore.Message.Read) {
                this.X2 = 1;
                if (this.Z2.s((SingleProcessDataStore.Message.Read) message, this) == l2) {
                    return l2;
                }
            } else if (message instanceof SingleProcessDataStore.Message.Update) {
                this.X2 = 2;
                if (this.Z2.t((SingleProcessDataStore.Message.Update) message, this) == l2) {
                    return l2;
                }
            }
        } else if (i2 == 1 || i2 == 2) {
            ResultKt.n(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f28779a;
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull SingleProcessDataStore.Message<T> message, @Nullable Continuation<? super Unit> continuation) {
        return ((SingleProcessDataStore$actor$3) v(message, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SingleProcessDataStore$actor$3 singleProcessDataStore$actor$3 = new SingleProcessDataStore$actor$3(this.Z2, continuation);
        singleProcessDataStore$actor$3.Y2 = obj;
        return singleProcessDataStore$actor$3;
    }
}
