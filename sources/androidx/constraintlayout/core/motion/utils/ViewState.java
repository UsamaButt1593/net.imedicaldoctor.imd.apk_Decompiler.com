package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.MotionWidget;

public class ViewState {

    /* renamed from: a  reason: collision with root package name */
    public float f4060a;

    /* renamed from: b  reason: collision with root package name */
    public int f4061b;

    /* renamed from: c  reason: collision with root package name */
    public int f4062c;

    /* renamed from: d  reason: collision with root package name */
    public int f4063d;

    /* renamed from: e  reason: collision with root package name */
    public int f4064e;

    public void a(MotionWidget motionWidget) {
        this.f4061b = motionWidget.l();
        this.f4062c = motionWidget.w();
        this.f4063d = motionWidget.q();
        this.f4064e = motionWidget.h();
        this.f4060a = (float) ((int) motionWidget.t());
    }

    public int b() {
        return this.f4064e - this.f4062c;
    }

    public int c() {
        return this.f4063d - this.f4061b;
    }
}
