package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0002\b\u0004\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0006\b\u0001\u0010\u0002 \u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H@"}, d2 = {"<anonymous>", "R", "E", "it", "Lkotlinx/coroutines/channels/ChannelResult;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ReceiveChannel$onReceiveOrNull$1$registerSelectClause1$1", f = "Channel.kt", i = {}, l = {375}, m = "invokeSuspend", n = {}, s = {})
final class ReceiveChannel$onReceiveOrNull$1$registerSelectClause1$1 extends SuspendLambda implements Function2<ChannelResult<? extends E>, Continuation<? super R>, Object> {
    int X2;
    /* synthetic */ Object Y2;
    final /* synthetic */ Function2<E, Continuation<? super R>, Object> Z2;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReceiveChannel$onReceiveOrNull$1$registerSelectClause1$1(Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super ReceiveChannel$onReceiveOrNull$1$registerSelectClause1$1> continuation) {
        super(2, continuation);
        this.Z2 = function2;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        Object l2 = IntrinsicsKt.l();
        int i2 = this.X2;
        if (i2 == 0) {
            ResultKt.n(obj);
            Object o = ((ChannelResult) this.Y2).o();
            Throwable f2 = ChannelResult.f(o);
            if (f2 == null) {
                Function2<E, Continuation<? super R>, Object> function2 = this.Z2;
                Object h2 = ChannelResult.h(o);
                this.X2 = 1;
                obj = function2.d0(h2, this);
                if (obj == l2) {
                    return l2;
                }
            } else {
                throw f2;
            }
        } else if (i2 == 1) {
            ResultKt.n(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }

    @Nullable
    public final Object U(@NotNull Object obj, @Nullable Continuation<? super R> continuation) {
        return ((ReceiveChannel$onReceiveOrNull$1$registerSelectClause1$1) v(ChannelResult.b(obj), continuation)).D(Unit.f28779a);
    }

    public /* bridge */ /* synthetic */ Object d0(Object obj, Object obj2) {
        return U(((ChannelResult) obj).o(), (Continuation) obj2);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ReceiveChannel$onReceiveOrNull$1$registerSelectClause1$1 receiveChannel$onReceiveOrNull$1$registerSelectClause1$1 = new ReceiveChannel$onReceiveOrNull$1$registerSelectClause1$1(this.Z2, continuation);
        receiveChannel$onReceiveOrNull$1$registerSelectClause1$1.Y2 = obj;
        return receiveChannel$onReceiveOrNull$1$registerSelectClause1$1;
    }
}
