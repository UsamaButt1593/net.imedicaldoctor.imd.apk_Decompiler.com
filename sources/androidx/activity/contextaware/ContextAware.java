package androidx.activity.contextaware;

import android.content.Context;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\tø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Landroidx/activity/contextaware/ContextAware;", "", "Landroid/content/Context;", "p", "()Landroid/content/Context;", "Landroidx/activity/contextaware/OnContextAvailableListener;", "listener", "", "J", "(Landroidx/activity/contextaware/OnContextAvailableListener;)V", "m", "activity_release"}, k = 1, mv = {1, 8, 0})
public interface ContextAware {
    void J(@NotNull OnContextAvailableListener onContextAvailableListener);

    void m(@NotNull OnContextAvailableListener onContextAvailableListener);

    @Nullable
    Context p();
}
