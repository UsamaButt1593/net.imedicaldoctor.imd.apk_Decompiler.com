package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\b¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "a", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class FlowKt__TransformKt$map$$inlined$unsafeTransform$1 implements Flow<R> {
    final /* synthetic */ Function2 X;
    final /* synthetic */ Flow s;

    public FlowKt__TransformKt$map$$inlined$unsafeTransform$1(Flow flow, Function2 function2) {
        this.s = flow;
        this.X = function2;
    }

    @Nullable
    public Object a(@NotNull final FlowCollector flowCollector, @NotNull Continuation continuation) {
        Flow flow = this.s;
        final Function2 function2 = this.X;
        Object a2 = flow.a(new FlowCollector() {
            @Nullable
            public final Object a(Object obj, @NotNull Continuation continuation) {
                InlineMarker.e(4);
                new ContinuationImpl(this, continuation) {
                    int X2;
                    final /* synthetic */ AnonymousClass2 Y2;
                    /* synthetic */ Object Z;
                    Object Z2;

                    {
                        this.Y2 = r1;
                    }

                    @Nullable
                    public final Object D(@NotNull Object obj) {
                        this.Z = obj;
                        this.X2 |= Integer.MIN_VALUE;
                        return this.Y2.h(null, this);
                    }
                };
                InlineMarker.e(5);
                FlowCollector flowCollector = r4;
                Object d0 = r2.d0(obj, continuation);
                InlineMarker.e(0);
                flowCollector.h(d0, continuation);
                InlineMarker.e(1);
                return Unit.f28779a;
            }

            /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x005c A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            @org.jetbrains.annotations.Nullable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object h(T r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r8
                    kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.X2
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.X2 = r1
                    goto L_0x0018
                L_0x0013:
                    kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2$1
                    r0.<init>(r6, r8)
                L_0x0018:
                    java.lang.Object r8 = r0.Z
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
                    int r2 = r0.X2
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L_0x003c
                    if (r2 == r4) goto L_0x0034
                    if (r2 != r3) goto L_0x002c
                    kotlin.ResultKt.n(r8)
                    goto L_0x005d
                L_0x002c:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L_0x0034:
                    java.lang.Object r7 = r0.Z2
                    kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                    kotlin.ResultKt.n(r8)
                    goto L_0x0051
                L_0x003c:
                    kotlin.ResultKt.n(r8)
                    kotlinx.coroutines.flow.FlowCollector r8 = r4
                    kotlin.jvm.functions.Function2 r2 = r2
                    r0.Z2 = r8
                    r0.X2 = r4
                    java.lang.Object r7 = r2.d0(r7, r0)
                    if (r7 != r1) goto L_0x004e
                    return r1
                L_0x004e:
                    r5 = r8
                    r8 = r7
                    r7 = r5
                L_0x0051:
                    r2 = 0
                    r0.Z2 = r2
                    r0.X2 = r3
                    java.lang.Object r7 = r7.h(r8, r0)
                    if (r7 != r1) goto L_0x005d
                    return r1
                L_0x005d:
                    kotlin.Unit r7 = kotlin.Unit.f28779a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1.AnonymousClass2.h(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        return a2 == IntrinsicsKt.l() ? a2 : Unit.f28779a;
    }

    @Nullable
    public Object d(@NotNull final FlowCollector flowCollector, @NotNull Continuation continuation) {
        InlineMarker.e(4);
        new ContinuationImpl(this, continuation) {
            int X2;
            final /* synthetic */ FlowKt__TransformKt$map$$inlined$unsafeTransform$1 Y2;
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
        final Function2 function2 = this.X;
        AnonymousClass2 r1 = new FlowCollector() {
            @Nullable
            public final Object a(Object obj, @NotNull Continuation continuation) {
                InlineMarker.e(4);
                new ContinuationImpl(this, continuation) {
                    int X2;
                    final /* synthetic */ AnonymousClass2 Y2;
                    /* synthetic */ Object Z;
                    Object Z2;

                    {
                        this.Y2 = r1;
                    }

                    @Nullable
                    public final Object D(@NotNull Object obj) {
                        this.Z = obj;
                        this.X2 |= Integer.MIN_VALUE;
                        return this.Y2.h(null, this);
                    }
                };
                InlineMarker.e(5);
                FlowCollector flowCollector = flowCollector;
                Object d0 = function2.d0(obj, continuation);
                InlineMarker.e(0);
                flowCollector.h(d0, continuation);
                InlineMarker.e(1);
                return Unit.f28779a;
            }

            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object h(T r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r8
                    kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.X2
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.X2 = r1
                    goto L_0x0018
                L_0x0013:
                    kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2$1
                    r0.<init>(r6, r8)
                L_0x0018:
                    java.lang.Object r8 = r0.Z
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
                    int r2 = r0.X2
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L_0x003c
                    if (r2 == r4) goto L_0x0034
                    if (r2 != r3) goto L_0x002c
                    kotlin.ResultKt.n(r8)
                    goto L_0x005d
                L_0x002c:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L_0x0034:
                    java.lang.Object r7 = r0.Z2
                    kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                    kotlin.ResultKt.n(r8)
                    goto L_0x0051
                L_0x003c:
                    kotlin.ResultKt.n(r8)
                    kotlinx.coroutines.flow.FlowCollector r8 = r4
                    kotlin.jvm.functions.Function2 r2 = r2
                    r0.Z2 = r8
                    r0.X2 = r4
                    java.lang.Object r7 = r2.d0(r7, r0)
                    if (r7 != r1) goto L_0x004e
                    return r1
                L_0x004e:
                    r5 = r8
                    r8 = r7
                    r7 = r5
                L_0x0051:
                    r2 = 0
                    r0.Z2 = r2
                    r0.X2 = r3
                    java.lang.Object r7 = r7.h(r8, r0)
                    if (r7 != r1) goto L_0x005d
                    return r1
                L_0x005d:
                    kotlin.Unit r7 = kotlin.Unit.f28779a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$map$$inlined$unsafeTransform$1.AnonymousClass2.h(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        };
        InlineMarker.e(0);
        flow.a(r1, continuation);
        InlineMarker.e(1);
        return Unit.f28779a;
    }
}
