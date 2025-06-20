package androidx.fragment.app.strictmode;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentTagUsageViolation;", "Landroidx/fragment/app/strictmode/Violation;", "Landroidx/fragment/app/Fragment;", "fragment", "Landroid/view/ViewGroup;", "parentContainer", "<init>", "(Landroidx/fragment/app/Fragment;Landroid/view/ViewGroup;)V", "X", "Landroid/view/ViewGroup;", "b", "()Landroid/view/ViewGroup;", "fragment_release"}, k = 1, mv = {1, 6, 0})
public final class FragmentTagUsageViolation extends Violation {
    @Nullable
    private final ViewGroup X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentTagUsageViolation(@NotNull Fragment fragment, @Nullable ViewGroup viewGroup) {
        super(fragment, "Attempting to use <fragment> tag to add fragment " + fragment + " to container " + viewGroup);
        Intrinsics.p(fragment, "fragment");
        this.X = viewGroup;
    }

    @Nullable
    public final ViewGroup b() {
        return this.X;
    }
}
