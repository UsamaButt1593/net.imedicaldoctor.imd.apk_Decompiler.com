package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\"\u001a\u0010\n\u001a\u00020\u00058\u0000XT¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\b\u0010\t\"\u001a\u0010\r\u001a\u00020\u00058\u0000XT¢\u0006\f\n\u0004\b\u000b\u0010\u0007\u0012\u0004\b\f\u0010\t\"\u001a\u0010\u000f\u001a\u00020\u00058\u0000XT¢\u0006\f\n\u0004\b\u000e\u0010\u0007\u0012\u0004\b\u000e\u0010\t\" \u0010\u0013\u001a\u00020\u00008\u0000X\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\u000b\u0010\t\u001a\u0004\b\u0006\u0010\u0012\" \u0010\u0015\u001a\u00020\u00008\u0000X\u0004¢\u0006\u0012\n\u0004\b\u0014\u0010\u0011\u0012\u0004\b\u0014\u0010\t\u001a\u0004\b\u0010\u0010\u0012*\n\u0010\u0017\"\u00020\u00162\u00020\u0016*\u001c\u0010\u001a\u001a\u0004\b\u0000\u0010\u0018\"\b\u0012\u0004\u0012\u00028\u00000\u00192\b\u0012\u0004\u0012\u00028\u00000\u0019*\f\b\u0002\u0010\u001b\"\u00020\u00012\u00020\u0001*\n\u0010\u001d\"\u00020\u001c2\u00020\u001c*\u001c\u0010\u001f\u001a\u0004\b\u0000\u0010\u0018\"\b\u0012\u0004\u0012\u00028\u00000\u001e2\b\u0012\u0004\u0012\u00028\u00000\u001e¨\u0006 "}, d2 = {"", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "h", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "a", "I", "g", "()V", "UNDECIDED", "b", "f", "SUCCESS", "c", "FAILURE", "d", "Ljava/lang/Object;", "()Ljava/lang/Object;", "CONDITION_FALSE", "e", "LIST_EMPTY", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "AbstractAtomicDesc", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "AddLastDesc", "Node", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "PrepareOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "RemoveFirstDesc", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class LockFreeLinkedListKt {

    /* renamed from: a  reason: collision with root package name */
    public static final int f29349a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f29350b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f29351c = 2;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final Object f29352d = new Symbol("CONDITION_FALSE");
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final Object f29353e = new Symbol("LIST_EMPTY");

    @NotNull
    public static final Object a() {
        return f29352d;
    }

    @PublishedApi
    public static /* synthetic */ void b() {
    }

    @PublishedApi
    public static /* synthetic */ void c() {
    }

    @NotNull
    public static final Object d() {
        return f29353e;
    }

    @PublishedApi
    public static /* synthetic */ void e() {
    }

    @PublishedApi
    public static /* synthetic */ void f() {
    }

    @PublishedApi
    public static /* synthetic */ void g() {
    }

    @NotNull
    @PublishedApi
    public static final LockFreeLinkedListNode h(@NotNull Object obj) {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        Removed removed = obj instanceof Removed ? (Removed) obj : null;
        return (removed == null || (lockFreeLinkedListNode = removed.f29389a) == null) ? (LockFreeLinkedListNode) obj : lockFreeLinkedListNode;
    }
}
