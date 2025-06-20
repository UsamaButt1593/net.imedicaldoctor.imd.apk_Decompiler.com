package androidx.media3.common;

import android.view.SurfaceView;
import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public interface DebugViewProvider {

    /* renamed from: a  reason: collision with root package name */
    public static final DebugViewProvider f9103a = new C0151i();

    @Nullable
    SurfaceView a(int i2, int i3);
}
