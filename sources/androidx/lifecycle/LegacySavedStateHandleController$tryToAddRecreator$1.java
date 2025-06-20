package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LegacySavedStateHandleController;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"androidx/lifecycle/LegacySavedStateHandleController$tryToAddRecreator$1", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "d", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0})
public final class LegacySavedStateHandleController$tryToAddRecreator$1 implements LifecycleEventObserver {
    final /* synthetic */ SavedStateRegistry X;
    final /* synthetic */ Lifecycle s;

    LegacySavedStateHandleController$tryToAddRecreator$1(Lifecycle lifecycle, SavedStateRegistry savedStateRegistry) {
        this.s = lifecycle;
        this.X = savedStateRegistry;
    }

    public void d(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event) {
        Intrinsics.p(lifecycleOwner, "source");
        Intrinsics.p(event, NotificationCompat.I0);
        if (event == Lifecycle.Event.ON_START) {
            this.s.d(this);
            this.X.k(LegacySavedStateHandleController.OnRecreation.class);
        }
    }
}
