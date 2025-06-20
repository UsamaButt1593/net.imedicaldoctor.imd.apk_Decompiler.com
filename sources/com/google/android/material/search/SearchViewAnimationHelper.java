package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.activity.BackEventCompat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.FadeThroughDrawable;
import com.google.android.material.internal.FadeThroughUpdateListener;
import com.google.android.material.internal.MultiViewUpdateListener;
import com.google.android.material.internal.RectEvaluator;
import com.google.android.material.internal.ReversableAnimatedValueInterpolator;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialMainContainerBackHelper;
import com.google.android.material.search.SearchView;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Objects;

class SearchViewAnimationHelper {
    private static final long A = 250;
    private static final float B = 0.95f;
    private static final long C = 350;
    private static final long D = 150;
    private static final long E = 300;
    private static final long p = 300;
    private static final long q = 50;
    private static final long r = 250;
    private static final long s = 150;
    private static final long t = 75;
    private static final long u = 300;
    private static final long v = 250;
    private static final long w = 42;
    private static final long x = 0;
    private static final long y = 83;
    private static final long z = 0;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final SearchView f21756a;

    /* renamed from: b  reason: collision with root package name */
    private final View f21757b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final ClippableRoundedCornerLayout f21758c;

    /* renamed from: d  reason: collision with root package name */
    private final FrameLayout f21759d;

    /* renamed from: e  reason: collision with root package name */
    private final FrameLayout f21760e;

    /* renamed from: f  reason: collision with root package name */
    private final Toolbar f21761f;

    /* renamed from: g  reason: collision with root package name */
    private final Toolbar f21762g;

    /* renamed from: h  reason: collision with root package name */
    private final TextView f21763h;

    /* renamed from: i  reason: collision with root package name */
    private final EditText f21764i;

    /* renamed from: j  reason: collision with root package name */
    private final ImageButton f21765j;

    /* renamed from: k  reason: collision with root package name */
    private final View f21766k;

    /* renamed from: l  reason: collision with root package name */
    private final TouchObserverFrameLayout f21767l;

    /* renamed from: m  reason: collision with root package name */
    private final MaterialMainContainerBackHelper f21768m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private AnimatorSet f21769n;
    /* access modifiers changed from: private */
    public SearchBar o;

    SearchViewAnimationHelper(SearchView searchView) {
        this.f21756a = searchView;
        this.f21757b = searchView.s;
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = searchView.X2;
        this.f21758c = clippableRoundedCornerLayout;
        this.f21759d = searchView.a3;
        this.f21760e = searchView.b3;
        this.f21761f = searchView.c3;
        this.f21762g = searchView.d3;
        this.f21763h = searchView.e3;
        this.f21764i = searchView.f3;
        this.f21765j = searchView.g3;
        this.f21766k = searchView.h3;
        this.f21767l = searchView.i3;
        this.f21768m = new MaterialMainContainerBackHelper(clippableRoundedCornerLayout);
    }

    private Animator A(boolean z2) {
        return K(z2, true, this.f21764i);
    }

    private AnimatorSet B(final boolean z2) {
        AnimatorSet animatorSet = new AnimatorSet();
        if (this.f21769n == null) {
            animatorSet.playTogether(new Animator[]{s(z2), t(z2)});
        }
        animatorSet.playTogether(new Animator[]{H(z2), G(z2), u(z2), w(z2), F(z2), z(z2), q(z2), A(z2), I(z2)});
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                SearchViewAnimationHelper.this.U(z2 ? 1.0f : 0.0f);
                SearchViewAnimationHelper.this.f21758c.a();
            }

