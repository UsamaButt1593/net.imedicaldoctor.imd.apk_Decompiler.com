package androidx.media3.exoplayer.scheduler;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
public interface Scheduler {
    Requirements a(Requirements requirements);

    boolean b(Requirements requirements, String str, String str2);

    boolean cancel();
}
