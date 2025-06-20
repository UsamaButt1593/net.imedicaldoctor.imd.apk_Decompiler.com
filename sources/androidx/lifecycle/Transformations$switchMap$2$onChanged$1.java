package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00018\u00018\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"X", "Y", "kotlin.jvm.PlatformType", "y", "", "b", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 8, 0})
final class Transformations$switchMap$2$onChanged$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ MediatorLiveData<Object> X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Transformations$switchMap$2$onChanged$1(MediatorLiveData<Object> mediatorLiveData) {
        super(1);
        this.X = mediatorLiveData;
    }

    public final void b(Object obj) {
        this.X.r(obj);
    }

    public /* bridge */ /* synthetic */ Object f(Object obj) {
        b(obj);
        return Unit.f28779a;
    }
}
