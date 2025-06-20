package kotlinx.coroutines.debug.internal;

import java.io.Serializable;
import java.lang.Thread;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineId;
import kotlinx.coroutines.CoroutineName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001e\u0010\u0012R\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020!0 8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010+\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "Ljava/io/Serializable;", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "source", "Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;Lkotlin/coroutines/CoroutineContext;)V", "", "s", "Ljava/lang/Long;", "a", "()Ljava/lang/Long;", "coroutineId", "", "X", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "dispatcher", "Y", "f", "name", "Z", "h", "state", "X2", "e", "lastObservedThreadState", "Y2", "d", "lastObservedThreadName", "", "Ljava/lang/StackTraceElement;", "Z2", "Ljava/util/List;", "c", "()Ljava/util/List;", "lastObservedStackTrace", "a3", "J", "g", "()J", "sequenceNumber", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
@PublishedApi
public final class DebuggerInfo implements Serializable {
    @Nullable
    private final String X;
    @Nullable
    private final String X2;
    @Nullable
    private final String Y;
    @Nullable
    private final String Y2;
    @NotNull
    private final String Z;
    @NotNull
    private final List<StackTraceElement> Z2;
    private final long a3;
    @Nullable
    private final Long s;

    public DebuggerInfo(@NotNull DebugCoroutineInfoImpl debugCoroutineInfoImpl, @NotNull CoroutineContext coroutineContext) {
        Thread.State state;
        CoroutineId coroutineId = (CoroutineId) coroutineContext.e(CoroutineId.Y);
        String str = null;
        this.s = coroutineId != null ? Long.valueOf(coroutineId.W()) : null;
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.e(ContinuationInterceptor.N2);
        this.X = continuationInterceptor != null ? continuationInterceptor.toString() : null;
        CoroutineName coroutineName = (CoroutineName) coroutineContext.e(CoroutineName.Y);
        this.Y = coroutineName != null ? coroutineName.W() : null;
        this.Z = debugCoroutineInfoImpl.g();
        Thread thread = debugCoroutineInfoImpl.f29281e;
        this.X2 = (thread == null || (state = thread.getState()) == null) ? null : state.toString();
        Thread thread2 = debugCoroutineInfoImpl.f29281e;
        this.Y2 = thread2 != null ? thread2.getName() : str;
        this.Z2 = debugCoroutineInfoImpl.h();
        this.a3 = debugCoroutineInfoImpl.f29278b;
    }

    @Nullable
    public final Long a() {
        return this.s;
    }

    @Nullable
    public final String b() {
        return this.X;
    }

    @NotNull
    public final List<StackTraceElement> c() {
        return this.Z2;
    }

    @Nullable
    public final String d() {
        return this.Y2;
    }

    @Nullable
    public final String e() {
        return this.X2;
    }

    @Nullable
    public final String f() {
        return this.Y;
    }

    public final long g() {
        return this.a3;
    }

    @NotNull
    public final String h() {
        return this.Z;
    }
}
