package kotlinx.coroutines.internal;

import com.dd.plist.ASCIIPropertyListParser;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\r\u001a\u00020\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/internal/ContextScope;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "", "toString", "()Ljava/lang/String;", "s", "Lkotlin/coroutines/CoroutineContext;", "U", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class ContextScope implements CoroutineScope {
    @NotNull
    private final CoroutineContext s;

    public ContextScope(@NotNull CoroutineContext coroutineContext) {
        this.s = coroutineContext;
    }

    @NotNull
    public CoroutineContext U() {
        return this.s;
    }

    @NotNull
    public String toString() {
        return "CoroutineScope(coroutineContext=" + U() + ASCIIPropertyListParser.f18650h;
    }
}
