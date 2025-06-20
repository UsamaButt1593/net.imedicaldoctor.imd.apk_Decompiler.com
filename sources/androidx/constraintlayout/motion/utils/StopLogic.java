package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.core.motion.utils.SpringStopEngine;
import androidx.constraintlayout.core.motion.utils.StopEngine;
import androidx.constraintlayout.core.motion.utils.StopLogicEngine;
import androidx.constraintlayout.motion.widget.MotionInterpolator;

public class StopLogic extends MotionInterpolator {

    /* renamed from: a  reason: collision with root package name */
    private StopLogicEngine f4339a;

    /* renamed from: b  reason: collision with root package name */
    private SpringStopEngine f4340b;

    /* renamed from: c  reason: collision with root package name */
    private StopEngine f4341c;

    public StopLogic() {
        StopLogicEngine stopLogicEngine = new StopLogicEngine();
        this.f4339a = stopLogicEngine;
        this.f4341c = stopLogicEngine;
    }

    public float a() {
        return this.f4341c.a();
    }

    public void b(float f2, float f3, float f4, float f5, float f6, float f7) {
        StopLogicEngine stopLogicEngine = this.f4339a;
        this.f4341c = stopLogicEngine;
        stopLogicEngine.f(f2, f3, f4, f5, f6, f7);
    }

    public String c(String str, float f2) {
        return this.f4341c.b(str, f2);
    }

    public float d(float f2) {
        return this.f4341c.c(f2);
    }

    public boolean e() {
        return this.f4341c.d();
    }

    public void f(float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i2) {
        if (this.f4340b == null) {
            this.f4340b = new SpringStopEngine();
        }
        SpringStopEngine springStopEngine = this.f4340b;
        this.f4341c = springStopEngine;
        springStopEngine.h(f2, f3, f4, f5, f6, f7, f8, i2);
    }

    public float getInterpolation(float f2) {
        return this.f4341c.getInterpolation(f2);
    }
}
