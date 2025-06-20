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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2, 3, 4}, l = {181, 182, 183, 187, 188}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0", "L$0", "L$0"})
final class ChannelsKt__DeprecatedKt$dropWhile$1 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    Object X2;
    Object Y2;
    int Z2;
    private /* synthetic */ Object a3;
    final /* synthetic */ ReceiveChannel<Object> b3;
    final /* synthetic */ Function2<Object, Continuation<? super Boolean>, Object> c3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__DeprecatedKt$dropWhile$1(ReceiveChannel<Object> receiveChannel, Function2<Object, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super ChannelsKt__DeprecatedKt$dropWhile$1> continuation) {
        super(2, continuation);
        this.b3 = receiveChannel;
        this.c3 = function2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0081 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00de  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object D(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r1 = r11.Z2
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r1 == 0) goto L_0x0065
            if (r1 == r6) goto L_0x0056
            if (r1 == r5) goto L_0x0045
            if (r1 == r4) goto L_0x003c
            if (r1 == r3) goto L_0x002f
            if (r1 != r2) goto L_0x0027
            java.lang.Object r1 = r11.X2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r11.a3
            kotlinx.coroutines.channels.ProducerScope r4 = (kotlinx.coroutines.channels.ProducerScope) r4
            kotlin.ResultKt.n(r12)
        L_0x0023:
            r12 = r1
            r1 = r4
            goto L_0x00c5
        L_0x0027:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x002f:
            java.lang.Object r1 = r11.X2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r11.a3
            kotlinx.coroutines.channels.ProducerScope r4 = (kotlinx.coroutines.channels.ProducerScope) r4
            kotlin.ResultKt.n(r12)
            goto L_0x00d6
        L_0x003c:
            java.lang.Object r1 = r11.a3
            kotlinx.coroutines.channels.ProducerScope r1 = (kotlinx.coroutines.channels.ProducerScope) r1
            kotlin.ResultKt.n(r12)
            goto L_0x00bf
        L_0x0045:
            java.lang.Object r1 = r11.Y2
            java.lang.Object r8 = r11.X2
            kotlinx.coroutines.channels.ChannelIterator r8 = (kotlinx.coroutines.channels.ChannelIterator) r8
            java.lang.Object r9 = r11.a3
            kotlinx.coroutines.channels.ProducerScope r9 = (kotlinx.coroutines.channels.ProducerScope) r9
            kotlin.ResultKt.n(r12)
            r10 = r8
            r8 = r1
        L_0x0054:
            r1 = r10
            goto L_0x00a4
        L_0x0056:
            java.lang.Object r1 = r11.X2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r8 = r11.a3
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            kotlin.ResultKt.n(r12)
        L_0x0061:
            r10 = r8
            r8 = r1
            r1 = r10
            goto L_0x0082
        L_0x0065:
            kotlin.ResultKt.n(r12)
            java.lang.Object r12 = r11.a3
            kotlinx.coroutines.channels.ProducerScope r12 = (kotlinx.coroutines.channels.ProducerScope) r12
            kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r1 = r11.b3
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r8 = r12
        L_0x0073:
            r11.a3 = r8
            r11.X2 = r1
            r11.Y2 = r7
            r11.Z2 = r6
            java.lang.Object r12 = r1.a(r11)
            if (r12 != r0) goto L_0x0061
            return r0
        L_0x0082:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x00bf
            java.lang.Object r12 = r8.next()
            kotlin.jvm.functions.Function2<java.lang.Object, kotlin.coroutines.Continuation<? super java.lang.Boolean>, java.lang.Object> r9 = r11.c3
            r11.a3 = r1
            r11.X2 = r8
            r11.Y2 = r12
            r11.Z2 = r5
            java.lang.Object r9 = r9.d0(r12, r11)
            if (r9 != r0) goto L_0x009f
            return r0
        L_0x009f:
            r10 = r8
            r8 = r12
            r12 = r9
            r9 = r1
            goto L_0x0054
        L_0x00a4:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 != 0) goto L_0x00bd
            r11.a3 = r9
            r11.X2 = r7
            r11.Y2 = r7
            r11.Z2 = r4
            java.lang.Object r12 = r9.g0(r8, r11)
            if (r12 != r0) goto L_0x00bb
            return r0
        L_0x00bb:
            r1 = r9
            goto L_0x00bf
        L_0x00bd:
            r8 = r9
            goto L_0x0073
        L_0x00bf:
            kotlinx.coroutines.channels.ReceiveChannel<java.lang.Object> r12 = r11.b3
            kotlinx.coroutines.channels.ChannelIterator r12 = r12.iterator()
        L_0x00c5:
            r11.a3 = r1
            r11.X2 = r12
            r11.Z2 = r3
            java.lang.Object r4 = r12.a(r11)
            if (r4 != r0) goto L_0x00d2
            return r0
        L_0x00d2:
            r10 = r1
            r1 = r12
            r12 = r4
            r4 = r10
        L_0x00d6:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x00ef
            java.lang.Object r12 = r1.next()
            r11.a3 = r4
            r11.X2 = r1
            r11.Z2 = r2
            java.lang.Object r12 = r4.g0(r12, r11)
            if (r12 != r0) goto L_0x0023
            return r0
        L_0x00ef:
            kotlin.Unit r12 = kotlin.Unit.f28779a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1.D(java.lang.Object):java.lang.Object");
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull ProducerScope<Object> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelsKt__DeprecatedKt$dropWhile$1) v(producerScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$dropWhile$1 channelsKt__DeprecatedKt$dropWhile$1 = new ChannelsKt__DeprecatedKt$dropWhile$1(this.b3, this.c3, continuation);
        channelsKt__DeprecatedKt$dropWhile$1.a3 = obj;
        return channelsKt__DeprecatedKt$dropWhile$1;
    }
}
