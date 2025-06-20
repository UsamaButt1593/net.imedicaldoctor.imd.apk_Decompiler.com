package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.PluralsRes;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.XmlRes;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import java.util.Locale;

@OptIn(markerClass = {ExperimentalBadgeUtils.class})
public class BadgeDrawable extends Drawable implements TextDrawableHelper.TextDrawableDelegate {
    private static final String g3 = "Badge";
    public static final int h3 = 8388661;
    public static final int i3 = 8388659;
    @Deprecated
    public static final int j3 = 8388693;
    @Deprecated
    public static final int k3 = 8388691;
    @StyleRes
    private static final int l3 = R.style.xi;
    @AttrRes
    private static final int m3 = R.attr.E0;
    static final String n3 = "+";
    static final String o3 = "…";
    static final int p3 = 0;
    static final int q3 = 1;
    static final int r3 = -1;
    public static final int s3 = -2;
    private static final float t3 = 0.3f;
    @NonNull
    private final MaterialShapeDrawable X;
    @NonNull
    private final BadgeState X2;
    @NonNull
    private final TextDrawableHelper Y;
    private float Y2;
    @NonNull
    private final Rect Z = new Rect();
    private float Z2;
    private int a3;
    private float b3;
    private float c3;
    private float d3;
    @Nullable
    private WeakReference<View> e3;
    @Nullable
    private WeakReference<FrameLayout> f3;
    @NonNull
    private final WeakReference<Context> s;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BadgeGravity {
    }

    private BadgeDrawable(@NonNull Context context, @XmlRes int i2, @AttrRes int i4, @StyleRes int i5, @Nullable BadgeState.State state) {
        this.s = new WeakReference<>(context);
        ThemeEnforcement.c(context);
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.Y = textDrawableHelper;
        textDrawableHelper.g().setTextAlign(Paint.Align.CENTER);
        BadgeState badgeState = new BadgeState(context, i2, i4, i5, state);
        this.X2 = badgeState;
        this.X = new MaterialShapeDrawable(ShapeAppearanceModel.b(context, R() ? badgeState.o() : badgeState.k(), R() ? badgeState.n() : badgeState.j()).m());
        g0();
    }

    @NonNull
    private String D() {
        if (this.a3 == -2 || C() <= this.a3) {
            return NumberFormat.getInstance(this.X2.z()).format((long) C());
        }
        Context context = this.s.get();
        if (context == null) {
            return "";
        }
        return String.format(this.X2.z(), context.getString(R.string.b1), new Object[]{Integer.valueOf(this.a3), n3});
    }

    @Nullable
    private String E() {
        Context context;
        if (this.X2.s() == 0 || (context = this.s.get()) == null) {
            return null;
        }
        if (this.a3 == -2 || C() <= this.a3) {
            return context.getResources().getQuantityString(this.X2.s(), C(), new Object[]{Integer.valueOf(C())});
        }
        return context.getString(this.X2.p(), new Object[]{Integer.valueOf(this.a3)});
    }

    private float F(View view, float f2) {
        if (view.getParent() instanceof View) {
            return ((this.Y2 + this.c3) - (((float) ((View) view.getParent()).getWidth()) - view.getX())) + f2;
        }
        return 0.0f;
    }

    @Nullable
    private String I() {
        String H = H();
        int A = A();
        if (A == -2 || H == null || H.length() <= A) {
            return H;
        }
        Context context = this.s.get();
        if (context == null) {
            return "";
        }
        String substring = H.substring(0, A - 1);
        return String.format(context.getString(R.string.b0), new Object[]{substring, o3});
    }

    @Nullable
    private CharSequence J() {
        CharSequence q = this.X2.q();
        return q != null ? q : H();
    }

    private float K(View view, float f2) {
        return (this.Z2 - this.d3) + view.getY() + f2;
    }

    private int L() {
        int t = R() ? this.X2.t() : this.X2.u();
        if (this.X2.f20838k == 1) {
            t += R() ? this.X2.f20837j : this.X2.f20836i;
        }
        return t + this.X2.d();
    }

