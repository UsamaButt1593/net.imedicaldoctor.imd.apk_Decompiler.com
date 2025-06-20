package com.google.android.material.card;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class MaterialCardViewHelper {
    private static final double A = Math.cos(Math.toRadians(45.0d));
    private static final float B = 1.5f;
    private static final int C = 2;
    private static final Drawable D = (Build.VERSION.SDK_INT <= 28 ? new ColorDrawable() : null);
    public static final int E = 300;
    private static final int z = -1;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f20902a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Rect f20903b = new Rect();
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final MaterialShapeDrawable f20904c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final MaterialShapeDrawable f20905d;
    @Dimension

    /* renamed from: e  reason: collision with root package name */
    private int f20906e;
    @Dimension

    /* renamed from: f  reason: collision with root package name */
    private int f20907f;

    /* renamed from: g  reason: collision with root package name */
    private int f20908g;
    @Dimension

    /* renamed from: h  reason: collision with root package name */
    private int f20909h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private Drawable f20910i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private Drawable f20911j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f20912k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private ColorStateList f20913l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private ShapeAppearanceModel f20914m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private ColorStateList f20915n;
    @Nullable
    private Drawable o;
    @Nullable
    private LayerDrawable p;
    @Nullable
    private MaterialShapeDrawable q;
    @Nullable
    private MaterialShapeDrawable r;
    private boolean s = false;
    private boolean t;
    @Nullable
    private ValueAnimator u;
    private final TimeInterpolator v;
    private final int w;
    private final int x;
    private float y = 0.0f;

    public MaterialCardViewHelper(@NonNull MaterialCardView materialCardView, AttributeSet attributeSet, int i2, @StyleRes int i3) {
        this.f20902a = materialCardView;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(materialCardView.getContext(), attributeSet, i2, i3);
        this.f20904c = materialShapeDrawable;
        materialShapeDrawable.a0(materialCardView.getContext());
        materialShapeDrawable.w0(-12303292);
        ShapeAppearanceModel.Builder v2 = materialShapeDrawable.getShapeAppearanceModel().v();
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, R.styleable.N5, i2, R.style.B4);
        int i4 = R.styleable.R5;
        if (obtainStyledAttributes.hasValue(i4)) {
            v2.o(obtainStyledAttributes.getDimension(i4, 0.0f));
        }
        this.f20905d = new MaterialShapeDrawable();
        Z(v2.m());
        this.v = MotionUtils.g(materialCardView.getContext(), R.attr.Xd, AnimationUtils.f20766a);
        this.w = MotionUtils.f(materialCardView.getContext(), R.attr.Nd, 300);
        this.x = MotionUtils.f(materialCardView.getContext(), R.attr.Md, 300);
        obtainStyledAttributes.recycle();
    }

    @NonNull
    private Drawable D(Drawable drawable) {
        int i2;
        int i3;
        if (this.f20902a.getUseCompatPadding()) {
            i2 = (int) Math.ceil((double) f());
            i3 = (int) Math.ceil((double) e());
        } else {
            i3 = 0;
            i2 = 0;
        }
        return new InsetDrawable(drawable, i3, i2, i3, i2) {
            public int getMinimumHeight() {
                return -1;
            }

            public int getMinimumWidth() {
                return -1;
            }

            public boolean getPadding(Rect rect) {
                return false;
            }
        };
    }

    private boolean G() {
        return (this.f20908g & 80) == 80;
    }

    private boolean H() {
        return (this.f20908g & GravityCompat.f6388c) == 8388613;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f20911j.setAlpha((int) (255.0f * floatValue));
        this.y = floatValue;
    }

    private float c() {
        return Math.max(Math.max(d(this.f20914m.q(), this.f20904c.T()), d(this.f20914m.s(), this.f20904c.U())), Math.max(d(this.f20914m.k(), this.f20904c.v()), d(this.f20914m.i(), this.f20904c.u())));
    }

    private float d(CornerTreatment cornerTreatment, float f2) {
        if (cornerTreatment instanceof RoundedCornerTreatment) {
            return (float) ((1.0d - A) * ((double) f2));
        }
        if (cornerTreatment instanceof CutCornerTreatment) {
            return f2 / 2.0f;
        }
        return 0.0f;
    }

    private boolean d0() {
        return this.f20902a.getPreventCornerOverlap() && !g();
    }

    private float e() {
        return this.f20902a.getMaxCardElevation() + (e0() ? c() : 0.0f);
    }

    private boolean e0() {
        return this.f20902a.getPreventCornerOverlap() && g() && this.f20902a.getUseCompatPadding();
    }

    private float f() {
        return (this.f20902a.getMaxCardElevation() * B) + (e0() ? c() : 0.0f);
    }

    private boolean f0() {
        if (this.f20902a.isClickable()) {
            return true;
        }
        View view = this.f20902a;
        while (view.isDuplicateParentStateEnabled() && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        return view.isClickable();
    }

    private boolean g() {
        return this.f20904c.f0();
    }

    @NonNull
    private Drawable h() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        MaterialShapeDrawable j2 = j();
        this.q = j2;
        j2.p0(this.f20912k);
        stateListDrawable.addState(new int[]{16842919}, this.q);
        return stateListDrawable;
    }

    @NonNull
    private Drawable i() {
        if (!RippleUtils.f21729a) {
            return h();
        }
        this.r = j();
        return new RippleDrawable(this.f20912k, (Drawable) null, this.r);
    }

    @NonNull
    private MaterialShapeDrawable j() {
        return new MaterialShapeDrawable(this.f20914m);
    }

    private void j0(Drawable drawable) {
        if (Build.VERSION.SDK_INT < 23 || !(this.f20902a.getForeground() instanceof InsetDrawable)) {
            this.f20902a.setForeground(D(drawable));
        } else {
            ((InsetDrawable) this.f20902a.getForeground()).setDrawable(drawable);
        }
    }

    private void l0() {
        Drawable drawable;
        if (!RippleUtils.f21729a || (drawable = this.o) == null) {
            MaterialShapeDrawable materialShapeDrawable = this.q;
            if (materialShapeDrawable != null) {
                materialShapeDrawable.p0(this.f20912k);
                return;
            }
            return;
        }
        ((RippleDrawable) drawable).setColor(this.f20912k);
    }

    @NonNull
    private Drawable t() {
        if (this.o == null) {
            this.o = i();
        }
        if (this.p == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.o, this.f20905d, this.f20911j});
            this.p = layerDrawable;
            layerDrawable.setId(2, R.id.p3);
        }
        return this.p;
    }

    private float v() {
        if (!this.f20902a.getPreventCornerOverlap() || !this.f20902a.getUseCompatPadding()) {
            return 0.0f;
        }
        return (float) ((1.0d - A) * ((double) this.f20902a.getCardViewRadius()));
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ColorStateList A() {
        return this.f20915n;
    }

    /* access modifiers changed from: package-private */
    @Dimension
    public int B() {
        return this.f20909h;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Rect C() {
        return this.f20903b;
    }

    /* access modifiers changed from: package-private */
    public boolean E() {
        return this.s;
    }

    /* access modifiers changed from: package-private */
    public boolean F() {
        return this.t;
    }

    /* access modifiers changed from: package-private */
    public void J(@NonNull TypedArray typedArray) {
        ColorStateList a2 = MaterialResources.a(this.f20902a.getContext(), typedArray, R.styleable.on);
        this.f20915n = a2;
        if (a2 == null) {
            this.f20915n = ColorStateList.valueOf(-1);
        }
        this.f20909h = typedArray.getDimensionPixelSize(R.styleable.pn, 0);
        boolean z2 = typedArray.getBoolean(R.styleable.dn, false);
        this.t = z2;
        this.f20902a.setLongClickable(z2);
        this.f20913l = MaterialResources.a(this.f20902a.getContext(), typedArray, R.styleable.jn);
        R(MaterialResources.e(this.f20902a.getContext(), typedArray, R.styleable.fn));
        U(typedArray.getDimensionPixelSize(R.styleable.in, 0));
        T(typedArray.getDimensionPixelSize(R.styleable.hn, 0));
        this.f20908g = typedArray.getInteger(R.styleable.gn, 8388661);
        ColorStateList a3 = MaterialResources.a(this.f20902a.getContext(), typedArray, R.styleable.kn);
        this.f20912k = a3;
        if (a3 == null) {
            this.f20912k = ColorStateList.valueOf(MaterialColors.d(this.f20902a, R.attr.q3));
        }
        N(MaterialResources.a(this.f20902a.getContext(), typedArray, R.styleable.en));
        l0();
        i0();
        m0();
        this.f20902a.setBackgroundInternal(D(this.f20904c));
        Drawable t2 = f0() ? t() : this.f20905d;
        this.f20910i = t2;
        this.f20902a.setForeground(D(t2));
    }

    /* access modifiers changed from: package-private */
    public void K(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        if (this.p != null) {
            if (this.f20902a.getUseCompatPadding()) {
                i5 = (int) Math.ceil((double) (f() * 2.0f));
                i4 = (int) Math.ceil((double) (e() * 2.0f));
            } else {
                i5 = 0;
                i4 = 0;
            }
            int i8 = H() ? ((i2 - this.f20906e) - this.f20907f) - i4 : this.f20906e;
            int i9 = G() ? this.f20906e : ((i3 - this.f20906e) - this.f20907f) - i5;
            int i10 = H() ? this.f20906e : ((i2 - this.f20906e) - this.f20907f) - i4;
            int i11 = G() ? ((i3 - this.f20906e) - this.f20907f) - i5 : this.f20906e;
            if (ViewCompat.c0(this.f20902a) == 1) {
                i7 = i10;
                i6 = i8;
            } else {
                i6 = i10;
                i7 = i8;
            }
            this.p.setLayerInset(2, i7, i11, i6, i9);
        }
    }

    /* access modifiers changed from: package-private */
    public void L(boolean z2) {
        this.s = z2;
    }

    /* access modifiers changed from: package-private */
    public void M(ColorStateList colorStateList) {
        this.f20904c.p0(colorStateList);
    }

    /* access modifiers changed from: package-private */
    public void N(@Nullable ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.f20905d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        materialShapeDrawable.p0(colorStateList);
    }

    /* access modifiers changed from: package-private */
    public void O(boolean z2) {
        this.t = z2;
    }

    public void P(boolean z2) {
        Q(z2, false);
    }

    public void Q(boolean z2, boolean z3) {
        Drawable drawable = this.f20911j;
        if (drawable == null) {
            return;
        }
        if (z3) {
            b(z2);
            return;
        }
        drawable.setAlpha(z2 ? 255 : 0);
        this.y = z2 ? 1.0f : 0.0f;
    }

    /* access modifiers changed from: package-private */
    public void R(@Nullable Drawable drawable) {
        if (drawable != null) {
            Drawable mutate = DrawableCompat.r(drawable).mutate();
            this.f20911j = mutate;
            DrawableCompat.o(mutate, this.f20913l);
            P(this.f20902a.isChecked());
        } else {
            this.f20911j = D;
        }
        LayerDrawable layerDrawable = this.p;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(R.id.p3, this.f20911j);
        }
    }

    /* access modifiers changed from: package-private */
    public void S(int i2) {
        this.f20908g = i2;
        K(this.f20902a.getMeasuredWidth(), this.f20902a.getMeasuredHeight());
    }

    /* access modifiers changed from: package-private */
    public void T(@Dimension int i2) {
        this.f20906e = i2;
    }

    /* access modifiers changed from: package-private */
    public void U(@Dimension int i2) {
        this.f20907f = i2;
    }

    /* access modifiers changed from: package-private */
    public void V(@Nullable ColorStateList colorStateList) {
        this.f20913l = colorStateList;
        Drawable drawable = this.f20911j;
        if (drawable != null) {
            DrawableCompat.o(drawable, colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void W(float f2) {
        Z(this.f20914m.w(f2));
        this.f20910i.invalidateSelf();
        if (e0() || d0()) {
            h0();
        }
        if (e0()) {
            k0();
        }
    }

    /* access modifiers changed from: package-private */
    public void X(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.f20904c.q0(f2);
        MaterialShapeDrawable materialShapeDrawable = this.f20905d;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.q0(f2);
        }
        MaterialShapeDrawable materialShapeDrawable2 = this.r;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.q0(f2);
        }
    }

    /* access modifiers changed from: package-private */
    public void Y(@Nullable ColorStateList colorStateList) {
        this.f20912k = colorStateList;
        l0();
    }

    /* access modifiers changed from: package-private */
    public void Z(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.f20914m = shapeAppearanceModel;
        this.f20904c.setShapeAppearanceModel(shapeAppearanceModel);
        MaterialShapeDrawable materialShapeDrawable = this.f20904c;
        materialShapeDrawable.v0(!materialShapeDrawable.f0());
        MaterialShapeDrawable materialShapeDrawable2 = this.f20905d;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setShapeAppearanceModel(shapeAppearanceModel);
        }
        MaterialShapeDrawable materialShapeDrawable3 = this.r;
        if (materialShapeDrawable3 != null) {
            materialShapeDrawable3.setShapeAppearanceModel(shapeAppearanceModel);
        }
        MaterialShapeDrawable materialShapeDrawable4 = this.q;
        if (materialShapeDrawable4 != null) {
            materialShapeDrawable4.setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    /* access modifiers changed from: package-private */
    public void a0(ColorStateList colorStateList) {
        if (this.f20915n != colorStateList) {
            this.f20915n = colorStateList;
            m0();
        }
    }

    public void b(boolean z2) {
        float f2 = z2 ? 1.0f : 0.0f;
        float f3 = z2 ? 1.0f - this.y : this.y;
        ValueAnimator valueAnimator = this.u;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.u = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.y, f2});
        this.u = ofFloat;
        ofFloat.addUpdateListener(new b(this));
        this.u.setInterpolator(this.v);
        this.u.setDuration((long) (((float) (z2 ? this.w : this.x)) * f3));
        this.u.start();
    }

    /* access modifiers changed from: package-private */
    public void b0(@Dimension int i2) {
        if (i2 != this.f20909h) {
            this.f20909h = i2;
            m0();
        }
    }

    /* access modifiers changed from: package-private */
    public void c0(int i2, int i3, int i4, int i5) {
        this.f20903b.set(i2, i3, i4, i5);
        h0();
    }

    /* access modifiers changed from: package-private */
    public void g0() {
        Drawable drawable = this.f20910i;
        Drawable t2 = f0() ? t() : this.f20905d;
        this.f20910i = t2;
        if (drawable != t2) {
            j0(t2);
        }
    }

    /* access modifiers changed from: package-private */
    public void h0() {
        int c2 = (int) (((d0() || e0()) ? c() : 0.0f) - v());
        MaterialCardView materialCardView = this.f20902a;
        Rect rect = this.f20903b;
        materialCardView.m(rect.left + c2, rect.top + c2, rect.right + c2, rect.bottom + c2);
    }

    /* access modifiers changed from: package-private */
    public void i0() {
        this.f20904c.o0(this.f20902a.getCardElevation());
    }

    /* access modifiers changed from: package-private */
    @RequiresApi(api = 23)
    public void k() {
        Drawable drawable = this.o;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i2 = bounds.bottom;
            this.o.setBounds(bounds.left, bounds.top, bounds.right, i2 - 1);
            this.o.setBounds(bounds.left, bounds.top, bounds.right, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void k0() {
        if (!E()) {
            this.f20902a.setBackgroundInternal(D(this.f20904c));
        }
        this.f20902a.setForeground(D(this.f20910i));
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public MaterialShapeDrawable l() {
        return this.f20904c;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList m() {
        return this.f20904c.z();
    }

    /* access modifiers changed from: package-private */
    public void m0() {
        this.f20905d.F0((float) this.f20909h, this.f20915n);
    }

    /* access modifiers changed from: package-private */
    public ColorStateList n() {
        return this.f20905d.z();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public Drawable o() {
        return this.f20911j;
    }

    /* access modifiers changed from: package-private */
    public int p() {
        return this.f20908g;
    }

    /* access modifiers changed from: package-private */
    @Dimension
    public int q() {
        return this.f20906e;
    }

    /* access modifiers changed from: package-private */
    @Dimension
    public int r() {
        return this.f20907f;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ColorStateList s() {
        return this.f20913l;
    }

    /* access modifiers changed from: package-private */
    public float u() {
        return this.f20904c.T();
    }

    /* access modifiers changed from: package-private */
    @FloatRange(from = 0.0d, to = 1.0d)
    public float w() {
        return this.f20904c.A();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ColorStateList x() {
        return this.f20912k;
    }

    /* access modifiers changed from: package-private */
    public ShapeAppearanceModel y() {
        return this.f20914m;
    }

    /* access modifiers changed from: package-private */
    @ColorInt
    public int z() {
        ColorStateList colorStateList = this.f20915n;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }
}
