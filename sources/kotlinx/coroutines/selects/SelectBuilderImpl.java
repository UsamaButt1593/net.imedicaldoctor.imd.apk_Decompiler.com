package kotlinx.coroutines.selects;

import androidx.concurrent.futures.a;
import com.dd.plist.ASCIIPropertyListParser;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellingNode;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@PublishedApi
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\u00060\u0006j\u0002`\u0007:\u0004[\\]^B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\t\u0010\nJ.\u0010\u0010\u001a\u00020\u000e2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bH\b¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0017\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J \u0010\u001b\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0011\u0010!\u001a\u0004\u0018\u00010\fH\u0001¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u001dH\u0001¢\u0006\u0004\b$\u0010 J\u0017\u0010'\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u001b\u0010.\u001a\u0004\u0018\u00010\f2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016¢\u0006\u0004\b.\u0010/J\u0019\u00102\u001a\u0004\u0018\u00010\f2\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J\u000f\u00105\u001a\u000204H\u0016¢\u0006\u0004\b5\u00106J5\u00109\u001a\u00020\u000e*\u0002072\u001c\u0010\u000f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\f08H\u0002ø\u0001\u0000¢\u0006\u0004\b9\u0010:JG\u0010>\u001a\u00020\u000e\"\u0004\b\u0001\u0010;*\b\u0012\u0004\u0012\u00028\u00010<2\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\f0=H\u0002ø\u0001\u0000¢\u0006\u0004\b>\u0010?J[\u0010C\u001a\u00020\u000e\"\u0004\b\u0001\u0010@\"\u0004\b\u0002\u0010;*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020A2\u0006\u0010B\u001a\u00028\u00012\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\f0=H\u0002ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ8\u0010G\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020E2\u001c\u0010\u000f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\f08H\u0016ø\u0001\u0000¢\u0006\u0004\bG\u0010HR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR(\u0010N\u001a\u0004\u0018\u00010%2\b\u0010\r\u001a\u0004\u0018\u00010%8B@BX\u000e¢\u0006\f\u001a\u0004\bK\u0010L\"\u0004\bM\u0010(R\u001c\u0010Q\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078VX\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0014\u0010U\u001a\u00020R8VX\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u001a\u0010X\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058VX\u0004¢\u0006\u0006\u001a\u0004\bV\u0010WR\u0014\u0010Z\u001a\u00020)8VX\u0004¢\u0006\u0006\u001a\u0004\bY\u0010+\u0002\u0004\n\u0002\b\u0019¨\u0006_"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl;", "R", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "uCont", "<init>", "(Lkotlin/coroutines/Continuation;)V", "Lkotlin/Function0;", "", "value", "", "block", "d1", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "W", "()V", "c1", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "K", "()Ljava/lang/StackTraceElement;", "Lkotlin/Result;", "result", "w", "(Ljava/lang/Object;)V", "", "exception", "g0", "(Ljava/lang/Throwable;)V", "f1", "()Ljava/lang/Object;", "e", "g1", "Lkotlinx/coroutines/DisposableHandle;", "handle", "p0", "(Lkotlinx/coroutines/DisposableHandle;)V", "", "y", "()Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "i", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/AtomicDesc;", "desc", "i0", "(Lkotlinx/coroutines/internal/AtomicDesc;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/selects/SelectClause0;", "Lkotlin/Function1;", "h", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "q0", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "G", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "timeMillis", "U", "(JLkotlin/jvm/functions/Function1;)V", "Z", "Lkotlin/coroutines/Continuation;", "e1", "()Lkotlinx/coroutines/DisposableHandle;", "h1", "parentHandle", "j", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", "g", "()Lkotlin/coroutines/CoroutineContext;", "context", "J", "()Lkotlin/coroutines/Continuation;", "completion", "I", "isSelected", "AtomicSelectOp", "DisposeNode", "PairSelectOp", "SelectOnCancelling", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class SelectBuilderImpl<R> extends LockFreeLinkedListHead implements SelectBuilder<R>, SelectInstance<R>, Continuation<R>, CoroutineStackFrame {
    static final /* synthetic */ AtomicReferenceFieldUpdater X2;
    private static final /* synthetic */ AtomicReferenceFieldUpdater Y2;
    @NotNull
    private final Continuation<R> Z;
    @NotNull
    private volatile /* synthetic */ Object _parentHandle = null;
    @NotNull
    private volatile /* synthetic */ Object _result = SelectKt.f29439c;
    @NotNull
    volatile /* synthetic */ Object _state = SelectKt.f();

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u001b\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00038\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010!\u001a\u00020\u001d8\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$AtomicSelectOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "", "Lkotlinx/coroutines/selects/SelectBuilderImpl;", "impl", "Lkotlinx/coroutines/internal/AtomicDesc;", "desc", "<init>", "(Lkotlinx/coroutines/selects/SelectBuilderImpl;Lkotlinx/coroutines/internal/AtomicDesc;)V", "k", "()Ljava/lang/Object;", "", "l", "()V", "failure", "j", "(Ljava/lang/Object;)V", "affected", "i", "(Ljava/lang/Object;)Ljava/lang/Object;", "d", "(Ljava/lang/Object;Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "b", "Lkotlinx/coroutines/selects/SelectBuilderImpl;", "c", "Lkotlinx/coroutines/internal/AtomicDesc;", "", "J", "g", "()J", "opSequence", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class AtomicSelectOp extends AtomicOp<Object> {
        @NotNull
        @JvmField

        /* renamed from: b  reason: collision with root package name */
        public final SelectBuilderImpl<?> f29433b;
        @NotNull
        @JvmField

        /* renamed from: c  reason: collision with root package name */
        public final AtomicDesc f29434c;

        /* renamed from: d  reason: collision with root package name */
        private final long f29435d = SelectKt.f29441e.a();

        public AtomicSelectOp(@NotNull SelectBuilderImpl<?> selectBuilderImpl, @NotNull AtomicDesc atomicDesc) {
            this.f29433b = selectBuilderImpl;
            this.f29434c = atomicDesc;
            atomicDesc.d(this);
        }

        private final void j(Object obj) {
            boolean z = obj == null;
            if (a.a(SelectBuilderImpl.X2, this.f29433b, this, z ? null : SelectKt.f()) && z) {
                this.f29433b.c1();
            }
        }

        private final Object k() {
            SelectBuilderImpl<?> selectBuilderImpl = this.f29433b;
            while (true) {
                Object obj = selectBuilderImpl._state;
                if (obj == this) {
                    return null;
                }
                if (obj instanceof OpDescriptor) {
                    ((OpDescriptor) obj).c(this.f29433b);
                } else if (obj != SelectKt.f()) {
                    return SelectKt.d();
                } else {
                    if (a.a(SelectBuilderImpl.X2, this.f29433b, SelectKt.f(), this)) {
                        return null;
                    }
                }
            }
        }

        private final void l() {
            a.a(SelectBuilderImpl.X2, this.f29433b, this, SelectKt.f());
        }

        public void d(@Nullable Object obj, @Nullable Object obj2) {
            j(obj2);
            this.f29434c.a(this, obj2);
        }

        public long g() {
            return this.f29435d;
        }

        @Nullable
        public Object i(@Nullable Object obj) {
            Object k2;
            if (obj == null && (k2 = k()) != null) {
                return k2;
            }
            try {
                return this.f29434c.c(this);
            } catch (Throwable th) {
                if (obj == null) {
                    l();
                }
                throw th;
            }
        }

        @NotNull
        public String toString() {
            return "AtomicSelectOp(sequence=" + g() + ASCIIPropertyListParser.f18650h;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$DisposeNode;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/DisposableHandle;", "handle", "<init>", "(Lkotlinx/coroutines/DisposableHandle;)V", "Z", "Lkotlinx/coroutines/DisposableHandle;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class DisposeNode extends LockFreeLinkedListNode {
        @NotNull
        @JvmField
        public final DisposableHandle Z;

        public DisposeNode(@NotNull DisposableHandle disposableHandle) {
            this.Z = disposableHandle;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\r¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$PairSelectOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "", "affected", "c", "(Ljava/lang/Object;)Ljava/lang/Object;", "a", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "()Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class PairSelectOp extends OpDescriptor {
        @NotNull
        @JvmField

        /* renamed from: a  reason: collision with root package name */
        public final LockFreeLinkedListNode.PrepareOp f29436a;

        public PairSelectOp(@NotNull LockFreeLinkedListNode.PrepareOp prepareOp) {
            this.f29436a = prepareOp;
        }

        @NotNull
        public AtomicOp<?> a() {
            return this.f29436a.a();
        }

        @Nullable
        public Object c(@Nullable Object obj) {
            if (obj != null) {
                SelectBuilderImpl selectBuilderImpl = (SelectBuilderImpl) obj;
                this.f29436a.d();
                Object e2 = this.f29436a.a().e((Object) null);
                a.a(SelectBuilderImpl.X2, selectBuilderImpl, this, e2 == null ? this.f29436a.f29361c : SelectKt.f());
                return e2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.selects.SelectBuilderImpl<*>");
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$SelectOnCancelling;", "Lkotlinx/coroutines/JobCancellingNode;", "<init>", "(Lkotlinx/coroutines/selects/SelectBuilderImpl;)V", "", "cause", "", "X0", "(Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private final class SelectOnCancelling extends JobCancellingNode {
        public SelectOnCancelling() {
        }

        public void X0(@Nullable Throwable th) {
            if (SelectBuilderImpl.this.y()) {
                SelectBuilderImpl.this.g0(Y0().I());
            }
        }

        public /* bridge */ /* synthetic */ Object f(Object obj) {
            X0((Throwable) obj);
            return Unit.f28779a;
        }
    }

    static {
        Class<SelectBuilderImpl> cls = SelectBuilderImpl.class;
        Class<Object> cls2 = Object.class;
        X2 = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_state");
        Y2 = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_result");
    }

    public SelectBuilderImpl(@NotNull Continuation<? super R> continuation) {
        this.Z = continuation;
    }

    private final void W() {
        Job job = (Job) g().e(Job.P2);
        if (job != null) {
            DisposableHandle f2 = Job.DefaultImpls.f(job, true, false, new SelectOnCancelling(), 2, (Object) null);
            h1(f2);
            if (I()) {
                f2.m();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void c1() {
        DisposableHandle e1 = e1();
        if (e1 != null) {
            e1.m();
        }
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) I0(); !Intrinsics.g(lockFreeLinkedListNode, this); lockFreeLinkedListNode = lockFreeLinkedListNode.J0()) {
            if (lockFreeLinkedListNode instanceof DisposeNode) {
                ((DisposeNode) lockFreeLinkedListNode).Z.m();
            }
        }
    }

    private final void d1(Function0<? extends Object> function0, Function0<Unit> function02) {
        while (true) {
            Object obj = this._result;
            if (obj == SelectKt.f29439c) {
                if (a.a(Y2, this, SelectKt.f29439c, function0.o())) {
                    return;
                }
            } else if (obj != IntrinsicsKt.l()) {
                throw new IllegalStateException("Already resumed");
            } else if (a.a(Y2, this, IntrinsicsKt.l(), SelectKt.f29440d)) {
                function02.o();
                return;
            }
        }
    }

    private final DisposableHandle e1() {
        return (DisposableHandle) this._parentHandle;
    }

    private final void h1(DisposableHandle disposableHandle) {
        this._parentHandle = disposableHandle;
    }

    public <P, Q> void G(@NotNull SelectClause2<? super P, ? extends Q> selectClause2, P p, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        selectClause2.b0(this, p, function2);
    }

    public boolean I() {
        while (true) {
            Object obj = this._state;
            if (obj == SelectKt.f()) {
                return false;
            }
            if (!(obj instanceof OpDescriptor)) {
                return true;
            }
            ((OpDescriptor) obj).c(this);
        }
    }

    @NotNull
    public Continuation<R> J() {
        return this;
    }

    @Nullable
    public StackTraceElement K() {
        return null;
    }

    public void U(long j2, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        if (j2 > 0) {
            p0(DelayKt.d(g()).N(j2, new SelectBuilderImpl$onTimeout$$inlined$Runnable$1(this, function1), g()));
        } else if (y()) {
            UndispatchedKt.c(function1, J());
        }
    }

    @Nullable
    @PublishedApi
    public final Object f1() {
        if (!I()) {
            W();
        }
        Object obj = this._result;
        if (obj == SelectKt.f29439c) {
            if (a.a(Y2, this, SelectKt.f29439c, IntrinsicsKt.l())) {
                return IntrinsicsKt.l();
            }
            obj = this._result;
        }
        if (obj == SelectKt.f29440d) {
            throw new IllegalStateException("Already resumed");
        } else if (!(obj instanceof CompletedExceptionally)) {
            return obj;
        } else {
            throw ((CompletedExceptionally) obj).f29164a;
        }
    }

    @NotNull
    public CoroutineContext g() {
        return this.Z.g();
    }

    public void g0(@NotNull Throwable th) {
        while (true) {
            Object obj = this._result;
            if (obj == SelectKt.f29439c) {
                if (a.a(Y2, this, SelectKt.f29439c, new CompletedExceptionally(th, false, 2, (DefaultConstructorMarker) null))) {
                    return;
                }
            } else if (obj != IntrinsicsKt.l()) {
                throw new IllegalStateException("Already resumed");
            } else if (a.a(Y2, this, IntrinsicsKt.l(), SelectKt.f29440d)) {
                Continuation<R> e2 = IntrinsicsKt.e(this.Z);
                Result.Companion companion = Result.X;
                e2.w(Result.b(ResultKt.a(th)));
                return;
            }
        }
    }

    @PublishedApi
    public final void g1(@NotNull Throwable th) {
        if (y()) {
            Result.Companion companion = Result.X;
            w(Result.b(ResultKt.a(th)));
        } else if (!(th instanceof CancellationException)) {
            Object f1 = f1();
            if (!(f1 instanceof CompletedExceptionally) || ((CompletedExceptionally) f1).f29164a != th) {
                CoroutineExceptionHandlerKt.b(g(), th);
            }
        }
    }

    public void h(@NotNull SelectClause0 selectClause0, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        selectClause0.C(this, function1);
    }

    @Nullable
    public Object i(@Nullable LockFreeLinkedListNode.PrepareOp prepareOp) {
        while (true) {
            Object obj = this._state;
            if (obj == SelectKt.f()) {
                if (prepareOp == null) {
                    if (a.a(X2, this, SelectKt.f(), (Object) null)) {
                        break;
                    }
                } else {
                    PairSelectOp pairSelectOp = new PairSelectOp(prepareOp);
                    if (a.a(X2, this, SelectKt.f(), pairSelectOp)) {
                        Object c2 = pairSelectOp.c(this);
                        if (c2 != null) {
                            return c2;
                        }
                    }
                }
            } else if (obj instanceof OpDescriptor) {
                if (prepareOp != null) {
                    AtomicOp<?> a2 = prepareOp.a();
                    if ((a2 instanceof AtomicSelectOp) && ((AtomicSelectOp) a2).f29433b == this) {
                        throw new IllegalStateException("Cannot use matching select clauses on the same object".toString());
                    } else if (a2.b((OpDescriptor) obj)) {
                        return AtomicKt.f29332b;
                    }
                }
                ((OpDescriptor) obj).c(this);
            } else if (prepareOp != null && obj == prepareOp.f29361c) {
                return CancellableContinuationImplKt.f29156d;
            } else {
                return null;
            }
        }
        c1();
        return CancellableContinuationImplKt.f29156d;
    }

    @Nullable
    public Object i0(@NotNull AtomicDesc atomicDesc) {
        return new AtomicSelectOp(this, atomicDesc).c((Object) null);
    }

    @Nullable
    public CoroutineStackFrame j() {
        Continuation<R> continuation = this.Z;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    public <P, Q> void l(@NotNull SelectClause2<? super P, ? extends Q> selectClause2, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        SelectBuilder.DefaultImpls.a(this, selectClause2, function2);
    }

    public void p0(@NotNull DisposableHandle disposableHandle) {
        DisposeNode disposeNode = new DisposeNode(disposableHandle);
        if (!I()) {
            x0(disposeNode);
            if (!I()) {
                return;
            }
        }
        disposableHandle.m();
    }

    public <Q> void q0(@NotNull SelectClause1<? extends Q> selectClause1, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        selectClause1.h(this, function2);
    }

    @NotNull
    public String toString() {
        return "SelectInstance(state=" + this._state + ", result=" + this._result + ASCIIPropertyListParser.f18650h;
    }

    public void w(@NotNull Object obj) {
        Continuation<R> continuation;
        while (true) {
            Object obj2 = this._result;
            if (obj2 == SelectKt.f29439c) {
                if (a.a(Y2, this, SelectKt.f29439c, CompletionStateKt.d(obj, (Function1) null, 1, (Object) null))) {
                    return;
                }
            } else if (obj2 != IntrinsicsKt.l()) {
                throw new IllegalStateException("Already resumed");
            } else if (a.a(Y2, this, IntrinsicsKt.l(), SelectKt.f29440d)) {
                if (Result.i(obj)) {
                    continuation = this.Z;
                    Throwable e2 = Result.e(obj);
                    Intrinsics.m(e2);
                    Result.Companion companion = Result.X;
                    obj = Result.b(ResultKt.a(e2));
                } else {
                    continuation = this.Z;
                }
                continuation.w(obj);
                return;
            }
        }
    }

    public boolean y() {
        Object i2 = i((LockFreeLinkedListNode.PrepareOp) null);
        if (i2 == CancellableContinuationImplKt.f29156d) {
            return true;
        }
        if (i2 == null) {
            return false;
        }
        throw new IllegalStateException(("Unexpected trySelectIdempotent result " + i2).toString());
    }
}
