package androidx.media3.datasource;

import androidx.media3.datasource.DefaultHttpDataSource;
import com.google.common.base.Predicate;
import java.util.Map;

/* renamed from: androidx.media3.datasource.g  reason: case insensitive filesystem */
public final /* synthetic */ class C0198g implements Predicate {
    public final boolean apply(Object obj) {
        return DefaultHttpDataSource.NullFilteringHeadersMap.E1((Map.Entry) obj);
    }
}
