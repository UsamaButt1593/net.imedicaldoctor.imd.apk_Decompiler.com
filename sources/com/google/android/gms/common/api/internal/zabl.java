package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;

final class zabl implements BackgroundDetector.BackgroundStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GoogleApiManager f20104a;

    zabl(GoogleApiManager googleApiManager) {
        this.f20104a = googleApiManager;
    }

    public final void a(boolean z) {
        GoogleApiManager googleApiManager = this.f20104a;
        googleApiManager.i3.sendMessage(googleApiManager.i3.obtainMessage(1, Boolean.valueOf(z)));
    }
}
