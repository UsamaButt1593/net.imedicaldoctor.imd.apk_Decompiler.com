package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.R;

public class MockView extends View {
    private Paint X2 = new Paint();
    private Paint Y2 = new Paint();
    private boolean Z2 = true;
    private boolean a3 = true;
    protected String b3 = null;
    private Rect c3 = new Rect();
    private int d3 = Color.argb(255, 0, 0, 0);
    private int e3 = Color.argb(255, 200, 200, 200);
    private int f3 = Color.argb(255, 50, 50, 50);
    private int g3 = 4;
    private Paint s = new Paint();

    public MockView(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.fj);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.hj) {
                    this.b3 = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.kj) {
                    this.Z2 = obtainStyledAttributes.getBoolean(index, this.Z2);
                } else if (index == R.styleable.gj) {
                    this.d3 = obtainStyledAttributes.getColor(index, this.d3);
                } else if (index == R.styleable.ij) {
                    this.f3 = obtainStyledAttributes.getColor(index, this.f3);
                } else if (index == R.styleable.jj) {
                    this.e3 = obtainStyledAttributes.getColor(index, this.e3);
                } else if (index == R.styleable.lj) {
                    this.a3 = obtainStyledAttributes.getBoolean(index, this.a3);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.b3 == null) {
            try {
                this.b3 = context.getResources().getResourceEntryName(getId());
            } catch (Exception unused) {
            }
        }
        this.s.setColor(this.d3);
        this.s.setAntiAlias(true);
        this.X2.setColor(this.e3);
        this.X2.setAntiAlias(true);
        this.Y2.setColor(this.f3);
        this.g3 = Math.round(((float) this.g3) * (getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.Z2) {
            width--;
            height--;
            float f2 = (float) width;
            float f4 = (float) height;
            Canvas canvas2 = canvas;
            float f5 = f2;
            canvas2.drawLine(0.0f, 0.0f, f5, f4, this.s);
            canvas2.drawLine(0.0f, f4, f5, 0.0f, this.s);
            canvas2.drawLine(0.0f, 0.0f, f5, 0.0f, this.s);
            float f6 = f2;
            float f7 = f4;
            canvas2.drawLine(f6, 0.0f, f5, f7, this.s);
            float f8 = f4;
            canvas2.drawLine(f6, f8, 0.0f, f7, this.s);
            canvas2.drawLine(0.0f, f8, 0.0f, 0.0f, this.s);
        }
        String str = this.b3;
        if (str != null && this.a3) {
            this.X2.getTextBounds(str, 0, str.length(), this.c3);
            float width2 = ((float) (width - this.c3.width())) / 2.0f;
            float height2 = (((float) (height - this.c3.height())) / 2.0f) + ((float) this.c3.height());
            this.c3.offset((int) width2, (int) height2);
            Rect rect = this.c3;
            int i2 = rect.left;
            int i3 = this.g3;
            rect.set(i2 - i3, rect.top - i3, rect.right + i3, rect.bottom + i3);
            canvas.drawRect(this.c3, this.Y2);
            canvas.drawText(this.b3, width2, height2, this.X2);
        }
    }

    public MockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public MockView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }
}
