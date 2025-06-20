package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.util.DebugUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.l;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class LoaderManagerImpl extends LoaderManager {

    /* renamed from: c  reason: collision with root package name */
    static final String f8805c = "LoaderManager";

    /* renamed from: d  reason: collision with root package name */
    static boolean f8806d = false;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LifecycleOwner f8807a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final LoaderViewModel f8808b;

    public static class LoaderInfo<D> extends MutableLiveData<D> implements Loader.OnLoadCompleteListener<D> {

        /* renamed from: m  reason: collision with root package name */
        private final int f8809m;
        @Nullable

        /* renamed from: n  reason: collision with root package name */
        private final Bundle f8810n;
        @NonNull
        private final Loader<D> o;
        private LifecycleOwner p;
        private LoaderObserver<D> q;
        private Loader<D> r;

        LoaderInfo(int i2, @Nullable Bundle bundle, @NonNull Loader<D> loader, @Nullable Loader<D> loader2) {
            this.f8809m = i2;
            this.f8810n = bundle;
            this.o = loader;
            this.r = loader2;
            loader.u(i2, this);
        }

        public void a(@NonNull Loader<D> loader, @Nullable D d2) {
            if (LoaderManagerImpl.f8806d) {
                Log.v(LoaderManagerImpl.f8805c, "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                r(d2);
                return;
            }
            if (LoaderManagerImpl.f8806d) {
                Log.w(LoaderManagerImpl.f8805c, "onLoadComplete was incorrectly called on a background thread");
            }
            o(d2);
        }

        /* access modifiers changed from: protected */
        public void m() {
            if (LoaderManagerImpl.f8806d) {
                Log.v(LoaderManagerImpl.f8805c, "  Starting: " + this);
            }
            this.o.y();
        }

        /* access modifiers changed from: protected */
        public void n() {
            if (LoaderManagerImpl.f8806d) {
                Log.v(LoaderManagerImpl.f8805c, "  Stopping: " + this);
            }
            this.o.z();
        }

        public void p(@NonNull Observer<? super D> observer) {
            super.p(observer);
            this.p = null;
            this.q = null;
        }

        public void r(D d2) {
            super.r(d2);
            Loader<D> loader = this.r;
            if (loader != null) {
                loader.w();
                this.r = null;
            }
        }

        /* access modifiers changed from: package-private */
        @MainThread
        public Loader<D> s(boolean z) {
            if (LoaderManagerImpl.f8806d) {
                Log.v(LoaderManagerImpl.f8805c, "  Destroying: " + this);
            }
            this.o.b();
            this.o.a();
            LoaderObserver<D> loaderObserver = this.q;
            if (loaderObserver != null) {
                p(loaderObserver);
                if (z) {
                    loaderObserver.d();
                }
            }
            this.o.B(this);
            if ((loaderObserver == null || loaderObserver.c()) && !z) {
                return this.o;
            }
            this.o.w();
            return this.r;
        }

        public void t(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f8809m);
            printWriter.print(" mArgs=");
            printWriter.println(this.f8810n);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.o);
            Loader<D> loader = this.o;
            loader.g(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.q != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.q);
                LoaderObserver<D> loaderObserver = this.q;
                loaderObserver.a(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(u().d(f()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(h());
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f8809m);
            sb.append(" : ");
            DebugUtils.a(this.o, sb);
            sb.append("}}");
            return sb.toString();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Loader<D> u() {
            return this.o;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
            r0 = r2.q;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean v() {
            /*
                r2 = this;
                boolean r0 = r2.h()
                r1 = 0
                if (r0 != 0) goto L_0x0008
                return r1
            L_0x0008:
                androidx.loader.app.LoaderManagerImpl$LoaderObserver<D> r0 = r2.q
                if (r0 == 0) goto L_0x0013
                boolean r0 = r0.c()
                if (r0 != 0) goto L_0x0013
                r1 = 1
            L_0x0013:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.loader.app.LoaderManagerImpl.LoaderInfo.v():boolean");
        }

        /* access modifiers changed from: package-private */
        public void w() {
            LifecycleOwner lifecycleOwner = this.p;
            LoaderObserver<D> loaderObserver = this.q;
            if (lifecycleOwner != null && loaderObserver != null) {
                super.p(loaderObserver);
                k(lifecycleOwner, loaderObserver);
            }
        }

        /* access modifiers changed from: package-private */
        @MainThread
        @NonNull
        public Loader<D> x(@NonNull LifecycleOwner lifecycleOwner, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            LoaderObserver<D> loaderObserver = new LoaderObserver<>(this.o, loaderCallbacks);
            k(lifecycleOwner, loaderObserver);
            LoaderObserver<D> loaderObserver2 = this.q;
            if (loaderObserver2 != null) {
                p(loaderObserver2);
            }
            this.p = lifecycleOwner;
            this.q = loaderObserver;
            return this.o;
        }
    }

    static class LoaderObserver<D> implements Observer<D> {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final Loader<D> f8811a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final LoaderManager.LoaderCallbacks<D> f8812b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f8813c = false;

        LoaderObserver(@NonNull Loader<D> loader, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
            this.f8811a = loader;
            this.f8812b = loaderCallbacks;
        }

        public void a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f8813c);
        }

        public void b(@Nullable D d2) {
            if (LoaderManagerImpl.f8806d) {
                Log.v(LoaderManagerImpl.f8805c, "  onLoadFinished in " + this.f8811a + ": " + this.f8811a.d(d2));
            }
            this.f8812b.a(this.f8811a, d2);
            this.f8813c = true;
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            return this.f8813c;
        }

        /* access modifiers changed from: package-private */
        @MainThread
        public void d() {
            if (this.f8813c) {
                if (LoaderManagerImpl.f8806d) {
                    Log.v(LoaderManagerImpl.f8805c, "  Resetting: " + this.f8811a);
                }
                this.f8812b.c(this.f8811a);
            }
        }

        public String toString() {
            return this.f8812b.toString();
        }
    }

    static class LoaderViewModel extends ViewModel {

        /* renamed from: f  reason: collision with root package name */
        private static final ViewModelProvider.Factory f8814f = new ViewModelProvider.Factory() {
            @NonNull
            public <T extends ViewModel> T a(@NonNull Class<T> cls) {
                return new LoaderViewModel();
            }

            public /* synthetic */ ViewModel b(Class cls, CreationExtras creationExtras) {
                return l.b(this, cls, creationExtras);
            }
        };

        /* renamed from: d  reason: collision with root package name */
        private SparseArrayCompat<LoaderInfo> f8815d = new SparseArrayCompat<>();

        /* renamed from: e  reason: collision with root package name */
        private boolean f8816e = false;

        LoaderViewModel() {
        }

        @NonNull
        static LoaderViewModel i(ViewModelStore viewModelStore) {
            return (LoaderViewModel) new ViewModelProvider(viewModelStore, f8814f).a(LoaderViewModel.class);
        }

        /* access modifiers changed from: protected */
        public void e() {
            super.e();
            int z = this.f8815d.z();
            for (int i2 = 0; i2 < z; i2++) {
                this.f8815d.A(i2).s(true);
            }
            this.f8815d.b();
        }

        public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f8815d.z() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i2 = 0; i2 < this.f8815d.z(); i2++) {
                    LoaderInfo A = this.f8815d.A(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f8815d.o(i2));
                    printWriter.print(": ");
                    printWriter.println(A.toString());
                    A.t(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void h() {
            this.f8816e = false;
        }

        /* access modifiers changed from: package-private */
        public <D> LoaderInfo<D> j(int i2) {
            return this.f8815d.h(i2);
        }

        /* access modifiers changed from: package-private */
        public boolean k() {
            int z = this.f8815d.z();
            for (int i2 = 0; i2 < z; i2++) {
                if (this.f8815d.A(i2).v()) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean l() {
            return this.f8816e;
        }

        /* access modifiers changed from: package-private */
        public void m() {
            int z = this.f8815d.z();
            for (int i2 = 0; i2 < z; i2++) {
                this.f8815d.A(i2).w();
            }
        }

        /* access modifiers changed from: package-private */
        public void n(int i2, @NonNull LoaderInfo loaderInfo) {
            this.f8815d.p(i2, loaderInfo);
        }

        /* access modifiers changed from: package-private */
        public void o(int i2) {
            this.f8815d.s(i2);
        }

        /* access modifiers changed from: package-private */
        public void p() {
            this.f8816e = true;
        }
    }

    LoaderManagerImpl(@NonNull LifecycleOwner lifecycleOwner, @NonNull ViewModelStore viewModelStore) {
        this.f8807a = lifecycleOwner;
        this.f8808b = LoaderViewModel.i(viewModelStore);
    }

    @MainThread
    @NonNull
    private <D> Loader<D> j(int i2, @Nullable Bundle bundle, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks, @Nullable Loader<D> loader) {
        try {
            this.f8808b.p();
            Loader<D> b2 = loaderCallbacks.b(i2, bundle);
            if (b2 != null) {
                if (b2.getClass().isMemberClass()) {
                    if (!Modifier.isStatic(b2.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + b2);
                    }
                }
                LoaderInfo loaderInfo = new LoaderInfo(i2, bundle, b2, loader);
                if (f8806d) {
                    Log.v(f8805c, "  Created new loader " + loaderInfo);
                }
                this.f8808b.n(i2, loaderInfo);
                this.f8808b.h();
                return loaderInfo.x(this.f8807a, loaderCallbacks);
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        } catch (Throwable th) {
            this.f8808b.h();
            throw th;
        }
    }

    @MainThread
    public void a(int i2) {
        if (this.f8808b.l()) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            if (f8806d) {
                Log.v(f8805c, "destroyLoader in " + this + " of " + i2);
            }
            LoaderInfo j2 = this.f8808b.j(i2);
            if (j2 != null) {
                j2.s(true);
                this.f8808b.o(i2);
            }
        } else {
            throw new IllegalStateException("destroyLoader must be called on the main thread");
        }
    }

    @Deprecated
    public void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f8808b.g(str, fileDescriptor, printWriter, strArr);
    }

    @Nullable
    public <D> Loader<D> e(int i2) {
        if (!this.f8808b.l()) {
            LoaderInfo j2 = this.f8808b.j(i2);
            if (j2 != null) {
                return j2.u();
            }
            return null;
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    public boolean f() {
        return this.f8808b.k();
    }

    @MainThread
    @NonNull
    public <D> Loader<D> g(int i2, @Nullable Bundle bundle, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (this.f8808b.l()) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            LoaderInfo j2 = this.f8808b.j(i2);
            if (f8806d) {
                Log.v(f8805c, "initLoader in " + this + ": args=" + bundle);
            }
            if (j2 == null) {
                return j(i2, bundle, loaderCallbacks, (Loader) null);
            }
            if (f8806d) {
                Log.v(f8805c, "  Re-using existing loader " + j2);
            }
            return j2.x(this.f8807a, loaderCallbacks);
        } else {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
    }

    public void h() {
        this.f8808b.m();
    }

    @MainThread
    @NonNull
    public <D> Loader<D> i(int i2, @Nullable Bundle bundle, @NonNull LoaderManager.LoaderCallbacks<D> loaderCallbacks) {
        if (this.f8808b.l()) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            if (f8806d) {
                Log.v(f8805c, "restartLoader in " + this + ": args=" + bundle);
            }
            LoaderInfo j2 = this.f8808b.j(i2);
            return j(i2, bundle, loaderCallbacks, j2 != null ? j2.s(false) : null);
        } else {
            throw new IllegalStateException("restartLoader must be called on the main thread");
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.a(this.f8807a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
