package androidx.lifecycle;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nSavedStateHandleSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateHandleSupport.kt\nandroidx/lifecycle/SavedStateHandleSupport\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 InitializerViewModelFactory.kt\nandroidx/lifecycle/viewmodel/InitializerViewModelFactoryKt\n*L\n1#1,225:1\n1#2:226\n31#3:227\n63#3,2:228\n*S KotlinDebug\n*F\n+ 1 SavedStateHandleSupport.kt\nandroidx/lifecycle/SavedStateHandleSupport\n*L\n109#1:227\n110#1:228,2\n*E\n"})
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0004\u001a\u00020\u0003\"\f\b\u0000\u0010\u0002*\u00020\u0000*\u00020\u0001*\u00028\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a1\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\u0013\u0010\u0010\u001a\u00020\f*\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\"\u0014\u0010\u0013\u001a\u00020\b8\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012\"\u0014\u0010\u0014\u001a\u00020\b8\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u0012\"\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00000\u00158\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0016\"\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00158\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016\"\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u00158\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0016\"\u0018\u0010\u001e\u001a\u00020\u001c*\u00020\u00018@X\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001d\"\u0018\u0010!\u001a\u00020\u001f*\u00020\u00008@X\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010 ¨\u0006\""}, d2 = {"Landroidx/savedstate/SavedStateRegistryOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "T", "", "c", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "savedStateRegistryOwner", "viewModelStoreOwner", "", "key", "Landroid/os/Bundle;", "defaultArgs", "Landroidx/lifecycle/SavedStateHandle;", "b", "(Landroidx/savedstate/SavedStateRegistryOwner;Landroidx/lifecycle/ViewModelStoreOwner;Ljava/lang/String;Landroid/os/Bundle;)Landroidx/lifecycle/SavedStateHandle;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "a", "(Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/SavedStateHandle;", "Ljava/lang/String;", "VIEWMODEL_KEY", "SAVED_STATE_KEY", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "SAVED_STATE_REGISTRY_OWNER_KEY", "d", "VIEW_MODEL_STORE_OWNER_KEY", "e", "DEFAULT_ARGS_KEY", "Landroidx/lifecycle/SavedStateHandlesVM;", "(Landroidx/lifecycle/ViewModelStoreOwner;)Landroidx/lifecycle/SavedStateHandlesVM;", "savedStateHandlesVM", "Landroidx/lifecycle/SavedStateHandlesProvider;", "(Landroidx/savedstate/SavedStateRegistryOwner;)Landroidx/lifecycle/SavedStateHandlesProvider;", "savedStateHandlesProvider", "lifecycle-viewmodel-savedstate_release"}, k = 2, mv = {1, 8, 0})
@JvmName(name = "SavedStateHandleSupport")
public final class SavedStateHandleSupport {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final String f8578a = "androidx.lifecycle.internal.SavedStateHandlesVM";
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final String f8579b = "androidx.lifecycle.internal.SavedStateHandlesProvider";
    @NotNull
    @JvmField

    /* renamed from: c  reason: collision with root package name */
    public static final CreationExtras.Key<SavedStateRegistryOwner> f8580c = new SavedStateHandleSupport$SAVED_STATE_REGISTRY_OWNER_KEY$1();
    @NotNull
    @JvmField

    /* renamed from: d  reason: collision with root package name */
    public static final CreationExtras.Key<ViewModelStoreOwner> f8581d = new SavedStateHandleSupport$VIEW_MODEL_STORE_OWNER_KEY$1();
    @NotNull
    @JvmField

    /* renamed from: e  reason: collision with root package name */
    public static final CreationExtras.Key<Bundle> f8582e = new SavedStateHandleSupport$DEFAULT_ARGS_KEY$1();

    @NotNull
    @MainThread
    public static final SavedStateHandle a(@NotNull CreationExtras creationExtras) {
        Intrinsics.p(creationExtras, "<this>");
        SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) creationExtras.a(f8580c);
        if (savedStateRegistryOwner != null) {
            ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) creationExtras.a(f8581d);
            if (viewModelStoreOwner != null) {
                Bundle bundle = (Bundle) creationExtras.a(f8582e);
                String str = (String) creationExtras.a(ViewModelProvider.NewInstanceFactory.f8621d);
                if (str != null) {
                    return b(savedStateRegistryOwner, viewModelStoreOwner, str, bundle);
                }
                throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
            }
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
    }

    private static final SavedStateHandle b(SavedStateRegistryOwner savedStateRegistryOwner, ViewModelStoreOwner viewModelStoreOwner, String str, Bundle bundle) {
        SavedStateHandlesProvider d2 = d(savedStateRegistryOwner);
        SavedStateHandlesVM e2 = e(viewModelStoreOwner);
        SavedStateHandle savedStateHandle = e2.g().get(str);
        if (savedStateHandle != null) {
            return savedStateHandle;
        }
        SavedStateHandle a2 = SavedStateHandle.f8567f.a(d2.b(str), bundle);
        e2.g().put(str, a2);
        return a2;
    }

    @MainThread
    public static final <T extends SavedStateRegistryOwner & ViewModelStoreOwner> void c(@NotNull T t) {
        Intrinsics.p(t, "<this>");
        Lifecycle.State b2 = t.a().b();
        if (b2 != Lifecycle.State.INITIALIZED && b2 != Lifecycle.State.CREATED) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (t.A().c(f8579b) == null) {
            SavedStateHandlesProvider savedStateHandlesProvider = new SavedStateHandlesProvider(t.A(), (ViewModelStoreOwner) t);
            t.A().j(f8579b, savedStateHandlesProvider);
            t.a().a(new SavedStateHandleAttacher(savedStateHandlesProvider));
        }
    }

    @NotNull
    public static final SavedStateHandlesProvider d(@NotNull SavedStateRegistryOwner savedStateRegistryOwner) {
        Intrinsics.p(savedStateRegistryOwner, "<this>");
        SavedStateRegistry.SavedStateProvider c2 = savedStateRegistryOwner.A().c(f8579b);
        SavedStateHandlesProvider savedStateHandlesProvider = c2 instanceof SavedStateHandlesProvider ? (SavedStateHandlesProvider) c2 : null;
        if (savedStateHandlesProvider != null) {
            return savedStateHandlesProvider;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    @NotNull
    public static final SavedStateHandlesVM e(@NotNull ViewModelStoreOwner viewModelStoreOwner) {
        Intrinsics.p(viewModelStoreOwner, "<this>");
        InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
        Class cls = SavedStateHandlesVM.class;
        initializerViewModelFactoryBuilder.a(Reflection.d(cls), SavedStateHandleSupport$savedStateHandlesVM$1$1.X);
        return (SavedStateHandlesVM) new ViewModelProvider(viewModelStoreOwner, initializerViewModelFactoryBuilder.b()).b(f8578a, cls);
    }
}
