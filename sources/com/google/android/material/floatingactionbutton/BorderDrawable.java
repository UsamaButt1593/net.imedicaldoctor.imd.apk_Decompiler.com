package com.google.android.material.floatingactionbutton;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class BorderDrawable extends Drawable {
    private static final float q = 1.3333f;

    /* renamed from: a  reason: collision with root package name */
    private final ShapeAppearancePathProvider f21430a = ShapeAppearancePathProvider.k();
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Paint f21431b;

    /* renamed from: c  reason: collision with root package name */
    private final Path f21432c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final Rect f21433d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    private final RectF f21434e = new RectF();

    /* renamed from: f  reason: collision with root package name */
    private final RectF f21435f = new RectF();

    /* renamed from: g  reason: collision with root package name */
    private final BorderState f21436g = new BorderState();
    @Dimension

    /* renamed from: h  reason: collision with root package name */
    float f21437h;
    @ColorInt

    /* renamed from: i  reason: collision with root package name */
    private int f21438i;
    @ColorInt

    /* renamed from: j  reason: collision with root package name */
    private int f21439j;
    @ColorInt

    /* renamed from: k  reason: collision with root package name */
    private int f21440k;
    @ColorInt

    /* renamed from: l  reason: collision with root package name */
    private int f21441l;
    @ColorInt

    /* renamed from: m  reason: collision with root package name */
    private int f21442m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f21443n = true;
    private ShapeAppearanceModel o;
    @Nullable
    private ColorStateList p;

    private class BorderState extends Drawable.ConstantState {
        private BorderState() {
        }

        public int getChangingConfigurations() {
            return 0;
        }

        @NonNull
        public Drawable newDrawable() {
            return BorderDrawable.this;
        }
    }

    BorderDrawable(ShapeAppearanceModel shapeAppearanceModel) {
        this.o = shapeAppearanceModel;
        Paint paint = new Paint(1);
        this.f21431b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    @NonNull
    private Shader a() {
        Rect rect = this.f21433d;
        copyBounds(rect);
        float height = this.f21437h / ((float) rect.height());
        return new LinearGradient(0.0f, (float) rect.top, 0.0f, (float) rect.bottom, new int[]{ColorUtils.v(this.f21438i, this.f21442m), ColorUtils.v(this.f21439j, this.f21442m), ColorUtils.v(ColorUtils.D(this.f21439j, 0), this.f21442m), ColorUtils.v(ColorUtils.D(this.f21441l, 0), this.f21442m), ColorUtils.v(this.f21441l, this.f21442m), ColorUtils.v(this.f21440k, this.f21442m)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public RectF b() {
        this.f21435f.set(getBounds());
        return this.f21435f;
    }

    public ShapeAppearanceModel c() {
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public void d(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f21442m = colorStateList.getColorForState(getState(), this.f21442m);
        }
        this.p = colorStateList;
        this.f21443n = true;
        invalidateSelf();
    }

    public void draw(@NonNull Canvas canvas) {
        if (this.f21443n) {
            this.f21431b.setShader(a());
            this.f21443n = false;
        }
        float strokeWidth = this.f21431b.getStrokeWidth() / 2.0f;
        copyBounds(this.f21433d);
        this.f21434e.set(this.f21433d);
        float min = Math.min(this.o.r().a(b()), this.f21434e.width() / 2.0f);
        if (this.o.u(b())) {
            this.f21434e.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.f21434e, min, min, this.f21431b);
        }
    }

    public void e(@Dimension float f2) {
        if (this.f21437h != f2) {
            this.f21437h = f2;
            this.f21431b.setStrokeWidth(f2 * q);
            this.f21443n = true;
            invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public void f(@ColorInt int i2, @ColorInt int i3, @ColorInt int i4, @ColorInt int i5) {
        this.f21438i = i2;
        this.f21439j = i3;
        this.f21440k = i4;
        this.f21441l = i5;
    }

    public void g(ShapeAppearanceModel shapeAppearanceModel) {
        this.o = shapeAppearanceModel;
        invalidateSelf();
    }

    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.f21436g;
    }

    public int getOpacity() {
        return this.f21437h > 0.0f ? -3 : -2;
    }

    @TargetApi(21)
    public void getOutline(@NonNull Outline outline) {
        if (this.o.u(b())) {
            outline.setRoundRect(getBounds(), this.o.r().a(b()));
            return;
        }
        copyBounds(this.f21433d);
        this.f21434e.set(this.f21433d);
        this.f21430a.d(this.o, 1.0f, this.f21434e, this.f21432c);
        DrawableUtils.l(outline, this.f21432c);
    }

    public boolean getPadding(@NonNull Rect rect) {
        if (!this.o.u(b())) {
            return true;
        }
        int round = Math.round(this.f21437h);
        rect.set(round, round, round, round);
        return true;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.p;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f21443n = true;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.p;
        if (!(colorStateList == null || (colorForState = colorStateList.getColorForState(iArr, this.f21442m)) == this.f21442m)) {
            this.f21443n = true;
            this.f21442m = colorForState;
        }
        if (this.f21443n) {
            invalidateSelf();
        }
        return this.f21443n;
    }

    public void setAlpha(@IntRange(from = 0, to = 255) int i2) {
        this.f21431b.setAlpha(i2);
        invalidateSelf();
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f21431b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
