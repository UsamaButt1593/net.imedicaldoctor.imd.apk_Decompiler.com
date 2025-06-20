package kotlinx.coroutines.sync;

import androidx.concurrent.futures.a;
import com.google.common.util.concurrent.I;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\b\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\u00070\nH\u0002¢\u0006\u0004\b\u0011\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u0013\u0010\u0013\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\tJ\u000f\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0016R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00070\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001c\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/sync/SemaphoreImpl;", "Lkotlinx/coroutines/sync/Semaphore;", "", "permits", "acquiredPermits", "<init>", "(II)V", "", "h", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "", "i", "(Lkotlinx/coroutines/CancellableContinuation;)Z", "k", "()Z", "j", "d", "c", "a", "()V", "I", "Lkotlin/Function1;", "", "b", "Lkotlin/jvm/functions/Function1;", "onCancellationRelease", "()I", "availablePermits", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class SemaphoreImpl implements Semaphore {

    /* renamed from: c  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f29455c;

    /* renamed from: d  reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f29456d;

    /* renamed from: e  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f29457e;

    /* renamed from: f  reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f29458f;

    /* renamed from: g  reason: collision with root package name */
    static final /* synthetic */ AtomicIntegerFieldUpdater f29459g;
    @NotNull
    volatile /* synthetic */ int _availablePermits;

    /* renamed from: a  reason: collision with root package name */
    private final int f29460a;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final Function1<Throwable, Unit> f29461b;
    @NotNull
    private volatile /* synthetic */ long deqIdx = 0;
    @NotNull
    private volatile /* synthetic */ long enqIdx = 0;
    @NotNull
    private volatile /* synthetic */ Object head;
    @NotNull
    private volatile /* synthetic */ Object tail;

    static {
        Class<SemaphoreImpl> cls = SemaphoreImpl.class;
        Class<Object> cls2 = Object.class;
        f29455c = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "head");
        f29456d = AtomicLongFieldUpdater.newUpdater(cls, "deqIdx");
        f29457e = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "tail");
        f29458f = AtomicLongFieldUpdater.newUpdater(cls, "enqIdx");
        f29459g = AtomicIntegerFieldUpdater.newUpdater(cls, "_availablePermits");
    }

    public SemaphoreImpl(int i2, int i3) {
        this.f29460a = i2;
        if (i2 <= 0) {
            throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i2).toString());
        } else if (i3 < 0 || i3 > i2) {
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i2).toString());
        } else {
            SemaphoreSegment semaphoreSegment = new SemaphoreSegment(0, (SemaphoreSegment) null, 2);
            this.head = semaphoreSegment;
            this.tail = semaphoreSegment;
            this._availablePermits = i2 - i3;
            this.f29461b = new SemaphoreImpl$onCancellationRelease$1(this);
        }
    }

    /* access modifiers changed from: private */
    public final Object h(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl<? super Unit> b2 = CancellableContinuationKt.b(IntrinsicsKt.e(continuation));
        while (true) {
            if (!i(b2)) {
                if (f29459g.getAndDecrement(this) > 0) {
                    b2.f0(Unit.f28779a, this.f29461b);
                    break;
                }
            } else {
                break;
            }
        }
        Object y = b2.y();
        if (y == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        return y == IntrinsicsKt.l() ? y : Unit.f28779a;
    }

    /* access modifiers changed from: private */
    public final boolean i(CancellableContinuation<? super Unit> cancellableContinuation) {
        Segment segment;
        Segment segment2;
        Object b2;
        Segment segment3 = (SemaphoreSegment) this.tail;
        long andIncrement = f29458f.getAndIncrement(this);
        long h2 = andIncrement / ((long) SemaphoreKt.f29467f);
        loop0:
        while (true) {
            Segment segment4 = segment3;
            while (true) {
                if (segment4.o() >= h2 && !segment4.g()) {
                    segment2 = segment4;
                    break;
                }
                Object a2 = segment4.e();
                if (a2 == ConcurrentLinkedListKt.f29338b) {
                    segment2 = ConcurrentLinkedListKt.f29338b;
                    break;
                }
                Segment segment5 = (Segment) ((ConcurrentLinkedListNode) a2);
                if (segment5 == null) {
                    segment5 = SemaphoreKt.j(segment4.o() + 1, (SemaphoreSegment) segment4);
                    if (!segment4.m(segment5)) {
                        segment = segment4;
                        segment4 = segment;
                    } else if (segment4.g()) {
                        segment4.l();
                    }
                }
                segment = segment5;
                segment4 = segment;
            }
            b2 = SegmentOrClosed.b(segment2);
            if (SegmentOrClosed.h(b2)) {
                break;
            }
            Segment f2 = SegmentOrClosed.f(b2);
            while (true) {
                Segment segment6 = (Segment) this.tail;
                if (segment6.o() >= f2.o()) {
                    break loop0;
                } else if (f2.r()) {
                    if (a.a(f29457e, this, segment6, f2)) {
                        if (segment6.n()) {
                            segment6.l();
                        }
                    } else if (f2.n()) {
                        f2.l();
                    }
                }
            }
        }
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) SegmentOrClosed.f(b2);
        int h3 = (int) (andIncrement % ((long) SemaphoreKt.f29467f));
        if (I.a(semaphoreSegment.f29468e, h3, (Object) null, cancellableContinuation)) {
            cancellableContinuation.M(new CancelSemaphoreAcquisitionHandler(semaphoreSegment, h3));
            return true;
        }
        if (!I.a(semaphoreSegment.f29468e, h3, SemaphoreKt.f29463b, SemaphoreKt.f29464c)) {
            return false;
        }
        cancellableContinuation.f0(Unit.f28779a, this.f29461b);
        return true;
    }

    private final boolean j(CancellableContinuation<? super Unit> cancellableContinuation) {
        Object P = cancellableContinuation.P(Unit.f28779a, (Object) null, this.f29461b);
        if (P == null) {
            return false;
        }
        cancellableContinuation.u0(P);
        return true;
    }

    private final boolean k() {
        Segment segment;
        Segment segment2;
        Object b2;
        Segment segment3 = (SemaphoreSegment) this.head;
        long andIncrement = f29456d.getAndIncrement(this);
        long h2 = andIncrement / ((long) SemaphoreKt.f29467f);
        loop0:
        while (true) {
            Segment segment4 = segment3;
            while (true) {
                if (segment4.o() >= h2 && !segment4.g()) {
                    segment2 = segment4;
                    break;
                }
                Object a2 = segment4.e();
                if (a2 == ConcurrentLinkedListKt.f29338b) {
                    segment2 = ConcurrentLinkedListKt.f29338b;
                    break;
                }
                Segment segment5 = (Segment) ((ConcurrentLinkedListNode) a2);
                if (segment5 == null) {
                    segment5 = SemaphoreKt.j(segment4.o() + 1, (SemaphoreSegment) segment4);
                    if (!segment4.m(segment5)) {
                        segment = segment4;
                        segment4 = segment;
                    } else if (segment4.g()) {
                        segment4.l();
                    }
                }
                segment = segment5;
                segment4 = segment;
            }
            b2 = SegmentOrClosed.b(segment2);
            if (SegmentOrClosed.h(b2)) {
                break;
            }
            Segment f2 = SegmentOrClosed.f(b2);
            while (true) {
                Segment segment6 = (Segment) this.head;
                if (segment6.o() >= f2.o()) {
                    break loop0;
                } else if (f2.r()) {
                    if (a.a(f29455c, this, segment6, f2)) {
                        if (segment6.n()) {
                            segment6.l();
                        }
                    } else if (f2.n()) {
                        f2.l();
                    }
                }
            }
        }
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) SegmentOrClosed.f(b2);
        semaphoreSegment.b();
        if (semaphoreSegment.o() > h2) {
            return false;
        }
        int h3 = (int) (andIncrement % ((long) SemaphoreKt.f29467f));
        Object andSet = semaphoreSegment.f29468e.getAndSet(h3, SemaphoreKt.f29463b);
        if (andSet == null) {
            int f3 = SemaphoreKt.f29462a;
            for (int i2 = 0; i2 < f3; i2++) {
                if (semaphoreSegment.f29468e.get(h3) == SemaphoreKt.f29464c) {
                    return true;
                }
            }
            return !I.a(semaphoreSegment.f29468e, h3, SemaphoreKt.f29463b, SemaphoreKt.f29465d);
        } else if (andSet == SemaphoreKt.f29466e) {
            return false;
        } else {
            return j((CancellableContinuation) andSet);
        }
    }

    public void a() {
        while (true) {
            int i2 = this._availablePermits;
            if (i2 < this.f29460a) {
                if (f29459g.compareAndSet(this, i2, i2 + 1) && (i2 >= 0 || k())) {
                    return;
                }
            } else {
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.f29460a).toString());
            }
        }
    }

    public int b() {
        return Math.max(this._availablePermits, 0);
    }

    @Nullable
    public Object c(@NotNull Continuation<? super Unit> continuation) {
        if (f29459g.getAndDecrement(this) > 0) {
            return Unit.f28779a;
        }
        Object h2 = h(continuation);
        return h2 == IntrinsicsKt.l() ? h2 : Unit.f28779a;
    }

    public boolean d() {
        int i2;
        do {
            i2 = this._availablePermits;
            if (i2 <= 0) {
                return false;
            }
        } while (!f29459g.compareAndSet(this, i2, i2 - 1));
        return true;
    }
}
