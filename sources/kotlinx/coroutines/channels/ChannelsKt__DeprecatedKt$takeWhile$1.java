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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {269, 270, 271}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
final class ChannelsKt__DeprecatedKt$takeWhile$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    Object X2;
    Object Y2;
    int Z2;
    private /* synthetic */ Object a3;
    final /* synthetic */ ReceiveChannel<Object> b3;
    final /* synthetic */ Function2<Object, Continuation<? super Boolean>, Object> c3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$takeWhile$1(ReceiveChannel<Object> receiveChannel, Function2<Object, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$takeWhile$1> continuation) {
        super(2, continuation);
        this.b3 = receiveChannel;
        this.c3 = function2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0087  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object D(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r1 = r8.Z2
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x003f
            if (r1 == r4) goto L_0x0033
            if (r1 == r3) goto L_0x0025
            if (r1 != r2) goto L_0x001d
            java.lang.Object r1 = r8.X2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r8.a3
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.n(r9)
            goto L_0x004d
        L_0x001d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0025:
            java.lang.Object r1 = r8.Y2
            java.lang.Object r5 = r8.X2
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r8.a3
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            kotlin.ResultKt.n(r9)
            goto L_0x007c
        L_0x0033:
            java.lang.Object r1 = r8.X2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r8.a3
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.n(r9)
            goto L_0x005a
        L_0x003f:
            kotlin.ResultKt.n(r9)
            java.lang.Object r9 = r8.a3
            kotlinx.coroutines.channels.ProducerScope r9 = (kotlinx.coroutines.channels.ProducerScope) r9
            kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r1 = r8.b3
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r5 = r9
        L_0x004d:
            r8.a3 = r5
            r8.X2 = r1
            r8.Z2 = r4
            java.lang.Object r9 = r1.a(r8)
            if (r9 != r0) goto L_0x005a
            return r0
        L_0x005a:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x009a
            java.lang.Object r9 = r1.next()
            kotlin.jvm.functions.Function2<java.lang.Object, kotlin.coroutines.Continuation<? super java.lang.Boolean>, java.lang.Object> r6 = r8.c3
            r8.a3 = r5
            r8.X2 = r1
            r8.Y2 = r9
            r8.Z2 = r3
            java.lang.Object r6 = r6.d0(r9, r8)
            if (r6 != r0) goto L_0x0077
            return r0
        L_0x0077:
            r7 = r1
            r1 = r9
            r9 = r6
            r6 = r5
            r5 = r7
        L_0x007c:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L_0x0087
            kotlin.Unit r9 = kotlin.Unit.f28779a
            return r9
        L_0x0087:
            r8.a3 = r6
            r8.X2 = r5
            r9 = 0
            r8.Y2 = r9
            r8.Z2 = r2
            java.lang.Object r9 = r6.g0(r1, r8)
            if (r9 != r0) goto L_0x0097
            return r0
        L_0x0097:
            r1 = r5
            r5 = r6
            goto L_0x004d
        L_0x009a:
            kotlin.Unit r9 = kotlin.Unit.f28779a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1.D(java.lang.Object):java.lang.Object");
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull ProducerScope<Object> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$takeWhile$1) v(producerScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$takeWhile$1 channelsKt__DeprecatedKt$takeWhile$1 = new ChannelsKt__DeprecatedKt$takeWhile$1(this.b3, this.c3, continuation);
        channelsKt__DeprecatedKt$takeWhile$1.a3 = obj;
        return channelsKt__DeprecatedKt$takeWhile$1;
    }
}
