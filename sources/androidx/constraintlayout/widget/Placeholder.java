package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Placeholder extends View {
    private View X2 = null;
    private int Y2 = 4;
    private int s = -1;

    public Placeholder(Context context) {
        super(context);
        a((AttributeSet) null);
    }

    private void a(AttributeSet attributeSet) {
        super.setVisibility(this.Y2);
        this.s = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.P8);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.Q8) {
                    this.s = obtainStyledAttributes.getResourceId(index, this.s);
                } else if (index == R.styleable.R8) {
                    this.Y2 = obtainStyledAttributes.getInt(index, this.Y2);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void b(ConstraintLayout constraintLayout) {
        if (this.X2 != null) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.X2.getLayoutParams();
            layoutParams2.v0.b2(0);
            ConstraintWidget.DimensionBehaviour H = layoutParams.v0.H();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
            if (H != dimensionBehaviour) {
                layoutParams.v0.c2(layoutParams2.v0.m0());
            }
            if (layoutParams.v0.j0() != dimensionBehaviour) {
                layoutParams.v0.y1(layoutParams2.v0.D());
            }
            layoutParams2.v0.b2(8);
        }
    }

    public void c(ConstraintLayout constraintLayout) {
        if (this.s == -1 && !isInEditMode()) {
            setVisibility(this.Y2);
        }
        View findViewById = constraintLayout.findViewById(this.s);
        this.X2 = findViewById;
        if (findViewById != null) {
            ((ConstraintLayout.LayoutParams) findViewById.getLayoutParams()).j0 = true;
            this.X2.setVisibility(0);
            setVisibility(0);
        }
    }

    public View getContent() {
        return this.X2;
    }

    public int getEmptyVisibility() {
        return this.Y2;
    }

    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize((float) rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((((float) width) / 2.0f) - (((float) rect.width()) / 2.0f)) - ((float) rect.left), ((((float) height) / 2.0f) + (((float) rect.height()) / 2.0f)) - ((float) rect.bottom), paint);
        }
    }

    public void setContentId(int i2) {
        View findViewById;
        if (this.s != i2) {
            View view = this.X2;
            if (view != null) {
                view.setVisibility(0);
                ((ConstraintLayout.LayoutParams) this.X2.getLayoutParams()).j0 = false;
                this.X2 = null;
            }
            this.s = i2;
            if (i2 != -1 && (findViewById = ((View) getParent()).findViewById(i2)) != null) {
                findViewById.setVisibility(8);
            }
        }
    }

    public void setEmptyVisibility(int i2) {
        this.Y2 = i2;
    }

    public Placeholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }
}
