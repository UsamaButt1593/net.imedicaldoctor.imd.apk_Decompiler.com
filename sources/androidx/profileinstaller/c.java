package androidx.profileinstaller;

import androidx.profileinstaller.ProfileInstaller;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ int X;
    public final /* synthetic */ Object Y;
    public final /* synthetic */ ProfileInstaller.DiagnosticsCallback s;

    public /* synthetic */ c(ProfileInstaller.DiagnosticsCallback diagnosticsCallback, int i2, Object obj) {
        this.s = diagnosticsCallback;
        this.X = i2;
        this.Y = obj;
    }

    public final void run() {
        this.s.b(this.X, this.Y);
    }
}
