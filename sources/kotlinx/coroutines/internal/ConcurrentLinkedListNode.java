package kotlinx.coroutines.internal;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u0002B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\t\u001a\u0004\u0018\u00018\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\b¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u0004\u0018\u00018\u00008BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00028\u00008BX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0013\u0010\u001e\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010 \u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0013R\u0013\u0010\u0003\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b!\u0010\u0019R\u0014\u0010#\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0013¨\u0006$"}, d2 = {"Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "N", "", "prev", "<init>", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)V", "Lkotlin/Function0;", "", "onClosedAction", "k", "(Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "value", "", "m", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Z", "", "b", "()V", "j", "()Z", "l", "e", "()Ljava/lang/Object;", "nextOrClosed", "c", "()Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "leftmostAliveNode", "h", "rightmostAliveNode", "d", "next", "i", "isTail", "f", "g", "removed", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class ConcurrentLinkedListNode<N extends ConcurrentLinkedListNode<N>> {

    /* renamed from: a  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f29339a;

    /* renamed from: b  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f29340b;
    @NotNull
    private volatile /* synthetic */ Object _next = null;
    @NotNull
    private volatile /* synthetic */ Object _prev;

    static {
        Class<ConcurrentLinkedListNode> cls = ConcurrentLinkedListNode.class;
        Class<Object> cls2 = Object.class;
        f29339a = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_next");
        f29340b = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_prev");
    }

    public ConcurrentLinkedListNode(@Nullable N n2) {
        this._prev = n2;
    }

    private final N c() {
        N f2 = f();
        while (f2 != null && f2.g()) {
            f2 = (ConcurrentLinkedListNode) f2._prev;
        }
        return f2;
    }

    /* access modifiers changed from: private */
    public final Object e() {
        return this._next;
    }

    private final N h() {
        N d2 = d();
        while (true) {
            Intrinsics.m(d2);
            if (!d2.g()) {
                return d2;
            }
            d2 = d2.d();
        }
    }

    public final void b() {
        f29340b.lazySet(this, (Object) null);
    }

    @Nullable
    public final N d() {
        N a2 = e();
        if (a2 == ConcurrentLinkedListKt.f29338b) {
            return null;
        }
        return (ConcurrentLinkedListNode) a2;
    }

    @Nullable
    public final N f() {
        return (ConcurrentLinkedListNode) this._prev;
    }

    public abstract boolean g();

    public final boolean i() {
        return d() == null;
    }

    public final boolean j() {
        return a.a(f29339a, this, (Object) null, ConcurrentLinkedListKt.f29338b);
    }

    @Nullable
    public final N k(@NotNull Function0 function0) {
        N a2 = e();
        if (a2 != ConcurrentLinkedListKt.f29338b) {
            return (ConcurrentLinkedListNode) a2;
        }
        function0.o();
        throw new KotlinNothingValueException();
    }

    public final void l() {
        while (true) {
            ConcurrentLinkedListNode c2 = c();
            ConcurrentLinkedListNode h2 = h();
            h2._prev = c2;
            if (c2 != null) {
                c2._next = h2;
            }
            if (!h2.g() && (c2 == null || !c2.g())) {
                return;
            }
        }
    }

    public final boolean m(@NotNull N n2) {
        return a.a(f29339a, this, (Object) null, n2);
    }
}
