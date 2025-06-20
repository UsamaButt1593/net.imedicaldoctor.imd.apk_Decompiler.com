package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H@"}, d2 = {"<anonymous>", "", "E", "R", "V", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, l = {487, 469, 471}, m = "invokeSuspend", n = {"$this$produce", "otherIterator", "$this$consume$iv$iv", "$this$produce", "otherIterator", "$this$consume$iv$iv", "element1", "$this$produce", "otherIterator", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$3", "L$0", "L$1", "L$3", "L$5", "L$0", "L$1", "L$3"})
final class ChannelsKt__DeprecatedKt$zip$2 extends SuspendLambda implements Function2<ProducerScope<? super V>, Continuation<? super Unit>, Object> {
    Object X2;
    Object Y2;
    Object Z2;
    Object a3;
    Object b3;
    int c3;
    private /* synthetic */ Object d3;
    final /* synthetic */ ReceiveChannel<R> e3;
    final /* synthetic */ ReceiveChannel<E> f3;
    final /* synthetic */ Function2<E, R, V> g3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$zip$2(ReceiveChannel<? extends R> receiveChannel, ReceiveChannel<? extends E> receiveChannel2, Function2<? super E, ? super R, ? extends V> function2, Continuation<? super ChannelsKt__DeprecatedKt$zip$2> continuation) {
        super(2, continuation);
        this.e3 = receiveChannel;
        this.f3 = receiveChannel2;
        this.g3 = function2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a5 A[Catch:{ all -> 0x002a }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cd A[Catch:{ all -> 0x0053 }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object D(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r1 = r12.c3
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x006f
            if (r1 == r4) goto L_0x0057
            if (r1 == r3) goto L_0x0035
            if (r1 != r2) goto L_0x002d
            java.lang.Object r1 = r12.a3
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r12.Z2
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r12.Y2
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r8 = r12.X2
            kotlinx.coroutines.channels.ChannelIterator r8 = (kotlinx.coroutines.channels.ChannelIterator) r8
            java.lang.Object r9 = r12.d3
            kotlinx.coroutines.channels.ProducerScope r9 = (kotlinx.coroutines.channels.ProducerScope) r9
            kotlin.ResultKt.n(r13)     // Catch:{ all -> 0x002a }
            goto L_0x0088
        L_0x002a:
            r13 = move-exception
            goto L_0x00f5
        L_0x002d:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0035:
            java.lang.Object r1 = r12.b3
            java.lang.Object r6 = r12.a3
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r12.Z2
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r8 = r12.Y2
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            java.lang.Object r9 = r12.X2
            kotlinx.coroutines.channels.ChannelIterator r9 = (kotlinx.coroutines.channels.ChannelIterator) r9
            java.lang.Object r10 = r12.d3
            kotlinx.coroutines.channels.ProducerScope r10 = (kotlinx.coroutines.channels.ProducerScope) r10
            kotlin.ResultKt.n(r13)     // Catch:{ all -> 0x0053 }
            r11 = r6
            r6 = r1
            r1 = r11
            goto L_0x00c5
        L_0x0053:
            r13 = move-exception
            r6 = r7
            goto L_0x00f5
        L_0x0057:
            java.lang.Object r1 = r12.a3
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r12.Z2
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r12.Y2
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r8 = r12.X2
            kotlinx.coroutines.channels.ChannelIterator r8 = (kotlinx.coroutines.channels.ChannelIterator) r8
            java.lang.Object r9 = r12.d3
            kotlinx.coroutines.channels.ProducerScope r9 = (kotlinx.coroutines.channels.ProducerScope) r9
            kotlin.ResultKt.n(r13)     // Catch:{ all -> 0x002a }
            goto L_0x009d
        L_0x006f:
            kotlin.ResultKt.n(r13)
            java.lang.Object r13 = r12.d3
            kotlinx.coroutines.channels.ProducerScope r13 = (kotlinx.coroutines.channels.ProducerScope) r13
            kotlinx.coroutines.channels.ReceiveChannel<R> r1 = r12.e3
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            kotlinx.coroutines.channels.ReceiveChannel<E> r6 = r12.f3
            kotlin.jvm.functions.Function2<E, R, V> r7 = r12.g3
            kotlinx.coroutines.channels.ChannelIterator r8 = r6.iterator()     // Catch:{ all -> 0x002a }
            r9 = r13
            r11 = r8
            r8 = r1
            r1 = r11
        L_0x0088:
            r12.d3 = r9     // Catch:{ all -> 0x002a }
            r12.X2 = r8     // Catch:{ all -> 0x002a }
            r12.Y2 = r7     // Catch:{ all -> 0x002a }
            r12.Z2 = r6     // Catch:{ all -> 0x002a }
            r12.a3 = r1     // Catch:{ all -> 0x002a }
            r12.b3 = r5     // Catch:{ all -> 0x002a }
            r12.c3 = r4     // Catch:{ all -> 0x002a }
            java.lang.Object r13 = r1.a(r12)     // Catch:{ all -> 0x002a }
            if (r13 != r0) goto L_0x009d
            return r0
        L_0x009d:
            java.lang.Boolean r13 = (java.lang.Boolean) r13     // Catch:{ all -> 0x002a }
            boolean r13 = r13.booleanValue()     // Catch:{ all -> 0x002a }
            if (r13 == 0) goto L_0x00ef
            java.lang.Object r13 = r1.next()     // Catch:{ all -> 0x002a }
            r12.d3 = r9     // Catch:{ all -> 0x002a }
            r12.X2 = r8     // Catch:{ all -> 0x002a }
            r12.Y2 = r7     // Catch:{ all -> 0x002a }
            r12.Z2 = r6     // Catch:{ all -> 0x002a }
            r12.a3 = r1     // Catch:{ all -> 0x002a }
            r12.b3 = r13     // Catch:{ all -> 0x002a }
            r12.c3 = r3     // Catch:{ all -> 0x002a }
            java.lang.Object r10 = r8.a(r12)     // Catch:{ all -> 0x002a }
            if (r10 != r0) goto L_0x00be
            return r0
        L_0x00be:
            r11 = r6
            r6 = r13
            r13 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r11
        L_0x00c5:
            java.lang.Boolean r13 = (java.lang.Boolean) r13     // Catch:{ all -> 0x0053 }
            boolean r13 = r13.booleanValue()     // Catch:{ all -> 0x0053 }
            if (r13 == 0) goto L_0x00ea
            java.lang.Object r13 = r9.next()     // Catch:{ all -> 0x0053 }
            java.lang.Object r13 = r8.d0(r6, r13)     // Catch:{ all -> 0x0053 }
            r12.d3 = r10     // Catch:{ all -> 0x0053 }
            r12.X2 = r9     // Catch:{ all -> 0x0053 }
            r12.Y2 = r8     // Catch:{ all -> 0x0053 }
            r12.Z2 = r7     // Catch:{ all -> 0x0053 }
            r12.a3 = r1     // Catch:{ all -> 0x0053 }
            r12.b3 = r5     // Catch:{ all -> 0x0053 }
            r12.c3 = r2     // Catch:{ all -> 0x0053 }
            java.lang.Object r13 = r10.g0(r13, r12)     // Catch:{ all -> 0x0053 }
            if (r13 != r0) goto L_0x00ea
            return r0
        L_0x00ea:
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            goto L_0x0088
        L_0x00ef:
            kotlin.Unit r13 = kotlin.Unit.f28779a     // Catch:{ all -> 0x002a }
            kotlinx.coroutines.channels.ChannelsKt.b(r6, r5)
            return r13
        L_0x00f5:
            throw r13     // Catch:{ all -> 0x00f6 }
        L_0x00f6:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r6, r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2.D(java.lang.Object):java.lang.Object");
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull ProducerScope<? super V> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$zip$2) v(producerScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$zip$2 channelsKt__DeprecatedKt$zip$2 = new ChannelsKt__DeprecatedKt$zip$2(this.e3, this.f3, this.g3, continuation);
        channelsKt__DeprecatedKt$zip$2.d3 = obj;
        return channelsKt__DeprecatedKt$zip$2;
    }
}
