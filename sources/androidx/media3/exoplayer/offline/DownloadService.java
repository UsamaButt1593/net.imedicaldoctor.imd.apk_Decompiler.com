package androidx.media3.exoplayer.offline;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.NotificationUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.offline.DownloadManager;
import androidx.media3.exoplayer.scheduler.Requirements;
import androidx.media3.exoplayer.scheduler.Scheduler;
import java.util.HashMap;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public abstract class DownloadService extends Service {
    public static final String d3 = "androidx.media3.exoplayer.downloadService.action.INIT";
    private static final String e3 = "androidx.media3.exoplayer.downloadService.action.RESTART";
    public static final String f3 = "androidx.media3.exoplayer.downloadService.action.ADD_DOWNLOAD";
    public static final String g3 = "androidx.media3.exoplayer.downloadService.action.REMOVE_DOWNLOAD";
    public static final String h3 = "androidx.media3.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS";
    public static final String i3 = "androidx.media3.exoplayer.downloadService.action.RESUME_DOWNLOADS";
    public static final String j3 = "androidx.media3.exoplayer.downloadService.action.PAUSE_DOWNLOADS";
    public static final String k3 = "androidx.media3.exoplayer.downloadService.action.SET_STOP_REASON";
    public static final String l3 = "androidx.media3.exoplayer.downloadService.action.SET_REQUIREMENTS";
    public static final String m3 = "download_request";
    public static final String n3 = "content_id";
    public static final String o3 = "stop_reason";
    public static final String p3 = "requirements";
    public static final String q3 = "foreground";
    public static final int r3 = 0;
    public static final long s3 = 1000;
    private static final String t3 = "DownloadService";
    private static final HashMap<Class<? extends DownloadService>, DownloadManagerHelper> u3 = new HashMap<>();
    @Nullable
    private final String X;
    /* access modifiers changed from: private */
    public DownloadManagerHelper X2;
    @StringRes
    private final int Y;
    private int Y2;
    @StringRes
    private final int Z;
    private boolean Z2;
    private boolean a3;
    private boolean b3;
    private boolean c3;
    @Nullable
    private final ForegroundNotificationUpdater s;

    private static final class DownloadManagerHelper implements DownloadManager.Listener {

        /* renamed from: a  reason: collision with root package name */
        private final Context f11827a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final DownloadManager f11828b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f11829c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private final Scheduler f11830d;

        /* renamed from: e  reason: collision with root package name */
        private final Class<? extends DownloadService> f11831e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private DownloadService f11832f;

        /* renamed from: g  reason: collision with root package name */
        private Requirements f11833g;

        private DownloadManagerHelper(Context context, DownloadManager downloadManager, boolean z, @Nullable Scheduler scheduler, Class<? extends DownloadService> cls) {
            this.f11827a = context;
            this.f11828b = downloadManager;
            this.f11829c = z;
            this.f11830d = scheduler;
            this.f11831e = cls;
            downloadManager.e(this);
            q();
        }

        @RequiresNonNull({"scheduler"})
        private void k() {
            Requirements requirements = new Requirements(0);
            if (o(requirements)) {
                this.f11830d.cancel();
                this.f11833g = requirements;
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void m(DownloadService downloadService) {
            downloadService.B(this.f11828b.g());
        }

        private void n() {
            String str;
            if (this.f11829c) {
                try {
                    Util.s2(this.f11827a, DownloadService.t(this.f11827a, this.f11831e, DownloadService.e3));
                    return;
                } catch (IllegalStateException unused) {
                    str = "Failed to restart (foreground launch restriction)";
                }
            } else {
                try {
                    this.f11827a.startService(DownloadService.t(this.f11827a, this.f11831e, DownloadService.d3));
                    return;
                } catch (IllegalStateException unused2) {
                    str = "Failed to restart (process is idle)";
                }
            }
            Log.n(DownloadService.t3, str);
        }

        private boolean o(Requirements requirements) {
            return !Util.g(this.f11833g, requirements);
        }

        private boolean p() {
            DownloadService downloadService = this.f11832f;
            return downloadService == null || downloadService.x();
        }

        public void a(DownloadManager downloadManager, boolean z) {
            if (!z && !downloadManager.i() && p()) {
                List<Download> g2 = downloadManager.g();
                for (int i2 = 0; i2 < g2.size(); i2++) {
                    if (g2.get(i2).f11763b == 0) {
                        n();
                        return;
                    }
                }
            }
        }

        public void b(DownloadManager downloadManager, Download download) {
            DownloadService downloadService = this.f11832f;
            if (downloadService != null) {
                downloadService.A();
            }
        }

        public final void c(DownloadManager downloadManager) {
            DownloadService downloadService = this.f11832f;
            if (downloadService != null) {
                downloadService.C();
            }
        }

        public void d(DownloadManager downloadManager, Requirements requirements, int i2) {
            q();
        }

        public void e(DownloadManager downloadManager, Download download, @Nullable Exception exc) {
            DownloadService downloadService = this.f11832f;
            if (downloadService != null) {
                downloadService.z(download);
            }
            if (p() && DownloadService.y(download.f11763b)) {
                Log.n(DownloadService.t3, "DownloadService wasn't running. Restarting.");
                n();
            }
        }

        public /* synthetic */ void f(DownloadManager downloadManager, boolean z) {
            m.c(this, downloadManager, z);
        }

        public void g(DownloadManager downloadManager) {
            DownloadService downloadService = this.f11832f;
            if (downloadService != null) {
                downloadService.B(downloadManager.g());
            }
        }

        public void j(DownloadService downloadService) {
            Assertions.i(this.f11832f == null);
            this.f11832f = downloadService;
            if (this.f11828b.p()) {
                Util.J().postAtFrontOfQueue(new n(this, downloadService));
            }
        }

        public void l(DownloadService downloadService) {
            Assertions.i(this.f11832f == downloadService);
            this.f11832f = null;
        }

        public boolean q() {
            boolean q = this.f11828b.q();
            if (this.f11830d == null) {
                return !q;
            }
            if (!q) {
                k();
                return true;
            }
            Requirements m2 = this.f11828b.m();
            if (!this.f11830d.a(m2).equals(m2)) {
                k();
                return false;
            } else if (!o(m2)) {
                return true;
            } else {
                if (this.f11830d.b(m2, this.f11827a.getPackageName(), DownloadService.e3)) {
                    this.f11833g = m2;
                    return true;
                }
                Log.n(DownloadService.t3, "Failed to schedule restart");
                k();
                return false;
            }
        }
    }

    private final class ForegroundNotificationUpdater {

        /* renamed from: a  reason: collision with root package name */
        private final int f11834a;

        /* renamed from: b  reason: collision with root package name */
        private final long f11835b;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f11836c = new Handler(Looper.getMainLooper());

        /* renamed from: d  reason: collision with root package name */
        private boolean f11837d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f11838e;

        public ForegroundNotificationUpdater(int i2, long j2) {
            this.f11834a = i2;
            this.f11835b = j2;
        }

        /* access modifiers changed from: private */
        @SuppressLint({"InlinedApi"})
        public void f() {
            DownloadManager i2 = ((DownloadManagerHelper) Assertions.g(DownloadService.this.X2)).f11828b;
            Notification s = DownloadService.this.s(i2.g(), i2.l());
            if (!this.f11838e) {
                Util.j2(DownloadService.this, this.f11834a, s, 1, "dataSync");
                this.f11838e = true;
            } else {
                ((NotificationManager) DownloadService.this.getSystemService("notification")).notify(this.f11834a, s);
            }
            if (this.f11837d) {
                this.f11836c.removeCallbacksAndMessages((Object) null);
                this.f11836c.postDelayed(new o(this), this.f11835b);
            }
        }

        public void b() {
            if (this.f11838e) {
                f();
            }
        }

        public void c() {
            if (!this.f11838e) {
                f();
            }
        }

        public void d() {
            this.f11837d = true;
            f();
        }

        public void e() {
            this.f11837d = false;
            this.f11836c.removeCallbacksAndMessages((Object) null);
        }
    }

    protected DownloadService(int i2) {
        this(i2, 1000);
    }

    /* access modifiers changed from: private */
    public void A() {
        ForegroundNotificationUpdater foregroundNotificationUpdater = this.s;
        if (foregroundNotificationUpdater != null) {
            foregroundNotificationUpdater.b();
        }
    }

    /* access modifiers changed from: private */
    public void B(List<Download> list) {
        if (this.s != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (y(list.get(i2).f11763b)) {
                    this.s.d();
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void C() {
        boolean stopSelfResult;
        ForegroundNotificationUpdater foregroundNotificationUpdater = this.s;
        if (foregroundNotificationUpdater != null) {
            foregroundNotificationUpdater.e();
        }
        if (((DownloadManagerHelper) Assertions.g(this.X2)).q()) {
            if (Util.f9646a >= 28 || !this.a3) {
                stopSelfResult = this.b3 | stopSelfResult(this.Y2);
            } else {
                stopSelf();
                stopSelfResult = true;
            }
            this.b3 = stopSelfResult;
        }
    }

    public static void D(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, int i2, boolean z) {
        N(context, i(context, cls, downloadRequest, i2, z), z);
    }

    public static void E(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, boolean z) {
        N(context, j(context, cls, downloadRequest, z), z);
    }

    public static void F(Context context, Class<? extends DownloadService> cls, boolean z) {
        N(context, k(context, cls, z), z);
    }

    public static void G(Context context, Class<? extends DownloadService> cls, boolean z) {
        N(context, l(context, cls, z), z);
    }

    public static void H(Context context, Class<? extends DownloadService> cls, String str, boolean z) {
        N(context, m(context, cls, str, z), z);
    }

    public static void I(Context context, Class<? extends DownloadService> cls, boolean z) {
        N(context, n(context, cls, z), z);
    }

    public static void J(Context context, Class<? extends DownloadService> cls, Requirements requirements, boolean z) {
        N(context, o(context, cls, requirements, z), z);
    }

    public static void K(Context context, Class<? extends DownloadService> cls, @Nullable String str, int i2, boolean z) {
        N(context, p(context, cls, str, i2, z), z);
    }

    public static void L(Context context, Class<? extends DownloadService> cls) {
        context.startService(t(context, cls, d3));
    }

    public static void M(Context context, Class<? extends DownloadService> cls) {
        Util.s2(context, u(context, cls, d3, true));
    }

    private static void N(Context context, Intent intent, boolean z) {
        if (z) {
            Util.s2(context, intent);
        } else {
            context.startService(intent);
        }
    }

    public static Intent i(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, int i2, boolean z) {
        return u(context, cls, f3, z).putExtra(m3, downloadRequest).putExtra(o3, i2);
    }

    public static Intent j(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, boolean z) {
        return i(context, cls, downloadRequest, 0, z);
    }

    public static Intent k(Context context, Class<? extends DownloadService> cls, boolean z) {
        return u(context, cls, j3, z);
    }

    public static Intent l(Context context, Class<? extends DownloadService> cls, boolean z) {
        return u(context, cls, h3, z);
    }

    public static Intent m(Context context, Class<? extends DownloadService> cls, String str, boolean z) {
        return u(context, cls, g3, z).putExtra(n3, str);
    }

    public static Intent n(Context context, Class<? extends DownloadService> cls, boolean z) {
        return u(context, cls, i3, z);
    }

    public static Intent o(Context context, Class<? extends DownloadService> cls, Requirements requirements, boolean z) {
        return u(context, cls, l3, z).putExtra(p3, requirements);
    }

    public static Intent p(Context context, Class<? extends DownloadService> cls, @Nullable String str, int i2, boolean z) {
        return u(context, cls, k3, z).putExtra(n3, str).putExtra(o3, i2);
    }

    public static void q() {
        u3.clear();
    }

    /* access modifiers changed from: private */
    public static Intent t(Context context, Class<? extends DownloadService> cls, String str) {
        return new Intent(context, cls).setAction(str);
    }

    private static Intent u(Context context, Class<? extends DownloadService> cls, String str, boolean z) {
        return t(context, cls, str).putExtra(q3, z);
    }

    /* access modifiers changed from: private */
    public boolean x() {
        return this.b3;
    }

    /* access modifiers changed from: private */
    public static boolean y(int i2) {
        return i2 == 2 || i2 == 5 || i2 == 7;
    }

    /* access modifiers changed from: private */
    public void z(Download download) {
        if (this.s == null) {
            return;
        }
        if (y(download.f11763b)) {
            this.s.d();
        } else {
            this.s.b();
        }
    }

    @Nullable
    public final IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }

    public void onCreate() {
        String str = this.X;
        if (str != null) {
            NotificationUtil.a(this, str, this.Y, this.Z, 2);
        }
        Class<?> cls = getClass();
        HashMap<Class<? extends DownloadService>, DownloadManagerHelper> hashMap = u3;
        DownloadManagerHelper downloadManagerHelper = hashMap.get(cls);
        if (downloadManagerHelper == null) {
            boolean z = false;
            boolean z2 = this.s != null;
            if (Util.f9646a < 31) {
                z = true;
            }
            Scheduler v = (!z2 || !z) ? null : v();
            DownloadManager r = r();
            r.C();
            downloadManagerHelper = new DownloadManagerHelper(getApplicationContext(), r, z2, v, cls);
            hashMap.put(cls, downloadManagerHelper);
        }
        this.X2 = downloadManagerHelper;
        downloadManagerHelper.j(this);
    }

    public void onDestroy() {
        this.c3 = true;
        ((DownloadManagerHelper) Assertions.g(this.X2)).l(this);
        ForegroundNotificationUpdater foregroundNotificationUpdater = this.s;
        if (foregroundNotificationUpdater != null) {
            foregroundNotificationUpdater.e();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int onStartCommand(@androidx.annotation.Nullable android.content.Intent r10, int r11, int r12) {
        /*
            r9 = this;
            java.lang.String r11 = "androidx.media3.exoplayer.downloadService.action.INIT"
            java.lang.String r0 = "androidx.media3.exoplayer.downloadService.action.RESTART"
            r9.Y2 = r12
            r12 = 0
            r9.a3 = r12
            r1 = 1
            if (r10 == 0) goto L_0x002e
            java.lang.String r2 = r10.getAction()
            java.lang.String r3 = "content_id"
            java.lang.String r3 = r10.getStringExtra(r3)
            boolean r4 = r9.Z2
            java.lang.String r5 = "foreground"
            boolean r5 = r10.getBooleanExtra(r5, r12)
            if (r5 != 0) goto L_0x0029
            boolean r5 = r0.equals(r2)
            if (r5 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r5 = 0
            goto L_0x002a
        L_0x0029:
            r5 = 1
        L_0x002a:
            r4 = r4 | r5
            r9.Z2 = r4
            goto L_0x0030
        L_0x002e:
            r2 = 0
            r3 = r2
        L_0x0030:
            if (r2 != 0) goto L_0x0033
            r2 = r11
        L_0x0033:
            androidx.media3.exoplayer.offline.DownloadService$DownloadManagerHelper r4 = r9.X2
            java.lang.Object r4 = androidx.media3.common.util.Assertions.g(r4)
            androidx.media3.exoplayer.offline.DownloadService$DownloadManagerHelper r4 = (androidx.media3.exoplayer.offline.DownloadService.DownloadManagerHelper) r4
            androidx.media3.exoplayer.offline.DownloadManager r4 = r4.f11828b
            java.lang.String r5 = "stop_reason"
            java.lang.String r6 = "DownloadService"
            r7 = -1
            int r8 = r2.hashCode()
            switch(r8) {
                case -2068303304: goto L_0x00a3;
                case -1192305801: goto L_0x0098;
                case -659421309: goto L_0x008f;
                case -238450692: goto L_0x0086;
                case 32678949: goto L_0x007b;
                case 464223742: goto L_0x0070;
                case 829812082: goto L_0x0065;
                case 845668953: goto L_0x005a;
                case 1746253622: goto L_0x004d;
                default: goto L_0x004b;
            }
        L_0x004b:
            goto L_0x00ad
        L_0x004d:
            java.lang.String r11 = "androidx.media3.exoplayer.downloadService.action.PAUSE_DOWNLOADS"
            boolean r11 = r2.equals(r11)
            if (r11 != 0) goto L_0x0057
            goto L_0x00ad
        L_0x0057:
            r7 = 8
            goto L_0x00ad
        L_0x005a:
            java.lang.String r11 = "androidx.media3.exoplayer.downloadService.action.SET_REQUIREMENTS"
            boolean r11 = r2.equals(r11)
            if (r11 != 0) goto L_0x0063
            goto L_0x00ad
        L_0x0063:
            r7 = 7
            goto L_0x00ad
        L_0x0065:
            java.lang.String r11 = "androidx.media3.exoplayer.downloadService.action.ADD_DOWNLOAD"
            boolean r11 = r2.equals(r11)
            if (r11 != 0) goto L_0x006e
            goto L_0x00ad
        L_0x006e:
            r7 = 6
            goto L_0x00ad
        L_0x0070:
            java.lang.String r11 = "androidx.media3.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS"
            boolean r11 = r2.equals(r11)
            if (r11 != 0) goto L_0x0079
            goto L_0x00ad
        L_0x0079:
            r7 = 5
            goto L_0x00ad
        L_0x007b:
            java.lang.String r11 = "androidx.media3.exoplayer.downloadService.action.RESUME_DOWNLOADS"
            boolean r11 = r2.equals(r11)
            if (r11 != 0) goto L_0x0084
            goto L_0x00ad
        L_0x0084:
            r7 = 4
            goto L_0x00ad
        L_0x0086:
            boolean r11 = r2.equals(r11)
            if (r11 != 0) goto L_0x008d
            goto L_0x00ad
        L_0x008d:
            r7 = 3
            goto L_0x00ad
        L_0x008f:
            boolean r11 = r2.equals(r0)
            if (r11 != 0) goto L_0x0096
            goto L_0x00ad
        L_0x0096:
            r7 = 2
            goto L_0x00ad
        L_0x0098:
            java.lang.String r11 = "androidx.media3.exoplayer.downloadService.action.REMOVE_DOWNLOAD"
            boolean r11 = r2.equals(r11)
            if (r11 != 0) goto L_0x00a1
            goto L_0x00ad
        L_0x00a1:
            r7 = 1
            goto L_0x00ad
        L_0x00a3:
            java.lang.String r11 = "androidx.media3.exoplayer.downloadService.action.SET_STOP_REASON"
            boolean r11 = r2.equals(r11)
            if (r11 != 0) goto L_0x00ac
            goto L_0x00ad
        L_0x00ac:
            r7 = 0
        L_0x00ad:
            switch(r7) {
                case 0: goto L_0x010c;
                case 1: goto L_0x0103;
                case 2: goto L_0x0122;
                case 3: goto L_0x0122;
                case 4: goto L_0x00ff;
                case 5: goto L_0x00fb;
                case 6: goto L_0x00e0;
                case 7: goto L_0x00c9;
                case 8: goto L_0x00c5;
                default: goto L_0x00b0;
            }
        L_0x00b0:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Ignored unrecognized action: "
            r10.append(r11)
            r10.append(r2)
            java.lang.String r10 = r10.toString()
        L_0x00c1:
            androidx.media3.common.util.Log.d(r6, r10)
            goto L_0x0122
        L_0x00c5:
            r4.x()
            goto L_0x0122
        L_0x00c9:
            java.lang.Object r10 = androidx.media3.common.util.Assertions.g(r10)
            android.content.Intent r10 = (android.content.Intent) r10
            java.lang.String r11 = "requirements"
            android.os.Parcelable r10 = r10.getParcelableExtra(r11)
            androidx.media3.exoplayer.scheduler.Requirements r10 = (androidx.media3.exoplayer.scheduler.Requirements) r10
            if (r10 != 0) goto L_0x00dc
            java.lang.String r10 = "Ignored SET_REQUIREMENTS: Missing requirements extra"
            goto L_0x00c1
        L_0x00dc:
            r4.G(r10)
            goto L_0x0122
        L_0x00e0:
            java.lang.Object r11 = androidx.media3.common.util.Assertions.g(r10)
            android.content.Intent r11 = (android.content.Intent) r11
            java.lang.String r0 = "download_request"
            android.os.Parcelable r11 = r11.getParcelableExtra(r0)
            androidx.media3.exoplayer.offline.DownloadRequest r11 = (androidx.media3.exoplayer.offline.DownloadRequest) r11
            if (r11 != 0) goto L_0x00f3
            java.lang.String r10 = "Ignored ADD_DOWNLOAD: Missing download_request extra"
            goto L_0x00c1
        L_0x00f3:
            int r10 = r10.getIntExtra(r5, r12)
            r4.d(r11, r10)
            goto L_0x0122
        L_0x00fb:
            r4.z()
            goto L_0x0122
        L_0x00ff:
            r4.C()
            goto L_0x0122
        L_0x0103:
            if (r3 != 0) goto L_0x0108
            java.lang.String r10 = "Ignored REMOVE_DOWNLOAD: Missing content_id extra"
            goto L_0x00c1
        L_0x0108:
            r4.A(r3)
            goto L_0x0122
        L_0x010c:
            java.lang.Object r11 = androidx.media3.common.util.Assertions.g(r10)
            android.content.Intent r11 = (android.content.Intent) r11
            boolean r11 = r11.hasExtra(r5)
            if (r11 != 0) goto L_0x011b
            java.lang.String r10 = "Ignored SET_STOP_REASON: Missing stop_reason extra"
            goto L_0x00c1
        L_0x011b:
            int r10 = r10.getIntExtra(r5, r12)
            r4.H(r3, r10)
        L_0x0122:
            int r10 = androidx.media3.common.util.Util.f9646a
            r11 = 26
            if (r10 < r11) goto L_0x0133
            boolean r10 = r9.Z2
            if (r10 == 0) goto L_0x0133
            androidx.media3.exoplayer.offline.DownloadService$ForegroundNotificationUpdater r10 = r9.s
            if (r10 == 0) goto L_0x0133
            r10.c()
        L_0x0133:
            r9.b3 = r12
            boolean r10 = r4.o()
            if (r10 == 0) goto L_0x013e
            r9.C()
        L_0x013e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.offline.DownloadService.onStartCommand(android.content.Intent, int, int):int");
    }

    public void onTaskRemoved(Intent intent) {
        this.a3 = true;
    }

    /* access modifiers changed from: protected */
    public abstract DownloadManager r();

    /* access modifiers changed from: protected */
    public abstract Notification s(List<Download> list, int i2);

    /* access modifiers changed from: protected */
    @Nullable
    public abstract Scheduler v();

    /* access modifiers changed from: protected */
    public final void w() {
        ForegroundNotificationUpdater foregroundNotificationUpdater = this.s;
        if (foregroundNotificationUpdater != null && !this.c3) {
            foregroundNotificationUpdater.b();
        }
    }

    protected DownloadService(int i2, long j2) {
        this(i2, j2, (String) null, 0, 0);
    }

    protected DownloadService(int i2, long j2, @Nullable String str, @StringRes int i4, @StringRes int i5) {
        if (i2 == 0) {
            this.s = null;
            this.X = null;
            this.Y = 0;
            this.Z = 0;
            return;
        }
        this.s = new ForegroundNotificationUpdater(i2, j2);
        this.X = str;
        this.Y = i4;
        this.Z = i5;
    }
}
