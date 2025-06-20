package net.imedicaldoctor.imd;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import androidx.media3.common.Player;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.ui.PlayerNotificationManager;

@UnstableApi
public class PlayerService extends Service {
    public static final String X = "imd_channel";
    public static final int Y = 2;
    private PlayerNotificationManager s;

    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onDestroy() {
        PlayerNotificationManager playerNotificationManager = this.s;
        if (playerNotificationManager != null) {
            playerNotificationManager.z((Player) null);
            this.s = null;
        }
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        PlayerNotificationManager playerNotificationManager = this.s;
        if (playerNotificationManager != null) {
            return 1;
        }
        playerNotificationManager.z(net.imedicaldoctor.imd.Fragments.CMEInfo.Player.I3);
        return 1;
    }
}
