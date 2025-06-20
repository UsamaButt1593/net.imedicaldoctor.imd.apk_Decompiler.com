package com.bumptech.glide.request.target;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.util.Preconditions;

public class FixedSizeDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f18478a;

    /* renamed from: b  reason: collision with root package name */
    private final RectF f18479b;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f18480c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f18481d;

    /* renamed from: e  reason: collision with root package name */
    private State f18482e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f18483f;

    static final class State extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f18484a;

        /* renamed from: b  reason: collision with root package name */
        final int f18485b;

        /* renamed from: c  reason: collision with root package name */
        final int f18486c;

        State(Drawable.ConstantState constantState, int i2, int i3) {
            this.f18484a = constantState;
            this.f18485b = i2;
            this.f18486c = i3;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        @NonNull
        public Drawable newDrawable() {
            return new FixedSizeDrawable(this, this.f18484a.newDrawable());
        }

        State(State state) {
            this(state.f18484a, state.f18485b, state.f18486c);
        }

        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new FixedSizeDrawable(this, this.f18484a.newDrawable(resources));
        }
    }

    public FixedSizeDrawable(Drawable drawable, int i2, int i3) {
        this(new State(drawable.getConstantState(), i2, i3), drawable);
    }

    private void a() {
        this.f18478a.setRectToRect(this.f18479b, this.f18480c, Matrix.ScaleToFit.CENTER);
    }

    public void clearColorFilter() {
        this.f18481d.clearColorFilter();
    }

    public void draw(@NonNull Canvas canvas) {
        canvas.save();
        canvas.concat(this.f18478a);
        this.f18481d.draw(canvas);
        canvas.restore();
    }

    @RequiresApi(19)
    public int getAlpha() {
        return this.f18481d.getAlpha();
    }

    public Drawable.Callback getCallback() {
        return this.f18481d.getCallback();
    }

    public int getChangingConfigurations() {
        return this.f18481d.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        return this.f18482e;
    }

    @NonNull
    public Drawable getCurrent() {
        return this.f18481d.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f18482e.f18486c;
    }

    public int getIntrinsicWidth() {
        return this.f18482e.f18485b;
    }

    public int getMinimumHeight() {
        return this.f18481d.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f18481d.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f18481d.getOpacity();
    }

    public boolean getPadding(@NonNull Rect rect) {
        return this.f18481d.getPadding(rect);
    }

    public void invalidateSelf() {
        super.invalidateSelf();
        this.f18481d.invalidateSelf();
    }

    @NonNull
    public Drawable mutate() {
        if (!this.f18483f && super.mutate() == this) {
            this.f18481d = this.f18481d.mutate();
            this.f18482e = new State(this.f18482e);
            this.f18483f = true;
        }
        return this;
    }

    public void scheduleSelf(@NonNull Runnable runnable, long j2) {
        super.scheduleSelf(runnable, j2);
        this.f18481d.scheduleSelf(runnable, j2);
    }

    public void setAlpha(int i2) {
        this.f18481d.setAlpha(i2);
    }

    public void setBounds(int i2, int i3, int i4, int i5) {
        super.setBounds(i2, i3, i4, i5);
        this.f18480c.set((float) i2, (float) i3, (float) i4, (float) i5);
        a();
    }

    public void setChangingConfigurations(int i2) {
        this.f18481d.setChangingConfigurations(i2);
    }

    public void setColorFilter(int i2, @NonNull PorterDuff.Mode mode) {
        this.f18481d.setColorFilter(i2, mode);
    }

    @Deprecated
    public void setDither(boolean z) {
        this.f18481d.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f18481d.setFilterBitmap(z);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return this.f18481d.setVisible(z, z2);
    }

    public void unscheduleSelf(@NonNull Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.f18481d.unscheduleSelf(runnable);
    }

    FixedSizeDrawable(State state, Drawable drawable) {
        this.f18482e = (State) Preconditions.d(state);
        this.f18481d = (Drawable) Preconditions.d(drawable);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f18478a = new Matrix();
        this.f18479b = new RectF(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        this.f18480c = new RectF();
    }

    public void setBounds(@NonNull Rect rect) {
        super.setBounds(rect);
        this.f18480c.set(rect);
        a();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f18481d.setColorFilter(colorFilter);
    }
}
