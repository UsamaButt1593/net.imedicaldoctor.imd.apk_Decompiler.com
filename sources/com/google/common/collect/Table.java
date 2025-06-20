package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CompatibleWith;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
@DoNotMock("Use ImmutableTable, HashBasedTable, or another implementation")
public interface Table<R, C, V> {

    public interface Cell<R, C, V> {
        @ParametricNullness
        C a();

        @ParametricNullness
        R b();

        boolean equals(@CheckForNull Object obj);

        @ParametricNullness
        V getValue();

        int hashCode();
    }

    void B0(Table<? extends R, ? extends C, ? extends V> table);

    boolean D(@CompatibleWith("C") @CheckForNull Object obj);

    Map<R, V> E(@ParametricNullness C c2);

    Set<Cell<R, C, V>> I();

    boolean I0(@CompatibleWith("R") @CheckForNull Object obj, @CompatibleWith("C") @CheckForNull Object obj2);

    Map<C, Map<R, V>> J0();

    @CanIgnoreReturnValue
    @CheckForNull
    V N(@ParametricNullness R r, @ParametricNullness C c2, @ParametricNullness V v);

    Map<C, V> P0(@ParametricNullness R r);

    void clear();

    boolean containsValue(@CompatibleWith("V") @CheckForNull Object obj);

    boolean equals(@CheckForNull Object obj);

    int hashCode();

    boolean isEmpty();

    Set<C> j0();

    Map<R, Map<C, V>> m();

    boolean m0(@CompatibleWith("R") @CheckForNull Object obj);

    Set<R> n();

    @CanIgnoreReturnValue
    @CheckForNull
    V remove(@CompatibleWith("R") @CheckForNull Object obj, @CompatibleWith("C") @CheckForNull Object obj2);

    int size();

    Collection<V> values();

    @CheckForNull
    V z(@CompatibleWith("R") @CheckForNull Object obj, @CompatibleWith("C") @CheckForNull Object obj2);
}
