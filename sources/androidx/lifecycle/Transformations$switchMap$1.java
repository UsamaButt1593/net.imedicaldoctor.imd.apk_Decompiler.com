package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R*\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"androidx/lifecycle/Transformations$switchMap$1", "Landroidx/lifecycle/Observer;", "value", "", "b", "(Ljava/lang/Object;)V", "Landroidx/lifecycle/LiveData;", "a", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "c", "(Landroidx/lifecycle/LiveData;)V", "liveData", "lifecycle-livedata_release"}, k = 1, mv = {1, 8, 0})
public final class Transformations$switchMap$1 implements Observer<X> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private LiveData<Y> f8599a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Function1<X, LiveData<Y>> f8600b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ MediatorLiveData<Y> f8601c;

    Transformations$switchMap$1(Function1<X, LiveData<Y>> function1, MediatorLiveData<Y> mediatorLiveData) {
        this.f8600b = function1;
        this.f8601c = mediatorLiveData;
    }

    @Nullable
    public final LiveData<Y> a() {
        return this.f8599a;
    }

    public void b(X x) {
        LiveData<Y> f2 = this.f8600b.f(x);
        LiveData<Y> liveData = this.f8599a;
        if (liveData != f2) {
            if (liveData != null) {
                MediatorLiveData<Y> mediatorLiveData = this.f8601c;
                Intrinsics.m(liveData);
                mediatorLiveData.t(liveData);
            }
            this.f8599a = f2;
            if (f2 != null) {
                MediatorLiveData<Y> mediatorLiveData2 = this.f8601c;
                Intrinsics.m(f2);
                mediatorLiveData2.s(f2, new Transformations$sam$androidx_lifecycle_Observer$0(new Transformations$switchMap$1$onChanged$1(this.f8601c)));
            }
        }
    }

    public final void c(@Nullable LiveData<Y> liveData) {
        this.f8599a = liveData;
    }
}
