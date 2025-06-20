package androidx.datastore.core;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002Bh\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\t\u0012\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\tø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R3\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t8\u0002X\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00168\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Landroidx/datastore/core/SimpleActor;", "T", "", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlin/Function1;", "", "", "onComplete", "Lkotlin/Function2;", "onUndeliveredElement", "Lkotlin/coroutines/Continuation;", "consumeMessage", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "msg", "e", "(Ljava/lang/Object;)V", "a", "Lkotlinx/coroutines/CoroutineScope;", "b", "Lkotlin/jvm/functions/Function2;", "Lkotlinx/coroutines/channels/Channel;", "c", "Lkotlinx/coroutines/channels/Channel;", "messageQueue", "Ljava/util/concurrent/atomic/AtomicInteger;", "d", "Ljava/util/concurrent/atomic/AtomicInteger;", "remainingMessages", "datastore-core"}, k = 1, mv = {1, 5, 1})
public final class SimpleActor<T> {
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final CoroutineScope f6907a;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final Function2<T, Continuation<? super Unit>, Object> f6908b;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final Channel<T> f6909c = ChannelKt.d(Integer.MAX_VALUE, (BufferOverflow) null, (Function1) null, 6, (Object) null);
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public final AtomicInteger f6910d = new AtomicInteger(0);

    public SimpleActor(@NotNull CoroutineScope coroutineScope, @NotNull final Function1<? super Throwable, Unit> function1, @NotNull final Function2<? super T, ? super Throwable, Unit> function2, @NotNull Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function22) {
        Intrinsics.p(coroutineScope, "scope");
        Intrinsics.p(function1, "onComplete");
        Intrinsics.p(function2, "onUndeliveredElement");
        Intrinsics.p(function22, "consumeMessage");
        this.f6907a = coroutineScope;
        this.f6908b = function22;
        Job job = (Job) coroutineScope.U().e(Job.P2);
        if (job != null) {
            job.Z(new Function1<Throwable, Unit>() {
                public final void b(@Nullable Throwable th) {
                    Unit unit;
                    function1.f(th);
                    this.f6909c.T(th);
                    do {
                        Object h2 = ChannelResult.h(this.f6909c.B());
                        if (h2 == null) {
                            unit = null;
                            continue;
                        } else {
                            function2.d0(h2, th);
                            unit = Unit.f28779a;
                            continue;
                        }
                    } while (unit != null);
                }

                public /* bridge */ /* synthetic */ Object f(Object obj) {
                    b((Throwable) obj);
                    return Unit.f28779a;
                }
            });
        }
    }

    public final void e(T t) {
        Object Y = this.f6909c.Y(t);
        if (Y instanceof ChannelResult.Closed) {
            Throwable f2 = ChannelResult.f(Y);
            if (f2 == null) {
                f2 = new ClosedSendChannelException("Channel was closed normally");
            }
            throw f2;
        } else if (!ChannelResult.m(Y)) {
            throw new IllegalStateException("Check failed.".toString());
        } else if (this.f6910d.getAndIncrement() == 0) {
            Job unused = BuildersKt__Builders_commonKt.f(this.f6907a, (CoroutineContext) null, (CoroutineStart) null, new SimpleActor$offer$2(this, (Continuation<? super SimpleActor$offer$2>) null), 3, (Object) null);
        }
    }
}
