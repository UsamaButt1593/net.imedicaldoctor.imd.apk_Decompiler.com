package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(23)
class ViewUtilsApi23 extends ViewUtilsApi22 {

    /* renamed from: m  reason: collision with root package name */
    private static boolean f16126m = true;

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void a(View view, int i2) {
            view.setTransitionVisibility(i2);
        }
    }

    ViewUtilsApi23() {
    }

    @SuppressLint({"NewApi"})
    public void h(@NonNull View view, int i2) {
        if (Build.VERSION.SDK_INT == 28) {
            super.h(view, i2);
        } else if (f16126m) {
            try {
                Api29Impl.a(view, i2);
            } catch (NoSuchMethodError unused) {
                f16126m = false;
            }
        }
    }
}
