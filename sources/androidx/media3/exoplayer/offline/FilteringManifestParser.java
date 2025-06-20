package androidx.media3.exoplayer.offline;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.offline.FilterableManifest;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@UnstableApi
public final class FilteringManifestParser<T extends FilterableManifest<T>> implements ParsingLoadable.Parser<T> {

    /* renamed from: a  reason: collision with root package name */
    private final ParsingLoadable.Parser<? extends T> f11840a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final List<StreamKey> f11841b;

    public FilteringManifestParser(ParsingLoadable.Parser<? extends T> parser, @Nullable List<StreamKey> list) {
        this.f11840a = parser;
        this.f11841b = list;
    }

    /* renamed from: b */
    public T a(Uri uri, InputStream inputStream) throws IOException {
        T t = (FilterableManifest) this.f11840a.a(uri, inputStream);
        List<StreamKey> list = this.f11841b;
        return (list == null || list.isEmpty()) ? t : (FilterableManifest) t.a(this.f11841b);
    }
}
