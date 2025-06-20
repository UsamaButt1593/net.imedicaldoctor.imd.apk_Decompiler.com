package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CompoundButton;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;

public final class CompoundButtonCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6751a = "CompoundButtonCompat";

    /* renamed from: b  reason: collision with root package name */
    private static Field f6752b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f6753c;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static ColorStateList a(CompoundButton compoundButton) {
            return compoundButton.getButtonTintList();
        }

        @DoNotInline
        static PorterDuff.Mode b(CompoundButton compoundButton) {
            return compoundButton.getButtonTintMode();
        }

        @DoNotInline
        static void c(CompoundButton compoundButton, ColorStateList colorStateList) {
            compoundButton.setButtonTintList(colorStateList);
        }

        @DoNotInline
        static void d(CompoundButton compoundButton, PorterDuff.Mode mode) {
            compoundButton.setButtonTintMode(mode);
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static Drawable a(CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }

    private CompoundButtonCompat() {
    }

    @Nullable
    public static Drawable a(@NonNull CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.a(compoundButton);
        }
        if (!f6753c) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f6752b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.i(f6751a, "Failed to retrieve mButtonDrawable field", e2);
            }
            f6753c = true;
        }
        Field field = f6752b;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException e3) {
                Log.i(f6751a, "Failed to get button drawable via reflection", e3);
                f6752b = null;
            }
        }
        return null;
    }

    @Nullable
    public static ColorStateList b(@NonNull CompoundButton compoundButton) {
        return Api21Impl.a(compoundButton);
    }

    @Nullable
    public static PorterDuff.Mode c(@NonNull CompoundButton compoundButton) {
        return Api21Impl.b(compoundButton);
    }

    public static void d(@NonNull CompoundButton compoundButton, @Nullable ColorStateList colorStateList) {
        Api21Impl.c(compoundButton, colorStateList);
    }

    public static void e(@NonNull CompoundButton compoundButton, @Nullable PorterDuff.Mode mode) {
        Api21Impl.d(compoundButton, mode);
    }
}
