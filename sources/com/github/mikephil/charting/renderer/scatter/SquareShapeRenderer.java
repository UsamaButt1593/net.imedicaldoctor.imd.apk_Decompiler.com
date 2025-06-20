package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class SquareShapeRenderer implements IShapeRenderer {
    public void a(Canvas canvas, IScatterDataSet iScatterDataSet, ViewPortHandler viewPortHandler, float f2, float f3, Paint paint) {
        float f4;
        Canvas canvas2;
        float f5;
        float f6;
        float f7;
        Paint paint2 = paint;
        float p0 = iScatterDataSet.p0();
        float f8 = p0 / 2.0f;
        float e2 = Utils.e(iScatterDataSet.q1());
        float f9 = (p0 - (e2 * 2.0f)) / 2.0f;
        float f10 = f9 / 2.0f;
        int H0 = iScatterDataSet.H0();
        if (((double) p0) > 0.0d) {
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth(f9);
            float f11 = f2 - e2;
            float f12 = f3 - e2;
            float f13 = f2 + e2;
            float f14 = f3 + e2;
            canvas.drawRect(f11 - f10, f12 - f10, f13 + f10, f14 + f10, paint);
            if (H0 != 1122867) {
                paint2.setStyle(Paint.Style.FILL);
                paint2.setColor(H0);
                canvas2 = canvas;
                f4 = f11;
                f5 = f12;
                f6 = f13;
                f7 = f14;
            } else {
                return;
            }
        } else {
            paint2.setStyle(Paint.Style.FILL);
            f4 = f2 - f8;
            float f15 = f2 + f8;
            float f16 = f3 + f8;
            canvas2 = canvas;
            f5 = f3 - f8;
            f6 = f15;
            f7 = f16;
        }
        canvas2.drawRect(f4, f5, f6, f7, paint);
    }
}
