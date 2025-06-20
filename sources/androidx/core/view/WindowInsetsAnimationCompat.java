package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public final class WindowInsetsAnimationCompat {

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f6534b = false;

    /* renamed from: c  reason: collision with root package name */
    private static final String f6535c = "WindowInsetsAnimCompat";

    /* renamed from: a  reason: collision with root package name */
    private Impl f6536a;

    public static final class BoundsCompat {

        /* renamed from: a  reason: collision with root package name */
        private final Insets f6537a;

        /* renamed from: b  reason: collision with root package name */
        private final Insets f6538b;

        @RequiresApi(30)
        private BoundsCompat(@NonNull WindowInsetsAnimation.Bounds bounds) {
            this.f6537a = Impl30.k(bounds);
            this.f6538b = Impl30.j(bounds);
        }

        @RequiresApi(30)
        @NonNull
        public static BoundsCompat e(@NonNull WindowInsetsAnimation.Bounds bounds) {
            return new BoundsCompat(bounds);
        }

        @NonNull
        public Insets a() {
            return this.f6537a;
        }

        @NonNull
        public Insets b() {
            return this.f6538b;
        }

        @NonNull
        public BoundsCompat c(@NonNull Insets insets) {
            return new BoundsCompat(WindowInsetsCompat.z(this.f6537a, insets.f5824a, insets.f5825b, insets.f5826c, insets.f5827d), WindowInsetsCompat.z(this.f6538b, insets.f5824a, insets.f5825b, insets.f5826c, insets.f5827d));
        }

        @RequiresApi(30)
        @NonNull
        public WindowInsetsAnimation.Bounds d() {
            return Impl30.i(this);
        }

        public String toString() {
            return "Bounds{lower=" + this.f6537a + " upper=" + this.f6538b + "}";
        }

        public BoundsCompat(@NonNull Insets insets, @NonNull Insets insets2) {
            this.f6537a = insets;
            this.f6538b = insets2;
        }
    }

    public static abstract class Callback {

        /* renamed from: c  reason: collision with root package name */
        public static final int f6539c = 0;

        /* renamed from: d  reason: collision with root package name */
        public static final int f6540d = 1;

        /* renamed from: a  reason: collision with root package name */
        WindowInsets f6541a;

        /* renamed from: b  reason: collision with root package name */
        private final int f6542b;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        public @interface DispatchMode {
        }

        public Callback(int i2) {
            this.f6542b = i2;
        }

        public final int a() {
            return this.f6542b;
        }

        public void b(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        }

        public void c(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        }

        @NonNull
        public abstract WindowInsetsCompat d(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull List<WindowInsetsAnimationCompat> list);

        @NonNull
        public BoundsCompat e(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat, @NonNull BoundsCompat boundsCompat) {
            return boundsCompat;
        }
    }

    private static class Impl {

        /* renamed from: a  reason: collision with root package name */
        private final int f6543a;

        /* renamed from: b  reason: collision with root package name */
        private float f6544b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private final Interpolator f6545c;

        /* renamed from: d  reason: collision with root package name */
        private final long f6546d;

        /* renamed from: e  reason: collision with root package name */
        private float f6547e;

        Impl(int i2, @Nullable Interpolator interpolator, long j2) {
            this.f6543a = i2;
            this.f6545c = interpolator;
            this.f6546d = j2;
        }

        public float a() {
            return this.f6547e;
        }

        public long b() {
            return this.f6546d;
        }

        public float c() {
            return this.f6544b;
        }

        public float d() {
            Interpolator interpolator = this.f6545c;
            return interpolator != null ? interpolator.getInterpolation(this.f6544b) : this.f6544b;
        }

        @Nullable
        public Interpolator e() {
            return this.f6545c;
        }

        public int f() {
            return this.f6543a;
        }

        public void g(float f2) {
            this.f6547e = f2;
        }

        public void h(float f2) {
            this.f6544b = f2;
        }
    }

    @RequiresApi(21)
    private static class Impl21 extends Impl {

        /* renamed from: f  reason: collision with root package name */
        private static final Interpolator f6548f = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);

        /* renamed from: g  reason: collision with root package name */
        private static final Interpolator f6549g = new FastOutLinearInInterpolator();

        /* renamed from: h  reason: collision with root package name */
        private static final Interpolator f6550h = new DecelerateInterpolator();

        @RequiresApi(21)
        private static class Impl21OnApplyWindowInsetsListener implements View.OnApplyWindowInsetsListener {

            /* renamed from: c  reason: collision with root package name */
            private static final int f6551c = 160;

            /* renamed from: a  reason: collision with root package name */
            final Callback f6552a;

            /* renamed from: b  reason: collision with root package name */
            private WindowInsetsCompat f6553b;

            Impl21OnApplyWindowInsetsListener(@NonNull View view, @NonNull Callback callback) {
                this.f6552a = callback;
                WindowInsetsCompat r0 = ViewCompat.r0(view);
                this.f6553b = r0 != null ? new WindowInsetsCompat.Builder(r0).a() : null;
            }

            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                final View view2 = view;
                WindowInsets windowInsets2 = windowInsets;
                if (!view.isLaidOut()) {
                    this.f6553b = WindowInsetsCompat.L(windowInsets2, view2);
                } else {
                    WindowInsetsCompat L = WindowInsetsCompat.L(windowInsets2, view2);
                    if (this.f6553b == null) {
                        this.f6553b = ViewCompat.r0(view);
                    }
                    if (this.f6553b != null) {
                        Callback r = Impl21.r(view);
                        if (r != null && Objects.equals(r.f6541a, windowInsets2)) {
                            return Impl21.q(view, windowInsets);
                        }
                        final int i2 = Impl21.i(L, this.f6553b);
                        if (i2 == 0) {
                            return Impl21.q(view, windowInsets);
                        }
                        final WindowInsetsCompat windowInsetsCompat = this.f6553b;
                        final WindowInsetsAnimationCompat windowInsetsAnimationCompat = new WindowInsetsAnimationCompat(i2, Impl21.k(i2, L, windowInsetsCompat), 160);
                        windowInsetsAnimationCompat.i(0.0f);
                        ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(windowInsetsAnimationCompat.b());
                        BoundsCompat j2 = Impl21.j(L, windowInsetsCompat, i2);
                        Impl21.n(view2, windowInsetsAnimationCompat, windowInsets2, false);
                        final WindowInsetsAnimationCompat windowInsetsAnimationCompat2 = windowInsetsAnimationCompat;
                        final WindowInsetsCompat windowInsetsCompat2 = L;
                        final View view3 = view;
                        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                windowInsetsAnimationCompat2.i(valueAnimator.getAnimatedFraction());
                                Impl21.o(view3, Impl21.s(windowInsetsCompat2, windowInsetsCompat, windowInsetsAnimationCompat2.d(), i2), Collections.singletonList(windowInsetsAnimationCompat2));
                            }
                        });
                        duration.addListener(new AnimatorListenerAdapter() {
                            public void onAnimationEnd(Animator animator) {
                                windowInsetsAnimationCompat.i(1.0f);
                                Impl21.m(view2, windowInsetsAnimationCompat);
                            }
                        });
                        final View view4 = view;
                        final WindowInsetsAnimationCompat windowInsetsAnimationCompat3 = windowInsetsAnimationCompat;
                        final BoundsCompat boundsCompat = j2;
                        final ValueAnimator valueAnimator = duration;
                        OneShotPreDrawListener.a(view2, new Runnable() {
                            public void run() {
                                Impl21.p(view4, windowInsetsAnimationCompat3, boundsCompat);
                                valueAnimator.start();
                            }
                        });
                    }
                    this.f6553b = L;
                }
                return Impl21.q(view, windowInsets);
            }
        }

        Impl21(int i2, @Nullable Interpolator interpolator, long j2) {
            super(i2, interpolator, j2);
        }

        @SuppressLint({"WrongConstant"})
        static int i(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsetsCompat windowInsetsCompat2) {
            int i2 = 0;
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if (!windowInsetsCompat.f(i3).equals(windowInsetsCompat2.f(i3))) {
                    i2 |= i3;
                }
            }
            return i2;
        }

        @NonNull
        static BoundsCompat j(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsetsCompat windowInsetsCompat2, int i2) {
            Insets f2 = windowInsetsCompat.f(i2);
            Insets f3 = windowInsetsCompat2.f(i2);
            return new BoundsCompat(Insets.d(Math.min(f2.f5824a, f3.f5824a), Math.min(f2.f5825b, f3.f5825b), Math.min(f2.f5826c, f3.f5826c), Math.min(f2.f5827d, f3.f5827d)), Insets.d(Math.max(f2.f5824a, f3.f5824a), Math.max(f2.f5825b, f3.f5825b), Math.max(f2.f5826c, f3.f5826c), Math.max(f2.f5827d, f3.f5827d)));
        }

        static Interpolator k(int i2, WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2) {
            if ((i2 & 8) != 0) {
                return windowInsetsCompat.f(WindowInsetsCompat.Type.d()).f5827d > windowInsetsCompat2.f(WindowInsetsCompat.Type.d()).f5827d ? f6548f : f6549g;
            }
            return f6550h;
        }

        @NonNull
        private static View.OnApplyWindowInsetsListener l(@NonNull View view, @NonNull Callback callback) {
            return new Impl21OnApplyWindowInsetsListener(view, callback);
        }

        static void m(@NonNull View view, @NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
            Callback r = r(view);
            if (r != null) {
                r.b(windowInsetsAnimationCompat);
                if (r.a() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    m(viewGroup.getChildAt(i2), windowInsetsAnimationCompat);
                }
            }
        }

        static void n(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsets windowInsets, boolean z) {
            Callback r = r(view);
            if (r != null) {
                r.f6541a = windowInsets;
                if (!z) {
                    r.c(windowInsetsAnimationCompat);
                    z = r.a() == 0;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    n(viewGroup.getChildAt(i2), windowInsetsAnimationCompat, windowInsets, z);
                }
            }
        }

        static void o(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull List<WindowInsetsAnimationCompat> list) {
            Callback r = r(view);
            if (r != null) {
                windowInsetsCompat = r.d(windowInsetsCompat, list);
                if (r.a() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    o(viewGroup.getChildAt(i2), windowInsetsCompat, list);
                }
            }
        }

        static void p(View view, WindowInsetsAnimationCompat windowInsetsAnimationCompat, BoundsCompat boundsCompat) {
            Callback r = r(view);
            if (r != null) {
                r.e(windowInsetsAnimationCompat, boundsCompat);
                if (r.a() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    p(viewGroup.getChildAt(i2), windowInsetsAnimationCompat, boundsCompat);
                }
            }
        }

        @NonNull
        static WindowInsets q(@NonNull View view, @NonNull WindowInsets windowInsets) {
            return view.getTag(R.id.j0) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
        }

        @Nullable
        static Callback r(View view) {
            Object tag = view.getTag(R.id.r0);
            if (tag instanceof Impl21OnApplyWindowInsetsListener) {
                return ((Impl21OnApplyWindowInsetsListener) tag).f6552a;
            }
            return null;
        }

        @SuppressLint({"WrongConstant"})
        static WindowInsetsCompat s(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, float f2, int i2) {
            Insets z;
            WindowInsetsCompat.Builder builder = new WindowInsetsCompat.Builder(windowInsetsCompat);
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i2 & i3) == 0) {
                    z = windowInsetsCompat.f(i3);
                } else {
                    Insets f3 = windowInsetsCompat.f(i3);
                    Insets f4 = windowInsetsCompat2.f(i3);
                    float f5 = 1.0f - f2;
                    z = WindowInsetsCompat.z(f3, (int) (((double) (((float) (f3.f5824a - f4.f5824a)) * f5)) + 0.5d), (int) (((double) (((float) (f3.f5825b - f4.f5825b)) * f5)) + 0.5d), (int) (((double) (((float) (f3.f5826c - f4.f5826c)) * f5)) + 0.5d), (int) (((double) (((float) (f3.f5827d - f4.f5827d)) * f5)) + 0.5d));
                }
                builder.c(i3, z);
            }
            return builder.a();
        }

        static void t(@NonNull View view, @Nullable Callback callback) {
            Object tag = view.getTag(R.id.j0);
            if (callback == null) {
                view.setTag(R.id.r0, (Object) null);
                if (tag == null) {
                    view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) null);
                    return;
                }
                return;
            }
            View.OnApplyWindowInsetsListener l2 = l(view, callback);
            view.setTag(R.id.r0, l2);
            if (tag == null) {
                view.setOnApplyWindowInsetsListener(l2);
            }
        }
    }

    @RequiresApi(30)
    private static class Impl30 extends Impl {
        @NonNull

        /* renamed from: f  reason: collision with root package name */
        private final WindowInsetsAnimation f6554f;

        @RequiresApi(30)
        private static class ProxyCallback extends WindowInsetsAnimation.Callback {

            /* renamed from: a  reason: collision with root package name */
            private final Callback f6555a;

            /* renamed from: b  reason: collision with root package name */
            private List<WindowInsetsAnimationCompat> f6556b;

            /* renamed from: c  reason: collision with root package name */
            private ArrayList<WindowInsetsAnimationCompat> f6557c;

            /* renamed from: d  reason: collision with root package name */
            private final HashMap<WindowInsetsAnimation, WindowInsetsAnimationCompat> f6558d = new HashMap<>();

            ProxyCallback(@NonNull Callback callback) {
                super(callback.a());
                this.f6555a = callback;
            }

            @NonNull
            private WindowInsetsAnimationCompat a(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
                WindowInsetsAnimationCompat windowInsetsAnimationCompat = this.f6558d.get(windowInsetsAnimation);
                if (windowInsetsAnimationCompat != null) {
                    return windowInsetsAnimationCompat;
                }
                WindowInsetsAnimationCompat j2 = WindowInsetsAnimationCompat.j(windowInsetsAnimation);
                this.f6558d.put(windowInsetsAnimation, j2);
                return j2;
            }

            public void onEnd(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
                this.f6555a.b(a(windowInsetsAnimation));
                this.f6558d.remove(windowInsetsAnimation);
            }

            public void onPrepare(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
                this.f6555a.c(a(windowInsetsAnimation));
            }

            @NonNull
            public WindowInsets onProgress(@NonNull WindowInsets windowInsets, @NonNull List<WindowInsetsAnimation> list) {
                ArrayList<WindowInsetsAnimationCompat> arrayList = this.f6557c;
                if (arrayList == null) {
                    ArrayList<WindowInsetsAnimationCompat> arrayList2 = new ArrayList<>(list.size());
                    this.f6557c = arrayList2;
                    this.f6556b = Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    WindowInsetsAnimation a2 = C0090b0.a(list.get(size));
                    WindowInsetsAnimationCompat a3 = a(a2);
                    a3.i(a2.getFraction());
                    this.f6557c.add(a3);
                }
                return this.f6555a.d(WindowInsetsCompat.K(windowInsets), this.f6556b).J();
            }

            @NonNull
            public WindowInsetsAnimation.Bounds onStart(@NonNull WindowInsetsAnimation windowInsetsAnimation, @NonNull WindowInsetsAnimation.Bounds bounds) {
                return this.f6555a.e(a(windowInsetsAnimation), BoundsCompat.e(bounds)).d();
            }
        }

        Impl30(int i2, Interpolator interpolator, long j2) {
            this(C0063a0.a(i2, interpolator, j2));
        }

        @NonNull
        public static WindowInsetsAnimation.Bounds i(@NonNull BoundsCompat boundsCompat) {
            Q.a();
            return P.a(boundsCompat.a().h(), boundsCompat.b().h());
        }

        @NonNull
        public static Insets j(@NonNull WindowInsetsAnimation.Bounds bounds) {
            return Insets.g(bounds.getUpperBound());
        }

        @NonNull
        public static Insets k(@NonNull WindowInsetsAnimation.Bounds bounds) {
            return Insets.g(bounds.getLowerBound());
        }

        public static void l(@NonNull View view, @Nullable Callback callback) {
            view.setWindowInsetsAnimationCallback(callback != null ? new ProxyCallback(callback) : null);
        }

        public long b() {
            return this.f6554f.getDurationMillis();
        }

        public float c() {
            return this.f6554f.getFraction();
        }

        public float d() {
            return this.f6554f.getInterpolatedFraction();
        }

        @Nullable
        public Interpolator e() {
            return this.f6554f.getInterpolator();
        }

        public int f() {
            return this.f6554f.getTypeMask();
        }

        public void h(float f2) {
            this.f6554f.setFraction(f2);
        }

        Impl30(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
            super(0, (Interpolator) null, 0);
            this.f6554f = windowInsetsAnimation;
        }
    }

    public WindowInsetsAnimationCompat(int i2, @Nullable Interpolator interpolator, long j2) {
        this.f6536a = Build.VERSION.SDK_INT >= 30 ? new Impl30(i2, interpolator, j2) : new Impl21(i2, interpolator, j2);
    }

    static void h(@NonNull View view, @Nullable Callback callback) {
        if (Build.VERSION.SDK_INT >= 30) {
            Impl30.l(view, callback);
        } else {
            Impl21.t(view, callback);
        }
    }

    @RequiresApi(30)
    static WindowInsetsAnimationCompat j(WindowInsetsAnimation windowInsetsAnimation) {
        return new WindowInsetsAnimationCompat(windowInsetsAnimation);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float a() {
        return this.f6536a.a();
    }

    public long b() {
        return this.f6536a.b();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float c() {
        return this.f6536a.c();
    }

    public float d() {
        return this.f6536a.d();
    }

    @Nullable
    public Interpolator e() {
        return this.f6536a.e();
    }

    public int f() {
        return this.f6536a.f();
    }

    public void g(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.f6536a.g(f2);
    }

    public void i(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.f6536a.h(f2);
    }

    @RequiresApi(30)
    private WindowInsetsAnimationCompat(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
        this(0, (Interpolator) null, 0);
        if (Build.VERSION.SDK_INT >= 30) {
            this.f6536a = new Impl30(windowInsetsAnimation);
        }
    }
}
