package com.github.mikephil.charting.renderer;

import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class BarLineScatterCandleBubbleRenderer extends DataRenderer {

    /* renamed from: g  reason: collision with root package name */
    protected XBounds f19059g = new XBounds();

    protected class XBounds {

        /* renamed from: a  reason: collision with root package name */
        public int f19060a;

        /* renamed from: b  reason: collision with root package name */
        public int f19061b;

        /* renamed from: c  reason: collision with root package name */
        public int f19062c;

        protected XBounds() {
        }

        public void a(BarLineScatterCandleBubbleDataProvider barLineScatterCandleBubbleDataProvider, IBarLineScatterCandleBubbleDataSet iBarLineScatterCandleBubbleDataSet) {
            float max = Math.max(0.0f, Math.min(1.0f, BarLineScatterCandleBubbleRenderer.this.f19078b.h()));
            float lowestVisibleX = barLineScatterCandleBubbleDataProvider.getLowestVisibleX();
            float highestVisibleX = barLineScatterCandleBubbleDataProvider.getHighestVisibleX();
            Entry t0 = iBarLineScatterCandleBubbleDataSet.t0(lowestVisibleX, Float.NaN, DataSet.Rounding.DOWN);
            Entry t02 = iBarLineScatterCandleBubbleDataSet.t0(highestVisibleX, Float.NaN, DataSet.Rounding.UP);
            int i2 = 0;
            this.f19060a = t0 == null ? 0 : iBarLineScatterCandleBubbleDataSet.s(t0);
            if (t02 != null) {
                i2 = iBarLineScatterCandleBubbleDataSet.s(t02);
            }
            this.f19061b = i2;
            this.f19062c = (int) (((float) (i2 - this.f19060a)) * max);
        }
    }

    public BarLineScatterCandleBubbleRenderer(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
    }

    /* access modifiers changed from: protected */
    public boolean l(Entry entry, IBarLineScatterCandleBubbleDataSet iBarLineScatterCandleBubbleDataSet) {
        return entry != null && ((float) iBarLineScatterCandleBubbleDataSet.s(entry)) < ((float) iBarLineScatterCandleBubbleDataSet.e1()) * this.f19078b.h();
    }

    /* access modifiers changed from: protected */
    public boolean m(IDataSet iDataSet) {
        return iDataSet.isVisible() && (iDataSet.V0() || iDataSet.B());
    }
}
