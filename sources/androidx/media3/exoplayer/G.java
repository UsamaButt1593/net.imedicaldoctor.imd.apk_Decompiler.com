package androidx.media3.exoplayer;

import androidx.media3.common.util.Clock;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;
import com.google.common.base.Function;

public final /* synthetic */ class G implements Function {
    public final Object apply(Object obj) {
        return new DefaultAnalyticsCollector((Clock) obj);
    }
}
