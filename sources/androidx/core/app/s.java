package androidx.core.app;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.PendingIntentCompat;

public final /* synthetic */ class s implements PendingIntent.OnFinished {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PendingIntentCompat.GatedCallback f5625a;

    public /* synthetic */ s(PendingIntentCompat.GatedCallback gatedCallback) {
        this.f5625a = gatedCallback;
    }

    public final void onSendFinished(PendingIntent pendingIntent, Intent intent, int i2, String str, Bundle bundle) {
        this.f5625a.e(pendingIntent, intent, i2, str, bundle);
    }
}
