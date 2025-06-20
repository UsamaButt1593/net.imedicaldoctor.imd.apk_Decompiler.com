package androidx.media3.exoplayer.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSourceInputStream;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.StatsDataSource;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.upstream.Loader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@UnstableApi
public final class ParsingLoadable<T> implements Loader.Loadable {

    /* renamed from: a  reason: collision with root package name */
    public final long f12583a;

    /* renamed from: b  reason: collision with root package name */
    public final DataSpec f12584b;

    /* renamed from: c  reason: collision with root package name */
    public final int f12585c;

    /* renamed from: d  reason: collision with root package name */
    private final StatsDataSource f12586d;

    /* renamed from: e  reason: collision with root package name */
    private final Parser<? extends T> f12587e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private volatile T f12588f;

    public interface Parser<T> {
        T a(Uri uri, InputStream inputStream) throws IOException;
    }

    public ParsingLoadable(DataSource dataSource, Uri uri, int i2, Parser<? extends T> parser) {
        this(dataSource, new DataSpec.Builder().j(uri).c(1).a(), i2, parser);
    }

    public static <T> T g(DataSource dataSource, Parser<? extends T> parser, Uri uri, int i2) throws IOException {
        ParsingLoadable parsingLoadable = new ParsingLoadable(dataSource, uri, i2, parser);
        parsingLoadable.a();
        return Assertions.g(parsingLoadable.e());
    }

    public static <T> T h(DataSource dataSource, Parser<? extends T> parser, DataSpec dataSpec, int i2) throws IOException {
        ParsingLoadable parsingLoadable = new ParsingLoadable(dataSource, dataSpec, i2, parser);
        parsingLoadable.a();
        return Assertions.g(parsingLoadable.e());
    }

    public final void a() throws IOException {
        this.f12586d.w();
        DataSourceInputStream dataSourceInputStream = new DataSourceInputStream(this.f12586d, this.f12584b);
        try {
            dataSourceInputStream.d();
            this.f12588f = this.f12587e.a((Uri) Assertions.g(this.f12586d.c()), dataSourceInputStream);
        } finally {
            Util.t(dataSourceInputStream);
        }
    }

    public long b() {
        return this.f12586d.t();
    }

    public final void c() {
    }

    public Map<String, List<String>> d() {
        return this.f12586d.v();
    }

    @Nullable
    public final T e() {
        return this.f12588f;
    }

    public Uri f() {
        return this.f12586d.u();
    }

    public ParsingLoadable(DataSource dataSource, DataSpec dataSpec, int i2, Parser<? extends T> parser) {
        this.f12586d = new StatsDataSource(dataSource);
        this.f12584b = dataSpec;
        this.f12585c = i2;
        this.f12587e = parser;
        this.f12583a = LoadEventInfo.a();
    }
}
