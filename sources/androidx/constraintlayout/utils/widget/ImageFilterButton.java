package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.R;

public class ImageFilterButton extends AppCompatImageButton {
    private ImageFilterView.ImageMatrix Z2 = new ImageFilterView.ImageMatrix();
    private float a3 = 0.0f;
    /* access modifiers changed from: private */
    public float b3 = 0.0f;
    /* access modifiers changed from: private */
    public float c3 = Float.NaN;
    private Path d3;
    ViewOutlineProvider e3;
    RectF f3;
    Drawable[] g3 = new Drawable[2];
    LayerDrawable h3;
    private boolean i3 = true;
    private Drawable j3 = null;
    private Drawable k3 = null;
    private float l3 = Float.NaN;
    private float m3 = Float.NaN;
    private float n3 = Float.NaN;
    private float o3 = Float.NaN;

    public ImageFilterButton(Context context) {
        super(context);
        c(context, (AttributeSet) null);
    }

    private void c(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ue);
            int indexCount = obtainStyledAttributes.getIndexCount();
            this.j3 = obtainStyledAttributes.getDrawable(R.styleable.ve);
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ze) {
                    this.a3 = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R.styleable.Ie) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.He) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ye) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.Fe) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.Ge) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.Ee) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.i3));
                } else if (index == R.styleable.Ae) {
                    setImagePanX(obtainStyledAttributes.getFloat(index, this.l3));
                } else if (index == R.styleable.Be) {
                    setImagePanY(obtainStyledAttributes.getFloat(index, this.m3));
                } else if (index == R.styleable.Ce) {
                    setImageRotate(obtainStyledAttributes.getFloat(index, this.o3));
                } else if (index == R.styleable.De) {
                    setImageZoom(obtainStyledAttributes.getFloat(index, this.n3));
                }
            }
            obtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.k3 = drawable;
            if (this.j3 == null || drawable == null) {
                Drawable drawable2 = getDrawable();
                this.k3 = drawable2;
                if (drawable2 != null) {
                    Drawable[] drawableArr = this.g3;
                    Drawable mutate = drawable2.mutate();
                    this.k3 = mutate;
                    drawableArr[0] = mutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.g3;
            Drawable mutate2 = getDrawable().mutate();
            this.k3 = mutate2;
            drawableArr2[0] = mutate2;
            this.g3[1] = this.j3.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(this.g3);
            this.h3 = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.a3 * 255.0f));
            if (!this.i3) {
                this.h3.getDrawable(0).setAlpha((int) ((1.0f - this.a3) * 255.0f));
            }
            super.setImageDrawable(this.h3);
        }
    }

    private void d() {
        if (!Float.isNaN(this.l3) || !Float.isNaN(this.m3) || !Float.isNaN(this.n3) || !Float.isNaN(this.o3)) {
            float f2 = 0.0f;
            float f4 = Float.isNaN(this.l3) ? 0.0f : this.l3;
            float f5 = Float.isNaN(this.m3) ? 0.0f : this.m3;
            float f6 = Float.isNaN(this.n3) ? 1.0f : this.n3;
            if (!Float.isNaN(this.o3)) {
                f2 = this.o3;
            }
            Matrix matrix = new Matrix();
            matrix.reset();
            float intrinsicWidth = (float) getDrawable().getIntrinsicWidth();
            float intrinsicHeight = (float) getDrawable().getIntrinsicHeight();
            float width = (float) getWidth();
            float height = (float) getHeight();
            float f7 = f6 * (intrinsicWidth * height < intrinsicHeight * width ? width / intrinsicWidth : height / intrinsicHeight);
            matrix.postScale(f7, f7);
            float f8 = intrinsicWidth * f7;
            float f9 = f7 * intrinsicHeight;
            matrix.postTranslate((((f4 * (width - f8)) + width) - f8) * 0.5f, (((f5 * (height - f9)) + height) - f9) * 0.5f);
            matrix.postRotate(f2, width / 2.0f, height / 2.0f);
            setImageMatrix(matrix);
            setScaleType(ImageView.ScaleType.MATRIX);
        }
    }

    private void e() {
        if (!Float.isNaN(this.l3) || !Float.isNaN(this.m3) || !Float.isNaN(this.n3) || !Float.isNaN(this.o3)) {
            d();
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    private void setOverlay(boolean z) {
        this.i3 = z;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getContrast() {
        return this.Z2.f4609f;
    }

    public float getCrossfade() {
        return this.a3;
    }

    public float getImagePanX() {
        return this.l3;
    }

    public float getImagePanY() {
        return this.m3;
    }

    public float getImageRotate() {
        return this.o3;
    }

    public float getImageZoom() {
        return this.n3;
    }

    public float getRound() {
        return this.c3;
    }

    public float getRoundPercent() {
        return this.b3;
    }

    public float getSaturation() {
        return this.Z2.f4608e;
    }

    public float getWarmth() {
        return this.Z2.f4610g;
    }

    public void layout(int i2, int i4, int i5, int i6) {
        super.layout(i2, i4, i5, i6);
        d();
    }

    public void setAltImageResource(int i2) {
        Drawable mutate = AppCompatResources.b(getContext(), i2).mutate();
        this.j3 = mutate;
        Drawable[] drawableArr = this.g3;
        drawableArr[0] = this.k3;
        drawableArr[1] = mutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.g3);
        this.h3 = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.a3);
    }

    public void setBrightness(float f2) {
        ImageFilterView.ImageMatrix imageMatrix = this.Z2;
        imageMatrix.f4607d = f2;
        imageMatrix.c(this);
    }

    public void setContrast(float f2) {
        ImageFilterView.ImageMatrix imageMatrix = this.Z2;
        imageMatrix.f4609f = f2;
        imageMatrix.c(this);
    }

    public void setCrossfade(float f2) {
        this.a3 = f2;
        if (this.g3 != null) {
            if (!this.i3) {
                this.h3.getDrawable(0).setAlpha((int) ((1.0f - this.a3) * 255.0f));
            }
            this.h3.getDrawable(1).setAlpha((int) (this.a3 * 255.0f));
            super.setImageDrawable(this.h3);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        if (this.j3 == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable mutate = drawable.mutate();
        this.k3 = mutate;
        Drawable[] drawableArr = this.g3;
        drawableArr[0] = mutate;
        drawableArr[1] = this.j3;
        LayerDrawable layerDrawable = new LayerDrawable(this.g3);
        this.h3 = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.a3);
    }

    public void setImagePanX(float f2) {
        this.l3 = f2;
        e();
    }

    public void setImagePanY(float f2) {
        this.m3 = f2;
        e();
    }

    public void setImageResource(int i2) {
        if (this.j3 != null) {
            Drawable mutate = AppCompatResources.b(getContext(), i2).mutate();
            this.k3 = mutate;
            Drawable[] drawableArr = this.g3;
            drawableArr[0] = mutate;
            drawableArr[1] = this.j3;
            LayerDrawable layerDrawable = new LayerDrawable(this.g3);
            this.h3 = layerDrawable;
            super.setImageDrawable(layerDrawable);
            setCrossfade(this.a3);
            return;
        }
        super.setImageResource(i2);
    }

    public void setImageRotate(float f2) {
        this.o3 = f2;
        e();
    }

    public void setImageZoom(float f2) {
        this.n3 = f2;
        e();
    }

    @RequiresApi(21)
    public void setRound(float f2) {
        if (Float.isNaN(f2)) {
            this.c3 = f2;
            float f4 = this.b3;
            this.b3 = -1.0f;
            setRoundPercent(f4);
            return;
        }
        boolean z = this.c3 != f2;
        this.c3 = f2;
        if (f2 != 0.0f) {
            if (this.d3 == null) {
                this.d3 = new Path();
            }
            if (this.f3 == null) {
                this.f3 = new RectF();
            }
            if (this.e3 == null) {
                AnonymousClass2 r5 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), ImageFilterButton.this.c3);
                    }
                };
                this.e3 = r5;
                setOutlineProvider(r5);
            }
            setClipToOutline(true);
            this.f3.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.d3.reset();
            Path path = this.d3;
            RectF rectF = this.f3;
            float f5 = this.c3;
            path.addRoundRect(rectF, f5, f5, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    @RequiresApi(21)
    public void setRoundPercent(float f2) {
        boolean z = this.b3 != f2;
        this.b3 = f2;
        if (f2 != 0.0f) {
            if (this.d3 == null) {
                this.d3 = new Path();
            }
            if (this.f3 == null) {
                this.f3 = new RectF();
            }
            if (this.e3 == null) {
                AnonymousClass1 r6 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        int width = ImageFilterButton.this.getWidth();
                        int height = ImageFilterButton.this.getHeight();
                        outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * ImageFilterButton.this.b3) / 2.0f);
                    }
                };
                this.e3 = r6;
                setOutlineProvider(r6);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.b3) / 2.0f;
            this.f3.set(0.0f, 0.0f, (float) width, (float) height);
            this.d3.reset();
            this.d3.addRoundRect(this.f3, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f2) {
        ImageFilterView.ImageMatrix imageMatrix = this.Z2;
        imageMatrix.f4608e = f2;
        imageMatrix.c(this);
    }

    public void setWarmth(float f2) {
        ImageFilterView.ImageMatrix imageMatrix = this.Z2;
        imageMatrix.f4610g = f2;
        imageMatrix.c(this);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c(context, attributeSet);
    }
}
