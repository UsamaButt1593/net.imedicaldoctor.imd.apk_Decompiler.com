package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\"\u0014\u0010\n\u001a\u00020\u00078\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\t\"\u0014\u0010\f\u001a\u00020\u00078\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\t\"\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f\"\u0014\u0010\u0012\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0011\"\u0014\u0010\u0013\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011¨\u0006\u0014"}, d2 = {"", "Lkotlinx/coroutines/debug/internal/Marked;", "d", "(Ljava/lang/Object;)Lkotlinx/coroutines/debug/internal/Marked;", "", "e", "()Ljava/lang/Void;", "", "a", "I", "MAGIC", "b", "MIN_CAPACITY", "Lkotlinx/coroutines/internal/Symbol;", "c", "Lkotlinx/coroutines/internal/Symbol;", "REHASH", "Lkotlinx/coroutines/debug/internal/Marked;", "MARKED_NULL", "MARKED_TRUE", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class ConcurrentWeakMapKt {

    /* renamed from: a  reason: collision with root package name */
    private static final int f29264a = -1640531527;

    /* renamed from: b  reason: collision with root package name */
    private static final int f29265b = 16;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final Symbol f29266c = new Symbol("REHASH");
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final Marked f29267d = new Marked((Object) null);
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final Marked f29268e = new Marked(Boolean.TRUE);

    /* access modifiers changed from: private */
    public static final Marked d(Object obj) {
        if (obj == null) {
            return f29267d;
        }
        return Intrinsics.g(obj, Boolean.TRUE) ? f29268e : new Marked(obj);
    }

    /* access modifiers changed from: private */
    public static final Void e() {
        throw new UnsupportedOperationException("not implemented");
    }
}
