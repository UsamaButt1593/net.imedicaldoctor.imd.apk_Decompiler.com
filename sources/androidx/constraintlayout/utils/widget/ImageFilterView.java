package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
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
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R;

public class ImageFilterView extends AppCompatImageView {
    private ImageMatrix Z2 = new ImageMatrix();
    private boolean a3 = true;
    private Drawable b3 = null;
    private Drawable c3 = null;
    private float d3 = 0.0f;
    /* access modifiers changed from: private */
    public float e3 = 0.0f;
    /* access modifiers changed from: private */
    public float f3 = Float.NaN;
    private Path g3;
    ViewOutlineProvider h3;
    RectF i3;
    Drawable[] j3 = new Drawable[2];
    LayerDrawable k3;
    float l3 = Float.NaN;
    float m3 = Float.NaN;
    float n3 = Float.NaN;
    float o3 = Float.NaN;

    static class ImageMatrix {

        /* renamed from: a  reason: collision with root package name */
        float[] f4604a = new float[20];

        /* renamed from: b  reason: collision with root package name */
        ColorMatrix f4605b = new ColorMatrix();

        /* renamed from: c  reason: collision with root package name */
        ColorMatrix f4606c = new ColorMatrix();

        /* renamed from: d  reason: collision with root package name */
        float f4607d = 1.0f;

        /* renamed from: e  reason: collision with root package name */
        float f4608e = 1.0f;

        /* renamed from: f  reason: collision with root package name */
        float f4609f = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        float f4610g = 1.0f;

        ImageMatrix() {
        }

