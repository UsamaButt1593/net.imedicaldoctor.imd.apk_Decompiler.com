package androidx.core.view;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.CancellationSignal;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.collection.SimpleArrayMap;
import androidx.media3.common.C;

public final class WindowInsetsControllerCompat {
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public static final int f6604b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static final int f6605c = 1;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public static final int f6606d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static final int f6607e = 2;

    /* renamed from: a  reason: collision with root package name */
    private final Impl f6608a;

    private static class Impl {
        Impl() {
        }

        /* access modifiers changed from: package-private */
        public void a(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        /* access modifiers changed from: package-private */
        public void b(int i2, long j2, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        }

        /* access modifiers changed from: package-private */
        public int c() {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public void d(int i2) {
        }

        public boolean e() {
            return false;
        }

        public boolean f() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void g(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        public void h(boolean z) {
        }

        public void i(boolean z) {
        }

        /* access modifiers changed from: package-private */
        public void j(int i2) {
        }

        /* access modifiers changed from: package-private */
        public void k(int i2) {
        }
    }

    @RequiresApi(20)
    private static class Impl20 extends Impl {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        protected final Window f6609a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final SoftwareKeyboardControllerCompat f6610b;

        Impl20(@NonNull Window window, @NonNull SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this.f6609a = window;
            this.f6610b = softwareKeyboardControllerCompat;
        }

        private void l(int i2) {
            if (i2 == 1) {
                m(4);
            } else if (i2 == 2) {
                m(2);
            } else if (i2 == 8) {
                this.f6610b.a();
            }
        }

        private void o(int i2) {
            if (i2 == 1) {
                p(4);
                q(1024);
            } else if (i2 == 2) {
                p(2);
            } else if (i2 == 8) {
                this.f6610b.b();
            }
        }

        /* access modifiers changed from: package-private */
        public void a(OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        /* access modifiers changed from: package-private */
        public void b(int i2, long j2, Interpolator interpolator, CancellationSignal cancellationSignal, WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        }

        /* access modifiers changed from: package-private */
        public int c() {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public void d(int i2) {
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i2 & i3) != 0) {
                    l(i3);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void g(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        }

        /* access modifiers changed from: package-private */
        public void j(int i2) {
            if (i2 == 0) {
                p(6144);
            } else if (i2 == 1) {
                p(4096);
                m(2048);
            } else if (i2 == 2) {
                p(2048);
                m(4096);
            }
        }

        /* access modifiers changed from: package-private */
        public void k(int i2) {
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i2 & i3) != 0) {
                    o(i3);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void m(int i2) {
            View decorView = this.f6609a.getDecorView();
            decorView.setSystemUiVisibility(i2 | decorView.getSystemUiVisibility());
        }

        /* access modifiers changed from: protected */
        public void n(int i2) {
            this.f6609a.addFlags(i2);
        }

        /* access modifiers changed from: protected */
        public void p(int i2) {
            View decorView = this.f6609a.getDecorView();
            decorView.setSystemUiVisibility((~i2) & decorView.getSystemUiVisibility());
        }

        /* access modifiers changed from: protected */
        public void q(int i2) {
            this.f6609a.clearFlags(i2);
        }
    }

    @RequiresApi(23)
    private static class Impl23 extends Impl20 {
        Impl23(@NonNull Window window, @NonNull SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, softwareKeyboardControllerCompat);
        }

        public boolean f() {
            return (this.f6609a.getDecorView().getSystemUiVisibility() & 8192) != 0;
        }

        public void i(boolean z) {
            if (z) {
                q(67108864);
                n(Integer.MIN_VALUE);
                m(8192);
                return;
            }
            p(8192);
        }
    }

    @RequiresApi(26)
    private static class Impl26 extends Impl23 {
        Impl26(@NonNull Window window, @NonNull SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, softwareKeyboardControllerCompat);
        }

        public boolean e() {
            return (this.f6609a.getDecorView().getSystemUiVisibility() & 16) != 0;
        }

        public void h(boolean z) {
            if (z) {
                q(C.S0);
                n(Integer.MIN_VALUE);
                m(16);
                return;
            }
            p(16);
        }
    }

    @RequiresApi(30)
    private static class Impl30 extends Impl {

        /* renamed from: a  reason: collision with root package name */
        final WindowInsetsControllerCompat f6611a;

        /* renamed from: b  reason: collision with root package name */
        final WindowInsetsController f6612b;

        /* renamed from: c  reason: collision with root package name */
        final SoftwareKeyboardControllerCompat f6613c;

        /* renamed from: d  reason: collision with root package name */
        private final SimpleArrayMap<OnControllableInsetsChangedListener, WindowInsetsController.OnControllableInsetsChangedListener> f6614d;

        /* renamed from: e  reason: collision with root package name */
        protected Window f6615e;

        Impl30(@NonNull Window window, @NonNull WindowInsetsControllerCompat windowInsetsControllerCompat, @NonNull SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this(window.getInsetsController(), windowInsetsControllerCompat, softwareKeyboardControllerCompat);
            this.f6615e = window;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void m(OnControllableInsetsChangedListener onControllableInsetsChangedListener, WindowInsetsController windowInsetsController, int i2) {
            if (this.f6612b == windowInsetsController) {
                onControllableInsetsChangedListener.a(this.f6611a, i2);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
            if (!this.f6614d.containsKey(onControllableInsetsChangedListener)) {
                W0 w0 = new W0(this, onControllableInsetsChangedListener);
                this.f6614d.put(onControllableInsetsChangedListener, w0);
                this.f6612b.addOnControllableInsetsChangedListener(w0);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i2, long j2, @Nullable Interpolator interpolator, @Nullable CancellationSignal cancellationSignal, @NonNull final WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
            this.f6612b.controlWindowInsetsAnimation(i2, j2, interpolator, cancellationSignal, new WindowInsetsAnimationControlListener() {

                /* renamed from: a  reason: collision with root package name */
                private WindowInsetsAnimationControllerCompat f6616a = null;

                public void onCancelled(@Nullable WindowInsetsAnimationController windowInsetsAnimationController) {
                    windowInsetsAnimationControlListenerCompat.a(windowInsetsAnimationController == null ? null : this.f6616a);
                }

                public void onFinished(@NonNull WindowInsetsAnimationController windowInsetsAnimationController) {
                    windowInsetsAnimationControlListenerCompat.c(this.f6616a);
                }

                public void onReady(@NonNull WindowInsetsAnimationController windowInsetsAnimationController, int i2) {
                    WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = new WindowInsetsAnimationControllerCompat(windowInsetsAnimationController);
                    this.f6616a = windowInsetsAnimationControllerCompat;
                    windowInsetsAnimationControlListenerCompat.b(windowInsetsAnimationControllerCompat, i2);
                }
            });
        }

        /* access modifiers changed from: package-private */
        @SuppressLint({"WrongConstant"})
        public int c() {
            return this.f6612b.getSystemBarsBehavior();
        }

        /* access modifiers changed from: package-private */
        public void d(int i2) {
            if ((i2 & 8) != 0) {
                this.f6613c.a();
            }
            this.f6612b.hide(i2 & -9);
        }

        public boolean e() {
            this.f6612b.setSystemBarsAppearance(0, 0);
            return (this.f6612b.getSystemBarsAppearance() & 16) != 0;
        }

        public boolean f() {
            this.f6612b.setSystemBarsAppearance(0, 0);
            return (this.f6612b.getSystemBarsAppearance() & 8) != 0;
        }

        /* access modifiers changed from: package-private */
        public void g(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
            WindowInsetsController.OnControllableInsetsChangedListener a2 = U0.a(this.f6614d.remove(onControllableInsetsChangedListener));
            if (a2 != null) {
                this.f6612b.removeOnControllableInsetsChangedListener(a2);
            }
        }

        public void h(boolean z) {
            if (z) {
                if (this.f6615e != null) {
                    n(16);
                }
                this.f6612b.setSystemBarsAppearance(16, 16);
                return;
            }
            if (this.f6615e != null) {
                o(16);
            }
            this.f6612b.setSystemBarsAppearance(0, 16);
        }

        public void i(boolean z) {
            if (z) {
                if (this.f6615e != null) {
                    n(8192);
                }
                this.f6612b.setSystemBarsAppearance(8, 8);
                return;
            }
            if (this.f6615e != null) {
                o(8192);
            }
            this.f6612b.setSystemBarsAppearance(0, 8);
        }

        /* access modifiers changed from: package-private */
        public void j(int i2) {
            this.f6612b.setSystemBarsBehavior(i2);
        }

        /* access modifiers changed from: package-private */
        public void k(int i2) {
            if ((i2 & 8) != 0) {
                this.f6613c.b();
            }
            this.f6612b.show(i2 & -9);
        }

        /* access modifiers changed from: protected */
        public void n(int i2) {
            View decorView = this.f6615e.getDecorView();
            decorView.setSystemUiVisibility(i2 | decorView.getSystemUiVisibility());
        }

        /* access modifiers changed from: protected */
        public void o(int i2) {
            View decorView = this.f6615e.getDecorView();
            decorView.setSystemUiVisibility((~i2) & decorView.getSystemUiVisibility());
        }

        Impl30(@NonNull WindowInsetsController windowInsetsController, @NonNull WindowInsetsControllerCompat windowInsetsControllerCompat, @NonNull SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this.f6614d = new SimpleArrayMap<>();
            this.f6612b = windowInsetsController;
            this.f6611a = windowInsetsControllerCompat;
            this.f6613c = softwareKeyboardControllerCompat;
        }
    }

    public interface OnControllableInsetsChangedListener {
        void a(@NonNull WindowInsetsControllerCompat windowInsetsControllerCompat, int i2);
    }

    public WindowInsetsControllerCompat(@NonNull Window window, @NonNull View view) {
        SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat = new SoftwareKeyboardControllerCompat(view);
        int i2 = Build.VERSION.SDK_INT;
        this.f6608a = i2 >= 30 ? new Impl30(window, this, softwareKeyboardControllerCompat) : i2 >= 26 ? new Impl26(window, softwareKeyboardControllerCompat) : i2 >= 23 ? new Impl23(window, softwareKeyboardControllerCompat) : new Impl20(window, softwareKeyboardControllerCompat);
    }

    @RequiresApi(30)
    @NonNull
    @Deprecated
    public static WindowInsetsControllerCompat l(@NonNull WindowInsetsController windowInsetsController) {
        return new WindowInsetsControllerCompat(windowInsetsController);
    }

    public void a(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.f6608a.a(onControllableInsetsChangedListener);
    }

    public void b(int i2, long j2, @Nullable Interpolator interpolator, @Nullable CancellationSignal cancellationSignal, @NonNull WindowInsetsAnimationControlListenerCompat windowInsetsAnimationControlListenerCompat) {
        this.f6608a.b(i2, j2, interpolator, cancellationSignal, windowInsetsAnimationControlListenerCompat);
    }

    @SuppressLint({"WrongConstant"})
    public int c() {
        return this.f6608a.c();
    }

    public void d(int i2) {
        this.f6608a.d(i2);
    }

    public boolean e() {
        return this.f6608a.e();
    }

    public boolean f() {
        return this.f6608a.f();
    }

    public void g(@NonNull OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.f6608a.g(onControllableInsetsChangedListener);
    }

    public void h(boolean z) {
        this.f6608a.h(z);
    }

    public void i(boolean z) {
        this.f6608a.i(z);
    }

    public void j(int i2) {
        this.f6608a.j(i2);
    }

    public void k(int i2) {
        this.f6608a.k(i2);
    }

    @RequiresApi(30)
    @Deprecated
    private WindowInsetsControllerCompat(@NonNull WindowInsetsController windowInsetsController) {
        this.f6608a = new Impl30(windowInsetsController, this, new SoftwareKeyboardControllerCompat(windowInsetsController));
    }
}
