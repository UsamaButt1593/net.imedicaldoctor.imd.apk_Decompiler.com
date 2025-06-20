package androidx.media3.exoplayer;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public final class RendererConfiguration {

    /* renamed from: c  reason: collision with root package name */
    public static final RendererConfiguration f10442c = new RendererConfiguration(0, false);

    /* renamed from: a  reason: collision with root package name */
    public final int f10443a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f10444b;

    public RendererConfiguration(int i2, boolean z) {
        this.f10443a = i2;
        this.f10444b = z;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RendererConfiguration.class != obj.getClass()) {
            return false;
        }
        RendererConfiguration rendererConfiguration = (RendererConfiguration) obj;
        return this.f10443a == rendererConfiguration.f10443a && this.f10444b == rendererConfiguration.f10444b;
    }

    public int hashCode() {
        return (this.f10443a << 1) + (this.f10444b ? 1 : 0);
    }

    public RendererConfiguration(boolean z) {
        this.f10443a = 0;
        this.f10444b = z;
    }
}