            public void onAnimationStart(Animator animator) {
                SearchViewAnimationHelper.this.U(z2 ? 0.0f : 1.0f);
            }
        });
        return animatorSet;
    }

    private int C(View view) {
        int b2 = MarginLayoutParamsCompat.b((ViewGroup.MarginLayoutParams) view.getLayoutParams());
        return ViewUtils.s(this.o) ? this.o.getLeft() - b2 : (this.o.getRight() - this.f21756a.getWidth()) + b2;
    }

    private int D(View view) {
        int c2 = MarginLayoutParamsCompat.c((ViewGroup.MarginLayoutParams) view.getLayoutParams());
        int n0 = ViewCompat.n0(this.o);
        return ViewUtils.s(this.o) ? ((this.o.getWidth() - this.o.getRight()) + c2) - n0 : (this.o.getLeft() - c2) + n0;
    }

    private int E() {
        return ((this.o.getTop() + this.o.getBottom()) / 2) - ((this.f21760e.getTop() + this.f21760e.getBottom()) / 2);
    }

    private Animator F(boolean z2) {
        return K(z2, false, this.f21759d);
    }

    private Animator G(boolean z2) {
        Rect m2 = this.f21768m.m();
        Rect l2 = this.f21768m.l();
        if (m2 == null) {
            m2 = ViewUtils.d(this.f21756a);
        }
        if (l2 == null) {
            l2 = ViewUtils.c(this.f21758c, this.o);
        }
        Rect rect = new Rect(l2);
        float cornerSize = this.o.getCornerSize();
        float max = Math.max(this.f21758c.getCornerRadius(), (float) this.f21768m.k());
        ValueAnimator ofObject = ValueAnimator.ofObject(new RectEvaluator(rect), new Object[]{l2, m2});
        ofObject.addUpdateListener(new y(this, cornerSize, max, rect));
        ofObject.setDuration(z2 ? 300 : 250);
        ofObject.setInterpolator(ReversableAnimatedValueInterpolator.a(z2, AnimationUtils.f20767b));
        return ofObject;
    }

    private Animator H(boolean z2) {
        TimeInterpolator timeInterpolator = z2 ? AnimationUtils.f20766a : AnimationUtils.f20767b;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setDuration(z2 ? 300 : 250);
        ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.a(z2, timeInterpolator));
        ofFloat.addUpdateListener(MultiViewUpdateListener.f(this.f21757b));
        return ofFloat;
    }

    private Animator I(boolean z2) {
        return K(z2, true, this.f21763h);
    }

    private AnimatorSet J(boolean z2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{L()});
        k(animatorSet);
        animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.a(z2, AnimationUtils.f20767b));
        animatorSet.setDuration(z2 ? C : 300);
        return animatorSet;
    }

    private Animator K(boolean z2, boolean z3, View view) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) (z3 ? D(view) : C(view)), 0.0f});
        ofFloat.addUpdateListener(MultiViewUpdateListener.n(view));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{(float) E(), 0.0f});
        ofFloat2.addUpdateListener(MultiViewUpdateListener.p(view));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.setDuration(z2 ? 300 : 250);
        animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.a(z2, AnimationUtils.f20767b));
        return animatorSet;
    }

    private Animator L() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) this.f21758c.getHeight(), 0.0f});
        ofFloat.addUpdateListener(MultiViewUpdateListener.p(this.f21758c));
        return ofFloat;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P(float f2, float f3, Rect rect, ValueAnimator valueAnimator) {
        this.f21758c.c(rect, AnimationUtils.a(f2, f3, valueAnimator.getAnimatedFraction()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q() {
        AnimatorSet B2 = B(true);
        B2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (!SearchViewAnimationHelper.this.f21756a.x()) {
                    SearchViewAnimationHelper.this.f21756a.U();
                }
                SearchViewAnimationHelper.this.f21756a.setTransitionState(SearchView.TransitionState.SHOWN);
            }

            public void onAnimationStart(Animator animator) {
                SearchViewAnimationHelper.this.f21758c.setVisibility(0);
                SearchViewAnimationHelper.this.o.L0();
            }
        });
        B2.start();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void R() {
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = this.f21758c;
        clippableRoundedCornerLayout.setTranslationY((float) clippableRoundedCornerLayout.getHeight());
        AnimatorSet J = J(true);
        J.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (!SearchViewAnimationHelper.this.f21756a.x()) {
                    SearchViewAnimationHelper.this.f21756a.U();
                }
                SearchViewAnimationHelper.this.f21756a.setTransitionState(SearchView.TransitionState.SHOWN);
            }

            public void onAnimationStart(Animator animator) {
                SearchViewAnimationHelper.this.f21758c.setVisibility(0);
                SearchViewAnimationHelper.this.f21756a.setTransitionState(SearchView.TransitionState.SHOWING);
            }
        });
        J.start();
    }

    private void T(float f2) {
        ActionMenuView b2;
        if (this.f21756a.B() && (b2 = ToolbarUtils.b(this.f21761f)) != null) {
            b2.setAlpha(f2);
        }
    }

    /* access modifiers changed from: private */
    public void U(float f2) {
        this.f21765j.setAlpha(f2);
        this.f21766k.setAlpha(f2);
        this.f21767l.setAlpha(f2);
        T(f2);
    }

    private void V(Drawable drawable) {
        if (drawable instanceof DrawerArrowDrawable) {
            ((DrawerArrowDrawable) drawable).s(1.0f);
        }
        if (drawable instanceof FadeThroughDrawable) {
            ((FadeThroughDrawable) drawable).a(1.0f);
        }
    }

    private void W(Toolbar toolbar) {
        ActionMenuView b2 = ToolbarUtils.b(toolbar);
        if (b2 != null) {
            for (int i2 = 0; i2 < b2.getChildCount(); i2++) {
                View childAt = b2.getChildAt(i2);
                childAt.setClickable(false);
                childAt.setFocusable(false);
                childAt.setFocusableInTouchMode(false);
            }
        }
    }

    private void Y() {
        Toolbar toolbar;
        int i2;
        Menu menu = this.f21762g.getMenu();
        if (menu != null) {
            menu.clear();
        }
        if (this.o.getMenuResId() == -1 || !this.f21756a.B()) {
            toolbar = this.f21762g;
            i2 = 8;
        } else {
            this.f21762g.z(this.o.getMenuResId());
            W(this.f21762g);
            toolbar = this.f21762g;
            i2 = 0;
        }
        toolbar.setVisibility(i2);
    }

    private AnimatorSet b0() {
        if (this.f21756a.x()) {
            this.f21756a.t();
        }
        AnimatorSet B2 = B(false);
        B2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                SearchViewAnimationHelper.this.f21758c.setVisibility(8);
                if (!SearchViewAnimationHelper.this.f21756a.x()) {
                    SearchViewAnimationHelper.this.f21756a.t();
                }
                SearchViewAnimationHelper.this.f21756a.setTransitionState(SearchView.TransitionState.HIDDEN);
            }

            public void onAnimationStart(Animator animator) {
                SearchViewAnimationHelper.this.f21756a.setTransitionState(SearchView.TransitionState.HIDING);
            }
        });
        B2.start();
        return B2;
    }

    private AnimatorSet c0() {
        if (this.f21756a.x()) {
            this.f21756a.t();
        }
        AnimatorSet J = J(false);
        J.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                SearchViewAnimationHelper.this.f21758c.setVisibility(8);
                if (!SearchViewAnimationHelper.this.f21756a.x()) {
                    SearchViewAnimationHelper.this.f21756a.t();
                }
                SearchViewAnimationHelper.this.f21756a.setTransitionState(SearchView.TransitionState.HIDDEN);
            }

            public void onAnimationStart(Animator animator) {
                SearchViewAnimationHelper.this.f21756a.setTransitionState(SearchView.TransitionState.HIDING);
            }
        });
        J.start();
        return J;
    }

    private void d0() {
        if (this.f21756a.x()) {
            this.f21756a.U();
        }
        this.f21756a.setTransitionState(SearchView.TransitionState.SHOWING);
        Y();
        this.f21764i.setText(this.o.getText());
        EditText editText = this.f21764i;
        editText.setSelection(editText.getText().length());
        this.f21758c.setVisibility(4);
        this.f21758c.post(new A(this));
    }

    private void e0() {
        if (this.f21756a.x()) {
            SearchView searchView = this.f21756a;
            Objects.requireNonNull(searchView);
            searchView.postDelayed(new C(searchView), 150);
        }
        this.f21758c.setVisibility(4);
        this.f21758c.post(new D(this));
    }

    private void j(AnimatorSet animatorSet) {
        ActionMenuView b2 = ToolbarUtils.b(this.f21761f);
        if (b2 != null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) C(b2), 0.0f});
            ofFloat.addUpdateListener(MultiViewUpdateListener.n(b2));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{(float) E(), 0.0f});
            ofFloat2.addUpdateListener(MultiViewUpdateListener.p(b2));
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        }
    }

    private void k(AnimatorSet animatorSet) {
        ImageButton e2 = ToolbarUtils.e(this.f21761f);
        if (e2 != null) {
            Drawable q2 = DrawableCompat.q(e2.getDrawable());
            if (this.f21756a.y()) {
                m(animatorSet, q2);
                n(animatorSet, q2);
                return;
            }
            V(q2);
        }
    }

    private void l(AnimatorSet animatorSet) {
        ImageButton e2 = ToolbarUtils.e(this.f21761f);
        if (e2 != null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) D(e2), 0.0f});
            ofFloat.addUpdateListener(MultiViewUpdateListener.n(e2));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{(float) E(), 0.0f});
            ofFloat2.addUpdateListener(MultiViewUpdateListener.p(e2));
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        }
    }

    private void m(AnimatorSet animatorSet, Drawable drawable) {
        if (drawable instanceof DrawerArrowDrawable) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ofFloat.addUpdateListener(new z((DrawerArrowDrawable) drawable));
            animatorSet.playTogether(new Animator[]{ofFloat});
        }
    }

    private void n(AnimatorSet animatorSet, Drawable drawable) {
        if (drawable instanceof FadeThroughDrawable) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            ofFloat.addUpdateListener(new B((FadeThroughDrawable) drawable));
            animatorSet.playTogether(new Animator[]{ofFloat});
        }
    }

    private Animator q(boolean z2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setDuration(z2 ? 300 : 250);
        ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.a(z2, AnimationUtils.f20767b));
        if (this.f21756a.B()) {
            ofFloat.addUpdateListener(new FadeThroughUpdateListener(ToolbarUtils.b(this.f21762g), ToolbarUtils.b(this.f21761f)));
        }
        return ofFloat;
    }

    private AnimatorSet s(boolean z2) {
        AnimatorSet animatorSet = new AnimatorSet();
        k(animatorSet);
        animatorSet.setDuration(z2 ? 300 : 250);
        animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.a(z2, AnimationUtils.f20767b));
        return animatorSet;
    }

    private AnimatorSet t(boolean z2) {
        AnimatorSet animatorSet = new AnimatorSet();
        l(animatorSet);
        j(animatorSet);
        animatorSet.setDuration(z2 ? 300 : 250);
        animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.a(z2, AnimationUtils.f20767b));
        return animatorSet;
    }

    private Animator u(boolean z2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setDuration(z2 ? q : w);
        ofFloat.setStartDelay(z2 ? 250 : 0);
        ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.a(z2, AnimationUtils.f20766a));
        ofFloat.addUpdateListener(MultiViewUpdateListener.f(this.f21765j));
        return ofFloat;
    }

    private Animator v(boolean z2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setDuration(z2 ? 150 : y);
        ofFloat.setStartDelay(z2 ? 75 : 0);
        ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.a(z2, AnimationUtils.f20766a));
        ofFloat.addUpdateListener(MultiViewUpdateListener.f(this.f21766k, this.f21767l));
        return ofFloat;
    }

    private Animator w(boolean z2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{v(z2), y(z2), x(z2)});
        return animatorSet;
    }

    private Animator x(boolean z2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{B, 1.0f});
        ofFloat.setDuration(z2 ? 300 : 250);
        ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.a(z2, AnimationUtils.f20767b));
        ofFloat.addUpdateListener(MultiViewUpdateListener.h(this.f21767l));
        return ofFloat;
    }

    private Animator y(boolean z2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(((float) this.f21767l.getHeight()) * 0.050000012f) / 2.0f, 0.0f});
        ofFloat.setDuration(z2 ? 300 : 250);
        ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.a(z2, AnimationUtils.f20767b));
        ofFloat.addUpdateListener(MultiViewUpdateListener.p(this.f21766k));
        return ofFloat;
    }

    private Animator z(boolean z2) {
        return K(z2, false, this.f21762g);
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public AnimatorSet M() {
        return this.o != null ? b0() : c0();
    }

    @Nullable
    public BackEventCompat S() {
        return this.f21768m.c();
    }

    /* access modifiers changed from: package-private */
    public void X(SearchBar searchBar) {
        this.o = searchBar;
    }

    /* access modifiers changed from: package-private */
    public void Z() {
        if (this.o != null) {
            d0();
        } else {
            e0();
        }
    }

    /* access modifiers changed from: package-private */
    public void a0(@NonNull BackEventCompat backEventCompat) {
        this.f21768m.t(backEventCompat, this.o);
    }

    @RequiresApi(34)
    public void f0(@NonNull BackEventCompat backEventCompat) {
        if (backEventCompat.a() > 0.0f) {
            MaterialMainContainerBackHelper materialMainContainerBackHelper = this.f21768m;
            SearchBar searchBar = this.o;
            materialMainContainerBackHelper.v(backEventCompat, searchBar, searchBar.getCornerSize());
            AnimatorSet animatorSet = this.f21769n;
            if (animatorSet == null) {
                if (this.f21756a.x()) {
                    this.f21756a.t();
                }
                if (this.f21756a.y()) {
                    AnimatorSet s2 = s(false);
                    this.f21769n = s2;
                    s2.start();
                    this.f21769n.pause();
                    return;
                }
                return;
            }
            animatorSet.setCurrentPlayTime((long) (backEventCompat.a() * ((float) this.f21769n.getDuration())));
        }
    }

    @RequiresApi(34)
    public void o() {
        this.f21768m.g(this.o);
        AnimatorSet animatorSet = this.f21769n;
        if (animatorSet != null) {
            animatorSet.reverse();
        }
        this.f21769n = null;
    }

    @RequiresApi(34)
    public void p() {
        this.f21768m.j(M().getTotalDuration(), this.o);
        if (this.f21769n != null) {
            t(false).start();
            this.f21769n.resume();
        }
        this.f21769n = null;
    }

    /* access modifiers changed from: package-private */
    public MaterialMainContainerBackHelper r() {
        return this.f21768m;
    }
}
