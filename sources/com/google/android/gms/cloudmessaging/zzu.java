package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

final class zzu extends zzs {
    zzu(int i2, int i3, Bundle bundle) {
        super(i2, i3, bundle);
    }

    /* access modifiers changed from: package-private */
    public final void a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        d(bundle2);
    }

    /* access modifiers changed from: package-private */
    public final boolean b() {
        return false;
    }
}
