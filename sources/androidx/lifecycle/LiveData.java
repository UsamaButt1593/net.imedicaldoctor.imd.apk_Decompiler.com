package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import java.util.Iterator;
import java.util.Map;

public abstract class LiveData<T> {

    /* renamed from: k  reason: collision with root package name */
    static final int f8548k = -1;

    /* renamed from: l  reason: collision with root package name */
    static final Object f8549l = new Object();

    /* renamed from: a  reason: collision with root package name */
    final Object f8550a;

    /* renamed from: b  reason: collision with root package name */
    private SafeIterableMap<Observer<? super T>, LiveData<T>.ObserverWrapper> f8551b;

    /* renamed from: c  reason: collision with root package name */
    int f8552c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8553d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Object f8554e;

    /* renamed from: f  reason: collision with root package name */
    volatile Object f8555f;

    /* renamed from: g  reason: collision with root package name */
    private int f8556g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f8557h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f8558i;

    /* renamed from: j  reason: collision with root package name */
    private final Runnable f8559j;

    private class AlwaysActiveObserver extends LiveData<T>.ObserverWrapper {
        AlwaysActiveObserver(Observer<? super T> observer) {
            super(observer);
        }

        /* access modifiers changed from: package-private */
        public boolean k() {
            return true;
        }
    }

    class LifecycleBoundObserver extends LiveData<T>.ObserverWrapper implements LifecycleEventObserver {
        @NonNull
        final LifecycleOwner X2;

        LifecycleBoundObserver(@NonNull LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
            super(observer);
            this.X2 = lifecycleOwner;
        }

        public void d(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
            Lifecycle.State b2 = this.X2.a().b();
            if (b2 == Lifecycle.State.DESTROYED) {
                LiveData.this.p(this.s);
                return;
            }
            Lifecycle.State state = null;
            while (state != b2) {
                a(k());
                state = b2;
                b2 = this.X2.a().b();
            }
        }

        /* access modifiers changed from: package-private */
        public void h() {
            this.X2.a().d(this);
        }

        /* access modifiers changed from: package-private */
        public boolean i(LifecycleOwner lifecycleOwner) {
            return this.X2 == lifecycleOwner;
        }

        /* access modifiers changed from: package-private */
        public boolean k() {
            return this.X2.a().b().b(Lifecycle.State.STARTED);
        }
    }

    private abstract class ObserverWrapper {
        boolean X;
        int Y = -1;
        final Observer<? super T> s;

