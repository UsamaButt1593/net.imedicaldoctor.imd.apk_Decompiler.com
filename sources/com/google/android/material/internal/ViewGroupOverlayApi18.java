package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(18)
class ViewGroupOverlayApi18 implements ViewGroupOverlayImpl {

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroupOverlay f21579a;

    ViewGroupOverlayApi18(@NonNull ViewGroup viewGroup) {
        this.f21579a = viewGroup.getOverlay();
    }

    public void a(@NonNull Drawable drawable) {
        this.f21579a.add(drawable);
    }

    public void b(@NonNull Drawable drawable) {
        this.f21579a.remove(drawable);
    }

    public void c(@NonNull View view) {
        this.f21579a.add(view);
    }

    public void d(@NonNull View view) {
        this.f21579a.remove(view);
    }
}
