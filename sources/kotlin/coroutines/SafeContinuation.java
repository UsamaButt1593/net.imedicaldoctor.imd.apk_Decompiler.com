package kotlin.coroutines;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.SinceKotlin;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.3")
@PublishedApi
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u0000 !*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003:\u0001\"B!\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0017\b\u0011\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0007\u0010\tJ \u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lkotlin/coroutines/SafeContinuation;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "", "initialResult", "<init>", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", "(Lkotlin/coroutines/Continuation;)V", "Lkotlin/Result;", "result", "", "w", "(Ljava/lang/Object;)V", "a", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "K", "()Ljava/lang/StackTraceElement;", "", "toString", "()Ljava/lang/String;", "s", "Lkotlin/coroutines/Continuation;", "Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "g", "()Lkotlin/coroutines/CoroutineContext;", "context", "j", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "X", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class SafeContinuation<T> implements Continuation<T>, CoroutineStackFrame {
    @NotNull
    private static final Companion X = new Companion((DefaultConstructorMarker) null);
    private static final AtomicReferenceFieldUpdater<SafeContinuation<?>, Object> Y = AtomicReferenceFieldUpdater.newUpdater(SafeContinuation.class, Object.class, "result");
    @Nullable
    private volatile Object result;
    @NotNull
    private final Continuation<T> s;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Rj\u0010\u0007\u001aR\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00010\u0001 \u0006*(\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0006*\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0005\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00040\u00048\u0002X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u0012\u0004\b\t\u0010\u0003¨\u0006\n"}, d2 = {"Lkotlin/coroutines/SafeContinuation$Companion;", "", "<init>", "()V", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lkotlin/coroutines/SafeContinuation;", "kotlin.jvm.PlatformType", "RESULT", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "a", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    private static final class Companion {
        private Companion() {
        }

        private static /* synthetic */ void a() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @PublishedApi
    public SafeContinuation(@NotNull Continuation<? super T> continuation) {
        this(continuation, CoroutineSingletons.UNDECIDED);
        Intrinsics.p(continuation, "delegate");
    }

    @Nullable
    public StackTraceElement K() {
        return null;
    }

    @Nullable
    @PublishedApi
    public final Object a() {
        Object obj = this.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.UNDECIDED;
        if (obj == coroutineSingletons) {
            if (a.a(Y, this, coroutineSingletons, IntrinsicsKt.l())) {
                return IntrinsicsKt.l();
            }
            obj = this.result;
        }
        if (obj == CoroutineSingletons.RESUMED) {
            return IntrinsicsKt.l();
        }
        if (!(obj instanceof Result.Failure)) {
            return obj;
        }
        throw ((Result.Failure) obj).s;
    }

    @NotNull
    public CoroutineContext g() {
        return this.s.g();
    }

    @Nullable
    public CoroutineStackFrame j() {
        Continuation<T> continuation = this.s;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @NotNull
    public String toString() {
        return "SafeContinuation for " + this.s;
    }

    public void w(@NotNull Object obj) {
        while (true) {
            Object obj2 = this.result;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.UNDECIDED;
            if (obj2 == coroutineSingletons) {
                if (a.a(Y, this, coroutineSingletons, obj)) {
                    return;
                }
            } else if (obj2 != IntrinsicsKt.l()) {
                throw new IllegalStateException("Already resumed");
            } else if (a.a(Y, this, IntrinsicsKt.l(), CoroutineSingletons.RESUMED)) {
                this.s.w(obj);
                return;
            }
        }
    }

    public SafeContinuation(@NotNull Continuation<? super T> continuation, @Nullable Object obj) {
        Intrinsics.p(continuation, "delegate");
        this.s = continuation;
        this.result = obj;
    }
}
