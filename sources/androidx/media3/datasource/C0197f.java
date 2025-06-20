package androidx.media3.datasource;

import android.net.Uri;
import java.util.concurrent.Callable;

/* renamed from: androidx.media3.datasource.f  reason: case insensitive filesystem */
public final /* synthetic */ class C0197f implements Callable {
    public final /* synthetic */ Uri X;
    public final /* synthetic */ DataSourceBitmapLoader s;

    public /* synthetic */ C0197f(DataSourceBitmapLoader dataSourceBitmapLoader, Uri uri) {
        this.s = dataSourceBitmapLoader;
        this.X = uri;
    }

    public final Object call() {
        return this.s.j(this.X);
    }
}
