package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.widget.R;

public class MotionEffect extends MotionHelper {
    public static final String r3 = "FadeMove";
    public static final int s3 = -1;
    public static final int t3 = 0;
    public static final int u3 = 1;
    public static final int v3 = 2;
    public static final int w3 = 3;
    private static final int x3 = -1;
    private float j3 = 0.1f;
    private int k3 = 49;
    private int l3 = 50;
    private int m3 = 0;
    private int n3 = 0;
    private boolean o3 = true;
    private int p3 = -1;
    private int q3 = -1;

    public MotionEffect(Context context) {
        super(context);
    }

    private void K(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.xj);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.Bj) {
                    int i3 = obtainStyledAttributes.getInt(index, this.k3);
                    this.k3 = i3;
                    this.k3 = Math.max(Math.min(i3, 99), 0);
                } else if (index == R.styleable.zj) {
                    int i4 = obtainStyledAttributes.getInt(index, this.l3);
                    this.l3 = i4;
                    this.l3 = Math.max(Math.min(i4, 99), 0);
                } else if (index == R.styleable.Dj) {
                    this.m3 = obtainStyledAttributes.getDimensionPixelOffset(index, this.m3);
                } else if (index == R.styleable.Ej) {
                    this.n3 = obtainStyledAttributes.getDimensionPixelOffset(index, this.n3);
                } else if (index == R.styleable.yj) {
                    this.j3 = obtainStyledAttributes.getFloat(index, this.j3);
                } else if (index == R.styleable.Aj) {
                    this.q3 = obtainStyledAttributes.getInt(index, this.q3);
                } else if (index == R.styleable.Cj) {
                    this.o3 = obtainStyledAttributes.getBoolean(index, this.o3);
                } else if (index == R.styleable.Fj) {
                    this.p3 = obtainStyledAttributes.getResourceId(index, this.p3);
                }
            }
            int i5 = this.k3;
            int i6 = this.l3;
            if (i5 == i6) {
                if (i5 > 0) {
                    this.k3 = i5 - 1;
                } else {
                    this.l3 = i6 + 1;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0186, code lost:
        if (r14 == 0.0f) goto L_0x018b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x019a, code lost:
        if (r14 == 0.0f) goto L_0x018b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01aa, code lost:
        if (r15 == 0.0f) goto L_0x018b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01ba, code lost:
        if (r15 == 0.0f) goto L_0x0162;
     */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01e5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(androidx.constraintlayout.motion.widget.MotionLayout r23, java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r24) {
        /*
            r22 = this;
            r0 = r22
            r1 = r24
            android.view.ViewParent r2 = r22.getParent()
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            android.view.View[] r2 = r0.w(r2)
            if (r2 != 0) goto L_0x002b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = androidx.constraintlayout.motion.widget.Debug.f()
            r1.append(r2)
            java.lang.String r2 = " views = null"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "FadeMove"
            android.util.Log.v(r2, r1)
            return
        L_0x002b:
            androidx.constraintlayout.motion.widget.KeyAttributes r3 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r3.<init>()
            androidx.constraintlayout.motion.widget.KeyAttributes r4 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r4.<init>()
            float r5 = r0.j3
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            java.lang.String r6 = "alpha"
            r3.j(r6, r5)
            float r5 = r0.j3
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r4.j(r6, r5)
            int r5 = r0.k3
            r3.h(r5)
            int r5 = r0.l3
            r4.h(r5)
            androidx.constraintlayout.motion.widget.KeyPosition r5 = new androidx.constraintlayout.motion.widget.KeyPosition
            r5.<init>()
            int r6 = r0.k3
            r5.h(r6)
            r6 = 0
            r5.z(r6)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            java.lang.String r8 = "percentX"
            r5.j(r8, r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            java.lang.String r9 = "percentY"
            r5.j(r9, r7)
            androidx.constraintlayout.motion.widget.KeyPosition r7 = new androidx.constraintlayout.motion.widget.KeyPosition
            r7.<init>()
            int r10 = r0.l3
            r7.h(r10)
            r7.z(r6)
            r10 = 1
            java.lang.Integer r11 = java.lang.Integer.valueOf(r10)
            r7.j(r8, r11)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r10)
            r7.j(r9, r8)
            int r8 = r0.m3
            r9 = 0
            if (r8 <= 0) goto L_0x00bc
            androidx.constraintlayout.motion.widget.KeyAttributes r8 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r8.<init>()
            androidx.constraintlayout.motion.widget.KeyAttributes r11 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r11.<init>()
            int r12 = r0.m3
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.String r13 = "translationX"
            r8.j(r13, r12)
            int r12 = r0.l3
            r8.h(r12)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r6)
            r11.j(r13, r12)
            int r12 = r0.l3
            int r12 = r12 - r10
            r11.h(r12)
            goto L_0x00be
        L_0x00bc:
            r8 = r9
            r11 = r8
        L_0x00be:
            int r12 = r0.n3
            if (r12 <= 0) goto L_0x00ea
            androidx.constraintlayout.motion.widget.KeyAttributes r9 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r9.<init>()
            androidx.constraintlayout.motion.widget.KeyAttributes r12 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r12.<init>()
            int r13 = r0.n3
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            java.lang.String r14 = "translationY"
            r9.j(r14, r13)
            int r13 = r0.l3
            r9.h(r13)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r6)
            r12.j(r14, r13)
            int r13 = r0.l3
            int r13 = r13 - r10
            r12.h(r13)
            goto L_0x00eb
        L_0x00ea:
            r12 = r9
        L_0x00eb:
            int r13 = r0.q3
            r14 = -1
            r17 = 0
            if (r13 != r14) goto L_0x0154
            r13 = 4
            int[] r14 = new int[r13]
            r13 = 0
        L_0x00f6:
            int r15 = r2.length
            if (r13 >= r15) goto L_0x0143
            r15 = r2[r13]
            java.lang.Object r15 = r1.get(r15)
            androidx.constraintlayout.motion.widget.MotionController r15 = (androidx.constraintlayout.motion.widget.MotionController) r15
            if (r15 != 0) goto L_0x0104
            goto L_0x0140
        L_0x0104:
            float r20 = r15.t()
            float r21 = r15.G()
            float r20 = r20 - r21
            float r21 = r15.u()
            float r15 = r15.H()
            float r21 = r21 - r15
            int r15 = (r21 > r17 ? 1 : (r21 == r17 ? 0 : -1))
            if (r15 >= 0) goto L_0x0121
            r15 = r14[r10]
            int r15 = r15 + r10
            r14[r10] = r15
        L_0x0121:
            int r15 = (r21 > r17 ? 1 : (r21 == r17 ? 0 : -1))
            if (r15 <= 0) goto L_0x012a
            r15 = r14[r6]
            int r15 = r15 + r10
            r14[r6] = r15
        L_0x012a:
            int r15 = (r20 > r17 ? 1 : (r20 == r17 ? 0 : -1))
            if (r15 <= 0) goto L_0x0135
            r15 = 3
            r19 = r14[r15]
            int r19 = r19 + 1
            r14[r15] = r19
        L_0x0135:
            int r15 = (r20 > r17 ? 1 : (r20 == r17 ? 0 : -1))
            if (r15 >= 0) goto L_0x0140
            r15 = 2
            r16 = r14[r15]
            int r16 = r16 + 1
            r14[r15] = r16
        L_0x0140:
            int r13 = r13 + 1
            goto L_0x00f6
        L_0x0143:
            r13 = r14[r6]
            r15 = r13
            r6 = 4
            r13 = 0
        L_0x0148:
            if (r10 >= r6) goto L_0x0154
            r6 = r14[r10]
            if (r15 >= r6) goto L_0x0150
            r15 = r6
            r13 = r10
        L_0x0150:
            int r10 = r10 + 1
            r6 = 4
            goto L_0x0148
        L_0x0154:
            r6 = 0
        L_0x0155:
            int r10 = r2.length
            if (r6 >= r10) goto L_0x01f0
            r10 = r2[r6]
            java.lang.Object r10 = r1.get(r10)
            androidx.constraintlayout.motion.widget.MotionController r10 = (androidx.constraintlayout.motion.widget.MotionController) r10
            if (r10 != 0) goto L_0x0167
        L_0x0162:
            r1 = r23
            r15 = -1
            goto L_0x01ea
        L_0x0167:
            float r14 = r10.t()
            float r15 = r10.G()
            float r14 = r14 - r15
            float r15 = r10.u()
            float r18 = r10.H()
            float r15 = r15 - r18
            if (r13 != 0) goto L_0x018d
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 <= 0) goto L_0x0189
            boolean r15 = r0.o3
            if (r15 == 0) goto L_0x018b
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x0189
            goto L_0x018b
        L_0x0189:
            r1 = 3
            goto L_0x01bd
        L_0x018b:
            r1 = 3
            goto L_0x01bc
        L_0x018d:
            r1 = 1
            if (r13 != r1) goto L_0x019d
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L_0x0189
            boolean r15 = r0.o3
            if (r15 == 0) goto L_0x018b
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x0189
            goto L_0x018b
        L_0x019d:
            r1 = 2
            if (r13 != r1) goto L_0x01ad
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 >= 0) goto L_0x0189
            boolean r14 = r0.o3
            if (r14 == 0) goto L_0x018b
            int r14 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x0189
            goto L_0x018b
        L_0x01ad:
            r1 = 3
            if (r13 != r1) goto L_0x01bd
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 <= 0) goto L_0x01bd
            boolean r14 = r0.o3
            if (r14 == 0) goto L_0x0162
            int r14 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x01bd
        L_0x01bc:
            goto L_0x0162
        L_0x01bd:
            int r14 = r0.p3
            r15 = -1
            if (r14 != r15) goto L_0x01e5
            r10.a(r3)
            r10.a(r4)
            r10.a(r5)
            r10.a(r7)
            int r14 = r0.m3
            if (r14 <= 0) goto L_0x01d8
            r10.a(r8)
            r10.a(r11)
        L_0x01d8:
            int r14 = r0.n3
            if (r14 <= 0) goto L_0x01e2
            r10.a(r9)
            r10.a(r12)
        L_0x01e2:
            r1 = r23
            goto L_0x01ea
        L_0x01e5:
            r1 = r23
            r1.i0(r14, r10)
        L_0x01ea:
            int r6 = r6 + 1
            r1 = r24
            goto L_0x0155
        L_0x01f0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.MotionEffect.g(androidx.constraintlayout.motion.widget.MotionLayout, java.util.HashMap):void");
    }

    public boolean j() {
        return true;
    }

    public MotionEffect(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        K(context, attributeSet);
    }

    public MotionEffect(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        K(context, attributeSet);
    }
}
