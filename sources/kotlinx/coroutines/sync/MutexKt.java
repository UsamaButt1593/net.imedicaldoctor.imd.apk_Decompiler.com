package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0017\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001aD\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0005*\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bHHø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\n\u0010\u000b\"\u001a\u0010\u0010\u001a\u00020\f8\u0002X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\r\u0012\u0004\b\u000e\u0010\u000f\"\u001a\u0010\u0013\u001a\u00020\f8\u0002X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\r\u0012\u0004\b\u0012\u0010\u000f\"\u001a\u0010\u0016\u001a\u00020\f8\u0002X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\r\u0012\u0004\b\u0015\u0010\u000f\"\u001a\u0010\u0019\u001a\u00020\f8\u0002X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\r\u0012\u0004\b\u0018\u0010\u000f\"\u001a\u0010\u001e\u001a\u00020\u001a8\u0002X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u0012\u0004\b\u001d\u0010\u000f\"\u001a\u0010!\u001a\u00020\u001a8\u0002X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u0012\u0004\b \u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"", "locked", "Lkotlinx/coroutines/sync/Mutex;", "a", "(Z)Lkotlinx/coroutines/sync/Mutex;", "T", "", "owner", "Lkotlin/Function0;", "action", "o", "(Lkotlinx/coroutines/sync/Mutex;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", "Lkotlinx/coroutines/internal/Symbol;", "l", "()V", "LOCK_FAIL", "b", "n", "UNLOCK_FAIL", "c", "k", "LOCKED", "d", "m", "UNLOCKED", "Lkotlinx/coroutines/sync/Empty;", "e", "Lkotlinx/coroutines/sync/Empty;", "i", "EMPTY_LOCKED", "f", "j", "EMPTY_UNLOCKED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class MutexKt {
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final Symbol f29449a = new Symbol("LOCK_FAIL");
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final Symbol f29450b = new Symbol("UNLOCK_FAIL");
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final Symbol f29451c;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final Symbol f29452d;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final Empty f29453e;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public static final Empty f29454f;

    static {
        Symbol symbol = new Symbol("LOCKED");
        f29451c = symbol;
        Symbol symbol2 = new Symbol("UNLOCKED");
        f29452d = symbol2;
        f29453e = new Empty(symbol);
        f29454f = new Empty(symbol2);
    }

    @NotNull
    public static final Mutex a(boolean z) {
        return new MutexImpl(z);
    }

    public static /* synthetic */ Mutex b(boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return a(z);
    }

    private static /* synthetic */ void i() {
    }

    private static /* synthetic */ void j() {
    }

    private static /* synthetic */ void k() {
    }

    private static /* synthetic */ void l() {
    }

    private static /* synthetic */ void m() {
    }

    private static /* synthetic */ void n() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: kotlin.jvm.functions.Function0<? extends T>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object o(@org.jetbrains.annotations.NotNull kotlinx.coroutines.sync.Mutex r4, @org.jetbrains.annotations.Nullable java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends T> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.sync.MutexKt$withLock$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.sync.MutexKt$withLock$1 r0 = (kotlinx.coroutines.sync.MutexKt$withLock$1) r0
            int r1 = r0.a3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.a3 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.sync.MutexKt$withLock$1 r0 = new kotlinx.coroutines.sync.MutexKt$withLock$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.Z2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.a3
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r4 = r0.Y2
            r6 = r4
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            java.lang.Object r5 = r0.X2
            java.lang.Object r4 = r0.Z
            kotlinx.coroutines.sync.Mutex r4 = (kotlinx.coroutines.sync.Mutex) r4
            kotlin.ResultKt.n(r7)
            goto L_0x004e
        L_0x0034:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003c:
            kotlin.ResultKt.n(r7)
            r0.Z = r4
            r0.X2 = r5
            r0.Y2 = r6
            r0.a3 = r3
            java.lang.Object r7 = r4.c(r5, r0)
            if (r7 != r1) goto L_0x004e
            return r1
        L_0x004e:
            java.lang.Object r6 = r6.o()     // Catch:{ all -> 0x005c }
            kotlin.jvm.internal.InlineMarker.d(r3)
            r4.d(r5)
            kotlin.jvm.internal.InlineMarker.c(r3)
            return r6
        L_0x005c:
            r6 = move-exception
            kotlin.jvm.internal.InlineMarker.d(r3)
            r4.d(r5)
            kotlin.jvm.internal.InlineMarker.c(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.MutexKt.o(kotlinx.coroutines.sync.Mutex, java.lang.Object, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final <T> Object p(Mutex mutex, Object obj, Function0<? extends T> function0, Continuation<? super T> continuation) {
        InlineMarker.e(0);
        mutex.c(obj, continuation);
        InlineMarker.e(1);
        try {
            return function0.o();
        } finally {
            InlineMarker.d(1);
            mutex.d(obj);
            InlineMarker.c(1);
        }
    }

    public static /* synthetic */ Object q(Mutex mutex, Object obj, Function0 function0, Continuation continuation, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = null;
        }
        InlineMarker.e(0);
        mutex.c(obj, continuation);
        InlineMarker.e(1);
        try {
            return function0.o();
        } finally {
            InlineMarker.d(1);
            mutex.d(obj);
            InlineMarker.c(1);
        }
    }
}
