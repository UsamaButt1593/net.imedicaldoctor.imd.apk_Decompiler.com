package androidx.media3.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

final class PlayerControlViewLayoutManager {
    private static final long D = 2000;
    private static final long E = 250;
    private static final long F = 250;
    private static final int G = 0;
    private static final int H = 1;
    private static final int I = 2;
    private static final int J = 3;
    private static final int K = 4;
    /* access modifiers changed from: private */
    public boolean A;
    /* access modifiers changed from: private */
    public boolean B;
    private boolean C = true;

    /* renamed from: a  reason: collision with root package name */
    private final PlayerControlView f14644a;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final View f14645b;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final ViewGroup f14646c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final ViewGroup f14647d;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final ViewGroup f14648e;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final ViewGroup f14649f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final ViewGroup f14650g;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final ViewGroup f14651h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private final ViewGroup f14652i;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public final View f14653j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private final View f14654k;

    /* renamed from: l  reason: collision with root package name */
    private final AnimatorSet f14655l;

    /* renamed from: m  reason: collision with root package name */
    private final AnimatorSet f14656m;

    /* renamed from: n  reason: collision with root package name */
    private final AnimatorSet f14657n;
    private final AnimatorSet o;
    private final AnimatorSet p;
    private final ValueAnimator q;
    private final ValueAnimator r;
    /* access modifiers changed from: private */
    public final Runnable s = new t(this);
    private final Runnable t = new w(this);
    private final Runnable u = new x(this);
    private final Runnable v = new y(this);
    private final Runnable w = new z(this);
    private final View.OnLayoutChangeListener x = new A(this);
    private final List<View> y = new ArrayList();
    private int z = 0;

    public PlayerControlViewLayoutManager(final PlayerControlView playerControlView) {
        this.f14644a = playerControlView;
        this.f14645b = playerControlView.findViewById(R.id.h0);
        this.f14646c = (ViewGroup) playerControlView.findViewById(R.id.c0);
        this.f14648e = (ViewGroup) playerControlView.findViewById(R.id.r0);
        ViewGroup viewGroup = (ViewGroup) playerControlView.findViewById(R.id.a0);
        this.f14647d = viewGroup;
        this.f14652i = (ViewGroup) playerControlView.findViewById(R.id.Q0);
        View findViewById = playerControlView.findViewById(R.id.D0);
        this.f14653j = findViewById;
        this.f14649f = (ViewGroup) playerControlView.findViewById(R.id.Z);
        this.f14650g = (ViewGroup) playerControlView.findViewById(R.id.k0);
        this.f14651h = (ViewGroup) playerControlView.findViewById(R.id.l0);
        View findViewById2 = playerControlView.findViewById(R.id.v0);
        this.f14654k = findViewById2;
        View findViewById3 = playerControlView.findViewById(R.id.u0);
        if (!(findViewById2 == null || findViewById3 == null)) {
            findViewById2.setOnClickListener(new p(this));
            findViewById3.setOnClickListener(new p(this));
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new q(this));
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (PlayerControlViewLayoutManager.this.f14645b != null) {
                    PlayerControlViewLayoutManager.this.f14645b.setVisibility(4);
                }
                if (PlayerControlViewLayoutManager.this.f14646c != null) {
                    PlayerControlViewLayoutManager.this.f14646c.setVisibility(4);
                }
                if (PlayerControlViewLayoutManager.this.f14648e != null) {
                    PlayerControlViewLayoutManager.this.f14648e.setVisibility(4);
                }
            }

