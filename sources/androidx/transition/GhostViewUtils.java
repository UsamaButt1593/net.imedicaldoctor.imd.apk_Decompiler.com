package androidx.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class GhostViewUtils {
    private GhostViewUtils() {
    }

    @Nullable
    static GhostView a(@NonNull View view, @NonNull ViewGroup viewGroup, @Nullable Matrix matrix) {
        return Build.VERSION.SDK_INT == 28 ? GhostViewPlatform.b(view, viewGroup, matrix) : GhostViewPort.b(view, viewGroup, matrix);
    }

    static void b(View view) {
        if (Build.VERSION.SDK_INT == 28) {
            GhostViewPlatform.f(view);
        } else {
            GhostViewPort.f(view);
        }
    }
}
