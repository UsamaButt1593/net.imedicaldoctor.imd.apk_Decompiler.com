package com.google.android.material.carousel;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FullScreenCarouselStrategy extends CarouselStrategy {
    /* access modifiers changed from: package-private */
    @NonNull
    public KeylineState g(@NonNull Carousel carousel, @NonNull View view) {
        float d2;
        int i2;
        int i3;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (carousel.g()) {
            d2 = (float) carousel.c();
            i2 = layoutParams.leftMargin;
            i3 = layoutParams.rightMargin;
        } else {
            d2 = (float) carousel.d();
            i2 = layoutParams.topMargin;
            i3 = layoutParams.bottomMargin;
        }
        float f2 = (float) (i2 + i3);
        return CarouselStrategyHelper.e(view.getContext(), f2, d2, new Arrangement(0, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0, Math.min(d2 + f2, d2), 1, d2));
    }
}
