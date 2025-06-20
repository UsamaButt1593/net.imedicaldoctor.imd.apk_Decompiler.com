package androidx.profileinstaller;

import android.content.Context;

public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ Context s;

    public /* synthetic */ e(Context context) {
        this.s = context;
    }

    public final void run() {
        ProfileInstallerInitializer.k(this.s);
    }
}
