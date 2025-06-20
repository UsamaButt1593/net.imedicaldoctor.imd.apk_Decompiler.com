package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public enum BoundType {
    OPEN(false),
    CLOSED(true);
    
    final boolean s;

    private BoundType(boolean z) {
        this.s = z;
    }

    static BoundType b(boolean z) {
        return z ? CLOSED : OPEN;
    }
}
