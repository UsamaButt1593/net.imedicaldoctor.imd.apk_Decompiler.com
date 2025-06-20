package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(21)
class GhostViewPlatform implements GhostView {
    private static final String X = "GhostViewApi21";
    private static Method X2;
    private static Class<?> Y;
    private static boolean Y2;
    private static boolean Z;
    private static Method Z2;
    private static boolean a3;
    private final View s;

    private GhostViewPlatform(@NonNull View view) {
        this.s = view;
    }

    @SuppressLint({"BanUncheckedReflection"})
    static GhostView b(View view, ViewGroup viewGroup, Matrix matrix) {
        c();
        Method method = X2;
        if (method != null) {
            try {
                return new GhostViewPlatform((View) method.invoke((Object) null, new Object[]{view, viewGroup, matrix}));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        return null;
    }

    private static void c() {
        if (!Y2) {
            try {
                d();
                Method declaredMethod = Y.getDeclaredMethod("addGhost", new Class[]{View.class, ViewGroup.class, Matrix.class});
                X2 = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i(X, "Failed to retrieve addGhost method", e2);
            }
            Y2 = true;
        }
    }

    private static void d() {
        if (!Z) {
            try {
                Y = Class.forName("android.view.GhostView");
            } catch (ClassNotFoundException e2) {
                Log.i(X, "Failed to retrieve GhostView class", e2);
            }
            Z = true;
        }
    }

    private static void e() {
        if (!a3) {
            try {
                d();
                Method declaredMethod = Y.getDeclaredMethod("removeGhost", new Class[]{View.class});
                Z2 = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i(X, "Failed to retrieve removeGhost method", e2);
            }
            a3 = true;
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    static void f(View view) {
        e();
        Method method = Z2;
        if (method != null) {
            try {
                method.invoke((Object) null, new Object[]{view});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    public void a(ViewGroup viewGroup, View view) {
    }

    public void setVisibility(int i2) {
        this.s.setVisibility(i2);
    }
}
