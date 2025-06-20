package com.google.android.material.color;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ThemeUtils {
    private ThemeUtils() {
    }

    public static void a(@NonNull Context context, @StyleRes int i2) {
        Resources.Theme b2;
        context.getTheme().applyStyle(i2, true);
        if ((context instanceof Activity) && (b2 = b((Activity) context)) != null) {
            b2.applyStyle(i2, true);
        }
    }

    @Nullable
    private static Resources.Theme b(@NonNull Activity activity) {
        View peekDecorView;
        Context context;
        Window window = activity.getWindow();
        if (window == null || (peekDecorView = window.peekDecorView()) == null || (context = peekDecorView.getContext()) == null) {
            return null;
        }
        return context.getTheme();
    }
}
