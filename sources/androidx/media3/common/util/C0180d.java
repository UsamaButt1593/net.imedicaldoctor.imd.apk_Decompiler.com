package androidx.media3.common.util;

import androidx.media3.common.util.NetworkTypeObserver;

/* renamed from: androidx.media3.common.util.d  reason: case insensitive filesystem */
public final /* synthetic */ class C0180d implements Runnable {
    public final /* synthetic */ NetworkTypeObserver.Listener X;
    public final /* synthetic */ NetworkTypeObserver s;

    public /* synthetic */ C0180d(NetworkTypeObserver networkTypeObserver, NetworkTypeObserver.Listener listener) {
        this.s = networkTypeObserver;
        this.X = listener;
    }

    public final void run() {
        this.s.h(this.X);
    }
}
