package androidx.media3.exoplayer.video;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
public final class VideoFrameReleaseHelper {
    private static final String r = "VideoFrameReleaseHelper";
    private static final long s = 5000000000L;
    private static final float t = 0.02f;
    private static final float u = 1.0f;
    private static final int v = 30;
    private static final long w = 500;
    private static final long x = 20000000;
    private static final long y = 80;

    /* renamed from: a  reason: collision with root package name */
    private final FixedFrameRateEstimator f12787a = new FixedFrameRateEstimator();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final DisplayHelper f12788b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final VSyncSampler f12789c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12790d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private Surface f12791e;

    /* renamed from: f  reason: collision with root package name */
    private float f12792f;

    /* renamed from: g  reason: collision with root package name */
    private float f12793g;

    /* renamed from: h  reason: collision with root package name */
    private float f12794h;

    /* renamed from: i  reason: collision with root package name */
    private float f12795i;

    /* renamed from: j  reason: collision with root package name */
    private int f12796j;

    /* renamed from: k  reason: collision with root package name */
    private long f12797k;

    /* renamed from: l  reason: collision with root package name */
    private long f12798l;

    /* renamed from: m  reason: collision with root package name */
    private long f12799m;

    /* renamed from: n  reason: collision with root package name */
    private long f12800n;
    private long o;
    private long p;
    private long q;

    @RequiresApi(17)
    private static final class Api17 {
        private Api17() {
        }

        @DoNotInline
        public static boolean a(@Nullable Surface surface) {
            return surface instanceof PlaceholderSurface;
        }
    }

    @RequiresApi(30)
    private static final class Api30 {
        private Api30() {
        }

        @DoNotInline
        public static void a(Surface surface, float f2) {
            try {
                surface.setFrameRate(f2, f2 == 0.0f ? 0 : 1);
            } catch (IllegalStateException e2) {
                Log.e(VideoFrameReleaseHelper.r, "Failed to call Surface.setFrameRate", e2);
            }
        }
    }

    private interface DisplayHelper {

        public interface Listener {
            void a(@Nullable Display display);
        }

        void a();

        void b(Listener listener);
    }

    private static final class DisplayHelperV16 implements DisplayHelper {

        /* renamed from: a  reason: collision with root package name */
        private final WindowManager f12801a;

        private DisplayHelperV16(WindowManager windowManager) {
            this.f12801a = windowManager;
        }

