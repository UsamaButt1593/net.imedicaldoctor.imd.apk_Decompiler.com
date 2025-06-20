package androidx.core.view;

import android.view.ScaleGestureDetector;
import androidx.annotation.NonNull;

public final class ScaleGestureDetectorCompat {
    private ScaleGestureDetectorCompat() {
    }

    public static boolean a(@NonNull ScaleGestureDetector scaleGestureDetector) {
        return scaleGestureDetector.isQuickScaleEnabled();
    }

    @Deprecated
    public static boolean b(Object obj) {
        return a((ScaleGestureDetector) obj);
    }

    public static void c(@NonNull ScaleGestureDetector scaleGestureDetector, boolean z) {
        scaleGestureDetector.setQuickScaleEnabled(z);
    }

    @Deprecated
    public static void d(Object obj, boolean z) {
        c((ScaleGestureDetector) obj, z);
    }
}
