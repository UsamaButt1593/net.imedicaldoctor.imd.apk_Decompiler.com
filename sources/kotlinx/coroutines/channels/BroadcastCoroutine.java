package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.selects.SelectClause2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u0005B%\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ5\u0010\u0013\u001a\u00020\u00032#\u0010\u0012\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00030\rH\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00028\u0000HAø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d2\u0006\u0010\u0015\u001a\u00028\u0000H\u0001ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010 \u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b \u0010!J\u001d\u0010$\u001a\u00020\u00032\u000e\u0010\u0011\u001a\n\u0018\u00010\"j\u0004\u0018\u0001`#¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003H\u0014¢\u0006\u0004\b)\u0010*J\u001f\u0010,\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\tH\u0014¢\u0006\u0004\b,\u0010-J\u0019\u0010.\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b.\u0010!R \u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0004X\u0004¢\u0006\f\n\u0004\b\u001e\u0010/\u001a\u0004\b0\u00101R\u0014\u00104\u001a\u00020\t8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b2\u00103R&\u00109\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000006058\u0016X\u0005¢\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u0010;\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b:\u00103R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00028\u0000068VX\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006?"}, d2 = {"Lkotlinx/coroutines/channels/BroadcastCoroutine;", "E", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlinx/coroutines/channels/BroadcastChannel;", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "_channel", "", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/BroadcastChannel;Z)V", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "handler", "X", "(Lkotlin/jvm/functions/Function1;)V", "element", "offer", "(Ljava/lang/Object;)Z", "Lkotlinx/coroutines/channels/ReceiveChannel;", "V", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "g0", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "Y", "(Ljava/lang/Object;)Ljava/lang/Object;", "d", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "i", "(Ljava/util/concurrent/CancellationException;)V", "y0", "(Ljava/lang/Throwable;)V", "value", "L1", "(Lkotlin/Unit;)V", "handled", "H1", "(Ljava/lang/Throwable;Z)V", "T", "Lkotlinx/coroutines/channels/BroadcastChannel;", "K1", "()Lkotlinx/coroutines/channels/BroadcastChannel;", "i0", "()Z", "isClosedForSend", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "G", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "b", "isActive", "a", "()Lkotlinx/coroutines/channels/SendChannel;", "channel", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
class BroadcastCoroutine<E> extends AbstractCoroutine<Unit> implements ProducerScope<E>, BroadcastChannel<E> {
    @NotNull
    private final BroadcastChannel<E> Y;

    public BroadcastCoroutine(@NotNull CoroutineContext coroutineContext, @NotNull BroadcastChannel<E> broadcastChannel, boolean z) {
        super(coroutineContext, false, z);
        this.Y = broadcastChannel;
        W0((Job) coroutineContext.e(Job.P2));
    }

    @NotNull
    public SelectClause2<E, SendChannel<E>> G() {
        return this.Y.G();
    }

    /* access modifiers changed from: protected */
    public void H1(@NotNull Throwable th, boolean z) {
        if (!this.Y.T(th) && !z) {
            CoroutineExceptionHandlerKt.b(g(), th);
        }
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final BroadcastChannel<E> K1() {
        return this.Y;
    }

    /* access modifiers changed from: protected */
    /* renamed from: L1 */
    public void I1(@NotNull Unit unit) {
        SendChannel.DefaultImpls.a(this.Y, (Throwable) null, 1, (Object) null);
    }

    public boolean T(@Nullable Throwable th) {
        boolean T = this.Y.T(th);
        start();
        return T;
    }

    @NotNull
    public ReceiveChannel<E> V() {
        return this.Y.V();
    }

    @ExperimentalCoroutinesApi
    public void X(@NotNull Function1<? super Throwable, Unit> function1) {
        this.Y.X(function1);
    }

    @NotNull
    public Object Y(E e2) {
        return this.Y.Y(e2);
    }

    @NotNull
    public SendChannel<E> a() {
        return this;
    }

    public boolean b() {
        return super.b();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final /* synthetic */ boolean d(Throwable th) {
        if (th == null) {
            th = new JobCancellationException(B0(), (Throwable) null, this);
        }
        y0(th);
        return true;
    }

    @Nullable
    public Object g0(E e2, @NotNull Continuation<? super Unit> continuation) {
        return this.Y.g0(e2, continuation);
    }

    public final void i(@Nullable CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(B0(), (Throwable) null, this);
        }
        y0(cancellationException);
    }

    public boolean i0() {
        return this.Y.i0();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e2) {
        return this.Y.offer(e2);
    }

    public void y0(@NotNull Throwable th) {
        CancellationException y1 = JobSupport.y1(this, th, (String) null, 1, (Object) null);
        this.Y.i(y1);
        w0(y1);
    }
}
