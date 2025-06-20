package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
class ViewUtilsApi21 extends ViewUtilsApi19 {

    /* renamed from: i  reason: collision with root package name */
    private static boolean f16122i = true;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f16123j = true;

    /* renamed from: k  reason: collision with root package name */
    private static boolean f16124k = true;

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void a(View view, Matrix matrix) {
            view.setAnimationMatrix(matrix);
        }

        @DoNotInline
        static void b(View view, Matrix matrix) {
            view.transformMatrixToGlobal(matrix);
        }

        @DoNotInline
        static void c(View view, Matrix matrix) {
            view.transformMatrixToLocal(matrix);
        }
    }

    ViewUtilsApi21() {
    }

    @SuppressLint({"NewApi"})
    public void e(@NonNull View view, @Nullable Matrix matrix) {
        if (f16122i) {
            try {
                Api29Impl.a(view, matrix);
            } catch (NoSuchMethodError unused) {
                f16122i = false;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void i(@NonNull View view, @NonNull Matrix matrix) {
        if (f16123j) {
            try {
                Api29Impl.b(view, matrix);
            } catch (NoSuchMethodError unused) {
                f16123j = false;
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void j(@NonNull View view, @NonNull Matrix matrix) {
        if (f16124k) {
            try {
                Api29Impl.c(view, matrix);
            } catch (NoSuchMethodError unused) {
                f16124k = false;
            }
        }
    }
}
