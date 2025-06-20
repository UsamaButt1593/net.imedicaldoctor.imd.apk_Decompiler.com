package androidx.constraintlayout.motion.utils;

import android.view.View;

public class ViewState {

    /* renamed from: a  reason: collision with root package name */
    public float f4351a;

    /* renamed from: b  reason: collision with root package name */
    public int f4352b;

    /* renamed from: c  reason: collision with root package name */
    public int f4353c;

    /* renamed from: d  reason: collision with root package name */
    public int f4354d;

    /* renamed from: e  reason: collision with root package name */
    public int f4355e;

    public void a(View view) {
        this.f4352b = view.getLeft();
        this.f4353c = view.getTop();
        this.f4354d = view.getRight();
        this.f4355e = view.getBottom();
        this.f4351a = view.getRotation();
    }

    public int b() {
        return this.f4355e - this.f4353c;
    }

    public int c() {
        return this.f4354d - this.f4352b;
    }
}
