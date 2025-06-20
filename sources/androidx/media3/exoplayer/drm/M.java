package androidx.media3.exoplayer.drm;

import androidx.media3.common.Format;
import com.google.common.util.concurrent.SettableFuture;

public final /* synthetic */ class M implements Runnable {
    public final /* synthetic */ int X;
    public final /* synthetic */ Format X2;
    public final /* synthetic */ byte[] Y;
    public final /* synthetic */ SettableFuture Z;
    public final /* synthetic */ OfflineLicenseHelper s;

    public /* synthetic */ M(OfflineLicenseHelper offlineLicenseHelper, int i2, byte[] bArr, SettableFuture settableFuture, Format format) {
        this.s = offlineLicenseHelper;
        this.X = i2;
        this.Y = bArr;
        this.Z = settableFuture;
        this.X2 = format;
    }

    public final void run() {
        this.s.k(this.X, this.Y, this.Z, this.X2);
    }
}
