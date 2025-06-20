package de.hdodenhof.circleimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;

public class CircleImageView extends ImageView {
    private static final ImageView.ScaleType p3 = ImageView.ScaleType.CENTER_CROP;
    private static final Bitmap.Config q3 = Bitmap.Config.ARGB_8888;
    private static final int r3 = 2;
    private static final int s3 = 0;
    private static final int t3 = -16777216;
    private static final int u3 = 0;
    private static final boolean v3 = false;
    private final RectF X2;
    private final Matrix Y2;
    private final Paint Z2;
    private final Paint a3;
    private final Paint b3;
    private int c3;
    private int d3;
    private int e3;
    private Bitmap f3;
    private BitmapShader g3;
    private int h3;
    private int i3;
    private float j3;
    private float k3;
    private ColorFilter l3;
    private boolean m3;
    private boolean n3;
    private boolean o3;
    private final RectF s;

    public CircleImageView(Context context) {
        super(context);
        this.s = new RectF();
        this.X2 = new RectF();
        this.Y2 = new Matrix();
        this.Z2 = new Paint();
        this.a3 = new Paint();
        this.b3 = new Paint();
        this.c3 = -16777216;
        this.d3 = 0;
        this.e3 = 0;
        b();
    }

    private Bitmap a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = drawable instanceof ColorDrawable ? Bitmap.createBitmap(2, 2, q3) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), q3);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private void b() {
        super.setScaleType(p3);
        this.m3 = true;
        if (this.n3) {
            d();
            this.n3 = false;
        }
    }

    private void d() {
        if (!this.m3) {
            this.n3 = true;
        } else if (getWidth() != 0 || getHeight() != 0) {
            if (this.f3 == null) {
                invalidate();
                return;
            }
            Bitmap bitmap = this.f3;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.g3 = new BitmapShader(bitmap, tileMode, tileMode);
            this.Z2.setAntiAlias(true);
            this.Z2.setShader(this.g3);
            this.a3.setStyle(Paint.Style.STROKE);
            this.a3.setAntiAlias(true);
            this.a3.setColor(this.c3);
            this.a3.setStrokeWidth((float) this.d3);
            this.b3.setStyle(Paint.Style.FILL);
            this.b3.setAntiAlias(true);
            this.b3.setColor(this.e3);
            this.i3 = this.f3.getHeight();
            this.h3 = this.f3.getWidth();
            this.X2.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.k3 = Math.min((this.X2.height() - ((float) this.d3)) / 2.0f, (this.X2.width() - ((float) this.d3)) / 2.0f);
            this.s.set(this.X2);
            if (!this.o3) {
                RectF rectF = this.s;
                int i2 = this.d3;
                rectF.inset((float) i2, (float) i2);
            }
            this.j3 = Math.min(this.s.height() / 2.0f, this.s.width() / 2.0f);
            e();
            invalidate();
        }
    }

    private void e() {
        float f2;
        float f4;
        this.Y2.set((Matrix) null);
        float f5 = 0.0f;
        if (((float) this.h3) * this.s.height() > this.s.width() * ((float) this.i3)) {
            f4 = this.s.height() / ((float) this.i3);
            f5 = (this.s.width() - (((float) this.h3) * f4)) * 0.5f;
            f2 = 0.0f;
        } else {
            f4 = this.s.width() / ((float) this.h3);
            f2 = (this.s.height() - (((float) this.i3) * f4)) * 0.5f;
        }
        this.Y2.setScale(f4, f4);
        Matrix matrix = this.Y2;
        RectF rectF = this.s;
        matrix.postTranslate(((float) ((int) (f5 + 0.5f))) + rectF.left, ((float) ((int) (f2 + 0.5f))) + rectF.top);
        this.g3.setLocalMatrix(this.Y2);
    }

    public boolean c() {
        return this.o3;
    }

    public int getBorderColor() {
        return this.c3;
    }

    public int getBorderWidth() {
        return this.d3;
    }

    public int getFillColor() {
        return this.e3;
    }

    public ImageView.ScaleType getScaleType() {
        return p3;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f3 != null) {
            if (this.e3 != 0) {
                canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, this.j3, this.b3);
            }
            canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, this.j3, this.Z2);
            if (this.d3 != 0) {
                canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, this.k3, this.a3);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i4, int i5, int i6) {
        super.onSizeChanged(i2, i4, i5, i6);
        d();
    }

    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setBorderColor(@ColorInt int i2) {
        if (i2 != this.c3) {
            this.c3 = i2;
            this.a3.setColor(i2);
            invalidate();
        }
    }

    public void setBorderColorResource(@ColorRes int i2) {
        setBorderColor(getContext().getResources().getColor(i2));
    }

    public void setBorderOverlay(boolean z) {
        if (z != this.o3) {
            this.o3 = z;
            d();
        }
    }

    public void setBorderWidth(int i2) {
        if (i2 != this.d3) {
            this.d3 = i2;
            d();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter != this.l3) {
            this.l3 = colorFilter;
            this.Z2.setColorFilter(colorFilter);
            invalidate();
        }
    }

    public void setFillColor(@ColorInt int i2) {
        if (i2 != this.e3) {
            this.e3 = i2;
            this.b3.setColor(i2);
            invalidate();
        }
    }

    public void setFillColorResource(@ColorRes int i2) {
        setFillColor(getContext().getResources().getColor(i2));
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.f3 = bitmap;
        d();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.f3 = a(drawable);
        d();
    }

    public void setImageResource(@DrawableRes int i2) {
        super.setImageResource(i2);
        this.f3 = a(getDrawable());
        d();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        this.f3 = uri != null ? a(getDrawable()) : null;
        d();
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != p3) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
        }
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.s = new RectF();
        this.X2 = new RectF();
        this.Y2 = new Matrix();
        this.Z2 = new Paint();
        this.a3 = new Paint();
        this.b3 = new Paint();
        this.c3 = -16777216;
        this.d3 = 0;
        this.e3 = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.f28268a, i2, 0);
        this.d3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.f28271d, 0);
        this.c3 = obtainStyledAttributes.getColor(R.styleable.f28269b, -16777216);
        this.o3 = obtainStyledAttributes.getBoolean(R.styleable.f28270c, false);
        this.e3 = obtainStyledAttributes.getColor(R.styleable.f28272e, 0);
        obtainStyledAttributes.recycle();
        b();
    }
}
