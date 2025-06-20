package androidx.profileinstaller;

import android.content.Context;

public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ Context X;
    public final /* synthetic */ ProfileInstallerInitializer s;

    public /* synthetic */ f(ProfileInstallerInitializer profileInstallerInitializer, Context context) {
        this.s = profileInstallerInitializer;
        this.X = context;
    }

    public final void run() {
        this.s.h(this.X);
    }
}
