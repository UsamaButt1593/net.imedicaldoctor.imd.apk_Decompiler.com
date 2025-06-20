package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.view.View;
import java.util.HashSet;

abstract class KeyPositionBase extends Key {
    protected static final float E = 20.0f;
    int D = Key.f4366f;

    KeyPositionBase() {
    }

    /* access modifiers changed from: package-private */
    public void d(HashSet<String> hashSet) {
    }

    /* access modifiers changed from: package-private */
    public abstract void o(int i2, int i3, float f2, float f3, float f4, float f5);

    /* access modifiers changed from: package-private */
    public abstract float p();

    /* access modifiers changed from: package-private */
    public abstract float q();

    public abstract boolean r(int i2, int i3, RectF rectF, RectF rectF2, float f2, float f3);

    /* access modifiers changed from: package-private */
    public abstract void s(View view, RectF rectF, RectF rectF2, float f2, float f3, String[] strArr, float[] fArr);
}
