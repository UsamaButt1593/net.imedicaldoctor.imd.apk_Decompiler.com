package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\b¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "a", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
public final class SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1 implements Flow<T> {
    final /* synthetic */ Flow s;

    public SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1(Flow flow) {
        this.s = flow;
    }

    @Nullable
    public Object a(@NotNull final FlowCollector flowCollector, @NotNull Continuation continuation) {
        Object a2 = this.s.a(new FlowCollector<State<T>>() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            @org.jetbrains.annotations.Nullable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object h(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r6
                    androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1 r0 = (androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.X2
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.X2 = r1
                    goto L_0x0018
                L_0x0013:
                    androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1 r0 = new androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2$1
                    r0.<init>(r4, r6)
                L_0x0018:
                    java.lang.Object r6 = r0.Z
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
                    int r2 = r0.X2
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    kotlin.ResultKt.n(r6)
                    goto L_0x0053
                L_0x0029:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L_0x0031:
                    kotlin.ResultKt.n(r6)
                    kotlinx.coroutines.flow.FlowCollector r6 = r3
                    androidx.datastore.core.State r5 = (androidx.datastore.core.State) r5
                    boolean r2 = r5 instanceof androidx.datastore.core.ReadException
                    if (r2 != 0) goto L_0x0073
                    boolean r2 = r5 instanceof androidx.datastore.core.Final
                    if (r2 != 0) goto L_0x006c
                    boolean r2 = r5 instanceof androidx.datastore.core.Data
                    if (r2 == 0) goto L_0x0056
                    androidx.datastore.core.Data r5 = (androidx.datastore.core.Data) r5
                    java.lang.Object r5 = r5.c()
                    r0.X2 = r3
                    java.lang.Object r5 = r6.h(r5, r0)
                    if (r5 != r1) goto L_0x0053
                    return r1
                L_0x0053:
                    kotlin.Unit r5 = kotlin.Unit.f28779a
                    return r5
                L_0x0056:
                    boolean r5 = r5 instanceof androidx.datastore.core.UnInitialized
                    if (r5 == 0) goto L_0x0066
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542"
                    java.lang.String r6 = r6.toString()
                    r5.<init>(r6)
                    throw r5
                L_0x0066:
                    kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
                    r5.<init>()
                    throw r5
                L_0x006c:
                    androidx.datastore.core.Final r5 = (androidx.datastore.core.Final) r5
                    java.lang.Throwable r5 = r5.a()
                    throw r5
                L_0x0073:
                    androidx.datastore.core.ReadException r5 = (androidx.datastore.core.ReadException) r5
                    java.lang.Throwable r5 = r5.a()
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1.AnonymousClass2.h(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        return a2 == IntrinsicsKt.l() ? a2 : Unit.f28779a;
    }
}
