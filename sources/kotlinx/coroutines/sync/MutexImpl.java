package kotlinx.coroutines.sync;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00010\u0002:\u0006%&'()*B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0003H@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000e\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000bJT\u0010\u0015\u001a\u00020\t\"\u0004\b\u0000\u0010\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u00032\"\u0010\u0014\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\rJ\u0019\u0010\u0018\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\"\u0010$\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlinx/coroutines/selects/SelectClause2;", "", "", "locked", "<init>", "(Z)V", "owner", "", "i", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "(Ljava/lang/Object;)Z", "c", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "block", "b0", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "e", "d", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "b", "()Z", "isLocked", "h", "isLockedEmptyQueueState", "f", "()Lkotlinx/coroutines/selects/SelectClause2;", "onLock", "LockCont", "LockSelect", "LockWaiter", "LockedQueue", "TryLockDesc", "UnlockOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class MutexImpl implements Mutex, SelectClause2<Object, Mutex> {
    static final /* synthetic */ AtomicReferenceFieldUpdater s = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "_state");
    @NotNull
    volatile /* synthetic */ Object _state;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u001f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockCont;", "Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/sync/MutexImpl;", "", "owner", "Lkotlinx/coroutines/CancellableContinuation;", "", "cont", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "", "Z0", "()Z", "X0", "()V", "", "toString", "()Ljava/lang/String;", "Z2", "Lkotlinx/coroutines/CancellableContinuation;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private final class LockCont extends LockWaiter {
        @NotNull
        private final CancellableContinuation<Unit> Z2;

        public LockCont(@Nullable Object obj, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
            super(obj);
            this.Z2 = cancellableContinuation;
        }

        public void X0() {
            this.Z2.u0(CancellableContinuationImplKt.f29156d);
        }

        public boolean Z0() {
            return Y0() && this.Z2.P(Unit.f28779a, (Object) null, new MutexImpl$LockCont$tryResumeLockWaiter$1(MutexImpl.this, this)) != null;
        }

        @NotNull
        public String toString() {
            return "LockCont[" + this.Z + ", " + this.Z2 + "] for " + MutexImpl.this;
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002R\u00020\u0003BF\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R3\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\b8\u0006X\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockSelect;", "R", "Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/sync/MutexImpl;", "", "owner", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlin/coroutines/Continuation;", "block", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "", "Z0", "()Z", "", "X0", "()V", "", "toString", "()Ljava/lang/String;", "Z2", "Lkotlinx/coroutines/selects/SelectInstance;", "a3", "Lkotlin/jvm/functions/Function2;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private final class LockSelect<R> extends LockWaiter {
        @NotNull
        @JvmField
        public final SelectInstance<R> Z2;
        @NotNull
        @JvmField
        public final Function2<Mutex, Continuation<? super R>, Object> a3;

        public LockSelect(@Nullable Object obj, @NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super Mutex, ? super Continuation<? super R>, ? extends Object> function2) {
            super(obj);
            this.Z2 = selectInstance;
            this.a3 = function2;
        }

        public void X0() {
            CancellableKt.e(this.a3, MutexImpl.this, this.Z2.J(), new MutexImpl$LockSelect$completeResumeLockWaiter$1(MutexImpl.this, this));
        }

        public boolean Z0() {
            return Y0() && this.Z2.y();
        }

        @NotNull
        public String toString() {
            return "LockSelect[" + this.Z + ", " + this.Z2 + "] for " + MutexImpl.this;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b¢\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\tJ\u000f\u0010\u000e\u001a\u00020\nH&¢\u0006\u0004\b\u000e\u0010\fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/DisposableHandle;", "", "owner", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;)V", "", "Y0", "()Z", "", "m", "()V", "Z0", "X0", "Z", "Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private abstract class LockWaiter extends LockFreeLinkedListNode implements DisposableHandle {
        private static final /* synthetic */ AtomicIntegerFieldUpdater Y2 = AtomicIntegerFieldUpdater.newUpdater(LockWaiter.class, "isTaken");
        @Nullable
        @JvmField
        public final Object Z;
        @NotNull
        private volatile /* synthetic */ int isTaken = 0;

        public LockWaiter(@Nullable Object obj) {
            this.Z = obj;
        }

        public abstract void X0();

        public final boolean Y0() {
            return Y2.compareAndSet(this, 0, 1);
        }

        public abstract boolean Z0();

        public final void m() {
            Q0();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "owner", "", "(Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class LockedQueue extends LockFreeLinkedListHead {
        @NotNull
        @JvmField
        public volatile Object owner;

        public LockedQueue(@NotNull Object obj) {
            this.owner = obj;
        }

        @NotNull
        public String toString() {
            return "LockedQueue[" + this.owner + ']';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u0004\u0018\u00010\u00042\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000e\u001a\u00020\r2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0012¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc;", "Lkotlinx/coroutines/internal/AtomicDesc;", "Lkotlinx/coroutines/sync/MutexImpl;", "mutex", "", "owner", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;)V", "Lkotlinx/coroutines/internal/AtomicOp;", "op", "c", "(Lkotlinx/coroutines/internal/AtomicOp;)Ljava/lang/Object;", "failure", "", "a", "(Lkotlinx/coroutines/internal/AtomicOp;Ljava/lang/Object;)V", "b", "Lkotlinx/coroutines/sync/MutexImpl;", "Ljava/lang/Object;", "PrepareOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class TryLockDesc extends AtomicDesc {
        @NotNull
        @JvmField

        /* renamed from: b  reason: collision with root package name */
        public final MutexImpl f29444b;
        @Nullable
        @JvmField

        /* renamed from: c  reason: collision with root package name */
        public final Object f29445c;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc$PrepareOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc;Lkotlinx/coroutines/internal/AtomicOp;)V", "", "affected", "c", "(Ljava/lang/Object;)Ljava/lang/Object;", "a", "Lkotlinx/coroutines/internal/AtomicOp;", "()Lkotlinx/coroutines/internal/AtomicOp;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
        private final class PrepareOp extends OpDescriptor {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            private final AtomicOp<?> f29446a;

            public PrepareOp(@NotNull AtomicOp<?> atomicOp) {
                this.f29446a = atomicOp;
            }

            @NotNull
            public AtomicOp<?> a() {
                return this.f29446a;
            }

            @Nullable
            public Object c(@Nullable Object obj) {
                Object d2 = a().h() ? MutexKt.f29454f : a();
                if (obj != null) {
                    a.a(MutexImpl.s, (MutexImpl) obj, this, d2);
                    return null;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.sync.MutexImpl");
            }
        }

        public TryLockDesc(@NotNull MutexImpl mutexImpl, @Nullable Object obj) {
            this.f29444b = mutexImpl;
            this.f29445c = obj;
        }

        public void a(@NotNull AtomicOp<?> atomicOp, @Nullable Object obj) {
            Empty empty;
            if (obj != null) {
                empty = MutexKt.f29454f;
            } else {
                Object obj2 = this.f29445c;
                empty = obj2 == null ? MutexKt.f29453e : new Empty(obj2);
            }
            a.a(MutexImpl.s, this.f29444b, atomicOp, empty);
        }

        @Nullable
        public Object c(@NotNull AtomicOp<?> atomicOp) {
            PrepareOp prepareOp = new PrepareOp(atomicOp);
            return !a.a(MutexImpl.s, this.f29444b, MutexKt.f29454f, prepareOp) ? MutexKt.f29449a : prepareOp.c(this.f29444b);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$UnlockOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/sync/MutexImpl;", "Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "queue", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;)V", "affected", "", "k", "(Lkotlinx/coroutines/sync/MutexImpl;)Ljava/lang/Object;", "failure", "", "j", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;)V", "b", "Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class UnlockOp extends AtomicOp<MutexImpl> {
        @NotNull
        @JvmField

        /* renamed from: b  reason: collision with root package name */
        public final LockedQueue f29448b;

        public UnlockOp(@NotNull LockedQueue lockedQueue) {
            this.f29448b = lockedQueue;
        }

        /* renamed from: j */
        public void d(@NotNull MutexImpl mutexImpl, @Nullable Object obj) {
            a.a(MutexImpl.s, mutexImpl, this, obj == null ? MutexKt.f29454f : this.f29448b);
        }

        @Nullable
        /* renamed from: k */
        public Object i(@NotNull MutexImpl mutexImpl) {
            if (this.f29448b.Y0()) {
                return null;
            }
            return MutexKt.f29450b;
        }
    }

    public MutexImpl(boolean z) {
        this._state = z ? MutexKt.f29453e : MutexKt.f29454f;
    }

    /* access modifiers changed from: private */
    public final Object i(Object obj, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl<? super Unit> b2 = CancellableContinuationKt.b(IntrinsicsKt.e(continuation));
        LockCont lockCont = new LockCont(obj, b2);
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof Empty) {
                Empty empty = (Empty) obj2;
                if (empty.f29443a != MutexKt.f29452d) {
                    a.a(s, this, obj2, new LockedQueue(empty.f29443a));
                } else {
                    if (a.a(s, this, obj2, obj == null ? MutexKt.f29453e : new Empty(obj))) {
                        b2.f0(Unit.f28779a, new MutexImpl$lockSuspend$2$1$1(this, obj));
                        break;
                    }
                }
            } else if (obj2 instanceof LockedQueue) {
                LockedQueue lockedQueue = (LockedQueue) obj2;
                if (lockedQueue.owner != obj) {
                    lockedQueue.x0(lockCont);
                    if (this._state == obj2 || !lockCont.Y0()) {
                        CancellableContinuationKt.c(b2, lockCont);
                    } else {
                        lockCont = new LockCont(obj, b2);
                    }
                } else {
                    throw new IllegalStateException(("Already locked by " + obj).toString());
                }
            } else if (obj2 instanceof OpDescriptor) {
                ((OpDescriptor) obj2).c(this);
            } else {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            }
        }
        Object y = b2.y();
        if (y == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        return y == IntrinsicsKt.l() ? y : Unit.f28779a;
    }

    public boolean a(@Nullable Object obj) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof Empty) {
                if (((Empty) obj2).f29443a != MutexKt.f29452d) {
                    return false;
                }
                if (a.a(s, this, obj2, obj == null ? MutexKt.f29453e : new Empty(obj))) {
                    return true;
                }
            } else if (obj2 instanceof LockedQueue) {
                if (((LockedQueue) obj2).owner != obj) {
                    return false;
                }
                throw new IllegalStateException(("Already locked by " + obj).toString());
            } else if (obj2 instanceof OpDescriptor) {
                ((OpDescriptor) obj2).c(this);
            } else {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            }
        }
    }

    public boolean b() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof Empty) {
                return ((Empty) obj).f29443a != MutexKt.f29452d;
            }
            if (obj instanceof LockedQueue) {
                return true;
            }
            if (obj instanceof OpDescriptor) {
                ((OpDescriptor) obj).c(this);
            } else {
                throw new IllegalStateException(("Illegal state " + obj).toString());
            }
        }
    }

    public <R> void b0(@NotNull SelectInstance<? super R> selectInstance, @Nullable Object obj, @NotNull Function2<? super Mutex, ? super Continuation<? super R>, ? extends Object> function2) {
        while (!selectInstance.I()) {
            Object obj2 = this._state;
            if (obj2 instanceof Empty) {
                Empty empty = (Empty) obj2;
                if (empty.f29443a != MutexKt.f29452d) {
                    a.a(s, this, obj2, new LockedQueue(empty.f29443a));
                } else {
                    Object i0 = selectInstance.i0(new TryLockDesc(this, obj));
                    if (i0 == null) {
                        UndispatchedKt.d(function2, this, selectInstance.J());
                        return;
                    } else if (i0 != SelectKt.d()) {
                        if (!(i0 == MutexKt.f29449a || i0 == AtomicKt.f29332b)) {
                            throw new IllegalStateException(("performAtomicTrySelect(TryLockDesc) returned " + i0).toString());
                        }
                    } else {
                        return;
                    }
                }
            } else if (obj2 instanceof LockedQueue) {
                LockedQueue lockedQueue = (LockedQueue) obj2;
                if (lockedQueue.owner != obj) {
                    LockSelect lockSelect = new LockSelect(obj, selectInstance, function2);
                    lockedQueue.x0(lockSelect);
                    if (this._state == obj2 || !lockSelect.Y0()) {
                        selectInstance.p0(lockSelect);
                        return;
                    }
                } else {
                    throw new IllegalStateException(("Already locked by " + obj).toString());
                }
            } else if (obj2 instanceof OpDescriptor) {
                ((OpDescriptor) obj2).c(this);
            } else {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            }
        }
    }

    @Nullable
    public Object c(@Nullable Object obj, @NotNull Continuation<? super Unit> continuation) {
        if (a(obj)) {
            return Unit.f28779a;
        }
        Object i2 = i(obj, continuation);
        return i2 == IntrinsicsKt.l() ? i2 : Unit.f28779a;
    }

    public void d(@Nullable Object obj) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof Empty) {
                Empty empty = (Empty) obj2;
                if (obj == null) {
                    if (empty.f29443a == MutexKt.f29452d) {
                        throw new IllegalStateException("Mutex is not locked".toString());
                    }
                } else if (empty.f29443a != obj) {
                    throw new IllegalStateException(("Mutex is locked by " + empty.f29443a + " but expected " + obj).toString());
                }
                if (a.a(s, this, obj2, MutexKt.f29454f)) {
                    return;
                }
            } else if (obj2 instanceof OpDescriptor) {
                ((OpDescriptor) obj2).c(this);
            } else if (obj2 instanceof LockedQueue) {
                if (obj != null) {
                    LockedQueue lockedQueue = (LockedQueue) obj2;
                    if (lockedQueue.owner != obj) {
                        throw new IllegalStateException(("Mutex is locked by " + lockedQueue.owner + " but expected " + obj).toString());
                    }
                }
                LockedQueue lockedQueue2 = (LockedQueue) obj2;
                LockFreeLinkedListNode S0 = lockedQueue2.S0();
                if (S0 == null) {
                    UnlockOp unlockOp = new UnlockOp(lockedQueue2);
                    if (a.a(s, this, obj2, unlockOp) && unlockOp.c(this) == null) {
                        return;
                    }
                } else {
                    LockWaiter lockWaiter = (LockWaiter) S0;
                    if (lockWaiter.Z0()) {
                        Object obj3 = lockWaiter.Z;
                        if (obj3 == null) {
                            obj3 = MutexKt.f29451c;
                        }
                        lockedQueue2.owner = obj3;
                        lockWaiter.X0();
                        return;
                    }
                }
            } else {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            }
        }
    }

    public boolean e(@NotNull Object obj) {
        Object obj2 = this._state;
        if (!(obj2 instanceof Empty)) {
            return (obj2 instanceof LockedQueue) && ((LockedQueue) obj2).owner == obj;
        }
        if (((Empty) obj2).f29443a == obj) {
            return true;
        }
    }

    @NotNull
    public SelectClause2<Object, Mutex> f() {
        return this;
    }

    public final boolean h() {
        Object obj = this._state;
        return (obj instanceof LockedQueue) && ((LockedQueue) obj).Y0();
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        Object obj;
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof Empty) {
                sb = new StringBuilder();
                sb.append("Mutex[");
                obj = ((Empty) obj2).f29443a;
                break;
            } else if (obj2 instanceof OpDescriptor) {
                ((OpDescriptor) obj2).c(this);
            } else if (obj2 instanceof LockedQueue) {
                sb = new StringBuilder();
                sb.append("Mutex[");
                obj = ((LockedQueue) obj2).owner;
            } else {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            }
        }
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }
}
