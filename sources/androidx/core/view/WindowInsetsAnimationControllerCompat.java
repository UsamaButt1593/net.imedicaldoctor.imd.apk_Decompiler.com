package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.WindowInsetsAnimationController;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;

public final class WindowInsetsAnimationControllerCompat {

    /* renamed from: a  reason: collision with root package name */
    private final Impl f6559a;

    private static class Impl {
        Impl() {
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z) {
        }

        public float b() {
            return 0.0f;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float c() {
            return 0.0f;
        }

        @NonNull
        public Insets d() {
            return Insets.f5823e;
        }

        @NonNull
        public Insets e() {
            return Insets.f5823e;
        }

        @NonNull
        public Insets f() {
            return Insets.f5823e;
        }

        public int g() {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public boolean h() {
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean i() {
            return false;
        }

        public void j(@Nullable Insets insets, @FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        }
    }

    @RequiresApi(30)
    private static class Impl30 extends Impl {

        /* renamed from: a  reason: collision with root package name */
        private final WindowInsetsAnimationController f6560a;

        Impl30(@NonNull WindowInsetsAnimationController windowInsetsAnimationController) {
            this.f6560a = windowInsetsAnimationController;
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z) {
            this.f6560a.finish(z);
        }

        public float b() {
            return this.f6560a.getCurrentAlpha();
        }

        public float c() {
            return this.f6560a.getCurrentFraction();
        }

        @NonNull
        public Insets d() {
            return Insets.g(this.f6560a.getCurrentInsets());
        }

        @NonNull
        public Insets e() {
            return Insets.g(this.f6560a.getHiddenStateInsets());
        }

        @NonNull
        public Insets f() {
            return Insets.g(this.f6560a.getShownStateInsets());
        }

        @SuppressLint({"WrongConstant"})
        public int g() {
            return this.f6560a.getTypes();
        }

        /* access modifiers changed from: package-private */
        public boolean h() {
            return this.f6560a.isCancelled();
        }

        /* access modifiers changed from: package-private */
        public boolean i() {
            return this.f6560a.isFinished();
        }

        public void j(@Nullable Insets insets, float f2, float f3) {
            this.f6560a.setInsetsAndAlpha(insets == null ? null : insets.h(), f2, f3);
        }
    }

    @RequiresApi(30)
    WindowInsetsAnimationControllerCompat(@NonNull WindowInsetsAnimationController windowInsetsAnimationController) {
        this.f6559a = new Impl30(windowInsetsAnimationController);
    }

    public void a(boolean z) {
        this.f6559a.a(z);
    }

    public float b() {
        return this.f6559a.b();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float c() {
        return this.f6559a.c();
    }

    @NonNull
    public Insets d() {
        return this.f6559a.d();
    }

    @NonNull
    public Insets e() {
        return this.f6559a.e();
    }

    @NonNull
    public Insets f() {
        return this.f6559a.f();
    }

    public int g() {
        return this.f6559a.g();
    }

    public boolean h() {
        return this.f6559a.h();
    }

    public boolean i() {
        return this.f6559a.i();
    }

    public boolean j() {
        return !i() && !h();
    }

    public void k(@Nullable Insets insets, @FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        this.f6559a.j(insets, f2, f3);
    }
}
