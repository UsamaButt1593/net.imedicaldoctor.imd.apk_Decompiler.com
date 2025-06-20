package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewGroup;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewGroupUtils {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f16107a = true;

    /* renamed from: b  reason: collision with root package name */
    private static Method f16108b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f16109c;

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static int a(ViewGroup viewGroup, int i2) {
            return viewGroup.getChildDrawingOrder(i2);
        }

        @DoNotInline
        static void b(ViewGroup viewGroup, boolean z) {
            viewGroup.suppressLayout(z);
        }
    }

    private ViewGroupUtils() {
    }

    static int a(@NonNull ViewGroup viewGroup, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.a(viewGroup, i2);
        }
        if (!f16109c) {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                Class cls2 = Integer.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("getChildDrawingOrder", new Class[]{cls2, cls2});
                f16108b = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f16109c = true;
        }
        Method method = f16108b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(viewGroup, new Object[]{Integer.valueOf(viewGroup.getChildCount()), Integer.valueOf(i2)})).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return i2;
    }

    @SuppressLint({"NewApi"})
    private static void b(@NonNull ViewGroup viewGroup, boolean z) {
        if (f16107a) {
            try {
                Api29Impl.b(viewGroup, z);
            } catch (NoSuchMethodError unused) {
                f16107a = false;
            }
        }
    }

    static void c(@NonNull ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.b(viewGroup, z);
        } else {
            b(viewGroup, z);
        }
    }
}