    private void L0(final View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null || viewGroup.getId() != R.id.g3) {
            WeakReference<FrameLayout> weakReference = this.f3;
            if (weakReference == null || weakReference.get() != viewGroup) {
                M0(view);
                final FrameLayout frameLayout = new FrameLayout(view.getContext());
                frameLayout.setId(R.id.g3);
                frameLayout.setClipChildren(false);
                frameLayout.setClipToPadding(false);
                frameLayout.setLayoutParams(view.getLayoutParams());
                frameLayout.setMinimumWidth(view.getWidth());
                frameLayout.setMinimumHeight(view.getHeight());
                int indexOfChild = viewGroup.indexOfChild(view);
                viewGroup.removeViewAt(indexOfChild);
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.addView(view);
                viewGroup.addView(frameLayout, indexOfChild);
                this.f3 = new WeakReference<>(frameLayout);
                frameLayout.post(new Runnable() {
                    public void run() {
                        BadgeDrawable.this.P0(view, frameLayout);
                    }
                });
            }
        }
    }

    private int M() {
        int E = this.X2.E();
        if (R()) {
            E = this.X2.D();
            Context context = this.s.get();
            if (context != null) {
                E = AnimationUtils.c(E, E - this.X2.v(), AnimationUtils.b(0.0f, 1.0f, t3, 1.0f, MaterialResources.f(context) - 1.0f));
            }
        }
        if (this.X2.f20838k == 0) {
            E -= Math.round(this.d3);
        }
        return E + this.X2.e();
    }

    private static void M0(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    private void Q0() {
        Context context = this.s.get();
        WeakReference<View> weakReference = this.e3;
        ViewGroup viewGroup = null;
        View view = weakReference != null ? weakReference.get() : null;
        if (context != null && view != null) {
            Rect rect = new Rect();
            rect.set(this.Z);
            Rect rect2 = new Rect();
            view.getDrawingRect(rect2);
            WeakReference<FrameLayout> weakReference2 = this.f3;
            if (weakReference2 != null) {
                viewGroup = weakReference2.get();
            }
            if (viewGroup != null || BadgeUtils.f20839a) {
                if (viewGroup == null) {
                    viewGroup = (ViewGroup) view.getParent();
                }
                viewGroup.offsetDescendantRectToMyCoords(view, rect2);
            }
            c(rect2, view);
            BadgeUtils.o(this.Z, this.Y2, this.Z2, this.c3, this.d3);
            float f2 = this.b3;
            if (f2 != -1.0f) {
                this.X.l0(f2);
            }
            if (!rect.equals(this.Z)) {
                this.X.setBounds(this.Z);
            }
        }
    }

    private boolean R() {
        return T() || S();
    }

    private void R0() {
        this.a3 = A() != -2 ? ((int) Math.pow(10.0d, ((double) A()) - 1.0d)) - 1 : B();
    }

    private boolean U() {
        FrameLayout s2 = s();
        return s2 != null && s2.getId() == R.id.g3;
    }

    private void V() {
        this.Y.g().setAlpha(getAlpha());
        invalidateSelf();
    }

    private void W() {
        ColorStateList valueOf = ColorStateList.valueOf(this.X2.g());
        if (this.X.z() != valueOf) {
            this.X.p0(valueOf);
            invalidateSelf();
        }
    }

    private void X() {
        this.Y.m(true);
        Z();
        Q0();
        invalidateSelf();
    }

    private void Y() {
        WeakReference<View> weakReference = this.e3;
        if (weakReference != null && weakReference.get() != null) {
            View view = this.e3.get();
            WeakReference<FrameLayout> weakReference2 = this.f3;
            P0(view, weakReference2 != null ? weakReference2.get() : null);
        }
    }

    private void Z() {
        Context context = this.s.get();
        if (context != null) {
            this.X.setShapeAppearanceModel(ShapeAppearanceModel.b(context, R() ? this.X2.o() : this.X2.k(), R() ? this.X2.n() : this.X2.j()).m());
            invalidateSelf();
        }
    }

    private void a0() {
        TextAppearance textAppearance;
        Context context = this.s.get();
        if (context != null && this.Y.e() != (textAppearance = new TextAppearance(context, this.X2.C()))) {
            this.Y.l(textAppearance, context);
            b0();
            Q0();
            invalidateSelf();
        }
    }

    private void b(@NonNull View view) {
        float f2;
        float f4;
        View s2 = s();
        if (s2 == null) {
            if (view.getParent() instanceof View) {
                float y = view.getY();
                f4 = view.getX();
                float f5 = y;
                s2 = (View) view.getParent();
                f2 = f5;
            } else {
                return;
            }
        } else if (!U()) {
            f2 = 0.0f;
            f4 = 0.0f;
        } else if (s2.getParent() instanceof View) {
            f2 = s2.getY();
            f4 = s2.getX();
            s2 = (View) s2.getParent();
        } else {
            return;
        }
        float K = K(s2, f2);
        float z = z(s2, f4);
        float q = q(s2, f2);
        float F = F(s2, f4);
        if (K < 0.0f) {
            this.Z2 += Math.abs(K);
        }
        if (z < 0.0f) {
            this.Y2 += Math.abs(z);
        }
        if (q > 0.0f) {
            this.Z2 -= Math.abs(q);
        }
        if (F > 0.0f) {
            this.Y2 -= Math.abs(F);
        }
    }

    private void b0() {
        this.Y.g().setColor(this.X2.l());
        invalidateSelf();
    }

    private void c(@NonNull Rect rect, @NonNull View view) {
        float f2 = R() ? this.X2.f20831d : this.X2.f20830c;
        this.b3 = f2;
        if (f2 != -1.0f) {
            this.c3 = f2;
        } else {
            this.c3 = (float) Math.round((R() ? this.X2.f20834g : this.X2.f20832e) / 2.0f);
            f2 = (float) Math.round((R() ? this.X2.f20835h : this.X2.f20833f) / 2.0f);
        }
        this.d3 = f2;
        if (R()) {
            String m2 = m();
            this.c3 = Math.max(this.c3, (this.Y.h(m2) / 2.0f) + ((float) this.X2.i()));
            float max = Math.max(this.d3, (this.Y.f(m2) / 2.0f) + ((float) this.X2.m()));
            this.d3 = max;
            this.c3 = Math.max(this.c3, max);
        }
        int M = M();
        int h2 = this.X2.h();
        this.Z2 = (float) ((h2 == 8388691 || h2 == 8388693) ? rect.bottom - M : rect.top + M);
        int L = L();
        int h4 = this.X2.h();
        this.Y2 = (h4 == 8388659 || h4 == 8388691 ? ViewCompat.c0(view) != 0 : ViewCompat.c0(view) == 0) ? (((float) rect.right) + this.c3) - ((float) L) : (((float) rect.left) - this.c3) + ((float) L);
        if (this.X2.H()) {
            b(view);
        }
    }

    private void c0() {
        R0();
        this.Y.m(true);
        Q0();
        invalidateSelf();
    }

    private void d0() {
        if (!T()) {
            X();
        }
    }

    private void e0() {
        X();
    }

    @NonNull
    public static BadgeDrawable f(@NonNull Context context) {
        return new BadgeDrawable(context, 0, m3, l3, (BadgeState.State) null);
    }

    private void f0() {
        boolean I = this.X2.I();
        setVisible(I, false);
        if (BadgeUtils.f20839a && s() != null && !I) {
            ((ViewGroup) s().getParent()).invalidate();
        }
    }

    @NonNull
    public static BadgeDrawable g(@NonNull Context context, @XmlRes int i2) {
        return new BadgeDrawable(context, i2, m3, l3, (BadgeState.State) null);
    }

    private void g0() {
        Z();
        a0();
        c0();
        X();
        V();
        W();
        b0();
        Y();
        Q0();
        f0();
    }

    @NonNull
    static BadgeDrawable h(@NonNull Context context, @NonNull BadgeState.State state) {
        return new BadgeDrawable(context, 0, m3, l3, state);
    }

    private void i(Canvas canvas) {
        String m2 = m();
        if (m2 != null) {
            Rect rect = new Rect();
            this.Y.g().getTextBounds(m2, 0, m2.length(), rect);
            float exactCenterY = this.Z2 - rect.exactCenterY();
            canvas.drawText(m2, this.Y2, (float) (rect.bottom <= 0 ? (int) exactCenterY : Math.round(exactCenterY)), this.Y.g());
        }
    }

    @Nullable
    private String m() {
        if (T()) {
            return I();
        }
        if (S()) {
            return D();
        }
        return null;
    }

    private float q(View view, float f2) {
        if (view.getParent() instanceof View) {
            return ((this.Z2 + this.d3) - (((float) ((View) view.getParent()).getHeight()) - view.getY())) + f2;
        }
        return 0.0f;
    }

    private CharSequence t() {
        return this.X2.r();
    }

    private float z(View view, float f2) {
        return (this.Y2 - this.c3) + view.getX() + f2;
    }

    public int A() {
        return this.X2.w();
    }

    public void A0(@Px int i2) {
        this.X2.d0(i2);
        Q0();
    }

    public int B() {
        return this.X2.x();
    }

    public void B0(int i2) {
        if (this.X2.w() != i2) {
            this.X2.e0(i2);
            c0();
        }
    }

    public int C() {
        if (this.X2.F()) {
            return this.X2.y();
        }
        return 0;
    }

    public void C0(int i2) {
        if (this.X2.x() != i2) {
            this.X2.f0(i2);
            c0();
        }
    }

    public void D0(int i2) {
        int max = Math.max(0, i2);
        if (this.X2.y() != max) {
            this.X2.g0(max);
            d0();
        }
    }

    public void E0(@Nullable String str) {
        if (!TextUtils.equals(this.X2.B(), str)) {
            this.X2.i0(str);
            e0();
        }
    }

    public void F0(@StyleRes int i2) {
        this.X2.j0(i2);
        a0();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public BadgeState.State G() {
        return this.X2.A();
    }

    public void G0(int i2) {
        I0(i2);
        H0(i2);
    }

    @Nullable
    public String H() {
        return this.X2.B();
    }

    public void H0(@Px int i2) {
        this.X2.k0(i2);
        Q0();
    }

    public void I0(@Px int i2) {
        this.X2.l0(i2);
        Q0();
    }

    public void J0(@Px int i2) {
        if (i2 != this.X2.m()) {
            this.X2.U(i2);
            Q0();
        }
    }

    public void K0(boolean z) {
        this.X2.m0(z);
        f0();
    }

    public int N() {
        return this.X2.E();
    }

    public void N0(@NonNull View view) {
        P0(view, (FrameLayout) null);
    }

    @Px
    public int O() {
        return this.X2.D();
    }

    @Deprecated
    public void O0(@NonNull View view, @Nullable ViewGroup viewGroup) {
        if (viewGroup instanceof FrameLayout) {
            P0(view, (FrameLayout) viewGroup);
            return;
        }
        throw new IllegalArgumentException("customBadgeParent must be a FrameLayout");
    }

    @Px
    public int P() {
        return this.X2.E();
    }

    public void P0(@NonNull View view, @Nullable FrameLayout frameLayout) {
        this.e3 = new WeakReference<>(view);
        boolean z = BadgeUtils.f20839a;
        if (!z || frameLayout != null) {
            this.f3 = new WeakReference<>(frameLayout);
        } else {
            L0(view);
        }
        if (!z) {
            M0(view);
        }
        Q0();
        invalidateSelf();
    }

    @Px
    public int Q() {
        return this.X2.m();
    }

    public boolean S() {
        return !this.X2.G() && this.X2.F();
    }

    public boolean T() {
        return this.X2.G();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void a() {
        invalidateSelf();
    }

    public void d() {
        if (this.X2.F()) {
            this.X2.a();
            d0();
        }
    }

    public void draw(@NonNull Canvas canvas) {
        if (!getBounds().isEmpty() && getAlpha() != 0 && isVisible()) {
            this.X.draw(canvas);
            if (R()) {
                i(canvas);
            }
        }
    }

    public void e() {
        if (this.X2.G()) {
            this.X2.b();
            e0();
        }
    }

    public int getAlpha() {
        return this.X2.f();
    }

    public int getIntrinsicHeight() {
        return this.Z.height();
    }

    public int getIntrinsicWidth() {
        return this.Z.width();
    }

    public int getOpacity() {
        return -3;
    }

    /* access modifiers changed from: package-private */
    public void h0(int i2) {
        this.X2.K(i2);
        Q0();
    }

    /* access modifiers changed from: package-private */
    public void i0(@Px int i2) {
        this.X2.L(i2);
        Q0();
    }

    public boolean isStateful() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return this.X2.d();
    }

    public void j0(boolean z) {
        if (this.X2.H() != z) {
            this.X2.N(z);
            WeakReference<View> weakReference = this.e3;
            if (weakReference != null && weakReference.get() != null) {
                b(this.e3.get());
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Px
    public int k() {
        return this.X2.e();
    }

    public void k0(@ColorInt int i2) {
        this.X2.O(i2);
        W();
    }

    @ColorInt
    public int l() {
        return this.X.z().getDefaultColor();
    }

    public void l0(int i2) {
        if (i2 == 8388691 || i2 == 8388693) {
            Log.w(g3, "Bottom badge gravities are deprecated; please use a top gravity instead.");
        }
        if (this.X2.h() != i2) {
            this.X2.P(i2);
            Y();
        }
    }

    public void m0(@NonNull Locale locale) {
        if (!locale.equals(this.X2.z())) {
            this.X2.h0(locale);
            invalidateSelf();
        }
    }

    public int n() {
        return this.X2.h();
    }

    public void n0(@ColorInt int i2) {
        if (this.Y.g().getColor() != i2) {
            this.X2.T(i2);
            b0();
        }
    }

    @NonNull
    public Locale o() {
        return this.X2.z();
    }

    public void o0(@StyleRes int i2) {
        this.X2.W(i2);
        Z();
    }

    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @ColorInt
    public int p() {
        return this.Y.g().getColor();
    }

    public void p0(@StyleRes int i2) {
        this.X2.V(i2);
        Z();
    }

    public void q0(@StyleRes int i2) {
        this.X2.S(i2);
        Z();
    }

    @Nullable
    public CharSequence r() {
        if (!isVisible()) {
            return null;
        }
        if (T()) {
            return J();
        }
        return S() ? E() : t();
    }

    public void r0(@StyleRes int i2) {
        this.X2.R(i2);
        Z();
    }

    @Nullable
    public FrameLayout s() {
        WeakReference<FrameLayout> weakReference = this.f3;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void s0(@StringRes int i2) {
        this.X2.X(i2);
    }

    public void setAlpha(int i2) {
        this.X2.M(i2);
        V();
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void t0(@Nullable CharSequence charSequence) {
        this.X2.Y(charSequence);
    }

    public int u() {
        return this.X2.u();
    }

    public void u0(CharSequence charSequence) {
        this.X2.Z(charSequence);
    }

    @Px
    public int v() {
        return this.X2.t();
    }

    public void v0(@PluralsRes int i2) {
        this.X2.a0(i2);
    }

    @Px
    public int w() {
        return this.X2.u();
    }

    public void w0(int i2) {
        y0(i2);
        x0(i2);
    }

    @Px
    public int x() {
        return this.X2.i();
    }

    public void x0(@Px int i2) {
        this.X2.b0(i2);
        Q0();
    }

    @Px
    public int y() {
        return this.X2.v();
    }

    public void y0(@Px int i2) {
        this.X2.c0(i2);
        Q0();
    }

    public void z0(@Px int i2) {
        if (i2 != this.X2.i()) {
            this.X2.Q(i2);
            Q0();
        }
    }
}
