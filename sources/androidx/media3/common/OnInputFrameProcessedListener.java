package androidx.media3.common;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
public interface OnInputFrameProcessedListener {
    void a(int i2, long j2) throws VideoFrameProcessingException;
}
