package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\b8\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u0016¨\u0006\u0019"}, d2 = {"Landroidx/lifecycle/LegacySavedStateHandleController;", "", "<init>", "()V", "Landroidx/savedstate/SavedStateRegistry;", "registry", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "", "key", "Landroid/os/Bundle;", "defaultArgs", "Landroidx/lifecycle/SavedStateHandleController;", "b", "(Landroidx/savedstate/SavedStateRegistry;Landroidx/lifecycle/Lifecycle;Ljava/lang/String;Landroid/os/Bundle;)Landroidx/lifecycle/SavedStateHandleController;", "Landroidx/lifecycle/ViewModel;", "viewModel", "", "a", "(Landroidx/lifecycle/ViewModel;Landroidx/savedstate/SavedStateRegistry;Landroidx/lifecycle/Lifecycle;)V", "c", "(Landroidx/savedstate/SavedStateRegistry;Landroidx/lifecycle/Lifecycle;)V", "Ljava/lang/String;", "TAG_SAVED_STATE_HANDLE_CONTROLLER", "OnRecreation", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0})
public final class LegacySavedStateHandleController {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final LegacySavedStateHandleController f8521a = new LegacySavedStateHandleController();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final String f8522b = "androidx.lifecycle.savedstate.vm.tag";

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/lifecycle/LegacySavedStateHandleController$OnRecreation;", "Landroidx/savedstate/SavedStateRegistry$AutoRecreated;", "<init>", "()V", "Landroidx/savedstate/SavedStateRegistryOwner;", "owner", "", "a", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0})
    public static final class OnRecreation implements SavedStateRegistry.AutoRecreated {
        public void a(@NotNull SavedStateRegistryOwner savedStateRegistryOwner) {
            Intrinsics.p(savedStateRegistryOwner, "owner");
            if (savedStateRegistryOwner instanceof ViewModelStoreOwner) {
                ViewModelStore w = ((ViewModelStoreOwner) savedStateRegistryOwner).w();
                SavedStateRegistry A = savedStateRegistryOwner.A();
                for (String b2 : w.c()) {
                    ViewModel b3 = w.b(b2);
                    Intrinsics.m(b3);
                    LegacySavedStateHandleController.a(b3, A, savedStateRegistryOwner.a());
                }
                if (!w.c().isEmpty()) {
                    A.k(OnRecreation.class);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner".toString());
        }
    }

    private LegacySavedStateHandleController() {
    }

    @JvmStatic
    public static final void a(@NotNull ViewModel viewModel, @NotNull SavedStateRegistry savedStateRegistry, @NotNull Lifecycle lifecycle) {
        Intrinsics.p(viewModel, "viewModel");
        Intrinsics.p(savedStateRegistry, "registry");
        Intrinsics.p(lifecycle, "lifecycle");
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) viewModel.d("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController != null && !savedStateHandleController.i()) {
            savedStateHandleController.a(savedStateRegistry, lifecycle);
            f8521a.c(savedStateRegistry, lifecycle);
        }
    }

    @JvmStatic
    @NotNull
    public static final SavedStateHandleController b(@NotNull SavedStateRegistry savedStateRegistry, @NotNull Lifecycle lifecycle, @Nullable String str, @Nullable Bundle bundle) {
        Intrinsics.p(savedStateRegistry, "registry");
        Intrinsics.p(lifecycle, "lifecycle");
        Intrinsics.m(str);
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, SavedStateHandle.f8567f.a(savedStateRegistry.b(str), bundle));
        savedStateHandleController.a(savedStateRegistry, lifecycle);
        f8521a.c(savedStateRegistry, lifecycle);
        return savedStateHandleController;
    }

    private final void c(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        Lifecycle.State b2 = lifecycle.b();
        if (b2 == Lifecycle.State.INITIALIZED || b2.b(Lifecycle.State.STARTED)) {
            savedStateRegistry.k(OnRecreation.class);
        } else {
            lifecycle.a(new LegacySavedStateHandleController$tryToAddRecreator$1(lifecycle, savedStateRegistry));
        }
    }
}
