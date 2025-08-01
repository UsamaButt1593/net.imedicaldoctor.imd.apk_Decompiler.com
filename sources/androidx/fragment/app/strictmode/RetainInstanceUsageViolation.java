package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u001b\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/fragment/app/strictmode/RetainInstanceUsageViolation;", "Landroidx/fragment/app/strictmode/Violation;", "fragment", "Landroidx/fragment/app/Fragment;", "message", "", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;)V", "fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class RetainInstanceUsageViolation extends Violation {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RetainInstanceUsageViolation(@NotNull Fragment fragment, @Nullable String str) {
        super(fragment, str);
        Intrinsics.p(fragment, "fragment");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RetainInstanceUsageViolation(Fragment fragment, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragment, (i2 & 2) != 0 ? null : str);
    }
}
