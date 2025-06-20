package androidx.viewpager2.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.R;
import androidx.viewpager2.adapter.StatefulAdapter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ViewPager2 extends ViewGroup {
    public static final int q3 = 0;
    public static final int r3 = 1;
    public static final int s3 = 0;
    public static final int t3 = 1;
    public static final int u3 = 2;
    public static final int v3 = -1;
    static boolean w3 = true;
    private final Rect X2 = new Rect();
    private CompositeOnPageChangeCallback Y2 = new CompositeOnPageChangeCallback(3);
    int Z2;
    boolean a3 = false;
    private RecyclerView.AdapterDataObserver b3 = new DataSetChangeObserver() {
        public void a() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.a3 = true;
            viewPager2.h3.n();
        }
    };
    LinearLayoutManager c3;
    private int d3 = -1;
    private Parcelable e3;
    RecyclerView f3;
    private PagerSnapHelper g3;
    ScrollEventAdapter h3;
    private CompositeOnPageChangeCallback i3;
    private FakeDrag j3;
    private PageTransformerAdapter k3;
    private RecyclerView.ItemAnimator l3 = null;
    private boolean m3 = false;
    private boolean n3 = true;
    private int o3 = -1;
    AccessibilityProvider p3;
    private final Rect s = new Rect();

    private abstract class AccessibilityProvider {
        private AccessibilityProvider() {
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean b(int i2) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean c(int i2, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void e(@Nullable RecyclerView.Adapter<?> adapter) {
        }

        /* access modifiers changed from: package-private */
        public void f(@Nullable RecyclerView.Adapter<?> adapter) {
        }

        /* access modifiers changed from: package-private */
        public String g() {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public void h(@NonNull CompositeOnPageChangeCallback compositeOnPageChangeCallback, @NonNull RecyclerView recyclerView) {
        }

        /* access modifiers changed from: package-private */
        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        /* access modifiers changed from: package-private */
        public void j(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        /* access modifiers changed from: package-private */
        public void k(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        /* access modifiers changed from: package-private */
        public boolean l(int i2) {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public boolean m(int i2, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public void n() {
        }

        /* access modifiers changed from: package-private */
        public CharSequence o() {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        public void p(@NonNull AccessibilityEvent accessibilityEvent) {
        }

        /* access modifiers changed from: package-private */
        public void q() {
        }

        /* access modifiers changed from: package-private */
        public void r() {
        }

        /* access modifiers changed from: package-private */
        public void s() {
        }

        /* access modifiers changed from: package-private */
        public void t() {
        }
    }

    class BasicAccessibilityProvider extends AccessibilityProvider {
        BasicAccessibilityProvider() {
            super();
        }

        public boolean b(int i2) {
            return (i2 == 8192 || i2 == 4096) && !ViewPager2.this.l();
        }

        public boolean d() {
            return true;
        }

        public void j(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (!ViewPager2.this.l()) {
                accessibilityNodeInfoCompat.V0(AccessibilityNodeInfoCompat.AccessibilityActionCompat.s);
                accessibilityNodeInfoCompat.V0(AccessibilityNodeInfoCompat.AccessibilityActionCompat.r);
                accessibilityNodeInfoCompat.X1(false);
            }
        }

        public boolean l(int i2) {
            if (b(i2)) {
                return false;
            }
            throw new IllegalStateException();
        }

        public CharSequence o() {
            if (d()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    private static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        private DataSetChangeObserver() {
        }

        public abstract void a();

        public final void b(int i2, int i3) {
            a();
        }

        public final void c(int i2, int i3, @Nullable Object obj) {
            a();
        }

        public final void d(int i2, int i3) {
            a();
        }

        public final void e(int i2, int i3, int i4) {
            a();
        }

        public final void f(int i2, int i3) {
            a();
        }
    }

    private class LinearLayoutManagerImpl extends LinearLayoutManager {
        LinearLayoutManagerImpl(Context context) {
            super(context);
        }

        public boolean C1(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, int i2, @Nullable Bundle bundle) {
            return ViewPager2.this.p3.b(i2) ? ViewPager2.this.p3.l(i2) : super.C1(recycler, state, i2, bundle);
        }

        public boolean Q1(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z, boolean z2) {
            return false;
        }

        public void i1(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.i1(recycler, state, accessibilityNodeInfoCompat);
            ViewPager2.this.p3.j(accessibilityNodeInfoCompat);
        }

        public void k1(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, @NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewPager2.this.p3.k(view, accessibilityNodeInfoCompat);
        }

        /* access modifiers changed from: protected */
        public void o2(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.o2(state, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @IntRange(from = 1)
    @Retention(RetentionPolicy.SOURCE)
    public @interface OffscreenPageLimit {
    }

    public static abstract class OnPageChangeCallback {
        public void a(int i2) {
        }

        public void b(int i2, float f2, @Px int i3) {
        }

        public void c(int i2) {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    class PageAwareAccessibilityProvider extends AccessibilityProvider {

        /* renamed from: b  reason: collision with root package name */
        private final AccessibilityViewCommand f16595b = new AccessibilityViewCommand() {
            public boolean a(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                PageAwareAccessibilityProvider.this.x(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        };

        /* renamed from: c  reason: collision with root package name */
        private final AccessibilityViewCommand f16596c = new AccessibilityViewCommand() {
            public boolean a(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                PageAwareAccessibilityProvider.this.x(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        };

        /* renamed from: d  reason: collision with root package name */
        private RecyclerView.AdapterDataObserver f16597d;

        PageAwareAccessibilityProvider() {
            super();
        }

        private void u(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int i2;
            int i3;
            if (ViewPager2.this.getAdapter() != null) {
                i2 = 1;
                if (ViewPager2.this.getOrientation() == 1) {
                    i2 = ViewPager2.this.getAdapter().b();
                    i3 = 1;
                } else {
                    i3 = ViewPager2.this.getAdapter().b();
                }
            } else {
                i3 = 0;
                i2 = 0;
            }
            accessibilityNodeInfoCompat.l1(AccessibilityNodeInfoCompat.CollectionInfoCompat.f(i2, i3, false, 0));
        }

        private void v(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.m1(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.j(ViewPager2.this.getOrientation() == 1 ? ViewPager2.this.c3.w0(view) : 0, 1, ViewPager2.this.getOrientation() == 0 ? ViewPager2.this.c3.w0(view) : 0, 1, false, false));
        }

        private void w(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int b2;
            RecyclerView.Adapter adapter = ViewPager2.this.getAdapter();
            if (adapter != null && (b2 = adapter.b()) != 0 && ViewPager2.this.l()) {
                if (ViewPager2.this.Z2 > 0) {
                    accessibilityNodeInfoCompat.a(8192);
                }
                if (ViewPager2.this.Z2 < b2 - 1) {
                    accessibilityNodeInfoCompat.a(4096);
                }
                accessibilityNodeInfoCompat.X1(true);
            }
        }

        public boolean a() {
            return true;
        }

        public boolean c(int i2, Bundle bundle) {
            return i2 == 8192 || i2 == 4096;
        }

        public void e(@Nullable RecyclerView.Adapter<?> adapter) {
            y();
            if (adapter != null) {
                adapter.Z(this.f16597d);
            }
        }

        public void f(@Nullable RecyclerView.Adapter<?> adapter) {
            if (adapter != null) {
                adapter.c0(this.f16597d);
            }
        }

        public String g() {
            if (a()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        public void h(@NonNull CompositeOnPageChangeCallback compositeOnPageChangeCallback, @NonNull RecyclerView recyclerView) {
            ViewCompat.Z1(recyclerView, 2);
            this.f16597d = new DataSetChangeObserver() {
                public void a() {
                    PageAwareAccessibilityProvider.this.y();
                }
            };
            if (ViewCompat.X(ViewPager2.this) == 0) {
                ViewCompat.Z1(ViewPager2.this, 1);
            }
        }

        public void i(AccessibilityNodeInfo accessibilityNodeInfo) {
            AccessibilityNodeInfoCompat r2 = AccessibilityNodeInfoCompat.r2(accessibilityNodeInfo);
            u(r2);
            w(r2);
        }

        /* access modifiers changed from: package-private */
        public void k(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            v(view, accessibilityNodeInfoCompat);
        }

        public boolean m(int i2, Bundle bundle) {
            if (c(i2, bundle)) {
                x(i2 == 8192 ? ViewPager2.this.getCurrentItem() - 1 : ViewPager2.this.getCurrentItem() + 1);
                return true;
            }
            throw new IllegalStateException();
        }

        public void n() {
            y();
        }

        public void p(@NonNull AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(g());
        }

        public void q() {
            y();
        }

        public void r() {
            y();
        }

        public void s() {
            y();
        }

        public void t() {
            y();
        }

        /* access modifiers changed from: package-private */
        public void x(int i2) {
            if (ViewPager2.this.l()) {
                ViewPager2.this.t(i2, true);
            }
        }

        /* access modifiers changed from: package-private */
        public void y() {
            int b2;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i2 = 16908360;
            ViewCompat.x1(viewPager2, 16908360);
            ViewCompat.x1(viewPager2, 16908361);
            ViewCompat.x1(viewPager2, 16908358);
            ViewCompat.x1(viewPager2, 16908359);
            if (ViewPager2.this.getAdapter() != null && (b2 = ViewPager2.this.getAdapter().b()) != 0 && ViewPager2.this.l()) {
                if (ViewPager2.this.getOrientation() == 0) {
                    boolean k2 = ViewPager2.this.k();
                    int i3 = k2 ? 16908360 : 16908361;
                    if (k2) {
                        i2 = 16908361;
                    }
                    if (ViewPager2.this.Z2 < b2 - 1) {
                        ViewCompat.A1(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i3, (CharSequence) null), (CharSequence) null, this.f16595b);
                    }
                    if (ViewPager2.this.Z2 > 0) {
                        ViewCompat.A1(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i2, (CharSequence) null), (CharSequence) null, this.f16596c);
                        return;
                    }
                    return;
                }
                if (ViewPager2.this.Z2 < b2 - 1) {
                    ViewCompat.A1(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908359, (CharSequence) null), (CharSequence) null, this.f16595b);
                }
                if (ViewPager2.this.Z2 > 0) {
                    ViewCompat.A1(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908358, (CharSequence) null), (CharSequence) null, this.f16596c);
                }
            }
        }
    }

    public interface PageTransformer {
        void a(@NonNull View view, float f2);
    }

    private class PagerSnapHelperImpl extends PagerSnapHelper {
        PagerSnapHelperImpl() {
        }

        @Nullable
        public View h(RecyclerView.LayoutManager layoutManager) {
            if (ViewPager2.this.j()) {
                return null;
            }
            return super.h(layoutManager);
        }
    }

    private class RecyclerViewImpl extends RecyclerView {
        RecyclerViewImpl(@NonNull Context context) {
            super(context);
        }

        @RequiresApi(23)
        public CharSequence getAccessibilityClassName() {
            return ViewPager2.this.p3.d() ? ViewPager2.this.p3.o() : super.getAccessibilityClassName();
        }

        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.Z2);
            accessibilityEvent.setToIndex(ViewPager2.this.Z2);
            ViewPager2.this.p3.p(accessibilityEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.l() && super.onInterceptTouchEvent(motionEvent);
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.l() && super.onTouchEvent(motionEvent);
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return Build.VERSION.SDK_INT >= 24 ? new SavedState(parcel, classLoader) : new SavedState(parcel);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        int X;
        Parcelable Y;
        int s;

        SavedState(Parcel parcel) {
            super(parcel);
            a(parcel, (ClassLoader) null);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.s = parcel.readInt();
            this.X = parcel.readInt();
            this.Y = parcel.readParcelable(classLoader);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.s);
            parcel.writeInt(this.X);
            parcel.writeParcelable(this.Y, i2);
        }

        @RequiresApi(24)
        @SuppressLint({"ClassVerificationFailure"})
        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollState {
    }

    private static class SmoothScrollToPosition implements Runnable {
        private final RecyclerView X;
        private final int s;

        SmoothScrollToPosition(int i2, RecyclerView recyclerView) {
            this.s = i2;
            this.X = recyclerView;
        }

        public void run() {
            this.X.X1(this.s);
        }
    }

    public ViewPager2(@NonNull Context context) {
        super(context);
        h(context, (AttributeSet) null);
    }

    private RecyclerView.OnChildAttachStateChangeListener e() {
        return new RecyclerView.OnChildAttachStateChangeListener() {
            public void b(@NonNull View view) {
            }

            public void d(@NonNull View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (layoutParams.width != -1 || layoutParams.height != -1) {
                    throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
                }
            }
        };
    }

    private void h(Context context, AttributeSet attributeSet) {
        this.p3 = w3 ? new PageAwareAccessibilityProvider() : new BasicAccessibilityProvider();
        RecyclerViewImpl recyclerViewImpl = new RecyclerViewImpl(context);
        this.f3 = recyclerViewImpl;
        recyclerViewImpl.setId(ViewCompat.D());
        this.f3.setDescendantFocusability(131072);
        LinearLayoutManagerImpl linearLayoutManagerImpl = new LinearLayoutManagerImpl(context);
        this.c3 = linearLayoutManagerImpl;
        this.f3.setLayoutManager(linearLayoutManagerImpl);
        this.f3.setScrollingTouchSlop(1);
        u(context, attributeSet);
        this.f3.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f3.r(e());
        ScrollEventAdapter scrollEventAdapter = new ScrollEventAdapter(this);
        this.h3 = scrollEventAdapter;
        this.j3 = new FakeDrag(this, scrollEventAdapter, this.f3);
        PagerSnapHelperImpl pagerSnapHelperImpl = new PagerSnapHelperImpl();
        this.g3 = pagerSnapHelperImpl;
        pagerSnapHelperImpl.b(this.f3);
        this.f3.t(this.h3);
        CompositeOnPageChangeCallback compositeOnPageChangeCallback = new CompositeOnPageChangeCallback(3);
        this.i3 = compositeOnPageChangeCallback;
        this.h3.r(compositeOnPageChangeCallback);
        AnonymousClass2 r32 = new OnPageChangeCallback() {
            public void a(int i2) {
                if (i2 == 0) {
                    ViewPager2.this.y();
                }
            }

            public void c(int i2) {
                ViewPager2 viewPager2 = ViewPager2.this;
                if (viewPager2.Z2 != i2) {
                    viewPager2.Z2 = i2;
                    viewPager2.p3.r();
                }
            }
        };
        AnonymousClass3 r4 = new OnPageChangeCallback() {
            public void c(int i2) {
                ViewPager2.this.clearFocus();
                if (ViewPager2.this.hasFocus()) {
                    ViewPager2.this.f3.requestFocus(2);
                }
            }
        };
        this.i3.d(r32);
        this.i3.d(r4);
        this.p3.h(this.i3, this.f3);
        this.i3.d(this.Y2);
        PageTransformerAdapter pageTransformerAdapter = new PageTransformerAdapter(this.c3);
        this.k3 = pageTransformerAdapter;
        this.i3.d(pageTransformerAdapter);
        RecyclerView recyclerView = this.f3;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    private void m(@Nullable RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.Z(this.b3);
        }
    }

    private void r() {
        RecyclerView.Adapter adapter;
        if (this.d3 != -1 && (adapter = getAdapter()) != null) {
            Parcelable parcelable = this.e3;
            if (parcelable != null) {
                if (adapter instanceof StatefulAdapter) {
                    ((StatefulAdapter) adapter).d(parcelable);
                }
                this.e3 = null;
            }
            int max = Math.max(0, Math.min(this.d3, adapter.b() - 1));
            this.Z2 = max;
            this.d3 = -1;
            this.f3.O1(max);
            this.p3.n();
        }
    }

    private void u(Context context, AttributeSet attributeSet) {
        int[] iArr = R.styleable.f16531a;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        ViewCompat.F1(this, context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        try {
            setOrientation(obtainStyledAttributes.getInt(R.styleable.f16532b, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void w(@Nullable RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.c0(this.b3);
        }
    }

    public void a(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        this.f3.setItemDecoration(itemDecoration);
    }

    public void b(@NonNull RecyclerView.ItemDecoration itemDecoration, int i2) {
        this.f3.q(itemDecoration, i2);
    }

    public boolean c() {
        return this.j3.b();
    }

    public boolean canScrollHorizontally(int i2) {
        return this.f3.canScrollHorizontally(i2);
    }

    public boolean canScrollVertically(int i2) {
        return this.f3.canScrollVertically(i2);
    }

    public boolean d() {
        return this.j3.d();
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i2 = ((SavedState) parcelable).s;
            sparseArray.put(this.f3.getId(), sparseArray.get(i2));
            sparseArray.remove(i2);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        r();
    }

    public boolean f(@Px @SuppressLint({"SupportAnnotationUsage"}) float f2) {
        return this.j3.e(f2);
    }

    @NonNull
    public RecyclerView.ItemDecoration g(int i2) {
        return this.f3.F0(i2);
    }

    @RequiresApi(23)
    public CharSequence getAccessibilityClassName() {
        return this.p3.a() ? this.p3.g() : super.getAccessibilityClassName();
    }

    @Nullable
    public RecyclerView.Adapter getAdapter() {
        return this.f3.getAdapter();
    }

    public int getCurrentItem() {
        return this.Z2;
    }

    public int getItemDecorationCount() {
        return this.f3.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.o3;
    }

    public int getOrientation() {
        return this.c3.Q2() == 1 ? 1 : 0;
    }

    /* access modifiers changed from: package-private */
    public int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.f3;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.h3.h();
    }

    public void i() {
        this.f3.Q0();
    }

    public boolean j() {
        return this.j3.f();
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return this.c3.m0() == 1;
    }

    public boolean l() {
        return this.n3;
    }

    public void n(@NonNull OnPageChangeCallback onPageChangeCallback) {
        this.Y2.d(onPageChangeCallback);
    }

    public void o(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        this.f3.A1(itemDecoration);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.p3.i(accessibilityNodeInfo);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i4, int i5, int i6) {
        int measuredWidth = this.f3.getMeasuredWidth();
        int measuredHeight = this.f3.getMeasuredHeight();
        this.s.left = getPaddingLeft();
        this.s.right = (i5 - i2) - getPaddingRight();
        this.s.top = getPaddingTop();
        this.s.bottom = (i6 - i4) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.s, this.X2);
        RecyclerView recyclerView = this.f3;
        Rect rect = this.X2;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.a3) {
            y();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i4) {
        measureChild(this.f3, i2, i4);
        int measuredWidth = this.f3.getMeasuredWidth();
        int measuredHeight = this.f3.getMeasuredHeight();
        int measuredState = this.f3.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i2, measuredState), View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i4, measuredState << 16));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.d3 = savedState.X;
        this.e3 = savedState.Y;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.s = this.f3.getId();
        int i2 = this.d3;
        if (i2 == -1) {
            i2 = this.Z2;
        }
        savedState.X = i2;
        Parcelable parcelable = this.e3;
        if (parcelable == null) {
            RecyclerView.Adapter adapter = this.f3.getAdapter();
            if (adapter instanceof StatefulAdapter) {
                parcelable = ((StatefulAdapter) adapter).a();
            }
            return savedState;
        }
        savedState.Y = parcelable;
        return savedState;
    }

    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    public void p(int i2) {
        this.f3.B1(i2);
    }

    @RequiresApi(16)
    public boolean performAccessibilityAction(int i2, @Nullable Bundle bundle) {
        return this.p3.c(i2, bundle) ? this.p3.m(i2, bundle) : super.performAccessibilityAction(i2, bundle);
    }

    public void q() {
        if (this.k3.d() != null) {
            double g2 = this.h3.g();
            int i2 = (int) g2;
            float f2 = (float) (g2 - ((double) i2));
            this.k3.b(i2, f2, Math.round(((float) getPageSize()) * f2));
        }
    }

    public void s(int i2, boolean z) {
        if (!j()) {
            t(i2, z);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.f3.getAdapter();
        this.p3.f(adapter2);
        w(adapter2);
        this.f3.setAdapter(adapter);
        this.Z2 = 0;
        r();
        this.p3.e(adapter);
        m(adapter);
    }

    public void setCurrentItem(int i2) {
        s(i2, true);
    }

    @RequiresApi(17)
    public void setLayoutDirection(int i2) {
        super.setLayoutDirection(i2);
        this.p3.q();
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 >= 1 || i2 == -1) {
            this.o3 = i2;
            this.f3.requestLayout();
            return;
        }
        throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }

    public void setOrientation(int i2) {
        this.c3.j3(i2);
        this.p3.s();
    }

    public void setPageTransformer(@Nullable PageTransformer pageTransformer) {
        boolean z = this.m3;
        if (pageTransformer != null) {
            if (!z) {
                this.l3 = this.f3.getItemAnimator();
                this.m3 = true;
            }
            this.f3.setItemAnimator((RecyclerView.ItemAnimator) null);
        } else if (z) {
            this.f3.setItemAnimator(this.l3);
            this.l3 = null;
            this.m3 = false;
        }
        if (pageTransformer != this.k3.d()) {
            this.k3.e(pageTransformer);
            q();
        }
    }

    public void setUserInputEnabled(boolean z) {
        this.n3 = z;
        this.p3.t();
    }

    /* access modifiers changed from: package-private */
    public void t(int i2, boolean z) {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            if (this.d3 != -1) {
                this.d3 = Math.max(i2, 0);
            }
        } else if (adapter.b() > 0) {
            int min = Math.min(Math.max(i2, 0), adapter.b() - 1);
            if (min != this.Z2 || !this.h3.k()) {
                int i4 = this.Z2;
                if (min != i4 || !z) {
                    double d2 = (double) i4;
                    this.Z2 = min;
                    this.p3.r();
                    if (!this.h3.k()) {
                        d2 = this.h3.g();
                    }
                    this.h3.p(min, z);
                    if (!z) {
                        this.f3.O1(min);
                        return;
                    }
                    double d4 = (double) min;
                    if (Math.abs(d4 - d2) > 3.0d) {
                        this.f3.O1(d4 > d2 ? min - 3 : min + 3);
                        RecyclerView recyclerView = this.f3;
                        recyclerView.post(new SmoothScrollToPosition(min, recyclerView));
                        return;
                    }
                    this.f3.X1(min);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void v() {
        View h2 = this.g3.h(this.c3);
        if (h2 != null) {
            int[] c2 = this.g3.c(this.c3, h2);
            int i2 = c2[0];
            if (i2 != 0 || c2[1] != 0) {
                this.f3.T1(i2, c2[1]);
            }
        }
    }

    public void x(@NonNull OnPageChangeCallback onPageChangeCallback) {
        this.Y2.e(onPageChangeCallback);
    }

    /* access modifiers changed from: package-private */
    public void y() {
        PagerSnapHelper pagerSnapHelper = this.g3;
        if (pagerSnapHelper != null) {
            View h2 = pagerSnapHelper.h(this.c3);
            if (h2 != null) {
                int w0 = this.c3.w0(h2);
                if (w0 != this.Z2 && getScrollState() == 0) {
                    this.i3.c(w0);
                }
                this.a3 = false;
                return;
            }
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        h(context, attributeSet);
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        h(context, attributeSet);
    }

    @RequiresApi(21)
    @SuppressLint({"ClassVerificationFailure"})
    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i4) {
        super(context, attributeSet, i2, i4);
        h(context, attributeSet);
    }
}
