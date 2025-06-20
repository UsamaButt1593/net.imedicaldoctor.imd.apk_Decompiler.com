package kotlinx.coroutines.flow;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\t2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u0004J\r\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "Lkotlinx/coroutines/flow/StateFlowImpl;", "<init>", "()V", "flow", "", "c", "(Lkotlinx/coroutines/flow/StateFlowImpl;)Z", "", "Lkotlin/coroutines/Continuation;", "", "e", "(Lkotlinx/coroutines/flow/StateFlowImpl;)[Lkotlin/coroutines/Continuation;", "f", "g", "()Z", "d", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class StateFlowSlot extends AbstractSharedFlowSlot<StateFlowImpl<?>> {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f29321a = AtomicReferenceFieldUpdater.newUpdater(StateFlowSlot.class, Object.class, "_state");
    @NotNull
    volatile /* synthetic */ Object _state = null;

    /* renamed from: c */
    public boolean a(@NotNull StateFlowImpl<?> stateFlowImpl) {
        if (this._state != null) {
            return false;
        }
        this._state = StateFlowKt.f29319a;
        return true;
    }

    @Nullable
    public final Object d(@NotNull Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.e(continuation), 1);
        cancellableContinuationImpl.W();
        if (!a.a(f29321a, this, StateFlowKt.f29319a, cancellableContinuationImpl)) {
            Result.Companion companion = Result.X;
            cancellableContinuationImpl.w(Result.b(Unit.f28779a));
        }
        Object y = cancellableContinuationImpl.y();
        if (y == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        return y == IntrinsicsKt.l() ? y : Unit.f28779a;
    }

    @NotNull
    /* renamed from: e */
    public Continuation<Unit>[] b(@NotNull StateFlowImpl<?> stateFlowImpl) {
        this._state = null;
        return AbstractSharedFlowKt.f29322a;
    }

    public final void f() {
        while (true) {
            Object obj = this._state;
            if (obj != null && obj != StateFlowKt.f29320b) {
                if (obj == StateFlowKt.f29319a) {
                    if (a.a(f29321a, this, obj, StateFlowKt.f29320b)) {
                        return;
                    }
                } else if (a.a(f29321a, this, obj, StateFlowKt.f29319a)) {
                    Result.Companion companion = Result.X;
                    ((CancellableContinuationImpl) obj).w(Result.b(Unit.f28779a));
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final boolean g() {
        Object andSet = f29321a.getAndSet(this, StateFlowKt.f29319a);
        Intrinsics.m(andSet);
        return andSet == StateFlowKt.f29320b;
    }
}
