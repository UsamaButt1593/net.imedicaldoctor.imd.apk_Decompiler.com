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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1", f = "Deprecated.kt", i = {0, 0, 1, 2}, l = {164, 169, 170}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "$this$produce"}, s = {"L$0", "I$0", "L$0", "L$0"})
final class ChannelsKt__DeprecatedKt$drop$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    Object X2;
    int Y2;
    int Z2;
    private /* synthetic */ Object a3;
    final /* synthetic */ int b3;
    final /* synthetic */ ReceiveChannel<Object> c3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$drop$1(int i2, ReceiveChannel<Object> receiveChannel, Continuation<? super ChannelsKt__DeprecatedKt$drop$1> continuation) {
        super(2, continuation);
        this.b3 = i2;
        this.c3 = receiveChannel;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0075, code lost:
        if (r1 == 0) goto L_0x0077;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0096  */
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
            if (r1 == 0) goto L_0x0040
            if (r1 == r4) goto L_0x0032
            if (r1 == r3) goto L_0x0026
            if (r1 != r2) goto L_0x001e
            java.lang.Object r1 = r8.X2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r8.a3
            kotlinx.coroutines.channels.ProducerScope r4 = (kotlinx.coroutines.channels.ProducerScope) r4
            kotlin.ResultKt.n(r9)
        L_0x001c:
            r9 = r4
            goto L_0x007e
        L_0x001e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0026:
            java.lang.Object r1 = r8.X2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r8.a3
            kotlinx.coroutines.channels.ProducerScope r4 = (kotlinx.coroutines.channels.ProducerScope) r4
            kotlin.ResultKt.n(r9)
            goto L_0x008e
        L_0x0032:
            int r1 = r8.Y2
            java.lang.Object r5 = r8.X2
            kotlinx.coroutines.channels.ChannelIterator r5 = (kotlinx.coroutines.channels.ChannelIterator) r5
            java.lang.Object r6 = r8.a3
            kotlinx.coroutines.channels.ProducerScope r6 = (kotlinx.coroutines.channels.ProducerScope) r6
            kotlin.ResultKt.n(r9)
            goto L_0x0068
        L_0x0040:
            kotlin.ResultKt.n(r9)
            java.lang.Object r9 = r8.a3
            kotlinx.coroutines.channels.ProducerScope r9 = (kotlinx.coroutines.channels.ProducerScope) r9
            int r1 = r8.b3
            if (r1 < 0) goto L_0x004d
            r5 = 1
            goto L_0x004e
        L_0x004d:
            r5 = 0
        L_0x004e:
            if (r5 == 0) goto L_0x00aa
            if (r1 <= 0) goto L_0x0078
            kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r5 = r8.c3
            kotlinx.coroutines.channels.ChannelIterator r5 = r5.iterator()
            r6 = r9
        L_0x0059:
            r8.a3 = r6
            r8.X2 = r5
            r8.Y2 = r1
            r8.Z2 = r4
            java.lang.Object r9 = r5.a(r8)
            if (r9 != r0) goto L_0x0068
            return r0
        L_0x0068:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0077
            r5.next()
            int r1 = r1 + -1
            if (r1 != 0) goto L_0x0059
        L_0x0077:
            r9 = r6
        L_0x0078:
            kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r1 = r8.c3
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
        L_0x007e:
            r8.a3 = r9
            r8.X2 = r1
            r8.Z2 = r3
            java.lang.Object r4 = r1.a(r8)
            if (r4 != r0) goto L_0x008b
            return r0
        L_0x008b:
            r7 = r4
            r4 = r9
            r9 = r7
        L_0x008e:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x00a7
            java.lang.Object r9 = r1.next()
            r8.a3 = r4
            r8.X2 = r1
            r8.Z2 = r2
            java.lang.Object r9 = r4.g0(r9, r8)
            if (r9 != r0) goto L_0x001c
            return r0
        L_0x00a7:
            kotlin.Unit r9 = kotlin.Unit.f28779a
            return r9
        L_0x00aa:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "Requested element count "
            r9.append(r0)
            r9.append(r1)
            java.lang.String r0 = " is less than zero."
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$drop$1.D(java.lang.Object):java.lang.Object");
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull ProducerScope<Object> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$drop$1) v(producerScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$drop$1 channelsKt__DeprecatedKt$drop$1 = new ChannelsKt__DeprecatedKt$drop$1(this.b3, this.c3, continuation);
        channelsKt__DeprecatedKt$drop$1.a3 = obj;
        return channelsKt__DeprecatedKt$drop$1;
    }
}
