package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Map;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
@DoNotMock("Use ImmutableClassToInstanceMap or MutableClassToInstanceMap")
public interface ClassToInstanceMap<B> extends Map<Class<? extends B>, B> {
    @CanIgnoreReturnValue
    @CheckForNull
    <T extends B> T q(Class<T> cls, @ParametricNullness T t);

    @CheckForNull
    <T extends B> T r(Class<T> cls);
}
