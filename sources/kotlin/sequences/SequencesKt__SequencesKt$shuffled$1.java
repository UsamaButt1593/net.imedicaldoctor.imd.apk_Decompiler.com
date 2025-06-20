package kotlin.sequences;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", f = "Sequences.kt", i = {0, 0}, l = {145}, m = "invokeSuspend", n = {"$this$sequence", "buffer"}, s = {"L$0", "L$1"})
final class SequencesKt__SequencesKt$shuffled$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super T>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object X2;
    Object Y;
    final /* synthetic */ Sequence<T> Y2;
    int Z;
    final /* synthetic */ Random Z2;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt__SequencesKt$shuffled$1(Sequence<? extends T> sequence, Random random, Continuation<? super SequencesKt__SequencesKt$shuffled$1> continuation) {
        super(2, continuation);
        this.Y2 = sequence;
        this.Z2 = random;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        SequenceScope sequenceScope;
        List<T> list;
        Object l2 = IntrinsicsKt.l();
        int i2 = this.Z;
        if (i2 == 0) {
            ResultKt.n(obj);
            list = SequencesKt___SequencesKt.d3(this.Y2);
            sequenceScope = (SequenceScope) this.X2;
        } else if (i2 == 1) {
            list = (List) this.Y;
            sequenceScope = (SequenceScope) this.X2;
            ResultKt.n(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (!list.isEmpty()) {
            int m2 = this.Z2.m(list.size());
            T L0 = CollectionsKt.L0(list);
            if (m2 < list.size()) {
                L0 = list.set(m2, L0);
            }
            this.X2 = sequenceScope;
            this.Y = list;
            this.Z = 1;
            if (sequenceScope.a(L0, this) == l2) {
                return l2;
            }
        }
        return Unit.f28779a;
    }

    @Nullable
    /* renamed from: J */
    public final Object d0(@NotNull SequenceScope<? super T> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SequencesKt__SequencesKt$shuffled$1) v(sequenceScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SequencesKt__SequencesKt$shuffled$1 sequencesKt__SequencesKt$shuffled$1 = new SequencesKt__SequencesKt$shuffled$1(this.Y2, this.Z2, continuation);
        sequencesKt__SequencesKt$shuffled$1.X2 = obj;
        return sequencesKt__SequencesKt$shuffled$1;
    }
}
