package androidx.savedstate;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "view", "Landroidx/savedstate/SavedStateRegistryOwner;", "b", "(Landroid/view/View;)Landroidx/savedstate/SavedStateRegistryOwner;"}, k = 3, mv = {1, 8, 0})
final class ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2 extends Lambda implements Function1<View, SavedStateRegistryOwner> {
    public static final ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2 X = new ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2();

    ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2() {
        super(1);
    }

    @Nullable
    /* renamed from: b */
    public final SavedStateRegistryOwner f(@NotNull View view) {
        Intrinsics.p(view, "view");
        Object tag = view.getTag(R.id.f15704a);
        if (tag instanceof SavedStateRegistryOwner) {
            return (SavedStateRegistryOwner) tag;
        }
        return null;
    }
}
