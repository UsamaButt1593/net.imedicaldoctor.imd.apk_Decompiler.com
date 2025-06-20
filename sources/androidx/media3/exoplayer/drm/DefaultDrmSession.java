package androidx.media3.exoplayer.drm;

import android.annotation.SuppressLint;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.CopyOnWriteMultiset;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoConfig;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@RequiresApi(18)
class DefaultDrmSession implements DrmSession {
    private static final String E = "DefaultDrmSession";
    private static final int F = 0;
    private static final int G = 1;
    private static final int H = 60;
    @Nullable
    private byte[] A;
    private byte[] B;
    @Nullable
    private ExoMediaDrm.KeyRequest C;
    @Nullable
    private ExoMediaDrm.ProvisionRequest D;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final List<DrmInitData.SchemeData> f11237f;

    /* renamed from: g  reason: collision with root package name */
    private final ExoMediaDrm f11238g;

    /* renamed from: h  reason: collision with root package name */
    private final ProvisioningManager f11239h;

    /* renamed from: i  reason: collision with root package name */
    private final ReferenceCountListener f11240i;

    /* renamed from: j  reason: collision with root package name */
    private final int f11241j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f11242k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f11243l;

    /* renamed from: m  reason: collision with root package name */
    private final HashMap<String, String> f11244m;

    /* renamed from: n  reason: collision with root package name */
    private final CopyOnWriteMultiset<DrmSessionEventListener.EventDispatcher> f11245n;
    /* access modifiers changed from: private */
    public final LoadErrorHandlingPolicy o;
    private final PlayerId p;
    /* access modifiers changed from: private */
    public final MediaDrmCallback q;
    /* access modifiers changed from: private */
    public final UUID r;
    private final Looper s;
    /* access modifiers changed from: private */
    public final ResponseHandler t;
    private int u;
    private int v;
    @Nullable
    private HandlerThread w;
    @Nullable
    private RequestHandler x;
    @Nullable
    private CryptoConfig y;
    @Nullable
    private DrmSession.DrmSessionException z;

    public interface ProvisioningManager {
        void a(Exception exc, boolean z);

        void b();

        void c(DefaultDrmSession defaultDrmSession);
    }

    public interface ReferenceCountListener {
        void a(DefaultDrmSession defaultDrmSession, int i2);

        void b(DefaultDrmSession defaultDrmSession, int i2);
    }

    @SuppressLint({"HandlerLeak"})
    private class RequestHandler extends Handler {
        @GuardedBy("this")

        /* renamed from: a  reason: collision with root package name */
        private boolean f11246a;

        public RequestHandler(Looper looper) {
            super(looper);
        }

