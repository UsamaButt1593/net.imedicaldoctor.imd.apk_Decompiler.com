package androidx.media3.exoplayer.upstream.experimental;

import android.os.Handler;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import androidx.media3.exoplayer.upstream.BandwidthMeter;

@UnstableApi
public interface BandwidthEstimator {

    /* renamed from: a  reason: collision with root package name */
    public static final long f12605a = Long.MIN_VALUE;

    void a(BandwidthMeter.EventListener eventListener);

    long b();

    void c(Handler handler, BandwidthMeter.EventListener eventListener);

    void d(DataSource dataSource, int i2);

    void e(DataSource dataSource);

    void f(long j2);

    void g(DataSource dataSource);

    void h(DataSource dataSource);
}
