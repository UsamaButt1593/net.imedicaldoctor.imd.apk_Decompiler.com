package androidx.media3.common;

import android.content.Context;
import androidx.media3.common.VideoGraph;
import androidx.media3.common.util.UnstableApi;
import java.util.List;
import java.util.concurrent.Executor;

@UnstableApi
public interface PreviewingVideoGraph extends VideoGraph {

    public interface Factory {
        PreviewingVideoGraph a(Context context, ColorInfo colorInfo, ColorInfo colorInfo2, DebugViewProvider debugViewProvider, VideoGraph.Listener listener, Executor executor, List<Effect> list, long j2) throws VideoFrameProcessingException;
    }

    void d(long j2);
}
