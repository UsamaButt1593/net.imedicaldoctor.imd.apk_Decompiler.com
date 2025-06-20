package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.CandleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

public class CandleStickChartRenderer extends LineScatterCandleRadarRenderer {

    /* renamed from: i  reason: collision with root package name */
    protected CandleDataProvider f19068i;

    /* renamed from: j  reason: collision with root package name */
    private float[] f19069j = new float[8];

    /* renamed from: k  reason: collision with root package name */
    private float[] f19070k = new float[4];

    /* renamed from: l  reason: collision with root package name */
    private float[] f19071l = new float[4];

    /* renamed from: m  reason: collision with root package name */
    private float[] f19072m = new float[4];

    /* renamed from: n  reason: collision with root package name */
    private float[] f19073n = new float[4];

    public CandleStickChartRenderer(CandleDataProvider candleDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f19068i = candleDataProvider;
    }

    public void b(Canvas canvas) {
        for (ICandleDataSet iCandleDataSet : this.f19068i.getCandleData().q()) {
            if (iCandleDataSet.isVisible()) {
                o(canvas, iCandleDataSet);
            }
        }
    }

    public void c(Canvas canvas) {
    }

    public void d(Canvas canvas, Highlight[] highlightArr) {
        CandleData candleData = this.f19068i.getCandleData();
        for (Highlight highlight : highlightArr) {
            ICandleDataSet iCandleDataSet = (ICandleDataSet) candleData.k(highlight.d());
            if (iCandleDataSet != null && iCandleDataSet.i1()) {
                CandleEntry candleEntry = (CandleEntry) iCandleDataSet.x(highlight.h(), highlight.j());
                if (l(candleEntry, iCandleDataSet)) {
                    MPPointD f2 = this.f19068i.a(iCandleDataSet.a1()).f(candleEntry.m(), ((candleEntry.B() * this.f19078b.i()) + (candleEntry.z() * this.f19078b.i())) / 2.0f);
                    highlight.n((float) f2.Y, (float) f2.Z);
                    n(canvas, (float) f2.Y, (float) f2.Z, iCandleDataSet);
                }
            }
        }
    }

    public void e(Canvas canvas, String str, float f2, float f3, int i2) {
        this.f19082f.setColor(i2);
        canvas.drawText(str, f2, f3, this.f19082f);
    }

    public void f(Canvas canvas) {
        ICandleDataSet iCandleDataSet;
        float f2;
        CandleEntry candleEntry;
        if (k(this.f19068i)) {
            List q = this.f19068i.getCandleData().q();
            for (int i2 = 0; i2 < q.size(); i2++) {
                ICandleDataSet iCandleDataSet2 = (ICandleDataSet) q.get(i2);
                if (m(iCandleDataSet2) && iCandleDataSet2.e1() >= 1) {
                    a(iCandleDataSet2);
                    Transformer a2 = this.f19068i.a(iCandleDataSet2.a1());
                    this.f19059g.a(this.f19068i, iCandleDataSet2);
                    float h2 = this.f19078b.h();
                    float i3 = this.f19078b.i();
                    BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.f19059g;
                    float[] b2 = a2.b(iCandleDataSet2, h2, i3, xBounds.f19060a, xBounds.f19061b);
                    float e2 = Utils.e(5.0f);
                    ValueFormatter T = iCandleDataSet2.T();
                    MPPointF d2 = MPPointF.d(iCandleDataSet2.f1());
                    d2.Y = Utils.e(d2.Y);
                    d2.Z = Utils.e(d2.Z);
                    int i4 = 0;
                    while (i4 < b2.length) {
                        float f3 = b2[i4];
                        float f4 = b2[i4 + 1];
                        if (!this.f19118a.J(f3)) {
                            break;
                        }
                        if (!this.f19118a.I(f3) || !this.f19118a.M(f4)) {
                            iCandleDataSet = iCandleDataSet2;
                        } else {
                            int i5 = i4 / 2;
                            CandleEntry candleEntry2 = (CandleEntry) iCandleDataSet2.X(this.f19059g.f19060a + i5);
                            if (iCandleDataSet2.V0()) {
                                candleEntry = candleEntry2;
                                f2 = f4;
                                float f5 = f4 - e2;
                                iCandleDataSet = iCandleDataSet2;
                                e(canvas, T.g(candleEntry2), f3, f5, iCandleDataSet2.u0(i5));
                            } else {
                                candleEntry = candleEntry2;
                                f2 = f4;
                                iCandleDataSet = iCandleDataSet2;
                            }
                            if (candleEntry.b() != null && iCandleDataSet.B()) {
                                Drawable b3 = candleEntry.b();
                                Utils.k(canvas, b3, (int) (f3 + d2.Y), (int) (f2 + d2.Z), b3.getIntrinsicWidth(), b3.getIntrinsicHeight());
                            }
                        }
                        i4 += 2;
                        iCandleDataSet2 = iCandleDataSet;
                    }
                    MPPointF.h(d2);
                }
            }
        }
    }

