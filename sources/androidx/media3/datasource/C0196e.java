package androidx.media3.datasource;

import java.util.concurrent.Callable;

/* renamed from: androidx.media3.datasource.e  reason: case insensitive filesystem */
public final /* synthetic */ class C0196e implements Callable {
    public final /* synthetic */ byte[] X;
    public final /* synthetic */ DataSourceBitmapLoader s;

    public /* synthetic */ C0196e(DataSourceBitmapLoader dataSourceBitmapLoader, byte[] bArr) {
        this.s = dataSourceBitmapLoader;
        this.X = bArr;
    }

    public final Object call() {
        return this.s.i(this.X);
    }
}
