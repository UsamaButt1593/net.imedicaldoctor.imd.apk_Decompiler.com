package net.imedicaldoctor.imd.Views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.nineoldandroids.animation.ObjectAnimator;
import net.imedicaldoctor.imd.R;

public class ButtonFloat extends Button {
    int q3 = 24;
    int r3 = 28;
    ImageView s3;
    Drawable t3;
    public boolean u3 = false;
    float v3;
    float w3;
    Integer x3;
    Integer y3;

    public ButtonFloat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBackgroundResource(R.drawable.f542background_button_float);
        setBackgroundColor(this.k3);
        this.r3 = 28;
        c();
        ImageView imageView = new ImageView(context);
        this.s3 = imageView;
        imageView.setAdjustViewBounds(true);
        this.s3.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Drawable drawable = this.t3;
        if (drawable != null) {
            this.s3.setImageDrawable(drawable);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Utils.a((float) this.q3, getResources()), Utils.a((float) this.q3, getResources()));
        layoutParams.addRule(13, -1);
        this.s3.setLayoutParams(layoutParams);
        addView(this.s3);
    }

    /* access modifiers changed from: protected */
    public void c() {
        this.f3 = (float) Utils.a(2.0f, getResources());
        this.g3 = Utils.a(5.0f, getResources());
        setMinimumWidth(Utils.a((float) (this.r3 * 2), getResources()));
        setMinimumHeight(Utils.a((float) (this.r3 * 2), getResources()));
        this.e3 = R.drawable.f542background_button_float;
    }

    public Bitmap d(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawCircle((float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2), (float) (bitmap.getWidth() / 2), paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public void e() {
        ObjectAnimator S0 = ObjectAnimator.S0(this, "y", this.w3);
        S0.n(new BounceInterpolator());
        S0.v0(1500);
        S0.s();
        this.u3 = false;
    }

    public boolean f() {
        return this.u3;
    }

    public void g() {
        ObjectAnimator S0 = ObjectAnimator.S0(this, "y", this.v3);
        S0.n(new BounceInterpolator());
        S0.v0(1500);
        S0.s();
        this.u3 = true;
    }

    public Drawable getDrawableIcon() {
        return this.t3;
    }

    public ImageView getIcon() {
        return this.s3;
    }

    public TextView getTextView() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.m3 != -1.0f) {
            canvas.drawBitmap(d(a()), new Rect(0, 0, getWidth(), getHeight()), new Rect(Utils.a(1.0f, getResources()), Utils.a(2.0f, getResources()), getWidth() - Utils.a(1.0f, getResources()), getHeight() - Utils.a(2.0f, getResources())), (Paint) null);
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001d, code lost:
        if (r0 != -1) goto L_0x0013;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setAttributes(android.util.AttributeSet r5) {
        /*
            r4 = this;
            java.lang.String r0 = "http://schemas.android.com/apk/res/android"
            java.lang.String r1 = "background"
            r2 = -1
            int r3 = r5.getAttributeResourceValue(r0, r1, r2)
            if (r3 == r2) goto L_0x0017
            android.content.res.Resources r0 = r4.getResources()
            int r0 = r0.getColor(r3)
        L_0x0013:
            r4.setBackgroundColor(r0)
            goto L_0x0020
        L_0x0017:
            int r0 = r5.getAttributeIntValue(r0, r1, r2)
            r4.e3 = r0
            if (r0 == r2) goto L_0x0020
            goto L_0x0013
        L_0x0020:
            java.lang.String r0 = "http://schemas.android.com/apk/res-auto"
            java.lang.String r1 = "rippleColor"
            int r3 = r5.getAttributeResourceValue(r0, r1, r2)
            if (r3 == r2) goto L_0x0036
            android.content.res.Resources r1 = r4.getResources()
            int r1 = r1.getColor(r3)
        L_0x0032:
            r4.setRippleColor(r1)
            goto L_0x0042
        L_0x0036:
            int r1 = r5.getAttributeIntValue(r0, r1, r2)
            if (r1 == r2) goto L_0x003d
            goto L_0x0032
        L_0x003d:
            int r1 = r4.b()
            goto L_0x0032
        L_0x0042:
            java.lang.String r1 = "iconDrawable"
            int r1 = r5.getAttributeResourceValue(r0, r1, r2)
            if (r1 == r2) goto L_0x0054
            android.content.res.Resources r2 = r4.getResources()
            android.graphics.drawable.Drawable r1 = r2.getDrawable(r1)
            r4.t3 = r1
        L_0x0054:
            java.lang.String r1 = "animate"
            r2 = 0
            boolean r5 = r5.getAttributeBooleanValue(r0, r1, r2)
            net.imedicaldoctor.imd.Views.ButtonFloat$1 r0 = new net.imedicaldoctor.imd.Views.ButtonFloat$1
            r0.<init>(r5)
            r4.post(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.Views.ButtonFloat.setAttributes(android.util.AttributeSet):void");
    }

    public void setDrawableIcon(Drawable drawable) {
        this.t3 = drawable;
        try {
            this.s3.setBackground(drawable);
        } catch (NoSuchMethodError unused) {
            this.s3.setBackgroundDrawable(drawable);
        }
    }

    public void setIcon(ImageView imageView) {
        this.s3 = imageView;
    }

    public void setRippleColor(int i2) {
        this.h3 = Integer.valueOf(i2);
    }
}
