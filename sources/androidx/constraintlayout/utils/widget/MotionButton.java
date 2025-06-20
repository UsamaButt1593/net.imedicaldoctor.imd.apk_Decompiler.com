package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.R;

public class MotionButton extends AppCompatButton {
    /* access modifiers changed from: private */
    public float Z2 = 0.0f;
    /* access modifiers changed from: private */
    public float a3 = Float.NaN;
    private Path b3;
    ViewOutlineProvider c3;
    RectF d3;

    public MotionButton(Context context) {
        super(context);
        d(context, (AttributeSet) null);
    }

    private void d(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ue);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.Fe) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.Ge) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getRound() {
        return this.a3;
    }

    public float getRoundPercent() {
        return this.Z2;
    }

    @RequiresApi(21)
    public void setRound(float f2) {
        if (Float.isNaN(f2)) {
            this.a3 = f2;
            float f3 = this.Z2;
            this.Z2 = -1.0f;
            setRoundPercent(f3);
            return;
        }
        boolean z = this.a3 != f2;
        this.a3 = f2;
        if (f2 != 0.0f) {
            if (this.b3 == null) {
                this.b3 = new Path();
            }
            if (this.d3 == null) {
                this.d3 = new RectF();
            }
            if (this.c3 == null) {
                AnonymousClass2 r5 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, MotionButton.this.getWidth(), MotionButton.this.getHeight(), MotionButton.this.a3);
                    }
                };
                this.c3 = r5;
                setOutlineProvider(r5);
            }
            setClipToOutline(true);
            this.d3.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.b3.reset();
            Path path = this.b3;
            RectF rectF = this.d3;
            float f4 = this.a3;
            path.addRoundRect(rectF, f4, f4, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    @RequiresApi(21)
    public void setRoundPercent(float f2) {
        boolean z = this.Z2 != f2;
        this.Z2 = f2;
        if (f2 != 0.0f) {
            if (this.b3 == null) {
                this.b3 = new Path();
            }
            if (this.d3 == null) {
                this.d3 = new RectF();
            }
            if (this.c3 == null) {
                AnonymousClass1 r6 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        int width = MotionButton.this.getWidth();
                        int height = MotionButton.this.getHeight();
                        outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * MotionButton.this.Z2) / 2.0f);
                    }
                };
                this.c3 = r6;
                setOutlineProvider(r6);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.Z2) / 2.0f;
            this.d3.set(0.0f, 0.0f, (float) width, (float) height);
            this.b3.reset();
            this.b3.addRoundRect(this.d3, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public MotionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d(context, attributeSet);
    }

    public MotionButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        d(context, attributeSet);
    }
}
