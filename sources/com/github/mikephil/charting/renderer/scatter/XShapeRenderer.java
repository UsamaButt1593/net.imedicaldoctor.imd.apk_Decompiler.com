package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class XShapeRenderer implements IShapeRenderer {
    public void a(Canvas canvas, IScatterDataSet iScatterDataSet, ViewPortHandler viewPortHandler, float f2, float f3, Paint paint) {
        float p0 = iScatterDataSet.p0() / 2.0f;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Utils.e(1.0f));
        float f4 = f2 - p0;
        float f5 = f2 + p0;
        Canvas canvas2 = canvas;
        float f6 = f3 - p0;
        float f7 = p0 + f3;
        Paint paint2 = paint;
        canvas2.drawLine(f4, f6, f5, f7, paint2);
        canvas2.drawLine(f5, f6, f4, f7, paint2);
    }
}
