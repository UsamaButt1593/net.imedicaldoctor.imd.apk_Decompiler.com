package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.viewmodel.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "view", "Landroidx/lifecycle/ViewModelStoreOwner;", "b", "(Landroid/view/View;)Landroidx/lifecycle/ViewModelStoreOwner;"}, k = 3, mv = {1, 8, 0})
final class ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2 extends Lambda implements Function1<View, ViewModelStoreOwner> {
    public static final ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2 X = new ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2();

    ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2() {
        super(1);
    }

    @Nullable
    /* renamed from: b */
    public final ViewModelStoreOwner f(@NotNull View view) {
        Intrinsics.p(view, "view");
        Object tag = view.getTag(R.id.f8717a);
        if (tag instanceof ViewModelStoreOwner) {
            return (ViewModelStoreOwner) tag;
        }
        return null;
    }
}
