package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;

class AppCompatCompoundButtonHelper {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CompoundButton f3068a;

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f3069b = null;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f3070c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3071d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3072e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3073f;

    AppCompatCompoundButtonHelper(@NonNull CompoundButton compoundButton) {
        this.f3068a = compoundButton;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        Drawable a2 = CompoundButtonCompat.a(this.f3068a);
        if (a2 == null) {
            return;
        }
        if (this.f3071d || this.f3072e) {
            Drawable mutate = DrawableCompat.r(a2).mutate();
            if (this.f3071d) {
                DrawableCompat.o(mutate, this.f3069b);
            }
            if (this.f3072e) {
                DrawableCompat.p(mutate, this.f3070c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f3068a.getDrawableState());
            }
            this.f3068a.setButtonDrawable(mutate);
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList b() {
        return this.f3069b;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        return this.f3070c;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(12:1|2|(2:6|7)|9|10|(1:14)|15|(1:17)|18|(1:20)|21|22) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x003b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(@androidx.annotation.Nullable android.util.AttributeSet r10, int r11) {
        /*
            r9 = this;
            android.widget.CompoundButton r0 = r9.f3068a
            android.content.Context r0 = r0.getContext()
            int[] r3 = androidx.appcompat.R.styleable.x3
            r8 = 0
            androidx.appcompat.widget.TintTypedArray r0 = androidx.appcompat.widget.TintTypedArray.G(r0, r10, r3, r11, r8)
            android.widget.CompoundButton r1 = r9.f3068a
            android.content.Context r2 = r1.getContext()
            android.content.res.TypedArray r5 = r0.B()
            r7 = 0
            r4 = r10
            r6 = r11
            androidx.core.view.ViewCompat.F1(r1, r2, r3, r4, r5, r6, r7)
            int r10 = androidx.appcompat.R.styleable.z3     // Catch:{ all -> 0x0039 }
            boolean r11 = r0.C(r10)     // Catch:{ all -> 0x0039 }
            if (r11 == 0) goto L_0x003b
            int r10 = r0.u(r10, r8)     // Catch:{ all -> 0x0039 }
            if (r10 == 0) goto L_0x003b
            android.widget.CompoundButton r11 = r9.f3068a     // Catch:{ NotFoundException -> 0x003b }
            android.content.Context r1 = r11.getContext()     // Catch:{ NotFoundException -> 0x003b }
            android.graphics.drawable.Drawable r10 = androidx.appcompat.content.res.AppCompatResources.b(r1, r10)     // Catch:{ NotFoundException -> 0x003b }
            r11.setButtonDrawable(r10)     // Catch:{ NotFoundException -> 0x003b }
            goto L_0x0056
        L_0x0039:
            r10 = move-exception
            goto L_0x0082
        L_0x003b:
            int r10 = androidx.appcompat.R.styleable.y3     // Catch:{ all -> 0x0039 }
            boolean r11 = r0.C(r10)     // Catch:{ all -> 0x0039 }
            if (r11 == 0) goto L_0x0056
            int r10 = r0.u(r10, r8)     // Catch:{ all -> 0x0039 }
            if (r10 == 0) goto L_0x0056
            android.widget.CompoundButton r11 = r9.f3068a     // Catch:{ all -> 0x0039 }
            android.content.Context r1 = r11.getContext()     // Catch:{ all -> 0x0039 }
            android.graphics.drawable.Drawable r10 = androidx.appcompat.content.res.AppCompatResources.b(r1, r10)     // Catch:{ all -> 0x0039 }
            r11.setButtonDrawable(r10)     // Catch:{ all -> 0x0039 }
        L_0x0056:
            int r10 = androidx.appcompat.R.styleable.A3     // Catch:{ all -> 0x0039 }
            boolean r11 = r0.C(r10)     // Catch:{ all -> 0x0039 }
            if (r11 == 0) goto L_0x0067
            android.widget.CompoundButton r11 = r9.f3068a     // Catch:{ all -> 0x0039 }
            android.content.res.ColorStateList r10 = r0.d(r10)     // Catch:{ all -> 0x0039 }
            androidx.core.widget.CompoundButtonCompat.d(r11, r10)     // Catch:{ all -> 0x0039 }
        L_0x0067:
            int r10 = androidx.appcompat.R.styleable.B3     // Catch:{ all -> 0x0039 }
            boolean r11 = r0.C(r10)     // Catch:{ all -> 0x0039 }
            if (r11 == 0) goto L_0x007e
            android.widget.CompoundButton r11 = r9.f3068a     // Catch:{ all -> 0x0039 }
            r1 = -1
            int r10 = r0.o(r10, r1)     // Catch:{ all -> 0x0039 }
            r1 = 0
            android.graphics.PorterDuff$Mode r10 = androidx.appcompat.widget.DrawableUtils.e(r10, r1)     // Catch:{ all -> 0x0039 }
            androidx.core.widget.CompoundButtonCompat.e(r11, r10)     // Catch:{ all -> 0x0039 }
        L_0x007e:
            r0.I()
            return
        L_0x0082:
            r0.I()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatCompoundButtonHelper.d(android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (this.f3073f) {
            this.f3073f = false;
            return;
        }
        this.f3073f = true;
        a();
    }

    /* access modifiers changed from: package-private */
    public void f(ColorStateList colorStateList) {
        this.f3069b = colorStateList;
        this.f3071d = true;
        a();
    }

    /* access modifiers changed from: package-private */
    public void g(@Nullable PorterDuff.Mode mode) {
        this.f3070c = mode;
        this.f3072e = true;
        a();
    }
}
