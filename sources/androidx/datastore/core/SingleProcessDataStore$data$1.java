package androidx.datastore.core;

import androidx.datastore.core.SingleProcessDataStore;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore$data$1", f = "SingleProcessDataStore.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
final class SingleProcessDataStore$data$1 extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    int X2;
    private /* synthetic */ Object Y2;
    final /* synthetic */ SingleProcessDataStore<T> Z2;

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "it", "Landroidx/datastore/core/State;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore$data$1$1", f = "SingleProcessDataStore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.datastore.core.SingleProcessDataStore$data$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<State<T>, Continuation<? super Boolean>, Object> {
        int X2;
        /* synthetic */ Object Y2;

        @Nullable
        public final Object D(@NotNull Object obj) {
            IntrinsicsKt.l();
            if (this.X2 == 0) {
                ResultKt.n(obj);
                State<T> state = (State) this.Y2;
                State<T> state2 = state;
                boolean z = false;
                if (!(state2 instanceof Data) && !(state2 instanceof Final) && state == state2) {
                    z = true;
                }
                return Boxing.a(z);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        /* renamed from: U */
        public final Object d0(@NotNull State<T> state, @Nullable Continuation<? super Boolean> continuation) {
            return ((AnonymousClass1) v(state, continuation)).D(Unit.f28779a);
        }

        @NotNull
        public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(state, continuation);
            r0.Y2 = obj;
            return r0;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SingleProcessDataStore$data$1(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super SingleProcessDataStore$data$1> continuation) {
        super(2, continuation);
        this.Z2 = singleProcessDataStore;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        Object l2 = IntrinsicsKt.l();
        int i2 = this.X2;
        if (i2 == 0) {
            ResultKt.n(obj);
            FlowCollector flowCollector = (FlowCollector) this.Y2;
            final State state = (State) this.Z2.f6921h.getValue();
            if (!(state instanceof Data)) {
                this.Z2.f6923j.e(new SingleProcessDataStore.Message.Read(state));
            }
            SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1 singleProcessDataStore$data$1$invokeSuspend$$inlined$map$1 = new SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1(FlowKt.k0(this.Z2.f6921h, new AnonymousClass1((Continuation<? super AnonymousClass1>) null)));
            this.X2 = 1;
            if (FlowKt.m0(flowCollector, singleProcessDataStore$data$1$invokeSuspend$$inlined$map$1, this) == l2) {
                return l2;
            }
        } else if (i2 == 1) {
            ResultKt.n(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f28779a;
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull FlowCollector<? super T> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((SingleProcessDataStore$data$1) v(flowCollector, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SingleProcessDataStore$data$1 singleProcessDataStore$data$1 = new SingleProcessDataStore$data$1(this.Z2, continuation);
        singleProcessDataStore$data$1.Y2 = obj;
        return singleProcessDataStore$data$1;
    }
}
