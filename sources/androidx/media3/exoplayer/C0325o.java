package androidx.media3.exoplayer;

import androidx.media3.common.util.Clock;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import com.google.common.base.Function;

/* renamed from: androidx.media3.exoplayer.o  reason: case insensitive filesystem */
public final /* synthetic */ class C0325o implements Function {
    public final /* synthetic */ AnalyticsCollector s;

    public /* synthetic */ C0325o(AnalyticsCollector analyticsCollector) {
        this.s = analyticsCollector;
    }

    public final Object apply(Object obj) {
        return ExoPlayer.Builder.P(this.s, (Clock) obj);
    }
}
