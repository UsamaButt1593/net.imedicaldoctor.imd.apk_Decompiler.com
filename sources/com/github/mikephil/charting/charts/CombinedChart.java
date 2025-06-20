package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.highlight.CombinedHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.CombinedDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.renderer.CombinedChartRenderer;

public class CombinedChart extends BarLineChartBase<CombinedData> implements CombinedDataProvider {
    private boolean r4 = true;
    protected boolean s4 = false;
    private boolean t4 = false;
    protected DrawOrder[] u4;

    public enum DrawOrder {
        BAR,
        BUBBLE,
        LINE,
        CANDLE,
        SCATTER
    }

    public CombinedChart(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void H() {
        super.H();
        this.u4 = new DrawOrder[]{DrawOrder.BAR, DrawOrder.BUBBLE, DrawOrder.LINE, DrawOrder.CANDLE, DrawOrder.SCATTER};
        setHighlighter(new CombinedHighlighter(this, this));
        setHighlightFullBarEnabled(true);
        this.n3 = new CombinedChartRenderer(this, this.q3, this.p3);
    }

    public boolean b() {
        return this.t4;
    }

    public boolean c() {
        return this.r4;
    }

    public boolean d() {
        return this.s4;
    }

    public BarData getBarData() {
        T t = this.X2;
        if (t == null) {
            return null;
        }
        return ((CombinedData) t).R();
    }

    public BubbleData getBubbleData() {
        T t = this.X2;
        if (t == null) {
            return null;
        }
        return ((CombinedData) t).S();
    }

    public CandleData getCandleData() {
        T t = this.X2;
        if (t == null) {
            return null;
        }
        return ((CombinedData) t).T();
    }

    public CombinedData getCombinedData() {
        return (CombinedData) this.X2;
    }

    public DrawOrder[] getDrawOrder() {
        return this.u4;
    }

    public LineData getLineData() {
        T t = this.X2;
        if (t == null) {
            return null;
        }
        return ((CombinedData) t).X();
    }

    public ScatterData getScatterData() {
        T t = this.X2;
        if (t == null) {
            return null;
        }
        return ((CombinedData) t).Y();
    }

    public void setDrawBarShadow(boolean z) {
        this.t4 = z;
    }

    public void setDrawOrder(DrawOrder[] drawOrderArr) {
        if (drawOrderArr != null && drawOrderArr.length > 0) {
            this.u4 = drawOrderArr;
        }
    }

    public void setDrawValueAboveBar(boolean z) {
        this.r4 = z;
    }

    public void setHighlightFullBarEnabled(boolean z) {
        this.s4 = z;
    }

    /* access modifiers changed from: protected */
    public void v(Canvas canvas) {
        if (this.z3 != null && K() && Y()) {
            int i2 = 0;
            while (true) {
                Highlight[] highlightArr = this.w3;
                if (i2 < highlightArr.length) {
                    Highlight highlight = highlightArr[i2];
                    IBarLineScatterCandleBubbleDataSet<? extends Entry> W = ((CombinedData) this.X2).W(highlight);
                    Entry s = ((CombinedData) this.X2).s(highlight);
                    if (s != null && ((float) W.s(s)) <= ((float) W.e1()) * this.q3.h()) {
                        float[] y = y(highlight);
                        if (this.p3.G(y[0], y[1])) {
                            this.z3.a(s, highlight);
                            this.z3.b(canvas, y[0], y[1]);
                        }
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public Highlight x(float f2, float f3) {
        if (this.X2 == null) {
            Log.e(Chart.C3, "Can't select by touch. No data set.");
            return null;
        }
        Highlight a2 = getHighlighter().a(f2, f3);
        return (a2 == null || !d()) ? a2 : new Highlight(a2.h(), a2.j(), a2.i(), a2.k(), a2.d(), -1, a2.b());
    }

    public CombinedChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setData(CombinedData combinedData) {
        super.setData(combinedData);
        setHighlighter(new CombinedHighlighter(this, this));
        ((CombinedChartRenderer) this.n3).l();
        this.n3.j();
    }

    public CombinedChart(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
