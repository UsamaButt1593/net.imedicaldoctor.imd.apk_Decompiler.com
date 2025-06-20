package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Ljava/lang/StackTraceElement;", "stackTraceElement", "<init>", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;Ljava/lang/StackTraceElement;)V", "K", "()Ljava/lang/StackTraceElement;", "s", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "j", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "X", "Ljava/lang/StackTraceElement;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class StackTraceFrame implements CoroutineStackFrame {
    @NotNull
    private final StackTraceElement X;
    @Nullable
    private final CoroutineStackFrame s;

    public StackTraceFrame(@Nullable CoroutineStackFrame coroutineStackFrame, @NotNull StackTraceElement stackTraceElement) {
        this.s = coroutineStackFrame;
        this.X = stackTraceElement;
    }

    @NotNull
    public StackTraceElement K() {
        return this.X;
    }

    @Nullable
    public CoroutineStackFrame j() {
        return this.s;
    }
}
