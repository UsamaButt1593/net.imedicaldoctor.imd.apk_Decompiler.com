package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Map;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
@DoNotMock("Use Maps.difference")
public interface MapDifference<K, V> {

    @DoNotMock("Use Maps.difference")
    public interface ValueDifference<V> {
        @ParametricNullness
        V a();

        @ParametricNullness
        V b();

        boolean equals(@CheckForNull Object obj);

        int hashCode();
    }

    Map<K, V> a();

    Map<K, ValueDifference<V>> b();

    Map<K, V> c();

    Map<K, V> d();

    boolean e();

    boolean equals(@CheckForNull Object obj);

    int hashCode();
}
