package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

@RequiresApi(21)
class WrappedDrawableApi21 extends WrappedDrawableApi14 {
    private static final String a3 = "WrappedDrawableApi21";
    private static Method b3;

    WrappedDrawableApi21(Drawable drawable) {
        super(drawable);
        g();
    }

    private void g() {
        if (b3 == null) {
            try {
                b3 = Drawable.class.getDeclaredMethod("isProjected", (Class[]) null);
            } catch (Exception e2) {
                Log.w(a3, "Failed to retrieve Drawable#isProjected() method", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.Y2;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
    }

    @NonNull
    public Rect getDirtyBounds() {
        return this.Y2.getDirtyBounds();
    }

    public void getOutline(@NonNull Outline outline) {
        this.Y2.getOutline(outline);
    }

    public boolean isProjected() {
        Method method;
        Drawable drawable = this.Y2;
        if (drawable == null || (method = b3) == null) {
            return false;
        }
        try {
            return ((Boolean) method.invoke(drawable, (Object[]) null)).booleanValue();
        } catch (Exception e2) {
            Log.w(a3, "Error calling Drawable#isProjected() method", e2);
            return false;
        }
    }

    public void setHotspot(float f2, float f3) {
        this.Y2.setHotspot(f2, f3);
    }

    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        this.Y2.setHotspotBounds(i2, i3, i4, i5);
    }

    public boolean setState(@NonNull int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    public void setTint(int i2) {
        if (c()) {
            super.setTint(i2);
        } else {
            this.Y2.setTint(i2);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (c()) {
            super.setTintList(colorStateList);
        } else {
            this.Y2.setTintList(colorStateList);
        }
    }

    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        if (c()) {
            super.setTintMode(mode);
        } else {
            this.Y2.setTintMode(mode);
        }
    }

    WrappedDrawableApi21(WrappedDrawableState wrappedDrawableState, Resources resources) {
        super(wrappedDrawableState, resources);
        g();
    }
}
