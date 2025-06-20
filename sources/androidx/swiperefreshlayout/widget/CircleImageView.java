package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

class CircleImageView extends ImageView {
    private static final int Y2 = 503316480;
    private static final int Z2 = 1023410176;
    private static final float a3 = 0.0f;
    private static final float b3 = 1.75f;
    private static final float c3 = 3.5f;
    private static final int d3 = 4;
    int X2;
    private Animation.AnimationListener s;

    private class OvalShadow extends OvalShape {
        private Paint X = new Paint();
        private RadialGradient s;

        OvalShadow(int i2) {
            CircleImageView.this.X2 = i2;
            a((int) rect().width());
        }

        private void a(int i2) {
            float f2 = (float) (i2 / 2);
            RadialGradient radialGradient = new RadialGradient(f2, f2, (float) CircleImageView.this.X2, new int[]{CircleImageView.Z2, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.s = radialGradient;
            this.X.setShader(radialGradient);
        }

        public void draw(Canvas canvas, Paint paint) {
            int width = CircleImageView.this.getWidth() / 2;
            float f2 = (float) width;
            float height = (float) (CircleImageView.this.getHeight() / 2);
            canvas.drawCircle(f2, height, f2, this.X);
            canvas.drawCircle(f2, height, (float) (width - CircleImageView.this.X2), paint);
        }

        /* access modifiers changed from: protected */
        public void onResize(float f2, float f3) {
            super.onResize(f2, f3);
            a((int) f2);
        }
    }

    CircleImageView(Context context, int i2) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f2 = getContext().getResources().getDisplayMetrics().density;
        int i3 = (int) (b3 * f2);
        int i4 = (int) (0.0f * f2);
        this.X2 = (int) (c3 * f2);
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ViewCompat.V1(this, f2 * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new OvalShadow(this.X2));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer((float) this.X2, (float) i4, (float) i3, Y2);
            int i5 = this.X2;
            setPadding(i5, i5, i5, i5);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i2);
        ViewCompat.P1(this, shapeDrawable);
    }

    private boolean a() {
        return true;
    }

    public void b(Animation.AnimationListener animationListener) {
        this.s = animationListener;
    }

    public void c(int i2) {
        setBackgroundColor(ContextCompat.g(getContext(), i2));
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.s;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.s;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (!a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.X2 * 2), getMeasuredHeight() + (this.X2 * 2));
        }
    }

    public void setBackgroundColor(int i2) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i2);
        }
    }
}
