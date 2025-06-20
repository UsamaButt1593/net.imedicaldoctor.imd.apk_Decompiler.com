package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

class WrappedDrawableApi14 extends Drawable implements Drawable.Callback, WrappedDrawable, TintAwareDrawable {
    static final PorterDuff.Mode Z2 = PorterDuff.Mode.SRC_IN;
    private PorterDuff.Mode X;
    private boolean X2;
    private boolean Y;
    Drawable Y2;
    WrappedDrawableState Z;
    private int s;

    WrappedDrawableApi14(@Nullable Drawable drawable) {
        this.Z = d();
        a(drawable);
    }

    @NonNull
    private WrappedDrawableState d() {
        return new WrappedDrawableState(this.Z);
    }

    private void e(@Nullable Resources resources) {
        Drawable.ConstantState constantState;
        WrappedDrawableState wrappedDrawableState = this.Z;
        if (wrappedDrawableState != null && (constantState = wrappedDrawableState.f5928b) != null) {
            a(constantState.newDrawable(resources));
        }
    }

    private boolean f(int[] iArr) {
        if (!c()) {
            return false;
        }
        WrappedDrawableState wrappedDrawableState = this.Z;
        ColorStateList colorStateList = wrappedDrawableState.f5929c;
        PorterDuff.Mode mode = wrappedDrawableState.f5930d;
        if (colorStateList == null || mode == null) {
            this.Y = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!(this.Y && colorForState == this.s && mode == this.X)) {
                setColorFilter(colorForState, mode);
                this.s = colorForState;
                this.X = mode;
                this.Y = true;
                return true;
            }
        }
        return false;
    }

    public final void a(Drawable drawable) {
        Drawable drawable2 = this.Y2;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.Y2 = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            WrappedDrawableState wrappedDrawableState = this.Z;
            if (wrappedDrawableState != null) {
                wrappedDrawableState.f5928b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    public final Drawable b() {
        return this.Y2;
    }

    /* access modifiers changed from: protected */
    public boolean c() {
        return true;
    }

    public void draw(@NonNull Canvas canvas) {
        this.Y2.draw(canvas);
    }

    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        WrappedDrawableState wrappedDrawableState = this.Z;
        return changingConfigurations | (wrappedDrawableState != null ? wrappedDrawableState.getChangingConfigurations() : 0) | this.Y2.getChangingConfigurations();
    }

    @Nullable
    public Drawable.ConstantState getConstantState() {
        WrappedDrawableState wrappedDrawableState = this.Z;
        if (wrappedDrawableState == null || !wrappedDrawableState.a()) {
            return null;
        }
        this.Z.f5927a = getChangingConfigurations();
        return this.Z;
    }

    @NonNull
    public Drawable getCurrent() {
        return this.Y2.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.Y2.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.Y2.getIntrinsicWidth();
    }

    @RequiresApi(23)
    public int getLayoutDirection() {
        return DrawableCompat.f(this.Y2);
    }

    public int getMinimumHeight() {
        return this.Y2.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.Y2.getMinimumWidth();
    }

    public int getOpacity() {
        return this.Y2.getOpacity();
    }

    public boolean getPadding(@NonNull Rect rect) {
        return this.Y2.getPadding(rect);
    }

    @NonNull
    public int[] getState() {
        return this.Y2.getState();
    }

    public Region getTransparentRegion() {
        return this.Y2.getTransparentRegion();
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return DrawableCompat.h(this.Y2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r1.Z;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            boolean r0 = r1.c()
            if (r0 == 0) goto L_0x000d
            androidx.core.graphics.drawable.WrappedDrawableState r0 = r1.Z
            if (r0 == 0) goto L_0x000d
            android.content.res.ColorStateList r0 = r0.f5929c
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            if (r0 == 0) goto L_0x0016
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x001e
        L_0x0016:
            android.graphics.drawable.Drawable r0 = r1.Y2
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0020
        L_0x001e:
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.WrappedDrawableApi14.isStateful():boolean");
    }

    public void jumpToCurrentState() {
        this.Y2.jumpToCurrentState();
    }

    @NonNull
    public Drawable mutate() {
        if (!this.X2 && super.mutate() == this) {
            this.Z = d();
            Drawable drawable = this.Y2;
            if (drawable != null) {
                drawable.mutate();
            }
            WrappedDrawableState wrappedDrawableState = this.Z;
            if (wrappedDrawableState != null) {
                Drawable drawable2 = this.Y2;
                wrappedDrawableState.f5928b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.X2 = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.Y2;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @RequiresApi(23)
    public boolean onLayoutDirectionChanged(int i2) {
        return DrawableCompat.m(this.Y2, i2);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        return this.Y2.setLevel(i2);
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    public void setAlpha(int i2) {
        this.Y2.setAlpha(i2);
    }

    public void setAutoMirrored(boolean z) {
        DrawableCompat.j(this.Y2, z);
    }

    public void setChangingConfigurations(int i2) {
        this.Y2.setChangingConfigurations(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.Y2.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.Y2.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.Y2.setFilterBitmap(z);
    }

    public boolean setState(@NonNull int[] iArr) {
        return f(iArr) || this.Y2.setState(iArr);
    }

    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.Z.f5929c = colorStateList;
        f(getState());
    }

    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        this.Z.f5930d = mode;
        f(getState());
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.Y2.setVisible(z, z2);
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        unscheduleSelf(runnable);
    }

    WrappedDrawableApi14(@NonNull WrappedDrawableState wrappedDrawableState, @Nullable Resources resources) {
        this.Z = wrappedDrawableState;
        e(resources);
    }
}
