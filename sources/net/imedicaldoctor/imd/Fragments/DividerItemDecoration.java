package net.imedicaldoctor.imd.Fragments;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f29701c = {16843284};

    /* renamed from: d  reason: collision with root package name */
    public static final int f29702d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static final int f29703e = 1;

    /* renamed from: a  reason: collision with root package name */
    private final Drawable f29704a;

    /* renamed from: b  reason: collision with root package name */
    private int f29705b;

    public DividerItemDecoration(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f29701c);
        this.f29704a = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        n(i2);
    }

    public void f(Rect rect, int i2, RecyclerView recyclerView) {
        if (this.f29705b == 1) {
            rect.set(0, 0, 0, this.f29704a.getIntrinsicHeight());
        } else {
            rect.set(0, 0, this.f29704a.getIntrinsicWidth(), 0);
        }
    }

    public void h(Canvas canvas, RecyclerView recyclerView) {
        if (this.f29705b == 1) {
            m(canvas, recyclerView);
        } else {
            l(canvas, recyclerView);
        }
    }

    public void l(Canvas canvas, RecyclerView recyclerView) {
        int paddingTop = recyclerView.getPaddingTop();
        int height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            int right = childAt.getRight() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).rightMargin;
            this.f29704a.setBounds(right, paddingTop, this.f29704a.getIntrinsicHeight() + right, height);
            this.f29704a.draw(canvas);
        }
    }

    public void m(Canvas canvas, RecyclerView recyclerView) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            this.f29704a.setBounds(paddingLeft, bottom, width, this.f29704a.getIntrinsicHeight() + bottom);
            this.f29704a.draw(canvas);
        }
    }

    public void n(int i2) {
        if (i2 == 0 || i2 == 1) {
            this.f29705b = i2;
            return;
        }
        throw new IllegalArgumentException("invalid orientation");
    }
}
