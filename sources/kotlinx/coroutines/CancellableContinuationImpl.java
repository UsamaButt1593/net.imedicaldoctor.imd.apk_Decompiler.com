package kotlinx.coroutines;

import androidx.concurrent.futures.a;
import com.dd.plist.ASCIIPropertyListParser;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@PublishedApi
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\u00060\u0004j\u0002`\u0005B\u001d\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\u0016\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\b¢\u0006\u0004\b\u0016\u0010\u0017JB\u0010\u001d\u001a\u00020\u00142'\u0010\u001c\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00140\u0018j\u0002`\u001b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001f\u0010\u000eJ\u000f\u0010 \u001a\u00020\fH\u0002¢\u0006\u0004\b \u0010\u000eJ\u0011\u0010\"\u001a\u0004\u0018\u00010!H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0014H\u0002¢\u0006\u0004\b$\u0010%JB\u0010(\u001a\u00020\u00142'\u0010\u001c\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00140\u0018j\u0002`\u001b2\b\u0010'\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0004\b(\u0010)J8\u0010+\u001a\u00020*2'\u0010\u001c\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00140\u0018j\u0002`\u001bH\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\u00142\u0006\u0010-\u001a\u00020\bH\u0002¢\u0006\u0004\b.\u0010/JZ\u00104\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010&2\u0006\u0010\t\u001a\u00020\b2#\u00102\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00182\b\u00103\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0004\b4\u00105JH\u00106\u001a\u00020\u00142\b\u00101\u001a\u0004\u0018\u00010&2\u0006\u0010\t\u001a\u00020\b2%\b\u0002\u00102\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018H\u0002¢\u0006\u0004\b6\u00107JJ\u0010\u0001\u001a\u0004\u0018\u0001082\b\u00101\u001a\u0004\u0018\u00010&2\b\u00103\u001a\u0004\u0018\u00010&2#\u00102\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u0001\u00109J\u0019\u0010;\u001a\u00020:2\b\u00101\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0014H\u0002¢\u0006\u0004\b=\u0010%J\u000f\u0010>\u001a\u00020\u0014H\u0016¢\u0006\u0004\b>\u0010%J\u000f\u0010?\u001a\u00020\fH\u0001¢\u0006\u0004\b?\u0010\u000eJ\u0017\u0010B\u001a\n\u0018\u00010@j\u0004\u0018\u0001`AH\u0016¢\u0006\u0004\bB\u0010CJ\u0011\u0010D\u001a\u0004\u0018\u00010&H\u0010¢\u0006\u0004\bD\u0010EJ!\u0010G\u001a\u00020\u00142\b\u0010F\u001a\u0004\u0018\u00010&2\u0006\u0010\u0010\u001a\u00020\u000fH\u0010¢\u0006\u0004\bG\u0010HJ\u0019\u0010I\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\bI\u0010\u0012J\u0017\u0010J\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\bJ\u0010KJ\u001f\u0010L\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020*2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\bL\u0010MJ8\u0010N\u001a\u00020\u00142!\u00102\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00140\u00182\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\bN\u0010\u001eJ\u0017\u0010Q\u001a\u00020\u000f2\u0006\u0010P\u001a\u00020OH\u0016¢\u0006\u0004\bQ\u0010RJ\u0011\u0010S\u001a\u0004\u0018\u00010&H\u0001¢\u0006\u0004\bS\u0010EJ \u0010V\u001a\u00020\u00142\f\u0010U\u001a\b\u0012\u0004\u0012\u00028\u00000TH\u0016ø\u0001\u0000¢\u0006\u0004\bV\u0010WJ<\u0010Y\u001a\u00020\u00142\u0006\u0010X\u001a\u00028\u00002#\u00102\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018H\u0016¢\u0006\u0004\bY\u0010ZJ8\u0010[\u001a\u00020\u00142'\u0010\u001c\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00140\u0018j\u0002`\u001bH\u0016¢\u0006\u0004\b[\u0010\\J\u000f\u0010]\u001a\u00020\u0014H\u0000¢\u0006\u0004\b]\u0010%J#\u0010^\u001a\u0004\u0018\u00010&2\u0006\u0010X\u001a\u00028\u00002\b\u00103\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b^\u0010_JH\u0010`\u001a\u0004\u0018\u00010&2\u0006\u0010X\u001a\u00028\u00002\b\u00103\u001a\u0004\u0018\u00010&2#\u00102\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018H\u0016¢\u0006\u0004\b`\u0010aJ\u0019\u0010c\u001a\u0004\u0018\u00010&2\u0006\u0010b\u001a\u00020\u000fH\u0016¢\u0006\u0004\bc\u0010dJ\u0017\u0010f\u001a\u00020\u00142\u0006\u0010e\u001a\u00020&H\u0016¢\u0006\u0004\bf\u0010WJ\u001b\u0010h\u001a\u00020\u0014*\u00020g2\u0006\u0010X\u001a\u00028\u0000H\u0016¢\u0006\u0004\bh\u0010iJ\u001b\u0010j\u001a\u00020\u0014*\u00020g2\u0006\u0010b\u001a\u00020\u000fH\u0016¢\u0006\u0004\bj\u0010kJ\u001f\u0010l\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010'\u001a\u0004\u0018\u00010&H\u0010¢\u0006\u0004\bl\u0010mJ\u001b\u0010n\u001a\u0004\u0018\u00010\u000f2\b\u0010'\u001a\u0004\u0018\u00010&H\u0010¢\u0006\u0004\bn\u0010oJ\u000f\u0010q\u001a\u00020pH\u0016¢\u0006\u0004\bq\u0010rJ\u000f\u0010s\u001a\u00020pH\u0014¢\u0006\u0004\bs\u0010rR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0000X\u0004¢\u0006\f\n\u0004\bt\u0010u\u001a\u0004\bv\u0010wR\u001a\u0010}\u001a\u00020x8\u0016X\u0004¢\u0006\f\n\u0004\by\u0010z\u001a\u0004\b{\u0010|R\u0019\u0010\u0001\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b~\u0010R\u0016\u0010\u0001\u001a\u00020p8BX\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010rR\u0017\u0010'\u001a\u0004\u0018\u00010&8@X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010ER\u0016\u0010\u0001\u001a\u00020\f8VX\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010\u000eR\u0016\u0010\u0001\u001a\u00020\f8VX\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010\u000eR\u0016\u0010\u0001\u001a\u00020\f8VX\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010\u000eR\u001f\u0010\u0001\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058VX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001\u0002\u0004\n\u0002\b\u0019¨\u0006\u0001"}, d2 = {"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlin/coroutines/Continuation;", "delegate", "", "resumeMode", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "", "C", "()Z", "", "cause", "s", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function0;", "", "block", "o", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "m", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Throwable;)V", "U", "Q", "Lkotlinx/coroutines/DisposableHandle;", "B", "()Lkotlinx/coroutines/DisposableHandle;", "H", "()V", "", "state", "E", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V", "Lkotlinx/coroutines/CancelHandler;", "D", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/CancelHandler;", "mode", "v", "(I)V", "Lkotlinx/coroutines/NotCompleted;", "proposedUpdate", "onCancellation", "idempotent", "O", "(Lkotlinx/coroutines/NotCompleted;Ljava/lang/Object;ILkotlin/jvm/functions/Function1;Ljava/lang/Object;)Ljava/lang/Object;", "J", "(Ljava/lang/Object;ILkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/internal/Symbol;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/Symbol;", "", "l", "(Ljava/lang/Object;)Ljava/lang/Void;", "u", "W", "I", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "K", "()Ljava/lang/StackTraceElement;", "k", "()Ljava/lang/Object;", "takenState", "c", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "d", "G", "(Ljava/lang/Throwable;)V", "n", "(Lkotlinx/coroutines/CancelHandler;Ljava/lang/Throwable;)V", "q", "Lkotlinx/coroutines/Job;", "parent", "x", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "y", "Lkotlin/Result;", "result", "w", "(Ljava/lang/Object;)V", "value", "f0", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "M", "(Lkotlin/jvm/functions/Function1;)V", "t", "r", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "P", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "exception", "N", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "token", "u0", "Lkotlinx/coroutines/CoroutineDispatcher;", "S", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "R", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "h", "(Ljava/lang/Object;)Ljava/lang/Object;", "f", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "", "toString", "()Ljava/lang/String;", "F", "Z", "Lkotlin/coroutines/Continuation;", "e", "()Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/CoroutineContext;", "X2", "Lkotlin/coroutines/CoroutineContext;", "g", "()Lkotlin/coroutines/CoroutineContext;", "context", "Y2", "Lkotlinx/coroutines/DisposableHandle;", "parentHandle", "A", "stateDebugRepresentation", "z", "b", "isActive", "p", "isCompleted", "isCancelled", "j", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class CancellableContinuationImpl<T> extends DispatchedTask<T> implements CancellableContinuation<T>, CoroutineStackFrame {
    private static final /* synthetic */ AtomicIntegerFieldUpdater Z2;
    private static final /* synthetic */ AtomicReferenceFieldUpdater a3;
    @NotNull
    private final CoroutineContext X2;
    @Nullable
    private DisposableHandle Y2;
    @NotNull
    private final Continuation<T> Z;
    @NotNull
    private volatile /* synthetic */ int _decision = 0;
    @NotNull
    private volatile /* synthetic */ Object _state = Active.s;

    static {
        Class<CancellableContinuationImpl> cls = CancellableContinuationImpl.class;
        Z2 = AtomicIntegerFieldUpdater.newUpdater(cls, "_decision");
        a3 = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_state");
    }

    public CancellableContinuationImpl(@NotNull Continuation<? super T> continuation, int i2) {
        super(i2);
        this.Z = continuation;
        this.X2 = continuation.g();
    }

    private final String A() {
        Object z = z();
        if (z instanceof NotCompleted) {
            return "Active";
        }
        return z instanceof CancelledContinuation ? "Cancelled" : "Completed";
    }

    private final DisposableHandle B() {
        Job job = (Job) g().e(Job.P2);
        if (job == null) {
            return null;
        }
        DisposableHandle f2 = Job.DefaultImpls.f(job, true, false, new ChildContinuation(this), 2, (Object) null);
        this.Y2 = f2;
        return f2;
    }

    private final boolean C() {
        return DispatchedTaskKt.d(this.Y) && ((DispatchedContinuation) this.Z).s();
    }

    private final CancelHandler D(Function1<? super Throwable, Unit> function1) {
        return function1 instanceof CancelHandler ? (CancelHandler) function1 : new InvokeOnCancel(function1);
    }

    private final void E(Function1<? super Throwable, Unit> function1, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + function1 + ", already has " + obj).toString());
    }

    private final void H() {
        Throwable z;
        Continuation<T> continuation = this.Z;
        DispatchedContinuation dispatchedContinuation = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        if (dispatchedContinuation != null && (z = dispatchedContinuation.z(this)) != null) {
            t();
            d(z);
        }
    }

    private final void J(Object obj, int i2, Function1<? super Throwable, Unit> function1) {
        Object obj2;
        do {
            obj2 = this._state;
            if (obj2 instanceof NotCompleted) {
            } else {
                if (obj2 instanceof CancelledContinuation) {
                    CancelledContinuation cancelledContinuation = (CancelledContinuation) obj2;
                    if (cancelledContinuation.c()) {
                        if (function1 != null) {
                            q(function1, cancelledContinuation.f29164a);
                            return;
                        }
                        return;
                    }
                }
                l(obj);
                throw new KotlinNothingValueException();
            }
        } while (!a.a(a3, this, obj2, O((NotCompleted) obj2, obj, i2, function1, (Object) null)));
        u();
        v(i2);
    }

    static /* synthetic */ void L(CancellableContinuationImpl cancellableContinuationImpl, Object obj, int i2, Function1 function1, int i3, Object obj2) {
        if (obj2 == null) {
            if ((i3 & 4) != 0) {
                function1 = null;
            }
            cancellableContinuationImpl.J(obj, i2, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    private final Object O(NotCompleted notCompleted, Object obj, int i2, Function1<? super Throwable, Unit> function1, Object obj2) {
        if (obj instanceof CompletedExceptionally) {
            return obj;
        }
        if (!DispatchedTaskKt.c(i2) && obj2 == null) {
            return obj;
        }
        if (function1 == null && ((!(notCompleted instanceof CancelHandler) || (notCompleted instanceof BeforeResumeCancelHandler)) && obj2 == null)) {
            return obj;
        }
        return new CompletedContinuation(obj, notCompleted instanceof CancelHandler ? (CancelHandler) notCompleted : null, function1, obj2, (Throwable) null, 16, (DefaultConstructorMarker) null);
    }

    private final boolean Q() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!Z2.compareAndSet(this, 0, 2));
        return true;
    }

    private final Symbol T(Object obj, Object obj2, Function1<? super Throwable, Unit> function1) {
        Object obj3;
        do {
            obj3 = this._state;
            if (obj3 instanceof NotCompleted) {
            } else if (!(obj3 instanceof CompletedContinuation) || obj2 == null || ((CompletedContinuation) obj3).f29161d != obj2) {
                return null;
            } else {
                return CancellableContinuationImplKt.f29156d;
            }
        } while (!a.a(a3, this, obj3, O((NotCompleted) obj3, obj, this.Y, function1, obj2)));
        u();
        return CancellableContinuationImplKt.f29156d;
    }

    private final boolean U() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!Z2.compareAndSet(this, 0, 1));
        return true;
    }

    private final Void l(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final void m(Function1<? super Throwable, Unit> function1, Throwable th) {
        try {
            function1.f(th);
        } catch (Throwable th2) {
            CoroutineContext g2 = g();
            CoroutineExceptionHandlerKt.b(g2, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    private final void o(Function0<Unit> function0) {
        try {
            function0.o();
        } catch (Throwable th) {
            CoroutineContext g2 = g();
            CoroutineExceptionHandlerKt.b(g2, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
        }
    }

    private final boolean s(Throwable th) {
        if (!C()) {
            return false;
        }
        return ((DispatchedContinuation) this.Z).t(th);
    }

    private final void u() {
        if (!C()) {
            t();
        }
    }

    private final void v(int i2) {
        if (!Q()) {
            DispatchedTaskKt.a(this, i2);
        }
    }

    /* access modifiers changed from: protected */
    @NotNull
    public String F() {
        return "CancellableContinuation";
    }

    public final void G(@NotNull Throwable th) {
        if (!s(th)) {
            d(th);
            u();
        }
    }

    @JvmName(name = "resetStateReusable")
    public final boolean I() {
        Object obj = this._state;
        if (!(obj instanceof CompletedContinuation) || ((CompletedContinuation) obj).f29161d == null) {
            this._decision = 0;
            this._state = Active.s;
            return true;
        }
        t();
        return false;
    }

    @Nullable
    public StackTraceElement K() {
        return null;
    }

    public void M(@NotNull Function1<? super Throwable, Unit> function1) {
        CancelHandler D = D(function1);
        while (true) {
            Object obj = this._state;
            if (obj instanceof Active) {
                if (a.a(a3, this, obj, D)) {
                    return;
                }
            } else if (obj instanceof CancelHandler) {
                E(function1, obj);
            } else if (obj instanceof CompletedExceptionally) {
                CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
                if (!completedExceptionally.b()) {
                    E(function1, obj);
                }
                if (obj instanceof CancelledContinuation) {
                    Throwable th = null;
                    if (!(obj instanceof CompletedExceptionally)) {
                        completedExceptionally = null;
                    }
                    if (completedExceptionally != null) {
                        th = completedExceptionally.f29164a;
                    }
                    m(function1, th);
                    return;
                }
                return;
            } else if (obj instanceof CompletedContinuation) {
                CompletedContinuation completedContinuation = (CompletedContinuation) obj;
                if (completedContinuation.f29159b != null) {
                    E(function1, obj);
                }
                if (!(D instanceof BeforeResumeCancelHandler)) {
                    if (completedContinuation.h()) {
                        m(function1, completedContinuation.f29162e);
                        return;
                    }
                    if (a.a(a3, this, obj, CompletedContinuation.g(completedContinuation, (Object) null, D, (Function1) null, (Object) null, (Throwable) null, 29, (Object) null))) {
                        return;
                    }
                } else {
                    return;
                }
            } else if (!(D instanceof BeforeResumeCancelHandler)) {
                if (a.a(a3, this, obj, new CompletedContinuation(obj, D, (Function1) null, (Object) null, (Throwable) null, 28, (DefaultConstructorMarker) null))) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    @Nullable
    public Object N(@NotNull Throwable th) {
        return T(new CompletedExceptionally(th, false, 2, (DefaultConstructorMarker) null), (Object) null, (Function1<? super Throwable, Unit>) null);
    }

    @Nullable
    public Object P(T t, @Nullable Object obj, @Nullable Function1<? super Throwable, Unit> function1) {
        return T(t, obj, function1);
    }

    public void R(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Throwable th) {
        Continuation<T> continuation = this.Z;
        CoroutineDispatcher coroutineDispatcher2 = null;
        DispatchedContinuation dispatchedContinuation = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        CompletedExceptionally completedExceptionally = new CompletedExceptionally(th, false, 2, (DefaultConstructorMarker) null);
        if (dispatchedContinuation != null) {
            coroutineDispatcher2 = dispatchedContinuation.Z;
        }
        L(this, completedExceptionally, coroutineDispatcher2 == coroutineDispatcher ? 4 : this.Y, (Function1) null, 4, (Object) null);
    }

    public void S(@NotNull CoroutineDispatcher coroutineDispatcher, T t) {
        Continuation<T> continuation = this.Z;
        CoroutineDispatcher coroutineDispatcher2 = null;
        DispatchedContinuation dispatchedContinuation = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        if (dispatchedContinuation != null) {
            coroutineDispatcher2 = dispatchedContinuation.Z;
        }
        L(this, t, coroutineDispatcher2 == coroutineDispatcher ? 4 : this.Y, (Function1) null, 4, (Object) null);
    }

    public void W() {
        DisposableHandle B = B();
        if (B != null && p()) {
            B.m();
            this.Y2 = NonDisposableHandle.s;
        }
    }

    public boolean b() {
        return z() instanceof NotCompleted;
    }

    public void c(@Nullable Object obj, @NotNull Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof NotCompleted) {
                throw new IllegalStateException("Not completed".toString());
            } else if (!(obj2 instanceof CompletedExceptionally)) {
                if (obj2 instanceof CompletedContinuation) {
                    CompletedContinuation completedContinuation = (CompletedContinuation) obj2;
                    if (!completedContinuation.h()) {
                        if (a.a(a3, this, obj2, CompletedContinuation.g(completedContinuation, (Object) null, (CancelHandler) null, (Function1) null, (Object) null, th, 15, (Object) null))) {
                            completedContinuation.i(this, th);
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                } else if (a.a(a3, this, obj2, new CompletedContinuation(obj2, (CancelHandler) null, (Function1) null, (Object) null, th, 14, (DefaultConstructorMarker) null))) {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public boolean d(@Nullable Throwable th) {
        Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof NotCompleted)) {
                return false;
            }
            z = obj instanceof CancelHandler;
        } while (!a.a(a3, this, obj, new CancelledContinuation(this, th, z)));
        CancelHandler cancelHandler = z ? (CancelHandler) obj : null;
        if (cancelHandler != null) {
            n(cancelHandler, th);
        }
        u();
        v(this.Y);
        return true;
    }

    @NotNull
    public final Continuation<T> e() {
        return this.Z;
    }

    @Nullable
    public Throwable f(@Nullable Object obj) {
        Throwable f2 = super.f(obj);
        if (f2 != null) {
            return f2;
        }
        return null;
    }

    public void f0(T t, @Nullable Function1<? super Throwable, Unit> function1) {
        J(t, this.Y, function1);
    }

    @NotNull
    public CoroutineContext g() {
        return this.X2;
    }

    public <T> T h(@Nullable Object obj) {
        return obj instanceof CompletedContinuation ? ((CompletedContinuation) obj).f29158a : obj;
    }

    public boolean isCancelled() {
        return z() instanceof CancelledContinuation;
    }

    @Nullable
    public CoroutineStackFrame j() {
        Continuation<T> continuation = this.Z;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Nullable
    public Object k() {
        return z();
    }

    public final void n(@NotNull CancelHandler cancelHandler, @Nullable Throwable th) {
        try {
            cancelHandler.b(th);
        } catch (Throwable th2) {
            CoroutineContext g2 = g();
            CoroutineExceptionHandlerKt.b(g2, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public boolean p() {
        return !(z() instanceof NotCompleted);
    }

    public final void q(@NotNull Function1<? super Throwable, Unit> function1, @NotNull Throwable th) {
        try {
            function1.f(th);
        } catch (Throwable th2) {
            CoroutineContext g2 = g();
            CoroutineExceptionHandlerKt.b(g2, new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    @Nullable
    public Object r(T t, @Nullable Object obj) {
        return T(t, obj, (Function1<? super Throwable, Unit>) null);
    }

    public final void t() {
        DisposableHandle disposableHandle = this.Y2;
        if (disposableHandle != null) {
            disposableHandle.m();
            this.Y2 = NonDisposableHandle.s;
        }
    }

    @NotNull
    public String toString() {
        return F() + ASCIIPropertyListParser.f18649g + DebugStringsKt.c(this.Z) + "){" + A() + "}@" + DebugStringsKt.b(this);
    }

    public void u0(@NotNull Object obj) {
        v(this.Y);
    }

    public void w(@NotNull Object obj) {
        L(this, CompletionStateKt.c(obj, this), this.Y, (Function1) null, 4, (Object) null);
    }

    @NotNull
    public Throwable x(@NotNull Job job) {
        return job.I();
    }

    @Nullable
    @PublishedApi
    public final Object y() {
        Job job;
        boolean C = C();
        if (U()) {
            if (this.Y2 == null) {
                B();
            }
            if (C) {
                H();
            }
            return IntrinsicsKt.l();
        }
        if (C) {
            H();
        }
        Object z = z();
        if (z instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) z).f29164a;
        } else if (!DispatchedTaskKt.c(this.Y) || (job = (Job) g().e(Job.P2)) == null || job.b()) {
            return h(z);
        } else {
            CancellationException I = job.I();
            c(z, I);
            throw I;
        }
    }

    @Nullable
    public final Object z() {
        return this._state;
    }
}
