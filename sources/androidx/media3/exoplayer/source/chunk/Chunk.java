package androidx.media3.exoplayer.source.chunk;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.upstream.Loader;
import java.util.List;
import java.util.Map;

@UnstableApi
public abstract class Chunk implements Loader.Loadable {

    /* renamed from: a  reason: collision with root package name */
    public final long f12278a = LoadEventInfo.a();

    /* renamed from: b  reason: collision with root package name */
    public final DataSpec f12279b;

    /* renamed from: c  reason: collision with root package name */
    public final int f12280c;

    /* renamed from: d  reason: collision with root package name */
    public final Format f12281d;

    /* renamed from: e  reason: collision with root package name */
    public final int f12282e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final Object f12283f;

    /* renamed from: g  reason: collision with root package name */
    public final long f12284g;

    /* renamed from: h  reason: collision with root package name */
    public final long f12285h;

    /* renamed from: i  reason: collision with root package name */
    protected final StatsDataSource f12286i;

    public Chunk(DataSource dataSource, DataSpec dataSpec, int i2, Format format, int i3, @Nullable Object obj, long j2, long j3) {
        this.f12286i = new StatsDataSource(dataSource);
        this.f12279b = (DataSpec) Assertions.g(dataSpec);
        this.f12280c = i2;
        this.f12281d = format;
        this.f12282e = i3;
        this.f12283f = obj;
        this.f12284g = j2;
        this.f12285h = j3;
    }

    public final long b() {
        return this.f12286i.t();
    }

    public final long d() {
        return this.f12285h - this.f12284g;
    }

    public final Map<String, List<String>> e() {
        return this.f12286i.v();
    }

    public final Uri f() {
        return this.f12286i.u();
    }
}
