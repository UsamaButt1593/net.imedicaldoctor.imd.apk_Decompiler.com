package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.customview.widget.FocusStrategy;
import androidx.media3.extractor.ts.TsExtractor;
import java.util.ArrayList;
import java.util.List;

public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {

    /* renamed from: n  reason: collision with root package name */
    public static final int f6868n = Integer.MIN_VALUE;
    public static final int o = -1;
    private static final String p = "android.view.View";
    private static final Rect q = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> r = new FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat>() {
        /* renamed from: b */
        public void a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, Rect rect) {
            accessibilityNodeInfoCompat.s(rect);
        }
    };
    private static final FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> s = new FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat>() {
        /* renamed from: c */
        public AccessibilityNodeInfoCompat a(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat, int i2) {
            return sparseArrayCompat.A(i2);
        }

        /* renamed from: d */
        public int b(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat) {
            return sparseArrayCompat.z();
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final Rect f6869d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    private final Rect f6870e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private final Rect f6871f = new Rect();

    /* renamed from: g  reason: collision with root package name */
    private final int[] f6872g = new int[2];

    /* renamed from: h  reason: collision with root package name */
    private final AccessibilityManager f6873h;

    /* renamed from: i  reason: collision with root package name */
    private final View f6874i;

    /* renamed from: j  reason: collision with root package name */
    private MyNodeProvider f6875j;

    /* renamed from: k  reason: collision with root package name */
    int f6876k = Integer.MIN_VALUE;

    /* renamed from: l  reason: collision with root package name */
    int f6877l = Integer.MIN_VALUE;

    /* renamed from: m  reason: collision with root package name */
    private int f6878m = Integer.MIN_VALUE;

    private class MyNodeProvider extends AccessibilityNodeProviderCompat {
        MyNodeProvider() {
        }

        public AccessibilityNodeInfoCompat b(int i2) {
            return AccessibilityNodeInfoCompat.Q0(ExploreByTouchHelper.this.L(i2));
        }

        public AccessibilityNodeInfoCompat d(int i2) {
            int i3 = i2 == 2 ? ExploreByTouchHelper.this.f6876k : ExploreByTouchHelper.this.f6877l;
            if (i3 == Integer.MIN_VALUE) {
                return null;
            }
            return b(i3);
        }

        public boolean f(int i2, int i3, Bundle bundle) {
            return ExploreByTouchHelper.this.T(i2, i3, bundle);
        }
    }

    public ExploreByTouchHelper(@NonNull View view) {
        if (view != null) {
            this.f6874i = view;
            this.f6873h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (ViewCompat.X(view) == 0) {
                ViewCompat.Z1(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    private static Rect E(@NonNull View view, int i2, @NonNull Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i2 == 17) {
            rect.set(width, 0, width, height);
        } else if (i2 == 33) {
            rect.set(0, height, width, height);
        } else if (i2 == 66) {
            rect.set(-1, 0, -1, height);
        } else if (i2 == 130) {
            rect.set(0, -1, width, -1);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean I(android.graphics.Rect r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L_0x0032
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x000a
            goto L_0x0032
        L_0x000a:
            android.view.View r4 = r3.f6874i
            int r4 = r4.getWindowVisibility()
            if (r4 == 0) goto L_0x0013
            return r0
        L_0x0013:
            android.view.View r4 = r3.f6874i
        L_0x0015:
            android.view.ViewParent r4 = r4.getParent()
            boolean r1 = r4 instanceof android.view.View
            if (r1 == 0) goto L_0x002f
            android.view.View r4 = (android.view.View) r4
            float r1 = r4.getAlpha()
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x002e
            int r1 = r4.getVisibility()
            if (r1 == 0) goto L_0x0015
        L_0x002e:
            return r0
        L_0x002f:
            if (r4 == 0) goto L_0x0032
            r0 = 1
        L_0x0032:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ExploreByTouchHelper.I(android.graphics.Rect):boolean");
    }

    private static int J(int i2) {
        if (i2 == 19) {
            return 33;
        }
        if (i2 == 21) {
            return 17;
        }
        if (i2 != 22) {
            return TsExtractor.L;
        }
        return 66;
    }

    private boolean K(int i2, @Nullable Rect rect) {
        Object d2;
        SparseArrayCompat<AccessibilityNodeInfoCompat> y = y();
        int i3 = this.f6877l;
        int i4 = Integer.MIN_VALUE;
        AccessibilityNodeInfoCompat h2 = i3 == Integer.MIN_VALUE ? null : y.h(i3);
        if (i2 == 1 || i2 == 2) {
            d2 = FocusStrategy.d(y, s, r, h2, i2, ViewCompat.c0(this.f6874i) == 1, false);
        } else if (i2 == 17 || i2 == 33 || i2 == 66 || i2 == 130) {
            Rect rect2 = new Rect();
            int i5 = this.f6877l;
            if (i5 != Integer.MIN_VALUE) {
                z(i5, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                E(this.f6874i, i2, rect2);
            }
            d2 = FocusStrategy.c(y, s, r, h2, rect2, i2);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) d2;
        if (accessibilityNodeInfoCompat != null) {
            i4 = y.o(y.m(accessibilityNodeInfoCompat));
        }
        return X(i4);
    }

    private boolean U(int i2, int i3, Bundle bundle) {
        if (i3 == 1) {
            return X(i2);
        }
        if (i3 == 2) {
            return o(i2);
        }
        if (i3 != 64) {
            return i3 != 128 ? N(i2, i3, bundle) : n(i2);
        }
        return W(i2);
    }

    private boolean V(int i2, Bundle bundle) {
        return ViewCompat.p1(this.f6874i, i2, bundle);
    }

    private boolean W(int i2) {
        int i3;
        if (!this.f6873h.isEnabled() || !this.f6873h.isTouchExplorationEnabled() || (i3 = this.f6876k) == i2) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            n(i3);
        }
        this.f6876k = i2;
        this.f6874i.invalidate();
        Y(i2, 32768);
        return true;
    }

    private void Z(int i2) {
        int i3 = this.f6878m;
        if (i3 != i2) {
            this.f6878m = i2;
            Y(i2, 128);
            Y(i3, 256);
        }
    }

    private boolean n(int i2) {
        if (this.f6876k != i2) {
            return false;
        }
        this.f6876k = Integer.MIN_VALUE;
        this.f6874i.invalidate();
        Y(i2, 65536);
        return true;
    }

    private boolean p() {
        int i2 = this.f6877l;
        return i2 != Integer.MIN_VALUE && N(i2, 16, (Bundle) null);
    }

    private AccessibilityEvent q(int i2, int i3) {
        return i2 != -1 ? r(i2, i3) : s(i3);
    }

    private AccessibilityEvent r(int i2, int i3) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i3);
        AccessibilityNodeInfoCompat L = L(i2);
        obtain.getText().add(L.a0());
        obtain.setContentDescription(L.D());
        obtain.setScrollable(L.H0());
        obtain.setPassword(L.F0());
        obtain.setEnabled(L.x0());
        obtain.setChecked(L.r0());
        P(i2, obtain);
        if (!obtain.getText().isEmpty() || obtain.getContentDescription() != null) {
            obtain.setClassName(L.y());
            AccessibilityRecordCompat.Y(obtain, this.f6874i, i2);
            obtain.setPackageName(this.f6874i.getContext().getPackageName());
            return obtain;
        }
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }

    private AccessibilityEvent s(int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        this.f6874i.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    @NonNull
    private AccessibilityNodeInfoCompat t(int i2) {
        AccessibilityNodeInfoCompat N0 = AccessibilityNodeInfoCompat.N0();
        N0.u1(true);
        N0.w1(true);
        N0.j1(p);
        Rect rect = q;
        N0.d1(rect);
        N0.e1(rect);
        N0.P1(this.f6874i);
        R(i2, N0);
        if (N0.a0() == null && N0.D() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        N0.s(this.f6870e);
        if (!this.f6870e.equals(rect)) {
            int p2 = N0.p();
            if ((p2 & 64) != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            } else if ((p2 & 128) == 0) {
                N0.N1(this.f6874i.getContext().getPackageName());
                N0.b2(this.f6874i, i2);
                if (this.f6876k == i2) {
                    N0.a1(true);
                    N0.a(128);
                } else {
                    N0.a1(false);
                    N0.a(64);
                }
                boolean z = this.f6877l == i2;
                if (z) {
                    N0.a(2);
                } else if (N0.y0()) {
                    N0.a(1);
                }
                N0.x1(z);
                this.f6874i.getLocationOnScreen(this.f6872g);
                N0.t(this.f6869d);
                if (this.f6869d.equals(rect)) {
                    N0.s(this.f6869d);
                    if (N0.f6650b != -1) {
                        AccessibilityNodeInfoCompat N02 = AccessibilityNodeInfoCompat.N0();
                        for (int i3 = N0.f6650b; i3 != -1; i3 = N02.f6650b) {
                            N02.Q1(this.f6874i, -1);
                            N02.d1(q);
                            R(i3, N02);
                            N02.s(this.f6870e);
                            Rect rect2 = this.f6869d;
                            Rect rect3 = this.f6870e;
                            rect2.offset(rect3.left, rect3.top);
                        }
                        N02.T0();
                    }
                    this.f6869d.offset(this.f6872g[0] - this.f6874i.getScrollX(), this.f6872g[1] - this.f6874i.getScrollY());
                }
                if (this.f6874i.getLocalVisibleRect(this.f6871f)) {
                    this.f6871f.offset(this.f6872g[0] - this.f6874i.getScrollX(), this.f6872g[1] - this.f6874i.getScrollY());
                    if (this.f6869d.intersect(this.f6871f)) {
                        N0.e1(this.f6869d);
                        if (I(this.f6869d)) {
                            N0.p2(true);
                        }
                    }
                }
                return N0;
            } else {
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
        } else {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
    }

    @NonNull
    private AccessibilityNodeInfoCompat u() {
        AccessibilityNodeInfoCompat O0 = AccessibilityNodeInfoCompat.O0(this.f6874i);
        ViewCompat.m1(this.f6874i, O0);
        ArrayList arrayList = new ArrayList();
        D(arrayList);
        if (O0.x() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                O0.d(this.f6874i, ((Integer) arrayList.get(i2)).intValue());
            }
            return O0;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    private SparseArrayCompat<AccessibilityNodeInfoCompat> y() {
        ArrayList arrayList = new ArrayList();
        D(arrayList);
        SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat = new SparseArrayCompat<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            sparseArrayCompat.p(((Integer) arrayList.get(i2)).intValue(), t(((Integer) arrayList.get(i2)).intValue()));
        }
        return sparseArrayCompat;
    }

    private void z(int i2, Rect rect) {
        L(i2).s(rect);
    }

    @Deprecated
    public int A() {
        return x();
    }

    public final int B() {
        return this.f6877l;
    }

    /* access modifiers changed from: protected */
    public abstract int C(float f2, float f3);

    /* access modifiers changed from: protected */
    public abstract void D(List<Integer> list);

    public final void F() {
        H(-1, 1);
    }

    public final void G(int i2) {
        H(i2, 0);
    }

    public final void H(int i2, int i3) {
        ViewParent parent;
        if (i2 != Integer.MIN_VALUE && this.f6873h.isEnabled() && (parent = this.f6874i.getParent()) != null) {
            AccessibilityEvent q2 = q(i2, 2048);
            AccessibilityEventCompat.k(q2, i3);
            parent.requestSendAccessibilityEvent(this.f6874i, q2);
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public AccessibilityNodeInfoCompat L(int i2) {
        return i2 == -1 ? u() : t(i2);
    }

    public final void M(boolean z, int i2, @Nullable Rect rect) {
        int i3 = this.f6877l;
        if (i3 != Integer.MIN_VALUE) {
            o(i3);
        }
        if (z) {
            K(i2, rect);
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean N(int i2, int i3, @Nullable Bundle bundle);

    /* access modifiers changed from: protected */
    public void O(@NonNull AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public void P(int i2, @NonNull AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public void Q(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    /* access modifiers changed from: protected */
    public abstract void R(int i2, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    /* access modifiers changed from: protected */
    public void S(int i2, boolean z) {
    }

    /* access modifiers changed from: package-private */
    public boolean T(int i2, int i3, Bundle bundle) {
        return i2 != -1 ? U(i2, i3, bundle) : V(i3, bundle);
    }

    public final boolean X(int i2) {
        int i3;
        if ((!this.f6874i.isFocused() && !this.f6874i.requestFocus()) || (i3 = this.f6877l) == i2) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            o(i3);
        }
        if (i2 == Integer.MIN_VALUE) {
            return false;
        }
        this.f6877l = i2;
        S(i2, true);
        Y(i2, 8);
        return true;
    }

    public final boolean Y(int i2, int i3) {
        ViewParent parent;
        if (i2 == Integer.MIN_VALUE || !this.f6873h.isEnabled() || (parent = this.f6874i.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.f6874i, q(i2, i3));
    }

    public AccessibilityNodeProviderCompat b(View view) {
        if (this.f6875j == null) {
            this.f6875j = new MyNodeProvider();
        }
        return this.f6875j;
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        O(accessibilityEvent);
    }

    public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.g(view, accessibilityNodeInfoCompat);
        Q(accessibilityNodeInfoCompat);
    }

    public final boolean o(int i2) {
        if (this.f6877l != i2) {
            return false;
        }
        this.f6877l = Integer.MIN_VALUE;
        S(i2, false);
        Y(i2, 8);
        return true;
    }

    public final boolean v(@NonNull MotionEvent motionEvent) {
        if (!this.f6873h.isEnabled() || !this.f6873h.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int C = C(motionEvent.getX(), motionEvent.getY());
            Z(C);
            return C != Integer.MIN_VALUE;
        } else if (action != 10 || this.f6878m == Integer.MIN_VALUE) {
            return false;
        } else {
            Z(Integer.MIN_VALUE);
            return true;
        }
    }

    public final boolean w(@NonNull KeyEvent keyEvent) {
        int i2 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 61) {
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (!keyEvent.hasNoModifiers()) {
                            return false;
                        }
                        int J = J(keyCode);
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        boolean z = false;
                        while (i2 < repeatCount && K(J, (Rect) null)) {
                            i2++;
                            z = true;
                        }
                        return z;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            p();
            return true;
        } else if (keyEvent.hasNoModifiers()) {
            return K(2, (Rect) null);
        } else {
            if (keyEvent.hasModifiers(1)) {
                return K(1, (Rect) null);
            }
            return false;
        }
    }

    public final int x() {
        return this.f6876k;
    }
}
