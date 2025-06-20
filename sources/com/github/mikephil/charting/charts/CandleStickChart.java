package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.interfaces.dataprovider.CandleDataProvider;
import com.github.mikephil.charting.renderer.CandleStickChartRenderer;

public class CandleStickChart extends BarLineChartBase<CandleData> implements CandleDataProvider {
    public CandleStickChart(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void H() {
        super.H();
        this.n3 = new CandleStickChartRenderer(this, this.q3, this.p3);
        getXAxis().t0(0.5f);
        getXAxis().s0(0.5f);
    }

    public CandleData getCandleData() {
        return (CandleData) this.X2;
    }

    public CandleStickChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CandleStickChart(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
