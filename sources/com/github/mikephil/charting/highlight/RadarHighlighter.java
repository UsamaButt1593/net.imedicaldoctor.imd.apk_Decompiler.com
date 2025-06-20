package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

public class RadarHighlighter extends PieRadarHighlighter<RadarChart> {
    public RadarHighlighter(RadarChart radarChart) {
        super(radarChart);
    }

    /* access modifiers changed from: protected */
    public Highlight b(int i2, float f2, float f3) {
        List<Highlight> c2 = c(i2);
        float Z = ((RadarChart) this.f19031a).Z(f2, f3) / ((RadarChart) this.f19031a).getFactor();
        Highlight highlight = null;
        float f4 = Float.MAX_VALUE;
        for (int i3 = 0; i3 < c2.size(); i3++) {
            Highlight highlight2 = c2.get(i3);
            float abs = Math.abs(highlight2.j() - Z);
            if (abs < f4) {
                highlight = highlight2;
                f4 = abs;
            }
        }
        return highlight;
    }

    /* access modifiers changed from: protected */
    public List<Highlight> c(int i2) {
        int i3 = i2;
        this.f19032b.clear();
        float h2 = ((RadarChart) this.f19031a).getAnimator().h();
        float i4 = ((RadarChart) this.f19031a).getAnimator().i();
        float sliceAngle = ((RadarChart) this.f19031a).getSliceAngle();
        float factor = ((RadarChart) this.f19031a).getFactor();
        MPPointF c2 = MPPointF.c(0.0f, 0.0f);
        int i5 = 0;
        while (i5 < ((RadarData) ((RadarChart) this.f19031a).getData()).m()) {
            IDataSet k2 = ((RadarData) ((RadarChart) this.f19031a).getData()).k(i5);
            Entry X = k2.X(i3);
            float f2 = (float) i3;
            Utils.B(((RadarChart) this.f19031a).getCenterOffsets(), (X.c() - ((RadarChart) this.f19031a).getYChartMin()) * factor * i4, (sliceAngle * f2 * h2) + ((RadarChart) this.f19031a).getRotationAngle(), c2);
            List<Highlight> list = this.f19032b;
            Highlight highlight = r8;
            Highlight highlight2 = new Highlight(f2, X.c(), c2.Y, c2.Z, i5, k2.a1());
            list.add(highlight);
            i5++;
            i3 = i2;
        }
        return this.f19032b;
    }
}
