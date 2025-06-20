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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt$ticker$3", f = "TickerChannels.kt", i = {}, l = {72, 73}, m = "invokeSuspend", n = {}, s = {})
final class TickerChannelsKt$ticker$3 extends SuspendLambda implements Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object> {
    int X2;
    private /* synthetic */ Object Y2;
    final /* synthetic */ TickerMode Z2;
    final /* synthetic */ long a3;
    final /* synthetic */ long b3;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29251a;

        static {
            int[] iArr = new int[TickerMode.values().length];
            iArr[TickerMode.FIXED_PERIOD.ordinal()] = 1;
            iArr[TickerMode.FIXED_DELAY.ordinal()] = 2;
            f29251a = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TickerChannelsKt$ticker$3(TickerMode tickerMode, long j2, long j3, Continuation<? super TickerChannelsKt$ticker$3> continuation) {
        super(2, continuation);
        this.Z2 = tickerMode;
        this.a3 = j2;
        this.b3 = j3;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        Object l2 = IntrinsicsKt.l();
        int i2 = this.X2;
        if (i2 == 0) {
            ResultKt.n(obj);
            ProducerScope producerScope = (ProducerScope) this.Y2;
            int i3 = WhenMappings.f29251a[this.Z2.ordinal()];
            if (i3 == 1) {
                long j2 = this.a3;
                long j3 = this.b3;
                SendChannel a2 = producerScope.a();
                this.X2 = 1;
                if (TickerChannelsKt.d(j2, j3, a2, this) == l2) {
                    return l2;
                }
            } else if (i3 == 2) {
                long j4 = this.a3;
                long j5 = this.b3;
                SendChannel a4 = producerScope.a();
                this.X2 = 2;
                if (TickerChannelsKt.c(j4, j5, a4, this) == l2) {
                    return l2;
                }
            }
        } else if (i2 == 1 || i2 == 2) {
            ResultKt.n(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f28779a;
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull ProducerScope<? super Unit> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TickerChannelsKt$ticker$3) v(producerScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TickerChannelsKt$ticker$3 tickerChannelsKt$ticker$3 = new TickerChannelsKt$ticker$3(this.Z2, this.a3, this.b3, continuation);
        tickerChannelsKt$ticker$3.Y2 = obj;
        return tickerChannelsKt$ticker$3;
    }
}
