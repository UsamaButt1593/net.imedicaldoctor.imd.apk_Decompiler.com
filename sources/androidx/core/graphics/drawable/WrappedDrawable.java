package androidx.core.graphics.drawable;

import android.graphics.drawable.Drawable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface WrappedDrawable {
    void a(Drawable drawable);

    Drawable b();
}
