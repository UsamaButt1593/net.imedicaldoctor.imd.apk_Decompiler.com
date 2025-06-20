package androidx.media3.exoplayer.analytics;

/* renamed from: androidx.media3.exoplayer.analytics.e0  reason: case insensitive filesystem */
public final /* synthetic */ class C0214e0 implements Runnable {
    public final /* synthetic */ DefaultAnalyticsCollector s;

    public /* synthetic */ C0214e0(DefaultAnalyticsCollector defaultAnalyticsCollector) {
        this.s = defaultAnalyticsCollector;
    }

    public final void run() {
        this.s.s3();
    }
}
