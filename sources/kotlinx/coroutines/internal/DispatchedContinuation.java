package kotlinx.coroutines.internal;

import androidx.concurrent.futures.a;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletedWithCancellation;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.UndispatchedCoroutine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00000\u0005B\u001d\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0014J\u0015\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010!\u001a\u0004\u0018\u00010 H\u0010¢\u0006\u0004\b!\u0010\"J \u0010%\u001a\u00020\u00122\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016ø\u0001\u0000¢\u0006\u0004\b%\u0010&JH\u0010+\u001a\u00020\u00122\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000#2%\b\b\u0010*\u001a\u001f\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u0012\u0018\u00010'H\bø\u0001\u0000¢\u0006\u0004\b+\u0010,J!\u0010.\u001a\u00020\u00122\b\u0010-\u001a\u0004\u0018\u00010 2\u0006\u0010\u001d\u001a\u00020\u001aH\u0010¢\u0006\u0004\b.\u0010/J\u001a\u00101\u001a\u00020\u000f2\b\u00100\u001a\u0004\u0018\u00010 H\b¢\u0006\u0004\b1\u00102J!\u00103\u001a\u00020\u00122\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000#H\bø\u0001\u0000¢\u0006\u0004\b3\u0010&J\u001f\u00107\u001a\u00020\u00122\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u00028\u0000H\u0000¢\u0006\u0004\b7\u00108J\u000f\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b:\u0010;R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u001e\u0010C\u001a\u0004\u0018\u00010 8\u0000@\u0000X\u000e¢\u0006\f\n\u0004\b@\u0010A\u0012\u0004\bB\u0010\u0014R\u0014\u0010E\u001a\u00020 8\u0000X\u0004¢\u0006\u0006\n\u0004\bD\u0010AR\u001a\u0010G\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00168BX\u0004¢\u0006\u0006\u001a\u0004\bF\u0010\u0018R\u0014\u00105\u001a\u0002048\u0016X\u0005¢\u0006\u0006\u001a\u0004\bH\u0010IR\u001c\u0010L\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048VX\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058PX\u0004¢\u0006\u0006\u001a\u0004\bM\u0010N\u0002\u0004\n\u0002\b\u0019¨\u0006P"}, d2 = {"Lkotlinx/coroutines/internal/DispatchedContinuation;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "continuation", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "K", "()Ljava/lang/StackTraceElement;", "", "s", "()Z", "", "l", "()V", "u", "Lkotlinx/coroutines/CancellableContinuationImpl;", "m", "()Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlinx/coroutines/CancellableContinuation;", "", "z", "(Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Throwable;", "cause", "t", "(Ljava/lang/Throwable;)Z", "", "k", "()Ljava/lang/Object;", "Lkotlin/Result;", "result", "w", "(Ljava/lang/Object;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onCancellation", "v", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "takenState", "c", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "state", "x", "(Ljava/lang/Object;)Z", "y", "Lkotlin/coroutines/CoroutineContext;", "context", "value", "n", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "Z", "Lkotlinx/coroutines/CoroutineDispatcher;", "X2", "Lkotlin/coroutines/Continuation;", "Y2", "Ljava/lang/Object;", "q", "_state", "Z2", "countOrElement", "o", "reusableCancellableContinuation", "g", "()Lkotlin/coroutines/CoroutineContext;", "j", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "e", "()Lkotlin/coroutines/Continuation;", "delegate", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class DispatchedContinuation<T> extends DispatchedTask<T> implements CoroutineStackFrame, Continuation<T> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater a3 = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation");
    @NotNull
    @JvmField
    public final Continuation<T> X2;
    @Nullable
    @JvmField
    public Object Y2 = DispatchedContinuationKt.f29341a;
    @NotNull
    @JvmField
    public final CoroutineDispatcher Z;
    @NotNull
    @JvmField
    public final Object Z2 = ThreadContextKt.b(g());
    @NotNull
    private volatile /* synthetic */ Object _reusableCancellableContinuation = null;

    public DispatchedContinuation(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Continuation<? super T> continuation) {
        super(-1);
        this.Z = coroutineDispatcher;
        this.X2 = continuation;
    }

    private final CancellableContinuationImpl<?> o() {
        Object obj = this._reusableCancellableContinuation;
        if (obj instanceof CancellableContinuationImpl) {
            return (CancellableContinuationImpl) obj;
        }
        return null;
    }

    public static /* synthetic */ void q() {
    }

    @Nullable
    public StackTraceElement K() {
        return null;
    }

    public void c(@Nullable Object obj, @NotNull Throwable th) {
        if (obj instanceof CompletedWithCancellation) {
            ((CompletedWithCancellation) obj).f29166b.f(th);
        }
    }

    @NotNull
    public Continuation<T> e() {
        return this;
    }

    @NotNull
    public CoroutineContext g() {
        return this.X2.g();
    }

    @Nullable
    public CoroutineStackFrame j() {
        Continuation<T> continuation = this.X2;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Nullable
    public Object k() {
        Object obj = this.Y2;
        this.Y2 = DispatchedContinuationKt.f29341a;
        return obj;
    }

    public final void l() {
        do {
        } while (this._reusableCancellableContinuation == DispatchedContinuationKt.f29342b);
    }

    @Nullable
    public final CancellableContinuationImpl<T> m() {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (obj == null) {
                this._reusableCancellableContinuation = DispatchedContinuationKt.f29342b;
                return null;
            } else if (obj instanceof CancellableContinuationImpl) {
                if (a.a(a3, this, obj, DispatchedContinuationKt.f29342b)) {
                    return (CancellableContinuationImpl) obj;
                }
            } else if (obj != DispatchedContinuationKt.f29342b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final void n(@NotNull CoroutineContext coroutineContext, T t) {
        this.Y2 = t;
        this.Y = 1;
        this.Z.S(coroutineContext, this);
    }

    public final boolean s() {
        return this._reusableCancellableContinuation != null;
    }

    public final boolean t(@NotNull Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            Symbol symbol = DispatchedContinuationKt.f29342b;
            if (Intrinsics.g(obj, symbol)) {
                if (a.a(a3, this, symbol, th)) {
                    return true;
                }
            } else if (obj instanceof Throwable) {
                return true;
            } else {
                if (a.a(a3, this, obj, (Object) null)) {
                    return false;
                }
            }
        }
    }

    @NotNull
    public String toString() {
        return "DispatchedContinuation[" + this.Z + ", " + DebugStringsKt.c(this.X2) + ']';
    }

    public final void u() {
        l();
        CancellableContinuationImpl<?> o = o();
        if (o != null) {
            o.t();
        }
    }

    public final void v(@NotNull Object obj, @Nullable Function1<? super Throwable, Unit> function1) {
        CoroutineContext g2;
        Object c2;
        UndispatchedCoroutine<?> g3;
        Object b2 = CompletionStateKt.b(obj, function1);
        if (this.Z.T(g())) {
            this.Y2 = b2;
            this.Y = 1;
            this.Z.R(g(), this);
            return;
        }
        EventLoop b3 = ThreadLocalEventLoop.f29217a.b();
        if (b3.G0()) {
            this.Y2 = b2;
            this.Y = 1;
            b3.s0(this);
            return;
        }
        b3.B0(true);
        try {
            Job job = (Job) g().e(Job.P2);
            if (job == null || job.b()) {
                Continuation<T> continuation = this.X2;
                Object obj2 = this.Z2;
                g2 = continuation.g();
                c2 = ThreadContextKt.c(g2, obj2);
                g3 = c2 != ThreadContextKt.f29399a ? CoroutineContextKt.g(continuation, g2, c2) : null;
                this.X2.w(obj);
                Unit unit = Unit.f28779a;
                InlineMarker.d(1);
                if (g3 == null || g3.L1()) {
                    ThreadContextKt.a(g2, c2);
                }
                InlineMarker.c(1);
            } else {
                CancellationException I = job.I();
                c(b2, I);
                Result.Companion companion = Result.X;
                w(Result.b(ResultKt.a(I)));
            }
            do {
            } while (b3.K0());
        } catch (Throwable th) {
            InlineMarker.d(1);
            b3.i0(true);
            InlineMarker.c(1);
            throw th;
        }
        InlineMarker.d(1);
        b3.i0(true);
        InlineMarker.c(1);
    }

    public void w(@NotNull Object obj) {
        CoroutineContext g2;
        Object c2;
        CoroutineContext g3 = this.X2.g();
        Object d2 = CompletionStateKt.d(obj, (Function1) null, 1, (Object) null);
        if (this.Z.T(g3)) {
            this.Y2 = d2;
            this.Y = 0;
            this.Z.R(g3, this);
            return;
        }
        EventLoop b2 = ThreadLocalEventLoop.f29217a.b();
        if (b2.G0()) {
            this.Y2 = d2;
            this.Y = 0;
            b2.s0(this);
            return;
        }
        b2.B0(true);
        try {
            g2 = g();
            c2 = ThreadContextKt.c(g2, this.Z2);
            this.X2.w(obj);
            Unit unit = Unit.f28779a;
            ThreadContextKt.a(g2, c2);
            do {
            } while (b2.K0());
        } catch (Throwable th) {
            b2.i0(true);
            throw th;
        }
        b2.i0(true);
    }

    public final boolean x(@Nullable Object obj) {
        Job job = (Job) g().e(Job.P2);
        if (job == null || job.b()) {
            return false;
        }
        CancellationException I = job.I();
        c(obj, I);
        Result.Companion companion = Result.X;
        w(Result.b(ResultKt.a(I)));
        return true;
    }

    public final void y(@NotNull Object obj) {
        Continuation<T> continuation = this.X2;
        Object obj2 = this.Z2;
        CoroutineContext g2 = continuation.g();
        Object c2 = ThreadContextKt.c(g2, obj2);
        UndispatchedCoroutine<?> g3 = c2 != ThreadContextKt.f29399a ? CoroutineContextKt.g(continuation, g2, c2) : null;
        try {
            this.X2.w(obj);
            Unit unit = Unit.f28779a;
        } finally {
            InlineMarker.d(1);
            if (g3 == null || g3.L1()) {
                ThreadContextKt.a(g2, c2);
            }
            InlineMarker.c(1);
        }
    }

    @Nullable
    public final Throwable z(@NotNull CancellableContinuation<?> cancellableContinuation) {
        Symbol symbol;
        do {
            Object obj = this._reusableCancellableContinuation;
            symbol = DispatchedContinuationKt.f29342b;
            if (obj != symbol) {
                if (!(obj instanceof Throwable)) {
                    throw new IllegalStateException(("Inconsistent state " + obj).toString());
                } else if (a.a(a3, this, obj, (Object) null)) {
                    return (Throwable) obj;
                } else {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
        } while (!a.a(a3, this, symbol, cancellableContinuation));
        return null;
    }
}
