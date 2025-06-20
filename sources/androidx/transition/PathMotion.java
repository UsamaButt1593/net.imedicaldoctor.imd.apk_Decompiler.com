package androidx.transition;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.annotation.NonNull;

public abstract class PathMotion {
    public PathMotion() {
    }

    @NonNull
    public abstract Path a(float f2, float f3, float f4, float f5);

    public PathMotion(@NonNull Context context, @NonNull AttributeSet attributeSet) {
    }
}
