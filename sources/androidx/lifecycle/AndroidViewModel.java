package androidx.lifecycle;

import android.app.Application;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\u0007\u001a\u00028\u0000\"\b\b\u0000\u0010\u0006*\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/lifecycle/AndroidViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "T", "g", "()Landroid/app/Application;", "d", "Landroid/app/Application;", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 8, 0})
public class AndroidViewModel extends ViewModel {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Application f8497d;

    public AndroidViewModel(@NotNull Application application) {
        Intrinsics.p(application, "application");
        this.f8497d = application;
    }

    @NotNull
    public <T extends Application> T g() {
        T t = this.f8497d;
        Intrinsics.n(t, "null cannot be cast to non-null type T of androidx.lifecycle.AndroidViewModel.getApplication");
        return t;
    }
}
