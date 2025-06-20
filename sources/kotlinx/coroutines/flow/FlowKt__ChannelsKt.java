package kotlinx.coroutines.flow;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a1\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a9\u0010\t\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\b\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a#\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\f\u0010\r\u001a#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u000e\u0010\r\u001a%\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a-\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"T", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "channel", "", "d", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "consume", "e", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/Flow;", "g", "(Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlinx/coroutines/flow/Flow;", "c", "Lkotlinx/coroutines/channels/BroadcastChannel;", "b", "(Lkotlinx/coroutines/channels/BroadcastChannel;)Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "f", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;)Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__ChannelsKt {
    @NotNull
    @Deprecated(level = DeprecationLevel.WARNING, message = "'BroadcastChannel' is obsolete and all corresponding operators are deprecated in the favour of StateFlow and SharedFlow")
    public static final <T> Flow<T> b(@NotNull BroadcastChannel<T> broadcastChannel) {
        return new FlowKt__ChannelsKt$asFlow$$inlined$unsafeFlow$1(broadcastChannel);
    }

    @NotNull
    public static final <T> Flow<T> c(@NotNull ReceiveChannel<? extends T> receiveChannel) {
        return new ChannelAsFlow(receiveChannel, true, (CoroutineContext) null, 0, (BufferOverflow) null, 28, (DefaultConstructorMarker) null);
    }

    @Nullable
    public static final <T> Object d(@NotNull FlowCollector<? super T> flowCollector, @NotNull ReceiveChannel<? extends T> receiveChannel, @NotNull Continuation<? super Unit> continuation) {
        Object e2 = e(flowCollector, receiveChannel, true, continuation);
        return e2 == IntrinsicsKt.l() ? e2 : Unit.f28779a;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0084 A[SYNTHETIC, Splitter:B:35:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0085 A[Catch:{ all -> 0x0039 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object e(kotlinx.coroutines.flow.FlowCollector<? super T> r6, kotlinx.coroutines.channels.ReceiveChannel<? extends T> r7, boolean r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = (kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1) r0
            int r1 = r0.a3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.a3 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = new kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            r0.<init>(r9)
        L_0x0018:
            java.lang.Object r9 = r0.Z2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.a3
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0057
            if (r2 == r4) goto L_0x0043
            if (r2 != r3) goto L_0x003b
            boolean r6 = r0.Y2
            java.lang.Object r7 = r0.X2
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r8 = r0.Z
            kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
            kotlin.ResultKt.n(r9)     // Catch:{ all -> 0x0039 }
        L_0x0035:
            r5 = r8
            r8 = r6
            r6 = r5
            goto L_0x005d
        L_0x0039:
            r8 = move-exception
            goto L_0x009c
        L_0x003b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0043:
            boolean r6 = r0.Y2
            java.lang.Object r7 = r0.X2
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r8 = r0.Z
            kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
            kotlin.ResultKt.n(r9)     // Catch:{ all -> 0x0039 }
            kotlinx.coroutines.channels.ChannelResult r9 = (kotlinx.coroutines.channels.ChannelResult) r9     // Catch:{ all -> 0x0039 }
            java.lang.Object r9 = r9.o()     // Catch:{ all -> 0x0039 }
            goto L_0x006f
        L_0x0057:
            kotlin.ResultKt.n(r9)
            kotlinx.coroutines.flow.FlowKt.o0(r6)
        L_0x005d:
            r0.Z = r6     // Catch:{ all -> 0x0098 }
            r0.X2 = r7     // Catch:{ all -> 0x0098 }
            r0.Y2 = r8     // Catch:{ all -> 0x0098 }
            r0.a3 = r4     // Catch:{ all -> 0x0098 }
            java.lang.Object r9 = r7.E(r0)     // Catch:{ all -> 0x0098 }
            if (r9 != r1) goto L_0x006c
            return r1
        L_0x006c:
            r5 = r8
            r8 = r6
            r6 = r5
        L_0x006f:
            boolean r2 = kotlinx.coroutines.channels.ChannelResult.k(r9)     // Catch:{ all -> 0x0039 }
            if (r2 == 0) goto L_0x0085
            java.lang.Throwable r8 = kotlinx.coroutines.channels.ChannelResult.f(r9)     // Catch:{ all -> 0x0039 }
            if (r8 != 0) goto L_0x0084
            if (r6 == 0) goto L_0x0081
            r6 = 0
            kotlinx.coroutines.channels.ChannelsKt.b(r7, r6)
        L_0x0081:
            kotlin.Unit r6 = kotlin.Unit.f28779a
            return r6
        L_0x0084:
            throw r8     // Catch:{ all -> 0x0039 }
        L_0x0085:
            java.lang.Object r9 = kotlinx.coroutines.channels.ChannelResult.i(r9)     // Catch:{ all -> 0x0039 }
            r0.Z = r8     // Catch:{ all -> 0x0039 }
            r0.X2 = r7     // Catch:{ all -> 0x0039 }
            r0.Y2 = r6     // Catch:{ all -> 0x0039 }
            r0.a3 = r3     // Catch:{ all -> 0x0039 }
            java.lang.Object r9 = r8.h(r9, r0)     // Catch:{ all -> 0x0039 }
            if (r9 != r1) goto L_0x0035
            return r1
        L_0x0098:
            r6 = move-exception
            r5 = r8
            r8 = r6
            r6 = r5
        L_0x009c:
            throw r8     // Catch:{ all -> 0x009d }
        L_0x009d:
            r9 = move-exception
            if (r6 == 0) goto L_0x00a3
            kotlinx.coroutines.channels.ChannelsKt.b(r7, r8)
        L_0x00a3:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ChannelsKt.e(kotlinx.coroutines.flow.FlowCollector, kotlinx.coroutines.channels.ReceiveChannel, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    @FlowPreview
    public static final <T> ReceiveChannel<T> f(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope coroutineScope) {
        return ChannelFlowKt.b(flow).o(coroutineScope);
    }

    @NotNull
    public static final <T> Flow<T> g(@NotNull ReceiveChannel<? extends T> receiveChannel) {
        return new ChannelAsFlow(receiveChannel, false, (CoroutineContext) null, 0, (BufferOverflow) null, 28, (DefaultConstructorMarker) null);
    }
}
