package com.airbnb.lottie;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

public class TextDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, String> f16917a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final LottieAnimationView f16918b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final LottieDrawable f16919c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f16920d;

    @VisibleForTesting
    TextDelegate() {
        this.f16917a = new HashMap();
        this.f16920d = true;
        this.f16918b = null;
        this.f16919c = null;
    }

    private String a(String str) {
        return str;
    }

    private void c() {
        LottieAnimationView lottieAnimationView = this.f16918b;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
        LottieDrawable lottieDrawable = this.f16919c;
        if (lottieDrawable != null) {
            lottieDrawable.invalidateSelf();
        }
    }

    public final String b(String str) {
        if (this.f16920d && this.f16917a.containsKey(str)) {
            return this.f16917a.get(str);
        }
        String a2 = a(str);
        if (this.f16920d) {
            this.f16917a.put(str, a2);
        }
        return a2;
    }

    public void d() {
        this.f16917a.clear();
        c();
    }

    public void e(String str) {
        this.f16917a.remove(str);
        c();
    }

    public void f(boolean z) {
        this.f16920d = z;
    }

    public void g(String str, String str2) {
        this.f16917a.put(str, str2);
        c();
    }

    public TextDelegate(LottieAnimationView lottieAnimationView) {
        this.f16917a = new HashMap();
        this.f16920d = true;
        this.f16918b = lottieAnimationView;
        this.f16919c = null;
    }

    public TextDelegate(LottieDrawable lottieDrawable) {
        this.f16917a = new HashMap();
        this.f16920d = true;
        this.f16919c = lottieDrawable;
        this.f16918b = null;
    }
}
