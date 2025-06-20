package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlinx.coroutines.DebugStringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0000¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/internal/OpDescriptor;", "", "<init>", "()V", "affected", "c", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "that", "", "b", "(Lkotlinx/coroutines/internal/OpDescriptor;)Z", "Lkotlinx/coroutines/internal/AtomicOp;", "a", "()Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class OpDescriptor {
    @Nullable
    public abstract AtomicOp<?> a();

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r7 = r7.a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(@org.jetbrains.annotations.NotNull kotlinx.coroutines.internal.OpDescriptor r7) {
        /*
            r6 = this;
            kotlinx.coroutines.internal.AtomicOp r0 = r6.a()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            kotlinx.coroutines.internal.AtomicOp r7 = r7.a()
            if (r7 != 0) goto L_0x000f
            return r1
        L_0x000f:
            long r2 = r0.g()
            long r4 = r7.g()
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 >= 0) goto L_0x001c
            r1 = 1
        L_0x001c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.OpDescriptor.b(kotlinx.coroutines.internal.OpDescriptor):boolean");
    }

    @Nullable
    public abstract Object c(@Nullable Object obj);

    @NotNull
    public String toString() {
        return DebugStringsKt.a(this) + '@' + DebugStringsKt.b(this);
    }
}
