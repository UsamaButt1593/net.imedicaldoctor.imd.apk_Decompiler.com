package com.google.android.material.shape;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.internal.ViewUtils;

public class MaterialShapeUtils {
    private MaterialShapeUtils() {
    }

    @NonNull
    static CornerTreatment a(int i2) {
        if (i2 != 0) {
            return i2 != 1 ? b() : new CutCornerTreatment();
        }
        return new RoundedCornerTreatment();
    }

    @NonNull
    static CornerTreatment b() {
        return new RoundedCornerTreatment();
    }

    @NonNull
    static EdgeTreatment c() {
        return new EdgeTreatment();
    }

    public static void d(@NonNull View view, float f2) {
        Drawable background = view.getBackground();
        if (background instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) background).o0(f2);
        }
    }

    public static void e(@NonNull View view) {
        Drawable background = view.getBackground();
        if (background instanceof MaterialShapeDrawable) {
            f(view, (MaterialShapeDrawable) background);
        }
    }

    public static void f(@NonNull View view, @NonNull MaterialShapeDrawable materialShapeDrawable) {
        if (materialShapeDrawable.c0()) {
            materialShapeDrawable.t0(ViewUtils.p(view));
        }
    }
}
