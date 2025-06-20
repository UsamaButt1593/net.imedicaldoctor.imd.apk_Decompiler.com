package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/fragment/app/strictmode/SetTargetFragmentUsageViolation;", "Landroidx/fragment/app/strictmode/TargetFragmentUsageViolation;", "Landroidx/fragment/app/Fragment;", "fragment", "targetFragment", "", "requestCode", "<init>", "(Landroidx/fragment/app/Fragment;Landroidx/fragment/app/Fragment;I)V", "X", "Landroidx/fragment/app/Fragment;", "c", "()Landroidx/fragment/app/Fragment;", "Y", "I", "b", "()I", "fragment_release"}, k = 1, mv = {1, 6, 0})
public final class SetTargetFragmentUsageViolation extends TargetFragmentUsageViolation {
    @NotNull
    private final Fragment X;
    private final int Y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SetTargetFragmentUsageViolation(@NotNull Fragment fragment, @NotNull Fragment fragment2, int i2) {
        super(fragment, "Attempting to set target fragment " + fragment2 + " with request code " + i2 + " for fragment " + fragment);
        Intrinsics.p(fragment, "fragment");
        Intrinsics.p(fragment2, "targetFragment");
        this.X = fragment2;
        this.Y = i2;
    }

    public final int b() {
        return this.Y;
    }

    @NotNull
    public final Fragment c() {
        return this.X;
    }
}
