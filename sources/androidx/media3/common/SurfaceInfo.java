package androidx.media3.common;

import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public final class SurfaceInfo {

    /* renamed from: a  reason: collision with root package name */
    public final Surface f9335a;

    /* renamed from: b  reason: collision with root package name */
    public final int f9336b;

    /* renamed from: c  reason: collision with root package name */
    public final int f9337c;

    /* renamed from: d  reason: collision with root package name */
    public final int f9338d;

    public SurfaceInfo(Surface surface, int i2, int i3) {
        this(surface, i2, i3, 0);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SurfaceInfo)) {
            return false;
        }
        SurfaceInfo surfaceInfo = (SurfaceInfo) obj;
        return this.f9336b == surfaceInfo.f9336b && this.f9337c == surfaceInfo.f9337c && this.f9338d == surfaceInfo.f9338d && this.f9335a.equals(surfaceInfo.f9335a);
    }

    public int hashCode() {
        return (((((this.f9335a.hashCode() * 31) + this.f9336b) * 31) + this.f9337c) * 31) + this.f9338d;
    }

    public SurfaceInfo(Surface surface, int i2, int i3, int i4) {
        Assertions.b(i4 == 0 || i4 == 90 || i4 == 180 || i4 == 270, "orientationDegrees must be 0, 90, 180, or 270");
        this.f9335a = surface;
        this.f9336b = i2;
        this.f9337c = i3;
        this.f9338d = i4;
    }
}
