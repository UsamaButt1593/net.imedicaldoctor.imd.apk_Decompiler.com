package androidx.media3.exoplayer.drm;

import android.annotation.SuppressLint;
import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DefaultDrmSession;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

@RequiresApi(18)
@UnstableApi
public class DefaultDrmSessionManager implements DrmSessionManager {
    public static final String A = "PRCustomData";
    public static final int B = 0;
    public static final int C = 1;
    public static final int D = 2;
    public static final int E = 3;
    public static final int F = 3;
    public static final long G = 300000;
    private static final String H = "DefaultDrmSessionMgr";

    /* renamed from: c  reason: collision with root package name */
    private final UUID f11254c;

    /* renamed from: d  reason: collision with root package name */
    private final ExoMediaDrm.Provider f11255d;

    /* renamed from: e  reason: collision with root package name */
    private final MediaDrmCallback f11256e;

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<String, String> f11257f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f11258g;

    /* renamed from: h  reason: collision with root package name */
    private final int[] f11259h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f11260i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final ProvisioningManagerImpl f11261j;

    /* renamed from: k  reason: collision with root package name */
    private final LoadErrorHandlingPolicy f11262k;

    /* renamed from: l  reason: collision with root package name */
    private final ReferenceCountListenerImpl f11263l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final long f11264m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final List<DefaultDrmSession> f11265n;
    /* access modifiers changed from: private */
    public final Set<PreacquiredSessionReference> o;
    /* access modifiers changed from: private */
    public final Set<DefaultDrmSession> p;
    /* access modifiers changed from: private */
    public int q;
    @Nullable
    private ExoMediaDrm r;
    /* access modifiers changed from: private */
    @Nullable
    public DefaultDrmSession s;
    /* access modifiers changed from: private */
    @Nullable
    public DefaultDrmSession t;
    /* access modifiers changed from: private */
    public Looper u;
    /* access modifiers changed from: private */
    public Handler v;
    private int w;
    @Nullable
    private byte[] x;
    private PlayerId y;
    @Nullable
    volatile MediaDrmHandler z;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final HashMap<String, String> f11266a = new HashMap<>();

        /* renamed from: b  reason: collision with root package name */
        private UUID f11267b = C.k2;

        /* renamed from: c  reason: collision with root package name */
        private ExoMediaDrm.Provider f11268c = FrameworkMediaDrm.f11335k;

        /* renamed from: d  reason: collision with root package name */
        private boolean f11269d;

        /* renamed from: e  reason: collision with root package name */
        private int[] f11270e = new int[0];

        /* renamed from: f  reason: collision with root package name */
        private boolean f11271f = true;

        /* renamed from: g  reason: collision with root package name */
        private LoadErrorHandlingPolicy f11272g = new DefaultLoadErrorHandlingPolicy();

        /* renamed from: h  reason: collision with root package name */
        private long f11273h = 300000;

        public DefaultDrmSessionManager a(MediaDrmCallback mediaDrmCallback) {
            return new DefaultDrmSessionManager(this.f11267b, this.f11268c, mediaDrmCallback, this.f11266a, this.f11269d, this.f11270e, this.f11271f, this.f11272g, this.f11273h);
        }

