package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\f\u001a\u00020\u000b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0010R\u001c\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0012R$\u0010\u0016\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\b0\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/internal/ThreadState;", "", "Lkotlin/coroutines/CoroutineContext;", "context", "", "n", "<init>", "(Lkotlin/coroutines/CoroutineContext;I)V", "Lkotlinx/coroutines/ThreadContextElement;", "element", "value", "", "a", "(Lkotlinx/coroutines/ThreadContextElement;Ljava/lang/Object;)V", "b", "(Lkotlin/coroutines/CoroutineContext;)V", "Lkotlin/coroutines/CoroutineContext;", "", "[Ljava/lang/Object;", "values", "c", "[Lkotlinx/coroutines/ThreadContextElement;", "elements", "d", "I", "i", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class ThreadState {
    @NotNull
    @JvmField

    /* renamed from: a  reason: collision with root package name */
    public final CoroutineContext f29404a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f29405b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final ThreadContextElement<Object>[] f29406c;

    /* renamed from: d  reason: collision with root package name */
    private int f29407d;

    public ThreadState(@NotNull CoroutineContext coroutineContext, int i2) {
        this.f29404a = coroutineContext;
        this.f29405b = new Object[i2];
        this.f29406c = new ThreadContextElement[i2];
    }

    public final void a(@NotNull ThreadContextElement<?> threadContextElement, @Nullable Object obj) {
        Object[] objArr = this.f29405b;
        int i2 = this.f29407d;
        objArr[i2] = obj;
        ThreadContextElement<Object>[] threadContextElementArr = this.f29406c;
        this.f29407d = i2 + 1;
        threadContextElementArr[i2] = threadContextElement;
    }

    public final void b(@NotNull CoroutineContext coroutineContext) {
        int length = this.f29406c.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                ThreadContextElement<Object> threadContextElement = this.f29406c[length];
                Intrinsics.m(threadContextElement);
                threadContextElement.c0(coroutineContext, this.f29405b[length]);
                if (i2 >= 0) {
                    length = i2;
                } else {
                    return;
                }
            }
        }
    }
}
