package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
class RoundRectDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private float f3517a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f3518b;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f3519c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f3520d;

    /* renamed from: e  reason: collision with root package name */
    private float f3521e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3522f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3523g = true;

    /* renamed from: h  reason: collision with root package name */
    private ColorStateList f3524h;

    /* renamed from: i  reason: collision with root package name */
    private PorterDuffColorFilter f3525i;

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f3526j;

    /* renamed from: k  reason: collision with root package name */
    private PorterDuff.Mode f3527k = PorterDuff.Mode.SRC_IN;

    RoundRectDrawable(ColorStateList colorStateList, float f2) {
        this.f3517a = f2;
        this.f3518b = new Paint(5);
        e(colorStateList);
        this.f3519c = new RectF();
        this.f3520d = new Rect();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void e(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f3524h = colorStateList;
        this.f3518b.setColor(colorStateList.getColorForState(getState(), this.f3524h.getDefaultColor()));
    }

    private void i(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f3519c.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.f3520d.set(rect);
        if (this.f3522f) {
            float d2 = RoundRectDrawableWithShadow.d(this.f3521e, this.f3517a, this.f3523g);
            this.f3520d.inset((int) Math.ceil((double) RoundRectDrawableWithShadow.c(this.f3521e, this.f3517a, this.f3523g)), (int) Math.ceil((double) d2));
            this.f3519c.set(this.f3520d);
        }
    }

    public ColorStateList b() {
        return this.f3524h;
    }

    /* access modifiers changed from: package-private */
    public float c() {
        return this.f3521e;
    }

    public float d() {
        return this.f3517a;
    }

    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.f3518b;
        if (this.f3525i == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.f3525i);
            z = true;
        }
        RectF rectF = this.f3519c;
        float f2 = this.f3517a;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        if (z) {
            paint.setColorFilter((ColorFilter) null);
        }
    }

    public void f(@Nullable ColorStateList colorStateList) {
        e(colorStateList);
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public void g(float f2, boolean z, boolean z2) {
        if (f2 != this.f3521e || this.f3522f != z || this.f3523g != z2) {
            this.f3521e = f2;
            this.f3522f = z;
            this.f3523g = z2;
            i((Rect) null);
            invalidateSelf();
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f3520d, this.f3517a);
    }

    /* access modifiers changed from: package-private */
    public void h(float f2) {
        if (f2 != this.f3517a) {
            this.f3517a = f2;
            i((Rect) null);
            invalidateSelf();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.f3524h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            android.content.res.ColorStateList r0 = r1.f3526j
            if (r0 == 0) goto L_0x000a
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x001a
        L_0x000a:
            android.content.res.ColorStateList r0 = r1.f3524h
            if (r0 == 0) goto L_0x0014
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x001a
        L_0x0014:
            boolean r0 = super.isStateful()
            if (r0 == 0) goto L_0x001c
        L_0x001a:
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.cardview.widget.RoundRectDrawable.isStateful():boolean");
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        i(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f3524h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z = colorForState != this.f3518b.getColor();
        if (z) {
            this.f3518b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f3526j;
        if (colorStateList2 == null || (mode = this.f3527k) == null) {
            return z;
        }
        this.f3525i = a(colorStateList2, mode);
        return true;
    }

    public void setAlpha(int i2) {
        this.f3518b.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f3518b.setColorFilter(colorFilter);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f3526j = colorStateList;
        this.f3525i = a(colorStateList, this.f3527k);
        invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f3527k = mode;
        this.f3525i = a(this.f3526j, mode);
        invalidateSelf();
    }
}
