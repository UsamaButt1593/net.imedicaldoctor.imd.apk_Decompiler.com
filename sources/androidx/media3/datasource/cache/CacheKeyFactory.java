package androidx.media3.datasource.cache;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSpec;

@UnstableApi
public interface CacheKeyFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final CacheKeyFactory f9972a = new a();

    String a(DataSpec dataSpec);
}
