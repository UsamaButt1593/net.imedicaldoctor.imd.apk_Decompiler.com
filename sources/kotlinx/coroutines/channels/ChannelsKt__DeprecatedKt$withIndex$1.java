package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H@"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/collections/IndexedValue;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {370, 371}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "I$0"})
final class ChannelsKt__DeprecatedKt$withIndex$1 extends SuspendLambda implements Function2<ProducerScope<? super IndexedValue<Object>>, Continuation<? super Unit>, Object> {
    Object X2;
    int Y2;
    int Z2;
    private /* synthetic */ Object a3;
    final /* synthetic */ ReceiveChannel<Object> b3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$withIndex$1(ReceiveChannel<Object> receiveChannel, Continuation<? super ChannelsKt__DeprecatedKt$withIndex$1> continuation) {
        super(2, continuation);
        this.b3 = receiveChannel;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0061  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object D(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r1 = r10.Z2
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0036
            if (r1 == r3) goto L_0x0028
            if (r1 != r2) goto L_0x0020
            int r1 = r10.Y2
            java.lang.Object r4 = r10.X2
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            java.lang.Object r5 = r10.a3
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.n(r11)
            r11 = r5
            r8 = r4
            r4 = r1
            r1 = r8
            goto L_0x0044
        L_0x0020:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0028:
            int r1 = r10.Y2
            java.lang.Object r4 = r10.X2
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            java.lang.Object r5 = r10.a3
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.n(r11)
            goto L_0x0059
        L_0x0036:
            kotlin.ResultKt.n(r11)
            java.lang.Object r11 = r10.a3
            kotlinx.coroutines.channels.ProducerScope r11 = (kotlinx.coroutines.channels.ProducerScope) r11
            kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r1 = r10.b3
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r4 = 0
        L_0x0044:
            r10.a3 = r11
            r10.X2 = r1
            r10.Y2 = r4
            r10.Z2 = r3
            java.lang.Object r5 = r1.a(r10)
            if (r5 != r0) goto L_0x0053
            return r0
        L_0x0053:
            r8 = r5
            r5 = r11
            r11 = r8
            r9 = r4
            r4 = r1
            r1 = r9
        L_0x0059:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x007f
            java.lang.Object r11 = r4.next()
            kotlin.collections.IndexedValue r6 = new kotlin.collections.IndexedValue
            int r7 = r1 + 1
            r6.<init>(r1, r11)
            r10.a3 = r5
            r10.X2 = r4
            r10.Y2 = r7
            r10.Z2 = r2
            java.lang.Object r11 = r5.g0(r6, r10)
            if (r11 != r0) goto L_0x007b
            return r0
        L_0x007b:
            r1 = r4
            r11 = r5
            r4 = r7
            goto L_0x0044
        L_0x007f:
            kotlin.Unit r11 = kotlin.Unit.f28779a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1.D(java.lang.Object):java.lang.Object");
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull ProducerScope<? super IndexedValue<Object>> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$withIndex$1) v(producerScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$withIndex$1 channelsKt__DeprecatedKt$withIndex$1 = new ChannelsKt__DeprecatedKt$withIndex$1(this.b3, continuation);
        channelsKt__DeprecatedKt$withIndex$1.a3 = obj;
        return channelsKt__DeprecatedKt$withIndex$1;
    }
}
