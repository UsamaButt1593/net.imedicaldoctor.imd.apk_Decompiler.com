package androidx.media3.exoplayer.source;

import androidx.media3.datasource.DataSource;
import com.google.common.base.Supplier;

/* renamed from: androidx.media3.exoplayer.source.g  reason: case insensitive filesystem */
public final /* synthetic */ class C0341g implements Supplier {
    public final /* synthetic */ DataSource.Factory X;
    public final /* synthetic */ Class s;

    public /* synthetic */ C0341g(Class cls, DataSource.Factory factory) {
        this.s = cls;
        this.X = factory;
    }

    public final Object get() {
        return DefaultMediaSourceFactory.q(this.s, this.X);
    }
}
