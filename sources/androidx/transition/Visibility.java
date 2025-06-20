package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.Transition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class Visibility extends Transition {
    static final String W3 = "android:visibility:visibility";
    private static final String X3 = "android:visibility:parent";
    private static final String Y3 = "android:visibility:screenLocation";
    public static final int Z3 = 1;
    public static final int a4 = 2;
    private static final String[] b4 = {W3, X3};
    private int V3 = 3;

    private static class DisappearListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private final int X;
        private boolean X2;
        private final ViewGroup Y;
        boolean Y2 = false;
        private final boolean Z;
        private final View s;

        DisappearListener(View view, int i2, boolean z) {
            this.s = view;
            this.X = i2;
            this.Y = (ViewGroup) view.getParent();
            this.Z = z;
            c(true);
        }

        private void a() {
            if (!this.Y2) {
                ViewUtils.g(this.s, this.X);
                ViewGroup viewGroup = this.Y;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            c(false);
        }

        private void c(boolean z) {
            ViewGroup viewGroup;
            if (this.Z && this.X2 != z && (viewGroup = this.Y) != null) {
                this.X2 = z;
                ViewGroupUtils.c(viewGroup, z);
            }
        }

        public void b(@NonNull Transition transition) {
        }

        public void f(@NonNull Transition transition) {
            c(false);
            if (!this.Y2) {
                ViewUtils.g(this.s, this.X);
            }
        }

        public /* synthetic */ void h(Transition transition, boolean z) {
            e.a(this, transition, z);
        }

        public void k(@NonNull Transition transition) {
            transition.S0(this);
        }

        public void onAnimationCancel(Animator animator) {
            this.Y2 = true;
        }

        public void onAnimationEnd(Animator animator) {
            a();
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        public void p(@NonNull Transition transition) {
        }

        public /* synthetic */ void q(Transition transition, boolean z) {
            e.b(this, transition, z);
        }

        public void s(@NonNull Transition transition) {
            c(true);
            if (!this.Y2) {
                ViewUtils.g(this.s, 0);
            }
        }

        public void onAnimationEnd(@NonNull Animator animator, boolean z) {
            if (!z) {
                a();
            }
        }

        public void onAnimationStart(@NonNull Animator animator, boolean z) {
            if (z) {
                ViewUtils.g(this.s, 0);
                ViewGroup viewGroup = this.Y;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
        }
    }

    @SuppressLint({"UniqueConstants"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    private class OverlayListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private final View X;
        private final View Y;
        private boolean Z = true;
        private final ViewGroup s;

        OverlayListener(ViewGroup viewGroup, View view, View view2) {
            this.s = viewGroup;
            this.X = view;
            this.Y = view2;
        }

        private void a() {
            this.Y.setTag(R.id.f16016e, (Object) null);
            this.s.getOverlay().remove(this.X);
            this.Z = false;
        }

        public void b(@NonNull Transition transition) {
        }

        public void f(@NonNull Transition transition) {
        }

        public /* synthetic */ void h(Transition transition, boolean z) {
            e.a(this, transition, z);
        }

        public void k(@NonNull Transition transition) {
            transition.S0(this);
        }

        public void onAnimationEnd(Animator animator) {
            a();
        }

        public void onAnimationPause(Animator animator) {
            this.s.getOverlay().remove(this.X);
        }

        public void onAnimationResume(Animator animator) {
            if (this.X.getParent() == null) {
                this.s.getOverlay().add(this.X);
            } else {
                Visibility.this.cancel();
            }
        }

        public void onAnimationStart(@NonNull Animator animator, boolean z) {
            if (z) {
                this.Y.setTag(R.id.f16016e, this.X);
                this.s.getOverlay().add(this.X);
                this.Z = true;
            }
        }

        public void p(@NonNull Transition transition) {
            if (this.Z) {
                a();
            }
        }

        public /* synthetic */ void q(Transition transition, boolean z) {
            e.b(this, transition, z);
        }

        public void s(@NonNull Transition transition) {
        }

        public void onAnimationEnd(@NonNull Animator animator, boolean z) {
            if (!z) {
                a();
            }
        }
    }

    private static class VisibilityInfo {

        /* renamed from: a  reason: collision with root package name */
        boolean f16127a;

        /* renamed from: b  reason: collision with root package name */
        boolean f16128b;

        /* renamed from: c  reason: collision with root package name */
        int f16129c;

        /* renamed from: d  reason: collision with root package name */
        int f16130d;

        /* renamed from: e  reason: collision with root package name */
        ViewGroup f16131e;

        /* renamed from: f  reason: collision with root package name */
        ViewGroup f16132f;

        VisibilityInfo() {
        }
    }

    public Visibility() {
    }

    private void C1(TransitionValues transitionValues) {
        transitionValues.f16094a.put(W3, Integer.valueOf(transitionValues.f16095b.getVisibility()));
        transitionValues.f16094a.put(X3, transitionValues.f16095b.getParent());
        int[] iArr = new int[2];
        transitionValues.f16095b.getLocationOnScreen(iArr);
        transitionValues.f16094a.put(Y3, iArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0078, code lost:
        if (r9 == 0) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0084, code lost:
        if (r0.f16131e == null) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0092, code lost:
        if (r0.f16129c == 0) goto L_0x0073;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.transition.Visibility.VisibilityInfo F1(androidx.transition.TransitionValues r8, androidx.transition.TransitionValues r9) {
        /*
            r7 = this;
            androidx.transition.Visibility$VisibilityInfo r0 = new androidx.transition.Visibility$VisibilityInfo
            r0.<init>()
            r1 = 0
            r0.f16127a = r1
            r0.f16128b = r1
            r2 = 0
            r3 = -1
            java.lang.String r4 = "android:visibility:parent"
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L_0x0033
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f16094a
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L_0x0033
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f16094a
            java.lang.Object r6 = r6.get(r5)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r0.f16129c = r6
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f16094a
            java.lang.Object r6 = r6.get(r4)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.f16131e = r6
            goto L_0x0037
        L_0x0033:
            r0.f16129c = r3
            r0.f16131e = r2
        L_0x0037:
            if (r9 == 0) goto L_0x005a
            java.util.Map<java.lang.String, java.lang.Object> r6 = r9.f16094a
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L_0x005a
            java.util.Map<java.lang.String, java.lang.Object> r2 = r9.f16094a
            java.lang.Object r2 = r2.get(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r0.f16130d = r2
            java.util.Map<java.lang.String, java.lang.Object> r2 = r9.f16094a
            java.lang.Object r2 = r2.get(r4)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
        L_0x0057:
            r0.f16132f = r2
            goto L_0x005d
        L_0x005a:
            r0.f16130d = r3
            goto L_0x0057
        L_0x005d:
            r2 = 1
            if (r8 == 0) goto L_0x0087
            if (r9 == 0) goto L_0x0087
            int r8 = r0.f16129c
            int r9 = r0.f16130d
            if (r8 != r9) goto L_0x006f
            android.view.ViewGroup r3 = r0.f16131e
            android.view.ViewGroup r4 = r0.f16132f
            if (r3 != r4) goto L_0x006f
            return r0
        L_0x006f:
            if (r8 == r9) goto L_0x007d
            if (r8 != 0) goto L_0x0078
        L_0x0073:
            r0.f16128b = r1
        L_0x0075:
            r0.f16127a = r2
            goto L_0x0095
        L_0x0078:
            if (r9 != 0) goto L_0x0095
        L_0x007a:
            r0.f16128b = r2
            goto L_0x0075
        L_0x007d:
            android.view.ViewGroup r8 = r0.f16132f
            if (r8 != 0) goto L_0x0082
            goto L_0x0073
        L_0x0082:
            android.view.ViewGroup r8 = r0.f16131e
            if (r8 != 0) goto L_0x0095
            goto L_0x007a
        L_0x0087:
            if (r8 != 0) goto L_0x008e
            int r8 = r0.f16130d
            if (r8 != 0) goto L_0x008e
            goto L_0x007a
        L_0x008e:
            if (r9 != 0) goto L_0x0095
            int r8 = r0.f16129c
            if (r8 != 0) goto L_0x0095
            goto L_0x0073
        L_0x0095:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.F1(androidx.transition.TransitionValues, androidx.transition.TransitionValues):androidx.transition.Visibility$VisibilityInfo");
    }

    public int D1() {
        return this.V3;
    }

    public boolean H1(@Nullable TransitionValues transitionValues) {
        if (transitionValues == null) {
            return false;
        }
        return ((Integer) transitionValues.f16094a.get(W3)).intValue() == 0 && ((View) transitionValues.f16094a.get(X3)) != null;
    }

    @Nullable
    public Animator O1(@NonNull ViewGroup viewGroup, @NonNull View view, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        return null;
    }

    @Nullable
    public Animator R1(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, int i2, @Nullable TransitionValues transitionValues2, int i3) {
        if ((this.V3 & 1) != 1 || transitionValues2 == null) {
            return null;
        }
        if (transitionValues == null) {
            View view = (View) transitionValues2.f16095b.getParent();
            if (F1(X(view, false), s0(view, false)).f16127a) {
                return null;
            }
        }
        return O1(viewGroup, transitionValues2.f16095b, transitionValues, transitionValues2);
    }

    @Nullable
    public Animator S1(@NonNull ViewGroup viewGroup, @NonNull View view, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008f, code lost:
        if (r0.p3 != false) goto L_0x0091;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004a  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator T1(@androidx.annotation.NonNull android.view.ViewGroup r18, @androidx.annotation.Nullable androidx.transition.TransitionValues r19, int r20, @androidx.annotation.Nullable androidx.transition.TransitionValues r21, int r22) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r21
            r4 = r22
            int r5 = r0.V3
            r6 = 2
            r5 = r5 & r6
            r7 = 0
            if (r5 == r6) goto L_0x0012
            return r7
        L_0x0012:
            if (r2 != 0) goto L_0x0015
            return r7
        L_0x0015:
            android.view.View r5 = r2.f16095b
            if (r3 == 0) goto L_0x001c
            android.view.View r8 = r3.f16095b
            goto L_0x001d
        L_0x001c:
            r8 = r7
        L_0x001d:
            int r9 = androidx.transition.R.id.f16016e
            java.lang.Object r10 = r5.getTag(r9)
            android.view.View r10 = (android.view.View) r10
            r11 = 0
            r12 = 1
            if (r10 == 0) goto L_0x002d
            r8 = r7
            r13 = 1
            goto L_0x0094
        L_0x002d:
            if (r8 == 0) goto L_0x0044
            android.view.ViewParent r10 = r8.getParent()
            if (r10 != 0) goto L_0x0036
            goto L_0x0044
        L_0x0036:
            r10 = 4
            if (r4 != r10) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            if (r5 != r8) goto L_0x0040
        L_0x003c:
            r10 = r8
            r13 = 0
            r8 = r7
            goto L_0x0048
        L_0x0040:
            r8 = r7
            r10 = r8
            r13 = 1
            goto L_0x0048
        L_0x0044:
            if (r8 == 0) goto L_0x0040
            r10 = r7
            r13 = 0
        L_0x0048:
            if (r13 == 0) goto L_0x0073
            android.view.ViewParent r13 = r5.getParent()
            if (r13 != 0) goto L_0x0051
            goto L_0x0091
        L_0x0051:
            android.view.ViewParent r13 = r5.getParent()
            boolean r13 = r13 instanceof android.view.View
            if (r13 == 0) goto L_0x0073
            android.view.ViewParent r13 = r5.getParent()
            android.view.View r13 = (android.view.View) r13
            androidx.transition.TransitionValues r14 = r0.s0(r13, r12)
            androidx.transition.TransitionValues r15 = r0.X(r13, r12)
            androidx.transition.Visibility$VisibilityInfo r14 = r0.F1(r14, r15)
            boolean r14 = r14.f16127a
            if (r14 != 0) goto L_0x007a
            android.view.View r8 = androidx.transition.TransitionUtils.a(r1, r5, r13)
        L_0x0073:
            r13 = 0
            r16 = r10
            r10 = r8
            r8 = r16
            goto L_0x0094
        L_0x007a:
            int r14 = r13.getId()
            android.view.ViewParent r13 = r13.getParent()
            if (r13 != 0) goto L_0x0073
            r13 = -1
            if (r14 == r13) goto L_0x0073
            android.view.View r13 = r1.findViewById(r14)
            if (r13 == 0) goto L_0x0073
            boolean r13 = r0.p3
            if (r13 == 0) goto L_0x0073
        L_0x0091:
            r8 = r10
            r13 = 0
            r10 = r5
        L_0x0094:
            if (r10 == 0) goto L_0x00ee
            if (r13 != 0) goto L_0x00c8
            java.util.Map<java.lang.String, java.lang.Object> r4 = r2.f16094a
            java.lang.String r7 = "android:visibility:screenLocation"
            java.lang.Object r4 = r4.get(r7)
            int[] r4 = (int[]) r4
            r7 = r4[r11]
            r4 = r4[r12]
            int[] r6 = new int[r6]
            r1.getLocationOnScreen(r6)
            r8 = r6[r11]
            int r7 = r7 - r8
            int r8 = r10.getLeft()
            int r7 = r7 - r8
            r10.offsetLeftAndRight(r7)
            r6 = r6[r12]
            int r4 = r4 - r6
            int r6 = r10.getTop()
            int r4 = r4 - r6
            r10.offsetTopAndBottom(r4)
            android.view.ViewGroupOverlay r4 = r18.getOverlay()
            r4.add(r10)
        L_0x00c8:
            android.animation.Animator r2 = r0.S1(r1, r10, r2, r3)
            if (r13 != 0) goto L_0x00ed
            if (r2 != 0) goto L_0x00d8
            android.view.ViewGroupOverlay r1 = r18.getOverlay()
            r1.remove(r10)
            goto L_0x00ed
        L_0x00d8:
            r5.setTag(r9, r10)
            androidx.transition.Visibility$OverlayListener r3 = new androidx.transition.Visibility$OverlayListener
            r3.<init>(r1, r10, r5)
            r2.addListener(r3)
            r2.addPauseListener(r3)
            androidx.transition.Transition r1 = r17.f0()
            r1.c(r3)
        L_0x00ed:
            return r2
        L_0x00ee:
            if (r8 == 0) goto L_0x0111
            int r5 = r8.getVisibility()
            androidx.transition.ViewUtils.g(r8, r11)
            android.animation.Animator r1 = r0.S1(r1, r8, r2, r3)
            if (r1 == 0) goto L_0x010d
            androidx.transition.Visibility$DisappearListener r2 = new androidx.transition.Visibility$DisappearListener
            r2.<init>(r8, r4, r12)
            r1.addListener(r2)
            androidx.transition.Transition r3 = r17.f0()
            r3.c(r2)
            goto L_0x0110
        L_0x010d:
            androidx.transition.ViewUtils.g(r8, r5)
        L_0x0110:
            return r1
        L_0x0111:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.T1(android.view.ViewGroup, androidx.transition.TransitionValues, int, androidx.transition.TransitionValues, int):android.animation.Animator");
    }

    public void U1(int i2) {
        if ((i2 & -4) == 0) {
            this.V3 = i2;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    public void n(@NonNull TransitionValues transitionValues) {
        C1(transitionValues);
    }

    public void q(@NonNull TransitionValues transitionValues) {
        C1(transitionValues);
    }

    @Nullable
    public String[] r0() {
        return b4;
    }

    @Nullable
    public Animator u(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        VisibilityInfo F1 = F1(transitionValues, transitionValues2);
        if (!F1.f16127a) {
            return null;
        }
        if (F1.f16131e == null && F1.f16132f == null) {
            return null;
        }
        if (F1.f16128b) {
            return R1(viewGroup, transitionValues, F1.f16129c, transitionValues2, F1.f16130d);
        }
        return T1(viewGroup, transitionValues, F1.f16129c, transitionValues2, F1.f16130d);
    }

    public boolean v0(@Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        if (transitionValues == null && transitionValues2 == null) {
            return false;
        }
        if (transitionValues != null && transitionValues2 != null && transitionValues2.f16094a.containsKey(W3) != transitionValues.f16094a.containsKey(W3)) {
            return false;
        }
        VisibilityInfo F1 = F1(transitionValues, transitionValues2);
        if (F1.f16127a) {
            return F1.f16129c == 0 || F1.f16130d == 0;
        }
        return false;
    }

    public Visibility(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f16038e);
        int k2 = TypedArrayUtils.k(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        obtainStyledAttributes.recycle();
        if (k2 != 0) {
            U1(k2);
        }
    }
}
