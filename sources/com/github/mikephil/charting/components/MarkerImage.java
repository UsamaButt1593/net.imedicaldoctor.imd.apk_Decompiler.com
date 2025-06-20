package com.github.mikephil.charting.components;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointF;
import java.lang.ref.WeakReference;

public class MarkerImage implements IMarker {
    private Drawable X;
    private WeakReference<Chart> X2;
    private MPPointF Y = new MPPointF();
    private FSize Y2 = new FSize();
    private MPPointF Z = new MPPointF();
    private Rect Z2 = new Rect();
    private Context s;

    public MarkerImage(Context context, int i2) {
        this.s = context;
        this.X = context.getResources().getDrawable(i2, (Resources.Theme) null);
    }

    public void a(Entry entry, Highlight highlight) {
    }

    public void b(Canvas canvas, float f2, float f3) {
        if (this.X != null) {
            MPPointF c2 = c(f2, f3);
            FSize fSize = this.Y2;
            float f4 = fSize.Y;
            float f5 = fSize.Z;
            if (f4 == 0.0f) {
                f4 = (float) this.X.getIntrinsicWidth();
            }
            if (f5 == 0.0f) {
                f5 = (float) this.X.getIntrinsicHeight();
            }
            this.X.copyBounds(this.Z2);
            Drawable drawable = this.X;
            Rect rect = this.Z2;
            int i2 = rect.left;
            int i3 = rect.top;
            drawable.setBounds(i2, i3, ((int) f4) + i2, ((int) f5) + i3);
            int save = canvas.save();
            canvas.translate(f2 + c2.Y, f3 + c2.Z);
            this.X.draw(canvas);
            canvas.restoreToCount(save);
            this.X.setBounds(this.Z2);
        }
    }

    public MPPointF c(float f2, float f3) {
        Drawable drawable;
        Drawable drawable2;
        MPPointF offset = getOffset();
        MPPointF mPPointF = this.Z;
        mPPointF.Y = offset.Y;
        mPPointF.Z = offset.Z;
        Chart d2 = d();
        FSize fSize = this.Y2;
        float f4 = fSize.Y;
        float f5 = fSize.Z;
        if (f4 == 0.0f && (drawable2 = this.X) != null) {
            f4 = (float) drawable2.getIntrinsicWidth();
        }
        if (f5 == 0.0f && (drawable = this.X) != null) {
            f5 = (float) drawable.getIntrinsicHeight();
        }
        MPPointF mPPointF2 = this.Z;
        float f6 = mPPointF2.Y;
        if (f2 + f6 < 0.0f) {
            mPPointF2.Y = -f2;
        } else if (d2 != null && f2 + f4 + f6 > ((float) d2.getWidth())) {
            this.Z.Y = (((float) d2.getWidth()) - f2) - f4;
        }
        MPPointF mPPointF3 = this.Z;
        float f7 = mPPointF3.Z;
        if (f3 + f7 < 0.0f) {
            mPPointF3.Z = -f3;
        } else if (d2 != null && f3 + f5 + f7 > ((float) d2.getHeight())) {
            this.Z.Z = (((float) d2.getHeight()) - f3) - f5;
        }
        return this.Z;
    }

    public Chart d() {
        WeakReference<Chart> weakReference = this.X2;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public FSize e() {
        return this.Y2;
    }

    public void f(Chart chart) {
        this.X2 = new WeakReference<>(chart);
    }

    public void g(float f2, float f3) {
        MPPointF mPPointF = this.Y;
        mPPointF.Y = f2;
        mPPointF.Z = f3;
    }

    public MPPointF getOffset() {
        return this.Y;
    }

    public void h(MPPointF mPPointF) {
        this.Y = mPPointF;
        if (mPPointF == null) {
            this.Y = new MPPointF();
        }
    }

    public void i(FSize fSize) {
        this.Y2 = fSize;
        if (fSize == null) {
            this.Y2 = new FSize();
        }
    }
}
