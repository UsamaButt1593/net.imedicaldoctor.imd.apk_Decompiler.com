package androidx.transition;

import android.animation.TypeEvaluator;

class FloatArrayEvaluator implements TypeEvaluator<float[]> {

    /* renamed from: a  reason: collision with root package name */
    private float[] f15994a;

    FloatArrayEvaluator(float[] fArr) {
        this.f15994a = fArr;
    }

    /* renamed from: a */
    public float[] evaluate(float f2, float[] fArr, float[] fArr2) {
        float[] fArr3 = this.f15994a;
        if (fArr3 == null) {
            fArr3 = new float[fArr.length];
        }
        for (int i2 = 0; i2 < fArr3.length; i2++) {
            float f3 = fArr[i2];
            fArr3[i2] = f3 + ((fArr2[i2] - f3) * f2);
        }
        return fArr3;
    }
}
