package androidx.activity;

import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/activity/OnBackPressedDispatcherOwner;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/activity/OnBackPressedDispatcher;", "e", "()Landroidx/activity/OnBackPressedDispatcher;", "onBackPressedDispatcher", "activity_release"}, k = 1, mv = {1, 8, 0})
public interface OnBackPressedDispatcherOwner extends LifecycleOwner {
    @NotNull
    OnBackPressedDispatcher e();
}
