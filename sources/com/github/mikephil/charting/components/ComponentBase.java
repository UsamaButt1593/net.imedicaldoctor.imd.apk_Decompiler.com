package com.github.mikephil.charting.components;

import android.graphics.Typeface;
import androidx.core.view.ViewCompat;
import com.github.mikephil.charting.utils.Utils;

public abstract class ComponentBase {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f18934a = true;

    /* renamed from: b  reason: collision with root package name */
    protected float f18935b = 5.0f;

    /* renamed from: c  reason: collision with root package name */
    protected float f18936c = 5.0f;

    /* renamed from: d  reason: collision with root package name */
    protected Typeface f18937d = null;

    /* renamed from: e  reason: collision with root package name */
    protected float f18938e = Utils.e(10.0f);

    /* renamed from: f  reason: collision with root package name */
    protected int f18939f = ViewCompat.y;

    public int a() {
        return this.f18939f;
    }

    public float b() {
        return this.f18938e;
    }

    public Typeface c() {
        return this.f18937d;
    }

    public float d() {
        return this.f18935b;
    }

    public float e() {
        return this.f18936c;
    }

    public boolean f() {
        return this.f18934a;
    }

    public void g(boolean z) {
        this.f18934a = z;
    }

    public void h(int i2) {
        this.f18939f = i2;
    }

    public void i(float f2) {
        if (f2 > 24.0f) {
            f2 = 24.0f;
        }
        if (f2 < 6.0f) {
            f2 = 6.0f;
        }
        this.f18938e = Utils.e(f2);
    }

    public void j(Typeface typeface) {
        this.f18937d = typeface;
    }

    public void k(float f2) {
        this.f18935b = Utils.e(f2);
    }

    public void l(float f2) {
        this.f18936c = Utils.e(f2);
    }
}
