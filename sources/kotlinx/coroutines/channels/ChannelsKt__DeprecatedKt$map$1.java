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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {487, 333, 333}, m = "invokeSuspend", n = {"$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv"}, s = {"L$0", "L$2", "L$0", "L$2", "L$0", "L$2"})
final class ChannelsKt__DeprecatedKt$map$1 extends SuspendLambda implements Function2<ProducerScope<? super R>, Continuation<? super Unit>, Object> {
    Object X2;
    Object Y2;
    Object Z2;
    Object a3;
    int b3;
    private /* synthetic */ Object c3;
    final /* synthetic */ ReceiveChannel<E> d3;
    final /* synthetic */ Function2<E, Continuation<? super R>, Object> e3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$map$1(ReceiveChannel<? extends E> receiveChannel, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$map$1> continuation) {
        super(2, continuation);
        this.d3 = receiveChannel;
        this.e3 = function2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0091 A[Catch:{ all -> 0x0027 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c0  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object D(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r1 = r11.b3
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x0063
            if (r1 == r4) goto L_0x004f
            if (r1 == r3) goto L_0x0032
            if (r1 != r2) goto L_0x002a
            java.lang.Object r1 = r11.Z2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r11.Y2
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r11.X2
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r8 = r11.c3
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            kotlin.ResultKt.n(r12)     // Catch:{ all -> 0x0027 }
            r12 = r8
            goto L_0x0075
        L_0x0027:
            r12 = move-exception
            goto L_0x00cb
        L_0x002a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0032:
            java.lang.Object r1 = r11.a3
            kotlinx.coroutines.channels.ProducerScope r1 = (kotlinx.coroutines.channels.ProducerScope) r1
            java.lang.Object r6 = r11.Z2
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r7 = r11.Y2
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r8 = r11.X2
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            java.lang.Object r9 = r11.c3
            kotlinx.coroutines.channels.ProducerScope r9 = (kotlinx.coroutines.channels.ProducerScope) r9
            kotlin.ResultKt.n(r12)     // Catch:{ all -> 0x004b }
            goto L_0x00ad
        L_0x004b:
            r12 = move-exception
            r6 = r7
            goto L_0x00cb
        L_0x004f:
            java.lang.Object r1 = r11.Z2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r6 = r11.Y2
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r11.X2
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r8 = r11.c3
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            kotlin.ResultKt.n(r12)     // Catch:{ all -> 0x0027 }
            goto L_0x0089
        L_0x0063:
            kotlin.ResultKt.n(r12)
            java.lang.Object r12 = r11.c3
            kotlinx.coroutines.channels.ProducerScope r12 = (kotlinx.coroutines.channels.ProducerScope) r12
            kotlinx.coroutines.channels.ReceiveChannel<E> r6 = r11.d3
            kotlin.jvm.functions.Function2<E, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r1 = r11.e3
            kotlinx.coroutines.channels.ChannelIterator r7 = r6.iterator()     // Catch:{ all -> 0x0027 }
            r10 = r7
            r7 = r1
            r1 = r10
        L_0x0075:
            r11.c3 = r12     // Catch:{ all -> 0x0027 }
            r11.X2 = r7     // Catch:{ all -> 0x0027 }
            r11.Y2 = r6     // Catch:{ all -> 0x0027 }
            r11.Z2 = r1     // Catch:{ all -> 0x0027 }
            r11.b3 = r4     // Catch:{ all -> 0x0027 }
            java.lang.Object r8 = r1.a(r11)     // Catch:{ all -> 0x0027 }
            if (r8 != r0) goto L_0x0086
            return r0
        L_0x0086:
            r10 = r8
            r8 = r12
            r12 = r10
        L_0x0089:
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch:{ all -> 0x0027 }
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x0027 }
            if (r12 == 0) goto L_0x00c5
            java.lang.Object r12 = r1.next()     // Catch:{ all -> 0x0027 }
            r11.c3 = r8     // Catch:{ all -> 0x0027 }
            r11.X2 = r7     // Catch:{ all -> 0x0027 }
            r11.Y2 = r6     // Catch:{ all -> 0x0027 }
            r11.Z2 = r1     // Catch:{ all -> 0x0027 }
            r11.a3 = r8     // Catch:{ all -> 0x0027 }
            r11.b3 = r3     // Catch:{ all -> 0x0027 }
            java.lang.Object r12 = r7.d0(r12, r11)     // Catch:{ all -> 0x0027 }
            if (r12 != r0) goto L_0x00a8
            return r0
        L_0x00a8:
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r1
            r1 = r9
        L_0x00ad:
            r11.c3 = r9     // Catch:{ all -> 0x004b }
            r11.X2 = r8     // Catch:{ all -> 0x004b }
            r11.Y2 = r7     // Catch:{ all -> 0x004b }
            r11.Z2 = r6     // Catch:{ all -> 0x004b }
            r11.a3 = r5     // Catch:{ all -> 0x004b }
            r11.b3 = r2     // Catch:{ all -> 0x004b }
            java.lang.Object r12 = r1.g0(r12, r11)     // Catch:{ all -> 0x004b }
            if (r12 != r0) goto L_0x00c0
            return r0
        L_0x00c0:
            r1 = r6
            r6 = r7
            r7 = r8
            r12 = r9
            goto L_0x0075
        L_0x00c5:
            kotlin.Unit r12 = kotlin.Unit.f28779a     // Catch:{ all -> 0x0027 }
            kotlinx.coroutines.channels.ChannelsKt.b(r6, r5)
            return r12
        L_0x00cb:
            throw r12     // Catch:{ all -> 0x00cc }
        L_0x00cc:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r6, r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1.D(java.lang.Object):java.lang.Object");
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull ProducerScope<? super R> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$map$1) v(producerScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$map$1 channelsKt__DeprecatedKt$map$1 = new ChannelsKt__DeprecatedKt$map$1(this.d3, this.e3, continuation);
        channelsKt__DeprecatedKt$map$1.c3 = obj;
        return channelsKt__DeprecatedKt$map$1;
    }
}
