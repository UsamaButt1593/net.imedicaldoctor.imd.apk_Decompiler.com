package androidx.media3.datasource.cache;

import androidx.media3.datasource.DataSpec;

public final /* synthetic */ class b {
    static {
        CacheKeyFactory cacheKeyFactory = CacheKeyFactory.f9972a;
    }

    public static /* synthetic */ String a(DataSpec dataSpec) {
        String str = dataSpec.f9787i;
        if (str != null) {
            return str;
        }
        return dataSpec.f9779a.toString();
    }
}
