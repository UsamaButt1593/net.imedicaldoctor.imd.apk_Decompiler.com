package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u0004B-\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J5\u0010\u0015\u001a\u00020\u00032#\u0010\u0014\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00030\u0011H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u001f\u001a\u00028\u0000HAø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\"\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000!HAø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0001\u0010 J\u0015\u0010\"\u001a\u0004\u0018\u00018\u0000HAø\u0001\u0000¢\u0006\u0004\b\"\u0010 J\u001b\u0010#\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00028\u0000HAø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u001f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0001ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b%\u0010\u001eJ'\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030!2\u0006\u0010\u001a\u001a\u00028\u0000H\u0001ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0003H\u0016¢\u0006\u0004\b(\u0010)J\u0019\u0010*\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0004\b*\u0010\u0010J\u001d\u0010-\u001a\u00020\u00032\u000e\u0010\u000e\u001a\n\u0018\u00010+j\u0004\u0018\u0001`,¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b/\u00100R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0004X\u0004¢\u0006\f\n\u0004\b&\u00101\u001a\u0004\b2\u00103R\u0014\u00106\u001a\u00020\b8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00108\u001a\u00020\b8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b7\u00105R\u0014\u00109\u001a\u00020\b8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b9\u00105R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000:8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b;\u0010<R#\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000!0:8\u0016X\u0005ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b>\u0010<R\u001c\u0010A\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000:8VX\u0005¢\u0006\u0006\u001a\u0004\b@\u0010<R&\u0010F\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000C0B8\u0016X\u0005¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0017\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048F¢\u0006\u0006\u001a\u0004\bG\u00103\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006I"}, d2 = {"Lkotlinx/coroutines/channels/ChannelCoroutine;", "E", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/Channel;", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "_channel", "", "initParentJob", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;ZZ)V", "", "cause", "T", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "handler", "X", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "()Lkotlinx/coroutines/channels/ChannelIterator;", "element", "offer", "(Ljava/lang/Object;)Z", "poll", "()Ljava/lang/Object;", "Q", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "D", "g0", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "B", "Y", "(Ljava/lang/Object;)Ljava/lang/Object;", "cancel", "()V", "d", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "i", "(Ljava/util/concurrent/CancellationException;)V", "y0", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/channels/Channel;", "K1", "()Lkotlinx/coroutines/channels/Channel;", "l", "()Z", "isClosedForReceive", "i0", "isClosedForSend", "isEmpty", "Lkotlinx/coroutines/selects/SelectClause1;", "m", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceive", "o", "onReceiveCatching", "z", "onReceiveOrNull", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "G", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "a", "channel", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class ChannelCoroutine<E> extends AbstractCoroutine<Unit> implements Channel<E> {
    @NotNull
    private final Channel<E> Y;

    public ChannelCoroutine(@NotNull CoroutineContext coroutineContext, @NotNull Channel<E> channel, boolean z, boolean z2) {
        super(coroutineContext, z, z2);
        this.Y = channel;
    }

    @NotNull
    public Object B() {
        return this.Y.B();
    }

    @Nullable
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    @LowPriorityInOverloadResolution
    public Object D(@NotNull Continuation<? super E> continuation) {
        return this.Y.D(continuation);
    }

    @Nullable
    public Object E(@NotNull Continuation<? super ChannelResult<? extends E>> continuation) {
        Object E = this.Y.E(continuation);
        IntrinsicsKt.l();
        return E;
    }

    @NotNull
    public SelectClause2<E, SendChannel<E>> G() {
        return this.Y.G();
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final Channel<E> K1() {
        return this.Y;
    }

    @Nullable
    public Object Q(@NotNull Continuation<? super E> continuation) {
        return this.Y.Q(continuation);
    }

    public boolean T(@Nullable Throwable th) {
        return this.Y.T(th);
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
    public final Channel<E> a() {
        return this;
    }

    public /* synthetic */ void cancel() {
        y0(new JobCancellationException(B0(), (Throwable) null, this));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public final /* synthetic */ boolean d(Throwable th) {
        y0(new JobCancellationException(B0(), (Throwable) null, this));
        return true;
    }

    @Nullable
    public Object g0(E e2, @NotNull Continuation<? super Unit> continuation) {
        return this.Y.g0(e2, continuation);
    }

    public final void i(@Nullable CancellationException cancellationException) {
        if (!isCancelled()) {
            if (cancellationException == null) {
                cancellationException = new JobCancellationException(B0(), (Throwable) null, this);
            }
            y0(cancellationException);
        }
    }

    public boolean i0() {
        return this.Y.i0();
    }

    public boolean isEmpty() {
        return this.Y.isEmpty();
    }

    @NotNull
    public ChannelIterator<E> iterator() {
        return this.Y.iterator();
    }

    public boolean l() {
        return this.Y.l();
    }

    @NotNull
    public SelectClause1<E> m() {
        return this.Y.m();
    }

    @NotNull
    public SelectClause1<ChannelResult<E>> o() {
        return this.Y.o();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e2) {
        return this.Y.offer(e2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    @Nullable
    public E poll() {
        return this.Y.poll();
    }

    public void y0(@NotNull Throwable th) {
        CancellationException y1 = JobSupport.y1(this, th, (String) null, 1, (Object) null);
        this.Y.i(y1);
        w0(y1);
    }

    @NotNull
    public SelectClause1<E> z() {
        return this.Y.z();
    }
}
