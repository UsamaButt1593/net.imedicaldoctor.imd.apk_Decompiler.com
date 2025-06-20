package androidx.core.app;

import android.app.SharedElementCallback;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;

public final /* synthetic */ class b implements SharedElementCallback.OnSharedElementsReadyListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SharedElementCallback.OnSharedElementsReadyListener f5624a;

    public /* synthetic */ b(SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
        this.f5624a = onSharedElementsReadyListener;
    }

    public final void a() {
        ActivityCompat.Api23Impl.a(this.f5624a);
    }
}
