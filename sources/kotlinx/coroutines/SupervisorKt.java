package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0005\u001a\u00020\u00002\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001aO\u0010\u000e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072'\u0010\r\u001a#\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\u0002\b\fH@ø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u000e\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/Job;", "parent", "Lkotlinx/coroutines/CompletableJob;", "a", "(Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/CompletableJob;", "b", "(Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/Job;", "R", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "block", "e", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class SupervisorKt {
    @NotNull
    public static final CompletableJob a(@Nullable Job job) {
        return new SupervisorJobImpl(job);
    }

    public static /* synthetic */ CompletableJob c(Job job, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            job = null;
        }
        return a(job);
    }

    public static /* synthetic */ Job d(Job job, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            job = null;
        }
        return a(job);
    }

    @Nullable
    public static final <R> Object e(@NotNull Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2, @NotNull Continuation<? super R> continuation) {
        SupervisorCoroutine supervisorCoroutine = new SupervisorCoroutine(continuation.g(), continuation);
        Object f2 = UndispatchedKt.f(supervisorCoroutine, supervisorCoroutine, function2);
        if (f2 == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        return f2;
    }
}
