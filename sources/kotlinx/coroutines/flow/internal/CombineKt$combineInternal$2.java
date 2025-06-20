package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "", "R", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {57, 79, 82}, m = "invokeSuspend", n = {"latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object X2;
    Object Y2;
    int Z2;
    int a3;
    int b3;
    private /* synthetic */ Object c3;
    final /* synthetic */ Flow<T>[] d3;
    final /* synthetic */ Function0<T[]> e3;
    final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> f3;
    final /* synthetic */ FlowCollector<R> g3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombineKt$combineInternal$2(Flow<? extends T>[] flowArr, Function0<T[]> function0, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> function3, FlowCollector<? super R> flowCollector, Continuation<? super CombineKt$combineInternal$2> continuation) {
        super(2, continuation);
        this.d3 = flowArr;
        this.e3 = function0;
        this.f3 = function3;
        this.g3 = flowCollector;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v4, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c9 A[LOOP:1: B:25:0x00c9->B:31:0x00ec, LOOP_START, PHI: r6 r10 
      PHI: (r6v2 int) = (r6v1 int), (r6v3 int) binds: [B:22:0x00c4, B:31:0x00ec] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r10v3 kotlin.collections.IndexedValue) = (r10v2 kotlin.collections.IndexedValue), (r10v16 kotlin.collections.IndexedValue) binds: [B:22:0x00c4, B:31:0x00ec] A[DONT_GENERATE, DONT_INLINE]] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object D(@org.jetbrains.annotations.NotNull java.lang.Object r24) {
        /*
            r23 = this;
            r0 = r23
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.b3
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0058
            if (r2 == r5) goto L_0x0035
            if (r2 == r4) goto L_0x001c
            if (r2 != r3) goto L_0x0014
            goto L_0x001c
        L_0x0014:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x001c:
            int r2 = r0.a3
            int r6 = r0.Z2
            java.lang.Object r7 = r0.Y2
            byte[] r7 = (byte[]) r7
            java.lang.Object r8 = r0.X2
            kotlinx.coroutines.channels.Channel r8 = (kotlinx.coroutines.channels.Channel) r8
            java.lang.Object r9 = r0.c3
            java.lang.Object[] r9 = (java.lang.Object[]) r9
            kotlin.ResultKt.n(r24)
            r21 = r2
            r2 = r7
            r7 = r8
            goto L_0x0136
        L_0x0035:
            int r2 = r0.a3
            int r6 = r0.Z2
            java.lang.Object r7 = r0.Y2
            byte[] r7 = (byte[]) r7
            java.lang.Object r8 = r0.X2
            kotlinx.coroutines.channels.Channel r8 = (kotlinx.coroutines.channels.Channel) r8
            java.lang.Object r9 = r0.c3
            java.lang.Object[] r9 = (java.lang.Object[]) r9
            kotlin.ResultKt.n(r24)
            r10 = r24
            kotlinx.coroutines.channels.ChannelResult r10 = (kotlinx.coroutines.channels.ChannelResult) r10
            java.lang.Object r10 = r10.o()
            r22 = r8
            r8 = r2
            r2 = r7
            r7 = r22
            goto L_0x00be
        L_0x0058:
            kotlin.ResultKt.n(r24)
            java.lang.Object r2 = r0.c3
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            kotlinx.coroutines.flow.Flow<T>[] r6 = r0.d3
            int r12 = r6.length
            if (r12 != 0) goto L_0x0067
            kotlin.Unit r1 = kotlin.Unit.f28779a
            return r1
        L_0x0067:
            java.lang.Object[] r13 = new java.lang.Object[r12]
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.flow.internal.NullSurrogateKt.f29324b
            r10 = 6
            r11 = 0
            r8 = 0
            r9 = 0
            r6 = r13
            kotlin.collections.ArraysKt.V1(r6, r7, r8, r9, r10, r11)
            r6 = 6
            r7 = 0
            kotlinx.coroutines.channels.Channel r20 = kotlinx.coroutines.channels.ChannelKt.d(r12, r7, r7, r6, r7)
            java.util.concurrent.atomic.AtomicInteger r11 = new java.util.concurrent.atomic.AtomicInteger
            r11.<init>(r12)
            r21 = 0
            r10 = 0
        L_0x0081:
            if (r10 >= r12) goto L_0x00a2
            kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1 r9 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1
            kotlinx.coroutines.flow.Flow<T>[] r15 = r0.d3
            r19 = 0
            r14 = r9
            r16 = r10
            r17 = r11
            r18 = r20
            r14.<init>(r15, r16, r17, r18, r19)
            r14 = 3
            r15 = 0
            r7 = 0
            r8 = 0
            r6 = r2
            r10 = r14
            r14 = r11
            r11 = r15
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.f(r6, r7, r8, r9, r10, r11)
            int r10 = r16 + 1
            r11 = r14
            goto L_0x0081
        L_0x00a2:
            byte[] r2 = new byte[r12]
            r6 = r12
            r7 = r20
        L_0x00a7:
            int r8 = r21 + 1
            byte r8 = (byte) r8
            r0.c3 = r13
            r0.X2 = r7
            r0.Y2 = r2
            r0.Z2 = r6
            r0.a3 = r8
            r0.b3 = r5
            java.lang.Object r10 = r7.E(r0)
            if (r10 != r1) goto L_0x00bd
            return r1
        L_0x00bd:
            r9 = r13
        L_0x00be:
            java.lang.Object r10 = kotlinx.coroutines.channels.ChannelResult.h(r10)
            kotlin.collections.IndexedValue r10 = (kotlin.collections.IndexedValue) r10
            if (r10 != 0) goto L_0x00c9
            kotlin.Unit r1 = kotlin.Unit.f28779a
            return r1
        L_0x00c9:
            int r11 = r10.e()
            r12 = r9[r11]
            java.lang.Object r10 = r10.f()
            r9[r11] = r10
            kotlinx.coroutines.internal.Symbol r10 = kotlinx.coroutines.flow.internal.NullSurrogateKt.f29324b
            if (r12 != r10) goto L_0x00db
            int r6 = r6 + -1
        L_0x00db:
            byte r10 = r2[r11]
            if (r10 == r8) goto L_0x00ee
            byte r10 = (byte) r8
            r2[r11] = r10
            java.lang.Object r10 = r7.B()
            java.lang.Object r10 = kotlinx.coroutines.channels.ChannelResult.h(r10)
            kotlin.collections.IndexedValue r10 = (kotlin.collections.IndexedValue) r10
            if (r10 != 0) goto L_0x00c9
        L_0x00ee:
            if (r6 != 0) goto L_0x0134
            kotlin.jvm.functions.Function0<T[]> r10 = r0.e3
            java.lang.Object r10 = r10.o()
            java.lang.Object[] r10 = (java.lang.Object[]) r10
            if (r10 != 0) goto L_0x0111
            kotlin.jvm.functions.Function3<kotlinx.coroutines.flow.FlowCollector<? super R>, T[], kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r10 = r0.f3
            kotlinx.coroutines.flow.FlowCollector<R> r11 = r0.g3
            r0.c3 = r9
            r0.X2 = r7
            r0.Y2 = r2
            r0.Z2 = r6
            r0.a3 = r8
            r0.b3 = r4
            java.lang.Object r10 = r10.A(r11, r9, r0)
            if (r10 != r1) goto L_0x0134
            return r1
        L_0x0111:
            r16 = 14
            r17 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r11 = r9
            r12 = r10
            kotlin.collections.ArraysKt.K0(r11, r12, r13, r14, r15, r16, r17)
            kotlin.jvm.functions.Function3<kotlinx.coroutines.flow.FlowCollector<? super R>, T[], kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r11 = r0.f3
            kotlinx.coroutines.flow.FlowCollector<R> r12 = r0.g3
            r0.c3 = r9
            r0.X2 = r7
            r0.Y2 = r2
            r0.Z2 = r6
            r0.a3 = r8
            r0.b3 = r3
            java.lang.Object r10 = r11.A(r12, r10, r0)
            if (r10 != r1) goto L_0x0134
            return r1
        L_0x0134:
            r21 = r8
        L_0x0136:
            r13 = r9
            goto L_0x00a7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.D(java.lang.Object):java.lang.Object");
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CombineKt$combineInternal$2) v(coroutineScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.d3, this.e3, this.f3, this.g3, continuation);
        combineKt$combineInternal$2.c3 = obj;
        return combineKt$combineInternal$2;
    }
}
