package androidx.lifecycle;

import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001'B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004B\u001b\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0003\u0010\tJ/\u0010\u0010\u001a\u00028\u0000\"\b\b\u0000\u0010\u000b*\u00020\n2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0014\u001a\u00028\u0000\"\b\b\u0000\u0010\u000b*\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0016\u001a\u00028\u0000\"\b\b\u0000\u0010\u000b*\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J7\u0010\u001a\u001a\u00028\u0000\"\b\b\u0000\u0010\u000b*\u00020\n2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0019\u001a\u00020\u0018H$¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\nH\u0017¢\u0006\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010$R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010&¨\u0006("}, d2 = {"Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$OnRequeryFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "()V", "Landroidx/savedstate/SavedStateRegistryOwner;", "owner", "Landroid/os/Bundle;", "defaultArgs", "(Landroidx/savedstate/SavedStateRegistryOwner;Landroid/os/Bundle;)V", "Landroidx/lifecycle/ViewModel;", "T", "", "key", "Ljava/lang/Class;", "modelClass", "d", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "extras", "b", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "a", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/SavedStateHandle;", "handle", "e", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "viewModel", "", "c", "(Landroidx/lifecycle/ViewModel;)V", "Landroidx/savedstate/SavedStateRegistry;", "Landroidx/savedstate/SavedStateRegistry;", "savedStateRegistry", "Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Landroid/os/Bundle;", "Companion", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0})
public abstract class AbstractSavedStateViewModelFactory extends ViewModelProvider.OnRequeryFactory implements ViewModelProvider.Factory {
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f8492e = new Companion((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public static final String f8493f = "androidx.lifecycle.savedstate.vm.tag";
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private SavedStateRegistry f8494b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Lifecycle f8495c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Bundle f8496d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/lifecycle/AbstractSavedStateViewModelFactory$Companion;", "", "()V", "TAG_SAVED_STATE_HANDLE_CONTROLLER", "", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AbstractSavedStateViewModelFactory() {
    }

    private final <T extends ViewModel> T d(String str, Class<T> cls) {
        SavedStateRegistry savedStateRegistry = this.f8494b;
        Intrinsics.m(savedStateRegistry);
        Lifecycle lifecycle = this.f8495c;
        Intrinsics.m(lifecycle);
        SavedStateHandleController b2 = LegacySavedStateHandleController.b(savedStateRegistry, lifecycle, str, this.f8496d);
        T e2 = e(str, cls, b2.h());
        e2.f("androidx.lifecycle.savedstate.vm.tag", b2);
        return e2;
    }

    @NotNull
    public <T extends ViewModel> T a(@NotNull Class<T> cls) {
        Intrinsics.p(cls, "modelClass");
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        } else if (this.f8495c != null) {
            return d(canonicalName, cls);
        } else {
            throw new UnsupportedOperationException("AbstractSavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
    }

    @NotNull
    public <T extends ViewModel> T b(@NotNull Class<T> cls, @NotNull CreationExtras creationExtras) {
        Intrinsics.p(cls, "modelClass");
        Intrinsics.p(creationExtras, "extras");
        String str = (String) creationExtras.a(ViewModelProvider.NewInstanceFactory.f8621d);
        if (str != null) {
            return this.f8494b != null ? d(str, cls) : e(str, cls, SavedStateHandleSupport.a(creationExtras));
        }
        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void c(@NotNull ViewModel viewModel) {
        Intrinsics.p(viewModel, "viewModel");
        SavedStateRegistry savedStateRegistry = this.f8494b;
        if (savedStateRegistry != null) {
            Intrinsics.m(savedStateRegistry);
            Lifecycle lifecycle = this.f8495c;
            Intrinsics.m(lifecycle);
            LegacySavedStateHandleController.a(viewModel, savedStateRegistry, lifecycle);
        }
    }

    /* access modifiers changed from: protected */
    @NotNull
    public abstract <T extends ViewModel> T e(@NotNull String str, @NotNull Class<T> cls, @NotNull SavedStateHandle savedStateHandle);

    public AbstractSavedStateViewModelFactory(@NotNull SavedStateRegistryOwner savedStateRegistryOwner, @Nullable Bundle bundle) {
        Intrinsics.p(savedStateRegistryOwner, "owner");
        this.f8494b = savedStateRegistryOwner.A();
        this.f8495c = savedStateRegistryOwner.a();
        this.f8496d = bundle;
    }
}
