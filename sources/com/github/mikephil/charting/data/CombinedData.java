package com.github.mikephil.charting.data;

import android.util.Log;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import java.util.ArrayList;
import java.util.List;

public class CombinedData extends BarLineScatterCandleBubbleData<IBarLineScatterCandleBubbleDataSet<? extends Entry>> {

    /* renamed from: j  reason: collision with root package name */
    private LineData f18989j;

    /* renamed from: k  reason: collision with root package name */
    private BarData f18990k;

    /* renamed from: l  reason: collision with root package name */
    private ScatterData f18991l;

    /* renamed from: m  reason: collision with root package name */
    private CandleData f18992m;

    /* renamed from: n  reason: collision with root package name */
    private BubbleData f18993n;

    public void E() {
        LineData lineData = this.f18989j;
        if (lineData != null) {
            lineData.E();
        }
        BarData barData = this.f18990k;
        if (barData != null) {
            barData.E();
        }
        CandleData candleData = this.f18992m;
        if (candleData != null) {
            candleData.E();
        }
        ScatterData scatterData = this.f18991l;
        if (scatterData != null) {
            scatterData.E();
        }
        BubbleData bubbleData = this.f18993n;
        if (bubbleData != null) {
            bubbleData.E();
        }
        d();
    }

    @Deprecated
    public boolean F(int i2) {
        Log.e(Chart.C3, "removeDataSet(int index) not supported for CombinedData");
        return false;
    }

    @Deprecated
    public boolean H(float f2, int i2) {
        Log.e(Chart.C3, "removeEntry(...) not supported for CombinedData");
        return false;
    }

    @Deprecated
    public boolean I(Entry entry, int i2) {
        Log.e(Chart.C3, "removeEntry(...) not supported for CombinedData");
        return false;
    }

    public List<BarLineScatterCandleBubbleData> Q() {
        ArrayList arrayList = new ArrayList();
        LineData lineData = this.f18989j;
        if (lineData != null) {
            arrayList.add(lineData);
        }
        BarData barData = this.f18990k;
        if (barData != null) {
            arrayList.add(barData);
        }
        ScatterData scatterData = this.f18991l;
        if (scatterData != null) {
            arrayList.add(scatterData);
        }
        CandleData candleData = this.f18992m;
        if (candleData != null) {
            arrayList.add(candleData);
        }
        BubbleData bubbleData = this.f18993n;
        if (bubbleData != null) {
            arrayList.add(bubbleData);
        }
        return arrayList;
    }

    public BarData R() {
        return this.f18990k;
    }

    public BubbleData S() {
        return this.f18993n;
    }

    public CandleData T() {
        return this.f18992m;
    }

    public BarLineScatterCandleBubbleData U(int i2) {
        return Q().get(i2);
    }

    public int V(ChartData chartData) {
        return Q().indexOf(chartData);
    }

    public IBarLineScatterCandleBubbleDataSet<? extends Entry> W(Highlight highlight) {
        if (highlight.c() >= Q().size()) {
            return null;
        }
        BarLineScatterCandleBubbleData U = U(highlight.c());
        if (highlight.d() >= U.m()) {
            return null;
        }
        return (IBarLineScatterCandleBubbleDataSet) U.q().get(highlight.d());
    }

    public LineData X() {
        return this.f18989j;
    }

    public ScatterData Y() {
        return this.f18991l;
    }

    /* JADX WARNING: Removed duplicated region for block: B:1:0x0009 A[LOOP:0: B:1:0x0009->B:4:0x0019, LOOP_START, PHI: r1 
      PHI: (r1v1 boolean) = (r1v0 boolean), (r1v5 boolean) binds: [B:0:0x0000, B:4:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: Z */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean G(com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet<? extends com.github.mikephil.charting.data.Entry> r4) {
        /*
            r3 = this;
            java.util.List r0 = r3.Q()
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L_0x0009:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x001b
            java.lang.Object r1 = r0.next()
            com.github.mikephil.charting.data.ChartData r1 = (com.github.mikephil.charting.data.ChartData) r1
            boolean r1 = r1.G(r4)
            if (r1 == 0) goto L_0x0009
        L_0x001b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.data.CombinedData.G(com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet):boolean");
    }

    public void a0(BarData barData) {
        this.f18990k = barData;
        E();
    }

    public void b0(BubbleData bubbleData) {
        this.f18993n = bubbleData;
        E();
    }

    public void c0(CandleData candleData) {
        this.f18992m = candleData;
        E();
    }

    public void d() {
        if (this.f18988i == null) {
            this.f18988i = new ArrayList();
        }
        this.f18988i.clear();
        this.f18980a = -3.4028235E38f;
        this.f18981b = Float.MAX_VALUE;
        this.f18982c = -3.4028235E38f;
        this.f18983d = Float.MAX_VALUE;
        this.f18984e = -3.4028235E38f;
        this.f18985f = Float.MAX_VALUE;
        this.f18986g = -3.4028235E38f;
        this.f18987h = Float.MAX_VALUE;
        for (ChartData next : Q()) {
            next.d();
            this.f18988i.addAll(next.q());
            if (next.z() > this.f18980a) {
                this.f18980a = next.z();
            }
            if (next.B() < this.f18981b) {
                this.f18981b = next.B();
            }
            if (next.x() > this.f18982c) {
                this.f18982c = next.x();
            }
            if (next.y() < this.f18983d) {
                this.f18983d = next.y();
            }
            float f2 = next.f18984e;
            if (f2 > this.f18984e) {
                this.f18984e = f2;
            }
            float f3 = next.f18985f;
            if (f3 < this.f18985f) {
                this.f18985f = f3;
            }
            float f4 = next.f18986g;
            if (f4 > this.f18986g) {
                this.f18986g = f4;
            }
            float f5 = next.f18987h;
            if (f5 < this.f18987h) {
                this.f18987h = f5;
            }
        }
    }

    public void d0(LineData lineData) {
        this.f18989j = lineData;
        E();
    }

    public void e0(ScatterData scatterData) {
        this.f18991l = scatterData;
        E();
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.github.mikephil.charting.data.Entry s(com.github.mikephil.charting.highlight.Highlight r6) {
        /*
            r5 = this;
            int r0 = r6.c()
            java.util.List r1 = r5.Q()
            int r1 = r1.size()
            r2 = 0
            if (r0 < r1) goto L_0x0010
            return r2
        L_0x0010:
            int r0 = r6.c()
            com.github.mikephil.charting.data.BarLineScatterCandleBubbleData r0 = r5.U(r0)
            int r1 = r6.d()
            int r3 = r0.m()
            if (r1 < r3) goto L_0x0023
            return r2
        L_0x0023:
            int r1 = r6.d()
            com.github.mikephil.charting.interfaces.datasets.IDataSet r0 = r0.k(r1)
            float r1 = r6.h()
            java.util.List r0 = r0.J0(r1)
            java.util.Iterator r0 = r0.iterator()
        L_0x0037:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005a
            java.lang.Object r1 = r0.next()
            com.github.mikephil.charting.data.Entry r1 = (com.github.mikephil.charting.data.Entry) r1
            float r3 = r1.c()
            float r4 = r6.j()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 == 0) goto L_0x0059
            float r3 = r6.j()
            boolean r3 = java.lang.Float.isNaN(r3)
            if (r3 == 0) goto L_0x0037
        L_0x0059:
            return r1
        L_0x005a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.data.CombinedData.s(com.github.mikephil.charting.highlight.Highlight):com.github.mikephil.charting.data.Entry");
    }
}
