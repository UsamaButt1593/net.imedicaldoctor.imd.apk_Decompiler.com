package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.kt", i = {0}, l = {203}, m = "invokeSuspend", n = {"controller"}, s = {"L$0"})
final class PausingDispatcherKt$whenStateAtLeast$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    int X2;
    private /* synthetic */ Object Y2;
    final /* synthetic */ Lifecycle Z2;
    final /* synthetic */ Lifecycle.State a3;
    final /* synthetic */ Function2<CoroutineScope, Continuation<? super T>, Object> b3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PausingDispatcherKt$whenStateAtLeast$2(Lifecycle lifecycle, Lifecycle.State state, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super PausingDispatcherKt$whenStateAtLeast$2> continuation) {
        super(2, continuation);
        this.Z2 = lifecycle;
        this.a3 = state;
        this.b3 = function2;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        LifecycleController lifecycleController;
        Object l2 = IntrinsicsKt.l();
        int i2 = this.X2;
        if (i2 == 0) {
            ResultKt.n(obj);
            Job job = (Job) ((CoroutineScope) this.Y2).U().e(Job.P2);
            if (job != null) {
                PausingDispatcher pausingDispatcher = new PausingDispatcher();
                LifecycleController lifecycleController2 = new LifecycleController(this.Z2, this.a3, pausingDispatcher.Y, job);
                try {
                    Function2<CoroutineScope, Continuation<? super T>, Object> function2 = this.b3;
                    this.Y2 = lifecycleController2;
                    this.X2 = 1;
                    obj = BuildersKt.h(pausingDispatcher, function2, this);
                    if (obj == l2) {
                        return l2;
                    }
                    lifecycleController = lifecycleController2;
                } catch (Throwable th) {
                    th = th;
                    lifecycleController = lifecycleController2;
                    lifecycleController.b();
                    throw th;
                }
            } else {
                throw new IllegalStateException("when[State] methods should have a parent job".toString());
            }
        } else if (i2 == 1) {
            lifecycleController = (LifecycleController) this.Y2;
            try {
                ResultKt.n(obj);
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        lifecycleController.b();
        return obj;
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super T> continuation) {
        return ((PausingDispatcherKt$whenStateAtLeast$2) v(coroutineScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        PausingDispatcherKt$whenStateAtLeast$2 pausingDispatcherKt$whenStateAtLeast$2 = new PausingDispatcherKt$whenStateAtLeast$2(this.Z2, this.a3, this.b3, continuation);
        pausingDispatcherKt$whenStateAtLeast$2.Y2 = obj;
        return pausingDispatcherKt$whenStateAtLeast$2;
    }
}
