package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aW\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\b\u0007H@ø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\t\u0010\n\u001a]\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\f\u001a\u00020\u000b2'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\b\u0007H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\r\u0010\n\u001aL\u0010\u000e\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\b\u0007H@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\n\u001aR\u0010\u000f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\f\u001a\u00020\u000b2'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\b\u0007H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\n\u001aa\u0010\u0013\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0010\"\b\b\u0001\u0010\u0000*\u00028\u00002\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00112'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\b\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"T", "", "timeMillis", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "block", "c", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/time/Duration;", "timeout", "d", "e", "f", "U", "Lkotlinx/coroutines/TimeoutCoroutine;", "coroutine", "b", "(Lkotlinx/coroutines/TimeoutCoroutine;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "time", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/TimeoutCancellationException;", "a", "(JLkotlinx/coroutines/Job;)Lkotlinx/coroutines/TimeoutCancellationException;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class TimeoutKt {
    @NotNull
    public static final TimeoutCancellationException a(long j2, @NotNull Job job) {
        return new TimeoutCancellationException("Timed out waiting for " + j2 + " ms", job);
    }

    private static final <U, T extends U> Object b(TimeoutCoroutine<U, ? super T> timeoutCoroutine, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        JobKt.y(timeoutCoroutine, DelayKt.d(timeoutCoroutine.Y.g()).N(timeoutCoroutine.Z, timeoutCoroutine, timeoutCoroutine.g()));
        return UndispatchedKt.g(timeoutCoroutine, timeoutCoroutine, function2);
    }

    @Nullable
    public static final <T> Object c(long j2, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        if (j2 > 0) {
            Object b2 = b(new TimeoutCoroutine(j2, continuation), function2);
            if (b2 == IntrinsicsKt.l()) {
                DebugProbesKt.c(continuation);
            }
            return b2;
        }
        throw new TimeoutCancellationException("Timed out immediately");
    }

    @Nullable
    public static final <T> Object d(long j2, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return c(DelayKt.e(j2), function2, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object e(long r7, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = (kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1) r0
            int r1 = r0.a3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.a3 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = new kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            r0.<init>(r10)
        L_0x0018:
            java.lang.Object r10 = r0.Z2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.a3
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r4) goto L_0x0034
            java.lang.Object r7 = r0.Y2
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            java.lang.Object r8 = r0.X2
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            kotlin.ResultKt.n(r10)     // Catch:{ TimeoutCancellationException -> 0x0032 }
            goto L_0x006f
        L_0x0032:
            r8 = move-exception
            goto L_0x0070
        L_0x0034:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003c:
            kotlin.ResultKt.n(r10)
            r5 = 0
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 > 0) goto L_0x0046
            return r3
        L_0x0046:
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            r0.X2 = r9     // Catch:{ TimeoutCancellationException -> 0x0068 }
            r0.Y2 = r10     // Catch:{ TimeoutCancellationException -> 0x0068 }
            r0.Z = r7     // Catch:{ TimeoutCancellationException -> 0x0068 }
            r0.a3 = r4     // Catch:{ TimeoutCancellationException -> 0x0068 }
            kotlinx.coroutines.TimeoutCoroutine r2 = new kotlinx.coroutines.TimeoutCoroutine     // Catch:{ TimeoutCancellationException -> 0x0068 }
            r2.<init>(r7, r0)     // Catch:{ TimeoutCancellationException -> 0x0068 }
            r10.s = r2     // Catch:{ TimeoutCancellationException -> 0x0068 }
            java.lang.Object r7 = b(r2, r9)     // Catch:{ TimeoutCancellationException -> 0x0068 }
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()     // Catch:{ TimeoutCancellationException -> 0x0068 }
            if (r7 != r8) goto L_0x006b
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)     // Catch:{ TimeoutCancellationException -> 0x0068 }
            goto L_0x006b
        L_0x0068:
            r8 = move-exception
            r7 = r10
            goto L_0x0070
        L_0x006b:
            if (r7 != r1) goto L_0x006e
            return r1
        L_0x006e:
            r10 = r7
        L_0x006f:
            return r10
        L_0x0070:
            kotlinx.coroutines.Job r9 = r8.s
            T r7 = r7.s
            if (r9 != r7) goto L_0x0077
            return r3
        L_0x0077:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.TimeoutKt.e(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public static final <T> Object f(long j2, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        return e(DelayKt.e(j2), function2, continuation);
    }
}
