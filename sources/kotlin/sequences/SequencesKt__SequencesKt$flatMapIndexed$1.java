package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H@"}, d2 = {"<anonymous>", "", "T", "C", "R", "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", f = "Sequences.kt", i = {0, 0}, l = {332}, m = "invokeSuspend", n = {"$this$sequence", "index"}, s = {"L$0", "I$0"})
final class SequencesKt__SequencesKt$flatMapIndexed$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
    int X2;
    Object Y;
    private /* synthetic */ Object Y2;
    int Z;
    final /* synthetic */ Sequence<T> Z2;
    final /* synthetic */ Function2<Integer, T, C> a3;
    final /* synthetic */ Function1<C, Iterator<R>> b3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt__SequencesKt$flatMapIndexed$1(Sequence<? extends T> sequence, Function2<? super Integer, ? super T, ? extends C> function2, Function1<? super C, ? extends Iterator<? extends R>> function1, Continuation<? super SequencesKt__SequencesKt$flatMapIndexed$1> continuation) {
        super(2, continuation);
        this.Z2 = sequence;
        this.a3 = function2;
        this.b3 = function1;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        int i2;
        SequenceScope sequenceScope;
        Iterator<T> it2;
        Object l2 = IntrinsicsKt.l();
        int i3 = this.X2;
        if (i3 == 0) {
            ResultKt.n(obj);
            sequenceScope = (SequenceScope) this.Y2;
            it2 = this.Z2.iterator();
            i2 = 0;
        } else if (i3 == 1) {
            int i4 = this.Z;
            it2 = (Iterator) this.Y;
            sequenceScope = (SequenceScope) this.Y2;
            ResultKt.n(obj);
            i2 = i4;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (it2.hasNext()) {
            T next = it2.next();
            Function2<Integer, T, C> function2 = this.a3;
            int i5 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.W();
            }
            C d0 = function2.d0(Boxing.f(i2), next);
            this.Y2 = sequenceScope;
            this.Y = it2;
            this.Z = i5;
            this.X2 = 1;
            if (sequenceScope.e(this.b3.f(d0), this) == l2) {
                return l2;
            }
            i2 = i5;
        }
        return Unit.f28779a;
    }

    @Nullable
    /* renamed from: J */
    public final Object d0(@NotNull SequenceScope<? super R> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SequencesKt__SequencesKt$flatMapIndexed$1) v(sequenceScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SequencesKt__SequencesKt$flatMapIndexed$1 sequencesKt__SequencesKt$flatMapIndexed$1 = new SequencesKt__SequencesKt$flatMapIndexed$1(this.Z2, this.a3, this.b3, continuation);
        sequencesKt__SequencesKt$flatMapIndexed$1.Y2 = obj;
        return sequencesKt__SequencesKt$flatMapIndexed$1;
    }
}
