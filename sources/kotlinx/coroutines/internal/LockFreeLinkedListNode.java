package kotlinx.coroutines.internal;

import androidx.concurrent.futures.a;
import androidx.exifinterface.media.ExifInterface;
import com.dd.plist.ASCIIPropertyListParser;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0017\u0018\u00002\u00020\u0001:\u0005JKLMNB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\t\u001a\u00060\u0000j\u0002`\u00072\n\u0010\b\u001a\u00060\u0000j\u0002`\u0007H\u0010¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\f2\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u0011\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0010¢\u0006\u0004\b\u0011\u0010\u0012J,\u0010\u0018\u001a\u00020\u00172\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u00072\u000e\b\u0004\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\b¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u00152\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\f2\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u0007¢\u0006\u0004\b\u001c\u0010\u000eJ)\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e\"\f\b\u0000\u0010\u001d*\u00060\u0000j\u0002`\u00072\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0004\b\u001f\u0010 J,\u0010!\u001a\u00020\u00152\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u00072\u000e\b\u0004\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\b¢\u0006\u0004\b!\u0010\"J4\u0010%\u001a\u00020\u00152\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u00072\u0016\u0010$\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0007\u0012\u0004\u0012\u00020\u00150#H\b¢\u0006\u0004\b%\u0010&JD\u0010'\u001a\u00020\u00152\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u00072\u0016\u0010$\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0007\u0012\u0004\u0012\u00020\u00150#2\u000e\b\u0004\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\b¢\u0006\u0004\b'\u0010(J'\u0010)\u001a\u00020\u00152\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u00072\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u0007H\u0001¢\u0006\u0004\b)\u0010*J/\u0010-\u001a\u00020,2\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u00072\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u00072\u0006\u0010+\u001a\u00020\u0017H\u0001¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0015H\u0016¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0007H\u0001¢\u0006\u0004\b1\u00102J\r\u00103\u001a\u00020\f¢\u0006\u0004\b3\u0010\u0003J\u000f\u00104\u001a\u00020\fH\u0001¢\u0006\u0004\b4\u0010\u0003J\u0015\u00105\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0007¢\u0006\u0004\b5\u00102J\u0017\u00107\u001a\f\u0012\b\u0012\u00060\u0000j\u0002`\u000706¢\u0006\u0004\b7\u00108J.\u00109\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u001d\u0018\u00012\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150#H\b¢\u0006\u0004\b9\u0010:J\u0017\u0010;\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0007H\u0014¢\u0006\u0004\b;\u00102J'\u0010=\u001a\u00020\f2\n\u0010<\u001a\u00060\u0000j\u0002`\u00072\n\u0010\u000b\u001a\u00060\u0000j\u0002`\u0007H\u0000¢\u0006\u0004\b=\u0010>J\u000f\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\b@\u0010AR\u0014\u0010C\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\bB\u00100R\u0011\u0010\u000b\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0015\u0010G\u001a\u00060\u0000j\u0002`\u00078F¢\u0006\u0006\u001a\u0004\bF\u00102R\u0015\u0010I\u001a\u00060\u0000j\u0002`\u00078F¢\u0006\u0006\u001a\u0004\bH\u00102¨\u0006O"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "", "<init>", "()V", "Lkotlinx/coroutines/internal/Removed;", "U0", "()Lkotlinx/coroutines/internal/Removed;", "Lkotlinx/coroutines/internal/Node;", "current", "G0", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "next", "", "H0", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "D0", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "node", "Lkotlin/Function0;", "", "condition", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "O0", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "C0", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "x0", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "E0", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "y0", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Z", "Lkotlin/Function1;", "predicate", "z0", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;)Z", "A0", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Z", "B0", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "condAdd", "", "V0", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;)I", "Q0", "()Z", "T0", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "L0", "M0", "S0", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "F0", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "R0", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "P0", "prev", "W0", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "", "toString", "()Ljava/lang/String;", "N0", "isRemoved", "I0", "()Ljava/lang/Object;", "J0", "nextNode", "K0", "prevNode", "AbstractAtomicDesc", "AddLastDesc", "CondAddOp", "PrepareOp", "RemoveFirstDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
@InternalCoroutinesApi
public class LockFreeLinkedListNode {
    static final /* synthetic */ AtomicReferenceFieldUpdater X;
    private static final /* synthetic */ AtomicReferenceFieldUpdater Y;
    static final /* synthetic */ AtomicReferenceFieldUpdater s;
    @NotNull
    volatile /* synthetic */ Object _next = this;
    @NotNull
    volatile /* synthetic */ Object _prev = this;
    @NotNull
    private volatile /* synthetic */ Object _removedRef = null;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\u0010\n\u001a\u00060\u0006j\u0002`\u0007H\u0014¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\u00020\u000f2\n\u0010\n\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u000e\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0013\u001a\u00020\u00122\n\u0010\n\u001a\u00060\u0006j\u0002`\u00072\n\u0010\u000e\u001a\u00060\u0006j\u0002`\u0007H$¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0015\u001a\u00020\u000b2\n\u0010\n\u001a\u00060\u0006j\u0002`\u00072\n\u0010\u000e\u001a\u00060\u0006j\u0002`\u0007H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001d\u001a\u00020\u00122\n\u0010\n\u001a\u00060\u0006j\u0002`\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010 \u001a\u0004\u0018\u00010\u000b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u001f¢\u0006\u0004\b \u0010!J#\u0010#\u001a\u00020\u00122\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b#\u0010$R\u001c\u0010'\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078$X¤\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001c\u0010)\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078$X¤\u0004¢\u0006\u0006\u001a\u0004\b(\u0010&¨\u0006*"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "Lkotlinx/coroutines/internal/AtomicDesc;", "<init>", "()V", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "m", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affected", "", "e", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "next", "", "l", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "", "f", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "n", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "prepareOp", "g", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "j", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Ljava/lang/Object;", "k", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlinx/coroutines/internal/AtomicOp;", "c", "(Lkotlinx/coroutines/internal/AtomicOp;)Ljava/lang/Object;", "failure", "a", "(Lkotlinx/coroutines/internal/AtomicOp;Ljava/lang/Object;)V", "h", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affectedNode", "i", "originalNext", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static abstract class AbstractAtomicDesc extends AtomicDesc {
        public final void a(@NotNull AtomicOp<?> atomicOp, @Nullable Object obj) {
            LockFreeLinkedListNode i2;
            boolean z = obj == null;
            LockFreeLinkedListNode h2 = h();
            if (h2 != null && (i2 = i()) != null) {
                if (a.a(LockFreeLinkedListNode.s, h2, atomicOp, z ? n(h2, i2) : i2) && z) {
                    f(h2, i2);
                }
            }
        }

