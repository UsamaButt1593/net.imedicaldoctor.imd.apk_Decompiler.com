package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class PathKeyframeAnimation extends KeyframeAnimation<PointF> {

    /* renamed from: i  reason: collision with root package name */
    private final PointF f17056i = new PointF();

    /* renamed from: j  reason: collision with root package name */
    private final float[] f17057j = new float[2];

    /* renamed from: k  reason: collision with root package name */
    private PathKeyframe f17058k;

    /* renamed from: l  reason: collision with root package name */
    private PathMeasure f17059l = new PathMeasure();

    public PathKeyframeAnimation(List<? extends Keyframe<PointF>> list) {
        super(list);
    }

    /* renamed from: o */
    public PointF i(Keyframe<PointF> keyframe, float f2) {
        PathKeyframe pathKeyframe = (PathKeyframe) keyframe;
        Path j2 = pathKeyframe.j();
        if (j2 == null) {
            return (PointF) keyframe.f17355b;
        }
        LottieValueCallback<A> lottieValueCallback = this.f17042e;
        if (lottieValueCallback != null) {
            PointF pointF = (PointF) lottieValueCallback.b(pathKeyframe.f17358e, pathKeyframe.f17359f.floatValue(), pathKeyframe.f17355b, pathKeyframe.f17356c, e(), f2, f());
            if (pointF != null) {
                return pointF;
            }
        }
        if (this.f17058k != pathKeyframe) {
            this.f17059l.setPath(j2, false);
            this.f17058k = pathKeyframe;
        }
        PathMeasure pathMeasure = this.f17059l;
        pathMeasure.getPosTan(f2 * pathMeasure.getLength(), this.f17057j, (float[]) null);
        PointF pointF2 = this.f17056i;
        float[] fArr = this.f17057j;
        pointF2.set(fArr[0], fArr[1]);
        return this.f17056i;
    }
}
