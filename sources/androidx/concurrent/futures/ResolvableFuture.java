package androidx.concurrent.futures;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.common.util.concurrent.ListenableFuture;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ResolvableFuture<V> extends AbstractResolvableFuture<V> {
    private ResolvableFuture() {
    }

    public static <V> ResolvableFuture<V> w() {
        return new ResolvableFuture<>();
    }

    public boolean q(@Nullable V v) {
        return super.q(v);
    }

    public boolean r(Throwable th) {
        return super.r(th);
    }

    public boolean s(ListenableFuture<? extends V> listenableFuture) {
        return super.s(listenableFuture);
    }
}
