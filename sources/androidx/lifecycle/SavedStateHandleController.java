package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Landroidx/lifecycle/SavedStateHandleController;", "Landroidx/lifecycle/LifecycleEventObserver;", "", "key", "Landroidx/lifecycle/SavedStateHandle;", "handle", "<init>", "(Ljava/lang/String;Landroidx/lifecycle/SavedStateHandle;)V", "Landroidx/savedstate/SavedStateRegistry;", "registry", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "", "a", "(Landroidx/savedstate/SavedStateRegistry;Landroidx/lifecycle/Lifecycle;)V", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "d", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "s", "Ljava/lang/String;", "X", "Landroidx/lifecycle/SavedStateHandle;", "h", "()Landroidx/lifecycle/SavedStateHandle;", "", "<set-?>", "Y", "Z", "i", "()Z", "isAttached", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSavedStateHandleController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateHandleController.kt\nandroidx/lifecycle/SavedStateHandleController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,41:1\n1#2:42\n*E\n"})
public final class SavedStateHandleController implements LifecycleEventObserver {
    @NotNull
    private final SavedStateHandle X;
    private boolean Y;
    @NotNull
    private final String s;

    public SavedStateHandleController(@NotNull String str, @NotNull SavedStateHandle savedStateHandle) {
        Intrinsics.p(str, "key");
        Intrinsics.p(savedStateHandle, "handle");
        this.s = str;
        this.X = savedStateHandle;
    }

    public final void a(@NotNull SavedStateRegistry savedStateRegistry, @NotNull Lifecycle lifecycle) {
        Intrinsics.p(savedStateRegistry, "registry");
        Intrinsics.p(lifecycle, "lifecycle");
        if (!this.Y) {
            this.Y = true;
            lifecycle.a(this);
            savedStateRegistry.j(this.s, this.X.o());
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner".toString());
    }

    public void d(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event) {
        Intrinsics.p(lifecycleOwner, "source");
        Intrinsics.p(event, NotificationCompat.I0);
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.Y = false;
            lifecycleOwner.a().d(this);
        }
    }

    @NotNull
    public final SavedStateHandle h() {
        return this.X;
    }

    public final boolean i() {
        return this.Y;
    }
}
