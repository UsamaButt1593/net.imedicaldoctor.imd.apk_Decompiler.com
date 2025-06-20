package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.concurrent.atomic.AtomicBoolean;

public final class SoftwareKeyboardControllerCompat {

    /* renamed from: a  reason: collision with root package name */
    private final Impl f6476a;

    private static class Impl {
        Impl() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
        }

        /* access modifiers changed from: package-private */
        public void b() {
        }
    }

    @RequiresApi(20)
    private static class Impl20 extends Impl {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private final View f6477a;

        Impl20(@Nullable View view) {
            this.f6477a = view;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            View view = this.f6477a;
            if (view != null) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f6477a.getWindowToken(), 0);
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            View view = this.f6477a;
            if (view != null) {
                if (view.isInEditMode() || view.onCheckIsTextEditor()) {
                    view.requestFocus();
                } else {
                    view = view.getRootView().findFocus();
                }
                if (view == null) {
                    view = this.f6477a.getRootView().findViewById(16908290);
                }
                if (view != null && view.hasWindowFocus()) {
                    view.post(new C0133y(view));
                }
            }
        }
    }

    @RequiresApi(30)
    private static class Impl30 extends Impl20 {
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private View f6478b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private WindowInsetsController f6479c;

        Impl30(@NonNull View view) {
            super(view);
            this.f6478b = view;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void f(AtomicBoolean atomicBoolean, WindowInsetsController windowInsetsController, int i2) {
            atomicBoolean.set((i2 & 8) != 0);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            View view;
            WindowInsetsController windowInsetsController = this.f6479c;
            if (windowInsetsController == null) {
                View view2 = this.f6478b;
                windowInsetsController = view2 != null ? view2.getWindowInsetsController() : null;
            }
            if (windowInsetsController != null) {
                AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                F f2 = new F(atomicBoolean);
                windowInsetsController.addOnControllableInsetsChangedListener(f2);
                if (!atomicBoolean.get() && (view = this.f6478b) != null) {
                    ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f6478b.getWindowToken(), 0);
                }
                windowInsetsController.removeOnControllableInsetsChangedListener(f2);
                windowInsetsController.hide(WindowInsets.Type.ime());
                return;
            }
            super.a();
        }

        /* access modifiers changed from: package-private */
        public void b() {
            View view = this.f6478b;
            if (view != null && Build.VERSION.SDK_INT < 33) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).isActive();
            }
            WindowInsetsController windowInsetsController = this.f6479c;
            if (windowInsetsController == null) {
                View view2 = this.f6478b;
                windowInsetsController = view2 != null ? view2.getWindowInsetsController() : null;
            }
            if (windowInsetsController != null) {
                windowInsetsController.show(WindowInsets.Type.ime());
            } else {
                super.b();
            }
        }

        Impl30(@Nullable WindowInsetsController windowInsetsController) {
            super((View) null);
            this.f6479c = windowInsetsController;
        }
    }

    public SoftwareKeyboardControllerCompat(@NonNull View view) {
        this.f6476a = Build.VERSION.SDK_INT >= 30 ? new Impl30(view) : new Impl20(view);
    }

    public void a() {
        this.f6476a.a();
    }

    public void b() {
        this.f6476a.b();
    }

    @RequiresApi(30)
    @Deprecated
    SoftwareKeyboardControllerCompat(@NonNull WindowInsetsController windowInsetsController) {
        this.f6476a = new Impl30(windowInsetsController);
    }
}
