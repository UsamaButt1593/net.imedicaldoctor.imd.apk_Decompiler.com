package com.google.android.material.imageview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.R;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.Shapeable;

public class ShapeableImageView extends AppCompatImageView implements Shapeable {
    private static final int r3 = R.style.Xj;
    private static final int s3 = Integer.MIN_VALUE;
    private final ShapeAppearancePathProvider Z2;
    /* access modifiers changed from: private */
    public final RectF a3;
    private final RectF b3;
    private final Paint c3;
    private final Paint d3;
    private final Path e3;
    @Nullable
    private ColorStateList f3;
    /* access modifiers changed from: private */
    @Nullable
    public MaterialShapeDrawable g3;
    /* access modifiers changed from: private */
    public ShapeAppearanceModel h3;
    @Dimension
    private float i3;
    private Path j3;
    @Dimension
    private int k3;
    @Dimension
    private int l3;
    @Dimension
    private int m3;
    @Dimension
    private int n3;
    @Dimension
    private int o3;
    @Dimension
    private int p3;
    private boolean q3;

    @TargetApi(21)
    class OutlineProvider extends ViewOutlineProvider {

        /* renamed from: a  reason: collision with root package name */
        private final Rect f21480a = new Rect();

        OutlineProvider() {
        }

        public void getOutline(View view, Outline outline) {
            if (ShapeableImageView.this.h3 != null) {
                if (ShapeableImageView.this.g3 == null) {
                    MaterialShapeDrawable unused = ShapeableImageView.this.g3 = new MaterialShapeDrawable(ShapeableImageView.this.h3);
                }
                ShapeableImageView.this.a3.round(this.f21480a);
                ShapeableImageView.this.g3.setBounds(this.f21480a);
                ShapeableImageView.this.g3.getOutline(outline);
            }
        }
    }

    public ShapeableImageView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    private void g(Canvas canvas) {
        if (this.f3 != null) {
            this.c3.setStrokeWidth(this.i3);
            int colorForState = this.f3.getColorForState(getDrawableState(), this.f3.getDefaultColor());
            if (this.i3 > 0.0f && colorForState != 0) {
                this.c3.setColor(colorForState);
                canvas.drawPath(this.e3, this.c3);
            }
        }
    }

    private boolean h() {
        return (this.o3 == Integer.MIN_VALUE && this.p3 == Integer.MIN_VALUE) ? false : true;
    }

    private boolean i() {
        return getLayoutDirection() == 1;
    }

    private void l(int i2, int i4) {
        this.a3.set((float) getPaddingLeft(), (float) getPaddingTop(), (float) (i2 - getPaddingRight()), (float) (i4 - getPaddingBottom()));
        this.Z2.d(this.h3, 1.0f, this.a3, this.e3);
        this.j3.rewind();
        this.j3.addPath(this.e3);
        this.b3.set(0.0f, 0.0f, (float) i2, (float) i4);
        this.j3.addRect(this.b3, Path.Direction.CCW);
    }

    @Dimension
    public int getContentPaddingBottom() {
        return this.n3;
    }

    @Dimension
    public final int getContentPaddingEnd() {
        int i2 = this.p3;
        return i2 != Integer.MIN_VALUE ? i2 : i() ? this.k3 : this.m3;
    }

    @Dimension
    public int getContentPaddingLeft() {
        int i2;
        int i4;
        if (h()) {
            if (i() && (i4 = this.p3) != Integer.MIN_VALUE) {
                return i4;
            }
            if (!i() && (i2 = this.o3) != Integer.MIN_VALUE) {
                return i2;
            }
        }
        return this.k3;
    }

    @Dimension
    public int getContentPaddingRight() {
        int i2;
        int i4;
        if (h()) {
            if (i() && (i4 = this.o3) != Integer.MIN_VALUE) {
                return i4;
            }
            if (!i() && (i2 = this.p3) != Integer.MIN_VALUE) {
                return i2;
            }
        }
        return this.m3;
    }

    @Dimension
    public final int getContentPaddingStart() {
        int i2 = this.o3;
        return i2 != Integer.MIN_VALUE ? i2 : i() ? this.m3 : this.k3;
    }

    @Dimension
    public int getContentPaddingTop() {
        return this.l3;
    }