            public void onAnimationStart(Animator animator) {
                if ((PlayerControlViewLayoutManager.this.f14653j instanceof DefaultTimeBar) && !PlayerControlViewLayoutManager.this.A) {
                    ((DefaultTimeBar) PlayerControlViewLayoutManager.this.f14653j).i(250);
                }
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.addUpdateListener(new C0374r(this));
        ofFloat2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                int i2 = 0;
                if (PlayerControlViewLayoutManager.this.f14645b != null) {
                    PlayerControlViewLayoutManager.this.f14645b.setVisibility(0);
                }
                if (PlayerControlViewLayoutManager.this.f14646c != null) {
                    PlayerControlViewLayoutManager.this.f14646c.setVisibility(0);
                }
                if (PlayerControlViewLayoutManager.this.f14648e != null) {
                    ViewGroup r = PlayerControlViewLayoutManager.this.f14648e;
                    if (!PlayerControlViewLayoutManager.this.A) {
                        i2 = 4;
                    }
                    r.setVisibility(i2);
                }
                if ((PlayerControlViewLayoutManager.this.f14653j instanceof DefaultTimeBar) && !PlayerControlViewLayoutManager.this.A) {
                    ((DefaultTimeBar) PlayerControlViewLayoutManager.this.f14653j).v(250);
                }
            }
        });
        Resources resources = playerControlView.getResources();
        int i2 = R.dimen.F;
        float dimension = resources.getDimension(i2) - resources.getDimension(R.dimen.K);
        float dimension2 = resources.getDimension(i2);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f14655l = animatorSet;
        animatorSet.setDuration(250);
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                PlayerControlViewLayoutManager.this.a0(1);
                if (PlayerControlViewLayoutManager.this.B) {
                    playerControlView.post(PlayerControlViewLayoutManager.this.s);
                    boolean unused = PlayerControlViewLayoutManager.this.B = false;
                }
            }

            public void onAnimationStart(Animator animator) {
                PlayerControlViewLayoutManager.this.a0(3);
            }
        });
        animatorSet.play(ofFloat).with(O(0.0f, dimension, findViewById)).with(O(0.0f, dimension, viewGroup));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f14656m = animatorSet2;
        animatorSet2.setDuration(250);
        animatorSet2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                PlayerControlViewLayoutManager.this.a0(2);
                if (PlayerControlViewLayoutManager.this.B) {
                    playerControlView.post(PlayerControlViewLayoutManager.this.s);
                    boolean unused = PlayerControlViewLayoutManager.this.B = false;
                }
            }

            public void onAnimationStart(Animator animator) {
                PlayerControlViewLayoutManager.this.a0(3);
            }
        });
        animatorSet2.play(O(dimension, dimension2, findViewById)).with(O(dimension, dimension2, viewGroup));
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.f14657n = animatorSet3;
        animatorSet3.setDuration(250);
        animatorSet3.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                PlayerControlViewLayoutManager.this.a0(2);
                if (PlayerControlViewLayoutManager.this.B) {
                    playerControlView.post(PlayerControlViewLayoutManager.this.s);
                    boolean unused = PlayerControlViewLayoutManager.this.B = false;
                }
            }

            public void onAnimationStart(Animator animator) {
                PlayerControlViewLayoutManager.this.a0(3);
            }
        });
        animatorSet3.play(ofFloat).with(O(0.0f, dimension2, findViewById)).with(O(0.0f, dimension2, viewGroup));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.o = animatorSet4;
        animatorSet4.setDuration(250);
        animatorSet4.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                PlayerControlViewLayoutManager.this.a0(0);
            }

            public void onAnimationStart(Animator animator) {
                PlayerControlViewLayoutManager.this.a0(4);
            }
        });
        animatorSet4.play(ofFloat2).with(O(dimension, 0.0f, findViewById)).with(O(dimension, 0.0f, viewGroup));
        AnimatorSet animatorSet5 = new AnimatorSet();
        this.p = animatorSet5;
        animatorSet5.setDuration(250);
        animatorSet5.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                PlayerControlViewLayoutManager.this.a0(0);
            }

            public void onAnimationStart(Animator animator) {
                PlayerControlViewLayoutManager.this.a0(4);
            }
        });
        animatorSet5.play(ofFloat2).with(O(dimension2, 0.0f, findViewById)).with(O(dimension2, 0.0f, viewGroup));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.q = ofFloat3;
        ofFloat3.setDuration(250);
        ofFloat3.addUpdateListener(new u(this));
        ofFloat3.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (PlayerControlViewLayoutManager.this.f14649f != null) {
                    PlayerControlViewLayoutManager.this.f14649f.setVisibility(4);
                }
            }

            public void onAnimationStart(Animator animator) {
                if (PlayerControlViewLayoutManager.this.f14651h != null) {
                    PlayerControlViewLayoutManager.this.f14651h.setVisibility(0);
                    PlayerControlViewLayoutManager.this.f14651h.setTranslationX((float) PlayerControlViewLayoutManager.this.f14651h.getWidth());
                    PlayerControlViewLayoutManager.this.f14651h.scrollTo(PlayerControlViewLayoutManager.this.f14651h.getWidth(), 0);
                }
            }
        });
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.r = ofFloat4;
        ofFloat4.setDuration(250);
        ofFloat4.addUpdateListener(new v(this));
        ofFloat4.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (PlayerControlViewLayoutManager.this.f14651h != null) {
                    PlayerControlViewLayoutManager.this.f14651h.setVisibility(4);
                }
            }

            public void onAnimationStart(Animator animator) {
                if (PlayerControlViewLayoutManager.this.f14649f != null) {
                    PlayerControlViewLayoutManager.this.f14649f.setVisibility(0);
                }
            }
        });
    }

    private static int B(@Nullable View view) {
        if (view == null) {
            return 0;
        }
        int width = view.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return width;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return width + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
    }

    /* access modifiers changed from: private */
    public void D() {
        this.f14657n.start();
    }

    /* access modifiers changed from: private */
    public void E() {
        a0(2);
    }

    /* access modifiers changed from: private */
    public void G() {
        this.f14655l.start();
        V(this.u, 2000);
    }

    /* access modifiers changed from: private */
    public void H() {
        this.f14656m.start();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.f14645b;
        if (view != null) {
            view.setAlpha(floatValue);
        }
        ViewGroup viewGroup = this.f14646c;
        if (viewGroup != null) {
            viewGroup.setAlpha(floatValue);
        }
        ViewGroup viewGroup2 = this.f14648e;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(floatValue);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.f14645b;
        if (view != null) {
            view.setAlpha(floatValue);
        }
        ViewGroup viewGroup = this.f14646c;
        if (viewGroup != null) {
            viewGroup.setAlpha(floatValue);
        }
        ViewGroup viewGroup2 = this.f14648e;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(floatValue);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M(ValueAnimator valueAnimator) {
        y(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N(ValueAnimator valueAnimator) {
        y(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    private static ObjectAnimator O(float f2, float f3, View view) {
        return ObjectAnimator.ofFloat(view, "translationY", new float[]{f2, f3});
    }

    /* access modifiers changed from: private */
    public void S(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        boolean f0 = f0();
        if (this.A != f0) {
            this.A = f0;
            view.post(new o(this));
        }
        boolean z2 = i4 - i2 != i8 - i6;
        if (!this.A && z2) {
            view.post(new s(this));
        }
    }

    /* access modifiers changed from: private */
    public void T() {
        int i2;
        if (this.f14649f != null && this.f14650g != null) {
            int width = (this.f14644a.getWidth() - this.f14644a.getPaddingLeft()) - this.f14644a.getPaddingRight();
            while (true) {
                if (this.f14650g.getChildCount() <= 1) {
                    break;
                }
                int childCount = this.f14650g.getChildCount() - 2;
                View childAt = this.f14650g.getChildAt(childCount);
                this.f14650g.removeViewAt(childCount);
                this.f14649f.addView(childAt, 0);
            }
            View view = this.f14654k;
            if (view != null) {
                view.setVisibility(8);
            }
            int B2 = B(this.f14652i);
            int childCount2 = this.f14649f.getChildCount() - 1;
            for (int i3 = 0; i3 < childCount2; i3++) {
                B2 += B(this.f14649f.getChildAt(i3));
            }
            if (B2 > width) {
                View view2 = this.f14654k;
                if (view2 != null) {
                    view2.setVisibility(0);
                    B2 += B(this.f14654k);
                }
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < childCount2; i4++) {
                    View childAt2 = this.f14649f.getChildAt(i4);
                    B2 -= B(childAt2);
                    arrayList.add(childAt2);
                    if (B2 <= width) {
                        break;
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.f14649f.removeViews(0, arrayList.size());
                    for (i2 = 0; i2 < arrayList.size(); i2++) {
                        this.f14650g.addView((View) arrayList.get(i2), this.f14650g.getChildCount() - 1);
                    }
                    return;
                }
                return;
            }
            ViewGroup viewGroup = this.f14651h;
            if (viewGroup != null && viewGroup.getVisibility() == 0 && !this.r.isStarted()) {
                this.q.cancel();
                this.r.start();
            }
        }
    }

    /* access modifiers changed from: private */
    public void U(View view) {
        ValueAnimator valueAnimator;
        X();
        if (view.getId() == R.id.v0) {
            valueAnimator = this.q;
        } else if (view.getId() == R.id.u0) {
            valueAnimator = this.r;
        } else {
            return;
        }
        valueAnimator.start();
    }

    private void V(Runnable runnable, long j2) {
        if (j2 >= 0) {
            this.f14644a.postDelayed(runnable, j2);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARNING: Removed duplicated region for block: B:9:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a0(int r4) {
        /*
            r3 = this;
            int r0 = r3.z
            r3.z = r4
            r1 = 2
            if (r4 != r1) goto L_0x000f
            androidx.media3.ui.PlayerControlView r1 = r3.f14644a
            r2 = 8
        L_0x000b:
            r1.setVisibility(r2)
            goto L_0x0015
        L_0x000f:
            if (r0 != r1) goto L_0x0015
            androidx.media3.ui.PlayerControlView r1 = r3.f14644a
            r2 = 0
            goto L_0x000b
        L_0x0015:
            if (r0 == r4) goto L_0x001c
            androidx.media3.ui.PlayerControlView r4 = r3.f14644a
            r4.g0()
        L_0x001c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.PlayerControlViewLayoutManager.a0(int):void");
    }

    private boolean b0(View view) {
        int id = view.getId();
        return id == R.id.a0 || id == R.id.C0 || id == R.id.t0 || id == R.id.G0 || id == R.id.H0 || id == R.id.m0 || id == R.id.n0;
    }

    /* access modifiers changed from: private */
    public void d0() {
        AnimatorSet animatorSet;
        if (!this.C) {
            a0(0);
            X();
            return;
        }
        int i2 = this.z;
        if (i2 == 1) {
            animatorSet = this.o;
        } else if (i2 != 2) {
            if (i2 == 3) {
                this.B = true;
            } else if (i2 == 4) {
                return;
            }
            X();
        } else {
            animatorSet = this.p;
        }
        animatorSet.start();
        X();
    }

    /* access modifiers changed from: private */
    public void e0() {
        ViewGroup viewGroup = this.f14648e;
        if (viewGroup != null) {
            viewGroup.setVisibility(this.A ? 0 : 4);
        }
        if (this.f14653j != null) {
            int dimensionPixelSize = this.f14644a.getResources().getDimensionPixelSize(R.dimen.O);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f14653j.getLayoutParams();
            if (marginLayoutParams != null) {
                if (this.A) {
                    dimensionPixelSize = 0;
                }
                marginLayoutParams.bottomMargin = dimensionPixelSize;
                this.f14653j.setLayoutParams(marginLayoutParams);
            }
            View view = this.f14653j;
            if (view instanceof DefaultTimeBar) {
                DefaultTimeBar defaultTimeBar = (DefaultTimeBar) view;
                if (this.A) {
                    defaultTimeBar.j(true);
                } else {
                    int i2 = this.z;
                    if (i2 == 1) {
                        defaultTimeBar.j(false);
                    } else if (i2 != 3) {
                        defaultTimeBar.u();
                    }
                }
            }
        }
        for (View next : this.y) {
            next.setVisibility((!this.A || !b0(next)) ? 0 : 4);
        }
    }

    private boolean f0() {
        int width = (this.f14644a.getWidth() - this.f14644a.getPaddingLeft()) - this.f14644a.getPaddingRight();
        int height = (this.f14644a.getHeight() - this.f14644a.getPaddingBottom()) - this.f14644a.getPaddingTop();
        int B2 = B(this.f14646c);
        ViewGroup viewGroup = this.f14646c;
        int paddingLeft = B2 - (viewGroup != null ? viewGroup.getPaddingLeft() + this.f14646c.getPaddingRight() : 0);
        int z2 = z(this.f14646c);
        ViewGroup viewGroup2 = this.f14646c;
        return width <= Math.max(paddingLeft, B(this.f14652i) + B(this.f14654k)) || height <= (z2 - (viewGroup2 != null ? viewGroup2.getPaddingTop() + this.f14646c.getPaddingBottom() : 0)) + (z(this.f14647d) * 2);
    }

    private void y(float f2) {
        ViewGroup viewGroup = this.f14651h;
        if (viewGroup != null) {
            this.f14651h.setTranslationX((float) ((int) (((float) viewGroup.getWidth()) * (1.0f - f2))));
        }
        ViewGroup viewGroup2 = this.f14652i;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(1.0f - f2);
        }
        ViewGroup viewGroup3 = this.f14649f;
        if (viewGroup3 != null) {
            viewGroup3.setAlpha(1.0f - f2);
        }
    }

    private static int z(@Nullable View view) {
        if (view == null) {
            return 0;
        }
        int height = view.getHeight();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return height;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return height + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public boolean A(@Nullable View view) {
        return view != null && this.y.contains(view);
    }

    public void C() {
        int i2 = this.z;
        if (i2 != 3 && i2 != 2) {
            W();
            if (!this.C) {
                E();
            } else if (this.z == 1) {
                H();
            } else {
                D();
            }
        }
    }

    public void F() {
        int i2 = this.z;
        if (i2 != 3 && i2 != 2) {
            W();
            E();
        }
    }

    public boolean I() {
        return this.C;
    }

    public boolean J() {
        return this.z == 0 && this.f14644a.f0();
    }

    public void P() {
        this.f14644a.addOnLayoutChangeListener(this.x);
    }

    public void Q() {
        this.f14644a.removeOnLayoutChangeListener(this.x);
    }

    public void R(boolean z2, int i2, int i3, int i4, int i5) {
        View view = this.f14645b;
        if (view != null) {
            view.layout(0, 0, i4 - i2, i5 - i3);
        }
    }

    public void W() {
        this.f14644a.removeCallbacks(this.w);
        this.f14644a.removeCallbacks(this.t);
        this.f14644a.removeCallbacks(this.v);
        this.f14644a.removeCallbacks(this.u);
    }

    public void X() {
        Runnable runnable;
        if (this.z != 3) {
            W();
            int showTimeoutMs = this.f14644a.getShowTimeoutMs();
            if (showTimeoutMs > 0) {
                if (!this.C) {
                    runnable = this.w;
                } else if (this.z == 1) {
                    V(this.u, 2000);
                    return;
                } else {
                    runnable = this.v;
                }
                V(runnable, (long) showTimeoutMs);
            }
        }
    }

    public void Y(boolean z2) {
        this.C = z2;
    }

    public void Z(@Nullable View view, boolean z2) {
        if (view != null) {
            if (!z2) {
                view.setVisibility(8);
                this.y.remove(view);
                return;
            }
            view.setVisibility((!this.A || !b0(view)) ? 0 : 4);
            this.y.add(view);
        }
    }

    public void c0() {
        if (!this.f14644a.f0()) {
            this.f14644a.setVisibility(0);
            this.f14644a.q0();
            this.f14644a.l0();
        }
        d0();
    }
}
