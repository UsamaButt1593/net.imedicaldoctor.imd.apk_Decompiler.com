package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class CircleShapeRenderer implements IShapeRenderer {
    public void a(Canvas canvas, IScatterDataSet iScatterDataSet, ViewPortHandler viewPortHandler, float f2, float f3, Paint paint) {
        float p0 = iScatterDataSet.p0();
        float f4 = p0 / 2.0f;
        float e2 = Utils.e(iScatterDataSet.q1());
        float f5 = (p0 - (e2 * 2.0f)) / 2.0f;
        float f6 = f5 / 2.0f;
        int H0 = iScatterDataSet.H0();
        if (((double) p0) > 0.0d) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(f5);
            canvas.drawCircle(f2, f3, f6 + e2, paint);
            if (H0 != 1122867) {
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(H0);
                canvas.drawCircle(f2, f3, e2, paint);
                return;
            }
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(f2, f3, f4, paint);
    }
}
