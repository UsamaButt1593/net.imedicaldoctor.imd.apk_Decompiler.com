package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1", f = "Share.kt", i = {}, l = {340}, m = "invokeSuspend", n = {}, s = {})
final class FlowKt__ShareKt$launchSharingDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int X2;
    private /* synthetic */ Object Y2;
    final /* synthetic */ Flow<T> Z2;
    final /* synthetic */ CompletableDeferred<StateFlow<T>> a3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__ShareKt$launchSharingDeferred$1(Flow<? extends T> flow, CompletableDeferred<StateFlow<T>> completableDeferred, Continuation<? super FlowKt__ShareKt$launchSharingDeferred$1> continuation) {
        super(2, continuation);
        this.Z2 = flow;
        this.a3 = completableDeferred;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        Object l2 = IntrinsicsKt.l();
        int i2 = this.X2;
        if (i2 == 0) {
            ResultKt.n(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.Y2;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Flow<T> flow = this.Z2;
            final CompletableDeferred<StateFlow<T>> completableDeferred = this.a3;
            AnonymousClass1 r4 = new FlowCollector() {
                @Nullable
                public final Object h(T t, @NotNull Continuation<? super Unit> continuation) {
                    Unit unit;
                    MutableStateFlow mutableStateFlow = (MutableStateFlow) objectRef.s;
                    if (mutableStateFlow != null) {
                        mutableStateFlow.setValue(t);
                        unit = Unit.f28779a;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        CoroutineScope coroutineScope = coroutineScope;
                        Ref.ObjectRef<MutableStateFlow<T>> objectRef = objectRef;
                        CompletableDeferred<StateFlow<T>> completableDeferred = completableDeferred;
                        T a2 = StateFlowKt.a(t);
                        completableDeferred.e0(new ReadonlyStateFlow(a2, JobKt.B(coroutineScope.U())));
                        objectRef.s = a2;
                    }
                    return Unit.f28779a;
                }
            };
            this.X2 = 1;
            if (flow.a(r4, this) == l2) {
                return l2;
            }
        } else if (i2 == 1) {
            try {
                ResultKt.n(obj);
            } catch (Throwable th) {
                this.a3.k(th);
                throw th;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f28779a;
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FlowKt__ShareKt$launchSharingDeferred$1) v(coroutineScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__ShareKt$launchSharingDeferred$1 flowKt__ShareKt$launchSharingDeferred$1 = new FlowKt__ShareKt$launchSharingDeferred$1(this.Z2, this.a3, continuation);
        flowKt__ShareKt$launchSharingDeferred$1.Y2 = obj;
        return flowKt__ShareKt$launchSharingDeferred$1;
    }
}
