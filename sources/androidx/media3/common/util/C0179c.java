package androidx.media3.common.util;

import androidx.media3.common.util.ListenerSet;
import java.util.concurrent.CopyOnWriteArraySet;

/* renamed from: androidx.media3.common.util.c  reason: case insensitive filesystem */
public final /* synthetic */ class C0179c implements Runnable {
    public final /* synthetic */ int X;
    public final /* synthetic */ ListenerSet.Event Y;
    public final /* synthetic */ CopyOnWriteArraySet s;

    public /* synthetic */ C0179c(CopyOnWriteArraySet copyOnWriteArraySet, int i2, ListenerSet.Event event) {
        this.s = copyOnWriteArraySet;
        this.X = i2;
        this.Y = event;
    }

    public final void run() {
        ListenerSet.i(this.s, this.X, this.Y);
    }
}
