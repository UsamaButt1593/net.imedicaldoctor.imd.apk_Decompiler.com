package kotlinx.coroutines.scheduling;

import com.itextpdf.text.pdf.Barcode128;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.ResizableAtomicArray;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 `2\u00020\u00012\u00020\u0002:\u0003abcB+\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\b\u0018\u00010\u0011R\u00020\u0000H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0015\u001a\u00020\u00032\n\u0010\u0014\u001a\u00060\u0011R\u00020\u0000H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0006H\b¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0006H\b¢\u0006\u0004\b\u001a\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u0003H\b¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0003H\b¢\u0006\u0004\b\u001d\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u0006H\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 H\b¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u000eH\b¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0006H\b¢\u0006\u0004\b%\u0010\u001fJ\u0017\u0010'\u001a\u00020 2\u0006\u0010&\u001a\u00020\u000eH\u0002¢\u0006\u0004\b'\u0010(J\u0019\u0010)\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u000eH\u0002¢\u0006\u0004\b+\u0010$J\u000f\u0010,\u001a\u00020\u0003H\u0002¢\u0006\u0004\b,\u0010\u001cJ+\u0010.\u001a\u0004\u0018\u00010\f*\b\u0018\u00010\u0011R\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010-\u001a\u00020\u000eH\u0002¢\u0006\u0004\b.\u0010/J\u0015\u00100\u001a\b\u0018\u00010\u0011R\u00020\u0000H\u0002¢\u0006\u0004\b0\u0010\u0013J)\u00103\u001a\u00020 2\n\u0010\u0014\u001a\u00060\u0011R\u00020\u00002\u0006\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0003¢\u0006\u0004\b3\u00104J\u0019\u00105\u001a\u00020\u000e2\n\u0010\u0014\u001a\u00060\u0011R\u00020\u0000¢\u0006\u0004\b5\u00106J\u0018\u00107\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0006H\b¢\u0006\u0004\b7\u0010\u0019J\u001b\u0010;\u001a\u00020 2\n\u0010:\u001a\u000608j\u0002`9H\u0016¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020 H\u0016¢\u0006\u0004\b=\u0010\"J\u0015\u0010?\u001a\u00020 2\u0006\u0010>\u001a\u00020\u0006¢\u0006\u0004\b?\u0010@J-\u0010D\u001a\u00020 2\n\u0010A\u001a\u000608j\u0002`92\b\b\u0002\u0010C\u001a\u00020B2\b\b\u0002\u0010-\u001a\u00020\u000e¢\u0006\u0004\bD\u0010EJ!\u0010F\u001a\u00020\f2\n\u0010A\u001a\u000608j\u0002`92\u0006\u0010C\u001a\u00020B¢\u0006\u0004\bF\u0010GJ\r\u0010H\u001a\u00020 ¢\u0006\u0004\bH\u0010\"J\u000f\u0010I\u001a\u00020\bH\u0016¢\u0006\u0004\bI\u0010JJ\u0015\u0010K\u001a\u00020 2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\bK\u0010LR\u0014\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0006\n\u0004\bM\u0010'R\u0014\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0006\n\u0004\bN\u0010'R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\bO\u0010HR\u0014\u0010\t\u001a\u00020\b8\u0006X\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010U\u001a\u00020R8\u0006X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010W\u001a\u00020R8\u0006X\u0004¢\u0006\u0006\n\u0004\bV\u0010TR\u001e\u0010[\u001a\f\u0012\b\u0012\u00060\u0011R\u00020\u00000X8\u0006X\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0015\u0010]\u001a\u00020\u00038Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010\u001cR\u0015\u0010^\u001a\u00020\u00038Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\bM\u0010\u001cR\u0011\u0010_\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b_\u0010$¨\u0006d"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "b", "(Lkotlinx/coroutines/scheduling/Task;)Z", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "x", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "worker", "w", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)I", "state", "i", "(J)I", "d", "v", "()I", "p", "u", "()J", "", "n", "()V", "N", "()Z", "F", "skipUnpark", "I", "(Z)V", "O", "(J)Z", "R", "e", "tailDispatch", "L", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "k", "oldIndex", "newIndex", "A", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;II)V", "y", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)Z", "c", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "command", "execute", "(Ljava/lang/Runnable;)V", "close", "timeout", "H", "(J)V", "block", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "q", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "f", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;)Lkotlinx/coroutines/scheduling/Task;", "J", "toString", "()Ljava/lang/String;", "G", "(Lkotlinx/coroutines/scheduling/Task;)V", "s", "X", "Y", "Z", "Ljava/lang/String;", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "X2", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "Y2", "globalBlockingQueue", "Lkotlinx/coroutines/internal/ResizableAtomicArray;", "Z2", "Lkotlinx/coroutines/internal/ResizableAtomicArray;", "workers", "t", "createdWorkers", "availableCpuPermits", "isTerminated", "a3", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class CoroutineScheduler implements Executor, Closeable {
    @NotNull
    public static final Companion a3 = new Companion((DefaultConstructorMarker) null);
    private static final /* synthetic */ AtomicLongFieldUpdater b3;
    static final /* synthetic */ AtomicLongFieldUpdater c3;
    private static final /* synthetic */ AtomicIntegerFieldUpdater d3;
    @NotNull
    @JvmField
    public static final Symbol e3 = new Symbol("NOT_IN_STACK");
    private static final int f3 = -1;
    private static final int g3 = 0;
    private static final int h3 = 1;
    private static final int i3 = 21;
    private static final long j3 = 2097151;
    private static final long k3 = 4398044413952L;
    private static final int l3 = 42;
    private static final long m3 = 9223367638808264704L;
    public static final int n3 = 1;
    public static final int o3 = 2097150;
    private static final long p3 = 2097151;
    private static final long q3 = -2097152;
    private static final long r3 = 2097152;
    @JvmField
    public final int X;
    @NotNull
    @JvmField
    public final GlobalQueue X2;
    @JvmField
    public final long Y;
    @NotNull
    @JvmField
    public final GlobalQueue Y2;
    @NotNull
    @JvmField
    public final String Z;
    @NotNull
    @JvmField
    public final ResizableAtomicArray<Worker> Z2;
    @NotNull
    private volatile /* synthetic */ int _isTerminated;
    @NotNull
    volatile /* synthetic */ long controlState;
    @NotNull
    private volatile /* synthetic */ long parkedWorkersStack;
    @JvmField
    public final int s;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Companion;", "", "()V", "BLOCKING_MASK", "", "BLOCKING_SHIFT", "", "CLAIMED", "CPU_PERMITS_MASK", "CPU_PERMITS_SHIFT", "CREATED_MASK", "MAX_SUPPORTED_POOL_SIZE", "MIN_SUPPORTED_POOL_SIZE", "NOT_IN_STACK", "Lkotlinx/coroutines/internal/Symbol;", "PARKED", "PARKED_INDEX_MASK", "PARKED_VERSION_INC", "PARKED_VERSION_MASK", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29411a;

        static {
            int[] iArr = new int[WorkerState.values().length];
            iArr[WorkerState.PARKING.ordinal()] = 1;
            iArr[WorkerState.BLOCKING.ordinal()] = 2;
            iArr[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            iArr[WorkerState.DORMANT.ordinal()] = 4;
            iArr[WorkerState.TERMINATED.ordinal()] = 5;
            f29411a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\tJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\fJ\u000f\u0010\u0018\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\fJ\u0017\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0015J\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010!\u001a\u0004\u0018\u00010\u000f2\u0006\u0010 \u001a\u00020\u0007H\u0002¢\u0006\u0004\b!\u0010\u001dJ\u0015\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\nH\u0016¢\u0006\u0004\b&\u0010\fJ\u0015\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b*\u0010\u001dR*\u0010+\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048\u0006@FX\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u0010\u0015R\u0014\u00102\u001a\u0002008\u0006X\u0004¢\u0006\u0006\n\u0004\b\r\u00101R\u0016\u00105\u001a\u00020\"8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R$\u0010;\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0016\u0010B\u001a\u0002068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u00108R\u0016\u0010D\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010,R\u0016\u0010F\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\bE\u0010AR\u0012\u0010J\u001a\u00020G8Æ\u0002¢\u0006\u0006\u001a\u0004\bH\u0010I¨\u0006K"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "Ljava/lang/Thread;", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "", "index", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "", "r", "()Z", "", "o", "()V", "s", "k", "Lkotlinx/coroutines/scheduling/Task;", "task", "d", "(Lkotlinx/coroutines/scheduling/Task;)V", "taskMode", "c", "(I)V", "b", "m", "v", "mode", "j", "scanLocalQueue", "e", "(Z)Lkotlinx/coroutines/scheduling/Task;", "n", "()Lkotlinx/coroutines/scheduling/Task;", "blockingOnly", "u", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "t", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "run", "upperBound", "l", "(I)I", "f", "indexInArray", "I", "g", "()I", "p", "Lkotlinx/coroutines/scheduling/WorkQueue;", "Lkotlinx/coroutines/scheduling/WorkQueue;", "localQueue", "X", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "state", "", "Y", "J", "terminationDeadline", "", "nextParkedWorker", "Ljava/lang/Object;", "h", "()Ljava/lang/Object;", "q", "(Ljava/lang/Object;)V", "Z", "minDelayUntilStealableTaskNs", "X2", "rngState", "Y2", "mayHaveLocalTasks", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "i", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public final class Worker extends Thread {
        static final /* synthetic */ AtomicIntegerFieldUpdater a3 = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl");
        @NotNull
        @JvmField
        public WorkerState X;
        private int X2;
        private long Y;
        @JvmField
        public boolean Y2;
        private long Z;
        private volatile int indexInArray;
        @Nullable
        private volatile Object nextParkedWorker;
        @NotNull
        @JvmField
        public final WorkQueue s;
        @NotNull
        volatile /* synthetic */ int workerCtl;

        private Worker() {
            setDaemon(true);
            this.s = new WorkQueue();
            this.X = WorkerState.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = CoroutineScheduler.e3;
            this.X2 = Random.s.l();
        }

        private final void b(int i2) {
            if (i2 != 0) {
                CoroutineScheduler.c3.addAndGet(CoroutineScheduler.this, CoroutineScheduler.q3);
                if (this.X != WorkerState.TERMINATED) {
                    this.X = WorkerState.DORMANT;
                }
            }
        }

        private final void c(int i2) {
            if (i2 != 0 && t(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.J();
            }
        }

        private final void d(Task task) {
            int G = task.X.G();
            j(G);
            c(G);
            CoroutineScheduler.this.G(task);
            b(G);
        }

        private final Task e(boolean z) {
            Task n2;
            Task n3;
            if (z) {
                boolean z2 = l(CoroutineScheduler.this.s * 2) == 0;
                if (z2 && (n3 = n()) != null) {
                    return n3;
                }
                Task h2 = this.s.h();
                if (h2 != null) {
                    return h2;
                }
                if (!z2 && (n2 = n()) != null) {
                    return n2;
                }
            } else {
                Task n4 = n();
                if (n4 != null) {
                    return n4;
                }
            }
            return u(false);
        }

        private final void j(int i2) {
            this.Y = 0;
            if (this.X == WorkerState.PARKING) {
                this.X = WorkerState.BLOCKING;
            }
        }

        private final boolean k() {
            return this.nextParkedWorker != CoroutineScheduler.e3;
        }

        private final void m() {
            if (this.Y == 0) {
                this.Y = System.nanoTime() + CoroutineScheduler.this.Y;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.Y);
            if (System.nanoTime() - this.Y >= 0) {
                this.Y = 0;
                v();
            }
        }

        private final Task n() {
            GlobalQueue globalQueue;
            if (l(2) == 0) {
                Task task = (Task) CoroutineScheduler.this.X2.g();
                if (task != null) {
                    return task;
                }
                globalQueue = CoroutineScheduler.this.Y2;
            } else {
                Task task2 = (Task) CoroutineScheduler.this.Y2.g();
                if (task2 != null) {
                    return task2;
                }
                globalQueue = CoroutineScheduler.this.X2;
            }
            return (Task) globalQueue.g();
        }

        private final void o() {
            loop0:
            while (true) {
                boolean z = false;
                while (!CoroutineScheduler.this.isTerminated() && this.X != WorkerState.TERMINATED) {
                    Task f2 = f(this.Y2);
                    if (f2 != null) {
                        this.Z = 0;
                        d(f2);
                    } else {
                        this.Y2 = false;
                        if (this.Z == 0) {
                            s();
                        } else if (!z) {
                            z = true;
                        } else {
                            t(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.Z);
                            this.Z = 0;
                        }
                    }
                }
            }
            t(WorkerState.TERMINATED);
        }

        private final boolean r() {
            long j2;
            if (this.X == WorkerState.CPU_ACQUIRED) {
                return true;
            }
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            do {
                j2 = coroutineScheduler.controlState;
                if (((int) ((CoroutineScheduler.m3 & j2) >> 42)) == 0) {
                    return false;
                }
            } while (!CoroutineScheduler.c3.compareAndSet(coroutineScheduler, j2, j2 - 4398046511104L));
            this.X = WorkerState.CPU_ACQUIRED;
            return true;
        }

        private final void s() {
            if (!k()) {
                CoroutineScheduler.this.y(this);
                return;
            }
            this.workerCtl = -1;
            while (k() && this.workerCtl == -1 && !CoroutineScheduler.this.isTerminated() && this.X != WorkerState.TERMINATED) {
                t(WorkerState.PARKING);
                Thread.interrupted();
                m();
            }
        }

        private final Task u(boolean z) {
            int i2 = (int) (CoroutineScheduler.this.controlState & 2097151);
            if (i2 < 2) {
                return null;
            }
            int l2 = l(i2);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            long j2 = Long.MAX_VALUE;
            for (int i3 = 0; i3 < i2; i3++) {
                l2++;
                if (l2 > i2) {
                    l2 = 1;
                }
                Worker b2 = coroutineScheduler.Z2.b(l2);
                if (!(b2 == null || b2 == this)) {
                    WorkQueue workQueue = this.s;
                    WorkQueue workQueue2 = b2.s;
                    long k2 = z ? workQueue.k(workQueue2) : workQueue.l(workQueue2);
                    if (k2 == -1) {
                        return this.s.h();
                    }
                    if (k2 > 0) {
                        j2 = Math.min(j2, k2);
                    }
                }
            }
            if (j2 == Long.MAX_VALUE) {
                j2 = 0;
            }
            this.Z = j2;
            return null;
        }

        private final void v() {
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (coroutineScheduler.Z2) {
                try {
                    if (!coroutineScheduler.isTerminated()) {
                        if (((int) (coroutineScheduler.controlState & 2097151)) > coroutineScheduler.s) {
                            if (a3.compareAndSet(this, -1, 1)) {
                                int i2 = this.indexInArray;
                                p(0);
                                coroutineScheduler.A(this, i2, 0);
                                int andDecrement = (int) (CoroutineScheduler.c3.getAndDecrement(coroutineScheduler) & 2097151);
                                if (andDecrement != i2) {
                                    Worker b2 = coroutineScheduler.Z2.b(andDecrement);
                                    Intrinsics.m(b2);
                                    Worker worker = b2;
                                    coroutineScheduler.Z2.c(i2, worker);
                                    worker.p(i2);
                                    coroutineScheduler.A(worker, andDecrement, i2);
                                }
                                coroutineScheduler.Z2.c(andDecrement, null);
                                Unit unit = Unit.f28779a;
                                this.X = WorkerState.TERMINATED;
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Nullable
        public final Task f(boolean z) {
            Task task;
            if (r()) {
                return e(z);
            }
            if (!z || (task = this.s.h()) == null) {
                task = (Task) CoroutineScheduler.this.Y2.g();
            }
            return task == null ? u(true) : task;
        }

        public final int g() {
            return this.indexInArray;
        }

        @Nullable
        public final Object h() {
            return this.nextParkedWorker;
        }

        @NotNull
        public final CoroutineScheduler i() {
            return CoroutineScheduler.this;
        }

        public final int l(int i2) {
            int i3 = this.X2;
            int i4 = i3 ^ (i3 << 13);
            int i5 = i4 ^ (i4 >> 17);
            int i6 = i5 ^ (i5 << 5);
            this.X2 = i6;
            int i7 = i2 - 1;
            return (i7 & i2) == 0 ? i6 & i7 : (i6 & Integer.MAX_VALUE) % i2;
        }

        public final void p(int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.Z);
            sb.append("-worker-");
            sb.append(i2 == 0 ? "TERMINATED" : String.valueOf(i2));
            setName(sb.toString());
            this.indexInArray = i2;
        }

        public final void q(@Nullable Object obj) {
            this.nextParkedWorker = obj;
        }

        public void run() {
            o();
        }

        public final boolean t(@NotNull WorkerState workerState) {
            WorkerState workerState2 = this.X;
            boolean z = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z) {
                CoroutineScheduler.c3.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.X = workerState;
            }
            return z;
        }

        public Worker(CoroutineScheduler coroutineScheduler, int i2) {
            this();
            p(i2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "<init>", "(Ljava/lang/String;I)V", "s", "X", "Y", "Z", "X2", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    static {
        Class<CoroutineScheduler> cls = CoroutineScheduler.class;
        b3 = AtomicLongFieldUpdater.newUpdater(cls, "parkedWorkersStack");
        c3 = AtomicLongFieldUpdater.newUpdater(cls, "controlState");
        d3 = AtomicIntegerFieldUpdater.newUpdater(cls, "_isTerminated");
    }

    public CoroutineScheduler(int i2, int i4, long j2, @NotNull String str) {
        this.s = i2;
        this.X = i4;
        this.Y = j2;
        this.Z = str;
        if (i2 < 1) {
            throw new IllegalArgumentException(("Core pool size " + i2 + " should be at least 1").toString());
        } else if (i4 < i2) {
            throw new IllegalArgumentException(("Max pool size " + i4 + " should be greater than or equals to core pool size " + i2).toString());
        } else if (i4 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i4 + " should not exceed maximal supported number of threads 2097150").toString());
        } else if (j2 > 0) {
            this.X2 = new GlobalQueue();
            this.Y2 = new GlobalQueue();
            this.parkedWorkersStack = 0;
            this.Z2 = new ResizableAtomicArray<>(i2 + 1);
            this.controlState = ((long) i2) << 42;
            this._isTerminated = 0;
        } else {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
        }
    }

    private final long F() {
        return c3.addAndGet(this, 4398046511104L);
    }

    private final void I(boolean z) {
        long addAndGet = c3.addAndGet(this, 2097152);
        if (!z && !R() && !O(addAndGet)) {
            R();
        }
    }

    private final Task L(Worker worker, Task task, boolean z) {
        if (worker == null || worker.X == WorkerState.TERMINATED) {
            return task;
        }
        if (task.X.G() == 0 && worker.X == WorkerState.BLOCKING) {
            return task;
        }
        worker.Y2 = true;
        return worker.s.a(task, z);
    }

    private final boolean N() {
        long j2;
        do {
            j2 = this.controlState;
            if (((int) ((m3 & j2) >> 42)) == 0) {
                return false;
            }
        } while (!c3.compareAndSet(this, j2, j2 - 4398046511104L));
        return true;
    }

    private final boolean O(long j2) {
        if (RangesKt.u(((int) (2097151 & j2)) - ((int) ((j2 & k3) >> 21)), 0) < this.s) {
            int e2 = e();
            if (e2 == 1 && this.s > 1) {
                e();
            }
            if (e2 > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean Q(CoroutineScheduler coroutineScheduler, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = coroutineScheduler.controlState;
        }
        return coroutineScheduler.O(j2);
    }

    private final boolean R() {
        Worker x;
        do {
            x = x();
            if (x == null) {
                return false;
            }
        } while (!Worker.a3.compareAndSet(x, -1, 0));
        LockSupport.unpark(x);
        return true;
    }

    private final boolean b(Task task) {
        return (task.X.G() == 1 ? this.Y2 : this.X2).a(task);
    }

    private final int d(long j2) {
        return (int) ((j2 & k3) >> 21);
    }

    private final int e() {
        synchronized (this.Z2) {
            if (isTerminated()) {
                return -1;
            }
            long j2 = this.controlState;
            int i2 = (int) (j2 & 2097151);
            int u = RangesKt.u(i2 - ((int) ((j2 & k3) >> 21)), 0);
            if (u >= this.s) {
                return 0;
            }
            if (i2 >= this.X) {
                return 0;
            }
            int i4 = ((int) (this.controlState & 2097151)) + 1;
            if (i4 <= 0 || this.Z2.b(i4) != null) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            Worker worker = new Worker(this, i4);
            this.Z2.c(i4, worker);
            if (i4 == ((int) (2097151 & c3.incrementAndGet(this)))) {
                worker.start();
                int i5 = u + 1;
                return i5;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private final int i(long j2) {
        return (int) (j2 & 2097151);
    }

    private final Worker k() {
        Thread currentThread = Thread.currentThread();
        Worker worker = currentThread instanceof Worker ? (Worker) currentThread : null;
        if (worker == null || !Intrinsics.g(CoroutineScheduler.this, this)) {
            return null;
        }
        return worker;
    }

    private final void n() {
        c3.addAndGet(this, q3);
    }

    private final int p() {
        return (int) (c3.getAndDecrement(this) & 2097151);
    }

    public static /* synthetic */ void r(CoroutineScheduler coroutineScheduler, Runnable runnable, TaskContext taskContext, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            taskContext = TasksKt.f29421i;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        coroutineScheduler.q(runnable, taskContext, z);
    }

    private final int s() {
        return (int) ((this.controlState & m3) >> 42);
    }

    private final int t() {
        return (int) (this.controlState & 2097151);
    }

    private final long u() {
        return c3.addAndGet(this, 2097152);
    }

    private final int v() {
        return (int) (c3.incrementAndGet(this) & 2097151);
    }

    private final int w(Worker worker) {
        int g2;
        do {
            Object h2 = worker.h();
            if (h2 == e3) {
                return -1;
            }
            if (h2 == null) {
                return 0;
            }
            worker = (Worker) h2;
            g2 = worker.g();
        } while (g2 == 0);
        return g2;
    }

    private final Worker x() {
        while (true) {
            long j2 = this.parkedWorkersStack;
            Worker b2 = this.Z2.b((int) (2097151 & j2));
            if (b2 == null) {
                return null;
            }
            long j4 = (2097152 + j2) & q3;
            int w = w(b2);
            if (w >= 0) {
                if (b3.compareAndSet(this, j2, ((long) w) | j4)) {
                    b2.q(e3);
                    return b2;
                }
            }
        }
    }

    public final void A(@NotNull Worker worker, int i2, int i4) {
        while (true) {
            long j2 = this.parkedWorkersStack;
            int i5 = (int) (2097151 & j2);
            long j4 = (2097152 + j2) & q3;
            if (i5 == i2) {
                i5 = i4 == 0 ? w(worker) : i4;
            }
            if (i5 >= 0) {
                if (b3.compareAndSet(this, j2, j4 | ((long) i5))) {
                    return;
                }
            }
        }
    }

    public final void G(@NotNull Task task) {
        AbstractTimeSource b2;
        try {
            task.run();
            b2 = AbstractTimeSourceKt.b();
            if (b2 == null) {
                return;
            }
        } catch (Throwable th) {
            AbstractTimeSource b4 = AbstractTimeSourceKt.b();
            if (b4 != null) {
                b4.f();
            }
            throw th;
        }
        b2.f();
    }

    public final void H(long j2) {
        int i2;
        Task task;
        if (d3.compareAndSet(this, 0, 1)) {
            Worker k2 = k();
            synchronized (this.Z2) {
                i2 = (int) (this.controlState & 2097151);
            }
            if (1 <= i2) {
                int i4 = 1;
                while (true) {
                    Worker b2 = this.Z2.b(i4);
                    Intrinsics.m(b2);
                    Worker worker = b2;
                    if (worker != k2) {
                        while (worker.isAlive()) {
                            LockSupport.unpark(worker);
                            worker.join(j2);
                        }
                        worker.s.g(this.Y2);
                    }
                    if (i4 == i2) {
                        break;
                    }
                    i4++;
                }
            }
            this.Y2.b();
            this.X2.b();
            while (true) {
                if (k2 != null) {
                    task = k2.f(true);
                    if (task != null) {
                        continue;
                        G(task);
                    }
                }
                task = (Task) this.X2.g();
                if (task == null && (task = (Task) this.Y2.g()) == null) {
                    break;
                }
                G(task);
            }
            if (k2 != null) {
                k2.t(WorkerState.TERMINATED);
            }
            this.parkedWorkersStack = 0;
            this.controlState = 0;
        }
    }

    public final void J() {
        if (!R() && !Q(this, 0, 1, (Object) null)) {
            R();
        }
    }

    public final int c(long j2) {
        return (int) ((j2 & m3) >> 42);
    }

    public void close() {
        H(10000);
    }

    public void execute(@NotNull Runnable runnable) {
        r(this, runnable, (TaskContext) null, false, 6, (Object) null);
    }

    @NotNull
    public final Task f(@NotNull Runnable runnable, @NotNull TaskContext taskContext) {
        long a2 = TasksKt.f29418f.a();
        if (!(runnable instanceof Task)) {
            return new TaskImpl(runnable, a2, taskContext);
        }
        Task task = (Task) runnable;
        task.s = a2;
        task.X = taskContext;
        return task;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [int, boolean] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final void q(@NotNull Runnable runnable, @NotNull TaskContext taskContext, boolean z) {
        AbstractTimeSource b2 = AbstractTimeSourceKt.b();
        if (b2 != null) {
            b2.e();
        }
        Task f2 = f(runnable, taskContext);
        Worker k2 = k();
        Task L = L(k2, f2, z);
        if (L == null || b(L)) {
            boolean z2 = z && k2 != null;
            if (f2.X.G() != 0) {
                I(z2);
            } else if (!z2) {
                J();
            }
        } else {
            throw new RejectedExecutionException(this.Z + " was terminated");
        }
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        char c2;
        ArrayList arrayList = new ArrayList();
        int a2 = this.Z2.a();
        int i2 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 1; i8 < a2; i8++) {
            Worker b2 = this.Z2.b(i8);
            if (b2 != null) {
                int f2 = b2.s.f();
                int i9 = WhenMappings.f29411a[b2.X.ordinal()];
                if (i9 != 1) {
                    if (i9 == 2) {
                        i4++;
                        sb = new StringBuilder();
                        sb.append(f2);
                        c2 = 'b';
                    } else if (i9 == 3) {
                        i2++;
                        sb = new StringBuilder();
                        sb.append(f2);
                        c2 = Barcode128.F;
                    } else if (i9 == 4) {
                        i6++;
                        if (f2 > 0) {
                            sb = new StringBuilder();
                            sb.append(f2);
                            c2 = Barcode128.G;
                        }
                    } else if (i9 == 5) {
                        i7++;
                    }
                    sb.append(c2);
                    arrayList.add(sb.toString());
                } else {
                    i5++;
                }
            }
        }
        long j2 = this.controlState;
        return this.Z + '@' + DebugStringsKt.b(this) + "[Pool Size {core = " + this.s + ", max = " + this.X + "}, Worker States {CPU = " + i2 + ", blocking = " + i4 + ", parked = " + i5 + ", dormant = " + i6 + ", terminated = " + i7 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.X2.c() + ", global blocking queue size = " + this.Y2.c() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((k3 & j2) >> 21)) + ", CPUs acquired = " + (this.s - ((int) ((m3 & j2) >> 42))) + "}]";
    }

    public final boolean y(@NotNull Worker worker) {
        long j2;
        long j4;
        int g2;
        if (worker.h() != e3) {
            return false;
        }
        do {
            j2 = this.parkedWorkersStack;
            j4 = (2097152 + j2) & q3;
            g2 = worker.g();
            worker.q(this.Z2.b((int) (2097151 & j2)));
        } while (!b3.compareAndSet(this, j2, j4 | ((long) g2)));
        return true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CoroutineScheduler(int i2, int i4, long j2, String str, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, i4, (i5 & 4) != 0 ? TasksKt.f29417e : j2, (i5 & 8) != 0 ? TasksKt.f29413a : str);
    }
}
