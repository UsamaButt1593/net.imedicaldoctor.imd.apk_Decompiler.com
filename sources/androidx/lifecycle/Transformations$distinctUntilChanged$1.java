package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"X", "kotlin.jvm.PlatformType", "value", "", "b", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 8, 0})
final class Transformations$distinctUntilChanged$1 extends Lambda implements Function1<X, Unit> {
    final /* synthetic */ MediatorLiveData<X> X;
    final /* synthetic */ Ref.BooleanRef Y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Transformations$distinctUntilChanged$1(MediatorLiveData<X> mediatorLiveData, Ref.BooleanRef booleanRef) {
        super(1);
        this.X = mediatorLiveData;
        this.Y = booleanRef;
    }

    public final void b(X x) {
        X f2 = this.X.f();
        if (this.Y.s || ((f2 == null && x != null) || (f2 != null && !Intrinsics.g(f2, x)))) {
            this.Y.s = false;
            this.X.r(x);
        }
    }

    public /* bridge */ /* synthetic */ Object f(Object obj) {
        b(obj);
        return Unit.f28779a;
    }
}
