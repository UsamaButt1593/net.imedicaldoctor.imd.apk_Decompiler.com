package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
final class NullnessCasts {
    private NullnessCasts() {
    }

    @ParametricNullness
    static <T> T a(@CheckForNull T t) {
        return t;
    }

    @ParametricNullness
    static <T> T b() {
        return null;
    }
}
