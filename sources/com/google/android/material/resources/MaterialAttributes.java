package com.google.android.material.resources;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialAttributes {
    @Nullable
    public static TypedValue a(@NonNull Context context, @AttrRes int i2) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i2, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean b(@NonNull Context context, @AttrRes int i2, boolean z) {
        TypedValue a2 = a(context, i2);
        if (a2 == null || a2.type != 18) {
            return z;
        }
        return a2.data != 0;
    }

    public static boolean c(@NonNull Context context, @AttrRes int i2, @NonNull String str) {
        return g(context, i2, str) != 0;
    }

    @Px
    public static int d(@NonNull Context context, @AttrRes int i2, @DimenRes int i3) {
        TypedValue a2 = a(context, i2);
        return (int) ((a2 == null || a2.type != 5) ? context.getResources().getDimension(i3) : a2.getDimension(context.getResources().getDisplayMetrics()));
    }

    public static int e(@NonNull Context context, @AttrRes int i2, int i3) {
        TypedValue a2 = a(context, i2);
        return (a2 == null || a2.type != 16) ? i3 : a2.data;
    }

    @Px
    public static int f(@NonNull Context context) {
        return d(context, R.attr.rd, R.dimen.Ec);
    }

    public static int g(@NonNull Context context, @AttrRes int i2, @NonNull String str) {
        return i(context, i2, str).data;
    }

    public static int h(@NonNull View view, @AttrRes int i2) {
        return j(view, i2).data;
    }

    @NonNull
    public static TypedValue i(@NonNull Context context, @AttrRes int i2, @NonNull String str) {
        TypedValue a2 = a(context, i2);
        if (a2 != null) {
            return a2;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", new Object[]{str, context.getResources().getResourceName(i2)}));
    }

    @NonNull
    public static TypedValue j(@NonNull View view, @AttrRes int i2) {
        return i(view.getContext(), i2, view.getClass().getCanonicalName());
    }
}
