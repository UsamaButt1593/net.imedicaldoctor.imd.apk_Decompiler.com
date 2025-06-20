package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\u001a1\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a+\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002¢\u0006\u0004\b\b\u0010\t\"\u0014\u0010\r\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\f\"\u0014\u0010\u000e\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\f\"\u0014\u0010\u0010\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\f\"\u0014\u0010\u0011\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"T", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/Function0;", "block", "b", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coroutineContext", "d", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "", "a", "I", "WORKING", "FINISHED", "c", "INTERRUPTING", "INTERRUPTED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class InterruptibleKt {

    /* renamed from: a  reason: collision with root package name */
    private static final int f29201a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static final int f29202b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f29203c = 2;

    /* renamed from: d  reason: collision with root package name */
    private static final int f29204d = 3;

    @Nullable
    public static final <T> Object b(@NotNull CoroutineContext coroutineContext, @NotNull Function0<? extends T> function0, @NotNull Continuation<? super T> continuation) {
        return BuildersKt.h(coroutineContext, new InterruptibleKt$runInterruptible$2(function0, (Continuation<? super InterruptibleKt$runInterruptible$2>) null), continuation);
    }

    public static /* synthetic */ Object c(CoroutineContext coroutineContext, Function0 function0, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.s;
        }
        return b(coroutineContext, function0, continuation);
    }

    /* access modifiers changed from: private */
    public static final <T> T d(CoroutineContext coroutineContext, Function0<? extends T> function0) {
        ThreadState threadState;
        try {
            threadState = new ThreadState(JobKt.B(coroutineContext));
            threadState.h();
            T o = function0.o();
            threadState.b();
            return o;
        } catch (InterruptedException e2) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e2);
        } catch (Throwable th) {
            threadState.b();
            throw th;
        }
    }
}
