package androidx.media3.exoplayer.hls;

import androidx.media3.exoplayer.hls.HlsSampleStreamWrapper;

public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ HlsSampleStreamWrapper.Callback s;

    public /* synthetic */ e(HlsSampleStreamWrapper.Callback callback) {
        this.s = callback;
    }

    public final void run() {
        this.s.b();
    }
}
