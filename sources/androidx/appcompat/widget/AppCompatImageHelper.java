package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AppCompatImageHelper {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f3100a;

    /* renamed from: b  reason: collision with root package name */
    private TintInfo f3101b;

    /* renamed from: c  reason: collision with root package name */
    private TintInfo f3102c;

    /* renamed from: d  reason: collision with root package name */
    private TintInfo f3103d;

    /* renamed from: e  reason: collision with root package name */
    private int f3104e = 0;

    public AppCompatImageHelper(@NonNull ImageView imageView) {
        this.f3100a = imageView;
    }

    private boolean a(@NonNull Drawable drawable) {
        if (this.f3103d == null) {
            this.f3103d = new TintInfo();
        }
        TintInfo tintInfo = this.f3103d;
        tintInfo.a();
        ColorStateList a2 = ImageViewCompat.a(this.f3100a);
        if (a2 != null) {
            tintInfo.f3315d = true;
            tintInfo.f3312a = a2;
        }
        PorterDuff.Mode b2 = ImageViewCompat.b(this.f3100a);
        if (b2 != null) {
            tintInfo.f3314c = true;
            tintInfo.f3313b = b2;
        }
        if (!tintInfo.f3315d && !tintInfo.f3314c) {
            return false;
        }
        AppCompatDrawableManager.j(drawable, tintInfo, this.f3100a.getDrawableState());
        return true;
    }

    private boolean m() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 > 21 ? this.f3101b != null : i2 == 21;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (this.f3100a.getDrawable() != null) {
            this.f3100a.getDrawable().setLevel(this.f3104e);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        Drawable drawable = this.f3100a.getDrawable();
        if (drawable != null) {
            DrawableUtils.b(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!m() || !a(drawable)) {
            TintInfo tintInfo = this.f3102c;
            if (tintInfo != null) {
                AppCompatDrawableManager.j(drawable, tintInfo, this.f3100a.getDrawableState());
                return;
            }
            TintInfo tintInfo2 = this.f3101b;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.j(drawable, tintInfo2, this.f3100a.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList d() {
        TintInfo tintInfo = this.f3102c;
        if (tintInfo != null) {
            return tintInfo.f3312a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode e() {
        TintInfo tintInfo = this.f3102c;
        if (tintInfo != null) {
            return tintInfo.f3313b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return !(this.f3100a.getBackground() instanceof RippleDrawable);
    }

    public void g(AttributeSet attributeSet, int i2) {
        int u;
        Context context = this.f3100a.getContext();
        int[] iArr = R.styleable.d0;
        TintTypedArray G = TintTypedArray.G(context, attributeSet, iArr, i2, 0);
        ImageView imageView = this.f3100a;
        ViewCompat.F1(imageView, imageView.getContext(), iArr, attributeSet, G.B(), i2, 0);
        try {
            Drawable drawable = this.f3100a.getDrawable();
            if (!(drawable != null || (u = G.u(R.styleable.f0, -1)) == -1 || (drawable = AppCompatResources.b(this.f3100a.getContext(), u)) == null)) {
                this.f3100a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                DrawableUtils.b(drawable);
            }
            int i3 = R.styleable.g0;
            if (G.C(i3)) {
                ImageViewCompat.c(this.f3100a, G.d(i3));
            }
            int i4 = R.styleable.h0;
            if (G.C(i4)) {
                ImageViewCompat.d(this.f3100a, DrawableUtils.e(G.o(i4, -1), (PorterDuff.Mode) null));
            }
            G.I();
        } catch (Throwable th) {
            G.I();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void h(@NonNull Drawable drawable) {
        this.f3104e = drawable.getLevel();
    }

    public void i(int i2) {
        if (i2 != 0) {
            Drawable b2 = AppCompatResources.b(this.f3100a.getContext(), i2);
            if (b2 != null) {
                DrawableUtils.b(b2);
            }
            this.f3100a.setImageDrawable(b2);
        } else {
            this.f3100a.setImageDrawable((Drawable) null);
        }
        c();
    }

    /* access modifiers changed from: package-private */
    public void j(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f3101b == null) {
                this.f3101b = new TintInfo();
            }
            TintInfo tintInfo = this.f3101b;
            tintInfo.f3312a = colorStateList;
            tintInfo.f3315d = true;
        } else {
            this.f3101b = null;
        }
        c();
    }

    /* access modifiers changed from: package-private */
    public void k(ColorStateList colorStateList) {
        if (this.f3102c == null) {
            this.f3102c = new TintInfo();
        }
        TintInfo tintInfo = this.f3102c;
        tintInfo.f3312a = colorStateList;
        tintInfo.f3315d = true;
        c();
    }

    /* access modifiers changed from: package-private */
    public void l(PorterDuff.Mode mode) {
        if (this.f3102c == null) {
            this.f3102c = new TintInfo();
        }
        TintInfo tintInfo = this.f3102c;
        tintInfo.f3313b = mode;
        tintInfo.f3314c = true;
        c();
    }
}
