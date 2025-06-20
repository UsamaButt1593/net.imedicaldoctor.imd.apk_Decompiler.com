package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.buffer.HorizontalBarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class HorizontalBarChartRenderer extends BarChartRenderer {

    /* renamed from: n  reason: collision with root package name */
    private RectF f19083n = new RectF();

    public HorizontalBarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(barDataProvider, chartAnimator, viewPortHandler);
        this.f19082f.setTextAlign(Paint.Align.LEFT);
    }

    public void e(Canvas canvas, String str, float f2, float f3, int i2) {
        this.f19082f.setColor(i2);
        canvas.drawText(str, f2, f3, this.f19082f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:142:0x03b4  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x03b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(android.graphics.Canvas r41) {
        /*
            r40 = this;
            r6 = r40
            com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider r0 = r6.f19053h
            boolean r0 = r6.k(r0)
            if (r0 == 0) goto L_0x03cb
            com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider r0 = r6.f19053h
            com.github.mikephil.charting.data.BarData r0 = r0.getBarData()
            java.util.List r7 = r0.q()
            r0 = 1084227584(0x40a00000, float:5.0)
            float r8 = com.github.mikephil.charting.utils.Utils.e(r0)
            com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider r0 = r6.f19053h
            boolean r9 = r0.c()
            r11 = 0
        L_0x0021:
            com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider r0 = r6.f19053h
            com.github.mikephil.charting.data.BarData r0 = r0.getBarData()
            int r0 = r0.m()
            if (r11 >= r0) goto L_0x03cb
            java.lang.Object r0 = r7.get(r11)
            r12 = r0
            com.github.mikephil.charting.interfaces.datasets.IBarDataSet r12 = (com.github.mikephil.charting.interfaces.datasets.IBarDataSet) r12
            boolean r0 = r6.m(r12)
            if (r0 != 0) goto L_0x0040
            r20 = r7
            r23 = r11
            goto L_0x03c5
        L_0x0040:
            com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider r0 = r6.f19053h
            com.github.mikephil.charting.components.YAxis$AxisDependency r1 = r12.a1()
            boolean r13 = r0.f(r1)
            r6.a(r12)
            android.graphics.Paint r0 = r6.f19082f
            java.lang.String r1 = "10"
            int r0 = com.github.mikephil.charting.utils.Utils.a(r0, r1)
            float r0 = (float) r0
            r14 = 1073741824(0x40000000, float:2.0)
            float r15 = r0 / r14
            com.github.mikephil.charting.formatter.ValueFormatter r5 = r12.T()
            com.github.mikephil.charting.buffer.BarBuffer[] r0 = r6.f19055j
            r4 = r0[r11]
            com.github.mikephil.charting.animation.ChartAnimator r0 = r6.f19078b
            float r16 = r0.i()
            com.github.mikephil.charting.utils.MPPointF r0 = r12.f1()
            com.github.mikephil.charting.utils.MPPointF r3 = com.github.mikephil.charting.utils.MPPointF.d(r0)
            float r0 = r3.Y
            float r0 = com.github.mikephil.charting.utils.Utils.e(r0)
            r3.Y = r0
            float r0 = r3.Z
            float r0 = com.github.mikephil.charting.utils.Utils.e(r0)
            r3.Z = r0
            boolean r0 = r12.U0()
            r17 = 0
            if (r0 != 0) goto L_0x0195
            r2 = 0
        L_0x0089:
            float r0 = (float) r2
            float[] r1 = r4.f18909b
            int r1 = r1.length
            float r1 = (float) r1
            com.github.mikephil.charting.animation.ChartAnimator r10 = r6.f19078b
            float r10 = r10.h()
            float r1 = r1 * r10
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x00af
            float[] r0 = r4.f18909b
            int r1 = r2 + 1
            r10 = r0[r1]
            int r16 = r2 + 3
            r0 = r0[r16]
            float r0 = r0 + r10
            float r16 = r0 / r14
            com.github.mikephil.charting.utils.ViewPortHandler r0 = r6.f19118a
            boolean r0 = r0.K(r10)
            if (r0 != 0) goto L_0x00b6
        L_0x00af:
            r20 = r7
            r23 = r11
            r7 = r3
            goto L_0x03c2
        L_0x00b6:
            com.github.mikephil.charting.utils.ViewPortHandler r0 = r6.f19118a
            float[] r10 = r4.f18909b
            r10 = r10[r2]
            boolean r0 = r0.L(r10)
            if (r0 != 0) goto L_0x00cd
        L_0x00c2:
            r25 = r2
            r14 = r4
            r20 = r7
            r23 = r11
            r7 = r3
            r11 = r5
            goto L_0x0188
        L_0x00cd:
            com.github.mikephil.charting.utils.ViewPortHandler r0 = r6.f19118a
            float[] r10 = r4.f18909b
            r1 = r10[r1]
            boolean r0 = r0.H(r1)
            if (r0 != 0) goto L_0x00da
            goto L_0x00c2
        L_0x00da:
            int r0 = r2 / 4
            com.github.mikephil.charting.data.Entry r0 = r12.X(r0)
            r10 = r0
            com.github.mikephil.charting.data.BarEntry r10 = (com.github.mikephil.charting.data.BarEntry) r10
            float r18 = r10.c()
            java.lang.String r1 = r5.d(r10)
            android.graphics.Paint r0 = r6.f19082f
            int r0 = com.github.mikephil.charting.utils.Utils.d(r0, r1)
            float r0 = (float) r0
            if (r9 == 0) goto L_0x00f6
            r14 = r8
            goto L_0x00f9
        L_0x00f6:
            float r14 = r0 + r8
            float r14 = -r14
        L_0x00f9:
            r20 = r1
            if (r9 == 0) goto L_0x0101
            float r1 = r0 + r8
            float r1 = -r1
            goto L_0x0102
        L_0x0101:
            r1 = r8
        L_0x0102:
            if (r13 == 0) goto L_0x0108
            float r14 = -r14
            float r14 = r14 - r0
            float r1 = -r1
            float r1 = r1 - r0
        L_0x0108:
            r21 = r14
            r14 = r1
            boolean r0 = r12.V0()
            if (r0 == 0) goto L_0x0144
            float[] r0 = r4.f18909b
            int r1 = r2 + 2
            r0 = r0[r1]
            int r1 = (r18 > r17 ? 1 : (r18 == r17 ? 0 : -1))
            if (r1 < 0) goto L_0x011e
            r1 = r21
            goto L_0x011f
        L_0x011e:
            r1 = r14
        L_0x011f:
            float r22 = r0 + r1
            float r23 = r16 + r15
            int r0 = r2 / 2
            int r24 = r12.u0(r0)
            r0 = r40
            r1 = r41
            r25 = r2
            r2 = r20
            r20 = r7
            r7 = r3
            r3 = r22
            r22 = r14
            r14 = r4
            r4 = r23
            r23 = r11
            r11 = r5
            r5 = r24
            r0.e(r1, r2, r3, r4, r5)
            goto L_0x014f
        L_0x0144:
            r25 = r2
            r20 = r7
            r23 = r11
            r22 = r14
            r7 = r3
            r14 = r4
            r11 = r5
        L_0x014f:
            android.graphics.drawable.Drawable r0 = r10.b()
            if (r0 == 0) goto L_0x0188
            boolean r0 = r12.B()
            if (r0 == 0) goto L_0x0188
            android.graphics.drawable.Drawable r27 = r10.b()
            float[] r0 = r14.f18909b
            int r2 = r25 + 2
            r0 = r0[r2]
            int r1 = (r18 > r17 ? 1 : (r18 == r17 ? 0 : -1))
            if (r1 < 0) goto L_0x016a
            goto L_0x016c
        L_0x016a:
            r21 = r22
        L_0x016c:
            float r0 = r0 + r21
            float r1 = r7.Y
            float r0 = r0 + r1
            float r1 = r7.Z
            float r1 = r16 + r1
            int r0 = (int) r0
            int r1 = (int) r1
            int r30 = r27.getIntrinsicWidth()
            int r31 = r27.getIntrinsicHeight()
            r26 = r41
            r28 = r0
            r29 = r1
            com.github.mikephil.charting.utils.Utils.k(r26, r27, r28, r29, r30, r31)
        L_0x0188:
            int r2 = r25 + 4
            r3 = r7
            r5 = r11
            r4 = r14
            r7 = r20
            r11 = r23
            r14 = 1073741824(0x40000000, float:2.0)
            goto L_0x0089
        L_0x0195:
            r14 = r4
            r20 = r7
            r23 = r11
            r7 = r3
            r11 = r5
            com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider r0 = r6.f19053h
            com.github.mikephil.charting.components.YAxis$AxisDependency r1 = r12.a1()
            com.github.mikephil.charting.utils.Transformer r10 = r0.a(r1)
            r5 = 0
            r18 = 0
        L_0x01a9:
            float r0 = (float) r5
            int r1 = r12.e1()
            float r1 = (float) r1
            com.github.mikephil.charting.animation.ChartAnimator r2 = r6.f19078b
            float r2 = r2.h()
            float r1 = r1 * r2
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x03c2
            com.github.mikephil.charting.data.Entry r0 = r12.X(r5)
            r4 = r0
            com.github.mikephil.charting.data.BarEntry r4 = (com.github.mikephil.charting.data.BarEntry) r4
            int r21 = r12.u0(r5)
            float[] r3 = r4.I()
            if (r3 != 0) goto L_0x029c
            com.github.mikephil.charting.utils.ViewPortHandler r0 = r6.f19118a
            float[] r1 = r14.f18909b
            int r22 = r18 + 1
            r1 = r1[r22]
            boolean r0 = r0.K(r1)
            if (r0 != 0) goto L_0x01dc
            goto L_0x03c2
        L_0x01dc:
            com.github.mikephil.charting.utils.ViewPortHandler r0 = r6.f19118a
            float[] r1 = r14.f18909b
            r1 = r1[r18]
            boolean r0 = r0.L(r1)
            if (r0 != 0) goto L_0x01e9
            goto L_0x01a9
        L_0x01e9:
            com.github.mikephil.charting.utils.ViewPortHandler r0 = r6.f19118a
            float[] r1 = r14.f18909b
            r1 = r1[r22]
            boolean r0 = r0.H(r1)
            if (r0 != 0) goto L_0x01f6
            goto L_0x01a9
        L_0x01f6:
            java.lang.String r2 = r11.d(r4)
            android.graphics.Paint r0 = r6.f19082f
            int r0 = com.github.mikephil.charting.utils.Utils.d(r0, r2)
            float r0 = (float) r0
            if (r9 == 0) goto L_0x0205
            r1 = r8
            goto L_0x0208
        L_0x0205:
            float r1 = r0 + r8
            float r1 = -r1
        L_0x0208:
            r24 = r3
            if (r9 == 0) goto L_0x0210
            float r3 = r0 + r8
            float r3 = -r3
            goto L_0x0211
        L_0x0210:
            r3 = r8
        L_0x0211:
            if (r13 == 0) goto L_0x0217
            float r1 = -r1
            float r1 = r1 - r0
            float r3 = -r3
            float r3 = r3 - r0
        L_0x0217:
            r25 = r1
            r26 = r3
            boolean r0 = r12.V0()
            if (r0 == 0) goto L_0x0250
            float[] r0 = r14.f18909b
            int r1 = r18 + 2
            r0 = r0[r1]
            float r1 = r4.c()
            int r1 = (r1 > r17 ? 1 : (r1 == r17 ? 0 : -1))
            if (r1 < 0) goto L_0x0232
            r1 = r25
            goto L_0x0234
        L_0x0232:
            r1 = r26
        L_0x0234:
            float r3 = r0 + r1
            float[] r0 = r14.f18909b
            r0 = r0[r22]
            float r27 = r0 + r15
            r0 = r40
            r1 = r41
            r28 = r15
            r15 = r24
            r24 = r4
            r4 = r27
            r27 = r5
            r5 = r21
            r0.e(r1, r2, r3, r4, r5)
            goto L_0x0258
        L_0x0250:
            r27 = r5
            r28 = r15
            r15 = r24
            r24 = r4
        L_0x0258:
            android.graphics.drawable.Drawable r0 = r24.b()
            if (r0 == 0) goto L_0x0298
            boolean r0 = r12.B()
            if (r0 == 0) goto L_0x0298
            android.graphics.drawable.Drawable r30 = r24.b()
            float[] r0 = r14.f18909b
            int r1 = r18 + 2
            r0 = r0[r1]
            float r1 = r24.c()
            int r1 = (r1 > r17 ? 1 : (r1 == r17 ? 0 : -1))
            if (r1 < 0) goto L_0x0277
            goto L_0x0279
        L_0x0277:
            r25 = r26
        L_0x0279:
            float r0 = r0 + r25
            float[] r1 = r14.f18909b
            r1 = r1[r22]
            float r2 = r7.Y
            float r0 = r0 + r2
            float r2 = r7.Z
            float r1 = r1 + r2
            int r0 = (int) r0
            int r1 = (int) r1
            int r33 = r30.getIntrinsicWidth()
            int r34 = r30.getIntrinsicHeight()
            r29 = r41
            r31 = r0
            r32 = r1
            com.github.mikephil.charting.utils.Utils.k(r29, r30, r31, r32, r33, r34)
        L_0x0298:
            r19 = 1073741824(0x40000000, float:2.0)
            goto L_0x03b2
        L_0x029c:
            r24 = r4
            r27 = r5
            r28 = r15
            r15 = r3
            int r0 = r15.length
            int r5 = r0 * 2
            float[] r4 = new float[r5]
            float r0 = r24.C()
            float r0 = -r0
            r22 = r0
            r0 = 0
            r1 = 0
            r25 = 0
        L_0x02b3:
            if (r0 >= r5) goto L_0x02e0
            r2 = r15[r1]
            int r3 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r3 != 0) goto L_0x02ca
            int r26 = (r25 > r17 ? 1 : (r25 == r17 ? 0 : -1))
            if (r26 == 0) goto L_0x02c3
            int r26 = (r22 > r17 ? 1 : (r22 == r17 ? 0 : -1))
            if (r26 != 0) goto L_0x02ca
        L_0x02c3:
            r39 = r22
            r22 = r2
            r2 = r39
            goto L_0x02d5
        L_0x02ca:
            if (r3 < 0) goto L_0x02d3
            float r25 = r25 + r2
            r2 = r22
            r22 = r25
            goto L_0x02d5
        L_0x02d3:
            float r2 = r22 - r2
        L_0x02d5:
            float r22 = r22 * r16
            r4[r0] = r22
            int r0 = r0 + 2
            int r1 = r1 + 1
            r22 = r2
            goto L_0x02b3
        L_0x02e0:
            r10.o(r4)
            r3 = 0
        L_0x02e4:
            if (r3 >= r5) goto L_0x0298
            int r0 = r3 / 2
            r0 = r15[r0]
            r2 = r24
            java.lang.String r1 = r11.e(r0, r2)
            android.graphics.Paint r2 = r6.f19082f
            int r2 = com.github.mikephil.charting.utils.Utils.d(r2, r1)
            float r2 = (float) r2
            r26 = r1
            if (r9 == 0) goto L_0x02fd
            r1 = r8
            goto L_0x0300
        L_0x02fd:
            float r1 = r2 + r8
            float r1 = -r1
        L_0x0300:
            r29 = r5
            if (r9 == 0) goto L_0x0308
            float r5 = r2 + r8
            float r5 = -r5
            goto L_0x0309
        L_0x0308:
            r5 = r8
        L_0x0309:
            if (r13 == 0) goto L_0x030f
            float r1 = -r1
            float r1 = r1 - r2
            float r5 = -r5
            float r5 = r5 - r2
        L_0x030f:
            int r2 = (r0 > r17 ? 1 : (r0 == r17 ? 0 : -1))
            if (r2 != 0) goto L_0x031b
            int r2 = (r22 > r17 ? 1 : (r22 == r17 ? 0 : -1))
            if (r2 != 0) goto L_0x031b
            int r2 = (r25 > r17 ? 1 : (r25 == r17 ? 0 : -1))
            if (r2 > 0) goto L_0x031f
        L_0x031b:
            int r0 = (r0 > r17 ? 1 : (r0 == r17 ? 0 : -1))
            if (r0 >= 0) goto L_0x0321
        L_0x031f:
            r0 = 1
            goto L_0x0322
        L_0x0321:
            r0 = 0
        L_0x0322:
            r2 = r4[r3]
            if (r0 == 0) goto L_0x0327
            r1 = r5
        L_0x0327:
            float r5 = r2 + r1
            float[] r0 = r14.f18909b
            int r1 = r18 + 1
            r1 = r0[r1]
            int r2 = r18 + 3
            r0 = r0[r2]
            float r1 = r1 + r0
            r19 = 1073741824(0x40000000, float:2.0)
            float r2 = r1 / r19
            com.github.mikephil.charting.utils.ViewPortHandler r0 = r6.f19118a
            boolean r0 = r0.K(r2)
            if (r0 != 0) goto L_0x0342
            goto L_0x03b2
        L_0x0342:
            com.github.mikephil.charting.utils.ViewPortHandler r0 = r6.f19118a
            boolean r0 = r0.L(r5)
            if (r0 != 0) goto L_0x034f
        L_0x034a:
            r26 = r3
            r32 = r4
            goto L_0x03aa
        L_0x034f:
            com.github.mikephil.charting.utils.ViewPortHandler r0 = r6.f19118a
            boolean r0 = r0.H(r2)
            if (r0 != 0) goto L_0x0358
            goto L_0x034a
        L_0x0358:
            boolean r0 = r12.V0()
            if (r0 == 0) goto L_0x0377
            float r30 = r2 + r28
            r0 = r40
            r1 = r41
            r31 = r2
            r2 = r26
            r26 = r3
            r3 = r5
            r32 = r4
            r4 = r30
            r30 = r5
            r5 = r21
            r0.e(r1, r2, r3, r4, r5)
            goto L_0x037f
        L_0x0377:
            r31 = r2
            r26 = r3
            r32 = r4
            r30 = r5
        L_0x037f:
            android.graphics.drawable.Drawable r0 = r24.b()
            if (r0 == 0) goto L_0x03aa
            boolean r0 = r12.B()
            if (r0 == 0) goto L_0x03aa
            android.graphics.drawable.Drawable r34 = r24.b()
            float r0 = r7.Y
            float r5 = r30 + r0
            int r0 = (int) r5
            float r1 = r7.Z
            float r2 = r31 + r1
            int r1 = (int) r2
            int r37 = r34.getIntrinsicWidth()
            int r38 = r34.getIntrinsicHeight()
            r33 = r41
            r35 = r0
            r36 = r1
            com.github.mikephil.charting.utils.Utils.k(r33, r34, r35, r36, r37, r38)
        L_0x03aa:
            int r3 = r26 + 2
            r5 = r29
            r4 = r32
            goto L_0x02e4
        L_0x03b2:
            if (r15 != 0) goto L_0x03b7
            int r18 = r18 + 4
            goto L_0x03bc
        L_0x03b7:
            int r0 = r15.length
            int r0 = r0 * 4
            int r18 = r18 + r0
        L_0x03bc:
            int r5 = r27 + 1
            r15 = r28
            goto L_0x01a9
        L_0x03c2:
            com.github.mikephil.charting.utils.MPPointF.h(r7)
        L_0x03c5:
            int r11 = r23 + 1
            r7 = r20
            goto L_0x0021
        L_0x03cb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.HorizontalBarChartRenderer.f(android.graphics.Canvas):void");
    }

    public void j() {
        BarData barData = this.f19053h.getBarData();
        this.f19055j = new HorizontalBarBuffer[barData.m()];
        for (int i2 = 0; i2 < this.f19055j.length; i2++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.k(i2);
            this.f19055j[i2] = new HorizontalBarBuffer(iBarDataSet.e1() * 4 * (iBarDataSet.U0() ? iBarDataSet.C0() : 1), barData.m(), iBarDataSet.U0());
        }
    }

    /* access modifiers changed from: protected */
    public boolean k(ChartInterface chartInterface) {
        return ((float) chartInterface.getData().r()) < ((float) chartInterface.getMaxVisibleCount()) * this.f19118a.x();
    }

    /* access modifiers changed from: protected */
    public void n(Canvas canvas, IBarDataSet iBarDataSet, int i2) {
        IBarDataSet iBarDataSet2 = iBarDataSet;
        int i3 = i2;
        Transformer a2 = this.f19053h.a(iBarDataSet.a1());
        this.f19057l.setColor(iBarDataSet.v());
        this.f19057l.setStrokeWidth(Utils.e(iBarDataSet.F()));
        int i4 = 0;
        boolean z = true;
        boolean z2 = iBarDataSet.F() > 0.0f;
        float h2 = this.f19078b.h();
        float i5 = this.f19078b.i();
        if (this.f19053h.b()) {
            this.f19056k.setColor(iBarDataSet.l0());
            float Q = this.f19053h.getBarData().Q() / 2.0f;
            int min = Math.min((int) Math.ceil((double) (((float) iBarDataSet.e1()) * h2)), iBarDataSet.e1());
            for (int i6 = 0; i6 < min; i6++) {
                float m2 = ((BarEntry) iBarDataSet2.X(i6)).m();
                RectF rectF = this.f19083n;
                rectF.top = m2 - Q;
                rectF.bottom = m2 + Q;
                a2.t(rectF);
                if (!this.f19118a.K(this.f19083n.bottom)) {
                    Canvas canvas2 = canvas;
                } else if (!this.f19118a.H(this.f19083n.top)) {
                    break;
                } else {
                    this.f19083n.left = this.f19118a.h();
                    this.f19083n.right = this.f19118a.i();
                    canvas.drawRect(this.f19083n, this.f19056k);
                }
            }
        }
        Canvas canvas3 = canvas;
        BarBuffer barBuffer = this.f19055j[i3];
        barBuffer.e(h2, i5);
        barBuffer.j(i3);
        barBuffer.k(this.f19053h.f(iBarDataSet.a1()));
        barBuffer.i(this.f19053h.getBarData().Q());
        barBuffer.a(iBarDataSet2);
        a2.o(barBuffer.f18909b);
        if (iBarDataSet.B0().size() != 1) {
            z = false;
        }
        if (z) {
            this.f19079c.setColor(iBarDataSet.g1());
        }
        while (i4 < barBuffer.f()) {
            int i7 = i4 + 3;
            if (this.f19118a.K(barBuffer.f18909b[i7])) {
                int i8 = i4 + 1;
                if (this.f19118a.H(barBuffer.f18909b[i8])) {
                    if (!z) {
                        this.f19079c.setColor(iBarDataSet2.d0(i4 / 4));
                    }
                    float[] fArr = barBuffer.f18909b;
                    int i9 = i4 + 2;
                    canvas.drawRect(fArr[i4], fArr[i8], fArr[i9], fArr[i7], this.f19079c);
                    if (z2) {
                        float[] fArr2 = barBuffer.f18909b;
                        canvas.drawRect(fArr2[i4], fArr2[i8], fArr2[i9], fArr2[i7], this.f19057l);
                    }
                }
                i4 += 4;
                Canvas canvas4 = canvas;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void o(float f2, float f3, float f4, float f5, Transformer transformer) {
        this.f19054i.set(f3, f2 - f5, f4, f2 + f5);
        transformer.s(this.f19054i, this.f19078b.i());
    }

    /* access modifiers changed from: protected */
    public void p(Highlight highlight, RectF rectF) {
        highlight.n(rectF.centerY(), rectF.right);
    }
}
