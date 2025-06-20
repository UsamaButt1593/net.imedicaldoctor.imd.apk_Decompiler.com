package androidx.drawerlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.Openable;
import androidx.customview.widget.ViewDragHelper;
import androidx.drawerlayout.R;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup implements Openable {
    private static final String H3 = "DrawerLayout";
    private static final int[] I3 = {16843828};
    public static final int J3 = 0;
    public static final int K3 = 1;
    public static final int L3 = 2;
    public static final int M3 = 0;
    public static final int N3 = 1;
    public static final int O3 = 2;
    public static final int P3 = 3;
    private static final int Q3 = 64;
    private static final int R3 = -1728053248;
    private static final int S3 = 160;
    private static final int T3 = 400;
    private static final boolean U3 = false;
    private static final boolean V3 = true;
    private static final float W3 = 1.0f;
    static final int[] X3 = {16842931};
    static final boolean Y3 = true;
    private static final boolean Z3 = true;
    private static final String a4 = "androidx.drawerlayout.widget.DrawerLayout";
    private static boolean b4;
    private Drawable A3;
    private Drawable B3;
    private Drawable C3;
    private final ArrayList<View> D3;
    private Rect E3;
    private Matrix F3;
    private final AccessibilityViewCommand G3;
    private float X2;
    private int Y2;
    private int Z2;
    private float a3;
    private Paint b3;
    private final ViewDragHelper c3;
    private final ViewDragHelper d3;
    private final ViewDragCallback e3;
    private final ViewDragCallback f3;
    private int g3;
    private boolean h3;
    private boolean i3;
    private int j3;
    private int k3;
    private int l3;
    private int m3;
    private boolean n3;
    @Nullable
    private DrawerListener o3;
    private List<DrawerListener> p3;
    private float q3;
    private float r3;
    private final ChildAccessibilityDelegate s;
    private Drawable s3;
    private Drawable t3;
    private Drawable u3;
    private CharSequence v3;
    private CharSequence w3;
    private Object x3;
    private boolean y3;
    private Drawable z3;

    class AccessibilityDelegate extends AccessibilityDelegateCompat {

        /* renamed from: d  reason: collision with root package name */
        private final Rect f7415d = new Rect();

        AccessibilityDelegate() {
        }

        private void n(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (DrawerLayout.A(childAt)) {
                    accessibilityNodeInfoCompat.c(childAt);
                }
            }
        }

        private void o(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.f7415d;
            accessibilityNodeInfoCompat2.t(rect);
            accessibilityNodeInfoCompat.e1(rect);
            accessibilityNodeInfoCompat.p2(accessibilityNodeInfoCompat2.M0());
            accessibilityNodeInfoCompat.N1(accessibilityNodeInfoCompat2.S());
            accessibilityNodeInfoCompat.j1(accessibilityNodeInfoCompat2.y());
            accessibilityNodeInfoCompat.o1(accessibilityNodeInfoCompat2.D());
            accessibilityNodeInfoCompat.u1(accessibilityNodeInfoCompat2.x0());
            accessibilityNodeInfoCompat.x1(accessibilityNodeInfoCompat2.z0());
            accessibilityNodeInfoCompat.a1(accessibilityNodeInfoCompat2.p0());
            accessibilityNodeInfoCompat.Y1(accessibilityNodeInfoCompat2.I0());
            accessibilityNodeInfoCompat.a(accessibilityNodeInfoCompat2.p());
        }

        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            CharSequence s;
            if (accessibilityEvent.getEventType() != 32) {
                return super.a(view, accessibilityEvent);
            }
            List<CharSequence> text = accessibilityEvent.getText();
            View p = DrawerLayout.this.p();
            if (p == null || (s = DrawerLayout.this.s(DrawerLayout.this.t(p))) == null) {
                return true;
            }
            text.add(s);
            return true;
        }

        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.a4);
        }

        public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (DrawerLayout.Y3) {
                super.g(view, accessibilityNodeInfoCompat);
            } else {
                AccessibilityNodeInfoCompat Q0 = AccessibilityNodeInfoCompat.Q0(accessibilityNodeInfoCompat);
                super.g(view, Q0);
                accessibilityNodeInfoCompat.a2(view);
                ViewParent o0 = ViewCompat.o0(view);
                if (o0 instanceof View) {
                    accessibilityNodeInfoCompat.P1((View) o0);
                }
                o(accessibilityNodeInfoCompat, Q0);
                Q0.T0();
                n(accessibilityNodeInfoCompat, (ViewGroup) view);
            }
            accessibilityNodeInfoCompat.j1(DrawerLayout.a4);
            accessibilityNodeInfoCompat.w1(false);
            accessibilityNodeInfoCompat.x1(false);
            accessibilityNodeInfoCompat.V0(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6653f);
            accessibilityNodeInfoCompat.V0(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6654g);
        }

        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.Y3 || DrawerLayout.A(view)) {
                return super.i(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    static final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
        ChildAccessibilityDelegate() {
        }

        public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.g(view, accessibilityNodeInfoCompat);
            if (!DrawerLayout.A(view)) {
                accessibilityNodeInfoCompat.P1((View) null);
            }
        }
    }

    public interface DrawerListener {
        void a(@NonNull View view);

        void b(@NonNull View view);

        void c(int i2);

        void d(@NonNull View view, float f2);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: e  reason: collision with root package name */
        private static final int f7417e = 1;

        /* renamed from: f  reason: collision with root package name */
        private static final int f7418f = 2;

        /* renamed from: g  reason: collision with root package name */
        private static final int f7419g = 4;

        /* renamed from: a  reason: collision with root package name */
        public int f7420a;

        /* renamed from: b  reason: collision with root package name */
        float f7421b;

        /* renamed from: c  reason: collision with root package name */
        boolean f7422c;

        /* renamed from: d  reason: collision with root package name */
        int f7423d;

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.f7420a = 0;
        }

        public LayoutParams(int i2, int i3, int i4) {
            this(i2, i3);
            this.f7420a = i4;
        }

        public LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f7420a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.X3);
            this.f7420a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f7420a = 0;
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f7420a = 0;
        }

        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super(layoutParams);
            this.f7420a = 0;
            this.f7420a = layoutParams.f7420a;
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        int X2;
        int Y = 0;
        int Y2;
        int Z;
        int Z2;

        public SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.Y = parcel.readInt();
            this.Z = parcel.readInt();
            this.X2 = parcel.readInt();
            this.Y2 = parcel.readInt();
            this.Z2 = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.Y);
            parcel.writeInt(this.Z);
            parcel.writeInt(this.X2);
            parcel.writeInt(this.Y2);
            parcel.writeInt(this.Z2);
        }

        public SavedState(@NonNull Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static abstract class SimpleDrawerListener implements DrawerListener {
        public void a(View view) {
        }

        public void b(View view) {
        }

        public void c(int i2) {
        }

        public void d(View view, float f2) {
        }
    }

    private class ViewDragCallback extends ViewDragHelper.Callback {

        /* renamed from: a  reason: collision with root package name */
        private final int f7424a;

        /* renamed from: b  reason: collision with root package name */
        private ViewDragHelper f7425b;

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f7426c = new Runnable() {
            public void run() {
                ViewDragCallback.this.o();
            }
        };

        ViewDragCallback(int i2) {
            this.f7424a = i2;
        }

        private void n() {
            int i2 = 3;
            if (this.f7424a == 3) {
                i2 = 5;
            }
            View n2 = DrawerLayout.this.n(i2);
            if (n2 != null) {
                DrawerLayout.this.f(n2);
            }
        }

        public int a(View view, int i2, int i3) {
            int width;
            int width2;
            if (DrawerLayout.this.c(view, 3)) {
                width2 = -view.getWidth();
                width = 0;
            } else {
                width = DrawerLayout.this.getWidth();
                width2 = width - view.getWidth();
            }
            return Math.max(width2, Math.min(i2, width));
        }

        public int b(View view, int i2, int i3) {
            return view.getTop();
        }

        public int d(View view) {
            if (DrawerLayout.this.E(view)) {
                return view.getWidth();
            }
            return 0;
        }

        public void f(int i2, int i3) {
            DrawerLayout drawerLayout;
            int i4;
            if ((i2 & 1) == 1) {
                drawerLayout = DrawerLayout.this;
                i4 = 3;
            } else {
                drawerLayout = DrawerLayout.this;
                i4 = 5;
            }
            View n2 = drawerLayout.n(i4);
            if (n2 != null && DrawerLayout.this.r(n2) == 0) {
                this.f7425b.d(n2, i3);
            }
        }

        public boolean g(int i2) {
            return false;
        }

        public void h(int i2, int i3) {
            DrawerLayout.this.postDelayed(this.f7426c, 160);
        }

        public void i(View view, int i2) {
            ((LayoutParams) view.getLayoutParams()).f7422c = false;
            n();
        }

        public void j(int i2) {
            DrawerLayout.this.b0(i2, this.f7425b.z());
        }

        public void k(View view, int i2, int i3, int i4, int i5) {
            int width = view.getWidth();
            float width2 = (DrawerLayout.this.c(view, 3) ? (float) (i2 + width) : (float) (DrawerLayout.this.getWidth() - i2)) / ((float) width);
            DrawerLayout.this.Y(view, width2);
            view.setVisibility(width2 == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        public void l(View view, float f2, float f3) {
            int i2;
            float u = DrawerLayout.this.u(view);
            int width = view.getWidth();
            if (DrawerLayout.this.c(view, 3)) {
                int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                i2 = (i3 > 0 || (i3 == 0 && u > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f2 < 0.0f || (f2 == 0.0f && u > 0.5f)) {
                    width2 -= width;
                }
                i2 = width2;
            }
            this.f7425b.V(i2, view.getTop());
            DrawerLayout.this.invalidate();
        }

        public boolean m(View view, int i2) {
            return DrawerLayout.this.E(view) && DrawerLayout.this.c(view, this.f7424a) && DrawerLayout.this.r(view) == 0;
        }

        /* access modifiers changed from: package-private */
        public void o() {
            View view;
            int i2;
            int B = this.f7425b.B();
            int i3 = 0;
            boolean z = this.f7424a == 3;
            if (z) {
                view = DrawerLayout.this.n(3);
                if (view != null) {
                    i3 = -view.getWidth();
                }
                i2 = i3 + B;
            } else {
                view = DrawerLayout.this.n(5);
                i2 = DrawerLayout.this.getWidth() - B;
            }
            if (view == null) {
                return;
            }
            if (((z && view.getLeft() < i2) || (!z && view.getLeft() > i2)) && DrawerLayout.this.r(view) == 0) {
                this.f7425b.X(view, i2, view.getTop());
                ((LayoutParams) view.getLayoutParams()).f7422c = true;
                DrawerLayout.this.invalidate();
                n();
                DrawerLayout.this.b();
            }
        }

        public void p() {
            DrawerLayout.this.removeCallbacks(this.f7426c);
        }

        public void q(ViewDragHelper viewDragHelper) {
            this.f7425b = viewDragHelper;
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        boolean z = true;
        if (i2 < 29) {
            z = false;
        }
        b4 = z;
    }

    public DrawerLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    static boolean A(View view) {
        return (ViewCompat.X(view) == 4 || ViewCompat.X(view) == 2) ? false : true;
    }

    private boolean H(float f2, float f4, View view) {
        if (this.E3 == null) {
            this.E3 = new Rect();
        }
        view.getHitRect(this.E3);
        return this.E3.contains((int) f2, (int) f4);
    }

    private void I(Drawable drawable, int i2) {
        if (drawable != null && DrawableCompat.h(drawable)) {
            DrawableCompat.m(drawable, i2);
        }
    }

    private Drawable P() {
        int c0 = ViewCompat.c0(this);
        if (c0 == 0) {
            Drawable drawable = this.z3;
            if (drawable != null) {
                I(drawable, c0);
                return this.z3;
            }
        } else {
            Drawable drawable2 = this.A3;
            if (drawable2 != null) {
                I(drawable2, c0);
                return this.A3;
            }
        }
        return this.B3;
    }

    private Drawable Q() {
        int c0 = ViewCompat.c0(this);
        if (c0 == 0) {
            Drawable drawable = this.A3;
            if (drawable != null) {
                I(drawable, c0);
                return this.A3;
            }
        } else {
            Drawable drawable2 = this.z3;
            if (drawable2 != null) {
                I(drawable2, c0);
                return this.z3;
            }
        }
        return this.C3;
    }

    private void R() {
        if (!Z3) {
            this.t3 = P();
            this.u3 = Q();
        }
    }

    private void Z(View view) {
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.z;
        ViewCompat.x1(view, accessibilityActionCompat.b());
        if (D(view) && r(view) != 2) {
            ViewCompat.A1(view, accessibilityActionCompat, (CharSequence) null, this.G3);
        }
    }

    private void a0(View view, boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            ViewCompat.Z1(childAt, ((z || E(childAt)) && (!z || childAt != view)) ? 4 : 1);
        }
    }

    private boolean m(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent v = v(motionEvent, view);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(v);
            v.recycle();
            return dispatchGenericMotionEvent;
        }
        float scrollX = (float) (getScrollX() - view.getLeft());
        float scrollY = (float) (getScrollY() - view.getTop());
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return dispatchGenericMotionEvent2;
    }

    private MotionEvent v(MotionEvent motionEvent, View view) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation((float) (getScrollX() - view.getLeft()), (float) (getScrollY() - view.getTop()));
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.F3 == null) {
                this.F3 = new Matrix();
            }
            matrix.invert(this.F3);
            obtain.transform(this.F3);
        }
        return obtain;
    }

    static String w(int i2) {
        if ((i2 & 3) == 3) {
            return "LEFT";
        }
        return (i2 & 5) == 5 ? "RIGHT" : Integer.toHexString(i2);
    }

    private static boolean x(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    private boolean y() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (((LayoutParams) getChildAt(i2).getLayoutParams()).f7422c) {
                return true;
            }
        }
        return false;
    }

    private boolean z() {
        return p() != null;
    }

    /* access modifiers changed from: package-private */
    public boolean B(View view) {
        return ((LayoutParams) view.getLayoutParams()).f7420a == 0;
    }

    public boolean C(int i2) {
        View n2 = n(i2);
        if (n2 != null) {
            return D(n2);
        }
        return false;
    }

    public boolean D(@NonNull View view) {
        if (E(view)) {
            return (((LayoutParams) view.getLayoutParams()).f7423d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* access modifiers changed from: package-private */
    public boolean E(View view) {
        int d2 = GravityCompat.d(((LayoutParams) view.getLayoutParams()).f7420a, ViewCompat.c0(view));
        return ((d2 & 3) == 0 && (d2 & 5) == 0) ? false : true;
    }

    public boolean F(int i2) {
        View n2 = n(i2);
        if (n2 != null) {
            return G(n2);
        }
        return false;
    }

    public boolean G(@NonNull View view) {
        if (E(view)) {
            return ((LayoutParams) view.getLayoutParams()).f7421b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* access modifiers changed from: package-private */
    public void J(View view, float f2) {
        float u = u(view);
        float width = (float) view.getWidth();
        int i2 = ((int) (width * f2)) - ((int) (u * width));
        if (!c(view, 3)) {
            i2 = -i2;
        }
        view.offsetLeftAndRight(i2);
        Y(view, f2);
    }

    public void K(int i2) {
        L(i2, true);
    }

    public void L(int i2, boolean z) {
        View n2 = n(i2);
        if (n2 != null) {
            N(n2, z);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + w(i2));
    }

    public void M(@NonNull View view) {
        N(view, true);
    }

    public void N(@NonNull View view, boolean z) {
        if (E(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.i3) {
                layoutParams.f7421b = 1.0f;
                layoutParams.f7423d = 1;
                a0(view, true);
                Z(view);
            } else if (z) {
                layoutParams.f7423d |= 2;
                if (c(view, 3)) {
                    this.c3.X(view, 0, view.getTop());
                } else {
                    this.d3.X(view, getWidth() - view.getWidth(), view.getTop());
                }
            } else {
                J(view, 1.0f);
                b0(0, view);
                view.setVisibility(0);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void O(@NonNull DrawerListener drawerListener) {
        List<DrawerListener> list;
        if (drawerListener != null && (list = this.p3) != null) {
            list.remove(drawerListener);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void S(Object obj, boolean z) {
        this.x3 = obj;
        this.y3 = z;
        setWillNotDraw(!z && getBackground() == null);
        requestLayout();
    }

    public void T(int i2, int i4) {
        View n2;
        int d2 = GravityCompat.d(i4, ViewCompat.c0(this));
        if (i4 == 3) {
            this.j3 = i2;
        } else if (i4 == 5) {
            this.k3 = i2;
        } else if (i4 == 8388611) {
            this.l3 = i2;
        } else if (i4 == 8388613) {
            this.m3 = i2;
        }
        if (i2 != 0) {
            (d2 == 3 ? this.c3 : this.d3).c();
        }
        if (i2 == 1) {
            View n4 = n(d2);
            if (n4 != null) {
                f(n4);
            }
        } else if (i2 == 2 && (n2 = n(d2)) != null) {
            M(n2);
        }
    }

    public void U(int i2, @NonNull View view) {
        if (E(view)) {
            T(i2, ((LayoutParams) view.getLayoutParams()).f7420a);
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer with appropriate layout_gravity");
    }

    public void V(@DrawableRes int i2, int i4) {
        W(ContextCompat.l(getContext(), i2), i4);
    }

    public void W(Drawable drawable, int i2) {
        if (!Z3) {
            if ((i2 & GravityCompat.f6387b) == 8388611) {
                this.z3 = drawable;
            } else if ((i2 & GravityCompat.f6388c) == 8388613) {
                this.A3 = drawable;
            } else if ((i2 & 3) == 3) {
                this.B3 = drawable;
            } else if ((i2 & 5) == 5) {
                this.C3 = drawable;
            } else {
                return;
            }
            R();
            invalidate();
        }
    }

    public void X(int i2, @Nullable CharSequence charSequence) {
        int d2 = GravityCompat.d(i2, ViewCompat.c0(this));
        if (d2 == 3) {
            this.v3 = charSequence;
        } else if (d2 == 5) {
            this.w3 = charSequence;
        }
    }

    /* access modifiers changed from: package-private */
    public void Y(View view, float f2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f2 != layoutParams.f7421b) {
            layoutParams.f7421b = f2;
            l(view, f2);
        }
    }

    public void setDrawerListener(@NonNull DrawerListener drawerListener) {
        if (drawerListener != null) {
            if (this.p3 == null) {
                this.p3 = new ArrayList();
            }
            this.p3.add(drawerListener);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i4) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            boolean z = false;
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (!E(childAt)) {
                    this.D3.add(childAt);
                } else if (D(childAt)) {
                    childAt.addFocusables(arrayList, i2, i4);
                    z = true;
                }
            }
            if (!z) {
                int size = this.D3.size();
                for (int i6 = 0; i6 < size; i6++) {
                    View view = this.D3.get(i6);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i2, i4);
                    }
                }
            }
            this.D3.clear();
        }
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        ViewCompat.Z1(view, (o() != null || E(view)) ? 4 : 1);
        if (!Y3) {
            ViewCompat.H1(view, this.s);
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (!this.n3) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                getChildAt(i2).dispatchTouchEvent(obtain);
            }
            obtain.recycle();
            this.n3 = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void b0(int i2, View view) {
        int i4;
        int F = this.c3.F();
        int F2 = this.d3.F();
        if (F == 1 || F2 == 1) {
            i4 = 1;
        } else {
            i4 = 2;
            if (!(F == 2 || F2 == 2)) {
                i4 = 0;
            }
        }
        if (view != null && i2 == 0) {
            float f2 = ((LayoutParams) view.getLayoutParams()).f7421b;
            if (f2 == 0.0f) {
                j(view);
            } else if (f2 == 1.0f) {
                k(view);
            }
        }
        if (i4 != this.g3) {
            this.g3 = i4;
            List<DrawerListener> list = this.p3;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.p3.get(size).c(i4);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c(View view, int i2) {
        return (t(view) & i2) == i2;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void close() {
        d(GravityCompat.f6387b);
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f2 = 0.0f;
        for (int i2 = 0; i2 < childCount; i2++) {
            f2 = Math.max(f2, ((LayoutParams) getChildAt(i2).getLayoutParams()).f7421b);
        }
        this.a3 = f2;
        boolean o = this.c3.o(true);
        boolean o2 = this.d3.o(true);
        if (o || o2) {
            ViewCompat.t1(this);
        }
    }

    public void d(int i2) {
        e(i2, true);
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.a3 <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            View childAt = getChildAt(i2);
            if (H(x, y, childAt) && !B(childAt) && m(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        Drawable drawable;
        Canvas canvas2 = canvas;
        View view2 = view;
        int height = getHeight();
        boolean B = B(view2);
        int width = getWidth();
        int save = canvas.save();
        int i2 = 0;
        if (B) {
            int childCount = getChildCount();
            int i4 = 0;
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt != view2 && childAt.getVisibility() == 0 && x(childAt) && E(childAt) && childAt.getHeight() >= height) {
                    if (c(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i4) {
                            i4 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i4, 0, width, getHeight());
            i2 = i4;
        }
        boolean drawChild = super.drawChild(canvas, view, j2);
        canvas.restoreToCount(save);
        float f2 = this.a3;
        if (f2 <= 0.0f || !B) {
            if (this.t3 != null && c(view2, 3)) {
                int intrinsicWidth = this.t3.getIntrinsicWidth();
                int right2 = view.getRight();
                float max = Math.max(0.0f, Math.min(((float) right2) / ((float) this.c3.B()), 1.0f));
                this.t3.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
                this.t3.setAlpha((int) (max * 255.0f));
                drawable = this.t3;
            } else if (this.u3 != null && c(view2, 5)) {
                int intrinsicWidth2 = this.u3.getIntrinsicWidth();
                int left2 = view.getLeft();
                float max2 = Math.max(0.0f, Math.min(((float) (getWidth() - left2)) / ((float) this.d3.B()), 1.0f));
                this.u3.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
                this.u3.setAlpha((int) (max2 * 255.0f));
                drawable = this.u3;
            }
            drawable.draw(canvas);
        } else {
            int i6 = this.Z2;
            this.b3.setColor((i6 & ViewCompat.x) | (((int) (((float) ((-16777216 & i6) >>> 24)) * f2)) << 24));
            canvas.drawRect((float) i2, 0.0f, (float) width, (float) getHeight(), this.b3);
        }
        return drawChild;
    }

    public void e(int i2, boolean z) {
        View n2 = n(i2);
        if (n2 != null) {
            g(n2, z);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + w(i2));
    }

    public void f(@NonNull View view) {
        g(view, true);
    }

    public void g(@NonNull View view, boolean z) {
        ViewDragHelper viewDragHelper;
        int width;
        if (E(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.i3) {
                layoutParams.f7421b = 0.0f;
                layoutParams.f7423d = 0;
            } else if (z) {
                layoutParams.f7423d |= 4;
                if (c(view, 3)) {
                    viewDragHelper = this.c3;
                    width = -view.getWidth();
                } else {
                    viewDragHelper = this.d3;
                    width = getWidth();
                }
                viewDragHelper.X(view, width, view.getTop());
            } else {
                J(view, 0.0f);
                b0(0, view);
                view.setVisibility(4);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public float getDrawerElevation() {
        if (Z3) {
            return this.X2;
        }
        return 0.0f;
    }

    @Nullable
    public Drawable getStatusBarBackgroundDrawable() {
        return this.s3;
    }

    public void h() {
        i(false);
    }

    /* access modifiers changed from: package-private */
    public void i(boolean z) {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (E(childAt) && (!z || layoutParams.f7422c)) {
                z2 |= c(childAt, 3) ? this.c3.X(childAt, -childAt.getWidth(), childAt.getTop()) : this.d3.X(childAt, getWidth(), childAt.getTop());
                layoutParams.f7422c = false;
            }
        }
        this.e3.p();
        this.f3.p();
        if (z2) {
            invalidate();
        }
    }

    public boolean isOpen() {
        return C(GravityCompat.f6387b);
    }

    /* access modifiers changed from: package-private */
    public void j(View view) {
        View rootView;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f7423d & 1) == 1) {
            layoutParams.f7423d = 0;
            List<DrawerListener> list = this.p3;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.p3.get(size).b(view);
                }
            }
            a0(view, false);
            Z(view);
            if (hasWindowFocus() && (rootView = getRootView()) != null) {
                rootView.sendAccessibilityEvent(32);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void k(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f7423d & 1) == 0) {
            layoutParams.f7423d = 1;
            List<DrawerListener> list = this.p3;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.p3.get(size).a(view);
                }
            }
            a0(view, true);
            Z(view);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void l(View view, float f2) {
        List<DrawerListener> list = this.p3;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.p3.get(size).d(view, f2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public View n(int i2) {
        int d2 = GravityCompat.d(i2, ViewCompat.c0(this)) & 7;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if ((t(childAt) & 7) == d2) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public View o() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((((LayoutParams) childAt.getLayoutParams()).f7423d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.i3 = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i3 = true;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.y3 && this.s3 != null) {
            Object obj = this.x3;
            int systemWindowInsetTop = obj != null ? ((WindowInsets) obj).getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.s3.setBounds(0, 0, getWidth(), systemWindowInsetTop);
                this.s3.draw(canvas);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004b, code lost:
        r7 = r6.c3.v((int) r0, (int) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if (r0 != 3) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            int r0 = r7.getActionMasked()
            androidx.customview.widget.ViewDragHelper r1 = r6.c3
            boolean r1 = r1.W(r7)
            androidx.customview.widget.ViewDragHelper r2 = r6.d3
            boolean r2 = r2.W(r7)
            r1 = r1 | r2
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0038
            if (r0 == r2) goto L_0x0031
            r7 = 2
            r4 = 3
            if (r0 == r7) goto L_0x001e
            if (r0 == r4) goto L_0x0031
            goto L_0x0036
        L_0x001e:
            androidx.customview.widget.ViewDragHelper r7 = r6.c3
            boolean r7 = r7.f(r4)
            if (r7 == 0) goto L_0x0036
            androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback r7 = r6.e3
            r7.p()
            androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback r7 = r6.f3
            r7.p()
            goto L_0x0036
        L_0x0031:
            r6.i(r2)
            r6.n3 = r3
        L_0x0036:
            r7 = 0
            goto L_0x0060
        L_0x0038:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.q3 = r0
            r6.r3 = r7
            float r4 = r6.a3
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x005d
            androidx.customview.widget.ViewDragHelper r4 = r6.c3
            int r0 = (int) r0
            int r7 = (int) r7
            android.view.View r7 = r4.v(r0, r7)
            if (r7 == 0) goto L_0x005d
            boolean r7 = r6.B(r7)
            if (r7 == 0) goto L_0x005d
            r7 = 1
            goto L_0x005e
        L_0x005d:
            r7 = 0
        L_0x005e:
            r6.n3 = r3
        L_0x0060:
            if (r1 != 0) goto L_0x0070
            if (r7 != 0) goto L_0x0070
            boolean r7 = r6.y()
            if (r7 != 0) goto L_0x0070
            boolean r7 = r6.n3
            if (r7 == 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r2 = 0
        L_0x0070:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4 || !z()) {
            return super.onKeyDown(i2, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyUp(i2, keyEvent);
        }
        View p = p();
        if (p != null && r(p) == 0) {
            h();
        }
        return p != null;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i4, int i5, int i6) {
        WindowInsets a2;
        float f2;
        int i7;
        int measuredHeight;
        int i8;
        int i9;
        this.h3 = true;
        int i10 = i5 - i2;
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (B(childAt)) {
                    int i12 = layoutParams.leftMargin;
                    childAt.layout(i12, layoutParams.topMargin, childAt.getMeasuredWidth() + i12, layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight2 = childAt.getMeasuredHeight();
                    if (c(childAt, 3)) {
                        float f4 = (float) measuredWidth;
                        i7 = (-measuredWidth) + ((int) (layoutParams.f7421b * f4));
                        f2 = ((float) (measuredWidth + i7)) / f4;
                    } else {
                        float f5 = (float) measuredWidth;
                        int i13 = i10 - ((int) (layoutParams.f7421b * f5));
                        f2 = ((float) (i10 - i13)) / f5;
                        i7 = i13;
                    }
                    boolean z2 = f2 != layoutParams.f7421b;
                    int i14 = layoutParams.f7420a & 112;
                    if (i14 != 16) {
                        if (i14 != 80) {
                            measuredHeight = layoutParams.topMargin;
                            i8 = measuredWidth + i7;
                            i9 = measuredHeight2 + measuredHeight;
                        } else {
                            int i15 = i6 - i4;
                            measuredHeight = (i15 - layoutParams.bottomMargin) - childAt.getMeasuredHeight();
                            i8 = measuredWidth + i7;
                            i9 = i15 - layoutParams.bottomMargin;
                        }
                        childAt.layout(i7, measuredHeight, i8, i9);
                    } else {
                        int i16 = i6 - i4;
                        int i17 = (i16 - measuredHeight2) / 2;
                        int i18 = layoutParams.topMargin;
                        if (i17 < i18) {
                            i17 = i18;
                        } else {
                            int i19 = i17 + measuredHeight2;
                            int i20 = layoutParams.bottomMargin;
                            if (i19 > i16 - i20) {
                                i17 = (i16 - i20) - measuredHeight2;
                            }
                        }
                        childAt.layout(i7, i17, measuredWidth + i7, measuredHeight2 + i17);
                    }
                    if (z2) {
                        Y(childAt, f2);
                    }
                    int i21 = layoutParams.f7421b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i21) {
                        childAt.setVisibility(i21);
                    }
                }
            }
        }
        if (b4 && (a2 = getRootWindowInsets()) != null) {
            Insets n2 = WindowInsetsCompat.K(a2).n();
            ViewDragHelper viewDragHelper = this.c3;
            viewDragHelper.S(Math.max(viewDragHelper.A(), n2.f5824a));
            ViewDragHelper viewDragHelper2 = this.d3;
            viewDragHelper2.S(Math.max(viewDragHelper2.A(), n2.f5826c));
        }
        this.h3 = false;
        this.i3 = false;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"WrongConstant"})
    public void onMeasure(int i2, int i4) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i4);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (isInEditMode()) {
                if (mode == 0) {
                    size = 300;
                }
                if (mode2 == 0) {
                    size2 = 300;
                }
            } else {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
        }
        setMeasuredDimension(size, size2);
        boolean z = this.x3 != null && ViewCompat.W(this);
        int c0 = ViewCompat.c0(this);
        int childCount = getChildCount();
        boolean z2 = false;
        boolean z4 = false;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (z) {
                    int d2 = GravityCompat.d(layoutParams.f7420a, c0);
                    boolean W = ViewCompat.W(childAt);
                    WindowInsets windowInsets = (WindowInsets) this.x3;
                    if (W) {
                        if (d2 == 3) {
                            windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), 0, windowInsets.getSystemWindowInsetBottom());
                        } else if (d2 == 5) {
                            windowInsets = windowInsets.replaceSystemWindowInsets(0, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                        }
                        childAt.dispatchApplyWindowInsets(windowInsets);
                    } else {
                        if (d2 == 3) {
                            windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), 0, windowInsets.getSystemWindowInsetBottom());
                        } else if (d2 == 5) {
                            windowInsets = windowInsets.replaceSystemWindowInsets(0, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                        }
                        layoutParams.leftMargin = windowInsets.getSystemWindowInsetLeft();
                        layoutParams.topMargin = windowInsets.getSystemWindowInsetTop();
                        layoutParams.rightMargin = windowInsets.getSystemWindowInsetRight();
                        layoutParams.bottomMargin = windowInsets.getSystemWindowInsetBottom();
                    }
                }
                if (B(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - layoutParams.leftMargin) - layoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - layoutParams.topMargin) - layoutParams.bottomMargin, 1073741824));
                } else if (E(childAt)) {
                    if (Z3) {
                        float T = ViewCompat.T(childAt);
                        float f2 = this.X2;
                        if (T != f2) {
                            ViewCompat.V1(childAt, f2);
                        }
                    }
                    int t = t(childAt) & 7;
                    boolean z5 = t == 3;
                    if ((!z5 || !z2) && (z5 || !z4)) {
                        if (z5) {
                            z2 = true;
                        } else {
                            z4 = true;
                        }
                        childAt.measure(ViewGroup.getChildMeasureSpec(i2, this.Y2 + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), ViewGroup.getChildMeasureSpec(i4, layoutParams.topMargin + layoutParams.bottomMargin, layoutParams.height));
                    } else {
                        throw new IllegalStateException("Child drawer has absolute gravity " + w(t) + " but this " + H3 + " already has a drawer view along that edge");
                    }
                } else {
                    throw new IllegalStateException("Child " + childAt + " at index " + i5 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
            int i6 = i2;
            int i7 = i4;
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        View n2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        int i2 = savedState.Y;
        if (!(i2 == 0 || (n2 = n(i2)) == null)) {
            M(n2);
        }
        int i4 = savedState.Z;
        if (i4 != 3) {
            T(i4, 3);
        }
        int i5 = savedState.X2;
        if (i5 != 3) {
            T(i5, 5);
        }
        int i6 = savedState.Y2;
        if (i6 != 3) {
            T(i6, GravityCompat.f6387b);
        }
        int i7 = savedState.Z2;
        if (i7 != 3) {
            T(i7, GravityCompat.f6388c);
        }
    }

    public void onRtlPropertiesChanged(int i2) {
        R();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
            int i4 = layoutParams.f7423d;
            boolean z = true;
            boolean z2 = i4 == 1;
            if (i4 != 2) {
                z = false;
            }
            if (z2 || z) {
                savedState.Y = layoutParams.f7420a;
            } else {
                i2++;
            }
        }
        savedState.Z = this.j3;
        savedState.X2 = this.k3;
        savedState.Y2 = this.l3;
        savedState.Z2 = this.m3;
        return savedState;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005b, code lost:
        if (r(r7) != 2) goto L_0x005e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            androidx.customview.widget.ViewDragHelper r0 = r6.c3
            r0.M(r7)
            androidx.customview.widget.ViewDragHelper r0 = r6.d3
            r0.M(r7)
            int r0 = r7.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0062
            if (r0 == r2) goto L_0x0020
            r7 = 3
            if (r0 == r7) goto L_0x001a
            goto L_0x006f
        L_0x001a:
            r6.i(r2)
        L_0x001d:
            r6.n3 = r1
            goto L_0x006f
        L_0x0020:
            float r0 = r7.getX()
            float r7 = r7.getY()
            androidx.customview.widget.ViewDragHelper r3 = r6.c3
            int r4 = (int) r0
            int r5 = (int) r7
            android.view.View r3 = r3.v(r4, r5)
            if (r3 == 0) goto L_0x005d
            boolean r3 = r6.B(r3)
            if (r3 == 0) goto L_0x005d
            float r3 = r6.q3
            float r0 = r0 - r3
            float r3 = r6.r3
            float r7 = r7 - r3
            androidx.customview.widget.ViewDragHelper r3 = r6.c3
            int r3 = r3.E()
            float r0 = r0 * r0
            float r7 = r7 * r7
            float r0 = r0 + r7
            int r3 = r3 * r3
            float r7 = (float) r3
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 >= 0) goto L_0x005d
            android.view.View r7 = r6.o()
            if (r7 == 0) goto L_0x005d
            int r7 = r6.r(r7)
            r0 = 2
            if (r7 != r0) goto L_0x005e
        L_0x005d:
            r1 = 1
        L_0x005e:
            r6.i(r1)
            goto L_0x006f
        L_0x0062:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.q3 = r0
            r6.r3 = r7
            goto L_0x001d
        L_0x006f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void open() {
        K(GravityCompat.f6387b);
    }

    /* access modifiers changed from: package-private */
    public View p() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (E(childAt) && G(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    public int q(int i2) {
        int c0 = ViewCompat.c0(this);
        if (i2 == 3) {
            int i4 = this.j3;
            if (i4 != 3) {
                return i4;
            }
            int i5 = c0 == 0 ? this.l3 : this.m3;
            if (i5 != 3) {
                return i5;
            }
            return 0;
        } else if (i2 == 5) {
            int i6 = this.k3;
            if (i6 != 3) {
                return i6;
            }
            int i7 = c0 == 0 ? this.m3 : this.l3;
            if (i7 != 3) {
                return i7;
            }
            return 0;
        } else if (i2 == 8388611) {
            int i8 = this.l3;
            if (i8 != 3) {
                return i8;
            }
            int i9 = c0 == 0 ? this.j3 : this.k3;
            if (i9 != 3) {
                return i9;
            }
            return 0;
        } else if (i2 != 8388613) {
            return 0;
        } else {
            int i10 = this.m3;
            if (i10 != 3) {
                return i10;
            }
            int i11 = c0 == 0 ? this.k3 : this.j3;
            if (i11 != 3) {
                return i11;
            }
            return 0;
        }
    }

    public int r(@NonNull View view) {
        if (E(view)) {
            return q(((LayoutParams) view.getLayoutParams()).f7420a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            i(true);
        }
    }

    public void requestLayout() {
        if (!this.h3) {
            super.requestLayout();
        }
    }

    @Nullable
    public CharSequence s(int i2) {
        int d2 = GravityCompat.d(i2, ViewCompat.c0(this));
        if (d2 == 3) {
            return this.v3;
        }
        if (d2 == 5) {
            return this.w3;
        }
        return null;
    }

    public void setDrawerElevation(float f2) {
        this.X2 = f2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (E(childAt)) {
                ViewCompat.V1(childAt, this.X2);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(DrawerListener drawerListener) {
        DrawerListener drawerListener2 = this.o3;
        if (drawerListener2 != null) {
            O(drawerListener2);
        }
        if (drawerListener != null) {
            setDrawerListener(drawerListener);
        }
        this.o3 = drawerListener;
    }

    public void setDrawerLockMode(int i2) {
        T(i2, 3);
        T(i2, 5);
    }

    public void setScrimColor(@ColorInt int i2) {
        this.Z2 = i2;
        invalidate();
    }

    public void setStatusBarBackground(int i2) {
        this.s3 = i2 != 0 ? ContextCompat.l(getContext(), i2) : null;
        invalidate();
    }

    public void setStatusBarBackgroundColor(@ColorInt int i2) {
        this.s3 = new ColorDrawable(i2);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public int t(View view) {
        return GravityCompat.d(((LayoutParams) view.getLayoutParams()).f7420a, ViewCompat.c0(this));
    }

    /* access modifiers changed from: package-private */
    public float u(View view) {
        return ((LayoutParams) view.getLayoutParams()).f7421b;
    }

    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f7326b);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        this.s3 = drawable;
        invalidate();
    }

    /* JADX INFO: finally extract failed */
    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.s = new ChildAccessibilityDelegate();
        this.Z2 = R3;
        this.b3 = new Paint();
        this.i3 = true;
        this.j3 = 3;
        this.k3 = 3;
        this.l3 = 3;
        this.m3 = 3;
        this.z3 = null;
        this.A3 = null;
        this.B3 = null;
        this.C3 = null;
        this.G3 = new AccessibilityViewCommand() {
            public boolean a(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                if (!DrawerLayout.this.D(view) || DrawerLayout.this.r(view) == 2) {
                    return false;
                }
                DrawerLayout.this.f(view);
                return true;
            }
        };
        setDescendantFocusability(262144);
        float f2 = getResources().getDisplayMetrics().density;
        this.Y2 = (int) ((64.0f * f2) + 0.5f);
        float f4 = f2 * 400.0f;
        ViewDragCallback viewDragCallback = new ViewDragCallback(3);
        this.e3 = viewDragCallback;
        ViewDragCallback viewDragCallback2 = new ViewDragCallback(5);
        this.f3 = viewDragCallback2;
        ViewDragHelper p = ViewDragHelper.p(this, 1.0f, viewDragCallback);
        this.c3 = p;
        p.T(1);
        p.U(f4);
        viewDragCallback.q(p);
        ViewDragHelper p2 = ViewDragHelper.p(this, 1.0f, viewDragCallback2);
        this.d3 = p2;
        p2.T(2);
        p2.U(f4);
        viewDragCallback2.q(p2);
        setFocusableInTouchMode(true);
        ViewCompat.Z1(this, 1);
        ViewCompat.H1(this, new AccessibilityDelegate());
        setMotionEventSplittingEnabled(false);
        if (ViewCompat.W(this)) {
            setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    ((DrawerLayout) view).S(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
                    return windowInsets.consumeSystemWindowInsets();
                }
            });
            setSystemUiVisibility(1280);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(I3);
            try {
                this.s3 = obtainStyledAttributes.getDrawable(0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.f7405g, i2, 0);
        try {
            int i4 = R.styleable.f7406h;
            this.X2 = obtainStyledAttributes2.hasValue(i4) ? obtainStyledAttributes2.getDimension(i4, 0.0f) : getResources().getDimension(R.dimen.f7350h);
            obtainStyledAttributes2.recycle();
            this.D3 = new ArrayList<>();
        } catch (Throwable th) {
            obtainStyledAttributes2.recycle();
            throw th;
        }
    }
}
