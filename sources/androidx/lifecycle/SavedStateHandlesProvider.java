package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001c\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u0016\u0010\u001b¨\u0006\u001d"}, d2 = {"Landroidx/lifecycle/SavedStateHandlesProvider;", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "Landroidx/savedstate/SavedStateRegistry;", "savedStateRegistry", "Landroidx/lifecycle/ViewModelStoreOwner;", "viewModelStoreOwner", "<init>", "(Landroidx/savedstate/SavedStateRegistry;Landroidx/lifecycle/ViewModelStoreOwner;)V", "Landroid/os/Bundle;", "a", "()Landroid/os/Bundle;", "", "d", "()V", "", "key", "b", "(Ljava/lang/String;)Landroid/os/Bundle;", "Landroidx/savedstate/SavedStateRegistry;", "", "Z", "restored", "c", "Landroid/os/Bundle;", "restoredState", "Landroidx/lifecycle/SavedStateHandlesVM;", "Lkotlin/Lazy;", "()Landroidx/lifecycle/SavedStateHandlesVM;", "viewModel", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSavedStateHandleSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateHandleSupport.kt\nandroidx/lifecycle/SavedStateHandlesProvider\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,225:1\n215#2,2:226\n1#3:228\n*S KotlinDebug\n*F\n+ 1 SavedStateHandleSupport.kt\nandroidx/lifecycle/SavedStateHandlesProvider\n*L\n146#1:226,2\n*E\n"})
public final class SavedStateHandlesProvider implements SavedStateRegistry.SavedStateProvider {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final SavedStateRegistry f8583a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f8584b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Bundle f8585c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Lazy f8586d;

    public SavedStateHandlesProvider(@NotNull SavedStateRegistry savedStateRegistry, @NotNull ViewModelStoreOwner viewModelStoreOwner) {
        Intrinsics.p(savedStateRegistry, "savedStateRegistry");
        Intrinsics.p(viewModelStoreOwner, "viewModelStoreOwner");
        this.f8583a = savedStateRegistry;
        this.f8586d = LazyKt.c(new SavedStateHandlesProvider$viewModel$2(viewModelStoreOwner));
    }

    private final SavedStateHandlesVM c() {
        return (SavedStateHandlesVM) this.f8586d.getValue();
    }

    @NotNull
    public Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f8585c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry next : c().g().entrySet()) {
            String str = (String) next.getKey();
            Bundle a2 = ((SavedStateHandle) next.getValue()).o().a();
            if (!Intrinsics.g(a2, Bundle.EMPTY)) {
                bundle.putBundle(str, a2);
            }
        }
        this.f8584b = false;
        return bundle;
    }

    @Nullable
    public final Bundle b(@NotNull String str) {
        Intrinsics.p(str, "key");
        d();
        Bundle bundle = this.f8585c;
        Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
        Bundle bundle3 = this.f8585c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.f8585c;
        if (bundle4 != null && bundle4.isEmpty()) {
            this.f8585c = null;
        }
        return bundle2;
    }

    public final void d() {
        if (!this.f8584b) {
            Bundle b2 = this.f8583a.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
            Bundle bundle = new Bundle();
            Bundle bundle2 = this.f8585c;
            if (bundle2 != null) {
                bundle.putAll(bundle2);
            }
            if (b2 != null) {
                bundle.putAll(b2);
            }
            this.f8585c = bundle;
            this.f8584b = true;
            c();
        }
    }
}
