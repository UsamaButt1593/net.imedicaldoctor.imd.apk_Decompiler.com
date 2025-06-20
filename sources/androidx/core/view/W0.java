package androidx.core.view;

import android.view.WindowInsetsController;
import androidx.core.view.WindowInsetsControllerCompat;

public final /* synthetic */ class W0 implements WindowInsetsController.OnControllableInsetsChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WindowInsetsControllerCompat.Impl30 f6529a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WindowInsetsControllerCompat.OnControllableInsetsChangedListener f6530b;

    public /* synthetic */ W0(WindowInsetsControllerCompat.Impl30 impl30, WindowInsetsControllerCompat.OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.f6529a = impl30;
        this.f6530b = onControllableInsetsChangedListener;
    }

    public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int i2) {
        this.f6529a.m(this.f6530b, windowInsetsController, i2);
    }
}
