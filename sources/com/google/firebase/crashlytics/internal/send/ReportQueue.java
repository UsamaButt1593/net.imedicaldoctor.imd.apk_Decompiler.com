package com.google.firebase.crashlytics.internal.send;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import androidx.media3.exoplayer.ExoPlayer;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.runtime.ForcedSender;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.common.OnDemandCounter;
import com.google.firebase.crashlytics.internal.common.Utils;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.settings.Settings;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class ReportQueue {

    /* renamed from: l  reason: collision with root package name */
    private static final int f24229l = 1000;

    /* renamed from: m  reason: collision with root package name */
    private static final int f24230m = 60000;

    /* renamed from: n  reason: collision with root package name */
    private static final int f24231n = 3600000;
    private static final int o = 2000;

    /* renamed from: a  reason: collision with root package name */
    private final double f24232a;

    /* renamed from: b  reason: collision with root package name */
    private final double f24233b;

    /* renamed from: c  reason: collision with root package name */
    private final long f24234c;

    /* renamed from: d  reason: collision with root package name */
    private final long f24235d;

    /* renamed from: e  reason: collision with root package name */
    private final int f24236e;

    /* renamed from: f  reason: collision with root package name */
    private final BlockingQueue<Runnable> f24237f;

    /* renamed from: g  reason: collision with root package name */
    private final ThreadPoolExecutor f24238g;

    /* renamed from: h  reason: collision with root package name */
    private final Transport<CrashlyticsReport> f24239h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final OnDemandCounter f24240i;

    /* renamed from: j  reason: collision with root package name */
    private int f24241j;

    /* renamed from: k  reason: collision with root package name */
    private long f24242k;

    private final class ReportRunnable implements Runnable {
        private final TaskCompletionSource<CrashlyticsReportWithSessionId> X;
        private final CrashlyticsReportWithSessionId s;

        private ReportRunnable(CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, TaskCompletionSource<CrashlyticsReportWithSessionId> taskCompletionSource) {
            this.s = crashlyticsReportWithSessionId;
            this.X = taskCompletionSource;
        }

        public void run() {
            ReportQueue.this.p(this.s, this.X);
            ReportQueue.this.f24240i.e();
            double e2 = ReportQueue.this.g();
            Logger f2 = Logger.f();
            f2.b("Delay for: " + String.format(Locale.US, "%.2f", new Object[]{Double.valueOf(e2 / 1000.0d)}) + " s for report: " + this.s.d());
            ReportQueue.q(e2);
        }
    }

    @SuppressLint({"ThreadPoolCreation"})
    ReportQueue(double d2, double d3, long j2, Transport<CrashlyticsReport> transport, OnDemandCounter onDemandCounter) {
        this.f24232a = d2;
        this.f24233b = d3;
        this.f24234c = j2;
        this.f24239h = transport;
        this.f24240i = onDemandCounter;
        this.f24235d = SystemClock.elapsedRealtime();
        int i2 = (int) d2;
        this.f24236e = i2;
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(i2);
        this.f24237f = arrayBlockingQueue;
        this.f24238g = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, arrayBlockingQueue);
        this.f24241j = 0;
        this.f24242k = 0;
    }

    /* access modifiers changed from: private */
    public double g() {
        return Math.min(3600000.0d, (60000.0d / this.f24232a) * Math.pow(this.f24233b, (double) h()));
    }

    private int h() {
        if (this.f24242k == 0) {
            this.f24242k = o();
        }
        int o2 = (int) ((o() - this.f24242k) / this.f24234c);
        int min = l() ? Math.min(100, this.f24241j + o2) : Math.max(0, this.f24241j - o2);
        if (this.f24241j != min) {
            this.f24241j = min;
            this.f24242k = o();
        }
        return min;
    }

    private boolean k() {
        return this.f24237f.size() < this.f24236e;
    }

    private boolean l() {
        return this.f24237f.size() == this.f24236e;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(CountDownLatch countDownLatch) {
        try {
            ForcedSender.a(this.f24239h, Priority.HIGHEST);
        } catch (Exception unused) {
        }
        countDownLatch.countDown();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(TaskCompletionSource taskCompletionSource, boolean z, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, Exception exc) {
        if (exc != null) {
            taskCompletionSource.d(exc);
            return;
        }
        if (z) {
            j();
        }
        taskCompletionSource.e(crashlyticsReportWithSessionId);
    }

    private long o() {
        return System.currentTimeMillis();
    }

    /* access modifiers changed from: private */
    public void p(CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, TaskCompletionSource<CrashlyticsReportWithSessionId> taskCompletionSource) {
        Logger f2 = Logger.f();
        f2.b("Sending report through Google DataTransport: " + crashlyticsReportWithSessionId.d());
        this.f24239h.b(Event.z(crashlyticsReportWithSessionId.b()), new c(this, taskCompletionSource, SystemClock.elapsedRealtime() - this.f24235d < ExoPlayer.a1, crashlyticsReportWithSessionId));
    }

    /* access modifiers changed from: private */
    public static void q(double d2) {
        try {
            Thread.sleep((long) d2);
        } catch (InterruptedException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public TaskCompletionSource<CrashlyticsReportWithSessionId> i(CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, boolean z) {
        synchronized (this.f24237f) {
            try {
                TaskCompletionSource<CrashlyticsReportWithSessionId> taskCompletionSource = new TaskCompletionSource<>();
                if (z) {
                    this.f24240i.d();
                    if (k()) {
                        Logger f2 = Logger.f();
                        f2.b("Enqueueing report: " + crashlyticsReportWithSessionId.d());
                        Logger f3 = Logger.f();
                        f3.b("Queue size: " + this.f24237f.size());
                        this.f24238g.execute(new ReportRunnable(crashlyticsReportWithSessionId, taskCompletionSource));
                        Logger f4 = Logger.f();
                        f4.b("Closing task for report: " + crashlyticsReportWithSessionId.d());
                        taskCompletionSource.e(crashlyticsReportWithSessionId);
                        return taskCompletionSource;
                    }
                    h();
                    Logger f5 = Logger.f();
                    f5.b("Dropping report due to queue being full: " + crashlyticsReportWithSessionId.d());
                    this.f24240i.c();
                    taskCompletionSource.e(crashlyticsReportWithSessionId);
                    return taskCompletionSource;
                }
                p(crashlyticsReportWithSessionId, taskCompletionSource);
                return taskCompletionSource;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @SuppressLint({"DiscouragedApi", "ThreadPoolCreation"})
    public void j() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new b(this, countDownLatch)).start();
        Utils.g(countDownLatch, 2, TimeUnit.SECONDS);
    }

    ReportQueue(Transport<CrashlyticsReport> transport, Settings settings, OnDemandCounter onDemandCounter) {
        this(settings.f24268f, settings.f24269g, ((long) settings.f24270h) * 1000, transport, onDemandCounter);
    }
}
