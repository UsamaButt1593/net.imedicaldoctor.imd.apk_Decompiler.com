package kotlinx.coroutines;

import java.util.List;
import java.util.ServiceLoader;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\"\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\t¨\u0006\u000b"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "a", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Throwable;)V", "", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Ljava/util/List;", "handlers", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class CoroutineExceptionHandlerImplKt {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final List<CoroutineExceptionHandler> f29168a;

    static {
        Class<CoroutineExceptionHandler> cls = CoroutineExceptionHandler.class;
        f29168a = SequencesKt.c3(SequencesKt.e(ServiceLoader.load(cls, cls.getClassLoader()).iterator()));
    }

    public static final void a(@NotNull CoroutineContext coroutineContext, @NotNull Throwable th) {
        for (CoroutineExceptionHandler j0 : f29168a) {
            try {
                j0.j0(coroutineContext, th);
            } catch (Throwable th2) {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, CoroutineExceptionHandlerKt.c(th, th2));
            }
        }
        Thread currentThread2 = Thread.currentThread();
        try {
            Result.Companion companion = Result.X;
            ExceptionsKt.a(th, new DiagnosticCoroutineContextException(coroutineContext));
            Result.b(Unit.f28779a);
        } catch (Throwable th3) {
            Result.Companion companion2 = Result.X;
            Result.b(ResultKt.a(th3));
        }
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }
}
