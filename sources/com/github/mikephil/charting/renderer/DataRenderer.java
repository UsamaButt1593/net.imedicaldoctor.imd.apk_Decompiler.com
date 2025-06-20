package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class DataRenderer extends Renderer {

    /* renamed from: b  reason: collision with root package name */
    protected ChartAnimator f19078b;

    /* renamed from: c  reason: collision with root package name */
    protected Paint f19079c;

    /* renamed from: d  reason: collision with root package name */
    protected Paint f19080d;

    /* renamed from: e  reason: collision with root package name */
    protected Paint f19081e = new Paint(4);

    /* renamed from: f  reason: collision with root package name */
    protected Paint f19082f;

    public DataRenderer(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(viewPortHandler);
        this.f19078b = chartAnimator;
        Paint paint = new Paint(1);
        this.f19079c = paint;
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.f19082f = paint2;
        paint2.setColor(Color.rgb(63, 63, 63));
        this.f19082f.setTextAlign(Paint.Align.CENTER);
        this.f19082f.setTextSize(Utils.e(9.0f));
        Paint paint3 = new Paint(1);
        this.f19080d = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        this.f19080d.setStrokeWidth(2.0f);
        this.f19080d.setColor(Color.rgb(255, 187, 115));
    }

    /* access modifiers changed from: protected */
    public void a(IDataSet iDataSet) {
        this.f19082f.setTypeface(iDataSet.k0());
        this.f19082f.setTextSize(iDataSet.S());
    }

    public abstract void b(Canvas canvas);

    public abstract void c(Canvas canvas);

    public abstract void d(Canvas canvas, Highlight[] highlightArr);

    public abstract void e(Canvas canvas, String str, float f2, float f3, int i2);

    public abstract void f(Canvas canvas);

    public Paint g() {
        return this.f19080d;
    }

    public Paint h() {
        return this.f19079c;
    }

    public Paint i() {
        return this.f19082f;
    }

    public abstract void j();

    /* access modifiers changed from: protected */
    public boolean k(ChartInterface chartInterface) {
        return ((float) chartInterface.getData().r()) < ((float) chartInterface.getMaxVisibleCount()) * this.f19118a.w();
    }
}
