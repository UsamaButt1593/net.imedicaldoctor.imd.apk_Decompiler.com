package androidx.media3.exoplayer.source;

import androidx.media3.datasource.DataSource;
import com.google.common.base.Supplier;

/* renamed from: androidx.media3.exoplayer.source.f  reason: case insensitive filesystem */
public final /* synthetic */ class C0340f implements Supplier {
    public final /* synthetic */ DataSource.Factory X;
    public final /* synthetic */ Class s;

    public /* synthetic */ C0340f(Class cls, DataSource.Factory factory) {
        this.s = cls;
        this.X = factory;
    }

    public final Object get() {
        return DefaultMediaSourceFactory.q(this.s, this.X);
    }
}
