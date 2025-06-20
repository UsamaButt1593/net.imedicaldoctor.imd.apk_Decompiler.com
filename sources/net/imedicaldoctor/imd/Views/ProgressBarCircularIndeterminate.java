package net.imedicaldoctor.imd.Views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.itextpdf.tool.xml.css.CSS;

public class ProgressBarCircularIndeterminate extends CustomView {
    static final String l3 = "http://schemas.android.com/apk/res/android";
    int c3 = Color.parseColor("#1E88E5");
    float d3 = 0.0f;
    float e3 = 0.0f;
    int f3 = 0;
    boolean g3 = false;
    int h3 = 1;
    int i3 = 0;
    float j3 = 0.0f;
    int k3 = 0;

    public ProgressBarCircularIndeterminate(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setAttributes(attributeSet);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.graphics.Canvas r11) {
        /*
            r10 = this;
            float r0 = r10.d3
            int r1 = r10.getWidth()
            int r1 = r1 / 2
            float r1 = (float) r1
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = 1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x004f
            android.graphics.Paint r0 = new android.graphics.Paint
            r0.<init>()
            r0.setAntiAlias(r4)
            int r1 = r10.c()
            r0.setColor(r1)
            float r1 = r10.d3
            int r4 = r10.getWidth()
            int r4 = r4 / 2
            float r4 = (float) r4
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 < 0) goto L_0x0035
            int r1 = r10.getWidth()
            float r1 = (float) r1
            float r1 = r1 / r3
            goto L_0x0038
        L_0x0035:
            float r1 = r10.d3
            float r1 = r1 + r2
        L_0x0038:
            r10.d3 = r1
            int r1 = r10.getWidth()
            int r1 = r1 / 2
            float r1 = (float) r1
            int r2 = r10.getHeight()
            int r2 = r2 / 2
            float r2 = (float) r2
            float r3 = r10.d3
            r11.drawCircle(r1, r2, r3, r0)
            goto L_0x0138
        L_0x004f:
            int r0 = r11.getWidth()
            int r1 = r11.getHeight()
            android.graphics.Bitmap$Config r5 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r1, r5)
            android.graphics.Canvas r1 = new android.graphics.Canvas
            r1.<init>(r0)
            android.graphics.Paint r5 = new android.graphics.Paint
            r5.<init>()
            r5.setAntiAlias(r4)
            int r6 = r10.c()
            r5.setColor(r6)
            int r6 = r10.getWidth()
            int r6 = r6 / 2
            float r6 = (float) r6
            int r7 = r10.getHeight()
            int r7 = r7 / 2
            float r7 = (float) r7
            int r8 = r10.getHeight()
            int r8 = r8 / 2
            float r8 = (float) r8
            r1.drawCircle(r6, r7, r8, r5)
            android.graphics.Paint r5 = new android.graphics.Paint
            r5.<init>()
            r5.setAntiAlias(r4)
            android.content.res.Resources r6 = r10.getResources()
            r7 = 17170445(0x106000d, float:2.461195E-38)
            int r6 = r6.getColor(r7)
            r5.setColor(r6)
            android.graphics.PorterDuffXfermode r6 = new android.graphics.PorterDuffXfermode
            android.graphics.PorterDuff$Mode r7 = android.graphics.PorterDuff.Mode.CLEAR
            r6.<init>(r7)
            r5.setXfermode(r6)
            int r6 = r10.f3
            r7 = 50
            r8 = 1082130432(0x40800000, float:4.0)
            if (r6 < r7) goto L_0x00cb
            float r6 = r10.e3
            int r7 = r10.getWidth()
            int r7 = r7 / 2
            float r7 = (float) r7
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 < 0) goto L_0x00c5
            int r2 = r10.getWidth()
            float r2 = (float) r2
            float r2 = r2 / r3
            goto L_0x00c8
        L_0x00c5:
            float r3 = r10.e3
            float r2 = r2 + r3
        L_0x00c8:
            r10.e3 = r2
            goto L_0x00f2
        L_0x00cb:
            float r6 = r10.e3
            int r7 = r10.getWidth()
            int r7 = r7 / 2
            android.content.res.Resources r9 = r10.getResources()
            int r9 = net.imedicaldoctor.imd.Views.Utils.a(r8, r9)
            int r7 = r7 - r9
            float r7 = (float) r7
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 < 0) goto L_0x00c5
            int r2 = r10.getWidth()
            float r2 = (float) r2
            float r2 = r2 / r3
            android.content.res.Resources r3 = r10.getResources()
            int r3 = net.imedicaldoctor.imd.Views.Utils.a(r8, r3)
            float r3 = (float) r3
            float r2 = r2 - r3
            goto L_0x00c8
        L_0x00f2:
            int r2 = r10.getWidth()
            int r2 = r2 / 2
            float r2 = (float) r2
            int r3 = r10.getHeight()
            int r3 = r3 / 2
            float r3 = (float) r3
            float r6 = r10.e3
            r1.drawCircle(r2, r3, r6, r5)
            android.graphics.Paint r1 = new android.graphics.Paint
            r1.<init>()
            r2 = 0
            r11.drawBitmap(r0, r2, r2, r1)
            float r11 = r10.e3
            int r0 = r10.getWidth()
            int r0 = r0 / 2
            android.content.res.Resources r1 = r10.getResources()
            int r1 = net.imedicaldoctor.imd.Views.Utils.a(r8, r1)
            int r0 = r0 - r1
            float r0 = (float) r0
            int r11 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r11 < 0) goto L_0x0129
            int r11 = r10.f3
            int r11 = r11 + r4
            r10.f3 = r11
        L_0x0129:
            float r11 = r10.e3
            int r0 = r10.getWidth()
            int r0 = r0 / 2
            float r0 = (float) r0
            int r11 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r11 < 0) goto L_0x0138
            r10.g3 = r4
        L_0x0138:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Views.ProgressBarCircularIndeterminate.a(android.graphics.Canvas):void");
    }

    private void b(Canvas canvas) {
        int i2 = this.i3;
        int i4 = this.k3;
        if (i2 == i4) {
            this.h3 += 6;
        }
        int i5 = this.h3;
        if (i5 >= 290 || i2 > i4) {
            this.i3 = i2 + 6;
            this.h3 = i5 - 6;
        }
        int i6 = this.i3;
        if (i6 > i4 + TIFFConstants.G0) {
            this.k3 = i6;
            this.i3 = i6;
            this.h3 = 1;
        }
        float f2 = this.j3 + 4.0f;
        this.j3 = f2;
        canvas.rotate(f2, (float) (getWidth() / 2), (float) (getHeight() / 2));
        Bitmap createBitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(this.c3);
        canvas2.drawArc(new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()), (float) this.i3, (float) this.h3, true, paint);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setColor(getResources().getColor(17170445));
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) ((getWidth() / 2) - Utils.a(4.0f, getResources())), paint2);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, new Paint());
    }

    /* access modifiers changed from: protected */
    public int c() {
        int i2 = this.c3;
        return Color.argb(128, (i2 >> 16) & 255, (i2 >> 8) & 255, i2 & 255);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.g3) {
            a(canvas);
        }
        if (this.f3 > 0) {
            b(canvas);
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void setAttributes(AttributeSet attributeSet) {
        int attributeIntValue;
        setMinimumHeight(Utils.a(32.0f, getResources()));
        setMinimumWidth(Utils.a(32.0f, getResources()));
        int attributeResourceValue = attributeSet.getAttributeResourceValue(l3, CSS.Property.f27458a, -1);
        if (attributeResourceValue != -1) {
            attributeIntValue = getResources().getColor(attributeResourceValue);
        } else {
            attributeIntValue = attributeSet.getAttributeIntValue(l3, CSS.Property.f27458a, -1);
            if (attributeIntValue == -1) {
                attributeIntValue = Color.parseColor("#1E88E5");
            }
        }
        setBackgroundColor(attributeIntValue);
        setMinimumHeight(Utils.a(3.0f, getResources()));
    }

    public void setBackgroundColor(int i2) {
        super.setBackgroundColor(getResources().getColor(17170445));
        if (isEnabled()) {
            this.X2 = this.c3;
        }
        this.c3 = i2;
    }
}