        @Nullable
        public final Object c(@NotNull AtomicOp<?> atomicOp) {
            while (true) {
                LockFreeLinkedListNode m2 = m(atomicOp);
                if (m2 == null) {
                    return AtomicKt.f29332b;
                }
                Object obj = m2._next;
                if (obj == atomicOp || atomicOp.h()) {
                    return null;
                }
                if (obj instanceof OpDescriptor) {
                    OpDescriptor opDescriptor = (OpDescriptor) obj;
                    if (atomicOp.b(opDescriptor)) {
                        return AtomicKt.f29332b;
                    }
                    opDescriptor.c(m2);
                } else {
                    Object e2 = e(m2);
                    if (e2 != null) {
                        return e2;
                    }
                    if (!l(m2, obj)) {
                        PrepareOp prepareOp = new PrepareOp(m2, (LockFreeLinkedListNode) obj, this);
                        if (a.a(LockFreeLinkedListNode.s, m2, obj, prepareOp)) {
                            try {
                                if (prepareOp.c(m2) != LockFreeLinkedList_commonKt.f29366a) {
                                    return null;
                                }
                            } catch (Throwable th) {
                                a.a(LockFreeLinkedListNode.s, m2, prepareOp, obj);
                                throw th;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        @Nullable
        public Object e(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            return null;
        }

        /* access modifiers changed from: protected */
        public abstract void f(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2);

        public abstract void g(@NotNull PrepareOp prepareOp);

        /* access modifiers changed from: protected */
        @Nullable
        public abstract LockFreeLinkedListNode h();

        /* access modifiers changed from: protected */
        @Nullable
        public abstract LockFreeLinkedListNode i();

        @Nullable
        public Object j(@NotNull PrepareOp prepareOp) {
            g(prepareOp);
            return null;
        }

        public void k(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        }

        /* access modifiers changed from: protected */
        public boolean l(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Object obj) {
            return false;
        }

        /* access modifiers changed from: protected */
        @Nullable
        public LockFreeLinkedListNode m(@NotNull OpDescriptor opDescriptor) {
            LockFreeLinkedListNode h2 = h();
            Intrinsics.m(h2);
            return h2;
        }

        @NotNull
        public abstract Object n(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2);
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000*\f\b\u0000\u0010\u0003*\u00060\u0001j\u0002`\u00022\u00020\u0004B\u001b\u0012\n\u0010\u0005\u001a\u00060\u0001j\u0002`\u0002\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00022\u0006\u0010\n\u001a\u00020\tH\u0004¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0011\u001a\u00020\u00102\n\u0010\r\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0018\u001a\u00020\u000e2\n\u0010\r\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u000f\u001a\u00060\u0001j\u0002`\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001a\u001a\u00020\u00152\n\u0010\r\u001a\u00060\u0001j\u0002`\u00022\n\u0010\u000f\u001a\u00060\u0001j\u0002`\u0002H\u0014¢\u0006\u0004\b\u001a\u0010\bR\u0018\u0010\u0005\u001a\u00060\u0001j\u0002`\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0006\u001a\u00028\u00008\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u001c\u0010 \u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00028DX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u00060\u0001j\u0002`\u00028DX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001f¨\u0006#"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "queue", "node", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "m", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affected", "", "next", "", "l", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "prepareOp", "", "g", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "n", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "f", "b", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "c", "h", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affectedNode", "i", "originalNext", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static class AddLastDesc<T extends LockFreeLinkedListNode> extends AbstractAtomicDesc {

        /* renamed from: d  reason: collision with root package name */
        private static final /* synthetic */ AtomicReferenceFieldUpdater f29354d = AtomicReferenceFieldUpdater.newUpdater(AddLastDesc.class, Object.class, "_affectedNode");
        @NotNull
        private volatile /* synthetic */ Object _affectedNode = null;
        @NotNull
        @JvmField

        /* renamed from: b  reason: collision with root package name */
        public final LockFreeLinkedListNode f29355b;
        @NotNull
        @JvmField

        /* renamed from: c  reason: collision with root package name */
        public final T f29356c;

        public AddLastDesc(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull T t) {
            this.f29355b = lockFreeLinkedListNode;
            this.f29356c = t;
        }

        /* access modifiers changed from: protected */
        public void f(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
            this.f29356c.H0(this.f29355b);
        }

        public void g(@NotNull PrepareOp prepareOp) {
            a.a(f29354d, this, (Object) null, prepareOp.f29359a);
        }

        /* access modifiers changed from: protected */
        @Nullable
        public final LockFreeLinkedListNode h() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        /* access modifiers changed from: protected */
        @NotNull
        public final LockFreeLinkedListNode i() {
            return this.f29355b;
        }

        /* access modifiers changed from: protected */
        public boolean l(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Object obj) {
            return obj != this.f29355b;
        }

        /* access modifiers changed from: protected */
        @Nullable
        public final LockFreeLinkedListNode m(@NotNull OpDescriptor opDescriptor) {
            return this.f29355b.D0(opDescriptor);
        }

        @NotNull
        public Object n(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
            T t = this.f29356c;
            a.a(LockFreeLinkedListNode.X, t, t, lockFreeLinkedListNode);
            T t2 = this.f29356c;
            a.a(LockFreeLinkedListNode.s, t2, t2, this.f29355b);
            return this.f29356c;
        }
    }

    @PublishedApi
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b!\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\u000b\u001a\u00020\n2\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "newNode", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "affected", "", "failure", "", "j", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)V", "b", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "c", "oldNext", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static abstract class CondAddOp extends AtomicOp<LockFreeLinkedListNode> {
        @NotNull
        @JvmField

        /* renamed from: b  reason: collision with root package name */
        public final LockFreeLinkedListNode f29357b;
        @Nullable
        @JvmField

        /* renamed from: c  reason: collision with root package name */
        public LockFreeLinkedListNode f29358c;

        public CondAddOp(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.f29357b = lockFreeLinkedListNode;
        }

        /* renamed from: j */
        public void d(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @Nullable Object obj) {
            boolean z = obj == null;
            LockFreeLinkedListNode lockFreeLinkedListNode2 = z ? this.f29357b : this.f29358c;
            if (lockFreeLinkedListNode2 != null && a.a(LockFreeLinkedListNode.s, lockFreeLinkedListNode, this, lockFreeLinkedListNode2) && z) {
                LockFreeLinkedListNode lockFreeLinkedListNode3 = this.f29357b;
                LockFreeLinkedListNode lockFreeLinkedListNode4 = this.f29358c;
                Intrinsics.m(lockFreeLinkedListNode4);
                lockFreeLinkedListNode3.H0(lockFreeLinkedListNode4);
            }
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u0012\n\u0010\u0005\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0005\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\u0018\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u00178VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0018¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "affected", "next", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "desc", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;)V", "", "c", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "d", "()V", "", "toString", "()Ljava/lang/String;", "a", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "b", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "Lkotlinx/coroutines/internal/AtomicOp;", "()Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class PrepareOp extends OpDescriptor {
        @NotNull
        @JvmField

        /* renamed from: a  reason: collision with root package name */
        public final LockFreeLinkedListNode f29359a;
        @NotNull
        @JvmField

        /* renamed from: b  reason: collision with root package name */
        public final LockFreeLinkedListNode f29360b;
        @NotNull
        @JvmField

        /* renamed from: c  reason: collision with root package name */
        public final AbstractAtomicDesc f29361c;

        public PrepareOp(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2, @NotNull AbstractAtomicDesc abstractAtomicDesc) {
            this.f29359a = lockFreeLinkedListNode;
            this.f29360b = lockFreeLinkedListNode2;
            this.f29361c = abstractAtomicDesc;
        }

        @NotNull
        public AtomicOp<?> a() {
            return this.f29361c.b();
        }

        @Nullable
        public Object c(@Nullable Object obj) {
            if (obj != null) {
                LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
                Object j2 = this.f29361c.j(this);
                Object obj2 = LockFreeLinkedList_commonKt.f29366a;
                if (j2 == obj2) {
                    LockFreeLinkedListNode lockFreeLinkedListNode2 = this.f29360b;
                    if (a.a(LockFreeLinkedListNode.s, lockFreeLinkedListNode, this, lockFreeLinkedListNode2.U0())) {
                        this.f29361c.k(lockFreeLinkedListNode);
                        LockFreeLinkedListNode unused = lockFreeLinkedListNode2.D0((OpDescriptor) null);
                    }
                    return obj2;
                }
                Object e2 = j2 != null ? a().e(j2) : a().f();
                a.a(LockFreeLinkedListNode.s, lockFreeLinkedListNode, this, e2 == AtomicKt.f29331a ? a() : e2 == null ? this.f29361c.n(lockFreeLinkedListNode, this.f29360b) : this.f29360b);
                return null;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        }

        public final void d() {
            this.f29361c.g(this);
        }

        @NotNull
        public String toString() {
            return "PrepareOp(op=" + a() + ASCIIPropertyListParser.f18650h;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\u0006\u0010\t\u001a\u00020\bH\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\u0010\f\u001a\u00060\u0003j\u0002`\u0004H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0012\u001a\u00020\u00112\n\u0010\f\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u0010\u001a\u00020\rH\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u0019\u001a\u00020\r2\n\u0010\f\u001a\u00060\u0003j\u0002`\u00042\n\u0010\u0010\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001b\u001a\u00020\u00162\n\u0010\f\u001a\u00060\u0003j\u0002`\u00042\n\u0010\u0010\u001a\u00060\u0003j\u0002`\u0004H\u0004¢\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0005\u001a\u00060\u0003j\u0002`\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0017\u0010#\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u001c\u0010&\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048DX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001c\u0010(\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048DX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010%¨\u0006)"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "T", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "queue", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "m", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affected", "", "e", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "next", "", "l", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "prepareOp", "", "g", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "n", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "f", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "b", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "o", "()Ljava/lang/Object;", "p", "()V", "result", "h", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affectedNode", "i", "originalNext", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static class RemoveFirstDesc<T> extends AbstractAtomicDesc {

        /* renamed from: c  reason: collision with root package name */
        private static final /* synthetic */ AtomicReferenceFieldUpdater f29362c;

        /* renamed from: d  reason: collision with root package name */
        private static final /* synthetic */ AtomicReferenceFieldUpdater f29363d;
        @NotNull
        private volatile /* synthetic */ Object _affectedNode = null;
        @NotNull
        private volatile /* synthetic */ Object _originalNext = null;
        @NotNull
        @JvmField

        /* renamed from: b  reason: collision with root package name */
        public final LockFreeLinkedListNode f29364b;

        static {
            Class<RemoveFirstDesc> cls = RemoveFirstDesc.class;
            Class<Object> cls2 = Object.class;
            f29362c = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_affectedNode");
            f29363d = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_originalNext");
        }

        public RemoveFirstDesc(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            this.f29364b = lockFreeLinkedListNode;
        }

        public static /* synthetic */ void p() {
        }

        /* access modifiers changed from: protected */
        @Nullable
        public Object e(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (lockFreeLinkedListNode == this.f29364b) {
                return LockFreeLinkedListKt.d();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public final void f(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
            LockFreeLinkedListNode unused = lockFreeLinkedListNode2.D0((OpDescriptor) null);
        }

        public void g(@NotNull PrepareOp prepareOp) {
            a.a(f29362c, this, (Object) null, prepareOp.f29359a);
            a.a(f29363d, this, (Object) null, prepareOp.f29360b);
        }

        /* access modifiers changed from: protected */
        @Nullable
        public final LockFreeLinkedListNode h() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        /* access modifiers changed from: protected */
        @Nullable
        public final LockFreeLinkedListNode i() {
            return (LockFreeLinkedListNode) this._originalNext;
        }

        /* access modifiers changed from: protected */
        public final boolean l(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Object obj) {
            if (!(obj instanceof Removed)) {
                return false;
            }
            ((Removed) obj).f29389a.M0();
            return true;
        }

        /* access modifiers changed from: protected */
        @Nullable
        public final LockFreeLinkedListNode m(@NotNull OpDescriptor opDescriptor) {
            LockFreeLinkedListNode lockFreeLinkedListNode = this.f29364b;
            while (true) {
                Object obj = lockFreeLinkedListNode._next;
                if (!(obj instanceof OpDescriptor)) {
                    return (LockFreeLinkedListNode) obj;
                }
                OpDescriptor opDescriptor2 = (OpDescriptor) obj;
                if (opDescriptor.b(opDescriptor2)) {
                    return null;
                }
                opDescriptor2.c(this.f29364b);
            }
        }

        @NotNull
        public final Object n(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
            return lockFreeLinkedListNode2.U0();
        }

        public final T o() {
            T h2 = h();
            Intrinsics.m(h2);
            return h2;
        }
    }

    static {
        Class<LockFreeLinkedListNode> cls = LockFreeLinkedListNode.class;
        Class<Object> cls2 = Object.class;
        s = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_next");
        X = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_prev");
        Y = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_removedRef");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: kotlinx.coroutines.internal.OpDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: kotlinx.coroutines.internal.LockFreeLinkedListNode} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (androidx.concurrent.futures.a.a(s, r3, r2, ((kotlinx.coroutines.internal.Removed) r4).f29389a) != false) goto L_0x004b;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.coroutines.internal.LockFreeLinkedListNode D0(kotlinx.coroutines.internal.OpDescriptor r8) {
        /*
            r7 = this;
        L_0x0000:
            java.lang.Object r0 = r7._prev
            kotlinx.coroutines.internal.LockFreeLinkedListNode r0 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r0
            r1 = 0
            r2 = r0
        L_0x0006:
            r3 = r1
        L_0x0007:
            java.lang.Object r4 = r2._next
            if (r4 != r7) goto L_0x0018
            if (r0 != r2) goto L_0x000e
            return r2
        L_0x000e:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = X
            boolean r0 = androidx.concurrent.futures.a.a(r1, r7, r0, r2)
            if (r0 != 0) goto L_0x0017
            goto L_0x0000
        L_0x0017:
            return r2
        L_0x0018:
            boolean r5 = r7.N0()
            if (r5 == 0) goto L_0x001f
            return r1
        L_0x001f:
            if (r4 != r8) goto L_0x0022
            return r2
        L_0x0022:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.OpDescriptor
            if (r5 == 0) goto L_0x0038
            if (r8 == 0) goto L_0x0032
            r0 = r4
            kotlinx.coroutines.internal.OpDescriptor r0 = (kotlinx.coroutines.internal.OpDescriptor) r0
            boolean r0 = r8.b(r0)
            if (r0 == 0) goto L_0x0032
            return r1
        L_0x0032:
            kotlinx.coroutines.internal.OpDescriptor r4 = (kotlinx.coroutines.internal.OpDescriptor) r4
            r4.c(r2)
            goto L_0x0000
        L_0x0038:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.Removed
            if (r5 == 0) goto L_0x0052
            if (r3 == 0) goto L_0x004d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = s
            kotlinx.coroutines.internal.Removed r4 = (kotlinx.coroutines.internal.Removed) r4
            kotlinx.coroutines.internal.LockFreeLinkedListNode r4 = r4.f29389a
            boolean r2 = androidx.concurrent.futures.a.a(r5, r3, r2, r4)
            if (r2 != 0) goto L_0x004b
            goto L_0x0000
        L_0x004b:
            r2 = r3
            goto L_0x0006
        L_0x004d:
            java.lang.Object r2 = r2._prev
            kotlinx.coroutines.internal.LockFreeLinkedListNode r2 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r2
            goto L_0x0007
        L_0x0052:
            r3 = r4
            kotlinx.coroutines.internal.LockFreeLinkedListNode r3 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r3
            r6 = r3
            r3 = r2
            r2 = r6
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.LockFreeLinkedListNode.D0(kotlinx.coroutines.internal.OpDescriptor):kotlinx.coroutines.internal.LockFreeLinkedListNode");
    }

    private final LockFreeLinkedListNode G0(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.N0()) {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) lockFreeLinkedListNode._prev;
        }
        return lockFreeLinkedListNode;
    }

    /* access modifiers changed from: private */
    public final void H0(LockFreeLinkedListNode lockFreeLinkedListNode) {
        LockFreeLinkedListNode lockFreeLinkedListNode2;
        do {
            lockFreeLinkedListNode2 = (LockFreeLinkedListNode) lockFreeLinkedListNode._prev;
            if (I0() != lockFreeLinkedListNode) {
                return;
            }
        } while (!a.a(X, lockFreeLinkedListNode, lockFreeLinkedListNode2, this));
        if (N0()) {
            lockFreeLinkedListNode.D0((OpDescriptor) null);
        }
    }

    /* access modifiers changed from: private */
    public final Removed U0() {
        Removed removed = (Removed) this._removedRef;
        if (removed != null) {
            return removed;
        }
        Removed removed2 = new Removed(this);
        Y.lazySet(this, removed2);
        return removed2;
    }

    public final boolean A0(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Function1<? super LockFreeLinkedListNode, Boolean> function1, @NotNull Function0<Boolean> function0) {
        int V0;
        LockFreeLinkedListNode$makeCondAddOp$1 lockFreeLinkedListNode$makeCondAddOp$1 = new LockFreeLinkedListNode$makeCondAddOp$1(lockFreeLinkedListNode, function0);
        do {
            LockFreeLinkedListNode K0 = K0();
            if (!function1.f(K0).booleanValue()) {
                return false;
            }
            V0 = K0.V0(lockFreeLinkedListNode, this, lockFreeLinkedListNode$makeCondAddOp$1);
            if (V0 == 1) {
                return true;
            }
        } while (V0 != 2);
        return false;
    }

    @PublishedApi
    public final boolean B0(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
        X.lazySet(lockFreeLinkedListNode, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = s;
        atomicReferenceFieldUpdater.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        if (!a.a(atomicReferenceFieldUpdater, this, lockFreeLinkedListNode2, lockFreeLinkedListNode)) {
            return false;
        }
        lockFreeLinkedListNode.H0(lockFreeLinkedListNode2);
        return true;
    }

    public final boolean C0(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        X.lazySet(lockFreeLinkedListNode, this);
        s.lazySet(lockFreeLinkedListNode, this);
        while (I0() == this) {
            if (a.a(s, this, this, lockFreeLinkedListNode)) {
                lockFreeLinkedListNode.H0(this);
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final <T extends LockFreeLinkedListNode> AddLastDesc<T> E0(@NotNull T t) {
        return new AddLastDesc<>(this, t);
    }

    @NotNull
    public final RemoveFirstDesc<LockFreeLinkedListNode> F0() {
        return new RemoveFirstDesc<>(this);
    }

    @NotNull
    public final Object I0() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).c(this);
        }
    }

    @NotNull
    public final LockFreeLinkedListNode J0() {
        return LockFreeLinkedListKt.h(I0());
    }

    @NotNull
    public final LockFreeLinkedListNode K0() {
        LockFreeLinkedListNode D0 = D0((OpDescriptor) null);
        return D0 == null ? G0((LockFreeLinkedListNode) this._prev) : D0;
    }

    public final void L0() {
        ((Removed) I0()).f29389a.M0();
    }

    @PublishedApi
    public final void M0() {
        LockFreeLinkedListNode lockFreeLinkedListNode = this;
        while (true) {
            Object I0 = lockFreeLinkedListNode.I0();
            if (I0 instanceof Removed) {
                lockFreeLinkedListNode = ((Removed) I0).f29389a;
            } else {
                lockFreeLinkedListNode.D0((OpDescriptor) null);
                return;
            }
        }
    }

    public boolean N0() {
        return I0() instanceof Removed;
    }

    @NotNull
    @PublishedApi
    public final CondAddOp O0(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Function0<Boolean> function0) {
        return new LockFreeLinkedListNode$makeCondAddOp$1(lockFreeLinkedListNode, function0);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public LockFreeLinkedListNode P0() {
        Object I0 = I0();
        Removed removed = I0 instanceof Removed ? (Removed) I0 : null;
        if (removed != null) {
            return removed.f29389a;
        }
        return null;
    }

    public boolean Q0() {
        return T0() == null;
    }

    public final /* synthetic */ <T> T R0(Function1<? super T, Boolean> function1) {
        LockFreeLinkedListNode T0;
        while (true) {
            T t = (LockFreeLinkedListNode) I0();
            if (t == this) {
                return null;
            }
            Intrinsics.y(3, ExifInterface.d5);
            if (!(t instanceof Object)) {
                return null;
            }
            if ((function1.f(t).booleanValue() && !t.N0()) || (T0 = t.T0()) == null) {
                return t;
            }
            T0.M0();
        }
    }

    @Nullable
    public final LockFreeLinkedListNode S0() {
        while (true) {
            LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) I0();
            if (lockFreeLinkedListNode == this) {
                return null;
            }
            if (lockFreeLinkedListNode.Q0()) {
                return lockFreeLinkedListNode;
            }
            lockFreeLinkedListNode.L0();
        }
    }

    @Nullable
    @PublishedApi
    public final LockFreeLinkedListNode T0() {
        Object I0;
        LockFreeLinkedListNode lockFreeLinkedListNode;
        do {
            I0 = I0();
            if (I0 instanceof Removed) {
                return ((Removed) I0).f29389a;
            }
            if (I0 == this) {
                return (LockFreeLinkedListNode) I0;
            }
            lockFreeLinkedListNode = (LockFreeLinkedListNode) I0;
        } while (!a.a(s, this, I0, lockFreeLinkedListNode.U0()));
        lockFreeLinkedListNode.D0((OpDescriptor) null);
        return null;
    }

    @PublishedApi
    public final int V0(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2, @NotNull CondAddOp condAddOp) {
        X.lazySet(lockFreeLinkedListNode, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = s;
        atomicReferenceFieldUpdater.lazySet(lockFreeLinkedListNode, lockFreeLinkedListNode2);
        condAddOp.f29358c = lockFreeLinkedListNode2;
        if (!a.a(atomicReferenceFieldUpdater, this, lockFreeLinkedListNode2, condAddOp)) {
            return 0;
        }
        return condAddOp.c(this) == null ? 1 : 2;
    }

    public final void W0(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode2) {
    }

    @NotNull
    public String toString() {
        return new LockFreeLinkedListNode$toString$1(this) + '@' + DebugStringsKt.b(this);
    }

    public final void x0(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        do {
        } while (!K0().B0(lockFreeLinkedListNode, this));
    }

    public final boolean y0(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Function0<Boolean> function0) {
        int V0;
        LockFreeLinkedListNode$makeCondAddOp$1 lockFreeLinkedListNode$makeCondAddOp$1 = new LockFreeLinkedListNode$makeCondAddOp$1(lockFreeLinkedListNode, function0);
        do {
            V0 = K0().V0(lockFreeLinkedListNode, this, lockFreeLinkedListNode$makeCondAddOp$1);
            if (V0 == 1) {
                return true;
            }
        } while (V0 != 2);
        return false;
    }

    public final boolean z0(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode, @NotNull Function1<? super LockFreeLinkedListNode, Boolean> function1) {
        LockFreeLinkedListNode K0;
        do {
            K0 = K0();
            if (!function1.f(K0).booleanValue()) {
                return false;
            }
        } while (!K0.B0(lockFreeLinkedListNode, this));
        return true;
    }
}