    public void j() {
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x015a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void o(android.graphics.Canvas r29, com.github.mikephil.charting.interfaces.datasets.ICandleDataSet r30) {
        /*
            r28 = this;
            r0 = r28
            r1 = r30
            com.github.mikephil.charting.interfaces.dataprovider.CandleDataProvider r2 = r0.f19068i
            com.github.mikephil.charting.components.YAxis$AxisDependency r3 = r30.a1()
            com.github.mikephil.charting.utils.Transformer r2 = r2.a(r3)
            com.github.mikephil.charting.animation.ChartAnimator r3 = r0.f19078b
            float r3 = r3.i()
            float r4 = r30.V()
            boolean r5 = r30.d1()
            com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer$XBounds r6 = r0.f19059g
            com.github.mikephil.charting.interfaces.dataprovider.CandleDataProvider r7 = r0.f19068i
            r6.a(r7, r1)
            android.graphics.Paint r6 = r0.f19079c
            float r7 = r30.r()
            r6.setStrokeWidth(r7)
            com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer$XBounds r6 = r0.f19059g
            int r6 = r6.f19060a
        L_0x0030:
            com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer$XBounds r7 = r0.f19059g
            int r8 = r7.f19062c
            int r7 = r7.f19060a
            int r8 = r8 + r7
            if (r6 > r8) goto L_0x0262
            com.github.mikephil.charting.data.Entry r7 = r1.X(r6)
            com.github.mikephil.charting.data.CandleEntry r7 = (com.github.mikephil.charting.data.CandleEntry) r7
            if (r7 != 0) goto L_0x0045
            r12 = r29
            goto L_0x025e
        L_0x0045:
            float r8 = r7.m()
            float r9 = r7.C()
            float r10 = r7.v()
            float r11 = r7.z()
            float r7 = r7.B()
            r13 = 1122867(0x112233, float:1.573472E-39)
            r14 = 2
            r15 = 0
            r16 = 3
            r17 = 1
            if (r5 == 0) goto L_0x01b5
            float[] r12 = r0.f19069j
            r12[r15] = r8
            r12[r14] = r8
            r19 = 4
            r12[r19] = r8
            r19 = 6
            r12[r19] = r8
            r19 = 7
            r20 = 5
            int r21 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r21 <= 0) goto L_0x008b
            float r11 = r11 * r3
            r12[r17] = r11
            float r11 = r9 * r3
            r12[r16] = r11
            float r7 = r7 * r3
            r12[r20] = r7
            float r7 = r10 * r3
            r12[r19] = r7
            goto L_0x00ac
        L_0x008b:
            int r22 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            float r11 = r11 * r3
            if (r22 >= 0) goto L_0x00a0
            r12[r17] = r11
            float r11 = r10 * r3
            r12[r16] = r11
            float r7 = r7 * r3
            r12[r20] = r7
            float r7 = r9 * r3
            r12[r19] = r7
            goto L_0x00ac
        L_0x00a0:
            r12[r17] = r11
            float r11 = r9 * r3
            r12[r16] = r11
            float r7 = r7 * r3
            r12[r20] = r7
            r12[r19] = r11
        L_0x00ac:
            r2.o(r12)
            boolean r7 = r30.y0()
            if (r7 == 0) goto L_0x00ec
            if (r21 <= 0) goto L_0x00cc
            android.graphics.Paint r7 = r0.f19079c
            int r11 = r30.p1()
            if (r11 != r13) goto L_0x00c4
        L_0x00bf:
            int r11 = r1.d0(r6)
            goto L_0x00c8
        L_0x00c4:
            int r11 = r30.p1()
        L_0x00c8:
            r7.setColor(r11)
            goto L_0x00fa
        L_0x00cc:
            int r7 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x00de
            android.graphics.Paint r7 = r0.f19079c
            int r11 = r30.X0()
            if (r11 != r13) goto L_0x00d9
            goto L_0x00bf
        L_0x00d9:
            int r11 = r30.X0()
            goto L_0x00c8
        L_0x00de:
            android.graphics.Paint r7 = r0.f19079c
            int r11 = r30.d()
            if (r11 != r13) goto L_0x00e7
            goto L_0x00bf
        L_0x00e7:
            int r11 = r30.d()
            goto L_0x00c8
        L_0x00ec:
            android.graphics.Paint r7 = r0.f19079c
            int r11 = r30.Q0()
            if (r11 != r13) goto L_0x00f5
            goto L_0x00bf
        L_0x00f5:
            int r11 = r30.Q0()
            goto L_0x00c8
        L_0x00fa:
            android.graphics.Paint r7 = r0.f19079c
            android.graphics.Paint$Style r11 = android.graphics.Paint.Style.STROKE
            r7.setStyle(r11)
            float[] r7 = r0.f19069j
            android.graphics.Paint r11 = r0.f19079c
            r12 = r29
            r12.drawLines(r7, r11)
            float[] r7 = r0.f19070k
            r11 = 1056964608(0x3f000000, float:0.5)
            float r18 = r8 - r11
            float r18 = r18 + r4
            r7[r15] = r18
            float r18 = r10 * r3
            r7[r17] = r18
            float r8 = r8 + r11
            float r8 = r8 - r4
            r7[r14] = r8
            float r8 = r9 * r3
            r7[r16] = r8
            r2.o(r7)
            if (r21 <= 0) goto L_0x015a
            int r7 = r30.p1()
            if (r7 != r13) goto L_0x0135
            android.graphics.Paint r7 = r0.f19079c
            int r8 = r1.d0(r6)
        L_0x0131:
            r7.setColor(r8)
            goto L_0x013c
        L_0x0135:
            android.graphics.Paint r7 = r0.f19079c
            int r8 = r30.p1()
            goto L_0x0131
        L_0x013c:
            android.graphics.Paint r7 = r0.f19079c
            android.graphics.Paint$Style r8 = r30.R()
            r7.setStyle(r8)
            float[] r7 = r0.f19070k
            r23 = r7[r15]
            r24 = r7[r16]
            r25 = r7[r14]
            r26 = r7[r17]
        L_0x014f:
            android.graphics.Paint r7 = r0.f19079c
            r22 = r29
            r27 = r7
            r22.drawRect(r23, r24, r25, r26, r27)
            goto L_0x025e
        L_0x015a:
            int r7 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x0189
            int r7 = r30.X0()
            if (r7 != r13) goto L_0x016e
            android.graphics.Paint r7 = r0.f19079c
            int r8 = r1.d0(r6)
        L_0x016a:
            r7.setColor(r8)
            goto L_0x0175
        L_0x016e:
            android.graphics.Paint r7 = r0.f19079c
            int r8 = r30.X0()
            goto L_0x016a
        L_0x0175:
            android.graphics.Paint r7 = r0.f19079c
            android.graphics.Paint$Style r8 = r30.j0()
            r7.setStyle(r8)
            float[] r7 = r0.f19070k
            r23 = r7[r15]
            r24 = r7[r17]
            r25 = r7[r14]
            r26 = r7[r16]
            goto L_0x014f
        L_0x0189:
            int r7 = r30.d()
            if (r7 != r13) goto L_0x0199
            android.graphics.Paint r7 = r0.f19079c
            int r8 = r1.d0(r6)
        L_0x0195:
            r7.setColor(r8)
            goto L_0x01a0
        L_0x0199:
            android.graphics.Paint r7 = r0.f19079c
            int r8 = r30.d()
            goto L_0x0195
        L_0x01a0:
            float[] r7 = r0.f19070k
            r23 = r7[r15]
            r24 = r7[r17]
            r25 = r7[r14]
            r26 = r7[r16]
            android.graphics.Paint r7 = r0.f19079c
            r22 = r29
        L_0x01ae:
            r27 = r7
            r22.drawLine(r23, r24, r25, r26, r27)
            goto L_0x025e
        L_0x01b5:
            r12 = r29
            float[] r13 = r0.f19071l
            r13[r15] = r8
            float r11 = r11 * r3
            r13[r17] = r11
            r13[r14] = r8
            float r7 = r7 * r3
            r13[r16] = r7
            float[] r7 = r0.f19072m
            r11 = 1056964608(0x3f000000, float:0.5)
            float r18 = r8 - r11
            float r18 = r18 + r4
            r7[r15] = r18
            float r18 = r9 * r3
            r7[r17] = r18
            r7[r14] = r8
            r7[r16] = r18
            float[] r7 = r0.f19073n
            float r11 = r11 + r8
            float r11 = r11 - r4
            r7[r15] = r11
            float r11 = r10 * r3
            r7[r17] = r11
            r7[r14] = r8
            r7[r16] = r11
            r2.o(r13)
            float[] r7 = r0.f19072m
            r2.o(r7)
            float[] r7 = r0.f19073n
            r2.o(r7)
            int r7 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r7 <= 0) goto L_0x0209
            int r7 = r30.p1()
            r8 = 1122867(0x112233, float:1.573472E-39)
            if (r7 != r8) goto L_0x0204
        L_0x01ff:
            int r7 = r1.d0(r6)
            goto L_0x0227
        L_0x0204:
            int r7 = r30.p1()
            goto L_0x0227
        L_0x0209:
            r8 = 1122867(0x112233, float:1.573472E-39)
            int r7 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x021c
            int r7 = r30.X0()
            if (r7 != r8) goto L_0x0217
            goto L_0x01ff
        L_0x0217:
            int r7 = r30.X0()
            goto L_0x0227
        L_0x021c:
            int r7 = r30.d()
            if (r7 != r8) goto L_0x0223
            goto L_0x01ff
        L_0x0223:
            int r7 = r30.d()
        L_0x0227:
            android.graphics.Paint r8 = r0.f19079c
            r8.setColor(r7)
            float[] r7 = r0.f19071l
            r23 = r7[r15]
            r24 = r7[r17]
            r25 = r7[r14]
            r26 = r7[r16]
            android.graphics.Paint r7 = r0.f19079c
            r22 = r29
            r27 = r7
            r22.drawLine(r23, r24, r25, r26, r27)
            float[] r7 = r0.f19072m
            r23 = r7[r15]
            r24 = r7[r17]
            r25 = r7[r14]
            r26 = r7[r16]
            android.graphics.Paint r7 = r0.f19079c
            r27 = r7
            r22.drawLine(r23, r24, r25, r26, r27)
            float[] r7 = r0.f19073n
            r23 = r7[r15]
            r24 = r7[r17]
            r25 = r7[r14]
            r26 = r7[r16]
            android.graphics.Paint r7 = r0.f19079c
            goto L_0x01ae
        L_0x025e:
            int r6 = r6 + 1
            goto L_0x0030
        L_0x0262:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.CandleStickChartRenderer.o(android.graphics.Canvas, com.github.mikephil.charting.interfaces.datasets.ICandleDataSet):void");
    }
}
