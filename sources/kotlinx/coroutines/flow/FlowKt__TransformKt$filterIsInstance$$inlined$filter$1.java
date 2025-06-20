package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\b¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "a", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class FlowKt__TransformKt$filterIsInstance$$inlined$filter$1 implements Flow<Object> {
    final /* synthetic */ Flow s;

    public FlowKt__TransformKt$filterIsInstance$$inlined$filter$1(Flow flow) {
        this.s = flow;
    }

    @Nullable
    public Object a(@NotNull final FlowCollector flowCollector, @NotNull Continuation continuation) {
        Flow flow = this.s;
        Intrinsics.w();
        Object a2 = flow.a(new FlowCollector() {
            @Nullable
            public final Object a(Object obj, @NotNull Continuation continuation) {
                InlineMarker.e(4);
                new ContinuationImpl(this, continuation) {
                    int X2;
                    Object Y2;
                    /* synthetic */ Object Z;
                    Object Z2;
                    final /* synthetic */ AnonymousClass2 a3;

                    {
                        this.a3 = r1;
                    }

                    @Nullable
                    public final Object D(@NotNull Object obj) {
                        this.Z = obj;
                        this.X2 |= Integer.MIN_VALUE;
                        return this.a3.h((Object) null, this);
                    }
                };
                InlineMarker.e(5);
                FlowCollector flowCollector = r3;
                Intrinsics.y(3, "R");
                if (obj instanceof Object) {
                    InlineMarker.e(0);
                    flowCollector.h(obj, continuation);
                    InlineMarker.e(1);
                }
                return Unit.f28779a;
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            @org.jetbrains.annotations.Nullable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object h(java.lang.Object r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r7
                    kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.X2
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.X2 = r1
                    goto L_0x0018
                L_0x0013:
                    kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1
                    r0.<init>(r5, r7)
                L_0x0018:
                    java.lang.Object r7 = r0.Z
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
                    int r2 = r0.X2
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    kotlin.ResultKt.n(r7)
                    goto L_0x0049
                L_0x0029:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L_0x0031:
                    kotlin.ResultKt.n(r7)
                    kotlinx.coroutines.flow.FlowCollector r7 = r3
                    r2 = 3
                    java.lang.String r4 = "R"
                    kotlin.jvm.internal.Intrinsics.y(r2, r4)
                    boolean r2 = r6 instanceof java.lang.Object
                    if (r2 == 0) goto L_0x0049
                    r0.X2 = r3
                    java.lang.Object r6 = r7.h(r6, r0)
                    if (r6 != r1) goto L_0x0049
                    return r1
                L_0x0049:
                    kotlin.Unit r6 = kotlin.Unit.f28779a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.h(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        return a2 == IntrinsicsKt.l() ? a2 : Unit.f28779a;
    }

    @Nullable
    public Object d(@NotNull final FlowCollector flowCollector, @NotNull Continuation continuation) {
        InlineMarker.e(4);
        new ContinuationImpl(this, continuation) {
            int X2;
            final /* synthetic */ FlowKt__TransformKt$filterIsInstance$$inlined$filter$1 Y2;
            /* synthetic */ Object Z;

            {
                this.Y2 = r1;
            }

            @Nullable
            public final Object D(@NotNull Object obj) {
                this.Z = obj;
                this.X2 |= Integer.MIN_VALUE;
                return this.Y2.a((FlowCollector) null, this);
            }
        };
        InlineMarker.e(5);
        Flow flow = this.s;
        Intrinsics.w();
        AnonymousClass2 r1 = new FlowCollector() {
            @Nullable
            public final Object a(Object obj, @NotNull Continuation continuation) {
                InlineMarker.e(4);
                new ContinuationImpl(this, continuation) {
                    int X2;
                    Object Y2;
                    /* synthetic */ Object Z;
                    Object Z2;
                    final /* synthetic */ AnonymousClass2 a3;

                    {
                        this.a3 = r1;
                    }

                    @Nullable
                    public final Object D(@NotNull Object obj) {
                        this.Z = obj;
                        this.X2 |= Integer.MIN_VALUE;
                        return this.a3.h((Object) null, this);
                    }
                };
                InlineMarker.e(5);
                FlowCollector flowCollector = flowCollector;
                Intrinsics.y(3, "R");
                if (obj instanceof Object) {
                    InlineMarker.e(0);
                    flowCollector.h(obj, continuation);
                    InlineMarker.e(1);
                }
                return Unit.f28779a;
            }

            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object h(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r7
                    kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.X2
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.X2 = r1
                    goto L_0x0018
                L_0x0013:
                    kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2$1
                    r0.<init>(r5, r7)
                L_0x0018:
                    java.lang.Object r7 = r0.Z
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
                    int r2 = r0.X2
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    kotlin.ResultKt.n(r7)
                    goto L_0x0049
                L_0x0029:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L_0x0031:
                    kotlin.ResultKt.n(r7)
                    kotlinx.coroutines.flow.FlowCollector r7 = r3
                    r2 = 3
                    java.lang.String r4 = "R"
                    kotlin.jvm.internal.Intrinsics.y(r2, r4)
                    boolean r2 = r6 instanceof java.lang.Object
                    if (r2 == 0) goto L_0x0049
                    r0.X2 = r3
                    java.lang.Object r6 = r7.h(r6, r0)
                    if (r6 != r1) goto L_0x0049
                    return r1
                L_0x0049:
                    kotlin.Unit r6 = kotlin.Unit.f28779a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$1.AnonymousClass2.h(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        };
        InlineMarker.e(0);
        flow.a(r1, continuation);
        InlineMarker.e(1);
        return Unit.f28779a;
    }
}
