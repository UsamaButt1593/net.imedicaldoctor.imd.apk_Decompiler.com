package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.runtime.R;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/view/View;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "", "b", "(Landroid/view/View;Landroidx/lifecycle/LifecycleOwner;)V", "a", "(Landroid/view/View;)Landroidx/lifecycle/LifecycleOwner;", "lifecycle-runtime_release"}, k = 2, mv = {1, 8, 0})
@JvmName(name = "ViewTreeLifecycleOwner")
public final class ViewTreeLifecycleOwner {
    @Nullable
    @JvmName(name = "get")
    public static final LifecycleOwner a(@NotNull View view) {
        Intrinsics.p(view, "<this>");
        return (LifecycleOwner) SequencesKt.F0(SequencesKt.p1(SequencesKt.l(view, ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1.X), ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2.X));
    }

    @JvmName(name = "set")
    public static final void b(@NotNull View view, @Nullable LifecycleOwner lifecycleOwner) {
        Intrinsics.p(view, "<this>");
        view.setTag(R.id.f8712a, lifecycleOwner);
    }
}
