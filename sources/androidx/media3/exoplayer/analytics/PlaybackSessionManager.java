package androidx.media3.exoplayer.analytics;

import androidx.annotation.Nullable;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.source.MediaSource;

@UnstableApi
public interface PlaybackSessionManager {

    public interface Listener {
        void N(AnalyticsListener.EventTime eventTime, String str, boolean z);

        void i(AnalyticsListener.EventTime eventTime, String str, String str2);

        void k0(AnalyticsListener.EventTime eventTime, String str);

        void s0(AnalyticsListener.EventTime eventTime, String str);
    }

    void a(AnalyticsListener.EventTime eventTime);

    void b(AnalyticsListener.EventTime eventTime);

    @Nullable
    String c();

    void d(Listener listener);

    String e(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId);

    boolean f(AnalyticsListener.EventTime eventTime, String str);

    void g(AnalyticsListener.EventTime eventTime, int i2);

    void h(AnalyticsListener.EventTime eventTime);
}
