package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class CrossShapeRenderer implements IShapeRenderer {
    public void a(Canvas canvas, IScatterDataSet iScatterDataSet, ViewPortHandler viewPortHandler, float f2, float f3, Paint paint) {
        float p0 = iScatterDataSet.p0() / 2.0f;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Utils.e(1.0f));
        Canvas canvas2 = canvas;
        Paint paint2 = paint;
        canvas2.drawLine(f2 - p0, f3, f2 + p0, f3, paint2);
        canvas2.drawLine(f2, f3 - p0, f2, f3 + p0, paint2);
    }
}
