package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(18)
class ViewOverlayApi18 implements ViewOverlayImpl {

    /* renamed from: a  reason: collision with root package name */
    private final ViewOverlay f21581a;

    ViewOverlayApi18(@NonNull View view) {
        this.f21581a = view.getOverlay();
    }

    public void a(@NonNull Drawable drawable) {
        this.f21581a.add(drawable);
    }

    public void b(@NonNull Drawable drawable) {
        this.f21581a.remove(drawable);
    }
}
