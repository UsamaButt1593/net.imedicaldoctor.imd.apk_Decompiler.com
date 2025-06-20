package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a \u0010\b\u001a\u00028\u0000\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0005*\u00020\u0007H\b¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "Landroidx/lifecycle/viewmodel/CreationExtras;", "a", "(Landroidx/lifecycle/ViewModelStoreOwner;)Landroidx/lifecycle/viewmodel/CreationExtras;", "Landroidx/lifecycle/ViewModel;", "VM", "Landroidx/lifecycle/ViewModelProvider;", "b", "(Landroidx/lifecycle/ViewModelProvider;)Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel_release"}, k = 2, mv = {1, 8, 0})
@JvmName(name = "ViewModelProviderGetKt")
public final class ViewModelProviderGetKt {
    @NotNull
    public static final CreationExtras a(@NotNull ViewModelStoreOwner viewModelStoreOwner) {
        Intrinsics.p(viewModelStoreOwner, "owner");
        return viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).o() : CreationExtras.Empty.f8714b;
    }

    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> VM b(ViewModelProvider viewModelProvider) {
        Intrinsics.p(viewModelProvider, "<this>");
        Intrinsics.y(4, "VM");
        return viewModelProvider.a(ViewModel.class);
    }
}
