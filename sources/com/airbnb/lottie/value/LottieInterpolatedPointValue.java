package com.airbnb.lottie.value;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.utils.MiscUtils;

public class LottieInterpolatedPointValue extends LottieInterpolatedValue<PointF> {

    /* renamed from: g  reason: collision with root package name */
    private final PointF f17375g = new PointF();

    public LottieInterpolatedPointValue(PointF pointF, PointF pointF2) {
        super(pointF, pointF2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public PointF e(PointF pointF, PointF pointF2, float f2) {
        this.f17375g.set(MiscUtils.j(pointF.x, pointF2.x, f2), MiscUtils.j(pointF.y, pointF2.y, f2));
        return this.f17375g;
    }

    public LottieInterpolatedPointValue(PointF pointF, PointF pointF2, Interpolator interpolator) {
        super(pointF, pointF2, interpolator);
    }
}
