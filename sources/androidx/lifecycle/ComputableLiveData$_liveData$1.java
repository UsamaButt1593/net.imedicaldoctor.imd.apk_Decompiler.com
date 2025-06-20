package androidx.lifecycle;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"androidx/lifecycle/ComputableLiveData$_liveData$1", "Landroidx/lifecycle/LiveData;", "", "m", "()V", "lifecycle-livedata_release"}, k = 1, mv = {1, 8, 0})
public final class ComputableLiveData$_liveData$1 extends LiveData<T> {

    /* renamed from: m  reason: collision with root package name */
    final /* synthetic */ ComputableLiveData<T> f8515m;

    ComputableLiveData$_liveData$1(ComputableLiveData<T> computableLiveData) {
        this.f8515m = computableLiveData;
    }

    /* access modifiers changed from: protected */
    public void m() {
        this.f8515m.e().execute(this.f8515m.f8513f);
    }
}
