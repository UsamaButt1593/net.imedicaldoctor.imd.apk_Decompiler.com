package androidx.core.view;

import android.view.WindowInsetsController;
import androidx.core.view.SoftwareKeyboardControllerCompat;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class F implements WindowInsetsController.OnControllableInsetsChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f6384a;

    public /* synthetic */ F(AtomicBoolean atomicBoolean) {
        this.f6384a = atomicBoolean;
    }

    public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int i2) {
        SoftwareKeyboardControllerCompat.Impl30.f(this.f6384a, windowInsetsController, i2);
    }
}
