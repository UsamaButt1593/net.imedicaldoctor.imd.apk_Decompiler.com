package androidx.media3.exoplayer.analytics;

import androidx.media3.common.FlagSet;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class G implements ListenerSet.IterationFinishedEvent {
    public final void a(Object obj, FlagSet flagSet) {
        DefaultAnalyticsCollector.a2((AnalyticsListener) obj, flagSet);
    }
}
