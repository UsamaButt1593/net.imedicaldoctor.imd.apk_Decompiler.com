package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

final class zzr extends zzs {
    zzr(int i2, int i3, Bundle bundle) {
        super(i2, i3, bundle);
    }

    /* access modifiers changed from: package-private */
    public final void a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            d((Object) null);
        } else {
            c(new zzt(4, "Invalid response to one way request", (Throwable) null));
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return true;
    }
}
