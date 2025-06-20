package com.h6ah4i.android.widget.advrecyclerview.utils;

import androidx.recyclerview.widget.RecyclerView;

public class WrapperAdapterUtils {
    private WrapperAdapterUtils() {
    }

    public static <T> T a(RecyclerView.Adapter adapter, Class<T> cls) {
        if (cls.isInstance(adapter)) {
            return cls.cast(adapter);
        }
        if (adapter instanceof BaseWrapperAdapter) {
            return a(((BaseWrapperAdapter) adapter).d0(), cls);
        }
        return null;
    }

    public static RecyclerView.Adapter b(RecyclerView.Adapter adapter) {
        return c(adapter);
    }

    private static RecyclerView.Adapter c(RecyclerView.Adapter adapter) {
        if (!(adapter instanceof BaseWrapperAdapter)) {
            return adapter;
        }
        BaseWrapperAdapter baseWrapperAdapter = (BaseWrapperAdapter) adapter;
        RecyclerView.Adapter d0 = baseWrapperAdapter.d0();
        baseWrapperAdapter.p0();
        return c(d0);
    }
}
