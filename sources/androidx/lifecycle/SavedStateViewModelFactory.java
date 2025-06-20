package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0003\u0010\tB%\b\u0017\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0003\u0010\fJ/\u0010\u0013\u001a\u00028\u0000\"\b\b\u0000\u0010\u000e*\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u0017\u001a\u00028\u0000\"\b\b\u0000\u0010\u000e*\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0019\u001a\u00028\u0000\"\b\b\u0000\u0010\u000e*\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\rH\u0017¢\u0006\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u001fR\u0014\u0010!\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010 R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006+"}, d2 = {"Landroidx/lifecycle/SavedStateViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$OnRequeryFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "()V", "Landroid/app/Application;", "application", "Landroidx/savedstate/SavedStateRegistryOwner;", "owner", "(Landroid/app/Application;Landroidx/savedstate/SavedStateRegistryOwner;)V", "Landroid/os/Bundle;", "defaultArgs", "(Landroid/app/Application;Landroidx/savedstate/SavedStateRegistryOwner;Landroid/os/Bundle;)V", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "Landroidx/lifecycle/viewmodel/CreationExtras;", "extras", "b", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "", "key", "d", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "a", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "viewModel", "", "c", "(Landroidx/lifecycle/ViewModel;)V", "Landroid/app/Application;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factory", "Landroid/os/Bundle;", "Landroidx/lifecycle/Lifecycle;", "e", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Landroidx/savedstate/SavedStateRegistry;", "f", "Landroidx/savedstate/SavedStateRegistry;", "savedStateRegistry", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0})
public final class SavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private Application f8588b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final ViewModelProvider.Factory f8589c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Bundle f8590d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private Lifecycle f8591e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private SavedStateRegistry f8592f;

    public SavedStateViewModelFactory() {
        this.f8589c = new ViewModelProvider.AndroidViewModelFactory();
    }

    @NotNull
    public <T extends ViewModel> T a(@NotNull Class<T> cls) {
        Intrinsics.p(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return d(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @NotNull
    public <T extends ViewModel> T b(@NotNull Class<T> cls, @NotNull CreationExtras creationExtras) {
        Intrinsics.p(cls, "modelClass");
        Intrinsics.p(creationExtras, "extras");
        String str = (String) creationExtras.a(ViewModelProvider.NewInstanceFactory.f8621d);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        } else if (creationExtras.a(SavedStateHandleSupport.f8580c) != null && creationExtras.a(SavedStateHandleSupport.f8581d) != null) {
            Application application = (Application) creationExtras.a(ViewModelProvider.AndroidViewModelFactory.f8614i);
            boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
            Constructor<T> c2 = SavedStateViewModelFactoryKt.c(cls, (!isAssignableFrom || application == null) ? SavedStateViewModelFactoryKt.f8594b : SavedStateViewModelFactoryKt.f8593a);
            if (c2 == null) {
                return this.f8589c.b(cls, creationExtras);
            }
            if (!isAssignableFrom || application == null) {
                return SavedStateViewModelFactoryKt.d(cls, c2, SavedStateHandleSupport.a(creationExtras));
            }
            return SavedStateViewModelFactoryKt.d(cls, c2, application, SavedStateHandleSupport.a(creationExtras));
        } else if (this.f8591e != null) {
            return d(str, cls);
        } else {
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void c(@NotNull ViewModel viewModel) {
        Intrinsics.p(viewModel, "viewModel");
        if (this.f8591e != null) {
            SavedStateRegistry savedStateRegistry = this.f8592f;
            Intrinsics.m(savedStateRegistry);
            Lifecycle lifecycle = this.f8591e;
            Intrinsics.m(lifecycle);
            LegacySavedStateHandleController.a(viewModel, savedStateRegistry, lifecycle);
        }
    }

    @NotNull
    public final <T extends ViewModel> T d(@NotNull String str, @NotNull Class<T> cls) {
        T t;
        Application application;
        Intrinsics.p(str, "key");
        Intrinsics.p(cls, "modelClass");
        Lifecycle lifecycle = this.f8591e;
        if (lifecycle != null) {
            boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
            Constructor<T> c2 = SavedStateViewModelFactoryKt.c(cls, (!isAssignableFrom || this.f8588b == null) ? SavedStateViewModelFactoryKt.f8594b : SavedStateViewModelFactoryKt.f8593a);
            if (c2 == null) {
                return this.f8588b != null ? this.f8589c.a(cls) : ViewModelProvider.NewInstanceFactory.f8619b.a().a(cls);
            }
            SavedStateRegistry savedStateRegistry = this.f8592f;
            Intrinsics.m(savedStateRegistry);
            SavedStateHandleController b2 = LegacySavedStateHandleController.b(savedStateRegistry, lifecycle, str, this.f8590d);
            if (!isAssignableFrom || (application = this.f8588b) == null) {
                t = SavedStateViewModelFactoryKt.d(cls, c2, b2.h());
            } else {
                Intrinsics.m(application);
                t = SavedStateViewModelFactoryKt.d(cls, c2, application, b2.h());
            }
            t.f("androidx.lifecycle.savedstate.vm.tag", b2);
            return t;
        }
        throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SavedStateViewModelFactory(@Nullable Application application, @NotNull SavedStateRegistryOwner savedStateRegistryOwner) {
        this(application, savedStateRegistryOwner, (Bundle) null);
        Intrinsics.p(savedStateRegistryOwner, "owner");
    }

    @SuppressLint({"LambdaLast"})
    public SavedStateViewModelFactory(@Nullable Application application, @NotNull SavedStateRegistryOwner savedStateRegistryOwner, @Nullable Bundle bundle) {
        Intrinsics.p(savedStateRegistryOwner, "owner");
        this.f8592f = savedStateRegistryOwner.A();
        this.f8591e = savedStateRegistryOwner.a();
        this.f8590d = bundle;
        this.f8588b = application;
        this.f8589c = application != null ? ViewModelProvider.AndroidViewModelFactory.f8611f.b(application) : new ViewModelProvider.AndroidViewModelFactory();
    }
}
