package androidx.transition;

import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.transition.Transition;

public final /* synthetic */ class d implements DynamicAnimation.OnAnimationEndListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Transition.SeekController f16139a;

    public /* synthetic */ d(Transition.SeekController seekController) {
        this.f16139a = seekController;
    }

    public final void a(DynamicAnimation dynamicAnimation, boolean z, float f2, float f3) {
        this.f16139a.y(dynamicAnimation, z, f2, f3);
    }
}
