package com.github.mikephil.charting.components;

import android.graphics.Paint;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;

public class Description extends ComponentBase {

    /* renamed from: g  reason: collision with root package name */
    private String f18940g = "Description Label";

    /* renamed from: h  reason: collision with root package name */
    private MPPointF f18941h;

    /* renamed from: i  reason: collision with root package name */
    private Paint.Align f18942i = Paint.Align.RIGHT;

    public Description() {
        this.f18938e = Utils.e(8.0f);
    }

    public MPPointF m() {
        return this.f18941h;
    }

    public String n() {
        return this.f18940g;
    }

    public Paint.Align o() {
        return this.f18942i;
    }

    public void p(float f2, float f3) {
        MPPointF mPPointF = this.f18941h;
        if (mPPointF == null) {
            this.f18941h = MPPointF.c(f2, f3);
            return;
        }
        mPPointF.Y = f2;
        mPPointF.Z = f3;
    }

    public void q(String str) {
        this.f18940g = str;
    }

    public void r(Paint.Align align) {
        this.f18942i = align;
    }
}
