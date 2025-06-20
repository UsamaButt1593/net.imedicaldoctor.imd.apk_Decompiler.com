package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u0012\u0010\u0013R*\u0010\u0018\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00150\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/UndispatchedCoroutine;", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "", "oldValue", "", "M1", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "", "L1", "()Z", "state", "F1", "(Ljava/lang/Object;)V", "Ljava/lang/ThreadLocal;", "Lkotlin/Pair;", "Z", "Ljava/lang/ThreadLocal;", "threadStateToRecover", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class UndispatchedCoroutine<T> extends ScopeCoroutine<T> {
    @NotNull
    private ThreadLocal<Pair<CoroutineContext, Object>> Z;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public UndispatchedCoroutine(@org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext r3, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r4) {
        /*
            r2 = this;
            kotlinx.coroutines.UndispatchedMarker r0 = kotlinx.coroutines.UndispatchedMarker.s
            kotlin.coroutines.CoroutineContext$Element r1 = r3.e(r0)
            if (r1 != 0) goto L_0x000d
            kotlin.coroutines.CoroutineContext r0 = r3.v(r0)
            goto L_0x000e
        L_0x000d:
            r0 = r3
        L_0x000e:
            r2.<init>(r0, r4)
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            r2.Z = r0
            kotlin.coroutines.CoroutineContext r4 = r4.g()
            kotlin.coroutines.ContinuationInterceptor$Key r0 = kotlin.coroutines.ContinuationInterceptor.N2
            kotlin.coroutines.CoroutineContext$Element r4 = r4.e(r0)
            boolean r4 = r4 instanceof kotlinx.coroutines.CoroutineDispatcher
            if (r4 != 0) goto L_0x0031
            r4 = 0
            java.lang.Object r4 = kotlinx.coroutines.internal.ThreadContextKt.c(r3, r4)
            kotlinx.coroutines.internal.ThreadContextKt.a(r3, r4)
            r2.M1(r3, r4)
        L_0x0031:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.UndispatchedCoroutine.<init>(kotlin.coroutines.CoroutineContext, kotlin.coroutines.Continuation):void");
    }

    /* access modifiers changed from: protected */
    public void F1(@Nullable Object obj) {
        Pair pair = this.Z.get();
        UndispatchedCoroutine<?> undispatchedCoroutine = null;
        if (pair != null) {
            ThreadContextKt.a((CoroutineContext) pair.a(), pair.b());
            this.Z.set(undispatchedCoroutine);
        }
        Object a2 = CompletionStateKt.a(obj, this.Y);
        Continuation<T> continuation = this.Y;
        CoroutineContext g2 = continuation.g();
        Object c2 = ThreadContextKt.c(g2, undispatchedCoroutine);
        if (c2 != ThreadContextKt.f29399a) {
            undispatchedCoroutine = CoroutineContextKt.g(continuation, g2, c2);
        }
        try {
            this.Y.w(a2);
            Unit unit = Unit.f28779a;
        } finally {
            if (undispatchedCoroutine == null || undispatchedCoroutine.L1()) {
                ThreadContextKt.a(g2, c2);
            }
        }
    }

    public final boolean L1() {
        if (this.Z.get() == null) {
            return false;
        }
        this.Z.set((Object) null);
        return true;
    }

    public final void M1(@NotNull CoroutineContext coroutineContext, @Nullable Object obj) {
        this.Z.set(TuplesKt.a(coroutineContext, obj));
    }
}