        @CanIgnoreReturnValue
        public Builder b(@Nullable Map<String, String> map) {
            this.f11266a.clear();
            if (map != null) {
                this.f11266a.putAll(map);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder c(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f11272g = (LoadErrorHandlingPolicy) Assertions.g(loadErrorHandlingPolicy);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder d(boolean z) {
            this.f11269d = z;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder e(boolean z) {
            this.f11271f = z;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder f(long j2) {
            Assertions.a(j2 > 0 || j2 == C.f9084b);
            this.f11273h = j2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder g(int... iArr) {
            for (int i2 : iArr) {
                boolean z = true;
                if (!(i2 == 2 || i2 == 1)) {
                    z = false;
                }
                Assertions.a(z);
            }
            this.f11270e = (int[]) iArr.clone();
            return this;
        }

        @CanIgnoreReturnValue
        public Builder h(UUID uuid, ExoMediaDrm.Provider provider) {
            this.f11267b = (UUID) Assertions.g(uuid);
            this.f11268c = (ExoMediaDrm.Provider) Assertions.g(provider);
            return this;
        }
    }

    private class MediaDrmEventListener implements ExoMediaDrm.OnEventListener {
        private MediaDrmEventListener() {
        }

        public void a(ExoMediaDrm exoMediaDrm, @Nullable byte[] bArr, int i2, int i3, @Nullable byte[] bArr2) {
            ((MediaDrmHandler) Assertions.g(DefaultDrmSessionManager.this.z)).obtainMessage(i2, bArr).sendToTarget();
        }
    }

    @SuppressLint({"HandlerLeak"})
    private class MediaDrmHandler extends Handler {
        public MediaDrmHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr != null) {
                for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.f11265n) {
                    if (defaultDrmSession.u(bArr)) {
                        defaultDrmSession.C(message.what);
                        return;
                    }
                }
            }
        }
    }

    public static final class MissingSchemeDataException extends Exception {
        private MissingSchemeDataException(UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    private class PreacquiredSessionReference implements DrmSessionManager.DrmSessionReference {
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final DrmSessionEventListener.EventDispatcher f11276b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private DrmSession f11277c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f11278d;

        public PreacquiredSessionReference(@Nullable DrmSessionEventListener.EventDispatcher eventDispatcher) {
            this.f11276b = eventDispatcher;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(Format format) {
            if (DefaultDrmSessionManager.this.q != 0 && !this.f11278d) {
                DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
                this.f11277c = defaultDrmSessionManager.u((Looper) Assertions.g(defaultDrmSessionManager.u), this.f11276b, format, false);
                DefaultDrmSessionManager.this.o.add(this);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f() {
            if (!this.f11278d) {
                DrmSession drmSession = this.f11277c;
                if (drmSession != null) {
                    drmSession.j(this.f11276b);
                }
                DefaultDrmSessionManager.this.o.remove(this);
                this.f11278d = true;
            }
        }

        public void a() {
            Util.T1((Handler) Assertions.g(DefaultDrmSessionManager.this.v), new C0293g(this));
        }

        public void d(Format format) {
            ((Handler) Assertions.g(DefaultDrmSessionManager.this.v)).post(new C0292f(this, format));
        }
    }

    private class ProvisioningManagerImpl implements DefaultDrmSession.ProvisioningManager {

        /* renamed from: a  reason: collision with root package name */
        private final Set<DefaultDrmSession> f11280a = new HashSet();
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private DefaultDrmSession f11281b;

        public ProvisioningManagerImpl() {
        }

        public void a(Exception exc, boolean z) {
            this.f11281b = null;
            ImmutableList<DefaultDrmSession> B = ImmutableList.B(this.f11280a);
            this.f11280a.clear();
            UnmodifiableIterator<DefaultDrmSession> k2 = B.iterator();
            while (k2.hasNext()) {
                k2.next().E(exc, z);
            }
        }

        public void b() {
            this.f11281b = null;
            ImmutableList<DefaultDrmSession> B = ImmutableList.B(this.f11280a);
            this.f11280a.clear();
            UnmodifiableIterator<DefaultDrmSession> k2 = B.iterator();
            while (k2.hasNext()) {
                k2.next().D();
            }
        }

        public void c(DefaultDrmSession defaultDrmSession) {
            this.f11280a.add(defaultDrmSession);
            if (this.f11281b == null) {
                this.f11281b = defaultDrmSession;
                defaultDrmSession.I();
            }
        }

        public void d(DefaultDrmSession defaultDrmSession) {
            this.f11280a.remove(defaultDrmSession);
            if (this.f11281b == defaultDrmSession) {
                this.f11281b = null;
                if (!this.f11280a.isEmpty()) {
                    DefaultDrmSession next = this.f11280a.iterator().next();
                    this.f11281b = next;
                    next.I();
                }
            }
        }
    }

    private class ReferenceCountListenerImpl implements DefaultDrmSession.ReferenceCountListener {
        private ReferenceCountListenerImpl() {
        }

        public void a(DefaultDrmSession defaultDrmSession, int i2) {
            if (DefaultDrmSessionManager.this.f11264m != C.f9084b) {
                DefaultDrmSessionManager.this.p.remove(defaultDrmSession);
                ((Handler) Assertions.g(DefaultDrmSessionManager.this.v)).removeCallbacksAndMessages(defaultDrmSession);
            }
        }

        public void b(DefaultDrmSession defaultDrmSession, int i2) {
            if (i2 == 1 && DefaultDrmSessionManager.this.q > 0 && DefaultDrmSessionManager.this.f11264m != C.f9084b) {
                DefaultDrmSessionManager.this.p.add(defaultDrmSession);
                ((Handler) Assertions.g(DefaultDrmSessionManager.this.v)).postAtTime(new C0294h(defaultDrmSession), defaultDrmSession, SystemClock.uptimeMillis() + DefaultDrmSessionManager.this.f11264m);
            } else if (i2 == 0) {
                DefaultDrmSessionManager.this.f11265n.remove(defaultDrmSession);
                if (DefaultDrmSessionManager.this.s == defaultDrmSession) {
                    DefaultDrmSession unused = DefaultDrmSessionManager.this.s = null;
                }
                if (DefaultDrmSessionManager.this.t == defaultDrmSession) {
                    DefaultDrmSession unused2 = DefaultDrmSessionManager.this.t = null;
                }
                DefaultDrmSessionManager.this.f11261j.d(defaultDrmSession);
                if (DefaultDrmSessionManager.this.f11264m != C.f9084b) {
                    ((Handler) Assertions.g(DefaultDrmSessionManager.this.v)).removeCallbacksAndMessages(defaultDrmSession);
                    DefaultDrmSessionManager.this.p.remove(defaultDrmSession);
                }
            }
            DefaultDrmSessionManager.this.D();
        }
    }

    private DefaultDrmSessionManager(UUID uuid, ExoMediaDrm.Provider provider, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, boolean z2, int[] iArr, boolean z3, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j2) {
        Assertions.g(uuid);
        Assertions.b(!C.i2.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f11254c = uuid;
        this.f11255d = provider;
        this.f11256e = mediaDrmCallback;
        this.f11257f = hashMap;
        this.f11258g = z2;
        this.f11259h = iArr;
        this.f11260i = z3;
        this.f11262k = loadErrorHandlingPolicy;
        this.f11261j = new ProvisioningManagerImpl();
        this.f11263l = new ReferenceCountListenerImpl();
        this.w = 0;
        this.f11265n = new ArrayList();
        this.o = Sets.z();
        this.p = Sets.z();
        this.f11264m = j2;
    }

    @EnsuresNonNull({"this.playbackLooper", "this.playbackHandler"})
    private synchronized void A(Looper looper) {
        try {
            Looper looper2 = this.u;
            if (looper2 == null) {
                this.u = looper;
                this.v = new Handler(looper);
            } else {
                Assertions.i(looper2 == looper);
                Assertions.g(this.v);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    @Nullable
    private DrmSession B(int i2, boolean z2) {
        ExoMediaDrm exoMediaDrm = (ExoMediaDrm) Assertions.g(this.r);
        if ((exoMediaDrm.w() == 2 && FrameworkCryptoConfig.f11330d) || Util.x1(this.f11259h, i2) == -1 || exoMediaDrm.w() == 1) {
            return null;
        }
        DefaultDrmSession defaultDrmSession = this.s;
        if (defaultDrmSession == null) {
            DefaultDrmSession y2 = y(ImmutableList.I(), true, (DrmSessionEventListener.EventDispatcher) null, z2);
            this.f11265n.add(y2);
            this.s = y2;
        } else {
            defaultDrmSession.f((DrmSessionEventListener.EventDispatcher) null);
        }
        return this.s;
    }

    private void C(Looper looper) {
        if (this.z == null) {
            this.z = new MediaDrmHandler(looper);
        }
    }

    /* access modifiers changed from: private */
    public void D() {
        if (this.r != null && this.q == 0 && this.f11265n.isEmpty() && this.o.isEmpty()) {
            ((ExoMediaDrm) Assertions.g(this.r)).a();
            this.r = null;
        }
    }

    private void E() {
        UnmodifiableIterator<DefaultDrmSession> k2 = ImmutableSet.C(this.p).iterator();
        while (k2.hasNext()) {
            k2.next().j((DrmSessionEventListener.EventDispatcher) null);
        }
    }

    private void F() {
        UnmodifiableIterator<PreacquiredSessionReference> k2 = ImmutableSet.C(this.o).iterator();
        while (k2.hasNext()) {
            k2.next().a();
        }
    }

    private void H(DrmSession drmSession, @Nullable DrmSessionEventListener.EventDispatcher eventDispatcher) {
        drmSession.j(eventDispatcher);
        if (this.f11264m != C.f9084b) {
            drmSession.j((DrmSessionEventListener.EventDispatcher) null);
        }
    }

    private void I(boolean z2) {
        if (z2 && this.u == null) {
            Log.o(H, "DefaultDrmSessionManager accessed before setPlayer(), possibly on the wrong thread.", new IllegalStateException());
        } else if (Thread.currentThread() != ((Looper) Assertions.g(this.u)).getThread()) {
            Log.o(H, "DefaultDrmSessionManager accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + this.u.getThread().getName(), new IllegalStateException());
        }
    }

    /* access modifiers changed from: private */
    @Nullable
    public DrmSession u(Looper looper, @Nullable DrmSessionEventListener.EventDispatcher eventDispatcher, Format format, boolean z2) {
        List<DrmInitData.SchemeData> list;
        C(looper);
        DrmInitData drmInitData = format.i3;
        if (drmInitData == null) {
            return B(MimeTypes.l(format.f3), z2);
        }
        DefaultDrmSession defaultDrmSession = null;
        if (this.x == null) {
            list = z((DrmInitData) Assertions.g(drmInitData), this.f11254c, false);
            if (list.isEmpty()) {
                MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException(this.f11254c);
                Log.e(H, "DRM error", missingSchemeDataException);
                if (eventDispatcher != null) {
                    eventDispatcher.l(missingSchemeDataException);
                }
                return new ErrorStateDrmSession(new DrmSession.DrmSessionException(missingSchemeDataException, PlaybackException.z3));
            }
        } else {
            list = null;
        }
        if (this.f11258g) {
            Iterator<DefaultDrmSession> it2 = this.f11265n.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                DefaultDrmSession next = it2.next();
                if (Util.g(next.f11237f, list)) {
                    defaultDrmSession = next;
                    break;
                }
            }
        } else {
            defaultDrmSession = this.t;
        }
        if (defaultDrmSession == null) {
            defaultDrmSession = y(list, false, eventDispatcher, z2);
            if (!this.f11258g) {
                this.t = defaultDrmSession;
            }
            this.f11265n.add(defaultDrmSession);
        } else {
            defaultDrmSession.f(eventDispatcher);
        }
        return defaultDrmSession;
    }

    private static boolean v(DrmSession drmSession) {
        if (drmSession.getState() != 1) {
            return false;
        }
        Throwable cause = ((DrmSession.DrmSessionException) Assertions.g(drmSession.e())).getCause();
        return Util.f9646a < 19 || (cause instanceof ResourceBusyException) || DrmUtil.c(cause);
    }

    private boolean w(DrmInitData drmInitData) {
        if (this.x != null) {
            return true;
        }
        if (z(drmInitData, this.f11254c, true).isEmpty()) {
            if (drmInitData.Z != 1 || !drmInitData.g(0).d(C.i2)) {
                return false;
            }
            Log.n(H, "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.f11254c);
        }
        String str = drmInitData.Y;
        if (str == null || C.d2.equals(str)) {
            return true;
        }
        return C.g2.equals(str) ? Util.f9646a >= 25 : !C.e2.equals(str) && !C.f2.equals(str);
    }

    private DefaultDrmSession x(@Nullable List<DrmInitData.SchemeData> list, boolean z2, @Nullable DrmSessionEventListener.EventDispatcher eventDispatcher) {
        Assertions.g(this.r);
        List<DrmInitData.SchemeData> list2 = list;
        DefaultDrmSession defaultDrmSession = new DefaultDrmSession(this.f11254c, this.r, this.f11261j, this.f11263l, list2, this.w, this.f11260i | z2, z2, this.x, this.f11257f, this.f11256e, (Looper) Assertions.g(this.u), this.f11262k, (PlayerId) Assertions.g(this.y));
        defaultDrmSession.f(eventDispatcher);
        if (this.f11264m != C.f9084b) {
            defaultDrmSession.f((DrmSessionEventListener.EventDispatcher) null);
        }
        return defaultDrmSession;
    }

    private DefaultDrmSession y(@Nullable List<DrmInitData.SchemeData> list, boolean z2, @Nullable DrmSessionEventListener.EventDispatcher eventDispatcher, boolean z3) {
        DefaultDrmSession x2 = x(list, z2, eventDispatcher);
        if (v(x2) && !this.p.isEmpty()) {
            E();
            H(x2, eventDispatcher);
            x2 = x(list, z2, eventDispatcher);
        }
        if (!v(x2) || !z3 || this.o.isEmpty()) {
            return x2;
        }
        F();
        if (!this.p.isEmpty()) {
            E();
        }
        H(x2, eventDispatcher);
        return x(list, z2, eventDispatcher);
    }

    private static List<DrmInitData.SchemeData> z(DrmInitData drmInitData, UUID uuid, boolean z2) {
        ArrayList arrayList = new ArrayList(drmInitData.Z);
        for (int i2 = 0; i2 < drmInitData.Z; i2++) {
            DrmInitData.SchemeData g2 = drmInitData.g(i2);
            if ((g2.d(uuid) || (C.j2.equals(uuid) && g2.d(C.i2))) && (g2.X2 != null || z2)) {
                arrayList.add(g2);
            }
        }
        return arrayList;
    }

    public void G(int i2, @Nullable byte[] bArr) {
        Assertions.i(this.f11265n.isEmpty());
        if (i2 == 1 || i2 == 3) {
            Assertions.g(bArr);
        }
        this.w = i2;
        this.x = bArr;
    }

    public final void a() {
        I(true);
        int i2 = this.q - 1;
        this.q = i2;
        if (i2 == 0) {
            if (this.f11264m != C.f9084b) {
                ArrayList arrayList = new ArrayList(this.f11265n);
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    ((DefaultDrmSession) arrayList.get(i3)).j((DrmSessionEventListener.EventDispatcher) null);
                }
            }
            F();
            D();
        }
    }

    public void b(Looper looper, PlayerId playerId) {
        A(looper);
        this.y = playerId;
    }

    @Nullable
    public DrmSession c(@Nullable DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
        boolean z2 = false;
        I(false);
        if (this.q > 0) {
            z2 = true;
        }
        Assertions.i(z2);
        Assertions.k(this.u);
        return u(this.u, eventDispatcher, format, true);
    }

    public int d(Format format) {
        I(false);
        int w2 = ((ExoMediaDrm) Assertions.g(this.r)).w();
        DrmInitData drmInitData = format.i3;
        if (drmInitData == null) {
            if (Util.x1(this.f11259h, MimeTypes.l(format.f3)) != -1) {
                return w2;
            }
            return 0;
        } else if (w(drmInitData)) {
            return w2;
        } else {
            return 1;
        }
    }

    public DrmSessionManager.DrmSessionReference e(@Nullable DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
        Assertions.i(this.q > 0);
        Assertions.k(this.u);
        PreacquiredSessionReference preacquiredSessionReference = new PreacquiredSessionReference(eventDispatcher);
        preacquiredSessionReference.d(format);
        return preacquiredSessionReference;
    }

    public final void k() {
        I(true);
        int i2 = this.q;
        this.q = i2 + 1;
        if (i2 == 0) {
            if (this.r == null) {
                ExoMediaDrm a2 = this.f11255d.a(this.f11254c);
                this.r = a2;
                a2.r(new MediaDrmEventListener());
            } else if (this.f11264m != C.f9084b) {
                for (int i3 = 0; i3 < this.f11265n.size(); i3++) {
                    this.f11265n.get(i3).f((DrmSessionEventListener.EventDispatcher) null);
                }
            }
        }
    }
}
