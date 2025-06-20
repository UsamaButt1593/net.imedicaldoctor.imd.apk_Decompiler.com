package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

class ScrollbarHelper {
    private ScrollbarHelper() {
    }

    static int a(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z) {
        if (layoutManager.V() == 0 || state.d() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(layoutManager.w0(view) - layoutManager.w0(view2)) + 1;
        }
        return Math.min(orientationHelper.o(), orientationHelper.d(view2) - orientationHelper.g(view));
    }

    static int b(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z, boolean z2) {
        if (layoutManager.V() == 0 || state.d() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? Math.max(0, (state.d() - Math.max(layoutManager.w0(view), layoutManager.w0(view2))) - 1) : Math.max(0, Math.min(layoutManager.w0(view), layoutManager.w0(view2)));
        if (!z) {
            return max;
        }
        return Math.round((((float) max) * (((float) Math.abs(orientationHelper.d(view2) - orientationHelper.g(view))) / ((float) (Math.abs(layoutManager.w0(view) - layoutManager.w0(view2)) + 1)))) + ((float) (orientationHelper.n() - orientationHelper.g(view))));
    }

    static int c(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z) {
        if (layoutManager.V() == 0 || state.d() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return state.d();
        }
        return (int) ((((float) (orientationHelper.d(view2) - orientationHelper.g(view))) / ((float) (Math.abs(layoutManager.w0(view) - layoutManager.w0(view2)) + 1))) * ((float) state.d()));
    }
}
