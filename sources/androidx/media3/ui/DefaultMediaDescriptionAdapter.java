package androidx.media3.ui;

import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.common.Player;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.ui.PlayerNotificationManager;

@UnstableApi
public final class DefaultMediaDescriptionAdapter implements PlayerNotificationManager.MediaDescriptionAdapter {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final PendingIntent f14625a;

    public DefaultMediaDescriptionAdapter(@Nullable PendingIntent pendingIntent) {
        this.f14625a = pendingIntent;
    }

    public /* synthetic */ CharSequence a(Player player) {
        return C.a(this, player);
    }

    @Nullable
    public Bitmap b(Player player, PlayerNotificationManager.BitmapCallback bitmapCallback) {
        byte[] bArr;
        if (player.R1(18) && (bArr = player.x2().c3) != null) {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
        return null;
    }

    @Nullable
    public CharSequence c(Player player) {
        if (!player.R1(18)) {
            return null;
        }
        CharSequence charSequence = player.x2().X;
        return !TextUtils.isEmpty(charSequence) ? charSequence : player.x2().Z;
    }

    @Nullable
    public PendingIntent d(Player player) {
        return this.f14625a;
    }

    public CharSequence e(Player player) {
        if (!player.R1(18)) {
            return "";
        }
        CharSequence charSequence = player.x2().X2;
        if (!TextUtils.isEmpty(charSequence)) {
            return charSequence;
        }
        CharSequence charSequence2 = player.x2().s;
        return charSequence2 != null ? charSequence2 : "";
    }
}
