package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {211, 212, 212}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "e", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "L$2", "I$0", "L$0", "I$0"})
final class ChannelsKt__DeprecatedKt$filterIndexed$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    Object X2;
    Object Y2;
    int Z2;
    int a3;
    private /* synthetic */ Object b3;
    final /* synthetic */ ReceiveChannel<Object> c3;
    final /* synthetic */ Function3<Integer, Object, Continuation<? super Boolean>, Object> d3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$filterIndexed$1(ReceiveChannel<Object> receiveChannel, Function3<? super Integer, Object, ? super Continuation<? super Boolean>, ? extends Object> function3, Continuation<? super ChannelsKt__DeprecatedKt$filterIndexed$1> continuation) {
        super(2, continuation);
        this.c3 = receiveChannel;
        this.d3 = function3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x009c  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object D(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r1 = r11.a3
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0049
            if (r1 == r5) goto L_0x003b
            if (r1 == r4) goto L_0x0028
            if (r1 != r3) goto L_0x0020
            int r1 = r11.Z2
            java.lang.Object r6 = r11.X2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r11.b3
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            kotlin.ResultKt.n(r12)
            goto L_0x005a
        L_0x0020:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0028:
            int r1 = r11.Z2
            java.lang.Object r6 = r11.Y2
            java.lang.Object r7 = r11.X2
            kotlinx.coroutines.channels.ChannelIterator r7 = (kotlinx.coroutines.channels.ChannelIterator) r7
            java.lang.Object r8 = r11.b3
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            kotlin.ResultKt.n(r12)
            r10 = r7
            r7 = r6
            r6 = r10
            goto L_0x0094
        L_0x003b:
            int r1 = r11.Z2
            java.lang.Object r6 = r11.X2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r11.b3
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            kotlin.ResultKt.n(r12)
            goto L_0x006b
        L_0x0049:
            kotlin.ResultKt.n(r12)
            java.lang.Object r12 = r11.b3
            kotlinx.coroutines.channels.ProducerScope r12 = (kotlinx.coroutines.channels.ProducerScope) r12
            kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r1 = r11.c3
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r6 = 0
            r7 = r12
            r6 = r1
            r1 = 0
        L_0x005a:
            r11.b3 = r7
            r11.X2 = r6
            r11.Y2 = r2
            r11.Z2 = r1
            r11.a3 = r5
            java.lang.Object r12 = r6.a(r11)
            if (r12 != r0) goto L_0x006b
            return r0
        L_0x006b:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x00af
            java.lang.Object r12 = r6.next()
            kotlin.jvm.functions.Function3<java.lang.Integer, java.lang.Object, kotlin.coroutines.Continuation<? super java.lang.Boolean>, java.lang.Object> r8 = r11.d3
            int r9 = r1 + 1
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.f(r1)
            r11.b3 = r7
            r11.X2 = r6
            r11.Y2 = r12
            r11.Z2 = r9
            r11.a3 = r4
            java.lang.Object r1 = r8.A(r1, r12, r11)
            if (r1 != r0) goto L_0x0090
            return r0
        L_0x0090:
            r8 = r7
            r7 = r12
            r12 = r1
            r1 = r9
        L_0x0094:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x00ad
            r11.b3 = r8
            r11.X2 = r6
            r11.Y2 = r2
            r11.Z2 = r1
            r11.a3 = r3
            java.lang.Object r12 = r8.g0(r7, r11)
            if (r12 != r0) goto L_0x00ad
            return r0
        L_0x00ad:
            r7 = r8
            goto L_0x005a
        L_0x00af:
            kotlin.Unit r12 = kotlin.Unit.f28779a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1.D(java.lang.Object):java.lang.Object");
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull ProducerScope<Object> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$filterIndexed$1) v(producerScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$filterIndexed$1 channelsKt__DeprecatedKt$filterIndexed$1 = new ChannelsKt__DeprecatedKt$filterIndexed$1(this.c3, this.d3, continuation);
        channelsKt__DeprecatedKt$filterIndexed$1.b3 = obj;
        return channelsKt__DeprecatedKt$filterIndexed$1;
    }
}
