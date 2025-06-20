package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H@"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 6, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7", f = "Zip.kt", i = {}, l = {308}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__ZipKt$combineTransform$7 extends SuspendLambda implements Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> {
    int X2;
    private /* synthetic */ Object Y2;
    final /* synthetic */ Flow<T>[] Z2;
    final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> a3;

    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H@"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", ""}, k = 3, mv = {1, 6, 0}, xi = 176)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$2", f = "Zip.kt", i = {}, l = {308}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$2  reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> {
        int X2;
        private /* synthetic */ Object Y2;
        /* synthetic */ Object Z2;

        @Nullable
        public final Object D(@NotNull Object obj) {
            Object l2 = IntrinsicsKt.l();
            int i2 = this.X2;
            if (i2 == 0) {
                ResultKt.n(obj);
                Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> function3 = r3;
                this.Y2 = null;
                this.X2 = 1;
                if (function3.A((FlowCollector) this.Y2, (Object[]) this.Z2, this) == l2) {
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
        public final Object A(@NotNull FlowCollector<? super R> flowCollector, @NotNull T[] tArr, @Nullable Continuation<? super Unit> continuation) {
            AnonymousClass2 r0 = new AnonymousClass2(r3, continuation);
            r0.Y2 = flowCollector;
            r0.Z2 = tArr;
            return r0.D(Unit.f28779a);
        }

        @Nullable
        public final Object c0(@NotNull Object obj) {
            r3.A((FlowCollector) this.Y2, (Object[]) this.Z2, this);
            return Unit.f28779a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combineTransform$7(Flow<T>[] flowArr, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super FlowKt__ZipKt$combineTransform$7> continuation) {
        super(2, continuation);
        this.Z2 = flowArr;
        this.a3 = function3;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        Object l2 = IntrinsicsKt.l();
        int i2 = this.X2;
        if (i2 == 0) {
            ResultKt.n(obj);
            Flow<T>[] flowArr = this.Z2;
            Intrinsics.w();
            final Flow<T>[] flowArr2 = this.Z2;
            AnonymousClass1 r3 = new Function0<T[]>() {
                @Nullable
                /* renamed from: b */
                public final T[] o() {
                    int length = r2.length;
                    Intrinsics.y(0, "T?");
                    return new Object[length];
                }
            };
            Intrinsics.w();
            final Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> function3 = this.a3;
            AnonymousClass2 r4 = new AnonymousClass2((Continuation<? super AnonymousClass2>) null);
            this.X2 = 1;
            if (CombineKt.a((FlowCollector) this.Y2, flowArr, r3, r4, this) == l2) {
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
        return ((FlowKt__ZipKt$combineTransform$7) v(flowCollector, continuation)).D(Unit.f28779a);
    }

    @Nullable
    public final Object c0(@NotNull Object obj) {
        Flow<T>[] flowArr = this.Z2;
        Intrinsics.w();
        final Flow<T>[] flowArr2 = this.Z2;
        AnonymousClass1 r1 = new Function0<T[]>() {
            @Nullable
            /* renamed from: b */
            public final T[] o() {
                int length = flowArr2.length;
                Intrinsics.y(0, "T?");
                return new Object[length];
            }
        };
        Intrinsics.w();
        final Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> function3 = this.a3;
        AnonymousClass2 r2 = new AnonymousClass2((Continuation<? super AnonymousClass2>) null);
        InlineMarker.e(0);
        CombineKt.a((FlowCollector) this.Y2, flowArr, r1, r2, this);
        InlineMarker.e(1);
        return Unit.f28779a;
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__ZipKt$combineTransform$7 flowKt__ZipKt$combineTransform$7 = new FlowKt__ZipKt$combineTransform$7(this.Z2, this.a3, continuation);
        flowKt__ZipKt$combineTransform$7.Y2 = obj;
        return flowKt__ZipKt$combineTransform$7;
    }
}
