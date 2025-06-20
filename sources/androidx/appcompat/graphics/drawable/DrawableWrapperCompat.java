package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;

public class DrawableWrapperCompat extends Drawable implements Drawable.Callback {
    private Drawable s;

    public DrawableWrapperCompat(Drawable drawable) {
        b(drawable);
    }

    @Nullable
    public Drawable a() {
        return this.s;
    }

    public void b(@Nullable Drawable drawable) {
        Drawable drawable2 = this.s;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.s = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public void draw(@NonNull Canvas canvas) {
        this.s.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.s.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.s.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.s.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.s.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.s.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.s.getMinimumWidth();
    }

    public int getOpacity() {
        return this.s.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.s.getPadding(rect);
    }

    public int[] getState() {
        return this.s.getState();
    }

    public Region getTransparentRegion() {
        return this.s.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return DrawableCompat.h(this.s);
    }

    public boolean isStateful() {
        return this.s.isStateful();
    }

    public void jumpToCurrentState() {
        this.s.jumpToCurrentState();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.s.setBounds(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        return this.s.setLevel(i2);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    public void setAlpha(int i2) {
        this.s.setAlpha(i2);
    }

    public void setAutoMirrored(boolean z) {
        DrawableCompat.j(this.s, z);
    }

    public void setChangingConfigurations(int i2) {
        this.s.setChangingConfigurations(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.s.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.s.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.s.setFilterBitmap(z);
    }

    public void setHotspot(float f2, float f3) {
        DrawableCompat.k(this.s, f2, f3);
    }

    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        DrawableCompat.l(this.s, i2, i3, i4, i5);
    }

    public boolean setState(int[] iArr) {
        return this.s.setState(iArr);
    }

    public void setTint(int i2) {
        DrawableCompat.n(this.s, i2);
    }

    public void setTintList(ColorStateList colorStateList) {
        DrawableCompat.o(this.s, colorStateList);
    }

    public void setTintMode(PorterDuff.Mode mode) {
        DrawableCompat.p(this.s, mode);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.s.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