        private boolean a(Message message, MediaDrmCallbackException mediaDrmCallbackException) {
            MediaDrmCallbackException mediaDrmCallbackException2 = mediaDrmCallbackException;
            RequestTask requestTask = (RequestTask) message.obj;
            if (!requestTask.f11249b) {
                return false;
            }
            int i2 = requestTask.f11252e + 1;
            requestTask.f11252e = i2;
            if (i2 > DefaultDrmSession.this.o.c(3)) {
                return false;
            }
            long a2 = DefaultDrmSession.this.o.a(new LoadErrorHandlingPolicy.LoadErrorInfo(new LoadEventInfo(requestTask.f11248a, mediaDrmCallbackException2.s, mediaDrmCallbackException2.X, mediaDrmCallbackException2.Y, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - requestTask.f11250c, mediaDrmCallbackException2.Z), new MediaLoadData(3), mediaDrmCallbackException.getCause() instanceof IOException ? (IOException) mediaDrmCallbackException.getCause() : new UnexpectedDrmSessionException(mediaDrmCallbackException.getCause()), requestTask.f11252e));
            if (a2 == C.f9084b) {
                return false;
            }
            synchronized (this) {
                try {
                    if (this.f11246a) {
                        return false;
                    }
                    sendMessageDelayed(Message.obtain(message), a2);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i2, Object obj, boolean z) {
            obtainMessage(i2, new RequestTask(LoadEventInfo.a(), z, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        public synchronized void c() {
            removeCallbacksAndMessages((Object) null);
            this.f11246a = true;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: androidx.media3.exoplayer.drm.MediaDrmCallbackException} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: androidx.media3.exoplayer.drm.MediaDrmCallbackException} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: androidx.media3.exoplayer.drm.MediaDrmCallbackException} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: byte[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: byte[]} */
        /* JADX WARNING: type inference failed for: r1v2, types: [java.lang.Throwable, java.lang.Exception] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r6) {
            /*
                r5 = this;
                java.lang.Object r0 = r6.obj
                androidx.media3.exoplayer.drm.DefaultDrmSession$RequestTask r0 = (androidx.media3.exoplayer.drm.DefaultDrmSession.RequestTask) r0
                int r1 = r6.what     // Catch:{ MediaDrmCallbackException -> 0x0022, Exception -> 0x0020 }
                if (r1 == 0) goto L_0x002a
                r2 = 1
                if (r1 != r2) goto L_0x0024
                androidx.media3.exoplayer.drm.DefaultDrmSession r1 = androidx.media3.exoplayer.drm.DefaultDrmSession.this     // Catch:{ MediaDrmCallbackException -> 0x0022, Exception -> 0x0020 }
                androidx.media3.exoplayer.drm.MediaDrmCallback r1 = r1.q     // Catch:{ MediaDrmCallbackException -> 0x0022, Exception -> 0x0020 }
                androidx.media3.exoplayer.drm.DefaultDrmSession r2 = androidx.media3.exoplayer.drm.DefaultDrmSession.this     // Catch:{ MediaDrmCallbackException -> 0x0022, Exception -> 0x0020 }
                java.util.UUID r2 = r2.r     // Catch:{ MediaDrmCallbackException -> 0x0022, Exception -> 0x0020 }
                java.lang.Object r3 = r0.f11251d     // Catch:{ MediaDrmCallbackException -> 0x0022, Exception -> 0x0020 }
                androidx.media3.exoplayer.drm.ExoMediaDrm$KeyRequest r3 = (androidx.media3.exoplayer.drm.ExoMediaDrm.KeyRequest) r3     // Catch:{ MediaDrmCallbackException -> 0x0022, Exception -> 0x0020 }
                byte[] r1 = r1.b(r2, r3)     // Catch:{ MediaDrmCallbackException -> 0x0022, Exception -> 0x0020 }
                goto L_0x004e
            L_0x0020:
                r1 = move-exception
                goto L_0x003f
            L_0x0022:
                r1 = move-exception
                goto L_0x0047
            L_0x0024:
                java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ MediaDrmCallbackException -> 0x0022, Exception -> 0x0020 }
                r1.<init>()     // Catch:{ MediaDrmCallbackException -> 0x0022, Exception -> 0x0020 }
                throw r1     // Catch:{ MediaDrmCallbackException -> 0x0022, Exception -> 0x0020 }
            L_0x002a:
                androidx.media3.exoplayer.drm.DefaultDrmSession r1 = androidx.media3.exoplayer.drm.DefaultDrmSession.this     // Catch:{ MediaDrmCallbackException -> 0x0022, Exception -> 0x0020 }
                androidx.media3.exoplayer.drm.MediaDrmCallback r1 = r1.q     // Catch:{ MediaDrmCallbackException -> 0x0022, Exception -> 0x0020 }
                androidx.media3.exoplayer.drm.DefaultDrmSession r2 = androidx.media3.exoplayer.drm.DefaultDrmSession.this     // Catch:{ MediaDrmCallbackException -> 0x0022, Exception -> 0x0020 }
                java.util.UUID r2 = r2.r     // Catch:{ MediaDrmCallbackException -> 0x0022, Exception -> 0x0020 }
                java.lang.Object r3 = r0.f11251d     // Catch:{ MediaDrmCallbackException -> 0x0022, Exception -> 0x0020 }
                androidx.media3.exoplayer.drm.ExoMediaDrm$ProvisionRequest r3 = (androidx.media3.exoplayer.drm.ExoMediaDrm.ProvisionRequest) r3     // Catch:{ MediaDrmCallbackException -> 0x0022, Exception -> 0x0020 }
                byte[] r1 = r1.a(r2, r3)     // Catch:{ MediaDrmCallbackException -> 0x0022, Exception -> 0x0020 }
                goto L_0x004e
            L_0x003f:
                java.lang.String r2 = "DefaultDrmSession"
                java.lang.String r3 = "Key/provisioning request produced an unexpected exception. Not retrying."
                androidx.media3.common.util.Log.o(r2, r3, r1)
                goto L_0x004e
            L_0x0047:
                boolean r2 = r5.a(r6, r1)
                if (r2 == 0) goto L_0x004e
                return
            L_0x004e:
                androidx.media3.exoplayer.drm.DefaultDrmSession r2 = androidx.media3.exoplayer.drm.DefaultDrmSession.this
                androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy r2 = r2.o
                long r3 = r0.f11248a
                r2.b(r3)
                monitor-enter(r5)
                boolean r2 = r5.f11246a     // Catch:{ all -> 0x0074 }
                if (r2 != 0) goto L_0x0076
                androidx.media3.exoplayer.drm.DefaultDrmSession r2 = androidx.media3.exoplayer.drm.DefaultDrmSession.this     // Catch:{ all -> 0x0074 }
                androidx.media3.exoplayer.drm.DefaultDrmSession$ResponseHandler r2 = r2.t     // Catch:{ all -> 0x0074 }
                int r6 = r6.what     // Catch:{ all -> 0x0074 }
                java.lang.Object r0 = r0.f11251d     // Catch:{ all -> 0x0074 }
                android.util.Pair r0 = android.util.Pair.create(r0, r1)     // Catch:{ all -> 0x0074 }
                android.os.Message r6 = r2.obtainMessage(r6, r0)     // Catch:{ all -> 0x0074 }
                r6.sendToTarget()     // Catch:{ all -> 0x0074 }
                goto L_0x0076
            L_0x0074:
                r6 = move-exception
                goto L_0x0078
            L_0x0076:
                monitor-exit(r5)     // Catch:{ all -> 0x0074 }
                return
            L_0x0078:
                monitor-exit(r5)     // Catch:{ all -> 0x0074 }
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.drm.DefaultDrmSession.RequestHandler.handleMessage(android.os.Message):void");
        }
    }

    private static final class RequestTask {

        /* renamed from: a  reason: collision with root package name */
        public final long f11248a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f11249b;

        /* renamed from: c  reason: collision with root package name */
        public final long f11250c;

        /* renamed from: d  reason: collision with root package name */
        public final Object f11251d;

        /* renamed from: e  reason: collision with root package name */
        public int f11252e;

        public RequestTask(long j2, boolean z, long j3, Object obj) {
            this.f11248a = j2;
            this.f11249b = z;
            this.f11250c = j3;
            this.f11251d = obj;
        }
    }

    @SuppressLint({"HandlerLeak"})
    private class ResponseHandler extends Handler {
        public ResponseHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i2 = message.what;
            if (i2 == 0) {
                DefaultDrmSession.this.F(obj, obj2);
            } else if (i2 == 1) {
                DefaultDrmSession.this.z(obj, obj2);
            }
        }
    }

    public static final class UnexpectedDrmSessionException extends IOException {
        public UnexpectedDrmSessionException(@Nullable Throwable th) {
            super(th);
        }
    }

    public DefaultDrmSession(UUID uuid, ExoMediaDrm exoMediaDrm, ProvisioningManager provisioningManager, ReferenceCountListener referenceCountListener, @Nullable List<DrmInitData.SchemeData> list, int i2, boolean z2, boolean z3, @Nullable byte[] bArr, HashMap<String, String> hashMap, MediaDrmCallback mediaDrmCallback, Looper looper, LoadErrorHandlingPolicy loadErrorHandlingPolicy, PlayerId playerId) {
        List<DrmInitData.SchemeData> unmodifiableList;
        if (i2 == 1 || i2 == 3) {
            Assertions.g(bArr);
        }
        this.r = uuid;
        this.f11239h = provisioningManager;
        this.f11240i = referenceCountListener;
        this.f11238g = exoMediaDrm;
        this.f11241j = i2;
        this.f11242k = z2;
        this.f11243l = z3;
        if (bArr != null) {
            this.B = bArr;
            unmodifiableList = null;
        } else {
            unmodifiableList = Collections.unmodifiableList((List) Assertions.g(list));
        }
        this.f11237f = unmodifiableList;
        this.f11244m = hashMap;
        this.q = mediaDrmCallback;
        this.f11245n = new CopyOnWriteMultiset<>();
        this.o = loadErrorHandlingPolicy;
        this.p = playerId;
        this.u = 2;
        this.s = looper;
        this.t = new ResponseHandler(looper);
    }

    private void A(Throwable th, boolean z2) {
        if ((th instanceof NotProvisionedException) || DrmUtil.b(th)) {
            this.f11239h.c(this);
        } else {
            y(th, z2 ? 1 : 2);
        }
    }

    private void B() {
        if (this.f11241j == 0 && this.u == 4) {
            Util.o(this.A);
            s(false);
        }
    }

    /* access modifiers changed from: private */
    public void F(Object obj, Object obj2) {
        if (obj != this.D) {
            return;
        }
        if (this.u == 2 || v()) {
            this.D = null;
            if (obj2 instanceof Exception) {
                this.f11239h.a((Exception) obj2, false);
                return;
            }
            try {
                this.f11238g.s((byte[]) obj2);
                this.f11239h.b();
            } catch (Exception e2) {
                this.f11239h.a(e2, true);
            }
        }
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    private boolean G() {
        if (v()) {
            return true;
        }
        try {
            byte[] j2 = this.f11238g.j();
            this.A = j2;
            this.f11238g.u(j2, this.p);
            this.y = this.f11238g.i(this.A);
            this.u = 3;
            r(new C0287a(3));
            Assertions.g(this.A);
            return true;
        } catch (NotProvisionedException unused) {
            this.f11239h.c(this);
            return false;
        } catch (Exception | NoSuchMethodError e2) {
            if (!DrmUtil.b(e2)) {
                y(e2, 1);
                return false;
            }
            this.f11239h.c(this);
            return false;
        }
    }

    private void H(byte[] bArr, int i2, boolean z2) {
        try {
            this.C = this.f11238g.t(bArr, this.f11237f, i2, this.f11244m);
            ((RequestHandler) Util.o(this.x)).b(1, Assertions.g(this.C), z2);
        } catch (Exception | NoSuchMethodError e2) {
            A(e2, true);
        }
    }

    @RequiresNonNull({"sessionId", "offlineLicenseKeySetId"})
    private boolean J() {
        try {
            this.f11238g.m(this.A, this.B);
            return true;
        } catch (Exception | NoSuchMethodError e2) {
            y(e2, 1);
            return false;
        }
    }

    private void K() {
        if (Thread.currentThread() != this.s.getThread()) {
            Log.o(E, "DefaultDrmSession accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + this.s.getThread().getName(), new IllegalStateException());
        }
    }

    private void r(Consumer<DrmSessionEventListener.EventDispatcher> consumer) {
        for (DrmSessionEventListener.EventDispatcher accept : this.f11245n.e()) {
            consumer.accept(accept);
        }
    }

    @RequiresNonNull({"sessionId"})
    private void s(boolean z2) {
        if (!this.f11243l) {
            byte[] bArr = (byte[]) Util.o(this.A);
            int i2 = this.f11241j;
            if (i2 == 0 || i2 == 1) {
                if (this.B == null) {
                    H(bArr, 1, z2);
                    return;
                } else if (this.u == 4 || J()) {
                    long t2 = t();
                    if (this.f11241j == 0 && t2 <= 60) {
                        Log.b(E, "Offline license has expired or will expire soon. Remaining seconds: " + t2);
                    } else if (t2 <= 0) {
                        y(new KeysExpiredException(), 2);
                        return;
                    } else {
                        this.u = 4;
                        r(new C0291e());
                        return;
                    }
                } else {
                    return;
                }
            } else if (i2 != 2) {
                if (i2 == 3) {
                    Assertions.g(this.B);
                    Assertions.g(this.A);
                    H(this.B, 3, z2);
                    return;
                }
                return;
            } else if (this.B != null && !J()) {
                return;
            }
            H(bArr, 2, z2);
        }
    }

    private long t() {
        if (!C.k2.equals(this.r)) {
            return Long.MAX_VALUE;
        }
        Pair pair = (Pair) Assertions.g(WidevineUtil.b(this));
        return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    private boolean v() {
        int i2 = this.u;
        return i2 == 3 || i2 == 4;
    }

    private void y(Throwable th, int i2) {
        this.z = new DrmSession.DrmSessionException(th, DrmUtil.a(th, i2));
        Log.e(E, "DRM session error", th);
        if (th instanceof Exception) {
            r(new C0290d(th));
        } else if (!(th instanceof Error)) {
            throw new IllegalStateException("Unexpected Throwable subclass", th);
        } else if (!DrmUtil.c(th) && !DrmUtil.b(th)) {
            throw ((Error) th);
        }
        if (this.u != 4) {
            this.u = 1;
        }
    }

    /* access modifiers changed from: private */
    public void z(Object obj, Object obj2) {
        Consumer consumer;
        if (obj == this.C && v()) {
            this.C = null;
            if ((obj2 instanceof Exception) || (obj2 instanceof NoSuchMethodError)) {
                A((Throwable) obj2, false);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.f11241j == 3) {
                    this.f11238g.q((byte[]) Util.o(this.B), bArr);
                    new C0288b
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002d: CONSTRUCTOR  (r2v16 ? I:androidx.media3.exoplayer.drm.b) =  call: androidx.media3.exoplayer.drm.b.<init>():void type: CONSTRUCTOR in method: androidx.media3.exoplayer.drm.DefaultDrmSession.z(java.lang.Object, java.lang.Object):void, dex: classes.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r2v16 ?
                        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:620)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	... 48 more
                        */
                    /*
                        this = this;
                        androidx.media3.exoplayer.drm.ExoMediaDrm$KeyRequest r0 = r1.C
                        if (r2 != r0) goto L_0x0066
                        boolean r2 = r1.v()
                        if (r2 != 0) goto L_0x000b
                        goto L_0x0066
                    L_0x000b:
                        r2 = 0
                        r1.C = r2
                        boolean r2 = r3 instanceof java.lang.Exception
                        if (r2 != 0) goto L_0x0060
                        boolean r2 = r3 instanceof java.lang.NoSuchMethodError
                        if (r2 == 0) goto L_0x0017
                        goto L_0x0060
                    L_0x0017:
                        byte[] r3 = (byte[]) r3     // Catch:{ Exception -> 0x0036, NoSuchMethodError -> 0x0034 }
                        int r2 = r1.f11241j     // Catch:{ Exception -> 0x0036, NoSuchMethodError -> 0x0034 }
                        r0 = 3
                        if (r2 != r0) goto L_0x0038
                        androidx.media3.exoplayer.drm.ExoMediaDrm r2 = r1.f11238g     // Catch:{ Exception -> 0x0036, NoSuchMethodError -> 0x0034 }
                        byte[] r0 = r1.B     // Catch:{ Exception -> 0x0036, NoSuchMethodError -> 0x0034 }
                        java.lang.Object r0 = androidx.media3.common.util.Util.o(r0)     // Catch:{ Exception -> 0x0036, NoSuchMethodError -> 0x0034 }
                        byte[] r0 = (byte[]) r0     // Catch:{ Exception -> 0x0036, NoSuchMethodError -> 0x0034 }
                        r2.q(r0, r3)     // Catch:{ Exception -> 0x0036, NoSuchMethodError -> 0x0034 }
                        androidx.media3.exoplayer.drm.b r2 = new androidx.media3.exoplayer.drm.b     // Catch:{ Exception -> 0x0036, NoSuchMethodError -> 0x0034 }
                        r2.<init>()     // Catch:{ Exception -> 0x0036, NoSuchMethodError -> 0x0034 }
                    L_0x0030:
                        r1.r(r2)     // Catch:{ Exception -> 0x0036, NoSuchMethodError -> 0x0034 }
                        goto L_0x005f
                    L_0x0034:
                        r2 = move-exception
                        goto L_0x005b
                    L_0x0036:
                        r2 = move-exception
                        goto L_0x005b
                    L_0x0038:
                        androidx.media3.exoplayer.drm.ExoMediaDrm r2 = r1.f11238g     // Catch:{ Exception -> 0x0036, NoSuchMethodError -> 0x0034 }
                        byte[] r0 = r1.A     // Catch:{ Exception -> 0x0036, NoSuchMethodError -> 0x0034 }
                        byte[] r2 = r2.q(r0, r3)     // Catch:{ Exception -> 0x0036, NoSuchMethodError -> 0x0034 }
                        int r3 = r1.f11241j     // Catch:{ Exception -> 0x0036, NoSuchMethodError -> 0x0034 }
                        r0 = 2
                        if (r3 == r0) goto L_0x004b
                        if (r3 != 0) goto L_0x0052
                        byte[] r3 = r1.B     // Catch:{ Exception -> 0x0036, NoSuchMethodError -> 0x0034 }
                        if (r3 == 0) goto L_0x0052
                    L_0x004b:
                        if (r2 == 0) goto L_0x0052
                        int r3 = r2.length     // Catch:{ Exception -> 0x0036, NoSuchMethodError -> 0x0034 }
                        if (r3 == 0) goto L_0x0052
                        r1.B = r2     // Catch:{ Exception -> 0x0036, NoSuchMethodError -> 0x0034 }
                    L_0x0052:
                        r2 = 4
                        r1.u = r2     // Catch:{ Exception -> 0x0036, NoSuchMethodError -> 0x0034 }
                        androidx.media3.exoplayer.drm.c r2 = new androidx.media3.exoplayer.drm.c     // Catch:{ Exception -> 0x0036, NoSuchMethodError -> 0x0034 }
                        r2.<init>()     // Catch:{ Exception -> 0x0036, NoSuchMethodError -> 0x0034 }
                        goto L_0x0030
                    L_0x005b:
                        r3 = 1
                        r1.A(r2, r3)
                    L_0x005f:
                        return
                    L_0x0060:
                        java.lang.Throwable r3 = (java.lang.Throwable) r3
                        r2 = 0
                        r1.A(r3, r2)
                    L_0x0066:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.drm.DefaultDrmSession.z(java.lang.Object, java.lang.Object):void");
                }

                /* access modifiers changed from: package-private */
                public void C(int i2) {
                    if (i2 == 2) {
                        B();
                    }
                }

                /* access modifiers changed from: package-private */
                public void D() {
                    if (G()) {
                        s(true);
                    }
                }

                /* access modifiers changed from: package-private */
                public void E(Exception exc, boolean z2) {
                    y(exc, z2 ? 1 : 3);
                }

                /* access modifiers changed from: package-private */
                public void I() {
                    this.D = this.f11238g.g();
                    ((RequestHandler) Util.o(this.x)).b(0, Assertions.g(this.D), true);
                }

                @Nullable
                public final DrmSession.DrmSessionException e() {
                    K();
                    if (this.u == 1) {
                        return this.z;
                    }
                    return null;
                }

                public void f(@Nullable DrmSessionEventListener.EventDispatcher eventDispatcher) {
                    K();
                    boolean z2 = false;
                    if (this.v < 0) {
                        Log.d(E, "Session reference count less than zero: " + this.v);
                        this.v = 0;
                    }
                    if (eventDispatcher != null) {
                        this.f11245n.b(eventDispatcher);
                    }
                    int i2 = this.v + 1;
                    this.v = i2;
                    if (i2 == 1) {
                        if (this.u == 2) {
                            z2 = true;
                        }
                        Assertions.i(z2);
                        HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
                        this.w = handlerThread;
                        handlerThread.start();
                        this.x = new RequestHandler(this.w.getLooper());
                        if (G()) {
                            s(true);
                        }
                    } else if (eventDispatcher != null && v() && this.f11245n.l1(eventDispatcher) == 1) {
                        eventDispatcher.k(this.u);
                    }
                    this.f11240i.a(this, this.v);
                }

                public final UUID g() {
                    K();
                    return this.r;
                }

                public final int getState() {
                    K();
                    return this.u;
                }

                public boolean h() {
                    K();
                    return this.f11242k;
                }

                @Nullable
                public Map<String, String> i() {
                    K();
                    byte[] bArr = this.A;
                    if (bArr == null) {
                        return null;
                    }
                    return this.f11238g.d(bArr);
                }

                public void j(@Nullable DrmSessionEventListener.EventDispatcher eventDispatcher) {
                    K();
                    int i2 = this.v;
                    if (i2 <= 0) {
                        Log.d(E, "release() called on a session that's already fully released.");
                        return;
                    }
                    int i3 = i2 - 1;
                    this.v = i3;
                    if (i3 == 0) {
                        this.u = 0;
                        ((ResponseHandler) Util.o(this.t)).removeCallbacksAndMessages((Object) null);
                        ((RequestHandler) Util.o(this.x)).c();
                        this.x = null;
                        ((HandlerThread) Util.o(this.w)).quit();
                        this.w = null;
                        this.y = null;
                        this.z = null;
                        this.C = null;
                        this.D = null;
                        byte[] bArr = this.A;
                        if (bArr != null) {
                            this.f11238g.o(bArr);
                            this.A = null;
                        }
                    }
                    if (eventDispatcher != null) {
                        this.f11245n.c(eventDispatcher);
                        if (this.f11245n.l1(eventDispatcher) == 0) {
                            eventDispatcher.m();
                        }
                    }
                    this.f11240i.b(this, this.v);
                }

                @Nullable
                public byte[] k() {
                    K();
                    return this.B;
                }

                public boolean l(String str) {
                    K();
                    return this.f11238g.l((byte[]) Assertions.k(this.A), str);
                }

                @Nullable
                public final CryptoConfig m() {
                    K();
                    return this.y;
                }

                public boolean u(byte[] bArr) {
                    K();
                    return Arrays.equals(this.A, bArr);
                }
            }