        @Nullable
        public static DisplayHelper c(Context context) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null) {
                return new DisplayHelperV16(windowManager);
            }
            return null;
        }

        public void a() {
        }

        public void b(DisplayHelper.Listener listener) {
            listener.a(this.f12801a.getDefaultDisplay());
        }
    }

    @RequiresApi(17)
    private static final class DisplayHelperV17 implements DisplayHelper, DisplayManager.DisplayListener {

        /* renamed from: a  reason: collision with root package name */
        private final DisplayManager f12802a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private DisplayHelper.Listener f12803b;

        private DisplayHelperV17(DisplayManager displayManager) {
            this.f12802a = displayManager;
        }

        private Display c() {
            return this.f12802a.getDisplay(0);
        }

        @Nullable
        public static DisplayHelper d(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            if (displayManager != null) {
                return new DisplayHelperV17(displayManager);
            }
            return null;
        }

        public void a() {
            this.f12802a.unregisterDisplayListener(this);
            this.f12803b = null;
        }

        public void b(DisplayHelper.Listener listener) {
            this.f12803b = listener;
            this.f12802a.registerDisplayListener(this, Util.H());
            listener.a(c());
        }

        public void onDisplayAdded(int i2) {
        }

        public void onDisplayChanged(int i2) {
            DisplayHelper.Listener listener = this.f12803b;
            if (listener != null && i2 == 0) {
                listener.a(c());
            }
        }

        public void onDisplayRemoved(int i2) {
        }
    }

    private static final class VSyncSampler implements Choreographer.FrameCallback, Handler.Callback {
        private static final int Y2 = 0;
        private static final int Z2 = 1;
        private static final int a3 = 2;
        private static final VSyncSampler b3 = new VSyncSampler();
        private final Handler X;
        private int X2;
        private final HandlerThread Y;
        private Choreographer Z;
        public volatile long s = C.f9084b;

        private VSyncSampler() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.Y = handlerThread;
            handlerThread.start();
            Handler G = Util.G(handlerThread.getLooper(), this);
            this.X = G;
            G.sendEmptyMessage(0);
        }

        private void b() {
            Choreographer choreographer = this.Z;
            if (choreographer != null) {
                int i2 = this.X2 + 1;
                this.X2 = i2;
                if (i2 == 1) {
                    choreographer.postFrameCallback(this);
                }
            }
        }

        private void c() {
            try {
                this.Z = Choreographer.getInstance();
            } catch (RuntimeException e2) {
                Log.o(VideoFrameReleaseHelper.r, "Vsync sampling disabled due to platform error", e2);
            }
        }

        public static VSyncSampler d() {
            return b3;
        }

        private void f() {
            Choreographer choreographer = this.Z;
            if (choreographer != null) {
                int i2 = this.X2 - 1;
                this.X2 = i2;
                if (i2 == 0) {
                    choreographer.removeFrameCallback(this);
                    this.s = C.f9084b;
                }
            }
        }

        public void a() {
            this.X.sendEmptyMessage(1);
        }

        public void doFrame(long j2) {
            this.s = j2;
            ((Choreographer) Assertions.g(this.Z)).postFrameCallbackDelayed(this, 500);
        }

        public void e() {
            this.X.sendEmptyMessage(2);
        }

        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                c();
                return true;
            } else if (i2 == 1) {
                b();
                return true;
            } else if (i2 != 2) {
                return false;
            } else {
                f();
                return true;
            }
        }
    }

    public VideoFrameReleaseHelper(@Nullable Context context) {
        DisplayHelper f2 = f(context);
        this.f12788b = f2;
        this.f12789c = f2 != null ? VSyncSampler.d() : null;
        this.f12797k = C.f9084b;
        this.f12798l = C.f9084b;
        this.f12792f = -1.0f;
        this.f12795i = 1.0f;
        this.f12796j = 0;
    }

    private static boolean c(long j2, long j3) {
        return Math.abs(j2 - j3) <= x;
    }

    private void d() {
        Surface surface;
        if (Util.f9646a >= 30 && (surface = this.f12791e) != null && this.f12796j != Integer.MIN_VALUE && this.f12794h != 0.0f) {
            this.f12794h = 0.0f;
            Api30.a(surface, 0.0f);
        }
    }

    private static long e(long j2, long j3, long j4) {
        long j5;
        long j6 = j3 + (((j2 - j3) / j4) * j4);
        if (j2 <= j6) {
            j5 = j6 - j4;
        } else {
            long j7 = j6;
            j6 = j4 + j6;
            j5 = j7;
        }
        return j6 - j2 < j2 - j5 ? j6 : j5;
    }

    @Nullable
    private static DisplayHelper f(@Nullable Context context) {
        DisplayHelper displayHelper = null;
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        if (Util.f9646a >= 17) {
            displayHelper = DisplayHelperV17.d(applicationContext);
        }
        return displayHelper == null ? DisplayHelperV16.c(applicationContext) : displayHelper;
    }

    private void n() {
        this.f12799m = 0;
        this.p = -1;
        this.f12800n = -1;
    }

    /* access modifiers changed from: private */
    public void p(@Nullable Display display) {
        long j2;
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            this.f12797k = refreshRate;
            j2 = (refreshRate * y) / 100;
        } else {
            Log.n(r, "Unable to query display refresh rate");
            j2 = C.f9084b;
            this.f12797k = C.f9084b;
        }
        this.f12798l = j2;
    }

    private void q() {
        if (Util.f9646a >= 30 && this.f12791e != null) {
            float b2 = this.f12787a.e() ? this.f12787a.b() : this.f12792f;
            float f2 = this.f12793g;
            if (b2 != f2) {
                int i2 = (b2 > -1.0f ? 1 : (b2 == -1.0f ? 0 : -1));
                if (i2 != 0 && f2 != -1.0f) {
                    if (Math.abs(b2 - this.f12793g) < ((!this.f12787a.e() || this.f12787a.d() < s) ? 1.0f : t)) {
                        return;
                    }
                } else if (i2 == 0 && this.f12787a.c() < 30) {
                    return;
                }
                this.f12793g = b2;
                r(false);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void r(boolean r4) {
        /*
            r3 = this;
            int r0 = androidx.media3.common.util.Util.f9646a
            r1 = 30
            if (r0 < r1) goto L_0x0031
            android.view.Surface r0 = r3.f12791e
            if (r0 == 0) goto L_0x0031
            int r1 = r3.f12796j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != r2) goto L_0x0011
            goto L_0x0031
        L_0x0011:
            boolean r1 = r3.f12790d
            if (r1 == 0) goto L_0x0022
            float r1 = r3.f12793g
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0022
            float r2 = r3.f12795i
            float r1 = r1 * r2
            goto L_0x0023
        L_0x0022:
            r1 = 0
        L_0x0023:
            if (r4 != 0) goto L_0x002c
            float r4 = r3.f12794h
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r4 != 0) goto L_0x002c
            return
        L_0x002c:
            r3.f12794h = r1
            androidx.media3.exoplayer.video.VideoFrameReleaseHelper.Api30.a(r0, r1)
        L_0x0031:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.VideoFrameReleaseHelper.r(boolean):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long b(long r11) {
        /*
            r10 = this;
            long r0 = r10.p
            r2 = -1
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0030
            androidx.media3.exoplayer.video.FixedFrameRateEstimator r0 = r10.f12787a
            boolean r0 = r0.e()
            if (r0 == 0) goto L_0x0030
            androidx.media3.exoplayer.video.FixedFrameRateEstimator r0 = r10.f12787a
            long r0 = r0.a()
            long r2 = r10.q
            long r4 = r10.f12799m
            long r6 = r10.p
            long r4 = r4 - r6
            long r0 = r0 * r4
            float r0 = (float) r0
            float r1 = r10.f12795i
            float r0 = r0 / r1
            long r0 = (long) r0
            long r2 = r2 + r0
            boolean r0 = c(r11, r2)
            if (r0 == 0) goto L_0x002d
            r4 = r2
            goto L_0x0031
        L_0x002d:
            r10.n()
        L_0x0030:
            r4 = r11
        L_0x0031:
            long r11 = r10.f12799m
            r10.f12800n = r11
            r10.o = r4
            androidx.media3.exoplayer.video.VideoFrameReleaseHelper$VSyncSampler r11 = r10.f12789c
            if (r11 == 0) goto L_0x0058
            long r0 = r10.f12797k
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 != 0) goto L_0x0047
            goto L_0x0058
        L_0x0047:
            long r6 = r11.s
            int r11 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r11 != 0) goto L_0x004e
            return r4
        L_0x004e:
            long r8 = r10.f12797k
            long r11 = e(r4, r6, r8)
            long r0 = r10.f12798l
            long r11 = r11 - r0
            return r11
        L_0x0058:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.VideoFrameReleaseHelper.b(long):long");
    }

    public void g(float f2) {
        this.f12792f = f2;
        this.f12787a.g();
        q();
    }

    public void h(long j2) {
        long j3 = this.f12800n;
        if (j3 != -1) {
            this.p = j3;
            this.q = this.o;
        }
        this.f12799m++;
        this.f12787a.f(j2 * 1000);
        q();
    }

    public void i(float f2) {
        this.f12795i = f2;
        n();
        r(false);
    }

    public void j() {
        n();
    }

    public void k() {
        this.f12790d = true;
        n();
        if (this.f12788b != null) {
            ((VSyncSampler) Assertions.g(this.f12789c)).a();
            this.f12788b.b(new l(this));
        }
        r(false);
    }

    public void l() {
        this.f12790d = false;
        DisplayHelper displayHelper = this.f12788b;
        if (displayHelper != null) {
            displayHelper.a();
            ((VSyncSampler) Assertions.g(this.f12789c)).e();
        }
        d();
    }

    public void m(@Nullable Surface surface) {
        if (Util.f9646a >= 17 && Api17.a(surface)) {
            surface = null;
        }
        if (this.f12791e != surface) {
            d();
            this.f12791e = surface;
            r(true);
        }
    }

    public void o(int i2) {
        if (this.f12796j != i2) {
            this.f12796j = i2;
            r(true);
        }
    }
}
