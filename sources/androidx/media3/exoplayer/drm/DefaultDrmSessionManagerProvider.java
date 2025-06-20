package androidx.media3.exoplayer.drm;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DefaultHttpDataSource;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Ints;
import java.util.Map;

@UnstableApi
public final class DefaultDrmSessionManagerProvider implements DrmSessionManagerProvider {

    /* renamed from: a  reason: collision with root package name */
    private final Object f11284a = new Object();
    @GuardedBy("lock")

    /* renamed from: b  reason: collision with root package name */
    private MediaItem.DrmConfiguration f11285b;
    @GuardedBy("lock")

    /* renamed from: c  reason: collision with root package name */
    private DrmSessionManager f11286c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private DataSource.Factory f11287d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private String f11288e;

    @RequiresApi(18)
    private DrmSessionManager b(MediaItem.DrmConfiguration drmConfiguration) {
        DataSource.Factory factory = this.f11287d;
        if (factory == null) {
            factory = new DefaultHttpDataSource.Factory().k(this.f11288e);
        }
        Uri uri = drmConfiguration.Y;
        HttpMediaDrmCallback httpMediaDrmCallback = new HttpMediaDrmCallback(uri == null ? null : uri.toString(), drmConfiguration.a3, factory);
        UnmodifiableIterator<Map.Entry<String, String>> k2 = drmConfiguration.X2.entrySet().iterator();
        while (k2.hasNext()) {
            Map.Entry next = k2.next();
            httpMediaDrmCallback.g((String) next.getKey(), (String) next.getValue());
        }
        DefaultDrmSessionManager a2 = new DefaultDrmSessionManager.Builder().h(drmConfiguration.s, FrameworkMediaDrm.f11335k).d(drmConfiguration.Y2).e(drmConfiguration.Z2).g(Ints.D(drmConfiguration.c3)).a(httpMediaDrmCallback);
        a2.G(0, drmConfiguration.e());
        return a2;
    }

    public DrmSessionManager a(MediaItem mediaItem) {
        DrmSessionManager drmSessionManager;
        Assertions.g(mediaItem.X);
        MediaItem.DrmConfiguration drmConfiguration = mediaItem.X.Y;
        if (drmConfiguration == null || Util.f9646a < 18) {
            return DrmSessionManager.f11299a;
        }
        synchronized (this.f11284a) {
            try {
                if (!Util.g(drmConfiguration, this.f11285b)) {
                    this.f11285b = drmConfiguration;
                    this.f11286c = b(drmConfiguration);
                }
                drmSessionManager = (DrmSessionManager) Assertions.g(this.f11286c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return drmSessionManager;
    }

    public void c(@Nullable DataSource.Factory factory) {
        this.f11287d = factory;
    }

    @Deprecated
    public void d(@Nullable String str) {
        this.f11288e = str;
    }
}
