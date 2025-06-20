package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;

class FragmentViewLifecycleOwner implements HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, ViewModelStoreOwner {
    private final ViewModelStore X;
    private SavedStateRegistryController X2 = null;
    private ViewModelProvider.Factory Y;
    private LifecycleRegistry Z = null;
    private final Fragment s;

    FragmentViewLifecycleOwner(@NonNull Fragment fragment, @NonNull ViewModelStore viewModelStore) {
        this.s = fragment;
        this.X = viewModelStore;
    }

    @NonNull
    public SavedStateRegistry A() {
        c();
        return this.X2.b();
    }

    @NonNull
    public Lifecycle a() {
        c();
        return this.Z;
    }

    /* access modifiers changed from: package-private */
    public void b(@NonNull Lifecycle.Event event) {
        this.Z.l(event);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.Z == null) {
            this.Z = new LifecycleRegistry(this);
            SavedStateRegistryController a2 = SavedStateRegistryController.a(this);
            this.X2 = a2;
            a2.c();
            SavedStateHandleSupport.c(this);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.Z != null;
    }

    /* access modifiers changed from: package-private */
    public void f(@Nullable Bundle bundle) {
        this.X2.d(bundle);
    }

    /* access modifiers changed from: package-private */
    public void g(@NonNull Bundle bundle) {
        this.X2.e(bundle);
    }

    /* access modifiers changed from: package-private */
    public void h(@NonNull Lifecycle.State state) {
        this.Z.s(state);
    }

    @NonNull
    public ViewModelProvider.Factory n() {
        Application application;
        ViewModelProvider.Factory n2 = this.s.n();
        if (!n2.equals(this.s.O3)) {
            this.Y = n2;
            return n2;
        }
        if (this.Y == null) {
            Context applicationContext = this.s.X1().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                } else if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                } else {
                    applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
                }
            }
            this.Y = new SavedStateViewModelFactory(application, this, this.s.y());
        }
        return this.Y;
    }

    @CallSuper
    @NonNull
    public CreationExtras o() {
        Application application;
        Context applicationContext = this.s.X1().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            } else if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            } else {
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
        }
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras();
        if (application != null) {
            mutableCreationExtras.c(ViewModelProvider.AndroidViewModelFactory.f8614i, application);
        }
        mutableCreationExtras.c(SavedStateHandleSupport.f8580c, this);
        mutableCreationExtras.c(SavedStateHandleSupport.f8581d, this);
        if (this.s.y() != null) {
            mutableCreationExtras.c(SavedStateHandleSupport.f8582e, this.s.y());
        }
        return mutableCreationExtras;
    }

    @NonNull
    public ViewModelStore w() {
        c();
        return this.X;
    }
}
