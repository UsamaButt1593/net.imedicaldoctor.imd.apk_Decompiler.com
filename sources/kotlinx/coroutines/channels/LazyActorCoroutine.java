package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003BO\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012-\u0010\u000f\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\t¢\u0006\u0002\b\u000eø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J&\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001a2\u0006\u0010\u0014\u001a\u00028\u0000H\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001f\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 JX\u0010%\u001a\u00020\f\"\u0004\b\u0001\u0010!2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\"2\u0006\u0010$\u001a\u00028\u00002(\u0010\u000f\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\tH\u0016ø\u0001\u0000¢\u0006\u0004\b%\u0010&R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R&\u0010,\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"Lkotlinx/coroutines/channels/LazyActorCoroutine;", "E", "Lkotlinx/coroutines/channels/ActorCoroutine;", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "Lkotlinx/coroutines/channels/Channel;", "channel", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ActorScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "block", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function2;)V", "o1", "()V", "element", "g0", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "offer", "(Ljava/lang/Object;)Z", "Lkotlinx/coroutines/channels/ChannelResult;", "Y", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "cause", "T", "(Ljava/lang/Throwable;)Z", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "param", "b0", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Z", "Lkotlin/coroutines/Continuation;", "continuation", "G", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class LazyActorCoroutine<E> extends ActorCoroutine<E> implements SelectClause2<E, SendChannel<? super E>> {
    @NotNull
    private Continuation<? super Unit> Z;

    public LazyActorCoroutine(@NotNull CoroutineContext coroutineContext, @NotNull Channel<E> channel, @NotNull Function2<? super ActorScope<E>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        super(coroutineContext, channel, false);
        this.Z = IntrinsicsKt.c(function2, this, this);
    }

    @NotNull
    public SelectClause2<E, SendChannel<E>> G() {
        return this;
    }

    public boolean T(@Nullable Throwable th) {
        boolean T = super.T(th);
        start();
        return T;
    }

    @NotNull
    public Object Y(E e2) {
        start();
        return super.Y(e2);
    }

    public <R> void b0(@NotNull SelectInstance<? super R> selectInstance, E e2, @NotNull Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
        start();
        super.G().b0(selectInstance, e2, function2);
    }

    @Nullable
    public Object g0(E e2, @NotNull Continuation<? super Unit> continuation) {
        start();
        Object g0 = super.g0(e2, continuation);
        return g0 == IntrinsicsKt.l() ? g0 : Unit.f28779a;
    }

    /* access modifiers changed from: protected */
    public void o1() {
        CancellableKt.c(this.Z, this);
    }

    public boolean offer(E e2) {
        start();
        return super.offer(e2);
    }
}
