package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class XAxisRendererRadarChart extends XAxisRenderer {
    private RadarChart p;

    public XAxisRendererRadarChart(ViewPortHandler viewPortHandler, XAxis xAxis, RadarChart radarChart) {
        super(viewPortHandler, xAxis, (Transformer) null);
        this.p = radarChart;
    }

    public void g(Canvas canvas) {
        if (this.f19121h.f() && this.f19121h.P()) {
            float v0 = this.f19121h.v0();
            MPPointF c2 = MPPointF.c(0.5f, 0.25f);
            this.f19050e.setTypeface(this.f19121h.c());
            this.f19050e.setTextSize(this.f19121h.b());
            this.f19050e.setColor(this.f19121h.a());
            float sliceAngle = this.p.getSliceAngle();
            float factor = this.p.getFactor();
            MPPointF centerOffsets = this.p.getCenterOffsets();
            MPPointF c3 = MPPointF.c(0.0f, 0.0f);
            for (int i2 = 0; i2 < ((IRadarDataSet) ((RadarData) this.p.getData()).w()).e1(); i2++) {
                float f2 = (float) i2;
                String c4 = this.f19121h.H().c(f2, this.f19121h);
                Utils.B(centerOffsets, (this.p.getYRange() * factor) + (((float) this.f19121h.L) / 2.0f), ((f2 * sliceAngle) + this.p.getRotationAngle()) % 360.0f, c3);
                m(canvas, c4, c3.Y, c3.Z - (((float) this.f19121h.M) / 2.0f), c2, v0);
            }
            MPPointF.h(centerOffsets);
            MPPointF.h(c3);
            MPPointF.h(c2);
        }
    }

    public void j(Canvas canvas) {
    }
}
