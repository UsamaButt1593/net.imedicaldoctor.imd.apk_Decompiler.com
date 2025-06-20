package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.R;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.ClassUtils;

public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2, NestedScrollingParent3 {
    private static final Pools.Pool<Rect> A3 = new Pools.SynchronizedPool(12);
    static final String q3 = "CoordinatorLayout";
    static final String r3;
    private static final int s3 = 0;
    private static final int t3 = 1;
    static final Class<?>[] u3 = {Context.class, AttributeSet.class};
    static final ThreadLocal<Map<String, Constructor<Behavior>>> v3 = new ThreadLocal<>();
    static final int w3 = 0;
    static final int x3 = 1;
    static final int y3 = 2;
    static final Comparator<View> z3 = new ViewElevationComparator();
    private final DirectedAcyclicGraph<View> X2;
    private final List<View> Y2;
    private final List<View> Z2;
    private Paint a3;
    private final int[] b3;
    private final int[] c3;
    private boolean d3;
    private boolean e3;
    private int[] f3;
    private View g3;
    private View h3;
    private OnPreDrawListener i3;
    private boolean j3;
    private WindowInsetsCompat k3;
    private boolean l3;
    private Drawable m3;
    ViewGroup.OnHierarchyChangeListener n3;
    private OnApplyWindowInsetsListener o3;
    private final NestedScrollingParentHelper p3;
    private final List<View> s;

    public interface AttachedBehavior {
        @NonNull
        Behavior getBehavior();
    }

    public static abstract class Behavior<V extends View> {
        public Behavior() {
        }

        public static void M(@NonNull View view, @Nullable Object obj) {
            ((LayoutParams) view.getLayoutParams()).r = obj;
        }

        @Nullable
        public static Object l(@NonNull View view) {
            return ((LayoutParams) view.getLayoutParams()).r;
        }

        @Deprecated
        public void A(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2, int i3, int i4, int i5, int i6) {
            if (i6 == 0) {
                z(coordinatorLayout, v, view, i2, i3, i4, i5);
            }
        }

        public void B(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2, int i3, int i4, int i5, int i6, @NonNull int[] iArr) {
            iArr[0] = iArr[0] + i4;
            iArr[1] = iArr[1] + i5;
            A(coordinatorLayout, v, view, i2, i3, i4, i5, i6);
        }

        @Deprecated
        public void C(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i2) {
        }

        public void D(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i2, int i3) {
            if (i3 == 0) {
                C(coordinatorLayout, v, view, view2, i2);
            }
        }

        public boolean E(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull Rect rect, boolean z) {
            return false;
        }

        public void F(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull Parcelable parcelable) {
        }

        @Nullable
        public Parcelable G(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean H(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i2) {
            return false;
        }

        public boolean I(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i2, int i3) {
            if (i3 == 0) {
                return H(coordinatorLayout, v, view, view2, i2);
            }
            return false;
        }

        @Deprecated
        public void J(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view) {
        }

        public void K(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2) {
            if (i2 == 0) {
                J(coordinatorLayout, v, view);
            }
        }

        public boolean L(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
            return false;
        }

        public boolean h(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v) {
            return k(coordinatorLayout, v) > 0.0f;
        }

        public boolean i(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull Rect rect) {
            return false;
        }

        @ColorInt
        public int j(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v) {
            return ViewCompat.y;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float k(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v) {
            return 0.0f;
        }

        public boolean m(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view) {
            return false;
        }

        @NonNull
        public WindowInsetsCompat n(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public void o(@NonNull LayoutParams layoutParams) {
        }

        public boolean p(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view) {
            return false;
        }

        public void q(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view) {
        }

        public void r() {
        }

        public boolean s(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
            return false;
        }

        public boolean t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
            return false;
        }

        public boolean u(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2, int i3, int i4, int i5) {
            return false;
        }

        public boolean v(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, float f2, float f3, boolean z) {
            return false;
        }

        public boolean w(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, float f2, float f3) {
            return false;
        }

        @Deprecated
        public void x(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2, int i3, @NonNull int[] iArr) {
        }

        public void y(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2, int i3, @NonNull int[] iArr, int i4) {
            if (i4 == 0) {
                x(coordinatorLayout, v, view, i2, i3, iArr);
            }
        }

        @Deprecated
        public void z(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2, int i3, int i4, int i5) {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }
    }

    @Deprecated
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DefaultBehavior {
        Class<? extends Behavior> value();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DispatchChangeEvent {
    }

    private class HierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        HierarchyChangeListener() {
        }

        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.n3;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.M(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.n3;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        Behavior f5077a;

        /* renamed from: b  reason: collision with root package name */
        boolean f5078b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f5079c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f5080d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f5081e = -1;

        /* renamed from: f  reason: collision with root package name */
        int f5082f = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f5083g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f5084h = 0;

        /* renamed from: i  reason: collision with root package name */
        int f5085i;

        /* renamed from: j  reason: collision with root package name */
        int f5086j;

        /* renamed from: k  reason: collision with root package name */
        View f5087k;

        /* renamed from: l  reason: collision with root package name */
        View f5088l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f5089m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f5090n;
        private boolean o;
        private boolean p;
        final Rect q = new Rect();
        Object r;

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        private void o(View view, CoordinatorLayout coordinatorLayout) {
            View findViewById = coordinatorLayout.findViewById(this.f5082f);
            this.f5087k = findViewById;
            if (findViewById != null) {
                if (findViewById != coordinatorLayout) {
                    ViewParent parent = findViewById.getParent();
                    while (parent != coordinatorLayout && parent != null) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                findViewById = (View) parent;
                            }
                            parent = parent.getParent();
                        } else if (!coordinatorLayout.isInEditMode()) {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.f5088l = findViewById;
                    return;
                } else if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (!coordinatorLayout.isInEditMode()) {
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f5082f) + " to anchor view " + view);
            }
            this.f5088l = null;
            this.f5087k = null;
        }

        private boolean u(View view, int i2) {
            int d2 = GravityCompat.d(((LayoutParams) view.getLayoutParams()).f5083g, i2);
            return d2 != 0 && (GravityCompat.d(this.f5084h, i2) & d2) == d2;
        }

        private boolean v(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f5087k.getId() != this.f5082f) {
                return false;
            }
            View view2 = this.f5087k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f5088l = null;
                    this.f5087k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
            this.f5088l = view2;
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f5087k == null && this.f5082f != -1;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
            r0 = r1.f5077a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean b(androidx.coordinatorlayout.widget.CoordinatorLayout r2, android.view.View r3, android.view.View r4) {
            /*
                r1 = this;
                android.view.View r0 = r1.f5088l
                if (r4 == r0) goto L_0x001b
                int r0 = androidx.core.view.ViewCompat.c0(r2)
                boolean r0 = r1.u(r4, r0)
                if (r0 != 0) goto L_0x001b
                androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r0 = r1.f5077a
                if (r0 == 0) goto L_0x0019
                boolean r2 = r0.m(r2, r3, r4)
                if (r2 == 0) goto L_0x0019
                goto L_0x001b
            L_0x0019:
                r2 = 0
                goto L_0x001c
            L_0x001b:
                r2 = 1
            L_0x001c:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams.b(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View):boolean");
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            if (this.f5077a == null) {
                this.f5089m = false;
            }
            return this.f5089m;
        }

        /* access modifiers changed from: package-private */
        public View d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f5082f == -1) {
                this.f5088l = null;
                this.f5087k = null;
                return null;
            }
            if (this.f5087k == null || !v(view, coordinatorLayout)) {
                o(view, coordinatorLayout);
            }
            return this.f5087k;
        }

        @IdRes
        public int e() {
            return this.f5082f;
        }

        @Nullable
        public Behavior f() {
            return this.f5077a;
        }

        /* access modifiers changed from: package-private */
        public boolean g() {
            return this.p;
        }

        /* access modifiers changed from: package-private */
        public Rect h() {
            return this.q;
        }

        /* access modifiers changed from: package-private */
        public void i() {
            this.f5088l = null;
            this.f5087k = null;
        }

        /* access modifiers changed from: package-private */
        public boolean j(CoordinatorLayout coordinatorLayout, View view) {
            boolean z = this.f5089m;
            if (z) {
                return true;
            }
            Behavior behavior = this.f5077a;
            boolean h2 = (behavior != null ? behavior.h(coordinatorLayout, view) : false) | z;
            this.f5089m = h2;
            return h2;
        }

        /* access modifiers changed from: package-private */
        public boolean k(int i2) {
            if (i2 == 0) {
                return this.f5090n;
            }
            if (i2 != 1) {
                return false;
            }
            return this.o;
        }

        /* access modifiers changed from: package-private */
        public void l() {
            this.p = false;
        }

        /* access modifiers changed from: package-private */
        public void m(int i2) {
            t(i2, false);
        }

        /* access modifiers changed from: package-private */
        public void n() {
            this.f5089m = false;
        }

        public void p(@IdRes int i2) {
            i();
            this.f5082f = i2;
        }

        public void q(@Nullable Behavior behavior) {
            Behavior behavior2 = this.f5077a;
            if (behavior2 != behavior) {
                if (behavior2 != null) {
                    behavior2.r();
                }
                this.f5077a = behavior;
                this.r = null;
                this.f5078b = true;
                if (behavior != null) {
                    behavior.o(this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void r(boolean z) {
            this.p = z;
        }

        /* access modifiers changed from: package-private */
        public void s(Rect rect) {
            this.q.set(rect);
        }

        /* access modifiers changed from: package-private */
        public void t(int i2, boolean z) {
            if (i2 == 0) {
                this.f5090n = z;
            } else if (i2 == 1) {
                this.o = z;
            }
        }

        LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.f5071j);
            this.f5079c = obtainStyledAttributes.getInteger(R.styleable.f5072k, 0);
            this.f5082f = obtainStyledAttributes.getResourceId(R.styleable.f5073l, -1);
            this.f5080d = obtainStyledAttributes.getInteger(R.styleable.f5074m, 0);
            this.f5081e = obtainStyledAttributes.getInteger(R.styleable.q, -1);
            this.f5083g = obtainStyledAttributes.getInt(R.styleable.p, 0);
            this.f5084h = obtainStyledAttributes.getInt(R.styleable.o, 0);
            int i2 = R.styleable.f5075n;
            boolean hasValue = obtainStyledAttributes.hasValue(i2);
            this.f5078b = hasValue;
            if (hasValue) {
                this.f5077a = CoordinatorLayout.P(context, attributeSet, obtainStyledAttributes.getString(i2));
            }
            obtainStyledAttributes.recycle();
            Behavior behavior = this.f5077a;
            if (behavior != null) {
                behavior.o(this);
            }
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    class OnPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
        OnPreDrawListener() {
        }

        public boolean onPreDraw() {
            CoordinatorLayout.this.M(0);
            return true;
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
        SparseArray<Parcelable> Y;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.Y = new SparseArray<>(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                this.Y.append(iArr[i2], readParcelableArray[i2]);
            }
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            SparseArray<Parcelable> sparseArray = this.Y;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i3 = 0; i3 < size; i3++) {
                iArr[i3] = this.Y.keyAt(i3);
                parcelableArr[i3] = this.Y.valueAt(i3);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i2);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    static class ViewElevationComparator implements Comparator<View> {
        ViewElevationComparator() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            float I0 = ViewCompat.I0(view);
            float I02 = ViewCompat.I0(view2);
            if (I0 > I02) {
                return -1;
            }
            return I0 < I02 ? 1 : 0;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<androidx.coordinatorlayout.widget.CoordinatorLayout> r0 = androidx.coordinatorlayout.widget.CoordinatorLayout.class
            java.lang.Package r0 = r0.getPackage()
            if (r0 == 0) goto L_0x000d
            java.lang.String r0 = r0.getName()
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            r3 = r0
            androidx.coordinatorlayout.widget.CoordinatorLayout$ViewElevationComparator r0 = new androidx.coordinatorlayout.widget.CoordinatorLayout$ViewElevationComparator
            r0.<init>()
            z3 = r0
            r0 = 2
            java.lang.Class[] r0 = new java.lang.Class[r0]
            java.lang.Class<android.content.Context> r1 = android.content.Context.class
            r2 = 0
            r0[r2] = r1
            java.lang.Class<android.util.AttributeSet> r1 = android.util.AttributeSet.class
            r2 = 1
            r0[r2] = r1
            u3 = r0
            java.lang.ThreadLocal r0 = new java.lang.ThreadLocal
            r0.<init>()
            v3 = r0
            androidx.core.util.Pools$SynchronizedPool r0 = new androidx.core.util.Pools$SynchronizedPool
            r1 = 12
            r0.<init>(r1)
            A3 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.<clinit>():void");
    }

    public CoordinatorLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void A(View view, int i2, Rect rect, Rect rect2, LayoutParams layoutParams, int i4, int i5) {
        int d2 = GravityCompat.d(W(layoutParams.f5079c), i2);
        int d4 = GravityCompat.d(X(layoutParams.f5080d), i2);
        int i6 = d2 & 7;
        int i7 = d2 & 112;
        int i8 = d4 & 7;
        int i9 = d4 & 112;
        int width = i8 != 1 ? i8 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int height = i9 != 16 ? i9 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i6 == 1) {
            width -= i4 / 2;
        } else if (i6 != 5) {
            width -= i4;
        }
        if (i7 == 16) {
            height -= i5 / 2;
        } else if (i7 != 80) {
            height -= i5;
        }
        rect2.set(width, height, i4 + width, i5 + height);
    }

    private int B(int i2) {
        StringBuilder sb;
        int[] iArr = this.f3;
        if (iArr == null) {
            sb = new StringBuilder();
            sb.append("No keylines defined for ");
            sb.append(this);
            sb.append(" - attempted index lookup ");
            sb.append(i2);
        } else if (i2 >= 0 && i2 < iArr.length) {
            return iArr[i2];
        } else {
            sb = new StringBuilder();
            sb.append("Keyline index ");
            sb.append(i2);
            sb.append(" out of range for ");
            sb.append(this);
        }
        Log.e(q3, sb.toString());
        return 0;
    }

    private void E(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i2) : i2));
        }
        Comparator<View> comparator = z3;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean F(View view) {
        return this.X2.j(view);
    }

    private void H(View view, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect e2 = e();
        e2.set(getPaddingLeft() + layoutParams.leftMargin, getPaddingTop() + layoutParams.topMargin, (getWidth() - getPaddingRight()) - layoutParams.rightMargin, (getHeight() - getPaddingBottom()) - layoutParams.bottomMargin);
        if (this.k3 != null && ViewCompat.W(this) && !ViewCompat.W(view)) {
            e2.left += this.k3.p();
            e2.top += this.k3.r();
            e2.right -= this.k3.q();
            e2.bottom -= this.k3.o();
        }
        Rect e4 = e();
        GravityCompat.b(X(layoutParams.f5079c), view.getMeasuredWidth(), view.getMeasuredHeight(), e2, e4, i2);
        view.layout(e4.left, e4.top, e4.right, e4.bottom);
        T(e2);
        T(e4);
    }

    private void I(View view, View view2, int i2) {
        Rect e2 = e();
        Rect e4 = e();
        try {
            y(view2, e2);
            z(view, i2, e2, e4);
            view.layout(e4.left, e4.top, e4.right, e4.bottom);
        } finally {
            T(e2);
            T(e4);
        }
    }

    private void J(View view, int i2, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int d2 = GravityCompat.d(Y(layoutParams.f5079c), i4);
        int i5 = d2 & 7;
        int i6 = d2 & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i4 == 1) {
            i2 = width - i2;
        }
        int B = B(i2) - measuredWidth;
        if (i5 == 1) {
            B += measuredWidth / 2;
        } else if (i5 == 5) {
            B += measuredWidth;
        }
        int i7 = i6 != 16 ? i6 != 80 ? 0 : measuredHeight : measuredHeight / 2;
        int max = Math.max(getPaddingLeft() + layoutParams.leftMargin, Math.min(B, ((width - getPaddingRight()) - measuredWidth) - layoutParams.rightMargin));
        int max2 = Math.max(getPaddingTop() + layoutParams.topMargin, Math.min(i7, ((height - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin));
        view.layout(max, max2, measuredWidth + max, measuredHeight + max2);
    }

    private void K(View view, Rect rect, int i2) {
        boolean z;
        boolean z2;
        int width;
        int i4;
        int i5;
        int i6;
        int height;
        int i7;
        int i8;
        int i9;
        if (ViewCompat.Y0(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Behavior f2 = layoutParams.f();
            Rect e2 = e();
            Rect e4 = e();
            e4.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (f2 == null || !f2.i(this, view, e2)) {
                e2.set(e4);
            } else if (!e4.contains(e2)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + e2.toShortString() + " | Bounds:" + e4.toShortString());
            }
            T(e4);
            if (e2.isEmpty()) {
                T(e2);
                return;
            }
            int d2 = GravityCompat.d(layoutParams.f5084h, i2);
            boolean z4 = true;
            if ((d2 & 48) != 48 || (i8 = (e2.top - layoutParams.topMargin) - layoutParams.f5086j) >= (i9 = rect.top)) {
                z = false;
            } else {
                a0(view, i9 - i8);
                z = true;
            }
            if ((d2 & 80) == 80 && (height = ((getHeight() - e2.bottom) - layoutParams.bottomMargin) + layoutParams.f5086j) < (i7 = rect.bottom)) {
                a0(view, height - i7);
                z = true;
            }
            if (!z) {
                a0(view, 0);
            }
            if ((d2 & 3) != 3 || (i5 = (e2.left - layoutParams.leftMargin) - layoutParams.f5085i) >= (i6 = rect.left)) {
                z2 = false;
            } else {
                Z(view, i6 - i5);
                z2 = true;
            }
            if ((d2 & 5) != 5 || (width = ((getWidth() - e2.right) - layoutParams.rightMargin) + layoutParams.f5085i) >= (i4 = rect.right)) {
                z4 = z2;
            } else {
                Z(view, width - i4);
            }
            if (!z4) {
                Z(view, 0);
            }
            T(e2);
        }
    }

    static Behavior P(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = r3;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + ClassUtils.PACKAGE_SEPARATOR_CHAR + str;
            }
        }
        try {
            ThreadLocal<Map<String, Constructor<Behavior>>> threadLocal = v3;
            Map map = threadLocal.get();
            if (map == null) {
                map = new HashMap();
                threadLocal.set(map);
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(u3);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (Behavior) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Exception e2) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e2);
        }
    }

    private boolean Q(MotionEvent motionEvent, int i2) {
        MotionEvent motionEvent2 = motionEvent;
        int i4 = i2;
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.Y2;
        E(list);
        int size = list.size();
        MotionEvent motionEvent3 = null;
        boolean z = false;
        boolean z2 = false;
        for (int i5 = 0; i5 < size; i5++) {
            View view = list.get(i5);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Behavior f2 = layoutParams.f();
            if ((!z && !z2) || actionMasked == 0) {
                if (!z && f2 != null) {
                    if (i4 == 0) {
                        z = f2.s(this, view, motionEvent2);
                    } else if (i4 == 1) {
                        z = f2.L(this, view, motionEvent2);
                    }
                    if (z) {
                        this.g3 = view;
                    }
                }
                boolean c2 = layoutParams.c();
                boolean j2 = layoutParams.j(this, view);
                z2 = j2 && !c2;
                if (j2 && !z2) {
                    break;
                }
            } else if (f2 != null) {
                if (motionEvent3 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i4 == 0) {
                    f2.s(this, view, motionEvent3);
                } else if (i4 == 1) {
                    f2.L(this, view, motionEvent3);
                }
            }
        }
        list.clear();
        return z;
    }

    private void R() {
        this.s.clear();
        this.X2.c();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams D = D(childAt);
            D.d(this, childAt);
            this.X2.b(childAt);
            for (int i4 = 0; i4 < childCount; i4++) {
                if (i4 != i2) {
                    View childAt2 = getChildAt(i4);
                    if (D.b(this, childAt, childAt2)) {
                        if (!this.X2.d(childAt2)) {
                            this.X2.b(childAt2);
                        }
                        this.X2.a(childAt2, childAt);
                    }
                }
            }
        }
        this.s.addAll(this.X2.i());
        Collections.reverse(this.s);
    }

    private static void T(@NonNull Rect rect) {
        rect.setEmpty();
        A3.c(rect);
    }

    private void V(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            Behavior f2 = ((LayoutParams) childAt.getLayoutParams()).f();
            if (f2 != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    f2.s(this, childAt, obtain);
                } else {
                    f2.L(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            ((LayoutParams) getChildAt(i4).getLayoutParams()).n();
        }
        this.g3 = null;
        this.d3 = false;
    }

    private static int W(int i2) {
        if (i2 == 0) {
            return 17;
        }
        return i2;
    }

    private static int X(int i2) {
        if ((i2 & 7) == 0) {
            i2 |= GravityCompat.f6387b;
        }
        return (i2 & 112) == 0 ? i2 | 48 : i2;
    }

    private static int Y(int i2) {
        if (i2 == 0) {
            return 8388661;
        }
        return i2;
    }

    private void Z(View view, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i4 = layoutParams.f5085i;
        if (i4 != i2) {
            ViewCompat.i1(view, i2 - i4);
            layoutParams.f5085i = i2;
        }
    }

    private void a0(View view, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i4 = layoutParams.f5086j;
        if (i4 != i2) {
            ViewCompat.j1(view, i2 - i4);
            layoutParams.f5086j = i2;
        }
    }

    private void c0() {
        if (ViewCompat.W(this)) {
            if (this.o3 == null) {
                this.o3 = new OnApplyWindowInsetsListener() {
                    public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                        return CoordinatorLayout.this.b0(windowInsetsCompat);
                    }
                };
            }
            ViewCompat.k2(this, this.o3);
            setSystemUiVisibility(1280);
            return;
        }
        ViewCompat.k2(this, (OnApplyWindowInsetsListener) null);
    }

    @NonNull
    private static Rect e() {
        Rect b2 = A3.b();
        return b2 == null ? new Rect() : b2;
    }

    private static int h(int i2, int i4, int i5) {
        if (i2 < i4) {
            return i4;
        }
        return i2 > i5 ? i5 : i2;
    }

    private void i(LayoutParams layoutParams, Rect rect, int i2, int i4) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + layoutParams.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i2) - layoutParams.rightMargin));
        int max2 = Math.max(getPaddingTop() + layoutParams.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i4) - layoutParams.bottomMargin));
        rect.set(max, max2, i2 + max, i4 + max2);
    }

    private WindowInsetsCompat j(WindowInsetsCompat windowInsetsCompat) {
        Behavior f2;
        if (windowInsetsCompat.A()) {
            return windowInsetsCompat;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (ViewCompat.W(childAt) && (f2 = ((LayoutParams) childAt.getLayoutParams()).f()) != null) {
                windowInsetsCompat = f2.n(this, childAt, windowInsetsCompat);
                if (windowInsetsCompat.A()) {
                    break;
                }
            }
        }
        return windowInsetsCompat;
    }

    /* access modifiers changed from: package-private */
    public void C(View view, Rect rect) {
        rect.set(((LayoutParams) view.getLayoutParams()).h());
    }

    /* access modifiers changed from: package-private */
    public LayoutParams D(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f5078b) {
            if (view instanceof AttachedBehavior) {
                Behavior behavior = ((AttachedBehavior) view).getBehavior();
                if (behavior == null) {
                    Log.e(q3, "Attached behavior class is null");
                }
                layoutParams.q(behavior);
            } else {
                DefaultBehavior defaultBehavior = null;
                for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    defaultBehavior = (DefaultBehavior) cls.getAnnotation(DefaultBehavior.class);
                    if (defaultBehavior != null) {
                        break;
                    }
                }
                if (defaultBehavior != null) {
                    try {
                        layoutParams.q((Behavior) defaultBehavior.value().getDeclaredConstructor((Class[]) null).newInstance((Object[]) null));
                    } catch (Exception e2) {
                        Log.e(q3, "Default behavior class " + defaultBehavior.value().getName() + " could not be instantiated. Did you forget a default constructor?", e2);
                    }
                }
            }
            layoutParams.f5078b = true;
        }
        return layoutParams;
    }

    public boolean G(@NonNull View view, int i2, int i4) {
        Rect e2 = e();
        y(view, e2);
        try {
            return e2.contains(i2, i4);
        } finally {
            T(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public void L(View view, int i2) {
        Behavior f2;
        View view2 = view;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.f5087k != null) {
            Rect e2 = e();
            Rect e4 = e();
            Rect e5 = e();
            y(layoutParams.f5087k, e2);
            boolean z = false;
            v(view2, false, e4);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int i4 = measuredHeight;
            A(view, i2, e2, e5, layoutParams, measuredWidth, measuredHeight);
            if (!(e5.left == e4.left && e5.top == e4.top)) {
                z = true;
            }
            i(layoutParams, e5, measuredWidth, i4);
            int i5 = e5.left - e4.left;
            int i6 = e5.top - e4.top;
            if (i5 != 0) {
                ViewCompat.i1(view2, i5);
            }
            if (i6 != 0) {
                ViewCompat.j1(view2, i6);
            }
            if (z && (f2 = layoutParams.f()) != null) {
                f2.p(this, view2, layoutParams.f5087k);
            }
            T(e2);
            T(e4);
            T(e5);
        }
    }

    /* access modifiers changed from: package-private */
    public final void M(int i2) {
        boolean z;
        int i4 = i2;
        int c0 = ViewCompat.c0(this);
        int size = this.s.size();
        Rect e2 = e();
        Rect e4 = e();
        Rect e5 = e();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.s.get(i5);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (i4 != 0 || view.getVisibility() != 8) {
                for (int i6 = 0; i6 < i5; i6++) {
                    if (layoutParams.f5088l == this.s.get(i6)) {
                        L(view, c0);
                    }
                }
                v(view, true, e4);
                if (layoutParams.f5083g != 0 && !e4.isEmpty()) {
                    int d2 = GravityCompat.d(layoutParams.f5083g, c0);
                    int i7 = d2 & 112;
                    if (i7 == 48) {
                        e2.top = Math.max(e2.top, e4.bottom);
                    } else if (i7 == 80) {
                        e2.bottom = Math.max(e2.bottom, getHeight() - e4.top);
                    }
                    int i8 = d2 & 7;
                    if (i8 == 3) {
                        e2.left = Math.max(e2.left, e4.right);
                    } else if (i8 == 5) {
                        e2.right = Math.max(e2.right, getWidth() - e4.left);
                    }
                }
                if (layoutParams.f5084h != 0 && view.getVisibility() == 0) {
                    K(view, e2, c0);
                }
                if (i4 != 2) {
                    C(view, e5);
                    if (!e5.equals(e4)) {
                        S(view, e4);
                    }
                }
                for (int i9 = i5 + 1; i9 < size; i9++) {
                    View view2 = this.s.get(i9);
                    LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                    Behavior f2 = layoutParams2.f();
                    if (f2 != null && f2.m(this, view2, view)) {
                        if (i4 != 0 || !layoutParams2.g()) {
                            if (i4 != 2) {
                                z = f2.p(this, view2, view);
                            } else {
                                f2.q(this, view2, view);
                                z = true;
                            }
                            if (i4 == 1) {
                                layoutParams2.r(z);
                            }
                        } else {
                            layoutParams2.l();
                        }
                    }
                }
            }
        }
        T(e2);
        T(e4);
        T(e5);
    }

    public void N(@NonNull View view, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.a()) {
            View view2 = layoutParams.f5087k;
            if (view2 != null) {
                I(view, view2, i2);
                return;
            }
            int i4 = layoutParams.f5081e;
            if (i4 >= 0) {
                J(view, i4, i2);
            } else {
                H(view, i2);
            }
        } else {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
    }

    public void O(View view, int i2, int i4, int i5, int i6) {
        measureChildWithMargins(view, i2, i4, i5, i6);
    }

    /* access modifiers changed from: package-private */
    public void S(View view, Rect rect) {
        ((LayoutParams) view.getLayoutParams()).s(rect);
    }

    /* access modifiers changed from: package-private */
    public void U() {
        if (this.e3 && this.i3 != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.i3);
        }
        this.j3 = false;
    }

    /* access modifiers changed from: package-private */
    public final WindowInsetsCompat b0(WindowInsetsCompat windowInsetsCompat) {
        if (ObjectsCompat.a(this.k3, windowInsetsCompat)) {
            return windowInsetsCompat;
        }
        this.k3 = windowInsetsCompat;
        boolean z = false;
        boolean z2 = windowInsetsCompat != null && windowInsetsCompat.r() > 0;
        this.l3 = z2;
        if (!z2 && getBackground() == null) {
            z = true;
        }
        setWillNotDraw(z);
        WindowInsetsCompat j2 = j(windowInsetsCompat);
        requestLayout();
        return j2;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Behavior behavior = layoutParams.f5077a;
        if (behavior != null) {
            float k2 = behavior.k(this, view);
            if (k2 > 0.0f) {
                if (this.a3 == null) {
                    this.a3 = new Paint();
                }
                this.a3.setColor(layoutParams.f5077a.j(this, view));
                this.a3.setAlpha(h(Math.round(k2 * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.a3);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j2);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.m3;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (this.e3) {
            if (this.i3 == null) {
                this.i3 = new OnPreDrawListener();
            }
            getViewTreeObserver().addOnPreDrawListener(this.i3);
        }
        this.j3 = true;
    }

    public void g(@NonNull View view, int i2, int i4, int i5, int i6, int i7, @NonNull int[] iArr) {
        Behavior f2;
        int childCount = getChildCount();
        boolean z = false;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.k(i7) && (f2 = layoutParams.f()) != null) {
                    int[] iArr2 = this.b3;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    f2.B(this, childAt, view, i2, i4, i5, i6, i7, iArr2);
                    int[] iArr3 = this.b3;
                    i8 = i5 > 0 ? Math.max(i8, iArr3[0]) : Math.min(i8, iArr3[0]);
                    i9 = i6 > 0 ? Math.max(i9, this.b3[1]) : Math.min(i9, this.b3[1]);
                    z = true;
                }
            }
        }
        iArr[0] = iArr[0] + i8;
        iArr[1] = iArr[1] + i9;
        if (z) {
            M(1);
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final List<View> getDependencySortedChildren() {
        R();
        return Collections.unmodifiableList(this.s);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final WindowInsetsCompat getLastWindowInsets() {
        return this.k3;
    }

    public int getNestedScrollAxes() {
        return this.p3.a();
    }

    @Nullable
    public Drawable getStatusBarBackground() {
        return this.m3;
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public void k(@NonNull View view) {
        List g2 = this.X2.g(view);
        if (g2 != null && !g2.isEmpty()) {
            for (int i2 = 0; i2 < g2.size(); i2++) {
                View view2 = (View) g2.get(i2);
                Behavior f2 = ((LayoutParams) view2.getLayoutParams()).f();
                if (f2 != null) {
                    f2.p(this, view2, view);
                }
            }
        }
    }

    public boolean l(@NonNull View view, @NonNull View view2) {
        boolean z = false;
        if (view.getVisibility() != 0 || view2.getVisibility() != 0) {
            return false;
        }
        Rect e2 = e();
        v(view, view.getParent() != this, e2);
        Rect e4 = e();
        v(view2, view2.getParent() != this, e4);
        try {
            if (e2.left <= e4.right && e2.top <= e4.bottom && e2.right >= e4.left && e2.bottom >= e4.top) {
                z = true;
            }
            return z;
        } finally {
            T(e2);
            T(e4);
        }
    }

    /* access modifiers changed from: package-private */
    public void m() {
        int childCount = getChildCount();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            } else if (F(getChildAt(i2))) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z == this.j3) {
            return;
        }
        if (z) {
            f();
        } else {
            U();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* renamed from: o */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        V(false);
        if (this.j3) {
            if (this.i3 == null) {
                this.i3 = new OnPreDrawListener();
            }
            getViewTreeObserver().addOnPreDrawListener(this.i3);
        }
        if (this.k3 == null && ViewCompat.W(this)) {
            ViewCompat.B1(this);
        }
        this.e3 = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        V(false);
        if (this.j3 && this.i3 != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.i3);
        }
        View view = this.h3;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.e3 = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.l3 && this.m3 != null) {
            WindowInsetsCompat windowInsetsCompat = this.k3;
            int r = windowInsetsCompat != null ? windowInsetsCompat.r() : 0;
            if (r > 0) {
                this.m3.setBounds(0, 0, getWidth(), r);
                this.m3.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            V(true);
        }
        boolean Q = Q(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            V(true);
        }
        return Q;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i4, int i5, int i6) {
        Behavior f2;
        int c0 = ViewCompat.c0(this);
        int size = this.s.size();
        for (int i7 = 0; i7 < size; i7++) {
            View view = this.s.get(i7);
            if (view.getVisibility() != 8 && ((f2 = ((LayoutParams) view.getLayoutParams()).f()) == null || !f2.t(this, view, c0))) {
                N(view, c0);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x011c, code lost:
        if (r0.u(r30, r20, r11, r21, r23, 0) == false) goto L_0x012c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x011f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r31, int r32) {
        /*
            r30 = this;
            r7 = r30
            r30.R()
            r30.m()
            int r8 = r30.getPaddingLeft()
            int r0 = r30.getPaddingTop()
            int r9 = r30.getPaddingRight()
            int r1 = r30.getPaddingBottom()
            int r10 = androidx.core.view.ViewCompat.c0(r30)
            r2 = 1
            if (r10 != r2) goto L_0x0021
            r12 = 1
            goto L_0x0022
        L_0x0021:
            r12 = 0
        L_0x0022:
            int r13 = android.view.View.MeasureSpec.getMode(r31)
            int r14 = android.view.View.MeasureSpec.getSize(r31)
            int r15 = android.view.View.MeasureSpec.getMode(r32)
            int r16 = android.view.View.MeasureSpec.getSize(r32)
            int r17 = r8 + r9
            int r18 = r0 + r1
            int r0 = r30.getSuggestedMinimumWidth()
            int r1 = r30.getSuggestedMinimumHeight()
            androidx.core.view.WindowInsetsCompat r3 = r7.k3
            if (r3 == 0) goto L_0x004b
            boolean r3 = androidx.core.view.ViewCompat.W(r30)
            if (r3 == 0) goto L_0x004b
            r19 = 1
            goto L_0x004d
        L_0x004b:
            r19 = 0
        L_0x004d:
            java.util.List<android.view.View> r2 = r7.s
            int r6 = r2.size()
            r5 = r0
            r4 = r1
            r2 = 0
            r3 = 0
        L_0x0057:
            if (r3 >= r6) goto L_0x0171
            java.util.List<android.view.View> r0 = r7.s
            java.lang.Object r0 = r0.get(r3)
            r20 = r0
            android.view.View r20 = (android.view.View) r20
            int r0 = r20.getVisibility()
            r1 = 8
            if (r0 != r1) goto L_0x0073
            r22 = r3
            r29 = r6
            r28 = r8
            goto L_0x0169
        L_0x0073:
            android.view.ViewGroup$LayoutParams r0 = r20.getLayoutParams()
            r1 = r0
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r1 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r1
            int r0 = r1.f5081e
            if (r0 < 0) goto L_0x00bc
            if (r13 == 0) goto L_0x00bc
            int r0 = r7.B(r0)
            int r11 = r1.f5079c
            int r11 = Y(r11)
            int r11 = androidx.core.view.GravityCompat.d(r11, r10)
            r11 = r11 & 7
            r22 = r2
            r2 = 3
            if (r11 != r2) goto L_0x0097
            if (r12 == 0) goto L_0x009c
        L_0x0097:
            r2 = 5
            if (r11 != r2) goto L_0x00a8
            if (r12 == 0) goto L_0x00a8
        L_0x009c:
            int r2 = r14 - r9
            int r2 = r2 - r0
            r0 = 0
            int r2 = java.lang.Math.max(r0, r2)
            r21 = r2
            r11 = 0
            goto L_0x00c1
        L_0x00a8:
            if (r11 != r2) goto L_0x00ac
            if (r12 == 0) goto L_0x00b1
        L_0x00ac:
            r2 = 3
            if (r11 != r2) goto L_0x00ba
            if (r12 == 0) goto L_0x00ba
        L_0x00b1:
            int r0 = r0 - r8
            r11 = 0
            int r0 = java.lang.Math.max(r11, r0)
            r21 = r0
            goto L_0x00c1
        L_0x00ba:
            r11 = 0
            goto L_0x00bf
        L_0x00bc:
            r22 = r2
            goto L_0x00ba
        L_0x00bf:
            r21 = 0
        L_0x00c1:
            if (r19 == 0) goto L_0x00f3
            boolean r0 = androidx.core.view.ViewCompat.W(r20)
            if (r0 != 0) goto L_0x00f3
            androidx.core.view.WindowInsetsCompat r0 = r7.k3
            int r0 = r0.p()
            androidx.core.view.WindowInsetsCompat r2 = r7.k3
            int r2 = r2.q()
            int r0 = r0 + r2
            androidx.core.view.WindowInsetsCompat r2 = r7.k3
            int r2 = r2.r()
            androidx.core.view.WindowInsetsCompat r11 = r7.k3
            int r11 = r11.o()
            int r2 = r2 + r11
            int r0 = r14 - r0
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r13)
            int r2 = r16 - r2
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r15)
            r11 = r0
            r23 = r2
            goto L_0x00f7
        L_0x00f3:
            r11 = r31
            r23 = r32
        L_0x00f7:
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r0 = r1.f()
            if (r0 == 0) goto L_0x011f
            r24 = 0
            r2 = r1
            r1 = r30
            r26 = r2
            r25 = r22
            r2 = r20
            r22 = r3
            r3 = r11
            r27 = r4
            r4 = r21
            r28 = r8
            r8 = r5
            r5 = r23
            r29 = r6
            r6 = r24
            boolean r0 = r0.u(r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x0139
            goto L_0x012c
        L_0x011f:
            r26 = r1
            r27 = r4
            r29 = r6
            r28 = r8
            r25 = r22
            r22 = r3
            r8 = r5
        L_0x012c:
            r5 = 0
            r0 = r30
            r1 = r20
            r2 = r11
            r3 = r21
            r4 = r23
            r0.O(r1, r2, r3, r4, r5)
        L_0x0139:
            int r0 = r20.getMeasuredWidth()
            int r0 = r17 + r0
            r1 = r26
            int r2 = r1.leftMargin
            int r0 = r0 + r2
            int r2 = r1.rightMargin
            int r0 = r0 + r2
            int r0 = java.lang.Math.max(r8, r0)
            int r2 = r20.getMeasuredHeight()
            int r2 = r18 + r2
            int r3 = r1.topMargin
            int r2 = r2 + r3
            int r1 = r1.bottomMargin
            int r2 = r2 + r1
            r1 = r27
            int r1 = java.lang.Math.max(r1, r2)
            int r2 = r20.getMeasuredState()
            r11 = r25
            int r2 = android.view.View.combineMeasuredStates(r11, r2)
            r5 = r0
            r4 = r1
        L_0x0169:
            int r3 = r22 + 1
            r8 = r28
            r6 = r29
            goto L_0x0057
        L_0x0171:
            r11 = r2
            r1 = r4
            r8 = r5
            r0 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0 = r0 & r11
            r2 = r31
            int r0 = android.view.View.resolveSizeAndState(r8, r2, r0)
            int r2 = r11 << 16
            r3 = r32
            int r1 = android.view.View.resolveSizeAndState(r1, r3, r2)
            r7.setMeasuredDimension(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    public boolean onNestedFling(View view, float f2, float f4, boolean z) {
        Behavior f5;
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.k(0) && (f5 = layoutParams.f()) != null) {
                    z2 |= f5.v(this, childAt, view, f2, f4, z);
                }
            }
        }
        if (z2) {
            M(1);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f2, float f4) {
        Behavior f5;
        int childCount = getChildCount();
        boolean z = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.k(0) && (f5 = layoutParams.f()) != null) {
                    z |= f5.w(this, childAt, view, f2, f4);
                }
            }
        }
        return z;
    }

    public void onNestedPreScroll(View view, int i2, int i4, int[] iArr) {
        u(view, i2, i4, iArr, 0);
    }

    public void onNestedScroll(View view, int i2, int i4, int i5, int i6) {
        q(view, i2, i4, i5, i6, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        s(view, view2, i2, 0);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        SparseArray<Parcelable> sparseArray = savedState.Y;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            Behavior f2 = D(childAt).f();
            if (!(id == -1 || f2 == null || (parcelable2 = sparseArray.get(id)) == null)) {
                f2.F(this, childAt, parcelable2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable G;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int id = childAt.getId();
            Behavior f2 = ((LayoutParams) childAt.getLayoutParams()).f();
            if (!(id == -1 || f2 == null || (G = f2.G(this, childAt)) == null)) {
                sparseArray.append(id, G);
            }
        }
        savedState.Y = sparseArray;
        return savedState;
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        return r(view, view2, i2, 0);
    }

    public void onStopNestedScroll(View view) {
        t(view, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0012, code lost:
        if (r3 != false) goto L_0x0018;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.g3
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x0017
            boolean r3 = r0.Q(r1, r4)
            if (r3 == 0) goto L_0x0015
            goto L_0x0018
        L_0x0015:
            r6 = 0
            goto L_0x002c
        L_0x0017:
            r3 = 0
        L_0x0018:
            android.view.View r6 = r0.g3
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r6 = r6.f()
            if (r6 == 0) goto L_0x0015
            android.view.View r7 = r0.g3
            boolean r6 = r6.L(r0, r7, r1)
        L_0x002c:
            android.view.View r7 = r0.g3
            r8 = 0
            if (r7 != 0) goto L_0x0037
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L_0x004a
        L_0x0037:
            if (r3 == 0) goto L_0x004a
            long r11 = android.os.SystemClock.uptimeMillis()
            r15 = 0
            r16 = 0
            r13 = 3
            r14 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L_0x004a:
            if (r8 == 0) goto L_0x004f
            r8.recycle()
        L_0x004f:
            if (r2 == r4) goto L_0x0054
            r1 = 3
            if (r2 != r1) goto L_0x0057
        L_0x0054:
            r0.V(r5)
        L_0x0057:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public void q(View view, int i2, int i4, int i5, int i6, int i7) {
        g(view, i2, i4, i5, i6, 0, this.c3);
    }

    public boolean r(View view, View view2, int i2, int i4) {
        int i5 = i4;
        int childCount = getChildCount();
        int i6 = 0;
        boolean z = false;
        while (true) {
            if (i6 >= childCount) {
                return z;
            }
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Behavior f2 = layoutParams.f();
                if (f2 != null) {
                    boolean I = f2.I(this, childAt, view, view2, i2, i4);
                    z |= I;
                    layoutParams.t(i5, I);
                } else {
                    layoutParams.t(i5, false);
                }
            }
            i6++;
        }
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        Behavior f2 = ((LayoutParams) view.getLayoutParams()).f();
        if (f2 == null || !f2.E(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.d3) {
            V(false);
            this.d3 = true;
        }
    }

    public void s(View view, View view2, int i2, int i4) {
        Behavior f2;
        this.p3.c(view, view2, i2, i4);
        this.h3 = view2;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.k(i4) && (f2 = layoutParams.f()) != null) {
                f2.D(this, childAt, view, view2, i2, i4);
            }
        }
    }

    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        c0();
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.n3 = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.m3;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.m3 = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.m3.setState(getDrawableState());
                }
                DrawableCompat.m(this.m3, ViewCompat.c0(this));
                this.m3.setVisible(getVisibility() == 0, false);
                this.m3.setCallback(this);
            }
            ViewCompat.t1(this);
        }
    }

    public void setStatusBarBackgroundColor(@ColorInt int i2) {
        setStatusBarBackground(new ColorDrawable(i2));
    }

    public void setStatusBarBackgroundResource(@DrawableRes int i2) {
        setStatusBarBackground(i2 != 0 ? ContextCompat.l(getContext(), i2) : null);
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.m3;
        if (drawable != null && drawable.isVisible() != z) {
            this.m3.setVisible(z, false);
        }
    }

    public void t(View view, int i2) {
        this.p3.e(view, i2);
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.k(i2)) {
                Behavior f2 = layoutParams.f();
                if (f2 != null) {
                    f2.K(this, childAt, view, i2);
                }
                layoutParams.m(i2);
                layoutParams.l();
            }
        }
        this.h3 = null;
    }

    public void u(View view, int i2, int i4, int[] iArr, int i5) {
        Behavior f2;
        int childCount = getChildCount();
        boolean z = false;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() == 8) {
                int i9 = i5;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.k(i5) && (f2 = layoutParams.f()) != null) {
                    int[] iArr2 = this.b3;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    f2.y(this, childAt, view, i2, i4, iArr2, i5);
                    int[] iArr3 = this.b3;
                    i6 = i2 > 0 ? Math.max(i6, iArr3[0]) : Math.min(i6, iArr3[0]);
                    int[] iArr4 = this.b3;
                    i7 = i4 > 0 ? Math.max(i7, iArr4[1]) : Math.min(i7, iArr4[1]);
                    z = true;
                }
            }
        }
        iArr[0] = i6;
        iArr[1] = i7;
        if (z) {
            M(1);
        }
    }

    /* access modifiers changed from: package-private */
    public void v(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            y(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.m3;
    }

    @NonNull
    public List<View> w(@NonNull View view) {
        List<View> h2 = this.X2.h(view);
        this.Z2.clear();
        if (h2 != null) {
            this.Z2.addAll(h2);
        }
        return this.Z2;
    }

    @NonNull
    public List<View> x(@NonNull View view) {
        List g2 = this.X2.g(view);
        this.Z2.clear();
        if (g2 != null) {
            this.Z2.addAll(g2);
        }
        return this.Z2;
    }

    /* access modifiers changed from: package-private */
    public void y(View view, Rect rect) {
        ViewGroupUtils.a(this, view, rect);
    }

    /* access modifiers changed from: package-private */
    public void z(View view, int i2, Rect rect, Rect rect2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        A(view, i2, rect, rect2, layoutParams, measuredWidth, measuredHeight);
        i(layoutParams, rect2, measuredWidth, measuredHeight);
    }

    public CoordinatorLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f4988b);
    }

    public CoordinatorLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2);
        this.s = new ArrayList();
        this.X2 = new DirectedAcyclicGraph<>();
        this.Y2 = new ArrayList();
        this.Z2 = new ArrayList();
        this.b3 = new int[2];
        this.c3 = new int[2];
        this.p3 = new NestedScrollingParentHelper(this);
        int[] iArr = R.styleable.f5068g;
        TypedArray obtainStyledAttributes = i2 == 0 ? context.obtainStyledAttributes(attributeSet, iArr, 0, R.style.f5061h) : context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            int[] iArr2 = R.styleable.f5068g;
            if (i2 == 0) {
                saveAttributeDataForStyleable(context, iArr2, attributeSet, obtainStyledAttributes, 0, R.style.f5061h);
            } else {
                saveAttributeDataForStyleable(context, iArr2, attributeSet, obtainStyledAttributes, i2, 0);
            }
        }
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.f5069h, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f3 = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.f3.length;
            for (int i4 = 0; i4 < length; i4++) {
                int[] iArr3 = this.f3;
                iArr3[i4] = (int) (((float) iArr3[i4]) * f2);
            }
        }
        this.m3 = obtainStyledAttributes.getDrawable(R.styleable.f5070i);
        obtainStyledAttributes.recycle();
        c0();
        super.setOnHierarchyChangeListener(new HierarchyChangeListener());
        if (ViewCompat.X(this) == 0) {
            ViewCompat.Z1(this, 1);
        }
    }
}
