package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;

abstract class VectorDrawableCommon extends Drawable implements TintAwareDrawable {
    Drawable s;

    VectorDrawableCommon() {
    }

    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.s;
        if (drawable != null) {
            DrawableCompat.a(drawable, theme);
        }
    }

    public void clearColorFilter() {
        Drawable drawable = this.s;
        if (drawable != null) {
            drawable.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public Drawable getCurrent() {
        Drawable drawable = this.s;
        return drawable != null ? drawable.getCurrent() : super.getCurrent();
    }

    public int getMinimumHeight() {
        Drawable drawable = this.s;
        return drawable != null ? drawable.getMinimumHeight() : super.getMinimumHeight();
    }

    public int getMinimumWidth() {
        Drawable drawable = this.s;
        return drawable != null ? drawable.getMinimumWidth() : super.getMinimumWidth();
    }

    public boolean getPadding(Rect rect) {
        Drawable drawable = this.s;
        return drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
    }

    public int[] getState() {
        Drawable drawable = this.s;
        return drawable != null ? drawable.getState() : super.getState();
    }

    public Region getTransparentRegion() {
        Drawable drawable = this.s;
        return drawable != null ? drawable.getTransparentRegion() : super.getTransparentRegion();
    }

    public void jumpToCurrentState() {
        Drawable drawable = this.s;
        if (drawable != null) {
            DrawableCompat.i(drawable);
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.s;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        Drawable drawable = this.s;
        return drawable != null ? drawable.setLevel(i2) : super.onLevelChange(i2);
    }

    public void setChangingConfigurations(int i2) {
        Drawable drawable = this.s;
        if (drawable != null) {
            drawable.setChangingConfigurations(i2);
        } else {
            super.setChangingConfigurations(i2);
        }
    }

    public void setColorFilter(int i2, PorterDuff.Mode mode) {
        Drawable drawable = this.s;
        if (drawable != null) {
            drawable.setColorFilter(i2, mode);
        } else {
            super.setColorFilter(i2, mode);
        }
    }

    public void setFilterBitmap(boolean z) {
        Drawable drawable = this.s;
        if (drawable != null) {
            drawable.setFilterBitmap(z);
        }
    }

    public void setHotspot(float f2, float f3) {
        Drawable drawable = this.s;
        if (drawable != null) {
            DrawableCompat.k(drawable, f2, f3);
        }
    }

    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        Drawable drawable = this.s;
        if (drawable != null) {
            DrawableCompat.l(drawable, i2, i3, i4, i5);
        }
    }

    public boolean setState(int[] iArr) {
        Drawable drawable = this.s;
        return drawable != null ? drawable.setState(iArr) : super.setState(iArr);
    }
}
