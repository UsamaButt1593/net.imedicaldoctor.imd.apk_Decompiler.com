package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.ThreadLocalEventLoop;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001aW\u0010\u000b\u001a\u00020\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022%\b\u0002\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0019\u0010\u000f\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\t0\rH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001aB\u0010\u0018\u001a\u00020\u000e*\u0006\u0012\u0002\b\u00030\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u0016H\b¢\u0006\u0004\b\u0018\u0010\u0019\"\u001a\u0010\u001f\u001a\u00020\u001a8\u0002X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u0012\u0004\b\u001d\u0010\u001e\"\u001a\u0010!\u001a\u00020\u001a8\u0000X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u001c\u0012\u0004\b \u0010\u001e\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"T", "Lkotlin/coroutines/Continuation;", "Lkotlin/Result;", "result", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "onCancellation", "f", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/internal/DispatchedContinuation;", "", "h", "(Lkotlinx/coroutines/internal/DispatchedContinuation;)Z", "", "contState", "", "mode", "doYield", "Lkotlin/Function0;", "block", "b", "(Lkotlinx/coroutines/internal/DispatchedContinuation;Ljava/lang/Object;IZLkotlin/jvm/functions/Function0;)Z", "Lkotlinx/coroutines/internal/Symbol;", "a", "Lkotlinx/coroutines/internal/Symbol;", "e", "()V", "UNDEFINED", "d", "REUSABLE_CLAIMED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class DispatchedContinuationKt {
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final Symbol f29341a = new Symbol("UNDEFINED");
    @NotNull
    @JvmField

    /* renamed from: b  reason: collision with root package name */
    public static final Symbol f29342b = new Symbol("REUSABLE_CLAIMED");

    private static final boolean b(DispatchedContinuation<?> dispatchedContinuation, Object obj, int i2, boolean z, Function0<Unit> function0) {
        EventLoop b2 = ThreadLocalEventLoop.f29217a.b();
        if (z && b2.I0()) {
            return false;
        }
        if (b2.G0()) {
            dispatchedContinuation.Y2 = obj;
            dispatchedContinuation.Y = i2;
            b2.s0(dispatchedContinuation);
            return true;
        }
        b2.B0(true);
        try {
            function0.o();
            do {
            } while (b2.K0());
        } catch (Throwable th) {
            InlineMarker.d(1);
            b2.i0(true);
            InlineMarker.c(1);
            throw th;
        }
        InlineMarker.d(1);
        b2.i0(true);
        InlineMarker.c(1);
        return false;
    }

    static /* synthetic */ boolean c(DispatchedContinuation dispatchedContinuation, Object obj, int i2, boolean z, Function0 function0, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        EventLoop b2 = ThreadLocalEventLoop.f29217a.b();
        if (z && b2.I0()) {
            return false;
        }
        if (b2.G0()) {
            dispatchedContinuation.Y2 = obj;
            dispatchedContinuation.Y = i2;
            b2.s0(dispatchedContinuation);
            return true;
        }
        b2.B0(true);
        try {
            function0.o();
            do {
            } while (b2.K0());
        } catch (Throwable th) {
            InlineMarker.d(1);
            b2.i0(true);
            InlineMarker.c(1);
            throw th;
        }
        InlineMarker.d(1);
        b2.i0(true);
        InlineMarker.c(1);
        return false;
    }

    public static /* synthetic */ void d() {
    }

    private static /* synthetic */ void e() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008d, code lost:
        if (r8.L1() != false) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a3, code lost:
        if (r8.L1() != false) goto L_0x00a5;
     */
    @kotlinx.coroutines.InternalCoroutinesApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> void f(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r6, @org.jetbrains.annotations.NotNull java.lang.Object r7, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> r8) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.internal.DispatchedContinuation
            if (r0 == 0) goto L_0x00b2
            kotlinx.coroutines.internal.DispatchedContinuation r6 = (kotlinx.coroutines.internal.DispatchedContinuation) r6
            java.lang.Object r8 = kotlinx.coroutines.CompletionStateKt.b(r7, r8)
            kotlinx.coroutines.CoroutineDispatcher r0 = r6.Z
            kotlin.coroutines.CoroutineContext r1 = r6.g()
            boolean r0 = r0.T(r1)
            r1 = 1
            if (r0 == 0) goto L_0x0026
            r6.Y2 = r8
            r6.Y = r1
            kotlinx.coroutines.CoroutineDispatcher r7 = r6.Z
            kotlin.coroutines.CoroutineContext r8 = r6.g()
            r7.R(r8, r6)
            goto L_0x00b5
        L_0x0026:
            kotlinx.coroutines.ThreadLocalEventLoop r0 = kotlinx.coroutines.ThreadLocalEventLoop.f29217a
            kotlinx.coroutines.EventLoop r0 = r0.b()
            boolean r2 = r0.G0()
            if (r2 == 0) goto L_0x003b
            r6.Y2 = r8
            r6.Y = r1
            r0.s0(r6)
            goto L_0x00b5
        L_0x003b:
            r0.B0(r1)
            r2 = 0
            kotlin.coroutines.CoroutineContext r3 = r6.g()     // Catch:{ all -> 0x0068 }
            kotlinx.coroutines.Job$Key r4 = kotlinx.coroutines.Job.P2     // Catch:{ all -> 0x0068 }
            kotlin.coroutines.CoroutineContext$Element r3 = r3.e(r4)     // Catch:{ all -> 0x0068 }
            kotlinx.coroutines.Job r3 = (kotlinx.coroutines.Job) r3     // Catch:{ all -> 0x0068 }
            if (r3 == 0) goto L_0x006a
            boolean r4 = r3.b()     // Catch:{ all -> 0x0068 }
            if (r4 != 0) goto L_0x006a
            java.util.concurrent.CancellationException r7 = r3.I()     // Catch:{ all -> 0x0068 }
            r6.c(r8, r7)     // Catch:{ all -> 0x0068 }
            kotlin.Result$Companion r8 = kotlin.Result.X     // Catch:{ all -> 0x0068 }
            java.lang.Object r7 = kotlin.ResultKt.a(r7)     // Catch:{ all -> 0x0068 }
            java.lang.Object r7 = kotlin.Result.b(r7)     // Catch:{ all -> 0x0068 }
            r6.w(r7)     // Catch:{ all -> 0x0068 }
            goto L_0x0092
        L_0x0068:
            r7 = move-exception
            goto L_0x00a9
        L_0x006a:
            kotlin.coroutines.Continuation<T> r8 = r6.X2     // Catch:{ all -> 0x0068 }
            java.lang.Object r3 = r6.Z2     // Catch:{ all -> 0x0068 }
            kotlin.coroutines.CoroutineContext r4 = r8.g()     // Catch:{ all -> 0x0068 }
            java.lang.Object r3 = kotlinx.coroutines.internal.ThreadContextKt.c(r4, r3)     // Catch:{ all -> 0x0068 }
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.internal.ThreadContextKt.f29399a     // Catch:{ all -> 0x0068 }
            if (r3 == r5) goto L_0x007f
            kotlinx.coroutines.UndispatchedCoroutine r8 = kotlinx.coroutines.CoroutineContextKt.g(r8, r4, r3)     // Catch:{ all -> 0x0068 }
            goto L_0x0080
        L_0x007f:
            r8 = r2
        L_0x0080:
            kotlin.coroutines.Continuation<T> r5 = r6.X2     // Catch:{ all -> 0x009c }
            r5.w(r7)     // Catch:{ all -> 0x009c }
            kotlin.Unit r7 = kotlin.Unit.f28779a     // Catch:{ all -> 0x009c }
            if (r8 == 0) goto L_0x008f
            boolean r7 = r8.L1()     // Catch:{ all -> 0x0068 }
            if (r7 == 0) goto L_0x0092
        L_0x008f:
            kotlinx.coroutines.internal.ThreadContextKt.a(r4, r3)     // Catch:{ all -> 0x0068 }
        L_0x0092:
            boolean r7 = r0.K0()     // Catch:{ all -> 0x0068 }
            if (r7 != 0) goto L_0x0092
        L_0x0098:
            r0.i0(r1)
            goto L_0x00b5
        L_0x009c:
            r7 = move-exception
            if (r8 == 0) goto L_0x00a5
            boolean r8 = r8.L1()     // Catch:{ all -> 0x0068 }
            if (r8 == 0) goto L_0x00a8
        L_0x00a5:
            kotlinx.coroutines.internal.ThreadContextKt.a(r4, r3)     // Catch:{ all -> 0x0068 }
        L_0x00a8:
            throw r7     // Catch:{ all -> 0x0068 }
        L_0x00a9:
            r6.i(r7, r2)     // Catch:{ all -> 0x00ad }
            goto L_0x0098
        L_0x00ad:
            r6 = move-exception
            r0.i0(r1)
            throw r6
        L_0x00b2:
            r6.w(r7)
        L_0x00b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.DispatchedContinuationKt.f(kotlin.coroutines.Continuation, java.lang.Object, kotlin.jvm.functions.Function1):void");
    }

    public static /* synthetic */ void g(Continuation continuation, Object obj, Function1 function1, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            function1 = null;
        }
        f(continuation, obj, function1);
    }

    public static final boolean h(@NotNull DispatchedContinuation<? super Unit> dispatchedContinuation) {
        Unit unit = Unit.f28779a;
        EventLoop b2 = ThreadLocalEventLoop.f29217a.b();
        if (b2.I0()) {
            return false;
        }
        if (b2.G0()) {
            dispatchedContinuation.Y2 = unit;
            dispatchedContinuation.Y = 1;
            b2.s0(dispatchedContinuation);
            return true;
        }
        b2.B0(true);
        try {
            dispatchedContinuation.run();
            do {
            } while (b2.K0());
        } catch (Throwable th) {
            b2.i0(true);
            throw th;
        }
        b2.i0(true);
        return false;
    }
}
