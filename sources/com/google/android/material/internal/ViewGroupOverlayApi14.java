package com.google.android.material.internal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

class ViewGroupOverlayApi14 extends ViewOverlayApi14 implements ViewGroupOverlayImpl {
    ViewGroupOverlayApi14(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
    }

    static ViewGroupOverlayApi14 f(ViewGroup viewGroup) {
        return (ViewGroupOverlayApi14) ViewOverlayApi14.e(viewGroup);
    }

    public void c(@NonNull View view) {
        this.f21580a.b(view);
    }

    public void d(@NonNull View view) {
        this.f21580a.h(view);
    }
}
