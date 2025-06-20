package com.h6ah4i.android.widget.advrecyclerview.decoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

public class ItemShadowDecorator extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private final NinePatchDrawable f25369a;

    /* renamed from: b  reason: collision with root package name */
    private final Rect f25370b;

    public ItemShadowDecorator(NinePatchDrawable ninePatchDrawable) {
        Rect rect = new Rect();
        this.f25370b = rect;
        this.f25369a = ninePatchDrawable;
        ninePatchDrawable.getPadding(rect);
    }

    private static boolean l(View view) {
        Drawable background;
        if (view.getVisibility() == 0 && ViewCompat.L(view) == 1.0f && (background = view.getBackground()) != null) {
            return !(background instanceof ColorDrawable) || ((ColorDrawable) background).getAlpha() != 0;
        }
        return false;
    }

    public void g(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.set(0, 0, 0, 0);
    }

    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int childCount = recyclerView.getChildCount();
        if (childCount != 0) {
            int save = canvas.save(2);
            canvas.clipRect(recyclerView.getLeft() + Math.max(0, recyclerView.getPaddingLeft() - this.f25370b.left), recyclerView.getTop(), recyclerView.getRight() - Math.max(0, recyclerView.getPaddingRight() - this.f25370b.right), recyclerView.getBottom());
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = recyclerView.getChildAt(i2);
                if (l(childAt)) {
                    int B0 = (int) (ViewCompat.B0(childAt) + 0.5f);
                    int C0 = (int) (ViewCompat.C0(childAt) + 0.5f);
                    int left = childAt.getLeft() - this.f25370b.left;
                    int right = childAt.getRight() + this.f25370b.right;
                    this.f25369a.setBounds(left + B0, (childAt.getTop() - this.f25370b.top) + C0, right + B0, childAt.getBottom() + this.f25370b.bottom + C0);
                    this.f25369a.draw(canvas);
                }
            }
            canvas.restoreToCount(save);
        }
    }
}
