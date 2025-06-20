package androidx.media3.exoplayer.drm;

import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;

@UnstableApi
public interface DrmSessionManager {

    /* renamed from: a  reason: collision with root package name */
    public static final DrmSessionManager f11299a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public static final DrmSessionManager f11300b;

    public interface DrmSessionReference {

        /* renamed from: a  reason: collision with root package name */
        public static final DrmSessionReference f11301a = new r();

        void a();
    }

    static {
        AnonymousClass1 r0 = new DrmSessionManager() {
            public /* synthetic */ void a() {
                q.c(this);
            }

            public void b(Looper looper, PlayerId playerId) {
            }

            @Nullable
            public DrmSession c(@Nullable DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
                if (format.i3 == null) {
                    return null;
                }
                return new ErrorStateDrmSession(new DrmSession.DrmSessionException(new UnsupportedDrmException(1), PlaybackException.x3));
            }

            public int d(Format format) {
                return format.i3 != null ? 1 : 0;
            }

            public /* synthetic */ DrmSessionReference e(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
                return q.a(this, eventDispatcher, format);
            }

            public /* synthetic */ void k() {
                q.b(this);
            }
        };
        f11299a = r0;
        f11300b = r0;
    }

    void a();

    void b(Looper looper, PlayerId playerId);

    @Nullable
    DrmSession c(@Nullable DrmSessionEventListener.EventDispatcher eventDispatcher, Format format);

    int d(Format format);

    DrmSessionReference e(@Nullable DrmSessionEventListener.EventDispatcher eventDispatcher, Format format);

    void k();
}
