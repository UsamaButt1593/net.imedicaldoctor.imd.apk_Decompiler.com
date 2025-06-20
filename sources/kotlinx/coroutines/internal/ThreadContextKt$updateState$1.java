package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/internal/ThreadState;", "state", "Lkotlin/coroutines/CoroutineContext$Element;", "element", "b", "(Lkotlinx/coroutines/internal/ThreadState;Lkotlin/coroutines/CoroutineContext$Element;)Lkotlinx/coroutines/internal/ThreadState;"}, k = 3, mv = {1, 6, 0})
final class ThreadContextKt$updateState$1 extends Lambda implements Function2<ThreadState, CoroutineContext.Element, ThreadState> {
    public static final ThreadContextKt$updateState$1 X = new ThreadContextKt$updateState$1();

    ThreadContextKt$updateState$1() {
        super(2);
    }

    @NotNull
    /* renamed from: b */
    public final ThreadState d0(@NotNull ThreadState threadState, @NotNull CoroutineContext.Element element) {
        if (element instanceof ThreadContextElement) {
            ThreadContextElement threadContextElement = (ThreadContextElement) element;
            threadState.a(threadContextElement, threadContextElement.k0(threadState.f29404a));
        }
        return threadState;
    }
}
