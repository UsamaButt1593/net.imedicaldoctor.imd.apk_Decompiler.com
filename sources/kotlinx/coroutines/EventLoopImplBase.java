package kotlinx.coroutines;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.DurationKt;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\b \u0018\u00002\u00020\u00012\u00020\u0002:\u000489:;B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\t\u001a\u00020\b2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u0017\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0019\u0010\u0004J%\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00122\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010!\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u00122\n\u0010\u001f\u001a\u00060\u0005j\u0002`\u0006H\u0004¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0012H\u0016¢\u0006\u0004\b#\u0010$J!\u0010'\u001a\u00020\r2\u0006\u0010&\u001a\u00020%2\n\u0010\u001f\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b'\u0010(J\u001b\u0010)\u001a\u00020\r2\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0004\b)\u0010*J\u001d\u0010+\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\rH\u0004¢\u0006\u0004\b-\u0010\u0004R$\u00103\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b8B@BX\u000e¢\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0014\u00105\u001a\u00020\b8TX\u0004¢\u0006\u0006\u001a\u0004\b4\u00100R\u0014\u00107\u001a\u00020\u00128TX\u0004¢\u0006\u0006\u001a\u0004\b6\u0010$¨\u0006<"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase;", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;", "<init>", "()V", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "task", "", "V0", "(Ljava/lang/Runnable;)Z", "T0", "()Ljava/lang/Runnable;", "", "S0", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "e1", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)Z", "", "now", "delayedTask", "", "a1", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "X0", "shutdown", "timeMillis", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "r", "(JLkotlinx/coroutines/CancellableContinuation;)V", "block", "Lkotlinx/coroutines/DisposableHandle;", "c1", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "J0", "()J", "Lkotlin/coroutines/CoroutineContext;", "context", "R", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "U0", "(Ljava/lang/Runnable;)V", "Z0", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "Y0", "value", "p", "()Z", "d1", "(Z)V", "isCompleted", "D0", "isEmpty", "x0", "nextTime", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class EventLoopImplBase extends EventLoopImplPlatform implements Delay {
    private static final /* synthetic */ AtomicReferenceFieldUpdater Y2;
    private static final /* synthetic */ AtomicReferenceFieldUpdater Z2;
    @NotNull
    private volatile /* synthetic */ Object _delayed = null;
    @NotNull
    private volatile /* synthetic */ int _isCompleted = 0;
    @NotNull
    private volatile /* synthetic */ Object _queue = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "", "nanoTime", "Lkotlinx/coroutines/CancellableContinuation;", "", "cont", "<init>", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "()V", "", "toString", "()Ljava/lang/String;", "Y", "Lkotlinx/coroutines/CancellableContinuation;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private final class DelayedResumeTask extends DelayedTask {
        @NotNull
        private final CancellableContinuation<Unit> Y;

        public DelayedResumeTask(long j2, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
            super(j2);
            this.Y = cancellableContinuation;
        }

        public void run() {
            this.Y.S(EventLoopImplBase.this, Unit.f28779a);
        }

        @NotNull
        public String toString() {
            return super.toString() + this.Y;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u00060\u0004j\u0002`\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "", "nanoTime", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "<init>", "(JLjava/lang/Runnable;)V", "", "run", "()V", "", "toString", "()Ljava/lang/String;", "Y", "Ljava/lang/Runnable;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class DelayedRunnableTask extends DelayedTask {
        @NotNull
        private final Runnable Y;

        public DelayedRunnableTask(long j2, @NotNull Runnable runnable) {
            super(j2);
            this.Y = runnable;
        }

        public void run() {
            this.Y.run();
        }

        @NotNull
        public String toString() {
            return super.toString() + this.Y;
        }
    }

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u0005B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\"\u0010)\u001a\u00020\u000b8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R0\u00100\u001a\b\u0012\u0002\b\u0003\u0018\u00010*2\f\u0010+\u001a\b\u0012\u0002\b\u0003\u0018\u00010*8V@VX\u000e¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u00061"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "nanoTime", "<init>", "(J)V", "other", "", "e", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "now", "", "g", "(J)Z", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "delayed", "Lkotlinx/coroutines/EventLoopImplBase;", "eventLoop", "f", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;Lkotlinx/coroutines/EventLoopImplBase;)I", "", "m", "()V", "", "toString", "()Ljava/lang/String;", "s", "J", "", "_heap", "Ljava/lang/Object;", "X", "I", "j", "()I", "c", "(I)V", "index", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "value", "b", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "a", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "heap", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static abstract class DelayedTask implements Runnable, Comparable<DelayedTask>, DisposableHandle, ThreadSafeHeapNode {
        private int X = -1;
        @Nullable
        private volatile Object _heap;
        @JvmField
        public long s;

        public DelayedTask(long j2) {
            this.s = j2;
        }

        public void a(@Nullable ThreadSafeHeap<?> threadSafeHeap) {
            if (this._heap != EventLoop_commonKt.f29192a) {
                this._heap = threadSafeHeap;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        @Nullable
        public ThreadSafeHeap<?> b() {
            Object obj = this._heap;
            if (obj instanceof ThreadSafeHeap) {
                return (ThreadSafeHeap) obj;
            }
            return null;
        }

        public void c(int i2) {
            this.X = i2;
        }

        /* renamed from: e */
        public int compareTo(@NotNull DelayedTask delayedTask) {
            int i2 = ((this.s - delayedTask.s) > 0 ? 1 : ((this.s - delayedTask.s) == 0 ? 0 : -1));
            if (i2 > 0) {
                return 1;
            }
            return i2 < 0 ? -1 : 0;
        }

        /* JADX WARNING: Removed duplicated region for block: B:31:0x0044 A[Catch:{ all -> 0x0026 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final synchronized int f(long r8, @org.jetbrains.annotations.NotNull kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue r10, @org.jetbrains.annotations.NotNull kotlinx.coroutines.EventLoopImplBase r11) {
            /*
                r7 = this;
                monitor-enter(r7)
                java.lang.Object r0 = r7._heap     // Catch:{ all -> 0x001d }
                kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.EventLoop_commonKt.f29192a     // Catch:{ all -> 0x001d }
                if (r0 != r1) goto L_0x000c
                monitor-exit(r7)
                r8 = 2
                return r8
            L_0x000c:
                monitor-enter(r10)     // Catch:{ all -> 0x001d }
                kotlinx.coroutines.internal.ThreadSafeHeapNode r0 = r10.f()     // Catch:{ all -> 0x0026 }
                kotlinx.coroutines.EventLoopImplBase$DelayedTask r0 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r0     // Catch:{ all -> 0x0026 }
                boolean r11 = r11.p()     // Catch:{ all -> 0x0026 }
                if (r11 == 0) goto L_0x001f
                monitor-exit(r10)     // Catch:{ all -> 0x001d }
                monitor-exit(r7)
                r8 = 1
                return r8
            L_0x001d:
                r8 = move-exception
                goto L_0x004f
            L_0x001f:
                r1 = 0
                if (r0 != 0) goto L_0x0028
            L_0x0023:
                r10.f29191b = r8     // Catch:{ all -> 0x0026 }
                goto L_0x003b
            L_0x0026:
                r8 = move-exception
                goto L_0x004d
            L_0x0028:
                long r3 = r0.s     // Catch:{ all -> 0x0026 }
                long r5 = r3 - r8
                int r11 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                if (r11 < 0) goto L_0x0031
                goto L_0x0032
            L_0x0031:
                r8 = r3
            L_0x0032:
                long r3 = r10.f29191b     // Catch:{ all -> 0x0026 }
                long r3 = r8 - r3
                int r11 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r11 <= 0) goto L_0x003b
                goto L_0x0023
            L_0x003b:
                long r8 = r7.s     // Catch:{ all -> 0x0026 }
                long r3 = r10.f29191b     // Catch:{ all -> 0x0026 }
                long r8 = r8 - r3
                int r11 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                if (r11 >= 0) goto L_0x0046
                r7.s = r3     // Catch:{ all -> 0x0026 }
            L_0x0046:
                r10.a(r7)     // Catch:{ all -> 0x0026 }
                monitor-exit(r10)     // Catch:{ all -> 0x001d }
                monitor-exit(r7)
                r8 = 0
                return r8
            L_0x004d:
                monitor-exit(r10)     // Catch:{ all -> 0x001d }
                throw r8     // Catch:{ all -> 0x001d }
            L_0x004f:
                monitor-exit(r7)     // Catch:{ all -> 0x001d }
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.EventLoopImplBase.DelayedTask.f(long, kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue, kotlinx.coroutines.EventLoopImplBase):int");
        }

        public final boolean g(long j2) {
            return j2 - this.s >= 0;
        }

        public int j() {
            return this.X;
        }

        public final synchronized void m() {
            try {
                Object obj = this._heap;
                if (obj != EventLoop_commonKt.f29192a) {
                    DelayedTaskQueue delayedTaskQueue = obj instanceof DelayedTaskQueue ? (DelayedTaskQueue) obj : null;
                    if (delayedTaskQueue != null) {
                        delayedTaskQueue.k(this);
                    }
                    this._heap = EventLoop_commonKt.f29192a;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }

        @NotNull
        public String toString() {
            return "Delayed[nanos=" + this.s + ']';
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "", "timeNow", "<init>", "(J)V", "b", "J", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class DelayedTaskQueue extends ThreadSafeHeap<DelayedTask> {
        @JvmField

        /* renamed from: b  reason: collision with root package name */
        public long f29191b;

        public DelayedTaskQueue(long j2) {
            this.f29191b = j2;
        }
    }

    static {
        Class<EventLoopImplBase> cls = EventLoopImplBase.class;
        Class<Object> cls2 = Object.class;
        Y2 = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_queue");
        Z2 = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_delayed");
    }

    private final void S0() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                if (a.a(Y2, this, (Object) null, EventLoop_commonKt.f29199h)) {
                    return;
                }
            } else if (obj instanceof LockFreeTaskQueueCore) {
                ((LockFreeTaskQueueCore) obj).d();
                return;
            } else if (obj != EventLoop_commonKt.f29199h) {
                LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                lockFreeTaskQueueCore.a((Runnable) obj);
                if (a.a(Y2, this, obj, lockFreeTaskQueueCore)) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private final Runnable T0() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof LockFreeTaskQueueCore) {
                LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj;
                Object l2 = lockFreeTaskQueueCore.l();
                if (l2 != LockFreeTaskQueueCore.t) {
                    return (Runnable) l2;
                }
                a.a(Y2, this, obj, lockFreeTaskQueueCore.k());
            } else if (obj == EventLoop_commonKt.f29199h) {
                return null;
            } else {
                if (a.a(Y2, this, obj, (Object) null)) {
                    return (Runnable) obj;
                }
            }
        }
    }

    private final boolean V0(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (p()) {
                return false;
            }
            if (obj == null) {
                if (a.a(Y2, this, (Object) null, runnable)) {
                    return true;
                }
            } else if (obj instanceof LockFreeTaskQueueCore) {
                LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj;
                int a2 = lockFreeTaskQueueCore.a(runnable);
                if (a2 == 0) {
                    return true;
                }
                if (a2 == 1) {
                    a.a(Y2, this, obj, lockFreeTaskQueueCore.k());
                } else if (a2 == 2) {
                    return false;
                }
            } else if (obj == EventLoop_commonKt.f29199h) {
                return false;
            } else {
                LockFreeTaskQueueCore lockFreeTaskQueueCore2 = new LockFreeTaskQueueCore(8, true);
                lockFreeTaskQueueCore2.a((Runnable) obj);
                lockFreeTaskQueueCore2.a(runnable);
                if (a.a(Y2, this, obj, lockFreeTaskQueueCore2)) {
                    return true;
                }
            }
        }
    }

    private final void X0() {
        DelayedTask delayedTask;
        AbstractTimeSource b2 = AbstractTimeSourceKt.b();
        long b3 = b2 != null ? b2.b() : System.nanoTime();
        while (true) {
            DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
            if (delayedTaskQueue != null && (delayedTask = (DelayedTask) delayedTaskQueue.n()) != null) {
                P0(b3, delayedTask);
            } else {
                return;
            }
        }
    }

    private final int a1(long j2, DelayedTask delayedTask) {
        if (p()) {
            return 1;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        if (delayedTaskQueue == null) {
            a.a(Z2, this, (Object) null, new DelayedTaskQueue(j2));
            Object obj = this._delayed;
            Intrinsics.m(obj);
            delayedTaskQueue = (DelayedTaskQueue) obj;
        }
        return delayedTask.f(j2, delayedTaskQueue, this);
    }

    private final void d1(boolean z) {
        this._isCompleted = z ? 1 : 0;
    }

    private final boolean e1(DelayedTask delayedTask) {
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        return (delayedTaskQueue != null ? (DelayedTask) delayedTaskQueue.i() : null) == delayedTask;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [int, boolean] */
    /* access modifiers changed from: private */
    public final boolean p() {
        return this._isCompleted;
    }

    /* access modifiers changed from: protected */
    public boolean D0() {
        if (!I0()) {
            return false;
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        if (delayedTaskQueue != null && !delayedTaskQueue.h()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof LockFreeTaskQueueCore) {
                return ((LockFreeTaskQueueCore) obj).h();
            }
            return obj == EventLoop_commonKt.f29199h;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long J0() {
        /*
            r9 = this;
            boolean r0 = r9.K0()
            r1 = 0
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            java.lang.Object r0 = r9._delayed
            kotlinx.coroutines.EventLoopImplBase$DelayedTaskQueue r0 = (kotlinx.coroutines.EventLoopImplBase.DelayedTaskQueue) r0
            if (r0 == 0) goto L_0x004d
            boolean r3 = r0.h()
            if (r3 != 0) goto L_0x004d
            kotlinx.coroutines.AbstractTimeSource r3 = kotlinx.coroutines.AbstractTimeSourceKt.b()
            if (r3 == 0) goto L_0x0020
            long r3 = r3.b()
            goto L_0x0024
        L_0x0020:
            long r3 = java.lang.System.nanoTime()
        L_0x0024:
            monitor-enter(r0)
            kotlinx.coroutines.internal.ThreadSafeHeapNode r5 = r0.f()     // Catch:{ all -> 0x003c }
            r6 = 0
            if (r5 != 0) goto L_0x002e
        L_0x002c:
            monitor-exit(r0)
            goto L_0x0046
        L_0x002e:
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r5 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r5     // Catch:{ all -> 0x003c }
            boolean r7 = r5.g(r3)     // Catch:{ all -> 0x003c }
            r8 = 0
            if (r7 == 0) goto L_0x003e
            boolean r5 = r9.V0(r5)     // Catch:{ all -> 0x003c }
            goto L_0x003f
        L_0x003c:
            r1 = move-exception
            goto L_0x004b
        L_0x003e:
            r5 = 0
        L_0x003f:
            if (r5 == 0) goto L_0x002c
            kotlinx.coroutines.internal.ThreadSafeHeapNode r6 = r0.l(r8)     // Catch:{ all -> 0x003c }
            goto L_0x002c
        L_0x0046:
            kotlinx.coroutines.EventLoopImplBase$DelayedTask r6 = (kotlinx.coroutines.EventLoopImplBase.DelayedTask) r6
            if (r6 != 0) goto L_0x0024
            goto L_0x004d
        L_0x004b:
            monitor-exit(r0)
            throw r1
        L_0x004d:
            java.lang.Runnable r0 = r9.T0()
            if (r0 == 0) goto L_0x0057
            r0.run()
            return r1
        L_0x0057:
            long r0 = r9.x0()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.EventLoopImplBase.J0():long");
    }

    @NotNull
    public DisposableHandle N(long j2, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        return Delay.DefaultImpls.b(this, j2, runnable, coroutineContext);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    @Nullable
    public Object Q(long j2, @NotNull Continuation<? super Unit> continuation) {
        return Delay.DefaultImpls.a(this, j2, continuation);
    }

    public final void R(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        U0(runnable);
    }

    public void U0(@NotNull Runnable runnable) {
        if (V0(runnable)) {
            Q0();
        } else {
            DefaultExecutor.a3.U0(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public final void Y0() {
        this._queue = null;
        this._delayed = null;
    }

    public final void Z0(long j2, @NotNull DelayedTask delayedTask) {
        int a1 = a1(j2, delayedTask);
        if (a1 != 0) {
            if (a1 == 1) {
                P0(j2, delayedTask);
            } else if (a1 != 2) {
                throw new IllegalStateException("unexpected result".toString());
            }
        } else if (e1(delayedTask)) {
            Q0();
        }
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final DisposableHandle c1(long j2, @NotNull Runnable runnable) {
        long d2 = EventLoop_commonKt.d(j2);
        if (d2 >= DurationKt.f29135c) {
            return NonDisposableHandle.s;
        }
        AbstractTimeSource b2 = AbstractTimeSourceKt.b();
        long b3 = b2 != null ? b2.b() : System.nanoTime();
        DelayedRunnableTask delayedRunnableTask = new DelayedRunnableTask(d2 + b3, runnable);
        Z0(b3, delayedRunnableTask);
        return delayedRunnableTask;
    }

    public void r(long j2, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
        long d2 = EventLoop_commonKt.d(j2);
        if (d2 < DurationKt.f29135c) {
            AbstractTimeSource b2 = AbstractTimeSourceKt.b();
            long b3 = b2 != null ? b2.b() : System.nanoTime();
            DelayedResumeTask delayedResumeTask = new DelayedResumeTask(d2 + b3, cancellableContinuation);
            Z0(b3, delayedResumeTask);
            CancellableContinuationKt.a(cancellableContinuation, delayedResumeTask);
        }
    }

    public void shutdown() {
        ThreadLocalEventLoop.f29217a.c();
        d1(true);
        S0();
        do {
        } while (J0() <= 0);
        X0();
    }

    /* access modifiers changed from: protected */
    public long x0() {
        DelayedTask delayedTask;
        if (super.x0() == 0) {
            return 0;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof LockFreeTaskQueueCore)) {
                return obj == EventLoop_commonKt.f29199h ? Long.MAX_VALUE : 0;
            }
            if (!((LockFreeTaskQueueCore) obj).h()) {
                return 0;
            }
        }
        DelayedTaskQueue delayedTaskQueue = (DelayedTaskQueue) this._delayed;
        if (delayedTaskQueue == null || (delayedTask = (DelayedTask) delayedTaskQueue.i()) == null) {
            return Long.MAX_VALUE;
        }
        long j2 = delayedTask.s;
        AbstractTimeSource b2 = AbstractTimeSourceKt.b();
        return RangesKt.v(j2 - (b2 != null ? b2.b() : System.nanoTime()), 0);
    }
}
