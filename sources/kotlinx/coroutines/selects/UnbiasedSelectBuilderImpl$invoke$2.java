package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001 \u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Q", "R", "", "b", "()V"}, k = 3, mv = {1, 6, 0})
final class UnbiasedSelectBuilderImpl$invoke$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SelectClause1<Q> X;
    final /* synthetic */ UnbiasedSelectBuilderImpl<R> Y;
    final /* synthetic */ Function2<Q, Continuation<? super R>, Object> Z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UnbiasedSelectBuilderImpl$invoke$2(SelectClause1<? extends Q> selectClause1, UnbiasedSelectBuilderImpl<? super R> unbiasedSelectBuilderImpl, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        super(0);
        this.X = selectClause1;
        this.Y = unbiasedSelectBuilderImpl;
        this.Z = function2;
    }

    public final void b() {
        this.X.h(this.Y.b(), this.Z);
    }

    public /* bridge */ /* synthetic */ Object o() {
        b();
        return Unit.f28779a;
    }
}
