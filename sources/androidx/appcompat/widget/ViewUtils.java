package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ViewUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3367a = "ViewUtils";

    /* renamed from: b  reason: collision with root package name */
    private static boolean f3368b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f3369c;
    @ChecksSdkIntAtLeast(api = 27)
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: d  reason: collision with root package name */
    static final boolean f3370d = (Build.VERSION.SDK_INT >= 27);

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void a(@NonNull View view, @NonNull Rect rect, @NonNull Rect rect2) {
            Insets systemWindowInsets = view.computeSystemWindowInsets(new WindowInsets.Builder().setSystemWindowInsets(Insets.of(rect)).build(), rect2).getSystemWindowInsets();
            rect.set(systemWindowInsets.left, systemWindowInsets.top, systemWindowInsets.right, systemWindowInsets.bottom);
        }
    }

    private ViewUtils() {
    }

    public static void a(@NonNull View view, @NonNull Rect rect, @NonNull Rect rect2) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.a(view, rect, rect2);
            return;
        }
        if (!f3368b) {
            f3368b = true;
            try {
                Class<Rect> cls = Rect.class;
                Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{cls, cls});
                f3369c = declaredMethod;
                if (!declaredMethod.isAccessible()) {
                    f3369c.setAccessible(true);
                }
            } catch (NoSuchMethodException unused) {
                Log.d(f3367a, "Could not find method computeFitSystemWindows. Oh well.");
            }
        }
        Method method = f3369c;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{rect, rect2});
            } catch (Exception e2) {
                Log.d(f3367a, "Could not invoke computeFitSystemWindows", e2);
            }
        }
    }

    public static boolean b(View view) {
        return view.getLayoutDirection() == 1;
    }

    @SuppressLint({"BanUncheckedReflection"})
    public static void c(View view) {
        try {
            Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", (Class[]) null);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(view, (Object[]) null);
        } catch (NoSuchMethodException unused) {
            Log.d(f3367a, "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        } catch (InvocationTargetException e2) {
            e = e2;
            Log.d(f3367a, "Could not invoke makeOptionalFitsSystemWindows", e);
        } catch (IllegalAccessException e3) {
            e = e3;
            Log.d(f3367a, "Could not invoke makeOptionalFitsSystemWindows", e);
        }
    }
}
