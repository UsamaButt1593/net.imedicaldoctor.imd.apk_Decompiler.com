package com.dd;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.dd.shadow.layout.R;

public class ShadowLayout extends FrameLayout {
    private float X2;
    private float Y2;
    private float Z2;
    private float a3;
    private boolean b3 = true;
    private boolean c3 = false;
    private int s;

    public ShadowLayout(Context context) {
        super(context);
        d(context, (AttributeSet) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap a(int r5, int r6, float r7, float r8, float r9, float r10, int r11, int r12) {
        /*
            r4 = this;
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ALPHA_8
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r5, r6, r0)
            android.graphics.Canvas r1 = new android.graphics.Canvas
            r1.<init>(r0)
            android.graphics.RectF r2 = new android.graphics.RectF
            float r5 = (float) r5
            float r5 = r5 - r8
            float r6 = (float) r6
            float r6 = r6 - r8
            r2.<init>(r8, r8, r5, r6)
            r5 = 0
            int r6 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r6 <= 0) goto L_0x0024
            float r6 = r2.top
            float r6 = r6 + r10
            r2.top = r6
            float r6 = r2.bottom
            float r6 = r6 - r10
        L_0x0021:
            r2.bottom = r6
            goto L_0x0039
        L_0x0024:
            int r6 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r6 >= 0) goto L_0x0039
            float r6 = r2.top
            float r3 = java.lang.Math.abs(r10)
            float r6 = r6 + r3
            r2.top = r6
            float r6 = r2.bottom
            float r3 = java.lang.Math.abs(r10)
            float r6 = r6 - r3
            goto L_0x0021
        L_0x0039:
            int r6 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r6 <= 0) goto L_0x0048
            float r5 = r2.left
            float r5 = r5 + r9
            r2.left = r5
            float r5 = r2.right
            float r5 = r5 - r9
        L_0x0045:
            r2.right = r5
            goto L_0x005d
        L_0x0048:
            int r5 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r5 >= 0) goto L_0x005d
            float r5 = r2.left
            float r6 = java.lang.Math.abs(r9)
            float r5 = r5 + r6
            r2.left = r5
            float r5 = r2.right
            float r6 = java.lang.Math.abs(r9)
            float r5 = r5 - r6
            goto L_0x0045
        L_0x005d:
            android.graphics.Paint r5 = new android.graphics.Paint
            r5.<init>()
            r6 = 1
            r5.setAntiAlias(r6)
            r5.setColor(r12)
            android.graphics.Paint$Style r6 = android.graphics.Paint.Style.FILL
            r5.setStyle(r6)
            boolean r6 = r4.isInEditMode()
            if (r6 != 0) goto L_0x0077
            r5.setShadowLayer(r8, r9, r10, r11)
        L_0x0077:
            r1.drawRoundRect(r2, r7, r7, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dd.ShadowLayout.a(int, int, float, float, float, float, int, int):android.graphics.Bitmap");
    }

    private TypedArray b(Context context, AttributeSet attributeSet, int[] iArr) {
        return context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray b2 = b(context, attributeSet, R.styleable.f18708a);
        if (b2 != null) {
            try {
                this.Y2 = b2.getDimension(R.styleable.f18709b, getResources().getDimension(R.dimen.f18706a));
                this.X2 = b2.getDimension(R.styleable.f18713f, getResources().getDimension(R.dimen.f18707b));
                this.Z2 = b2.getDimension(R.styleable.f18710c, 0.0f);
                this.a3 = b2.getDimension(R.styleable.f18711d, 0.0f);
                this.s = b2.getColor(R.styleable.f18712e, getResources().getColor(R.color.f18705b));
            } finally {
                b2.recycle();
            }
        }
    }

    private void d(Context context, AttributeSet attributeSet) {
        c(context, attributeSet);
        int abs = (int) (this.X2 + Math.abs(this.Z2));
        int abs2 = (int) (this.X2 + Math.abs(this.a3));
        setPadding(abs, abs2, abs, abs2);
    }

    private void f(int i2, int i3) {
        setBackground(new BitmapDrawable(getResources(), a(i2, i3, this.Y2, this.X2, this.Z2, this.a3, this.s, 0)));
    }

    public void e() {
        this.c3 = true;
        requestLayout();
        invalidate();
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.c3) {
            this.c3 = false;
            f(i4 - i2, i5 - i3);
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 > 0 && i3 > 0) {
            if (getBackground() == null || this.b3 || this.c3) {
                this.c3 = false;
                f(i2, i3);
            }
        }
    }

    public void setInvalidateShadowOnSizeChanged(boolean z) {
        this.b3 = z;
    }

    public ShadowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d(context, attributeSet);
    }

    public ShadowLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        d(context, attributeSet);
    }
}
