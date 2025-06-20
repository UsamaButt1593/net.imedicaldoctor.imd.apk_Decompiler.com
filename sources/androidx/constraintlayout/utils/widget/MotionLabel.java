package androidx.constraintlayout.utils.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.FloatLayout;
import androidx.constraintlayout.widget.R;
import androidx.core.view.GravityCompat;

public class MotionLabel extends View implements FloatLayout {
    static String S3 = "MotionLabel";
    private static final int T3 = 1;
    private static final int U3 = 2;
    private static final int V3 = 3;
    private Drawable A3;
    Matrix B3;
    private Bitmap C3;
    private BitmapShader D3;
    private Matrix E3;
    private float F3 = Float.NaN;
    private float G3 = Float.NaN;
    private float H3 = 0.0f;
    private float I3 = 0.0f;
    Paint J3 = new Paint();
    private int K3 = 0;
    Rect L3;
    Paint M3;
    float N3;
    float O3 = Float.NaN;
    float P3 = Float.NaN;
    float Q3 = Float.NaN;
    float R3 = Float.NaN;
    Path X2 = new Path();
    private int Y2 = 65535;
    private int Z2 = 65535;
    private boolean a3 = false;
    /* access modifiers changed from: private */
    public float b3 = 0.0f;
    /* access modifiers changed from: private */
    public float c3 = Float.NaN;
    ViewOutlineProvider d3;
    RectF e3;
    private float f3 = 48.0f;
    private float g3 = Float.NaN;
    private int h3;
    private int i3;
    private float j3 = 0.0f;
    private String k3 = "Hello World";
    boolean l3 = true;
    private Rect m3 = new Rect();
    private CharSequence n3;
    private int o3 = 1;
    private int p3 = 1;
    private int q3 = 1;
    private int r3 = 1;
    TextPaint s = new TextPaint();
    private String s3;
    private Layout t3;
    private int u3 = 8388659;
    private int v3 = 0;
    private boolean w3 = false;
    private float x3;
    private float y3;
    private float z3;

    public MotionLabel(Context context) {
        super(context);
        g(context, (AttributeSet) null);
    }

    private void d(float f2, float f4, float f5, float f6) {
        if (this.E3 != null) {
            this.y3 = f5 - f2;
            this.z3 = f6 - f4;
            l();
        }
    }

    private void g(Context context, AttributeSet attributeSet) {
        i(context, attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.Jj);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.Pj) {
                    setText(obtainStyledAttributes.getText(index));
                } else if (index == R.styleable.Rj) {
                    this.s3 = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.Vj) {
                    this.g3 = (float) obtainStyledAttributes.getDimensionPixelSize(index, (int) this.g3);
                } else if (index == R.styleable.Kj) {
                    this.f3 = (float) obtainStyledAttributes.getDimensionPixelSize(index, (int) this.f3);
                } else if (index == R.styleable.Mj) {
                    this.h3 = obtainStyledAttributes.getInt(index, this.h3);
                } else if (index == R.styleable.Lj) {
                    this.i3 = obtainStyledAttributes.getInt(index, this.i3);
                } else if (index == R.styleable.Nj) {
                    this.Y2 = obtainStyledAttributes.getColor(index, this.Y2);
                } else if (index == R.styleable.Tj) {
                    float dimension = obtainStyledAttributes.getDimension(index, this.c3);
                    this.c3 = dimension;
                    setRound(dimension);
                } else if (index == R.styleable.Uj) {
                    float f2 = obtainStyledAttributes.getFloat(index, this.b3);
                    this.b3 = f2;
                    setRoundPercent(f2);
                } else if (index == R.styleable.Oj) {
                    setGravity(obtainStyledAttributes.getInt(index, -1));
                } else if (index == R.styleable.Sj) {
                    this.v3 = obtainStyledAttributes.getInt(index, 0);
                } else {
                    if (index == R.styleable.bk) {
                        this.Z2 = obtainStyledAttributes.getInt(index, this.Z2);
                    } else if (index == R.styleable.ck) {
                        this.j3 = obtainStyledAttributes.getDimension(index, this.j3);
                    } else if (index == R.styleable.Wj) {
                        this.A3 = obtainStyledAttributes.getDrawable(index);
                    } else if (index == R.styleable.Xj) {
                        this.O3 = obtainStyledAttributes.getFloat(index, this.O3);
                    } else if (index == R.styleable.Yj) {
                        this.P3 = obtainStyledAttributes.getFloat(index, this.P3);
                    } else if (index == R.styleable.dk) {
                        this.H3 = obtainStyledAttributes.getFloat(index, this.H3);
                    } else if (index == R.styleable.ek) {
                        this.I3 = obtainStyledAttributes.getFloat(index, this.I3);
                    } else if (index == R.styleable.Zj) {
                        this.R3 = obtainStyledAttributes.getFloat(index, this.R3);
                    } else if (index == R.styleable.ak) {
                        this.Q3 = obtainStyledAttributes.getFloat(index, this.Q3);
                    } else if (index == R.styleable.hk) {
                        this.F3 = obtainStyledAttributes.getDimension(index, this.F3);
                    } else if (index == R.styleable.ik) {
                        this.G3 = obtainStyledAttributes.getDimension(index, this.G3);
                    } else if (index == R.styleable.gk) {
                        this.K3 = obtainStyledAttributes.getInt(index, this.K3);
                    }
                    this.a3 = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
        k();
        j();
    }

