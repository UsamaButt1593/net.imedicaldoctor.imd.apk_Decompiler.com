package kotlinx.coroutines.debug.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0011\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010%\u001a\u0004\u0018\u00010\"8\u0006¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b\u001d\u0010$R\u0019\u0010&\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u001f\u0010\r\u001a\u0004\b\u0018\u0010\u000eR\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168G¢\u0006\f\n\u0004\b'\u0010\u0019\u001a\u0004\b'\u0010\u001a¨\u0006)"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "source", "Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;Lkotlin/coroutines/CoroutineContext;)V", "a", "Lkotlin/coroutines/CoroutineContext;", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "b", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "creationStackBottom", "", "c", "J", "f", "()J", "sequenceNumber", "", "Ljava/lang/StackTraceElement;", "d", "Ljava/util/List;", "()Ljava/util/List;", "creationStackTrace", "", "e", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "state", "Ljava/lang/Thread;", "Ljava/lang/Thread;", "()Ljava/lang/Thread;", "lastObservedThread", "lastObservedFrame", "h", "lastObservedStackTrace", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
@PublishedApi
public final class DebugCoroutineInfo {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineContext f29269a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final CoroutineStackFrame f29270b;

    /* renamed from: c  reason: collision with root package name */
    private final long f29271c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final List<StackTraceElement> f29272d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final String f29273e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final Thread f29274f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final CoroutineStackFrame f29275g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final List<StackTraceElement> f29276h;

    public DebugCoroutineInfo(@NotNull DebugCoroutineInfoImpl debugCoroutineInfoImpl, @NotNull CoroutineContext coroutineContext) {
        this.f29269a = coroutineContext;
        this.f29270b = debugCoroutineInfoImpl.d();
        this.f29271c = debugCoroutineInfoImpl.f29278b;
        this.f29272d = debugCoroutineInfoImpl.e();
        this.f29273e = debugCoroutineInfoImpl.g();
        this.f29274f = debugCoroutineInfoImpl.f29281e;
        this.f29275g = debugCoroutineInfoImpl.f();
        this.f29276h = debugCoroutineInfoImpl.h();
    }

    @NotNull
    public final CoroutineContext a() {
        return this.f29269a;
    }

    @Nullable
    public final CoroutineStackFrame b() {
        return this.f29270b;
    }

    @NotNull
    public final List<StackTraceElement> c() {
        return this.f29272d;
    }

    @Nullable
    public final CoroutineStackFrame d() {
        return this.f29275g;
    }

    @Nullable
    public final Thread e() {
        return this.f29274f;
    }

    public final long f() {
        return this.f29271c;
    }

    @NotNull
    public final String g() {
        return this.f29273e;
    }

    @NotNull
    @JvmName(name = "lastObservedStackTrace")
    public final List<StackTraceElement> h() {
        return this.f29276h;
    }
}
