package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    private static final String b4 = "ViewPager";
    private static final boolean c4 = false;
    private static final boolean d4 = false;
    private static final int e4 = 1;
    private static final int f4 = 600;
    private static final int g4 = 25;
    private static final int h4 = 16;
    private static final int i4 = 400;
    static final int[] j4 = {16842931};
    private static final Comparator<ItemInfo> k4 = new Comparator<ItemInfo>() {
        /* renamed from: a */
        public int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
            return itemInfo.f16519b - itemInfo2.f16519b;
        }
    };
    private static final Interpolator l4 = new Interpolator() {
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    private static final int m4 = -1;
    private static final int n4 = 2;
    private static final int o4 = 0;
    private static final int p4 = 1;
    private static final int q4 = 2;
    private static final ViewPositionComparator r4 = new ViewPositionComparator();
    public static final int s4 = 0;
    public static final int t4 = 1;
    public static final int u4 = 2;
    private float A3;
    private float B3;
    private float C3;
    private int D3 = -1;
    private VelocityTracker E3;
    private int F3;
    private int G3;
    private int H3;
    private int I3;
    private boolean J3;
    private long K3;
    private EdgeEffect L3;
    private EdgeEffect M3;
    private boolean N3 = true;
    private boolean O3 = false;
    private boolean P3;
    private int Q3;
    private List<OnPageChangeListener> R3;
    private OnPageChangeListener S3;
    private OnPageChangeListener T3;
    private List<OnAdapterChangeListener> U3;
    private PageTransformer V3;
    private int W3;
    private final ArrayList<ItemInfo> X2 = new ArrayList<>();
    private int X3;
    private final ItemInfo Y2 = new ItemInfo();
    private ArrayList<View> Y3;
    private final Rect Z2 = new Rect();
    private final Runnable Z3 = new Runnable() {
        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.J();
        }
    };
    PagerAdapter a3;
    private int a4 = 0;
    int b3;
    private int c3 = -1;
    private Parcelable d3 = null;
    private ClassLoader e3 = null;
    private Scroller f3;
    private boolean g3;
    private PagerObserver h3;
    private int i3;
    private Drawable j3;
    private int k3;
    private int l3;
    private float m3 = -3.4028235E38f;
    private float n3 = Float.MAX_VALUE;
    private int o3;
    private int p3;
    private boolean q3;
    private boolean r3;
    private int s;
    private boolean s3;
    private int t3 = 1;
    private boolean u3;
    private boolean v3;
    private int w3;
    private int x3;
    private int y3;
    private float z3;

    @Inherited
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DecorView {
    }

    static class ItemInfo {

        /* renamed from: a  reason: collision with root package name */
        Object f16518a;

        /* renamed from: b  reason: collision with root package name */
        int f16519b;

        /* renamed from: c  reason: collision with root package name */
        boolean f16520c;

        /* renamed from: d  reason: collision with root package name */
        float f16521d;

        /* renamed from: e  reason: collision with root package name */
        float f16522e;

        ItemInfo() {
        }
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f16523a;

        /* renamed from: b  reason: collision with root package name */
        public int f16524b;

        /* renamed from: c  reason: collision with root package name */
        float f16525c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        boolean f16526d;

        /* renamed from: e  reason: collision with root package name */
        int f16527e;

        /* renamed from: f  reason: collision with root package name */
        int f16528f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.j4);
            this.f16524b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        MyAccessibilityDelegate() {
        }

        private boolean n() {
            PagerAdapter pagerAdapter = ViewPager.this.a3;
            return pagerAdapter != null && pagerAdapter.e() > 1;
        }

        public void f(View view, AccessibilityEvent accessibilityEvent) {
            PagerAdapter pagerAdapter;
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(n());
            if (accessibilityEvent.getEventType() == 4096 && (pagerAdapter = ViewPager.this.a3) != null) {
                accessibilityEvent.setItemCount(pagerAdapter.e());
                accessibilityEvent.setFromIndex(ViewPager.this.b3);
                accessibilityEvent.setToIndex(ViewPager.this.b3);
            }
        }

        public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.g(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.j1(ViewPager.class.getName());
            accessibilityNodeInfoCompat.X1(n());
            if (ViewPager.this.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.a(8192);
            }
        }

        public boolean j(View view, int i2, Bundle bundle) {
            ViewPager viewPager;
            int i3;
            if (super.j(view, i2, bundle)) {
                return true;
            }
            if (i2 != 4096) {
                if (i2 != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                viewPager = ViewPager.this;
                i3 = viewPager.b3 - 1;
            } else if (!ViewPager.this.canScrollHorizontally(1)) {
                return false;
            } else {
                viewPager = ViewPager.this;
                i3 = viewPager.b3 + 1;
            }
            viewPager.setCurrentItem(i3);
            return true;
        }
    }

    public interface OnAdapterChangeListener {
        void b(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2);
    }

    public interface OnPageChangeListener {
        void a(int i2, float f2, @Px int i3);

        void c(int i2);

        void d(int i2);
    }

    public interface PageTransformer {
        void a(@NonNull View view, float f2);
    }

    private class PagerObserver extends DataSetObserver {
        PagerObserver() {
        }

        public void onChanged() {
            ViewPager.this.j();
        }

        public void onInvalidated() {
            ViewPager.this.j();
        }
    }

    public static class SavedState extends AbsSavedState {
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
        ClassLoader X2;
        int Y;
        Parcelable Z;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.Y = parcel.readInt();
            this.Z = parcel.readParcelable(classLoader);
            this.X2 = classLoader;
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.Y + "}";
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.Y);
            parcel.writeParcelable(this.Z, i2);
        }

        public SavedState(@NonNull Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        public void a(int i2, float f2, int i3) {
        }

        public void c(int i2) {
        }

        public void d(int i2) {
        }
    }

    static class ViewPositionComparator implements Comparator<View> {
        ViewPositionComparator() {
        }

        /* renamed from: a */
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z = layoutParams.f16523a;
            if (z != layoutParams2.f16523a) {
                return z ? 1 : -1;
            }
            return layoutParams.f16527e - layoutParams2.f16527e;
        }
    }

    public ViewPager(@NonNull Context context) {
        super(context);
        z();
    }

    private static boolean A(@NonNull View view) {
        return view.getClass().getAnnotation(DecorView.class) != null;
    }

    private boolean C(float f2, float f5) {
        return (f2 < ((float) this.x3) && f5 > 0.0f) || (f2 > ((float) (getWidth() - this.x3)) && f5 < 0.0f);
    }

    private void E(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.D3) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.z3 = motionEvent.getX(i2);
            this.D3 = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.E3;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private boolean H(int i2) {
        if (this.X2.size() != 0) {
            ItemInfo x = x();
            int clientWidth = getClientWidth();
            int i5 = this.i3;
            int i6 = clientWidth + i5;
            float f2 = (float) clientWidth;
            int i7 = x.f16519b;
            float f5 = ((((float) i2) / f2) - x.f16522e) / (x.f16521d + (((float) i5) / f2));
            this.P3 = false;
            D(i7, f5, (int) (((float) i6) * f5));
            if (this.P3) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.N3) {
            return false;
        } else {
            this.P3 = false;
            D(0, 0.0f, 0);
            if (this.P3) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    private boolean I(float f2) {
        boolean z;
        boolean z2;
        float f5 = this.z3 - f2;
        this.z3 = f2;
        float scrollX = ((float) getScrollX()) + f5;
        float clientWidth = (float) getClientWidth();
        float f6 = this.m3 * clientWidth;
        float f7 = this.n3 * clientWidth;
        boolean z4 = false;
        ItemInfo itemInfo = this.X2.get(0);
        ArrayList<ItemInfo> arrayList = this.X2;
        ItemInfo itemInfo2 = arrayList.get(arrayList.size() - 1);
        if (itemInfo.f16519b != 0) {
            f6 = itemInfo.f16522e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (itemInfo2.f16519b != this.a3.e() - 1) {
            f7 = itemInfo2.f16522e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f6) {
            if (z) {
                this.L3.onPull(Math.abs(f6 - scrollX) / clientWidth);
                z4 = true;
            }
            scrollX = f6;
        } else if (scrollX > f7) {
            if (z2) {
                this.M3.onPull(Math.abs(scrollX - f7) / clientWidth);
                z4 = true;
            }
            scrollX = f7;
        }
        int i2 = (int) scrollX;
        this.z3 += scrollX - ((float) i2);
        scrollTo(i2, getScrollY());
        H(i2);
        return z4;
    }

    private void L(int i2, int i5, int i6, int i7) {
        int min;
        if (i5 <= 0 || this.X2.isEmpty()) {
            ItemInfo y = y(this.b3);
            min = (int) ((y != null ? Math.min(y.f16522e, this.n3) : 0.0f) * ((float) ((i2 - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                i(false);
            } else {
                return;
            }
        } else if (!this.f3.isFinished()) {
            this.f3.setFinalX(getCurrentItem() * getClientWidth());
            return;
        } else {
            min = (int) ((((float) getScrollX()) / ((float) (((i5 - getPaddingLeft()) - getPaddingRight()) + i7))) * ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i6)));
        }
        scrollTo(min, getScrollY());
    }

    private void M() {
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (!((LayoutParams) getChildAt(i2).getLayoutParams()).f16523a) {
                removeViewAt(i2);
                i2--;
            }
            i2++;
        }
    }

    private void P(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean Q() {
        this.D3 = -1;
        q();
        this.L3.onRelease();
        this.M3.onRelease();
        return this.L3.isFinished() || this.M3.isFinished();
    }

    private void R(int i2, boolean z, int i5, boolean z2) {
        ItemInfo y = y(i2);
        int clientWidth = y != null ? (int) (((float) getClientWidth()) * Math.max(this.m3, Math.min(y.f16522e, this.n3))) : 0;
        if (z) {
            Z(clientWidth, 0, i5);
            if (z2) {
                m(i2);
                return;
            }
            return;
        }
        if (z2) {
            m(i2);
        }
        i(false);
        scrollTo(clientWidth, 0);
        H(clientWidth);
    }

    private void a0() {
        if (this.X3 != 0) {
            ArrayList<View> arrayList = this.Y3;
            if (arrayList == null) {
                this.Y3 = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.Y3.add(getChildAt(i2));
            }
            Collections.sort(this.Y3, r4);
        }
    }

    private void f(ItemInfo itemInfo, int i2, ItemInfo itemInfo2) {
        int i5;
        int i6;
        ItemInfo itemInfo3;
        ItemInfo itemInfo4;
        int e2 = this.a3.e();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? ((float) this.i3) / ((float) clientWidth) : 0.0f;
        if (itemInfo2 != null) {
            int i7 = itemInfo2.f16519b;
            int i8 = itemInfo.f16519b;
            if (i7 < i8) {
                float f5 = itemInfo2.f16522e + itemInfo2.f16521d + f2;
                int i9 = i7 + 1;
                int i10 = 0;
                while (i9 <= itemInfo.f16519b && i10 < this.X2.size()) {
                    while (true) {
                        itemInfo4 = this.X2.get(i10);
                        if (i9 > itemInfo4.f16519b && i10 < this.X2.size() - 1) {
                            i10++;
                        }
                    }
                    while (i9 < itemInfo4.f16519b) {
                        f5 += this.a3.h(i9) + f2;
                        i9++;
                    }
                    itemInfo4.f16522e = f5;
                    f5 += itemInfo4.f16521d + f2;
                    i9++;
                }
            } else if (i7 > i8) {
                int size = this.X2.size() - 1;
                float f6 = itemInfo2.f16522e;
                while (true) {
                    i7--;
                    if (i7 < itemInfo.f16519b || size < 0) {
                        break;
                    }
                    while (true) {
                        itemInfo3 = this.X2.get(size);
                        if (i7 < itemInfo3.f16519b && size > 0) {
                            size--;
                        }
                    }
                    while (i7 > itemInfo3.f16519b) {
                        f6 -= this.a3.h(i7) + f2;
                        i7--;
                    }
                    f6 -= itemInfo3.f16521d + f2;
                    itemInfo3.f16522e = f6;
                }
            }
        }
        int size2 = this.X2.size();
        float f7 = itemInfo.f16522e;
        int i11 = itemInfo.f16519b;
        int i12 = i11 - 1;
        this.m3 = i11 == 0 ? f7 : -3.4028235E38f;
        int i13 = e2 - 1;
        this.n3 = i11 == i13 ? (itemInfo.f16521d + f7) - 1.0f : Float.MAX_VALUE;
        int i14 = i2 - 1;
        while (i14 >= 0) {
            ItemInfo itemInfo5 = this.X2.get(i14);
            while (true) {
                i6 = itemInfo5.f16519b;
                if (i12 <= i6) {
                    break;
                }
                f7 -= this.a3.h(i12) + f2;
                i12--;
            }
            f7 -= itemInfo5.f16521d + f2;
            itemInfo5.f16522e = f7;
            if (i6 == 0) {
                this.m3 = f7;
            }
            i14--;
            i12--;
        }
        float f8 = itemInfo.f16522e + itemInfo.f16521d + f2;
        int i15 = itemInfo.f16519b + 1;
        int i16 = i2 + 1;
        while (i16 < size2) {
            ItemInfo itemInfo6 = this.X2.get(i16);
            while (true) {
                i5 = itemInfo6.f16519b;
                if (i15 >= i5) {
                    break;
                }
                f8 += this.a3.h(i15) + f2;
                i15++;
            }
            if (i5 == i13) {
                this.n3 = (itemInfo6.f16521d + f8) - 1.0f;
            }
            itemInfo6.f16522e = f8;
            f8 += itemInfo6.f16521d + f2;
            i16++;
            i15++;
        }
        this.O3 = false;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void i(boolean z) {
        boolean z2 = this.a4 == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.f3.isFinished()) {
                this.f3.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f3.getCurrX();
                int currY = this.f3.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        H(currX);
                    }
                }
            }
        }
        this.s3 = false;
        for (int i2 = 0; i2 < this.X2.size(); i2++) {
            ItemInfo itemInfo = this.X2.get(i2);
            if (itemInfo.f16520c) {
                itemInfo.f16520c = false;
                z2 = true;
            }
        }
        if (!z2) {
            return;
        }
        if (z) {
            ViewCompat.v1(this, this.Z3);
        } else {
            this.Z3.run();
        }
    }

    private int k(int i2, float f2, int i5, int i6) {
        if (Math.abs(i6) <= this.H3 || Math.abs(i5) <= this.F3) {
            i2 += (int) (f2 + (i2 >= this.b3 ? 0.4f : 0.6f));
        } else if (i5 <= 0) {
            i2++;
        }
        if (this.X2.size() <= 0) {
            return i2;
        }
        ArrayList<ItemInfo> arrayList = this.X2;
        return Math.max(this.X2.get(0).f16519b, Math.min(i2, arrayList.get(arrayList.size() - 1).f16519b));
    }

    private void l(int i2, float f2, int i5) {
        OnPageChangeListener onPageChangeListener = this.S3;
        if (onPageChangeListener != null) {
            onPageChangeListener.a(i2, f2, i5);
        }
        List<OnPageChangeListener> list = this.R3;
        if (list != null) {
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                OnPageChangeListener onPageChangeListener2 = this.R3.get(i6);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.a(i2, f2, i5);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.T3;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.a(i2, f2, i5);
        }
    }

    private void m(int i2) {
        OnPageChangeListener onPageChangeListener = this.S3;
        if (onPageChangeListener != null) {
            onPageChangeListener.d(i2);
        }
        List<OnPageChangeListener> list = this.R3;
        if (list != null) {
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                OnPageChangeListener onPageChangeListener2 = this.R3.get(i5);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.d(i2);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.T3;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.d(i2);
        }
    }

    private void n(int i2) {
        OnPageChangeListener onPageChangeListener = this.S3;
        if (onPageChangeListener != null) {
            onPageChangeListener.c(i2);
        }
        List<OnPageChangeListener> list = this.R3;
        if (list != null) {
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                OnPageChangeListener onPageChangeListener2 = this.R3.get(i5);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.c(i2);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.T3;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.c(i2);
        }
    }

    private void p(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setLayerType(z ? this.W3 : 0, (Paint) null);
        }
    }

    private void q() {
        this.u3 = false;
        this.v3 = false;
        VelocityTracker velocityTracker = this.E3;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.E3 = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.r3 != z) {
            this.r3 = z;
        }
    }

    private Rect u(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        int bottom = view.getBottom();
        while (true) {
            rect.bottom = bottom;
            ViewParent parent = view.getParent();
            if (!(parent instanceof ViewGroup) || parent == this) {
                return rect;
            }
            view = (ViewGroup) parent;
            rect.left += view.getLeft();
            rect.right += view.getRight();
            rect.top += view.getTop();
            bottom = rect.bottom + view.getBottom();
        }
        return rect;
    }

    private ItemInfo x() {
        int i2;
        int clientWidth = getClientWidth();
        float f2 = 0.0f;
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f5 = clientWidth > 0 ? ((float) this.i3) / ((float) clientWidth) : 0.0f;
        ItemInfo itemInfo = null;
        float f6 = 0.0f;
        int i5 = -1;
        int i6 = 0;
        boolean z = true;
        while (i6 < this.X2.size()) {
            ItemInfo itemInfo2 = this.X2.get(i6);
            if (!z && itemInfo2.f16519b != (i2 = i5 + 1)) {
                itemInfo2 = this.Y2;
                itemInfo2.f16522e = f2 + f6 + f5;
                itemInfo2.f16519b = i2;
                itemInfo2.f16521d = this.a3.h(i2);
                i6--;
            }
            ItemInfo itemInfo3 = itemInfo2;
            f2 = itemInfo3.f16522e;
            float f7 = itemInfo3.f16521d + f2 + f5;
            if (!z && scrollX < f2) {
                return itemInfo;
            }
            if (scrollX < f7 || i6 == this.X2.size() - 1) {
                return itemInfo3;
            }
            int i7 = itemInfo3.f16519b;
            float f8 = itemInfo3.f16521d;
            i6++;
            z = false;
            ItemInfo itemInfo4 = itemInfo3;
            i5 = i7;
            f6 = f8;
            itemInfo = itemInfo4;
        }
        return itemInfo;
    }

    public boolean B() {
        return this.J3;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0065  */
    @androidx.annotation.CallSuper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void D(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.Q3
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L_0x006c
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = 0
        L_0x001b:
            if (r7 >= r6) goto L_0x006c
            android.view.View r8 = r12.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r9 = (androidx.viewpager.widget.ViewPager.LayoutParams) r9
            boolean r10 = r9.f16523a
            if (r10 != 0) goto L_0x002c
            goto L_0x0069
        L_0x002c:
            int r9 = r9.f16524b
            r9 = r9 & 7
            if (r9 == r2) goto L_0x0050
            r10 = 3
            if (r9 == r10) goto L_0x004a
            r10 = 5
            if (r9 == r10) goto L_0x003a
            r9 = r3
            goto L_0x005d
        L_0x003a:
            int r9 = r5 - r4
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r4 = r4 + r10
        L_0x0046:
            r11 = r9
            r9 = r3
            r3 = r11
            goto L_0x005d
        L_0x004a:
            int r9 = r8.getWidth()
            int r9 = r9 + r3
            goto L_0x005d
        L_0x0050:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r3)
            goto L_0x0046
        L_0x005d:
            int r3 = r3 + r0
            int r10 = r8.getLeft()
            int r3 = r3 - r10
            if (r3 == 0) goto L_0x0068
            r8.offsetLeftAndRight(r3)
        L_0x0068:
            r3 = r9
        L_0x0069:
            int r7 = r7 + 1
            goto L_0x001b
        L_0x006c:
            r12.l(r13, r14, r15)
            androidx.viewpager.widget.ViewPager$PageTransformer r13 = r12.V3
            if (r13 == 0) goto L_0x00a0
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L_0x007b:
            if (r1 >= r14) goto L_0x00a0
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r0 = (androidx.viewpager.widget.ViewPager.LayoutParams) r0
            boolean r0 = r0.f16523a
            if (r0 == 0) goto L_0x008c
            goto L_0x009d
        L_0x008c:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            androidx.viewpager.widget.ViewPager$PageTransformer r3 = r12.V3
            r3.a(r15, r0)
        L_0x009d:
            int r1 = r1 + 1
            goto L_0x007b
        L_0x00a0:
            r12.P3 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.D(int, float, int):void");
    }

    /* access modifiers changed from: package-private */
    public boolean F() {
        int i2 = this.b3;
        if (i2 <= 0) {
            return false;
        }
        S(i2 - 1, true);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean G() {
        PagerAdapter pagerAdapter = this.a3;
        if (pagerAdapter == null || this.b3 >= pagerAdapter.e() - 1) {
            return false;
        }
        S(this.b3 + 1, true);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void J() {
        K(this.b3);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0060, code lost:
        if (r9 == r10) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0066, code lost:
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c0, code lost:
        if (r10 >= 0) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00cb, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00d9, code lost:
        if (r10 >= 0) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00e7, code lost:
        if (r10 >= 0) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x013d, code lost:
        if (r4 < r0.X2.size()) goto L_0x013f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0148, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x015b, code lost:
        if (r4 < r0.X2.size()) goto L_0x013f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x016d, code lost:
        if (r4 < r0.X2.size()) goto L_0x013f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void K(int r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r0.b3
            if (r2 == r1) goto L_0x000f
            androidx.viewpager.widget.ViewPager$ItemInfo r2 = r0.y(r2)
            r0.b3 = r1
            goto L_0x0010
        L_0x000f:
            r2 = 0
        L_0x0010:
            androidx.viewpager.widget.PagerAdapter r1 = r0.a3
            if (r1 != 0) goto L_0x0018
            r17.a0()
            return
        L_0x0018:
            boolean r1 = r0.s3
            if (r1 == 0) goto L_0x0020
            r17.a0()
            return
        L_0x0020:
            android.os.IBinder r1 = r17.getWindowToken()
            if (r1 != 0) goto L_0x0027
            return
        L_0x0027:
            androidx.viewpager.widget.PagerAdapter r1 = r0.a3
            r1.t(r0)
            int r1 = r0.t3
            int r4 = r0.b3
            int r4 = r4 - r1
            r5 = 0
            int r4 = java.lang.Math.max(r5, r4)
            androidx.viewpager.widget.PagerAdapter r6 = r0.a3
            int r6 = r6.e()
            int r7 = r6 + -1
            int r8 = r0.b3
            int r8 = r8 + r1
            int r1 = java.lang.Math.min(r7, r8)
            int r7 = r0.s
            if (r6 != r7) goto L_0x01f0
            r7 = 0
        L_0x004a:
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r8 = r0.X2
            int r8 = r8.size()
            if (r7 >= r8) goto L_0x0066
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r8 = r0.X2
            java.lang.Object r8 = r8.get(r7)
            androidx.viewpager.widget.ViewPager$ItemInfo r8 = (androidx.viewpager.widget.ViewPager.ItemInfo) r8
            int r9 = r8.f16519b
            int r10 = r0.b3
            if (r9 < r10) goto L_0x0063
            if (r9 != r10) goto L_0x0066
            goto L_0x0067
        L_0x0063:
            int r7 = r7 + 1
            goto L_0x004a
        L_0x0066:
            r8 = 0
        L_0x0067:
            if (r8 != 0) goto L_0x0071
            if (r6 <= 0) goto L_0x0071
            int r8 = r0.b3
            androidx.viewpager.widget.ViewPager$ItemInfo r8 = r0.a(r8, r7)
        L_0x0071:
            r9 = 0
            if (r8 == 0) goto L_0x017d
            int r10 = r7 + -1
            if (r10 < 0) goto L_0x0081
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r11 = r0.X2
            java.lang.Object r11 = r11.get(r10)
            androidx.viewpager.widget.ViewPager$ItemInfo r11 = (androidx.viewpager.widget.ViewPager.ItemInfo) r11
            goto L_0x0082
        L_0x0081:
            r11 = 0
        L_0x0082:
            int r12 = r17.getClientWidth()
            r13 = 1073741824(0x40000000, float:2.0)
            if (r12 > 0) goto L_0x008c
            r14 = 0
            goto L_0x0098
        L_0x008c:
            float r14 = r8.f16521d
            float r14 = r13 - r14
            int r15 = r17.getPaddingLeft()
            float r15 = (float) r15
            float r3 = (float) r12
            float r15 = r15 / r3
            float r14 = r14 + r15
        L_0x0098:
            int r3 = r0.b3
            int r3 = r3 + -1
            r15 = 0
        L_0x009d:
            if (r3 < 0) goto L_0x00ee
            int r16 = (r15 > r14 ? 1 : (r15 == r14 ? 0 : -1))
            if (r16 < 0) goto L_0x00ce
            if (r3 >= r4) goto L_0x00ce
            if (r11 != 0) goto L_0x00a8
            goto L_0x00ee
        L_0x00a8:
            int r5 = r11.f16519b
            if (r3 != r5) goto L_0x00ea
            boolean r5 = r11.f16520c
            if (r5 != 0) goto L_0x00ea
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.X2
            r5.remove(r10)
            androidx.viewpager.widget.PagerAdapter r5 = r0.a3
            java.lang.Object r11 = r11.f16518a
            r5.b(r0, r3, r11)
            int r10 = r10 + -1
            int r7 = r7 + -1
            if (r10 < 0) goto L_0x00cb
        L_0x00c2:
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.X2
            java.lang.Object r5 = r5.get(r10)
            androidx.viewpager.widget.ViewPager$ItemInfo r5 = (androidx.viewpager.widget.ViewPager.ItemInfo) r5
            goto L_0x00cc
        L_0x00cb:
            r5 = 0
        L_0x00cc:
            r11 = r5
            goto L_0x00ea
        L_0x00ce:
            if (r11 == 0) goto L_0x00dc
            int r5 = r11.f16519b
            if (r3 != r5) goto L_0x00dc
            float r5 = r11.f16521d
            float r15 = r15 + r5
            int r10 = r10 + -1
            if (r10 < 0) goto L_0x00cb
            goto L_0x00c2
        L_0x00dc:
            int r5 = r10 + 1
            androidx.viewpager.widget.ViewPager$ItemInfo r5 = r0.a(r3, r5)
            float r5 = r5.f16521d
            float r15 = r15 + r5
            int r7 = r7 + 1
            if (r10 < 0) goto L_0x00cb
            goto L_0x00c2
        L_0x00ea:
            int r3 = r3 + -1
            r5 = 0
            goto L_0x009d
        L_0x00ee:
            float r3 = r8.f16521d
            int r4 = r7 + 1
            int r5 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r5 >= 0) goto L_0x0171
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.X2
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0107
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.X2
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$ItemInfo r5 = (androidx.viewpager.widget.ViewPager.ItemInfo) r5
            goto L_0x0108
        L_0x0107:
            r5 = 0
        L_0x0108:
            if (r12 > 0) goto L_0x010c
            r10 = 0
            goto L_0x0114
        L_0x010c:
            int r10 = r17.getPaddingRight()
            float r10 = (float) r10
            float r11 = (float) r12
            float r10 = r10 / r11
            float r10 = r10 + r13
        L_0x0114:
            int r11 = r0.b3
        L_0x0116:
            int r11 = r11 + 1
            if (r11 >= r6) goto L_0x0171
            int r12 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r12 < 0) goto L_0x014a
            if (r11 <= r1) goto L_0x014a
            if (r5 != 0) goto L_0x0123
            goto L_0x0171
        L_0x0123:
            int r12 = r5.f16519b
            if (r11 != r12) goto L_0x0170
            boolean r12 = r5.f16520c
            if (r12 != 0) goto L_0x0170
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r12 = r0.X2
            r12.remove(r4)
            androidx.viewpager.widget.PagerAdapter r12 = r0.a3
            java.lang.Object r5 = r5.f16518a
            r12.b(r0, r11, r5)
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.X2
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0148
        L_0x013f:
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.X2
            java.lang.Object r5 = r5.get(r4)
            androidx.viewpager.widget.ViewPager$ItemInfo r5 = (androidx.viewpager.widget.ViewPager.ItemInfo) r5
            goto L_0x0170
        L_0x0148:
            r5 = 0
            goto L_0x0170
        L_0x014a:
            if (r5 == 0) goto L_0x015e
            int r12 = r5.f16519b
            if (r11 != r12) goto L_0x015e
            float r5 = r5.f16521d
            float r3 = r3 + r5
            int r4 = r4 + 1
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.X2
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0148
            goto L_0x013f
        L_0x015e:
            androidx.viewpager.widget.ViewPager$ItemInfo r5 = r0.a(r11, r4)
            int r4 = r4 + 1
            float r5 = r5.f16521d
            float r3 = r3 + r5
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.X2
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x0148
            goto L_0x013f
        L_0x0170:
            goto L_0x0116
        L_0x0171:
            r0.f(r8, r7, r2)
            androidx.viewpager.widget.PagerAdapter r1 = r0.a3
            int r2 = r0.b3
            java.lang.Object r3 = r8.f16518a
            r1.q(r0, r2, r3)
        L_0x017d:
            androidx.viewpager.widget.PagerAdapter r1 = r0.a3
            r1.d(r0)
            int r1 = r17.getChildCount()
            r2 = 0
        L_0x0187:
            if (r2 >= r1) goto L_0x01b0
            android.view.View r3 = r0.getChildAt(r2)
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r4 = (androidx.viewpager.widget.ViewPager.LayoutParams) r4
            r4.f16528f = r2
            boolean r5 = r4.f16523a
            if (r5 != 0) goto L_0x01ad
            float r5 = r4.f16525c
            int r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r5 != 0) goto L_0x01ad
            androidx.viewpager.widget.ViewPager$ItemInfo r3 = r0.w(r3)
            if (r3 == 0) goto L_0x01ad
            float r5 = r3.f16521d
            r4.f16525c = r5
            int r3 = r3.f16519b
            r4.f16527e = r3
        L_0x01ad:
            int r2 = r2 + 1
            goto L_0x0187
        L_0x01b0:
            r17.a0()
            boolean r1 = r17.hasFocus()
            if (r1 == 0) goto L_0x01ef
            android.view.View r1 = r17.findFocus()
            if (r1 == 0) goto L_0x01c4
            androidx.viewpager.widget.ViewPager$ItemInfo r3 = r0.v(r1)
            goto L_0x01c5
        L_0x01c4:
            r3 = 0
        L_0x01c5:
            if (r3 == 0) goto L_0x01cd
            int r1 = r3.f16519b
            int r2 = r0.b3
            if (r1 == r2) goto L_0x01ef
        L_0x01cd:
            r5 = 0
        L_0x01ce:
            int r1 = r17.getChildCount()
            if (r5 >= r1) goto L_0x01ef
            android.view.View r1 = r0.getChildAt(r5)
            androidx.viewpager.widget.ViewPager$ItemInfo r2 = r0.w(r1)
            if (r2 == 0) goto L_0x01ec
            int r2 = r2.f16519b
            int r3 = r0.b3
            if (r2 != r3) goto L_0x01ec
            r2 = 2
            boolean r1 = r1.requestFocus(r2)
            if (r1 == 0) goto L_0x01ec
            goto L_0x01ef
        L_0x01ec:
            int r5 = r5 + 1
            goto L_0x01ce
        L_0x01ef:
            return
        L_0x01f0:
            android.content.res.Resources r1 = r17.getResources()     // Catch:{ NotFoundException -> 0x01fd }
            int r2 = r17.getId()     // Catch:{ NotFoundException -> 0x01fd }
            java.lang.String r1 = r1.getResourceName(r2)     // Catch:{ NotFoundException -> 0x01fd }
            goto L_0x0205
        L_0x01fd:
            int r1 = r17.getId()
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
        L_0x0205:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: "
            r3.append(r4)
            int r4 = r0.s
            r3.append(r4)
            java.lang.String r4 = ", found: "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r4 = " Pager id: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = " Pager class: "
            r3.append(r1)
            java.lang.Class r1 = r17.getClass()
            r3.append(r1)
            java.lang.String r1 = " Problematic adapter: "
            r3.append(r1)
            androidx.viewpager.widget.PagerAdapter r1 = r0.a3
            java.lang.Class r1 = r1.getClass()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.K(int):void");
    }

    public void N(@NonNull OnAdapterChangeListener onAdapterChangeListener) {
        List<OnAdapterChangeListener> list = this.U3;
        if (list != null) {
            list.remove(onAdapterChangeListener);
        }
    }

    public void O(@NonNull OnPageChangeListener onPageChangeListener) {
        List<OnPageChangeListener> list = this.R3;
        if (list != null) {
            list.remove(onPageChangeListener);
        }
    }

    public void S(int i2, boolean z) {
        this.s3 = false;
        T(i2, z, false);
    }

    /* access modifiers changed from: package-private */
    public void T(int i2, boolean z, boolean z2) {
        U(i2, z, z2, 0);
    }

    /* access modifiers changed from: package-private */
    public void U(int i2, boolean z, boolean z2, int i5) {
        PagerAdapter pagerAdapter = this.a3;
        boolean z4 = false;
        if (pagerAdapter == null || pagerAdapter.e() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.b3 != i2 || this.X2.size() == 0) {
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 >= this.a3.e()) {
                i2 = this.a3.e() - 1;
            }
            int i6 = this.t3;
            int i7 = this.b3;
            if (i2 > i7 + i6 || i2 < i7 - i6) {
                for (int i8 = 0; i8 < this.X2.size(); i8++) {
                    this.X2.get(i8).f16520c = true;
                }
            }
            if (this.b3 != i2) {
                z4 = true;
            }
            if (this.N3) {
                this.b3 = i2;
                if (z4) {
                    m(i2);
                }
                requestLayout();
                return;
            }
            K(i2);
            R(i2, z, i5, z4);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    /* access modifiers changed from: package-private */
    public OnPageChangeListener V(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.T3;
        this.T3 = onPageChangeListener;
        return onPageChangeListener2;
    }

    public void W(boolean z, @Nullable PageTransformer pageTransformer) {
        X(z, pageTransformer, 2);
    }

    public void X(boolean z, @Nullable PageTransformer pageTransformer, int i2) {
        int i5 = 1;
        boolean z2 = pageTransformer != null;
        boolean z4 = z2 != (this.V3 != null);
        this.V3 = pageTransformer;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            if (z) {
                i5 = 2;
            }
            this.X3 = i5;
            this.W3 = i2;
        } else {
            this.X3 = 0;
        }
        if (z4) {
            J();
        }
    }

    /* access modifiers changed from: package-private */
    public void Y(int i2, int i5) {
        Z(i2, i5, 0);
    }

    /* access modifiers changed from: package-private */
    public void Z(int i2, int i5, int i6) {
        int scrollX;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.f3;
        if (scroller == null || scroller.isFinished()) {
            scrollX = getScrollX();
        } else {
            scrollX = this.g3 ? this.f3.getCurrX() : this.f3.getStartX();
            this.f3.abortAnimation();
            setScrollingCacheEnabled(false);
        }
        int i7 = scrollX;
        int scrollY = getScrollY();
        int i8 = i2 - i7;
        int i9 = i5 - scrollY;
        if (i8 == 0 && i9 == 0) {
            i(false);
            J();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i10 = clientWidth / 2;
        float f2 = (float) clientWidth;
        float f5 = (float) i10;
        float o = f5 + (o(Math.min(1.0f, (((float) Math.abs(i8)) * 1.0f) / f2)) * f5);
        int abs = Math.abs(i6);
        int min = Math.min(abs > 0 ? Math.round(Math.abs(o / ((float) abs)) * 1000.0f) * 4 : (int) (((((float) Math.abs(i8)) / ((f2 * this.a3.h(this.b3)) + ((float) this.i3))) + 1.0f) * 100.0f), 600);
        this.g3 = false;
        this.f3.startScroll(i7, scrollY, i8, i9, min);
        ViewCompat.t1(this);
    }

    /* access modifiers changed from: package-private */
    public ItemInfo a(int i2, int i5) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.f16519b = i2;
        itemInfo.f16518a = this.a3.j(this, i2);
        itemInfo.f16521d = this.a3.h(i2);
        if (i5 < 0 || i5 >= this.X2.size()) {
            this.X2.add(itemInfo);
        } else {
            this.X2.add(i5, itemInfo);
        }
        return itemInfo;
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i5) {
        ItemInfo w;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                View childAt = getChildAt(i6);
                if (childAt.getVisibility() == 0 && (w = w(childAt)) != null && w.f16519b == this.b3) {
                    childAt.addFocusables(arrayList, i2, i5);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if ((i5 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        ItemInfo w;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (w = w(childAt)) != null && w.f16519b == this.b3) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean A = layoutParams2.f16523a | A(view);
        layoutParams2.f16523a = A;
        if (!this.q3) {
            super.addView(view, i2, layoutParams);
        } else if (!A) {
            layoutParams2.f16526d = true;
            addViewInLayout(view, i2, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public void b(@NonNull OnAdapterChangeListener onAdapterChangeListener) {
        if (this.U3 == null) {
            this.U3 = new ArrayList();
        }
        this.U3.add(onAdapterChangeListener);
    }

    public void c(@NonNull OnPageChangeListener onPageChangeListener) {
        if (this.R3 == null) {
            this.R3 = new ArrayList();
        }
        this.R3.add(onPageChangeListener);
    }

    public boolean canScrollHorizontally(int i2) {
        if (this.a3 == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i2 < 0 ? scrollX > ((int) (((float) clientWidth) * this.m3)) : i2 > 0 && scrollX < ((int) (((float) clientWidth) * this.n3));
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        this.g3 = true;
        if (this.f3.isFinished() || !this.f3.computeScrollOffset()) {
            i(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f3.getCurrX();
        int currY = this.f3.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!H(currX)) {
                this.f3.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ViewCompat.t1(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0087, code lost:
        if (r2 >= r3) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a3, code lost:
        if (r2 <= r3) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00af, code lost:
        if (r5 != 2) goto L_0x00b2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d(int r5) {
        /*
            r4 = this;
            android.view.View r0 = r4.findFocus()
            r1 = 0
            if (r0 != r4) goto L_0x0009
        L_0x0007:
            r0 = r1
            goto L_0x0063
        L_0x0009:
            if (r0 == 0) goto L_0x0063
            android.view.ViewParent r2 = r0.getParent()
        L_0x000f:
            boolean r3 = r2 instanceof android.view.ViewGroup
            if (r3 == 0) goto L_0x001b
            if (r2 != r4) goto L_0x0016
            goto L_0x0063
        L_0x0016:
            android.view.ViewParent r2 = r2.getParent()
            goto L_0x000f
        L_0x001b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
        L_0x002f:
            boolean r3 = r0 instanceof android.view.ViewGroup
            if (r3 == 0) goto L_0x0048
            java.lang.String r3 = " => "
            r2.append(r3)
            java.lang.Class r3 = r0.getClass()
            java.lang.String r3 = r3.getSimpleName()
            r2.append(r3)
            android.view.ViewParent r0 = r0.getParent()
            goto L_0x002f
        L_0x0048:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "arrowScroll tried to find focus based on non-child current focused view "
            r0.append(r3)
            java.lang.String r2 = r2.toString()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "ViewPager"
            android.util.Log.e(r2, r0)
            goto L_0x0007
        L_0x0063:
            android.view.FocusFinder r1 = android.view.FocusFinder.getInstance()
            android.view.View r1 = r1.findNextFocus(r4, r0, r5)
            r2 = 66
            r3 = 17
            if (r1 == 0) goto L_0x00a6
            if (r1 == r0) goto L_0x00a6
            if (r5 != r3) goto L_0x008f
            android.graphics.Rect r2 = r4.Z2
            android.graphics.Rect r2 = r4.u(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r4.Z2
            android.graphics.Rect r3 = r4.u(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto L_0x008a
            if (r2 < r3) goto L_0x008a
            goto L_0x00b9
        L_0x008a:
            boolean r0 = r1.requestFocus()
            goto L_0x00bd
        L_0x008f:
            if (r5 != r2) goto L_0x00b2
            android.graphics.Rect r2 = r4.Z2
            android.graphics.Rect r2 = r4.u(r2, r1)
            int r2 = r2.left
            android.graphics.Rect r3 = r4.Z2
            android.graphics.Rect r3 = r4.u(r3, r0)
            int r3 = r3.left
            if (r0 == 0) goto L_0x008a
            if (r2 > r3) goto L_0x008a
            goto L_0x00b4
        L_0x00a6:
            if (r5 == r3) goto L_0x00b9
            r0 = 1
            if (r5 != r0) goto L_0x00ac
            goto L_0x00b9
        L_0x00ac:
            if (r5 == r2) goto L_0x00b4
            r0 = 2
            if (r5 != r0) goto L_0x00b2
            goto L_0x00b4
        L_0x00b2:
            r0 = 0
            goto L_0x00bd
        L_0x00b4:
            boolean r0 = r4.G()
            goto L_0x00bd
        L_0x00b9:
            boolean r0 = r4.F()
        L_0x00bd:
            if (r0 == 0) goto L_0x00c6
            int r5 = android.view.SoundEffectConstants.getContantForFocusDirection(r5)
            r4.playSoundEffect(r5)
        L_0x00c6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.d(int):boolean");
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || s(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ItemInfo w;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (w = w(childAt)) != null && w.f16519b == this.b3 && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (pagerAdapter = this.a3) != null && pagerAdapter.e() > 1)) {
            if (!this.L3.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.m3 * ((float) width));
                this.L3.setSize(height, width);
                z = this.L3.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.M3.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.n3 + 1.0f)) * ((float) width2));
                this.M3.setSize(height2, width2);
                z |= this.M3.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.L3.finish();
            this.M3.finish();
        }
        if (z) {
            ViewCompat.t1(this);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.j3;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public boolean e() {
        if (this.u3) {
            return false;
        }
        this.J3 = true;
        setScrollState(1);
        this.z3 = 0.0f;
        this.B3 = 0.0f;
        VelocityTracker velocityTracker = this.E3;
        if (velocityTracker == null) {
            this.E3 = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.E3.addMovement(obtain);
        obtain.recycle();
        this.K3 = uptimeMillis;
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean g(View view, boolean z, int i2, int i5, int i6) {
        int i7;
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i8 = i5 + scrollX;
                if (i8 >= childAt.getLeft() && i8 < childAt.getRight() && (i7 = i6 + scrollY) >= childAt.getTop() && i7 < childAt.getBottom()) {
                    if (g(childAt, true, i2, i8 - childAt.getLeft(), i7 - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        return z && view.canScrollHorizontally(-i2);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Nullable
    public PagerAdapter getAdapter() {
        return this.a3;
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i5) {
        if (this.X3 == 2) {
            i5 = (i2 - 1) - i5;
        }
        return ((LayoutParams) this.Y3.get(i5).getLayoutParams()).f16528f;
    }

    public int getCurrentItem() {
        return this.b3;
    }

    public int getOffscreenPageLimit() {
        return this.t3;
    }

    public int getPageMargin() {
        return this.i3;
    }

    public void h() {
        List<OnPageChangeListener> list = this.R3;
        if (list != null) {
            list.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        int e2 = this.a3.e();
        this.s = e2;
        boolean z = this.X2.size() < (this.t3 * 2) + 1 && this.X2.size() < e2;
        int i2 = this.b3;
        int i5 = 0;
        boolean z2 = false;
        while (i5 < this.X2.size()) {
            ItemInfo itemInfo = this.X2.get(i5);
            int f2 = this.a3.f(itemInfo.f16518a);
            if (f2 != -1) {
                if (f2 == -2) {
                    this.X2.remove(i5);
                    i5--;
                    if (!z2) {
                        this.a3.t(this);
                        z2 = true;
                    }
                    this.a3.b(this, itemInfo.f16519b, itemInfo.f16518a);
                    int i6 = this.b3;
                    if (i6 == itemInfo.f16519b) {
                        i2 = Math.max(0, Math.min(i6, e2 - 1));
                    }
                } else {
                    int i7 = itemInfo.f16519b;
                    if (i7 != f2) {
                        if (i7 == this.b3) {
                            i2 = f2;
                        }
                        itemInfo.f16519b = f2;
                    }
                }
                z = true;
            }
            i5++;
        }
        if (z2) {
            this.a3.d(this);
        }
        Collections.sort(this.X2, k4);
        if (z) {
            int childCount = getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i8).getLayoutParams();
                if (!layoutParams.f16523a) {
                    layoutParams.f16525c = 0.0f;
                }
            }
            T(i2, false, true);
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public float o(float f2) {
        return (float) Math.sin((double) ((f2 - 0.5f) * 0.47123894f));
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.N3 = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.Z3);
        Scroller scroller = this.f3;
        if (scroller != null && !scroller.isFinished()) {
            this.f3.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r18) {
        /*
            r17 = this;
            r0 = r17
            super.onDraw(r18)
            int r1 = r0.i3
            if (r1 <= 0) goto L_0x00aa
            android.graphics.drawable.Drawable r1 = r0.j3
            if (r1 == 0) goto L_0x00aa
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r1 = r0.X2
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x00aa
            androidx.viewpager.widget.PagerAdapter r1 = r0.a3
            if (r1 == 0) goto L_0x00aa
            int r1 = r17.getScrollX()
            int r2 = r17.getWidth()
            int r3 = r0.i3
            float r3 = (float) r3
            float r4 = (float) r2
            float r3 = r3 / r4
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.X2
            r6 = 0
            java.lang.Object r5 = r5.get(r6)
            androidx.viewpager.widget.ViewPager$ItemInfo r5 = (androidx.viewpager.widget.ViewPager.ItemInfo) r5
            float r7 = r5.f16522e
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r8 = r0.X2
            int r8 = r8.size()
            int r9 = r5.f16519b
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r10 = r0.X2
            int r11 = r8 + -1
            java.lang.Object r10 = r10.get(r11)
            androidx.viewpager.widget.ViewPager$ItemInfo r10 = (androidx.viewpager.widget.ViewPager.ItemInfo) r10
            int r10 = r10.f16519b
        L_0x0045:
            if (r9 >= r10) goto L_0x00aa
        L_0x0047:
            int r11 = r5.f16519b
            if (r9 <= r11) goto L_0x0058
            if (r6 >= r8) goto L_0x0058
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$ItemInfo> r5 = r0.X2
            int r6 = r6 + 1
            java.lang.Object r5 = r5.get(r6)
            androidx.viewpager.widget.ViewPager$ItemInfo r5 = (androidx.viewpager.widget.ViewPager.ItemInfo) r5
            goto L_0x0047
        L_0x0058:
            if (r9 != r11) goto L_0x0065
            float r7 = r5.f16522e
            float r11 = r5.f16521d
            float r12 = r7 + r11
            float r12 = r12 * r4
            float r7 = r7 + r11
            float r7 = r7 + r3
            goto L_0x0071
        L_0x0065:
            androidx.viewpager.widget.PagerAdapter r11 = r0.a3
            float r11 = r11.h(r9)
            float r12 = r7 + r11
            float r12 = r12 * r4
            float r11 = r11 + r3
            float r7 = r7 + r11
        L_0x0071:
            int r11 = r0.i3
            float r11 = (float) r11
            float r11 = r11 + r12
            float r13 = (float) r1
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 <= 0) goto L_0x0099
            android.graphics.drawable.Drawable r11 = r0.j3
            int r13 = java.lang.Math.round(r12)
            int r14 = r0.k3
            int r15 = r0.i3
            float r15 = (float) r15
            float r15 = r15 + r12
            int r15 = java.lang.Math.round(r15)
            r16 = r3
            int r3 = r0.l3
            r11.setBounds(r13, r14, r15, r3)
            android.graphics.drawable.Drawable r3 = r0.j3
            r11 = r18
            r3.draw(r11)
            goto L_0x009d
        L_0x0099:
            r11 = r18
            r16 = r3
        L_0x009d:
            int r3 = r1 + r2
            float r3 = (float) r3
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x00a5
            goto L_0x00aa
        L_0x00a5:
            int r9 = r9 + 1
            r3 = r16
            goto L_0x0045
        L_0x00aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onDraw(android.graphics.Canvas):void");
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            Q();
            return false;
        }
        if (action != 0) {
            if (this.u3) {
                return true;
            }
            if (this.v3) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.B3 = x;
            this.z3 = x;
            float y = motionEvent.getY();
            this.C3 = y;
            this.A3 = y;
            this.D3 = motionEvent2.getPointerId(0);
            this.v3 = false;
            this.g3 = true;
            this.f3.computeScrollOffset();
            if (this.a4 != 2 || Math.abs(this.f3.getFinalX() - this.f3.getCurrX()) <= this.I3) {
                i(false);
                this.u3 = false;
            } else {
                this.f3.abortAnimation();
                this.s3 = false;
                J();
                this.u3 = true;
                P(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.D3;
            if (i2 != -1) {
                int findPointerIndex = motionEvent2.findPointerIndex(i2);
                float x2 = motionEvent2.getX(findPointerIndex);
                float f2 = x2 - this.z3;
                float abs = Math.abs(f2);
                float y2 = motionEvent2.getY(findPointerIndex);
                float abs2 = Math.abs(y2 - this.C3);
                int i5 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                if (i5 != 0 && !C(this.z3, f2)) {
                    if (g(this, false, (int) f2, (int) x2, (int) y2)) {
                        this.z3 = x2;
                        this.A3 = y2;
                        this.v3 = true;
                        return false;
                    }
                }
                int i6 = this.y3;
                if (abs > ((float) i6) && abs * 0.5f > abs2) {
                    this.u3 = true;
                    P(true);
                    setScrollState(1);
                    float f5 = this.B3;
                    float f6 = (float) this.y3;
                    this.z3 = i5 > 0 ? f5 + f6 : f5 - f6;
                    this.A3 = y2;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > ((float) i6)) {
                    this.v3 = true;
                }
                if (this.u3 && I(x2)) {
                    ViewCompat.t1(this);
                }
            }
        } else if (action == 6) {
            E(motionEvent);
        }
        if (this.E3 == null) {
            this.E3 = VelocityTracker.obtain();
        }
        this.E3.addMovement(motionEvent2);
        return this.u3;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            r18 = this;
            r0 = r18
            int r1 = r18.getChildCount()
            int r2 = r22 - r20
            int r3 = r23 - r21
            int r4 = r18.getPaddingLeft()
            int r5 = r18.getPaddingTop()
            int r6 = r18.getPaddingRight()
            int r7 = r18.getPaddingBottom()
            int r8 = r18.getScrollX()
            r10 = 0
            r11 = 0
        L_0x0020:
            r12 = 8
            if (r10 >= r1) goto L_0x00b8
            android.view.View r13 = r0.getChildAt(r10)
            int r14 = r13.getVisibility()
            if (r14 == r12) goto L_0x00b4
            android.view.ViewGroup$LayoutParams r12 = r13.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r12 = (androidx.viewpager.widget.ViewPager.LayoutParams) r12
            boolean r14 = r12.f16523a
            if (r14 == 0) goto L_0x00b4
            int r12 = r12.f16524b
            r14 = r12 & 7
            r12 = r12 & 112(0x70, float:1.57E-43)
            r15 = 1
            if (r14 == r15) goto L_0x0061
            r15 = 3
            if (r14 == r15) goto L_0x005b
            r15 = 5
            if (r14 == r15) goto L_0x0049
            r14 = r4
            goto L_0x006e
        L_0x0049:
            int r14 = r2 - r6
            int r15 = r13.getMeasuredWidth()
            int r14 = r14 - r15
            int r15 = r13.getMeasuredWidth()
            int r6 = r6 + r15
        L_0x0055:
            r17 = r14
            r14 = r4
            r4 = r17
            goto L_0x006e
        L_0x005b:
            int r14 = r13.getMeasuredWidth()
            int r14 = r14 + r4
            goto L_0x006e
        L_0x0061:
            int r14 = r13.getMeasuredWidth()
            int r14 = r2 - r14
            int r14 = r14 / 2
            int r14 = java.lang.Math.max(r14, r4)
            goto L_0x0055
        L_0x006e:
            r15 = 16
            if (r12 == r15) goto L_0x0094
            r15 = 48
            if (r12 == r15) goto L_0x008e
            r15 = 80
            if (r12 == r15) goto L_0x007c
            r12 = r5
            goto L_0x00a1
        L_0x007c:
            int r12 = r3 - r7
            int r15 = r13.getMeasuredHeight()
            int r12 = r12 - r15
            int r15 = r13.getMeasuredHeight()
            int r7 = r7 + r15
        L_0x0088:
            r17 = r12
            r12 = r5
            r5 = r17
            goto L_0x00a1
        L_0x008e:
            int r12 = r13.getMeasuredHeight()
            int r12 = r12 + r5
            goto L_0x00a1
        L_0x0094:
            int r12 = r13.getMeasuredHeight()
            int r12 = r3 - r12
            int r12 = r12 / 2
            int r12 = java.lang.Math.max(r12, r5)
            goto L_0x0088
        L_0x00a1:
            int r4 = r4 + r8
            int r15 = r13.getMeasuredWidth()
            int r15 = r15 + r4
            int r16 = r13.getMeasuredHeight()
            int r9 = r5 + r16
            r13.layout(r4, r5, r15, r9)
            int r11 = r11 + 1
            r5 = r12
            r4 = r14
        L_0x00b4:
            int r10 = r10 + 1
            goto L_0x0020
        L_0x00b8:
            int r2 = r2 - r4
            int r2 = r2 - r6
            r6 = 0
        L_0x00bb:
            if (r6 >= r1) goto L_0x010a
            android.view.View r8 = r0.getChildAt(r6)
            int r9 = r8.getVisibility()
            if (r9 == r12) goto L_0x0107
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r9 = (androidx.viewpager.widget.ViewPager.LayoutParams) r9
            boolean r10 = r9.f16523a
            if (r10 != 0) goto L_0x0107
            androidx.viewpager.widget.ViewPager$ItemInfo r10 = r0.w(r8)
            if (r10 == 0) goto L_0x0107
            float r13 = (float) r2
            float r10 = r10.f16522e
            float r10 = r10 * r13
            int r10 = (int) r10
            int r10 = r10 + r4
            boolean r14 = r9.f16526d
            if (r14 == 0) goto L_0x00fa
            r14 = 0
            r9.f16526d = r14
            float r9 = r9.f16525c
            float r13 = r13 * r9
            int r9 = (int) r13
            r13 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r13)
            int r14 = r3 - r5
            int r14 = r14 - r7
            int r13 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r13)
            r8.measure(r9, r13)
        L_0x00fa:
            int r9 = r8.getMeasuredWidth()
            int r9 = r9 + r10
            int r13 = r8.getMeasuredHeight()
            int r13 = r13 + r5
            r8.layout(r10, r5, r9, r13)
        L_0x0107:
            int r6 = r6 + 1
            goto L_0x00bb
        L_0x010a:
            r0.k3 = r5
            int r3 = r3 - r7
            r0.l3 = r3
            r0.Q3 = r11
            boolean r1 = r0.N3
            if (r1 == 0) goto L_0x011c
            int r1 = r0.b3
            r2 = 0
            r0.R(r1, r2, r2, r2)
            goto L_0x011d
        L_0x011c:
            r2 = 0
        L_0x011d:
            r0.N3 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r14, int r15) {
        /*
            r13 = this;
            r0 = 0
            int r14 = android.view.View.getDefaultSize(r0, r14)
            int r15 = android.view.View.getDefaultSize(r0, r15)
            r13.setMeasuredDimension(r14, r15)
            int r14 = r13.getMeasuredWidth()
            int r15 = r14 / 10
            int r1 = r13.w3
            int r15 = java.lang.Math.min(r15, r1)
            r13.x3 = r15
            int r15 = r13.getPaddingLeft()
            int r14 = r14 - r15
            int r15 = r13.getPaddingRight()
            int r14 = r14 - r15
            int r15 = r13.getMeasuredHeight()
            int r1 = r13.getPaddingTop()
            int r15 = r15 - r1
            int r1 = r13.getPaddingBottom()
            int r15 = r15 - r1
            int r1 = r13.getChildCount()
            r2 = 0
        L_0x0037:
            r3 = 8
            r4 = 1
            r5 = 1073741824(0x40000000, float:2.0)
            if (r2 >= r1) goto L_0x00b1
            android.view.View r6 = r13.getChildAt(r2)
            int r7 = r6.getVisibility()
            if (r7 == r3) goto L_0x00ae
            android.view.ViewGroup$LayoutParams r3 = r6.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r3 = (androidx.viewpager.widget.ViewPager.LayoutParams) r3
            if (r3 == 0) goto L_0x00ae
            boolean r7 = r3.f16523a
            if (r7 == 0) goto L_0x00ae
            int r7 = r3.f16524b
            r8 = r7 & 7
            r7 = r7 & 112(0x70, float:1.57E-43)
            r9 = 48
            if (r7 == r9) goto L_0x0065
            r9 = 80
            if (r7 != r9) goto L_0x0063
            goto L_0x0065
        L_0x0063:
            r7 = 0
            goto L_0x0066
        L_0x0065:
            r7 = 1
        L_0x0066:
            r9 = 3
            if (r8 == r9) goto L_0x006e
            r9 = 5
            if (r8 != r9) goto L_0x006d
            goto L_0x006e
        L_0x006d:
            r4 = 0
        L_0x006e:
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r7 == 0) goto L_0x0077
            r8 = 1073741824(0x40000000, float:2.0)
        L_0x0074:
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x007b
        L_0x0077:
            if (r4 == 0) goto L_0x0074
            r9 = 1073741824(0x40000000, float:2.0)
        L_0x007b:
            int r10 = r3.width
            r11 = -1
            r12 = -2
            if (r10 == r12) goto L_0x0088
            if (r10 == r11) goto L_0x0086
        L_0x0083:
            r8 = 1073741824(0x40000000, float:2.0)
            goto L_0x0089
        L_0x0086:
            r10 = r14
            goto L_0x0083
        L_0x0088:
            r10 = r14
        L_0x0089:
            int r3 = r3.height
            if (r3 == r12) goto L_0x0092
            if (r3 == r11) goto L_0x0090
            goto L_0x0094
        L_0x0090:
            r3 = r15
            goto L_0x0094
        L_0x0092:
            r3 = r15
            r5 = r9
        L_0x0094:
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r8)
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r5)
            r6.measure(r8, r3)
            if (r7 == 0) goto L_0x00a7
            int r3 = r6.getMeasuredHeight()
            int r15 = r15 - r3
            goto L_0x00ae
        L_0x00a7:
            if (r4 == 0) goto L_0x00ae
            int r3 = r6.getMeasuredWidth()
            int r14 = r14 - r3
        L_0x00ae:
            int r2 = r2 + 1
            goto L_0x0037
        L_0x00b1:
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r5)
            r13.o3 = r1
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r5)
            r13.p3 = r15
            r13.q3 = r4
            r13.J()
            r13.q3 = r0
            int r15 = r13.getChildCount()
        L_0x00c8:
            if (r0 >= r15) goto L_0x00f2
            android.view.View r1 = r13.getChildAt(r0)
            int r2 = r1.getVisibility()
            if (r2 == r3) goto L_0x00ef
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r2 = (androidx.viewpager.widget.ViewPager.LayoutParams) r2
            if (r2 == 0) goto L_0x00e0
            boolean r4 = r2.f16523a
            if (r4 != 0) goto L_0x00ef
        L_0x00e0:
            float r4 = (float) r14
            float r2 = r2.f16525c
            float r4 = r4 * r2
            int r2 = (int) r4
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r5)
            int r4 = r13.p3
            r1.measure(r2, r4)
        L_0x00ef:
            int r0 = r0 + 1
            goto L_0x00c8
        L_0x00f2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onMeasure(int, int):void");
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i5;
        int i6;
        int i7;
        ItemInfo w;
        int childCount = getChildCount();
        if ((i2 & 2) != 0) {
            i6 = childCount;
            i7 = 0;
            i5 = 1;
        } else {
            i7 = childCount - 1;
            i6 = -1;
            i5 = -1;
        }
        while (i7 != i6) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() == 0 && (w = w(childAt)) != null && w.f16519b == this.b3 && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i7 += i5;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        PagerAdapter pagerAdapter = this.a3;
        if (pagerAdapter != null) {
            pagerAdapter.n(savedState.Z, savedState.X2);
            T(savedState.Y, false, true);
            return;
        }
        this.c3 = savedState.Y;
        this.d3 = savedState.Z;
        this.e3 = savedState.X2;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Y = this.b3;
        PagerAdapter pagerAdapter = this.a3;
        if (pagerAdapter != null) {
            savedState.Z = pagerAdapter.o();
        }
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i5, int i6, int i7) {
        super.onSizeChanged(i2, i5, i6, i7);
        if (i2 != i6) {
            int i8 = this.i3;
            L(i2, i6, i8, i8);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0152  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.J3
            r1 = 1
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r8.getAction()
            r2 = 0
            if (r0 != 0) goto L_0x0014
            int r0 = r8.getEdgeFlags()
            if (r0 == 0) goto L_0x0014
            return r2
        L_0x0014:
            androidx.viewpager.widget.PagerAdapter r0 = r7.a3
            if (r0 == 0) goto L_0x0156
            int r0 = r0.e()
            if (r0 != 0) goto L_0x0020
            goto L_0x0156
        L_0x0020:
            android.view.VelocityTracker r0 = r7.E3
            if (r0 != 0) goto L_0x002a
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r7.E3 = r0
        L_0x002a:
            android.view.VelocityTracker r0 = r7.E3
            r0.addMovement(r8)
            int r0 = r8.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            if (r0 == 0) goto L_0x0130
            if (r0 == r1) goto L_0x00e6
            r3 = 2
            if (r0 == r3) goto L_0x0079
            r3 = 3
            if (r0 == r3) goto L_0x006a
            r3 = 5
            if (r0 == r3) goto L_0x0058
            r3 = 6
            if (r0 == r3) goto L_0x0047
            goto L_0x0150
        L_0x0047:
            r7.E(r8)
            int r0 = r7.D3
            int r0 = r8.findPointerIndex(r0)
            float r8 = r8.getX(r0)
            r7.z3 = r8
            goto L_0x0150
        L_0x0058:
            int r0 = r8.getActionIndex()
            float r3 = r8.getX(r0)
            r7.z3 = r3
            int r8 = r8.getPointerId(r0)
        L_0x0066:
            r7.D3 = r8
            goto L_0x0150
        L_0x006a:
            boolean r8 = r7.u3
            if (r8 == 0) goto L_0x0150
            int r8 = r7.b3
            r7.R(r8, r1, r2, r2)
        L_0x0073:
            boolean r2 = r7.Q()
            goto L_0x0150
        L_0x0079:
            boolean r0 = r7.u3
            if (r0 != 0) goto L_0x00d3
            int r0 = r7.D3
            int r0 = r8.findPointerIndex(r0)
            r3 = -1
            if (r0 != r3) goto L_0x0087
            goto L_0x0073
        L_0x0087:
            float r3 = r8.getX(r0)
            float r4 = r7.z3
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            float r0 = r8.getY(r0)
            float r5 = r7.A3
            float r5 = r0 - r5
            float r5 = java.lang.Math.abs(r5)
            int r6 = r7.y3
            float r6 = (float) r6
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x00d3
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x00d3
            r7.u3 = r1
            r7.P(r1)
            float r4 = r7.B3
            float r3 = r3 - r4
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x00bc
            int r3 = r7.y3
            float r3 = (float) r3
            float r4 = r4 + r3
            goto L_0x00c0
        L_0x00bc:
            int r3 = r7.y3
            float r3 = (float) r3
            float r4 = r4 - r3
        L_0x00c0:
            r7.z3 = r4
            r7.A3 = r0
            r7.setScrollState(r1)
            r7.setScrollingCacheEnabled(r1)
            android.view.ViewParent r0 = r7.getParent()
            if (r0 == 0) goto L_0x00d3
            r0.requestDisallowInterceptTouchEvent(r1)
        L_0x00d3:
            boolean r0 = r7.u3
            if (r0 == 0) goto L_0x0150
            int r0 = r7.D3
            int r0 = r8.findPointerIndex(r0)
            float r8 = r8.getX(r0)
            boolean r2 = r7.I(r8)
            goto L_0x0150
        L_0x00e6:
            boolean r0 = r7.u3
            if (r0 == 0) goto L_0x0150
            android.view.VelocityTracker r0 = r7.E3
            int r2 = r7.G3
            float r2 = (float) r2
            r3 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r3, r2)
            int r2 = r7.D3
            float r0 = r0.getXVelocity(r2)
            int r0 = (int) r0
            r7.s3 = r1
            int r2 = r7.getClientWidth()
            int r3 = r7.getScrollX()
            androidx.viewpager.widget.ViewPager$ItemInfo r4 = r7.x()
            int r5 = r7.i3
            float r5 = (float) r5
            float r2 = (float) r2
            float r5 = r5 / r2
            int r6 = r4.f16519b
            float r3 = (float) r3
            float r3 = r3 / r2
            float r2 = r4.f16522e
            float r3 = r3 - r2
            float r2 = r4.f16521d
            float r2 = r2 + r5
            float r3 = r3 / r2
            int r2 = r7.D3
            int r2 = r8.findPointerIndex(r2)
            float r8 = r8.getX(r2)
            float r2 = r7.B3
            float r8 = r8 - r2
            int r8 = (int) r8
            int r8 = r7.k(r6, r3, r0, r8)
            r7.U(r8, r1, r1, r0)
            goto L_0x0073
        L_0x0130:
            android.widget.Scroller r0 = r7.f3
            r0.abortAnimation()
            r7.s3 = r2
            r7.J()
            float r0 = r8.getX()
            r7.B3 = r0
            r7.z3 = r0
            float r0 = r8.getY()
            r7.C3 = r0
            r7.A3 = r0
            int r8 = r8.getPointerId(r2)
            goto L_0x0066
        L_0x0150:
            if (r2 == 0) goto L_0x0155
            androidx.core.view.ViewCompat.t1(r7)
        L_0x0155:
            return r1
        L_0x0156:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void r() {
        if (this.J3) {
            if (this.a3 != null) {
                VelocityTracker velocityTracker = this.E3;
                velocityTracker.computeCurrentVelocity(1000, (float) this.G3);
                int xVelocity = (int) velocityTracker.getXVelocity(this.D3);
                this.s3 = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                ItemInfo x = x();
                U(k(x.f16519b, ((((float) scrollX) / ((float) clientWidth)) - x.f16522e) / x.f16521d, xVelocity, (int) (this.z3 - this.B3)), true, true, xVelocity);
            }
            q();
            this.J3 = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public void removeView(View view) {
        if (this.q3) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public boolean s(@NonNull KeyEvent keyEvent) {
        int i2;
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 21) {
                if (keyCode != 22) {
                    if (keyCode == 61) {
                        if (keyEvent.hasNoModifiers()) {
                            return d(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return d(1);
                        }
                    }
                } else if (keyEvent.hasModifiers(2)) {
                    return G();
                } else {
                    i2 = 66;
                }
            } else if (keyEvent.hasModifiers(2)) {
                return F();
            } else {
                i2 = 17;
            }
            return d(i2);
        }
        return false;
    }

    public void setAdapter(@Nullable PagerAdapter pagerAdapter) {
        PagerAdapter pagerAdapter2 = this.a3;
        if (pagerAdapter2 != null) {
            pagerAdapter2.r((DataSetObserver) null);
            this.a3.t(this);
            for (int i2 = 0; i2 < this.X2.size(); i2++) {
                ItemInfo itemInfo = this.X2.get(i2);
                this.a3.b(this, itemInfo.f16519b, itemInfo.f16518a);
            }
            this.a3.d(this);
            this.X2.clear();
            M();
            this.b3 = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter3 = this.a3;
        this.a3 = pagerAdapter;
        this.s = 0;
        if (pagerAdapter != null) {
            if (this.h3 == null) {
                this.h3 = new PagerObserver();
            }
            this.a3.r(this.h3);
            this.s3 = false;
            boolean z = this.N3;
            this.N3 = true;
            this.s = this.a3.e();
            if (this.c3 >= 0) {
                this.a3.n(this.d3, this.e3);
                T(this.c3, false, true);
                this.c3 = -1;
                this.d3 = null;
                this.e3 = null;
            } else if (!z) {
                J();
            } else {
                requestLayout();
            }
        }
        List<OnAdapterChangeListener> list = this.U3;
        if (list != null && !list.isEmpty()) {
            int size = this.U3.size();
            for (int i5 = 0; i5 < size; i5++) {
                this.U3.get(i5).b(this, pagerAdapter3, pagerAdapter);
            }
        }
    }

    public void setCurrentItem(int i2) {
        this.s3 = false;
        T(i2, !this.N3, false);
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            Log.w(b4, "Requested offscreen page limit " + i2 + " too small; defaulting to " + 1);
            i2 = 1;
        }
        if (i2 != this.t3) {
            this.t3 = i2;
            J();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.S3 = onPageChangeListener;
    }

    public void setPageMargin(int i2) {
        int i5 = this.i3;
        this.i3 = i2;
        int width = getWidth();
        L(width, width, i2, i5);
        requestLayout();
    }

    public void setPageMarginDrawable(@DrawableRes int i2) {
        setPageMarginDrawable(ContextCompat.l(getContext(), i2));
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i2) {
        if (this.a4 != i2) {
            this.a4 = i2;
            if (this.V3 != null) {
                p(i2 != 0);
            }
            n(i2);
        }
    }

    public void t(float f2) {
        if (!this.J3) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        } else if (this.a3 != null) {
            this.z3 += f2;
            float scrollX = ((float) getScrollX()) - f2;
            float clientWidth = (float) getClientWidth();
            float f5 = this.m3 * clientWidth;
            float f6 = this.n3 * clientWidth;
            ItemInfo itemInfo = this.X2.get(0);
            ArrayList<ItemInfo> arrayList = this.X2;
            ItemInfo itemInfo2 = arrayList.get(arrayList.size() - 1);
            if (itemInfo.f16519b != 0) {
                f5 = itemInfo.f16522e * clientWidth;
            }
            if (itemInfo2.f16519b != this.a3.e() - 1) {
                f6 = itemInfo2.f16522e * clientWidth;
            }
            if (scrollX < f5) {
                scrollX = f5;
            } else if (scrollX > f6) {
                scrollX = f6;
            }
            int i2 = (int) scrollX;
            this.z3 += scrollX - ((float) i2);
            scrollTo(i2, getScrollY());
            H(i2);
            MotionEvent obtain = MotionEvent.obtain(this.K3, SystemClock.uptimeMillis(), 2, this.z3, 0.0f, 0);
            this.E3.addMovement(obtain);
            obtain.recycle();
        }
    }

    /* access modifiers changed from: package-private */
    public ItemInfo v(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return w(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.j3;
    }

    /* access modifiers changed from: package-private */
    public ItemInfo w(View view) {
        for (int i2 = 0; i2 < this.X2.size(); i2++) {
            ItemInfo itemInfo = this.X2.get(i2);
            if (this.a3.k(view, itemInfo.f16518a)) {
                return itemInfo;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public ItemInfo y(int i2) {
        for (int i5 = 0; i5 < this.X2.size(); i5++) {
            ItemInfo itemInfo = this.X2.get(i5);
            if (itemInfo.f16519b == i2) {
                return itemInfo;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void z() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f3 = new Scroller(context, l4);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.y3 = viewConfiguration.getScaledPagingTouchSlop();
        this.F3 = (int) (400.0f * f2);
        this.G3 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.L3 = new EdgeEffect(context);
        this.M3 = new EdgeEffect(context);
        this.H3 = (int) (25.0f * f2);
        this.I3 = (int) (2.0f * f2);
        this.w3 = (int) (f2 * 16.0f);
        ViewCompat.H1(this, new MyAccessibilityDelegate());
        if (ViewCompat.X(this) == 0) {
            ViewCompat.Z1(this, 1);
        }
        ViewCompat.k2(this, new OnApplyWindowInsetsListener() {

            /* renamed from: a  reason: collision with root package name */
            private final Rect f16516a = new Rect();

            public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat k1 = ViewCompat.k1(view, windowInsetsCompat);
                if (k1.A()) {
                    return k1;
                }
                Rect rect = this.f16516a;
                rect.left = k1.p();
                rect.top = k1.r();
                rect.right = k1.q();
                rect.bottom = k1.o();
                int childCount = ViewPager.this.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    WindowInsetsCompat p = ViewCompat.p(ViewPager.this.getChildAt(i2), k1);
                    rect.left = Math.min(p.p(), rect.left);
                    rect.top = Math.min(p.r(), rect.top);
                    rect.right = Math.min(p.q(), rect.right);
                    rect.bottom = Math.min(p.o(), rect.bottom);
                }
                return k1.D(rect.left, rect.top, rect.right, rect.bottom);
            }
        });
    }

    public ViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        z();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public void setPageMarginDrawable(@Nullable Drawable drawable) {
        this.j3 = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }
}
