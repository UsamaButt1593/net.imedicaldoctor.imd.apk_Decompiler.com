package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public final class CheckedTextViewCompat {

    @RequiresApi(21)
    private static class Api21Impl {
        private Api21Impl() {
        }

        @Nullable
        static ColorStateList a(@NonNull CheckedTextView checkedTextView) {
            return checkedTextView.getCheckMarkTintList();
        }

        @Nullable
        static PorterDuff.Mode b(@NonNull CheckedTextView checkedTextView) {
            return checkedTextView.getCheckMarkTintMode();
        }

        static void c(@NonNull CheckedTextView checkedTextView, @Nullable ColorStateList colorStateList) {
            checkedTextView.setCheckMarkTintList(colorStateList);
        }

        static void d(@NonNull CheckedTextView checkedTextView, @Nullable PorterDuff.Mode mode) {
            checkedTextView.setCheckMarkTintMode(mode);
        }
    }

    private CheckedTextViewCompat() {
    }

    @Nullable
    public static Drawable a(@NonNull CheckedTextView checkedTextView) {
        return checkedTextView.getCheckMarkDrawable();
    }

    @Nullable
    public static ColorStateList b(@NonNull CheckedTextView checkedTextView) {
        return Api21Impl.a(checkedTextView);
    }

    @Nullable
    public static PorterDuff.Mode c(@NonNull CheckedTextView checkedTextView) {
        return Api21Impl.b(checkedTextView);
    }

    public static void d(@NonNull CheckedTextView checkedTextView, @Nullable ColorStateList colorStateList) {
        Api21Impl.c(checkedTextView, colorStateList);
    }

    public static void e(@NonNull CheckedTextView checkedTextView, @Nullable PorterDuff.Mode mode) {
        Api21Impl.d(checkedTextView, mode);
    }
}
