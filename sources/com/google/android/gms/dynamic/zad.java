package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

final class zad implements zah {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrameLayout f20459a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LayoutInflater f20460b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ViewGroup f20461c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Bundle f20462d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ DeferredLifecycleHelper f20463e;

    zad(DeferredLifecycleHelper deferredLifecycleHelper, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f20463e = deferredLifecycleHelper;
        this.f20459a = frameLayout;
        this.f20460b = layoutInflater;
        this.f20461c = viewGroup;
        this.f20462d = bundle;
    }

    public final void a(LifecycleDelegate lifecycleDelegate) {
        this.f20459a.removeAllViews();
        this.f20459a.addView(this.f20463e.f20443a.f(this.f20460b, this.f20461c, this.f20462d));
    }

    public final int b() {
        return 2;
    }
}
