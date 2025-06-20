package com.h6ah4i.android.widget.advrecyclerview.utils;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CustomRecyclerViewUtils {
    public static RecyclerView.ViewHolder a(RecyclerView recyclerView, float f2, float f3) {
        View f0 = recyclerView.f0(f2, f3);
        if (f0 != null) {
            return recyclerView.y0(f0);
        }
        return null;
    }

    public static RecyclerView.ViewHolder b(RecyclerView recyclerView, float f2, float f3) {
        View c2 = c(recyclerView, f2, f3);
        if (c2 != null) {
            return recyclerView.y0(c2);
        }
        return null;
    }

    private static View c(ViewGroup viewGroup, float f2, float f3) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (f2 >= ((float) childAt.getLeft()) && f2 <= ((float) childAt.getRight()) && f3 >= ((float) childAt.getTop()) && f3 <= ((float) childAt.getBottom())) {
                return childAt;
            }
        }
        return null;
    }

    public static int d(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).x2();
        }
        return -1;
    }

    public static int e(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).B2();
        }
        return -1;
    }

    public static int f(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).C2();
        }
        return -1;
    }

    public static int g(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).E2();
        }
        return -1;
    }

    public static Rect h(RecyclerView.LayoutManager layoutManager, View view, Rect rect) {
        rect.left = layoutManager.n0(view);
        rect.right = layoutManager.y0(view);
        rect.top = layoutManager.B0(view);
        rect.bottom = layoutManager.T(view);
        return rect;
    }

    public static Rect i(View view, Rect rect) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            rect.left = marginLayoutParams.leftMargin;
            rect.right = marginLayoutParams.rightMargin;
            rect.top = marginLayoutParams.topMargin;
            rect.bottom = marginLayoutParams.bottomMargin;
        } else {
            rect.bottom = 0;
            rect.top = 0;
            rect.right = 0;
            rect.left = 0;
        }
        return rect;
    }

    public static int j(RecyclerView.ViewHolder viewHolder) {
        int G = viewHolder.G();
        if (G == viewHolder.B()) {
            return G;
        }
        return -1;
    }

    public static Rect k(View view, Rect rect) {
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        return rect;
    }
}
