package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class MaterialButtonHelper {
    @ChecksSdkIntAtLeast(api = 21)
    private static final boolean u = true;
    private static final boolean v;

    /* renamed from: a  reason: collision with root package name */
    private final MaterialButton f20881a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private ShapeAppearanceModel f20882b;

    /* renamed from: c  reason: collision with root package name */
    private int f20883c;

    /* renamed from: d  reason: collision with root package name */
    private int f20884d;

    /* renamed from: e  reason: collision with root package name */
    private int f20885e;

    /* renamed from: f  reason: collision with root package name */
    private int f20886f;

    /* renamed from: g  reason: collision with root package name */
    private int f20887g;

    /* renamed from: h  reason: collision with root package name */
    private int f20888h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private PorterDuff.Mode f20889i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f20890j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f20891k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private ColorStateList f20892l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private Drawable f20893m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f20894n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q;
    private boolean r = true;
    private LayerDrawable s;
    private int t;

    static {
        int i2 = Build.VERSION.SDK_INT;
        boolean z = true;
        if (i2 > 22) {
            z = false;
        }
        v = z;
    }

    MaterialButtonHelper(MaterialButton materialButton, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.f20881a = materialButton;
        this.f20882b = shapeAppearanceModel;
    }

    private void G(@Dimension int i2, @Dimension int i3) {
        int n0 = ViewCompat.n0(this.f20881a);
        int paddingTop = this.f20881a.getPaddingTop();
        int m0 = ViewCompat.m0(this.f20881a);
        int paddingBottom = this.f20881a.getPaddingBottom();
        int i4 = this.f20885e;
        int i5 = this.f20886f;
        this.f20886f = i3;
        this.f20885e = i2;
        if (!this.o) {
            H();
        }
        ViewCompat.n2(this.f20881a, n0, (paddingTop + i2) - i4, m0, (paddingBottom + i3) - i5);
    }

    private void H() {
        this.f20881a.setInternalBackground(a());
        MaterialShapeDrawable f2 = f();
        if (f2 != null) {
            f2.o0((float) this.t);
            f2.setState(this.f20881a.getDrawableState());
        }
    }

    private void I(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (!v || this.o) {
            if (f() != null) {
                f().setShapeAppearanceModel(shapeAppearanceModel);
            }
            if (n() != null) {
                n().setShapeAppearanceModel(shapeAppearanceModel);
            }
            if (e() != null) {
                e().setShapeAppearanceModel(shapeAppearanceModel);
                return;
            }
            return;
        }
        int n0 = ViewCompat.n0(this.f20881a);
        int paddingTop = this.f20881a.getPaddingTop();
        int m0 = ViewCompat.m0(this.f20881a);
        int paddingBottom = this.f20881a.getPaddingBottom();
        H();
        ViewCompat.n2(this.f20881a, n0, paddingTop, m0, paddingBottom);
    }

    private void K() {
        MaterialShapeDrawable f2 = f();
        MaterialShapeDrawable n2 = n();
        if (f2 != null) {
            f2.F0((float) this.f20888h, this.f20891k);
            if (n2 != null) {
                n2.E0((float) this.f20888h, this.f20894n ? MaterialColors.d(this.f20881a, R.attr.e4) : 0);
            }
        }
    }

    @NonNull
    private InsetDrawable L(Drawable drawable) {
        return new InsetDrawable(drawable, this.f20883c, this.f20885e, this.f20884d, this.f20886f);
    }

    private Drawable a() {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.f20882b);
        materialShapeDrawable.a0(this.f20881a.getContext());
        DrawableCompat.o(materialShapeDrawable, this.f20890j);
        PorterDuff.Mode mode = this.f20889i;
        if (mode != null) {
            DrawableCompat.p(materialShapeDrawable, mode);
        }
        materialShapeDrawable.F0((float) this.f20888h, this.f20891k);
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.f20882b);
        materialShapeDrawable2.setTint(0);
        materialShapeDrawable2.E0((float) this.f20888h, this.f20894n ? MaterialColors.d(this.f20881a, R.attr.e4) : 0);
        if (u) {
            MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(this.f20882b);
            this.f20893m = materialShapeDrawable3;
            DrawableCompat.n(materialShapeDrawable3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.e(this.f20892l), L(new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable})), this.f20893m);
            this.s = rippleDrawable;
            return rippleDrawable;
        }
        RippleDrawableCompat rippleDrawableCompat = new RippleDrawableCompat(this.f20882b);
        this.f20893m = rippleDrawableCompat;
        DrawableCompat.o(rippleDrawableCompat, RippleUtils.e(this.f20892l));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable, this.f20893m});
        this.s = layerDrawable;
        return L(layerDrawable);
    }

    @Nullable
    private MaterialShapeDrawable g(boolean z) {
        LayerDrawable layerDrawable = this.s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (MaterialShapeDrawable) (u ? (LayerDrawable) ((InsetDrawable) this.s.getDrawable(0)).getDrawable() : this.s).getDrawable(z ^ true ? 1 : 0);
    }

    @Nullable
    private MaterialShapeDrawable n() {
        return g(true);
    }

    /* access modifiers changed from: package-private */
    public void A(boolean z) {
        this.f20894n = z;
        K();
    }

    /* access modifiers changed from: package-private */
    public void B(@Nullable ColorStateList colorStateList) {
        if (this.f20891k != colorStateList) {
            this.f20891k = colorStateList;
            K();
        }
    }

    /* access modifiers changed from: package-private */
    public void C(int i2) {
        if (this.f20888h != i2) {
            this.f20888h = i2;
            K();
        }
    }

    /* access modifiers changed from: package-private */
    public void D(@Nullable ColorStateList colorStateList) {
        if (this.f20890j != colorStateList) {
            this.f20890j = colorStateList;
            if (f() != null) {
                DrawableCompat.o(f(), this.f20890j);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void E(@Nullable PorterDuff.Mode mode) {
        if (this.f20889i != mode) {
            this.f20889i = mode;
            if (f() != null && this.f20889i != null) {
                DrawableCompat.p(f(), this.f20889i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void F(boolean z) {
        this.r = z;
    }

    /* access modifiers changed from: package-private */
    public void J(int i2, int i3) {
        Drawable drawable = this.f20893m;
        if (drawable != null) {
            drawable.setBounds(this.f20883c, this.f20885e, i3 - this.f20884d, i2 - this.f20886f);
        }
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.f20887g;
    }

    public int c() {
        return this.f20886f;
    }

    public int d() {
        return this.f20885e;
    }

    @Nullable
    public Shapeable e() {
        LayerDrawable layerDrawable = this.s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return (Shapeable) (this.s.getNumberOfLayers() > 2 ? this.s.getDrawable(2) : this.s.getDrawable(1));
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public MaterialShapeDrawable f() {
        return g(false);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ColorStateList h() {
        return this.f20892l;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public ShapeAppearanceModel i() {
        return this.f20882b;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public ColorStateList j() {
        return this.f20891k;
    }

    /* access modifiers changed from: package-private */
    public int k() {
        return this.f20888h;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList l() {
        return this.f20890j;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode m() {
        return this.f20889i;
    }

    /* access modifiers changed from: package-private */
    public boolean o() {
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public boolean p() {
        return this.q;
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        return this.r;
    }

    /* access modifiers changed from: package-private */
    public void r(@NonNull TypedArray typedArray) {
        this.f20883c = typedArray.getDimensionPixelOffset(R.styleable.fm, 0);
        this.f20884d = typedArray.getDimensionPixelOffset(R.styleable.gm, 0);
        this.f20885e = typedArray.getDimensionPixelOffset(R.styleable.hm, 0);
        this.f20886f = typedArray.getDimensionPixelOffset(R.styleable.im, 0);
        int i2 = R.styleable.mm;
        if (typedArray.hasValue(i2)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i2, -1);
            this.f20887g = dimensionPixelSize;
            z(this.f20882b.w((float) dimensionPixelSize));
            this.p = true;
        }
        this.f20888h = typedArray.getDimensionPixelSize(R.styleable.ym, 0);
        this.f20889i = ViewUtils.u(typedArray.getInt(R.styleable.lm, -1), PorterDuff.Mode.SRC_IN);
        this.f20890j = MaterialResources.a(this.f20881a.getContext(), typedArray, R.styleable.km);
        this.f20891k = MaterialResources.a(this.f20881a.getContext(), typedArray, R.styleable.xm);
        this.f20892l = MaterialResources.a(this.f20881a.getContext(), typedArray, R.styleable.um);
        this.q = typedArray.getBoolean(R.styleable.jm, false);
        this.t = typedArray.getDimensionPixelSize(R.styleable.nm, 0);
        this.r = typedArray.getBoolean(R.styleable.zm, true);
        int n0 = ViewCompat.n0(this.f20881a);
        int paddingTop = this.f20881a.getPaddingTop();
        int m0 = ViewCompat.m0(this.f20881a);
        int paddingBottom = this.f20881a.getPaddingBottom();
        if (typedArray.hasValue(R.styleable.em)) {
            t();
        } else {
            H();
        }
        ViewCompat.n2(this.f20881a, n0 + this.f20883c, paddingTop + this.f20885e, m0 + this.f20884d, paddingBottom + this.f20886f);
    }

    /* access modifiers changed from: package-private */
    public void s(int i2) {
        if (f() != null) {
            f().setTint(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void t() {
        this.o = true;
        this.f20881a.setSupportBackgroundTintList(this.f20890j);
        this.f20881a.setSupportBackgroundTintMode(this.f20889i);
    }

    /* access modifiers changed from: package-private */
    public void u(boolean z) {
        this.q = z;
    }

    /* access modifiers changed from: package-private */
    public void v(int i2) {
        if (!this.p || this.f20887g != i2) {
            this.f20887g = i2;
            this.p = true;
            z(this.f20882b.w((float) i2));
        }
    }

    public void w(@Dimension int i2) {
        G(this.f20885e, i2);
    }

    public void x(@Dimension int i2) {
        G(i2, this.f20886f);
    }

    /* access modifiers changed from: package-private */
    public void y(@Nullable ColorStateList colorStateList) {
        if (this.f20892l != colorStateList) {
            this.f20892l = colorStateList;
            boolean z = u;
            if (z && (this.f20881a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f20881a.getBackground()).setColor(RippleUtils.e(colorStateList));
            } else if (!z && (this.f20881a.getBackground() instanceof RippleDrawableCompat)) {
                ((RippleDrawableCompat) this.f20881a.getBackground()).setTintList(RippleUtils.e(colorStateList));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void z(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.f20882b = shapeAppearanceModel;
        I(shapeAppearanceModel);
    }
}
