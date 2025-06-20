package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class ImageViewCompat {

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static ColorStateList a(ImageView imageView) {
            return imageView.getImageTintList();
        }

        @DoNotInline
        static PorterDuff.Mode b(ImageView imageView) {
            return imageView.getImageTintMode();
        }

        @DoNotInline
        static void c(ImageView imageView, ColorStateList colorStateList) {
            imageView.setImageTintList(colorStateList);
        }

        @DoNotInline
        static void d(ImageView imageView, PorterDuff.Mode mode) {
            imageView.setImageTintMode(mode);
        }
    }

    private ImageViewCompat() {
    }

    @Nullable
    public static ColorStateList a(@NonNull ImageView imageView) {
        return Api21Impl.a(imageView);
    }

    @Nullable
    public static PorterDuff.Mode b(@NonNull ImageView imageView) {
        return Api21Impl.b(imageView);
    }

    public static void c(@NonNull ImageView imageView, @Nullable ColorStateList colorStateList) {
        Drawable drawable;
        int i2 = Build.VERSION.SDK_INT;
        Api21Impl.c(imageView, colorStateList);
        if (i2 == 21 && (drawable = imageView.getDrawable()) != null && Api21Impl.a(imageView) != null) {
            if (drawable.isStateful()) {
                drawable.setState(imageView.getDrawableState());
            }
            imageView.setImageDrawable(drawable);
        }
    }

    public static void d(@NonNull ImageView imageView, @Nullable PorterDuff.Mode mode) {
        Drawable drawable;
        int i2 = Build.VERSION.SDK_INT;
        Api21Impl.d(imageView, mode);
        if (i2 == 21 && (drawable = imageView.getDrawable()) != null && Api21Impl.a(imageView) != null) {
            if (drawable.isStateful()) {
                drawable.setState(imageView.getDrawableState());
            }
            imageView.setImageDrawable(drawable);
        }
    }
}
