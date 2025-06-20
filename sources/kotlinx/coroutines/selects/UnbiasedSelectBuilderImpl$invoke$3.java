package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0006\b\u0002\u0010\u0002 \u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"P", "Q", "R", "", "b", "()V"}, k = 3, mv = {1, 6, 0})
final class UnbiasedSelectBuilderImpl$invoke$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SelectClause2<P, Q> X;
    final /* synthetic */ Function2<Q, Continuation<? super R>, Object> X2;
    final /* synthetic */ UnbiasedSelectBuilderImpl<R> Y;
    final /* synthetic */ P Z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UnbiasedSelectBuilderImpl$invoke$3(SelectClause2<? super P, ? extends Q> selectClause2, UnbiasedSelectBuilderImpl<? super R> unbiasedSelectBuilderImpl, P p, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        super(0);
        this.X = selectClause2;
        this.Y = unbiasedSelectBuilderImpl;
        this.Z = p;
        this.X2 = function2;
    }

    public final void b() {
        this.X.b0(this.Y.b(), this.Z, this.X2);
    }

    public /* bridge */ /* synthetic */ Object o() {
        b();
        return Unit.f28779a;
    }
}
