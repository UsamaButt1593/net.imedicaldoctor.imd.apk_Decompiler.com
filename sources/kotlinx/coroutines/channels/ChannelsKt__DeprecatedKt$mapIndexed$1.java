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

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H@"}, d2 = {"<anonymous>", "", "E", "R", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {344, 345, 345}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
final class ChannelsKt__DeprecatedKt$mapIndexed$1 extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> {
    Object X2;
    Object Y2;
    int Z2;
    int a3;
    private /* synthetic */ Object b3;
    final /* synthetic */ ReceiveChannel<E> c3;
    final /* synthetic */ Function3<Integer, E, Continuation<? super R>, Object> d3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$mapIndexed$1(ReceiveChannel<? extends E> receiveChannel, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super ChannelsKt__DeprecatedKt$mapIndexed$1> continuation) {
        super(2, continuation);
        this.c3 = receiveChannel;
        this.d3 = function3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a5  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object D(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r1 = r10.a3
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0048
            if (r1 == r4) goto L_0x003a
            if (r1 == r3) goto L_0x0028
            if (r1 != r2) goto L_0x0020
            int r1 = r10.Z2
            java.lang.Object r5 = r10.X2
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r10.b3
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            kotlin.ResultKt.n(r11)
            r11 = r6
            goto L_0x0058
        L_0x0020:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0028:
            int r1 = r10.Z2
            java.lang.Object r5 = r10.Y2
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            java.lang.Object r6 = r10.X2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r10.b3
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            kotlin.ResultKt.n(r11)
            goto L_0x0093
        L_0x003a:
            int r1 = r10.Z2
            java.lang.Object r5 = r10.X2
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r10.b3
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            kotlin.ResultKt.n(r11)
            goto L_0x006a
        L_0x0048:
            kotlin.ResultKt.n(r11)
            java.lang.Object r11 = r10.b3
            kotlinx.coroutines.channels.ProducerScope r11 = (kotlinx.coroutines.channels.ProducerScope) r11
            kotlinx.coroutines.channels.ReceiveChannel<E> r1 = r10.c3
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r5 = 0
            r5 = r1
            r1 = 0
        L_0x0058:
            r10.b3 = r11
            r10.X2 = r5
            r10.Z2 = r1
            r10.a3 = r4
            java.lang.Object r6 = r5.a(r10)
            if (r6 != r0) goto L_0x0067
            return r0
        L_0x0067:
            r9 = r6
            r6 = r11
            r11 = r9
        L_0x006a:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x00a8
            java.lang.Object r11 = r5.next()
            kotlin.jvm.functions.Function3<java.lang.Integer, E, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r7 = r10.d3
            int r8 = r1 + 1
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.f(r1)
            r10.b3 = r6
            r10.X2 = r5
            r10.Y2 = r6
            r10.Z2 = r8
            r10.a3 = r3
            java.lang.Object r11 = r7.A(r1, r11, r10)
            if (r11 != r0) goto L_0x008f
            return r0
        L_0x008f:
            r7 = r6
            r1 = r8
            r6 = r5
            r5 = r7
        L_0x0093:
            r10.b3 = r7
            r10.X2 = r6
            r8 = 0
            r10.Y2 = r8
            r10.Z2 = r1
            r10.a3 = r2
            java.lang.Object r11 = r5.g0(r11, r10)
            if (r11 != r0) goto L_0x00a5
            return r0
        L_0x00a5:
            r5 = r6
            r11 = r7
            goto L_0x0058
        L_0x00a8:
            kotlin.Unit r11 = kotlin.Unit.f28779a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1.D(java.lang.Object):java.lang.Object");
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull ProducerScope<? super R> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$mapIndexed$1) v(producerScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$mapIndexed$1 channelsKt__DeprecatedKt$mapIndexed$1 = new ChannelsKt__DeprecatedKt$mapIndexed$1(this.c3, this.d3, continuation);
        channelsKt__DeprecatedKt$mapIndexed$1.b3 = obj;
        return channelsKt__DeprecatedKt$mapIndexed$1;
    }
}
