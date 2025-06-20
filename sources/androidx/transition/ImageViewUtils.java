package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;

class ImageViewUtils {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f15999a = true;

    /* renamed from: b  reason: collision with root package name */
    private static Field f16000b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f16001c;

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void a(ImageView imageView, Matrix matrix) {
            imageView.animateTransform(matrix);
        }
    }

    private ImageViewUtils() {
    }

    static void a(@NonNull ImageView imageView, @Nullable Matrix matrix) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.a(imageView, matrix);
        } else if (matrix == null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable != null) {
                drawable.setBounds(0, 0, (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight(), (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom());
                imageView.invalidate();
            }
        } else {
            c(imageView, matrix);
        }
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    private static void b() {
        if (!f16001c) {
            try {
                Field declaredField = ImageView.class.getDeclaredField("mDrawMatrix");
                f16000b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f16001c = true;
        }
    }

    @RequiresApi(21)
    @SuppressLint({"NewApi"})
    private static void c(@NonNull ImageView imageView, @Nullable Matrix matrix) {
        if (f15999a) {
            try {
                Api29Impl.a(imageView, matrix);
            } catch (NoSuchMethodError unused) {
                f15999a = false;
            }
        }
    }
}
