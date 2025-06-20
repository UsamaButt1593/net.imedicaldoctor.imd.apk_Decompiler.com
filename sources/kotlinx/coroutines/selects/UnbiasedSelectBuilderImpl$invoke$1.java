package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0000 \u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"R", "", "b", "()V"}, k = 3, mv = {1, 6, 0})
final class UnbiasedSelectBuilderImpl$invoke$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SelectClause0 X;
    final /* synthetic */ UnbiasedSelectBuilderImpl<R> Y;
    final /* synthetic */ Function1<Continuation<? super R>, Object> Z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UnbiasedSelectBuilderImpl$invoke$1(SelectClause0 selectClause0, UnbiasedSelectBuilderImpl<? super R> unbiasedSelectBuilderImpl, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        super(0);
        this.X = selectClause0;
        this.Y = unbiasedSelectBuilderImpl;
        this.Z = function1;
    }

    public final void b() {
        this.X.C(this.Y.b(), this.Z);
    }

    public /* bridge */ /* synthetic */ Object o() {
        b();
        return Unit.f28779a;
    }
}
