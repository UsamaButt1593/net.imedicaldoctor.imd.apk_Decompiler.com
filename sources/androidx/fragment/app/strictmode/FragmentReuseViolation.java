package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentReuseViolation;", "Landroidx/fragment/app/strictmode/Violation;", "Landroidx/fragment/app/Fragment;", "fragment", "", "previousFragmentId", "<init>", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "X", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "fragment_release"}, k = 1, mv = {1, 6, 0})
public final class FragmentReuseViolation extends Violation {
    @NotNull
    private final String X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentReuseViolation(@NotNull Fragment fragment, @NotNull String str) {
        super(fragment, "Attempting to reuse fragment " + fragment + " with previous ID " + str);
        Intrinsics.p(fragment, "fragment");
        Intrinsics.p(str, "previousFragmentId");
        this.X = str;
    }

    @NotNull
    public final String b() {
        return this.X;
    }
}
