package androidx.lifecycle;

import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;

public class MediatorLiveData<T> extends MutableLiveData<T> {

    /* renamed from: m  reason: collision with root package name */
    private SafeIterableMap<LiveData<?>, Source<?>> f8560m = new SafeIterableMap<>();

    private static class Source<V> implements Observer<V> {

        /* renamed from: a  reason: collision with root package name */
        final LiveData<V> f8561a;

        /* renamed from: b  reason: collision with root package name */
        final Observer<? super V> f8562b;

        /* renamed from: c  reason: collision with root package name */
        int f8563c = -1;

        Source(LiveData<V> liveData, Observer<? super V> observer) {
            this.f8561a = liveData;
            this.f8562b = observer;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f8561a.l(this);
        }

        public void b(@Nullable V v) {
            if (this.f8563c != this.f8561a.g()) {
                this.f8563c = this.f8561a.g();
                this.f8562b.b(v);
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f8561a.p(this);
        }
    }

    public MediatorLiveData() {
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void m() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> it2 = this.f8560m.iterator();
        while (it2.hasNext()) {
            ((Source) it2.next().getValue()).a();
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void n() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> it2 = this.f8560m.iterator();
        while (it2.hasNext()) {
            ((Source) it2.next().getValue()).c();
        }
    }

    @MainThread
    public <S> void s(@NonNull LiveData<S> liveData, @NonNull Observer<? super S> observer) {
        if (liveData != null) {
            Source source = new Source(liveData, observer);
            Source j2 = this.f8560m.j(liveData, source);
            if (j2 != null && j2.f8562b != observer) {
                throw new IllegalArgumentException("This source was already added with the different observer");
            } else if (j2 == null && h()) {
                source.a();
            }
        } else {
            throw new NullPointerException("source cannot be null");
        }
    }

    @MainThread
    public <S> void t(@NonNull LiveData<S> liveData) {
        Source k2 = this.f8560m.k(liveData);
        if (k2 != null) {
            k2.c();
        }
    }

    public MediatorLiveData(T t) {
        super(t);
    }
}
