package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\r\u000eB\u001d\u0012\u0014\u0010\u0005\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0005\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/AwaitAll;", "T", "", "", "Lkotlinx/coroutines/Deferred;", "deferreds", "<init>", "([Lkotlinx/coroutines/Deferred;)V", "", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "[Lkotlinx/coroutines/Deferred;", "AwaitAllNode", "DisposeHandlersOnCancel", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class AwaitAll<T> {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ AtomicIntegerFieldUpdater f29148b = AtomicIntegerFieldUpdater.newUpdater(AwaitAll.class, "notCompletedCount");
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final Deferred<T>[] f29149a;
    @NotNull
    volatile /* synthetic */ int notCompletedCount;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R<\u0010\u001d\u001a\u000e\u0018\u00010\u0016R\b\u0012\u0004\u0012\u00028\u00000\u00172\u0012\u0010\u0018\u001a\u000e\u0018\u00010\u0016R\b\u0012\u0004\u0012\u00028\u00000\u00178F@FX\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/CancellableContinuation;", "", "continuation", "<init>", "(Lkotlinx/coroutines/AwaitAll;Lkotlinx/coroutines/CancellableContinuation;)V", "", "cause", "", "X0", "(Ljava/lang/Throwable;)V", "X2", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlinx/coroutines/DisposableHandle;", "Y2", "Lkotlinx/coroutines/DisposableHandle;", "b1", "()Lkotlinx/coroutines/DisposableHandle;", "d1", "(Lkotlinx/coroutines/DisposableHandle;)V", "handle", "Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/AwaitAll;", "value", "a1", "()Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "c1", "(Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;)V", "disposer", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private final class AwaitAllNode extends JobNode {
        @NotNull
        private final CancellableContinuation<List<? extends T>> X2;
        public DisposableHandle Y2;
        @NotNull
        private volatile /* synthetic */ Object _disposer = null;

        public AwaitAllNode(@NotNull CancellableContinuation<? super List<? extends T>> cancellableContinuation) {
            this.X2 = cancellableContinuation;
        }

        public void X0(@Nullable Throwable th) {
            if (th != null) {
                Object N = this.X2.N(th);
                if (N != null) {
                    this.X2.u0(N);
                    AwaitAll<T>.DisposeHandlersOnCancel a1 = a1();
                    if (a1 != null) {
                        a1.d();
                        return;
                    }
                    return;
                }
                return;
            }
            if (AwaitAll.f29148b.decrementAndGet(AwaitAll.this) == 0) {
                CancellableContinuation<List<? extends T>> cancellableContinuation = this.X2;
                Deferred[] a2 = AwaitAll.this.f29149a;
                ArrayList arrayList = new ArrayList(a2.length);
                for (Deferred s : a2) {
                    arrayList.add(s.s());
                }
                Result.Companion companion = Result.X;
                cancellableContinuation.w(Result.b(arrayList));
            }
        }

        @Nullable
        public final AwaitAll<T>.DisposeHandlersOnCancel a1() {
            return (DisposeHandlersOnCancel) this._disposer;
        }

        @NotNull
        public final DisposableHandle b1() {
            DisposableHandle disposableHandle = this.Y2;
            if (disposableHandle != null) {
                return disposableHandle;
            }
            Intrinsics.S("handle");
            return null;
        }

        public final void c1(@Nullable AwaitAll<T>.DisposeHandlersOnCancel disposeHandlersOnCancel) {
            this._disposer = disposeHandlersOnCancel;
        }

        public final void d1(@NotNull DisposableHandle disposableHandle) {
            this.Y2 = disposableHandle;
        }

        public /* bridge */ /* synthetic */ Object f(Object obj) {
            X0((Throwable) obj);
            return Unit.f28779a;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u000e\u0012\f0\u0003R\b\u0012\u0004\u0012\u00028\u00000\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0005\u001a\u0012\u0012\u000e\u0012\f0\u0003R\b\u0012\u0004\u0012\u00028\u00000\u00040\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/AwaitAll$DisposeHandlersOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "", "Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "Lkotlinx/coroutines/AwaitAll;", "nodes", "<init>", "(Lkotlinx/coroutines/AwaitAll;[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;)V", "", "d", "()V", "", "cause", "b", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "s", "[Lkotlinx/coroutines/AwaitAll$AwaitAllNode;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private final class DisposeHandlersOnCancel extends CancelHandler {
        @NotNull
        private final AwaitAll<T>.AwaitAllNode[] s;

        public DisposeHandlersOnCancel(@NotNull AwaitAll<T>.AwaitAllNode[] awaitAllNodeArr) {
            this.s = awaitAllNodeArr;
        }

        public void b(@Nullable Throwable th) {
            d();
        }

        public final void d() {
            for (AwaitAll<T>.AwaitAllNode b1 : this.s) {
                b1.b1().m();
            }
        }

        public /* bridge */ /* synthetic */ Object f(Object obj) {
            b((Throwable) obj);
            return Unit.f28779a;
        }

        @NotNull
        public String toString() {
            return "DisposeHandlersOnCancel[" + this.s + ']';
        }
    }

    public AwaitAll(@NotNull Deferred<? extends T>[] deferredArr) {
        this.f29149a = deferredArr;
        this.notCompletedCount = deferredArr.length;
    }

    @Nullable
    public final Object b(@NotNull Continuation<? super List<? extends T>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.e(continuation), 1);
        cancellableContinuationImpl.W();
        int length = this.f29149a.length;
        AwaitAllNode[] awaitAllNodeArr = new AwaitAllNode[length];
        for (int i2 = 0; i2 < length; i2++) {
            Deferred deferred = this.f29149a[i2];
            deferred.start();
            AwaitAllNode awaitAllNode = new AwaitAllNode(cancellableContinuationImpl);
            awaitAllNode.d1(deferred.Z(awaitAllNode));
            Unit unit = Unit.f28779a;
            awaitAllNodeArr[i2] = awaitAllNode;
        }
        DisposeHandlersOnCancel disposeHandlersOnCancel = new DisposeHandlersOnCancel(awaitAllNodeArr);
        for (int i3 = 0; i3 < length; i3++) {
            awaitAllNodeArr[i3].c1(disposeHandlersOnCancel);
        }
        if (cancellableContinuationImpl.p()) {
            disposeHandlersOnCancel.d();
        } else {
            cancellableContinuationImpl.M(disposeHandlersOnCancel);
        }
        Object y = cancellableContinuationImpl.y();
        if (y == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        return y;
    }
}