    private float getHorizontalOffset() {
        float f2 = Float.isNaN(this.g3) ? 1.0f : this.f3 / this.g3;
        TextPaint textPaint = this.s;
        String str = this.k3;
        return (((((Float.isNaN(this.y3) ? (float) getMeasuredWidth() : this.y3) - ((float) getPaddingLeft())) - ((float) getPaddingRight())) - (f2 * textPaint.measureText(str, 0, str.length()))) * (this.H3 + 1.0f)) / 2.0f;
    }

    private float getVerticalOffset() {
        float f2 = Float.isNaN(this.g3) ? 1.0f : this.f3 / this.g3;
        Paint.FontMetrics fontMetrics = this.s.getFontMetrics();
        float measuredHeight = ((Float.isNaN(this.z3) ? (float) getMeasuredHeight() : this.z3) - ((float) getPaddingTop())) - ((float) getPaddingBottom());
        float f4 = fontMetrics.descent;
        float f5 = fontMetrics.ascent;
        return (((measuredHeight - ((f4 - f5) * f2)) * (1.0f - this.I3)) / 2.0f) - (f2 * f5);
    }

    private void h(String str, int i2, int i4) {
        Typeface typeface;
        if (str != null) {
            typeface = Typeface.create(str, i4);
            if (typeface != null) {
                setTypeface(typeface);
                return;
            }
        } else {
            typeface = null;
        }
        boolean z = true;
        if (i2 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i2 == 2) {
            typeface = Typeface.SERIF;
        } else if (i2 == 3) {
            typeface = Typeface.MONOSPACE;
        }
        float f2 = 0.0f;
        if (i4 > 0) {
            Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i4) : Typeface.create(typeface, i4);
            setTypeface(defaultFromStyle);
            int i5 = (~(defaultFromStyle != null ? defaultFromStyle.getStyle() : 0)) & i4;
            TextPaint textPaint = this.s;
            if ((i5 & 1) == 0) {
                z = false;
            }
            textPaint.setFakeBoldText(z);
            TextPaint textPaint2 = this.s;
            if ((i5 & 2) != 0) {
                f2 = -0.25f;
            }
            textPaint2.setTextSkewX(f2);
            return;
        }
        this.s.setFakeBoldText(false);
        this.s.setTextSkewX(0.0f);
        setTypeface(typeface);
    }

    private void i(Context context, @Nullable AttributeSet attributeSet) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(androidx.appcompat.R.attr.J0, typedValue, true);
        TextPaint textPaint = this.s;
        int i2 = typedValue.data;
        this.Y2 = i2;
        textPaint.setColor(i2);
    }

    private void k() {
        if (this.A3 != null) {
            this.E3 = new Matrix();
            int intrinsicWidth = this.A3.getIntrinsicWidth();
            int intrinsicHeight = this.A3.getIntrinsicHeight();
            int i2 = 128;
            if (intrinsicWidth <= 0 && (intrinsicWidth = getWidth()) == 0) {
                intrinsicWidth = Float.isNaN(this.G3) ? 128 : (int) this.G3;
            }
            if (intrinsicHeight <= 0 && (intrinsicHeight = getHeight()) == 0) {
                if (!Float.isNaN(this.F3)) {
                    i2 = (int) this.F3;
                }
                intrinsicHeight = i2;
            }
            if (this.K3 != 0) {
                intrinsicWidth /= 2;
                intrinsicHeight /= 2;
            }
            this.C3 = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.C3);
            this.A3.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            this.A3.setFilterBitmap(true);
            this.A3.draw(canvas);
            if (this.K3 != 0) {
                this.C3 = e(this.C3, 4);
            }
            Bitmap bitmap = this.C3;
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.D3 = new BitmapShader(bitmap, tileMode, tileMode);
        }
    }

    private void l() {
        float f2 = 0.0f;
        float f4 = Float.isNaN(this.O3) ? 0.0f : this.O3;
        float f5 = Float.isNaN(this.P3) ? 0.0f : this.P3;
        float f6 = Float.isNaN(this.Q3) ? 1.0f : this.Q3;
        if (!Float.isNaN(this.R3)) {
            f2 = this.R3;
        }
        this.E3.reset();
        float width = (float) this.C3.getWidth();
        float height = (float) this.C3.getHeight();
        float f7 = Float.isNaN(this.G3) ? this.y3 : this.G3;
        float f8 = Float.isNaN(this.F3) ? this.z3 : this.F3;
        float f9 = f6 * (width * f8 < height * f7 ? f7 / width : f8 / height);
        this.E3.postScale(f9, f9);
        float f10 = width * f9;
        float f11 = f7 - f10;
        float f12 = f9 * height;
        float f13 = f8 - f12;
        if (!Float.isNaN(this.F3)) {
            f13 = this.F3 / 2.0f;
        }
        if (!Float.isNaN(this.G3)) {
            f11 = this.G3 / 2.0f;
        }
        this.E3.postTranslate((((f4 * f11) + f7) - f10) * 0.5f, (((f5 * f13) + f8) - f12) * 0.5f);
        this.E3.postRotate(f2, f7 / 2.0f, f8 / 2.0f);
        this.D3.setLocalMatrix(this.E3);
    }

    public void a(float f2, float f4, float f5, float f6) {
        int i2 = (int) (f2 + 0.5f);
        this.x3 = f2 - ((float) i2);
        int i4 = (int) (f5 + 0.5f);
        int i5 = i4 - i2;
        int i6 = (int) (f6 + 0.5f);
        int i7 = (int) (0.5f + f4);
        int i8 = i6 - i7;
        float f7 = f5 - f2;
        this.y3 = f7;
        float f8 = f6 - f4;
        this.z3 = f8;
        d(f2, f4, f5, f6);
        if (!(getMeasuredHeight() == i8 && getMeasuredWidth() == i5)) {
            measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
        }
        super.layout(i2, i7, i4, i6);
        if (this.w3) {
            if (this.L3 == null) {
                this.M3 = new Paint();
                this.L3 = new Rect();
                this.M3.set(this.s);
                this.N3 = this.M3.getTextSize();
            }
            this.y3 = f7;
            this.z3 = f8;
            Paint paint = this.M3;
            String str = this.k3;
            paint.getTextBounds(str, 0, str.length(), this.L3);
            int width = this.L3.width();
            float height = ((float) this.L3.height()) * 1.3f;
            float f9 = (f7 - ((float) this.p3)) - ((float) this.o3);
            float f10 = (f8 - ((float) this.r3)) - ((float) this.q3);
            float f11 = (float) width;
            if (f11 * f10 > height * f9) {
                this.s.setTextSize((this.N3 * f9) / f11);
            } else {
                this.s.setTextSize((this.N3 * f10) / height);
            }
            if (this.a3 || !Float.isNaN(this.g3)) {
                f(Float.isNaN(this.g3) ? 1.0f : this.f3 / this.g3);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Bitmap e(Bitmap bitmap, int i2) {
        System.nanoTime();
        int width = bitmap.getWidth() / 2;
        int height = bitmap.getHeight() / 2;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, true);
        for (int i4 = 0; i4 < i2 && width >= 32 && height >= 32; i4++) {
            width /= 2;
            height /= 2;
            createScaledBitmap = Bitmap.createScaledBitmap(createScaledBitmap, width, height, true);
        }
        return createScaledBitmap;
    }

    /* access modifiers changed from: package-private */
    public void f(float f2) {
        if (this.a3 || f2 != 1.0f) {
            this.X2.reset();
            String str = this.k3;
            int length = str.length();
            this.s.getTextBounds(str, 0, length, this.m3);
            this.s.getTextPath(str, 0, length, 0.0f, 0.0f, this.X2);
            if (f2 != 1.0f) {
                Log.v(S3, Debug.f() + " scale " + f2);
                Matrix matrix = new Matrix();
                matrix.postScale(f2, f2);
                this.X2.transform(matrix);
            }
            Rect rect = this.m3;
            rect.right--;
            rect.left++;
            rect.bottom++;
            rect.top--;
            RectF rectF = new RectF();
            rectF.bottom = (float) getHeight();
            rectF.right = (float) getWidth();
            this.l3 = false;
        }
    }

    public float getRound() {
        return this.c3;
    }

    public float getRoundPercent() {
        return this.b3;
    }

    public float getScaleFromTextSize() {
        return this.g3;
    }

    public float getTextBackgroundPanX() {
        return this.O3;
    }

    public float getTextBackgroundPanY() {
        return this.P3;
    }

    public float getTextBackgroundRotate() {
        return this.R3;
    }

    public float getTextBackgroundZoom() {
        return this.Q3;
    }

    public int getTextOutlineColor() {
        return this.Z2;
    }

    public float getTextPanX() {
        return this.H3;
    }

    public float getTextPanY() {
        return this.I3;
    }

    public float getTextureHeight() {
        return this.F3;
    }

    public float getTextureWidth() {
        return this.G3;
    }

    public Typeface getTypeface() {
        return this.s.getTypeface();
    }

    /* access modifiers changed from: package-private */
    public void j() {
        this.o3 = getPaddingLeft();
        this.p3 = getPaddingRight();
        this.q3 = getPaddingTop();
        this.r3 = getPaddingBottom();
        h(this.s3, this.i3, this.h3);
        this.s.setColor(this.Y2);
        this.s.setStrokeWidth(this.j3);
        this.s.setStyle(Paint.Style.FILL_AND_STROKE);
        this.s.setFlags(128);
        setTextSize(this.f3);
        this.s.setAntiAlias(true);
    }

    public void layout(int i2, int i4, int i5, int i6) {
        super.layout(i2, i4, i5, i6);
        boolean isNaN = Float.isNaN(this.g3);
        float f2 = isNaN ? 1.0f : this.f3 / this.g3;
        this.y3 = (float) (i5 - i2);
        this.z3 = (float) (i6 - i4);
        if (this.w3) {
            if (this.L3 == null) {
                this.M3 = new Paint();
                this.L3 = new Rect();
                this.M3.set(this.s);
                this.N3 = this.M3.getTextSize();
            }
            Paint paint = this.M3;
            String str = this.k3;
            paint.getTextBounds(str, 0, str.length(), this.L3);
            int width = this.L3.width();
            int height = (int) (((float) this.L3.height()) * 1.3f);
            float f4 = (this.y3 - ((float) this.p3)) - ((float) this.o3);
            float f5 = (this.z3 - ((float) this.r3)) - ((float) this.q3);
            if (isNaN) {
                float f6 = (float) width;
                float f7 = (float) height;
                if (f6 * f5 > f7 * f4) {
                    this.s.setTextSize((this.N3 * f4) / f6);
                } else {
                    this.s.setTextSize((this.N3 * f5) / f7);
                }
            } else {
                float f8 = (float) width;
                float f9 = (float) height;
                f2 = f8 * f5 > f9 * f4 ? f4 / f8 : f5 / f9;
            }
        }
        if (this.a3 || !isNaN) {
            d((float) i2, (float) i4, (float) i5, (float) i6);
            f(f2);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f2 = Float.isNaN(this.g3) ? 1.0f : this.f3 / this.g3;
        super.onDraw(canvas);
        if (this.a3 || f2 != 1.0f) {
            if (this.l3) {
                f(f2);
            }
            if (this.B3 == null) {
                this.B3 = new Matrix();
            }
            if (this.a3) {
                this.J3.set(this.s);
                this.B3.reset();
                float horizontalOffset = ((float) this.o3) + getHorizontalOffset();
                float verticalOffset = ((float) this.q3) + getVerticalOffset();
                this.B3.postTranslate(horizontalOffset, verticalOffset);
                this.B3.preScale(f2, f2);
                this.X2.transform(this.B3);
                if (this.D3 != null) {
                    this.s.setFilterBitmap(true);
                    this.s.setShader(this.D3);
                } else {
                    this.s.setColor(this.Y2);
                }
                this.s.setStyle(Paint.Style.FILL);
                this.s.setStrokeWidth(this.j3);
                canvas.drawPath(this.X2, this.s);
                if (this.D3 != null) {
                    this.s.setShader((Shader) null);
                }
                this.s.setColor(this.Z2);
                this.s.setStyle(Paint.Style.STROKE);
                this.s.setStrokeWidth(this.j3);
                canvas.drawPath(this.X2, this.s);
                this.B3.reset();
                this.B3.postTranslate(-horizontalOffset, -verticalOffset);
                this.X2.transform(this.B3);
                this.s.set(this.J3);
                return;
            }
            float horizontalOffset2 = ((float) this.o3) + getHorizontalOffset();
            float verticalOffset2 = ((float) this.q3) + getVerticalOffset();
            this.B3.reset();
            this.B3.preTranslate(horizontalOffset2, verticalOffset2);
            this.X2.transform(this.B3);
            this.s.setColor(this.Y2);
            this.s.setStyle(Paint.Style.FILL_AND_STROKE);
            this.s.setStrokeWidth(this.j3);
            canvas.drawPath(this.X2, this.s);
            this.B3.reset();
            this.B3.preTranslate(-horizontalOffset2, -verticalOffset2);
            this.X2.transform(this.B3);
            return;
        }
        canvas.drawText(this.k3, this.x3 + ((float) this.o3) + getHorizontalOffset(), ((float) this.q3) + getVerticalOffset(), this.s);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i4) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i4);
        this.w3 = false;
        this.o3 = getPaddingLeft();
        this.p3 = getPaddingRight();
        this.q3 = getPaddingTop();
        this.r3 = getPaddingBottom();
        if (mode != 1073741824 || mode2 != 1073741824) {
            TextPaint textPaint = this.s;
            String str = this.k3;
            textPaint.getTextBounds(str, 0, str.length(), this.m3);
            if (mode != 1073741824) {
                size = (int) (((float) this.m3.width()) + 0.99999f);
            }
            size += this.o3 + this.p3;
            if (mode2 != 1073741824) {
                int fontMetricsInt = (int) (((float) this.s.getFontMetricsInt((Paint.FontMetricsInt) null)) + 0.99999f);
                if (mode2 == Integer.MIN_VALUE) {
                    fontMetricsInt = Math.min(size2, fontMetricsInt);
                }
                size2 = this.q3 + this.r3 + fontMetricsInt;
            }
        } else if (this.v3 != 0) {
            this.w3 = true;
        }
        setMeasuredDimension(size, size2);
    }

    @SuppressLint({"RtlHardcoded"})
    public void setGravity(int i2) {
        if ((i2 & GravityCompat.f6389d) == 0) {
            i2 |= GravityCompat.f6387b;
        }
        if ((i2 & 112) == 0) {
            i2 |= 48;
        }
        if (i2 != this.u3) {
            invalidate();
        }
        this.u3 = i2;
        int i4 = i2 & 112;
        if (i4 == 48) {
            this.I3 = -1.0f;
        } else if (i4 != 80) {
            this.I3 = 0.0f;
        } else {
            this.I3 = 1.0f;
        }
        int i5 = i2 & GravityCompat.f6389d;
        if (i5 != 3) {
            if (i5 != 5) {
                if (i5 != 8388611) {
                    if (i5 != 8388613) {
                        this.H3 = 0.0f;
                        return;
                    }
                }
            }
            this.H3 = 1.0f;
            return;
        }
        this.H3 = -1.0f;
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
            if (this.X2 == null) {
                this.X2 = new Path();
            }
            if (this.e3 == null) {
                this.e3 = new RectF();
            }
            if (this.d3 == null) {
                AnonymousClass2 r5 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, MotionLabel.this.getWidth(), MotionLabel.this.getHeight(), MotionLabel.this.c3);
                    }
                };
                this.d3 = r5;
                setOutlineProvider(r5);
            }
            setClipToOutline(true);
            this.e3.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.X2.reset();
            Path path = this.X2;
            RectF rectF = this.e3;
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
            if (this.X2 == null) {
                this.X2 = new Path();
            }
            if (this.e3 == null) {
                this.e3 = new RectF();
            }
            if (this.d3 == null) {
                AnonymousClass1 r6 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        int width = MotionLabel.this.getWidth();
                        int height = MotionLabel.this.getHeight();
                        outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * MotionLabel.this.b3) / 2.0f);
                    }
                };
                this.d3 = r6;
                setOutlineProvider(r6);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.b3) / 2.0f;
            this.e3.set(0.0f, 0.0f, (float) width, (float) height);
            this.X2.reset();
            this.X2.addRoundRect(this.e3, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setScaleFromTextSize(float f2) {
        this.g3 = f2;
    }

    public void setText(CharSequence charSequence) {
        this.k3 = charSequence.toString();
        invalidate();
    }

    public void setTextBackgroundPanX(float f2) {
        this.O3 = f2;
        l();
        invalidate();
    }

    public void setTextBackgroundPanY(float f2) {
        this.P3 = f2;
        l();
        invalidate();
    }

    public void setTextBackgroundRotate(float f2) {
        this.R3 = f2;
        l();
        invalidate();
    }

    public void setTextBackgroundZoom(float f2) {
        this.Q3 = f2;
        l();
        invalidate();
    }

    public void setTextFillColor(int i2) {
        this.Y2 = i2;
        invalidate();
    }

    public void setTextOutlineColor(int i2) {
        this.Z2 = i2;
        this.a3 = true;
        invalidate();
    }

    public void setTextOutlineThickness(float f2) {
        this.j3 = f2;
        this.a3 = true;
        if (Float.isNaN(f2)) {
            this.j3 = 1.0f;
            this.a3 = false;
        }
        invalidate();
    }

    public void setTextPanX(float f2) {
        this.H3 = f2;
        invalidate();
    }

    public void setTextPanY(float f2) {
        this.I3 = f2;
        invalidate();
    }

    public void setTextSize(float f2) {
        this.f3 = f2;
        String str = S3;
        Log.v(str, Debug.f() + "  " + f2 + " / " + this.g3);
        TextPaint textPaint = this.s;
        if (!Float.isNaN(this.g3)) {
            f2 = this.g3;
        }
        textPaint.setTextSize(f2);
        f(Float.isNaN(this.g3) ? 1.0f : this.f3 / this.g3);
        requestLayout();
        invalidate();
    }

    public void setTextureHeight(float f2) {
        this.F3 = f2;
        l();
        invalidate();
    }

    public void setTextureWidth(float f2) {
        this.G3 = f2;
        l();
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        if (this.s.getTypeface() != typeface) {
            this.s.setTypeface(typeface);
            if (this.t3 != null) {
                this.t3 = null;
                requestLayout();
                invalidate();
            }
        }
    }

    public MotionLabel(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        g(context, attributeSet);
    }

    public MotionLabel(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        g(context, attributeSet);
    }
}
