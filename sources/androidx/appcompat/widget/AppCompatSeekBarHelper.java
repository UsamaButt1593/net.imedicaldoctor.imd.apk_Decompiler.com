package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;

class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {

    /* renamed from: d  reason: collision with root package name */
    private final SeekBar f3128d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f3129e;

    /* renamed from: f  reason: collision with root package name */
    private ColorStateList f3130f = null;

    /* renamed from: g  reason: collision with root package name */
    private PorterDuff.Mode f3131g = null;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3132h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f3133i = false;

    AppCompatSeekBarHelper(SeekBar seekBar) {
        super(seekBar);
        this.f3128d = seekBar;
    }

    private void f() {
        Drawable drawable = this.f3129e;
        if (drawable == null) {
            return;
        }
        if (this.f3132h || this.f3133i) {
            Drawable r = DrawableCompat.r(drawable.mutate());
            this.f3129e = r;
            if (this.f3132h) {
                DrawableCompat.o(r, this.f3130f);
            }
            if (this.f3133i) {
                DrawableCompat.p(this.f3129e, this.f3131g);
            }
            if (this.f3129e.isStateful()) {
                this.f3129e.setState(this.f3128d.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(AttributeSet attributeSet, int i2) {
        super.c(attributeSet, i2);
        Context context = this.f3128d.getContext();
        int[] iArr = R.styleable.i0;
        TintTypedArray G = TintTypedArray.G(context, attributeSet, iArr, i2, 0);
        SeekBar seekBar = this.f3128d;
        ViewCompat.F1(seekBar, seekBar.getContext(), iArr, attributeSet, G.B(), i2, 0);
        Drawable i3 = G.i(R.styleable.j0);
        if (i3 != null) {
            this.f3128d.setThumb(i3);
        }
        m(G.h(R.styleable.k0));
        int i4 = R.styleable.m0;
        if (G.C(i4)) {
            this.f3131g = DrawableUtils.e(G.o(i4, -1), this.f3131g);
            this.f3133i = true;
        }
        int i5 = R.styleable.l0;
        if (G.C(i5)) {
            this.f3130f = G.d(i5);
            this.f3132h = true;
        }
        G.I();
        f();
    }

    /* access modifiers changed from: package-private */
    public void g(Canvas canvas) {
        if (this.f3129e != null) {
            int max = this.f3128d.getMax();
            int i2 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f3129e.getIntrinsicWidth();
                int intrinsicHeight = this.f3129e.getIntrinsicHeight();
                int i3 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i2 = intrinsicHeight / 2;
                }
                this.f3129e.setBounds(-i3, -i2, i3, i2);
                float width = ((float) ((this.f3128d.getWidth() - this.f3128d.getPaddingLeft()) - this.f3128d.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.f3128d.getPaddingLeft(), (float) (this.f3128d.getHeight() / 2));
                for (int i4 = 0; i4 <= max; i4++) {
                    this.f3129e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void h() {
        Drawable drawable = this.f3129e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f3128d.getDrawableState())) {
            this.f3128d.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Drawable i() {
        return this.f3129e;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ColorStateList j() {
        return this.f3130f;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public PorterDuff.Mode k() {
        return this.f3131g;
    }

    /* access modifiers changed from: package-private */
    public void l() {
        Drawable drawable = this.f3129e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: package-private */
    public void m(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f3129e;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f3129e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f3128d);
            DrawableCompat.m(drawable, this.f3128d.getLayoutDirection());
            if (drawable.isStateful()) {
                drawable.setState(this.f3128d.getDrawableState());
            }
            f();
        }
        this.f3128d.invalidate();
    }

    /* access modifiers changed from: package-private */
    public void n(@Nullable ColorStateList colorStateList) {
        this.f3130f = colorStateList;
        this.f3132h = true;
        f();
    }

    /* access modifiers changed from: package-private */
    public void o(@Nullable PorterDuff.Mode mode) {
        this.f3131g = mode;
        this.f3133i = true;
        f();
    }
}
