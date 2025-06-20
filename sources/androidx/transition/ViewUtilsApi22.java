package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(22)
class ViewUtilsApi22 extends ViewUtilsApi21 {

    /* renamed from: l  reason: collision with root package name */
    private static boolean f16125l = true;

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void a(View view, int i2, int i3, int i4, int i5) {
            view.setLeftTopRightBottom(i2, i3, i4, i5);
        }
    }

    ViewUtilsApi22() {
    }

    @SuppressLint({"NewApi"})
    public void f(@NonNull View view, int i2, int i3, int i4, int i5) {
        if (f16125l) {
            try {
                Api29Impl.a(view, i2, i3, i4, i5);
            } catch (NoSuchMethodError unused) {
                f16125l = false;
            }
        }
    }
}
