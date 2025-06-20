package androidx.media3.datasource;

import androidx.media3.datasource.DefaultHttpDataSource;
import com.google.common.base.Predicate;

/* renamed from: androidx.media3.datasource.h  reason: case insensitive filesystem */
public final /* synthetic */ class C0199h implements Predicate {
    public final boolean apply(Object obj) {
        return DefaultHttpDataSource.NullFilteringHeadersMap.G1((String) obj);
    }
}
