package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H@"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 6, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1", f = "Emitters.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__EmittersKt$transform$1 extends SuspendLambda implements Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> {
    int X2;
    private /* synthetic */ Object Y2;
    final /* synthetic */ Flow<T> Z2;
    final /* synthetic */ Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> a3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__EmittersKt$transform$1(Flow<? extends T> flow, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super FlowKt__EmittersKt$transform$1> continuation) {
        super(2, continuation);
        this.Z2 = flow;
        this.a3 = function3;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        Object l2 = IntrinsicsKt.l();
        int i2 = this.X2;
        if (i2 == 0) {
            ResultKt.n(obj);
            final FlowCollector flowCollector = (FlowCollector) this.Y2;
            Flow<T> flow = this.Z2;
            final Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> function3 = this.a3;
            AnonymousClass1 r3 = new FlowCollector() {
                @Nullable
                public final Object a(T t, @NotNull Continuation<? super Unit> continuation) {
                    InlineMarker.e(4);
                    new FlowKt__EmittersKt$transform$1$1$emit$1(this, continuation);
                    InlineMarker.e(5);
                    r2.A(r4, t, continuation);
                    return Unit.f28779a;
                }

                /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
                @org.jetbrains.annotations.Nullable
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object h(T r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1
                        if (r0 == 0) goto L_0x0013
                        r0 = r6
                        kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1) r0
                        int r1 = r0.Y2
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L_0x0013
                        int r1 = r1 - r2
                        r0.Y2 = r1
                        goto L_0x0018
                    L_0x0013:
                        kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1
                        r0.<init>(r4, r6)
                    L_0x0018:
                        java.lang.Object r6 = r0.Z
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
                        int r2 = r0.Y2
                        r3 = 1
                        if (r2 == 0) goto L_0x0031
                        if (r2 != r3) goto L_0x0029
                        kotlin.ResultKt.n(r6)
                        goto L_0x0041
                    L_0x0029:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L_0x0031:
                        kotlin.ResultKt.n(r6)
                        kotlin.jvm.functions.Function3<kotlinx.coroutines.flow.FlowCollector<? super R>, T, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r6 = r2
                        kotlinx.coroutines.flow.FlowCollector<R> r2 = r4
                        r0.Y2 = r3
                        java.lang.Object r5 = r6.A(r2, r5, r0)
                        if (r5 != r1) goto L_0x0041
                        return r1
                    L_0x0041:
                        kotlin.Unit r5 = kotlin.Unit.f28779a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1.AnonymousClass1.h(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            };
            this.X2 = 1;
            if (flow.a(r3, this) == l2) {
                return l2;
            }
        } else if (i2 == 1) {
            ResultKt.n(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f28779a;
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull FlowCollector<? super R> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((FlowKt__EmittersKt$transform$1) v(flowCollector, continuation)).D(Unit.f28779a);
    }

    @Nullable
    public final Object c0(@NotNull Object obj) {
        final FlowCollector flowCollector = (FlowCollector) this.Y2;
        Flow<T> flow = this.Z2;
        final Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> function3 = this.a3;
        AnonymousClass1 r1 = new FlowCollector() {
            @Nullable
            public final Object a(T t, @NotNull Continuation<? super Unit> continuation) {
                InlineMarker.e(4);
                new FlowKt__EmittersKt$transform$1$1$emit$1(this, continuation);
                InlineMarker.e(5);
                function3.A(flowCollector, t, continuation);
                return Unit.f28779a;
            }

            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object h(T r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1
                    if (r0 == 0) goto L_0x0013
                    r0 = r6
                    kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1) r0
                    int r1 = r0.Y2
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.Y2 = r1
                    goto L_0x0018
                L_0x0013:
                    kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1$emit$1
                    r0.<init>(r4, r6)
                L_0x0018:
                    java.lang.Object r6 = r0.Z
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
                    int r2 = r0.Y2
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    kotlin.ResultKt.n(r6)
                    goto L_0x0041
                L_0x0029:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L_0x0031:
                    kotlin.ResultKt.n(r6)
                    kotlin.jvm.functions.Function3<kotlinx.coroutines.flow.FlowCollector<? super R>, T, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r6 = r2
                    kotlinx.coroutines.flow.FlowCollector<R> r2 = r4
                    r0.Y2 = r3
                    java.lang.Object r5 = r6.A(r2, r5, r0)
                    if (r5 != r1) goto L_0x0041
                    return r1
                L_0x0041:
                    kotlin.Unit r5 = kotlin.Unit.f28779a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1.AnonymousClass1.h(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        };
        InlineMarker.e(0);
        flow.a(r1, this);
        InlineMarker.e(1);
        return Unit.f28779a;
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__EmittersKt$transform$1 flowKt__EmittersKt$transform$1 = new FlowKt__EmittersKt$transform$1(this.Z2, this.a3, continuation);
        flowKt__EmittersKt$transform$1.Y2 = obj;
        return flowKt__EmittersKt$transform$1;
    }
}
