package androidx.media3.exoplayer.drm;

import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.source.MediaSource;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@RequiresApi(18)
@UnstableApi
public final class OfflineLicenseHelper {

    /* renamed from: f  reason: collision with root package name */
    private static final Format f11348f = new Format.Builder().R(new DrmInitData(new DrmInitData.SchemeData[0])).I();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ConditionVariable f11349a = new ConditionVariable();

    /* renamed from: b  reason: collision with root package name */
    private final DefaultDrmSessionManager f11350b;

    /* renamed from: c  reason: collision with root package name */
    private final HandlerThread f11351c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f11352d;

    /* renamed from: e  reason: collision with root package name */
    private final DrmSessionEventListener.EventDispatcher f11353e;

    public OfflineLicenseHelper(DefaultDrmSessionManager defaultDrmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        this.f11350b = defaultDrmSessionManager;
        this.f11353e = eventDispatcher;
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:OfflineLicenseHelper");
        this.f11351c = handlerThread;
        handlerThread.start();
        this.f11352d = new Handler(handlerThread.getLooper());
        eventDispatcher.g(new Handler(handlerThread.getLooper()), new DrmSessionEventListener() {
            public void R(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
                OfflineLicenseHelper.this.f11349a.open();
            }

            public void c0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
                OfflineLicenseHelper.this.f11349a.open();
            }

            public /* synthetic */ void m0(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
                C0296j.g(this, i2, mediaPeriodId);
            }

            public /* synthetic */ void o0(int i2, MediaSource.MediaPeriodId mediaPeriodId, int i3) {
                C0296j.e(this, i2, mediaPeriodId, i3);
            }

            public /* synthetic */ void r0(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
                C0296j.d(this, i2, mediaPeriodId);
            }

            public void v0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
                OfflineLicenseHelper.this.f11349a.open();
            }

            public void w0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
                OfflineLicenseHelper.this.f11349a.open();
            }
        });
    }

    private DrmSession g(int i2, @Nullable byte[] bArr, Format format) throws DrmSession.DrmSessionException {
        Assertions.g(format.i3);
        SettableFuture F = SettableFuture.F();
        this.f11349a.close();
        this.f11352d.post(new M(this, i2, bArr, F, format));
        try {
            DrmSession drmSession = (DrmSession) F.get();
            this.f11349a.block();
            SettableFuture F2 = SettableFuture.F();
            this.f11352d.post(new N(this, drmSession, F2));
            try {
                if (F2.get() == null) {
                    return drmSession;
                }
                throw ((DrmSession.DrmSessionException) F2.get());
            } catch (InterruptedException | ExecutionException e2) {
                throw new IllegalStateException(e2);
            }
        } catch (InterruptedException | ExecutionException e3) {
            throw new IllegalStateException(e3);
        }
    }

    private byte[] h(int i2, @Nullable byte[] bArr, Format format) throws DrmSession.DrmSessionException {
        DrmSession g2 = g(i2, bArr, format);
        SettableFuture F = SettableFuture.F();
        this.f11352d.post(new P(this, F, g2));
        try {
            byte[] bArr2 = (byte[]) Assertions.g((byte[]) F.get());
            u();
            return bArr2;
        } catch (InterruptedException | ExecutionException e2) {
            throw new IllegalStateException(e2);
        } catch (Throwable th) {
            u();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(int i2, byte[] bArr, SettableFuture settableFuture, Format format) {
        try {
            this.f11350b.b((Looper) Assertions.g(Looper.myLooper()), PlayerId.f10613b);
            this.f11350b.k();
            this.f11350b.G(i2, bArr);
            settableFuture.B((DrmSession) Assertions.g(this.f11350b.c(this.f11353e, format)));
        } catch (Throwable th) {
            settableFuture.C(th);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(DrmSession drmSession, SettableFuture settableFuture) {
        try {
            DrmSession.DrmSessionException e2 = drmSession.e();
            if (drmSession.getState() == 1) {
                drmSession.j(this.f11353e);
                this.f11350b.a();
            }
            settableFuture.B(e2);
        } catch (Throwable th) {
            settableFuture.C(th);
            drmSession.j(this.f11353e);
            this.f11350b.a();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(SettableFuture settableFuture, DrmSession drmSession) {
        try {
            settableFuture.B(drmSession.k());
        } catch (Throwable th) {
            drmSession.j(this.f11353e);
            throw th;
        }
        drmSession.j(this.f11353e);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(SettableFuture settableFuture, DrmSession drmSession) {
        try {
            settableFuture.B((Pair) Assertions.g(WidevineUtil.b(drmSession)));
        } catch (Throwable th) {
            drmSession.j(this.f11353e);
            throw th;
        }
        drmSession.j(this.f11353e);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(SettableFuture settableFuture) {
        try {
            this.f11350b.a();
            settableFuture.B(null);
        } catch (Throwable th) {
            settableFuture.C(th);
        }
    }

    public static OfflineLicenseHelper p(String str, DataSource.Factory factory, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        return q(str, false, factory, eventDispatcher);
    }

    public static OfflineLicenseHelper q(String str, boolean z, DataSource.Factory factory, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        return r(str, z, factory, (Map<String, String>) null, eventDispatcher);
    }

    public static OfflineLicenseHelper r(String str, boolean z, DataSource.Factory factory, @Nullable Map<String, String> map, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        return new OfflineLicenseHelper(new DefaultDrmSessionManager.Builder().b(map).a(new HttpMediaDrmCallback(str, z, factory)), eventDispatcher);
    }

    private void u() {
        SettableFuture F = SettableFuture.F();
        this.f11352d.post(new O(this, F));
        try {
            F.get();
        } catch (InterruptedException | ExecutionException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public synchronized byte[] i(Format format) throws DrmSession.DrmSessionException {
        Assertions.a(format.i3 != null);
        return h(2, (byte[]) null, format);
    }

    public synchronized Pair<Long, Long> j(byte[] bArr) throws DrmSession.DrmSessionException {
        Pair<Long, Long> pair;
        Assertions.g(bArr);
        try {
            DrmSession g2 = g(1, bArr, f11348f);
            SettableFuture F = SettableFuture.F();
            this.f11352d.post(new L(this, F, g2));
            pair = (Pair) F.get();
            u();
        } catch (DrmSession.DrmSessionException e2) {
            if (e2.getCause() instanceof KeysExpiredException) {
                return Pair.create(0L, 0L);
            }
            throw e2;
        } catch (InterruptedException | ExecutionException e3) {
            throw new IllegalStateException(e3);
        } catch (Throwable th) {
            u();
            throw th;
        }
        return pair;
    }

    public void s() {
        this.f11351c.quit();
    }

    public synchronized void t(byte[] bArr) throws DrmSession.DrmSessionException {
        Assertions.g(bArr);
        h(3, bArr, f11348f);
    }

    public synchronized byte[] v(byte[] bArr) throws DrmSession.DrmSessionException {
        Assertions.g(bArr);
        return h(2, bArr, f11348f);
    }
}
