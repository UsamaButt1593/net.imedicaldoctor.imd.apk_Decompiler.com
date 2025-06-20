package net.imedicaldoctor.imd.CollapsingToolbar;

import android.content.Context;
import android.content.res.TypedArray;
import net.imedicaldoctor.imd.R;

class ThemeUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f29508a = {R.attr.colorPrimary};

    ThemeUtils() {
    }

    static void a(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f29508a);
        boolean z = !obtainStyledAttributes.hasValue(0);
        obtainStyledAttributes.recycle();
        if (z) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
