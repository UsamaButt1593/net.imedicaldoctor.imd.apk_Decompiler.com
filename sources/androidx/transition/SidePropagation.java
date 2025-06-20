package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SidePropagation extends VisibilityPropagation {

    /* renamed from: d  reason: collision with root package name */
    private float f16032d = 3.0f;

    /* renamed from: e  reason: collision with root package name */
    private int f16033e = 80;

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        if (r6.getLayoutDirection() == 1) goto L_0x0010;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        r0 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if (r6.getLayoutDirection() == 1) goto L_0x0012;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int h(android.view.View r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14) {
        /*
            r5 = this;
            int r0 = r5.f16033e
            r1 = 8388611(0x800003, float:1.1754948E-38)
            r2 = 1
            r3 = 3
            r4 = 5
            if (r0 != r1) goto L_0x0014
            int r6 = r6.getLayoutDirection()
            if (r6 != r2) goto L_0x0012
        L_0x0010:
            r0 = 5
            goto L_0x0020
        L_0x0012:
            r0 = 3
            goto L_0x0020
        L_0x0014:
            r1 = 8388613(0x800005, float:1.175495E-38)
            if (r0 != r1) goto L_0x0020
            int r6 = r6.getLayoutDirection()
            if (r6 != r2) goto L_0x0010
            goto L_0x0012
        L_0x0020:
            if (r0 == r3) goto L_0x0046
            if (r0 == r4) goto L_0x003e
            r6 = 48
            if (r0 == r6) goto L_0x0036
            r6 = 80
            if (r0 == r6) goto L_0x002e
            r6 = 0
            goto L_0x004d
        L_0x002e:
            int r8 = r8 - r12
            int r9 = r9 - r7
            int r6 = java.lang.Math.abs(r9)
            int r6 = r6 + r8
            goto L_0x004d
        L_0x0036:
            int r14 = r14 - r8
            int r9 = r9 - r7
            int r6 = java.lang.Math.abs(r9)
            int r6 = r6 + r14
            goto L_0x004d
        L_0x003e:
            int r7 = r7 - r11
            int r10 = r10 - r8
            int r6 = java.lang.Math.abs(r10)
            int r6 = r6 + r7
            goto L_0x004d
        L_0x0046:
            int r13 = r13 - r7
            int r10 = r10 - r8
            int r6 = java.lang.Math.abs(r10)
            int r6 = r6 + r13
        L_0x004d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.SidePropagation.h(android.view.View, int, int, int, int, int, int, int, int):int");
    }

    private int i(ViewGroup viewGroup) {
        int i2 = this.f16033e;
        return (i2 == 3 || i2 == 5 || i2 == 8388611 || i2 == 8388613) ? viewGroup.getWidth() : viewGroup.getHeight();
    }

    public long c(@NonNull ViewGroup viewGroup, @NonNull Transition transition, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        int i2;
        int i3;
        int i4;
        TransitionValues transitionValues3 = transitionValues;
        if (transitionValues3 == null && transitionValues2 == null) {
            return 0;
        }
        Rect S = transition.S();
        if (transitionValues2 == null || e(transitionValues3) == 0) {
            i2 = -1;
        } else {
            transitionValues3 = transitionValues2;
            i2 = 1;
        }
        int f2 = f(transitionValues3);
        int g2 = g(transitionValues3);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int round = iArr[0] + Math.round(viewGroup.getTranslationX());
        int round2 = iArr[1] + Math.round(viewGroup.getTranslationY());
        int width = round + viewGroup.getWidth();
        int height = round2 + viewGroup.getHeight();
        if (S != null) {
            i4 = S.centerX();
            i3 = S.centerY();
        } else {
            i4 = (round + width) / 2;
            i3 = (round2 + height) / 2;
        }
        float h2 = ((float) h(viewGroup, f2, g2, i4, i3, round, round2, width, height)) / ((float) i(viewGroup));
        long Q = transition.Q();
        if (Q < 0) {
            Q = 300;
        }
        return (long) Math.round((((float) (Q * ((long) i2))) / this.f16032d) * h2);
    }

    public void j(float f2) {
        if (f2 != 0.0f) {
            this.f16032d = f2;
            return;
        }
        throw new IllegalArgumentException("propagationSpeed may not be 0");
    }

    public void k(int i2) {
        this.f16033e = i2;
    }
}
