package com.google.android.material.carousel;

import android.view.View;

public final /* synthetic */ class b implements View.OnLayoutChangeListener {
    public final /* synthetic */ CarouselLayoutManager s;

    public /* synthetic */ b(CarouselLayoutManager carouselLayoutManager) {
        this.s = carouselLayoutManager;
    }

    public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.s.h3(view, i2, i3, i4, i5, i6, i7, i8, i9);
    }
}
