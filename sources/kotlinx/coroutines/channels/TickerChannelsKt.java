package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a;\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\t\u0010\n\u001a1\u0010\r\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a1\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"", "delayMillis", "initialDelayMillis", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/channels/TickerMode;", "mode", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "e", "(JJLkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/TickerMode;)Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/channels/SendChannel;", "channel", "d", "(JJLkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class TickerChannelsKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: kotlinx.coroutines.channels.SendChannel<? super kotlin.Unit>} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0071 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object c(long r6, long r8, kotlinx.coroutines.channels.SendChannel<? super kotlin.Unit> r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            boolean r0 = r11 instanceof kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1 r0 = (kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1) r0
            int r1 = r0.Z2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.Z2 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1 r0 = new kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1
            r0.<init>(r11)
        L_0x0018:
            java.lang.Object r11 = r0.Y2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.Z2
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0053
            if (r2 == r5) goto L_0x0048
            if (r2 == r4) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            long r6 = r0.Z
            java.lang.Object r8 = r0.X2
            kotlinx.coroutines.channels.SendChannel r8 = (kotlinx.coroutines.channels.SendChannel) r8
            kotlin.ResultKt.n(r11)
        L_0x0034:
            r10 = r8
            goto L_0x0063
        L_0x0036:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003e:
            long r6 = r0.Z
            java.lang.Object r8 = r0.X2
            kotlinx.coroutines.channels.SendChannel r8 = (kotlinx.coroutines.channels.SendChannel) r8
            kotlin.ResultKt.n(r11)
            goto L_0x0073
        L_0x0048:
            long r6 = r0.Z
            java.lang.Object r8 = r0.X2
            r10 = r8
            kotlinx.coroutines.channels.SendChannel r10 = (kotlinx.coroutines.channels.SendChannel) r10
            kotlin.ResultKt.n(r11)
            goto L_0x0063
        L_0x0053:
            kotlin.ResultKt.n(r11)
            r0.X2 = r10
            r0.Z = r6
            r0.Z2 = r5
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.b(r8, r0)
            if (r8 != r1) goto L_0x0063
            return r1
        L_0x0063:
            kotlin.Unit r8 = kotlin.Unit.f28779a
            r0.X2 = r10
            r0.Z = r6
            r0.Z2 = r4
            java.lang.Object r8 = r10.g0(r8, r0)
            if (r8 != r1) goto L_0x0072
            return r1
        L_0x0072:
            r8 = r10
        L_0x0073:
            r0.X2 = r8
            r0.Z = r6
            r0.Z2 = r3
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.b(r6, r0)
            if (r9 != r1) goto L_0x0034
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.TickerChannelsKt.c(long, long, kotlinx.coroutines.channels.SendChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object d(long r18, long r20, kotlinx.coroutines.channels.SendChannel<? super kotlin.Unit> r22, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
        /*
            r0 = r23
            boolean r1 = r0 instanceof kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1
            if (r1 == 0) goto L_0x0015
            r1 = r0
            kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1 r1 = (kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1) r1
            int r2 = r1.a3
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0015
            int r2 = r2 - r3
            r1.a3 = r2
            goto L_0x001a
        L_0x0015:
            kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1 r1 = new kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1
            r1.<init>(r0)
        L_0x001a:
            java.lang.Object r0 = r1.Z2
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r3 = r1.a3
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r3 == 0) goto L_0x0073
            if (r3 == r7) goto L_0x0065
            if (r3 == r6) goto L_0x0059
            if (r3 == r5) goto L_0x0046
            if (r3 != r4) goto L_0x003e
            long r7 = r1.X2
            long r9 = r1.Z
            java.lang.Object r3 = r1.Y2
            kotlinx.coroutines.channels.SendChannel r3 = (kotlinx.coroutines.channels.SendChannel) r3
            kotlin.ResultKt.n(r0)
            r0 = 3
            r11 = 4
            goto L_0x0052
        L_0x003e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0046:
            long r7 = r1.X2
            long r9 = r1.Z
            java.lang.Object r3 = r1.Y2
            kotlinx.coroutines.channels.SendChannel r3 = (kotlinx.coroutines.channels.SendChannel) r3
            kotlin.ResultKt.n(r0)
            r0 = 3
        L_0x0052:
            r16 = r7
            r7 = r9
            r9 = r16
            goto L_0x00f6
        L_0x0059:
            long r7 = r1.X2
            long r9 = r1.Z
            java.lang.Object r3 = r1.Y2
            kotlinx.coroutines.channels.SendChannel r3 = (kotlinx.coroutines.channels.SendChannel) r3
            kotlin.ResultKt.n(r0)
            goto L_0x00bc
        L_0x0065:
            long r7 = r1.X2
            long r9 = r1.Z
            java.lang.Object r3 = r1.Y2
            kotlinx.coroutines.channels.SendChannel r3 = (kotlinx.coroutines.channels.SendChannel) r3
            kotlin.ResultKt.n(r0)
            r0 = r3
            r10 = r9
            goto L_0x00a0
        L_0x0073:
            kotlin.ResultKt.n(r0)
            kotlinx.coroutines.AbstractTimeSource r0 = kotlinx.coroutines.AbstractTimeSourceKt.b()
            if (r0 == 0) goto L_0x0081
            long r8 = r0.b()
            goto L_0x0085
        L_0x0081:
            long r8 = java.lang.System.nanoTime()
        L_0x0085:
            long r10 = kotlinx.coroutines.EventLoop_commonKt.d(r20)
            long r8 = r8 + r10
            r0 = r22
            r1.Y2 = r0
            r10 = r18
            r1.Z = r10
            r1.X2 = r8
            r1.a3 = r7
            r12 = r20
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.b(r12, r1)
            if (r3 != r2) goto L_0x009f
            return r2
        L_0x009f:
            r7 = r8
        L_0x00a0:
            long r9 = kotlinx.coroutines.EventLoop_commonKt.d(r10)
        L_0x00a4:
            long r7 = r7 + r9
            kotlin.Unit r3 = kotlin.Unit.f28779a
            r1.Y2 = r0
            r1.Z = r7
            r1.X2 = r9
            r1.a3 = r6
            java.lang.Object r3 = r0.g0(r3, r1)
            if (r3 != r2) goto L_0x00b6
            return r2
        L_0x00b6:
            r3 = r0
            r16 = r7
            r7 = r9
            r9 = r16
        L_0x00bc:
            kotlinx.coroutines.AbstractTimeSource r0 = kotlinx.coroutines.AbstractTimeSourceKt.b()
            if (r0 == 0) goto L_0x00c7
            long r11 = r0.b()
            goto L_0x00cb
        L_0x00c7:
            long r11 = java.lang.System.nanoTime()
        L_0x00cb:
            long r13 = r9 - r11
            r4 = 0
            long r13 = kotlin.ranges.RangesKt.v(r13, r4)
            int r15 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r15 != 0) goto L_0x00fa
            int r15 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r15 == 0) goto L_0x00fa
            long r4 = r11 - r9
            long r4 = r4 % r7
            long r4 = r7 - r4
            long r9 = r11 + r4
            long r4 = kotlinx.coroutines.EventLoop_commonKt.c(r4)
            r1.Y2 = r3
            r1.Z = r9
            r1.X2 = r7
            r0 = 3
            r1.a3 = r0
            java.lang.Object r4 = kotlinx.coroutines.DelayKt.b(r4, r1)
            if (r4 != r2) goto L_0x0052
            return r2
        L_0x00f6:
            r0 = r3
            r4 = 4
            r5 = 3
            goto L_0x00a4
        L_0x00fa:
            r0 = 3
            long r4 = kotlinx.coroutines.EventLoop_commonKt.c(r13)
            r1.Y2 = r3
            r1.Z = r9
            r1.X2 = r7
            r11 = 4
            r1.a3 = r11
            java.lang.Object r4 = kotlinx.coroutines.DelayKt.b(r4, r1)
            if (r4 != r2) goto L_0x0052
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.TickerChannelsKt.d(long, long, kotlinx.coroutines.channels.SendChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    @ObsoleteCoroutinesApi
    public static final ReceiveChannel<Unit> e(long j2, long j3, @NotNull CoroutineContext coroutineContext, @NotNull TickerMode tickerMode) {
        if (j2 < 0) {
            throw new IllegalArgumentException(("Expected non-negative delay, but has " + j2 + " ms").toString());
        } else if (j3 >= 0) {
            return ProduceKt.c(GlobalScope.s, Dispatchers.g().v(coroutineContext), 0, new TickerChannelsKt$ticker$3(tickerMode, j2, j3, (Continuation<? super TickerChannelsKt$ticker$3>) null));
        } else {
            throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j3 + " ms").toString());
        }
    }

    public static /* synthetic */ ReceiveChannel f(long j2, long j3, CoroutineContext coroutineContext, TickerMode tickerMode, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j3 = j2;
        }
        if ((i2 & 4) != 0) {
            coroutineContext = EmptyCoroutineContext.s;
        }
        if ((i2 & 8) != 0) {
            tickerMode = TickerMode.FIXED_PERIOD;
        }
        return e(j2, j3, coroutineContext, tickerMode);
    }
}