    @Dimension
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Dimension
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Dimension
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Dimension
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Dimension
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Dimension
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.h3;
    }

    @Nullable
    public ColorStateList getStrokeColor() {
        return this.f3;
    }

    @Dimension
    public float getStrokeWidth() {
        return this.i3;
    }

    public void j(@Dimension int i2, @Dimension int i4, @Dimension int i5, @Dimension int i6) {
        this.o3 = Integer.MIN_VALUE;
        this.p3 = Integer.MIN_VALUE;
        super.setPadding((super.getPaddingLeft() - this.k3) + i2, (super.getPaddingTop() - this.l3) + i4, (super.getPaddingRight() - this.m3) + i5, (super.getPaddingBottom() - this.n3) + i6);
        this.k3 = i2;
        this.l3 = i4;
        this.m3 = i5;
        this.n3 = i6;
    }

    @RequiresApi(17)
    public void k(@Dimension int i2, @Dimension int i4, @Dimension int i5, @Dimension int i6) {
        super.setPaddingRelative((super.getPaddingStart() - getContentPaddingStart()) + i2, (super.getPaddingTop() - this.l3) + i4, (super.getPaddingEnd() - getContentPaddingEnd()) + i5, (super.getPaddingBottom() - this.n3) + i6);
        this.k3 = i() ? i5 : i2;
        this.l3 = i4;
        if (!i()) {
            i2 = i5;
        }
        this.m3 = i2;
        this.n3 = i6;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.j3, this.d3);
        g(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i4) {
        super.onMeasure(i2, i4);
        if (!this.q3 && isLayoutDirectionResolved()) {
            this.q3 = true;
            if (isPaddingRelative() || h()) {
                setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
            } else {
                setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i4, int i5, int i6) {
        super.onSizeChanged(i2, i4, i5, i6);
        l(i2, i4);
    }

    public void setPadding(@Dimension int i2, @Dimension int i4, @Dimension int i5, @Dimension int i6) {
        super.setPadding(i2 + getContentPaddingLeft(), i4 + getContentPaddingTop(), i5 + getContentPaddingRight(), i6 + getContentPaddingBottom());
    }

    public void setPaddingRelative(@Dimension int i2, @Dimension int i4, @Dimension int i5, @Dimension int i6) {
        super.setPaddingRelative(i2 + getContentPaddingStart(), i4 + getContentPaddingTop(), i5 + getContentPaddingEnd(), i6 + getContentPaddingBottom());
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.h3 = shapeAppearanceModel;
        MaterialShapeDrawable materialShapeDrawable = this.g3;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        l(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(@Nullable ColorStateList colorStateList) {
        this.f3 = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(@ColorRes int i2) {
        setStrokeColor(AppCompatResources.a(getContext(), i2));
    }

    public void setStrokeWidth(@Dimension float f2) {
        if (this.i3 != f2) {
            this.i3 = f2;
            invalidate();
        }
    }

    public void setStrokeWidthResource(@DimenRes int i2) {
        setStrokeWidth((float) getResources().getDimensionPixelSize(i2));
    }

    public ShapeableImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ShapeableImageView(android.content.Context r7, @androidx.annotation.Nullable android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r0 = r3
            android.content.Context r7 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r7, r8, r9, r0)
            r6.<init>(r7, r8, r9)
            com.google.android.material.shape.ShapeAppearancePathProvider r7 = com.google.android.material.shape.ShapeAppearancePathProvider.k()
            r6.Z2 = r7
            android.graphics.Path r7 = new android.graphics.Path
            r7.<init>()
            r6.e3 = r7
            r7 = 0
            r6.q3 = r7
            android.content.Context r1 = r6.getContext()
            android.graphics.Paint r2 = new android.graphics.Paint
            r2.<init>()
            r6.d3 = r2
            r3 = 1
            r2.setAntiAlias(r3)
            r4 = -1
            r2.setColor(r4)
            android.graphics.PorterDuffXfermode r4 = new android.graphics.PorterDuffXfermode
            android.graphics.PorterDuff$Mode r5 = android.graphics.PorterDuff.Mode.DST_OUT
            r4.<init>(r5)
            r2.setXfermode(r4)
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r6.a3 = r2
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r6.b3 = r2
            android.graphics.Path r2 = new android.graphics.Path
            r2.<init>()
            r6.j3 = r2
            int[] r2 = com.google.android.material.R.styleable.tt
            android.content.res.TypedArray r2 = r1.obtainStyledAttributes(r8, r2, r9, r0)
            r4 = 2
            r5 = 0
            r6.setLayerType(r4, r5)
            int r4 = com.google.android.material.R.styleable.Dt
            android.content.res.ColorStateList r4 = com.google.android.material.resources.MaterialResources.a(r1, r2, r4)
            r6.f3 = r4
            int r4 = com.google.android.material.R.styleable.Et
            int r4 = r2.getDimensionPixelSize(r4, r7)
            float r4 = (float) r4
            r6.i3 = r4
            int r4 = com.google.android.material.R.styleable.ut
            int r7 = r2.getDimensionPixelSize(r4, r7)
            r6.k3 = r7
            r6.l3 = r7
            r6.m3 = r7
            r6.n3 = r7
            int r4 = com.google.android.material.R.styleable.xt
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.k3 = r4
            int r4 = com.google.android.material.R.styleable.At
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.l3 = r4
            int r4 = com.google.android.material.R.styleable.yt
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.m3 = r4
            int r4 = com.google.android.material.R.styleable.vt
            int r7 = r2.getDimensionPixelSize(r4, r7)
            r6.n3 = r7
            int r7 = com.google.android.material.R.styleable.zt
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            int r7 = r2.getDimensionPixelSize(r7, r4)
            r6.o3 = r7
            int r7 = com.google.android.material.R.styleable.wt
            int r7 = r2.getDimensionPixelSize(r7, r4)
            r6.p3 = r7
            r2.recycle()
            android.graphics.Paint r7 = new android.graphics.Paint
            r7.<init>()
            r6.c3 = r7
            android.graphics.Paint$Style r2 = android.graphics.Paint.Style.STROKE
            r7.setStyle(r2)
            r7.setAntiAlias(r3)
            com.google.android.material.shape.ShapeAppearanceModel$Builder r7 = com.google.android.material.shape.ShapeAppearanceModel.e(r1, r8, r9, r0)
            com.google.android.material.shape.ShapeAppearanceModel r7 = r7.m()
            r6.h3 = r7
            com.google.android.material.imageview.ShapeableImageView$OutlineProvider r7 = new com.google.android.material.imageview.ShapeableImageView$OutlineProvider
            r7.<init>()
            r6.setOutlineProvider(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.imageview.ShapeableImageView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
