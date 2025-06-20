package kotlinx.coroutines.internal;

import com.dd.plist.ASCIIPropertyListParser;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0003HÂ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\u00002\f\b\u0002\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/internal/ThreadLocalKey;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/internal/ThreadLocalElement;", "Ljava/lang/ThreadLocal;", "threadLocal", "<init>", "(Ljava/lang/ThreadLocal;)V", "a", "()Ljava/lang/ThreadLocal;", "b", "(Ljava/lang/ThreadLocal;)Lkotlinx/coroutines/internal/ThreadLocalKey;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "s", "Ljava/lang/ThreadLocal;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
@PublishedApi
public final class ThreadLocalKey implements CoroutineContext.Key<ThreadLocalElement<?>> {
    @NotNull
    private final ThreadLocal<?> s;

    public ThreadLocalKey(@NotNull ThreadLocal<?> threadLocal) {
        this.s = threadLocal;
    }

    private final ThreadLocal<?> a() {
        return this.s;
    }

    public static /* synthetic */ ThreadLocalKey c(ThreadLocalKey threadLocalKey, ThreadLocal<?> threadLocal, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            threadLocal = threadLocalKey.s;
        }
        return threadLocalKey.b(threadLocal);
    }

    @NotNull
    public final ThreadLocalKey b(@NotNull ThreadLocal<?> threadLocal) {
        return new ThreadLocalKey(threadLocal);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ThreadLocalKey) && Intrinsics.g(this.s, ((ThreadLocalKey) obj).s);
    }

    public int hashCode() {
        return this.s.hashCode();
    }

    @NotNull
    public String toString() {
        return "ThreadLocalKey(threadLocal=" + this.s + ASCIIPropertyListParser.f18650h;
    }
}
