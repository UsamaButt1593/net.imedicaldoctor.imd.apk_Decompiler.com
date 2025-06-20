package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimatableView;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.ExpandCollapseAnimationHelper;
import com.google.android.material.internal.MultiViewUpdateListener;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.search.SearchBar;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class SearchBarAnimationHelper {

    /* renamed from: j  reason: collision with root package name */
    private static final long f21742j = 250;

    /* renamed from: k  reason: collision with root package name */
    private static final long f21743k = 500;

    /* renamed from: l  reason: collision with root package name */
    private static final long f21744l = 750;

    /* renamed from: m  reason: collision with root package name */
    private static final long f21745m = 250;

    /* renamed from: n  reason: collision with root package name */
    private static final long f21746n = 250;
    private static final long o = 300;
    private static final long p = 75;
    private static final long q = 250;
    private static final long r = 100;

    /* renamed from: a  reason: collision with root package name */
    private final Set<SearchBar.OnLoadAnimationCallback> f21747a = new LinkedHashSet();

    /* renamed from: b  reason: collision with root package name */
    private final Set<AnimatorListenerAdapter> f21748b = new LinkedHashSet();

    /* renamed from: c  reason: collision with root package name */
    private final Set<AnimatorListenerAdapter> f21749c = new LinkedHashSet();
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Animator f21750d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private Animator f21751e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f21752f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f21753g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f21754h = true;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public Animator f21755i = null;

    private interface OnLoadAnimationInvocation {
        void a(SearchBar.OnLoadAnimationCallback onLoadAnimationCallback);
    }

    SearchBarAnimationHelper() {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void A(MaterialShapeDrawable materialShapeDrawable, View view, ValueAnimator valueAnimator) {
        materialShapeDrawable.q0(1.0f - valueAnimator.getAnimatedFraction());
        ViewCompat.P1(view, materialShapeDrawable);
        view.setAlpha(1.0f);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C(SearchBar searchBar, View view, AppBarLayout appBarLayout, boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{t(searchBar, view), o(searchBar, view, appBarLayout)});
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                Animator unused = SearchBarAnimationHelper.this.f21755i = null;
            }
        });
        for (AnimatorListenerAdapter addListener : this.f21748b) {
            animatorSet.addListener(addListener);
        }
        if (z) {
            animatorSet.setDuration(0);
        }
        animatorSet.start();
        this.f21755i = animatorSet;
    }

    /* access modifiers changed from: private */
    public void k(OnLoadAnimationInvocation onLoadAnimationInvocation) {
        for (SearchBar.OnLoadAnimationCallback a2 : this.f21747a) {
            onLoadAnimationInvocation.a(a2);
        }
    }

    private Animator l(final SearchBar searchBar, View view, AppBarLayout appBarLayout) {
        return p(searchBar, view, appBarLayout).p(250).e(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                searchBar.setVisibility(0);
                boolean unused = SearchBarAnimationHelper.this.f21753g = false;
            }

            public void onAnimationStart(Animator animator) {
                searchBar.L0();
            }
        }).h();
    }

    private Animator m(@Nullable View view) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(MultiViewUpdateListener.f(view));
        TimeInterpolator timeInterpolator = AnimationUtils.f20766a;
        ofFloat.setInterpolator(timeInterpolator);
        long j2 = 0;
        ofFloat.setDuration(this.f21754h ? 250 : 0);
        if (this.f21754h) {
            j2 = 500;
        }
        ofFloat.setStartDelay(j2);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat2.addUpdateListener(MultiViewUpdateListener.f(view));
        ofFloat2.setInterpolator(timeInterpolator);
        ofFloat2.setDuration(250);
        ofFloat2.setStartDelay(f21744l);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{ofFloat, ofFloat2});
        return animatorSet;
    }

    private List<View> n(View view) {
        boolean s = ViewUtils.s(view);
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if ((!s && (childAt instanceof ActionMenuView)) || (s && !(childAt instanceof ActionMenuView))) {
                    arrayList.add(childAt);
                }
            }
        }
        return arrayList;
    }

    private Animator o(final SearchBar searchBar, View view, @Nullable AppBarLayout appBarLayout) {
        return p(searchBar, view, appBarLayout).p(o).e(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean unused = SearchBarAnimationHelper.this.f21752f = false;
            }

            public void onAnimationStart(Animator animator) {
                searchBar.setVisibility(4);
            }
        }).j();
    }

    private ExpandCollapseAnimationHelper p(SearchBar searchBar, View view, @Nullable AppBarLayout appBarLayout) {
        return new ExpandCollapseAnimationHelper(searchBar, view).n(q(searchBar, view)).o(appBarLayout != null ? appBarLayout.getTop() : 0).c(n(view));
    }

    private ValueAnimator.AnimatorUpdateListener q(SearchBar searchBar, View view) {
        MaterialShapeDrawable m2 = MaterialShapeDrawable.m(view.getContext());
        m2.l0(searchBar.getCornerSize());
        m2.o0(ViewCompat.T(searchBar));
        return new h(m2, view);
    }

    private List<View> r(SearchBar searchBar) {
        List<View> k2 = ViewUtils.k(searchBar);
        if (searchBar.getCenterView() != null) {
            k2.remove(searchBar.getCenterView());
        }
        return k2;
    }

    private Animator s(SearchBar searchBar) {
        List<View> r2 = r(searchBar);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(MultiViewUpdateListener.e(r2));
        ofFloat.setDuration(r);
        ofFloat.setInterpolator(AnimationUtils.f20766a);
        return ofFloat;
    }

    private Animator t(SearchBar searchBar, View view) {
        List<View> r2 = r(searchBar);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat.addUpdateListener(MultiViewUpdateListener.e(r2));
        ofFloat.addUpdateListener(new C0465d(view));
        ofFloat.setDuration(75);
        ofFloat.setInterpolator(AnimationUtils.f20766a);
        return ofFloat;
    }

    private Animator u(@Nullable View view) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(MultiViewUpdateListener.f(view));
        ofFloat.setInterpolator(AnimationUtils.f20766a);
        ofFloat.setDuration(250);
        return ofFloat;
    }

    private Animator v(TextView textView, @Nullable View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setStartDelay(250);
        animatorSet.play(w(textView));
        if (view != null) {
            animatorSet.play(u(view));
        }
        return animatorSet;
    }

    private Animator w(TextView textView) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(MultiViewUpdateListener.f(textView));
        ofFloat.setInterpolator(AnimationUtils.f20766a);
        ofFloat.setDuration(250);
        return ofFloat;
    }

    /* access modifiers changed from: package-private */
    public boolean D(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        return this.f21749c.remove(animatorListenerAdapter);
    }

    /* access modifiers changed from: package-private */
    public boolean E(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        return this.f21748b.remove(animatorListenerAdapter);
    }

    /* access modifiers changed from: package-private */
    public boolean F(SearchBar.OnLoadAnimationCallback onLoadAnimationCallback) {
        return this.f21747a.remove(onLoadAnimationCallback);
    }

    /* access modifiers changed from: package-private */
    public void G(boolean z) {
        this.f21754h = z;
    }

    /* access modifiers changed from: package-private */
    public void H(SearchBar searchBar, View view, @Nullable AppBarLayout appBarLayout, boolean z) {
        Animator animator;
        if (y() && (animator = this.f21755i) != null) {
            animator.cancel();
        }
        this.f21753g = true;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{l(searchBar, view, appBarLayout), s(searchBar)});
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                Animator unused = SearchBarAnimationHelper.this.f21755i = null;
            }
        });
        for (AnimatorListenerAdapter addListener : this.f21749c) {
            animatorSet.addListener(addListener);
        }
        if (z) {
            animatorSet.setDuration(0);
        }
        animatorSet.start();
        this.f21755i = animatorSet;
    }

    /* access modifiers changed from: package-private */
    public void I(SearchBar searchBar, View view, @Nullable AppBarLayout appBarLayout, boolean z) {
        Animator animator;
        if (x() && (animator = this.f21755i) != null) {
            animator.cancel();
        }
        this.f21752f = true;
        view.setVisibility(4);
        view.post(new g(this, searchBar, view, appBarLayout, z));
    }

    /* access modifiers changed from: package-private */
    public void J(SearchBar searchBar) {
        k(new e());
        TextView textView = searchBar.getTextView();
        final View centerView = searchBar.getCenterView();
        View f2 = ToolbarUtils.f(searchBar);
        final Animator v = v(textView, f2);
        v.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                SearchBarAnimationHelper.this.k(new i());
            }
        });
        this.f21750d = v;
        textView.setAlpha(0.0f);
        if (f2 != null) {
            f2.setAlpha(0.0f);
        }
        if (centerView instanceof AnimatableView) {
            ((AnimatableView) centerView).a(new f(v));
        } else if (centerView != null) {
            centerView.setAlpha(0.0f);
            centerView.setVisibility(0);
            Animator m2 = m(centerView);
            this.f21751e = m2;
            m2.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    centerView.setVisibility(8);
                    v.start();
                }
            });
            m2.start();
        } else {
            v.start();
        }
    }

    /* access modifiers changed from: package-private */
    public void K(SearchBar searchBar) {
        Animator animator = this.f21750d;
        if (animator != null) {
            animator.end();
        }
        Animator animator2 = this.f21751e;
        if (animator2 != null) {
            animator2.end();
        }
        View centerView = searchBar.getCenterView();
        if (centerView instanceof AnimatableView) {
            ((AnimatableView) centerView).b();
        }
        if (centerView != null) {
            centerView.setAlpha(0.0f);
        }
    }

    /* access modifiers changed from: package-private */
    public void h(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        this.f21749c.add(animatorListenerAdapter);
    }

    /* access modifiers changed from: package-private */
    public void i(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        this.f21748b.add(animatorListenerAdapter);
    }

    /* access modifiers changed from: package-private */
    public void j(SearchBar.OnLoadAnimationCallback onLoadAnimationCallback) {
        this.f21747a.add(onLoadAnimationCallback);
    }

    /* access modifiers changed from: package-private */
    public boolean x() {
        return this.f21753g;
    }

    /* access modifiers changed from: package-private */
    public boolean y() {
        return this.f21752f;
    }

    /* access modifiers changed from: package-private */
    public boolean z() {
        return this.f21754h;
    }
}
