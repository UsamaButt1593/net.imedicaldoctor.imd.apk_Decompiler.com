package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {222, 355}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "timeoutMillis", "downstream", "values", "lastValue", "timeoutMillis"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
final class FlowKt__DelayKt$debounceInternal$1 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    Object X2;
    Object Y2;
    int Z2;
    private /* synthetic */ Object a3;
    /* synthetic */ Object b3;
    final /* synthetic */ Function1<T, Long> c3;
    final /* synthetic */ Flow<T> d3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$debounceInternal$1(Function1<? super T, Long> function1, Flow<? extends T> flow, Continuation<? super FlowKt__DelayKt$debounceInternal$1> continuation) {
        super(3, continuation);
        this.c3 = function1;
        this.d3 = flow;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:8|27|28|31|32|33|(1:35)|38|40|(1:42)|(1:44)) */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d7, code lost:
        r15 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e6, code lost:
        r7.g1(r15);
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cc A[Catch:{ all -> 0x00d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00f8 A[RETURN] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object D(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r1 = r14.Z2
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0042
            if (r1 == r3) goto L_0x002e
            if (r1 != r2) goto L_0x0026
            java.lang.Object r1 = r14.Y2
            kotlin.jvm.internal.Ref$LongRef r1 = (kotlin.jvm.internal.Ref.LongRef) r1
            java.lang.Object r1 = r14.X2
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r5 = r14.b3
            kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
            java.lang.Object r6 = r14.a3
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            kotlin.ResultKt.n(r15)
        L_0x0022:
            r7 = r6
            r6 = r5
            r5 = r1
            goto L_0x0064
        L_0x0026:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x002e:
            java.lang.Object r1 = r14.Y2
            kotlin.jvm.internal.Ref$LongRef r1 = (kotlin.jvm.internal.Ref.LongRef) r1
            java.lang.Object r5 = r14.X2
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            java.lang.Object r6 = r14.b3
            kotlinx.coroutines.channels.ReceiveChannel r6 = (kotlinx.coroutines.channels.ReceiveChannel) r6
            java.lang.Object r7 = r14.a3
            kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
            kotlin.ResultKt.n(r15)
            goto L_0x00a6
        L_0x0042:
            kotlin.ResultKt.n(r15)
            java.lang.Object r15 = r14.a3
            r5 = r15
            kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
            java.lang.Object r15 = r14.b3
            kotlinx.coroutines.flow.FlowCollector r15 = (kotlinx.coroutines.flow.FlowCollector) r15
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1 r8 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1
            kotlinx.coroutines.flow.Flow<T> r1 = r14.d3
            r8.<init>(r1, r4)
            r9 = 3
            r10 = 0
            r6 = 0
            r7 = 0
            kotlinx.coroutines.channels.ReceiveChannel r1 = kotlinx.coroutines.channels.ProduceKt.f(r5, r6, r7, r8, r9, r10)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            r7 = r15
            r6 = r1
        L_0x0064:
            T r15 = r5.s
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.flow.internal.NullSurrogateKt.f29325c
            if (r15 == r1) goto L_0x00f9
            kotlin.jvm.internal.Ref$LongRef r1 = new kotlin.jvm.internal.Ref$LongRef
            r1.<init>()
            T r15 = r5.s
            if (r15 == 0) goto L_0x00a8
            kotlin.jvm.functions.Function1<T, java.lang.Long> r8 = r14.c3
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.flow.internal.NullSurrogateKt.f29323a
            if (r15 != r9) goto L_0x007a
            r15 = r4
        L_0x007a:
            java.lang.Object r15 = r8.f(r15)
            java.lang.Number r15 = (java.lang.Number) r15
            long r10 = r15.longValue()
            r1.s = r10
            r12 = 0
            int r15 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r15 < 0) goto L_0x00ad
            int r15 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r15 != 0) goto L_0x00a8
            T r15 = r5.s
            if (r15 != r9) goto L_0x0095
            r15 = r4
        L_0x0095:
            r14.a3 = r7
            r14.b3 = r6
            r14.X2 = r5
            r14.Y2 = r1
            r14.Z2 = r3
            java.lang.Object r15 = r7.h(r15, r14)
            if (r15 != r0) goto L_0x00a6
            return r0
        L_0x00a6:
            r5.s = r4
        L_0x00a8:
            r15 = r1
            r1 = r5
            r5 = r6
            r6 = r7
            goto L_0x00b9
        L_0x00ad:
            java.lang.IllegalArgumentException r15 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Debounce timeout should not be negative"
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            throw r15
        L_0x00b9:
            r14.a3 = r6
            r14.b3 = r5
            r14.X2 = r1
            r14.Y2 = r15
            r14.Z2 = r2
            kotlinx.coroutines.selects.SelectBuilderImpl r7 = new kotlinx.coroutines.selects.SelectBuilderImpl
            r7.<init>(r14)
            T r8 = r1.s     // Catch:{ all -> 0x00d7 }
            if (r8 == 0) goto L_0x00d9
            long r8 = r15.s     // Catch:{ all -> 0x00d7 }
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1 r15 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1     // Catch:{ all -> 0x00d7 }
            r15.<init>(r6, r1, r4)     // Catch:{ all -> 0x00d7 }
            r7.U(r8, r15)     // Catch:{ all -> 0x00d7 }
            goto L_0x00d9
        L_0x00d7:
            r15 = move-exception
            goto L_0x00e6
        L_0x00d9:
            kotlinx.coroutines.selects.SelectClause1 r15 = r5.o()     // Catch:{ all -> 0x00d7 }
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2 r8 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2     // Catch:{ all -> 0x00d7 }
            r8.<init>(r1, r6, r4)     // Catch:{ all -> 0x00d7 }
            r7.q0(r15, r8)     // Catch:{ all -> 0x00d7 }
            goto L_0x00e9
        L_0x00e6:
            r7.g1(r15)
        L_0x00e9:
            java.lang.Object r15 = r7.f1()
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            if (r15 != r7) goto L_0x00f6
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r14)
        L_0x00f6:
            if (r15 != r0) goto L_0x0022
            return r0
        L_0x00f9:
            kotlin.Unit r15 = kotlin.Unit.f28779a
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1.D(java.lang.Object):java.lang.Object");
    }

    @Nullable
    /* renamed from: U */
    public final Object A(@NotNull CoroutineScope coroutineScope, @NotNull FlowCollector<? super T> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(this.c3, this.d3, continuation);
        flowKt__DelayKt$debounceInternal$1.a3 = coroutineScope;
        flowKt__DelayKt$debounceInternal$1.b3 = flowCollector;
        return flowKt__DelayKt$debounceInternal$1.D(Unit.f28779a);
    }
}
