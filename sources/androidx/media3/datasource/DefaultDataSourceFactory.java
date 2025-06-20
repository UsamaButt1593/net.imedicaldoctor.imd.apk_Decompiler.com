package androidx.media3.datasource;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DefaultHttpDataSource;

@UnstableApi
@Deprecated
public final class DefaultDataSourceFactory implements DataSource.Factory {

    /* renamed from: a  reason: collision with root package name */
    private final Context f9816a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final TransferListener f9817b;

    /* renamed from: c  reason: collision with root package name */
    private final DataSource.Factory f9818c;

    public DefaultDataSourceFactory(Context context) {
        this(context, (String) null, (TransferListener) null);
    }

    /* renamed from: c */
    public DefaultDataSource a() {
        DefaultDataSource defaultDataSource = new DefaultDataSource(this.f9816a, this.f9818c.a());
        TransferListener transferListener = this.f9817b;
        if (transferListener != null) {
            defaultDataSource.e(transferListener);
        }
        return defaultDataSource;
    }

    public DefaultDataSourceFactory(Context context, DataSource.Factory factory) {
        this(context, (TransferListener) null, factory);
    }

    public DefaultDataSourceFactory(Context context, @Nullable TransferListener transferListener, DataSource.Factory factory) {
        this.f9816a = context.getApplicationContext();
        this.f9817b = transferListener;
        this.f9818c = factory;
    }

    public DefaultDataSourceFactory(Context context, @Nullable String str) {
        this(context, str, (TransferListener) null);
    }

    public DefaultDataSourceFactory(Context context, @Nullable String str, @Nullable TransferListener transferListener) {
        this(context, transferListener, (DataSource.Factory) new DefaultHttpDataSource.Factory().k(str));
    }
}
