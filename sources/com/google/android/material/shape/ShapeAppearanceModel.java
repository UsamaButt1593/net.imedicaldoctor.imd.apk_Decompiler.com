package com.google.android.material.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.annotation.AttrRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

public class ShapeAppearanceModel {

    /* renamed from: m  reason: collision with root package name */
    public static final CornerSize f21822m = new RelativeCornerSize(0.5f);

    /* renamed from: a  reason: collision with root package name */
    CornerTreatment f21823a;

    /* renamed from: b  reason: collision with root package name */
    CornerTreatment f21824b;

    /* renamed from: c  reason: collision with root package name */
    CornerTreatment f21825c;

    /* renamed from: d  reason: collision with root package name */
    CornerTreatment f21826d;

    /* renamed from: e  reason: collision with root package name */
    CornerSize f21827e;

    /* renamed from: f  reason: collision with root package name */
    CornerSize f21828f;

    /* renamed from: g  reason: collision with root package name */
    CornerSize f21829g;

    /* renamed from: h  reason: collision with root package name */
    CornerSize f21830h;

    /* renamed from: i  reason: collision with root package name */
    EdgeTreatment f21831i;

    /* renamed from: j  reason: collision with root package name */
    EdgeTreatment f21832j;

    /* renamed from: k  reason: collision with root package name */
    EdgeTreatment f21833k;

    /* renamed from: l  reason: collision with root package name */
    EdgeTreatment f21834l;

    public static final class Builder {
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public CornerTreatment f21835a = MaterialShapeUtils.b();
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public CornerTreatment f21836b = MaterialShapeUtils.b();
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        public CornerTreatment f21837c = MaterialShapeUtils.b();
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        public CornerTreatment f21838d = MaterialShapeUtils.b();
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: e  reason: collision with root package name */
        public CornerSize f21839e = new AbsoluteCornerSize(0.0f);
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: f  reason: collision with root package name */
        public CornerSize f21840f = new AbsoluteCornerSize(0.0f);
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: g  reason: collision with root package name */
        public CornerSize f21841g = new AbsoluteCornerSize(0.0f);
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: h  reason: collision with root package name */
        public CornerSize f21842h = new AbsoluteCornerSize(0.0f);
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: i  reason: collision with root package name */
        public EdgeTreatment f21843i = MaterialShapeUtils.c();
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: j  reason: collision with root package name */
        public EdgeTreatment f21844j = MaterialShapeUtils.c();
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: k  reason: collision with root package name */
        public EdgeTreatment f21845k = MaterialShapeUtils.c();
        /* access modifiers changed from: private */
        @NonNull

        /* renamed from: l  reason: collision with root package name */
        public EdgeTreatment f21846l = MaterialShapeUtils.c();

        public Builder() {
        }

