package androidx.media3.datasource;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executors;

/* renamed from: androidx.media3.datasource.d  reason: case insensitive filesystem */
public final /* synthetic */ class C0195d implements Supplier {
    public final Object get() {
        return MoreExecutors.j(Executors.newSingleThreadExecutor());
    }
}
