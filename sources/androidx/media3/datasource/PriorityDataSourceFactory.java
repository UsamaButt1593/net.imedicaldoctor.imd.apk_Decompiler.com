package androidx.media3.datasource;

import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;

@UnstableApi
@Deprecated
public final class PriorityDataSourceFactory implements DataSource.Factory {

    /* renamed from: a  reason: collision with root package name */
    private final DataSource.Factory f9884a;

    /* renamed from: b  reason: collision with root package name */
    private final PriorityTaskManager f9885b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9886c;

    public PriorityDataSourceFactory(DataSource.Factory factory, PriorityTaskManager priorityTaskManager, int i2) {
        this.f9884a = factory;
        this.f9885b = priorityTaskManager;
        this.f9886c = i2;
    }

    /* renamed from: c */
    public PriorityDataSource a() {
        return new PriorityDataSource(this.f9884a.a(), this.f9885b, this.f9886c);
    }
}
