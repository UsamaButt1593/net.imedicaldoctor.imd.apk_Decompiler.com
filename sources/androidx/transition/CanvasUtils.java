package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class CanvasUtils {

    /* renamed from: a  reason: collision with root package name */
    private static Method f15969a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f15970b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f15971c;

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void a(Canvas canvas) {
            canvas.disableZ();
        }

        @DoNotInline
        static void b(Canvas canvas) {
            canvas.enableZ();
        }
    }

    private CanvasUtils() {
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    static void a(@NonNull Canvas canvas, boolean z) {
        Method method;
        Class<Canvas> cls = Canvas.class;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            if (z) {
                Api29Impl.b(canvas);
            } else {
                Api29Impl.a(canvas);
            }
        } else if (i2 != 28) {
            if (!f15971c) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod("insertReorderBarrier", (Class[]) null);
                    f15969a = declaredMethod;
                    declaredMethod.setAccessible(true);
                    Method declaredMethod2 = cls.getDeclaredMethod("insertInorderBarrier", (Class[]) null);
                    f15970b = declaredMethod2;
                    declaredMethod2.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                }
                f15971c = true;
            }
            if (z) {
                try {
                    Method method2 = f15969a;
                    if (method2 != null) {
                        method2.invoke(canvas, (Object[]) null);
                    }
                } catch (IllegalAccessException unused2) {
                    return;
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException(e2.getCause());
                }
            }
            if (!z && (method = f15970b) != null) {
                method.invoke(canvas, (Object[]) null);
            }
        } else {
            throw new IllegalStateException("This method doesn't work on Pie!");
        }
    }
}
