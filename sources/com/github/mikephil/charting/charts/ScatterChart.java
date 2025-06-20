package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider;
import com.github.mikephil.charting.renderer.ScatterChartRenderer;

public class ScatterChart extends BarLineChartBase<ScatterData> implements ScatterDataProvider {

    public enum ScatterShape {
        SQUARE("SQUARE"),
        CIRCLE("CIRCLE"),
        TRIANGLE("TRIANGLE"),
        CROSS("CROSS"),
        X("X"),
        CHEVRON_UP("CHEVRON_UP"),
        CHEVRON_DOWN("CHEVRON_DOWN");
        
        private final String s;

        private ScatterShape(String str) {
            this.s = str;
        }

        public static ScatterShape[] a() {
            return new ScatterShape[]{SQUARE, CIRCLE, TRIANGLE, CROSS, X, CHEVRON_UP, CHEVRON_DOWN};
        }

        public String toString() {
            return this.s;
        }
    }

    public ScatterChart(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void H() {
        super.H();
        this.n3 = new ScatterChartRenderer(this, this.q3, this.p3);
        getXAxis().t0(0.5f);
        getXAxis().s0(0.5f);
    }

    public ScatterData getScatterData() {
        return (ScatterData) this.X2;
    }

    public ScatterChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScatterChart(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
