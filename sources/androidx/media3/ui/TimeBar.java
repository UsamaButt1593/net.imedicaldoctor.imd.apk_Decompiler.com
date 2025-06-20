package androidx.media3.ui;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public interface TimeBar {

    public interface OnScrubListener {
        void A(TimeBar timeBar, long j2);

        void O(TimeBar timeBar, long j2);

        void P(TimeBar timeBar, long j2, boolean z);
    }

    void a(OnScrubListener onScrubListener);

    void b(@Nullable long[] jArr, @Nullable boolean[] zArr, int i2);

    void c(OnScrubListener onScrubListener);

    long getPreferredUpdateDelay();

    void setBufferedPosition(long j2);

    void setDuration(long j2);

    void setEnabled(boolean z);

    void setKeyCountIncrement(int i2);

    void setKeyTimeIncrement(long j2);

    void setPosition(long j2);
}
