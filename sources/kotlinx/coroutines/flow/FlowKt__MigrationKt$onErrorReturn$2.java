package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "e", ""}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$onErrorReturn$2", f = "Migration.kt", i = {}, l = {306}, m = "invokeSuspend", n = {}, s = {})
final class FlowKt__MigrationKt$onErrorReturn$2 extends SuspendLambda implements Function3<FlowCollector<? super T>, Throwable, Continuation<? super Unit>, Object> {
    int X2;
    private /* synthetic */ Object Y2;
    /* synthetic */ Object Z2;
    final /* synthetic */ Function1<Throwable, Boolean> a3;
    final /* synthetic */ T b3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__MigrationKt$onErrorReturn$2(Function1<? super Throwable, Boolean> function1, T t, Continuation<? super FlowKt__MigrationKt$onErrorReturn$2> continuation) {
        super(3, continuation);
        this.a3 = function1;
        this.b3 = t;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        Object l2 = IntrinsicsKt.l();
        int i2 = this.X2;
        if (i2 == 0) {
            ResultKt.n(obj);
            FlowCollector flowCollector = (FlowCollector) this.Y2;
            Throwable th = (Throwable) this.Z2;
            if (this.a3.f(th).booleanValue()) {
                T t = this.b3;
                this.Y2 = null;
                this.X2 = 1;
                if (flowCollector.h(t, this) == l2) {
                    return l2;
                }
            } else {
                throw th;
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
    public final Object A(@NotNull FlowCollector<? super T> flowCollector, @NotNull Throwable th, @Nullable Continuation<? super Unit> continuation) {
        FlowKt__MigrationKt$onErrorReturn$2 flowKt__MigrationKt$onErrorReturn$2 = new FlowKt__MigrationKt$onErrorReturn$2(this.a3, this.b3, continuation);
        flowKt__MigrationKt$onErrorReturn$2.Y2 = flowCollector;
        flowKt__MigrationKt$onErrorReturn$2.Z2 = th;
        return flowKt__MigrationKt$onErrorReturn$2.D(Unit.f28779a);
    }
}
