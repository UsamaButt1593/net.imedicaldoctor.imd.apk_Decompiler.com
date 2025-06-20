package androidx.media3.exoplayer;

import androidx.media3.common.util.Clock;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import com.google.common.base.Function;

public final /* synthetic */ class C implements Function {
    public final /* synthetic */ AnalyticsCollector s;

    public /* synthetic */ C(AnalyticsCollector analyticsCollector) {
        this.s = analyticsCollector;
    }

    public final Object apply(Object obj) {
        return ExoPlayer.Builder.E(this.s, (Clock) obj);
    }
}
