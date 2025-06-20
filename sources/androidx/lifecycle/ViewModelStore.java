package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0003R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012¨\u0006\u0014"}, d2 = {"Landroidx/lifecycle/ViewModelStore;", "", "<init>", "()V", "", "key", "Landroidx/lifecycle/ViewModel;", "viewModel", "", "d", "(Ljava/lang/String;Landroidx/lifecycle/ViewModel;)V", "b", "(Ljava/lang/String;)Landroidx/lifecycle/ViewModel;", "", "c", "()Ljava/util/Set;", "a", "", "Ljava/util/Map;", "map", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 8, 0})
public class ViewModelStore {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, ViewModel> f8623a = new LinkedHashMap();

    public final void a() {
        for (ViewModel b2 : this.f8623a.values()) {
            b2.b();
        }
        this.f8623a.clear();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final ViewModel b(@NotNull String str) {
        Intrinsics.p(str, "key");
        return this.f8623a.get(str);
    }

    @NotNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Set<String> c() {
        return new HashSet(this.f8623a.keySet());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void d(@NotNull String str, @NotNull ViewModel viewModel) {
        Intrinsics.p(str, "key");
        Intrinsics.p(viewModel, "viewModel");
        ViewModel put = this.f8623a.put(str, viewModel);
        if (put != null) {
            put.e();
        }
    }
}
