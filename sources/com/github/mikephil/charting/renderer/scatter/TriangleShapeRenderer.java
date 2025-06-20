package com.github.mikephil.charting.renderer.scatter;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class TriangleShapeRenderer implements IShapeRenderer {

    /* renamed from: a  reason: collision with root package name */
    protected Path f19135a = new Path();

    public void a(Canvas canvas, IScatterDataSet iScatterDataSet, ViewPortHandler viewPortHandler, float f2, float f3, Paint paint) {
        float p0 = iScatterDataSet.p0();
        float f4 = p0 / 2.0f;
        float e2 = (p0 - (Utils.e(iScatterDataSet.q1()) * 2.0f)) / 2.0f;
        int H0 = iScatterDataSet.H0();
        paint.setStyle(Paint.Style.FILL);
        Path path = this.f19135a;
        path.reset();
        float f5 = f3 - f4;
        path.moveTo(f2, f5);
        float f6 = f2 + f4;
        float f7 = f3 + f4;
        path.lineTo(f6, f7);
        float f8 = f2 - f4;
        path.lineTo(f8, f7);
        int i2 = (((double) p0) > 0.0d ? 1 : (((double) p0) == 0.0d ? 0 : -1));
        if (i2 > 0) {
            path.lineTo(f2, f5);
            float f9 = f8 + e2;
            float f10 = f7 - e2;
            path.moveTo(f9, f10);
            path.lineTo(f6 - e2, f10);
            path.lineTo(f2, f5 + e2);
            path.lineTo(f9, f10);
        }
        path.close();
        canvas.drawPath(path, paint);
        path.reset();
        if (i2 > 0 && H0 != 1122867) {
            paint.setColor(H0);
            path.moveTo(f2, f5 + e2);
            float f11 = f7 - e2;
            path.lineTo(f6 - e2, f11);
            path.lineTo(f8 + e2, f11);
            path.close();
            canvas.drawPath(path, paint);
            path.reset();
        }
    }
}
