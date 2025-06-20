package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Keyframe;
import java.util.ArrayList;

class FloatKeyframeSet extends KeyframeSet {

    /* renamed from: g  reason: collision with root package name */
    private float f27873g;

    /* renamed from: h  reason: collision with root package name */
    private float f27874h;

    /* renamed from: i  reason: collision with root package name */
    private float f27875i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f27876j = true;

    public FloatKeyframeSet(Keyframe.FloatKeyframe... floatKeyframeArr) {
        super(floatKeyframeArr);
    }

    public Object b(float f2) {
        return Float.valueOf(i(f2));
    }

    /* renamed from: h */
    public FloatKeyframeSet clone() {
        ArrayList<Keyframe> arrayList = this.f27885e;
        int size = arrayList.size();
        Keyframe.FloatKeyframe[] floatKeyframeArr = new Keyframe.FloatKeyframe[size];
        for (int i2 = 0; i2 < size; i2++) {
            floatKeyframeArr[i2] = (Keyframe.FloatKeyframe) arrayList.get(i2).clone();
        }
        return new FloatKeyframeSet(floatKeyframeArr);
    }

    public float i(float f2) {
        Object e2;
        int i2 = this.f27881a;
        if (i2 != 2) {
            if (f2 > 0.0f) {
                if (f2 < 1.0f) {
                    Keyframe.FloatKeyframe floatKeyframe = (Keyframe.FloatKeyframe) this.f27885e.get(0);
                    int i3 = 1;
                    while (true) {
                        int i4 = this.f27881a;
                        if (i3 >= i4) {
                            e2 = this.f27885e.get(i4 - 1).e();
                            break;
                        }
                        Keyframe.FloatKeyframe floatKeyframe2 = (Keyframe.FloatKeyframe) this.f27885e.get(i3);
                        if (f2 < floatKeyframe2.b()) {
                            Interpolator c2 = floatKeyframe2.c();
                            if (c2 != null) {
                                f2 = c2.getInterpolation(f2);
                            }
                            float b2 = (f2 - floatKeyframe.b()) / (floatKeyframe2.b() - floatKeyframe.b());
                            float s = floatKeyframe.s();
                            float s2 = floatKeyframe2.s();
                            TypeEvaluator typeEvaluator = this.f27886f;
                            return typeEvaluator == null ? s + (b2 * (s2 - s)) : ((Number) typeEvaluator.evaluate(b2, Float.valueOf(s), Float.valueOf(s2))).floatValue();
                        }
                        i3++;
                        floatKeyframe = floatKeyframe2;
                    }
                } else {
                    Keyframe.FloatKeyframe floatKeyframe3 = (Keyframe.FloatKeyframe) this.f27885e.get(i2 - 2);
                    Keyframe.FloatKeyframe floatKeyframe4 = (Keyframe.FloatKeyframe) this.f27885e.get(this.f27881a - 1);
                    float s3 = floatKeyframe3.s();
                    float s4 = floatKeyframe4.s();
                    float b3 = floatKeyframe3.b();
                    float b4 = floatKeyframe4.b();
                    Interpolator c3 = floatKeyframe4.c();
                    if (c3 != null) {
                        f2 = c3.getInterpolation(f2);
                    }
                    float f3 = (f2 - b3) / (b4 - b3);
                    TypeEvaluator typeEvaluator2 = this.f27886f;
                    return typeEvaluator2 == null ? s3 + (f3 * (s4 - s3)) : ((Number) typeEvaluator2.evaluate(f3, Float.valueOf(s3), Float.valueOf(s4))).floatValue();
                }
            } else {
                Keyframe.FloatKeyframe floatKeyframe5 = (Keyframe.FloatKeyframe) this.f27885e.get(0);
                Keyframe.FloatKeyframe floatKeyframe6 = (Keyframe.FloatKeyframe) this.f27885e.get(1);
                float s5 = floatKeyframe5.s();
                float s6 = floatKeyframe6.s();
                float b5 = floatKeyframe5.b();
                float b6 = floatKeyframe6.b();
                Interpolator c4 = floatKeyframe6.c();
                if (c4 != null) {
                    f2 = c4.getInterpolation(f2);
                }
                float f4 = (f2 - b5) / (b6 - b5);
                TypeEvaluator typeEvaluator3 = this.f27886f;
                return typeEvaluator3 == null ? s5 + (f4 * (s6 - s5)) : ((Number) typeEvaluator3.evaluate(f4, Float.valueOf(s5), Float.valueOf(s6))).floatValue();
            }
        } else {
            if (this.f27876j) {
                this.f27876j = false;
                this.f27873g = ((Keyframe.FloatKeyframe) this.f27885e.get(0)).s();
                float s7 = ((Keyframe.FloatKeyframe) this.f27885e.get(1)).s();
                this.f27874h = s7;
                this.f27875i = s7 - this.f27873g;
            }
            Interpolator interpolator = this.f27884d;
            if (interpolator != null) {
                f2 = interpolator.getInterpolation(f2);
            }
            TypeEvaluator typeEvaluator4 = this.f27886f;
            if (typeEvaluator4 == null) {
                return this.f27873g + (f2 * this.f27875i);
            }
            e2 = typeEvaluator4.evaluate(f2, Float.valueOf(this.f27873g), Float.valueOf(this.f27874h));
        }
        return ((Number) e2).floatValue();
    }
}
