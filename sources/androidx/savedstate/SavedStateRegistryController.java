package androidx.savedstate;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0019B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000e\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017¨\u0006\u001a"}, d2 = {"Landroidx/savedstate/SavedStateRegistryController;", "", "Landroidx/savedstate/SavedStateRegistryOwner;", "owner", "<init>", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "", "c", "()V", "Landroid/os/Bundle;", "savedState", "d", "(Landroid/os/Bundle;)V", "outBundle", "e", "a", "Landroidx/savedstate/SavedStateRegistryOwner;", "Landroidx/savedstate/SavedStateRegistry;", "b", "Landroidx/savedstate/SavedStateRegistry;", "()Landroidx/savedstate/SavedStateRegistry;", "savedStateRegistry", "", "Z", "attached", "Companion", "savedstate_release"}, k = 1, mv = {1, 8, 0})
public final class SavedStateRegistryController {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f15714d = new Companion((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final SavedStateRegistryOwner f15715a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final SavedStateRegistry f15716b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f15717c;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/savedstate/SavedStateRegistryController$Companion;", "", "<init>", "()V", "Landroidx/savedstate/SavedStateRegistryOwner;", "owner", "Landroidx/savedstate/SavedStateRegistryController;", "a", "(Landroidx/savedstate/SavedStateRegistryOwner;)Landroidx/savedstate/SavedStateRegistryController;", "savedstate_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final SavedStateRegistryController a(@NotNull SavedStateRegistryOwner savedStateRegistryOwner) {
            Intrinsics.p(savedStateRegistryOwner, "owner");
            return new SavedStateRegistryController(savedStateRegistryOwner, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private SavedStateRegistryController(SavedStateRegistryOwner savedStateRegistryOwner) {
        this.f15715a = savedStateRegistryOwner;
        this.f15716b = new SavedStateRegistry();
    }

    @JvmStatic
    @NotNull
    public static final SavedStateRegistryController a(@NotNull SavedStateRegistryOwner savedStateRegistryOwner) {
        return f15714d.a(savedStateRegistryOwner);
    }

    @NotNull
    public final SavedStateRegistry b() {
        return this.f15716b;
    }

    @MainThread
    public final void c() {
        Lifecycle a2 = this.f15715a.a();
        if (a2.b() == Lifecycle.State.INITIALIZED) {
            a2.a(new Recreator(this.f15715a));
            this.f15716b.g(a2);
            this.f15717c = true;
            return;
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage".toString());
    }

    @MainThread
    public final void d(@Nullable Bundle bundle) {
        if (!this.f15717c) {
            c();
        }
        Lifecycle a2 = this.f15715a.a();
        if (!a2.b().b(Lifecycle.State.STARTED)) {
            this.f15716b.h(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + a2.b()).toString());
    }

    @MainThread
    public final void e(@NotNull Bundle bundle) {
        Intrinsics.p(bundle, "outBundle");
        this.f15716b.i(bundle);
    }

    public /* synthetic */ SavedStateRegistryController(SavedStateRegistryOwner savedStateRegistryOwner, DefaultConstructorMarker defaultConstructorMarker) {
        this(savedStateRegistryOwner);
    }
}
