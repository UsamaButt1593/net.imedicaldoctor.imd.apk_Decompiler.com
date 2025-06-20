package com.github.mikephil.charting.components;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import com.github.mikephil.charting.utils.Utils;
import com.itextpdf.text.Jpeg;

public class LimitLine extends ComponentBase {

    /* renamed from: g  reason: collision with root package name */
    private float f18958g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    private float f18959h = 2.0f;

    /* renamed from: i  reason: collision with root package name */
    private int f18960i = Color.rgb(Jpeg.X4, 91, 91);

    /* renamed from: j  reason: collision with root package name */
    private Paint.Style f18961j = Paint.Style.FILL_AND_STROKE;

    /* renamed from: k  reason: collision with root package name */
    private String f18962k = "";

    /* renamed from: l  reason: collision with root package name */
    private DashPathEffect f18963l = null;

    /* renamed from: m  reason: collision with root package name */
    private LimitLabelPosition f18964m = LimitLabelPosition.RIGHT_TOP;

    public enum LimitLabelPosition {
        LEFT_TOP,
        LEFT_BOTTOM,
        RIGHT_TOP,
        RIGHT_BOTTOM
    }

    public LimitLine(float f2) {
        this.f18958g = f2;
    }

    public void A(Paint.Style style) {
        this.f18961j = style;
    }

    public void m() {
        this.f18963l = null;
    }

    public void n(float f2, float f3, float f4) {
        this.f18963l = new DashPathEffect(new float[]{f2, f3}, f4);
    }

    public DashPathEffect o() {
        return this.f18963l;
    }

    public String p() {
        return this.f18962k;
    }

    public LimitLabelPosition q() {
        return this.f18964m;
    }

    public float r() {
        return this.f18958g;
    }

    public int s() {
        return this.f18960i;
    }

    public float t() {
        return this.f18959h;
    }

    public Paint.Style u() {
        return this.f18961j;
    }

    public boolean v() {
        return this.f18963l != null;
    }

    public void w(String str) {
        this.f18962k = str;
    }

    public void x(LimitLabelPosition limitLabelPosition) {
        this.f18964m = limitLabelPosition;
    }

    public void y(int i2) {
        this.f18960i = i2;
    }

    public void z(float f2) {
        if (f2 < 0.2f) {
            f2 = 0.2f;
        }
        if (f2 > 12.0f) {
            f2 = 12.0f;
        }
        this.f18959h = Utils.e(f2);
    }

    public LimitLine(float f2, String str) {
        this.f18958g = f2;
        this.f18962k = str;
    }
}
