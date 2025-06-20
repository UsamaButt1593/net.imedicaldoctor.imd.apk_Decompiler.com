package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class FragmentContainer {
    @NonNull
    @Deprecated
    public Fragment d(@NonNull Context context, @NonNull String str, @Nullable Bundle bundle) {
        return Fragment.x0(context, str, bundle);
    }

    @Nullable
    public abstract View g(@IdRes int i2);

    public abstract boolean i();
}
