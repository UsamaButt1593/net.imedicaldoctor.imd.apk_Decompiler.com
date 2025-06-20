package com.github.chrisbanes.photoview;

import android.annotation.TargetApi;
import android.view.View;

class Compat {

    /* renamed from: a  reason: collision with root package name */
    private static final int f18720a = 16;

    Compat() {
    }

    public static void a(View view, Runnable runnable) {
        b(view, runnable);
    }

    @TargetApi(16)
    private static void b(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
