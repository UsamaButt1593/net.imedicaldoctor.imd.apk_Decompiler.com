package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.graphics.Insets;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionBarOverlayLayout extends ViewGroup implements DecorContentParent, NestedScrollingParent, NestedScrollingParent2, NestedScrollingParent3 {
    private static final String C3 = "ActionBarOverlayLayout";
    private static final int D3 = 600;
    static final int[] E3 = {R.attr.f2554d, 16842841};
    private static final WindowInsetsCompat F3 = new WindowInsetsCompat.Builder().h(Insets.d(0, 1, 0, 1)).a();
    private static final Rect G3 = new Rect();
    private final NestedScrollingParentHelper A3;
    private final NoSystemUiLayoutFlagView B3;
    private int X2;
    private ContentFrameLayout Y2;
    ActionBarContainer Z2;
    private DecorToolbar a3;
    private Drawable b3;
    private boolean c3;
    private boolean d3;
    private boolean e3;
    boolean f3;
    private int g3;
    private int h3;
    private final Rect i3;
    private final Rect j3;
    private final Rect k3;
    private final Rect l3;
    private final Rect m3;
    private final Rect n3;
    private final Rect o3;
    private final Rect p3;
    @NonNull
    private WindowInsetsCompat q3;
    @NonNull
    private WindowInsetsCompat r3;
    private int s;
    @NonNull
    private WindowInsetsCompat s3;
    @NonNull
    private WindowInsetsCompat t3;
    private ActionBarVisibilityCallback u3;
    private OverScroller v3;
    ViewPropertyAnimator w3;
    final AnimatorListenerAdapter x3;
    private final Runnable y3;
    private final Runnable z3;

    public interface ActionBarVisibilityCallback {
        void a();

        void b();

        void c(boolean z);

        void d();

        void e();

        void f(int i2);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    private static final class NoSystemUiLayoutFlagView extends View {
        NoSystemUiLayoutFlagView(Context context) {
            super(context);
            setWillNotDraw(true);
        }

        public int getWindowSystemUiVisibility() {
            return 0;
        }
    }

    public ActionBarOverlayLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void A(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(E3);
        boolean z = false;
        this.s = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.b3 = drawable;
        if (drawable == null) {
            z = true;
        }
        setWillNotDraw(z);
        obtainStyledAttributes.recycle();
        this.v3 = new OverScroller(context);
    }

    private void D() {
        z();
        postDelayed(this.z3, 600);
    }

    private void E() {
        z();
        postDelayed(this.y3, 600);
    }

    private void G() {
        z();
        this.y3.run();
    }

    private boolean H(float f2) {
        this.v3.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.v3.getFinalY() > this.Z2.getHeight();
    }

    private void b() {
        z();
        this.z3.run();
    }

    private boolean c(@NonNull View view, @NonNull Rect rect, boolean z, boolean z2, boolean z4, boolean z5) {
        boolean z6;
        int i2;
        int i4;
        int i5;
        int i6;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!z || layoutParams.leftMargin == (i6 = rect.left)) {
            z6 = false;
        } else {
            layoutParams.leftMargin = i6;
            z6 = true;
        }
        if (z2 && layoutParams.topMargin != (i5 = rect.top)) {
            layoutParams.topMargin = i5;
            z6 = true;
        }
        if (z5 && layoutParams.rightMargin != (i4 = rect.right)) {
            layoutParams.rightMargin = i4;
            z6 = true;
        }
        if (!z4 || layoutParams.bottomMargin == (i2 = rect.bottom)) {
            return z6;
        }
        layoutParams.bottomMargin = i2;
        return true;
    }

    private boolean v() {
        ViewCompat.o(this.B3, F3, this.l3);
        return !this.l3.equals(G3);
    }

    private DecorToolbar y(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public boolean B() {
        return this.e3;
    }

    public boolean C() {
        return this.c3;
    }

    /* access modifiers changed from: package-private */
    public void F() {
        if (this.Y2 == null) {
            this.Y2 = (ContentFrameLayout) findViewById(R.id.f2610b);
            this.Z2 = (ActionBarContainer) findViewById(R.id.f2611c);
            this.a3 = y(findViewById(R.id.f2609a));
        }
    }

    public void a(Menu menu, MenuPresenter.Callback callback) {
        F();
        this.a3.a(menu, callback);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public boolean d() {
        F();
        return this.a3.d();
    }

    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (this.b3 != null) {
            int bottom = this.Z2.getVisibility() == 0 ? (int) (((float) this.Z2.getBottom()) + this.Z2.getTranslationY() + 0.5f) : 0;
            this.b3.setBounds(0, bottom, getWidth(), this.b3.getIntrinsicHeight() + bottom);
            this.b3.draw(canvas);
        }
    }

    public void e() {
        F();
        this.a3.e();
    }

    public boolean f() {
        F();
        return this.a3.f();
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    public void g(View view, int i2, int i4, int i5, int i6, int i7, int[] iArr) {
        q(view, i2, i4, i5, i6, i7);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.Z2;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public int getNestedScrollAxes() {
        return this.A3.a();
    }

    public CharSequence getTitle() {
        F();
        return this.a3.getTitle();
    }

    public boolean h() {
        F();
        return this.a3.h();
    }

    public boolean i() {
        F();
        return this.a3.i();
    }

    public boolean j() {
        F();
        return this.a3.j();
    }

    public boolean k() {
        F();
        return this.a3.k();
    }

    public boolean l() {
        F();
        return this.a3.l();
    }

    public void m(SparseArray<Parcelable> sparseArray) {
        F();
        this.a3.x(sparseArray);
    }

    public void n(int i2) {
        F();
        if (i2 == 2) {
            this.a3.Q();
        } else if (i2 == 5) {
            this.a3.S();
        } else if (i2 == 109) {
            setOverlayMode(true);
        }
    }

    public void o() {
        F();
        this.a3.n();
    }

    @RequiresApi(21)
    public WindowInsets onApplyWindowInsets(@NonNull WindowInsets windowInsets) {
        F();
        WindowInsetsCompat L = WindowInsetsCompat.L(windowInsets, this);
        boolean c2 = c(this.Z2, new Rect(L.p(), L.r(), L.q(), L.o()), true, true, false, true);
        ViewCompat.o(this, L, this.i3);
        Rect rect = this.i3;
        WindowInsetsCompat x = L.x(rect.left, rect.top, rect.right, rect.bottom);
        this.q3 = x;
        boolean z = true;
        if (!this.r3.equals(x)) {
            this.r3 = this.q3;
            c2 = true;
        }
        if (!this.j3.equals(this.i3)) {
            this.j3.set(this.i3);
        } else {
            z = c2;
        }
        if (z) {
            requestLayout();
        }
        return L.a().c().b().J();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        A(getContext());
        ViewCompat.B1(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        z();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i4, int i5, int i6) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i8 = layoutParams.leftMargin + paddingLeft;
                int i9 = layoutParams.topMargin + paddingTop;
                childAt.layout(i8, i9, measuredWidth + i8, measuredHeight + i9);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i4) {
        int i5;
        WindowInsetsCompat a2;
        F();
        measureChildWithMargins(this.Z2, i2, 0, i4, 0);
        LayoutParams layoutParams = (LayoutParams) this.Z2.getLayoutParams();
        int max = Math.max(0, this.Z2.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
        int max2 = Math.max(0, this.Z2.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.Z2.getMeasuredState());
        boolean z = (ViewCompat.F0(this) & 256) != 0;
        if (z) {
            i5 = this.s;
            if (this.d3 && this.Z2.getTabContainer() != null) {
                i5 += this.s;
            }
        } else {
            i5 = this.Z2.getVisibility() != 8 ? this.Z2.getMeasuredHeight() : 0;
        }
        this.k3.set(this.i3);
        this.s3 = this.q3;
        if (this.c3 || z || !v()) {
            a2 = new WindowInsetsCompat.Builder(this.s3).h(Insets.d(this.s3.p(), this.s3.r() + i5, this.s3.q(), this.s3.o())).a();
        } else {
            Rect rect = this.k3;
            rect.top += i5;
            rect.bottom = rect.bottom;
            a2 = this.s3.x(0, i5, 0, 0);
        }
        this.s3 = a2;
        c(this.Y2, this.k3, true, true, true, true);
        if (!this.t3.equals(this.s3)) {
            WindowInsetsCompat windowInsetsCompat = this.s3;
            this.t3 = windowInsetsCompat;
            ViewCompat.p(this.Y2, windowInsetsCompat);
        }
        measureChildWithMargins(this.Y2, i2, 0, i4, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.Y2.getLayoutParams();
        int max3 = Math.max(max, this.Y2.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin);
        int max4 = Math.max(max2, this.Y2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.Y2.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i4, combineMeasuredStates2 << 16));
    }

    public boolean onNestedFling(View view, float f2, float f4, boolean z) {
        if (!this.e3 || !z) {
            return false;
        }
        if (H(f4)) {
            b();
        } else {
            G();
        }
        this.f3 = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f2, float f4) {
        return false;
    }

    public void onNestedPreScroll(View view, int i2, int i4, int[] iArr) {
    }

    public void onNestedScroll(View view, int i2, int i4, int i5, int i6) {
        int i7 = this.g3 + i4;
        this.g3 = i7;
        setActionBarHideOffset(i7);
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.A3.b(view, view2, i2);
        this.g3 = getActionBarHideOffset();
        z();
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.u3;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.e();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        if ((i2 & 2) == 0 || this.Z2.getVisibility() != 0) {
            return false;
        }
        return this.e3;
    }

    public void onStopNestedScroll(View view) {
        if (this.e3 && !this.f3) {
            if (this.g3 <= this.Z2.getHeight()) {
                E();
            } else {
                D();
            }
        }
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.u3;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.b();
        }
    }

    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i2) {
        super.onWindowSystemUiVisibilityChanged(i2);
        F();
        int i4 = this.h3 ^ i2;
        this.h3 = i2;
        boolean z = false;
        boolean z2 = (i2 & 4) == 0;
        if ((i2 & 256) != 0) {
            z = true;
        }
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.u3;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.c(!z);
            if (z2 || !z) {
                this.u3.a();
            } else {
                this.u3.d();
            }
        }
        if ((i4 & 256) != 0 && this.u3 != null) {
            ViewCompat.B1(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.X2 = i2;
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.u3;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.f(i2);
        }
    }

    public void p(SparseArray<Parcelable> sparseArray) {
        F();
        this.a3.K(sparseArray);
    }

    public void q(View view, int i2, int i4, int i5, int i6, int i7) {
        if (i7 == 0) {
            onNestedScroll(view, i2, i4, i5, i6);
        }
    }

    public boolean r(View view, View view2, int i2, int i4) {
        return i4 == 0 && onStartNestedScroll(view, view2, i2);
    }

    public void s(View view, View view2, int i2, int i4) {
        if (i4 == 0) {
            onNestedScrollAccepted(view, view2, i2);
        }
    }

    public void setActionBarHideOffset(int i2) {
        z();
        this.Z2.setTranslationY((float) (-Math.max(0, Math.min(i2, this.Z2.getHeight()))));
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback actionBarVisibilityCallback) {
        this.u3 = actionBarVisibilityCallback;
        if (getWindowToken() != null) {
            this.u3.f(this.X2);
            int i2 = this.h3;
            if (i2 != 0) {
                onWindowSystemUiVisibilityChanged(i2);
                ViewCompat.B1(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.d3 = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.e3) {
            this.e3 = z;
            if (!z) {
                z();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i2) {
        F();
        this.a3.setIcon(i2);
    }

    public void setLogo(int i2) {
        F();
        this.a3.setLogo(i2);
    }

    public void setOverlayMode(boolean z) {
        this.c3 = z;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i2) {
    }

    public void setWindowCallback(Window.Callback callback) {
        F();
        this.a3.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        F();
        this.a3.setWindowTitle(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void t(View view, int i2) {
        if (i2 == 0) {
            onStopNestedScroll(view);
        }
    }

    public void u(View view, int i2, int i4, int[] iArr, int i5) {
        if (i5 == 0) {
            onNestedPreScroll(view, i2, i4, iArr);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* renamed from: x */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: package-private */
    public void z() {
        removeCallbacks(this.y3);
        removeCallbacks(this.z3);
        ViewPropertyAnimator viewPropertyAnimator = this.w3;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public ActionBarOverlayLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.X2 = 0;
        this.i3 = new Rect();
        this.j3 = new Rect();
        this.k3 = new Rect();
        this.l3 = new Rect();
        this.m3 = new Rect();
        this.n3 = new Rect();
        this.o3 = new Rect();
        this.p3 = new Rect();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.f6562c;
        this.q3 = windowInsetsCompat;
        this.r3 = windowInsetsCompat;
        this.s3 = windowInsetsCompat;
        this.t3 = windowInsetsCompat;
        this.x3 = new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.w3 = null;
                actionBarOverlayLayout.f3 = false;
            }

            public void onAnimationEnd(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.w3 = null;
                actionBarOverlayLayout.f3 = false;
            }
        };
        this.y3 = new Runnable() {
            public void run() {
                ActionBarOverlayLayout.this.z();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.w3 = actionBarOverlayLayout.Z2.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.x3);
            }
        };
        this.z3 = new Runnable() {
            public void run() {
                ActionBarOverlayLayout.this.z();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.w3 = actionBarOverlayLayout.Z2.animate().translationY((float) (-ActionBarOverlayLayout.this.Z2.getHeight())).setListener(ActionBarOverlayLayout.this.x3);
            }
        };
        A(context);
        this.A3 = new NestedScrollingParentHelper(this);
        NoSystemUiLayoutFlagView noSystemUiLayoutFlagView = new NoSystemUiLayoutFlagView(context);
        this.B3 = noSystemUiLayoutFlagView;
        addView(noSystemUiLayoutFlagView);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        F();
        this.a3.setIcon(drawable);
    }
}
