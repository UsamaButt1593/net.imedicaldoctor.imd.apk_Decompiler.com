package androidx.media3.common.util;

import android.os.Handler;
import android.os.Message;

/* renamed from: androidx.media3.common.util.b  reason: case insensitive filesystem */
public final /* synthetic */ class C0178b implements Handler.Callback {
    public final /* synthetic */ ListenerSet s;

    public /* synthetic */ C0178b(ListenerSet listenerSet) {
        this.s = listenerSet;
    }

    public final boolean handleMessage(Message message) {
        return this.s.h(message);
    }
}
