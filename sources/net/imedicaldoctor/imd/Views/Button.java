package net.imedicaldoctor.imd.Views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import net.imedicaldoctor.imd.R;

public abstract class Button extends CustomView {
    static final String p3 = "http://schemas.android.com/apk/res/android";
    int c3;
    int d3;
    int e3;
    float f3 = 12.0f;
    int g3 = 3;
    Integer h3;
    View.OnClickListener i3;
    boolean j3 = true;
    int k3 = Color.parseColor("#1E88E5");
    TextView l3;
    float m3 = -1.0f;
    float n3 = -1.0f;
    float o3 = -1.0f;

    public Button(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
        this.j3 = attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res-auto", "animate", true);
        setAttributes(attributeSet);
        this.X2 = this.k3;
        if (this.h3 == null) {
            this.h3 = Integer.valueOf(b());
        }
    }

    public Bitmap a() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth() - Utils.a(6.0f, getResources()), getHeight() - Utils.a(7.0f, getResources()), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawARGB(0, 0, 0, 0);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(this.h3.intValue());
        canvas.drawCircle(this.m3, this.n3, this.o3, paint);
        if (this.o3 > ((float) (getHeight() / this.g3))) {
            this.o3 += this.f3;
        }
        if (this.o3 >= ((float) getWidth())) {
            this.m3 = -1.0f;
            this.n3 = -1.0f;
            this.o3 = (float) (getHeight() / this.g3);
            View.OnClickListener onClickListener = this.i3;
            if (onClickListener != null && this.j3) {
                onClickListener.onClick(this);
            }
        }
        return createBitmap;
    }

    /* access modifiers changed from: protected */
    public int b() {
        int i2 = this.k3;
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
    public void c() {
        setMinimumHeight(Utils.a((float) this.d3, getResources()));
        setMinimumWidth(Utils.a((float) this.c3, getResources()));
        setBackgroundResource(this.e3);
        setBackgroundColor(this.k3);
    }

    public float getRippleSpeed() {
        return this.f3;
    }

    public String getText() {
        return this.l3.getText().toString();
    }

    public TextView getTextView() {
        return this.l3;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        if (!z) {
            this.m3 = -1.0f;
            this.n3 = -1.0f;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0073, code lost:
        if (r7.getY() >= 0.0f) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c4, code lost:
        if (r7.getAction() == 3) goto L_0x0075;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            r6.invalidate()
            boolean r0 = r6.isEnabled()
            r1 = 1
            if (r0 == 0) goto L_0x00c7
            r6.Y2 = r1
            int r0 = r7.getAction()
            if (r0 != 0) goto L_0x002a
            int r0 = r6.getHeight()
            int r2 = r6.g3
            int r0 = r0 / r2
            float r0 = (float) r0
            r6.o3 = r0
            float r0 = r7.getX()
            r6.m3 = r0
            float r7 = r7.getY()
            r6.n3 = r7
            goto L_0x00c7
        L_0x002a:
            int r0 = r7.getAction()
            r2 = 2
            r3 = 0
            r4 = 0
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r0 != r2) goto L_0x007c
            int r0 = r6.getHeight()
            int r2 = r6.g3
            int r0 = r0 / r2
            float r0 = (float) r0
            r6.o3 = r0
            float r0 = r7.getX()
            r6.m3 = r0
            float r0 = r7.getY()
            r6.n3 = r0
            float r0 = r7.getX()
            int r2 = r6.getWidth()
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x0075
            float r0 = r7.getX()
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x0075
            float r0 = r7.getY()
            int r2 = r6.getHeight()
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x0075
            float r7 = r7.getY()
            int r7 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r7 >= 0) goto L_0x00c7
        L_0x0075:
            r6.Y2 = r3
            r6.m3 = r5
            r6.n3 = r5
            goto L_0x00c7
        L_0x007c:
            int r0 = r7.getAction()
            if (r0 != r1) goto L_0x00bf
            float r0 = r7.getX()
            int r2 = r6.getWidth()
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x0075
            float r0 = r7.getX()
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x0075
            float r0 = r7.getY()
            int r2 = r6.getHeight()
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x0075
            float r7 = r7.getY()
            int r7 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r7 < 0) goto L_0x0075
            float r7 = r6.o3
            r0 = 1065353216(0x3f800000, float:1.0)
            float r7 = r7 + r0
            r6.o3 = r7
            boolean r7 = r6.j3
            if (r7 != 0) goto L_0x00c7
            android.view.View$OnClickListener r7 = r6.i3
            if (r7 == 0) goto L_0x00c7
            r7.onClick(r6)
            goto L_0x00c7
        L_0x00bf:
            int r7 = r7.getAction()
            r0 = 3
            if (r7 != r0) goto L_0x00c7
            goto L_0x0075
        L_0x00c7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Views.Button.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: protected */
    public abstract void setAttributes(AttributeSet attributeSet);

    public void setBackgroundColor(int i2) {
        this.k3 = i2;
        if (isEnabled()) {
            this.X2 = this.k3;
        }
        try {
            ((GradientDrawable) ((LayerDrawable) getBackground()).findDrawableByLayerId(R.id.f1072shape_bacground)).setColor(this.k3);
            this.h3 = Integer.valueOf(b());
        } catch (Exception unused) {
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.i3 = onClickListener;
    }

    public void setRippleSpeed(float f2) {
        this.f3 = f2;
    }

    public void setText(String str) {
        this.l3.setText(str);
    }

    public void setTextColor(int i2) {
        this.l3.setTextColor(i2);
    }
}
