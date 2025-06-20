package com.timehop.stickyheadersrecyclerview;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.timehop.stickyheadersrecyclerview.caching.HeaderProvider;
import com.timehop.stickyheadersrecyclerview.calculation.DimensionCalculator;
import com.timehop.stickyheadersrecyclerview.util.OrientationProvider;

public class HeaderPositionCalculator {

    /* renamed from: a  reason: collision with root package name */
    private final StickyRecyclerHeadersAdapter f28191a;

    /* renamed from: b  reason: collision with root package name */
    private final OrientationProvider f28192b;

    /* renamed from: c  reason: collision with root package name */
    private final HeaderProvider f28193c;

    /* renamed from: d  reason: collision with root package name */
    private final DimensionCalculator f28194d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f28195e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private final Rect f28196f = new Rect();

    public HeaderPositionCalculator(StickyRecyclerHeadersAdapter stickyRecyclerHeadersAdapter, HeaderProvider headerProvider, OrientationProvider orientationProvider, DimensionCalculator dimensionCalculator) {
        this.f28191a = stickyRecyclerHeadersAdapter;
        this.f28193c = headerProvider;
        this.f28192b = orientationProvider;
        this.f28194d = dimensionCalculator;
    }

    private View a(RecyclerView recyclerView, View view) {
        boolean b2 = this.f28192b.b(recyclerView);
        int i2 = b2 ? -1 : 1;
        int childCount = b2 ? recyclerView.getChildCount() - 1 : 0;
        while (childCount >= 0 && childCount <= recyclerView.getChildCount() - 1) {
            View childAt = recyclerView.getChildAt(childCount);
            if (!j(recyclerView, childAt, view, this.f28192b.a(recyclerView))) {
                return childAt;
            }
            childCount += i2;
        }
        return null;
    }

    private int b(RecyclerView recyclerView) {
        if (recyclerView.getLayoutManager().Z()) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }

    private int c(RecyclerView recyclerView) {
        if (recyclerView.getLayoutManager().Z()) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    private boolean f(int i2) {
        return i2 < 0 || i2 >= this.f28191a.b();
    }

    private void g(Rect rect, RecyclerView recyclerView, View view, View view2, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        this.f28194d.b(this.f28195e, view);
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            i3 = marginLayoutParams.leftMargin;
            i4 = marginLayoutParams.topMargin;
        } else {
            i3 = 0;
            i4 = 0;
        }
        if (i2 == 1) {
            i5 = (view2.getLeft() - i3) + this.f28195e.left;
            i6 = Math.max(((view2.getTop() - i4) - view.getHeight()) - this.f28195e.bottom, c(recyclerView) + this.f28195e.top);
        } else {
            int top = (view2.getTop() - i4) + this.f28195e.top;
            i5 = Math.max(((view2.getLeft() - i3) - view.getWidth()) - this.f28195e.right, b(recyclerView) + this.f28195e.left);
            i6 = top;
        }
        rect.set(i5, i6, view.getWidth() + i5, view.getHeight() + i6);
    }

    private boolean i(RecyclerView recyclerView, View view) {
        View a2 = a(recyclerView, view);
        int u0 = recyclerView.u0(a2);
        if (u0 == -1) {
            return false;
        }
        boolean b2 = this.f28192b.b(recyclerView);
        if (u0 <= 0 || !d(u0, b2)) {
            return false;
        }
        View a3 = this.f28193c.a(recyclerView, u0);
        this.f28194d.b(this.f28195e, a3);
        this.f28194d.b(this.f28196f, view);
        if (this.f28192b.a(recyclerView) == 1) {
            int top = ((a2.getTop() - this.f28195e.bottom) - a3.getHeight()) - this.f28195e.top;
            int paddingTop = recyclerView.getPaddingTop() + view.getBottom();
            Rect rect = this.f28196f;
            return top < (paddingTop + rect.top) + rect.bottom;
        }
        int left = ((a2.getLeft() - this.f28195e.right) - a3.getWidth()) - this.f28195e.left;
        int paddingLeft = recyclerView.getPaddingLeft() + view.getRight();
        Rect rect2 = this.f28196f;
        return left < (paddingLeft + rect2.left) + rect2.right;
    }

    private boolean j(RecyclerView recyclerView, View view, View view2, int i2) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        this.f28194d.b(this.f28195e, view2);
        int u0 = recyclerView.u0(view);
        if (u0 == -1 || this.f28193c.a(recyclerView, u0) != view2) {
            return false;
        }
        if (i2 == 1) {
            int top = view.getTop() - layoutParams.topMargin;
            int c2 = c(recyclerView) + view2.getBottom();
            Rect rect = this.f28195e;
            return top < (c2 + rect.bottom) + rect.top;
        }
        int left = view.getLeft() - layoutParams.leftMargin;
        int b2 = b(recyclerView) + view2.getRight();
        Rect rect2 = this.f28195e;
        return left < (b2 + rect2.right) + rect2.left;
    }

    private void k(RecyclerView recyclerView, int i2, Rect rect, View view, View view2, View view3) {
        this.f28194d.b(this.f28195e, view3);
        this.f28194d.b(this.f28196f, view);
        if (i2 == 1) {
            int c2 = c(recyclerView);
            Rect rect2 = this.f28196f;
            int i3 = c2 + rect2.top + rect2.bottom;
            int top = view2.getTop() - view3.getHeight();
            Rect rect3 = this.f28195e;
            int height = (((top - rect3.bottom) - rect3.top) - view.getHeight()) - i3;
            if (height < i3) {
                rect.top += height;
                return;
            }
            return;
        }
        int b2 = b(recyclerView);
        Rect rect4 = this.f28196f;
        int i4 = b2 + rect4.left + rect4.right;
        int left = view2.getLeft() - view3.getWidth();
        Rect rect5 = this.f28195e;
        int width = (((left - rect5.right) - rect5.left) - view.getWidth()) - i4;
        if (width < i4) {
            rect.left += width;
        }
    }

    public boolean d(int i2, boolean z) {
        if (f(i2)) {
            return false;
        }
        long r = this.f28191a.r(i2);
        if (r < 0) {
            return false;
        }
        int i3 = (z ? 1 : -1) + i2;
        return i2 == (z ? this.f28191a.b() - 1 : 0) || r != (!f(i3) ? this.f28191a.r(i3) : -1);
    }

    public boolean e(View view, int i2, int i3) {
        int i4;
        int i5;
        this.f28194d.b(this.f28195e, view);
        if (i2 == 1) {
            i5 = view.getTop();
            i4 = this.f28195e.top;
        } else {
            i5 = view.getLeft();
            i4 = this.f28195e.left;
        }
        return i5 <= i4 && this.f28191a.r(i3) >= 0;
    }

    public void h(Rect rect, RecyclerView recyclerView, View view, View view2, boolean z) {
        g(rect, recyclerView, view, view2, this.f28192b.a(recyclerView));
        if (z && i(recyclerView, view)) {
            View a2 = a(recyclerView, view);
            RecyclerView recyclerView2 = recyclerView;
            k(recyclerView2, this.f28192b.a(recyclerView), rect, view, a2, this.f28193c.a(recyclerView, recyclerView.u0(a2)));
        }
    }
}
