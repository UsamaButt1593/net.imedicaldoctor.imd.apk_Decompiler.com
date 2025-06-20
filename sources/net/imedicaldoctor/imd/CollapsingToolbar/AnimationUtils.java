package net.imedicaldoctor.imd.CollapsingToolbar;

import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

class AnimationUtils {

    /* renamed from: a  reason: collision with root package name */
    static final Interpolator f29480a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    static final Interpolator f29481b = new FastOutSlowInInterpolator();

    /* renamed from: c  reason: collision with root package name */
    static final Interpolator f29482c = new FastOutLinearInInterpolator();

    /* renamed from: d  reason: collision with root package name */
    static final Interpolator f29483d = new LinearOutSlowInInterpolator();

    /* renamed from: e  reason: collision with root package name */
    static final Interpolator f29484e = new DecelerateInterpolator();

    static class AnimationListenerAdapter implements Animation.AnimationListener {
        AnimationListenerAdapter() {
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    AnimationUtils() {
    }

    static float a(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    static int b(int i2, int i3, float f2) {
        return i2 + Math.round(f2 * ((float) (i3 - i2)));
    }
}
