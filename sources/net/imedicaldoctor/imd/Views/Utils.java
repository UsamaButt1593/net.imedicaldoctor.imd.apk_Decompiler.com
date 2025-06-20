package net.imedicaldoctor.imd.Views;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;

public class Utils {
    public static int a(float f2, Resources resources) {
        return (int) TypedValue.applyDimension(1, f2, resources.getDisplayMetrics());
    }

    public static int b(View view) {
        return view.getId() == 16908290 ? view.getLeft() : view.getLeft() + b((View) view.getParent());
    }

    public static int c(View view) {
        return view.getId() == 16908290 ? view.getTop() : view.getTop() + c((View) view.getParent());
    }
}
