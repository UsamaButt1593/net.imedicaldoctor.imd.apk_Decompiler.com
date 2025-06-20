package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;

public class MotionTelltales extends MockView {
    private static final String o3 = "MotionTelltales";
    private Paint h3 = new Paint();
    MotionLayout i3;
    float[] j3 = new float[2];
    Matrix k3 = new Matrix();
    int l3 = 0;
    int m3 = -65281;
    float n3 = 0.25f;

    public MotionTelltales(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.tk);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.uk) {
                    this.m3 = obtainStyledAttributes.getColor(index, this.m3);
                } else if (index == R.styleable.wk) {
                    this.l3 = obtainStyledAttributes.getInt(index, this.l3);
                } else if (index == R.styleable.vk) {
                    this.n3 = obtainStyledAttributes.getFloat(index, this.n3);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.h3.setColor(this.m3);
        this.h3.setStrokeWidth(5.0f);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getMatrix().invert(this.k3);
        if (this.i3 == null) {
            ViewParent parent = getParent();
            if (parent instanceof MotionLayout) {
                this.i3 = (MotionLayout) parent;
                return;
            }
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float[] fArr = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        for (int i2 = 0; i2 < 5; i2++) {
            float f2 = fArr[i2];
            for (int i4 = 0; i4 < 5; i4++) {
                float f3 = fArr[i4];
                this.i3.G0(this, f3, f2, this.j3, this.l3);
                this.k3.mapVectors(this.j3);
                float f4 = ((float) width) * f3;
                float f5 = ((float) height) * f2;
                float[] fArr2 = this.j3;
                float f6 = fArr2[0];
                float f7 = this.n3;
                float f8 = f5 - (fArr2[1] * f7);
                this.k3.mapVectors(fArr2);
                canvas.drawLine(f4, f5, f4 - (f6 * f7), f8, this.h3);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i4, int i5, int i6) {
        super.onLayout(z, i2, i4, i5, i6);
        postInvalidate();
    }

    public void setText(CharSequence charSequence) {
        this.b3 = charSequence.toString();
        requestLayout();
    }

    public MotionTelltales(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }
}
