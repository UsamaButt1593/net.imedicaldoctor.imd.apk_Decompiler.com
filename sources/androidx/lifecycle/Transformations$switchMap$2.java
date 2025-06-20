package androidx.lifecycle;

import androidx.arch.core.util.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R*\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"androidx/lifecycle/Transformations$switchMap$2", "Landroidx/lifecycle/Observer;", "value", "", "b", "(Ljava/lang/Object;)V", "Landroidx/lifecycle/LiveData;", "a", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "c", "(Landroidx/lifecycle/LiveData;)V", "liveData", "lifecycle-livedata_release"}, k = 1, mv = {1, 8, 0})
public final class Transformations$switchMap$2 implements Observer<Object> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private LiveData<Object> f8602a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Function<Object, LiveData<Object>> f8603b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ MediatorLiveData<Object> f8604c;

    Transformations$switchMap$2(Function<Object, LiveData<Object>> function, MediatorLiveData<Object> mediatorLiveData) {
        this.f8603b = function;
        this.f8604c = mediatorLiveData;
    }

    @Nullable
    public final LiveData<Object> a() {
        return this.f8602a;
    }

    public void b(Object obj) {
        LiveData<Object> apply = this.f8603b.apply(obj);
        LiveData<Object> liveData = this.f8602a;
        if (liveData != apply) {
            if (liveData != null) {
                MediatorLiveData<Object> mediatorLiveData = this.f8604c;
                Intrinsics.m(liveData);
                mediatorLiveData.t(liveData);
            }
            this.f8602a = apply;
            if (apply != null) {
                MediatorLiveData<Object> mediatorLiveData2 = this.f8604c;
                Intrinsics.m(apply);
                mediatorLiveData2.s(apply, new Transformations$sam$androidx_lifecycle_Observer$0(new Transformations$switchMap$2$onChanged$1(this.f8604c)));
            }
        }
    }

    public final void c(@Nullable LiveData<Object> liveData) {
        this.f8602a = liveData;
    }
}
