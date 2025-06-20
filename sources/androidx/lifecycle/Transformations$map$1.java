package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"X", "Y", "kotlin.jvm.PlatformType", "x", "", "b", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 8, 0})
final class Transformations$map$1 extends Lambda implements Function1<X, Unit> {
    final /* synthetic */ MediatorLiveData<Y> X;
    final /* synthetic */ Function1<X, Y> Y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Transformations$map$1(MediatorLiveData<Y> mediatorLiveData, Function1<X, Y> function1) {
        super(1);
        this.X = mediatorLiveData;
        this.Y = function1;
    }

    public final void b(X x) {
        this.X.r(this.Y.f(x));
    }

    public /* bridge */ /* synthetic */ Object f(Object obj) {
        b(obj);
        return Unit.f28779a;
    }
}
