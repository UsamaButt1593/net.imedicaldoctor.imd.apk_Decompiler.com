package androidx.constraintlayout.motion.widget;

import android.view.animation.Interpolator;

public abstract class MotionInterpolator implements Interpolator {
    public abstract float a();

    public abstract float getInterpolation(float f2);
}
