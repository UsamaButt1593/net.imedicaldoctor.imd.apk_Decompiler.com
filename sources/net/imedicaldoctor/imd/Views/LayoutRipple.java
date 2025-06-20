package net.imedicaldoctor.imd.Views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.itextpdf.tool.xml.css.CSS;

public class LayoutRipple extends CustomView {
    int c3;
    float d3 = 10.0f;
    int e3 = 3;
    View.OnClickListener f3;
    int g3 = Color.parseColor("#FFFFFF");
    Integer h3;
    Float i3;
    Float j3;
    float k3 = -1.0f;
    float l3 = -1.0f;
    float m3 = -1.0f;

    public LayoutRipple(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setAttributes(attributeSet);
    }

    public Bitmap a() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawARGB(0, 0, 0, 0);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        if (this.h3 == null) {
            this.h3 = Integer.valueOf(b());
        }
        paint.setColor(this.h3.intValue());
        Float f2 = this.i3;
        this.k3 = f2 == null ? this.k3 : f2.floatValue();
        Float f4 = this.j3;
        float floatValue = f4 == null ? this.l3 : f4.floatValue();
        this.l3 = floatValue;
        canvas.drawCircle(this.k3, floatValue, this.m3, paint);
        if (this.m3 > ((float) (getHeight() / this.e3))) {
            this.m3 += this.d3;
        }
        if (this.m3 >= ((float) getWidth())) {
            this.k3 = -1.0f;
            this.l3 = -1.0f;
            this.m3 = (float) (getHeight() / this.e3);
            View.OnClickListener onClickListener = this.f3;
            if (onClickListener != null) {
                onClickListener.onClick(this);
            }
        }
        return createBitmap;
    }

    /* access modifiers changed from: protected */
    public int b() {
        int i2 = this.g3;
        int i4 = (i2 >> 8) & 255;
        int i5 = i2 & 255;
        int i6 = ((i2 >> 16) & 255) - 30;
        int i7 = 0;
        if (i6 < 0) {
            i6 = 0;
        }
        int i8 = i4 - 30;
        if (i8 < 0) {
            i8 = 0;
        }
        int i9 = i5 - 30;
        if (i9 >= 0) {
            i7 = i9;
        }
        return Color.rgb(i6, i8, i7);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.k3 != -1.0f) {
            canvas.drawBitmap(a(), new Rect(0, 0, getWidth(), getHeight()), new Rect(0, 0, getWidth(), getHeight()), (Paint) null);
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        if (!z) {
            this.k3 = -1.0f;
            this.l3 = -1.0f;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0073, code lost:
        if (r7.getY() >= 0.0f) goto L_0x00b3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            r6.invalidate()
            boolean r0 = r6.isEnabled()
            r1 = 1
            if (r0 == 0) goto L_0x00c0
            r6.Y2 = r1
            int r0 = r7.getAction()
            r2 = 0
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r0 != 0) goto L_0x002d
            int r0 = r6.getHeight()
            int r4 = r6.e3
            int r0 = r0 / r4
            float r0 = (float) r0
            r6.m3 = r0
            float r0 = r7.getX()
            r6.k3 = r0
            float r0 = r7.getY()
            r6.l3 = r0
            goto L_0x00b3
        L_0x002d:
            int r0 = r7.getAction()
            r4 = 2
            r5 = 0
            if (r0 != r4) goto L_0x007c
            int r0 = r6.getHeight()
            int r4 = r6.e3
            int r0 = r0 / r4
            float r0 = (float) r0
            r6.m3 = r0
            float r0 = r7.getX()
            r6.k3 = r0
            float r0 = r7.getY()
            r6.l3 = r0
            float r0 = r7.getX()
            int r4 = r6.getWidth()
            float r4 = (float) r4
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x0075
            float r0 = r7.getX()
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x0075
            float r0 = r7.getY()
            int r4 = r6.getHeight()
            float r4 = (float) r4
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x0075
            float r0 = r7.getY()
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x00b3
        L_0x0075:
            r6.Y2 = r2
            r6.k3 = r3
            r6.l3 = r3
            goto L_0x00b3
        L_0x007c:
            int r0 = r7.getAction()
            if (r0 != r1) goto L_0x00b3
            float r0 = r7.getX()
            int r4 = r6.getWidth()
            float r4 = (float) r4
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x0075
            float r0 = r7.getX()
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x0075
            float r0 = r7.getY()
            int r4 = r6.getHeight()
            float r4 = (float) r4
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x0075
            float r0 = r7.getY()
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x0075
            float r0 = r6.m3
            r4 = 1065353216(0x3f800000, float:1.0)
            float r0 = r0 + r4
            r6.m3 = r0
        L_0x00b3:
            int r7 = r7.getAction()
            r0 = 3
            if (r7 != r0) goto L_0x00c0
            r6.Y2 = r2
            r6.k3 = r3
            r6.l3 = r3
        L_0x00c0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Views.LayoutRipple.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: protected */
    public void setAttributes(AttributeSet attributeSet) {
        int attributeIntValue;
        int attributeIntValue2;
        int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", CSS.Property.f27458a, -1);
        if (attributeResourceValue != -1) {
            attributeIntValue = getResources().getColor(attributeResourceValue);
        } else {
            attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", CSS.Property.f27458a, -1);
            this.c3 = attributeIntValue;
            if (attributeIntValue == -1) {
                attributeIntValue = this.g3;
            }
        }
        setBackgroundColor(attributeIntValue);
        int attributeResourceValue2 = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res-auto", "rippleColor", -1);
        if (attributeResourceValue2 != -1) {
            attributeIntValue2 = getResources().getColor(attributeResourceValue2);
        } else {
            attributeIntValue2 = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res-auto", "rippleColor", -1);
            if (attributeIntValue2 == -1) {
                attributeIntValue2 = b();
            }
        }
        setRippleColor(attributeIntValue2);
        this.d3 = attributeSet.getAttributeFloatValue("http://schemas.android.com/apk/res-auto", "rippleSpeed", 20.0f);
    }

    public void setBackgroundColor(int i2) {
        this.g3 = i2;
        if (isEnabled()) {
            this.X2 = this.g3;
        }
        super.setBackgroundColor(i2);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f3 = onClickListener;
    }

    public void setRippleColor(int i2) {
        this.h3 = Integer.valueOf(i2);
    }

    public void setRippleSpeed(int i2) {
        this.d3 = (float) i2;
    }

    public void setxRippleOrigin(Float f2) {
        this.i3 = f2;
    }

    public void setyRippleOrigin(Float f2) {
        this.j3 = f2;
    }
}
