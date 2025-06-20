package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H@"}, d2 = {"<anonymous>", "", "E", "R", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1", f = "Deprecated.kt", i = {0, 1, 2}, l = {321, 322, 322}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
final class ChannelsKt__DeprecatedKt$flatMap$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    Object X2;
    int Y2;
    private /* synthetic */ Object Z2;
    final /* synthetic */ ReceiveChannel<Object> a3;
    final /* synthetic */ Function2<Object, Continuation<? super ReceiveChannel<Object>>, Object> b3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$flatMap$1(ReceiveChannel<Object> receiveChannel, Function2<Object, ? super Continuation<? super ReceiveChannel<Object>>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$flatMap$1> continuation) {
        super(2, continuation);
        this.a3 = receiveChannel;
        this.b3 = function2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0081 A[RETURN] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object D(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r1 = r7.Y2
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x003d
            if (r1 == r4) goto L_0x0031
            if (r1 == r3) goto L_0x0025
            if (r1 != r2) goto L_0x001d
            java.lang.Object r1 = r7.X2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r7.Z2
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.n(r8)
            goto L_0x004b
        L_0x001d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0025:
            java.lang.Object r1 = r7.X2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r7.Z2
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.n(r8)
            goto L_0x0073
        L_0x0031:
            java.lang.Object r1 = r7.X2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r7.Z2
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.n(r8)
            goto L_0x0058
        L_0x003d:
            kotlin.ResultKt.n(r8)
            java.lang.Object r8 = r7.Z2
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r1 = r7.a3
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r5 = r8
        L_0x004b:
            r7.Z2 = r5
            r7.X2 = r1
            r7.Y2 = r4
            java.lang.Object r8 = r1.a(r7)
            if (r8 != r0) goto L_0x0058
            return r0
        L_0x0058:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0082
            java.lang.Object r8 = r1.next()
            kotlin.jvm.functions.Function2<java.lang.Object, kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object>>, java.lang.Object> r6 = r7.b3
            r7.Z2 = r5
            r7.X2 = r1
            r7.Y2 = r3
            java.lang.Object r8 = r6.d0(r8, r7)
            if (r8 != r0) goto L_0x0073
            return r0
        L_0x0073:
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            r7.Z2 = r5
            r7.X2 = r1
            r7.Y2 = r2
            java.lang.Object r8 = kotlinx.coroutines.channels.ChannelsKt.e0(r8, r5, r7)
            if (r8 != r0) goto L_0x004b
            return r0
        L_0x0082:
            kotlin.Unit r8 = kotlin.Unit.f28779a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$flatMap$1.D(java.lang.Object):java.lang.Object");
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull ProducerScope<Object> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$flatMap$1) v(producerScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$flatMap$1 channelsKt__DeprecatedKt$flatMap$1 = new ChannelsKt__DeprecatedKt$flatMap$1(this.a3, this.b3, continuation);
        channelsKt__DeprecatedKt$flatMap$1.Z2 = obj;
        return channelsKt__DeprecatedKt$flatMap$1;
    }
}
