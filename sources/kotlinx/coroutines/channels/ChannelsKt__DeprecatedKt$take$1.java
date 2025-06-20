package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {254, 255}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "remaining"}, s = {"L$0", "I$0", "L$0", "I$0"})
final class ChannelsKt__DeprecatedKt$take$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    Object X2;
    int Y2;
    int Z2;
    private /* synthetic */ Object a3;
    final /* synthetic */ int b3;
    final /* synthetic */ ReceiveChannel<Object> c3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$take$1(int i2, ReceiveChannel<Object> receiveChannel, Continuation<? super ChannelsKt__DeprecatedKt$take$1> continuation) {
        super(2, continuation);
        this.b3 = i2;
        this.c3 = receiveChannel;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0068  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object D(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r1 = r7.Z2
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0033
            if (r1 == r3) goto L_0x0025
            if (r1 != r2) goto L_0x001d
            int r1 = r7.Y2
            java.lang.Object r4 = r7.X2
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            java.lang.Object r5 = r7.a3
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.n(r8)
        L_0x001b:
            r8 = r5
            goto L_0x007b
        L_0x001d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0025:
            int r1 = r7.Y2
            java.lang.Object r4 = r7.X2
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            java.lang.Object r5 = r7.a3
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.n(r8)
            goto L_0x0060
        L_0x0033:
            kotlin.ResultKt.n(r8)
            java.lang.Object r8 = r7.a3
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            int r1 = r7.b3
            if (r1 != 0) goto L_0x0041
            kotlin.Unit r8 = kotlin.Unit.f28779a
            return r8
        L_0x0041:
            if (r1 < 0) goto L_0x0045
            r4 = 1
            goto L_0x0046
        L_0x0045:
            r4 = 0
        L_0x0046:
            if (r4 == 0) goto L_0x0085
            kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r4 = r7.c3
            kotlinx.coroutines.channels.ChannelIterator r4 = r4.iterator()
        L_0x004e:
            r7.a3 = r8
            r7.X2 = r4
            r7.Y2 = r1
            r7.Z2 = r3
            java.lang.Object r5 = r4.a(r7)
            if (r5 != r0) goto L_0x005d
            return r0
        L_0x005d:
            r6 = r5
            r5 = r8
            r8 = r6
        L_0x0060:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0082
            java.lang.Object r8 = r4.next()
            r7.a3 = r5
            r7.X2 = r4
            r7.Y2 = r1
            r7.Z2 = r2
            java.lang.Object r8 = r5.g0(r8, r7)
            if (r8 != r0) goto L_0x001b
            return r0
        L_0x007b:
            int r1 = r1 + -1
            if (r1 != 0) goto L_0x004e
            kotlin.Unit r8 = kotlin.Unit.f28779a
            return r8
        L_0x0082:
            kotlin.Unit r8 = kotlin.Unit.f28779a
            return r8
        L_0x0085:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Requested element count "
            r8.append(r0)
            r8.append(r1)
            java.lang.String r0 = " is less than zero."
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r8 = r8.toString()
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1.D(java.lang.Object):java.lang.Object");
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull ProducerScope<Object> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$take$1) v(producerScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$take$1 channelsKt__DeprecatedKt$take$1 = new ChannelsKt__DeprecatedKt$take$1(this.b3, this.c3, continuation);
        channelsKt__DeprecatedKt$take$1.a3 = obj;
        return channelsKt__DeprecatedKt$take$1;
    }
}
