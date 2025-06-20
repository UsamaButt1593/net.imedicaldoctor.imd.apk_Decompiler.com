package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;
import java.util.HashMap;

public class KeyCache {

    /* renamed from: a  reason: collision with root package name */
    HashMap<Object, HashMap<String, float[]>> f3785a = new HashMap<>();

    public float a(Object obj, String str, int i2) {
        HashMap hashMap;
        float[] fArr;
        if (this.f3785a.containsKey(obj) && (hashMap = this.f3785a.get(obj)) != null && hashMap.containsKey(str) && (fArr = (float[]) hashMap.get(str)) != null && fArr.length > i2) {
            return fArr[i2];
        }
        return Float.NaN;
    }

    public void b(Object obj, String str, int i2, float f2) {
        HashMap hashMap;
        if (!this.f3785a.containsKey(obj)) {
            hashMap = new HashMap();
            float[] fArr = new float[(i2 + 1)];
            fArr[i2] = f2;
            hashMap.put(str, fArr);
        } else {
            hashMap = this.f3785a.get(obj);
            if (hashMap == null) {
                hashMap = new HashMap();
            }
            if (!hashMap.containsKey(str)) {
                float[] fArr2 = new float[(i2 + 1)];
                fArr2[i2] = f2;
                hashMap.put(str, fArr2);
            } else {
                float[] fArr3 = (float[]) hashMap.get(str);
                if (fArr3 == null) {
                    fArr3 = new float[0];
                }
                if (fArr3.length <= i2) {
                    fArr3 = Arrays.copyOf(fArr3, i2 + 1);
                }
                fArr3[i2] = f2;
                hashMap.put(str, fArr3);
                return;
            }
        }
        this.f3785a.put(obj, hashMap);
    }
}
