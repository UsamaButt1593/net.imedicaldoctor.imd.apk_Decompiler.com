package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.ArrayList;
import java.util.List;

public class LegendRenderer extends Renderer {

    /* renamed from: b  reason: collision with root package name */
    protected Paint f19084b;

    /* renamed from: c  reason: collision with root package name */
    protected Paint f19085c;

    /* renamed from: d  reason: collision with root package name */
    protected Legend f19086d;

    /* renamed from: e  reason: collision with root package name */
    protected List<LegendEntry> f19087e = new ArrayList(16);

    /* renamed from: f  reason: collision with root package name */
    protected Paint.FontMetrics f19088f = new Paint.FontMetrics();

    /* renamed from: g  reason: collision with root package name */
    private Path f19089g = new Path();

    /* renamed from: com.github.mikephil.charting.renderer.LegendRenderer$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f19090a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f19091b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f19092c;

        /* renamed from: d  reason: collision with root package name */
        static final /* synthetic */ int[] f19093d;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|19|20|(2:21|22)|23|25|26|27|28|29|30|31|33|34|35|36|37|38|40) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|19|20|21|22|23|25|26|27|28|29|30|31|33|34|35|36|37|38|40) */
        /* JADX WARNING: Can't wrap try/catch for region: R(35:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|17|19|20|21|22|23|25|26|27|28|29|30|31|33|34|35|36|37|38|40) */
        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0075 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x009a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00a4 */
        static {
            /*
                com.github.mikephil.charting.components.Legend$LegendForm[] r0 = com.github.mikephil.charting.components.Legend.LegendForm.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f19093d = r0
                r1 = 1
                com.github.mikephil.charting.components.Legend$LegendForm r2 = com.github.mikephil.charting.components.Legend.LegendForm.NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f19093d     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.mikephil.charting.components.Legend$LegendForm r3 = com.github.mikephil.charting.components.Legend.LegendForm.EMPTY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f19093d     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.github.mikephil.charting.components.Legend$LegendForm r4 = com.github.mikephil.charting.components.Legend.LegendForm.DEFAULT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = f19093d     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.github.mikephil.charting.components.Legend$LegendForm r4 = com.github.mikephil.charting.components.Legend.LegendForm.CIRCLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r3 = f19093d     // Catch:{ NoSuchFieldError -> 0x003e }
                com.github.mikephil.charting.components.Legend$LegendForm r4 = com.github.mikephil.charting.components.Legend.LegendForm.SQUARE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r3 = f19093d     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.github.mikephil.charting.components.Legend$LegendForm r4 = com.github.mikephil.charting.components.Legend.LegendForm.LINE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r5 = 6
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                com.github.mikephil.charting.components.Legend$LegendOrientation[] r3 = com.github.mikephil.charting.components.Legend.LegendOrientation.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f19092c = r3
                com.github.mikephil.charting.components.Legend$LegendOrientation r4 = com.github.mikephil.charting.components.Legend.LegendOrientation.HORIZONTAL     // Catch:{ NoSuchFieldError -> 0x005a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                int[] r3 = f19092c     // Catch:{ NoSuchFieldError -> 0x0064 }
                com.github.mikephil.charting.components.Legend$LegendOrientation r4 = com.github.mikephil.charting.components.Legend.LegendOrientation.VERTICAL     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment[] r3 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f19091b = r3
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r4 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.TOP     // Catch:{ NoSuchFieldError -> 0x0075 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0075 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0075 }
            L_0x0075:
                int[] r3 = f19091b     // Catch:{ NoSuchFieldError -> 0x007f }
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r4 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.BOTTOM     // Catch:{ NoSuchFieldError -> 0x007f }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x007f }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x007f }
            L_0x007f:
                int[] r3 = f19091b     // Catch:{ NoSuchFieldError -> 0x0089 }
                com.github.mikephil.charting.components.Legend$LegendVerticalAlignment r4 = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.CENTER     // Catch:{ NoSuchFieldError -> 0x0089 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0089 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0089 }
            L_0x0089:
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment[] r3 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f19090a = r3
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r4 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.LEFT     // Catch:{ NoSuchFieldError -> 0x009a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x009a }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x009a }
            L_0x009a:
                int[] r1 = f19090a     // Catch:{ NoSuchFieldError -> 0x00a4 }
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r3 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.RIGHT     // Catch:{ NoSuchFieldError -> 0x00a4 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a4 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x00a4 }
            L_0x00a4:
                int[] r0 = f19090a     // Catch:{ NoSuchFieldError -> 0x00ae }
                com.github.mikephil.charting.components.Legend$LegendHorizontalAlignment r1 = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.CENTER     // Catch:{ NoSuchFieldError -> 0x00ae }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ae }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00ae }
            L_0x00ae:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.LegendRenderer.AnonymousClass1.<clinit>():void");
        }
    }

    public LegendRenderer(ViewPortHandler viewPortHandler, Legend legend) {
        super(viewPortHandler);
        this.f19086d = legend;
        Paint paint = new Paint(1);
        this.f19084b = paint;
        paint.setTextSize(Utils.e(9.0f));
        this.f19084b.setTextAlign(Paint.Align.LEFT);
        Paint paint2 = new Paint(1);
        this.f19085c = paint2;
        paint2.setStyle(Paint.Style.FILL);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: com.github.mikephil.charting.data.ChartData<?>} */
    /* JADX WARNING: type inference failed for: r7v2, types: [com.github.mikephil.charting.interfaces.datasets.IDataSet] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.github.mikephil.charting.data.ChartData<?> r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            com.github.mikephil.charting.components.Legend r2 = r0.f19086d
            boolean r2 = r2.I()
            if (r2 != 0) goto L_0x01c1
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r2 = r0.f19087e
            r2.clear()
            r3 = 0
        L_0x0012:
            int r4 = r19.m()
            if (r3 >= r4) goto L_0x01a7
            com.github.mikephil.charting.interfaces.datasets.IDataSet r4 = r1.k(r3)
            java.util.List r5 = r4.B0()
            int r6 = r4.e1()
            boolean r7 = r4 instanceof com.github.mikephil.charting.interfaces.datasets.IBarDataSet
            if (r7 == 0) goto L_0x0096
            r7 = r4
            com.github.mikephil.charting.interfaces.datasets.IBarDataSet r7 = (com.github.mikephil.charting.interfaces.datasets.IBarDataSet) r7
            boolean r8 = r7.U0()
            if (r8 == 0) goto L_0x0096
            java.lang.String[] r6 = r7.W0()
            r8 = 0
        L_0x0036:
            int r9 = r5.size()
            if (r8 >= r9) goto L_0x0074
            int r9 = r7.C0()
            if (r8 >= r9) goto L_0x0074
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r9 = r0.f19087e
            com.github.mikephil.charting.components.LegendEntry r15 = new com.github.mikephil.charting.components.LegendEntry
            int r10 = r6.length
            int r10 = r8 % r10
            r11 = r6[r10]
            com.github.mikephil.charting.components.Legend$LegendForm r12 = r4.C()
            float r13 = r4.b0()
            float r14 = r4.W()
            android.graphics.DashPathEffect r16 = r4.w()
            java.lang.Object r10 = r5.get(r8)
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r17 = r10.intValue()
            r10 = r15
            r2 = r15
            r15 = r16
            r16 = r17
            r10.<init>(r11, r12, r13, r14, r15, r16)
            r9.add(r2)
            int r8 = r8 + 1
            goto L_0x0036
        L_0x0074:
            java.lang.String r2 = r7.H()
            if (r2 == 0) goto L_0x0093
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r2 = r0.f19087e
            com.github.mikephil.charting.components.LegendEntry r12 = new com.github.mikephil.charting.components.LegendEntry
            java.lang.String r6 = r4.H()
            com.github.mikephil.charting.components.Legend$LegendForm r7 = com.github.mikephil.charting.components.Legend.LegendForm.NONE
            r10 = 0
            r11 = 1122867(0x112233, float:1.573472E-39)
            r8 = 2143289344(0x7fc00000, float:NaN)
            r9 = 2143289344(0x7fc00000, float:NaN)
            r5 = r12
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r2.add(r12)
        L_0x0093:
            r2 = r1
            goto L_0x01a2
        L_0x0096:
            boolean r2 = r4 instanceof com.github.mikephil.charting.interfaces.datasets.IPieDataSet
            if (r2 == 0) goto L_0x0100
            r2 = r4
            com.github.mikephil.charting.interfaces.datasets.IPieDataSet r2 = (com.github.mikephil.charting.interfaces.datasets.IPieDataSet) r2
            r7 = 0
        L_0x009e:
            int r8 = r5.size()
            if (r7 >= r8) goto L_0x00dd
            if (r7 >= r6) goto L_0x00dd
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r8 = r0.f19087e
            com.github.mikephil.charting.components.LegendEntry r15 = new com.github.mikephil.charting.components.LegendEntry
            com.github.mikephil.charting.data.Entry r9 = r2.X(r7)
            com.github.mikephil.charting.data.PieEntry r9 = (com.github.mikephil.charting.data.PieEntry) r9
            java.lang.String r10 = r9.t()
            com.github.mikephil.charting.components.Legend$LegendForm r11 = r4.C()
            float r12 = r4.b0()
            float r13 = r4.W()
            android.graphics.DashPathEffect r14 = r4.w()
            java.lang.Object r9 = r5.get(r7)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r16 = r9.intValue()
            r9 = r15
            r1 = r15
            r15 = r16
            r9.<init>(r10, r11, r12, r13, r14, r15)
            r8.add(r1)
            int r7 = r7 + 1
            r1 = r19
            goto L_0x009e
        L_0x00dd:
            java.lang.String r1 = r2.H()
            if (r1 == 0) goto L_0x00fc
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r1 = r0.f19087e
            com.github.mikephil.charting.components.LegendEntry r2 = new com.github.mikephil.charting.components.LegendEntry
            java.lang.String r6 = r4.H()
            com.github.mikephil.charting.components.Legend$LegendForm r7 = com.github.mikephil.charting.components.Legend.LegendForm.NONE
            r10 = 0
            r11 = 1122867(0x112233, float:1.573472E-39)
            r8 = 2143289344(0x7fc00000, float:NaN)
            r9 = 2143289344(0x7fc00000, float:NaN)
            r5 = r2
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r1.add(r2)
        L_0x00fc:
            r2 = r19
            goto L_0x01a2
        L_0x0100:
            boolean r1 = r4 instanceof com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
            if (r1 == 0) goto L_0x0155
            r1 = r4
            com.github.mikephil.charting.interfaces.datasets.ICandleDataSet r1 = (com.github.mikephil.charting.interfaces.datasets.ICandleDataSet) r1
            int r2 = r1.p1()
            r7 = 1122867(0x112233, float:1.573472E-39)
            if (r2 == r7) goto L_0x0155
            int r14 = r1.p1()
            int r1 = r1.X0()
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r2 = r0.f19087e
            com.github.mikephil.charting.components.LegendEntry r5 = new com.github.mikephil.charting.components.LegendEntry
            com.github.mikephil.charting.components.Legend$LegendForm r10 = r4.C()
            float r11 = r4.b0()
            float r12 = r4.W()
            android.graphics.DashPathEffect r13 = r4.w()
            r9 = 0
            r8 = r5
            r8.<init>(r9, r10, r11, r12, r13, r14)
            r2.add(r5)
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r2 = r0.f19087e
            com.github.mikephil.charting.components.LegendEntry r12 = new com.github.mikephil.charting.components.LegendEntry
            java.lang.String r6 = r4.H()
            com.github.mikephil.charting.components.Legend$LegendForm r7 = r4.C()
            float r8 = r4.b0()
            float r9 = r4.W()
            android.graphics.DashPathEffect r10 = r4.w()
            r5 = r12
            r11 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r2.add(r12)
            goto L_0x00fc
        L_0x0155:
            r1 = 0
        L_0x0156:
            int r2 = r5.size()
            if (r1 >= r2) goto L_0x00fc
            if (r1 >= r6) goto L_0x00fc
            int r2 = r5.size()
            int r2 = r2 + -1
            if (r1 >= r2) goto L_0x016f
            int r2 = r6 + -1
            if (r1 >= r2) goto L_0x016f
            r2 = 0
            r9 = r2
            r2 = r19
            goto L_0x017a
        L_0x016f:
            r2 = r19
            com.github.mikephil.charting.interfaces.datasets.IDataSet r7 = r2.k(r3)
            java.lang.String r7 = r7.H()
            r9 = r7
        L_0x017a:
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r7 = r0.f19087e
            com.github.mikephil.charting.components.LegendEntry r15 = new com.github.mikephil.charting.components.LegendEntry
            com.github.mikephil.charting.components.Legend$LegendForm r10 = r4.C()
            float r11 = r4.b0()
            float r12 = r4.W()
            android.graphics.DashPathEffect r13 = r4.w()
            java.lang.Object r8 = r5.get(r1)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r14 = r8.intValue()
            r8 = r15
            r8.<init>(r9, r10, r11, r12, r13, r14)
            r7.add(r15)
            int r1 = r1 + 1
            goto L_0x0156
        L_0x01a2:
            int r3 = r3 + 1
            r1 = r2
            goto L_0x0012
        L_0x01a7:
            com.github.mikephil.charting.components.Legend r1 = r0.f19086d
            com.github.mikephil.charting.components.LegendEntry[] r1 = r1.s()
            if (r1 == 0) goto L_0x01ba
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r1 = r0.f19087e
            com.github.mikephil.charting.components.Legend r2 = r0.f19086d
            com.github.mikephil.charting.components.LegendEntry[] r2 = r2.s()
            java.util.Collections.addAll(r1, r2)
        L_0x01ba:
            com.github.mikephil.charting.components.Legend r1 = r0.f19086d
            java.util.List<com.github.mikephil.charting.components.LegendEntry> r2 = r0.f19087e
            r1.P(r2)
        L_0x01c1:
            com.github.mikephil.charting.components.Legend r1 = r0.f19086d
            android.graphics.Typeface r1 = r1.c()
            if (r1 == 0) goto L_0x01ce
            android.graphics.Paint r2 = r0.f19084b
            r2.setTypeface(r1)
        L_0x01ce:
            android.graphics.Paint r1 = r0.f19084b
            com.github.mikephil.charting.components.Legend r2 = r0.f19086d
            float r2 = r2.b()
            r1.setTextSize(r2)
            android.graphics.Paint r1 = r0.f19084b
            com.github.mikephil.charting.components.Legend r2 = r0.f19086d
            int r2 = r2.a()
            r1.setColor(r2)
            com.github.mikephil.charting.components.Legend r1 = r0.f19086d
            android.graphics.Paint r2 = r0.f19084b
            com.github.mikephil.charting.utils.ViewPortHandler r3 = r0.f19118a
            r1.m(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.LegendRenderer.a(com.github.mikephil.charting.data.ChartData):void");
    }

    /* access modifiers changed from: protected */
    public void b(Canvas canvas, float f2, float f3, LegendEntry legendEntry, Legend legend) {
        int i2 = legendEntry.f18957f;
        if (i2 != 1122868 && i2 != 1122867 && i2 != 0) {
            int save = canvas.save();
            Legend.LegendForm legendForm = legendEntry.f18953b;
            if (legendForm == Legend.LegendForm.DEFAULT) {
                legendForm = legend.t();
            }
            this.f19085c.setColor(legendEntry.f18957f);
            float e2 = Utils.e(Float.isNaN(legendEntry.f18954c) ? legend.w() : legendEntry.f18954c);
            float f4 = e2 / 2.0f;
            int i3 = AnonymousClass1.f19093d[legendForm.ordinal()];
            if (i3 == 3 || i3 == 4) {
                this.f19085c.setStyle(Paint.Style.FILL);
                canvas.drawCircle(f2 + f4, f3, f4, this.f19085c);
            } else if (i3 == 5) {
                this.f19085c.setStyle(Paint.Style.FILL);
                canvas.drawRect(f2, f3 - f4, f2 + e2, f3 + f4, this.f19085c);
            } else if (i3 == 6) {
                float e3 = Utils.e(Float.isNaN(legendEntry.f18955d) ? legend.v() : legendEntry.f18955d);
                DashPathEffect dashPathEffect = legendEntry.f18956e;
                if (dashPathEffect == null) {
                    dashPathEffect = legend.u();
                }
                this.f19085c.setStyle(Paint.Style.STROKE);
                this.f19085c.setStrokeWidth(e3);
                this.f19085c.setPathEffect(dashPathEffect);
                this.f19089g.reset();
                this.f19089g.moveTo(f2, f3);
                this.f19089g.lineTo(f2 + e2, f3);
                canvas.drawPath(this.f19089g, this.f19085c);
            }
            canvas.restoreToCount(save);
        }
    }

    /* access modifiers changed from: protected */
    public void c(Canvas canvas, float f2, float f3, String str) {
        canvas.drawText(str, f2, f3, this.f19084b);
    }

    public Paint d() {
        return this.f19085c;
    }

    public Paint e() {
        return this.f19084b;
    }

    public void f(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        List<Boolean> list;
        List<FSize> list2;
        int i2;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        Legend.LegendDirection legendDirection;
        LegendEntry legendEntry;
        Canvas canvas2;
        float f16;
        String str;
        double d2;
        Canvas canvas3 = canvas;
        if (this.f19086d.f()) {
            Typeface c2 = this.f19086d.c();
            if (c2 != null) {
                this.f19084b.setTypeface(c2);
            }
            this.f19084b.setTextSize(this.f19086d.b());
            this.f19084b.setColor(this.f19086d.a());
            float u = Utils.u(this.f19084b, this.f19088f);
            float w = Utils.w(this.f19084b, this.f19088f) + Utils.e(this.f19086d.G());
            float a2 = u - (((float) Utils.a(this.f19084b, "ABC")) / 2.0f);
            LegendEntry[] r = this.f19086d.r();
            float e2 = Utils.e(this.f19086d.x());
            float e3 = Utils.e(this.f19086d.F());
            Legend.LegendOrientation C = this.f19086d.C();
            Legend.LegendHorizontalAlignment y = this.f19086d.y();
            Legend.LegendVerticalAlignment E = this.f19086d.E();
            Legend.LegendDirection q = this.f19086d.q();
            float e4 = Utils.e(this.f19086d.w());
            float e5 = Utils.e(this.f19086d.D());
            float e6 = this.f19086d.e();
            float d3 = this.f19086d.d();
            int i3 = AnonymousClass1.f19090a[y.ordinal()];
            float f17 = e5;
            float f18 = e3;
            if (i3 == 1) {
                f3 = u;
                f2 = w;
                if (C != Legend.LegendOrientation.VERTICAL) {
                    d3 += this.f19118a.h();
                }
                f4 = q == Legend.LegendDirection.RIGHT_TO_LEFT ? d3 + this.f19086d.x : d3;
            } else if (i3 == 2) {
                f3 = u;
                f2 = w;
                f4 = (C == Legend.LegendOrientation.VERTICAL ? this.f19118a.o() : this.f19118a.i()) - d3;
                if (q == Legend.LegendDirection.LEFT_TO_RIGHT) {
                    f4 -= this.f19086d.x;
                }
            } else if (i3 != 3) {
                f3 = u;
                f2 = w;
                f4 = 0.0f;
            } else {
                Legend.LegendOrientation legendOrientation = Legend.LegendOrientation.VERTICAL;
                float o = C == legendOrientation ? this.f19118a.o() / 2.0f : this.f19118a.h() + (this.f19118a.k() / 2.0f);
                Legend.LegendDirection legendDirection2 = Legend.LegendDirection.LEFT_TO_RIGHT;
                f2 = w;
                f4 = o + (q == legendDirection2 ? d3 : -d3);
                if (C == legendOrientation) {
                    double d4 = (double) f4;
                    if (q == legendDirection2) {
                        f3 = u;
                        d2 = (((double) (-this.f19086d.x)) / 2.0d) + ((double) d3);
                    } else {
                        f3 = u;
                        d2 = (((double) this.f19086d.x) / 2.0d) - ((double) d3);
                    }
                    f4 = (float) (d4 + d2);
                } else {
                    f3 = u;
                }
            }
            int i4 = AnonymousClass1.f19092c[C.ordinal()];
            if (i4 == 1) {
                Canvas canvas4 = canvas;
                float f19 = f4;
                float f20 = a2;
                float f21 = f17;
                Legend.LegendDirection legendDirection3 = q;
                List<FSize> p = this.f19086d.p();
                List<FSize> o2 = this.f19086d.o();
                List<Boolean> n2 = this.f19086d.n();
                int i5 = AnonymousClass1.f19091b[E.ordinal()];
                if (i5 != 1) {
                    e6 = i5 != 2 ? i5 != 3 ? 0.0f : e6 + ((this.f19118a.n() - this.f19086d.y) / 2.0f) : (this.f19118a.n() - e6) - this.f19086d.y;
                }
                int length = r.length;
                float f22 = f19;
                int i6 = 0;
                int i7 = 0;
                while (i6 < length) {
                    float f23 = f21;
                    LegendEntry legendEntry2 = r[i6];
                    float f24 = f22;
                    int i8 = length;
                    boolean z = legendEntry2.f18953b != Legend.LegendForm.NONE;
                    float e7 = Float.isNaN(legendEntry2.f18954c) ? e4 : Utils.e(legendEntry2.f18954c);
                    if (i6 >= n2.size() || !n2.get(i6).booleanValue()) {
                        f6 = f24;
                        f5 = e6;
                    } else {
                        f5 = e6 + f3 + f2;
                        f6 = f19;
                    }
                    if (f6 == f19 && y == Legend.LegendHorizontalAlignment.CENTER && i7 < p.size()) {
                        f6 += (legendDirection3 == Legend.LegendDirection.RIGHT_TO_LEFT ? p.get(i7).Y : -p.get(i7).Y) / 2.0f;
                        i7++;
                    }
                    int i9 = i7;
                    boolean z2 = legendEntry2.f18952a == null;
                    if (z) {
                        if (legendDirection3 == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            f6 -= e7;
                        }
                        float f25 = f6;
                        list2 = p;
                        i2 = i6;
                        list = n2;
                        b(canvas, f25, f5 + f20, legendEntry2, this.f19086d);
                        f6 = legendDirection3 == Legend.LegendDirection.LEFT_TO_RIGHT ? f25 + e7 : f25;
                    } else {
                        list = n2;
                        list2 = p;
                        i2 = i6;
                    }
                    if (!z2) {
                        if (z) {
                            f6 += legendDirection3 == Legend.LegendDirection.RIGHT_TO_LEFT ? -e2 : e2;
                        }
                        Legend.LegendDirection legendDirection4 = Legend.LegendDirection.RIGHT_TO_LEFT;
                        if (legendDirection3 == legendDirection4) {
                            f6 -= o2.get(i2).Y;
                        }
                        c(canvas4, f6, f5 + f3, legendEntry2.f18952a);
                        if (legendDirection3 == Legend.LegendDirection.LEFT_TO_RIGHT) {
                            f6 += o2.get(i2).Y;
                        }
                        if (legendDirection3 == legendDirection4) {
                            f8 = f18;
                            f10 = -f8;
                        } else {
                            f8 = f18;
                            f10 = f8;
                        }
                        f22 = f6 + f10;
                        f7 = f23;
                    } else {
                        f8 = f18;
                        if (legendDirection3 == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            f7 = f23;
                            f9 = -f7;
                        } else {
                            f7 = f23;
                            f9 = f7;
                        }
                        f22 = f6 + f9;
                    }
                    f18 = f8;
                    f21 = f7;
                    i6 = i2 + 1;
                    e6 = f5;
                    length = i8;
                    i7 = i9;
                    p = list2;
                    n2 = list;
                }
            } else if (i4 == 2) {
                int i10 = AnonymousClass1.f19091b[E.ordinal()];
                if (i10 == 1) {
                    f11 = (y == Legend.LegendHorizontalAlignment.CENTER ? 0.0f : this.f19118a.j()) + e6;
                } else if (i10 == 2) {
                    f11 = (y == Legend.LegendHorizontalAlignment.CENTER ? this.f19118a.n() : this.f19118a.f()) - (this.f19086d.y + e6);
                } else if (i10 != 3) {
                    f11 = 0.0f;
                } else {
                    Legend legend = this.f19086d;
                    f11 = ((this.f19118a.n() / 2.0f) - (legend.y / 2.0f)) + legend.e();
                }
                float f26 = f11;
                boolean z3 = false;
                int i11 = 0;
                float f27 = 0.0f;
                while (i11 < r.length) {
                    LegendEntry legendEntry3 = r[i11];
                    boolean z4 = legendEntry3.f18953b != Legend.LegendForm.NONE;
                    float e8 = Float.isNaN(legendEntry3.f18954c) ? e4 : Utils.e(legendEntry3.f18954c);
                    if (z4) {
                        Legend.LegendDirection legendDirection5 = Legend.LegendDirection.LEFT_TO_RIGHT;
                        f14 = q == legendDirection5 ? f4 + f27 : f4 - (e8 - f27);
                        Legend.LegendDirection legendDirection6 = legendDirection5;
                        float f28 = f26 + a2;
                        f13 = a2;
                        f15 = f17;
                        LegendEntry legendEntry4 = legendEntry3;
                        f12 = f4;
                        legendDirection = q;
                        b(canvas, f14, f28, legendEntry3, this.f19086d);
                        if (legendDirection == legendDirection6) {
                            f14 += e8;
                        }
                        legendEntry = legendEntry4;
                    } else {
                        f12 = f4;
                        f13 = a2;
                        f15 = f17;
                        legendDirection = q;
                        legendEntry = legendEntry3;
                        f14 = f12;
                    }
                    String str2 = legendEntry.f18952a;
                    if (str2 != null) {
                        if (z4 && !z3) {
                            f14 += legendDirection == Legend.LegendDirection.LEFT_TO_RIGHT ? e2 : -e2;
                        } else if (z3) {
                            f14 = f12;
                        }
                        if (legendDirection == Legend.LegendDirection.RIGHT_TO_LEFT) {
                            f14 -= (float) Utils.d(this.f19084b, str2);
                        }
                        float f29 = f14;
                        if (!z3) {
                            f16 = f26 + f3;
                            str = legendEntry.f18952a;
                            canvas2 = canvas;
                        } else {
                            canvas2 = canvas;
                            f26 += f3 + f2;
                            f16 = f26 + f3;
                            str = legendEntry.f18952a;
                        }
                        c(canvas2, f29, f16, str);
                        f26 += f3 + f2;
                        f27 = 0.0f;
                    } else {
                        Canvas canvas5 = canvas;
                        f27 += e8 + f15;
                        z3 = true;
                    }
                    i11++;
                    q = legendDirection;
                    f17 = f15;
                    a2 = f13;
                    f4 = f12;
                }
            }
        }
    }
}
