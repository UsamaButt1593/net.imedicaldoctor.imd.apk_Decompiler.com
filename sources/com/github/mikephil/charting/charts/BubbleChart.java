package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.interfaces.dataprovider.BubbleDataProvider;
import com.github.mikephil.charting.renderer.BubbleChartRenderer;

public class BubbleChart extends BarLineChartBase<BubbleData> implements BubbleDataProvider {
    public BubbleChart(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void H() {
        super.H();
        this.n3 = new BubbleChartRenderer(this, this.q3, this.p3);
    }

    public BubbleData getBubbleData() {
        return (BubbleData) this.X2;
    }

    public BubbleChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BubbleChart(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
