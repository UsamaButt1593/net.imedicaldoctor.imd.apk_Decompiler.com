package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Path;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class LineScatterCandleRadarRenderer extends BarLineScatterCandleBubbleRenderer {

    /* renamed from: h  reason: collision with root package name */
    private Path f19104h = new Path();

    public LineScatterCandleRadarRenderer(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
    }

    /* access modifiers changed from: protected */
    public void n(Canvas canvas, float f2, float f3, ILineScatterCandleRadarDataSet iLineScatterCandleRadarDataSet) {
        this.f19080d.setColor(iLineScatterCandleRadarDataSet.Y0());
        this.f19080d.setStrokeWidth(iLineScatterCandleRadarDataSet.I());
        this.f19080d.setPathEffect(iLineScatterCandleRadarDataSet.v0());
        if (iLineScatterCandleRadarDataSet.j1()) {
            this.f19104h.reset();
            this.f19104h.moveTo(f2, this.f19118a.j());
            this.f19104h.lineTo(f2, this.f19118a.f());
            canvas.drawPath(this.f19104h, this.f19080d);
        }
        if (iLineScatterCandleRadarDataSet.n1()) {
            this.f19104h.reset();
            this.f19104h.moveTo(this.f19118a.h(), f3);
            this.f19104h.lineTo(this.f19118a.i(), f3);
            canvas.drawPath(this.f19104h, this.f19080d);
        }
    }
}
