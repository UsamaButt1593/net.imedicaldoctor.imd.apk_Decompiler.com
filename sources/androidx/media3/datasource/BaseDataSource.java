package androidx.media3.datasource;

import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.ArrayList;
import java.util.Map;

@UnstableApi
public abstract class BaseDataSource implements DataSource {

    /* renamed from: b  reason: collision with root package name */
    private final boolean f9748b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<TransferListener> f9749c = new ArrayList<>(1);

    /* renamed from: d  reason: collision with root package name */
    private int f9750d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private DataSpec f9751e;

    protected BaseDataSource(boolean z) {
        this.f9748b = z;
    }

    @UnstableApi
    public final void e(TransferListener transferListener) {
        Assertions.g(transferListener);
        if (!this.f9749c.contains(transferListener)) {
            this.f9749c.add(transferListener);
            this.f9750d++;
        }
    }

    public /* synthetic */ Map getResponseHeaders() {
        return C0194c.a(this);
    }

    /* access modifiers changed from: protected */
    public final void t(int i2) {
        DataSpec dataSpec = (DataSpec) Util.o(this.f9751e);
        for (int i3 = 0; i3 < this.f9750d; i3++) {
            this.f9749c.get(i3).d(this, dataSpec, this.f9748b, i2);
        }
    }

    /* access modifiers changed from: protected */
    public final void u() {
        DataSpec dataSpec = (DataSpec) Util.o(this.f9751e);
        for (int i2 = 0; i2 < this.f9750d; i2++) {
            this.f9749c.get(i2).g(this, dataSpec, this.f9748b);
        }
        this.f9751e = null;
    }

    /* access modifiers changed from: protected */
    public final void v(DataSpec dataSpec) {
        for (int i2 = 0; i2 < this.f9750d; i2++) {
            this.f9749c.get(i2).h(this, dataSpec, this.f9748b);
        }
    }

    /* access modifiers changed from: protected */
    public final void w(DataSpec dataSpec) {
        this.f9751e = dataSpec;
        for (int i2 = 0; i2 < this.f9750d; i2++) {
            this.f9749c.get(i2).e(this, dataSpec, this.f9748b);
        }
    }
}
