package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;

class AppCompatBackgroundHelper {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f3032a;

    /* renamed from: b  reason: collision with root package name */
    private final AppCompatDrawableManager f3033b;

    /* renamed from: c  reason: collision with root package name */
    private int f3034c = -1;

    /* renamed from: d  reason: collision with root package name */
    private TintInfo f3035d;

    /* renamed from: e  reason: collision with root package name */
    private TintInfo f3036e;

    /* renamed from: f  reason: collision with root package name */
    private TintInfo f3037f;

    AppCompatBackgroundHelper(@NonNull View view) {
        this.f3032a = view;
        this.f3033b = AppCompatDrawableManager.b();
    }

    private boolean a(@NonNull Drawable drawable) {
        if (this.f3037f == null) {
            this.f3037f = new TintInfo();
        }
        TintInfo tintInfo = this.f3037f;
        tintInfo.a();
        ColorStateList O = ViewCompat.O(this.f3032a);
        if (O != null) {
            tintInfo.f3315d = true;
            tintInfo.f3312a = O;
        }
        PorterDuff.Mode P = ViewCompat.P(this.f3032a);
        if (P != null) {
            tintInfo.f3314c = true;
            tintInfo.f3313b = P;
        }
        if (!tintInfo.f3315d && !tintInfo.f3314c) {
            return false;
        }
        AppCompatDrawableManager.j(drawable, tintInfo, this.f3032a.getDrawableState());
        return true;
    }

    private boolean k() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 > 21 ? this.f3035d != null : i2 == 21;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        Drawable background = this.f3032a.getBackground();
        if (background == null) {
            return;
        }
        if (!k() || !a(background)) {
            TintInfo tintInfo = this.f3036e;
            if (tintInfo != null) {
                AppCompatDrawableManager.j(background, tintInfo, this.f3032a.getDrawableState());
                return;
            }
            TintInfo tintInfo2 = this.f3035d;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.j(background, tintInfo2, this.f3032a.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList c() {
        TintInfo tintInfo = this.f3036e;
        if (tintInfo != null) {
            return tintInfo.f3312a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        TintInfo tintInfo = this.f3036e;
        if (tintInfo != null) {
            return tintInfo.f3313b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void e(@Nullable AttributeSet attributeSet, int i2) {
        Context context = this.f3032a.getContext();
        int[] iArr = R.styleable.c7;
        TintTypedArray G = TintTypedArray.G(context, attributeSet, iArr, i2, 0);
        View view = this.f3032a;
        ViewCompat.F1(view, view.getContext(), iArr, attributeSet, G.B(), i2, 0);
        try {
            int i3 = R.styleable.d7;
            if (G.C(i3)) {
                this.f3034c = G.u(i3, -1);
                ColorStateList f2 = this.f3033b.f(this.f3032a.getContext(), this.f3034c);
                if (f2 != null) {
                    h(f2);
                }
            }
            int i4 = R.styleable.e7;
            if (G.C(i4)) {
                ViewCompat.Q1(this.f3032a, G.d(i4));
            }
            int i5 = R.styleable.f7;
            if (G.C(i5)) {
                ViewCompat.R1(this.f3032a, DrawableUtils.e(G.o(i5, -1), (PorterDuff.Mode) null));
            }
            G.I();
        } catch (Throwable th) {
            G.I();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void f(Drawable drawable) {
        this.f3034c = -1;
        h((ColorStateList) null);
        b();
    }

    /* access modifiers changed from: package-private */
    public void g(int i2) {
        this.f3034c = i2;
        AppCompatDrawableManager appCompatDrawableManager = this.f3033b;
        h(appCompatDrawableManager != null ? appCompatDrawableManager.f(this.f3032a.getContext(), i2) : null);
        b();
    }

    /* access modifiers changed from: package-private */
    public void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f3035d == null) {
                this.f3035d = new TintInfo();
            }
            TintInfo tintInfo = this.f3035d;
            tintInfo.f3312a = colorStateList;
            tintInfo.f3315d = true;
        } else {
            this.f3035d = null;
        }
        b();
    }

    /* access modifiers changed from: package-private */
    public void i(ColorStateList colorStateList) {
        if (this.f3036e == null) {
            this.f3036e = new TintInfo();
        }
        TintInfo tintInfo = this.f3036e;
        tintInfo.f3312a = colorStateList;
        tintInfo.f3315d = true;
        b();
    }

    /* access modifiers changed from: package-private */
    public void j(PorterDuff.Mode mode) {
        if (this.f3036e == null) {
            this.f3036e = new TintInfo();
        }
        TintInfo tintInfo = this.f3036e;
        tintInfo.f3313b = mode;
        tintInfo.f3314c = true;
        b();
    }
}