        private void a(float f2) {
            float[] fArr = this.f4604a;
            fArr[0] = f2;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f2;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = f2;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void b(float f2) {
            float f3 = 1.0f - f2;
            float f4 = 0.2999f * f3;
            float f5 = 0.587f * f3;
            float f6 = f3 * 0.114f;
            float[] fArr = this.f4604a;
            fArr[0] = f4 + f2;
            fArr[1] = f5;
            fArr[2] = f6;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f4;
            fArr[6] = f5 + f2;
            fArr[7] = f6;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f4;
            fArr[11] = f5;
            fArr[12] = f6 + f2;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void d(float f2) {
            float f3;
            float f4;
            if (f2 <= 0.0f) {
                f2 = 0.01f;
            }
            float f5 = (5000.0f / f2) / 100.0f;
            if (f5 > 66.0f) {
                double d2 = (double) (f5 - 60.0f);
                f3 = ((float) Math.pow(d2, -0.13320475816726685d)) * 329.69873f;
                f4 = ((float) Math.pow(d2, 0.07551484555006027d)) * 288.12216f;
            } else {
                f4 = (((float) Math.log((double) f5)) * 99.4708f) - 161.11957f;
                f3 = 255.0f;
            }
            float log = f5 < 66.0f ? f5 > 19.0f ? (((float) Math.log((double) (f5 - 10.0f))) * 138.51773f) - 305.0448f : 0.0f : 255.0f;
            float min = Math.min(255.0f, Math.max(f3, 0.0f));
            float min2 = Math.min(255.0f, Math.max(f4, 0.0f));
            float min3 = Math.min(255.0f, Math.max(log, 0.0f));
            float min4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float min5 = Math.min(255.0f, Math.max((((float) Math.log((double) 50.0f)) * 99.4708f) - 161.11957f, 0.0f));
            float min6 = min3 / Math.min(255.0f, Math.max((((float) Math.log((double) 40.0f)) * 138.51773f) - 305.0448f, 0.0f));
            float[] fArr = this.f4604a;
            fArr[0] = min / min4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = min2 / min5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = min6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        /* access modifiers changed from: package-private */
        public void c(ImageView imageView) {
            boolean z;
            this.f4605b.reset();
            float f2 = this.f4608e;
            boolean z2 = true;
            if (f2 != 1.0f) {
                b(f2);
                this.f4605b.set(this.f4604a);
                z = true;
            } else {
                z = false;
            }
            float f3 = this.f4609f;
            if (f3 != 1.0f) {
                this.f4606c.setScale(f3, f3, f3, 1.0f);
                this.f4605b.postConcat(this.f4606c);
                z = true;
            }
            float f4 = this.f4610g;
            if (f4 != 1.0f) {
                d(f4);
                this.f4606c.set(this.f4604a);
                this.f4605b.postConcat(this.f4606c);
                z = true;
            }
            float f5 = this.f4607d;
            if (f5 != 1.0f) {
                a(f5);
                this.f4606c.set(this.f4604a);
                this.f4605b.postConcat(this.f4606c);
            } else {
                z2 = z;
            }
            if (z2) {
                imageView.setColorFilter(new ColorMatrixColorFilter(this.f4605b));
            } else {
                imageView.clearColorFilter();
            }
        }
    }

    public ImageFilterView(Context context) {
        super(context);
        e(context, (AttributeSet) null);
    }

    private void e(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ue);
            int indexCount = obtainStyledAttributes.getIndexCount();
            this.b3 = obtainStyledAttributes.getDrawable(R.styleable.ve);
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ze) {
                    this.d3 = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R.styleable.Ie) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.He) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ye) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.xe) {
                    setBrightness(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.Fe) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.Ge) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.Ee) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.a3));
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
            this.c3 = drawable;
            if (this.b3 == null || drawable == null) {
                Drawable drawable2 = getDrawable();
                this.c3 = drawable2;
                if (drawable2 != null) {
                    Drawable[] drawableArr = this.j3;
                    Drawable mutate = drawable2.mutate();
                    this.c3 = mutate;
                    drawableArr[0] = mutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.j3;
            Drawable mutate2 = getDrawable().mutate();
            this.c3 = mutate2;
            drawableArr2[0] = mutate2;
            this.j3[1] = this.b3.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(this.j3);
            this.k3 = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.d3 * 255.0f));
            if (!this.a3) {
                this.k3.getDrawable(0).setAlpha((int) ((1.0f - this.d3) * 255.0f));
            }
            super.setImageDrawable(this.k3);
        }
    }

    private void f() {
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

    private void g() {
        if (!Float.isNaN(this.l3) || !Float.isNaN(this.m3) || !Float.isNaN(this.n3) || !Float.isNaN(this.o3)) {
            f();
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    private void setOverlay(boolean z) {
        this.a3 = z;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getBrightness() {
        return this.Z2.f4607d;
    }

    public float getContrast() {
        return this.Z2.f4609f;
    }

    public float getCrossfade() {
        return this.d3;
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
        return this.f3;
    }

    public float getRoundPercent() {
        return this.e3;
    }

    public float getSaturation() {
        return this.Z2.f4608e;
    }

    public float getWarmth() {
        return this.Z2.f4610g;
    }

    public void layout(int i2, int i4, int i5, int i6) {
        super.layout(i2, i4, i5, i6);
        f();
    }

    public void setAltImageResource(int i2) {
        Drawable mutate = AppCompatResources.b(getContext(), i2).mutate();
        this.b3 = mutate;
        Drawable[] drawableArr = this.j3;
        drawableArr[0] = this.c3;
        drawableArr[1] = mutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.j3);
        this.k3 = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.d3);
    }

    public void setBrightness(float f2) {
        ImageMatrix imageMatrix = this.Z2;
        imageMatrix.f4607d = f2;
        imageMatrix.c(this);
    }

    public void setContrast(float f2) {
        ImageMatrix imageMatrix = this.Z2;
        imageMatrix.f4609f = f2;
        imageMatrix.c(this);
    }

    public void setCrossfade(float f2) {
        this.d3 = f2;
        if (this.j3 != null) {
            if (!this.a3) {
                this.k3.getDrawable(0).setAlpha((int) ((1.0f - this.d3) * 255.0f));
            }
            this.k3.getDrawable(1).setAlpha((int) (this.d3 * 255.0f));
            super.setImageDrawable(this.k3);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        if (this.b3 == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable mutate = drawable.mutate();
        this.c3 = mutate;
        Drawable[] drawableArr = this.j3;
        drawableArr[0] = mutate;
        drawableArr[1] = this.b3;
        LayerDrawable layerDrawable = new LayerDrawable(this.j3);
        this.k3 = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.d3);
    }

    public void setImagePanX(float f2) {
        this.l3 = f2;
        g();
    }

    public void setImagePanY(float f2) {
        this.m3 = f2;
        g();
    }

    public void setImageResource(int i2) {
        if (this.b3 != null) {
            Drawable mutate = AppCompatResources.b(getContext(), i2).mutate();
            this.c3 = mutate;
            Drawable[] drawableArr = this.j3;
            drawableArr[0] = mutate;
            drawableArr[1] = this.b3;
            LayerDrawable layerDrawable = new LayerDrawable(this.j3);
            this.k3 = layerDrawable;
            super.setImageDrawable(layerDrawable);
            setCrossfade(this.d3);
            return;
        }
        super.setImageResource(i2);
    }

    public void setImageRotate(float f2) {
        this.o3 = f2;
        g();
    }

    public void setImageZoom(float f2) {
        this.n3 = f2;
        g();
    }

    @RequiresApi(21)
    public void setRound(float f2) {
        if (Float.isNaN(f2)) {
            this.f3 = f2;
            float f4 = this.e3;
            this.e3 = -1.0f;
            setRoundPercent(f4);
            return;
        }
        boolean z = this.f3 != f2;
        this.f3 = f2;
        if (f2 != 0.0f) {
            if (this.g3 == null) {
                this.g3 = new Path();
            }
            if (this.i3 == null) {
                this.i3 = new RectF();
            }
            if (this.h3 == null) {
                AnonymousClass2 r5 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.this.f3);
                    }
                };
                this.h3 = r5;
                setOutlineProvider(r5);
            }
            setClipToOutline(true);
            this.i3.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.g3.reset();
            Path path = this.g3;
            RectF rectF = this.i3;
            float f5 = this.f3;
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
        boolean z = this.e3 != f2;
        this.e3 = f2;
        if (f2 != 0.0f) {
            if (this.g3 == null) {
                this.g3 = new Path();
            }
            if (this.i3 == null) {
                this.i3 = new RectF();
            }
            if (this.h3 == null) {
                AnonymousClass1 r6 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        int width = ImageFilterView.this.getWidth();
                        int height = ImageFilterView.this.getHeight();
                        outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * ImageFilterView.this.e3) / 2.0f);
                    }
                };
                this.h3 = r6;
                setOutlineProvider(r6);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.e3) / 2.0f;
            this.i3.set(0.0f, 0.0f, (float) width, (float) height);
            this.g3.reset();
            this.g3.addRoundRect(this.i3, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f2) {
        ImageMatrix imageMatrix = this.Z2;
        imageMatrix.f4608e = f2;
        imageMatrix.c(this);
    }

    public void setWarmth(float f2) {
        ImageMatrix imageMatrix = this.Z2;
        imageMatrix.f4610g = f2;
        imageMatrix.c(this);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(context, attributeSet);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        e(context, attributeSet);
    }
}