        ObserverWrapper(Observer<? super T> observer) {
            this.s = observer;
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z) {
            if (z != this.X) {
                this.X = z;
                LiveData.this.c(z ? 1 : -1);
                if (this.X) {
                    LiveData.this.e(this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void h() {
        }

        /* access modifiers changed from: package-private */
        public boolean i(LifecycleOwner lifecycleOwner) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public abstract boolean k();
    }

    public LiveData() {
        this.f8550a = new Object();
        this.f8551b = new SafeIterableMap<>();
        this.f8552c = 0;
        Object obj = f8549l;
        this.f8555f = obj;
        this.f8559j = new Runnable() {
            public void run() {
                Object obj;
                synchronized (LiveData.this.f8550a) {
                    obj = LiveData.this.f8555f;
                    LiveData.this.f8555f = LiveData.f8549l;
                }
                LiveData.this.r(obj);
            }
        };
        this.f8554e = obj;
        this.f8556g = -1;
    }

    static void b(String str) {
        if (!ArchTaskExecutor.h().c()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
        }
    }

    private void d(LiveData<T>.ObserverWrapper observerWrapper) {
        if (observerWrapper.X) {
            if (!observerWrapper.k()) {
                observerWrapper.a(false);
                return;
            }
            int i2 = observerWrapper.Y;
            int i3 = this.f8556g;
            if (i2 < i3) {
                observerWrapper.Y = i3;
                observerWrapper.s.b(this.f8554e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @MainThread
    public void c(int i2) {
        int i3 = this.f8552c;
        this.f8552c = i2 + i3;
        if (!this.f8553d) {
            this.f8553d = true;
            while (true) {
                try {
                    int i4 = this.f8552c;
                    if (i3 != i4) {
                        boolean z = i3 == 0 && i4 > 0;
                        boolean z2 = i3 > 0 && i4 == 0;
                        if (z) {
                            m();
                        } else if (z2) {
                            n();
                        }
                        i3 = i4;
                    } else {
                        this.f8553d = false;
                        return;
                    }
                } catch (Throwable th) {
                    this.f8553d = false;
                    throw th;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e(@Nullable LiveData<T>.ObserverWrapper observerWrapper) {
        if (this.f8557h) {
            this.f8558i = true;
            return;
        }
        this.f8557h = true;
        do {
            this.f8558i = false;
            if (observerWrapper == null) {
                SafeIterableMap<K, V>.IteratorWithAdditions d2 = this.f8551b.d();
                while (d2.hasNext()) {
                    d((ObserverWrapper) ((Map.Entry) d2.next()).getValue());
                    if (this.f8558i) {
                        break;
                    }
                }
            } else {
                d(observerWrapper);
                observerWrapper = null;
            }
        } while (this.f8558i);
        this.f8557h = false;
    }

    @Nullable
    public T f() {
        T t = this.f8554e;
        if (t != f8549l) {
            return t;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.f8556g;
    }

    public boolean h() {
        return this.f8552c > 0;
    }

    public boolean i() {
        return this.f8551b.size() > 0;
    }

    public boolean j() {
        return this.f8554e != f8549l;
    }

    @MainThread
    public void k(@NonNull LifecycleOwner lifecycleOwner, @NonNull Observer<? super T> observer) {
        b("observe");
        if (lifecycleOwner.a().b() != Lifecycle.State.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(lifecycleOwner, observer);
            ObserverWrapper j2 = this.f8551b.j(observer, lifecycleBoundObserver);
            if (j2 != null && !j2.i(lifecycleOwner)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (j2 == null) {
                lifecycleOwner.a().a(lifecycleBoundObserver);
            }
        }
    }

    @MainThread
    public void l(@NonNull Observer<? super T> observer) {
        b("observeForever");
        AlwaysActiveObserver alwaysActiveObserver = new AlwaysActiveObserver(observer);
        ObserverWrapper j2 = this.f8551b.j(observer, alwaysActiveObserver);
        if (j2 instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        } else if (j2 == null) {
            alwaysActiveObserver.a(true);
        }
    }

    /* access modifiers changed from: protected */
    public void m() {
    }

    /* access modifiers changed from: protected */
    public void n() {
    }

    /* access modifiers changed from: protected */
    public void o(T t) {
        boolean z;
        synchronized (this.f8550a) {
            z = this.f8555f == f8549l;
            this.f8555f = t;
        }
        if (z) {
            ArchTaskExecutor.h().d(this.f8559j);
        }
    }

    @MainThread
    public void p(@NonNull Observer<? super T> observer) {
        b("removeObserver");
        ObserverWrapper k2 = this.f8551b.k(observer);
        if (k2 != null) {
            k2.h();
            k2.a(false);
        }
    }

    @MainThread
    public void q(@NonNull LifecycleOwner lifecycleOwner) {
        b("removeObservers");
        Iterator<Map.Entry<Observer<? super T>, LiveData<T>.ObserverWrapper>> it2 = this.f8551b.iterator();
        while (it2.hasNext()) {
            Map.Entry next = it2.next();
            if (((ObserverWrapper) next.getValue()).i(lifecycleOwner)) {
                p((Observer) next.getKey());
            }
        }
    }

    /* access modifiers changed from: protected */
    @MainThread
    public void r(T t) {
        b("setValue");
        this.f8556g++;
        this.f8554e = t;
        e((LiveData<T>.ObserverWrapper) null);
    }

    public LiveData(T t) {
        this.f8550a = new Object();
        this.f8551b = new SafeIterableMap<>();
        this.f8552c = 0;
        this.f8555f = f8549l;
        this.f8559j = new Runnable() {
            public void run() {
                Object obj;
                synchronized (LiveData.this.f8550a) {
                    obj = LiveData.this.f8555f;
                    LiveData.this.f8555f = LiveData.f8549l;
                }
                LiveData.this.r(obj);
            }
        };
        this.f8554e = t;
        this.f8556g = 0;
    }
}
