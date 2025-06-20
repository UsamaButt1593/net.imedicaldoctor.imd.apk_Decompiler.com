package com.h6ah4i.android.widget.advrecyclerview.decoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

public class SimpleListDividerDecorator extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private final Drawable f25371a;

    /* renamed from: b  reason: collision with root package name */
    private final int f25372b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f25373c;

    public SimpleListDividerDecorator(Drawable drawable, boolean z) {
        this.f25371a = drawable;
        this.f25372b = drawable.getIntrinsicHeight();
        this.f25373c = z;
    }

    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.f25373c) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(0, 0, 0, this.f25372b);
        }
    }

    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        Canvas canvas2 = canvas;
        RecyclerView recyclerView2 = recyclerView;
        int childCount = recyclerView.getChildCount();
        float f2 = 1.0f;
        float f3 = this.f25373c ? 1.0f : ((float) this.f25372b) + 1.0f;
        if (childCount != 0) {
            int save = canvas2.save(2);
            canvas2.clipRect(recyclerView.getLeft() + recyclerView.getPaddingLeft(), recyclerView.getTop() + recyclerView.getPaddingTop(), recyclerView.getRight() - recyclerView.getPaddingRight(), recyclerView.getBottom() + recyclerView.getPaddingBottom());
            int i2 = 0;
            while (i2 < childCount - 1) {
                View childAt = recyclerView2.getChildAt(i2);
                i2++;
                View childAt2 = recyclerView2.getChildAt(i2);
                if (childAt.getVisibility() == 0 && childAt2.getVisibility() == 0) {
                    if (Math.abs((((float) childAt2.getTop()) + ViewCompat.C0(childAt2)) - (((float) childAt.getBottom()) + ViewCompat.C0(childAt))) < f3) {
                        if (Math.abs((ViewCompat.D0(childAt2) + ViewCompat.T(childAt2)) - (ViewCompat.D0(childAt) + ViewCompat.T(childAt))) < f2) {
                            float L = ViewCompat.L(childAt);
                            float L2 = ViewCompat.L(childAt2);
                            int B0 = (int) (ViewCompat.B0(childAt) + 0.5f);
                            int C0 = (int) (ViewCompat.C0(childAt) + 0.5f);
                            int left = childAt.getLeft();
                            int right = childAt.getRight();
                            int bottom = childAt.getBottom();
                            int i3 = this.f25372b + bottom;
                            this.f25371a.setAlpha((int) (((L + L2) * 127.5f) + 0.5f));
                            this.f25371a.setBounds(left + B0, bottom + C0, right + B0, i3 + C0);
                            this.f25371a.draw(canvas2);
                        }
                    }
                }
                f2 = 1.0f;
            }
            canvas2.restoreToCount(save);
        }
    }
}
