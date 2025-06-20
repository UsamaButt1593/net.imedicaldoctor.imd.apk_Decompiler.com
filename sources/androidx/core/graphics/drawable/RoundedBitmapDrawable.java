package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class RoundedBitmapDrawable extends Drawable {

    /* renamed from: n  reason: collision with root package name */
    private static final int f5912n = 3;

    /* renamed from: a  reason: collision with root package name */
    final Bitmap f5913a;

    /* renamed from: b  reason: collision with root package name */
    private int f5914b = 160;

    /* renamed from: c  reason: collision with root package name */
    private int f5915c = 119;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f5916d = new Paint(3);

    /* renamed from: e  reason: collision with root package name */
    private final BitmapShader f5917e;

    /* renamed from: f  reason: collision with root package name */
    private final Matrix f5918f = new Matrix();

    /* renamed from: g  reason: collision with root package name */
    private float f5919g;

    /* renamed from: h  reason: collision with root package name */
    final Rect f5920h = new Rect();

    /* renamed from: i  reason: collision with root package name */
    private final RectF f5921i = new RectF();

    /* renamed from: j  reason: collision with root package name */
    private boolean f5922j = true;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5923k;

    /* renamed from: l  reason: collision with root package name */
    private int f5924l;

    /* renamed from: m  reason: collision with root package name */
    private int f5925m;

    RoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
        BitmapShader bitmapShader;
        if (resources != null) {
            this.f5914b = resources.getDisplayMetrics().densityDpi;
        }
        this.f5913a = bitmap;
        if (bitmap != null) {
            a();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        } else {
            this.f5925m = -1;
            this.f5924l = -1;
            bitmapShader = null;
        }
        this.f5917e = bitmapShader;
    }

    private void a() {
        this.f5924l = this.f5913a.getScaledWidth(this.f5914b);
        this.f5925m = this.f5913a.getScaledHeight(this.f5914b);
    }

    private static boolean j(float f2) {
        return f2 > 0.05f;
    }

    private void s() {
        this.f5919g = (float) (Math.min(this.f5925m, this.f5924l) / 2);
    }

    @Nullable
    public final Bitmap b() {
        return this.f5913a;
    }

    public float c() {
        return this.f5919g;
    }

    public int d() {
        return this.f5915c;
    }

    public void draw(@NonNull Canvas canvas) {
        Bitmap bitmap = this.f5913a;
        if (bitmap != null) {
            t();
            if (this.f5916d.getShader() == null) {
                canvas.drawBitmap(bitmap, (Rect) null, this.f5920h, this.f5916d);
                return;
            }
            RectF rectF = this.f5921i;
            float f2 = this.f5919g;
            canvas.drawRoundRect(rectF, f2, f2, this.f5916d);
        }
    }

    @NonNull
    public final Paint e() {
        return this.f5916d;
    }

    /* access modifiers changed from: package-private */
    public void f(int i2, int i3, int i4, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    public boolean g() {
        return this.f5916d.isAntiAlias();
    }

    public int getAlpha() {
        return this.f5916d.getAlpha();
    }

    public ColorFilter getColorFilter() {
        return this.f5916d.getColorFilter();
    }

    public int getIntrinsicHeight() {
        return this.f5925m;
    }

    public int getIntrinsicWidth() {
        return this.f5924l;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = r3.f5913a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getOpacity() {
        /*
            r3 = this;
            int r0 = r3.f5915c
            r1 = 119(0x77, float:1.67E-43)
            r2 = -3
            if (r0 != r1) goto L_0x002a
            boolean r0 = r3.f5923k
            if (r0 == 0) goto L_0x000c
            goto L_0x002a
        L_0x000c:
            android.graphics.Bitmap r0 = r3.f5913a
            if (r0 == 0) goto L_0x002a
            boolean r0 = r0.hasAlpha()
            if (r0 != 0) goto L_0x002a
            android.graphics.Paint r0 = r3.f5916d
            int r0 = r0.getAlpha()
            r1 = 255(0xff, float:3.57E-43)
            if (r0 < r1) goto L_0x002a
            float r0 = r3.f5919g
            boolean r0 = j(r0)
            if (r0 == 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r2 = -1
        L_0x002a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.RoundedBitmapDrawable.getOpacity():int");
    }

    public boolean h() {
        throw new UnsupportedOperationException();
    }

    public boolean i() {
        return this.f5923k;
    }

    public void k(boolean z) {
        this.f5916d.setAntiAlias(z);
        invalidateSelf();
    }

    public void l(boolean z) {
        this.f5923k = z;
        this.f5922j = true;
        if (z) {
            s();
            this.f5916d.setShader(this.f5917e);
            invalidateSelf();
            return;
        }
        m(0.0f);
    }

    public void m(float f2) {
        Paint paint;
        BitmapShader bitmapShader;
        if (this.f5919g != f2) {
            this.f5923k = false;
            if (j(f2)) {
                paint = this.f5916d;
                bitmapShader = this.f5917e;
            } else {
                paint = this.f5916d;
                bitmapShader = null;
            }
            paint.setShader(bitmapShader);
            this.f5919g = f2;
            invalidateSelf();
        }
    }

    public void n(int i2) {
        if (this.f5915c != i2) {
            this.f5915c = i2;
            this.f5922j = true;
            invalidateSelf();
        }
    }

    public void o(boolean z) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        if (this.f5923k) {
            s();
        }
        this.f5922j = true;
    }

    public void p(int i2) {
        if (this.f5914b != i2) {
            if (i2 == 0) {
                i2 = 160;
            }
            this.f5914b = i2;
            if (this.f5913a != null) {
                a();
            }
            invalidateSelf();
        }
    }

    public void q(@NonNull Canvas canvas) {
        p(canvas.getDensity());
    }

    public void r(@NonNull DisplayMetrics displayMetrics) {
        p(displayMetrics.densityDpi);
    }

    public void setAlpha(int i2) {
        if (i2 != this.f5916d.getAlpha()) {
            this.f5916d.setAlpha(i2);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f5916d.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setDither(boolean z) {
        this.f5916d.setDither(z);
        invalidateSelf();
    }

    public void setFilterBitmap(boolean z) {
        this.f5916d.setFilterBitmap(z);
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public void t() {
        if (this.f5922j) {
            if (this.f5923k) {
                int min = Math.min(this.f5924l, this.f5925m);
                f(this.f5915c, min, min, getBounds(), this.f5920h);
                int min2 = Math.min(this.f5920h.width(), this.f5920h.height());
                this.f5920h.inset(Math.max(0, (this.f5920h.width() - min2) / 2), Math.max(0, (this.f5920h.height() - min2) / 2));
                this.f5919g = ((float) min2) * 0.5f;
            } else {
                f(this.f5915c, this.f5924l, this.f5925m, getBounds(), this.f5920h);
            }
            this.f5921i.set(this.f5920h);
            if (this.f5917e != null) {
                Matrix matrix = this.f5918f;
                RectF rectF = this.f5921i;
                matrix.setTranslate(rectF.left, rectF.top);
                this.f5918f.preScale(this.f5921i.width() / ((float) this.f5913a.getWidth()), this.f5921i.height() / ((float) this.f5913a.getHeight()));
                this.f5917e.setLocalMatrix(this.f5918f);
                this.f5916d.setShader(this.f5917e);
            }
            this.f5922j = false;
        }
    }
}
