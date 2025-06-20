package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\u00020\u0005H@"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", f = "Combine.kt", i = {0}, l = {129}, m = "invokeSuspend", n = {"second"}, s = {"L$0"})
final class CombineKt$zipImpl$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int X2;
    private /* synthetic */ Object Y2;
    final /* synthetic */ FlowCollector<R> Z2;
    final /* synthetic */ Flow<T2> a3;
    final /* synthetic */ Flow<T1> b3;
    final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> c3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombineKt$zipImpl$1$1(FlowCollector<? super R> flowCollector, Flow<? extends T2> flow, Flow<? extends T1> flow2, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super CombineKt$zipImpl$1$1> continuation) {
        super(2, continuation);
        this.Z2 = flowCollector;
        this.a3 = flow;
        this.b3 = flow2;
        this.c3 = function3;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object D(@org.jetbrains.annotations.NotNull java.lang.Object r20) {
        /*
            r19 = this;
            r8 = r19
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r1 = r8.X2
            r9 = 1
            r10 = 0
            if (r1 == 0) goto L_0x0026
            if (r1 != r9) goto L_0x001e
            java.lang.Object r0 = r8.Y2
            r1 = r0
            kotlinx.coroutines.channels.ReceiveChannel r1 = (kotlinx.coroutines.channels.ReceiveChannel) r1
            kotlin.ResultKt.n(r20)     // Catch:{ AbortFlowException -> 0x001b }
            goto L_0x0086
        L_0x0018:
            r0 = move-exception
            goto L_0x009f
        L_0x001b:
            r0 = move-exception
            goto L_0x0096
        L_0x001e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0026:
            kotlin.ResultKt.n(r20)
            java.lang.Object r1 = r8.Y2
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1 r5 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1
            kotlinx.coroutines.flow.Flow<T2> r2 = r8.a3
            r5.<init>(r2, r10)
            r6 = 3
            r7 = 0
            r3 = 0
            r4 = 0
            r2 = r1
            kotlinx.coroutines.channels.ReceiveChannel r7 = kotlinx.coroutines.channels.ProduceKt.f(r2, r3, r4, r5, r6, r7)
            kotlinx.coroutines.CompletableJob r2 = kotlinx.coroutines.JobKt__JobKt.c(r10, r9, r10)
            r3 = r7
            kotlinx.coroutines.channels.SendChannel r3 = (kotlinx.coroutines.channels.SendChannel) r3
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$1 r4 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$1
            kotlinx.coroutines.flow.FlowCollector<R> r5 = r8.Z2
            r4.<init>(r2, r5)
            r3.X(r4)
            kotlin.coroutines.CoroutineContext r13 = r1.U()     // Catch:{ AbortFlowException -> 0x0093, all -> 0x0090 }
            java.lang.Object r14 = kotlinx.coroutines.internal.ThreadContextKt.b(r13)     // Catch:{ AbortFlowException -> 0x0093, all -> 0x0090 }
            kotlin.coroutines.CoroutineContext r1 = r1.U()     // Catch:{ AbortFlowException -> 0x0093, all -> 0x0090 }
            kotlin.coroutines.CoroutineContext r1 = r1.v(r2)     // Catch:{ AbortFlowException -> 0x0093, all -> 0x0090 }
            kotlin.Unit r2 = kotlin.Unit.f28779a     // Catch:{ AbortFlowException -> 0x0093, all -> 0x0090 }
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2 r4 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2     // Catch:{ AbortFlowException -> 0x0093, all -> 0x0090 }
            kotlinx.coroutines.flow.Flow<T1> r12 = r8.b3     // Catch:{ AbortFlowException -> 0x0093, all -> 0x0090 }
            kotlinx.coroutines.flow.FlowCollector<R> r3 = r8.Z2     // Catch:{ AbortFlowException -> 0x0093, all -> 0x0090 }
            kotlin.jvm.functions.Function3<T1, T2, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r5 = r8.c3     // Catch:{ AbortFlowException -> 0x0093, all -> 0x0090 }
            r18 = 0
            r11 = r4
            r15 = r7
            r16 = r3
            r17 = r5
            r11.<init>(r12, r13, r14, r15, r16, r17, r18)     // Catch:{ AbortFlowException -> 0x0093, all -> 0x0090 }
            r8.Y2 = r7     // Catch:{ AbortFlowException -> 0x0093, all -> 0x0090 }
            r8.X2 = r9     // Catch:{ AbortFlowException -> 0x0093, all -> 0x0090 }
            r3 = 0
            r6 = 4
            r11 = 0
            r5 = r19
            r12 = r7
            r7 = r11
            java.lang.Object r1 = kotlinx.coroutines.flow.internal.ChannelFlowKt.d(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ AbortFlowException -> 0x008d, all -> 0x008a }
            if (r1 != r0) goto L_0x0085
            return r0
        L_0x0085:
            r1 = r12
        L_0x0086:
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.b(r1, r10, r9, r10)
            goto L_0x009c
        L_0x008a:
            r0 = move-exception
        L_0x008b:
            r1 = r12
            goto L_0x009f
        L_0x008d:
            r0 = move-exception
        L_0x008e:
            r1 = r12
            goto L_0x0096
        L_0x0090:
            r0 = move-exception
            r12 = r7
            goto L_0x008b
        L_0x0093:
            r0 = move-exception
            r12 = r7
            goto L_0x008e
        L_0x0096:
            kotlinx.coroutines.flow.FlowCollector<R> r2 = r8.Z2     // Catch:{ all -> 0x0018 }
            kotlinx.coroutines.flow.internal.FlowExceptions_commonKt.b(r0, r2)     // Catch:{ all -> 0x0018 }
            goto L_0x0086
        L_0x009c:
            kotlin.Unit r0 = kotlin.Unit.f28779a
            return r0
        L_0x009f:
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.b(r1, r10, r9, r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1.D(java.lang.Object):java.lang.Object");
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CombineKt$zipImpl$1$1) v(coroutineScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CombineKt$zipImpl$1$1 combineKt$zipImpl$1$1 = new CombineKt$zipImpl$1$1(this.Z2, this.a3, this.b3, this.c3, continuation);
        combineKt$zipImpl$1$1.Y2 = obj;
        return combineKt$zipImpl$1$1;
    }
}
