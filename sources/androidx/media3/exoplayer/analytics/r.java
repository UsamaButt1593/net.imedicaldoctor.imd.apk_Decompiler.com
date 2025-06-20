package androidx.media3.exoplayer.analytics;

import androidx.media3.common.FlagSet;
import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class r implements ListenerSet.IterationFinishedEvent {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultAnalyticsCollector f10711a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Player f10712b;

    public /* synthetic */ r(DefaultAnalyticsCollector defaultAnalyticsCollector, Player player) {
        this.f10711a = defaultAnalyticsCollector;
        this.f10712b = player;
    }

    public final void a(Object obj, FlagSet flagSet) {
        this.f10711a.r3(this.f10712b, (AnalyticsListener) obj, flagSet);
    }
}
