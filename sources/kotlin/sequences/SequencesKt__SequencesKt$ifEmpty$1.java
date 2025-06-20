package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1", f = "Sequences.kt", i = {}, l = {69, 71}, m = "invokeSuspend", n = {}, s = {})
final class SequencesKt__SequencesKt$ifEmpty$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Sequence<T> X2;
    int Y;
    final /* synthetic */ Function0<Sequence<T>> Y2;
    private /* synthetic */ Object Z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt__SequencesKt$ifEmpty$1(Sequence<? extends T> sequence, Function0<? extends Sequence<? extends T>> function0, Continuation<? super SequencesKt__SequencesKt$ifEmpty$1> continuation) {
        super(2, continuation);
        this.X2 = sequence;
        this.Y2 = function0;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        Object l2 = IntrinsicsKt.l();
        int i2 = this.Y;
        if (i2 == 0) {
            ResultKt.n(obj);
            SequenceScope sequenceScope = (SequenceScope) this.Z;
            Iterator<T> it2 = this.X2.iterator();
            if (it2.hasNext()) {
                this.Y = 1;
                if (sequenceScope.e(it2, this) == l2) {
                    return l2;
                }
            } else {
                this.Y = 2;
                if (sequenceScope.f(this.Y2.o(), this) == l2) {
                    return l2;
                }
            }
        } else if (i2 == 1 || i2 == 2) {
            ResultKt.n(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f28779a;
    }

    @Nullable
    /* renamed from: J */
    public final Object d0(@NotNull SequenceScope<? super T> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SequencesKt__SequencesKt$ifEmpty$1) v(sequenceScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SequencesKt__SequencesKt$ifEmpty$1 sequencesKt__SequencesKt$ifEmpty$1 = new SequencesKt__SequencesKt$ifEmpty$1(this.X2, this.Y2, continuation);
        sequencesKt__SequencesKt$ifEmpty$1.Z = obj;
        return sequencesKt__SequencesKt$ifEmpty$1;
    }
}
