package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H@"}, d2 = {"<anonymous>", "", "E", "K", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {387, 388, 390}, m = "invokeSuspend", n = {"$this$produce", "keys", "$this$produce", "keys", "e", "$this$produce", "keys", "k"}, s = {"L$0", "L$1", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3"})
final class ChannelsKt__DeprecatedKt$distinctBy$1 extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
    Object X2;
    Object Y2;
    Object Z2;
    int a3;
    private /* synthetic */ Object b3;
    final /* synthetic */ ReceiveChannel<E> c3;
    final /* synthetic */ Function2<E, Continuation<? super K>, Object> d3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$distinctBy$1(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super K>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$distinctBy$1> continuation) {
        super(2, continuation);
        this.c3 = receiveChannel;
        this.d3 = function2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a3  */
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
            if (r1 == 0) goto L_0x0051
            if (r1 == r4) goto L_0x0041
            if (r1 == r3) goto L_0x002c
            if (r1 != r2) goto L_0x0024
            java.lang.Object r1 = r10.Z2
            java.lang.Object r5 = r10.Y2
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r10.X2
            java.util.HashSet r6 = (java.util.HashSet) r6
            java.lang.Object r7 = r10.b3
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            kotlin.ResultKt.n(r11)
            goto L_0x00b6
        L_0x0024:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x002c:
            java.lang.Object r1 = r10.Z2
            java.lang.Object r5 = r10.Y2
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r10.X2
            java.util.HashSet r6 = (java.util.HashSet) r6
            java.lang.Object r7 = r10.b3
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            kotlin.ResultKt.n(r11)
            r9 = r5
            r5 = r1
            r1 = r9
            goto L_0x009d
        L_0x0041:
            java.lang.Object r1 = r10.Y2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r10.X2
            java.util.HashSet r5 = (java.util.HashSet) r5
            java.lang.Object r6 = r10.b3
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            kotlin.ResultKt.n(r11)
            goto L_0x0079
        L_0x0051:
            kotlin.ResultKt.n(r11)
            java.lang.Object r11 = r10.b3
            kotlinx.coroutines.channels.ProducerScope r11 = (kotlinx.coroutines.channels.ProducerScope) r11
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            kotlinx.coroutines.channels.ReceiveChannel<E> r5 = r10.c3
            kotlinx.coroutines.channels.ChannelIterator r5 = r5.iterator()
            r6 = r11
            r9 = r5
            r5 = r1
            r1 = r9
        L_0x0067:
            r10.b3 = r6
            r10.X2 = r5
            r10.Y2 = r1
            r11 = 0
            r10.Z2 = r11
            r10.a3 = r4
            java.lang.Object r11 = r1.a(r10)
            if (r11 != r0) goto L_0x0079
            return r0
        L_0x0079:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x00bd
            java.lang.Object r11 = r1.next()
            kotlin.jvm.functions.Function2<E, kotlin.coroutines.Continuation<? super K>, java.lang.Object> r7 = r10.d3
            r10.b3 = r6
            r10.X2 = r5
            r10.Y2 = r1
            r10.Z2 = r11
            r10.a3 = r3
            java.lang.Object r7 = r7.d0(r11, r10)
            if (r7 != r0) goto L_0x0098
            return r0
        L_0x0098:
            r9 = r5
            r5 = r11
            r11 = r7
            r7 = r6
            r6 = r9
        L_0x009d:
            boolean r8 = r6.contains(r11)
            if (r8 != 0) goto L_0x00ba
            r10.b3 = r7
            r10.X2 = r6
            r10.Y2 = r1
            r10.Z2 = r11
            r10.a3 = r2
            java.lang.Object r5 = r7.g0(r5, r10)
            if (r5 != r0) goto L_0x00b4
            return r0
        L_0x00b4:
            r5 = r1
            r1 = r11
        L_0x00b6:
            r6.add(r1)
            r1 = r5
        L_0x00ba:
            r5 = r6
            r6 = r7
            goto L_0x0067
        L_0x00bd:
            kotlin.Unit r11 = kotlin.Unit.f28779a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1.D(java.lang.Object):java.lang.Object");
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull ProducerScope<? super E> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$distinctBy$1) v(producerScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$distinctBy$1 channelsKt__DeprecatedKt$distinctBy$1 = new ChannelsKt__DeprecatedKt$distinctBy$1(this.c3, this.d3, continuation);
        channelsKt__DeprecatedKt$distinctBy$1.b3 = obj;
        return channelsKt__DeprecatedKt$distinctBy$1;
    }
}
