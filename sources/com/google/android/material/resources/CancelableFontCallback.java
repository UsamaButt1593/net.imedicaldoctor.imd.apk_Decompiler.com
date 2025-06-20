package com.google.android.material.resources;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CancelableFontCallback extends TextAppearanceFontCallback {

    /* renamed from: a  reason: collision with root package name */
    private final Typeface f21701a;

    /* renamed from: b  reason: collision with root package name */
    private final ApplyFont f21702b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f21703c;

    public interface ApplyFont {
        void a(Typeface typeface);
    }

    public CancelableFontCallback(ApplyFont applyFont, Typeface typeface) {
        this.f21701a = typeface;
        this.f21702b = applyFont;
    }

    private void d(Typeface typeface) {
        if (!this.f21703c) {
            this.f21702b.a(typeface);
        }
    }

    public void a(int i2) {
        d(this.f21701a);
    }

    public void b(Typeface typeface, boolean z) {
        d(typeface);
    }

    public void c() {
        this.f21703c = true;
    }
}
