package net.imedicaldoctor.imd.Fragments;

import android.view.View;
import androidx.core.view.ViewCompat;

public class ViewUtils {
    public static boolean a(View view, int i2, int i3) {
        int B0 = (int) (ViewCompat.B0(view) + 0.5f);
        int C0 = (int) (ViewCompat.C0(view) + 0.5f);
        return i2 >= view.getLeft() + B0 && i2 <= view.getRight() + B0 && i3 >= view.getTop() + C0 && i3 <= view.getBottom() + C0;
    }
}
