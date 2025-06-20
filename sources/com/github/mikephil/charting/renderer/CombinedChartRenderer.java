package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.util.Log;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class CombinedChartRenderer extends DataRenderer {

    /* renamed from: g  reason: collision with root package name */
    protected List<DataRenderer> f19074g = new ArrayList(5);

    /* renamed from: h  reason: collision with root package name */
    protected WeakReference<Chart> f19075h;

    /* renamed from: i  reason: collision with root package name */
    protected List<Highlight> f19076i = new ArrayList();

    /* renamed from: com.github.mikephil.charting.renderer.CombinedChartRenderer$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f19077a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.github.mikephil.charting.charts.CombinedChart$DrawOrder[] r0 = com.github.mikephil.charting.charts.CombinedChart.DrawOrder.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f19077a = r0
                com.github.mikephil.charting.charts.CombinedChart$DrawOrder r1 = com.github.mikephil.charting.charts.CombinedChart.DrawOrder.BAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f19077a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.mikephil.charting.charts.CombinedChart$DrawOrder r1 = com.github.mikephil.charting.charts.CombinedChart.DrawOrder.BUBBLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f19077a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.github.mikephil.charting.charts.CombinedChart$DrawOrder r1 = com.github.mikephil.charting.charts.CombinedChart.DrawOrder.LINE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f19077a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.github.mikephil.charting.charts.CombinedChart$DrawOrder r1 = com.github.mikephil.charting.charts.CombinedChart.DrawOrder.CANDLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f19077a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.github.mikephil.charting.charts.CombinedChart$DrawOrder r1 = com.github.mikephil.charting.charts.CombinedChart.DrawOrder.SCATTER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.CombinedChartRenderer.AnonymousClass1.<clinit>():void");
        }
    }

    public CombinedChartRenderer(CombinedChart combinedChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f19075h = new WeakReference<>(combinedChart);
        l();
    }

    public void b(Canvas canvas) {
        for (DataRenderer b2 : this.f19074g) {
            b2.b(canvas);
        }
    }

    public void c(Canvas canvas) {
        for (DataRenderer c2 : this.f19074g) {
            c2.c(canvas);
        }
    }

    public void d(Canvas canvas, Highlight[] highlightArr) {
        Chart chart = this.f19075h.get();
        if (chart != null) {
            for (DataRenderer next : this.f19074g) {
                Object barData = next instanceof BarChartRenderer ? ((BarChartRenderer) next).f19053h.getBarData() : next instanceof LineChartRenderer ? ((LineChartRenderer) next).f19094i.getLineData() : next instanceof CandleStickChartRenderer ? ((CandleStickChartRenderer) next).f19068i.getCandleData() : next instanceof ScatterChartRenderer ? ((ScatterChartRenderer) next).f19119i.getScatterData() : next instanceof BubbleChartRenderer ? ((BubbleChartRenderer) next).f19064h.getBubbleData() : null;
                int indexOf = barData == null ? -1 : ((CombinedData) chart.getData()).Q().indexOf(barData);
                this.f19076i.clear();
                for (Highlight highlight : highlightArr) {
                    if (highlight.c() == indexOf || highlight.c() == -1) {
                        this.f19076i.add(highlight);
                    }
                }
                List<Highlight> list = this.f19076i;
                next.d(canvas, (Highlight[]) list.toArray(new Highlight[list.size()]));
            }
        }
    }

    public void e(Canvas canvas, String str, float f2, float f3, int i2) {
        Log.e(Chart.C3, "Erroneous call to drawValue() in CombinedChartRenderer!");
    }

    public void f(Canvas canvas) {
        for (DataRenderer f2 : this.f19074g) {
            f2.f(canvas);
        }
    }

    public void j() {
        for (DataRenderer j2 : this.f19074g) {
            j2.j();
        }
    }

    public void l() {
        List<DataRenderer> list;
        Object barChartRenderer;
        this.f19074g.clear();
        CombinedChart combinedChart = (CombinedChart) this.f19075h.get();
        if (combinedChart != null) {
            for (CombinedChart.DrawOrder ordinal : combinedChart.getDrawOrder()) {
                int i2 = AnonymousClass1.f19077a[ordinal.ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                if (i2 == 5 && combinedChart.getScatterData() != null) {
                                    list = this.f19074g;
                                    barChartRenderer = new ScatterChartRenderer(combinedChart, this.f19078b, this.f19118a);
                                }
                            } else if (combinedChart.getCandleData() != null) {
                                list = this.f19074g;
                                barChartRenderer = new CandleStickChartRenderer(combinedChart, this.f19078b, this.f19118a);
                            }
                        } else if (combinedChart.getLineData() != null) {
                            list = this.f19074g;
                            barChartRenderer = new LineChartRenderer(combinedChart, this.f19078b, this.f19118a);
                        }
                    } else if (combinedChart.getBubbleData() != null) {
                        list = this.f19074g;
                        barChartRenderer = new BubbleChartRenderer(combinedChart, this.f19078b, this.f19118a);
                    }
                } else if (combinedChart.getBarData() != null) {
                    list = this.f19074g;
                    barChartRenderer = new BarChartRenderer(combinedChart, this.f19078b, this.f19118a);
                }
                list.add(barChartRenderer);
            }
        }
    }

    public DataRenderer m(int i2) {
        if (i2 >= this.f19074g.size() || i2 < 0) {
            return null;
        }
        return this.f19074g.get(i2);
    }

    public List<DataRenderer> n() {
        return this.f19074g;
    }

    public void o(List<DataRenderer> list) {
        this.f19074g = list;
    }
}
