package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H@"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it"}, k = 3, mv = {1, 6, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapLatest$1", f = "Merge.kt", i = {}, l = {190, 190}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__MergeKt$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> {
    int X2;
    private /* synthetic */ Object Y2;
    /* synthetic */ Object Z2;
    final /* synthetic */ Function2<T, Continuation<? super Flow<? extends R>>, Object> a3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__MergeKt$flatMapLatest$1(Function2<? super T, ? super Continuation<? super Flow<? extends R>>, ? extends Object> function2, Continuation<? super FlowKt__MergeKt$flatMapLatest$1> continuation) {
        super(3, continuation);
        this.a3 = function2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object D(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r1 = r5.X2
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.n(r6)
            goto L_0x0047
        L_0x0012:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001a:
            java.lang.Object r1 = r5.Y2
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.n(r6)
            goto L_0x0039
        L_0x0022:
            kotlin.ResultKt.n(r6)
            java.lang.Object r6 = r5.Y2
            r1 = r6
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            java.lang.Object r6 = r5.Z2
            kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends R>>, java.lang.Object> r4 = r5.a3
            r5.Y2 = r1
            r5.X2 = r3
            java.lang.Object r6 = r4.d0(r6, r5)
            if (r6 != r0) goto L_0x0039
            return r0
        L_0x0039:
            kotlinx.coroutines.flow.Flow r6 = (kotlinx.coroutines.flow.Flow) r6
            r3 = 0
            r5.Y2 = r3
            r5.X2 = r2
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.m0(r1, r6, r5)
            if (r6 != r0) goto L_0x0047
            return r0
        L_0x0047:
            kotlin.Unit r6 = kotlin.Unit.f28779a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapLatest$1.D(java.lang.Object):java.lang.Object");
    }

    @Nullable
    /* renamed from: U */
    public final Object A(@NotNull FlowCollector<? super R> flowCollector, T t, @Nullable Continuation<? super Unit> continuation) {
        FlowKt__MergeKt$flatMapLatest$1 flowKt__MergeKt$flatMapLatest$1 = new FlowKt__MergeKt$flatMapLatest$1(this.a3, continuation);
        flowKt__MergeKt$flatMapLatest$1.Y2 = flowCollector;
        flowKt__MergeKt$flatMapLatest$1.Z2 = t;
        return flowKt__MergeKt$flatMapLatest$1.D(Unit.f28779a);
    }

    @Nullable
    public final Object c0(@NotNull Object obj) {
        Object obj2 = this.Z2;
        InlineMarker.e(0);
        FlowKt.m0((FlowCollector) this.Y2, (Flow) this.a3.d0(obj2, this), this);
        InlineMarker.e(1);
        return Unit.f28779a;
    }
}
