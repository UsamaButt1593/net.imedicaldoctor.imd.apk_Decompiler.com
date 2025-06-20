package androidx.media3.exoplayer.source;

import androidx.media3.datasource.DataSource;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import com.google.common.base.Supplier;

/* renamed from: androidx.media3.exoplayer.source.i  reason: case insensitive filesystem */
public final /* synthetic */ class C0343i implements Supplier {
    public final /* synthetic */ DataSource.Factory X;
    public final /* synthetic */ DefaultMediaSourceFactory.DelegateFactoryLoader s;

    public /* synthetic */ C0343i(DefaultMediaSourceFactory.DelegateFactoryLoader delegateFactoryLoader, DataSource.Factory factory) {
        this.s = delegateFactoryLoader;
        this.X = factory;
    }

    public final Object get() {
        return this.s.m(this.X);
    }
}
