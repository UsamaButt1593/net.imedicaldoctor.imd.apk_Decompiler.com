package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Keyframe;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

class KeyframeSet {

    /* renamed from: a  reason: collision with root package name */
    int f27881a;

    /* renamed from: b  reason: collision with root package name */
    Keyframe f27882b = this.f27885e.get(0);

    /* renamed from: c  reason: collision with root package name */
    Keyframe f27883c;

    /* renamed from: d  reason: collision with root package name */
    Interpolator f27884d;

    /* renamed from: e  reason: collision with root package name */
    ArrayList<Keyframe> f27885e;

    /* renamed from: f  reason: collision with root package name */
    TypeEvaluator f27886f;

    public KeyframeSet(Keyframe... keyframeArr) {
        this.f27881a = keyframeArr.length;
        ArrayList<Keyframe> arrayList = new ArrayList<>();
        this.f27885e = arrayList;
        arrayList.addAll(Arrays.asList(keyframeArr));
        Keyframe keyframe = this.f27885e.get(this.f27881a - 1);
        this.f27883c = keyframe;
        this.f27884d = keyframe.c();
    }

    public static KeyframeSet c(float... fArr) {
        int length = fArr.length;
        Keyframe.FloatKeyframe[] floatKeyframeArr = new Keyframe.FloatKeyframe[Math.max(length, 2)];
        if (length == 1) {
            floatKeyframeArr[0] = (Keyframe.FloatKeyframe) Keyframe.g(0.0f);
            floatKeyframeArr[1] = (Keyframe.FloatKeyframe) Keyframe.h(1.0f, fArr[0]);
        } else {
            floatKeyframeArr[0] = (Keyframe.FloatKeyframe) Keyframe.h(0.0f, fArr[0]);
            for (int i2 = 1; i2 < length; i2++) {
                floatKeyframeArr[i2] = (Keyframe.FloatKeyframe) Keyframe.h(((float) i2) / ((float) (length - 1)), fArr[i2]);
            }
        }
        return new FloatKeyframeSet(floatKeyframeArr);
    }

    public static KeyframeSet d(int... iArr) {
        int length = iArr.length;
        Keyframe.IntKeyframe[] intKeyframeArr = new Keyframe.IntKeyframe[Math.max(length, 2)];
        if (length == 1) {
            intKeyframeArr[0] = (Keyframe.IntKeyframe) Keyframe.i(0.0f);
            intKeyframeArr[1] = (Keyframe.IntKeyframe) Keyframe.l(1.0f, iArr[0]);
        } else {
            intKeyframeArr[0] = (Keyframe.IntKeyframe) Keyframe.l(0.0f, iArr[0]);
            for (int i2 = 1; i2 < length; i2++) {
                intKeyframeArr[i2] = (Keyframe.IntKeyframe) Keyframe.l(((float) i2) / ((float) (length - 1)), iArr[i2]);
            }
        }
        return new IntKeyframeSet(intKeyframeArr);
    }

    public static KeyframeSet e(Keyframe... keyframeArr) {
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (Keyframe keyframe : keyframeArr) {
            if (keyframe instanceof Keyframe.FloatKeyframe) {
                z = true;
            } else if (keyframe instanceof Keyframe.IntKeyframe) {
                z2 = true;
            } else {
                z3 = true;
            }
        }
        if (z && !z2 && !z3) {
            Keyframe.FloatKeyframe[] floatKeyframeArr = new Keyframe.FloatKeyframe[r0];
            while (i2 < r0) {
                floatKeyframeArr[i2] = keyframeArr[i2];
                i2++;
            }
            return new FloatKeyframeSet(floatKeyframeArr);
        } else if (!z2 || z || z3) {
            return new KeyframeSet(keyframeArr);
        } else {
            Keyframe.IntKeyframe[] intKeyframeArr = new Keyframe.IntKeyframe[r0];
            while (i2 < r0) {
                intKeyframeArr[i2] = keyframeArr[i2];
                i2++;
            }
            return new IntKeyframeSet(intKeyframeArr);
        }
    }

    public static KeyframeSet f(Object... objArr) {
        int length = objArr.length;
        Keyframe.ObjectKeyframe[] objectKeyframeArr = new Keyframe.ObjectKeyframe[Math.max(length, 2)];
        if (length == 1) {
            objectKeyframeArr[0] = (Keyframe.ObjectKeyframe) Keyframe.m(0.0f);
            objectKeyframeArr[1] = (Keyframe.ObjectKeyframe) Keyframe.n(1.0f, objArr[0]);
        } else {
            objectKeyframeArr[0] = (Keyframe.ObjectKeyframe) Keyframe.n(0.0f, objArr[0]);
            for (int i2 = 1; i2 < length; i2++) {
                objectKeyframeArr[i2] = (Keyframe.ObjectKeyframe) Keyframe.n(((float) i2) / ((float) (length - 1)), objArr[i2]);
            }
        }
        return new KeyframeSet(objectKeyframeArr);
    }

    /* renamed from: a */
    public KeyframeSet clone() {
        ArrayList<Keyframe> arrayList = this.f27885e;
        int size = arrayList.size();
        Keyframe[] keyframeArr = new Keyframe[size];
        for (int i2 = 0; i2 < size; i2++) {
            keyframeArr[i2] = arrayList.get(i2).clone();
        }
        return new KeyframeSet(keyframeArr);
    }

    public Object b(float f2) {
        int i2 = this.f27881a;
        if (i2 == 2) {
            Interpolator interpolator = this.f27884d;
            if (interpolator != null) {
                f2 = interpolator.getInterpolation(f2);
            }
            return this.f27886f.evaluate(f2, this.f27882b.e(), this.f27883c.e());
        }
        int i3 = 1;
        if (f2 <= 0.0f) {
            Keyframe keyframe = this.f27885e.get(1);
            Interpolator c2 = keyframe.c();
            if (c2 != null) {
                f2 = c2.getInterpolation(f2);
            }
            float b2 = this.f27882b.b();
            return this.f27886f.evaluate((f2 - b2) / (keyframe.b() - b2), this.f27882b.e(), keyframe.e());
        } else if (f2 >= 1.0f) {
            Keyframe keyframe2 = this.f27885e.get(i2 - 2);
            Interpolator c3 = this.f27883c.c();
            if (c3 != null) {
                f2 = c3.getInterpolation(f2);
            }
            float b3 = keyframe2.b();
            return this.f27886f.evaluate((f2 - b3) / (this.f27883c.b() - b3), keyframe2.e(), this.f27883c.e());
        } else {
            Keyframe keyframe3 = this.f27882b;
            while (i3 < this.f27881a) {
                Keyframe keyframe4 = this.f27885e.get(i3);
                if (f2 < keyframe4.b()) {
                    Interpolator c4 = keyframe4.c();
                    if (c4 != null) {
                        f2 = c4.getInterpolation(f2);
                    }
                    float b4 = keyframe3.b();
                    return this.f27886f.evaluate((f2 - b4) / (keyframe4.b() - b4), keyframe3.e(), keyframe4.e());
                }
                i3++;
                keyframe3 = keyframe4;
            }
            return this.f27883c.e();
        }
    }

    public void g(TypeEvaluator typeEvaluator) {
        this.f27886f = typeEvaluator;
    }

    public String toString() {
        String str = StringUtils.SPACE;
        for (int i2 = 0; i2 < this.f27881a; i2++) {
            str = str + this.f27885e.get(i2).e() + "  ";
        }
        return str;
    }
}
