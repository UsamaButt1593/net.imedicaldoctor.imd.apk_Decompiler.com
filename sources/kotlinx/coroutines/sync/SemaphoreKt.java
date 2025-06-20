package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a8\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0006*\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007HHø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\t\u0010\n\u001a!\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010\"\u001a\u0010\u0014\u001a\u00020\u00008\u0002X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u0012\u0004\b\u0012\u0010\u0013\"\u001a\u0010\u0019\u001a\u00020\u00158\u0002X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u0018\u0010\u0013\"\u001a\u0010\u001c\u001a\u00020\u00158\u0002X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u0012\u0004\b\u001b\u0010\u0013\"\u001a\u0010\u001f\u001a\u00020\u00158\u0002X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0017\u0012\u0004\b\u001e\u0010\u0013\"\u001a\u0010\"\u001a\u00020\u00158\u0002X\u0004¢\u0006\f\n\u0004\b \u0010\u0017\u0012\u0004\b!\u0010\u0013\"\u001a\u0010%\u001a\u00020\u00008\u0002X\u0004¢\u0006\f\n\u0004\b#\u0010\u0011\u0012\u0004\b$\u0010\u0013\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"", "permits", "acquiredPermits", "Lkotlinx/coroutines/sync/Semaphore;", "a", "(II)Lkotlinx/coroutines/sync/Semaphore;", "T", "Lkotlin/Function0;", "action", "q", "(Lkotlinx/coroutines/sync/Semaphore;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "id", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "prev", "j", "(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", "I", "m", "()V", "MAX_SPIN_CYCLES", "Lkotlinx/coroutines/internal/Symbol;", "b", "Lkotlinx/coroutines/internal/Symbol;", "n", "PERMIT", "c", "p", "TAKEN", "d", "k", "BROKEN", "e", "l", "CANCELLED", "f", "o", "SEGMENT_SIZE", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class SemaphoreKt {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final int f29462a = SystemPropsKt__SystemProps_commonKt.d("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, (Object) null);
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final Symbol f29463b = new Symbol("PERMIT");
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final Symbol f29464c = new Symbol("TAKEN");
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final Symbol f29465d = new Symbol("BROKEN");
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final Symbol f29466e = new Symbol("CANCELLED");
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final int f29467f = SystemPropsKt__SystemProps_commonKt.d("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, (Object) null);

    @NotNull
    public static final Semaphore a(int i2, int i3) {
        return new SemaphoreImpl(i2, i3);
    }

    public static /* synthetic */ Semaphore b(int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        return a(i2, i3);
    }

    /* access modifiers changed from: private */
    public static final SemaphoreSegment j(long j2, SemaphoreSegment semaphoreSegment) {
        return new SemaphoreSegment(j2, semaphoreSegment, 0);
    }

    private static /* synthetic */ void k() {
    }

    private static /* synthetic */ void l() {
    }

    private static /* synthetic */ void m() {
    }

    private static /* synthetic */ void n() {
    }

    private static /* synthetic */ void o() {
    }

    private static /* synthetic */ void p() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: kotlin.jvm.functions.Function0<? extends T>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object q(@org.jetbrains.annotations.NotNull kotlinx.coroutines.sync.Semaphore r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends T> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.sync.SemaphoreKt$withPermit$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 r0 = (kotlinx.coroutines.sync.SemaphoreKt$withPermit$1) r0
            int r1 = r0.Z2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.Z2 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 r0 = new kotlinx.coroutines.sync.SemaphoreKt$withPermit$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.Y2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.Z2
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r4 = r0.X2
            r5 = r4
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            java.lang.Object r4 = r0.Z
            kotlinx.coroutines.sync.Semaphore r4 = (kotlinx.coroutines.sync.Semaphore) r4
            kotlin.ResultKt.n(r6)
            goto L_0x004a
        L_0x0032:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003a:
            kotlin.ResultKt.n(r6)
            r0.Z = r4
            r0.X2 = r5
            r0.Z2 = r3
            java.lang.Object r6 = r4.c(r0)
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            java.lang.Object r5 = r5.o()     // Catch:{ all -> 0x0058 }
            kotlin.jvm.internal.InlineMarker.d(r3)
            r4.a()
            kotlin.jvm.internal.InlineMarker.c(r3)
            return r5
        L_0x0058:
            r5 = move-exception
            kotlin.jvm.internal.InlineMarker.d(r3)
            r4.a()
            kotlin.jvm.internal.InlineMarker.c(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreKt.q(kotlinx.coroutines.sync.Semaphore, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final <T> Object r(Semaphore semaphore, Function0<? extends T> function0, Continuation<? super T> continuation) {
        InlineMarker.e(0);
        semaphore.c(continuation);
        InlineMarker.e(1);
        try {
            return function0.o();
        } finally {
            InlineMarker.d(1);
            semaphore.a();
            InlineMarker.c(1);
        }
    }
}
