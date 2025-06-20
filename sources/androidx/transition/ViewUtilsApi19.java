package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ViewUtilsApi19 {

    /* renamed from: b  reason: collision with root package name */
    private static final String f16114b = "ViewUtilsApi19";

    /* renamed from: c  reason: collision with root package name */
    private static boolean f16115c = true;

    /* renamed from: d  reason: collision with root package name */
    private static Method f16116d = null;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f16117e = false;

    /* renamed from: f  reason: collision with root package name */
    private static Field f16118f = null;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f16119g = false;

    /* renamed from: h  reason: collision with root package name */
    private static final int f16120h = 12;

    /* renamed from: a  reason: collision with root package name */
    private float[] f16121a;

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static float a(View view) {
            return view.getTransitionAlpha();
        }

        @DoNotInline
        static void b(View view, float f2) {
            view.setTransitionAlpha(f2);
        }
    }

    ViewUtilsApi19() {
    }

    @SuppressLint({"PrivateApi", "SoonBlockedPrivateApi"})
    private void b() {
        if (!f16117e) {
            Class<View> cls = View.class;
            try {
                Class cls2 = Integer.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("setFrame", new Class[]{cls2, cls2, cls2, cls2});
                f16116d = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i(f16114b, "Failed to retrieve setFrame method", e2);
            }
            f16117e = true;
        }
    }

    public void a(@NonNull View view) {
    }

    @SuppressLint({"NewApi"})
    public float c(@NonNull View view) {
        if (f16115c) {
            try {
                return Api29Impl.a(view);
            } catch (NoSuchMethodError unused) {
                f16115c = false;
            }
        }
        return view.getAlpha();
    }

    public void d(@NonNull View view) {
    }

    public void e(@NonNull View view, @Nullable Matrix matrix) {
        if (matrix == null || matrix.isIdentity()) {
            view.setPivotX((float) (view.getWidth() / 2));
            view.setPivotY((float) (view.getHeight() / 2));
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setRotation(0.0f);
            return;
        }
        float[] fArr = this.f16121a;
        if (fArr == null) {
            fArr = new float[9];
            this.f16121a = fArr;
        }
        matrix.getValues(fArr);
        float f2 = fArr[3];
        float sqrt = ((float) Math.sqrt((double) (1.0f - (f2 * f2)))) * ((float) (fArr[0] < 0.0f ? -1 : 1));
        float degrees = (float) Math.toDegrees(Math.atan2((double) f2, (double) sqrt));
        float f3 = fArr[0] / sqrt;
        float f4 = fArr[4] / sqrt;
        float f5 = fArr[2];
        float f6 = fArr[5];
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setTranslationX(f5);
        view.setTranslationY(f6);
        view.setRotation(degrees);
        view.setScaleX(f3);
        view.setScaleY(f4);
    }

    @SuppressLint({"BanUncheckedReflection"})
    public void f(@NonNull View view, int i2, int i3, int i4, int i5) {
        b();
        Method method = f16116d;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void g(@NonNull View view, float f2) {
        if (f16115c) {
            try {
                Api29Impl.b(view, f2);
                return;
            } catch (NoSuchMethodError unused) {
                f16115c = false;
            }
        }
        view.setAlpha(f2);
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public void h(@NonNull View view, int i2) {
        if (!f16119g) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f16118f = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i(f16114b, "fetchViewFlagsField: ");
            }
            f16119g = true;
        }
        Field field = f16118f;
        if (field != null) {
            try {
                f16118f.setInt(view, i2 | (field.getInt(view) & -13));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public void i(@NonNull View view, @NonNull Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            i(view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            matrix.preConcat(matrix2);
        }
    }

    public void j(@NonNull View view, @NonNull Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            j(view2, matrix);
            matrix.postTranslate((float) view2.getScrollX(), (float) view2.getScrollY());
        }
        matrix.postTranslate((float) (-view.getLeft()), (float) (-view.getTop()));
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            Matrix matrix3 = new Matrix();
            if (matrix2.invert(matrix3)) {
                matrix.postConcat(matrix3);
            }
        }
    }
}
