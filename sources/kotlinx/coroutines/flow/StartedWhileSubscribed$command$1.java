package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/flow/SharingCommand;", "count", ""}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", i = {1, 2, 3}, l = {178, 180, 182, 183, 185}, m = "invokeSuspend", n = {"$this$transformLatest", "$this$transformLatest", "$this$transformLatest"}, s = {"L$0", "L$0", "L$0"})
final class StartedWhileSubscribed$command$1 extends SuspendLambda implements Function3<FlowCollector<? super SharingCommand>, Integer, Continuation<? super Unit>, Object> {
    int X2;
    private /* synthetic */ Object Y2;
    /* synthetic */ int Z2;
    final /* synthetic */ StartedWhileSubscribed a3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StartedWhileSubscribed$command$1(StartedWhileSubscribed startedWhileSubscribed, Continuation<? super StartedWhileSubscribed$command$1> continuation) {
        super(3, continuation);
        this.a3 = startedWhileSubscribed;
    }

    public /* bridge */ /* synthetic */ Object A(Object obj, Object obj2, Object obj3) {
        return U((FlowCollector) obj, ((Number) obj2).intValue(), (Continuation) obj3);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009b A[RETURN] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object D(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r1 = r9.X2
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L_0x003c
            if (r1 == r6) goto L_0x0038
            if (r1 == r5) goto L_0x0030
            if (r1 == r4) goto L_0x0028
            if (r1 == r3) goto L_0x0020
            if (r1 != r2) goto L_0x0018
            goto L_0x0038
        L_0x0018:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0020:
            java.lang.Object r1 = r9.Y2
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.n(r10)
            goto L_0x008e
        L_0x0028:
            java.lang.Object r1 = r9.Y2
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.n(r10)
            goto L_0x007d
        L_0x0030:
            java.lang.Object r1 = r9.Y2
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.n(r10)
            goto L_0x0064
        L_0x0038:
            kotlin.ResultKt.n(r10)
            goto L_0x009c
        L_0x003c:
            kotlin.ResultKt.n(r10)
            java.lang.Object r10 = r9.Y2
            r1 = r10
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            int r10 = r9.Z2
            if (r10 <= 0) goto L_0x0053
            kotlinx.coroutines.flow.SharingCommand r10 = kotlinx.coroutines.flow.SharingCommand.START
            r9.X2 = r6
            java.lang.Object r10 = r1.h(r10, r9)
            if (r10 != r0) goto L_0x009c
            return r0
        L_0x0053:
            kotlinx.coroutines.flow.StartedWhileSubscribed r10 = r9.a3
            long r6 = r10.f29317b
            r9.Y2 = r1
            r9.X2 = r5
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.b(r6, r9)
            if (r10 != r0) goto L_0x0064
            return r0
        L_0x0064:
            kotlinx.coroutines.flow.StartedWhileSubscribed r10 = r9.a3
            long r5 = r10.f29318c
            r7 = 0
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 <= 0) goto L_0x008e
            kotlinx.coroutines.flow.SharingCommand r10 = kotlinx.coroutines.flow.SharingCommand.STOP
            r9.Y2 = r1
            r9.X2 = r4
            java.lang.Object r10 = r1.h(r10, r9)
            if (r10 != r0) goto L_0x007d
            return r0
        L_0x007d:
            kotlinx.coroutines.flow.StartedWhileSubscribed r10 = r9.a3
            long r4 = r10.f29318c
            r9.Y2 = r1
            r9.X2 = r3
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.b(r4, r9)
            if (r10 != r0) goto L_0x008e
            return r0
        L_0x008e:
            kotlinx.coroutines.flow.SharingCommand r10 = kotlinx.coroutines.flow.SharingCommand.STOP_AND_RESET_REPLAY_CACHE
            r3 = 0
            r9.Y2 = r3
            r9.X2 = r2
            java.lang.Object r10 = r1.h(r10, r9)
            if (r10 != r0) goto L_0x009c
            return r0
        L_0x009c:
            kotlin.Unit r10 = kotlin.Unit.f28779a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StartedWhileSubscribed$command$1.D(java.lang.Object):java.lang.Object");
    }

    @Nullable
    public final Object U(@NotNull FlowCollector<? super SharingCommand> flowCollector, int i2, @Nullable Continuation<? super Unit> continuation) {
        StartedWhileSubscribed$command$1 startedWhileSubscribed$command$1 = new StartedWhileSubscribed$command$1(this.a3, continuation);
        startedWhileSubscribed$command$1.Y2 = flowCollector;
        startedWhileSubscribed$command$1.Z2 = i2;
        return startedWhileSubscribed$command$1.D(Unit.f28779a);
    }
}
