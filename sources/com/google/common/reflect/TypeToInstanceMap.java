package com.google.common.reflect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Map;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@DoNotMock("Use ImmutableTypeToInstanceMap or MutableTypeToInstanceMap")
public interface TypeToInstanceMap<B> extends Map<TypeToken<? extends B>, B> {
    @CanIgnoreReturnValue
    @CheckForNull
    <T extends B> T G0(TypeToken<T> typeToken, @ParametricNullness T t);

    @CheckForNull
    <T extends B> T L(TypeToken<T> typeToken);

    @CanIgnoreReturnValue
    @CheckForNull
    <T extends B> T q(Class<T> cls, @ParametricNullness T t);

    @CheckForNull
    <T extends B> T r(Class<T> cls);
}
