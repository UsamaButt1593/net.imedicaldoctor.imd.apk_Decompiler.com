package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0011\u001a'\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a5\u0010\u000b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0017\u0010\r\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0001H\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a.\u0010\u0013\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011H\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a \u0010\u0017\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\b¢\u0006\u0004\b\u0017\u0010\u0018\"\u0014\u0010\u001a\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019\"\u001a\u0010\u001d\u001a\u00020\u00028\u0000XT¢\u0006\f\n\u0004\b\u001b\u0010\u0019\u0012\u0004\b\u001b\u0010\u001c\"\u0014\u0010\u001f\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u001e\u0010\u0019\"\u0014\u0010!\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b \u0010\u0019\"\u0014\u0010\"\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0019\"\u0018\u0010$\u001a\u00020\t*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010#\"\u0018\u0010%\u001a\u00020\t*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b \u0010#¨\u0006&"}, d2 = {"T", "Lkotlinx/coroutines/DispatchedTask;", "", "mode", "", "a", "(Lkotlinx/coroutines/DispatchedTask;I)V", "Lkotlin/coroutines/Continuation;", "delegate", "", "undispatched", "e", "(Lkotlinx/coroutines/DispatchedTask;Lkotlin/coroutines/Continuation;Z)V", "f", "(Lkotlinx/coroutines/DispatchedTask;)V", "Lkotlinx/coroutines/EventLoop;", "eventLoop", "Lkotlin/Function0;", "block", "h", "(Lkotlinx/coroutines/DispatchedTask;Lkotlinx/coroutines/EventLoop;Lkotlin/jvm/functions/Function0;)V", "", "exception", "g", "(Lkotlin/coroutines/Continuation;Ljava/lang/Throwable;)V", "I", "MODE_ATOMIC", "b", "()V", "MODE_CANCELLABLE", "c", "MODE_CANCELLABLE_REUSABLE", "d", "MODE_UNDISPATCHED", "MODE_UNINITIALIZED", "(I)Z", "isCancellableMode", "isReusableMode", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class DispatchedTaskKt {

    /* renamed from: a  reason: collision with root package name */
    public static final int f29181a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f29182b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f29183c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f29184d = 4;

    /* renamed from: e  reason: collision with root package name */
    public static final int f29185e = -1;

    public static final <T> void a(@NotNull DispatchedTask<? super T> dispatchedTask, int i2) {
        Continuation<? super T> e2 = dispatchedTask.e();
        boolean z = i2 == 4;
        if (z || !(e2 instanceof DispatchedContinuation) || c(i2) != c(dispatchedTask.Y)) {
            e(dispatchedTask, e2, z);
            return;
        }
        CoroutineDispatcher coroutineDispatcher = ((DispatchedContinuation) e2).Z;
        CoroutineContext g2 = e2.g();
        if (coroutineDispatcher.T(g2)) {
            coroutineDispatcher.R(g2, dispatchedTask);
        } else {
            f(dispatchedTask);
        }
    }

    @PublishedApi
    public static /* synthetic */ void b() {
    }

    public static final boolean c(int i2) {
        return i2 == 1 || i2 == 2;
    }

    public static final boolean d(int i2) {
        return i2 == 2;
    }

    public static final <T> void e(@NotNull DispatchedTask<? super T> dispatchedTask, @NotNull Continuation<? super T> continuation, boolean z) {
        Object h2;
        Object k2 = dispatchedTask.k();
        Throwable f2 = dispatchedTask.f(k2);
        if (f2 != null) {
            Result.Companion companion = Result.X;
            h2 = ResultKt.a(f2);
        } else {
            Result.Companion companion2 = Result.X;
            h2 = dispatchedTask.h(k2);
        }
        Object b2 = Result.b(h2);
        if (z) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            Continuation<T> continuation2 = dispatchedContinuation.X2;
            Object obj = dispatchedContinuation.Z2;
            CoroutineContext g2 = continuation2.g();
            Object c2 = ThreadContextKt.c(g2, obj);
            UndispatchedCoroutine<?> g3 = c2 != ThreadContextKt.f29399a ? CoroutineContextKt.g(continuation2, g2, c2) : null;
            try {
                dispatchedContinuation.X2.w(b2);
                Unit unit = Unit.f28779a;
            } finally {
                if (g3 == null || g3.L1()) {
                    ThreadContextKt.a(g2, c2);
                }
            }
        } else {
            continuation.w(b2);
        }
    }

    private static final void f(DispatchedTask<?> dispatchedTask) {
        EventLoop b2 = ThreadLocalEventLoop.f29217a.b();
        if (b2.G0()) {
            b2.s0(dispatchedTask);
            return;
        }
        b2.B0(true);
        try {
            e(dispatchedTask, dispatchedTask.e(), true);
            do {
            } while (b2.K0());
        } catch (Throwable th) {
            b2.i0(true);
            throw th;
        }
        b2.i0(true);
    }

    public static final void g(@NotNull Continuation<?> continuation, @NotNull Throwable th) {
        Result.Companion companion = Result.X;
        continuation.w(Result.b(ResultKt.a(th)));
    }

    public static final void h(@NotNull DispatchedTask<?> dispatchedTask, @NotNull EventLoop eventLoop, @NotNull Function0<Unit> function0) {
        eventLoop.B0(true);
        try {
            function0.o();
            do {
            } while (eventLoop.K0());
        } catch (Throwable th) {
            InlineMarker.d(1);
            eventLoop.i0(true);
            InlineMarker.c(1);
            throw th;
        }
        InlineMarker.d(1);
        eventLoop.i0(true);
        InlineMarker.c(1);
    }
}
