package androidx.appcompat.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;

public final class AppCompatResources {
    private AppCompatResources() {
    }

    public static ColorStateList a(@NonNull Context context, @ColorRes int i2) {
        return ContextCompat.h(context, i2);
    }

    @Nullable
    public static Drawable b(@NonNull Context context, @DrawableRes int i2) {
        return ResourceManagerInternal.h().j(context, i2);
    }
}
