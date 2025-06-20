package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.annotation.DoNotInline;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class WindowCompat {

    /* renamed from: a  reason: collision with root package name */
    public static final int f6531a = 8;

    /* renamed from: b  reason: collision with root package name */
    public static final int f6532b = 9;

    /* renamed from: c  reason: collision with root package name */
    public static final int f6533c = 10;

    static class Api16Impl {
        private Api16Impl() {
        }

        static void a(@NonNull Window window, boolean z) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility & -1793 : systemUiVisibility | 1792);
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static <T> T a(Window window, int i2) {
            return window.requireViewById(i2);
        }
    }

    @RequiresApi(30)
    static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static void a(@NonNull Window window, boolean z) {
            window.setDecorFitsSystemWindows(z);
        }
    }

    private WindowCompat() {
    }

    @NonNull
    public static WindowInsetsControllerCompat a(@NonNull Window window, @NonNull View view) {
        return new WindowInsetsControllerCompat(window, view);
    }

    @NonNull
    public static <T extends View> T b(@NonNull Window window, @IdRes int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (View) Api28Impl.a(window, i2);
        }
        T findViewById = window.findViewById(i2);
        if (findViewById != null) {
            return findViewById;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Window");
    }

    public static void c(@NonNull Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.a(window, z);
        } else {
            Api16Impl.a(window, z);
        }
    }
}
