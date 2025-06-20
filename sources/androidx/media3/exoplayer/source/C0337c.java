package androidx.media3.exoplayer.source;

import android.os.Handler;
import android.os.Message;

/* renamed from: androidx.media3.exoplayer.source.c  reason: case insensitive filesystem */
public final /* synthetic */ class C0337c implements Handler.Callback {
    public final /* synthetic */ ConcatenatingMediaSource2 s;

    public /* synthetic */ C0337c(ConcatenatingMediaSource2 concatenatingMediaSource2) {
        this.s = concatenatingMediaSource2;
    }

    public final boolean handleMessage(Message message) {
        return this.s.X0(message);
    }
}
