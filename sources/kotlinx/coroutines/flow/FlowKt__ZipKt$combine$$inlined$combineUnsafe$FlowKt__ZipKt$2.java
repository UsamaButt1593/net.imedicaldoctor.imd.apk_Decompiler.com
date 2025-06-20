package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\b¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "a", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2 implements Flow<R> {
    final /* synthetic */ Function5 X;
    final /* synthetic */ Flow[] s;

    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H@¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "kotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$1$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2", f = "Zip.kt", i = {}, l = {333, 333}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2  reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object> {
        int X2;
        private /* synthetic */ Object Y2;
        /* synthetic */ Object Z2;

        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object D(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
                int r1 = r10.X2
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0022
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                kotlin.ResultKt.n(r11)
                goto L_0x005a
            L_0x0012:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L_0x001a:
                java.lang.Object r1 = r10.Y2
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.n(r11)
                goto L_0x004e
            L_0x0022:
                kotlin.ResultKt.n(r11)
                java.lang.Object r11 = r10.Y2
                r1 = r11
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                java.lang.Object r11 = r10.Z2
                java.lang.Object[] r11 = (java.lang.Object[]) r11
                kotlin.jvm.functions.Function5 r4 = r4
                r5 = 0
                r5 = r11[r5]
                r6 = r11[r3]
                r7 = r11[r2]
                r8 = 3
                r8 = r11[r8]
                r10.Y2 = r1
                r10.X2 = r3
                r11 = 6
                kotlin.jvm.internal.InlineMarker.e(r11)
                r9 = r10
                java.lang.Object r11 = r4.h0(r5, r6, r7, r8, r9)
                r3 = 7
                kotlin.jvm.internal.InlineMarker.e(r3)
                if (r11 != r0) goto L_0x004e
                return r0
            L_0x004e:
                r3 = 0
                r10.Y2 = r3
                r10.X2 = r2
                java.lang.Object r11 = r1.h(r11, r10)
                if (r11 != r0) goto L_0x005a
                return r0
            L_0x005a:
                kotlin.Unit r11 = kotlin.Unit.f28779a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2.AnonymousClass2.D(java.lang.Object):java.lang.Object");
        }

        @Nullable
        /* renamed from: U */
        public final Object A(@NotNull FlowCollector<? super R> flowCollector, @NotNull Object[] objArr, @Nullable Continuation<? super Unit> continuation) {
            AnonymousClass2 r0 = new AnonymousClass2(continuation, function5);
            r0.Y2 = flowCollector;
            r0.Z2 = objArr;
            return r0.D(Unit.f28779a);
        }
    }

    public FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2(Flow[] flowArr, Function5 function5) {
        this.s = flowArr;
        this.X = function5;
    }

    @Nullable
    public Object a(@NotNull FlowCollector flowCollector, @NotNull Continuation continuation) {
        Flow[] flowArr = this.s;
        Function0 a2 = FlowKt__ZipKt.r();
        final Function5 function5 = this.X;
        Object a3 = CombineKt.a(flowCollector, flowArr, a2, new AnonymousClass2((Continuation) null), continuation);
        return a3 == IntrinsicsKt.l() ? a3 : Unit.f28779a;
    }
}
