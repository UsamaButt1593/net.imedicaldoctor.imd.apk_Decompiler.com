package com.h6ah4i.android.widget.advrecyclerview.utils;

import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapterUtils {
    private RecyclerViewAdapterUtils() {
    }

    public static RecyclerView a(View view) {
        if (view == null) {
            return null;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof RecyclerView) {
            return (RecyclerView) parent;
        }
        if (parent instanceof View) {
            return a((View) parent);
        }
        return null;
    }

    public static View b(View view) {
        if (view == null) {
            return null;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof RecyclerView) {
            return view;
        }
        if (parent instanceof View) {
            return b((View) parent);
        }
        return null;
    }

    public static RecyclerView.ViewHolder c(View view) {
        RecyclerView a2 = a(view);
        View b2 = b(view);
        if (a2 == null || b2 == null) {
            return null;
        }
        return a2.y0(b2);
    }
}