        private static float n(CornerTreatment cornerTreatment) {
            if (cornerTreatment instanceof RoundedCornerTreatment) {
                return ((RoundedCornerTreatment) cornerTreatment).f21821a;
            }
            if (cornerTreatment instanceof CutCornerTreatment) {
                return ((CutCornerTreatment) cornerTreatment).f21795a;
            }
            return -1.0f;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder A(int i2, @NonNull CornerSize cornerSize) {
            return B(MaterialShapeUtils.a(i2)).D(cornerSize);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder B(@NonNull CornerTreatment cornerTreatment) {
            this.f21837c = cornerTreatment;
            float n2 = n(cornerTreatment);
            if (n2 != -1.0f) {
                C(n2);
            }
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder C(@Dimension float f2) {
            this.f21841g = new AbsoluteCornerSize(f2);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder D(@NonNull CornerSize cornerSize) {
            this.f21841g = cornerSize;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder E(@NonNull EdgeTreatment edgeTreatment) {
            this.f21846l = edgeTreatment;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder F(@NonNull EdgeTreatment edgeTreatment) {
            this.f21844j = edgeTreatment;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder G(@NonNull EdgeTreatment edgeTreatment) {
            this.f21843i = edgeTreatment;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder H(int i2, @Dimension float f2) {
            return J(MaterialShapeUtils.a(i2)).K(f2);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder I(int i2, @NonNull CornerSize cornerSize) {
            return J(MaterialShapeUtils.a(i2)).L(cornerSize);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder J(@NonNull CornerTreatment cornerTreatment) {
            this.f21835a = cornerTreatment;
            float n2 = n(cornerTreatment);
            if (n2 != -1.0f) {
                K(n2);
            }
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder K(@Dimension float f2) {
            this.f21839e = new AbsoluteCornerSize(f2);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder L(@NonNull CornerSize cornerSize) {
            this.f21839e = cornerSize;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder M(int i2, @Dimension float f2) {
            return O(MaterialShapeUtils.a(i2)).P(f2);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder N(int i2, @NonNull CornerSize cornerSize) {
            return O(MaterialShapeUtils.a(i2)).Q(cornerSize);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder O(@NonNull CornerTreatment cornerTreatment) {
            this.f21836b = cornerTreatment;
            float n2 = n(cornerTreatment);
            if (n2 != -1.0f) {
                P(n2);
            }
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder P(@Dimension float f2) {
            this.f21840f = new AbsoluteCornerSize(f2);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder Q(@NonNull CornerSize cornerSize) {
            this.f21840f = cornerSize;
            return this;
        }

        @NonNull
        public ShapeAppearanceModel m() {
            return new ShapeAppearanceModel(this);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder o(@Dimension float f2) {
            return K(f2).P(f2).C(f2).x(f2);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder p(@NonNull CornerSize cornerSize) {
            return L(cornerSize).Q(cornerSize).D(cornerSize).y(cornerSize);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder q(int i2, @Dimension float f2) {
            return r(MaterialShapeUtils.a(i2)).o(f2);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder r(@NonNull CornerTreatment cornerTreatment) {
            return J(cornerTreatment).O(cornerTreatment).B(cornerTreatment).w(cornerTreatment);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder s(@NonNull EdgeTreatment edgeTreatment) {
            return E(edgeTreatment).G(edgeTreatment).F(edgeTreatment).t(edgeTreatment);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder t(@NonNull EdgeTreatment edgeTreatment) {
            this.f21845k = edgeTreatment;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder u(int i2, @Dimension float f2) {
            return w(MaterialShapeUtils.a(i2)).x(f2);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder v(int i2, @NonNull CornerSize cornerSize) {
            return w(MaterialShapeUtils.a(i2)).y(cornerSize);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder w(@NonNull CornerTreatment cornerTreatment) {
            this.f21838d = cornerTreatment;
            float n2 = n(cornerTreatment);
            if (n2 != -1.0f) {
                x(n2);
            }
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder x(@Dimension float f2) {
            this.f21842h = new AbsoluteCornerSize(f2);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder y(@NonNull CornerSize cornerSize) {
            this.f21842h = cornerSize;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder z(int i2, @Dimension float f2) {
            return B(MaterialShapeUtils.a(i2)).C(f2);
        }

        public Builder(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
            this.f21835a = shapeAppearanceModel.f21823a;
            this.f21836b = shapeAppearanceModel.f21824b;
            this.f21837c = shapeAppearanceModel.f21825c;
            this.f21838d = shapeAppearanceModel.f21826d;
            this.f21839e = shapeAppearanceModel.f21827e;
            this.f21840f = shapeAppearanceModel.f21828f;
            this.f21841g = shapeAppearanceModel.f21829g;
            this.f21842h = shapeAppearanceModel.f21830h;
            this.f21843i = shapeAppearanceModel.f21831i;
            this.f21844j = shapeAppearanceModel.f21832j;
            this.f21845k = shapeAppearanceModel.f21833k;
            this.f21846l = shapeAppearanceModel.f21834l;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface CornerSizeUnaryOperator {
        @NonNull
        CornerSize a(@NonNull CornerSize cornerSize);
    }

    public ShapeAppearanceModel() {
        this.f21823a = MaterialShapeUtils.b();
        this.f21824b = MaterialShapeUtils.b();
        this.f21825c = MaterialShapeUtils.b();
        this.f21826d = MaterialShapeUtils.b();
        this.f21827e = new AbsoluteCornerSize(0.0f);
        this.f21828f = new AbsoluteCornerSize(0.0f);
        this.f21829g = new AbsoluteCornerSize(0.0f);
        this.f21830h = new AbsoluteCornerSize(0.0f);
        this.f21831i = MaterialShapeUtils.c();
        this.f21832j = MaterialShapeUtils.c();
        this.f21833k = MaterialShapeUtils.c();
        this.f21834l = MaterialShapeUtils.c();
    }

    @NonNull
    public static Builder a() {
        return new Builder();
    }

    @NonNull
    public static Builder b(Context context, @StyleRes int i2, @StyleRes int i3) {
        return c(context, i2, i3, 0);
    }

    @NonNull
    private static Builder c(Context context, @StyleRes int i2, @StyleRes int i3, int i4) {
        return d(context, i2, i3, new AbsoluteCornerSize((float) i4));
    }

    @NonNull
    private static Builder d(Context context, @StyleRes int i2, @StyleRes int i3, @NonNull CornerSize cornerSize) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i2);
        if (i3 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i3);
        }
        TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R.styleable.ht);
        try {
            int i4 = obtainStyledAttributes.getInt(R.styleable.jt, 0);
            int i5 = obtainStyledAttributes.getInt(R.styleable.mt, i4);
            int i6 = obtainStyledAttributes.getInt(R.styleable.nt, i4);
            int i7 = obtainStyledAttributes.getInt(R.styleable.lt, i4);
            int i8 = obtainStyledAttributes.getInt(R.styleable.kt, i4);
            CornerSize m2 = m(obtainStyledAttributes, R.styleable.ot, cornerSize);
            CornerSize m3 = m(obtainStyledAttributes, R.styleable.rt, m2);
            CornerSize m4 = m(obtainStyledAttributes, R.styleable.st, m2);
            CornerSize m5 = m(obtainStyledAttributes, R.styleable.qt, m2);
            return new Builder().I(i5, m3).N(i6, m4).A(i7, m5).v(i8, m(obtainStyledAttributes, R.styleable.pt, m2));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @NonNull
    public static Builder e(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        return f(context, attributeSet, i2, i3, 0);
    }

    @NonNull
    public static Builder f(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3, int i4) {
        return g(context, attributeSet, i2, i3, new AbsoluteCornerSize((float) i4));
    }

    @NonNull
    public static Builder g(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3, @NonNull CornerSize cornerSize) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.On, i2, i3);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.Pn, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.Qn, 0);
        obtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, cornerSize);
    }

    @NonNull
    private static CornerSize m(TypedArray typedArray, int i2, @NonNull CornerSize cornerSize) {
        TypedValue peekValue = typedArray.peekValue(i2);
        if (peekValue == null) {
            return cornerSize;
        }
        int i3 = peekValue.type;
        if (i3 == 5) {
            return new AbsoluteCornerSize((float) TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        return i3 == 6 ? new RelativeCornerSize(peekValue.getFraction(1.0f, 1.0f)) : cornerSize;
    }

    @NonNull
    public EdgeTreatment h() {
        return this.f21833k;
    }

    @NonNull
    public CornerTreatment i() {
        return this.f21826d;
    }

    @NonNull
    public CornerSize j() {
        return this.f21830h;
    }

    @NonNull
    public CornerTreatment k() {
        return this.f21825c;
    }

    @NonNull
    public CornerSize l() {
        return this.f21829g;
    }

    @NonNull
    public EdgeTreatment n() {
        return this.f21834l;
    }

    @NonNull
    public EdgeTreatment o() {
        return this.f21832j;
    }

    @NonNull
    public EdgeTreatment p() {
        return this.f21831i;
    }

    @NonNull
    public CornerTreatment q() {
        return this.f21823a;
    }

    @NonNull
    public CornerSize r() {
        return this.f21827e;
    }

    @NonNull
    public CornerTreatment s() {
        return this.f21824b;
    }

    @NonNull
    public CornerSize t() {
        return this.f21828f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean u(@NonNull RectF rectF) {
        Class<EdgeTreatment> cls = EdgeTreatment.class;
        boolean z = this.f21834l.getClass().equals(cls) && this.f21832j.getClass().equals(cls) && this.f21831i.getClass().equals(cls) && this.f21833k.getClass().equals(cls);
        float a2 = this.f21827e.a(rectF);
        return z && ((this.f21828f.a(rectF) > a2 ? 1 : (this.f21828f.a(rectF) == a2 ? 0 : -1)) == 0 && (this.f21830h.a(rectF) > a2 ? 1 : (this.f21830h.a(rectF) == a2 ? 0 : -1)) == 0 && (this.f21829g.a(rectF) > a2 ? 1 : (this.f21829g.a(rectF) == a2 ? 0 : -1)) == 0) && ((this.f21824b instanceof RoundedCornerTreatment) && (this.f21823a instanceof RoundedCornerTreatment) && (this.f21825c instanceof RoundedCornerTreatment) && (this.f21826d instanceof RoundedCornerTreatment));
    }

    @NonNull
    public Builder v() {
        return new Builder(this);
    }

    @NonNull
    public ShapeAppearanceModel w(float f2) {
        return v().o(f2).m();
    }

    @NonNull
    public ShapeAppearanceModel x(@NonNull CornerSize cornerSize) {
        return v().p(cornerSize).m();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ShapeAppearanceModel y(@NonNull CornerSizeUnaryOperator cornerSizeUnaryOperator) {
        return v().L(cornerSizeUnaryOperator.a(r())).Q(cornerSizeUnaryOperator.a(t())).y(cornerSizeUnaryOperator.a(j())).D(cornerSizeUnaryOperator.a(l())).m();
    }

    private ShapeAppearanceModel(@NonNull Builder builder) {
        this.f21823a = builder.f21835a;
        this.f21824b = builder.f21836b;
        this.f21825c = builder.f21837c;
        this.f21826d = builder.f21838d;
        this.f21827e = builder.f21839e;
        this.f21828f = builder.f21840f;
        this.f21829g = builder.f21841g;
        this.f21830h = builder.f21842h;
        this.f21831i = builder.f21843i;
        this.f21832j = builder.f21844j;
        this.f21833k = builder.f21845k;
        this.f21834l = builder.f21846l;
    }
}
