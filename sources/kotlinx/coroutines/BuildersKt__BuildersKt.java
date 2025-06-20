package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aV\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0003¢\u0006\u0002\b\u0007ø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"T", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "block", "a", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/BuildersKt")
final /* synthetic */ class BuildersKt__BuildersKt {
    public static final <T> T a(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) throws InterruptedException {
        EventLoop eventLoop;
        GlobalScope globalScope;
        Thread currentThread = Thread.currentThread();
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.e(ContinuationInterceptor.N2);
        if (continuationInterceptor == null) {
            eventLoop = ThreadLocalEventLoop.f29217a.b();
            globalScope = GlobalScope.s;
            coroutineContext = coroutineContext.v(eventLoop);
        } else {
            EventLoop eventLoop2 = null;
            EventLoop eventLoop3 = continuationInterceptor instanceof EventLoop ? (EventLoop) continuationInterceptor : null;
            if (eventLoop3 != null) {
                if (eventLoop3.L0()) {
                    eventLoop2 = eventLoop3;
                }
                if (eventLoop2 != null) {
                    eventLoop = eventLoop2;
                    globalScope = GlobalScope.s;
                }
            }
            eventLoop = ThreadLocalEventLoop.f29217a.a();
            globalScope = GlobalScope.s;
        }
        BlockingCoroutine blockingCoroutine = new BlockingCoroutine(CoroutineContextKt.e(globalScope, coroutineContext), currentThread, eventLoop);
        blockingCoroutine.J1(CoroutineStart.DEFAULT, blockingCoroutine, function2);
        return blockingCoroutine.K1();
    }

    public static /* synthetic */ Object b(CoroutineContext coroutineContext, Function2 function2, int i2, Object obj) throws InterruptedException {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.s;
        }
        return BuildersKt.f(coroutineContext, function2);
    }
}
