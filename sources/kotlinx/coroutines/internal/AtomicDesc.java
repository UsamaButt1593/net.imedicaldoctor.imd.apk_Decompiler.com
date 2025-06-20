package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\n\u001a\u00020\t2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0001H&¢\u0006\u0004\b\n\u0010\u000bR&\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00048\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\n\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/internal/AtomicDesc;", "", "<init>", "()V", "Lkotlinx/coroutines/internal/AtomicOp;", "op", "c", "(Lkotlinx/coroutines/internal/AtomicOp;)Ljava/lang/Object;", "failure", "", "a", "(Lkotlinx/coroutines/internal/AtomicOp;Ljava/lang/Object;)V", "Lkotlinx/coroutines/internal/AtomicOp;", "b", "()Lkotlinx/coroutines/internal/AtomicOp;", "d", "(Lkotlinx/coroutines/internal/AtomicOp;)V", "atomicOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class AtomicDesc {

    /* renamed from: a  reason: collision with root package name */
    public AtomicOp<?> f29330a;

    public abstract void a(@NotNull AtomicOp<?> atomicOp, @Nullable Object obj);

    @NotNull
    public final AtomicOp<?> b() {
        AtomicOp<?> atomicOp = this.f29330a;
        if (atomicOp != null) {
            return atomicOp;
        }
        Intrinsics.S("atomicOp");
        return null;
    }

    @Nullable
    public abstract Object c(@NotNull AtomicOp<?> atomicOp);

    public final void d(@NotNull AtomicOp<?> atomicOp) {
        this.f29330a = atomicOp;
    }
}
