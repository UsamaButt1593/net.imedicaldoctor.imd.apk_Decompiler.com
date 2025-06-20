package androidx.media3.exoplayer.source;

import android.os.Handler;
import android.os.Message;

/* renamed from: androidx.media3.exoplayer.source.b  reason: case insensitive filesystem */
public final /* synthetic */ class C0336b implements Handler.Callback {
    public final /* synthetic */ ConcatenatingMediaSource s;

    public /* synthetic */ C0336b(ConcatenatingMediaSource concatenatingMediaSource) {
        this.s = concatenatingMediaSource;
    }

    public final boolean handleMessage(Message message) {
        return this.s.l1(message);
    }
}
