package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.Recreator;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nSavedStateRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateRegistry.kt\nandroidx/savedstate/SavedStateRegistry\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,272:1\n1#2:273\n*E\n"})
@SuppressLint({"RestrictedApi"})
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0003567B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u000b2\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u001f\u0010\u001dR \u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0 8\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010'R$\u0010-\u001a\u00020$2\u0006\u0010)\u001a\u00020$8G@BX\u000e¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010/R\"\u00104\u001a\u00020$8\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b1\u0010%\u001a\u0004\b*\u0010,\"\u0004\b2\u00103¨\u00068"}, d2 = {"Landroidx/savedstate/SavedStateRegistry;", "", "<init>", "()V", "", "key", "Landroid/os/Bundle;", "b", "(Ljava/lang/String;)Landroid/os/Bundle;", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "provider", "", "j", "(Ljava/lang/String;Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;)V", "c", "(Ljava/lang/String;)Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "m", "(Ljava/lang/String;)V", "Ljava/lang/Class;", "Landroidx/savedstate/SavedStateRegistry$AutoRecreated;", "clazz", "k", "(Ljava/lang/Class;)V", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "g", "(Landroidx/lifecycle/Lifecycle;)V", "savedState", "h", "(Landroid/os/Bundle;)V", "outBundle", "i", "Landroidx/arch/core/internal/SafeIterableMap;", "a", "Landroidx/arch/core/internal/SafeIterableMap;", "components", "", "Z", "attached", "Landroid/os/Bundle;", "restoredState", "<set-?>", "d", "e", "()Z", "isRestored", "Landroidx/savedstate/Recreator$SavedStateProvider;", "Landroidx/savedstate/Recreator$SavedStateProvider;", "recreatorProvider", "f", "l", "(Z)V", "isAllowingSavingState", "AutoRecreated", "Companion", "SavedStateProvider", "savedstate_release"}, k = 1, mv = {1, 8, 0})
public final class SavedStateRegistry {
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private static final Companion f15706g = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated

    /* renamed from: h  reason: collision with root package name */
    private static final String f15707h = "androidx.lifecycle.BundlableSavedStateRegistry.key";
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final SafeIterableMap<String, SavedStateProvider> f15708a = new SafeIterableMap<>();

    /* renamed from: b  reason: collision with root package name */
    private boolean f15709b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Bundle f15710c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f15711d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private Recreator.SavedStateProvider f15712e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f15713f = true;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/savedstate/SavedStateRegistry$AutoRecreated;", "", "Landroidx/savedstate/SavedStateRegistryOwner;", "owner", "", "a", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "savedstate_release"}, k = 1, mv = {1, 8, 0})
    public interface AutoRecreated {
        void a(@NotNull SavedStateRegistryOwner savedStateRegistryOwner);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/savedstate/SavedStateRegistry$Companion;", "", "()V", "SAVED_COMPONENTS_KEY", "", "savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0001\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "", "Landroid/os/Bundle;", "a", "()Landroid/os/Bundle;", "savedstate_release"}, k = 1, mv = {1, 8, 0})
    public interface SavedStateProvider {
        @NotNull
        Bundle a();
    }

    /* access modifiers changed from: private */
    public static final void f(SavedStateRegistry savedStateRegistry, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        boolean z;
        Intrinsics.p(savedStateRegistry, "this$0");
        Intrinsics.p(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.p(event, NotificationCompat.I0);
        if (event == Lifecycle.Event.ON_START) {
            z = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            z = false;
        } else {
            return;
        }
        savedStateRegistry.f15713f = z;
    }

    @Nullable
    @MainThread
    public final Bundle b(@NotNull String str) {
        Intrinsics.p(str, "key");
        if (this.f15711d) {
            Bundle bundle = this.f15710c;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
            Bundle bundle3 = this.f15710c;
            if (bundle3 != null) {
                bundle3.remove(str);
            }
            Bundle bundle4 = this.f15710c;
            if (bundle4 == null || bundle4.isEmpty()) {
                this.f15710c = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
    }

    @Nullable
    public final SavedStateProvider c(@NotNull String str) {
        Intrinsics.p(str, "key");
        Iterator<Map.Entry<String, SavedStateProvider>> it2 = this.f15708a.iterator();
        while (it2.hasNext()) {
            Map.Entry next = it2.next();
            Intrinsics.o(next, "components");
            SavedStateProvider savedStateProvider = (SavedStateProvider) next.getValue();
            if (Intrinsics.g((String) next.getKey(), str)) {
                return savedStateProvider;
            }
        }
        return null;
    }

    public final boolean d() {
        return this.f15713f;
    }

    @MainThread
    public final boolean e() {
        return this.f15711d;
    }

    @MainThread
    public final void g(@NotNull Lifecycle lifecycle) {
        Intrinsics.p(lifecycle, "lifecycle");
        if (!this.f15709b) {
            lifecycle.a(new a(this));
            this.f15709b = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
    }

    @MainThread
    public final void h(@Nullable Bundle bundle) {
        if (!this.f15709b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        } else if (!this.f15711d) {
            this.f15710c = bundle != null ? bundle.getBundle(f15707h) : null;
            this.f15711d = true;
        } else {
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
    }

    @MainThread
    public final void i(@NotNull Bundle bundle) {
        Intrinsics.p(bundle, "outBundle");
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f15710c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        SafeIterableMap<K, V>.IteratorWithAdditions d2 = this.f15708a.d();
        Intrinsics.o(d2, "this.components.iteratorWithAdditions()");
        while (d2.hasNext()) {
            Map.Entry entry = (Map.Entry) d2.next();
            bundle2.putBundle((String) entry.getKey(), ((SavedStateProvider) entry.getValue()).a());
        }
        if (!bundle2.isEmpty()) {
            bundle.putBundle(f15707h, bundle2);
        }
    }

    @MainThread
    public final void j(@NotNull String str, @NotNull SavedStateProvider savedStateProvider) {
        Intrinsics.p(str, "key");
        Intrinsics.p(savedStateProvider, "provider");
        if (this.f15708a.j(str, savedStateProvider) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    @MainThread
    public final void k(@NotNull Class<? extends AutoRecreated> cls) {
        Intrinsics.p(cls, "clazz");
        if (this.f15713f) {
            Recreator.SavedStateProvider savedStateProvider = this.f15712e;
            if (savedStateProvider == null) {
                savedStateProvider = new Recreator.SavedStateProvider(this);
            }
            this.f15712e = savedStateProvider;
            try {
                cls.getDeclaredConstructor((Class[]) null);
                Recreator.SavedStateProvider savedStateProvider2 = this.f15712e;
                if (savedStateProvider2 != null) {
                    String name = cls.getName();
                    Intrinsics.o(name, "clazz.name");
                    savedStateProvider2.b(name);
                }
            } catch (NoSuchMethodException e2) {
                throw new IllegalArgumentException("Class " + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
        }
    }

    public final void l(boolean z) {
        this.f15713f = z;
    }

    @MainThread
    public final void m(@NotNull String str) {
        Intrinsics.p(str, "key");
        this.f15708a.k(str);
    }
}
