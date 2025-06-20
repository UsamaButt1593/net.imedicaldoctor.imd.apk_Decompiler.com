package com.github.mikephil.charting.data;

import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.renderer.scatter.ChevronDownShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.ChevronUpShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.CircleShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.CrossShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.IShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.SquareShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.TriangleShapeRenderer;
import com.github.mikephil.charting.renderer.scatter.XShapeRenderer;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
import java.util.List;

public class ScatterDataSet extends LineScatterCandleRadarDataSet<Entry> implements IScatterDataSet {
    private float C = 15.0f;
    protected IShapeRenderer D = new SquareShapeRenderer();
    private float E = 0.0f;
    private int F = ColorTemplate.f19136a;

    /* renamed from: com.github.mikephil.charting.data.ScatterDataSet$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f18995a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.github.mikephil.charting.charts.ScatterChart$ScatterShape[] r0 = com.github.mikephil.charting.charts.ScatterChart.ScatterShape.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f18995a = r0
                com.github.mikephil.charting.charts.ScatterChart$ScatterShape r1 = com.github.mikephil.charting.charts.ScatterChart.ScatterShape.SQUARE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f18995a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.mikephil.charting.charts.ScatterChart$ScatterShape r1 = com.github.mikephil.charting.charts.ScatterChart.ScatterShape.CIRCLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f18995a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.github.mikephil.charting.charts.ScatterChart$ScatterShape r1 = com.github.mikephil.charting.charts.ScatterChart.ScatterShape.TRIANGLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f18995a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.github.mikephil.charting.charts.ScatterChart$ScatterShape r1 = com.github.mikephil.charting.charts.ScatterChart.ScatterShape.CROSS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f18995a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.github.mikephil.charting.charts.ScatterChart$ScatterShape r1 = com.github.mikephil.charting.charts.ScatterChart.ScatterShape.X     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f18995a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.github.mikephil.charting.charts.ScatterChart$ScatterShape r1 = com.github.mikephil.charting.charts.ScatterChart.ScatterShape.CHEVRON_UP     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f18995a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.github.mikephil.charting.charts.ScatterChart$ScatterShape r1 = com.github.mikephil.charting.charts.ScatterChart.ScatterShape.CHEVRON_DOWN     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.data.ScatterDataSet.AnonymousClass1.<clinit>():void");
        }
    }

    public ScatterDataSet(List<Entry> list, String str) {
        super(list, str);
    }

    public static IShapeRenderer d2(ScatterChart.ScatterShape scatterShape) {
        switch (AnonymousClass1.f18995a[scatterShape.ordinal()]) {
            case 1:
                return new SquareShapeRenderer();
            case 2:
                return new CircleShapeRenderer();
            case 3:
                return new TriangleShapeRenderer();
            case 4:
                return new CrossShapeRenderer();
            case 5:
                return new XShapeRenderer();
            case 6:
                return new ChevronUpShapeRenderer();
            case 7:
                return new ChevronDownShapeRenderer();
            default:
                return null;
        }
    }

    public int H0() {
        return this.F;
    }

    public DataSet<Entry> N1() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.s.size(); i2++) {
            arrayList.add(((Entry) this.s.get(i2)).k());
        }
        ScatterDataSet scatterDataSet = new ScatterDataSet(arrayList, H());
        c2(scatterDataSet);
        return scatterDataSet;
    }

    public IShapeRenderer O0() {
        return this.D;
    }

    /* access modifiers changed from: protected */
    public void c2(ScatterDataSet scatterDataSet) {
        super.U1(scatterDataSet);
        scatterDataSet.C = this.C;
        scatterDataSet.D = this.D;
        scatterDataSet.E = this.E;
        scatterDataSet.F = this.F;
    }

    public void e2(ScatterChart.ScatterShape scatterShape) {
        this.D = d2(scatterShape);
    }

    public void f2(int i2) {
        this.F = i2;
    }

    public void g2(float f2) {
        this.E = f2;
    }

    public void h2(float f2) {
        this.C = f2;
    }

    public void i2(IShapeRenderer iShapeRenderer) {
        this.D = iShapeRenderer;
    }

    public float p0() {
        return this.C;
    }

    public float q1() {
        return this.E;
    }
}
