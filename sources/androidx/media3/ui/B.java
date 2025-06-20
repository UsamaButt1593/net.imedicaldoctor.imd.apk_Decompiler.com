package androidx.media3.ui;

import android.os.Handler;
import android.os.Message;

public final /* synthetic */ class B implements Handler.Callback {
    public final /* synthetic */ PlayerNotificationManager s;

    public /* synthetic */ B(PlayerNotificationManager playerNotificationManager) {
        this.s = playerNotificationManager;
    }

    public final boolean handleMessage(Message message) {
        return this.s.p(message);
    }
}
