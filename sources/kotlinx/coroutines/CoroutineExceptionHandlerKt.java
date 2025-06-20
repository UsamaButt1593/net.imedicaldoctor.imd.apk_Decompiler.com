package kotlinx.coroutines;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\n\u001a,\u0010\u000e\u001a\u00020\r2\u001a\b\u0004\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000bH\b¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "b", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Throwable;)V", "originalException", "thrownException", "c", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Lkotlin/Function2;", "handler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "a", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/CoroutineExceptionHandler;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class CoroutineExceptionHandlerKt {
    @NotNull
    public static final CoroutineExceptionHandler a(@NotNull Function2<? super CoroutineContext, ? super Throwable, Unit> function2) {
        return new CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1(function2, CoroutineExceptionHandler.O2);
    }

    @InternalCoroutinesApi
    public static final void b(@NotNull CoroutineContext coroutineContext, @NotNull Throwable th) {
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) coroutineContext.e(CoroutineExceptionHandler.O2);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.j0(coroutineContext, th);
            } else {
                CoroutineExceptionHandlerImplKt.a(coroutineContext, th);
            }
        } catch (Throwable th2) {
            CoroutineExceptionHandlerImplKt.a(coroutineContext, c(th, th2));
        }
    }

    @NotNull
    public static final Throwable c(@NotNull Throwable th, @NotNull Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        ExceptionsKt.a(runtimeException, th);
        return runtimeException;
    }
}
