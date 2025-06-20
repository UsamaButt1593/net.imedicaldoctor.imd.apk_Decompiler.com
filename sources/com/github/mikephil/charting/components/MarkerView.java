package com.github.mikephil.charting.components;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import java.lang.ref.WeakReference;

public class MarkerView extends RelativeLayout implements IMarker {
    private MPPointF X2 = new MPPointF();
    private WeakReference<Chart> Y2;
    private MPPointF s = new MPPointF();

    public MarkerView(Context context, int i2) {
        super(context);
        setupLayoutResource(i2);
    }

    private void setupLayoutResource(int i2) {
        View inflate = LayoutInflater.from(getContext()).inflate(i2, this);
        inflate.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        inflate.layout(0, 0, inflate.getMeasuredWidth(), inflate.getMeasuredHeight());
    }

    public void a(Entry entry, Highlight highlight) {
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    public void b(Canvas canvas, float f2, float f3) {
        MPPointF c2 = c(f2, f3);
        int save = canvas.save();
        canvas.translate(f2 + c2.Y, f3 + c2.Z);
        draw(canvas);
        canvas.restoreToCount(save);
    }

    public MPPointF c(float f2, float f3) {
        MPPointF offset = getOffset();
        MPPointF mPPointF = this.X2;
        mPPointF.Y = offset.Y;
        mPPointF.Z = offset.Z;
        Chart chartView = getChartView();
        float width = (float) getWidth();
        float height = (float) getHeight();
        MPPointF mPPointF2 = this.X2;
        float f4 = mPPointF2.Y;
        if (f2 + f4 < 0.0f) {
            mPPointF2.Y = -f2;
        } else if (chartView != null && f2 + width + f4 > ((float) chartView.getWidth())) {
            this.X2.Y = (((float) chartView.getWidth()) - f2) - width;
        }
        MPPointF mPPointF3 = this.X2;
        float f5 = mPPointF3.Z;
        if (f3 + f5 < 0.0f) {
            mPPointF3.Z = -f3;
        } else if (chartView != null && f3 + height + f5 > ((float) chartView.getHeight())) {
            this.X2.Z = (((float) chartView.getHeight()) - f3) - height;
        }
        return this.X2;
    }

    public void d(float f2, float f3) {
        MPPointF mPPointF = this.s;
        mPPointF.Y = f2;
        mPPointF.Z = f3;
    }

    public Chart getChartView() {
        WeakReference<Chart> weakReference = this.Y2;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public MPPointF getOffset() {
        return this.s;
    }

    public void setChartView(Chart chart) {
        this.Y2 = new WeakReference<>(chart);
    }

    public void setOffset(MPPointF mPPointF) {
        this.s = mPPointF;
        if (mPPointF == null) {
            this.s = new MPPointF();
        }
    }
}
