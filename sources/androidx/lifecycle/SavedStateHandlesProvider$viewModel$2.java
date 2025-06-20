package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Landroidx/lifecycle/SavedStateHandlesVM;", "b", "()Landroidx/lifecycle/SavedStateHandlesVM;"}, k = 3, mv = {1, 8, 0})
final class SavedStateHandlesProvider$viewModel$2 extends Lambda implements Function0<SavedStateHandlesVM> {
    final /* synthetic */ ViewModelStoreOwner X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SavedStateHandlesProvider$viewModel$2(ViewModelStoreOwner viewModelStoreOwner) {
        super(0);
        this.X = viewModelStoreOwner;
    }

    @NotNull
    /* renamed from: b */
    public final SavedStateHandlesVM o() {
        return SavedStateHandleSupport.e(this.X);
    }
}
