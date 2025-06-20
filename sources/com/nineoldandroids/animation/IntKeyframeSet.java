package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Keyframe;
import java.util.ArrayList;

class IntKeyframeSet extends KeyframeSet {

    /* renamed from: g  reason: collision with root package name */
    private int f27877g;

    /* renamed from: h  reason: collision with root package name */
    private int f27878h;

    /* renamed from: i  reason: collision with root package name */
    private int f27879i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f27880j = true;

    public IntKeyframeSet(Keyframe.IntKeyframe... intKeyframeArr) {
        super(intKeyframeArr);
    }

    public Object b(float f2) {
        return Integer.valueOf(i(f2));
    }

    /* renamed from: h */
    public IntKeyframeSet clone() {
        ArrayList<Keyframe> arrayList = this.f27885e;
        int size = arrayList.size();
        Keyframe.IntKeyframe[] intKeyframeArr = new Keyframe.IntKeyframe[size];
        for (int i2 = 0; i2 < size; i2++) {
            intKeyframeArr[i2] = (Keyframe.IntKeyframe) arrayList.get(i2).clone();
        }
        return new IntKeyframeSet(intKeyframeArr);
    }

    public int i(float f2) {
        Object e2;
        int i2 = this.f27881a;
        if (i2 != 2) {
            if (f2 > 0.0f) {
                if (f2 < 1.0f) {
                    Keyframe.IntKeyframe intKeyframe = (Keyframe.IntKeyframe) this.f27885e.get(0);
                    int i3 = 1;
                    while (true) {
                        int i4 = this.f27881a;
                        if (i3 >= i4) {
                            e2 = this.f27885e.get(i4 - 1).e();
                            break;
                        }
                        Keyframe.IntKeyframe intKeyframe2 = (Keyframe.IntKeyframe) this.f27885e.get(i3);
                        if (f2 < intKeyframe2.b()) {
                            Interpolator c2 = intKeyframe2.c();
                            if (c2 != null) {
                                f2 = c2.getInterpolation(f2);
                            }
                            float b2 = (f2 - intKeyframe.b()) / (intKeyframe2.b() - intKeyframe.b());
                            int s = intKeyframe.s();
                            int s2 = intKeyframe2.s();
                            TypeEvaluator typeEvaluator = this.f27886f;
                            return typeEvaluator == null ? s + ((int) (b2 * ((float) (s2 - s)))) : ((Number) typeEvaluator.evaluate(b2, Integer.valueOf(s), Integer.valueOf(s2))).intValue();
                        }
                        i3++;
                        intKeyframe = intKeyframe2;
                    }
                } else {
                    Keyframe.IntKeyframe intKeyframe3 = (Keyframe.IntKeyframe) this.f27885e.get(i2 - 2);
                    Keyframe.IntKeyframe intKeyframe4 = (Keyframe.IntKeyframe) this.f27885e.get(this.f27881a - 1);
                    int s3 = intKeyframe3.s();
                    int s4 = intKeyframe4.s();
                    float b3 = intKeyframe3.b();
                    float b4 = intKeyframe4.b();
                    Interpolator c3 = intKeyframe4.c();
                    if (c3 != null) {
                        f2 = c3.getInterpolation(f2);
                    }
                    float f3 = (f2 - b3) / (b4 - b3);
                    TypeEvaluator typeEvaluator2 = this.f27886f;
                    return typeEvaluator2 == null ? s3 + ((int) (f3 * ((float) (s4 - s3)))) : ((Number) typeEvaluator2.evaluate(f3, Integer.valueOf(s3), Integer.valueOf(s4))).intValue();
                }
            } else {
                Keyframe.IntKeyframe intKeyframe5 = (Keyframe.IntKeyframe) this.f27885e.get(0);
                Keyframe.IntKeyframe intKeyframe6 = (Keyframe.IntKeyframe) this.f27885e.get(1);
                int s5 = intKeyframe5.s();
                int s6 = intKeyframe6.s();
                float b5 = intKeyframe5.b();
                float b6 = intKeyframe6.b();
                Interpolator c4 = intKeyframe6.c();
                if (c4 != null) {
                    f2 = c4.getInterpolation(f2);
                }
                float f4 = (f2 - b5) / (b6 - b5);
                TypeEvaluator typeEvaluator3 = this.f27886f;
                return typeEvaluator3 == null ? s5 + ((int) (f4 * ((float) (s6 - s5)))) : ((Number) typeEvaluator3.evaluate(f4, Integer.valueOf(s5), Integer.valueOf(s6))).intValue();
            }
        } else {
            if (this.f27880j) {
                this.f27880j = false;
                this.f27877g = ((Keyframe.IntKeyframe) this.f27885e.get(0)).s();
                int s7 = ((Keyframe.IntKeyframe) this.f27885e.get(1)).s();
                this.f27878h = s7;
                this.f27879i = s7 - this.f27877g;
            }
            Interpolator interpolator = this.f27884d;
            if (interpolator != null) {
                f2 = interpolator.getInterpolation(f2);
            }
            TypeEvaluator typeEvaluator4 = this.f27886f;
            if (typeEvaluator4 == null) {
                return this.f27877g + ((int) (f2 * ((float) this.f27879i)));
            }
            e2 = typeEvaluator4.evaluate(f2, Integer.valueOf(this.f27877g), Integer.valueOf(this.f27878h));
        }
        return ((Number) e2).intValue();
    }
}
