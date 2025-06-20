package androidx.appcompat.widget;

import android.graphics.Rect;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface FitWindowsViewGroup {

    public interface OnFitSystemWindowsListener {
        void a(Rect rect);
    }

    void setOnFitSystemWindowsListener(OnFitSystemWindowsListener onFitSystemWindowsListener);
}
