package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class ChevronDownShapeRenderer implements IShapeRenderer {
    public void a(Canvas canvas, IScatterDataSet iScatterDataSet, ViewPortHandler viewPortHandler, float f2, float f3, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Utils.e(1.0f));
        float p0 = (iScatterDataSet.p0() / 2.0f) * 2.0f;
        Canvas canvas2 = canvas;
        float f4 = f2;
        float f5 = f3 + p0;
        float f6 = f3;
        Paint paint2 = paint;
        canvas2.drawLine(f4, f5, f2 + p0, f6, paint2);
        canvas2.drawLine(f4, f5, f2 - p0, f6, paint2);
    }
}
